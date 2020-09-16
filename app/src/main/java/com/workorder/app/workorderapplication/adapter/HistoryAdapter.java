package com.workorder.app.workorderapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.model.history.HistoryModel;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Bharat Tripathi on 29-May-18.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder1>{
    Context mContext;
    HistoryDetalisClick mClickListner;
    String rolename,WorkOrderId,companyid;
    List<HistoryModel> historyModels,filterList;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    public HistoryAdapter(Context context, List<HistoryModel> historyModels) {
        this.historyModels = historyModels;
        this.filterList=historyModels;
        this.mContext = context;
    }
    @Override
    public MyViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_history, parent, false);

        return new MyViewHolder1(mContext,itemView, viewType,mClickListner);
    }
    @Override
    public void onBindViewHolder(MyViewHolder1 holder, int position) {
            if(historyModels.size()!=0)
            {
                HistoryModel item=historyModels.get(position);
                holder.user.setText(item.getAuditUserName());
                String date=item.getTimeStamp();
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
                holder.time.setText(dateInReqFormat);
            }
        }
    public void setClicklistener(HistoryDetalisClick clickListner) {
        this.mClickListner = clickListner;
    }
    @Override
    public int getItemCount() {
        return historyModels.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        TextView type,status,user,time;
        Integer position;
        ImageButton history_Details;
        Context context;
        HistoryDetalisClick clickListener;

        public MyViewHolder1(Context context, final View itemView, Integer viewType, final HistoryDetalisClick clickListener) {
            super(itemView);
            position = viewType;
            this.context = context;
            this.clickListener = clickListener;
            type=itemView.findViewById(R.id.type);
            status=itemView.findViewById(R.id.status);
            user=itemView.findViewById(R.id.user);
            time=itemView.findViewById(R.id.time);
            history_Details=itemView.findViewById(R.id.history_details);

            history_Details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   clickListener.historyDetailsClickListener(getAdapterPosition()
                   );
                }
            });
        }

    }
}
