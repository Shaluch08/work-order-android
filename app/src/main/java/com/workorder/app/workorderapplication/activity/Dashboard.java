package com.workorder.app.workorderapplication.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.workorderapplication.model.dashboardModel.DashBoardResponse;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.DashBoardContractor;
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

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DashBoardResponse responses;
    ArrayList<Treestuctutr> list;
    public List<WorkOrderResponseModel> myTaskList;
    CardView cardtree,cardcomp,cardasset,cardwork,cardpo;
    TextView user,role;
    TextView company_number,asset_number,purchase_number,work_number,
            company_name,asset_name,purchase_name,work_name;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    ArrayList<ContrctTree> contrctTreeList;
    DashBoardContractor dashContractors;
    ProgressDialog progressDoalog;
    LinearLayout linearLayout;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DashBoard");
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
        company_name=(TextView) findViewById(R.id.company_Name);
        asset_name=(TextView) findViewById(R.id.asset_Name);
        purchase_name=(TextView) findViewById(R.id.purchase_Name);
        work_name=(TextView) findViewById(R.id.work_Name);
        company_number=(TextView) findViewById(R.id.company_Number);
        company_number.setVisibility(View.INVISIBLE);
        asset_number=(TextView) findViewById(R.id.asset_Number);
        purchase_number=(TextView) findViewById(R.id.purchase_Number);
        work_number=(TextView) findViewById(R.id.work_Number);
        user=(TextView) findViewById(R.id.user_name);
        role=(TextView) findViewById(R.id.user_role);
        user.setText(preferenceManagerWorkOrder.getKey_User_Name());
        role.setText(preferenceManagerWorkOrder.getKey_User_Role());

        cardasset=(CardView)findViewById(R.id.card_view_asset);
        cardasset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    Intent intent=new Intent(Dashboard.this,SearchAsset.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                  //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
                    Intent intent=new Intent(Dashboard.this,SearchAsset.class);
                    intent.putExtra("contrctTreeList",contrctTreeList);
                    startActivity(intent);
                  //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            }
        });

        cardtree=(CardView)findViewById(R.id.card_view_tree);
        cardtree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    Intent intent=new Intent(Dashboard.this,TreeStructure.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                //    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
                    Intent intent=new Intent(Dashboard.this,TreeStructure.class);
                    intent.putExtra("contrctTreeList",contrctTreeList);
                    startActivity(intent);
                 //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

             }
        });
        cardcomp=(CardView)findViewById(R.id.card_view_comp);
        cardcomp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "All Company", Toast.LENGTH_SHORT).show();
            }
        });
        cardpo=(CardView)findViewById(R.id.card_view_po);
        cardpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    Intent intent=new Intent(Dashboard.this,SearchPurchaseOrder.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                 //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
                    Intent intent=new Intent(Dashboard.this,SearchPurchaseOrder.class);
                    intent.putExtra("contrctTreeList",contrctTreeList);
                    startActivity(intent);
                //    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            }
        });


        cardwork=(CardView)findViewById(R.id.card_view_work);
        cardwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    Intent intent=new Intent(Dashboard.this,SearchWorkOrder.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                  //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
                    Intent intent=new Intent(Dashboard.this,SearchWorkOrder.class);
                    intent.putExtra("contrctTreeList",contrctTreeList);
                    startActivity(intent);
                   // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                else if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker"))
                {
                    Intent intent=new Intent(Dashboard.this,SearchWorkOrder.class);
                    startActivity(intent);
                  //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

            }
        });
        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager")){
            fetchDashBoardListFM();
        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")) {
            fetchDashBoardListContractor();
        }
        else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker")){
            fetchDashBoardListFM();
        }
        progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Extracting and Transferring Data Please Wait...");
        progressDoalog.setTitle("Welcome to "+ preferenceManagerWorkOrder.getKey_User_Name());
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();
    }

    private void fetchDashBoardListContractor() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
           //api/home/linktree?rolename=Super%20Administrator&companyid=319896&parentcompanyid=319895
            final Call<DashBoardContractor> workOrderResponseModelCall= apiServicesWorkOrder.dashBoardListContractor("application/json","api/home/linktree?rolename="+ preferenceManagerWorkOrder.getKey_User_Role()+"&companyid="+ preferenceManagerWorkOrder.getKey_Person_Company_Id()+"&parentcompanyid="+ preferenceManagerWorkOrder.getKey_Parent_Company_Id());
            workOrderResponseModelCall.enqueue(new Callback<DashBoardContractor>() {
                @Override
                public void onResponse(Call<DashBoardContractor> call, Response<DashBoardContractor> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if(response.body()!=null)
                        {
                            dashContractors=response.body();
                            company_number.setText(String.valueOf(dashContractors.getCompanycoubt()));
                            purchase_number.setText(String.valueOf(dashContractors.getPurchaseorderount()));
                            asset_number.setText(String.valueOf(dashContractors.getAssetcount()));
                          //  work_number.setText(String.valueOf(dashContractors.getWordercount()));
                             contrctTreeList= (ArrayList<ContrctTree>) dashContractors.getTreestuctutr();
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
                public void onFailure(Call<DashBoardContractor> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void fetchDashBoardListFM()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());//api/home/linktree?rolename=Super%20Administrator&companyid=319896&parentcompanyid=319895
            final Call<DashBoardResponse> workOrderResponseModelCall= apiServicesWorkOrder.dashBoardListFm("application/json","api/home/linktree?rolename="+ preferenceManagerWorkOrder.getKey_User_Role()+"&companyid="+ preferenceManagerWorkOrder.getKey_Person_Company_Id()+"&parentcompanyid="+ preferenceManagerWorkOrder.getKey_Parent_Company_Id());
            workOrderResponseModelCall.enqueue(new Callback<DashBoardResponse>() {
                @Override
                public void onResponse(Call<DashBoardResponse> call, Response<DashBoardResponse> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if(response.body()!=null)
                        {
                            responses=response.body();
                            company_number.setText(String.valueOf(responses.getCompanycoubt()));
                            purchase_number.setText(String.valueOf(responses.getPurchaseorderount()));
                            asset_number.setText(String.valueOf(responses.getAssetcount()));
                            work_number.setText(String.valueOf(responses.getWordercount()));
                            list= (ArrayList<Treestuctutr>) responses.getTreestuctutr();
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
                public void onFailure(Call<DashBoardResponse> call, Throwable t) {
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
        if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Contractor")){

            MenuItem m_asset = menu.findItem(R.id.menu_asset);
            m_asset.setVisible(false);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_dashboard:
                Toast.makeText(this, "DashBoard", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                return true;
            case R.id.menu_asset:
                Toast.makeText(this, "Asset", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),SearchAsset.class));
                return true;
            case R.id.menu_about_us:
                Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_work_order:
                Toast.makeText(this, "Work Order", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),SearchWorkOrder.class));
                return true;
            case R.id.menu_logout:
                startActivity(new Intent(this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_purchase_order:
                Toast.makeText(this, "Purchase Order", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        int id = item.getItemId();
        if (id == R.id.nav_dashboard) {
            // Handle the camera action
            startActivity(new Intent(Dashboard.this, Dashboard.class));
        } else if (id == R.id.nav_asset) {
            startActivity(new Intent(Dashboard.this, SearchAsset.class));
        } else if (id == R.id.nav_purchase_order) {
            startActivity(new Intent(Dashboard.this, SearchPurchaseOrder.class));
        } else if (id == R.id.nav_work_order) {
            Intent intent=new Intent(Dashboard.this, SearchWorkOrder.class);
            startActivity(intent);
        }else  if(id== R.id.nav_client_list)
        {
            startActivity(new Intent(Dashboard.this,Client.class));
        }
        else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(Dashboard.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            finish();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
