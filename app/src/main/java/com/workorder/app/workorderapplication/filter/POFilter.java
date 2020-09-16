package com.workorder.app.workorderapplication.filter;

import android.widget.Filter;

import com.workorder.app.workorderapplication.adapter.ListPurchaseOrderAdapter;
import com.workorder.app.workorderapplication.model.purchaseOrderModel.PurchaseOrderResponseModel;

import java.util.ArrayList;
import java.util.List;

public class POFilter extends Filter {
    ListPurchaseOrderAdapter adapter;
    List<PurchaseOrderResponseModel> filterList;

    public POFilter(ListPurchaseOrderAdapter adapter, List<PurchaseOrderResponseModel> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results=new FilterResults();
        if(charSequence != null && charSequence.length() > 0) {
            charSequence = charSequence.toString();
            ArrayList<PurchaseOrderResponseModel> arrayList=new ArrayList<>();
            for(int i=0;i<filterList.size();i++)
            {
                if(filterList.get(i).getStatus().toLowerCase().contains(charSequence.toString().toLowerCase()) ||
                        filterList.get(i).getStatus()==null || (filterList.get(i).getStatus().toLowerCase().contains(charSequence.toString().toLowerCase())) ||
                        filterList.get(i).getClientPurchaseOrderNo()==null ||(filterList.get(i).getClientPurchaseOrderNo().toLowerCase().contains(charSequence.toString().toLowerCase()))||
                        filterList.get(i).getPurchaseOrder()==null ||(filterList.get(i).getPurchaseOrder().toLowerCase().contains(charSequence.toString().toLowerCase())) ||
                        filterList.get(i).getDescription()==null ||(filterList.get(i).getDescription().toLowerCase().contains(charSequence.toString().toLowerCase()))
                        ){
                    arrayList.add(filterList.get(i));
                }
            }
            results.count=arrayList.size();
            results.values=arrayList;
        }else {
            results.count=filterList.size();
            results.values=filterList;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults results) {
        adapter.purchaseOrderList= (List<PurchaseOrderResponseModel>) results.values;
        adapter.notifyDataSetChanged();
    }
}
