package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
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
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
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

public class UpdateAsset3 extends AppCompatActivity {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    CheckBox statutoryMaintenance;
    Spinner maintenanceStrategy,maintenanceFrequency;
    static EditText nextMaintenanceDate,lastMaintenanceDate;
    EditText maintenanceProcedureResult,maintenanceComments;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String userrole,companyid,clientId,rolename,id;
    List<MaintenanceFrequencyDropDown> maintenanceFrequencyDropDownList;
    List<MaintenanceStrategyDropDown> maintenanceStrategyDropDownList;
    String updateClient,updateAssetType,updateAssetStatus,updatePriority,updateWarningLevel,updateLoadDate,updateClientNo,updateAssetId,updateAssetName,updateDescription,updateContractNo,
            updateContractType,updateAssetCategory,updateSubCategory,updateAssetCondition,updateRegion,updateSubRegion,updateLocation,updateArea,updateConditionDate,updateAssetCode,
            updateAssetComent,updateBuildingName,updateRoom,updateReactiveCriticality,updateInspectionFrequency,updateNextInspectionDate,updateLastInspectionDate,updateRoomName
            ,updateFloor,updateAssetUse,updateEnergyRating,updateInspectionProcedureResult
            ,updateInspectionComments,updateMaintenanceStrategy,updateMaintenanceFrequency,updateNextMaintenanceDate,
            updateLastMaintenanceDate,updateMaintenanceProcedureResult,updateMaintenanceComments,
            updateSupplierName,updateComponentOfAsset,updateOldAsset,updateSupplierId,updateOrderNumber,updateQualityLifeExpectancy,
            updateComDescription,updateDateInstalled,updateReplacementDate,updateComissionDate,updateDeComissionDate,updateComComissionDate,
            updateComDateDeComission,updateWarrantyStart,updateWarrantyEnd,updateEstMaintenance,updatePurchaseCost,updateExpectReplaceCost,updateManufacturer,updateMakeYear,
            updateModel,updateSerialNo,updateBarCode,updatePartsWarrantyLengthMonth,updatePartsWarrantyLengthYear,updatePartsWarrantyComments,
            updatePartyWarrantyDateEntered,updateLabourWarrantyStart,
            updateLabourWarrantyEnd,updatePartsWarrantyEnteredBy,updateWarrantyComments,updateDrwaingNumber,updateOmLink,updateLabourWarrantyEnteredBy
            ,updateLabourWarrantyDateEntered;
    boolean updateStatutoryMaintenance,updateSubComponent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_asset3);
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
        getSupportActionBar().setTitle("Update Asset");
        ImageView image=(ImageView) findViewById(R.id.tree);
        image.setVisibility(View.VISIBLE);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UpdateAsset3.this,TreeStructure.class);
                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    intent.putExtra("list",arrayList);
                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
                    intent.putExtra("contrctTreeList",contrctTrees);

                }
                startActivity(intent);
              //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                Toast.makeText(UpdateAsset3.this,"Action Escalation Tree", Toast.LENGTH_SHORT).show();
            }
        });

        if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Client")){
            image.setVisibility(View.INVISIBLE);
        }

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
            updateClient=intent.getString("updateClient");
            updateAssetType=intent.getString("updateAssetType");
            updateAssetStatus=intent.getString("updateAssetStatus");
            updatePriority=intent.getString("updatePriority");
            updateWarningLevel=intent.getString("updateWarningLevel");
            updateLoadDate=intent.getString("updateLoadDate");
            updateClientNo=intent.getString("updateClientNo");
            updateAssetId=intent.getString("updateAssetId");
            updateAssetName=intent.getString("updateAssetName");
            updateDescription=intent.getString("updateDescription");
            updateContractNo=intent.getString("updateContractNo");
            updateContractType=intent.getString("updateContractType");
            updateAssetCategory=intent.getString("updateAssetCategory");
            updateSubCategory=intent.getString("updateSubCategory");
            updateAssetCondition=intent.getString("updateAssetCondition");
            updateRegion=intent.getString("updateRegion");
            updateSubRegion=intent.getString("updateSubRegion");
            updateLocation=intent.getString("updateLocation");
            updateArea=intent.getString("updateArea");
            updateConditionDate=intent.getString("updateConditionDate");
            updateAssetCode=intent.getString("updateAssetCode");
            updateAssetComent=intent.getString("updateAssetComent");
            updateBuildingName=intent.getString("updateBuildingName");
            updateRoom=intent.getString("updateRoom");
            updateReactiveCriticality=intent.getString("updateReactiveCriticality");
            updateInspectionFrequency=intent.getString("updateInspectionFrequency");
            updateNextInspectionDate=intent.getString("updateNextInspectionDate");
            updateLastInspectionDate=intent.getString("updateLastInspectionDate");
            updateRoomName=intent.getString("updateRoomName");
            updateFloor=intent.getString("updateFloor");
            updateAssetUse=intent.getString("updateAssetUse");
            updateEnergyRating=intent.getString("updateEnergyRating");
            updateInspectionProcedureResult=intent.getString("updateInspectionProcedureResult");
            updateInspectionComments=intent.getString("updateInspectionComments");
            updateMaintenanceStrategy=intent.getString("updateMaintenanceStrategy");
            updateMaintenanceFrequency=intent.getString("updateMaintenanceFrequency");
            updateNextMaintenanceDate=intent.getString("updateNextMaintenanceDate");
            updateLastMaintenanceDate=intent.getString("updateLastMaintenanceDate");
            updateMaintenanceProcedureResult=intent.getString("updateMaintenanceProcedureResult");
            updateMaintenanceComments=intent.getString("updateMaintenanceComments");
            updateSupplierName=intent.getString("updateSupplierName");
            updateComponentOfAsset=intent.getString("updateComponentOfAsset");
            updateOldAsset=intent.getString("updateOldAsset");
            updateSupplierId=intent.getString("updateSupplierId");
            updateOrderNumber=intent.getString("updateOrderNumber");
            updateQualityLifeExpectancy=intent.getString("updateQualityLifeExpectancy");
            updateComDescription=intent.getString("updateComDescription");
            updateDateInstalled=intent.getString("updateDateInstalled");
            updateReplacementDate=intent.getString("updateReplacementDate");
            updateComissionDate=intent.getString("updateComissionDate");
            updateDeComissionDate=intent.getString("updateDeComissionDate");
            updateComComissionDate=intent.getString("updateComComissionDate");
            updateComDateDeComission=intent.getString("updateComDateDeComission");
            updateWarrantyStart=intent.getString("updateWarrantyStart");
            updateWarrantyEnd=intent.getString("updateWarrantyEnd");
            updateEstMaintenance=intent.getString("updateEstMaintenance");
            updatePurchaseCost=intent.getString("updatePurchaseCost");
            updateExpectReplaceCost=intent.getString("updateExpectReplaceCost");
            updateManufacturer=intent.getString("updateManufacturer");
            updateMakeYear=intent.getString("updateMakeYear");
            updateModel=intent.getString("updateModel");
            updateSerialNo=intent.getString("updateSerialNo");
            updateBarCode=intent.getString("updateBarCode");
            updatePartsWarrantyLengthMonth=intent.getString("updatePartsWarrantyLengthMonth");
            updatePartsWarrantyLengthYear=intent.getString("updatePartsWarrantyLengthYear");
            updatePartsWarrantyComments=intent.getString("updatePartsWarrantyComments");
            updatePartyWarrantyDateEntered=intent.getString("updatePartyWarrantyDateEntered");
            updateLabourWarrantyStart=intent.getString("updateLabourWarrantyStart");
            updateLabourWarrantyEnd=intent.getString("updateLabourWarrantyEnd");
            updatePartsWarrantyEnteredBy=intent.getString("updatePartsWarrantyEnteredBy");
            updateWarrantyComments=intent.getString("updateWarrantyComments");
            updateDrwaingNumber=intent.getString("updateDrwaingNumber");
            updateOmLink=intent.getString("updateOmLink");
            updateLabourWarrantyEnteredBy=intent.getString("updateLabourWarrantyEnteredBy");
            updateLabourWarrantyDateEntered=intent.getString("updateLabourWarrantyDateEntered");
            updateStatutoryMaintenance=intent.getBoolean("updateStatutoryMaintenance");
            updateSubComponent=intent.getBoolean("updateSubComponent");
        }
        statutoryMaintenance=(CheckBox) findViewById(R.id.statutory_maintenance);
        statutoryMaintenance.setChecked(updateStatutoryMaintenance);
        maintenanceStrategy=(Spinner) findViewById(R.id.spinner_maintenance_strategy);
        maintenanceFrequency=(Spinner)findViewById(R.id.spinner_maintenance_frequency);
        nextMaintenanceDate=(EditText)findViewById(R.id.next_maintenance_date);
        nextMaintenanceDate.setText(updateNextMaintenanceDate);
        nextMaintenanceDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        lastMaintenanceDate=(EditText)findViewById(R.id.last_maintenance_date);
        lastMaintenanceDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });
        lastMaintenanceDate.setText(updateLastMaintenanceDate);
        maintenanceProcedureResult=(EditText)findViewById(R.id.maintenance_procedure_result);
        maintenanceProcedureResult.setText(updateMaintenanceProcedureResult);
        maintenanceComments=(EditText)findViewById(R.id.maintenance_comments);
        maintenanceComments.setText(updateMaintenanceComments);
        Button next=(Button)findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextEvent();
             //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        Button pre=(Button) findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UpdateAsset3.this,UpdateAsset2.class);
                Bundle bundle=new Bundle();
                bundle.putString("AssetId",id);
                bundle.putString("updateClient",updateClient);
                bundle.putString("updateAssetType",updateAssetType);
                bundle.putString("updateAssetStatus",updateAssetStatus);
                bundle.putString("updatePriority",updatePriority);
                bundle.putString("updateWarningLevel",updateWarningLevel);
                bundle.putString("updateLoadDate",updateLoadDate);
                bundle.putString("updateClientNo",updateClientNo);
                bundle.putString("updateAssetId",updateAssetId);
                bundle.putString("updateAssetName",updateAssetName);
                bundle.putString("updateDescription",updateDescription);
                bundle.putString("updateContractNo",updateContractNo);
                bundle.putString("updateContractType",updateContractType);
                bundle.putString("updateAssetCategory",updateAssetCategory);
                bundle.putString("updateSubCategory",updateSubCategory);
                bundle.putString("updateAssetCondition",updateAssetCondition);
                bundle.putString("updateRegion",updateRegion);
                bundle.putString("updateSubRegion",updateSubRegion);
                bundle.putString("updateLocation",updateLocation);
                bundle.putString("updateArea",updateArea);
                bundle.putString("updateConditionDate",updateConditionDate);
                bundle.putString("updateAssetCode",updateAssetCode);
                bundle.putString("updateAssetComent",updateAssetComent);
                bundle.putString("updateBuildingName",updateBuildingName);
                bundle.putString("updateRoom",updateRoom);
                bundle.putString("updateReactiveCriticality",updateReactiveCriticality);
                bundle.putString("updateInspectionFrequency",updateInspectionFrequency);
                bundle.putString("updateNextInspectionDate",updateNextInspectionDate);
                bundle.putString("updateLastInspectionDate",updateLastInspectionDate);
                bundle.putString("updateRoomName",updateRoomName);
                bundle.putString("updateFloor",updateFloor);
                bundle.putString("updateAssetUse",updateAssetUse);
                bundle.putString("updateEnergyRating",updateEnergyRating);
                bundle.putString("updateInspectionProcedureResult",updateInspectionProcedureResult);
                bundle.putString("updateInspectionComments",updateInspectionComments);
                bundle.putString("updateMaintenanceStrategy",updateMaintenanceStrategy);
                bundle.putString("updateMaintenanceFrequency",updateMaintenanceFrequency);
                bundle.putString("updateNextMaintenanceDate",updateNextMaintenanceDate);
                bundle.putString("updateLastMaintenanceDate",updateLastMaintenanceDate);
                bundle.putString("updateMaintenanceProcedureResult",updateMaintenanceProcedureResult);
                bundle.putString("updateMaintenanceComments",updateMaintenanceComments);
                bundle.putString("updateSupplierName",updateSupplierName);
                bundle.putString("updateComponentOfAsset",updateComponentOfAsset);
                bundle.putString("updateOldAsset",updateOldAsset);
                bundle.putString("updateSupplierId",updateSupplierId);
                bundle.putString("updateOrderNumber",updateOrderNumber);
                bundle.putString("updateQualityLifeExpectancy",updateQualityLifeExpectancy);
                bundle.putString("updateComDescription",updateComDescription);
                bundle.putString("updateDateInstalled",updateDateInstalled);
                bundle.putString("updateReplacementDate",updateReplacementDate);
                bundle.putString("updateComissionDate",updateComissionDate);
                bundle.putString("updateDeComissionDate",updateDeComissionDate);
                bundle.putString("updateComComissionDate",updateComComissionDate);
                bundle.putString("updateComDateDeComission",updateComDateDeComission);
                bundle.putString("updateWarrantyStart",updateWarrantyStart);
                bundle.putString("updateWarrantyEnd",updateWarrantyEnd);
                bundle.putString("updateEstMaintenance",updateEstMaintenance);
                bundle.putString("updatePurchaseCost",updatePurchaseCost);
                bundle.putString("updateExpectReplaceCost",updateExpectReplaceCost);
                bundle.putString("updateManufacturer",updateManufacturer);
                bundle.putString("updateMakeYear",updateMakeYear);
                bundle.putString("updateModel",updateModel);
                bundle.putString("updateSerialNo",updateSerialNo);
                bundle.putString("updateBarCode",updateBarCode);
                bundle.putString("updatePartsWarrantyLengthMonth",updatePartsWarrantyLengthMonth);
                bundle.putString("updatePartsWarrantyLengthYear",updatePartsWarrantyLengthYear);
                bundle.putString("updatePartsWarrantyComments",updatePartsWarrantyComments);
                bundle.putString("updatePartyWarrantyDateEntered",updatePartyWarrantyDateEntered);
                bundle.putString("updateLabourWarrantyStart",updateLabourWarrantyStart);
                bundle.putString("updateLabourWarrantyEnd",updateLabourWarrantyEnd);
                bundle.putString("updatePartsWarrantyEnteredBy",updatePartsWarrantyEnteredBy);
                bundle.putString("updateWarrantyComments",updateWarrantyComments);
                bundle.putString("updateDrwaingNumber",updateDrwaingNumber);
                bundle.putString("updateOmLink",updateOmLink);
                bundle.putString("updateLabourWarrantyEnteredBy",updateLabourWarrantyEnteredBy);
                bundle.putString("updateLabourWarrantyDateEntered",updateLabourWarrantyDateEntered);
                bundle.putBoolean("updateStatutoryMaintenance",updateStatutoryMaintenance);
                bundle.putBoolean("updateSubComponent",updateSubComponent);
                intent.putExtras(bundle);
               startActivity(intent);
             //   overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
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
    private void nextEvent()
    {

          try {
              String abc=maintenanceStrategy.getSelectedItem().toString();

              if (maintenanceStrategy.getSelectedItem().toString().equals("Maintenance Strategy")) {
                  TextView tv = (TextView) maintenanceStrategy.getSelectedView();
                  if (tv.getText().toString().trim().equals("Maintenance Strategy")) {
                      tv.setError("Please Select Maintenance Strategy");
                  }
                  Toast.makeText(this, "Please Select Maintenance Strategy", Toast.LENGTH_SHORT).show();
              } else if (nextMaintenanceDate.getText().toString().trim().isEmpty()) {
                  nextMaintenanceDate.setError("Please Enter Next Maintenance Date");
                  requestFocus(nextMaintenanceDate);
              } else if (lastMaintenanceDate.getText().toString().trim().isEmpty()) {
                  lastMaintenanceDate.setError("Please Enter Last Maintenance Date");
                  requestFocus(lastMaintenanceDate);
              } else if (maintenanceFrequency.getSelectedItem().toString().equals("Maintenance Frequency")) {
                  TextView tv = (TextView) maintenanceFrequency.getSelectedView();
                  if (tv.getText().toString().trim().equals("Maintenance Frequency")) {
                      tv.setError("Please Select Maintenance Frequency");
                  }
                  Toast.makeText(this, "Please Select Maintenance Frequency", Toast.LENGTH_SHORT).show();
              } else if (maintenanceProcedureResult.getText().toString().isEmpty()) {
                  maintenanceProcedureResult.setError("Please Enter Maintenance Procedure Result");
                  requestFocus(maintenanceProcedureResult);
              }
              else {
                  updateStatutoryMaintenance=statutoryMaintenance.isChecked();
                  updateNextMaintenanceDate=nextMaintenanceDate.getText().toString().trim();
                  updateLastMaintenanceDate=lastMaintenanceDate.getText().toString().trim();
                  updateMaintenanceProcedureResult=maintenanceProcedureResult.getText().toString().trim();
                  updateMaintenanceComments=maintenanceComments.getText().toString().trim();

                  if (statutoryMaintenance.isChecked())
                  {
                      Constants.updateAssetPOJO.setStatutoryMaintenance(true);
                  }else {
                      Constants.updateAssetPOJO.setStatutoryMaintenance(false);
                  }

                  Constants.updateAssetPOJO.setStrategy(updateMaintenanceStrategy);
                  Constants.updateAssetPOJO.setNextMaintenanceDate(updateNextMaintenanceDate);
                  Constants.updateAssetPOJO.setLastInspectionDate(updateLastMaintenanceDate);
                  Constants.updateAssetPOJO.setMaintenanceProcedureResult(updateMaintenanceProcedureResult);
                  Constants.updateAssetPOJO.setMaintenanceComments(updateMaintenanceComments);



                  Intent intent=new Intent(UpdateAsset3.this,UpdateAsset4.class);
                  Bundle bundle=new Bundle();
                  bundle.putString("updateClient",updateClient);
                  bundle.putString("updateAssetType",updateAssetType);
                  bundle.putString("updateAssetStatus",updateAssetStatus);
                  bundle.putString("updatePriority",updatePriority);
                  bundle.putString("updateWarningLevel",updateWarningLevel);
                  bundle.putString("updateLoadDate",updateLoadDate);
                  bundle.putString("updateClientNo",updateClientNo);
                  bundle.putString("updateAssetId",updateAssetId);
                  bundle.putString("updateAssetName",updateAssetName);
                  bundle.putString("updateDescription",updateDescription);
                  bundle.putString("updateContractNo",updateContractNo);
                  bundle.putString("updateContractType",updateContractType);
                  bundle.putString("updateAssetCategory",updateAssetCategory);
                  bundle.putString("updateSubCategory",updateSubCategory);
                  bundle.putString("updateAssetCondition",updateAssetCondition);
                  bundle.putString("updateRegion",updateRegion);
                  bundle.putString("updateSubRegion",updateSubRegion);
                  bundle.putString("updateLocation",updateLocation);
                  bundle.putString("updateArea",updateArea);
                  bundle.putString("updateConditionDate",updateConditionDate);
                  bundle.putString("updateAssetCode",updateAssetCode);
                  bundle.putString("updateAssetComent",updateAssetComent);
                  bundle.putString("updateBuildingName",updateBuildingName);
                  bundle.putString("updateRoom",updateRoom);
                  bundle.putString("updateReactiveCriticality",updateReactiveCriticality);
                  bundle.putString("updateInspectionFrequency",updateInspectionFrequency);
                  bundle.putString("updateNextInspectionDate",updateNextInspectionDate);
                  bundle.putString("updateLastInspectionDate",updateLastInspectionDate);
                  bundle.putString("updateRoomName",updateRoomName);
                  bundle.putString("updateFloor",updateFloor);
                  bundle.putString("updateAssetUse",updateAssetUse);
                  bundle.putString("updateEnergyRating",updateEnergyRating);
                  bundle.putString("updateInspectionProcedureResult",updateInspectionProcedureResult);
                  bundle.putString("updateInspectionComments",updateInspectionComments);
                  bundle.putString("updateMaintenanceStrategy",updateMaintenanceStrategy);
                  bundle.putString("updateMaintenanceFrequency",updateMaintenanceFrequency);
                  bundle.putString("updateNextMaintenanceDate",updateNextMaintenanceDate);
                  bundle.putString("updateLastMaintenanceDate",updateLastMaintenanceDate);
                  bundle.putString("updateMaintenanceProcedureResult",updateMaintenanceProcedureResult);
                  bundle.putString("updateMaintenanceComments",updateMaintenanceComments);
                  bundle.putString("updateSupplierName",updateSupplierName);
                  bundle.putString("updateComponentOfAsset",updateComponentOfAsset);
                  bundle.putString("updateOldAsset",updateOldAsset);
                  bundle.putString("updateSupplierId",updateSupplierId);
                  bundle.putString("updateOrderNumber",updateOrderNumber);
                  bundle.putString("updateQualityLifeExpectancy",updateQualityLifeExpectancy);
                  bundle.putString("updateComDescription",updateComDescription);
                  bundle.putString("updateDateInstalled",updateDateInstalled);
                  bundle.putString("updateReplacementDate",updateReplacementDate);
                  bundle.putString("updateComissionDate",updateComissionDate);
                  bundle.putString("updateDeComissionDate",updateDeComissionDate);
                  bundle.putString("updateComComissionDate",updateComComissionDate);
                  bundle.putString("updateComDateDeComission",updateComDateDeComission);
                  bundle.putString("updateWarrantyStart",updateWarrantyStart);
                  bundle.putString("updateWarrantyEnd",updateWarrantyEnd);
                  bundle.putString("updateEstMaintenance",updateEstMaintenance);
                  bundle.putString("updatePurchaseCost",updatePurchaseCost);
                  bundle.putString("updateExpectReplaceCost",updateExpectReplaceCost);
                  bundle.putString("updateManufacturer",updateManufacturer);
                  bundle.putString("updateMakeYear",updateMakeYear);
                  bundle.putString("updateModel",updateModel);
                  bundle.putString("updateSerialNo",updateSerialNo);
                  bundle.putString("updateBarCode",updateBarCode);
                  bundle.putString("updatePartsWarrantyLengthMonth",updatePartsWarrantyLengthMonth);
                  bundle.putString("updatePartsWarrantyLengthYear",updatePartsWarrantyLengthYear);
                  bundle.putString("updatePartsWarrantyComments",updatePartsWarrantyComments);
                  bundle.putString("updatePartyWarrantyDateEntered",updatePartyWarrantyDateEntered);
                  bundle.putString("updateLabourWarrantyStart",updateLabourWarrantyStart);
                  bundle.putString("updateLabourWarrantyEnd",updateLabourWarrantyEnd);
                  bundle.putString("updatePartsWarrantyEnteredBy",updatePartsWarrantyEnteredBy);
                  bundle.putString("updateWarrantyComments",updateWarrantyComments);
                  bundle.putString("updateDrwaingNumber",updateDrwaingNumber);
                  bundle.putString("updateOmLink",updateOmLink);
                  bundle.putString("updateLabourWarrantyEnteredBy",updateLabourWarrantyEnteredBy);
                  bundle.putString("updateLabourWarrantyDateEntered",updateLabourWarrantyDateEntered);
                  bundle.putBoolean("updateStatutoryMaintenance",updateStatutoryMaintenance);
                  bundle.putBoolean("updateSubComponent",updateSubComponent);
                  intent.putExtras(bundle);
                  intent.putExtra("list",arrayList);
                  intent.putExtra("contrctTreeList",contrctTrees);
                  startActivity(intent);
              }
          }catch (Exception e)
          {
              Log.d("UpdateAsset3",e.toString());
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
    public void fetchMaintenanceStrategyDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<MaintenanceStrategyDropDown>> listCall= apiServicesWorkOrder.mainStrtDropDownList("application/json","api/assetsdropdown/getmaintenancestrategy");
            listCall.enqueue(new Callback<List<MaintenanceStrategyDropDown>>() {
                @Override
                public void onResponse(Call<List<MaintenanceStrategyDropDown>> call, Response<List<MaintenanceStrategyDropDown>> response) {
                    if(response.body()!=null)
                    {
                        maintenanceStrategyDropDownList=response.body();
                        for(int i=0;i<maintenanceStrategyDropDownList.size();i++)
                        {
                            if(maintenanceStrategyDropDownList.get(i).getValue().equals(updateMaintenanceStrategy))
                            {
                                showMaintenanceStrategyDropDownList(maintenanceStrategyDropDownList.get(i).getText());
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<MaintenanceStrategyDropDown>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    public void showMaintenanceStrategyDropDownList(String compareValue)
    {
        if (getApplicationContext() != null) {
            String item[] = new String[maintenanceStrategyDropDownList.size()];
            for (int i = 0; i < maintenanceStrategyDropDownList.size(); i++) {
                item[i] = maintenanceStrategyDropDownList.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            maintenanceStrategy.setAdapter(adapter);
            if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                maintenanceStrategy.setSelection(spinnerPosition);
            }
            maintenanceStrategy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateMaintenanceStrategy = maintenanceStrategyDropDownList.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    public void fetchMaintenanceFrequencyDropDown(){
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<MaintenanceFrequencyDropDown>> listCall= apiServicesWorkOrder.mainfreqDropDownList("application/json","api/assetsdropdown/getmaintenancefrequency");
            listCall.enqueue(new Callback<List<MaintenanceFrequencyDropDown>>() {
                @Override
                public void onResponse(Call<List<MaintenanceFrequencyDropDown>> call, Response<List<MaintenanceFrequencyDropDown>> response) {
                    if(response.body()!=null)
                    {
                        maintenanceFrequencyDropDownList=response.body();
                      /*  for(int i=0;i<maintenanceFrequencyDropDownList.size();i++)
                        {
                            if(maintenanceFrequencyDropDownList.get(i).getValue().equals(updateMaintenanceFrequency))
                            {
                                showMaintenanceFrequencyDropDownList(maintenanceFrequencyDropDownList.get(i).getText());
                            }
                        }*/
                        showMaintenanceFrequencyDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<MaintenanceFrequencyDropDown>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    public void showMaintenanceFrequencyDropDownList()
    {
        if (getApplicationContext() != null) {
            String item[] = new String[maintenanceFrequencyDropDownList.size()];
            for (int i = 0; i < maintenanceFrequencyDropDownList.size(); i++) {
                item[i] = maintenanceFrequencyDropDownList.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            maintenanceFrequency.setAdapter(adapter);

           // if(compareValue!=null)
           // {
            //    int spinnerPosition=adapter.getPosition(compareValue);
           //     maintenanceFrequency.setSelection(spinnerPosition);
           // }
            maintenanceFrequency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateMaintenanceFrequency = maintenanceFrequencyDropDownList.get(position).getValue();
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

            String date =months   + "-" + days + "-" + year;
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

            String date =months   + "-" + days + "-" + year;
            nextMaintenanceDate.setText(date);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
