package com.workorder.app.workorderapplication.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.workorderapplication.adapter.HistoryAdapter;
import com.workorder.app.workorderapplication.adapter.HistoryDetailsAdapter;
import com.workorder.app.workorderapplication.adapter.HistoryDetalisClick;
import com.workorder.app.workorderapplication.model.history.HistoryModel;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class History extends AppCompatActivity {
    RecyclerView recyclerView;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String rolename,companyid;
    String WorkOrderId,AssetId;
    HistoryAdapter adapter;
    List<HistoryModel> historyModels;
    ProgressDialog progressDoalog;
    TextView ErrormsgHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("History");
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }
        Bundle intent=getIntent().getExtras();
        if(intent!=null)
        {
            WorkOrderId=intent.getString("WorkOrderId");
             AssetId=intent.getString("AssetId");
        }
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename= preferenceManagerWorkOrder.getKey_User_Name();
        recyclerView=(RecyclerView) findViewById(R.id.recycler_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        ErrormsgHistory=(TextView) findViewById(R.id.tvErrormsgHistory);

        progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Extracting and Transferring Data Please Wait...");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        if(WorkOrderId!=null) {
            fetchHistoryWorkOrder(WorkOrderId);
        }
        else if(AssetId!=null)
        {
            fetchHistoryAsset(AssetId);
        }

    }
    private void fetchHistoryAsset(String AssetId)
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            progressDoalog.show();
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
            final Call<List<HistoryModel>> workOrderResponseModelCall= apiServicesWorkOrder.historyAssetList("application/json","api/assets/GetAuditHistoryDetailsAsset?ID="+AssetId+"&asset=asset");
            workOrderResponseModelCall.enqueue(new Callback<List<HistoryModel>>() {
                @Override
                public void onResponse(Call<List<HistoryModel>> call, Response<List<HistoryModel>> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if(response.body()!=null)
                        {
                            historyModels=response.body();
                            if(historyModels.size()==0)
                            {
                                ErrormsgHistory.setText("No History Found!!!");

                            }else{
                                callAfterResponse(historyModels);
                            }
                           // progressDoalog.dismiss();

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
                public void onFailure(Call<List<HistoryModel>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                    progressDoalog.dismiss();
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
           // progressDoalog.dismiss();
        }
    }
    private void fetchHistoryWorkOrder(String WorkOrderId) {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            progressDoalog.show();
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
            final Call<List<HistoryModel>> workOrderResponseModelCall= apiServicesWorkOrder.historyWOList("application/json","api/order/GetAuditHistoryDetails?Id="+WorkOrderId+"&worder=worder");
            workOrderResponseModelCall.enqueue(new Callback<List<HistoryModel>>() {
                @Override
                public void onResponse(Call<List<HistoryModel>> call, Response<List<HistoryModel>> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if(response.body()!=null)
                        {
                            historyModels=response.body();
                            Handler handler=new Handler();
                            handler.post(new Runnable()
                            {
                                public void run()
                                {
                                    try {
                                        // code to execute
                                        Thread.sleep(9000);
                                    } catch (Exception e) {

                                    }

                                }
                            });
                            if(historyModels.size()==0)
                            {
                                ErrormsgHistory.setText("No History Found!!!");
                                ErrormsgHistory.setVisibility(View.VISIBLE);
                            }else{
                                callAfterResponse(historyModels);
                                //progressDoalog.dismiss();
                            }
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
                public void onFailure(Call<List<HistoryModel>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
          //  progressDoalog.dismiss();
        }
    }

    public void callAfterResponse(List<HistoryModel> list)
    {
        adapter=new HistoryAdapter(getApplicationContext(),list);
        recyclerView.setAdapter(adapter);
        adapter.setClicklistener(new HistoryDetalisClick() {
            @Override
            public void historyDetailsClickListener(Integer position) {
                int Id=historyModels.get(position).getId();
                Bundle bundle=new Bundle();
                bundle.putString("AuditId", String.valueOf(Id));
                Intent intent=new Intent(History.this,HistoryDetails.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        adapter.notifyDataSetChanged();
        progressDoalog.dismiss();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem refresh = menu.findItem(R.id.menu_refresh);
            refresh.setVisible(false);
        if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Contractor")) {
            /*MenuItem refresh = menu.findItem(R.id.menu_refresh);
            refresh.setVisible(false);*/
            MenuItem m_asset = menu.findItem(R.id.menu_asset);
            m_asset.setVisible(false);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            /*case R.id.menu_refresh:
                Toast.makeText(this, "Refresh", Toast.LENGTH_LONG).show();
                progressDoalog = new ProgressDialog(History.this);
                progressDoalog.setMessage("Page Refreshing");
                progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDoalog.show();
                progressDoalog.setCanceledOnTouchOutside(false);
                onRestart();
                return true;*/

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

  /*  @Override
    public void historyDetailsClickListener(Integer position) {
        Intent intent =new Intent(this,HistoryDetails.class);
        intent.putExtra("sfd",historyModels.get(position));
        startActivity(intent);
    }*/

   /* @Override
    protected void onRestart() {

        super.onRestart();
        Intent i = new Intent(History.this, History.class);  //your class
        startActivity(i);
       finish();

    }*/
}
