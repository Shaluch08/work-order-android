package com.workorder.app.workorderapplication.filter;

import android.widget.Filter;

import com.workorder.app.workorderapplication.adapter.WorkOrderAllocationAdapter;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderAllocationListResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bharat Tripathi on 03-May-18.
 */

public class WorkOrderAllocationFilter extends Filter {
    WorkOrderAllocationAdapter adapter;
    List<WorkOrderAllocationListResponse> filterList;

    public WorkOrderAllocationFilter(WorkOrderAllocationAdapter adapter, List<WorkOrderAllocationListResponse> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results=new FilterResults();
        if(charSequence != null && charSequence.length() > 0) {
            charSequence = charSequence.toString();
            ArrayList<WorkOrderAllocationListResponse> filterAsigneeName = new ArrayList<>();
            for (int i = 0; i < filterList.size(); i++) {
                if(filterList.get(i).getPerson().getFullName().toUpperCase().contains(charSequence) ||
                        filterList.get(i).getTradeCategories().getTradeName().toUpperCase().contains(charSequence) ||
                        filterList.get(i).getSwms().toUpperCase().contains(charSequence) ||
                        filterList.get(i).getTotalHours().contains(charSequence) ||
                        filterList.get(i).getWorkingHours().contains(charSequence)) {
                    filterAsigneeName.add(filterList.get(i));
                }else if(filterList.get(i).getPerson().getFullName().toLowerCase().contains(charSequence)||
                        filterList.get(i).getTradeCategories().getTradeName().toLowerCase().contains(charSequence) ||
                                filterList.get(i).getSwms().toLowerCase().contains(charSequence)
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
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.workOrderAllocationListResponseList= (List<WorkOrderAllocationListResponse>) results.values;
        adapter.notifyDataSetChanged();
    }
}
