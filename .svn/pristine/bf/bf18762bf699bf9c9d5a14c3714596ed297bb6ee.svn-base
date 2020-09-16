package com.workorder.app.workorderapplication.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.workorderapplication.model.workOrderModel.ClientDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.EditWorkOrderDetails;
import com.workorder.app.workorderapplication.model.workOrderModel.OrderStatusDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.PriorityDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.UpdateWorkOrderRequest;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkerWOUpdate extends AppCompatActivity {

    List<OrderStatusDropDownList> orderStatusDropDownLists;
    List<ClientDropDownList> clientDropDownLists;
    List<PriorityDropDownList> priorityDropDownLists;
    ProgressDialog progressDoalog;


    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    SimpleDateFormat newformat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());

    EditWorkOrderDetails editWorkOrderDetailsList;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String updateClient,updateClientNo,updateWarningLevel,updateOrderStatus,updatePriority
            ,updateOrderType,updateDueDate,updateWONumber,updateDescription,updateRoom,updateRegion,
            updateSubRegion,updateArea,updateLocation,updateBuildingName,updateFloor,
            updateAssetId,updateClientOrderNo,updateNewDueDate,WorkOrderId,userrole,
            companyid,clientId,rolename;

    TextView tvWorkorderNo,etdueDate,
            etAssestid,tvassestLocationDisplay,etworkorderDescription;
    Spinner tvorderStatusDisplay,tvClient,tvpriorityDisplay;

    Button btnExtReq,btnMaterial,btnReport,btnUpdate,BtnExtDetails,btWoDetails;

    Integer ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_update);

        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager")){

        }

        Bundle intent=getIntent().getExtras();
        if(intent!=null)
        {
            WorkOrderId=intent.getString("workOrderId");
        }

        /*etdueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*showDatePickerDialog1(v);*//*
            }
        });*/

        userrole= preferenceManagerWorkOrder.getKey_User_Role();
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename= preferenceManagerWorkOrder.getKey_User_Name();

        tvClient = (Spinner)findViewById(R.id.tvClient);
        tvClient.setClickable(false);
        tvClient.setEnabled(false);
        tvWorkorderNo = (TextView)findViewById(R.id.tvWorkorderNo);
        etdueDate = (TextView)findViewById(R.id.etdueDate);
        tvorderStatusDisplay = (Spinner)findViewById(R.id.tvorderStatusDisplay);
        tvpriorityDisplay = (Spinner)findViewById(R.id.tvpriorityDisplay);
        tvpriorityDisplay.setClickable(false);
        tvpriorityDisplay.setEnabled(false);
        etAssestid = (TextView)findViewById(R.id.etAssestid);
        tvassestLocationDisplay = (TextView)findViewById(R.id.tvassestLocationDisplay);
        etworkorderDescription = (TextView)findViewById(R.id.etworkorderDescription);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Work Order Update");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }

        Button btnBacktolist = (Button)findViewById(R.id.btnBacktolist);
        btnBacktolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WorkerWOUpdate.this,WorkerSearchList.class);
                startActivity(intent);
            }
        });




        btnExtReq = (Button)findViewById(R.id.btnextReq);
        btnExtReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("WorkOrderId",WorkOrderId);
                Intent intent = new Intent(WorkerWOUpdate.this,ExtensionRequired.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });


        btnMaterial = (Button)findViewById(R.id.btnMaterial);

        btnMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("WorkOrderId",WorkOrderId);
                Intent intent = new Intent(WorkerWOUpdate.this,CreateMaterial.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });


        btnReport = (Button)findViewById(R.id.btnReport);
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("WorkOrderId",WorkOrderId);
                Intent intent = new Intent(WorkerWOUpdate.this,ReportOnWork.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });

        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateOrderstatus();



            }
        });

        BtnExtDetails = (Button)findViewById(R.id.btnExtDetails);
        BtnExtDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("WorkOrderId",WorkOrderId);

                Intent intent = new Intent(WorkerWOUpdate.this,ExtensionDetails.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });

        btWoDetails = (Button)findViewById(R.id.btWoDetails);
        btWoDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("WorkOrderId",WorkOrderId);

                Intent intent = new Intent(WorkerWOUpdate.this,UpdateWorkOrder.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });


        getUpdateListWO();
        fetchOrderStatusDropDown();
        fetchClientDropDown();
        fetchPriorityDropDown();


    }






    private void getUpdateListWO(){
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())){


            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<EditWorkOrderDetails> details= apiServicesWorkOrder.editworkOrderDetails("application/json","api/order/EditWorkOrderDetails?rolename="+rolename+"&companyid="+companyid+"&id="+WorkOrderId);
            details.enqueue(new Callback<EditWorkOrderDetails>(){

                @Override
                public void onResponse(Call<EditWorkOrderDetails> call, Response<EditWorkOrderDetails> response){

                    if(response.body()!=null){

                        editWorkOrderDetailsList=response.body();
                        Log.v("Success",response.body()+"");
                        ID=editWorkOrderDetailsList.getId();
                        updateClient= String.valueOf(editWorkOrderDetailsList.getClientid());
                        updateClientNo=editWorkOrderDetailsList.getClientno();
                        updateWONumber=editWorkOrderDetailsList.getWorkordernumber();
                        tvWorkorderNo.setText(updateWONumber);

                        if(editWorkOrderDetailsList.getDuedate()!=null) {
                            String updateDueDateRaise = editWorkOrderDetailsList.getDuedate();
                            String[] duedate = updateDueDateRaise.split("T");
                            Date date11 = null;
                            try {
                                date11 = simpleDateFormat.parse(duedate[0]);
                                updateDueDate = newformat.format(date11);
                                etdueDate.setText(updateDueDate);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }else {
                            etdueDate.setText("");
                        }

                        updateOrderStatus= String.valueOf(editWorkOrderDetailsList.getEntitystatus());
                        /*tvorderStatusDisplay.setText(updateOrderStatus);*/
                                updatePriority= String.valueOf(editWorkOrderDetailsList.getPriority());
                        /*tvpriorityDisplay.setText(updatePriority);*/

                                updateClientOrderNo=editWorkOrderDetailsList.getClientworkorderno();
                        updateAssetId= String.valueOf(editWorkOrderDetailsList.getAssetid());
                        etAssestid.setText(updateAssetId);
                                updateDescription=editWorkOrderDetailsList.getDescription();
                        etworkorderDescription.setText(updateDescription);
                                updateLocation= String.valueOf(editWorkOrderDetailsList.getLocationid());
                        tvassestLocationDisplay.setText(updateLocation);
                    }
                }
                @Override
                public void onFailure(Call<EditWorkOrderDetails> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                    Log.v("Error",t.getMessage());
                }
            });
        }

    }

    private void fetchOrderStatusDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<OrderStatusDropDownList>> poListCall= apiServicesWorkOrder.oredrstatusdropdown("application/json","api/dropdown/getOrderStatus?rolename="+rolename+"&companyid="+companyid);
            poListCall.enqueue(new Callback<List<OrderStatusDropDownList>>() {
                @Override
                public void onResponse(Call<List<OrderStatusDropDownList>> call, Response<List<OrderStatusDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        orderStatusDropDownLists=response.body();

                        Handler handler=new Handler();
                        handler.post(new Runnable()
                        {
                            public void run()
                            {
                                try {

                                    for(int i=0;i<orderStatusDropDownLists.size();i++)
                                    {
                                        if(orderStatusDropDownLists.get(i).getValue().equals(updateOrderStatus))
                                            showOrderStatusDropDownList(orderStatusDropDownLists.get(i).getText());
                                    }
                                    // code to execute
                                    Thread.sleep(100);
                                } catch (Exception e) {

                                }
                                /*progressDialog.dismiss();*/
                                /*dialog.dismiss();*/
                            }
                        });


                    }
                }

                @Override
                public void onFailure(Call<List<OrderStatusDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    private void showOrderStatusDropDownList(String compareValue)
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[orderStatusDropDownLists.size()];
            for(int i=0;i<orderStatusDropDownLists.size();i++)
            {
                item[i]=orderStatusDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            tvorderStatusDisplay.setAdapter(adapter);
            if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                tvorderStatusDisplay.setSelection(spinnerPosition);
            }
            tvorderStatusDisplay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateOrderStatus= orderStatusDropDownLists.get(position).getValue();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }
    }

    private void fetchClientDropDown(){

        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<ClientDropDownList>> poListCall= apiServicesWorkOrder.clientdropdown("application/json","api/dropdown/getallclientlist?rolename="+userrole+"&companyid="+companyid);
            poListCall.enqueue(new Callback<List<ClientDropDownList>>() {
                @Override
                public void onResponse(Call<List<ClientDropDownList>> call, Response<List<ClientDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        clientDropDownLists=response.body();

                        Handler handler=new Handler();
                        handler.post(new Runnable()
                        {
                            public void run()
                            {
                                try {

                                    for(int i=0;i<clientDropDownLists.size();i++) {
                                        if(clientDropDownLists.get(i).getValue().equals(updateClient))
                                            showClientDropDownList(clientDropDownLists.get(i).getText());
                                    }
                                    // code to execute
                                    Thread.sleep(100);
                                } catch (Exception e) {

                                }
                                /*progressDialog.dismiss();*/
                               /* dialog.dismiss();*/
                            }
                        });

                    }
                }

                @Override
                public void onFailure(Call<List<ClientDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showClientDropDownList(String compareValue)
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[clientDropDownLists.size()];
            for(int i=0;i<clientDropDownLists.size();i++)
            {
                item[i] = clientDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            tvClient.setAdapter(adapter);
            if (compareValue != null) {
                int spinnerPosition = adapter.getPosition(compareValue);
                tvClient.setSelection(spinnerPosition);
            }
            tvClient.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateClientNo= clientDropDownLists.get(position).getValue();
                    /*clientNo.setText(updateClientNo);
                    clientNo.setEnabled(false);*/

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
    }


    private void fetchPriorityDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<PriorityDropDownList>> poListCall= apiServicesWorkOrder.prioritydropdown("application/json","api/dropdown/getpriority?rolename="+rolename+"&companyid="+companyid);
            poListCall.enqueue(new Callback<List<PriorityDropDownList>>() {
                @Override
                public void onResponse(Call<List<PriorityDropDownList>> call, Response<List<PriorityDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        priorityDropDownLists=response.body();

                        Handler handler=new Handler();
                        handler.post(new Runnable()
                        {
                            public void run()
                            {
                                try {

                                    for(int i=0;i<priorityDropDownLists.size();i++)
                                    {
                                        if(priorityDropDownLists.get(i).getValue().equals(updatePriority))
                                        {
                                            showPriorityDropDownList(priorityDropDownLists.get(i).getText());
                                        }
                                    }
                                    // code to execute
                                    Thread.sleep(100);
                                } catch (Exception e) {

                                }
                                /*progressDialog.dismiss();*/
                                /*dialog.dismiss();*/
                            }
                        });


                    }
                }

                @Override
                public void onFailure(Call<List<PriorityDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showPriorityDropDownList(String compareValue)
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[priorityDropDownLists.size()];
            for(int i=0;i<priorityDropDownLists.size();i++)
            {
                item[i]=priorityDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            tvpriorityDisplay.setAdapter(adapter);
            if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                tvpriorityDisplay.setSelection(spinnerPosition);
            }

            tvpriorityDisplay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updatePriority= priorityDropDownLists.get(position).getValue();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
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
        MenuItem refresh = menu.findItem(R.id.menu_refresh);
        refresh.setVisible(false);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle item selection
        switch (item.getItemId()) {

            case R.id.menu_refresh:
                Toast.makeText(this, "Refresh", Toast.LENGTH_LONG).show();
                progressDoalog = new ProgressDialog(WorkerWOUpdate.this);
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
                startActivity(new Intent(WorkerWOUpdate.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
                Toast.makeText(this, "Logout", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
  /*  @Override
    protected void onRestart() {

        super.onRestart();
        Bundle bundle = new Bundle();
        bundle.putString("workOrderId", WorkOrderId);
        Intent i = new Intent(WorkerWOUpdate.this, WorkerWOUpdate.class);
        i.putExtras(bundle);
        startActivity(i);
        progressDoalog.dismiss();
        finish();

    }*/

    public void updateOrderstatus(){
        UpdateWorkOrderRequest request=new UpdateWorkOrderRequest();
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<String> loginResponseCall =
                    apiServicesWorkOrder.updateWorkOrderStatus("application/json","api/order/UpdateWorkOrderStatus?WorkOrderID="+WorkOrderId+"&Status="+updateOrderStatus);
            loginResponseCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    try {
                        int codeStatus=response.code();
                        // TODO NULL CHECK OF RESPONSE
                        String result=response.body();

                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(WorkerWOUpdate.this,WorkerSearchList.class));
                    } catch (Exception e) {
                        Log.v("Error",e.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }

    }


}
