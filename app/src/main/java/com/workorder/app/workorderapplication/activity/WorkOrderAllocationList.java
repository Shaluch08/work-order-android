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
import com.workorder.app.workorderapplication.adapter.WorkOrderAllocationAdapter;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderAllocationListResponse;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderAllocationRequest;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkOrderAllocationList extends AppCompatActivity implements ClickListener {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    List<WorkOrderAllocationListResponse> workOrderAllocationListResponseList;
    RecyclerView recyclerView;
    String rolename,WorkOrderId,companyid;
    SearchView searchView;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    WorkOrderAllocationAdapter adapter;
    ImageButton add_allocation;
    String personId;
    String Id;
    ProgressDialog progressDoalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_allocation_list);
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
        getSupportActionBar().setTitle("Work Order Allocation");

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
        recyclerView=(RecyclerView) findViewById(R.id.recycler_allocation);
        searchView=(SearchView) findViewById(R.id.search_workAllocation);
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
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        add_allocation=(ImageButton) findViewById(R.id.create_allocation);
        add_allocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("WorkOrderId",WorkOrderId);
                Intent intent=new Intent(WorkOrderAllocationList.this,CreateWorkAllocation.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Extracting and Transferring Data Please Wait...");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();
        fetchWorkOrderAllocationList();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Contractor")) {

            MenuItem m_asset = menu.findItem(R.id.menu_asset);
            m_asset.setVisible(false);
            MenuItem refresh = menu.findItem(R.id.menu_refresh);
            refresh.setVisible(false);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            /*case R.id.menu_refresh:
                Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
                progressDoalog = new ProgressDialog(this);
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
    public void callAfterResponse(List<WorkOrderAllocationListResponse> response) {
        if (getApplicationContext()!=null) {
            adapter = new WorkOrderAllocationAdapter(getBaseContext(), response);
            recyclerView.setAdapter(adapter);
            adapter.setClicklistener(this);
            adapter.notifyDataSetChanged();
        }

    }
    private void fetchWorkOrderAllocationList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();

            final Call<List<WorkOrderAllocationListResponse>> workOrderResponseModelCall= apiServicesWorkOrder.allocationList("application/json","api/workerperson/workerlist?workorderid="+WorkOrderId);
            workOrderResponseModelCall.enqueue(new Callback<List<WorkOrderAllocationListResponse>>() {
                @Override
                public void onResponse(Call<List<WorkOrderAllocationListResponse>> call, Response<List<WorkOrderAllocationListResponse>> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if(response.body()!=null)
                        {
                            workOrderAllocationListResponseList=response.body();
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
                            callAfterResponse(workOrderAllocationListResponseList);
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
                public void onFailure(Call<List<WorkOrderAllocationListResponse>> call, Throwable t) {
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
        Id= String.valueOf(workOrderAllocationListResponseList.get(position).getId());
        Bundle bundle=new Bundle();
        bundle.putString("WorkOrderId",WorkOrderId);
        bundle.putString("Id",Id);
        bundle.putString("personId",personId);
       Intent intent=new Intent(WorkOrderAllocationList.this,UpdateWorkOrderAllocate.class);
        intent.putExtras(bundle);
        startActivity(intent);
     //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

   /* @Override
    public void deleteClick( Integer position) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        *//*builder.setTitle("Delete?");
        //Setting message manually and performing action on button click
        builder.setMessage("Are you sure to delete this item?");
        //This will not allow to close dialogbox until user selects an option
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(WorkOrderAllocationList.this, "Delete", Toast.LENGTH_LONG).show();
                Id=String.valueOf(workOrderAllocationListResponseList.get(position).getId());
                personId=String.valueOf(workOrderAllocationListResponseList.get(position).getPersonId());
                deleteWorkOrderAllocation();
                startActivity(getIntent());
                finish();
                builder.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //  Action for 'NO' Button
                Toast.makeText(WorkOrderAllocationList.this, "Cancel", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });*//*

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("AlertDialogExample");
        alert.show();
    }*/
   @Override
   public void deleteClick(final Integer position) {
   }

      /* final AlertDialog.Builder builder = new AlertDialog.Builder(this);
       builder.setTitle("Delete?");
       //Setting message manually and performing action on button click
       builder.setMessage("Are you sure to delete this item?");
       //This will not allow to close dialogbox until user selects an option
       builder.setCancelable(false);
       builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
               *//*Toast.makeText(WorkOrderAllocationList.this, "Delete", Toast.LENGTH_LONG).show();*//*
               *//*WorkOrderId=responseModel.get(position).getWorkOrderId();
               deleteWorkOrder();
               startActivity(getIntent());*//*
               finish();
               //builder.finish();
           }
       });
       builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
               //  Action for 'NO' Button
               Toast.makeText(WorkOrderAllocationList.this, "Cancel", Toast.LENGTH_LONG).show();
               dialog.cancel();
           }
       });

       //Creating dialog box
       AlertDialog alert = builder.create();
       //Setting the title manually
       //alert.setTitle("AlertDialogExample");
       alert.show();
   }*/

    @Override
    public void addWorker(Integer position) {

    }

    @Override
    public void materialClickListener(Integer position) {

    }

    @Override
    public void historyClickListener(Integer position) {

    }
    private void deleteWorkOrderAllocation()
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete!");
        //Setting message manually and performing action on button click
        builder.setMessage("Do you want to delete the item?");
        //This will not allow to close dialogbox until user selects an option
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(WorkOrderAllocationList.this, "Delete", Toast.LENGTH_LONG).show();
                WorkOrderAllocationRequest request=new WorkOrderAllocationRequest();
                request.setId(Integer.parseInt(Id));
                request.setPersonId((Integer.parseInt(personId)));
                if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
                    ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
                    final Call<String> deleteWorkOrder= apiServicesWorkOrder.deleteWorkAllocation("application/json","api/workerperson/DeleteAllocation?id="+Id+"&personid="+personId);
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
                Toast.makeText(WorkOrderAllocationList.this, "Cancel", Toast.LENGTH_LONG).show();
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
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    /*@Override
    protected void onRestart() {

        super.onRestart();
        Bundle bundle = new Bundle();
        bundle.putString("workOrderId", WorkOrderId);
        Intent i = new Intent(WorkOrderAllocationList.this, WorkOrderAllocationList.class);  //your class
        i.putExtras(bundle);
        startActivity(i);
        progressDoalog.dismiss();
        finish();

    }*/
}
