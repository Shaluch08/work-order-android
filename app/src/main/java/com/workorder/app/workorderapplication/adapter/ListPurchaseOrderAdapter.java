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
import com.workorder.app.workorderapplication.filter.POFilter;
import com.workorder.app.workorderapplication.model.purchaseOrderModel.PurchaseOrderResponseModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ListPurchaseOrderAdapter extends RecyclerView.Adapter<ListPurchaseOrderAdapter.MyViewHolder> implements Filterable {
        Context mContext;
        public List<PurchaseOrderResponseModel> purchaseOrderList,filterList;
        POFilter filter;
    public ListPurchaseOrderAdapter(Context mContext, List<PurchaseOrderResponseModel> list) {
        this.purchaseOrderList = list;
        this.filterList=purchaseOrderList;
        this.mContext = mContext;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_purchase_order, parent, false);
        return new ListPurchaseOrderAdapter.MyViewHolder(mContext, itemView, viewType);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (purchaseOrderList.size() != 0) {

            PurchaseOrderResponseModel item = purchaseOrderList.get(position);
            holder.po_number.setText(item.getPurchaseOrder());
            holder.client_po_no.setText(item.getClientPurchaseOrderNo());
            holder.status.setText(item.getStatus());
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
            holder.date.setText(dateInReqFormat);
            holder.description.setText(item.getDescription());

        }
    }

    @Override
    public int getItemCount() {
        return purchaseOrderList.size();
    }
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new POFilter(this,filterList);
        }
        return filter;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView po_number,client_po_no,status,date,description;
        Integer position;
        Context context;

        public MyViewHolder(Context context, View itemView, Integer viewType) {
            super(itemView);
            position = viewType;
            this.context = context;
            po_number=itemView.findViewById(R.id.po_no);
            client_po_no=itemView.findViewById(R.id.client_po_number);
            status=itemView.findViewById(R.id.status1);
            date=itemView.findViewById(R.id.raised);
            description=itemView.findViewById(R.id.descrption);
        }
    }
}