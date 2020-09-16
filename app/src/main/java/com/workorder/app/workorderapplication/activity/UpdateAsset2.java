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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
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

public class UpdateAsset2 extends AppCompatActivity {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    Button pre, next;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String userrole,companyid,clientId,rolename,id;
    List<ReactiveCriticalityDropDown> reactiveCriticalityDropDowns;
    List<InspectionFrequencyDropDown> inspectionFrequencyDropDowns;
    Spinner reactiveCriticality,inspectionFrequency;
    static EditText nextInspectionDate,lastInspectionDate;
    EditText roomName,floor,assetUse,energyRating,inspectionProcedureResult,inspectionComments;

    String updateClient,updateAssetType,updateAssetStatus,updatePriority,updateWarningLevel,
            updateLoadDate,updateClientNo,updateAssetId,updateAssetName,updateDescription,
            updateContractNo,updateContractType,updateAssetCategory,updateSubCategory,
            updateAssetCondition,updateRegion,updateSubRegion,updateLocation,updateArea,
            updateConditionDate,updateAssetCode,updateAssetComent,updateBuildingName,
            updateRoom,updateReactiveCriticality,updateInspectionFrequency,
            updateNextInspectionDate,updateLastInspectionDate,updateRoomName,updateFloor,
            updateAssetUse,updateEnergyRating,updateInspectionProcedureResult,
            updateInspectionComments,updateMaintenanceStrategy,updateMaintenanceFrequency,
            updateNextMaintenanceDate,updateLastMaintenanceDate,updateMaintenanceProcedureResult,
            updateMaintenanceComments,updateSupplierName,updateComponentOfAsset,updateOldAsset,
            updateSupplierId,updateOrderNumber,updateQualityLifeExpectancy,updateComDescription,
            updateDateInstalled,updateReplacementDate,updateComissionDate,updateDeComissionDate,
            updateComComissionDate,updateComDateDeComission,updateWarrantyStart,updateWarrantyEnd,
            updateEstMaintenance,updatePurchaseCost,updateExpectReplaceCost,updateManufacturer,
            updateMakeYear,updateModel,updateSerialNo,updateBarCode,updatePartsWarrantyLengthMonth,
            updatePartsWarrantyLengthYear,updatePartsWarrantyComments,updatePartyWarrantyDateEntered,
            updateLabourWarrantyStart,updateLabourWarrantyEnd,updatePartsWarrantyEnteredBy,
            updateWarrantyComments,updateDrwaingNumber,updateOmLink,updateLabourWarrantyEnteredBy,
            updateLabourWarrantyDateEntered;

