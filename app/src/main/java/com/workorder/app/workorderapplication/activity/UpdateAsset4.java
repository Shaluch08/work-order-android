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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
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

public class UpdateAsset4 extends AppCompatActivity {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    List<SupplierDropDownList> supplierDropDownLists;
    List<OldAssetDropDownList> oldAssetDropDownLists;
    List<ComponentOfAssetDropDown> componentOfAssetDropDowns;
    String userrole,companyid,clientId,rolename,id;
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
    Spinner supplierName,componentOfAsset,oldAsset;
    CheckBox sub_component;
    EditText supplierId,orderNumber,qualityLifeExpectancy,comDescription;
    static EditText dateInstalled,replacementDate,comissionDate,deComissionDate,comComissionDate;
    Button pre,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_asset4);
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
                Intent intent=new Intent(UpdateAsset4.this,TreeStructure.class);
                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    intent.putExtra("list",arrayList);
                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
                    intent.putExtra("contrctTreeList",contrctTrees);

                }
                startActivity(intent);
              //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                Toast.makeText(UpdateAsset4.this,"Action Escalation Tree", Toast.LENGTH_SHORT).show();
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

        userrole= preferenceManagerWorkOrder.getKey_User_Role();
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        sub_component=(CheckBox) findViewById(R.id.sub_component);
        sub_component.setChecked(updateSubComponent);
        supplierName=(Spinner) findViewById(R.id.spinner_supplierName);
        componentOfAsset=(Spinner) findViewById(R.id.spinner_componentAsset);
        oldAsset=(Spinner) findViewById(R.id.spinner_oldAsset);
        supplierId=(EditText) findViewById(R.id.supplierId);
        supplierId.setText(updateSupplierId);
        orderNumber=(EditText) findViewById(R.id.orderNumber);
        orderNumber.setText(updateOrderNumber);
        qualityLifeExpectancy=(EditText) findViewById(R.id.quality_life_expectancy);
        qualityLifeExpectancy.setText(updateQualityLifeExpectancy);
        comDescription=(EditText) findViewById(R.id.com_description1);
        comDescription.setText(updateComDescription);
        dateInstalled=(EditText) findViewById(R.id.installed_date);
        dateInstalled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        dateInstalled.setText(updateDateInstalled);
        replacementDate=(EditText) findViewById(R.id.replacement_date);
        replacementDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });
        replacementDate.setText(updateReplacementDate);
        comissionDate=(EditText) findViewById(R.id.commissioned_date);
        comissionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog2(v);
            }
        });
        comissionDate.setText(updateComissionDate);
        deComissionDate=(EditText) findViewById(R.id.commissioned_de_date);
        deComissionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog3(v);
            }
        });
        deComissionDate.setText(updateDeComissionDate);
        comComissionDate=(EditText) findViewById(R.id.com_date_Commissioned);
        comComissionDate.setText(updateComComissionDate);
        comComissionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog4(v);
            }
        });
        next=(Button) findViewById(R.id.btn_next);


        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getOrdernumber(),orderNumber);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getDateinstalled(),dateInstalled);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getReplacementdate(),replacementDate);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getCommissioned(),comissionDate);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getComcommissioned(),comComissionDate);
        UtilityFunction.checkEditTextSetValue(String.valueOf(Constants.assetsDetails.getQualifeexpectancy()),qualityLifeExpectancy);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getComponentdescription(),comDescription);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getDecommissioned(),deComissionDate);

    /*    UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getPartswarrantydateentered(),et_parts_warranty_entered_date);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getLabourwarrantystartdate(),et_labour_warranty_entered_start);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getLabourwarrantyenddate(),et_labour_warranty_entered_end);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getPartswarrantycomments(),et_warranty_comment);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getLabourwarrantyenterby(),et_labour_warranty_enntered_by);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getLabourwarrantyenddate(),et_labour_warranty_entered_date);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getDrawingnumber(),et_drawing_no);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getOmlink(),et_om_link);
*/
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            nextEvent();
           //     overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        pre=(Button) findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UpdateAsset4.this,UpdateAsset3.class);
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
    private void nextEvent()
    {
        if (supplierName.getSelectedItem().toString().trim().equals("Select Supplier")) {
            View selectedView = supplierName.getSelectedView();
            TextView tv = (TextView) selectedView;
            if (tv.getText().toString().trim().equals("Select Supplier")) {
                tv.setError("Please Select Supplier");
                requestFocus(tv);
            }
            Toast.makeText(this, "Please Select Supplier", Toast.LENGTH_SHORT).show();
        } else if (supplierId.getText().toString().trim().isEmpty()) {
            supplierId.setError("Please Enter Supplier Id");
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
        }else {
            updateSupplierName=supplierName.getSelectedItem().toString();
            updateSubComponent=sub_component.isChecked();
            updateSupplierId=supplierId.getText().toString().trim();
            updateOrderNumber=orderNumber.getText().toString().trim();
            updateQualityLifeExpectancy=qualityLifeExpectancy.getText().toString().trim();
            updateComDescription=comDescription.getText().toString().trim();
            updateDateInstalled=dateInstalled.getText().toString().trim();
            updateReplacementDate=replacementDate.getText().toString().trim();
            updateDeComissionDate=deComissionDate.getText().toString().trim();
            updateComComissionDate=comComissionDate.getText().toString().trim();
            updateComissionDate=comissionDate.getText().toString().trim();

            Constants.updateAssetPOJO.setSupplierName(updateSupplierName);
            Constants.updateAssetPOJO.setSupplierId(updateSupplierId);
            Constants.updateAssetPOJO.setOrderNumber(updateOrderNumber);

            if (updateOldAsset.equals(""))
            {
                Constants.updateAssetPOJO.setOldAssetID("");
            }else if (updateOldAsset.isEmpty())
            {
                Constants.updateAssetPOJO.setOldAssetID("");
            }else if (updateOldAsset.equals("null"))
            {
                Constants.updateAssetPOJO.setOldAssetID("");

            }else {
                Constants.updateAssetPOJO.setOldAssetID(updateOldAsset);
            }
            Constants.updateAssetPOJO.setDateInstalled(updateDateInstalled);
            Constants.updateAssetPOJO.setReplacementDate(updateReplacementDate);
            Constants.updateAssetPOJO.setCommissioned(updateComissionDate);
            Constants.updateAssetPOJO.setDecommissioned(updateDeComissionDate);
            if (updateQualityLifeExpectancy.equals(""))
            {
             Constants.updateAssetPOJO.setQuaLifeExpectancy(0);
            }else {
                Constants.updateAssetPOJO.setQuaLifeExpectancy(Integer.parseInt(updateQualityLifeExpectancy));
            }
            if (sub_component.isChecked()) {
                Constants.updateAssetPOJO.setSubComponent(true);
            }else {
                Constants.updateAssetPOJO.setSubComponent(false);
            }
            Constants.updateAssetPOJO.setComponentDescription(updateComDescription);
            Constants.updateAssetPOJO.setComCommissioned(updateComComissionDate);


            Intent intent=new Intent(UpdateAsset4.this,UpdateAsset5.class);
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
                       /* for(int i=0;i<componentOfAssetDropDowns.size();i++)
                        {
                            if(componentOfAssetDropDowns.get(i).getValue().equals(updateComponentOfAsset))
                            {
                                showComAssetDownList(componentOfAssetDropDowns.get(i).getText());
                            }
                        }
*/       showComAssetDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<ComponentOfAssetDropDown>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
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

         /*   if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                componentOfAsset.setSelection(spinnerPosition);
            }*/
            componentOfAsset.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateComponentOfAsset = componentOfAssetDropDowns.get(position).getValue();

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
                       /* for(int i=0;i<supplierDropDownLists.size();i++)
                        {
                            if(supplierDropDownLists.get(i).getValue().equals(updateSupplierId))
                            {
                                showSupplierDropDownList(supplierDropDownLists.get(i).getText());
                            }
                        }*/

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
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
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
        /*    if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                supplierName.setSelection(spinnerPosition);
            }*/
            supplierName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateSupplierId = supplierDropDownLists.get(position).getValue();
                    supplierId.setText(updateSupplierId);
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
                       /* for(int i=0;i<oldAssetDropDownLists.size();i++)
                        {
                            if(oldAssetDropDownLists.get(i).getValue().equals(updateOldAsset))
                            {
                                showOldAssetDropDownList(oldAssetDropDownLists.get(i).getText());
                            }
                        }
*/                    showOldAssetDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<OldAssetDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
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
          /*  if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                oldAsset.setSelection(spinnerPosition);
            }*/
            oldAsset.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateOldAsset = oldAssetDropDownLists.get(position).getValue();
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

            String date =months   + "-" + days + "-" + year;
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

            String date =months   + "-" + days + "-" + year;
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

            String date =months   + "-" + days + "-" + year;
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

            String date =months   + "-" + days + "-" + year;
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

            String date =months   + "-" + days + "-" + year;
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
