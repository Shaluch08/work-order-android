package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.blikoon.qrcodescanner.QrCodeActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;

import java.util.ArrayList;
import java.util.Calendar;

public class Asset5 extends AppCompatActivity {
    Button pre,next;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String userrole,companyid,clientId,rolename;
    static EditText comDateDeComission,warrantyStart,warrantyEnd;
    EditText estMaintenance,purchaseCost,expectReplaceCost,manufacturer,
            makeYear,modl,serialNo,barCode,partsWarrantyLengthMonth,partsWarrantyLengthYear,partsWarrantyComments;


    String Client,AssetType,AssetStatus,Priority,WarningLevel,LoadDate,ClientNo,AssetId,AssetName,Description,ContractNo,
            ContractType,AssetCategory,SubCategory,AssetCondition,Region,SubRegion,Location,Area,ConditionDate,AssetCode,
            AssetComent,BuildingName,Room,ReactiveCriticality,InspectionFrequency,NextInspectionDate,LastInspectionDate,RoomName
            ,Floor,AssetUse,EnergyRating,InspectionProcedureResult
            ,InspectionComments,MaintenanceStrategy,MaintenanceFrequency,NextMaintenanceDate,
            LastMaintenanceDate,MaintenanceProcedureResult,MaintenanceComments,
            SupplierName,ComponentOfAsset,OldAsset,SupplierId,OrderNumber,QualityLifeExpectancy,
            ComDescription,DateInstalled,ReplacementDate,ComissionDate,DeComissionDate,ComComissionDate,
            ComDateDeComission,WarrantyStart,WarrantyEnd,EstMaintenance,PurchaseCost,ExpectReplaceCost,Manufacturer,MakeYear,
            Model,SerialNo,BarCode,PartsWarrantyLengthMonth,PartsWarrantyLengthYear,PartsWarrantyComments;
    boolean StatutoryMaintenance,SubComponent;
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset5);
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
            SupplierName=intent.getString("SupplierName");
            ComponentOfAsset=intent.getString("ComponentOfAsset");
            OldAsset=intent.getString("OldAsset");
            SupplierId=intent.getString("SupplierId");
            OrderNumber=intent.getString("OrderNumber");
            QualityLifeExpectancy=intent.getString("QualityLifeExpectancy");
            ComDescription=intent.getString("ComDescription");
            DateInstalled=intent.getString("DateInstalled");
            ReplacementDate=intent.getString("ReplacementDate");
            ComissionDate=intent.getString("ComissionDate");
            DeComissionDate=intent.getString("DeComissionDate");
            ComComissionDate=intent.getString("ComComissionDate");
            InspectionProcedureResult=intent.getString("InspectionProcedureResult");
            SubComponent=intent.getBoolean("SubComponent");
        }
        comDateDeComission=(EditText)findViewById(R.id.commissioned_de_date);
        comDateDeComission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        warrantyStart=(EditText)findViewById(R.id.warranty_start);
        warrantyStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });
        warrantyEnd=(EditText) findViewById(R.id.warranty_end);
        warrantyEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog2(v);
            }
        });

        userrole= preferenceManagerWorkOrder.getKey_User_Role();
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        estMaintenance=(EditText)findViewById(R.id.est_maintenance);
        purchaseCost=(EditText)findViewById(R.id.po_cost);
        expectReplaceCost=(EditText)findViewById(R.id.expect_replace_cost);
        manufacturer=(EditText)findViewById(R.id.manufacturer);
        makeYear=(EditText)findViewById(R.id.make_year);
        modl=(EditText)findViewById(R.id.model);
        serialNo=(EditText)findViewById(R.id.serial_No);
        barCode=(EditText)findViewById(R.id.bar_Code);
        partsWarrantyLengthMonth=(EditText)findViewById(R.id.month);
        partsWarrantyLengthYear=(EditText)findViewById(R.id.year);
        partsWarrantyComments=(EditText)findViewById(R.id.pw_comments);
        next=(Button) findViewById(R.id.btn_next);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                   ComDateDeComission=comDateDeComission.getText().toString().trim();
                   WarrantyStart=warrantyStart.getText().toString().trim();
                   WarrantyEnd=warrantyEnd.getText().toString().trim();
                   EstMaintenance=estMaintenance.getText().toString().trim();
                   PurchaseCost=purchaseCost.getText().toString().trim();
                   ExpectReplaceCost=expectReplaceCost.getText().toString().trim();
                   Manufacturer=manufacturer.getText().toString().trim();
                   MakeYear=makeYear.getText().toString().trim();
                   Model=modl.getText().toString().trim();
                   SerialNo=serialNo.getText().toString().trim();
                   BarCode=barCode.getText().toString().trim();
                   PartsWarrantyLengthMonth=partsWarrantyLengthMonth.getText().toString().trim();
                   PartsWarrantyLengthYear=partsWarrantyLengthYear.getText().toString().trim();
                   PartsWarrantyComments=partsWarrantyComments.getText().toString().trim();

                   if (ComDateDeComission.equals(""))
                   {
                       Toast.makeText(Asset5.this, "Please Select Component De Commision Date.", Toast.LENGTH_SHORT).show();
                   }else if (EstMaintenance.equals(""))
                   {
                       estMaintenance.requestFocus();
                       estMaintenance.setError("Please enter Estimate Mantinance Cost.");
                   }else if (PurchaseCost.equals(""))
                   {
                       purchaseCost.requestFocus();
                       purchaseCost.setError("Please enter Purchase Mantinance Cost.");
                   }
                   else if (Manufacturer.equals(""))
                   {
                       manufacturer.requestFocus();
                       manufacturer.setError("Please enter Estimate Mantinance Cost.");
                   }
                   else if (MakeYear.equals(""))
                   {
                       makeYear.requestFocus();
                       makeYear.setError("Please enter Estimate Mantinance Cost.");
                   }
                   else if (Model.equals(""))
                   {
                       modl.requestFocus();
                       modl.setError("Please enter Estimate Mantinance Cost.");
                   }else if (SerialNo.equals(""))
                   {
                       serialNo.requestFocus();
                       serialNo.setError("Please enter Estimate Mantinance Cost.");
                   }
                   else if (PartsWarrantyLengthMonth.equals(""))
                   {
                       partsWarrantyLengthMonth.requestFocus();
                       partsWarrantyLengthMonth.setError("Please enter Estimate Mantinance Cost.");
                   }
                   else if (PartsWarrantyLengthYear.equals(""))
                   {
                       partsWarrantyLengthYear.requestFocus();
                       partsWarrantyLengthYear.setError("Please enter Estimate Mantinance Cost.");
                   }
                   else if (WarrantyStart.equals(""))
                   {
                       warrantyStart.requestFocus();
                       warrantyStart.setError("Please enter Estimate Mantinance Cost.");
                   }
                   else {

                       Constants.createAssetModel.setComDecommissioned(UtilityFunction.ddMMyyyyToMMddyyyy(ComDateDeComission));
                       Constants.createAssetModel.setEstMaintenanceCost(EstMaintenance);
                       Constants.createAssetModel.setPurchaseCost(PurchaseCost);
                       Constants.createAssetModel.setExpectedReplacementCost(ExpectReplaceCost);
                       Constants.createAssetModel.setManufacturer(Manufacturer);
                       Constants.createAssetModel.setMake(MakeYear);
                       Constants.createAssetModel.setModelNo(Model);
                       Constants.createAssetModel.setSerialNo(SerialNo);
                       Constants.createAssetModel.setBarCode(BarCode);
                       Constants.createAssetModel.setWarrantyLengthInMonth(Integer.parseInt(PartsWarrantyLengthMonth));
                       Constants.createAssetModel.setWarrantyLengthInYear(PartsWarrantyLengthYear);
                       Constants.createAssetModel.setPartsWarrantyStartDate(UtilityFunction.ddMMyyyyToMMddyyyy(WarrantyStart));
                       Constants.createAssetModel.setWarrantyExpiration(WarrantyEnd);
                      //  Constants.createAssetModel.setPart
                       Constants.createAssetModel.setPartsWarrantyComments(PartsWarrantyComments);


                       Intent intent = new Intent(Asset5.this, Asset6.class);
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
                       bundle.putString("ComDateDeComission", ComDateDeComission);
                       bundle.putString("WarrantyStart", WarrantyStart);
                       bundle.putString("WarrantyEnd", WarrantyEnd);
                       bundle.putString("EstMaintenance", EstMaintenance);
                       bundle.putString("PurchaseCost", PurchaseCost);
                       bundle.putString("ExpectReplaceCost", ExpectReplaceCost);
                       bundle.putString("Manufacturer", Manufacturer);
                       bundle.putString("MakeYear", MakeYear);
                       bundle.putString("Model", Model);
                       bundle.putString("SerialNo", SerialNo);
                       bundle.putString("BarCode", BarCode);
                       bundle.putString("PartsWarrantyLengthMonth", PartsWarrantyLengthMonth);
                       bundle.putString("PartsWarrantyLengthYear", PartsWarrantyLengthYear);
                       bundle.putString("PartsWarrantyComments", PartsWarrantyComments);
                       intent.putExtras(bundle);
                       startActivity(intent);
                   }
               }catch (Exception e)
               {
                   Toast.makeText(Asset5.this, "Data not found.", Toast.LENGTH_SHORT).show();
               }
              //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        pre=(Button) findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Asset5.this,Asset4.class);
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
                bundle.putBoolean("StatutoryMaintenance",StatutoryMaintenance);
                bundle.putString("MaintenanceStrategy",MaintenanceStrategy);
                bundle.putString("MaintenanceFrequency",MaintenanceFrequency);
                bundle.putString("NextMaintenanceDate",NextMaintenanceDate);
                bundle.putString("LastMaintenanceDate",LastMaintenanceDate);
                bundle.putString("MaintenanceProcedureResult",MaintenanceProcedureResult);
                bundle.putString("MaintenanceComments",MaintenanceComments);
                bundle.putString("SupplierName",SupplierName);
                bundle.putString("OldAsset",OldAsset);
                bundle.putString("ComponentOfAsset",ComponentOfAsset);
                bundle.putString("SupplierId",SupplierId);
                bundle.putString("OrderNumber",OrderNumber);
                bundle.putString("QualityLifeExpectancy",QualityLifeExpectancy);
                bundle.putString("ComDescription",ComDescription);
                bundle.putString("DateInstalled",DateInstalled);
                bundle.putString("ReplacementDate",ReplacementDate);
                bundle.putString("ComissionDate",ComissionDate);
                bundle.putString("ComComissionDate",ComComissionDate);
                bundle.putBoolean("SubComponent",SubComponent);
                bundle.putString("DeComissionDate",DeComissionDate);
                intent.putExtras(bundle);
                startActivity(intent);
            //    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });
        fl_barCode=findViewById(R.id.TILBarCode);
        tl_barcode=findViewById(R.id.barcode_field);
        fl_barCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator scanIntegrator = new IntentIntegrator(Asset5.this);
                scanIntegrator.initiateScan();
              /*  Intent i = new Intent(Asset5.this, QrCodeActivity.class);
                startActivityForResult( i,REQUEST_CODE_QR_SCAN);*/
            }
        });
        tl_barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator scanIntegrator = new IntentIntegrator(Asset5.this);
                scanIntegrator.initiateScan();
                /*Intent i = new Intent(Asset5.this, QrCodeActivity.class);
                startActivityForResult( i,REQUEST_CODE_QR_SCAN);*/
            }
        });

    }

    private static final int REQUEST_CODE_QR_SCAN = 101;
    FrameLayout fl_barCode;
    TextInputLayout tl_barcode;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (scanningResult != null) {

            String contents = data.getStringExtra("SCAN_RESULT");
            String format = data.getStringExtra("SCAN_RESULT_FORMAT");
            Toast.makeText(Asset5.this, "Content-" + contents + " Format-" + format, Toast.LENGTH_LONG).show();
            barCode.setText(contents);
        }
         /*   switch (requestCode){
            case REQUEST_CODE_QR_SCAN: {
                if (resultCode==RESULT_OK){
                    String result = data.getStringExtra("com.blikoon.qrcodescanner.got_qr_scan_relult");

                    barCode.setText(result);
                }
            } break;
        }*/
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
                startActivity(new Intent(Asset5.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
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
            comDateDeComission.setText(date);
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
            warrantyStart.setText(date);
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
            warrantyEnd.setText(date);
        }
    }
    public void showDatePickerDialog2(View v){
        DialogFragment newFragment = new DatePickerFragment2();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
