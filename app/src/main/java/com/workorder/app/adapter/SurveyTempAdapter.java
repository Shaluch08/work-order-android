package com.workorder.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.Util;
import com.workorder.app.activity.SurveyActivity;
import com.workorder.app.pojo.survey.SurveyPOJO;
import com.workorder.app.pojo.survey.SurveyTempPOJO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurveyTempAdapter extends RecyclerView.Adapter<SurveyTempAdapter.QuestionListAdapter> {
    Context context;
    List<SurveyTempPOJO> attachementPOJOList;
    String workorderid;

    public SurveyTempAdapter(Context context, List<SurveyTempPOJO> attachementPOJOList,String workorderid) {
        this.context = context;
        this.attachementPOJOList=attachementPOJOList;
        this.workorderid=workorderid;

    }

    @NonNull
    @Override
    public QuestionListAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_surveytemp, parent, false);

        return new QuestionListAdapter(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionListAdapter holder, final int position) {
    holder.name.setText(workorderid);
    holder.detail.setText(attachementPOJOList.get(position).getSurveyName());


    }

    @Override
    public int getItemCount() {
        return attachementPOJOList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public class QuestionListAdapter extends RecyclerView.ViewHolder{
        TextView name,detail,start;
        LinearLayout next;

        public QuestionListAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_inflate_work_order_number);
            detail = itemView.findViewById(R.id.tv_inflate_synchronized_place_work);
            start = itemView.findViewById(R.id.tv_inflate_synchronized_date);

            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(context, SurveyActivity.class);
                    i.putExtra("surveyTemplateId",attachementPOJOList.get(getLayoutPosition()).getSurveyTemplateId());
                    context.startActivity(i);
                }
            });

        }

        }

}
