package com.workorder.app.workorderapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.activity.WorkOrderListClientWise;
import com.workorder.app.workorderapplication.filter.ClientFilter;
import com.workorder.app.workorderapplication.model.clientList.ClientListResponse;

import java.util.List;

/**
 * Created by Bharat Tripathi on 08-May-18.
 */

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.MyViewHolder> implements Filterable {
  public List<ClientListResponse> myTaskList,filterList;
    Context mContext;
    ClickListener mClickListner;
   ClientFilter clientFilter;
    public ClientAdapter(List<ClientListResponse> myTaskList, Context mContext) {
        this.myTaskList = myTaskList;
        this.mContext = mContext;
        this.filterList=myTaskList;
    }
    public void setClicklistener(ClickListener clickListner) {
        this.mClickListner = clickListner;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_all_client, parent, false);
        return new ClientAdapter.MyViewHolder(mContext,itemView, viewType,mClickListner);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(myTaskList.size()!=0) {
           final ClientListResponse item = myTaskList.get(position);
            String fullName=item.getFullName();
            holder.clientName.setText(fullName);
            holder.companyName.setText(item.getParentPerson().getFullName());
            holder.fmName.setText(item.getAssignTo().getFullName());
            holder.roleName.setText(item.getRole().getRoleName());
            holder.email.setText(item.getBusinessEmail());
            holder.phone.setText(item.getBusinessPhone());
            holder.city.setText(item.getBusinessCity());
            holder.state.setText(item.getBusinessState());
            holder.worker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id=item.getId();
                    Bundle bundle=new Bundle();
                    bundle.putString("Id", String.valueOf(id));
                    Log.d("AdapterClickId",""+item.getId());
                    Intent intent=new Intent(v.getContext(),WorkOrderListClientWise.class);
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return myTaskList.size();
    }

    @Override
    public Filter getFilter() {
        if(clientFilter==null)
        {
            clientFilter= new ClientFilter(this,filterList);
        }
        return clientFilter;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView clientName,companyName,fmName,roleName,email,phone,city,state;
        Integer position;
        Context context;
        ClickListener clickListener;
        ImageButton worker;
        public MyViewHolder(Context context, View itemView, Integer viewType, final ClickListener clickListener) {
            super(itemView);
            position = viewType;
            this.context = context;
            clientName=itemView.findViewById(R.id.client_name);
            companyName=itemView.findViewById(R.id.company_name);
            fmName=itemView.findViewById(R.id.fm_name);
            roleName=itemView.findViewById(R.id.role_name);
            email=itemView.findViewById(R.id.email_id);
            phone=itemView.findViewById(R.id.phone);
            city=itemView.findViewById(R.id.city);
            state=itemView.findViewById(R.id.state);
            worker=itemView.findViewById(R.id.workerList);

        }
    }
}
