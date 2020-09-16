package com.workorder.app.workorderapplication.filter;

import android.widget.Filter;

import com.workorder.app.workorderapplication.adapter.ClientAdapter;
import com.workorder.app.workorderapplication.model.clientList.ClientListResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bharat Tripathi on 14-May-18.
 */

public class ClientFilter extends Filter {
    ClientAdapter adapter;
    List<ClientListResponse> filterList;

    public ClientFilter(ClientAdapter adapter, List<ClientListResponse> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results=new FilterResults();
        if(charSequence != null && charSequence.length() > 0) {
            charSequence = charSequence.toString();
            ArrayList<ClientListResponse> filterAsigneeName = new ArrayList<>();
            for (int i = 0; i < filterList.size(); i++) {
                if(filterList.get(i).getFullName().toUpperCase().contains(charSequence) ||
                        filterList.get(i).getParentPerson().getFullName().toUpperCase().contains(charSequence)||
                        filterList.get(i).getAssignTo().getFullName().toUpperCase().contains(charSequence)||
                        filterList.get(i).getRole().getRoleName().toUpperCase().contains(charSequence) ||
                        filterList.get(i).getBusinessEmail().toUpperCase().contains(charSequence) ||
                        filterList.get(i).getBusinessCity().toUpperCase().contains(charSequence) ||
                        filterList.get(i).getBusinessState().toUpperCase().contains(charSequence)) {
                    filterAsigneeName.add(filterList.get(i));
                }else if(filterList.get(i).getFullName().toLowerCase().contains(charSequence)||
                        filterList.get(i).getParentPerson().getFullName().toLowerCase().contains(charSequence) ||
                        filterList.get(i).getAssignTo().getFullName().toLowerCase().contains(charSequence) ||
                        filterList.get(i).getRole().getRoleName().toLowerCase().contains(charSequence) ||
                        filterList.get(i).getBusinessEmail().toLowerCase().contains(charSequence) ||
                        filterList.get(i).getBusinessCity().toLowerCase().contains(charSequence) ||
                        filterList.get(i).getBusinessState().toLowerCase().contains(charSequence)
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
        adapter.myTaskList= (List<ClientListResponse>) results.values;
        adapter.notifyDataSetChanged();
    }
}
