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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.workorderapplication.activity.Asset3;
import com.workorder.app.workorderapplication.activity.Asset5;
import com.workorder.app.workorderapplication.activity.MainActivity;
import com.workorder.app.workorderapplication.activity.SearchAsset;
import com.workorder.app.workorderapplication.activity.SearchPurchaseOrder;
import com.workorder.app.workorderapplication.activity.SearchWorkOrder;
import com.workorder.app.workorderapplication.model.assetModel.ComponentOfAssetDropDown;
import com.workorder.app.workorderapplication.model.assetModel.OldAssetDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.SupplierDropDownList;
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

public class Asset4 extends AppCompatActivity {
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    List<SupplierDropDownList> supplierDropDownLists;
    List<OldAssetDropDownList> oldAssetDropDownLists;
    List<ComponentOfAssetDropDown> componentOfAssetDropDowns;
    String userrole,companyid,clientId,rolename;
    String Client,AssetType,AssetStatus,Priority,WarningLevel,LoadDate,ClientNo,AssetId,AssetName,Description,ContractNo,
            ContractType,AssetCategory,SubCategory,AssetCondition,Region,SubRegion,Location,Area,ConditionDate,AssetCode,AssetComent,BuildingName,Room,ReactiveCriticality,InspectionFrequency,NextInspectionDate,LastInspectionDate,RoomName,Floor,AssetUse,EnergyRating,InspectionProcedureResult
            ,InspectionComments,MaintenanceStrategy,MaintenanceFrequency,NextMaintenanceDate,
            LastMaintenanceDate,MaintenanceProcedureResult,MaintenanceComments,
            SupplierName,ComponentOfAsset,OldAsset,SupplierId,OrderNumber,QualityLifeExpectancy,
            ComDescription,DateInstalled,ReplacementDate,ComissionDate,DeComissionDate,ComComissionDate;
    boolean StatutoryMaintenance,SubComponent;
    Spinner supplierName,componentOfAsset,oldAsset;
    CheckBox sub_component;
    EditText supplierId,orderNumber,qualityLifeExpectancy,comDescription;
    static EditText dateInstalled,replacementDate,comissionDate,deComissionDate,comComissionDate;
    Button pre,next;
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset4);
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
        Bundle intent=getIntent().getExtras();
        if(intent!=null)
        {
            InspectionComments=intent.getString("InspectionComments");
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
            ReactiveCriticality=intent.getString("ReactiveCriticality");
            InspectionFrequency=intent.getString("InspectionFrequency");
            NextInspectionDate=intent.getString("NextInspectionDate");
            LastInspectionDate=intent.getString("LastInspectionDate");
            RoomName=intent.getString("RoomName");
            Floor=intent.getString("Floor");
            AssetUse=intent.getString("AssetUse");
            EnergyRating=intent.getString("EnergyRating");
            MaintenanceStrategy=intent.getString("MaintenanceStrategy");
            MaintenanceFrequency=intent.getString("MaintenanceFrequency");
            NextMaintenanceDate=intent.getString("NextMaintenanceDate");
            LastMaintenanceDate=intent.getString("LastMaintenanceDate");
            MaintenanceProcedureResult=intent.getString("MaintenanceProcedureResult");
            MaintenanceComments=intent.getString("MaintenanceComments");
            StatutoryMaintenance=intent.getBoolean("StatutoryMaintenance");
            InspectionProcedureResult=intent.getString("InspectionProcedureResult");
        }

        userrole= preferenceManagerWorkOrder.getKey_User_Role();
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        sub_component=(CheckBox) findViewById(R.id.sub_component);
        supplierName=(Spinner) findViewById(R.id.spinner_supplierName);
        componentOfAsset=(Spinner) findViewById(R.id.spinner_componentAsset);
        oldAsset=(Spinner) findViewById(R.id.spinner_oldAsset);
        supplierId=(EditText)findViewById(R.id.supplierId);
        orderNumber=(EditText)findViewById(R.id.orderNumber);
        qualityLifeExpectancy=(EditText)findViewById(R.id.quality_life_expectancy);
        comDescription=(EditText)findViewById(R.id.com_description1);
        dateInstalled=(EditText)findViewById(R.id.installed_date);
        dateInstalled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        replacementDate=(EditText)findViewById(R.id.replacement_date);
        replacementDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });
        comissionDate=(EditText)findViewById(R.id.commissioned_date);
        comissionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog2(v);
            }
        });
        deComissionDate=(EditText)findViewById(R.id.commissioned_de_date);
        deComissionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog3(v);
            }
        });
        comComissionDate=(EditText) findViewById(R.id.com_date_Commissioned);
        comComissionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog4(v);
            }
        });
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
                Intent intent1=new Intent(Asset4.this,Asset3.class);
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
                intent1.putExtras(bundle);
                startActivity(intent1);
              //  overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });
        fetchSupplierDropDown();
        fetchOldAssetDropDown();
        fetchComAssetDropDown();
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
          if (supplierName.getSelectedItemPosition()==0) {

              Toast.makeText(this, "Please Select Supplier", Toast.LENGTH_LONG).show();
          } else if (supplierId.getText().toString().equals("")) {
              supplierId.setError("Enter Supplier Id");
              requestFocus(supplierId);
          }else if(orderNumber.getText().toString().trim().isEmpty())
          {
              orderNumber.setError("Please Enter Order Number");
              requestFocus(orderNumber);
          }else if(dateInstalled.getText().toString().trim().isEmpty()){
              dateInstalled.setError("Please Enter Date Installed");
              requestFocus(dateInstalled);
          }else if(replacementDate.getText().toString().trim().isEmpty()){
              replacementDate.setError("Please Enter Replacement Date");
              requestFocus(replacementDate);
          }else if (comissionDate.getText().toString().equals(""))
          {
              Toast.makeText(this, "Please select Commission Date.", Toast.LENGTH_SHORT).show();
          }else if (deComissionDate.getText().toString().equals(""))
          {
              Toast.makeText(this, "Please select DeCommission Date.", Toast.LENGTH_SHORT).show();
          }else if (comComissionDate.getText().toString().equals(""))
          {
              Toast.makeText(this, "Please select Component Commission Date.", Toast.LENGTH_SHORT).show();
          }
          else {
              SubComponent = sub_component.isChecked();
              SupplierId = supplierId.getText().toString().trim();
              OrderNumber = orderNumber.getText().toString().trim();
              QualityLifeExpectancy = qualityLifeExpectancy.getText().toString().trim();
              ComDescription = comDescription.getText().toString().trim();
              DateInstalled = dateInstalled.getText().toString().trim();
              ReplacementDate = replacementDate.getText().toString().trim();
              DeComissionDate = deComissionDate.getText().toString().trim();
              ComComissionDate = comComissionDate.getText().toString().trim();
              ComissionDate = comissionDate.getText().toString().trim();

              Constants.createAssetModel.setSupplierName(supplierName.getSelectedItem().toString());
              Constants.createAssetModel.setSupplierId(SupplierId);
              Constants.createAssetModel.setOrderNumber(orderNumber.getText().toString());
              Constants.createAssetModel.setOldAssetID(OldAsset);
              Constants.createAssetModel.setDateInstalled(dateInstalled.getText().toString());
              Constants.createAssetModel.setReplacementDate(replacementDate.getText().toString());
              Constants.createAssetModel.setCommissioned(comissionDate.getText().toString());
              Constants.createAssetModel.setDecommissioned(deComissionDate.getText().toString());
              Constants.createAssetModel.setQuaLifeExpectancy(Integer.parseInt(QualityLifeExpectancy));

              if (sub_component.isChecked()) {
                  Constants.createAssetModel.setSubComponent(true);
              }else {
                  Constants.createAssetModel.setSubComponent(false);
              }

              Constants.createAssetModel.setSubComponentId(ComponentOfAsset);
              Constants.createAssetModel.setComponentDescription(comDescription.getText().toString());
              Constants.createAssetModel.setComCommissioned(comComissionDate.getText().toString());
              

              Intent intent = new Intent(Asset4.this, Asset5.class);
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
              bundle.putString("SupplierName", SupplierName);
              bundle.putString("OldAsset", OldAsset);
              bundle.putString("ComponentOfAsset", ComponentOfAsset);
              bundle.putString("SupplierId", SupplierId);
              bundle.putString("OrderNumber", OrderNumber);
              bundle.putString("QualityLifeExpectancy", QualityLifeExpectancy);
              bundle.putString("ComDescription", ComDescription);
              bundle.putString("DateInstalled", DateInstalled);
              bundle.putString("ReplacementDate", ReplacementDate);
              bundle.putString("ComissionDate", ComissionDate);
              bundle.putString("ComComissionDate", ComComissionDate);
              bundle.putBoolean("SubComponent", SubComponent);
              bundle.putString("DeComissionDate", DeComissionDate);
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
                startActivity(new Intent(Asset4.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
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
    public void fetchComAssetDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<ComponentOfAssetDropDown>> listCall= apiServicesWorkOrder.comassetDropDownList("application/json","api/assetsdropdown/getcomponentasset");
            listCall.enqueue(new Callback<List<ComponentOfAssetDropDown>>() {
                @Override
                public void onResponse(Call<List<ComponentOfAssetDropDown>> call, Response<List<ComponentOfAssetDropDown>> response) {
                    if(response.body()!=null)
                    {
                        componentOfAssetDropDowns=response.body();
                        showComAssetDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<ComponentOfAssetDropDown>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showComAssetDownList()
    {
        if (getApplicationContext() != null) {
            String item[] = new String[componentOfAssetDropDowns.size()];
            for (int i = 0; i < componentOfAssetDropDowns.size(); i++) {
                item[i] = componentOfAssetDropDowns.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            componentOfAsset.setAdapter(adapter);
            componentOfAsset.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ComponentOfAsset = componentOfAssetDropDowns.get(position).getValue();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    public void fetchSupplierDropDown(){
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<SupplierDropDownList>> listCall= apiServicesWorkOrder.supplierDropDownList("application/json","api/assetsdropdown/getsupplier?companyid="+companyid);
            listCall.enqueue(new Callback<List<SupplierDropDownList>>() {
                @Override
                public void onResponse(Call<List<SupplierDropDownList>> call, Response<List<SupplierDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        supplierDropDownLists=response.body();
                        showSupplierDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<SupplierDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showSupplierDropDownList()
    {
        if (getApplicationContext() != null) {
            String item[] = new String[supplierDropDownLists.size()];
            for (int i = 0; i < supplierDropDownLists.size(); i++) {
                item[i] = supplierDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            supplierName.setAdapter(adapter);
            supplierName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SupplierId = supplierDropDownLists.get(position).getValue();
                    supplierId.setText(SupplierId);
                    supplierId.setEnabled(false);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    public void fetchOldAssetDropDown(){
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<OldAssetDropDownList>> listCall= apiServicesWorkOrder.oldAssetDropDownList("application/json","api/assetsdropdown/getoldasset");
            listCall.enqueue(new Callback<List<OldAssetDropDownList>>() {
                @Override
                public void onResponse(Call<List<OldAssetDropDownList>> call, Response<List<OldAssetDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        oldAssetDropDownLists=response.body();
                        showOldAssetDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<OldAssetDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showOldAssetDropDownList()
    {
        if (getApplicationContext() != null) {
            String item[] = new String[oldAssetDropDownLists.size()];
            for (int i = 0; i < oldAssetDropDownLists.size(); i++) {
                item[i] = oldAssetDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            oldAsset.setAdapter(adapter);
            oldAsset.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    OldAsset = oldAssetDropDownLists.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
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
            dateInstalled.setText(date);
        }
    }
    public void showDatePickerDialog(View v){
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
            replacementDate.setText(date);
        }
    }
    public void showDatePickerDialog1(View v){
        DialogFragment newFragment = new DatePickerFragment1();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment2 extends DialogFragment implements
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
            comissionDate.setText(date);
        }
    }
    public void showDatePickerDialog2(View v){
        DialogFragment newFragment = new DatePickerFragment2();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    public static class DatePickerFragment3 extends DialogFragment implements
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
            deComissionDate.setText(date);
        }
    }
    public void showDatePickerDialog3(View v){
        DialogFragment newFragment = new DatePickerFragment3();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    public static class DatePickerFragment4 extends DialogFragment implements
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
            comComissionDate.setText(date);
        }
    }
    public void showDatePickerDialog4(View v){
        DialogFragment newFragment = new DatePickerFragment4();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
