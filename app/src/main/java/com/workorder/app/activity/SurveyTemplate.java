package com.workorder.app.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.workorder.app.ConnectivityReceiver;
import com.workorder.app.R;
import com.workorder.app.adapter.SurveyAdapter;
import com.workorder.app.adapter.SurveyTempAdapter;
import com.workorder.app.pojo.WorkOrderPOJO;
import com.workorder.app.pojo.survey.SurveyPOJO;
import com.workorder.app.pojo.survey.SurveyTempPOJO;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UrlClass;
import com.workorder.app.webservicecallback.GetApiCallback;
import com.workorder.app.webservicecallback.OnTaskCompleted;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class SurveyTemplate extends FragmentActivity {
    int workorderno;
    String workorderid;
    RecyclerView recyclerView;
    SurveyTempAdapter adapter;

    TextView tv_home_activity_name;
    TextView tv_home_activity_role;
    ImageView iv_back;
    TextView tv_list_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.template);

        iv_back = findViewById(R.id.iv_site_location_back);
        tv_home_activity_name = findViewById(R.id.tv_home_activity_name);
        tv_home_activity_role = findViewById(R.id.tv_home_activity_role);

        tv_home_activity_name.setText(Constants.loginPOJO.getUsername());
        tv_home_activity_role.setText(Constants.loginPOJO.getUserRole());

        workorderno=getIntent().getIntExtra("workorderno",0);
        workorderid=getIntent().getStringExtra("workorderid");

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                // finish();
            }
        });
        tv_list_type = findViewById(R.id.unsigned_task);

        tv_list_type.setText("Survey List");


        recyclerView= findViewById(R.id.rv_sync_trask_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(SurveyTemplate.this));

        boolean connection= ConnectivityReceiver.isConnected();
        if(connection==true) {
            try {
                new GetApiCallback(SurveyTemplate.this, UrlClass.SURVEY_TEMPLATE + workorderno, new OnTaskCompleted<String>() {
                    @Override
                    public void onTaskCompleted(String response) {
                        Log.v("wrk", UrlClass.SURVEY_TEMPLATE + workorderno);
                        Log.v("wrk", response);
                        Constants.surveytemplateList  = Arrays.asList(new Gson().fromJson(response, SurveyTempPOJO[].class));

                      /*  Type collectionType = new TypeToken<List<SurveyTempPOJO>>() {
                        }.getType();
                        Constants.surveytemplateList = (List<SurveyTempPOJO>) new Gson().fromJson(response, collectionType);*/
                        adapter = new SurveyTempAdapter(SurveyTemplate.this, Constants.surveytemplateList, workorderid);
                        recyclerView.setAdapter(adapter);


                    }
                }, true).execute();
            } catch (Exception e) {
                Log.d("ShowListExceptiion", e.toString());
            }

        }else {
            adapter = new SurveyTempAdapter(SurveyTemplate.this, Constants.surveytemplateList, workorderid);
            recyclerView.setAdapter(adapter);

        }
    }


}
