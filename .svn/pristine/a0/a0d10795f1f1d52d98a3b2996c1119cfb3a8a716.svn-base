package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CpuUsageInfo;
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
import android.widget.Toast;


import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.workorderapplication.model.assetModel.InspectionFrequencyDropDown;
import com.workorder.app.workorderapplication.model.assetModel.ReactiveCriticalityDropDown;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Asset2 extends AppCompatActivity {
    Button pre, next;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String userrole,companyid,clientId,rolename;
    List<ReactiveCriticalityDropDown> reactiveCriticalityDropDowns;
    List<InspectionFrequencyDropDown> inspectionFrequencyDropDowns;
    Spinner reactiveCriticality,inspectionFrequency;
    static EditText nextInspectionDate,lastInspectionDate;
    EditText roomName,floor,assetUse,energyRating,inspectionProcedureResult,inspectionComments;
    String Client,AssetType,AssetStatus,Priority,WarningLevel,LoadDate,ClientNo,AssetId, AssetName,
            Description,ContractNo,InspectionComments, ContractType,AssetCategory,SubCategory,
            AssetCondition,Region,SubRegion,Location,Area,ConditionDate,AssetCode,AssetComent,
            BuildingName,Room,ReactiveCriticality,InspectionFrequency,NextInspectionDate,
            LastInspectionDate,RoomName,Floor,AssetUse,EnergyRating,InspectionProcedureResult;
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset2);
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
        getSupportActionBar().setTitle("ADD NEW ASSET");
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }
        userrole= preferenceManagerWorkOrder.getKey_User_Role();
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename= preferenceManagerWorkOrder.getKey_User_Name();
        Bundle intent=getIntent().getExtras();
        if(intent!=null)
        {
            Client=intent.getString("ClientContract");
            AssetType=intent.getString("AssetType");
            AssetStatus=intent.getString("AssetStatus");
            Priority=intent.getString("Priority");
            WarningLevel=intent.getString("WarningLevel");
            LoadDate=intent.getString("LoadDate");
            ClientNo=intent.getString("ClientNo");
            AssetId=intent.getString("AssetId");
            AssetName=intent.getString("AssetName");
            Description=intent.getString("Description");
            ContractNo=intent.getString("ContractNo");
            ContractType=intent.getString("ContractType");
            AssetCategory=intent.getString("AssetCategory");
            SubCategory=intent.getString("SubCategory");
            AssetCondition=intent.getString("AssetCondition");
            Region=intent.getString("Region");
            SubRegion=intent.getString("SubRegion");
            Location=intent.getString("Location");
            Area=intent.getString(  "Area");
            ConditionDate=intent.getString("ConditionDate");
            AssetCode=intent.getString("AssetCode");
            AssetComent=intent.getString("AssetComent");
            BuildingName=intent.getString("BuildingName");
            Room=intent.getString("Room");
        }
        inspectionComments=(EditText) findViewById(R.id.inspection_comments);
        reactiveCriticality=(Spinner)findViewById(R.id.spinner_reactive_criticality);
        inspectionFrequency=(Spinner) findViewById(R.id.spinner_inspection_frequency);
        nextInspectionDate=(EditText)findViewById(R.id.next_inspection_date);
        nextInspectionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        lastInspectionDate=(EditText)findViewById(R.id.last_inspection_date);
        lastInspectionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });
        roomName=(EditText)findViewById(R.id.room_name);
        floor=(EditText)findViewById(R.id.floor);
        assetUse=(EditText)findViewById(R.id.asset_use);
        energyRating=(EditText)findViewById(R.id.energy_rating);
        inspectionProcedureResult=(EditText)findViewById(R.id.inspection_procedure_result);

        next=(Button) findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextEvent();
              //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
        });

        pre=(Button) findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Asset2.this,Asset1.class);
                Bundle bundle=new Bundle();
                bundle.putString("ClientContract",Client);
                bundle.putString("AssetType",AssetType);
                bundle.putString("AssetStatus",AssetStatus);
                bundle.putString("Priority",Priority);
                bundle.putString("WarningLevel",WarningLevel);
                bundle.putString("LoadDate",LoadDate);
                bundle.putString("ClientNo",ClientNo);
                bundle.putString("AssetId",AssetId);
                bundle.putString("AssetName",AssetName);
                bundle.putString("Description",Description);
                bundle.putString("ContractNo",ContractNo);
                bundle.putString("ContractType",ContractType);
                bundle.putString("AssetCategory",AssetCategory);
                bundle.putString("SubCategory",SubCategory);
                bundle.putString("AssetCondition",AssetCondition);
                bundle.putString("Region",Region);
                bundle.putString("SubRegion",SubRegion);
                bundle.putString("Location",Location);
                bundle.putString("ConditionDate",ConditionDate);
                bundle.putString("AssetCode",AssetCode);
                bundle.putString("AssetComent",AssetComent);
                bundle.putString("BuildingName",BuildingName);
                bundle.putString("Room",Room);
                bundle.putString("Area",Area);
                intent.putExtras(bundle);
                startActivity(intent);
              //  overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });
        fetchReactiveCriticalityDropDown();
        fetchInspectionFrequencyDropDown();
    }

    private void requestFocus(View view)
    {
        if(view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }
    private void nextEvent(){
       try {
           if(roomName.getText().toString().trim().isEmpty()){
               roomName.setError("Please Enter RoomName");
               requestFocus(roomName);
           }else if(floor.getText().toString().trim().isEmpty()){
               floor.setError("Please Enter Floor");
               requestFocus(floor);
           }else if(assetUse.getText().toString().trim().isEmpty())
           {
               assetUse.setError("Please Enter Asset Use");
               requestFocus(assetUse);
           }else if(energyRating.getText().toString().trim().isEmpty()){
               energyRating.setError("Please Enter Energy Rating");
               requestFocus(energyRating);
           }
           else{
               NextInspectionDate=nextInspectionDate.getText().toString().trim();
               LastInspectionDate=lastInspectionDate.getText().toString().trim();
               RoomName=roomName.getText().toString().trim();
               Floor=floor.getText().toString().trim();
               AssetUse=assetUse.getText().toString().trim();
               EnergyRating=energyRating.getText().toString().trim();
               InspectionProcedureResult=inspectionProcedureResult.getText().toString().trim();
               InspectionComments=inspectionComments.getText().toString().trim();

               Constants.createAssetModel.setRoomName(roomName.getText().toString());
               Constants.createAssetModel.setFloor(floor.getText().toString());
               Constants.createAssetModel.setAssetUse(assetUse.getText().toString());
               Constants.createAssetModel.setEnergyRating(energyRating.getText().toString());
               Constants.createAssetModel.setCriticality(ReactiveCriticality);
               Constants.createAssetModel.setNextInspectionDate(nextInspectionDate.getText().toString());
               Constants.createAssetModel.setLastInspectionDate(lastInspectionDate.getText().toString());
               Constants.createAssetModel.setInspectionFrequency(InspectionFrequency);
               Constants.createAssetModel.setInspectionProcedureResult(inspectionProcedureResult.getText().toString());
               Constants.createAssetModel.setInspectionComments(inspectionComments.getText().toString());


               Intent intent=new Intent(Asset2.this,Asset3.class);
               Bundle bundle=new Bundle();
               bundle.putString("ClientContract",Client);
               bundle.putString("InspectionComments",InspectionComments);
               bundle.putString("AssetType",AssetType);
               bundle.putString("AssetStatus",AssetStatus);
               bundle.putString("Priority",Priority);
               bundle.putString("WarningLevel",WarningLevel);
               bundle.putString("LoadDate",LoadDate);
               bundle.putString("ClientNo",ClientNo);
               bundle.putString("AssetId",AssetId);
               bundle.putString("AssetName",AssetName);
               bundle.putString("Description",Description);
               bundle.putString("ContractNo",ContractNo);
               bundle.putString("ContractType",ContractType);
               bundle.putString("AssetCategory",AssetCategory);
               bundle.putString("SubCategory",SubCategory);
               bundle.putString("AssetCondition",AssetCondition);
               bundle.putString("Region",Region);
               bundle.putString("SubRegion",SubRegion);
               bundle.putString("Location",Location);
               bundle.putString("Area",Area);
               bundle.putString("ConditionDate",ConditionDate);
               bundle.putString("AssetCode",AssetCode);
               bundle.putString("AssetComent",AssetComent);
               bundle.putString("BuildingName",BuildingName);
               bundle.putString("Room",Room);
               bundle.putString("ReactiveCriticality",ReactiveCriticality);
               bundle.putString("InspectionFrequency",InspectionFrequency);
               bundle.putString("NextInspectionDate",NextInspectionDate);
               bundle.putString("LastInspectionDate",LastInspectionDate);
               bundle.putString("RoomName",RoomName);
               bundle.putString("Floor",Floor);
               bundle.putString("AssetUse",AssetUse);
               bundle.putString("EnergyRating",EnergyRating);
               bundle.putString("InspectionProcedureResult",InspectionProcedureResult);
               intent.putExtras(bundle);
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
                startActivity(new Intent(Asset2.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
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
                        showReactiveCriticalityDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<ReactiveCriticalityDropDown>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
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
            reactiveCriticality.setAdapter(adapter);
            reactiveCriticality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ReactiveCriticality = reactiveCriticalityDropDowns.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    public void fetchInspectionFrequencyDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<InspectionFrequencyDropDown>> listCall= apiServicesWorkOrder.ifDropDownList("application/json","api/assetsdropdown/getinspectionfrequency");
            listCall.enqueue(new Callback<List<InspectionFrequencyDropDown>>() {
                @Override
                public void onResponse(Call<List<InspectionFrequencyDropDown>> call, Response<List<InspectionFrequencyDropDown>> response) {
                    if(response.body()!=null)
                    {
                        inspectionFrequencyDropDowns=response.body();
                        showInspectionFrequencyDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<InspectionFrequencyDropDown>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showInspectionFrequencyDropDownList()
    {
        if (getApplicationContext() != null) {
            String item[] = new String[inspectionFrequencyDropDowns.size()];
            for (int i = 0; i < inspectionFrequencyDropDowns.size(); i++) {
                item[i] = inspectionFrequencyDropDowns.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            inspectionFrequency.setAdapter(adapter);
            inspectionFrequency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    InspectionFrequency = inspectionFrequencyDropDowns.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
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
            lastInspectionDate.setText(date);
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

            String date =months  + "-" + days + "-" + year;
            nextInspectionDate.setText(date);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
