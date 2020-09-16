package com.workorder.app.workorderapplication.filter;

import android.widget.Filter;

import com.workorder.app.workorderapplication.adapter.ListWorkOrderAdapter;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderResponseModel;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderFilter extends Filter {
    ListWorkOrderAdapter adapter;
    List<WorkOrderResponseModel> filterList;

    public WorkOrderFilter(ListWorkOrderAdapter adapter, List<WorkOrderResponseModel> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results=new FilterResults();
        if(charSequence != null && charSequence.length() > 0) {
            charSequence = charSequence.toString();
            ArrayList<WorkOrderResponseModel> filterAsigneeName = new ArrayList<>();
            for (int i = 0; i < filterList.size(); i++) {
                if(filterList.get(i).getAssetName()==null || (filterList.get(i).getAssetName().toLowerCase().contains(charSequence.toString().toLowerCase())) ||
                   filterList.get(i).getClientName()==null || (filterList.get(i).getClientName().toLowerCase().contains(charSequence.toString().toLowerCase()))||
                        filterList.get(i).getAssignedName()==null || (filterList.get(i).getAssignedName().toLowerCase().contains(charSequence.toString().toLowerCase()))||
                   filterList.get(i).getWorkOrderNumber()==null || (filterList.get(i).getWorkOrderNumber().toLowerCase().contains(charSequence.toString().toLowerCase()))||
                        filterList.get(i).getStatus()==null || (filterList.get(i).getStatus().toLowerCase().contains(charSequence.toString().toLowerCase()))||
                   filterList.get(i).getWorkOrderId().contains(charSequence)) {
                        filterAsigneeName.add(filterList.get(i));
                }else if(filterList.get(i).getAssignedName().toUpperCase().contains(charSequence)||
                        filterList.get(i).getAssetName().toUpperCase().contains(charSequence) ||
                        filterList.get(i).getClientName().toUpperCase().contains(charSequence)
                        )
                {
                    filterAsigneeName.add(filterList.get(i));
                }
            }
            results.count=filterAsigneeName.size();
            results.values=filterAsigneeName;
        }else {
            results.count=filterList.size();
            results.values=filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults results) {
        adapter.myTaskList= (List<WorkOrderResponseModel>) results.values;
        adapter.notifyDataSetChanged();
    }
}
