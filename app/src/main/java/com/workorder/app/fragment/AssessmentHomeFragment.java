package com.workorder.app.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import com.workorder.app.activity.HomeActivity;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.adapter.SWMSAdapter;
import com.workorder.app.adapter.SyncronizedHomeAdapter;
import com.workorder.app.pojo.HomeStatusPOJO;
import com.workorder.app.pojo.WorkOrderPOJO;
import com.workorder.app.pojo.assesment.AssesmentHomePOJO;
import com.workorder.app.util.Constants;
import com.workorder.app.util.PrefManager;
import com.workorder.app.util.UrlClass;
import com.workorder.app.webservicecallback.GetApiCallback;
import com.workorder.app.webservicecallback.OnTaskCompleted;
import com.workorder.app.webservicecallback.SendData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

import static android.content.Context.MODE_PRIVATE;
import static com.workorder.app.activity.HomeActivity.iv_mapview;
import static com.workorder.app.activity.HomeActivity.tv_go_on_site;

public class AssessmentHomeFragment extends Fragment{
    Dialog dialog;
    Button yesButton;
    TextView titleText;
    ImageView img;
    ProgressBar progressbar;
    //RVSyncTaskListAdapter adapter;
    Integer taskId ;
    //private List<SearchTaskListResponseModel> list = new ArrayList<>();
    //private ArrayList<SearchTaskListResponseModel> data;
    RecyclerView mrecyclerView;
    String task = "";
    ImageView attchment;
   // private PreferenceManager preferenceManager;
    TextView taskList;
    ProgressDialog progressDialog;
   // private List<SearchTaskListResponseModel> responseModel;

    SyncronizedHomeAdapter syncronizedHomeAdapter;

    String role="",companyId="";
    String url="";
    String workorderno;
    ArrayList<String> article=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView=inflater.inflate(R.layout.fragment_sync,container,false);
       // attchment=rootView.findViewById(R.id.img_attachment);
        if(getArguments()!=null)
        {
            taskId = getArguments().getInt("taskId");
        }

        Toolbar toolbar = (Toolbar)rootView.findViewById(R.id.toolbar);
        init(rootView);

         //UrlClass.ROLE_TYPE=Constants.loginPOJO.getUserRole();
         //UrlClass.COMPANYID=Constants.loginPOJO.getPersonCompanyId();
        url=UrlClass.GET_ALL_TASK_URL+UrlClass.ROLE_TYPE+"&companyid="+UrlClass.COMPANYID;
        Log.d("SyncUrl",url);

        role=Constants.loginPOJO.getUserRole();
        companyId=Constants.loginPOJO.getPersonCompanyId();
        Log.d("URL",UrlClass.GET_WORKORDER_URL+role+"&companyid="+companyId);


        callCheckOnSiteApi();


