package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UrlClass;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.webservicecallback.GetApiCallback;
import com.workorder.app.webservicecallback.OnTaskCompleted;
import com.workorder.app.workorderapplication.model.assetModel.AssetDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.ReactiveCriticalityDropDown;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.workOrderModel.AssetProcessTypePOJO;
import com.workorder.app.workorderapplication.model.workOrderModel.ClientDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.OrderStatusDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.OrderTypeDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.PriorityDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.PurchaseOrderDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.WarningLevelDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderPostResquest;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkOrder extends AppCompatActivity {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    List<AssetDropDownList> assetDropDownLists;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    Button next;
    Spinner sp_reactive_criticality;

    Spinner purchaseOrderNumber,orderType,client,warningLevel,orderStatus,priority,assetId;
    List<PurchaseOrderDropDownList> poList;
    List<OrderTypeDropDownList> otList;
    List<ClientDropDownList> clientDropDownLists;
    List<OrderStatusDropDownList> orderStatusDropDownLists;
    List<PriorityDropDownList> priorityDropDownLists;
    List<WarningLevelDropDownList> warningLevelDropDownLists;
    String userrole,companyid,rolename;
    EditText client_no;
    static EditText dateRaised,dueDate;
    WorkOrderPostResquest workOrderPostResquest;
    EditText clientOrderNo,woNo;
    int ClientId=0;
    String clientNo,poNo="",workOrderNo,orderstatus="",clientId,dateraised,duedate;
    int priorty,assetID,ordertype,warning;
    List<ReactiveCriticalityDropDown> reactiveCriticalityDropDowns;
    String updateReactiveCriticality;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order);
        sp_reactive_criticality=findViewById(R.id.sp_reactive_criticality);
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
        getSupportActionBar().setTitle("Add New Work Order");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }
        Constants.workOrderPostResquest=new WorkOrderPostResquest();
        dateRaised=(EditText) findViewById(R.id.raised_date);
        woNo=(EditText) findViewById(R.id.work_order_no);
        dueDate=(EditText) findViewById(R.id.due_date);
        assetId=(Spinner)findViewById(R.id.spinner_asset_id);
        client_no=(EditText) findViewById(R.id.client_no);
        userrole= preferenceManagerWorkOrder.getKey_User_Role();
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename= preferenceManagerWorkOrder.getKey_User_Name();
        purchaseOrderNumber=(Spinner) findViewById(R.id.spinner_purchase_order_no);
        orderType=(Spinner) findViewById(R.id.spinner_order_type);
        client=(Spinner) findViewById(R.id.spinner_client);
        warningLevel=(Spinner) findViewById(R.id.spinner_warning_level);
        orderStatus=(Spinner) findViewById(R.id.spinner_order_status);
        priority=(Spinner) findViewById(R.id.spinner_priority);
        Button next=(Button) findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextEvent();
              //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        dateRaised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        dueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });
        Button pre=(Button) findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
               // startActivity(new Intent(WorkOrder.this,SearchWorkOrder.class));
            //    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });
      //  fetchPONUmberDropDown();
        fetchClientDropDown();
        fetchOrderTypeDropDown();
      //  fetchClientDropDown();
        fetchWarningLevelDropDown();
        fetchOrderStatusDropDown();
        fetchPriorityDropDown();
        fetchAssetDropDownList();
        fetchReactiveCriticalityDropDown();

        new GetApiCallback(this, UrlClass.GET_WORK_ORDER_NO, new OnTaskCompleted<String>() {
            @Override
            public void onTaskCompleted(String response) {
                Log.d("Response",response);
               // woNo.setText(response.trim());

                response = response.replaceAll("^\"|\"$", "");
                woNo.setText(response);
            }
        },true).execute();

    }

    private void requestFocus(View view)
    {
        if(view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }
    private void nextEvent()
    {
        try {
            if (client.getSelectedItemPosition()==0)
            {
                Toast.makeText(this, "Client Not Found.", Toast.LENGTH_SHORT).show();
            }else  if(client.getSelectedItem().toString().trim().equals("Select ClientContract")){
                View v= client.getSelectedView();
                TextView tv= (TextView) v;
                if(tv.getText().toString().trim().equals("Select ClientContract")){
                    tv.setError("Select ClientContract");
                }
                Toast.makeText(this, "Please Select ClientContract", Toast.LENGTH_SHORT).show();
            }else if(client_no.getText().toString().trim().isEmpty()){
                client_no.setError("Please Enter ClientContract Id");
                requestFocus(client_no);
            }else if (purchaseOrderNumber.getSelectedItemPosition()==0){
                Toast.makeText(this, "Purchase Order Number not found.", Toast.LENGTH_SHORT).show();
            }
            else if(woNo.getText().toString().trim().isEmpty()){
                woNo.setError("Please Enter the Work Order Number");
                requestFocus(woNo);
            }else if (assetId.getSelectedItemPosition()==0){
                Toast.makeText(this, "AssetId not found.", Toast.LENGTH_SHORT).show();
            } /*else if(assetId.getSelectedItem().toString().trim().equals("Select Asset")) {
                View v = assetId.getSelectedView();
                TextView tv = (TextView) v;
                if (tv.getText().toString().trim().equals("Select Asset")) {
                    tv.setError("Please Select Asset");
                }
                //      Toast.makeText(this, "Please Select Assets", Toast.LENGTH_SHORT).show();
            }*/

            else if(dateRaised.getText().toString().trim().isEmpty()){
                dateRaised.setError("Please Enter Date Raised");
                requestFocus(dateRaised);
            }else if(dueDate.getText().toString().trim().isEmpty()){
                dueDate.setError("Please Enter Due Date");
                requestFocus(dueDate);
            }
            else if(orderType.getSelectedItemPosition()==0){

                Toast.makeText(this, "Please Select Order Type", Toast.LENGTH_SHORT).show();
            }else if (priority.getSelectedItemPosition()==0)
            {
                Toast.makeText(this, "Please Priority Type", Toast.LENGTH_SHORT).show();
            }
            else {
                workOrderNo=woNo.getText().toString();
                duedate=dueDate.getText().toString();
                dateraised=dateRaised.getText().toString();
                clientNo=client_no.getText().toString();

                Intent intent=new Intent(WorkOrder.this,WorkOrder1.class);
                Bundle bundle = new Bundle();

                Constants.workOrderPostResquest.setClientid(clientId);
                Constants.workOrderPostResquest.setAssetid(assetID);
                Constants.workOrderPostResquest.setPoNumber(poNo);

                Constants.workOrderPostResquest.setWorkOrderNumber(workOrderNo);

                Constants.workOrderPostResquest.setDateraised(dateraised);
                Constants.workOrderPostResquest.setDuedate(duedate);
                Constants.workOrderPostResquest.setWarningLevel(warning);
                Constants.workOrderPostResquest.setWorkOrderType(ordertype);
                Constants.workOrderPostResquest.setPriority(priorty);
            /*    bundle.putString("clientId",clientId);
                bundle.putString("clientNo",clientNo);
                bundle.putString("assetID",assetID);
                bundle.putString("poNo",poNo);
                bundle.putString("workOrderNo",workOrderNo);
                bundle.putString("warning",warning);
                bundle.putString("orderstatus",orderstatus);
              //  bundle.putString("priorty",priorty);
                bundle.putString("ordertype",ordertype);
                bundle.putString("dateraised",dateraised);
                bundle.putString("duedate",duedate);
                intent.putExtras(bundle);*/
                startActivity(intent);
            }
        }catch (Exception e)
        {
            Toast.makeText(this, "Data not found.", Toast.LENGTH_SHORT).show();
        }

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem refresh = menu.findItem(R.id.menu_refresh);
        refresh.setVisible(false);

        if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Contractor")){

            MenuItem m_asset = menu.findItem(R.id.menu_asset);
            m_asset.setVisible(false);
            /*MenuItem refresh = menu.findItem(R.id.menu_refresh);
            refresh.setVisible(false);*/
        }
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
    public void showDatePickerDialog1(View v){
        DialogFragment newFragment1 = new DatePickerFragment1();
        newFragment1.show(getSupportFragmentManager(), "datePicker");
    }
    public void showDatePickerDialog(View v){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static  class DatePickerFragment1 extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            /*dueDate.setText(day + "/" + (month + 1) + "/" + year);*/
            String months = "";
            String days = "";
            if ((month + 1) < 10) {
                months = "0" + (month + 1);
            } else {
                months = String.valueOf(month + 1);
            }

            if (day< 10) {
                days = "0" + day;
            } else {
                days = String.valueOf(day);
            }

            String date = months  + "-" + days + "-" + year;
            dueDate.setText(date);
        }
    }

    public static class DatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            String months = "";
            String days = "";
            if ((month + 1) < 10) {
                months = "0" + (month + 1);
            } else {
                months = String.valueOf(month + 1);
            }

            if (day< 10) {
                days = "0" + day;
            } else {
                days = String.valueOf(day);
            }

            String date = months  + "-" + days + "-" + year;
            dateRaised.setText(date);//year + "/" + (month + 1) + "/" + day
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
                        showPriorityDropDownList();
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
    private void showPriorityDropDownList()
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
            priority.setAdapter(adapter);
            priority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    priorty= Integer.parseInt(priorityDropDownLists.get(position).getValue());
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    private void fetchOrderStatusDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<OrderStatusDropDownList>> poListCall= apiServicesWorkOrder.oredrstatusdropdown("application/json","api/dropdown/getOrderStatus");
            poListCall.enqueue(new Callback<List<OrderStatusDropDownList>>() {
                @Override
                public void onResponse(Call<List<OrderStatusDropDownList>> call, Response<List<OrderStatusDropDownList>> response) {
                    if(response.body()!=null) {
                        orderStatusDropDownLists = response.body();
                        showOrderStatusDropDownList();
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
    private void showOrderStatusDropDownList()
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
            orderStatus.setAdapter(adapter);
            orderStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    orderstatus= orderStatusDropDownLists.get(position).getValue();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }
    }
    private void fetchWarningLevelDropDown(){
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<WarningLevelDropDownList>> poListCall= apiServicesWorkOrder.wldropdown("application/json","api/dropdown/warninglevel");
            poListCall.enqueue(new Callback<List<WarningLevelDropDownList>>() {
                @Override
                public void onResponse(Call<List<WarningLevelDropDownList>> call, Response<List<WarningLevelDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        warningLevelDropDownLists=response.body();
                        showWLDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<WarningLevelDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showWLDropDownList()
    {
        if(getApplicationContext()!=null) {
            String item[] = new String[warningLevelDropDownLists.size()];
            for (int i = 0; i < warningLevelDropDownLists.size(); i++) {
                item[i] = warningLevelDropDownLists.get(i).getDescription();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            warningLevel.setAdapter(adapter);
            warningLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    warning= warningLevelDropDownLists.get(position).getLevel();
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
                        showClientDropDownList();
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
    private void showClientDropDownList()
    {

        if(getApplicationContext()!=null)
        {
            String item[]=new String[clientDropDownLists.size()];
            for(int i=0;i<clientDropDownLists.size();i++)
            {
                item[i]=clientDropDownLists.get(i).getText();
                Log.d("Name & Id : ",clientDropDownLists.get(i).getText()+" "+clientDropDownLists.get(i).getValue());
            }
         if (item.length>0)
         {
             final ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
             adapter.setDropDownViewResource(R.layout.fortitle);
             client.setAdapter(adapter);
             client.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                 @Override
                 public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                     ClientId = Integer.parseInt(clientDropDownLists.get(position).getValue());
                     clientId= ""+ClientId;
                     client_no.setText(clientId);
                     client_no.setEnabled(false);
                     fetchAssetDropDownList();
                     if (position>0) {
                         fetchPONUmberDropDown("Client",clientId);
                     }
                 }
                 @Override
                 public void onNothingSelected(AdapterView<?> parent) {

                 }
             });
         }
        }
    }
    private void fetchPONUmberDropDown(String role,String companyId)
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<PurchaseOrderDropDownList>> poListCall= apiServicesWorkOrder.podropdown("application/json","api/dropdown/purchaseorder?rolename="+role+"&companyid="+companyId);
            poListCall.enqueue(new Callback<List<PurchaseOrderDropDownList>>() {
                @Override
                public void onResponse(Call<List<PurchaseOrderDropDownList>> call, Response<List<PurchaseOrderDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        poList=response.body();
                        showPODropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<PurchaseOrderDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showPODropDownList()
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[poList.size()];
            for(int i=0;i<poList.size();i++)
            {
                item[i]=poList.get(i).getText();
            }
         if (item.length>0)
         {
             ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
             adapter.setDropDownViewResource(R.layout.fortitle);
             purchaseOrderNumber.setAdapter(adapter);
             purchaseOrderNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                 @Override
                 public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                     poNo= poList.get(position).getValue();
                     Log.v("Select PO",poList.get(position).getText());
                     Log.v("Value of Select PO",poList.get(position).getValue());

                 }
                 @Override
                 public void onNothingSelected(AdapterView<?> parent) {

                 }
             });
         }
        }
    }
    private void fetchOrderTypeDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<OrderTypeDropDownList>> ListCall= apiServicesWorkOrder.otdropdown("application/json","api/dropdown/getordertype");
            ListCall.enqueue(new Callback<List<OrderTypeDropDownList>>() {
                @Override
                public void onResponse(Call<List<OrderTypeDropDownList>> call, Response<List<OrderTypeDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        otList=response.body();
                        showOtDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<OrderTypeDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showOtDropDownList()
    {
        String item[]=new String[otList.size()];
        for(int i=0;i<otList.size();i++)
        {
            item[i]=otList.get(i).getText();
            //  item[i]=otList.get(i).getValue();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
        adapter.setDropDownViewResource(R.layout.fortitle);
        orderType.setAdapter(adapter);
        orderType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ordertype=Integer.parseInt(otList.get(position).getValue());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void showAssetDropDownList(){
        if(getApplicationContext()!=null) {
            String item[]=new String[assetDropDownLists.size()];
            List<String> assetIdList=new ArrayList<>();
             assetIdList.add("Select Asset");
            for(int i=0;i<assetDropDownLists.size();i++)
            {
                item[i]=assetDropDownLists.get(i).getText();
                assetIdList.add(item[i]);
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,assetIdList);
            adapter.setDropDownViewResource(R.layout.fortitle);
            assetId.setAdapter(adapter);
            assetId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position>0) {
                        assetID = Integer.parseInt(assetDropDownLists.get(position-1).getValue());
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void fetchAssetDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetDropDownList>> ListCall= apiServicesWorkOrder.assetdropdown("application/json","api/dropdown/getaseetby?Clientid="+ClientId);
            ListCall.enqueue(new Callback<List<AssetDropDownList>>() {
                @Override
                public void onResponse(Call<List<AssetDropDownList>> call, Response<List<AssetDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        assetDropDownLists=response.body();
                        showAssetDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<AssetDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }


    public void fetchReactiveCriticalityDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<ReactiveCriticalityDropDown>> listCall= apiServicesWorkOrder.rcDropDownList("application/json","api/assetsdropdown/getcriticalities");
            listCall.enqueue(new Callback<List<ReactiveCriticalityDropDown>>() {
                @Override
                public void onResponse(Call<List<ReactiveCriticalityDropDown>> call, Response<List<ReactiveCriticalityDropDown>> response) {
                    if(response.body()!=null)
                    {
                        reactiveCriticalityDropDowns=response.body();
                       // for(int i=0;i<reactiveCriticalityDropDowns.size();i++)
                        //{
                           // if(reactiveCriticalityDropDowns.get(i).getValue().equals(updateReactiveCriticality))
                           // {
                                showReactiveCriticalityDropDownList();
                           // }
                     //   }
                    }
                }

                @Override
                public void onFailure(Call<List<ReactiveCriticalityDropDown>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    public void showReactiveCriticalityDropDownList()
    {
        if (getApplicationContext() != null) {
            String item[] = new String[reactiveCriticalityDropDowns.size()];
            for (int i = 0; i < reactiveCriticalityDropDowns.size(); i++) {
                item[i] = reactiveCriticalityDropDowns.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            sp_reactive_criticality.setAdapter(adapter);
            /*if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                sp_reactive_criticality.setSelection(spinnerPosition);
            }*/
            sp_reactive_criticality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                   Constants.workOrderPostResquest.setReactiveCriticality(Integer.parseInt(reactiveCriticalityDropDowns.get(position).getValue()));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

}
