package com.workorder.app.workorderapplication.adapter;

import android.content.Context;
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

import com.workorder.app.R;
import com.workorder.app.workorderapplication.activity.WorkerWOUpdate;
import com.workorder.app.workorderapplication.filter.WorkerFilter;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderResponseModel;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WorkerListAdapter extends RecyclerView.Adapter<WorkerListAdapter.MyViewHolder> implements Filterable {

    Context mContext;
    ClickListener mClickListner;



    public List<WorkOrderResponseModel> myTaskList,filterList;
    WorkerFilter filter;
    String rolename,WorkOrderId,companyid;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    public WorkerListAdapter(Context context, List<WorkOrderResponseModel> list) {
        this.myTaskList = list;
        this.filterList=myTaskList;
        this.mContext = context;
    }

    public void setClicklistener(ClickListener clickListner) {
        this.mClickListner = clickListner;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.workerlist, parent, false);

        return new MyViewHolder(mContext,itemView, viewType,mClickListner);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){

        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(mContext);

        if (myTaskList.size() != 0){

            if(preferenceManagerWorkOrder.getKey_User_Role().equals("Worker")){

                holder.workerUpdatebnt.setVisibility(View.VISIBLE);
            }
            final WorkOrderResponseModel item = myTaskList.get(position);
            if(item.getWorkOrderId()!=null){
                holder.wono.setText(item.getWorkOrderNumber());
                holder.orderDesc.setText(item.getDescription());
                holder.Assestlocation.setText(item.getLocationName());
                holder.assestId.setText(item.getAssetId());
                holder.priority.setText(item.getPriority());
                holder.orderStatus.setText(item.getStatus());
                String date=item.getDueDate();
                String[]dat=date.split("T");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                Date date1=null;
                try {
                    date1 = simpleDateFormat.parse(dat[0]);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat newformat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                String dateInReqFormat = newformat.format(date1);

                holder.dueDate.setText(dateInReqFormat);

                holder.clientName.setText(item.getClientName());

                holder.workerUpdatebnt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String WorkOrderId=item.getWorkOrderId();
                        Bundle bundle=new Bundle();
                        bundle.putString("workOrderId",WorkOrderId);
                        Intent intent=new Intent(v.getContext(),WorkerWOUpdate.class);
                        intent.putExtras(bundle);
//
                        v.getContext().startActivity(intent);


                    }
                });
            }
        }

    }
    @Override
    public int getItemCount() {
        return myTaskList.size();
    }

    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new WorkerFilter(this,filterList);
        }
        return filter;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView wono,clientName,dueDate,orderStatus,priority,assestId,Assestlocation,orderDesc;
        ImageButton workerUpdatebnt;
       Integer position;
        Context context;
        ClickListener clickListener;

        public MyViewHolder(Context context, final View itemView, Integer viewType, final ClickListener clickListener){

            super(itemView);
            position = viewType;
            this.context=context;
            this.clickListener=clickListener;
            preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(mContext);
            companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
            rolename= preferenceManagerWorkOrder.getKey_User_Name();

            wono = itemView.findViewById(R.id.wono);
            clientName = itemView.findViewById(R.id.clientName);
            dueDate= itemView.findViewById(R.id.dueDate);
            orderStatus = itemView.findViewById(R.id.orderStatus);
            priority = itemView.findViewById(R.id.priority);
            assestId = itemView.findViewById(R.id.assestId);
            Assestlocation = itemView.findViewById(R.id.Assestlocation);
            orderDesc = itemView.findViewById(R.id.orderDesc);
            workerUpdatebnt = itemView.findViewById(R.id.workerUpdatebtn);
        }


    }


}
