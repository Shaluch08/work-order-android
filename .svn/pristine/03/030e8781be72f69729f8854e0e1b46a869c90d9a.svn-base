package com.workorder.app.workorderapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.model.history.HistoryDetailsModel;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;

import java.util.List;

/**
 * Created by Bharat Tripathi on 29-May-18.
 */

public class HistoryDetailsAdapter extends RecyclerView.Adapter<HistoryDetailsAdapter.MyViewHolder1>{
    Context mContext;
    ClickListener mClickListner;
    String rolename,WorkOrderId,companyid;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    List<HistoryDetailsModel> myTaskList,filterList;
        public HistoryDetailsAdapter(Context context, List<HistoryDetailsModel> list) {
        this.myTaskList = list;
        this.filterList=myTaskList;
        this.mContext = context;
       }
    public void setClicklistener(ClickListener clickListner) {
        this.mClickListner = clickListner;
    }
    @Override
    public MyViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_history_details, parent, false);

        return new MyViewHolder1(mContext,itemView, viewType,mClickListner);
    }
    @Override
    public void onBindViewHolder(MyViewHolder1 holder, int position) {
        if(myTaskList.size()!=0)
        {
            HistoryDetailsModel item=myTaskList.get(position);
            holder.property.setText(item.getPropertyName());
            holder.previous.setText(item.getPreviousValue());
            holder.saved.setText(item.getSavedValue());
            holder.edit.setChecked(item.getIsChanged());
        }
    }

    @Override
    public int getItemCount() {
        return myTaskList.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        TextView property,previous,saved;
        Integer position;
        public CheckBox edit;
        Context context;
        ClickListener clickListener;

        public MyViewHolder1(Context context, final View itemView, Integer viewType, final ClickListener clickListener) {
            super(itemView);
            position = viewType;
            this.context = context;
            this.clickListener = clickListener;
            property=itemView.findViewById(R.id.property);
            previous=itemView.findViewById(R.id.previous);
            saved=itemView.findViewById(R.id.saved);
            edit=itemView.findViewById(R.id.changed);

        }

    }
}
