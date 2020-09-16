package com.workorder.app.workorderapplication.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.activity.UpdateMaterialUsed;
import com.workorder.app.workorderapplication.filter.MaterialUsedFilter;
import com.workorder.app.workorderapplication.model.materialModel.MaterialEditList;
import com.workorder.app.workorderapplication.model.materialModel.MaterialList;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bharat Tripathi on 13-May-18.
 */

public class MaterialUsedAdapter extends RecyclerView.Adapter<MaterialUsedAdapter.MyViewHolder> implements Filterable {
    Context mContext;
    public List<MaterialList> myTaskList,filterList;
    MaterialUsedFilter filter;
    ClickListener mClickListner;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String rolename,AssetId,companyid;
    public MaterialUsedAdapter(Context mContext, List<MaterialList> myTaskList) {
        this.mContext = mContext;
        this.myTaskList = myTaskList;
        this.filterList=myTaskList;
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(mContext);
    }
    public void setClicklistener(ClickListener clickListner) {
        this.mClickListner = clickListner;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_material_used, parent, false);
        return new MaterialUsedAdapter.MyViewHolder(mContext,itemView, viewType,mClickListner);
    }
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
         filter=new MaterialUsedFilter(this,filterList);
        }
        return filter;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(myTaskList.size()!=0)
        {
           final MaterialList item=myTaskList.get(position);
            holder.material.setText(item.getMaterialUsed());
            holder.quantity.setText(String.valueOf(item.getMaterialQuntity()));
            holder.cost.setText(String.valueOf(item.getMaterialCost()));
            holder.deleteasset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("Delete?");
                    //Setting message manually and performing action on button click
                    builder.setMessage("Are you sure to delete this item?");
                    //This will not allow to close dialogbox until user selects an option
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(mContext, "Delete", Toast.LENGTH_SHORT).show();
                            int ID=item.getId();
                            MaterialEditList request=new MaterialEditList();
                            request.setId(ID);
                            request.setUpdatedBy(preferenceManagerWorkOrder.getKey_Person_Company_Id());
                                ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
                                final Call<String> deleteWorkOrder= apiServicesWorkOrder.deletematerial("application/json","api/WorkMaterial/DeleteMaterial?id="+ID+"&personid="+ preferenceManagerWorkOrder.getKey_Person_Company_Id());
                                deleteWorkOrder.enqueue(new Callback<String>() {
                                    @Override
                                    public void onResponse(Call<String> call, Response<String> response) {
                                        if(response.body()!=null)
                                        {
                                            String result=response.body();
                                            Toast.makeText(mContext, ""+result, Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<String> call, Throwable t) {
                                        t.printStackTrace();
                                        System.out.println(t.getMessage() + t.getLocalizedMessage());
                                    }
                                });

                            v.getContext().startActivity(new Intent(v.getContext(),UpdateMaterialUsed.class));
                            //builder.finish();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            Toast.makeText(mContext, "Cancel", Toast.LENGTH_SHORT).show();
                            dialog.cancel();
                        }
                    });

                    //Creating dialog box
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    //alert.setTitle("AlertDialogExample");
                    alert.show();

                }
            });
            holder.updateasset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 int   id=item.getId();
                    Bundle bundle=new Bundle();
                   // bundle.putString("WorkOrderId",WorkOrderId);
                    bundle.putInt("id",id);
                    Intent intent=new Intent(v.getContext(),UpdateMaterialUsed.class);
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return  myTaskList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView material,quantity,cost;
        Integer position;
        Context context;
        ClickListener clickListener;
        public ImageButton updateasset,deleteasset;
        public MyViewHolder(Context context, View itemView, Integer viewType, final ClickListener clickListener) {
            super(itemView);
            position = viewType;
            this.context = context;
            material=itemView.findViewById(R.id.material);
            quantity=itemView.findViewById(R.id.quantity);
            cost=itemView.findViewById(R.id.cost);
            updateasset=itemView.findViewById(R.id.updateworkOrder);
            deleteasset=itemView.findViewById(R.id.deleteWorkOrder);
        }
    }
}
