package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.workOrderModel.AproveByDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.AssetProcessTypePOJO;
import com.workorder.app.workorderapplication.model.workOrderModel.OriginalOrderDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.RequestByDropDownList;
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

public class WorkOrder1 extends AppCompatActivity {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    Spinner sp_process_type,sp_client,sp_requestBy,sp_originalOrder;
    List<RequestByDropDownList> requestByDropDownLists;
    List<AproveByDropDownList> aproveByDropDownLists;
    List<OriginalOrderDropDownList> originalOrderDropDownLists;
    String clientId,rolename,companyid;
    Button next;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    EditText scope,clientOrderNo;
    EditText et_wo_cost;
    static EditText clientaprovedate;
    CheckBox clientaproval;
    boolean clientaprov=false;
    String clientName,clientorderNo,originalorder,requestby="",clientaproveddate="",desciption,clientaproveby,AssetId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order1);
        et_wo_cost=findViewById(R.id.estimated_wo_cost);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        clientOrderNo=(EditText) findViewById(R.id.client_order_no);
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

       /* Bundle intent=getIntent().getExtras();
        if (intent != null) {
            clientId=intent.getString("clientId");
            clientNo=intent.getString("clientNo");
            poNo=intent.getString("poNo");
            workOrderNo=intent.getString("workOrderNo");
            warning=intent.getString("warning");
            orderstatus=intent.getString("orderstatus");
            //priorty=intent.getString("priorty");
            AssetId = intent.getString("assetID");
            orderstatus=intent.getString("orderstatus");
            ordertype=intent.getString("ordertype");
            dateraised=intent.getString("dateraised");
            duedate=intent.getString("duedate");
        }*/
        clientaproval=(CheckBox) findViewById(R.id.client_approval);
        scope=(EditText) findViewById(R.id.txt_scope_description);
        scope.setEnabled(false);
        clientaprovedate=(EditText) findViewById(R.id.client_approval_date);
        clientaprovedate.setEnabled(false);
        clientaprovedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        rolename= preferenceManagerWorkOrder.getKey_User_Name();
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        sp_process_type=findViewById(R.id.spinner_process_type);
        sp_client=(Spinner) findViewById(R.id.spinner_client_approval_by);
        sp_client.setEnabled(false);
        sp_requestBy=(Spinner) findViewById(R.id.spinner_requested_by);
        sp_originalOrder=(Spinner) findViewById(R.id.spinner_original_order_no);

        clientaproval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    clientaprovedate.setEnabled(true);
                    clientaprovedate.setFocusable(false);
                    sp_client.setEnabled(true);
                    scope.setEnabled(true);

                }else {
                    clientaprovedate.setEnabled(false);
                    sp_client.setEnabled(false);
                    scope.setEnabled(false);
                }
            }
        });

        Button next=(Button) findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextEvent();
              //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        Button pre=(Button) findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
              //  Intent intent=new Intent(WorkOrder1.this,WorkOrder.class);
               /* Bundle bundle = new Bundle();
                bundle.putString("clientId",clientId);
                bundle.putString("clientNo",clientNo);
                bundle.putString("poNo",poNo);
                bundle.putString("workOrderNo",workOrderNo);
                bundle.putString("warning",warning);
                bundle.putString("orderstatus",orderstatus);
                bundle.putString("priorty",priorty);
                bundle.putString("ordertype",ordertype);
                bundle.putString("clientorderNo",clientorderNo);
                bundle.putString("dateraised",dateraised);
                bundle.putString("duedate",duedate);
                intent.putExtras(bundle);
*/             //  startActivity(intent);
             //   overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });

        clientId=String.valueOf(Constants.workOrderPostResquest.getClientid());

        fetchClientAproveByDropDownList();
        fetchRequestByDropDownList();
        fetchOriginalOrderDropDownList();
        fetProcessTypeDropDown();

    }
    List<AssetProcessTypePOJO> processTypePOJOList = new ArrayList<>();
    String[] processTypeList;

    public void fetProcessTypeDropDown() {
        new GetApiCallback(this, UrlClass.WO_PROCESS_TYPE_URL, new OnTaskCompleted<String>() {
            @Override
            public void onTaskCompleted(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("data");
                    processTypePOJOList = Arrays.asList(new Gson().fromJson(array.toString(), AssetProcessTypePOJO[].class));
                    processTypeList = new String[processTypePOJOList.size()];
                    for (int i = 0; i < processTypePOJOList.size(); i++) {
                        processTypeList[i] = processTypePOJOList.get(i).getSubtypetext();
                    }
                    sp_process_type.setAdapter(new ArrayAdapter<String>(WorkOrder1.this, android.R.layout.simple_list_item_1, processTypeList));




                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, true).execute();
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
            if(clientOrderNo.getText().toString().equals("")){
                clientOrderNo.setError("Please Enter ClientContract Order Number");
                requestFocus(clientOrderNo);
            }
             else if(clientaproval.isChecked()){

                if (TextUtils.isEmpty(clientaprovedate.getText().toString().trim())){
                    clientaprovedate.setError("Enter Client Approval Date");
                }else {




                    clientorderNo=clientOrderNo.getText().toString();
                    clientaproveddate=clientaprovedate.getText().toString();
                    desciption=scope.getText().toString();

                   // Constants.workOrderPostResquest.setiD(clientId);


                  //  Constants.workOrderPostResquest.setWarningLevel(warning);
                    Constants.workOrderPostResquest.setClientworkorderno(clientorderNo);
                    Constants.workOrderPostResquest.setEstimatedWorkOrderCost(Integer.parseInt(et_wo_cost.getText().toString().trim()));
                    Constants.workOrderPostResquest.setProcessType(processTypePOJOList.get(sp_process_type.getSelectedItemPosition()).getSubtypeid());
                    Constants.workOrderPostResquest.setOriginalWorkOrderNo(originalorder);

                    Constants.workOrderPostResquest.setRequestedBy(requestby);
                    Constants.workOrderPostResquest.setClientapproval(clientaprov);
                    Constants.workOrderPostResquest.setClientapprovaldate(clientaproveddate);
                    Constants.workOrderPostResquest.setAssignedto("2126");

                   // Constants.workOrderPostResquest.setClientid("2124");
                    Constants.workOrderPostResquest.setExtensionApprovedById(clientaproveby);
                    Constants.workOrderPostResquest.setDescription(desciption);

                    Intent intent=new Intent(WorkOrder1.this,Work_Order1.class);
               /*     Bundle bundle = new Bundle();
                    bundle.putString("clientId",clientId);
                    bundle.putString("clientNo",clientNo);
                    bundle.putString("poNo",poNo);
                    bundle.putString("clientorderNo",clientorderNo);
                    bundle.putString("workOrderNo",workOrderNo);
                    bundle.putString("warning",warning);
                    bundle.putString("orderstatus",orderstatus);
                    bundle.putString("priorty",priorty);
                    bundle.putString("ordertype",ordertype);
                    bundle.putString("duedate",duedate);
                    bundle.putString("dateraised",dateraised);
                    bundle.putString("originalorder",originalorder);
                    bundle.putString("assetID",AssetId);
                    bundle.putString("requestby",requestby);
                    bundle.putString("clientaproveddate",clientaproveddate);
                    bundle.putString("desciption",desciption);
                    bundle.putBoolean("clientaprov",clientaprov);
                    bundle.putString("clientaproveby",clientaproveby);
                    intent.putExtras(bundle);*/
                    startActivity(intent);


                }


            }

        }catch (Exception e)
        {
            if (TextUtils.isEmpty(clientaprovedate.getText().toString().trim())){
                clientaprovedate.setError("Enter Client Approval Date");
            }else {
                clientorderNo=clientOrderNo.getText().toString();
                clientaproveddate=clientaprovedate.getText().toString();
                desciption=scope.getText().toString();
                Intent intent=new Intent(WorkOrder1.this,Work_Order1.class);
          /*      Bundle bundle = new Bundle();
                bundle.putString("clientId",clientId);
                bundle.putString("clientNo",clientNo);
                bundle.putString("poNo",poNo);
                bundle.putString("clientorderNo",clientorderNo);
                bundle.putString("workOrderNo",workOrderNo);
                bundle.putString("warning",warning);
                bundle.putString("orderstatus",orderstatus);
                bundle.putString("priorty",priorty);
                bundle.putString("ordertype",ordertype);
                bundle.putString("duedate",duedate);
                bundle.putString("dateraised",dateraised);
                bundle.putString("originalorder",originalorder);
                bundle.putString("assetID",AssetId);
                bundle.putString("requestby",requestby);
                bundle.putString("clientaproveddate",clientaproveddate);
                bundle.putString("desciption",desciption);
                bundle.putBoolean("clientaprov",clientaprov);
                bundle.putString("clientaproveby",clientaproveby);
                intent.putExtras(bundle);*/
                startActivity(intent);


            }
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
    public void showDatePickerDialog(View v){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
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
            clientaprovedate.setText(date);//year + "/" + (month + 1) + "/" + day
        }
    }
    private void fetchOriginalOrderDropDownList()
    {

        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<OriginalOrderDropDownList>> ListCall= apiServicesWorkOrder.originalorderdropdown("application/json","api/dropdown/workordernum?rolename="+rolename+"&companyid="+companyid);
            ListCall.enqueue(new Callback<List<OriginalOrderDropDownList>>() {
                @Override
                public void onResponse(Call<List<OriginalOrderDropDownList>> call, Response<List<OriginalOrderDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        originalOrderDropDownLists=response.body();
                        showOriginalOrderDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<OriginalOrderDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private  void showOriginalOrderDropDownList()
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[originalOrderDropDownLists.size()];
            for(int i=0;i<originalOrderDropDownLists.size();i++)
            {
                item[i]=originalOrderDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            sp_originalOrder.setAdapter(adapter);
            sp_originalOrder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    originalorder=originalOrderDropDownLists.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    private void fetchClientAproveByDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AproveByDropDownList>> ListCall= apiServicesWorkOrder.aprovebyordropdown("application/json","api/dropdown/aproveby?companyid="+companyid);
            ListCall.enqueue(new Callback<List<AproveByDropDownList>>() {
                @Override
                public void onResponse(Call<List<AproveByDropDownList>> call, Response<List<AproveByDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        aproveByDropDownLists=response.body();
                        showAproveByDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<AproveByDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showAproveByDropDownList()
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[aproveByDropDownLists.size()];
            for(int i=0;i<aproveByDropDownLists.size();i++)
            {
                item[i]=aproveByDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            sp_client.setAdapter(adapter);
            sp_client.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    clientaproveby= String.valueOf(aproveByDropDownLists.get(position).getValue());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    private void fetchRequestByDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<RequestByDropDownList>> ListCall= apiServicesWorkOrder.requestbyordropdown("application/json","api/dropdown/getrequestby?clientId="+clientId);
            ListCall.enqueue(new Callback<List<RequestByDropDownList>>() {
                @Override
                public void onResponse(Call<List<RequestByDropDownList>> call, Response<List<RequestByDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        requestByDropDownLists=response.body();
                        showRequestByDropDownList();
                    }
                }
                @Override
                public void onFailure(Call<List<RequestByDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showRequestByDropDownList()
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[requestByDropDownLists.size()];
            for(int i=0;i<requestByDropDownLists.size();i++)
            {
                item[i]=requestByDropDownLists.get(i).getText();
            }

            if (item.length>0) {
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
                adapter.setDropDownViewResource(R.layout.fortitle);
                sp_requestBy.setAdapter(adapter);
                sp_requestBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        requestby= String.valueOf(requestByDropDownLists.get(position).getValue());

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
