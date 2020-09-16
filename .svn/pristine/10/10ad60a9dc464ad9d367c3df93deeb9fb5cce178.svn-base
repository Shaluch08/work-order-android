package com.workorder.app.workorderapplication.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.LoginFilter;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.workorder.app.R;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.webservicecallback.OnTaskCompleted;
import com.workorder.app.webservicecallback.SendData;
import com.workorder.app.workorderapplication.model.assetModel.AssetCreateResponsePOJO;
import com.workorder.app.workorderapplication.model.assetModel.AssetRequestModel;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import org.json.JSONObject;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UpdateAsset6 extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    AssetRequestModel request;
    TextInputEditText et_parts_warranty_entered_date;
    TextInputEditText et_labour_warranty_entered_start;
    TextInputEditText et_parts_entered_by;
    TextInputEditText et_labour_warranty_entered_end;
    TextInputEditText et_warranty_comment;
    TextInputEditText et_labour_warranty_enntered_by;
    TextInputEditText et_labour_warranty_entered_date;
    TextInputEditText et_drawing_no;
    TextInputEditText et_om_link;

    String entered_by = "";
    String pw_entered_dt = "";
    String lw_entered_start = "";
    String lw_entered_end = "";
    String warrenty_comment = "";
    String lw_entered_by = "";
    String lw_entered_dt = "";
    String drawing_no = "";
    String om_link = "";

    ProgressDialog dialog;
    Button btn_prev;
    Button btn_update;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_asset6);
        et_parts_entered_by = findViewById(R.id.et_entered_by);
        et_parts_warranty_entered_date = findViewById(R.id.et_pw_date_enter);
        et_labour_warranty_entered_start = findViewById(R.id.et_lw_start);
        et_labour_warranty_entered_end = findViewById(R.id.et_lw_end);
        et_warranty_comment = findViewById(R.id.et_warranty_comments);
        et_labour_warranty_enntered_by = findViewById(R.id.et_lw_enteredBy);
        et_labour_warranty_entered_date = findViewById(R.id.et_lw_date_enter);
        et_drawing_no = findViewById(R.id.et_drawing_number);
        et_om_link = findViewById(R.id.et_om_link);
        btn_prev = findViewById(R.id.btn_previous);
        btn_update = findViewById(R.id.btn_update);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait.");
        dialog.setCancelable(false);

        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getPartswarrantyenterby(),et_parts_entered_by);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getPartswarrantydateentered(),et_parts_warranty_entered_date);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getLabourwarrantystartdate(),et_labour_warranty_entered_start);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getLabourwarrantyenddate(),et_labour_warranty_entered_end);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getPartswarrantycomments(),et_warranty_comment);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getLabourwarrantyenterby(),et_labour_warranty_enntered_by);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getLabourwarrantyenddate(),et_labour_warranty_entered_date);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getDrawingnumber(),et_drawing_no);
        UtilityFunction.checkTextInputEditTextSetValue(Constants.assetsDetails.getOmlink(),et_om_link);



        request = new AssetRequestModel();
        Bundle intent = getIntent().getExtras();
        request.setClient(intent.getString("updateClient"));
        request.setAssetType(intent.getString("updateAssetType"));
        request.setEntityStatus(intent.getString("updateAssetStatus"));
        request.setPriority(intent.getString("updatePriority"));
        request.setWarningLevel(intent.getString("updateWarningLevel"));
        request.setUpdatedDate(intent.getString("updateLoadDate"));
        request.setClientNo(intent.getString("updateClientNo"));
        request.setLoadDate(intent.getString("updateLoadDate"));
        request.setAssetCategoryId(intent.getString("updateAssetCategory"));
        request.setAssetSubCategoryId(intent.getString("updateSubCategory"));
        request.setAsset_ID(intent.getString("updateAssetId"));
        request.setAssetName(intent.getString("updateAssetName"));
        request.setDescription(intent.getString("updateDescription"));
        request.setContractNo(intent.getString("updateContractNo"));
        request.setContractType(intent.getString("updateContractType"));
        request.setAssetType(intent.getString("updateAssetCategory"));
        request.setAssetSubCategoryId(intent.getString("updateSubCategory"));
        request.setCondition(intent.getString("updateAssetCondition"));
        request.setRegionId(intent.getString("updateRegion"));
        request.setSubRegionId(intent.getString("updateSubRegion"));
        request.setLocationId(intent.getString("updateLocation"));
        request.setArea(intent.getString("updateArea"));
        request.setConditionDate(intent.getString("updateConditionDate"));
        request.setAssetCode(intent.getString("updateAssetCode"));
        request.setComments(intent.getString("updateAssetComent"));
        request.setBuildingName(intent.getString("updateBuildingName"));
        request.setRoom(intent.getString("updateRoom"));
        request.setCriticality(intent.getString("updateReactiveCriticality"));
        request.setInspectionFrequency(intent.getString("updateInspectionFrequency"));
        request.setNextInspectionDate(intent.getString("updateNextInspectionDate"));
        request.setLastInspectionDate(intent.getString("updateLastInspectionDate"));
        request.setRoomName(intent.getString("updateRoomName"));
        request.setFloor(intent.getString("updateFloor"));
        request.setAssetUse(intent.getString("updateAssetUse"));
        request.setEnergyRating(intent.getString("updateEnergyRating"));
        request.setInspectionProcedureResult(intent.getString("updateInspectionProcedureResult"));
        request.setInspectionComments(intent.getString("updateInspectionComments"));
        request.setStrategy(intent.getString("updateMaintenanceStrategy"));
        request.setMaintenaceFrequency(intent.getString("updateMaintenanceFrequency"));
        request.setNextMaintenanceDate(intent.getString("updateNextMaintenanceDate"));
        request.setLastMaintenanceDate(intent.getString("updateLastMaintenanceDate"));
        request.setMaintenanceProcedureResult(intent.getString("updateMaintenanceProcedureResult"));
        request.setMaintenanceComments(intent.getString("updateMaintenanceComments"));
        request.setSupplierName(intent.getString("updateSupplierName"));
        request.setSubComponentId(intent.getString("updateComponentOfAsset"));
        request.setOldAssetID(intent.getString("updateOldAsset"));
        request.setSupplierId(intent.getString("updateSupplierId"));
        request.setOrderNumber(intent.getString("updateOrderNumber"));
        request.setQuaLifeExpectancy(intent.getString("updateQualityLifeExpectancy"));
        request.setComponentDescription(intent.getString("updateComDescription"));
        request.setDateInstalled(intent.getString("updateDateInstalled"));
        request.setReplacementDate(intent.getString("updateReplacementDate"));
        request.setReplacementYear("2018");
        request.setCommissioned(intent.getString("updateComissionDate"));
        request.setDecommissioned(intent.getString("updateDeComissionDate"));
        request.setComCommissioned(intent.getString("updateComComissionDate"));
        request.setComDecommissioned(intent.getString("updateComDateDeComission"));
        request.setLabourWarrantyStartDate(intent.getString("updateWarrantyStart"));
        request.setLabourWarrantyEndDate(intent.getString("updateWarrantyEnd"));
        request.setEstMaintenanceCost(intent.getString("updateEstMaintenance"));
        request.setPurchaseCost(intent.getString("updatePurchaseCost"));
        request.setExpectedReplacementCost(intent.getString("updateExpectReplaceCost"));
        request.setManufacturer(intent.getString("updateManufacturer"));
        request.setMake(intent.getString("updateMakeYear"));
        request.setModelNo(intent.getString("updateModel"));
        request.setSerialNo(intent.getString("updateSerialNo"));
        request.setBarCode(intent.getString("updateBarCode"));
        request.setWarrantyLengthInMonth(intent.getString("updatePartsWarrantyLengthMonth"));
        request.setWarrantyLengthInYear(intent.getString("updatePartsWarrantyLengthYear"));
        request.setPartsWarrantyComments(intent.getString("updatePartsWarrantyComments"));
        request.setPartsWarrantyDateEntered(intent.getString("updatePartyWarrantyDateEntered"));
        request.setLabourWarrantyStartDate(intent.getString("updateLabourWarrantyStart"));
        request.setLabourWarrantyEndDate(intent.getString("updateLabourWarrantyEnd"));
        request.setPartsWarrantyEnterBy(intent.getString("updatePartsWarrantyEnteredBy"));
        request.setLabourWarrantyComments(intent.getString("updateWarrantyComments"));
        request.setDrawingNumber(intent.getString("updateDrwaingNumber"));
        request.setOMLink(intent.getString("updateOmLink"));
        request.setPersonId(Constants.loginPOJO.getPersonCompanyId());
        request.setQuaLifeExpectancy(intent.getString("updateQualityLifeExpectancy"));
        request.setQtyLife("jkdfs");
        request.setLabourWarrantyEnterBy(intent.getString("updateLabourWarrantyEnteredBy"));
        request.setLabourWarrantyDateEntered(intent.getString("updateLabourWarrantyDateEntered"));
        request.setStatutoryMaintenance(intent.getBoolean("updateStatutoryMaintenance"));
        request.setSubComponent(intent.getBoolean("updateSubComponent"));
        request.setWarrantyExpiration("2020");
        request.setWarrantyLength("2 Years");
        request.setSpecificRequirement("fdsakk");

        et_parts_warranty_entered_date.setText(request.getPartsWarrantyDateEntered());
        et_labour_warranty_entered_start.setText(request.getLabourWarrantyStartDate());
        et_parts_entered_by.setText(request.getPartsWarrantyEnterBy());
        et_labour_warranty_entered_end.setText(request.getLabourWarrantyEndDate());
        et_warranty_comment.setText(request.getLabourWarrantyComments());
        et_labour_warranty_enntered_by.setText(request.getLabourWarrantyEnterBy());

        et_labour_warranty_entered_date.setText(request.getLabourWarrantyDateEntered());
        et_drawing_no.setText(request.getDrawingNumber());
        et_om_link.setText(request.getOMLink());

        setListner();

    }


    public void setListner() {
        et_parts_warranty_entered_date.setOnClickListener(this);
        et_labour_warranty_entered_start.setOnClickListener(this);
        et_labour_warranty_entered_end.setOnClickListener(this);
        et_labour_warranty_entered_date.setOnClickListener(this);
        btn_prev.setOnClickListener(this);
        btn_update.setOnClickListener(this);

    }


    public void callUpdateAssetApi() {

        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            try {
          /*     final ProgressDialog progressDialog=new ProgressDialog(this);
                progressDialog.setMessage("Please Wait.");
                progressDialog.setCancelable(false);
                progressDialog.show();
                ApiServicesWorkOrder apiServicesWorkOrder=NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
               Call<AssetCreateResponsePOJO> updateAsset= apiServicesWorkOrder.updateAsset("application/json","?companyid="+Constants.loginPOJO.getPersonCompanyId(),Constants.updateAssetPOJO);
                updateAsset.enqueue(new Callback<AssetCreateResponsePOJO>() {
                    @Override
                    public void onResponse(Call<AssetCreateResponsePOJO> call, Response<AssetCreateResponsePOJO> response) {
                       try {
                           if (response.body().getMsg().equals("Asset Created Successfully"))
                           {
                               Toast.makeText(UpdateAsset6.this, ""+response.body().getMsg(), Toast.LENGTH_SHORT).show();
                           }else {
                               Toast.makeText(UpdateAsset6.this, ""+response.body().getMsg(), Toast.LENGTH_SHORT).show();
                           }
                       }catch (Exception e)
                       {
                           e.printStackTrace();
                       }
                       progressDialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<AssetCreateResponsePOJO> call, Throwable t) {
                        Toast.makeText(UpdateAsset6.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                      Log.d("AssetUpdateError",t.getMessage());
                        progressDialog.dismiss();

                    }
                });*/


                JSONObject jsonObject = new JSONObject();
              /*  jsonObject.put("area", Constants.updateAssetPOJO.getArea());
                jsonObject.put("assetCategoryId", Constants.updateAssetPOJO.getAssetCategoryId());
                jsonObject.put("assetCode", Constants.updateAssetPOJO.getAssetCode());
                jsonObject.put("asset_ID", Constants.updateAssetPOJO.getAssetId());
                jsonObject.put("assetName", Constants.updateAssetPOJO.getAssetName());
                jsonObject.put("assetSubCategoryId", Constants.updateAssetPOJO.getAssetSubCategoryId());
                jsonObject.put("assetType", Constants.updateAssetPOJO.getAssetType());
                jsonObject.put("barCode", Constants.updateAssetPOJO.getBarCode());
                jsonObject.put("buildingName", Constants.updateAssetPOJO.getBuildingName());
                jsonObject.put("clientNo", Constants.updateAssetPOJO.getClientNo());
                jsonObject.put("comCommissioned", Constants.updateAssetPOJO.getComCommissioned());
                jsonObject.put("comDecommissioned", Constants.updateAssetPOJO.getComDecommissioned());
                jsonObject.put("comments", Constants.updateAssetPOJO.getComments());
                jsonObject.put("commissioned", Constants.updateAssetPOJO.getCommissioned());
                jsonObject.put("componentDescription", Constants.updateAssetPOJO.getComponentDescription());
                jsonObject.put("condition", Constants.updateAssetPOJO.getCondition());
                jsonObject.put("conditionDate", Constants.updateAssetPOJO.getConditionDate());
                jsonObject.put("contractNo", Constants.updateAssetPOJO.getContractNo());
                jsonObject.put("criticality", Constants.updateAssetPOJO.getCriticality());
                jsonObject.put("dateInstalled", Constants.updateAssetPOJO.getDateInstalled());
                jsonObject.put("decommissioned", Constants.updateAssetPOJO.getDecommissioned());
                jsonObject.put("description", Constants.updateAssetPOJO.getDescription());
                jsonObject.put("drawingNumber", Constants.updateAssetPOJO.getDrawingNumber());
                jsonObject.put("energyRating", Constants.updateAssetPOJO.getEnergyRating());
                jsonObject.put("estMaintenanceCost", Constants.updateAssetPOJO.getEstMaintenanceCost());
                jsonObject.put("expectedReplacementCost", Constants.updateAssetPOJO.getExpectedReplacementCost());
                jsonObject.put("userIdReferenceNumber","");
                jsonObject.put("floor", Constants.updateAssetPOJO.getFloor());
                jsonObject.put("inspectionComments", Constants.updateAssetPOJO.getInspectionComments());
                jsonObject.put("inspectionFrequency", Constants.updateAssetPOJO.getInspectionFrequency());
                jsonObject.put("inspectionProcedureResult", Constants.updateAssetPOJO.getInspectionProcedureResult());
                jsonObject.put("labourWarrantyComments", Constants.updateAssetPOJO.getLabourWarrantyComments());
                jsonObject.put("labourWarrantyDateEntered", Constants.updateAssetPOJO.getLabourWarrantyDateEntered());
                jsonObject.put("labourWarrantyEndDate", Constants.updateAssetPOJO.getLabourWarrantyEndDate());
                jsonObject.put("labourWarrantyEnterBy", Constants.updateAssetPOJO.getLabourWarrantyEnterBy());
                jsonObject.put("labourWarrantyStartDate", Constants.updateAssetPOJO.getLabourWarrantyStartDate());
                jsonObject.put("lastInspectionDate", Constants.updateAssetPOJO.getLastInspectionDate());
                jsonObject.put("loadDate", Constants.updateAssetPOJO.getLoadDate());
                jsonObject.put("locationId", Constants.updateAssetPOJO.getLocationId());
                jsonObject.put("maintenanceComments", Constants.updateAssetPOJO.getMaintenanceComments());
                jsonObject.put("maintenanceProcedureResult", Constants.updateAssetPOJO.getMaintenanceProcedureResult());

                jsonObject.put("manufacturer", Constants.updateAssetPOJO.getManufacturer());
                jsonObject.put("modelNo", Constants.updateAssetPOJO.getModelNo());
                jsonObject.put("nextInspectionDate", Constants.updateAssetPOJO.getNextInspectionDate());
                jsonObject.put("nextMaintenanceDate", Constants.updateAssetPOJO.getNextMaintenanceDate());
                jsonObject.put("omLink", Constants.updateAssetPOJO.getOmLink());
                jsonObject.put("oldAssetID", Constants.updateAssetPOJO.getOldAssetID());
                jsonObject.put("orderNumber", Constants.updateAssetPOJO.getOrderNumber());
                jsonObject.put("partsWarrantyComments", Constants.updateAssetPOJO.getPartsWarrantyComments());
                jsonObject.put("partsWarrantyDateEntered", Constants.updateAssetPOJO.getPartsWarrantyDateEntered());
                jsonObject.put("partsWarrantyEnterBy", Constants.updateAssetPOJO.getPartsWarrantyEnterBy());
                jsonObject.put("priority", Constants.updateAssetPOJO.getPriority());
                jsonObject.put("purchaseCost", Constants.updateAssetPOJO.getPurchaseCost());
                jsonObject.put("quaLifeExpectancy", Constants.updateAssetPOJO.getQuaLifeExpectancy());
                jsonObject.put("regionId", Constants.updateAssetPOJO.getRegionId());
                jsonObject.put("replacementDate", Constants.updateAssetPOJO.getReplacementDate());
                jsonObject.put("room", Constants.updateAssetPOJO.getRoom());
                jsonObject.put("roomName", Constants.updateAssetPOJO.getRoomName());
                jsonObject.put("serialNo", Constants.updateAssetPOJO.getSerialNo());
                jsonObject.put("statutoryMaintenance", Constants.updateAssetPOJO.getStatutoryMaintenance());
                jsonObject.put("strategy", Constants.updateAssetPOJO.getStrategy());
                jsonObject.put("subComponent", Constants.updateAssetPOJO.getSubComponent());
                jsonObject.put("subRegionId", Constants.updateAssetPOJO.getSubRegionId());
                jsonObject.put("postcode",Constants.updateAssetPOJO.getPostcode());

                jsonObject.put("supplierId", Constants.updateAssetPOJO.getSupplierId());
                jsonObject.put("supplierName", Constants.updateAssetPOJO.getSupplierName());
                jsonObject.put("warningLevel", Constants.updateAssetPOJO.getWarningLevel());
                jsonObject.put("warrantyLengthInMonth", Constants.updateAssetPOJO.getWarrantyLengthInMonth());
                jsonObject.put("warrantyLengthInYear", Constants.updateAssetPOJO.getWarrantyLengthInYear());

                jsonObject.put("assetUse", Constants.updateAssetPOJO.getAssetUse());
                jsonObject.put("contractType", 5);
                if (Constants.updateAssetPOJO.getEntityStatus()==null)
                {
                    jsonObject.put("entityStatus", "1");

                }else {
                    jsonObject.put("entityStatus", Constants.updateAssetPOJO.getEntityStatus());
                }
                jsonObject.put("maintenaceFrequency", 15);
                jsonObject.put("personId", Constants.loginPOJO.getPersonCompanyId());
                jsonObject.put("qtyLife", 12);
                jsonObject.put("ReplacementYear",Constants.updateAssetPOJO.getArea());
                jsonObject.put("SpecificRequirement",Constants.updateAssetPOJO.getSpecificRequirement());
               // jsonObject.put("updatedDate",Constants.updateAssetPOJO.getUp());
                jsonObject.put("warrantyExpiration",Constants.updateAssetPOJO.getWarrantyExpiration());
                jsonObject.put("warrantyLength",Constants.updateAssetPOJO.getWarrantyLength());
                jsonObject.put("updatedBy", Constants.loginPOJO.getUserId());
                new SendData(this, jsonObject, "http://109.228.49.117:8095/api/assets/UpdateAssetDetails?companyid=" + Constants.loginPOJO.getPersonCompanyId(), new OnTaskCompleted<String>() {
                    @Override
                    public void onTaskCompleted(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            if (object.getString("msg").equals("Asset Updation Sucessfully")) {
                                Toast.makeText(UpdateAsset6.this, "" + object.getString("msg"), Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(UpdateAsset6.this, SearchAsset.class));
                                finishAffinity();
                            } else {
                                Toast.makeText(UpdateAsset6.this, "" + object.getString("msg"), Toast.LENGTH_SHORT).show();

                            }

                        } catch (Exception e) {
                            Log.d("UpdatePostAsset", e.toString());
                        }
                    }
                }, true).execute();*/
               Constants.updateAssetPOJO.setPersonId(Constants.assetsDetails.getPersonid());
               Constants.updateAssetPOJO.setMaintenaceFrequency(Constants.assetsDetails.getMaintenacefrequency());
               Constants.updateAssetPOJO.setUserIdReferenceNumber(Constants.assetsDetails.getUseridreferencenumber());
               Constants.updateAssetPOJO.setContractType(Constants.assetsDetails.getContracttype());
               Constants.updateAssetPOJO.setWarrantyLength(Constants.assetsDetails.getWarrantylength());
               Constants.updateAssetPOJO.setRemovedNextMaintenanceCode(Constants.assetsDetails.getRemovednextmaintenancecode());
               Constants.updateAssetPOJO.setQtyLife(Constants.assetsDetails.getQtylife());
               Constants.updateAssetPOJO.setUpdatedBy(Constants.loginPOJO.getUserId());

            } catch (Exception e) {
                Log.d("UpdateAsset", e.toString());

            }
             dialog.show();
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<AssetCreateResponsePOJO> loginResponseCall =
                    apiServicesWorkOrder.updateAsset("application/json",Constants.updateAssetPOJO);
            loginResponseCall.enqueue(new Callback<AssetCreateResponsePOJO>() {
                @Override
                public void onResponse(Call<AssetCreateResponsePOJO> call, Response<AssetCreateResponsePOJO> response) {
                    try {
                      //  int codeStatus=response.code();
                        // TODO NULL CHECK OF RESPONSE
                        if (response.body().getMsg().equals("Asset Updation Sucessfully"))
                        {
                            startActivity(new Intent(UpdateAsset6.this, SearchAsset.class));
                            finishAffinity();
                            Toast.makeText(getApplicationContext(), ""+response.body().getMsg(), Toast.LENGTH_LONG).show();

                        }else {
                            Toast.makeText(getApplicationContext(), ""+response.body().getMsg(), Toast.LENGTH_LONG).show();

                        }

                      //  startActivity(new Intent(UpdateAsset6.this,SearchAsset.class));
                        dialog.dismiss();
                    } catch (Exception e) {
                        dialog.dismiss();
                        Log.v("Error",e.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<AssetCreateResponsePOJO> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                    dialog.dismiss();
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_pw_date_enter:
                et_date = et_parts_warranty_entered_date;
                openDatePicker();
                break;
            case R.id.et_lw_start:
                et_date = et_labour_warranty_entered_start;
                openDatePicker();
                break;
            case R.id.et_lw_end:
                et_date = et_labour_warranty_entered_end;
                openDatePicker();
                break;
            case R.id.et_lw_date_enter:
                et_date = et_labour_warranty_entered_date;
                openDatePicker();
                break;
            case R.id.btn_previous:
                onBackPressed();
                finish();
            case R.id.btn_update:
                entered_by = et_parts_entered_by.getText().toString().trim();
                pw_entered_dt = et_parts_warranty_entered_date.getText().toString().trim();
                lw_entered_start = et_labour_warranty_entered_start.getText().toString().trim();
                lw_entered_end = et_labour_warranty_entered_end.getText().toString().trim();
                warrenty_comment = et_warranty_comment.getText().toString().trim();
                lw_entered_by = et_labour_warranty_enntered_by.getText().toString().trim();
                lw_entered_dt = et_labour_warranty_entered_date.getText().toString().trim();
                drawing_no = et_drawing_no.getText().toString().trim();
                om_link = et_om_link.getText().toString().trim();
                if (entered_by.equals("")) {
                    et_parts_entered_by.requestFocus();
                    et_parts_entered_by.setError("Please enter parts entered by");
                } else if (pw_entered_dt.equals("")) {
                    et_parts_warranty_entered_date.requestFocus();
                    et_parts_warranty_entered_date.setError("Please enter date");
                } else if (lw_entered_start.equals("")) {
                    et_labour_warranty_entered_start.requestFocus();
                    et_labour_warranty_entered_start.setError("Please enter start date");
                } else if (lw_entered_end.equals("")) {
                    et_labour_warranty_entered_end.requestFocus();
                    et_labour_warranty_entered_end.setError("Please enter end date");
                } else if (lw_entered_by.equals("")) {
                    et_labour_warranty_enntered_by.requestFocus();
                    et_labour_warranty_enntered_by.setError("Please enter parts entered by");
                } else if (lw_entered_dt.equals("")) {
                    et_labour_warranty_entered_date.requestFocus();
                    et_labour_warranty_entered_date.setError("Please enter entered date");
                } else if (drawing_no.equals("")) {
                    et_drawing_no.requestFocus();
                    et_drawing_no.setError("Please enter drawing number");
                } else if (om_link.equals("")) {
                    et_om_link.requestFocus();
                    et_om_link.setError("Please enter om link");
                } else {

                    Constants.updateAssetPOJO.setPartsWarrantyDateEntered(et_parts_warranty_entered_date.getText().toString());
                    Constants.updateAssetPOJO.setLabourWarrantyStartDate(et_labour_warranty_entered_start.getText().toString());
                    Constants.updateAssetPOJO.setPartsWarrantyEnterBy(et_parts_entered_by.getText().toString());
                    Constants.updateAssetPOJO.setLabourWarrantyEndDate(et_labour_warranty_entered_end.getText().toString());
                    Constants.updateAssetPOJO.setLabourWarrantyComments(et_warranty_comment.getText().toString());
                    Constants.updateAssetPOJO.setLabourWarrantyEnterBy(et_labour_warranty_enntered_by.getText().toString());
                    Constants.updateAssetPOJO.setLabourWarrantyDateEntered(et_labour_warranty_entered_date.getText().toString());
                    Constants.updateAssetPOJO.setDrawingNumber(et_drawing_no.getText().toString());
                    Constants.updateAssetPOJO.setOmLink(et_om_link.getText().toString());


                    // et_labour_warranty_entered_start.setText(request.getLabourWarrantyStartDate());
                    //  et_parts_entered_by.setText(request.getPartsWarrantyEnterBy());
                    //   et_labour_warranty_entered_end.setText(request.getLabourWarrantyEndDate());
                    // et_warranty_comment.setText(request.getLabourWarrantyComments());
                    //   et_labour_warranty_enntered_by.setText(request.getLabourWarrantyEnterBy());
                    //  et_labour_warranty_entered_date.setText(request.getLabourWarrantyDateEntered());
                    // et_drawing_no.setText(request.getDrawingNumber());
                    //   et_om_link.setText(request.getOMLink());


                    callUpdateAssetApi();
                }
                break;


        }
    }

    String selected_date = "";
    boolean is_custom_DT = false;
    TextInputEditText et_date, et_time;

    public void openDatePicker() {
        Calendar now = Calendar.getInstance();
        //now.setTimeInMillis(now.getTimeInMillis());
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                UpdateAsset6.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

      //  dpd.setMinDate(now);
        dpd.show(this.getFragmentManager(), "Datepickerdialog");
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        String month = "";
        String day = "";
        if ((monthOfYear + 1) < 10) {
            month = "0" + (monthOfYear + 1);
        } else {
            month = String.valueOf(monthOfYear + 1);
        }

        if (dayOfMonth < 10) {
            day = "0" + dayOfMonth;
        } else {
            day = String.valueOf(dayOfMonth);
        }

        String date = month + "-" + day + "-" + year;
        selected_date = date;


        et_date.setText(date);

        //  et_date.setText(UtilityFunction.changeDateFormat(date));

        //  et_movement_date.setText(UtilityFunction.changeDateFormat(date));
    }


}
