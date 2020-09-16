package com.workorder.app.workorderapplication.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.workorder.app.R;
import com.workorder.app.adapter.SWMSAdapter;
import com.workorder.app.pojo.GetLocationPOJO;
import com.workorder.app.pojo.assesment.AssesmentHomePOJO;
import com.workorder.app.pojo.docPOJO.AttachementPOJO;
import com.workorder.app.pojo.docPOJO.DocListPOJO;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UrlClass;
import com.workorder.app.webservicecallback.GetApiCallback;
import com.workorder.app.webservicecallback.OnTaskCompleted;

import java.util.ArrayList;
import java.util.List;

public class Swmslist extends AppCompatActivity {
    Dialog dialog;
    Button yesButton;
    TextView titleText;
    ImageView img;
    ProgressBar progressbar;
    TextView tv_wo_no;
    TextView show;
    /**/ RecyclerView rv_home;
    String task = "";
    GetLocationPOJO locationPOJO;

    SWMSAdapter adapter;
    AssesmentHomePOJO assesmentHomePOJO;
    List<AttachementPOJO> attachementPOJOS=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swms_related_to_site);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("SWMS Template");
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }



        rv_home = findViewById(R.id.rv_task_list);
        tv_wo_no=findViewById(R.id.tv_swms_work_order_no);
        show=findViewById(R.id.show);
        rv_home.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


     /*   try {
            new GetApiCallback(getApplicationContext(), UrlClass.GET_TASK_API_URL + id, new OnTaskCompleted<String>() {
                @Override
                public void onTaskCompleted(String response) {
                    Log.d("response",response);
                    Constants.docListPOJO=new Gson().fromJson(response, DocListPOJO.class);
                    attachementPOJOS=Constants.docListPOJO.getAttachementPOJOs();
                    //tv_wo_no.setText(attachementPOJOS.get());
                    adapter=new SWMSAdapter(getApplicationContext(),attachementPOJOS,Constants.homeStatusPOJO.getWorkOrderNo());
                    rv_home.setAdapter(adapter);
                    Log.d("AttachementSize",attachementPOJOS.size()+"");
                }
            },true).execute();
        }catch (Exception e)
        {
            Log.d("ShowListExceptiion",e.toString());
        }

*/
    }
}
