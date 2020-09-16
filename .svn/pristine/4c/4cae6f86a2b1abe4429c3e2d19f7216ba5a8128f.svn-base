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
import android.widget.ImageView;
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


public class UpdateAsset5 extends AppCompatActivity {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    Button pre, next;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String userrole, companyid, clientId, rolename, id;
    static EditText comDateDeComission, warrantyStart, warrantyEnd;
    EditText estMaintenance, purchaseCost, expectReplaceCost, manufacturer,
            makeYear, modl, serialNo, barCode, partsWarrantyLengthMonth, partsWarrantyLengthYear, partsWarrantyComments;

    String updateClient, updateAssetType, updateAssetStatus, updatePriority, updateWarningLevel, updateLoadDate, updateClientNo, updateAssetId, updateAssetName, updateDescription, updateContractNo,
            updateContractType, updateAssetCategory, updateSubCategory, updateAssetCondition, updateRegion, updateSubRegion, updateLocation, updateArea, updateConditionDate, updateAssetCode,
            updateAssetComent, updateBuildingName, updateRoom, updateReactiveCriticality, updateInspectionFrequency, updateNextInspectionDate, updateLastInspectionDate, updateRoomName, updateFloor, updateAssetUse, updateEnergyRating, updateInspectionProcedureResult, updateInspectionComments, updateMaintenanceStrategy, updateMaintenanceFrequency, updateNextMaintenanceDate,
            updateLastMaintenanceDate, updateMaintenanceProcedureResult, updateMaintenanceComments,
            updateSupplierName, updateComponentOfAsset, updateOldAsset, updateSupplierId, updateOrderNumber, updateQualityLifeExpectancy,
            updateComDescription, updateDateInstalled, updateReplacementDate, updateComissionDate, updateDeComissionDate, updateComComissionDate,
            updateComDateDeComission, updateWarrantyStart, updateWarrantyEnd, updateEstMaintenance, updatePurchaseCost, updateExpectReplaceCost, updateManufacturer, updateMakeYear,
            updateModel, updateSerialNo, updateBarCode, updatePartsWarrantyLengthMonth, updatePartsWarrantyLengthYear, updatePartsWarrantyComments,
            updatePartyWarrantyDateEntered, updateLabourWarrantyStart,
            updateLabourWarrantyEnd, updatePartsWarrantyEnteredBy, updateWarrantyComments, updateDrwaingNumber, updateOmLink, updateLabourWarrantyEnteredBy, updateLabourWarrantyDateEntered;
    boolean updateStatutoryMaintenance, updateSubComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_asset5);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager")) {
            ArrayList<Treestuctutr> list = (ArrayList<Treestuctutr>) getIntent().getSerializableExtra("list");
            arrayList = list;
        } else if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")) {
            ArrayList<ContrctTree> contrctTreeArrayList = (ArrayList<ContrctTree>) getIntent().getSerializableExtra("contrctTreeList");
            contrctTrees = contrctTreeArrayList;
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Update Asset");
        ImageView image = (ImageView) findViewById(R.id.tree);
        image.setVisibility(View.VISIBLE);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateAsset5.this, TreeStructure.class);
                if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager")) {
                    intent.putExtra("list", arrayList);
                } else if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")) {
                    intent.putExtra("contrctTreeList", contrctTrees);

                }
                startActivity(intent);
                //    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                Toast.makeText(UpdateAsset5.this, "Action Escalation Tree", Toast.LENGTH_SHORT).show();
            }
        });

        if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Client")) {
            image.setVisibility(View.INVISIBLE);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }
        Bundle intent = getIntent().getExtras();
        if (intent != null) {
            updateClient = intent.getString("updateClient");
            updateAssetType = intent.getString("updateAssetType");
            updateAssetStatus = intent.getString("updateAssetStatus");
            updatePriority = intent.getString("updatePriority");
            updateWarningLevel = intent.getString("updateWarningLevel");
            updateLoadDate = intent.getString("updateLoadDate");
            updateClientNo = intent.getString("updateClientNo");
            updateAssetId = intent.getString("updateAssetId");
            updateAssetName = intent.getString("updateAssetName");
            updateDescription = intent.getString("updateDescription");
            updateContractNo = intent.getString("updateContractNo");
            updateContractType = intent.getString("updateContractType");
            updateAssetCategory = intent.getString("updateAssetCategory");
            updateSubCategory = intent.getString("updateSubCategory");
            updateAssetCondition = intent.getString("updateAssetCondition");
            updateRegion = intent.getString("updateRegion");
            updateSubRegion = intent.getString("updateSubRegion");
            updateLocation = intent.getString("updateLocation");
            updateArea = intent.getString("updateArea");
            updateConditionDate = intent.getString("updateConditionDate");
            updateAssetCode = intent.getString("updateAssetCode");
            updateAssetComent = intent.getString("updateAssetComent");
            updateBuildingName = intent.getString("updateBuildingName");
            updateRoom = intent.getString("updateRoom");
            updateReactiveCriticality = intent.getString("updateReactiveCriticality");
            updateInspectionFrequency = intent.getString("updateInspectionFrequency");
            updateNextInspectionDate = intent.getString("updateNextInspectionDate");
            updateLastInspectionDate = intent.getString("updateLastInspectionDate");
            updateRoomName = intent.getString("updateRoomName");
            updateFloor = intent.getString("updateFloor");
            updateAssetUse = intent.getString("updateAssetUse");
            updateEnergyRating = intent.getString("updateEnergyRating");
            updateInspectionProcedureResult = intent.getString("updateInspectionProcedureResult");
            updateInspectionComments = intent.getString("updateInspectionComments");
            updateMaintenanceStrategy = intent.getString("updateMaintenanceStrategy");
            updateMaintenanceFrequency = intent.getString("updateMaintenanceFrequency");
            updateNextMaintenanceDate = intent.getString("updateNextMaintenanceDate");
            updateLastMaintenanceDate = intent.getString("updateLastMaintenanceDate");
            updateMaintenanceProcedureResult = intent.getString("updateMaintenanceProcedureResult");
            updateMaintenanceComments = intent.getString("updateMaintenanceComments");
            updateSupplierName = intent.getString("updateSupplierName");
            updateComponentOfAsset = intent.getString("updateComponentOfAsset");
            updateOldAsset = intent.getString("updateOldAsset");
            updateSupplierId = intent.getString("updateSupplierId");
            updateOrderNumber = intent.getString("updateOrderNumber");
            updateQualityLifeExpectancy = intent.getString("updateQualityLifeExpectancy");
            updateComDescription = intent.getString("updateComDescription");
            updateDateInstalled = intent.getString("updateDateInstalled");
            updateReplacementDate = intent.getString("updateReplacementDate");
            updateComissionDate = intent.getString("updateComissionDate");
            updateDeComissionDate = intent.getString("updateDeComissionDate");
            updateComComissionDate = intent.getString("updateComComissionDate");
            updateComDateDeComission = intent.getString("updateComDateDeComission");
            updateWarrantyStart = intent.getString("updateWarrantyStart");
            updateWarrantyEnd = intent.getString("updateWarrantyEnd");
            updateEstMaintenance = intent.getString("updateEstMaintenance");
            updatePurchaseCost = intent.getString("updatePurchaseCost");
            updateExpectReplaceCost = intent.getString("updateExpectReplaceCost");
            updateManufacturer = intent.getString("updateManufacturer");
            updateMakeYear = intent.getString("updateMakeYear");
            updateModel = intent.getString("updateModel");
            updateSerialNo = intent.getString("updateSerialNo");
            updateBarCode = intent.getString("updateBarCode");
            updatePartsWarrantyLengthMonth = intent.getString("updatePartsWarrantyLengthMonth");
            updatePartsWarrantyLengthYear = intent.getString("updatePartsWarrantyLengthYear");
            updatePartsWarrantyComments = intent.getString("updatePartsWarrantyComments");
            updatePartyWarrantyDateEntered = intent.getString("updatePartyWarrantyDateEntered");
            updateLabourWarrantyStart = intent.getString("updateLabourWarrantyStart");
            updateLabourWarrantyEnd = intent.getString("updateLabourWarrantyEnd");
            updatePartsWarrantyEnteredBy = intent.getString("updatePartsWarrantyEnteredBy");
            updateWarrantyComments = intent.getString("updateWarrantyComments");
            updateDrwaingNumber = intent.getString("updateDrwaingNumber");
            updateOmLink = intent.getString("updateOmLink");
            updateLabourWarrantyEnteredBy = intent.getString("updateLabourWarrantyEnteredBy");
            updateLabourWarrantyDateEntered = intent.getString("updateLabourWarrantyDateEntered");
            updateStatutoryMaintenance = intent.getBoolean("updateStatutoryMaintenance");
            updateSubComponent = intent.getBoolean("updateSubComponent");
        }
        comDateDeComission = (EditText) findViewById(R.id.commissioned_de_date);
        comDateDeComission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        comDateDeComission.setText(updateComDateDeComission);
        warrantyStart = (EditText) findViewById(R.id.warranty_start);
        warrantyStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });
        warrantyStart.setText(updateWarrantyStart);
        warrantyEnd = (EditText) findViewById(R.id.warranty_end);
        warrantyEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog2(v);
            }
        });
        warrantyEnd.setText(updateWarrantyEnd);

        userrole = preferenceManagerWorkOrder.getKey_User_Role();
        companyid = preferenceManagerWorkOrder.getKey_Person_Company_Id();
        estMaintenance = (EditText) findViewById(R.id.est_maintenance);
        estMaintenance.setText(updateEstMaintenance);
        purchaseCost = (EditText) findViewById(R.id.po_cost);
        purchaseCost.setText(updatePurchaseCost);
        expectReplaceCost = (EditText) findViewById(R.id.expect_replace_cost);
        expectReplaceCost.setText(updateExpectReplaceCost);
        manufacturer = (EditText) findViewById(R.id.manufacturer);
        manufacturer.setText(updateManufacturer);
        makeYear = (EditText) findViewById(R.id.make_year);
        makeYear.setText(updateMakeYear);
        modl = (EditText) findViewById(R.id.model);
        modl.setText(updateModel);
        serialNo = (EditText) findViewById(R.id.serial_No);
        serialNo.setText(updateSerialNo);
        barCode = (EditText) findViewById(R.id.bar_Code);
        barCode.setText(updateBarCode);
        partsWarrantyLengthMonth = (EditText) findViewById(R.id.month);
        partsWarrantyLengthMonth.setText(updatePartsWarrantyLengthMonth);
        partsWarrantyLengthYear = (EditText) findViewById(R.id.year);
        partsWarrantyLengthYear.setText(updatePartsWarrantyLengthYear);
        partsWarrantyComments = (EditText) findViewById(R.id.pw_comments);
        partsWarrantyComments.setText(updatePartsWarrantyComments);
        next = (Button) findViewById(R.id.btn_next);






        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getComdecommissioned(),comDateDeComission);
        UtilityFunction.checkEditTextSetValue(String.valueOf(Constants.assetsDetails.getEstmaintenancecost()),estMaintenance);
        UtilityFunction.checkEditTextSetValue(String.valueOf(Constants.assetsDetails.getPurchasecost()),purchaseCost);
        UtilityFunction.checkEditTextSetValue(String.valueOf(Constants.assetsDetails.getExpectedreplacementcost()),expectReplaceCost);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getManufacturer(),manufacturer);
        UtilityFunction.checkEditTextSetValue(String.valueOf(Constants.assetsDetails.getMake()),makeYear);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getModelno(),modl);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getSerialno(),serialNo);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getBarcode(),barCode);
        UtilityFunction.checkEditTextSetValue(updatePartsWarrantyLengthMonth,partsWarrantyLengthMonth);
        UtilityFunction.checkEditTextSetValue(updatePartsWarrantyLengthYear,partsWarrantyLengthYear);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getPartswarrantystartdate(),warrantyStart);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getPartswarrantyexpirydate(),warrantyEnd);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getPartswarrantycomments(),partsWarrantyComments);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateComDateDeComission = comDateDeComission.getText().toString().trim();
                updateWarrantyStart = warrantyStart.getText().toString().trim();
                updateWarrantyEnd = warrantyEnd.getText().toString().trim();
                updateEstMaintenance = estMaintenance.getText().toString().trim();
                updatePurchaseCost = purchaseCost.getText().toString().trim();
                updateExpectReplaceCost = expectReplaceCost.getText().toString().trim();
                updateManufacturer = manufacturer.getText().toString().trim();
                updateMakeYear = makeYear.getText().toString().trim();
                updateModel = modl.getText().toString().trim();
                updateSerialNo = serialNo.getText().toString().trim();
                updateBarCode = barCode.getText().toString().trim();
                updatePartsWarrantyLengthMonth = partsWarrantyLengthMonth.getText().toString().trim();
                updatePartsWarrantyLengthYear = partsWarrantyLengthYear.getText().toString().trim();
                updatePartsWarrantyComments = partsWarrantyComments.getText().toString().trim();
                Constants.updateAssetPOJO.setComDecommissioned(updateComDateDeComission);
                try {
                    Constants.updateAssetPOJO.setEstMaintenanceCost(updateEstMaintenance);
                }  catch (Exception e) {
                    e.printStackTrace();
                    Constants.updateAssetPOJO.setEstMaintenanceCost("10000.0");

                }
                try {
                    Constants.updateAssetPOJO.setPurchaseCost(updatePurchaseCost);
                } catch (Exception e) {
                    e.printStackTrace();
                    Constants.updateAssetPOJO.setPurchaseCost("10000");

                }
                try {
                    Constants.updateAssetPOJO.setExpectedReplacementCost(updateExpectReplaceCost);
                } catch (Exception e) {
                    e.printStackTrace();
                    Constants.updateAssetPOJO.setExpectedReplacementCost("10000");

                }


                Constants.updateAssetPOJO.setManufacturer(updateManufacturer);
                try {
                    Constants.updateAssetPOJO.setMake(updateMakeYear);

                } catch (Exception e) {
                    e.printStackTrace();
                    Constants.updateAssetPOJO.setMake("2019");
                }
                Constants.updateAssetPOJO.setPartsWarrantyStartDate(warrantyStart.getText().toString());

                Constants.updateAssetPOJO.setModelNo(updateModel);
                Constants.updateAssetPOJO.setSerialNo(updateSerialNo);
                Constants.updateAssetPOJO.setBarCode(updateBarCode);

                Constants.updateAssetPOJO.setWarrantyLengthInMonth(Integer.parseInt(updatePartsWarrantyLengthMonth));

                Constants.updateAssetPOJO.setWarrantyLengthInYear(updatePartsWarrantyLengthYear);

                Constants.updateAssetPOJO.setPartsWarrantyComments(updatePartsWarrantyComments);


                Intent intent = new Intent(UpdateAsset5.this, UpdateAsset6.class);
                Bundle bundle = new Bundle();
                bundle.putString("updateClient", updateClient);
                bundle.putString("updateAssetType", updateAssetType);
                bundle.putString("updateAssetStatus", updateAssetStatus);
                bundle.putString("updatePriority", updatePriority);
                bundle.putString("updateWarningLevel", updateWarningLevel);
                bundle.putString("updateLoadDate", updateLoadDate);
                bundle.putString("updateClientNo", updateClientNo);
                bundle.putString("updateAssetId", updateAssetId);
                bundle.putString("updateAssetName", updateAssetName);
                bundle.putString("updateDescription", updateDescription);
                bundle.putString("updateContractNo", updateContractNo);
                bundle.putString("updateContractType", updateContractType);
                bundle.putString("updateAssetCategory", updateAssetCategory);
                bundle.putString("updateSubCategory", updateSubCategory);
                bundle.putString("updateAssetCondition", updateAssetCondition);
                bundle.putString("updateRegion", updateRegion);
                bundle.putString("updateSubRegion", updateSubRegion);
                bundle.putString("updateLocation", updateLocation);
                bundle.putString("updateArea", updateArea);
                bundle.putString("updateConditionDate", updateConditionDate);
                bundle.putString("updateAssetCode", updateAssetCode);
                bundle.putString("updateAssetComent", updateAssetComent);
                bundle.putString("updateBuildingName", updateBuildingName);
                bundle.putString("updateRoom", updateRoom);
                bundle.putString("updateReactiveCriticality", updateReactiveCriticality);
                bundle.putString("updateInspectionFrequency", updateInspectionFrequency);
                bundle.putString("updateNextInspectionDate", updateNextInspectionDate);
                bundle.putString("updateLastInspectionDate", updateLastInspectionDate);
                bundle.putString("updateRoomName", updateRoomName);
                bundle.putString("updateFloor", updateFloor);
                bundle.putString("updateAssetUse", updateAssetUse);
                bundle.putString("updateEnergyRating", updateEnergyRating);
                bundle.putString("updateInspectionProcedureResult", updateInspectionProcedureResult);
                bundle.putString("updateInspectionComments", updateInspectionComments);
                bundle.putString("updateMaintenanceStrategy", updateMaintenanceStrategy);
                bundle.putString("updateMaintenanceFrequency", updateMaintenanceFrequency);
                bundle.putString("updateNextMaintenanceDate", updateNextMaintenanceDate);
                bundle.putString("updateLastMaintenanceDate", updateLastMaintenanceDate);
                bundle.putString("updateMaintenanceProcedureResult", updateMaintenanceProcedureResult);
                bundle.putString("updateMaintenanceComments", updateMaintenanceComments);
                bundle.putString("updateSupplierName", updateSupplierName);
                bundle.putString("updateComponentOfAsset", updateComponentOfAsset);
                bundle.putString("updateOldAsset", updateOldAsset);
                bundle.putString("updateSupplierId", updateSupplierId);
                bundle.putString("updateOrderNumber", updateOrderNumber);
                bundle.putString("updateQualityLifeExpectancy", updateQualityLifeExpectancy);
                bundle.putString("updateComDescription", updateComDescription);
                bundle.putString("updateDateInstalled", updateDateInstalled);
                bundle.putString("updateReplacementDate", updateReplacementDate);
                bundle.putString("updateComissionDate", updateComissionDate);
                bundle.putString("updateDeComissionDate", updateDeComissionDate);
                bundle.putString("updateComComissionDate", updateComComissionDate);
                bundle.putString("updateComDateDeComission", updateComDateDeComission);
                bundle.putString("updateWarrantyStart", updateWarrantyStart);
                bundle.putString("updateWarrantyEnd", updateWarrantyEnd);
                bundle.putString("updateEstMaintenance", updateEstMaintenance);
                bundle.putString("updatePurchaseCost", updatePurchaseCost);
                bundle.putString("updateExpectReplaceCost", updateExpectReplaceCost);
                bundle.putString("updateManufacturer", updateManufacturer);
                bundle.putString("updateMakeYear", updateMakeYear);
                bundle.putString("updateModel", updateModel);
                bundle.putString("updateSerialNo", updateSerialNo);
                bundle.putString("updateBarCode", updateBarCode);
                bundle.putString("updatePartsWarrantyLengthMonth", updatePartsWarrantyLengthMonth);
                bundle.putString("updatePartsWarrantyLengthYear", updatePartsWarrantyLengthYear);
                bundle.putString("updatePartsWarrantyComments", updatePartsWarrantyComments);
                bundle.putString("updatePartyWarrantyDateEntered", updatePartyWarrantyDateEntered);
                bundle.putString("updateLabourWarrantyStart", updateLabourWarrantyStart);
                bundle.putString("updateLabourWarrantyEnd", updateLabourWarrantyEnd);
                bundle.putString("updatePartsWarrantyEnteredBy", updatePartsWarrantyEnteredBy);
                bundle.putString("updateWarrantyComments", updateWarrantyComments);
                bundle.putString("updateDrwaingNumber", updateDrwaingNumber);
                bundle.putString("updateOmLink", updateOmLink);
                bundle.putString("updateLabourWarrantyEnteredBy", updateLabourWarrantyEnteredBy);
                bundle.putString("updateLabourWarrantyDateEntered", updateLabourWarrantyDateEntered);
                bundle.putBoolean("updateStatutoryMaintenance", updateStatutoryMaintenance);
                bundle.putBoolean("updateSubComponent", updateSubComponent);
                intent.putExtras(bundle);
                startActivity(intent);
                //    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        pre = (Button) findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateAsset5.this, UpdateAsset4.class);
                Bundle bundle = new Bundle();
                bundle.putString("AssetId", id);
                bundle.putString("updateClient", updateClient);
                bundle.putString("updateAssetType", updateAssetType);
                bundle.putString("updateAssetStatus", updateAssetStatus);
                bundle.putString("updatePriority", updatePriority);
                bundle.putString("updateWarningLevel", updateWarningLevel);
                bundle.putString("updateLoadDate", updateLoadDate);
                bundle.putString("updateClientNo", updateClientNo);
                bundle.putString("updateAssetId", updateAssetId);
                bundle.putString("updateAssetName", updateAssetName);
                bundle.putString("updateDescription", updateDescription);
                bundle.putString("updateContractNo", updateContractNo);
                bundle.putString("updateContractType", updateContractType);
                bundle.putString("updateAssetCategory", updateAssetCategory);
                bundle.putString("updateSubCategory", updateSubCategory);
                bundle.putString("updateAssetCondition", updateAssetCondition);
                bundle.putString("updateRegion", updateRegion);
                bundle.putString("updateSubRegion", updateSubRegion);
                bundle.putString("updateLocation", updateLocation);
                bundle.putString("updateArea", updateArea);
                bundle.putString("updateConditionDate", updateConditionDate);
                bundle.putString("updateAssetCode", updateAssetCode);
                bundle.putString("updateAssetComent", updateAssetComent);
                bundle.putString("updateBuildingName", updateBuildingName);
                bundle.putString("updateRoom", updateRoom);
                bundle.putString("updateReactiveCriticality", updateReactiveCriticality);
                bundle.putString("updateInspectionFrequency", updateInspectionFrequency);
                bundle.putString("updateNextInspectionDate", updateNextInspectionDate);
                bundle.putString("updateLastInspectionDate", updateLastInspectionDate);
                bundle.putString("updateRoomName", updateRoomName);
                bundle.putString("updateFloor", updateFloor);
                bundle.putString("updateAssetUse", updateAssetUse);
                bundle.putString("updateEnergyRating", updateEnergyRating);
                bundle.putString("updateInspectionProcedureResult", updateInspectionProcedureResult);
                bundle.putString("updateInspectionComments", updateInspectionComments);
                bundle.putString("updateMaintenanceStrategy", updateMaintenanceStrategy);
                bundle.putString("updateMaintenanceFrequency", updateMaintenanceFrequency);
                bundle.putString("updateNextMaintenanceDate", updateNextMaintenanceDate);
                bundle.putString("updateLastMaintenanceDate", updateLastMaintenanceDate);
                bundle.putString("updateMaintenanceProcedureResult", updateMaintenanceProcedureResult);
                bundle.putString("updateMaintenanceComments", updateMaintenanceComments);
                bundle.putString("updateSupplierName", updateSupplierName);
                bundle.putString("updateComponentOfAsset", updateComponentOfAsset);
                bundle.putString("updateOldAsset", updateOldAsset);
                bundle.putString("updateSupplierId", updateSupplierId);
                bundle.putString("updateOrderNumber", updateOrderNumber);
                bundle.putString("updateQualityLifeExpectancy", updateQualityLifeExpectancy);
                bundle.putString("updateComDescription", updateComDescription);
                bundle.putString("updateDateInstalled", updateDateInstalled);
                bundle.putString("updateReplacementDate", updateReplacementDate);
                bundle.putString("updateComissionDate", updateComissionDate);
                bundle.putString("updateDeComissionDate", updateDeComissionDate);
                bundle.putString("updateComComissionDate", updateComComissionDate);
                bundle.putString("updateComDateDeComission", updateComDateDeComission);
                bundle.putString("updateWarrantyStart", updateWarrantyStart);
                bundle.putString("updateWarrantyEnd", updateWarrantyEnd);
                bundle.putString("updateEstMaintenance", updateEstMaintenance);
                bundle.putString("updatePurchaseCost", updatePurchaseCost);
                bundle.putString("updateExpectReplaceCost", updateExpectReplaceCost);
                bundle.putString("updateManufacturer", updateManufacturer);
                bundle.putString("updateMakeYear", updateMakeYear);
                bundle.putString("updateModel", updateModel);
                bundle.putString("updateSerialNo", updateSerialNo);
                bundle.putString("updateBarCode", updateBarCode);
                bundle.putString("updatePartsWarrantyLengthMonth", updatePartsWarrantyLengthMonth);
                bundle.putString("updatePartsWarrantyLengthYear", updatePartsWarrantyLengthYear);
                bundle.putString("updatePartsWarrantyComments", updatePartsWarrantyComments);
                bundle.putString("updatePartyWarrantyDateEntered", updatePartyWarrantyDateEntered);
                bundle.putString("updateLabourWarrantyStart", updateLabourWarrantyStart);
                bundle.putString("updateLabourWarrantyEnd", updateLabourWarrantyEnd);
                bundle.putString("updatePartsWarrantyEnteredBy", updatePartsWarrantyEnteredBy);
                bundle.putString("updateWarrantyComments", updateWarrantyComments);
                bundle.putString("updateDrwaingNumber", updateDrwaingNumber);
                bundle.putString("updateOmLink", updateOmLink);
                bundle.putString("updateLabourWarrantyEnteredBy", updateLabourWarrantyEnteredBy);
                bundle.putString("updateLabourWarrantyDateEntered", updateLabourWarrantyDateEntered);
                bundle.putBoolean("updateStatutoryMaintenance", updateStatutoryMaintenance);
                bundle.putBoolean("updateSubComponent", updateSubComponent);
                intent.putExtra("list", arrayList);
                intent.putExtra("contrctTreeList", contrctTrees);
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
                IntentIntegrator scanIntegrator = new IntentIntegrator(UpdateAsset5.this);
                scanIntegrator.initiateScan();
               /* Intent i = new Intent(UpdateAsset5.this, QrCodeActivity.class);
                startActivityForResult( i,REQUEST_CODE_QR_SCAN);*/
            }
        });
        tl_barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator scanIntegrator = new IntentIntegrator(UpdateAsset5.this);
                scanIntegrator.initiateScan();
            /*    Intent i = new Intent(UpdateAsset5.this, QrCodeActivity.class);
                startActivityForResult( i,REQUEST_CODE_QR_SCAN);*/
            }
        });
    }
    private static final int REQUEST_CODE_QR_SCAN = 101;
    FrameLayout fl_barCode;
    TextInputLayout tl_barcode;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (scanningResult != null) {

            String contents = data.getStringExtra("SCAN_RESULT");
            String format = data.getStringExtra("SCAN_RESULT_FORMAT");
            Toast.makeText(UpdateAsset5.this, "Content-" + contents + " Format-" + format, Toast.LENGTH_LONG).show();
            barCode.setText(contents);
        }
       /* super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
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
                startActivity(new Intent(this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
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

            if (day < 10) {
                days = "0" + day;
            } else {
                days = String.valueOf(day);
            }

            String date = months + "-" + days + "-" + year;
            comDateDeComission.setText(date);
        }
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

            if (day < 10) {
                days = "0" + day;
            } else {
                days = String.valueOf(day);
            }

            String date = months + "-" + days + "-" + year;
            warrantyStart.setText(date);
        }
    }

    public void showDatePickerDialog1(View v) {
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

            if (day < 10) {
                days = "0" + day;
            } else {
                days = String.valueOf(day);
            }

            String date = months + "-" + days + "-" + year;
            warrantyEnd.setText(date);
        }
    }

    public void showDatePickerDialog2(View v) {
        DialogFragment newFragment = new DatePickerFragment2();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
