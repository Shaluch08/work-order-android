package com.workorder.app.workorderapplication.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;

import com.workorder.app.activity.LoginActivity;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.workorderapplication.model.dashboardModel.AdminTreeStructure;
import com.workorder.app.workorderapplication.model.dashboardModel.ClientList;
import com.workorder.app.workorderapplication.model.dashboardModel.ClientTreeStructure;
import com.workorder.app.workorderapplication.model.dashboardModel.DashBoardAdmin;
import com.workorder.app.workorderapplication.model.dashboardModel.DashBoardResponse;
import com.workorder.app.workorderapplication.model.dashboardModel.DashboardClient;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ClientContract;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.DashBoardContractor;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DashBoardResponse responses;
    ClientList dashboardClientlist;
    Demo demo;
    DashboardClient dashboardClient;
    CardView cardtree,cardcomp,cardasset,cardwork,cardpo;
    TextView user,role;
    Dialog dialog;
    TextView company_number,asset_number,purchase_number,work_number,
            company_name,asset_name,purchase_name,work_name;

    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    ArrayList<Treestuctutr> list;
    ClientContract clientContract;
    public static ArrayList<ClientTreeStructure> clientlist;
    ArrayList<ContrctTree> contrctTreeList;
    DashBoardContractor dashContractors;
    ProgressDialog progressDoalog;
    Context mContext;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_work_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        //Constants.loginPOJO=PreferenceManagerWorkOrder.GetLoginData(this);


        navigationView.setNavigationItemSelectedListener(this);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        user=(TextView) findViewById(R.id.user_name);
        role=(TextView) findViewById(R.id.user_role);

        user.setText(preferenceManagerWorkOrder.getKey_User_Name());

        role.setText(preferenceManagerWorkOrder.getKey_User_Role());

         /*if (preferenceManagerWorkOrder.getKey_User_Role().equals("Administrator"))
         {
             preferenceManagerWorkOrder.setKey_User_Role("Finance Manager");
         }*/
        company_number=(TextView) findViewById(R.id.company_Number);
        asset_number=(TextView) findViewById(R.id.asset_Number);
        purchase_number=(TextView) findViewById(R.id.purchase_Number);
        work_number=(TextView) findViewById(R.id.work_Number);
        cardasset=(CardView)findViewById(R.id.card_view_asset);

        if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker")){

            Menu menu = navigationView.getMenu();
            menu.findItem(R.id.nav_purchase_order).setVisible(false);
            menu.findItem(R.id.nav_asset).setVisible(false);
            menu.findItem(R.id.nav_client_list).setVisible(false);
            menu.findItem(R.id.nav_swms_list).setVisible(true);

        }else if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){

            Menu menu = navigationView.getMenu();
            menu.findItem(R.id.nav_swms_list).setVisible(false);
            menu.findItem(R.id.nav_purchase_order).setVisible(false);
            menu.findItem(R.id.nav_asset).setVisible(false);
            menu.findItem(R.id.nav_client_list).setVisible(false);

        }else if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Client")){

            Menu menu = navigationView.getMenu();
            menu.findItem(R.id.nav_client_list).setVisible(false);
            menu.findItem(R.id.nav_dashboard).setVisible(false);
            menu.findItem(R.id.nav_asset).setVisible(false);
            menu.findItem(R.id.nav_purchase_order).setVisible(false);
            menu.findItem(R.id.nav_swms_list).setVisible(false);

        }else {
            Menu menu = navigationView.getMenu();
            menu.findItem(R.id.nav_swms_list).setVisible(false);
        }

        cardasset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    Intent intent=new Intent(MainActivity.this,SearchAsset.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                  //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){

                    Intent intent=new Intent(MainActivity.this,SearchAsset.class);
                    intent.putExtra("contrctTreeList",contrctTreeList);
                    startActivity(intent);
                  //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }else if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Client")){

                    Intent intent=new Intent(MainActivity.this,SearchAsset.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                  //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else {
                    Intent intent=new Intent(MainActivity.this,SearchAsset.class);
                    intent.putExtra("list",adminTreeStructures);
                    startActivity(intent);
                }
            }
        });

        cardtree=(CardView)findViewById(R.id.card_view_tree);

        cardtree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    Intent intent=new Intent(MainActivity.this,TreeStructure.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                //    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){

                    Intent intent=new Intent(MainActivity.this,TreeStructure.class);
                    intent.putExtra("contrctTreeList",contrctTreeList);
                    startActivity(intent);
                 //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Client")){
                    Intent intent=new Intent(MainActivity.this,TreeStructure.class);
                    intent.putExtra("clientlist",clientlist);
                    startActivity(intent);
                   try{
                    //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                   }catch (Exception e){
                       e.printStackTrace();
                   }
                }else {
                    Intent intent=new Intent(MainActivity.this,TreeStructure.class);
                    intent.putExtra("adminlist",adminTreeStructures);
                    startActivity(intent);
                }
            }
        });

        cardcomp=(CardView)findViewById(R.id.card_view_comp);
        cardcomp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "All Company", Toast.LENGTH_SHORT).show();;
            }
        });

        cardpo=(CardView)findViewById(R.id.card_view_po);
        cardpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    Intent intent=new Intent(MainActivity.this,SearchPurchaseOrder.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                  //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){

                    Intent intent=new Intent(MainActivity.this,SearchPurchaseOrder.class);
                    intent.putExtra("contrctTreeList",contrctTreeList);
                    startActivity(intent);
                  //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Client")){

                    Intent intent=new Intent(MainActivity.this,SearchPurchaseOrder.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                   // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else {
                    Intent intent=new Intent(MainActivity.this,SearchPurchaseOrder.class);
                    intent.putExtra("adminlist",adminTreeStructures);
                    startActivity(intent);
                }
            }
        });

        if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Contractor")){
            cardpo.setEnabled(false);
            cardasset.setEnabled(false);


        }else if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Client")){
            cardtree.setVisibility(View.VISIBLE);
        }

        cardwork=(CardView)findViewById(R.id.card_view_work);
        cardwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    Intent intent=new Intent(MainActivity.this,SearchWorkOrder.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                  //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){

                    Intent intent=new Intent(MainActivity.this,SearchWorkOrder.class);
                    intent.putExtra("contrctTreeList",contrctTreeList);
                    startActivity(intent);
                 //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

                else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker")){

                    Intent intent=new Intent(MainActivity.this,SearchWorkOrder.class);
                    startActivity(intent);
                 //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Client")){

                    Intent intent=new Intent(MainActivity.this,SearchWorkOrder.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                  //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else {
                    Intent intent=new Intent(MainActivity.this,SearchWorkOrder.class);
                    intent.putExtra("adminlist",adminTreeStructures);
                    startActivity(intent);
                }
            }
        });



        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.prog);
       /* progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Extracting and Transferring Data Please Wait...");
        progressDoalog.setTitle("Welcome to "+preferenceManagerWorkOrder.getKey_User_Name());*/
        /*progressDoalog.setContentView(R.layout.prog);
        progressDoalog.requestWindowFeature(Window.FEATURE_NO_TITLE);*/
        /*progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.setCancelable(false);*/
        /*progressDoalog.getWindow().setBackgroundDrawable(new ColorDrawable(0x9000000));*/
        /*progressDoalog.show();*/
        dialog.setCancelable(false);


        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager")){
            fetchDashBoardListFM();

        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")) {
            fetchDashBoardListContractor();

        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker")) {
            fetchDashBoardListWorker();

        }else if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Client")){
            fetchDashBoardListClinet();
        }else //if (preferenceManagerWorkOrder.getKey_User_Role().equals("Administrator"))
        {
            fetchDashBoardListAdmin();
        }


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
                            work_number.setText(String.valueOf(dashContractors.getWordercount()));
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
                                        dialog.dismiss();
                                    }
                                    dialog.dismiss();
                                }
                            });
                        }

                        else {
                            Toast.makeText(getApplicationContext(), response.errorBody().string().toString(), Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }

                    }catch (Exception e)
                    {
                        Log.v("Exception",e.toString());
                        dialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<DashBoardContractor> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                    dialog.dismiss();
                }
            });

        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        }
    }

    public void fetchDashBoardListFM()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            dialog.show();
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());//"http://109.228.49.117:8096/
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
                                /*Handler handler=new Handler();
                                handler.post(new Runnable()
                                {
                                    public void run()
                                    {
                                        try {
                                            // code to execute
                                            Thread.sleep(3000);
                                        } catch (Exception e) {

                                        }

                                    }
                                });*/
                                dialog.dismiss();
                            }
                        else {
                            Toast.makeText(getApplicationContext(), response.errorBody().string().toString(), Toast.LENGTH_SHORT).show();
                           dialog.dismiss();
                        }
                    }catch (Exception e)
                    {
                        Log.v("Exception",e.toString());
                        dialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<DashBoardResponse> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                    dialog.dismiss();
                }
            });

        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    DashBoardAdmin adminResponse;
    ArrayList<AdminTreeStructure> adminTreeStructures;
    public void fetchDashBoardListAdmin()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            dialog.show();
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());//"http://109.228.49.117:8096/
            final Call<DashBoardAdmin> workOrderResponseModelCall= apiServicesWorkOrder.dashBoardListAdmin("application/json","api/home/linktree?rolename="+ preferenceManagerWorkOrder.getKey_User_Role()+"&companyid="+ preferenceManagerWorkOrder.getKey_Person_Company_Id()+"&parentcompanyid="+ preferenceManagerWorkOrder.getKey_Parent_Company_Id());
            workOrderResponseModelCall.enqueue(new Callback<DashBoardAdmin>() {

                @Override
                public void onResponse(Call<DashBoardAdmin> call, Response<DashBoardAdmin> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if(response.body()!=null)
                        {
                            adminResponse=response.body();
                            company_number.setText(String.valueOf(adminResponse.getCompanycoubt()));
                            purchase_number.setText(String.valueOf(adminResponse.getPurchaseorderount()));
                            asset_number.setText(String.valueOf(adminResponse.getAssetcount()));
                            work_number.setText(String.valueOf(adminResponse.getWordercount()));
                            adminTreeStructures= (ArrayList<AdminTreeStructure>) adminResponse.getTreestuctutr();
                                /*Handler handler=new Handler();
                                handler.post(new Runnable()
                                {
                                    public void run()
                                    {
                                        try {
                                            // code to execute
                                            Thread.sleep(3000);
                                        } catch (Exception e) {

                                        }

                                    }
                                });*/
                            dialog.dismiss();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), response.errorBody().string().toString(), Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }catch (Exception e)
                    {
                        Log.v("Exception",e.toString());
                        dialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<DashBoardAdmin> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                    dialog.dismiss();
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
        MenuItem refresh = menu.findItem(R.id.menu_refresh);
        refresh.setVisible(false);
        MenuItem dashboard = menu.findItem(R.id.menu_dashboard);
        dashboard.setVisible(false);

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
               // Toast.makeText(this, "DashBoard", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                return true;
            case R.id.menu_asset:
            //    Toast.makeText(this, "Asset", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),SearchAsset.class));
                return true;
            case R.id.menu_about_us:
                Toast.makeText(this, "About Us", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_work_order:
             //   Toast.makeText(this, "Work Order", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),SearchWorkOrder.class));
                return true;
            case R.id.menu_logout:
               // startActivity(new Intent(MainActivity.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
             //   finish();
                UtilityFunction.logOutAlert(this);
                Toast.makeText(this, "Logout", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_purchase_order:
              //  Toast.makeText(this, "Purchase Order", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),SearchPurchaseOrder.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {
            // Handle the camera action
            startActivity(new Intent(MainActivity.this, MainActivity.class));

        } else if (id == R.id.nav_asset) {
            startActivity(new Intent(MainActivity.this, SearchAsset.class));

        } else if (id == R.id.nav_purchase_order) {
            startActivity(new Intent(MainActivity.this, SearchPurchaseOrder.class));

        } else if (id == R.id.nav_work_order) {
            Intent intent=new Intent(MainActivity.this, SearchWorkOrder.class);
            startActivity(intent);

        }else  if(id== R.id.nav_client_list)
        {
            startActivity(new Intent(MainActivity.this,Client.class));
        }

        else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_logout) {
           // startActivity(new Intent(MainActivity.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
          //  finish();
            UtilityFunction.logOutAlert(this);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void fetchDashBoardListWorker(){

       if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
           dialog.show();
           ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
           final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
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
                                   } catch(Exception e) {

                                   }
                                   dialog.dismiss();
                               }
                           });
                       }
                       else {
                           Toast.makeText(getApplicationContext(), response.errorBody().string().toString(), Toast.LENGTH_SHORT).show();
                           dialog.dismiss();
                       }
                   }catch (Exception e)
                   {
                       Log.v("Exception",e.toString());
                       dialog.dismiss();
                   }
               }

               @Override
               public void onFailure(Call<DashBoardResponse> call, Throwable t) {
                   t.printStackTrace();
                   System.out.println(t.getMessage() + t.getLocalizedMessage());
                   dialog.dismiss();
               }
           });
       }else {
           Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
       }

   }


   /* @Override
    protected void onRestart() {

        super.onRestart();

        startActivity(i);
        finish();

    }*/


    private void fetchDashBoardListClinet() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            dialog.show();
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            //api/home/linktree?rolename=Super%20Administrator&companyid=319896&parentcompanyid=319895
            final Call<DashboardClient> workOrderResponseModelCall= apiServicesWorkOrder.dashBoardListClient("application/json","api/home/linktree?rolename="+ preferenceManagerWorkOrder.getKey_User_Role()+"&companyid="+ preferenceManagerWorkOrder.getKey_Person_Company_Id()+"&parentcompanyid="+ preferenceManagerWorkOrder.getKey_Parent_Company_Id());
            workOrderResponseModelCall.enqueue(new Callback<DashboardClient>() {
                @Override
                public void onResponse(Call<DashboardClient> call, Response<DashboardClient> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if(response.body()!=null)
                        {
                            dashboardClient=response.body();
                            company_number.setText(String.valueOf(dashboardClient.getCompanycoubt()));
                            purchase_number.setText(String.valueOf(dashboardClient.getPurchaseorderount()));
                            asset_number.setText(String.valueOf(dashboardClient.getAssetcount()));
                            work_number.setText(String.valueOf(dashboardClient.getWordercount()));
                            clientlist=  dashboardClient.getClientTreeStructure();
                            dialog.dismiss();
                        }

                        else {
                            Toast.makeText(getApplicationContext(), response.errorBody().string().toString(), Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }

                    }catch (Exception e)
                    {
                        Log.v("Exception",e.toString());
                        dialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<DashboardClient> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                    dialog.dismiss();
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

}
