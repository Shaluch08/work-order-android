package com.workorder.app.workorderapplication.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.activity.History;
import com.workorder.app.workorderapplication.activity.SearchAsset;
import com.workorder.app.workorderapplication.activity.UpdateAsset;
import com.workorder.app.workorderapplication.filter.AssetFilter;
import com.workorder.app.workorderapplication.model.assetModel.*;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bharat Tripathi on 03-May-18.
 */

public class ListAssetAdapter extends RecyclerView.Adapter<ListAssetAdapter.MyViewHolder> implements Filterable {
    Context mContext;
    public List<AssetResponseModel> myTaskList,filterList;
    AssetFilter filter;
     ClickListener mClickListner;
    String rolename,AssetId,companyid;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    public ListAssetAdapter(Context mContext, List<AssetResponseModel> myTaskList) {
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
                .inflate(R.layout.list_asset, parent, false);
        return new ListAssetAdapter.MyViewHolder(mContext,itemView, viewType,mClickListner);
    }
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new AssetFilter(this,filterList);
        }
        return filter;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(myTaskList.size()!=0)
        {
              final AssetResponseModel item=myTaskList.get(position);
            holder.assetName.setText(item.getAssetName());
            holder.assetId.setText(String.valueOf(item.getId()));
            holder.clientName.setText(item.getClientName());
            holder.assetStatus.setText(String.valueOf(item.getStatus()));
            holder.assetType.setText(String.valueOf(item.getAssetType()));
            holder.supplierName.setText(item.getSupplierName());
            holder.orderNumber.setText(item.getOrderNumber());

            Log.d("AssetId Name",AssetId+" "+item.getAssetName());

            holder.history.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String AssetId=item.getId();
                    Bundle bundle=new Bundle();
                    bundle.putString("AssetId",AssetId);
                    Intent i=new Intent(v.getContext(),History.class);
                    i.putExtras(bundle);
                    v.getContext().startActivity(i);
                }
            });
            holder.updateasset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String AssetId=item.getId();
                    Bundle bundle=new Bundle();
                    bundle.putString("AssetId",AssetId);

                    Intent intent=new Intent(v.getContext(),UpdateAsset.class);
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                }
            });
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
                             AssetId=item.getId();
                            deleteAsset();
                            v.getContext().startActivity(new Intent(v.getContext(),SearchAsset.class));

                            //builder.finish();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
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
        }
    }
    private void deleteAsset(){
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<String> deleteWorkOrder= apiServicesWorkOrder.delete("application/json","api/assets/DeleteAssetDetails?companyid="+companyid+"&AssetId="+AssetId);
            deleteWorkOrder.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.body()!=null)
                    {
                        String result=response.body();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
    }
    @Override
    public int getItemCount() {
        return  myTaskList.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView assetName,assetId,clientName,assetStatus,assetType,supplierName,orderNumber;
        Integer position;
        Context context;
        ClickListener clickListener;
        public ImageButton updateasset,deleteasset,history;
        public MyViewHolder(Context context, View itemView, Integer viewType, final ClickListener clickListener) {
            super(itemView);
            position = viewType;
            this.context = context;
            assetName=itemView.findViewById(R.id.asset_Name);
            assetId=itemView.findViewById(R.id.asset_id);
            clientName=itemView.findViewById(R.id.client_Name);
            assetStatus=itemView.findViewById(R.id.asset_status);
            supplierName=itemView.findViewById(R.id.supplier_name);
            assetType=itemView.findViewById(R.id.asset_type);
            orderNumber=itemView.findViewById(R.id.order_number);
            updateasset=itemView.findViewById(R.id.updateAsset);
            deleteasset=itemView.findViewById(R.id.deleteAsset);
            history=itemView.findViewById(R.id.histroyWorkOrder);

        }


    }
}
