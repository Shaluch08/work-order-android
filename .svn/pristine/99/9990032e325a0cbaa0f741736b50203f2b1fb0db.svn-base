package com.workorder.app.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import com.workorder.app.R;
import com.workorder.app.pojo.GetWorkerPOJO;
import com.workorder.app.util.Constants;

import java.util.List;

public class GoOnSiteAdapter extends RecyclerView.Adapter<GoOnSiteAdapter.GoOnSiteHolder> {

    Activity context;
    List<GetWorkerPOJO> workerPOJOList;



    public GoOnSiteAdapter(Activity context, List<GetWorkerPOJO> workerPOJOList) {
        this.context = context;
        this.workerPOJOList = workerPOJOList;
    }



    @Override
    public GoOnSiteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.inflate_go_on_site,parent,false);

        return new GoOnSiteHolder(view);
    }



    @Override
    public void onBindViewHolder(final GoOnSiteHolder holder, final int position) {

        try {
            holder.tv_name.setText(workerPOJOList.get(position).getWorkOrderNumber());
            holder.tv_task_name.setText(workerPOJOList.get(position).getDescription());
           // holder.tv_task_day.setText(workerPOJOList.get(position).getTi);

        if (Constants.CHECKED_POSITION==position)
        {
            holder.ch_select.setChecked(true);
         //   notifyDataSetChanged();
        }else {
            holder.ch_select.setChecked(false);
           // notifyDataSetChanged();
        }

            holder.ch_select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    notifyDataSetChanged();
                    if (isChecked)
                    {

                        Constants.CHECKED_POSITION=position;

                    }else {

                        Constants.CHECKED_POSITION=-1;
                        //notifyDataSetChanged();
                    }
                }
            });

        }catch (Exception e)
        {
            Log.d("GoOnSiteException",e.toString());
        }

    }

    @Override
    public int getItemCount() {
        return workerPOJOList.size();
    }



    public class GoOnSiteHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_task_name;
        CheckBox ch_select;
        public GoOnSiteHolder(View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.tv_inflate_go_on_site_worker_name);
            tv_task_name=itemView.findViewById(R.id.tv_inflate_go_on_site_task_name);
             ch_select=itemView.findViewById(R.id.ch_inflate_go_on_site);
             this.setIsRecyclable(false);
        }
    }


}
