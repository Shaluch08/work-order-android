package com.workorder.app.workorderapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.filter.ClientListFilter;
import com.workorder.app.workorderapplication.model.clientList.ClientResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Bharat Tripathi on 07-May-18.
 */

public class ClientListAdapter extends RecyclerView.Adapter<ClientListAdapter.MyViewHolder> implements Filterable {
    Context mContext;
    public List<ClientResponse> myTaskList,filterList;
    ClickListener mClickListner;
    ClientListFilter filter;
    public ClientListAdapter(Context mContext, List<ClientResponse> myTaskList) {
        this.mContext = mContext;
        this.myTaskList = myTaskList;
        this.filterList=myTaskList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.client_list, parent, false);
        return new ClientListAdapter.MyViewHolder(mContext,itemView, viewType,mClickListner);
    }

   @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       if(myTaskList.size()!=0){
           ClientResponse item=myTaskList.get(position);
           String Id= String.valueOf(item.getWorkOrderId());
           holder.workOrderId.setText(Id);
            holder.status.setText(String.valueOf(item.getStatus()));
            holder.assignedName.setText(item.getAssignedName());
            holder.clientName.setText(item.getClientName());
            holder.workOrderNumber.setText(item.getWorkOrderNumber());
            holder.assetName.setText(item.getAssetName());
            String date=item.getDateRaised();
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
           holder.dateRaised.setText(dateInReqFormat);
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
            filter=new ClientListFilter(this,filterList);
        }
        return filter;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView workOrderId,status,assignedName,assetName,clientName,dateRaised,workOrderNumber;
        Integer position;
        Context context;
        ClickListener clickListener;

        public MyViewHolder(Context context, View itemView, Integer viewType, final ClickListener clickListener) {
            super(itemView);
            position = viewType;
            this.context = context;
            workOrderId=itemView.findViewById(R.id.workOrder_Id);
            status=itemView.findViewById(R.id.status_client);
            assignedName=itemView.findViewById(R.id.assigned_name);
            assetName=itemView.findViewById(R.id.asset_name);
            clientName=itemView.findViewById(R.id.client_name);
            dateRaised=itemView.findViewById(R.id.date_raised);
            workOrderNumber=itemView.findViewById(R.id.workOrderNumber);
        }
    }
}
