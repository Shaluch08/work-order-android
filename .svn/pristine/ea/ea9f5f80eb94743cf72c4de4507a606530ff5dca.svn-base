package com.workorder.app.workorderapplication.filter;

import android.widget.Filter;

import com.workorder.app.workorderapplication.adapter.ClientListAdapter;
import com.workorder.app.workorderapplication.model.clientList.ClientResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bharat Tripathi on 14-May-18.
 */

public class ClientListFilter extends Filter {
    ClientListAdapter adapter;
    List<ClientResponse> filterList;

    public ClientListFilter(ClientListAdapter adapter, List<ClientResponse> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results=new FilterResults();
        if(charSequence != null && charSequence.length() > 0) {
            charSequence = charSequence.toString();
            ArrayList<ClientResponse> filterAsigneeName = new ArrayList<>();
            for (int i = 0; i < filterList.size(); i++) {
                if(filterList.get(i).getAssetName().toUpperCase().contains(charSequence) ||
                        filterList.get(i).getClientName().toUpperCase().contains(charSequence)||
                        filterList.get(i).getAssignedName().toUpperCase().contains(charSequence)||
                        filterList.get(i).getWorkOrderNumber().toUpperCase().contains(charSequence)) {
                    filterAsigneeName.add(filterList.get(i));
                }else if(filterList.get(i).getAssignedName().toLowerCase().contains(charSequence)||
                        filterList.get(i).getAssetName().toLowerCase().contains(charSequence) ||
                        filterList.get(i).getClientName().toLowerCase().contains(charSequence)
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
        adapter.myTaskList= (List<ClientResponse>) results.values;
        adapter.notifyDataSetChanged();
    }
}