    boolean updateStatutoryMaintenance,updateSubComponent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_asset2);
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
                Intent intent=new Intent(UpdateAsset2.this,TreeStructure.class);
                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    intent.putExtra("list",arrayList);
                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
                    intent.putExtra("contrctTreeList",contrctTrees);

                }
                startActivity(intent);
               // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                Toast.makeText(UpdateAsset2.this,"Action Escalation Tree", Toast.LENGTH_SHORT).show();
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
            id=intent.getString("AssetId");
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
        inspectionComments=(EditText)findViewById(R.id.inspection_comments);
        inspectionComments.setText(updateInspectionComments);
        reactiveCriticality=(Spinner)findViewById(R.id.spinner_reactive_criticality);
        inspectionFrequency=(Spinner)findViewById(R.id.spinner_inspection_frequency);
        nextInspectionDate=(EditText)findViewById(R.id.next_inspection_date);
        nextInspectionDate.setText(updateNextInspectionDate);
        nextInspectionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        lastInspectionDate=(EditText)findViewById(R.id.last_inspection_date);
        lastInspectionDate.setText(updateLastInspectionDate);
        lastInspectionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });
        roomName=(EditText)findViewById(R.id.room_name);
        roomName.setText(updateRoomName);
        floor=(EditText)findViewById(R.id.floor);
        floor.setText(updateFloor);
        assetUse=(EditText)findViewById(R.id.asset_use);
        assetUse.setText(updateAssetUse);
        energyRating=(EditText)findViewById(R.id.energy_rating);
        energyRating.setText(updateEnergyRating);
        inspectionProcedureResult=(EditText)findViewById(R.id.inspection_procedure_result);
        inspectionProcedureResult.setText(updateInspectionProcedureResult);
        next=(Button)findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            nextEvent();
           //     overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        pre=(Button)findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=  new Intent(UpdateAsset2.this,UpdateAsset1.class);
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
    private void nextEvent()
    {
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
        }else {
            updateNextInspectionDate=nextInspectionDate.getText().toString().trim();
            updateLastInspectionDate=lastInspectionDate.getText().toString().trim();
            updateRoomName=roomName.getText().toString().trim();
            updateFloor=floor.getText().toString().trim();
            updateAssetUse=assetUse.getText().toString().trim();
            updateEnergyRating=energyRating.getText().toString().trim();
            updateInspectionProcedureResult=inspectionProcedureResult.getText().toString().trim();
            updateInspectionComments=inspectionComments.getText().toString().trim();

            Constants.updateAssetPOJO.setRoomName(updateRoomName);
            Constants.updateAssetPOJO.setFloor(updateFloor);
            Constants.updateAssetPOJO.setAssetUse(assetUse.getText().toString());
            Constants.updateAssetPOJO.setEnergyRating(updateEnergyRating);
            Constants.updateAssetPOJO.setCriticality(updateReactiveCriticality);
            Constants.updateAssetPOJO.setNextInspectionDate(updateNextInspectionDate);
            Constants.updateAssetPOJO.setLastInspectionDate(updateLastInspectionDate);
            Constants.updateAssetPOJO.setInspectionFrequency(updateInspectionFrequency);
            Constants.updateAssetPOJO.setInspectionProcedureResult(updateInspectionProcedureResult);
            Constants.updateAssetPOJO.setInspectionComments(updateInspectionComments);





            Intent intent=new Intent(UpdateAsset2.this,UpdateAsset3.class);
            Bundle bundle=new Bundle();
            bundle.putString("updateClient",updateClient);
            bundle.putString("updateAssetType",updateAssetType);
            bundle.putString("updateAssetStatus",updateAssetStatus);
            bundle.putString("updatePriority",updatePriority);
            bundle.putString("updateWarningLevel",updateWarningLevel);
            bundle.putString("updateLoadDate",updateLoadDate);
            bundle.putString("updateClientNo",updateClientNo);
            bundle.putString("updateAssetId",updateAssetId);
            bundle.putString("updateDescription",updateDescription);
            bundle.putString("updateAssetName",updateAssetName);
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
                        for(int i=0;i<reactiveCriticalityDropDowns.size();i++)
                        {
                            if(reactiveCriticalityDropDowns.get(i).getValue().equals(updateReactiveCriticality))
                            {
                                showReactiveCriticalityDropDownList(reactiveCriticalityDropDowns.get(i).getText());
                            }
                        }
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
    public void showReactiveCriticalityDropDownList(String compareValue)
    {
        if (getApplicationContext() != null) {
            String item[] = new String[reactiveCriticalityDropDowns.size()];
            for (int i = 0; i < reactiveCriticalityDropDowns.size(); i++) {
                item[i] = reactiveCriticalityDropDowns.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            reactiveCriticality.setAdapter(adapter);
            if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                reactiveCriticality.setSelection(spinnerPosition);
            }
            reactiveCriticality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateReactiveCriticality = reactiveCriticalityDropDowns.get(position).getValue();
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

                        for(int i=0;i<inspectionFrequencyDropDowns.size();i++)
                        {
                            if(inspectionFrequencyDropDowns.get(i).getValue().equals(updatePriority))
                            {
                                showInspectionFrequencyDropDownList(inspectionFrequencyDropDowns.get(i).getText());
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<InspectionFrequencyDropDown>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    public void showInspectionFrequencyDropDownList(String compareValue)
    {
        if (getApplicationContext() != null) {
            String item[] = new String[inspectionFrequencyDropDowns.size()];
            for (int i = 0; i < inspectionFrequencyDropDowns.size(); i++) {
                item[i] = inspectionFrequencyDropDowns.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            inspectionFrequency.setAdapter(adapter);
            if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                inspectionFrequency.setSelection(spinnerPosition);
            }
            inspectionFrequency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateInspectionFrequency = inspectionFrequencyDropDowns.get(position).getValue();
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

            String date =months   + "-" + days + "-" + year;
            nextInspectionDate.setText(date);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
