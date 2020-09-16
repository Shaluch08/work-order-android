package com.workorder.app.workorderapplication.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import com.workorder.app.workorderapplication.adapter.ClientAdapter;
import com.workorder.app.workorderapplication.model.clientList.ClientListResponse;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Client extends AppCompatActivity implements ClickListener {
    RecyclerView recycler_View;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String rolename,AssetId,companyid,Id;
    ClientAdapter adapter;
    SearchView searchView;
    List<ClientListResponse> responseList;
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    ProgressDialog progressDoalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        /*if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Client")){
            ArrayList<ClientListResponse> list= (ArrayList<ClientListResponse>) getIntent().getSerializableExtra("list");
            responseList=list;
        }*/

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ClientContract");
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }

        recycler_View=(RecyclerView) findViewById(R.id.recycler_client);
        recycler_View.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        searchView=(SearchView) findViewById(R.id.search_client);
        searchView.setFocusableInTouchMode(false);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
              //   adapter.getFilter().filter(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename= preferenceManagerWorkOrder.getKey_User_Name();
        progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Extracting and Transferring Data Please Wait...");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);


        fetchGetClient();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.menu_refresh:
                progressDoalog = new ProgressDialog(Client.this);
                progressDoalog.setMessage("Page Refreshing");
                progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDoalog.show();
                progressDoalog.setCanceledOnTouchOutside(false);
                onRestart();
                finish();
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
    public void callAfterResponse(List<ClientListResponse> responses){
        adapter = new ClientAdapter(responses,this);
        recycler_View.setAdapter(adapter);
        adapter.setClicklistener(this);
        adapter.notifyDataSetChanged();
        progressDoalog.dismiss();
    }
    public void fetchGetClient()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            progressDoalog.show();
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
            final Call<List<ClientListResponse>> workOrderResponseModelCall= apiServicesWorkOrder.clientList("application/json","api/order/getclient?companyid="+ preferenceManagerWorkOrder.getKey_Person_Company_Id());
            workOrderResponseModelCall.enqueue(new Callback<List<ClientListResponse>>() {
                @Override
                public void onResponse(Call<List<ClientListResponse>> call, Response<List<ClientListResponse>> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if(response.body()!=null)
                        {
                            responseList=response.body();
                            Id= String.valueOf(response.body().get(0).getId());
                            Log.d("Id",Id);
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
                            callAfterResponse(responseList);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), response.errorBody().string().toString(), Toast.LENGTH_LONG).show();
                            progressDoalog.dismiss();
                        }

                    }catch (Exception e)
                    {
                        Log.v("Exception",e.toString());
                        progressDoalog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<List<ClientListResponse>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                    progressDoalog.dismiss();
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void editClick(Integer position) {
        Bundle bundle=new Bundle();
        bundle.putString("Id", String.valueOf(responseList.get(position).getId()));
        Intent intent=new Intent(Client.this,WorkOrderListClientWise.class);
        intent.putExtras(bundle);
        startActivity(intent);
     //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    @Override
    public void deleteClick(Integer position) {

    }

    @Override
    public void addWorker(Integer position) {

    }

    @Override
    public void materialClickListener(Integer position) {

    }

    @Override
    public void historyClickListener(Integer position) {

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        Intent i = new Intent(Client.this, Client.class);  //your class
        startActivity(i);
        finish();

    }

}
