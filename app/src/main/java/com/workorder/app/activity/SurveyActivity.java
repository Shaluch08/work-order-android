package com.workorder.app.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.workorder.app.ConnectivityReceiver;
import com.workorder.app.R;
import com.workorder.app.Util;
import com.workorder.app.adapter.SurveyAdapter;
import com.workorder.app.fragment.SurveyFragment;
import com.workorder.app.pojo.survey.SurveyPOJO;
import com.workorder.app.pojo.survey.SurveyTempPOJO;
import com.workorder.app.util.Constants;
import com.workorder.app.util.SubmitSurveyAns;
import com.workorder.app.util.UrlClass;
import com.workorder.app.webservicecallback.GetApiCallback;
import com.workorder.app.webservicecallback.OnTaskCompleted;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SurveyActivity extends FragmentActivity implements SurveyAdapter.RatingSelectionInterface {
    String surveyTemplateId;
    TextView tv_list_type;
    ImageView iv_back;
    ImageView iv_mapview;
    SurveyAdapter adapter;
    RecyclerView rv_sync_task_list;
    LinearLayout next;
    LinearLayout back;
    int i=0;
    TextView sub;

    TextView tv_home_activity_name;
    TextView tv_home_activity_role;
    String requestBody;

    private Map<String,String> map=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_sur);

        iv_back = findViewById(R.id.iv_site_location_back);
        tv_home_activity_name = findViewById(R.id.tv_home_activity_name);
        tv_home_activity_role = findViewById(R.id.tv_home_activity_role);

        tv_home_activity_name.setText(Constants.loginPOJO.getUsername());
        tv_home_activity_role.setText(Constants.loginPOJO.getUserRole());


        surveyTemplateId=getIntent().getStringExtra("surveyTemplateId");
    //    Log.v("wrk",surveyTemplateId);

        tv_list_type = findViewById(R.id.unsigned_task);

        tv_list_type.setText("Survey");

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onBackPressed();
                 finish();
            }
        });


       // Log.v("wrk",surveyTemplateId);
        next=findViewById(R.id.next);
        back=findViewById(R.id.back);
        sub=findViewById(R.id.sub);
        rv_sync_task_list=findViewById(R.id.rv_sync_task_list);
        rv_sync_task_list.setLayoutManager(new LinearLayoutManager(SurveyActivity.this));


        boolean connection= ConnectivityReceiver.isConnected();
        if(connection==true) {
            try {
                new GetApiCallback(SurveyActivity.this, UrlClass.SURVEY_URL + 1, new OnTaskCompleted<String>() {
                    @Override
                    public void onTaskCompleted(String response) {
                        Constants.surveyList = Arrays.asList(new Gson().fromJson(response, SurveyPOJO[].class));
                       /*
                        Type collectionType = new TypeToken<List<SurveyPOJO>>() {
                        }.getType();
                        Constants.surveyList = (List<SurveyPOJO>) new Gson().fromJson(response, collectionType);*/
                        Log.v("respo", response);
                        getlist(i);

                    }
                }, true).execute();
            } catch (Exception e) {
                Log.d("ShowListExceptiion", e.toString());
            }
        }else {
            getlist(i);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=i-1;
                adapter.notifyDataSetChanged();
                getlist(i);
                if(i==0){
                    Log.v("size1", String.valueOf(i));

                    back.setVisibility(View.GONE);
                }
                if(i< Constants.surveyList.size()-1){
                    Log.v("size1", String.valueOf(i));
                    sub.setTextColor(getResources().getColor(R.color.blue));
                    next.setBackground(getResources().getDrawable(R.drawable.circular_blue_desing));

                    sub.setText("Next");
                }
                if(i== Constants.surveyList.size()-1){
                    Log.v("size1", String.valueOf(i));
                    sub.setTextColor(getResources().getColor(R.color.white));
                    next.setBackground(getResources().getDrawable(R.drawable.blue_desing));

                    sub.setText("Submit");
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if(i< Constants.surveyList.size()-1) {
                    if(map.size()>i){
                        i = i + 1;

                        back.setVisibility(View.VISIBLE);

                        adapter.notifyDataSetChanged();
                        getlist(i);
                        Log.v("size", String.valueOf( Constants.surveyList.size()));
                        Log.v("size1", String.valueOf(i));
                        if(i== Constants.surveyList.size()-1){
                            sub.setText("Submit");
                            next.setBackground(getResources().getDrawable(R.drawable.blue_desing));
                            sub.setTextColor(getResources().getColor(R.color.white));
                            Log.v("size1", String.valueOf(i));
                            Log.v("size", String.valueOf( Constants.surveyList.size()));

                        }
                    }else {
                        Toast.makeText(SurveyActivity.this, "select one option" , Toast.LENGTH_SHORT).show();

                    }

                }
                else {
                    Log.v("size1", String.valueOf(i));


                    sub.setText("Submit");
                    sub.setTextColor(getResources().getColor(R.color.white));
                    next.setBackground(getResources().getDrawable(R.drawable.blue_desing));

                    if (map.size() ==  Constants.surveyList.size()) {
                        JSONArray jsonArray = new JSONArray();
                        for (Map.Entry<String, String> mmap : map.entrySet()) {
                            JSONObject jsonObject = new JSONObject();
                            try {
                                //    jsonObject.put("questionID", mmap.getKey());
                                //   jsonObject.put("answerID",mmap.getValue().getAnswerID() );
                                //   jsonObject.put("surveyAnswerID", mmap.getValue().getSurveyAnswerID());
                                //  jsonObject.put("surveyID",mmap.getValue().getSurveyID() );
                                //jsonObject.put("SurveyorIDt",mmap.getValue(). getSurveyorIDt());

                                String srValue = mmap.getValue();
                                String aa = srValue.substring(mmap.getValue().indexOf(",") + 1);
                                String surveyAnswerID = Util.before(aa, ",");
                                String aaa = aa.substring(aa.indexOf(",") + 1);
                                String surveyID = Util.before(aaa, ",");
                                String SurveyorIDt = Util.after(aaa, ",");

                                jsonObject.put("questionID", mmap.getKey());
                                jsonObject.put("answerID", Util.before(mmap.getValue(), ","));
                                //  jsonObject.put("surveyAnswerID", "");
                                jsonObject.put("surveyID", surveyID);
                                //  jsonObject.put("SurveyorIDt", SurveyorIDt);

                                jsonArray.put(jsonObject);

                            } catch (Exception e) {
                            }
                        }

                        requestBody = jsonArray.toString();

                        Log.v("shalu", requestBody);
                        boolean isConnected = ConnectivityReceiver.isConnected();
                        if (isConnected == true) {

                            StringRequest stringRequest = new StringRequest(Request.Method.POST, UrlClass.SUBMIT_ANSWER,
                                    new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {

                                            JSONObject jsonObject = null;
                                            try {
                                                jsonObject = new JSONObject(response);
                                                String status = jsonObject.getString("status");
                                                String message = jsonObject.getString("msg");

                                                if (status.equalsIgnoreCase("true")) {
                                                    // Toast.makeText(SurveyActivity.this, "" + message, Toast.LENGTH_SHORT).show();
                                                    next.setEnabled(false);
                                                    opentThanksYesClickDialog("survey completed successfully");
                                                } else {
                                                    opentThanksYesClickDialog("something went wrong");

                                                }
                                                //   map.clear();
//                                            Fragment  fragment = new AssessmentHomeFragment();
//                                            if (fragment != null) {
//                                                getFragmentManager().beginTransaction().add(R.id.container, fragment, null).addToBackStack(null).commit();
//
//                                            }
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }


                                        }
                                    }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(SurveyActivity.this, "Error" + error, Toast.LENGTH_SHORT).show();

                                }
                            }) {
                                @Override
                                public String getBodyContentType() {
                                    return String.format("application/json; charset=utf-8");
                                }

                                @Override

                                public byte[] getBody() throws AuthFailureError {
                                    try {
                                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                                    } catch (UnsupportedEncodingException uee) {
                                        return null;
                                    }
                                }
                            };
                            RequestQueue requestQueue = Volley.newRequestQueue(SurveyActivity.this);
                            requestQueue.add(stringRequest);

                        } else {
                            SharedPreferences mPrefs = SurveyActivity.this.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
                            SharedPreferences.Editor prefsEditor = mPrefs.edit();
                            prefsEditor.putString("jsonarray", jsonArray.toString());
                            prefsEditor.commit();

                            opentThanksYesClickDialog("Network not available");


                            //   Toast.makeText(SurveyActivity.this,"Network Not Available",Toast.LENGTH_LONG).show();
                            //    startActivity(new Intent(SurveyActivity.this,HomeActivity.class));

                        }


                        Log.v("requestBody", requestBody);


                    } else {
                        Toast.makeText(SurveyActivity.this, "select one option" , Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });



    }

    public void opentThanksYesClickDialog(String message)
    {
        final Dialog dialog=new Dialog(SurveyActivity.this);
        dialog.setContentView(R.layout.inflate_home_thanks_yes_click);
        TextView tv_type=dialog.findViewById(R.id.tv_alert_type);
        TextView tv_ok=dialog.findViewById(R.id.tv_ok_thanks);
        tv_type.setText("Alert");
        TextView tv_message=dialog.findViewById(R.id.tv_message_thanks);
        tv_message.setText(message);

        dialog.show();
        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                startActivity(new Intent(SurveyActivity.this,HomeActivity.class));


            }
        });
    }

    private void getlist(int p) {
        adapter=new SurveyAdapter(SurveyActivity.this, Constants.surveyList,p,this,map);
        rv_sync_task_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void itemselect(String questionID, String answerID, String surveyAnswerID, String surveyID, String SurveyorIDt) {
        map.put(questionID,answerID+","+surveyAnswerID+","+surveyID+","+SurveyorIDt);
        Log.v("SELECt",map.toString());
    }

    @Override
    public void itemUnSelect(int questionID) {

    }


}
