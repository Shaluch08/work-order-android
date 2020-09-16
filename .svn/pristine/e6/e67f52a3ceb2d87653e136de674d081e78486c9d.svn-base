package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import com.workorder.app.workorderapplication.model.assetModel.AssetStatusDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.AssetTypeDropDownList;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.workOrderModel.AssetProcessTypePOJO;
import com.workorder.app.workorderapplication.model.workOrderModel.PriorityDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.WarningLevelDropDownList;
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

public class Asset extends AppCompatActivity {
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String userrole,companyid,clientId,rolename;
    Button next;
    static EditText loadDate;
    List<AssetStatusDropDownList> assetStatusDropDownLists;
    List<AssetDropDownList> assetDropDownLists;
    List<PriorityDropDownList> priorityDropDownLists;
    List<AssetTypeDropDownList> assetTypeDropDownLists;
    List<WarningLevelDropDownList> warningLevelDropDownLists;
    Spinner client,assetType,assetStatus,priority,warningLevel;
    Spinner sp_process_type;
    EditText clientNumber,assetId,assetName,description,contractNo;
    String Client="",AssetType="",AssetStatus,Priority,WarningLevel,ClientNo,AssetId,AssetName,Description,LoadDate,ContractNo;
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;


    String[] processTypeList;//={"Select","Temporary","Normal","Domestic"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
        {
            ArrayList<Treestuctutr> list= (ArrayList<Treestuctutr>) getIntent().getSerializableExtra("list");
            arrayList=list;
        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
            ArrayList<ContrctTree> contrctTreeArrayList=(ArrayList<ContrctTree>)getIntent().getSerializableExtra("contrctTreeList");
            contrctTrees=contrctTreeArrayList;
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ADD NEW ASSET");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(Color.WHITE);
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }
        userrole = preferenceManagerWorkOrder.getKey_User_Role();
        companyid = preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename = preferenceManagerWorkOrder.getKey_User_Name();
        client = (Spinner) findViewById(R.id.spinner_client);
        sp_process_type=findViewById(R.id.spinner_process_type);
        assetType = (Spinner) findViewById(R.id.spinner_asset_type);
        assetStatus = (Spinner) findViewById(R.id.spinner_asset_status);
        priority = (Spinner) findViewById(R.id.spinner_priority);
        warningLevel = (Spinner) findViewById(R.id.spinner_warning_level);
        contractNo=(EditText)findViewById(R.id.contract_number);
        clientNumber = (EditText) findViewById(R.id.clientNo);
       // assetId = (EditText) findViewById(R.id.asset_id);
        assetName = (EditText) findViewById(R.id.asset_name);
        description = (EditText) findViewById(R.id.txt_description);
        loadDate=(EditText)findViewById(R.id.load_date);
        loadDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        next = (Button) findViewById(R.id.btn_next);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    nextEvent();
            //    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        Button pre = (Button) findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Asset.this, SearchAsset.class));
           //     overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });
        fetchClientDropDown();
        fetchAssetStatusDropDown();
        fetchPriorityDropDown();
        fetchWarningLevelDropDown();
        fetchAssetTypeDropDown();
        fetProcessTypeDropDown();
    }

    List<AssetProcessTypePOJO> processTypePOJOList=new ArrayList<>();
    public void fetProcessTypeDropDown()
    {
        new GetApiCallback(this, UrlClass.ASSET_PROCESS_TYPE_URL, new OnTaskCompleted<String>() {
            @Override
            public void onTaskCompleted(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("data");
                    processTypePOJOList= Arrays.asList(new Gson().fromJson(array.toString(),AssetProcessTypePOJO[].class));
                    processTypeList=new String[processTypePOJOList.size()];
                    for (int i=0;i<processTypePOJOList.size();i++)
                    {
                        processTypeList[i]=processTypePOJOList.get(i).getSubtypetext();
                    }
                    sp_process_type.setAdapter(new ArrayAdapter<String>(Asset.this,android.R.layout.simple_list_item_1,processTypeList));

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        },true).execute();
    }


    private void nextEvent()
    {
       try {
           if (Client.equals("")){
               Toast.makeText(this, "Client Not Found", Toast.LENGTH_SHORT).show();
           }else if(client.getSelectedItem().toString().trim().equals("Select Client"))
           {
               View selectedView = client.getSelectedView();
               TextView tv=(TextView) selectedView;
               /*if(tv.getText().toString().trim().equals("Please Select Client"))*/
               tv.setError("Please Select Client");
               requestFocus(tv);

               Toast.makeText(Asset.this, "Please Select Client", Toast.LENGTH_LONG).show();
           }
           else if(clientNumber.getText().toString().trim().isEmpty())
           {
               clientNumber.setError("Please Select Client Number");
               requestFocus(clientNumber);
           }else if(assetName.getText().toString().trim().isEmpty())
           {
               assetName.setError("Please Enter Asset Name");
               requestFocus(assetName);
           }else if (AssetType.equals("")){
               Toast.makeText(this, "Asset Type not Found.", Toast.LENGTH_SHORT).show();
           }
           else if(assetType.getSelectedItem().toString().trim().equals("Please Select Asset Type"))
           {
               View selectedView = assetType.getSelectedView();
               TextView tv=(TextView) selectedView;
               /*if(tv.getText().toString().trim().equals("Please Select Asset Type"))*/
               tv.setError("Please Select Asset Type");
               requestFocus(tv);

               Toast.makeText(Asset.this, "Please Select Asset Type", Toast.LENGTH_LONG).show();
           }else if (sp_process_type.getSelectedItemPosition()==0)
           {
               Toast.makeText(this, "Please Select Process Type.", Toast.LENGTH_SHORT).show();
           }
           else if(contractNo.getText().toString().trim().isEmpty()){
               contractNo.setError("Please Enter Contract Number");
               requestFocus(contractNo);
           }else if(loadDate.getText().toString().trim().isEmpty()){
               loadDate.setError("Enter Load Date");
               requestFocus(loadDate);
           }
           else{
               LoadDate = loadDate.getText().toString().trim();
               ContractNo = contractNo.getText().toString().trim();
               ClientNo = clientNumber.getText().toString().trim();
             //  AssetId = assetId.getText().toString().trim();
               AssetName = assetName.getText().toString().trim();
               Description = description.getText().toString().trim();
               //Constants.createAssetModel.setClient(client.getSelectedItem().toString());
               Constants.createAssetModel.setClientNo(clientNumber.getText().toString());
              // Constants.createAssetModel.setAssetID(assetId.getText().toString());
               Constants.createAssetModel.setAssetName(assetName.getText().toString());
               Constants.createAssetModel.setAssetType(Integer.parseInt(AssetType));
               Constants.createAssetModel.setLoadDate(UtilityFunction.ddMMyyyyToMMddyyyy(LoadDate));
               //Constants.createAssetModel
               Constants.createAssetModel.setProcessType(String.valueOf(processTypePOJOList.get(sp_process_type.getSelectedItemPosition()).getSubtypeid()));
               Constants.createAssetModel.setDescription(Description);
               Constants.createAssetModel.setPriority(Integer.parseInt(Priority));
               Constants.createAssetModel.setWarningLevel(Integer.parseInt(WarningLevel));
               try {
                   Constants.createAssetModel.setEntityStatus(Integer.valueOf(AssetStatus));
               }catch (Exception e)
               {
                   e.printStackTrace();
               }

               Constants.createAssetModel.setContractNo(ContractNo);

               Intent intent = new Intent(Asset.this, Asset1.class);
               Bundle bundle = new Bundle();
               bundle.putString("ClientContract", Client);
               bundle.putString("AssetType", AssetType);
               bundle.putString("AssetStatus", AssetStatus);
               bundle.putString("ContractNo", ContractNo);
               bundle.putString("LoadDate", LoadDate);
               bundle.putString("Priority", Priority);
               bundle.putString("WarningLevel", WarningLevel);
               bundle.putString("ClientNo", ClientNo);
               bundle.putString("AssetId", AssetId);
               bundle.putString("AssetName", AssetName);
               bundle.putString("Description", Description);
               intent.putExtras(bundle);
               startActivity(intent);
               return;
           }
       }catch (Exception e)
       {
           Toast.makeText(this, "Data not found", Toast.LENGTH_SHORT).show();
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
            return new DatePickerDialog(getContext(),this, year, month, day);
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

            String date =months  + "-" + days + "-" + year;


            loadDate.setText(date);
        }
    }
    private void requestFocus(View view)
    {
        if(view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem refresh = menu.findItem(R.id.menu_refresh);
        refresh.setVisible(false);
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
               // startActivity(new Intent(Asset.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
              //  finish();
                UtilityFunction.logOutAlert(this);
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
    public void fetchAssetStatusDropDown(){
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetStatusDropDownList>> listCall= apiServicesWorkOrder.assetStatusDropDownList("application/json","api/assetsdropdown/getassetStatus");
            listCall.enqueue(new Callback<List<AssetStatusDropDownList>>() {
                @Override
                public void onResponse(Call<List<AssetStatusDropDownList>> call, Response<List<AssetStatusDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        assetStatusDropDownLists=response.body();
                        showAssetStatusDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<AssetStatusDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showAssetStatusDropDownList()
    {
        String item[]=new String[assetStatusDropDownLists.size()];
        for(int i=0;i<assetStatusDropDownLists.size();i++)
        {
            item[i]=assetStatusDropDownLists.get(i).getText();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
        adapter.setDropDownViewResource(R.layout.fortitle);
        assetStatus.setAdapter(adapter);
        assetStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AssetStatus=assetStatusDropDownLists.get(position).getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void fetchWarningLevelDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<WarningLevelDropDownList>> listCall= apiServicesWorkOrder.wldropdown("application/json","api/assetsdropdown/warninglevel?companyid)="+companyid);
            listCall.enqueue(new Callback<List<WarningLevelDropDownList>>() {
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
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showWLDropDownList(){
        String item[]=new String[warningLevelDropDownLists.size()];
        for(int i=0;i<warningLevelDropDownLists.size();i++)
        {
            item[i]=warningLevelDropDownLists.get(i).getDescription();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);

        adapter.setDropDownViewResource(R.layout.fortitle);
        warningLevel.setAdapter(adapter);
        warningLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                WarningLevel= String.valueOf(warningLevelDropDownLists.get(position).getLevel());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void fetchPriorityDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<PriorityDropDownList>> listCall= apiServicesWorkOrder.prioritydropdown("application/json","api/assetsdropdown/getpriority");
            listCall.enqueue(new Callback<List<PriorityDropDownList>>() {
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
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showPriorityDropDownList()
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
                    Priority=priorityDropDownLists.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    public void fetchAssetTypeDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetTypeDropDownList>> listCall= apiServicesWorkOrder.assetTypeDropDownList("application/json","api/assetsdropdown/getassettype?companyid="+companyid);
            listCall.enqueue(new Callback<List<AssetTypeDropDownList>>() {
                @Override
                public void onResponse(Call<List<AssetTypeDropDownList>> call, Response<List<AssetTypeDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        assetTypeDropDownLists=response.body();
                        showAssetTypeDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<AssetTypeDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showAssetTypeDropDownList() {
        if (getApplicationContext() != null) {
            String item[] = new String[assetTypeDropDownLists.size()];
            for (int i = 0; i < assetTypeDropDownLists.size(); i++) {
                item[i] = assetTypeDropDownLists.get(i).getText();
            }
           if (item.length>0)
           {
               ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
               adapter.setDropDownViewResource(R.layout.fortitle);
               assetType.setAdapter(adapter);
               assetType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                   @Override
                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                       AssetType = assetTypeDropDownLists.get(position).getValue();
                   }

                   @Override
                   public void onNothingSelected(AdapterView<?> parent) {

                   }
               });
           }
        }
    }
    private void fetchClientDropDown(){
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetDropDownList>> listCall= apiServicesWorkOrder.assetDropDownList("application/json","api/assetsdropdown/getclient?companyid="+companyid);
            listCall.enqueue(new Callback<List<AssetDropDownList>>() {
                @Override
                public void onResponse(Call<List<AssetDropDownList>> call, Response<List<AssetDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        assetDropDownLists=response.body();
                        showClientDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<AssetDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    private void showClientDropDownList()
    {

        if(getApplicationContext()!=null)
        {
            int size=assetDropDownLists.size();
            String item[]=new String[size];
            for(int i=0;i<size;i++)
            {
                item[i]=assetDropDownLists.get(i).getText();
            }

            if (item.length>0)
            {
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item) ;
                adapter.setDropDownViewResource(R.layout.fortitle);
                client.setAdapter(adapter);
                client.setPopupBackgroundResource(R.color.even);
                client.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Client= assetDropDownLists.get(position).getValue();
                        clientNumber.setText(Client);
                        clientNumber.setEnabled(false);
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
