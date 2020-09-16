package com.workorder.app.workorderapplication.filter;

import android.widget.Filter;

import com.workorder.app.workorderapplication.adapter.WorkerListAdapter;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderResponseModel;

import java.util.ArrayList;
import java.util.List;

public class WorkerFilter extends Filter {

    WorkerListAdapter adapter;
    List<WorkOrderResponseModel> filterList;

    public WorkerFilter(WorkerListAdapter adapter, List<WorkOrderResponseModel> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Filter.FilterResults results=new Filter.FilterResults();
        if(charSequence != null && charSequence.length() > 0) {
            charSequence = charSequence.toString();
            ArrayList<WorkOrderResponseModel> filterWorker = new ArrayList<>();
            for (int i = 0; i < filterList.size(); i++) {

                if(filterList.get(i).getClientName()== null || (filterList.get(i).getClientName().toLowerCase().contains(charSequence.toString().toLowerCase()))||
                        filterList.get(i).getLocationName()==null || (filterList.get(i).getLocationName().toLowerCase().contains(charSequence.toString().toLowerCase()))||
                        filterList.get(i).getPriority() ==null || (filterList.get(i).getPriority().toLowerCase().contains(charSequence.toString().toLowerCase()))||
                        filterList.get(i).getWorkOrderNumber()==null || (filterList.get(i).getWorkOrderNumber().toLowerCase().contains(charSequence.toString().toLowerCase()))||
                        filterList.get(i).getStatus()== null || (filterList.get(i).getStatus().toLowerCase().contains(charSequence.toString().toLowerCase()))||
                        filterList.get(i).getWorkOrderId().contains(charSequence)) {
                    filterWorker.add(filterList.get(i));
                }else if(filterList.get(i).getClientName().toUpperCase().toString().contains(charSequence) ||
                        filterList.get(i).getPriority().toUpperCase().toString().contains(charSequence) ||
                        filterList.get(i).getStatus().toUpperCase().toString().contains(charSequence)||
                        filterList.get(i).getWorkOrderNumber().toUpperCase().toString().contains(charSequence)

                        )
                {
                    filterWorker.add(filterList.get(i));
                }
            }
            results.count=filterWorker.size();
            results.values=filterWorker;
        }else {
            results.count=filterList.size();
            results.values=filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, Filter.FilterResults results) {
        adapter.myTaskList= (List<WorkOrderResponseModel>) results.values;
        adapter.notifyDataSetChanged();
    }
}
