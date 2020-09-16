package com.workorder.app.workorderapplication.filter;

import android.widget.Filter;

import com.workorder.app.workorderapplication.adapter.ListAssetAdapter;
import com.workorder.app.workorderapplication.model.assetModel.AssetResponseModel;

import java.util.ArrayList;
import java.util.List;

public class AssetFilter extends Filter {
   ListAssetAdapter adapter;
    List<AssetResponseModel> filterList;

    public AssetFilter(ListAssetAdapter adapter, List<AssetResponseModel> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results=new FilterResults();
        if(charSequence != null && charSequence.length() > 0) {
            charSequence = charSequence.toString();
            ArrayList<AssetResponseModel> filterAsigneeName = new ArrayList<>();
            for (int i = 0; i < filterList.size(); i++) {
                if(filterList.get(i).getAssetName().toLowerCase().contains(charSequence.toString().toLowerCase()) ||
                        filterList.get(i).getSupplierName().toLowerCase().contains(charSequence.toString().toLowerCase()) ||
                        filterList.get(i).getId().contains(charSequence)||
                        filterList.get(i).getClientName().toLowerCase().contains(charSequence.toString().toLowerCase())||
                        filterList.get(i).getAssetType().toLowerCase().contains(charSequence.toString().toLowerCase()) ||
                        filterList.get(i).getOrderNumber()== null || (filterList.get(i).getOrderNumber().toLowerCase().contains(charSequence.toString().toLowerCase()))||
                        filterList.get(i).getStatus().toLowerCase().contains(charSequence.toString().toLowerCase())
                        ) {
                    filterAsigneeName.add(filterList.get(i));
                }else if(filterList.get(i).getAssetName().toUpperCase().contains(charSequence) ||
                        filterList.get(i).getSupplierName().toUpperCase().contains(charSequence) ||
                        filterList.get(i).getAssetType().toUpperCase().contains(charSequence) ||
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
        adapter.myTaskList= (List<AssetResponseModel>) results.values;
        adapter.notifyDataSetChanged();
    }
}
