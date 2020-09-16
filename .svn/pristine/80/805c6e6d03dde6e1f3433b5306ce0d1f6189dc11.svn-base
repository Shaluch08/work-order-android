package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.search_autocomplete.GeocodingLocation;
import com.workorder.app.search_autocomplete.PlacesAutoCompleteAdapter;
import com.workorder.app.search_autocomplete.Prediction;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.workorderapplication.model.assetModel.AssetCategoryDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.AssetConditionDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.AssetLocationResponse;
import com.workorder.app.workorderapplication.model.assetModel.ContractTypeDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.SubCategoryDropDownList;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.workOrderModel.AreaDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.RegionDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.SubRegionDropDownList;
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

public class UpdateAsset1 extends AppCompatActivity {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    Button next;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    List<AreaDropDownList> areaDropDownLists;
    List<ContractTypeDropDownList> contractTypeDropDownLists;
    List<AssetCategoryDropDownList> assetCategoryDropDownLists;
    List<SubCategoryDropDownList> subCategoryDropDownLists;
    List<AssetConditionDropDownList> conditionDropDownLists;
    List<RegionDropDownList> regionDropDownLists;
    List<SubRegionDropDownList> subRegionDropDownLists;
    List<AssetLocationResponse> locationDropDownLists;
    String userrole, companyid, clientId, rolename;
    Spinner contractType, assetCategory, subCategory, assetCondition;
    AutoCompleteTextView auto_address1;
    EditText et_city, et_state, et_pincode, et_country, et_latitude, et_longitude;

    TextInputEditText et_region, et_subRegion, et_location, et_area;
    static EditText conditionDate;
    EditText assetCode, assetComent, buildingName, room, contractNo;
    String updateClient, updateAssetType, updateAssetStatus, updatePriority,
            updateWarningLevel, updateLoadDate, updateClientNo, updateAssetId,
            updateAssetName, updateDescription, updateContractNo, updateContractType,
            updateAssetCategory, updateSubCategory, updateAssetCondition, updateRegion,
            updateSubRegion, updateLocation, updateArea, updateConditionDate, updateAssetCode,
            updateAssetComent, updateBuildingName, updateRoom, updateReactiveCriticality,
            updateInspectionFrequency, updateNextInspectionDate, updateLastInspectionDate,
            updateRoomName, updateFloor, updateAssetUse, updateEnergyRating,
            updateInspectionProcedureResult, updateInspectionComments,
            updateMaintenanceStrategy, updateMaintenanceFrequency, updateNextMaintenanceDate,
            updateLastMaintenanceDate, updateMaintenanceProcedureResult,
            updateMaintenanceComments, updateSupplierName, updateComponentOfAsset,
            updateOldAsset, updateSupplierId, updateOrderNumber, updateQualityLifeExpectancy,
            updateComDescription, updateDateInstalled, updateReplacementDate,
            updateComissionDate, updateDeComissionDate, updateComComissionDate,
            updateComDateDeComission, updateWarrantyStart, updateWarrantyEnd,
            updateEstMaintenance, updatePurchaseCost, updateExpectReplaceCost,
            updateManufacturer, updateMakeYear, updateModel, updateSerialNo, updateBarCode,
            updatePartsWarrantyLengthMonth, updatePartsWarrantyLengthYear,
            updatePartsWarrantyComments, updatePartyWarrantyDateEntered,
            updateLabourWarrantyStart, updateLabourWarrantyEnd, updatePartsWarrantyEnteredBy,
            updateWarrantyComments, updateDrwaingNumber, updateOmLink,
            updateLabourWarrantyEnteredBy, updateLabourWarrantyDateEntered, id;

