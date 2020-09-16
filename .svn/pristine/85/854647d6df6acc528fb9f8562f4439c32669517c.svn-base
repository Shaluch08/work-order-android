package com.workorder.app.workorderapplication.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.workorderapplication.adapter.ClickListener;
import com.workorder.app.workorderapplication.adapter.ListAssetAdapter;
import com.workorder.app.workorderapplication.model.assetModel.AssetResponseModel;
import com.workorder.app.workorderapplication.model.dashboardModel.AdminTreeStructure;
import com.workorder.app.workorderapplication.model.dashboardModel.DashBoardResponse;
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

public class SearchAsset extends AppCompatActivity implements ClickListener {
    ImageButton fab;
    List<AssetResponseModel> responseModel;
    RecyclerView recycler_View;
    int assetNumber;
    TextView Errormsg;
    DashBoardResponse responses;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String rolename,AssetId,companyid,errorMsgAsset;
    ListAssetAdapter adapter;
    SearchView searchView;
    Context context;
    ArrayList<Treestuctutr> arrayList;
    ArrayList<AdminTreeStructure> adminTreeStructures;
    ArrayList<ContrctTree> contrctTrees;
    ProgressDialog progressDoalog;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_asset);
         Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Asset");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }

        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
        {
            ArrayList<Treestuctutr> list= (ArrayList<Treestuctutr>) getIntent().getSerializableExtra("list");
            arrayList=list;
        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
            ArrayList<ContrctTree> contrctTreeArrayList=(ArrayList<ContrctTree>)getIntent().getSerializableExtra("contrctTreeList");
            contrctTrees=contrctTreeArrayList;
        }else {
            ArrayList<AdminTreeStructure> list= (ArrayList<AdminTreeStructure>) getIntent().getSerializableExtra("adminlist");
            adminTreeStructures=list;
        }

        Errormsg = (TextView)findViewById(R.id.tvErrormsgAsset);
        errorMsgAsset = "Asset not created yet!!!";

        recycler_View=(RecyclerView)findViewById(R.id.recycler_asset);
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename= preferenceManagerWorkOrder.getKey_User_Name();
        recycler_View.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        /*recycler_View.setItemAnimator(new DefaultItemAnimator());*/
        searchView=(SearchView)findViewById(R.id.search_asset);
        searchView.setFocusableInTouchMode(false);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                  /*adapter.getFilter().filter(query);*/
               return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               try {
                   adapter.getFilter().filter(newText);

               }catch (Exception e)
               {
                   Log.d("SearchAsset",e.toString());
               }

                return false;
            }
        });

        fab = (ImageButton) findViewById(R.id.fabasset);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchAsset.this,Asset.class));
               // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Extracting and Transferring Data Please Wait...");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        assetListFM();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem m_asset = menu.findItem(R.id.menu_asset);
        m_asset.setVisible(false);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.menu_refresh:
                /*Toast.makeText(this, "Refresh", Toast.LENGTH_LONG).show();*/
                progressDoalog = new ProgressDialog(SearchAsset.this);
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
    public void callAfterResponse(List<AssetResponseModel> response) {
        adapter = new ListAssetAdapter(this, response);
        recycler_View.setAdapter(adapter);
        adapter.setClicklistener(this);
        adapter.notifyDataSetChanged();
       // progressDoalog.dismiss();
    }
    public void fetchAssetList()
    {

        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            progressDoalog.show();
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
            final Call<List<AssetResponseModel>> workOrderResponseModelCall= apiServicesWorkOrder.assetList("application/json","api/assets/assetlist?rolename="+ preferenceManagerWorkOrder.getKey_User_Role()+"&companyid="+companyid);
            workOrderResponseModelCall.enqueue(new Callback<List<AssetResponseModel>>() {
                @Override
                public void onResponse(Call<List<AssetResponseModel>> call, Response<List<AssetResponseModel>> response) {
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
                            progressDoalog.dismiss();
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
                public void onFailure(Call<List<AssetResponseModel>> call, Throwable t) {
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
        String AssetId=responseModel.get(position).getId();
        Bundle bundle=new Bundle();
        Log.d("AssetId",AssetId);
        bundle.putString("AssetId",AssetId);
        Intent intent=new Intent(SearchAsset.this,UpdateAsset.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progressDoalog.dismiss();
      //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
                Toast.makeText(SearchAsset.this, "Delete", Toast.LENGTH_LONG).show();
                AssetId= String.valueOf(responseModel.get(position).getId());
                deleteAsset();
                startActivity(getIntent());
                finish();
                //builder.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(SearchAsset.this, "Cancel", Toast.LENGTH_LONG).show();
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
        String AssetId=responseModel.get(position).getId();
        Bundle bundle=new Bundle();
        bundle.putString("AssetId",AssetId);
        Intent intent=new Intent(SearchAsset.this,History.class);
        intent.putExtras(bundle);
        startActivity(intent);
       // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    private void deleteAsset(){
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<String> deleteWorkOrder= apiServicesWorkOrder.delete("application/json","api/assets/DeleteAssetDetails?companyid="+companyid+"&AssetId="+AssetId);
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
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class));
        finishAffinity();
    }

    /*  @Override
    protected void onRestart() {

        super.onRestart();
        Intent i = new Intent(SearchAsset.this, SearchAsset.class);
        startActivity(i);
        finish();

    }*/

    public void assetListFM()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            progressDoalog.show();
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
            final Call<DashBoardResponse> workOrderResponseModelCall= apiServicesWorkOrder.dashBoardListFm("application/json","api/home/linktree?rolename="+ preferenceManagerWorkOrder.getKey_User_Role()+"&companyid="+ preferenceManagerWorkOrder.getKey_Person_Company_Id()+"&parentcompanyid="+ preferenceManagerWorkOrder.getKey_Parent_Company_Id());
            workOrderResponseModelCall.enqueue(new Callback<DashBoardResponse>() {
                @Override
                public void onResponse(Call<DashBoardResponse> call, Response<DashBoardResponse> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE

                        responses=response.body();
                        assetNumber = responses.getAssetcount();
                        if (assetNumber > 0 ){
                            fetchAssetList();
                        }else {

                            Errormsg.setText(errorMsgAsset);
                            progressDoalog.dismiss();
                        }


                    }catch (Exception e)
                    {
                        Log.v("Exception",e.toString());
                        progressDoalog.dismiss();
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
}
