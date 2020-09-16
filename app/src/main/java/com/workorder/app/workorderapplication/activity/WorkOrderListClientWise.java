package com.workorder.app.workorderapplication.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.workorderapplication.adapter.ClickListener;
import com.workorder.app.workorderapplication.adapter.ListWorkOrderAdapter;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
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

public class WorkOrderListClientWise extends AppCompatActivity implements ClickListener {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    List<WorkOrderResponseModel> responseModel;
    String role1;
    String rolename,WorkOrderId,companyid;
    FloatingActionButton fab;
    SearchView searchView;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    RecyclerView recyclerView;
    ListWorkOrderAdapter adapter;
    String Id;
    ProgressDialog progressDoalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_list_client_wise);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Wo rk Order List");
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }


        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename= preferenceManagerWorkOrder.getKey_User_Role();
        recyclerView=(RecyclerView) findViewById(R.id.recycler_work_order);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        searchView=(SearchView) findViewById(R.id.search_work);
        searchView.setFocusableInTouchMode(false);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

        progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Extracting and Transferring Data Please Wait...");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        Bundle intent=getIntent().getExtras();
        if(intent!=null)
        {
            Id=intent.getString("Id");
            Log.d("ClientWiseId",Id);
            progressDoalog.show();
            fetchWorkOrderList();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Client")){

            MenuItem m_asset = menu.findItem(R.id.menu_asset);
            m_asset.setVisible(false);
            MenuItem m_workorder = menu.findItem(R.id.menu_work_order);
            m_workorder.setVisible(false);
            MenuItem m_dashboard = menu.findItem(R.id.menu_dashboard);
            m_dashboard.setVisible(false);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.menu_refresh:
                progressDoalog = new ProgressDialog(WorkOrderListClientWise.this);
                progressDoalog.setMessage("Page Refreshing");
                progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDoalog.show();
                progressDoalog.setCanceledOnTouchOutside(false);
                onRestart();
                return true;

            case R.id.menu_dashboard:
                Toast.makeText(this, "DashBoard", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                return true;
            case R.id.menu_asset:
                Toast.makeText(this, "Asset", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),SearchAsset.class));
                return true;
            case R.id.menu_about_us:
                Toast.makeText(this, "About Us", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_work_order:
                Toast.makeText(this, "Work Order", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),SearchWorkOrder.class));
                return true;
            case R.id.menu_logout:
                startActivity(new Intent(this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
                Toast.makeText(this, "Logout", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_purchase_order:
                Toast.makeText(this, "Purchase Order", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),SearchPurchaseOrder.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void callAfterResponse(List<WorkOrderResponseModel> response) {
        if(getApplicationContext()!=null) {
            adapter = new ListWorkOrderAdapter(this, response);
            recyclerView.setAdapter(adapter);
            adapter.setClicklistener(this);
            adapter.notifyDataSetChanged();
        }
    }
    public void fetchWorkOrderList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
            final Call<List<WorkOrderResponseModel>> workOrderResponseModelCall= apiServicesWorkOrder.workOrderList("application/json","api/order/workorderlistbyclient?ContrectorId="+Id);
            workOrderResponseModelCall.enqueue(new Callback<List<WorkOrderResponseModel>>() {
                @Override
                public void onResponse(Call<List<WorkOrderResponseModel>> call, Response<List<WorkOrderResponseModel>> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if(response.body()!=null)
                        {
                            responseModel=response.body();
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
                                    progressDoalog.dismiss();
                                }
                            });
                            callAfterResponse(responseModel);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), response.errorBody().string().toString(), Toast.LENGTH_LONG).show();
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
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void editClick(Integer position) {
        Bundle bundle=new Bundle();
        bundle.putString("WorkOrderId",responseModel.get(position).getWorkOrderId());
        Intent intent=new Intent(WorkOrderListClientWise.this,UpdateWorkOrder.class);
        intent.putExtras(bundle);
        startActivity(intent);
     //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void deleteClick(final Integer position) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete?");
        //Setting message manually and performing action on button click
        builder.setMessage("Are you sure to delete this item?");
        //This will not allow to close dialogbox until user selects an option
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(WorkOrderListClientWise.this, "Delete", Toast.LENGTH_LONG).show();
                WorkOrderId=responseModel.get(position).getWorkOrderId();
                deleteWorkOrder();
                startActivity(getIntent());
                finish();
                //builder.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //  Action for 'NO' Button
                Toast.makeText(WorkOrderListClientWise.this, "Cancel", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        //alert.setTitle("AlertDialogExample");
        alert.show();
    }


    @Override
    public void addWorker(Integer position) {

    }

    @Override
    public void materialClickListener(Integer position) {

    }

    @Override
    public void historyClickListener(Integer position) {
        String woId=responseModel.get(position).getWorkOrderId();
        Bundle bundle=new Bundle();
        bundle.putString("WorkOrderId",woId);
        Intent intent=new Intent(WorkOrderListClientWise.this,History.class);
        intent.putExtras(bundle);
        startActivity(intent);
     //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    private void deleteWorkOrder()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<String> deleteWorkOrder= apiServicesWorkOrder.delete("application/json","api/order/DeleteWorkOrderDetails?WorkOrderId="+WorkOrderId+"&CompanyId="+companyid);
            deleteWorkOrder.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.body()!=null)
                    {
                        String result=response.body();
                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }

  /*  protected void onRestart() {

        super.onRestart();
        Intent i = new Intent(WorkOrderListClientWise.this, WorkOrderListClientWise.class);  //your class
        startActivity(i);
        finish();

    }*/

}