    boolean updateStatutoryMaintenance, updateSubComponent;
    static EditText loadDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_asset1);

        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());

        if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager")) {
            ArrayList<Treestuctutr> list = (ArrayList<Treestuctutr>) getIntent().getSerializableExtra("list");
            arrayList = list;
        } else if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")) {
            ArrayList<ContrctTree> contrctTreeArrayList = (ArrayList<ContrctTree>) getIntent().getSerializableExtra("contrctTreeList");
            contrctTrees = contrctTreeArrayList;
        }

        Bundle intent = getIntent().getExtras();
        if (intent != null) {
            id = intent.getString("AssetId");
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Update Asset");
        ImageView image = (ImageView) findViewById(R.id.tree);
        image.setVisibility(View.VISIBLE);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateAsset1.this, TreeStructure.class);
                if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager")) {
                    intent.putExtra("list", arrayList);
                    // intent.putExtra("updateAsset",editAssetsDetails)
                } else if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")) {
                    intent.putExtra("contrctTreeList", contrctTrees);

                }
                startActivity(intent);
                //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                Toast.makeText(UpdateAsset1.this, "Action Escalation Tree", Toast.LENGTH_SHORT).show();
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
        contractType = findViewById(R.id.spinner_contract_type);
        assetCategory = findViewById(R.id.spinner_asset_category);
        subCategory = findViewById(R.id.spinner_sub_category);
        assetCondition = findViewById(R.id.spinner_asset_condition);
        //et_region = findViewById(R.id.et_region);
        et_subRegion = findViewById(R.id.et_sub_region);
        et_area = findViewById(R.id.et_area);
        et_location = findViewById(R.id.et_location);

        auto_address1 = findViewById(R.id.asset_address1);
        //auto_address2 = findViewById(R.id.asset_address2);
        et_city = findViewById(R.id.asset_city);
        et_state = findViewById(R.id.asset_state);
        et_pincode = findViewById(R.id.asset_post_code);
        et_country = findViewById(R.id.asset_country);
        et_latitude = findViewById(R.id.et_asset_latitude);
        et_longitude = findViewById(R.id.et_asset_longitude);


        conditionDate = (EditText) findViewById(R.id.condition_date);

        conditionDate.setText(updateConditionDate);

        conditionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        assetCode = (EditText) findViewById(R.id.asset_code);
        assetCode.setText(updateAssetCode);
        assetComent = (EditText) findViewById(R.id.asset_comments);
        assetComent.setText(updateAssetComent);
        buildingName = (EditText) findViewById(R.id.building_name);
        buildingName.setText(updateBuildingName);
        //et_region.setText(updateRegion);
        et_subRegion.setText(updateSubRegion);
        et_area.setText(updateArea);
        et_location.setText(updateLocation);
        room = (EditText) findViewById(R.id.room);
        room.setText(updateRoom);
        next = (Button) findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextEvent();
                //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        Button pre = (Button) findViewById(R.id.btn_previous);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getAssetcode(), assetCode);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getComments(), assetComent);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getConditiondate(), conditionDate);
       // UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getRegionid(), et_region);
   //     UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getSupplierid(), et_subRegion);
     //   UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getArea(), et_area);
     //   UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getLocationid(), et_location);
       // UtilityFunction.checkAutoCompleteTextSetValue(Constants.assetsDetails.getAddress1(), auto_address1);
      //  UtilityFunction.checkAutoCompleteTextSetValue(Constants.assetsDetails.getAddress2(), auto_address2);
      //  UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getBuildingname(), buildingName);
    /*    UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getRoom(), room);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getCity(), et_city);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getState(), et_state);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getPostcode(), et_pincode);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getCountry(), et_country);
        UtilityFunction.checkEditTextSetValue(String.valueOf(Constants.assetsDetails.getLatitude()), et_latitude);
        UtilityFunction.checkEditTextSetValue(String.valueOf(Constants.assetsDetails.getLongitude()), et_longitude);
*/

        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(UpdateAsset1.this, UpdateAsset.class);
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
                intent1.putExtras(bundle);
                startActivity(intent1);
                //   overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });


        UtilityFunction.checkAutoCompleteTextSetValue(Constants.assetsDetails.getAddress1(), auto_address1);
       // UtilityFunction.checkAutoCompleteTextSetValue(Constants.assetsDetails.getAddress2(), auto_address2);
       // UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getRegionid(), et_region);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getSubregionid(), et_subRegion);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getRoom(), room);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getArea(), et_area);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getBuildingname(), buildingName);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getLocationid(), et_location);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getCity(), et_city);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getState(), et_state);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getPostcode(), et_pincode);
        UtilityFunction.checkEditTextSetValue(Constants.assetsDetails.getCountry(), et_country);
        UtilityFunction.checkEditTextSetValue(String.valueOf(Constants.assetsDetails.getLatitude()), et_latitude);
        UtilityFunction.checkEditTextSetValue(String.valueOf(Constants.assetsDetails.getLongitude()), et_longitude);


        fetchContractTypeDropDown();
        fetchAssetCategoryDropDown();
        fetchSubCategoryDropDown();
        fetchAssetConditionDropDown();
        //fetchRegionDropDown();
        // fetchSubRegionDropDown();
        // fetchAreaDropDown();
        // fetchLocationDropDown();
        loadData();

        auto_address1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("Before", "now here");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("textch", "before");
            }

            @Override
            public void afterTextChanged(Editable s) {
                GeocodingLocation locationAddress = new GeocodingLocation();
                locationAddress.getAddressFromLocation(auto_address1.getText().toString(),
                        UpdateAsset1.this, new GeocoderHandlerfrom());
            }
        });


    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }

    private void loadData() {
        List<Prediction> predictions = new ArrayList<>();
        PlacesAutoCompleteAdapter placesAutoCompleteAdapter = new PlacesAutoCompleteAdapter(getApplicationContext(), predictions);

        auto_address1.setThreshold(1);
        auto_address1.setAdapter(placesAutoCompleteAdapter);


        //dtocity.setText();
//      Log.d("PlaceId",Utility.prediction.getPlaceId());
        //placesAutoCompleteAdapter.getItem();


        // autoCompleteTextViewPlace.setOn

    }

    String from_city = "", from_country = "";
    String to_city = "", to_country = "";

    private class GeocoderHandlerfrom extends Handler {
        @Override
        public void handleMessage(Message message) {
            try {
                String locationAddress;
                switch (message.what) {
                    case 1:
                        Bundle bundle = message.getData();
                        locationAddress = bundle.getString("address");
                        break;
                    default:
                        locationAddress = null;
                }
                Log.d("logi", locationAddress);
                //autoCompleteTextViewPlace.setText("");

                //locationAddress.length();
                // oaddress.setText(dfromcity.getText().toString());
                String[] address = locationAddress.split(",");
                if (address.length > 3) {
                    // ocity.setText(address[0]);
                    // ostate.setText(address[1]);
                    //  ocountry.setText(address[2]);
                    //  opin.setText(address[3]);
                    //start1=address[4];
                    // start2=address[5];
                    // startlat=Double.parseDouble(start1);
                    //startlong=Double.parseDouble(start2);

                    from_city = UtilityFunction.filterAddress(UpdateAsset1.this, address[4], address[5], "city");//address[0];
                    Log.d("City", from_city);
                    Constants.FROM_CITY = from_city;
                    et_city.setText(from_city);
                    et_state.setText(UtilityFunction.filterAddress(UpdateAsset1.this, address[4], address[5], "state"));
                    et_pincode.setText(UtilityFunction.filterAddress(UpdateAsset1.this, address[4], address[5], "pincode"));
                    from_country = UtilityFunction.filterAddress(UpdateAsset1.this, address[4], address[5], "country");
                    // et_region.setText(UtilityFunction.filterAddress(UpdateAsset1.this,address[4],address[5],"state"));
                    // et_subRegion.setText(UtilityFunction.filterAddress(UpdateAsset1.this,address[4],address[5],"city"));
                    //  et_location.setText(from_city);
                    // Log.d("print",address[i]);

                    et_latitude.setText(address[4]);
                    et_longitude.setText(address[5]);
                    et_country.setText(from_country);

                }
                //  oaddress.setText(ocity.getText().toString()+" ,"+ostate.getText().toString()+" ,"+ocountry.getText().toString());

            } catch (Exception e) {
                Log.d("FromCity", e.toString());
            }
        }
    }


    private void nextEvent() {
        if (contractType.getSelectedItem().toString().trim().equals("Please Select Contract Type")) {
            View selectedView = contractType.getSelectedView();
            TextView tv = (TextView) selectedView;
            if (tv.getText().toString().trim().equals("Please Select Contract Type")) {
                tv.setError("Please Select Contract Type");
                requestFocus(tv);
            }
            Toast.makeText(UpdateAsset1.this, "Please Select Contract Type", Toast.LENGTH_SHORT).show();
        } else if (assetCategory.getSelectedItem().toString().trim().equals("Select Category")) {
            View selectedView = assetCategory.getSelectedView();
            TextView tv = (TextView) selectedView;
            if (tv.getText().toString().trim().equals("Select Category")) {
                tv.setError("Select Category");
                requestFocus(tv);
            }
            Toast.makeText(UpdateAsset1.this, "Please Select Category", Toast.LENGTH_SHORT).show();
        } else if (conditionDate.getText().toString().trim().isEmpty()) {
            conditionDate.setError("Please Enter Condition Date");
            requestFocus(conditionDate);
        } else if (assetCondition.getSelectedItemPosition()==0) {
         /*   View selectedView = assetCondition.getSelectedView();
            TextView tv = (TextView) selectedView;
            if (tv.getText().toString().trim().equals("Please Select Asset Condition")) {
                tv.setError("Please Select Asset Condition");
                requestFocus(tv);
            }*/
            Toast.makeText(UpdateAsset1.this, "Please Select Asset Condition", Toast.LENGTH_SHORT).show();

        } else if (auto_address1.getText().toString().trim().equals("")) {
            // View selectedView = et_region.getSelectedView();
            // TextView tv=(TextView) selectedView;
            // if(tv.getText().toString().trim().equals("Select Region")) {
            //    tv.setError("Please Select Region");
            //   requestFocus(tv);
            // }
            auto_address1.requestFocus();
            auto_address1.setError("Please enter address");
            //  Toast.makeText(UpdateAsset1.this, "Please Select Region", Toast.LENGTH_SHORT).show();
        } else if (et_subRegion.getText().toString().trim().equals("")) {
         /*   View selectedView = subRegion.getSelectedView();
            TextView tv=(TextView) selectedView;
            if(tv.getText().toString().trim().equals("Select Region")) {
                tv.setError("Please Select Sub Region");
                requestFocus(tv);
            }*/
            et_subRegion.requestFocus();
            et_subRegion.setError("Please enter Sub Region.");
            //  Toast.makeText(UpdateAsset1.this, "Please Select Sub Region", Toast.LENGTH_SHORT).show();
        } else if (et_area.getText().toString().trim().equals("Select Area")) {
            et_area.requestFocus();
            et_area.setError("Please enter Area");
         /*   View selectedView = area.getSelectedView();
            TextView tv=(TextView) selectedView;
            if(tv.getText().toString().trim().equals("Select Area")) {
                tv.setError("Please Select Area");
                requestFocus(tv);
            }
            Toast.makeText(UpdateAsset1.this, "Please Select Area", Toast.LENGTH_SHORT).show();*/
        } else if (et_location.getText().toString().trim().equals("Select Location")) {
            et_location.requestFocus();
            et_location.setError("Please enter Location");
      /*      View selectedView = location.getSelectedView();
            TextView tv=(TextView) selectedView;
            if(tv.getText().toString().trim().equals("Select Location")) {
                tv.setError("Please Select Location");
                requestFocus(tv);
            }
            Toast.makeText(UpdateAsset1.this, "Please Select Location", Toast.LENGTH_SHORT).show();*/
        } else if (buildingName.getText().toString().trim().isEmpty()) {
            buildingName.setError("Please Enter Building Name");
            requestFocus(buildingName);
        } else if (room.getText().toString().trim().isEmpty()) {
            room.setError("Please Enter Room");
        } else {
            updateConditionDate = conditionDate.getText().toString().trim();
            updateAssetCode = assetCode.getText().toString().trim();
            updateAssetComent = assetComent.getText().toString().trim();
            updateBuildingName = buildingName.getText().toString().trim();
            updateRoom = room.getText().toString().trim();
           // updateRegion = et_region.getText().toString().trim();
            updateSubRegion = et_subRegion.getText().toString().trim();
            updateArea = et_area.getText().toString().trim();
            updateLocation = et_location.getText().toString().trim();

            // Constants.updateAssetPOJO.setContractType();
            Constants.updateAssetPOJO.setAssetCode(updateAssetCode);
            Constants.updateAssetPOJO.setComments(updateAssetComent);
            Constants.updateAssetPOJO.setAssetCategoryId(updateAssetCategory);
            Constants.updateAssetPOJO.setAssetSubCategoryId(updateSubCategory);
            Constants.updateAssetPOJO.setConditionDate(updateConditionDate);
            Constants.updateAssetPOJO.setCondition(updateAssetCondition);
            Constants.updateAssetPOJO.setRegionId(updateRegion);
            Constants.updateAssetPOJO.setSubRegionId(updateSubRegion);
            Constants.updateAssetPOJO.setArea(updateArea);
            Constants.updateAssetPOJO.setLocationId(updateLocation);

            Constants.updateAssetPOJO.setAddress1(auto_address1.getText().toString());
            Constants.updateAssetPOJO.setAddress2("");
            Constants.updateAssetPOJO.setBuildingName(buildingName.getText().toString());
            Constants.updateAssetPOJO.setCity(et_city.getText().toString());
            Constants.updateAssetPOJO.setState(et_state.getText().toString());
            Constants.updateAssetPOJO.setPostcode(et_pincode.getText().toString());
            try {
                Constants.updateAssetPOJO.setLatitude(Double.parseDouble(et_latitude.getText().toString()));
                Constants.updateAssetPOJO.setLongitude(Double.parseDouble(et_longitude.getText().toString()));
            }catch (Exception e)
            {
                e.printStackTrace();

            }

            //  Constants.updateAssetPOJO.Address1(updateRegion);
            // Constants.updateAssetPOJO.setAddress2(updateSubRegion);
            // Constants.updateAssetPOJO.setCity(updateArea);
            //  Constants.updateAssetPOJO.setState(updateLocation);
            //  Constants.updateAssetPOJO.setPostCode(updateRegion);
            //  Constants.updateAssetPOJO.setCountry(updateSubRegion);
            //  Constants.updateAssetPOJO.setLatitude(updateArea);
            //   Constants.updateAssetPOJO.setLongitude(updateLocation);
         //   Constants.updateAssetPOJO.setBuildingName(updateBuildingName);
            Constants.updateAssetPOJO.setRoom(updateRoom);


            Intent intent = new Intent(UpdateAsset1.this, UpdateAsset2.class);
            Bundle bundle = new Bundle();
            bundle.putString("updateClient", updateClient);
            bundle.putString("updateAssetType", updateAssetType);
            bundle.putString("updateAssetStatus", updateAssetStatus);
            bundle.putString("updatePriority", updatePriority);
            bundle.putString("updateWarningLevel", updateWarningLevel);
            bundle.putString("updateLoadDate", updateLoadDate);
            bundle.putString("updateClientNo", updateClientNo);
            bundle.putString("updateAssetId", updateAssetId);
            bundle.putString("updateDescription", updateDescription);
            bundle.putString("updateAssetName", updateAssetName);
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
            intent.putExtra("list", arrayList);
            intent.putExtra("contrctTreeList", contrctTrees);
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

    public void fetchContractTypeDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<ContractTypeDropDownList>> listCall = apiServicesWorkOrder.ctDropDownList("application/json", "api/assetsdropdown/getcontractType");
            listCall.enqueue(new Callback<List<ContractTypeDropDownList>>() {
                @Override
                public void onResponse(Call<List<ContractTypeDropDownList>> call, Response<List<ContractTypeDropDownList>> response) {
                    if (response.body() != null) {
                        contractTypeDropDownLists = response.body();
                        for (int i = 0; i < contractTypeDropDownLists.size(); i++) {
                            if (contractTypeDropDownLists.get(i).getValue().equals(updateContractType)) {
                                showContractTypeDropDownList(contractTypeDropDownLists.get(i).getText());
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<ContractTypeDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void showContractTypeDropDownList(String compareValue) {
        if (getApplicationContext() != null) {
            String item[] = new String[contractTypeDropDownLists.size()];
            for (int i = 0; i < contractTypeDropDownLists.size(); i++) {
                item[i] = contractTypeDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            contractType.setAdapter(adapter);

            if (compareValue != null) {
                int spinnerPosition = adapter.getPosition(compareValue);
                contractType.setSelection(spinnerPosition);
            }
            contractType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateContractType = contractTypeDropDownLists.get(position).getValue();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


        }
    }

    public void fetchAssetCategoryDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetCategoryDropDownList>> listCall = apiServicesWorkOrder.assetcatDropDownList("application/json", "api/assetsdropdown/getassetcategories");
            listCall.enqueue(new Callback<List<AssetCategoryDropDownList>>() {
                @Override
                public void onResponse(Call<List<AssetCategoryDropDownList>> call, Response<List<AssetCategoryDropDownList>> response) {
                    if (response.body() != null) {
                        assetCategoryDropDownLists = response.body();
                        for (int i = 0; i < assetCategoryDropDownLists.size(); i++) {
                            if (assetCategoryDropDownLists.get(i).getValue().equals(updateAssetCategory)) {
                                showAssetCategoryDropDownList(assetCategoryDropDownLists.get(i).getText());
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<AssetCategoryDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void showAssetCategoryDropDownList(String compareValue) {
        if (getApplicationContext() != null) {
            String item[] = new String[assetCategoryDropDownLists.size()];
            for (int i = 0; i < assetCategoryDropDownLists.size(); i++) {
                item[i] = assetCategoryDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            assetCategory.setAdapter(adapter);
            if (compareValue != null) {
                int spinnerPosition = adapter.getPosition(compareValue);
                assetCategory.setSelection(spinnerPosition);
            }
            assetCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateAssetCategory = assetCategoryDropDownLists.get(position).getValue();

                    fetchSubCategoryDropDown();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


        }
    }

    public void fetchSubCategoryDropDown() {

        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<SubCategoryDropDownList>> listCall = apiServicesWorkOrder.subcatDropDownList("application/json", "api/assetsdropdown/getsubassetcategories?assetcategoriesId=" + updateAssetCategory);
            listCall.enqueue(new Callback<List<SubCategoryDropDownList>>() {
                @Override
                public void onResponse(Call<List<SubCategoryDropDownList>> call, Response<List<SubCategoryDropDownList>> response) {
                    if (response.body() != null) {
                        subCategoryDropDownLists = response.body();
                       /* for(int i=0;i<subCategoryDropDownLists.size();i++)
                        {
                            if(subCategoryDropDownLists.get(i).getValue().equals(updateSubCategory))
                            {

                            }
                        }*/
                        showSubCategoryDropDownList();

                    }
                }

                @Override
                public void onFailure(Call<List<SubCategoryDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void showSubCategoryDropDownList() {
        if (getApplicationContext() != null) {
            String item[] = new String[subCategoryDropDownLists.size()];
            for (int i = 0; i < subCategoryDropDownLists.size(); i++) {
                item[i] = subCategoryDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            subCategory.setAdapter(adapter);

           /* if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                subCategory.setSelection(spinnerPosition);
            }*/
            subCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateSubCategory = subCategoryDropDownLists.get(position).getValue();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


        }
    }

    public void fetchAssetConditionDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetConditionDropDownList>> listCall = apiServicesWorkOrder.conditionDropDownList("application/json", "api/assetsdropdown/getassetcondition");
            listCall.enqueue(new Callback<List<AssetConditionDropDownList>>() {
                @Override
                public void onResponse(Call<List<AssetConditionDropDownList>> call, Response<List<AssetConditionDropDownList>> response) {
                    if (response.body() != null) {
                        conditionDropDownLists = response.body();
                        for (int i = 0; i < conditionDropDownLists.size(); i++) {
                            if (conditionDropDownLists.get(i).getValue().equals(updateAssetCondition)) {
                                showAssetConditionDropDownList(conditionDropDownLists.get(i).getText());
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<AssetConditionDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void showAssetConditionDropDownList(String compareValue) {
        if (getApplicationContext() != null) {
            String item[] = new String[conditionDropDownLists.size()];
            for (int i = 0; i < conditionDropDownLists.size(); i++) {
                item[i] = conditionDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            assetCondition.setAdapter(adapter);

            if (compareValue != null) {
                int spinnerPosition = adapter.getPosition(compareValue);
                assetCondition.setSelection(spinnerPosition);
            }
            assetCondition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateAssetCondition = conditionDropDownLists.get(position).getValue();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


        }
    }

    public void fetchRegionDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<RegionDropDownList>> ListCall = apiServicesWorkOrder.regiondropdown("application/json", "api/assetsdropdown/getregion");
            ListCall.enqueue(new Callback<List<RegionDropDownList>>() {
                @Override
                public void onResponse(Call<List<RegionDropDownList>> call, Response<List<RegionDropDownList>> response) {
                    if (response.body() != null) {
                        regionDropDownLists = response.body();
                        for (int i = 0; i < regionDropDownLists.size(); i++) {
                            if (regionDropDownLists.get(i).getValue().equals(updateRegion)) {
                                showRegionDropDownList(regionDropDownLists.get(i).getValue());
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<RegionDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void showRegionDropDownList(String compareValue) {
        if (getApplicationContext() != null) {
            String item[] = new String[regionDropDownLists.size()];
            for (int i = 0; i < regionDropDownLists.size(); i++) {
                item[i] = regionDropDownLists.get(i).getText();
            }
            //  ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            // adapter.setDropDownViewResource(R.layout.fortitle);
            // region.setAdapter(adapter);
            if (compareValue != null) {
                //int spinnerPosition=adapter.getPosition(compareValue);
                //region.setSelection(spinnerPosition);
                //et_region.setText(compareValue);
            }


        /*    region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateRegion=regionDropDownLists.get(position).getValue();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });*/

        }
    }

    public void fetchSubRegionDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<SubRegionDropDownList>> ListCall = apiServicesWorkOrder.subregionorderdropdown("application/json", "api/assetsdropdown/getsubregionb?regionId=" + updateRegion);
            ListCall.enqueue(new Callback<List<SubRegionDropDownList>>() {
                @Override
                public void onResponse(Call<List<SubRegionDropDownList>> call, Response<List<SubRegionDropDownList>> response) {
                    if (response.body() != null) {
                        subRegionDropDownLists = response.body();
                        for (int i = 0; i < subRegionDropDownLists.size(); i++) {
                            if (subRegionDropDownLists.get(i).getValue().equals(updateSubRegion)) {
                                //showSubRegionDropDownList(subRegionDropDownLists.get(i).getText());
                                et_subRegion.setText(subRegionDropDownLists.get(i).getText());
                                updateSubRegion = subRegionDropDownLists.get(i).getValue();
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<SubRegionDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void showSubRegionDropDownList(String compareValue) {
        if (getApplicationContext() != null) {
            String item[] = new String[subRegionDropDownLists.size()];
            for (int i = 0; i < subRegionDropDownLists.size(); i++) {
                item[i] = subRegionDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            //subRegion.setAdapter(adapter);

            if (compareValue != null) {
                int spinnerPosition = adapter.getPosition(compareValue);
                //  subRegion.setSelection(spinnerPosition);
            }
           /* subRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateSubRegion=subRegionDropDownLists.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });*/
        }
    }

    public void fetchAreaDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AreaDropDownList>> ListCall = apiServicesWorkOrder.areadropdown("application/json", "api/assetsdropdown/getarea");
            ListCall.enqueue(new Callback<List<AreaDropDownList>>() {
                @Override
                public void onResponse(Call<List<AreaDropDownList>> call, Response<List<AreaDropDownList>> response) {
                    if (response.body() != null) {
                        areaDropDownLists = response.body();
                        for (int i = 0; i < areaDropDownLists.size(); i++) {
                            if (areaDropDownLists.get(i).getValue().equals(updateArea)) {
                                //showAreaDropDownList(areaDropDownLists.get(i).getText());
                                et_area.setText(areaDropDownLists.get(i).getText());
                                updateArea = areaDropDownLists.get(i).getValue();


                            }
                        }


                    }
                }

                @Override
                public void onFailure(Call<List<AreaDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });

        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void showAreaDropDownList(String compareValue) {
        String item[] = new String[areaDropDownLists.size()];
        for (int i = 0; i < areaDropDownLists.size(); i++) {
            item[i] = areaDropDownLists.get(i).getText();

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
        adapter.setDropDownViewResource(R.layout.fortitle);
        //area.setAdapter(adapter);
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            //   area.setSelection(spinnerPosition);
        }
    /*    area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateArea=areaDropDownLists.get(position).getValue();
                fetchLocationDropDown();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    public void fetchLocationDropDown() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetLocationResponse>> ListCall = apiServicesWorkOrder.locationdropdown("application/json", "api/assetsdropdown/getlocation?regionid=" + updateRegion + "&subRegionId=" + updateSubRegion + "&AreaId=" + updateArea + "&ClientId=" + updateClientNo);
            ListCall.enqueue(new Callback<List<AssetLocationResponse>>() {
                @Override
                public void onResponse(Call<List<AssetLocationResponse>> call, Response<List<AssetLocationResponse>> response) {
                    if (response.body() != null) {
                        locationDropDownLists = response.body();
                        for (int i = 0; i < locationDropDownLists.size(); i++) {
                            if (locationDropDownLists.get(i).getId().equals(Integer.parseInt(updateLocation))) {
                                // showLocationDropDown(locationDropDownLists.get(i).getSiteName());

                                updateLocation = String.valueOf(locationDropDownLists.get(i).getId());
                                Log.d("Asset1Id", updateLocation);
                                et_location.setText(locationDropDownLists.get(i).getAddress1());
                                String loc = locationDropDownLists.get(i).getBuildingName();
                                buildingName.setText(loc);
                            }
                        }
                        //showLocationDropDown();
                    }
                }

                @Override
                public void onFailure(Call<List<AssetLocationResponse>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    public void showLocationDropDown() {

        String item[] = new String[locationDropDownLists.size()];
        for (int i = 0; i < locationDropDownLists.size(); i++) {
            item[i] = locationDropDownLists.get(i).getSiteName();
            // item[i]=locationDropDownLists.get(i).getValue();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
        adapter.setDropDownViewResource(R.layout.fortitle);
        //location.setAdapter(adapter);
     /*   if(compareValue!=null)
        {
            int spinnerPosition=adapter.getPosition(compareValue);
            location.setSelection(spinnerPosition);
        }*/
      /*  location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateLocation= String.valueOf(locationDropDownLists.get(position).getId());
                String loc=locationDropDownLists.get(position).getBuildingName();
                buildingName.setText(loc);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
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
            conditionDate.setText(date);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