        final SharedPreferences pref = getContext().getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        String json_array = pref.getString("jsonarray", null);
        try {
            if(json_array.isEmpty()){

            }else {
                JSONArray jsoArray = new JSONArray(json_array);
                Log.v("shalu", jsoArray.toString());

                final String requestBody=jsoArray.toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, UrlClass.SUBMIT_ANSWER,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                JSONObject jsonObject= null;
                                try {
                                    jsonObject = new JSONObject(response);
                                    String message=jsonObject.getString("msg");
                                    SharedPreferences mSharedPreferences = getContext().getSharedPreferences("PREFS_NAME", 0);
                                    if (mSharedPreferences != null)
                                        mSharedPreferences.edit().remove("jsonarray").commit();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Error" + error, Toast.LENGTH_SHORT).show();

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
                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                requestQueue.add(stringRequest);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }catch (NullPointerException e){

        }





        SharedPreferences prefs =  getContext().getSharedPreferences("arraydata", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("jsonobject", null);
        try {
            if (json.isEmpty()) {

            } else {
                Type type = new TypeToken<ArrayList<String>>() {
                }.getType();
                article = gson.fromJson(json, type);

                Log.v("shalu", String.valueOf(article.size()));
                for (int i = 0; i <= article.size(); i++) {
                    try {
                        JSONObject jsonObject = new JSONObject(article.get(i));
                        new SendData(getContext(), jsonObject, UrlClass.UPLOAD_SIGN_URL, new OnTaskCompleted<String>() {
                            @Override
                            public void onTaskCompleted(String response) {
                                Log.d("Post Response", response);
                                try {
                                    JSONObject object = new JSONObject(response);


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Log.d("PostSignature", e.toString());
                                }

                            }
                        }, true).execute();

                    } catch (Exception e) {

                    }
                }

                SharedPreferences mSharedPreferences =getContext().getSharedPreferences("arraydata", 0);
                if (mSharedPreferences != null)
                    mSharedPreferences.edit().remove("jsonobject").commit();
                article.clear();
                LoginActivity.jsonObjects.clear();


            }
        }catch (NullPointerException e ){

        }




        boolean isConnected = ConnectivityReceiver.isConnected();
          if (isConnected == true) {
              if (LoginActivity.value == 0) {

                      showProgressPopup();
                      new GetApiCallback(getActivity(), UrlClass.GET_WORKORDER_URL + role + "&companyid=" + companyId, new OnTaskCompleted<String>() {
                          @Override
                          public void onTaskCompleted(String response) {
                              Log.d("ResponseWorkOrder", response);
                              try {

                                  yesButton.setVisibility(View.VISIBLE);
                                  img.setVisibility(View.VISIBLE);
                                  progressbar.setVisibility(View.GONE);
                                  titleText.setText("Download Completed");
                                  Log.d("Url", UrlClass.GET_ALL_TASK_URL);
                /*    JSONArray jsonArray=new JSONArray(response);
                    Log.d("SingleResponse",jsonArray.get(0).toString());*/
                                  Constants.workOrderPOJOList = Arrays.asList(new Gson().fromJson(response, WorkOrderPOJO[].class));
                                  PrefManager.saveworkorder(getActivity(), Constants.workOrderPOJOList);
                                  syncronizedHomeAdapter = new SyncronizedHomeAdapter(getActivity(), Constants.workOrderPOJOList, workorderno);
                                  mrecyclerView.setAdapter(syncronizedHomeAdapter);
                                  Constants.TASK_ID = "" + Constants.workOrderPOJOList.get(0).getAssessmentTaskId();
                                  // assesmentHomePOJO=Constants.assesmentHomePOJOList.get(0);
                                  LoginActivity.value = 1;

                              } catch (Exception e) {

                              }

                          }
                      }, true).execute();
                  }else {
                  syncronizedHomeAdapter = new SyncronizedHomeAdapter(getActivity(), Constants.workOrderPOJOList, workorderno);
                  mrecyclerView.setAdapter(syncronizedHomeAdapter);
              }
          }else {
            //  Constants.workOrderPOJOList=PrefManager.getsaveworkorder(getActivity());
              syncronizedHomeAdapter = new SyncronizedHomeAdapter(getActivity(), Constants.workOrderPOJOList, workorderno);
              mrecyclerView.setAdapter(syncronizedHomeAdapter);
          }



      //  fetchData();


        return rootView;
    }
    public void init(View rootView) {

        mrecyclerView = rootView.findViewById(R.id.rv_sync_task_list);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       // progressDialog = new ProgressDialog(getActivity(),R.style.AppCompatAlertDialogStyle);
    }
    AssesmentHomePOJO assesmentHomePOJO;


    public void showProgressPopup() {
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.prog_dialog_layout);
        yesButton = dialog.findViewById(R.id.btn_ok);
        titleText = dialog.findViewById(R.id.txt_title);
        img = dialog.findViewById(R.id.img_ok);
        progressbar = dialog.findViewById(R.id.progressbar);
        yesButton.setText("OK");
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
   /* public void fetchData()
    {
        showProgressPopup();
        SearchRequestModel searchRequestModel = new SearchRequestModel();
        searchRequestModel.setTitle("");
        searchRequestModel.setAssigenTo("");
        searchRequestModel.setFromDate("");
        searchRequestModel.setToDate("");
        preferenceManager = PreferenceManager.getInstance(getActivity());
        searchRequestModel.setUserName(preferenceManager.getUsername());
        ApiServices apiServices = Network.getInstance().getApiServices();
        final Call<List<SearchTaskListResponseModel>> loginResponseCall =
                apiServices. postAllTask( "Bearer " + preferenceManager.getSessionToken(),"application/json", searchRequestModel);
        loginResponseCall.enqueue(new Callback<List<SearchTaskListResponseModel>>() {
            @Override
            public void onResponse(Call<List<SearchTaskListResponseModel>> call, Response<List<SearchTaskListResponseModel>> response) {
                try {
                    // TODO NULL CHECK OF RESPONSE
                    if (response.body() != null) {
                        responseModel = response.body();
                        callAfterResponse(responseModel);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                yesButton.setVisibility(View.VISIBLE);
                                img.setVisibility(View.VISIBLE);
                                progressbar.setVisibility(View.GONE);
                                titleText.setText("Download Completed");
                            }
                        }, 1000);
                        progressDialog.dismiss();
                    } else {
                        Toast.makeText(getActivity(), response.errorBody().string().toString(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }

                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<List<SearchTaskListResponseModel>> call, Throwable t) {
                t.printStackTrace();
                System.out.println(t.getMessage() + t.getLocalizedMessage());
                Toast.makeText(getActivity(), "failure" + t.getMessage() + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });


    }
    public void callAfterResponse(List<SearchTaskListResponseModel> response) {
        adapter = new RVSyncTaskListAdapter(getActivity(), response);
        mrecyclerView.setAdapter(adapter);
        adapter.setClicklistner(this);




    }
    @Override
    public void taskClick(Integer position) {
        Bundle bundle = new Bundle();
        bundle.putInt("taskId", responseModel.get(position).getTaskID());
        TaskDetailFragment fragment = new TaskDetailFragment();
        fragment.setArguments(bundle);
        Toast.makeText(getContext(), ""+responseModel.get(position).getStatus(), Toast.LENGTH_SHORT).show();
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container, fragment, null).addToBackStack(null).commit();
    }*/
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Sync Data");

    }

    public void callCheckOnSiteApi() {
        new GetApiCallback(getContext(), UrlClass.CHECK_ON_SITE_URL + Constants.loginPOJO.getPersonCompanyId(), new OnTaskCompleted<String>() {
            @Override
            public void onTaskCompleted(String response) {
                try {
                    Log.d("CheckStatusResponse", response);
                    Constants.homeStatusPOJO = new Gson().fromJson(response, HomeStatusPOJO.class);
                    if (Constants.homeStatusPOJO.getStatus().equals("On-Site")) {
                        tv_go_on_site.setText(Constants.homeStatusPOJO.getStatus());
                        tv_go_on_site.setBackgroundDrawable(getResources().getDrawable(R.drawable.go_on_site_bg_design));
                        tv_go_on_site.setEnabled(true);
                        workorderno=Constants.homeStatusPOJO.getWorkOrderNo();

                    } else if (Constants.homeStatusPOJO.getStatus().equals("Off-Site")) {
                        tv_go_on_site.setText("Off-Site");
                        tv_go_on_site.setBackgroundDrawable(getResources().getDrawable(R.drawable.go_off_site_design));
                        tv_go_on_site.setEnabled(false);
                        workorderno="";
                    }
                } catch (Exception e) {
                    Log.d("Exception", e.toString());
                }

            }
        }, true).execute();
    }


}
