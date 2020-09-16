package com.workorder.app.workorderapplication.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.workorderapplication.adapter.ClickListener;
import com.workorder.app.workorderapplication.adapter.WorkerListAdapter;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderResponseModel;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkerSearchList extends AppCompatActivity {
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    List<WorkOrderResponseModel> workOrderResponseModel;
    ArrayList<WorkOrderResponseModel> arrayList;
    ProgressDialog progressDialog;
    TextView user,role;
    WorkerListAdapter adapter;
    ProgressDialog progressDoalog;
    Dialog dialog;
    String WorkOrderId;


    android.support.v7.widget.Toolbar workertoolbar;

    android.support.v7.widget.SearchView searchView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_search_list);



        workertoolbar= (android.support.v7.widget.Toolbar) findViewById(R.id.workertoolbar);
        setSupportActionBar(workertoolbar);
        getSupportActionBar().setTitle("Work Order List");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            workertoolbar.setTitleTextColor(getResources().getColor(R.color.white));
            workertoolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }


       /* if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }*/
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker")){
            ArrayList<WorkOrderResponseModel> list= (ArrayList<WorkOrderResponseModel>) getIntent().getSerializableExtra("list");
            arrayList=list;

        }

        user=(TextView) findViewById(R.id.user_name);
        role=(TextView) findViewById(R.id.user_role);
        user.setText(preferenceManagerWorkOrder.getKey_User_Name());
        role.setText(preferenceManagerWorkOrder.getKey_User_Role());
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.prog);
        dialog.setCancelable(false);
        dialog.show();



        recyclerView=(RecyclerView) findViewById(R.id.recyclerSerarchList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
        searchView= (android.support.v7.widget.SearchView) findViewById(R.id.search_worker);
        searchView.setFocusableInTouchMode(false);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        fetchWorkOrderList();


    }

    public void callAfterResponse(List<WorkOrderResponseModel> response) {
        if(getApplicationContext()!=null) {
            adapter = new WorkerListAdapter(this, response);
            recyclerView.setAdapter(adapter);
            adapter.setClicklistener((ClickListener) this);
            adapter.notifyDataSetChanged();
        }
    }


    public void fetchWorkOrderList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
            /*final Call<List<WorkOrderResponseModel>> workOrderResponseModelCall=apiServicesWorkOrder.workerlist("application/json","api/order/orderlist?rolename="+preferenceManagerWorkOrder.getKey_User_Role()+"&companyid="+preferenceManagerWorkOrder.getKey_Person_Company_Id());*/
            final Call<List<WorkOrderResponseModel>> workOrderResponseModelCall = apiServicesWorkOrder.workerlist("application/json","api/order/orderlist?rolename="+ preferenceManagerWorkOrder.getKey_User_Role()+"&companyid="+ preferenceManagerWorkOrder.getKey_Person_Company_Id());
            workOrderResponseModelCall.enqueue(new Callback<List<WorkOrderResponseModel>>() {
                @Override
                public void onResponse(Call<List<WorkOrderResponseModel>> call, Response<List<WorkOrderResponseModel>> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if(response.body()!=null)
                        {
                            workOrderResponseModel=response.body();

                            Handler handler=new Handler();
                            handler.post(new Runnable()
                            {
                                public void run()
                                {
                                    try {
                                        // code to execute
                                        Thread.sleep(3000);
                                    } catch (Exception e) {

                                    }
                                    /*progressDialog.dismiss();*/
                                    dialog.dismiss();
                                }
                            });



                            callAfterResponse(workOrderResponseModel);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), response.errorBody().string().toString(), Toast.LENGTH_SHORT).show();
                        }

                    }catch (Exception e)
                    {
                        Log.v("Exception",e.toString());
                    }
                }

                @Override
                public void onFailure(Call<List<WorkOrderResponseModel>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem dashboard = menu.findItem(R.id.menu_dashboard);
        dashboard.setVisible(false);
        MenuItem m_asset = menu.findItem(R.id.menu_asset);
        m_asset.setVisible(false);
        MenuItem m_about_us = menu.findItem(R.id.menu_about_us);
        m_about_us.setVisible(false);
        MenuItem m_purchase_order = menu.findItem(R.id.menu_purchase_order);
        m_purchase_order.setVisible(false);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle item selection
        switch (item.getItemId()) {

            case R.id.menu_refresh:
                /*Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();*/
                progressDoalog = new ProgressDialog(WorkerSearchList.this);
                progressDoalog.setMessage("Page Refreshing");
                progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDoalog.show();
                progressDoalog.setCanceledOnTouchOutside(false);
                onRestart();
                return true;



            case R.id.menu_work_order:
                Toast.makeText(this, "Work Order", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),WorkerSearchList.class));
                return true;
            case R.id.menu_logout:
                startActivity(new Intent(WorkerSearchList.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
                Toast.makeText(this, "Logout", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
   /* @Override
    protected void onRestart() {

        super.onRestart();
        Bundle bundle = new Bundle();
        bundle.putString("workOrderId", WorkOrderId);
        Intent i = new Intent(WorkerSearchList.this, WorkerSearchList.class);
        startActivity(i);
        finish();

    }*/

}
