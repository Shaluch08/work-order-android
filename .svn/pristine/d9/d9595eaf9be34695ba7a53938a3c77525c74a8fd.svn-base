package com.workorder.app.workorderapplication.filter;

import android.widget.Filter;

import com.workorder.app.workorderapplication.adapter.MaterialUsedAdapter;
import com.workorder.app.workorderapplication.model.materialModel.MaterialList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bharat Tripathi on 15-May-18.
 */

public class MaterialUsedFilter extends Filter {
    MaterialUsedAdapter adapter;
    List<MaterialList> filterList;

    public MaterialUsedFilter(MaterialUsedAdapter adapter, List<MaterialList> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results=new FilterResults();
        if(charSequence != null && charSequence.length() > 0) {
            charSequence = charSequence.toString();
            ArrayList<MaterialList> filterAsigneeName = new ArrayList<>();
            for (int i = 0; i < filterList.size(); i++) {
                if(filterList.get(i).getMaterialUsed().toUpperCase().contains(charSequence) ||
                        filterList.get(i).getMaterialQuntity().toString().contains(charSequence) ||
                        filterList.get(i).getMaterialCost().toString().contains(charSequence)
                       ) {
                    filterAsigneeName.add(filterList.get(i));
                }else if(filterList.get(i).getMaterialUsed().toLowerCase().contains(charSequence)
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
        adapter.myTaskList= (List<MaterialList>) results.values;
        adapter.notifyDataSetChanged();
    }}
