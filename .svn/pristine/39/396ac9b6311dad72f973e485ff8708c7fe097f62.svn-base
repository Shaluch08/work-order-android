package com.workorder.app.workorderapplication.activity;

import android.app.ProgressDialog;
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
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.workorderapplication.adapter.ClickListener;
import com.workorder.app.workorderapplication.adapter.MaterialUsedAdapter;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.materialModel.MaterialEditList;
import com.workorder.app.workorderapplication.model.materialModel.MaterialList;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MaterialUsedList extends AppCompatActivity implements ClickListener {
    List<MaterialList> materialLists;
    RecyclerView recycler_View;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String rolename,AssetId,companyid;
    MaterialUsedAdapter adapter;
    SearchView searchView;
    String WorkOrderId;
    ImageButton create_material;
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    ProgressDialog progressDoalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_used_list);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
        {
            ArrayList<Treestuctutr> list= (ArrayList<Treestuctutr>) getIntent().getSerializableExtra("list");
            arrayList=list;
        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
            ArrayList<ContrctTree> contrctTreeArrayList=(ArrayList<ContrctTree>)getIntent().getSerializableExtra("contrctTreeList");
            contrctTrees=contrctTreeArrayList;
        }
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Material Used");
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
        }
        create_material= (ImageButton) findViewById(R.id.create_material);
        create_material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("WorkOrderId",WorkOrderId);
                Intent intent=new Intent(MaterialUsedList.this,CreateMaterial.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        recycler_View=(RecyclerView)findViewById(R.id.recycler_materialUsed);

        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename= preferenceManagerWorkOrder.getKey_User_Name();
        searchView=(SearchView)findViewById(R.id.search_materialUsed);
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
        recycler_View.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Extracting and Transferring Data Please Wait...");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();
        fetchMaterialList();
    }
    public void callAfterResponse(List<MaterialList> response) {
        adapter = new MaterialUsedAdapter(this, response);
        recycler_View.setAdapter(adapter);
        adapter.setClicklistener(this);
        adapter.notifyDataSetChanged();
    }
    public void fetchMaterialList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
            final Call<List<MaterialList>> workOrderResponseModelCall= apiServicesWorkOrder.materialList("application/json","api/WorkMaterial/WorkMaterialList?workorderid="+WorkOrderId);
            workOrderResponseModelCall.enqueue(new Callback<List<MaterialList>>() {
                @Override
                public void onResponse(Call<List<MaterialList>> call, Response<List<MaterialList>> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if(response.body()!=null)
                        {
                            materialLists=response.body();
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



                            callAfterResponse(materialLists);
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
                public void onFailure(Call<List<MaterialList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
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
    public void editClick(Integer position) {
        Bundle bundle=new Bundle();
            bundle.putString("WorkOrderId",WorkOrderId);
            bundle.putInt("id",materialLists.get(position).getId());
            Intent intent=new Intent(MaterialUsedList.this,UpdateMaterialUsed.class);
                intent.putExtras(bundle);
                startActivity(intent);
      //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
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
                Toast.makeText(MaterialUsedList.this, "Delete", Toast.LENGTH_LONG).show();
                int ID=materialLists.get(position).getId();
                MaterialEditList request=new MaterialEditList();
                request.setId(ID);
                request.setUpdatedBy(preferenceManagerWorkOrder.getKey_Person_Company_Id());
                if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
                    ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
                    final Call<String> deleteWorkOrder= apiServicesWorkOrder.deletematerial("application/json","api/WorkMaterial/DeleteMaterial?id="+ID+"&personid="+ preferenceManagerWorkOrder.getKey_Person_Company_Id());
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
                startActivity(getIntent());
                finish();
                //builder.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //  Action for 'NO' Button
                Toast.makeText(MaterialUsedList.this, "Cancel", Toast.LENGTH_LONG).show();
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

    }

}
