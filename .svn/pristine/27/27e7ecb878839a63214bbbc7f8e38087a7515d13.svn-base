package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.workorder.app.workorderapplication.model.assetModel.EditAssetsDetails;
import com.workorder.app.workorderapplication.model.dashboardModel.DashBoardResponse;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateAsset extends AppCompatActivity {

    ArrayList<Treestuctutr> list;
    DashBoardResponse responses;
    Dialog dialog;
    ArrayList<ContrctTree> contrctTrees;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    SimpleDateFormat newformat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String userrole, companyid, clientId, rolename, id;
    Button next;
    EditAssetsDetails editAssetsDetails;
    List<AssetStatusDropDownList> assetStatusDropDownLists;
    List<AssetDropDownList> assetDropDownLists;
    List<PriorityDropDownList> priorityDropDownLists;
    List<AssetTypeDropDownList> assetTypeDropDownLists;
    List<WarningLevelDropDownList> warningLevelDropDownLists;
    Spinner client, assetType, assetStatus, priority, warningLevel;
    static EditText loadDate;
    Integer asset_ID;
    EditText clientNumber, assetId, assetName, description, contractNo;

    String updateClient, updateAssetType, updateAssetStatus, updatePriority, updateWarningLevel,
            updateLoadDate, updateClientNo, updateAssetId, updateAssetName, updateDescription,
            updateContractNo, updateContractType, updateAssetCategory, updateSubCategory,
            updateAssetCondition, updateRegion, updateSubRegion, updateLocation, updateArea,
            updateConditionDate, updateAssetCode, updateAssetComent, updateBuildingName,
            updateRoom, updateReactiveCriticality, updateInspectionFrequency,
            updateNextInspectionDate, updateLastInspectionDate, updateRoomName, updateFloor,
            updateAssetUse, updateEnergyRating, updateInspectionProcedureResult,
            updateInspectionComments, updateMaintenanceStrategy, updateMaintenanceFrequency,
            updateNextMaintenanceDate, updateLastMaintenanceDate,
            updateMaintenanceProcedureResult, updateMaintenanceComments, updateSupplierName,
            updateComponentOfAsset, updateOldAsset, updateSupplierId, updateOrderNumber,
            updateQualityLifeExpectancy, updateComDescription, updateDateInstalled,
            updateReplacementDate, updateComissionDate, updateDeComissionDate,
            updateComComissionDate, updateComDateDeComission, updateWarrantyStart,
            updateWarrantyEnd, updateEstMaintenance, updatePurchaseCost,
            updateExpectReplaceCost, updateManufacturer, updateMakeYear, updateModel,
            updateSerialNo, updateBarCode, updatePartsWarrantyLengthMonth,
            updatePartsWarrantyLengthYear, updatePartsWarrantyComments,
            updatePartyWarrantyDateEntered, updateLabourWarrantyStart,
            updateLabourWarrantyEnd, updatePartsWarrantyEnteredBy, updateWarrantyComments,
            updateDrwaingNumber, updateOmLink, updateLabourWarrantyEnteredBy, updateLabourWarrantyDateEntered;

    boolean updateStatutoryMaintenance, updateSubComponent;
    Spinner sp_process_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_asset);

        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());

        Bundle intent = getIntent().getExtras();
        if (intent != null) {
            id = intent.getString("AssetId");
            Log.d("Id", id);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Update Asset");

        ImageView image = toolbar.findViewById(R.id.tree);
        image.setVisibility(View.VISIBLE);

        fetchDashBoardListFM();

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager")) {
                    Intent intent = new Intent(UpdateAsset.this, TreeStructure.class);
                    intent.putExtra("list", list);
                    startActivity(intent);
                    //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                } else if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")) {
                    Intent intent = new Intent(UpdateAsset.this, TreeStructure.class);
                    intent.putExtra("contrctTreeList", contrctTrees);
                    startActivity(intent);
                    //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                } else if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Client")) {
                    Intent intent = new Intent(UpdateAsset.this, TreeStructure.class);
                    intent.putExtra("list", list);
                    startActivity(intent);
                    //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }
                Toast.makeText(UpdateAsset.this, "Action Escalation Tree", Toast.LENGTH_SHORT).show();
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

        userrole = preferenceManagerWorkOrder.getKey_User_Role();
        companyid = preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename = preferenceManagerWorkOrder.getKey_User_Name();
        client = (Spinner) findViewById(R.id.spinner_client);
        assetType = (Spinner) findViewById(R.id.spinner_asset_type);
        assetStatus = (Spinner) findViewById(R.id.spinner_asset_status);
        priority = (Spinner) findViewById(R.id.spinner_priority);
        warningLevel = (Spinner) findViewById(R.id.spinner_warning_level);
        sp_process_type = findViewById(R.id.spinner_process_type);
        clientNumber = (EditText) findViewById(R.id.clientNo);
        loadDate = (EditText) findViewById(R.id.load_date);
        loadDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog0(v);
            }
        });
        assetId = (EditText) findViewById(R.id.asset_id);
        assetName = (EditText) findViewById(R.id.asset_name);
        contractNo = (EditText) findViewById(R.id.contract_number);
        description = (EditText) findViewById(R.id.txt_description);
        next = (Button) findViewById(R.id.btn_next);

        getUpdateListAsset();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextEvent();
                //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        Button pre = (Button) findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateAsset.this, SearchAsset.class));
                //  overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });

        fetProcessTypeDropDown();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }

    private void nextEvent() {
        try {
            if (client.getSelectedItem().toString().trim().equals("Select Client")) {
                View selectedView = client.getSelectedView();
                TextView tv = (TextView) selectedView;
                if (tv.getText().toString().trim().equals("Select Client")) {
                    tv.setError("Please Select Client");
                    requestFocus(tv);
                }
                Toast.makeText(UpdateAsset.this, "Please Select Client", Toast.LENGTH_SHORT).show();
            } else if (clientNumber.getText().toString().trim().isEmpty()) {
                clientNumber.setError("Please Select Client Number");
                requestFocus(clientNumber);
            } else if (assetId.getText().toString().trim().isEmpty()) {
                assetId.setError("Please Enter Asset Id");
                requestFocus(assetId);
                // Toast.makeText(Asset.this, , Toast.LENGTH_SHORT).show();
            } else if (assetName.getText().toString().trim().isEmpty()) {
                assetName.setError("Please Enter Asset Name");
                requestFocus(assetName);
            } else if (assetType.getSelectedItem().toString().trim().equals("Please Select Asset Type")) {
                View selectedView = assetType.getSelectedView();
                TextView tv = (TextView) selectedView;
                if (tv.getText().toString().trim().equals("Please Select Asset Type")) {
                    tv.setError("Please Select Asset Type");
                    requestFocus(tv);
                }
                Toast.makeText(UpdateAsset.this, "Please Select Asset Type", Toast.LENGTH_SHORT).show();
            } else if (contractNo.getText().toString().trim().isEmpty()) {
                contractNo.setError("Please Enter Contract Number");
                requestFocus(contractNo);
            } else if (loadDate.getText().toString().trim().isEmpty()) {
                loadDate.setError("Please Enter Load Date");
                requestFocus(loadDate);
            } else {
                updateClientNo = clientNumber.getText().toString().trim();
                updateAssetId = assetId.getText().toString().trim();
                updateAssetName = assetName.getText().toString().trim();
                updateDescription = description.getText().toString().trim();
                updateLoadDate = loadDate.getText().toString().trim();
                updateContractNo = contractNo.getText().toString().trim();

                Constants.updateAssetPOJO.setClientNo(updateClientNo);
                Constants.updateAssetPOJO.setAssetID(String.valueOf(asset_ID));

                Constants.updateAssetPOJO.setAssetName(updateAssetName);
                Constants.updateAssetPOJO.setAssetType(Integer.parseInt(updateAssetType));
                Constants.updateAssetPOJO.setEntityStatus(Integer.parseInt(updateAssetStatus));
                Constants.updateAssetPOJO.setPriority(Integer.parseInt(updatePriority));

                try {
                    Constants.updateAssetPOJO.setWarningLevel(Integer.valueOf(updateWarningLevel));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Constants.updateAssetPOJO.setProcessType(String.valueOf(processTypePOJOList.get(sp_process_type.getSelectedItemPosition()).getSubtypeid()));
                Constants.updateAssetPOJO.setDescription(updateDescription);
                Constants.updateAssetPOJO.setLoadDate(updateLoadDate);
                Constants.updateAssetPOJO.setContractNo(updateContractNo);


                Intent intent = new Intent(UpdateAsset.this, UpdateAsset1.class);
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
                intent.putExtras(bundle);
                intent.putExtra("list", list);
                intent.putExtra("contrctTreeList", contrctTrees);
                startActivity(intent);
            }
        } catch (Exception e) {
            Log.d("UpdateAsset", e.toString());
        }

    }

    List<AssetProcessTypePOJO> processTypePOJOList = new ArrayList<>();
    String[] processTypeList;

    public void fetProcessTypeDropDown() {
        new GetApiCallback(this, UrlClass.ASSET_PROCESS_TYPE_URL, new OnTaskCompleted<String>() {
            @Override
            public void onTaskCompleted(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("data");
                    processTypePOJOList = Arrays.asList(new Gson().fromJson(array.toString(), AssetProcessTypePOJO[].class));
                    processTypeList = new String[processTypePOJOList.size()];
                    for (int i = 0; i < processTypePOJOList.size(); i++) {
                        processTypeList[i] = processTypePOJOList.get(i).getSubtypetext();
                    }
                    sp_process_type.setAdapter(new ArrayAdapter<String>(UpdateAsset.this, android.R.layout.simple_list_item_1, processTypeList));


                    if (Constants.assetsDetails.getProcesstype() != null) {
                        int position = 0;
                        for (int i = 0; i < processTypePOJOList.size(); i++) {
                            if (processTypePOJOList.get(i).getSubtypeid() == Constants.assetsDetails.getProcesstype()) {
                                position = i;
                            }
                        }
                        sp_process_type.setSelection(position);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, true).execute();
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

    public void getUpdateListAsset() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<EditAssetsDetails> details = apiServicesWorkOrder.editAssetDetails("application/json", "api/assets/EditAssetsDetails?Id=" + id);
            details.enqueue(new Callback<EditAssetsDetails>() {
                @Override
                public void onResponse(Call<EditAssetsDetails> call, Response<EditAssetsDetails> response) {
                    if (response.body() != null) {
                        editAssetsDetails = response.body();
                        Constants.assetsDetails = response.body();
                        asset_ID = editAssetsDetails.getAssetId();
                        preferenceManagerWorkOrder.setAsset_ID(String.valueOf(asset_ID));
                        updateClientNo = editAssetsDetails.getClientno();
                        clientNumber.setText(updateClientNo);
                        updateAssetType = String.valueOf(editAssetsDetails.getAssettype());
                        updateAssetStatus = String.valueOf(editAssetsDetails.getEntitystatus());
                        updatePriority = String.valueOf(editAssetsDetails.getPriority());
                        updateWarningLevel = String.valueOf(editAssetsDetails.getWarninglevel());
                        // updateClientNo=editAssetsDetails.getClientNo();
//                        Log.d("ClientNo",updateClientNo);

                        //  updateAssetId = editAssetsDetails.getAssetid();
                        assetId.setText(String.valueOf(editAssetsDetails.getAssetId()));
                        assetId.setEnabled(false);
                        updateAssetName = editAssetsDetails.getAssetname();
                        assetName.setText(updateAssetName);
                        updateDescription = editAssetsDetails.getDescription();
                        description.setText(updateDescription);
                        updateContractNo = editAssetsDetails.getContractno();
                        contractNo.setText(updateContractNo);
                        updateContractType = String.valueOf(editAssetsDetails.getContracttype());
                        updateAssetCategory = String.valueOf(editAssetsDetails.getAssetcategoryid());
                        updateSubCategory = editAssetsDetails.getAssetsubcategoryid();
                        updateAssetCondition = String.valueOf(editAssetsDetails.getCondition());
                        updateRegion = editAssetsDetails.getRegionid();
                        updateSubRegion = editAssetsDetails.getSubregionid();
                        try {
                            updateLocation = editAssetsDetails.getLocationid();

                            Log.d("LocationId", updateLocation);
                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }


                        updateArea = editAssetsDetails.getArea();
                        updateAssetCode = editAssetsDetails.getAssetcode();
                        updateAssetComent = editAssetsDetails.getComments();
                        updateBuildingName = editAssetsDetails.getBuildingname();
                        updateRoom = editAssetsDetails.getRoom();
                        updateReactiveCriticality = String.valueOf(editAssetsDetails.getCriticality());
                        updateInspectionFrequency = String.valueOf(editAssetsDetails.getInspectionfrequency());
                        updateRoomName = editAssetsDetails.getRoomname();
                        updateEnergyRating = String.valueOf(editAssetsDetails.getEnergyrating());
                        updateAssetUse = editAssetsDetails.getAssetuse();
                        updateFloor = editAssetsDetails.getFloor();
                        updateInspectionProcedureResult = editAssetsDetails.getInspectionprocedureresult();
                        updateInspectionComments = editAssetsDetails.getInspectioncomments();
                        updateMaintenanceStrategy = String.valueOf(editAssetsDetails.getStrategy());
                        updateMaintenanceFrequency = String.valueOf(editAssetsDetails.getMaintenacefrequency());
                        updateMaintenanceProcedureResult = editAssetsDetails.getMaintenanceprocedureresult();
                        updateMaintenanceComments = editAssetsDetails.getMaintenancecomments();
                        updateSupplierName = editAssetsDetails.getSuppliername();
                        updateComponentOfAsset = String.valueOf(editAssetsDetails.getSubcomponentid());
                        updateOldAsset = String.valueOf(editAssetsDetails.getOldassetid());
                        updateSupplierId = editAssetsDetails.getSupplierid();
                        updateOrderNumber = editAssetsDetails.getOrdernumber();
                        updateQualityLifeExpectancy = String.valueOf(editAssetsDetails.getQualifeexpectancy());
                        updateComDescription = editAssetsDetails.getComponentdescription();
                        updateDrwaingNumber = editAssetsDetails.getDrawingnumber();
                        updateOmLink = String.valueOf(editAssetsDetails.getOmlink());
                        updateEstMaintenance = String.valueOf(editAssetsDetails.getEstmaintenancecost());
                        updateManufacturer = editAssetsDetails.getManufacturer();
                        updateBarCode = editAssetsDetails.getBarcode();
                        updateModel = editAssetsDetails.getModelno();
                        updateSerialNo = editAssetsDetails.getSerialno();
                        updatePartsWarrantyComments = editAssetsDetails.getPartswarrantycomments();
                        updateWarrantyComments = editAssetsDetails.getLabourwarrantycomments();
                        updatePartsWarrantyEnteredBy = editAssetsDetails.getPartswarrantyenterby();
                        updatePartsWarrantyLengthYear = String.valueOf(editAssetsDetails.getWarrantylengthinyear());
                        updatePartsWarrantyLengthMonth = String.valueOf(editAssetsDetails.getWarrantylengthinmonth());
                        updateMakeYear = String.valueOf(editAssetsDetails.getMake());
                        updatePurchaseCost = String.valueOf(editAssetsDetails.getPurchasecost());
                        updateExpectReplaceCost = String.valueOf(editAssetsDetails.getExpectedreplacementcost());
                        if (editAssetsDetails.getLoaddate() != null) {
                          /*  String loadDat = editAssetsDetails.getLoaddate();
                            String[] Ldat = loadDat.split("T");
                            Date date1 = null;*/

                            //date1 = simpleDateFormat.parse(Ldat[0]);
                            updateLoadDate = editAssetsDetails.getLoaddate();//UtilityFunction.getSplitedDate();//newformat.format(date1);
                            loadDate.setText(updateLoadDate);

                        } else {
                        }
                        if (editAssetsDetails.getConditiondate() != null) {
                            updateConditionDate = editAssetsDetails.getConditiondate();
                        }
                        if (editAssetsDetails.getNextinspectiondate() != null) {
                            updateNextInspectionDate = editAssetsDetails.getNextinspectiondate();

                        }
                        if (editAssetsDetails.getLastinspectiondate() != null) {

                            updateLastInspectionDate = editAssetsDetails.getLastinspectiondate();

                        }
                        if (editAssetsDetails.getNextmaintenancedate() != null) {
                            updateNextMaintenanceDate = editAssetsDetails.getNextmaintenancedate();

                        }
                        if (editAssetsDetails.getLastmaintenancedate() != null) {
                            updateLastMaintenanceDate = editAssetsDetails.getLastmaintenancedate();


                        }
                        if (editAssetsDetails.getDateinstalled() != null) {
                            updateDateInstalled = editAssetsDetails.getDateinstalled();

                        }
                        if (editAssetsDetails.getReplacementdate() != null) {
                            updateReplacementDate = editAssetsDetails.getReplacementdate();


                        }
                        if (editAssetsDetails.getCommissioned() != null) {
                            updateComissionDate = editAssetsDetails.getCommissioned();

                        }
                        if (editAssetsDetails.getDecommissioned() != null) {
                            updateDeComissionDate = editAssetsDetails.getDecommissioned();
                        }
                        if (editAssetsDetails.getComcommissioned() != null) {
                            updateComComissionDate = editAssetsDetails.getComcommissioned();
                        }

                        if (editAssetsDetails.getComdecommissioned() != null) {
                            updateComDateDeComission = editAssetsDetails.getComdecommissioned();

                        }
                        if (editAssetsDetails.getPartswarrantystartdate() != null) {
                            updateWarrantyStart = editAssetsDetails.getPartswarrantystartdate();


                        }
                        if (editAssetsDetails.getWarrantyexpiration() != null) {
                            updateWarrantyEnd = editAssetsDetails.getWarrantyexpiration();

                        }
                        if (editAssetsDetails.getPartswarrantydateentered() != null) {
                            updatePartyWarrantyDateEntered = editAssetsDetails.getPartswarrantydateentered();
                        }

                        if (editAssetsDetails.getLabourwarrantydateentered() != null) {
                            updateLabourWarrantyDateEntered = editAssetsDetails.getLabourwarrantydateentered();
                        }
                        if (editAssetsDetails.getLabourwarrantystartdate() != null) {
                            updateLabourWarrantyStart = editAssetsDetails.getLabourwarrantystartdate();
                        }
                        if (editAssetsDetails.getLabourwarrantyenddate() != null) {
                            updateLabourWarrantyEnd = editAssetsDetails.getLabourwarrantyenddate();

                        }
                        updateLabourWarrantyEnteredBy = editAssetsDetails.getLabourwarrantyenterby();
                        updateStatutoryMaintenance = editAssetsDetails.getStatutorymaintenance();
                        updateSubComponent = editAssetsDetails.getSubcomponent();

                        fetchClientDropDown();
                        fetchAssetTypeDropDown();
                        fetchAssetStatusDropDown();
                        fetchPriorityDropDown();
                        fetchWarningLevelDropDown();
                    }
                }

                @Override
                public void onFailure(Call<EditAssetsDetails> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                    Log.v("Error", t.getMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void showDatePickerDialog0(View v) {
        DialogFragment newFragment = new DatePickerFragment0();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment0 extends DialogFragment implements
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
            loadDate.setText(date);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void fetchClientDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetDropDownList>> listCall = apiServicesWorkOrder.assetDropDownList("application/json", "api/assetsdropdown/getclient?companyid=" + companyid);
            listCall.enqueue(new Callback<List<AssetDropDownList>>() {
                @Override
                public void onResponse(Call<List<AssetDropDownList>> call, Response<List<AssetDropDownList>> response) {
                    if (response.body() != null) {
                        assetDropDownLists = response.body();

                        //  for(int i=0;i<assetDropDownLists.size();i++)
                        //  {
                        //   if(assetDropDownLists.get(i).getValue().equals(updateClient))
                        //    {
                        showClientDropDownList();
                        //    }
                        //  }


                    }
                }

                @Override
                public void onFailure(Call<List<AssetDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }


    private void showClientDropDownList() {
        if (getApplicationContext() != null) {
            String item[] = new String[assetDropDownLists.size()];
            for (int i = 0; i < assetDropDownLists.size(); i++) {
                item[i] = assetDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            //  adapter.setDropDownViewResource(R.layout.fortitle);
            client.setAdapter(adapter);

            for (int i = 0; i < assetDropDownLists.size(); i++) {
                Log.d("AssetText Value", assetDropDownLists.get(i).getText() + " " + assetDropDownLists.get(i).getValue());
                if (updateClientNo.equals(assetDropDownLists.get(i).getValue())) {
                    client.setSelection(i);
                }

            }
            if (asset_ID != null) {
                // int spinnerPosition=adapter.getPosition(asset_ID);
                //  client.setSelection(spinnerPosition);
            }
            client.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    updateClientNo = assetDropDownLists.get(position).getValue();
                    clientNumber.setText(updateClientNo);
                    updateClient = assetDropDownLists.get(position).getText();
                    clientNumber.setEnabled(false);

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }
    }

    public void fetchAssetStatusDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetStatusDropDownList>> listCall = apiServicesWorkOrder.assetStatusDropDownList("application/json", "api/assetsdropdown/getassetStatus");
            listCall.enqueue(new Callback<List<AssetStatusDropDownList>>() {
                @Override
                public void onResponse(Call<List<AssetStatusDropDownList>> call, Response<List<AssetStatusDropDownList>> response) {
                    if (response.body() != null) {
                        assetStatusDropDownLists = response.body();
                        for (int i = 0; i < assetStatusDropDownLists.size(); i++) {
                            if (assetStatusDropDownLists.get(i).getValue().equals(updateAssetStatus)) {
                                showAssetStatusDropDownList(assetStatusDropDownLists.get(i).getText());
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<AssetStatusDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void showAssetStatusDropDownList(String compareValue) {
        String item[] = new String[assetStatusDropDownLists.size()];
        for (int i = 0; i < assetStatusDropDownLists.size(); i++) {
            item[i] = assetStatusDropDownLists.get(i).getText();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
        adapter.setDropDownViewResource(R.layout.fortitle);
        assetStatus.setAdapter(adapter);
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            assetStatus.setSelection(spinnerPosition);
        }
        assetStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateAssetStatus = assetStatusDropDownLists.get(position).getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void fetchAssetTypeDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetTypeDropDownList>> listCall = apiServicesWorkOrder.assetTypeDropDownList("application/json", "api/assetsdropdown/getassettype?companyid=" + companyid);
            listCall.enqueue(new Callback<List<AssetTypeDropDownList>>() {
                @Override
                public void onResponse(Call<List<AssetTypeDropDownList>> call, Response<List<AssetTypeDropDownList>> response) {
                    if (response.body() != null) {
                        assetTypeDropDownLists = response.body();
                        for (int i = 0; i < assetTypeDropDownLists.size(); i++) {
                            if (assetTypeDropDownLists.get(i).getValue().equals(updateAssetType)) {
                                showAssetTypeDropDownList(assetTypeDropDownLists.get(i).getText());
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<AssetTypeDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void showAssetTypeDropDownList(String compareValue) {
        if (getApplicationContext() != null) {
            String item[] = new String[assetTypeDropDownLists.size()];
            for (int i = 0; i < assetTypeDropDownLists.size(); i++) {
                item[i] = assetTypeDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            assetType.setAdapter(adapter);
            if (compareValue != null) {
                int spinnerPosition = adapter.getPosition(compareValue);
                assetType.setSelection(spinnerPosition);
            }
            assetType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateAssetType = assetTypeDropDownLists.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    public void fetchWarningLevelDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<WarningLevelDropDownList>> listCall = apiServicesWorkOrder.wldropdown("application/json", "api/assetsdropdown/warninglevel?companyid=" + companyid);
            listCall.enqueue(new Callback<List<WarningLevelDropDownList>>() {
                @Override
                public void onResponse(Call<List<WarningLevelDropDownList>> call, Response<List<WarningLevelDropDownList>> response) {
                    if (response.body() != null) {
                        warningLevelDropDownLists = response.body();
                        for (int i = 0; i < warningLevelDropDownLists.size(); i++) {
                            //String abc=warningLevelDropDownLists.get(i).getLevel();
                            if (warningLevelDropDownLists.get(i).getLevel().equals(Integer.parseInt(updateWarningLevel))) {
                                showWLDropDownList(warningLevelDropDownLists.get(i).getDescription());
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<WarningLevelDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void showWLDropDownList(String compareValue) {
        String item[] = new String[warningLevelDropDownLists.size()];
        for (int i = 0; i < warningLevelDropDownLists.size(); i++) {
            item[i] = warningLevelDropDownLists.get(i).getDescription();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);

        adapter.setDropDownViewResource(R.layout.fortitle);
        warningLevel.setAdapter(adapter);
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            warningLevel.setSelection(spinnerPosition);
        }
        warningLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateWarningLevel = String.valueOf(warningLevelDropDownLists.get(position).getLevel());
                Constants.updateAssetPOJO.setWarningLevel(warningLevelDropDownLists.get(position).getLevel());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void fetchPriorityDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<PriorityDropDownList>> listCall = apiServicesWorkOrder.prioritydropdown("application/json", "api/assetsdropdown/getpriority");
            listCall.enqueue(new Callback<List<PriorityDropDownList>>() {
                @Override
                public void onResponse(Call<List<PriorityDropDownList>> call, Response<List<PriorityDropDownList>> response) {
                    if (response.body() != null) {
                        priorityDropDownLists = response.body();
                        for (int i = 0; i < priorityDropDownLists.size(); i++) {
                            if (priorityDropDownLists.get(i).getValue().equals(updatePriority)) {
                                showPriorityDropDownList(priorityDropDownLists.get(i).getText());
                            }
                        }
                        String item[] = new String[priorityDropDownLists.size()];
                        for (int i = 0; i < priorityDropDownLists.size(); i++) {
                            item[i] = priorityDropDownLists.get(i).getText();
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
                        priority.setAdapter(adapter);
                        adapter.setDropDownViewResource(R.layout.fortitle);

                    }
                }

                @Override
                public void onFailure(Call<List<PriorityDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void showPriorityDropDownList(String compareValue) {
        if (getApplicationContext() != null) {
            String item[] = new String[priorityDropDownLists.size()];
            for (int i = 0; i < priorityDropDownLists.size(); i++) {
                item[i] = priorityDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            priority.setAdapter(adapter);
            if (compareValue != null) {
                int spinnerPosition = adapter.getPosition(compareValue);
                priority.setSelection(spinnerPosition);
            }
            priority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updatePriority = priorityDropDownLists.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    public void fetchDashBoardListFM() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
            final Call<DashBoardResponse> workOrderResponseModelCall = apiServicesWorkOrder.dashBoardListFm("application/json", "api/home/linktree?rolename=" + preferenceManagerWorkOrder.getKey_User_Role() + "&companyid=" + preferenceManagerWorkOrder.getKey_Person_Company_Id() + "&parentcompanyid=" + preferenceManagerWorkOrder.getKey_Parent_Company_Id());
            workOrderResponseModelCall.enqueue(new Callback<DashBoardResponse>() {
                @Override
                public void onResponse(Call<DashBoardResponse> call, Response<DashBoardResponse> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if (response.body() != null) {
                            responses = response.body();

                            list = (ArrayList<Treestuctutr>) responses.getTreestuctutr();
                        } else {
                            Toast.makeText(getApplicationContext(), response.errorBody().string().toString(), Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Log.v("Exception", e.toString());
                    }
                }

                @Override
                public void onFailure(Call<DashBoardResponse> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

}
