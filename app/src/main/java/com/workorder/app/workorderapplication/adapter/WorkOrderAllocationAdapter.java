package com.workorder.app.workorderapplication.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import com.workorder.app.workorderapplication.activity.UpdateWorkOrderAllocate;
import com.workorder.app.workorderapplication.activity.WorkOrderAllocationList;
import com.workorder.app.workorderapplication.filter.WorkOrderAllocationFilter;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderAllocationListResponse;
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

public class WorkOrderAllocationAdapter extends RecyclerView.Adapter<WorkOrderAllocationAdapter.MyViewHolder> implements Filterable {
    Context mContext;
    ClickListener mClickListner;
    WorkOrderAllocationFilter filter;
    public List<WorkOrderAllocationListResponse> workOrderAllocationListResponseList,filterList;
    String personId,Id;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    public WorkOrderAllocationAdapter(Context context, List<WorkOrderAllocationListResponse> workOrderAllocationListResponseList) {
        this.workOrderAllocationListResponseList = workOrderAllocationListResponseList;
        this.filterList=workOrderAllocationListResponseList;
        this.mContext=context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_allocation, parent, false);
        return new MyViewHolder(mContext,itemView, viewType,mClickListner);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(mContext);
        if (workOrderAllocationListResponseList.size()!=0){
           final WorkOrderAllocationListResponse response=workOrderAllocationListResponseList.get(position);
            if(response.getPersonId()!=null) {
                holder.workerName.setText(response.getPerson().getFullName());
                holder.tradeCategory.setText(response.getTradeCategories().getTradeName());
                holder.workingHrs.setText(response.getWorkingHours());
                holder.totalHrs.setText(response.getTotalHours());
                holder.swps.setText(response.getSwms());
            
                holder.deletewoAlloc.setVisibility(View.INVISIBLE);
                holder.deletewoAlloc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure to delete this item?");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Id= String.valueOf(response.getId());
                                        deleteWorkOrderAllocation();
                                        v.getContext().startActivity(new Intent(v.getContext(),WorkOrderAllocationList.class));


                                    }
                                });builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        dialog.dismiss();

                    }
                });



                holder.updatewo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      String Id= String.valueOf(response.getId());
                       String WorkOrderId= String.valueOf(response.getWorkOrderId());
                        Bundle bundle=new Bundle();
                        bundle.putString("WorkOrderId",WorkOrderId);
                        bundle.putString("Id",Id);
                        Intent intent=new Intent(v.getContext(),UpdateWorkOrderAllocate.class);
                        intent.putExtras(bundle);
                        v.getContext().startActivity(intent);
                    }
                });
            }
        }
    }
    private void deleteWorkOrderAllocation()
    {
        personId= preferenceManagerWorkOrder.getKey_Person_Company_Id();
                    ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
                    final Call<String> deleteWorkOrderAlc= apiServicesWorkOrder.deleteWorkAllocation("application/json","api/workerperson/DeleteAllocation?id="+Id+"&personid="+personId);
        deleteWorkOrderAlc.enqueue(new Callback<String>() {
                                                @Override
                                                public void onResponse(Call<String> call, Response<String> response) {
                                                    if (response.body() != null) {
                                                        String result = response.body();
                                                        Toast.makeText(mContext, "" + result, Toast.LENGTH_SHORT).show();
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
        return workOrderAllocationListResponseList.size();
    }

    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new WorkOrderAllocationFilter(this,filterList);
        }
        return filter;
    }
    public void setClicklistener(ClickListener clickListner) {
        this.mClickListner = clickListner;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        ClickListener clickListener;
        Context context;
        Integer position;
        public ImageButton updatewo,deletewoAlloc;
        TextView workerName,tradeCategory,workingHrs,totalHrs,swps;
        public MyViewHolder(Context context, final View itemView, Integer viewType, final ClickListener clickListener) {
            super(itemView);
            position = viewType;
            this.context=context;
            this.clickListener=clickListener;
            workerName=itemView.findViewById(R.id.work_name);
            tradeCategory=itemView.findViewById(R.id.trade_cat);
            workingHrs=itemView.findViewById(R.id.workingsHrs);
            totalHrs=itemView.findViewById(R.id.total_hrs);
            deletewoAlloc=itemView.findViewById(R.id.deleteWorkOrderAllocation);
            updatewo=itemView.findViewById(R.id.updateworkOrderAllocation);
            swps=itemView.findViewById(R.id.swms);

        }

    }
}
