package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.workorderapplication.activity.Asset2;
import com.workorder.app.workorderapplication.activity.Asset4;
import com.workorder.app.workorderapplication.activity.MainActivity;
import com.workorder.app.workorderapplication.activity.SearchAsset;
import com.workorder.app.workorderapplication.activity.SearchPurchaseOrder;
import com.workorder.app.workorderapplication.activity.SearchWorkOrder;
import com.workorder.app.workorderapplication.model.assetModel.MaintenanceFrequencyDropDown;
import com.workorder.app.workorderapplication.model.assetModel.MaintenanceStrategyDropDown;
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

public class Asset3 extends AppCompatActivity {
    CheckBox statutoryMaintenance;
    Spinner maintenanceStrategy, maintenanceFrequency;
    static EditText nextMaintenanceDate, lastMaintenanceDate;
    EditText maintenanceProcedureResult, maintenanceComments;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String userrole, companyid, clientId, rolename;
    List<MaintenanceFrequencyDropDown> maintenanceFrequencyDropDownList;
    List<MaintenanceStrategyDropDown> maintenanceStrategyDropDownList;
    String Client, AssetType, AssetStatus, Priority, WarningLevel, LoadDate, ClientNo, AssetId, AssetName, Description, ContractNo,
            ContractType, AssetCategory, SubCategory, AssetCondition, Region, SubRegion, Location, Area, ConditionDate, AssetCode, AssetComent, BuildingName, Room, ReactiveCriticality, InspectionFrequency, NextInspectionDate, LastInspectionDate, RoomName, Floor, AssetUse, EnergyRating, InspectionProcedureResult, InspectionComments, MaintenanceStrategy, MaintenanceFrequency, NextMaintenanceDate, LastMaintenanceDate, MaintenanceProcedureResult, MaintenanceComments;
    boolean StatutoryMaintenance;
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset3);
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
        userrole = preferenceManagerWorkOrder.getKey_User_Role();
        companyid = preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename = preferenceManagerWorkOrder.getKey_User_Name();
        Bundle intent=getIntent().getExtras();
        if (intent != null) {
            InspectionComments = intent.getString("InspectionComments");
            Client = intent.getString("ClientContract");
            AssetType = intent.getString("AssetType");
            AssetStatus =intent.getString("AssetStatus");
            Priority = intent.getString("Priority");
            WarningLevel = intent.getString("WarningLevel");
            LoadDate = intent.getString("LoadDate");
            ClientNo =intent.getString("ClientNo");
            AssetId = intent.getString("AssetId");
            AssetName = intent.getString("AssetName");
            Description =intent.getString("Description");
            ContractNo = intent.getString("ContractNo");
            ContractType = intent.getString("ContractType");
            AssetCategory = intent.getString("AssetCategory");
            SubCategory = intent.getString("SubCategory");
            AssetCondition = intent.getString("AssetCondition");
            Region = intent.getString("Region");
            SubRegion = intent.getString("SubRegion");
            Location = intent.getString("Location");
            Area = intent.getString("Area");
            ConditionDate = intent.getString("ConditionDate");
            AssetCode = intent.getString("AssetCode");
            AssetComent = intent.getString("AssetComent");
            BuildingName = intent.getString("BuildingName");
            Room = intent.getString("Room");
            ReactiveCriticality = intent.getString("ReactiveCriticality");
            InspectionFrequency = intent.getString("InspectionFrequency");
            NextInspectionDate = intent.getString("NextInspectionDate");
            LastInspectionDate = intent.getString("LastInspectionDate");
            RoomName = intent.getString("RoomName");
            Floor = intent.getString("Floor");
            AssetUse = intent.getString("AssetUse");
            EnergyRating = intent.getString("EnergyRating");
            InspectionProcedureResult = intent.getString("InspectionProcedureResult");
        }

        statutoryMaintenance = (CheckBox) findViewById(R.id.statutory_maintenance);
        maintenanceStrategy = (Spinner) findViewById(R.id.spinner_maintenance_strategy);
       // maintenanceStrategy.setEnabled(false);
        maintenanceFrequency = (Spinner) findViewById(R.id.spinner_maintenance_frequency);
       // maintenanceFrequency.setEnabled(false);

        nextMaintenanceDate = (EditText) findViewById(R.id.next_maintenance_date);
      //  nextMaintenanceDate.setEnabled(false);
        nextMaintenanceDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        lastMaintenanceDate = (EditText) findViewById(R.id.last_maintenance_date);
      //  lastMaintenanceDate.setEnabled(false);
        lastMaintenanceDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });

        maintenanceProcedureResult = (EditText) findViewById(R.id.maintenance_procedure_result);
     //   maintenanceProcedureResult.setEnabled(false);
        maintenanceComments = (EditText) findViewById(R.id.maintenance_comments);
      //  maintenanceComments.setEnabled(false);

        statutoryMaintenance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constants.createAssetModel.setStatutoryMaintenance(isChecked);

                /*if (isChecked){

                    maintenanceStrategy.setEnabled(true);
                    maintenanceFrequency.setEnabled(true);
                    nextMaintenanceDate.setEnabled(true);
                    lastMaintenanceDate.setEnabled(true);
                    maintenanceProcedureResult.setEnabled(true);
                    maintenanceComments.setEnabled(true);

                    if (maintenanceStrategy.getSelectedItem().toString().equals("Select Maintenance Strategy")) {
                        TextView tv = (TextView) maintenanceStrategy.getSelectedView();
                        *//*if (tv.getText().toString().trim().equals("Maintenance Strategy"))*//*
                        tv.setError("Select Maintenance Strategy");

                    } else if (nextMaintenanceDate.getText().toString().trim().isEmpty()) {
                        nextMaintenanceDate.setError("Select Next Maintenance Date");
                        requestFocus(nextMaintenanceDate);

                    } else if (lastMaintenanceDate.getText().toString().trim().isEmpty()) {
                        lastMaintenanceDate.setError("Select Last Maintenance Date");
                        requestFocus(lastMaintenanceDate);

                    } else if (maintenanceFrequency.getSelectedItem().toString().equals("Maintenance Frequency")) {
                        TextView tv = (TextView) maintenanceFrequency.getSelectedView();
                        if (tv.getText().toString().trim().equals("Select Maintenance Frequency")) {
                            tv.setError("Select Maintenance Frequency");
                        }

                    } else if (maintenanceProcedureResult.getText().toString().isEmpty()) {
                        maintenanceProcedureResult.setError("Select Maintenance Procedure Result");
                        requestFocus(maintenanceProcedureResult);
                    }
                }else {
                    maintenanceStrategy.setEnabled(false);
                    maintenanceFrequency.setEnabled(false);
                    nextMaintenanceDate.setEnabled(false);
                    lastMaintenanceDate.setEnabled(false);
                    maintenanceProcedureResult.setEnabled(false);
                    maintenanceComments.setEnabled(false);


                }*/
            }
        });

        Button next = (Button) findViewById(R.id.btn_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextEvent();
               // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        Button pre =(Button) findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Asset3.this, Asset2.class);
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
               // overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });
        fetchMaintenanceStrategyDropDown();
        fetchMaintenanceFrequencyDropDown();
    }
    private void requestFocus(View view)
    {
        if(view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }
    private void nextEvent() {

       try {
           if (maintenanceStrategy.getSelectedItemPosition()==0)
           {
               Toast.makeText(this, "Please Select Maintenance Strategy.", Toast.LENGTH_SHORT).show();
           }else if (nextMaintenanceDate.getText().toString().equals(""))
           {
               Toast.makeText(this, "Please select Next Maintenance Date.", Toast.LENGTH_SHORT).show();
           }else if (lastMaintenanceDate.getText().toString().equals(""))
           {
               Toast.makeText(this, "Please select Last Maintenance Date.", Toast.LENGTH_SHORT).show();
           }else if (maintenanceFrequency.getSelectedItemPosition()==0)
           {
               Toast.makeText(this, "Please Select Maintenance Frequency.", Toast.LENGTH_SHORT).show();
           }else if (maintenanceProcedureResult.getText().toString().equals(""))
           {
               maintenanceProcedureResult.setError("Please enter Maintenance Procedure Result.");
           }else {


               if (statutoryMaintenance.isChecked()) {
                   Constants.createAssetModel.setStatutoryMaintenance(true);
               }else {
                   Constants.createAssetModel.setStatutoryMaintenance(false);
               }
               Constants.createAssetModel.setStrategy(MaintenanceStrategy);
               Constants.createAssetModel.setNextMaintenanceDate(nextMaintenanceDate.getText().toString());
               Constants.createAssetModel.setLastMaintenanceDate(lastMaintenanceDate.getText().toString());
               Constants.createAssetModel.setMaintenaceFrequency(MaintenanceFrequency);
               Constants.createAssetModel.setMaintenanceProcedureResult(maintenanceProcedureResult.getText().toString());
               Constants.createAssetModel.setMaintenanceComments(maintenanceComments.getText().toString());


               Intent intent = new Intent(Asset3.this, Asset4.class);
               Bundle bundle = new Bundle();
               bundle.putString("ClientContract", Client);
               bundle.putString("InspectionComments", InspectionComments);
               bundle.putString("AssetType", AssetType);
               bundle.putString("AssetStatus", AssetStatus);
               bundle.putString("Priority", Priority);
               bundle.putString("WarningLevel", WarningLevel);
               bundle.putString("LoadDate", LoadDate);
               bundle.putString("ClientNo", ClientNo);
               bundle.putString("AssetId", AssetId);
               bundle.putString("AssetName", AssetName);
               bundle.putString("Description", Description);
               bundle.putString("ContractNo", ContractNo);
               bundle.putString("ContractType", ContractType);
               bundle.putString("AssetCategory", AssetCategory);
               bundle.putString("SubCategory", SubCategory);
               bundle.putString("AssetCondition", AssetCondition);
               bundle.putString("Region", Region);
               bundle.putString("SubRegion", SubRegion);
               bundle.putString("Location", Location);
               bundle.putString("Area", Area);
               bundle.putString("ConditionDate", ConditionDate);
               bundle.putString("AssetCode", AssetCode);
               bundle.putString("AssetComent", AssetComent);
               bundle.putString("BuildingName", BuildingName);
               bundle.putString("Room", Room);
               bundle.putString("ReactiveCriticality", ReactiveCriticality);
               bundle.putString("InspectionFrequency", InspectionFrequency);
               bundle.putString("NextInspectionDate", NextInspectionDate);
               bundle.putString("LastInspectionDate", LastInspectionDate);
               bundle.putString("RoomName", RoomName);
               bundle.putString("Floor", Floor);
               bundle.putString("AssetUse", AssetUse);
               bundle.putString("EnergyRating", EnergyRating);
               bundle.putString("InspectionProcedureResult", InspectionProcedureResult);
               bundle.putBoolean("StatutoryMaintenance", StatutoryMaintenance);
               bundle.putString("MaintenanceStrategy", MaintenanceStrategy);
               bundle.putString("MaintenanceFrequency", MaintenanceFrequency);
               bundle.putString("NextMaintenanceDate", NextMaintenanceDate);
               bundle.putString("LastMaintenanceDate", LastMaintenanceDate);
               bundle.putString("MaintenanceProcedureResult", MaintenanceProcedureResult);
               bundle.putString("MaintenanceComments", MaintenanceComments);
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
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                return true;
            case R.id.menu_asset:
                Toast.makeText(this, "Asset", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), SearchAsset.class));
                return true;
            case R.id.menu_about_us:
                Toast.makeText(this, "About Us", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_work_order:
                Toast.makeText(this, "Work Order", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), SearchWorkOrder.class));
                return true;
            case R.id.menu_logout:
                startActivity(new Intent(Asset3.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
                Toast.makeText(this, "Logout", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_purchase_order:
                Toast.makeText(this, "Purchase Order", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), SearchPurchaseOrder.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void fetchMaintenanceStrategyDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<MaintenanceStrategyDropDown>> listCall = apiServicesWorkOrder.mainStrtDropDownList("application/json", "api/assetsdropdown/getmaintenancestrategy");
            listCall.enqueue(new Callback<List<MaintenanceStrategyDropDown>>() {
                @Override
                public void onResponse(Call<List<MaintenanceStrategyDropDown>> call, Response<List<MaintenanceStrategyDropDown>> response) {
                    if (response.body() != null) {
                        maintenanceStrategyDropDownList = response.body();
                        showMaintenanceStrategyDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<MaintenanceStrategyDropDown>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }

    public void showMaintenanceStrategyDropDownList() {
        if (getApplicationContext() != null) {
            String item[] = new String[maintenanceStrategyDropDownList.size()];
            for (int i = 0; i < maintenanceStrategyDropDownList.size(); i++) {
                item[i] = maintenanceStrategyDropDownList.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            maintenanceStrategy.setAdapter(adapter);
            maintenanceStrategy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    MaintenanceStrategy = maintenanceStrategyDropDownList.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    public void fetchMaintenanceFrequencyDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<MaintenanceFrequencyDropDown>> listCall = apiServicesWorkOrder.mainfreqDropDownList("application/json", "api/assetsdropdown/getmaintenancefrequency");
            listCall.enqueue(new Callback<List<MaintenanceFrequencyDropDown>>() {
                @Override
                public void onResponse(Call<List<MaintenanceFrequencyDropDown>> call, Response<List<MaintenanceFrequencyDropDown>> response) {
                    if (response.body() != null) {
                        maintenanceFrequencyDropDownList = response.body();
                        showMaintenanceFrequencyDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<MaintenanceFrequencyDropDown>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }

    public void showMaintenanceFrequencyDropDownList() {
        if (getApplicationContext() != null) {
            String item[] = new String[maintenanceFrequencyDropDownList.size()];
            for (int i = 0; i < maintenanceFrequencyDropDownList.size(); i++) {
                item[i] = maintenanceFrequencyDropDownList.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            maintenanceFrequency.setAdapter(adapter);
            maintenanceFrequency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    MaintenanceFrequency = maintenanceFrequencyDropDownList.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    public void showDatePickerDialog1(View v) {
        DialogFragment newFragment1 = new DatePickerFragment1();
        newFragment1.show(getSupportFragmentManager(), "datePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment1 extends DialogFragment implements
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
            lastMaintenanceDate.setText(date);
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

            nextMaintenanceDate.setText(date);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}