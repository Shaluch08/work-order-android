package com.workorder.app.workorderapplication.activity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.search_autocomplete.GeocodingLocation;
import com.workorder.app.search_autocomplete.PlacesAutoCompleteAdapter;
import com.workorder.app.search_autocomplete.Prediction;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.workorderapplication.model.assetModel.AssetDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.AssetLocationResponse;
import com.workorder.app.workorderapplication.model.dashboardModel.DashBoardResponse;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.DashBoardContractor;
import com.workorder.app.workorderapplication.model.workOrderModel.AreaDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.BuildingDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.FloorDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.RegionDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.RoomDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.SubRegionDropDownList;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateWorkOrder2 extends AppCompatActivity {
    ArrayList<Treestuctutr> list;
    ArrayList<ContrctTree> contrctTreeList;
    DashBoardResponse responses;
    DashBoardContractor dashContractors;
    List<RegionDropDownList> regionDropDownLists;
    List<AreaDropDownList> areaDropDownLists;
    List<AssetLocationResponse> locationDropDownLists;
    List<BuildingDropDownList> buildingDropDownLists;
    List<AssetDropDownList> assetDropDownLists;
    List<SubRegionDropDownList> subRegionDropDownLists;
    List<FloorDropDownList> floorDropDownLists;
    List<RoomDropDownList> roomDropDownLists;
    Button previous, nextTO;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String userrole, companyid, clientId, rolename;
    CheckBox clientaproval;
    EditText clientaprovedate;
    Spinner sp_client_site;
    EditText et_latitude, et_longitude;
    EditText et_room, et_region, et_subRegion, et_area, et_location, et_buildingName, et_floor, et_assetId;
    EditText et_city, et_state, et_postcode, et_country, etReportOnwork;
    AutoCompleteTextView auto_address1;
    String ID;
    String updateClient, updateClientNo, updatePoNumber, updateWarningLevel, updateOrderStatus, updatePriority, updateOrderType, updateAddress,
            updateDateRaised, updateDueDate, updateWONumber, updateOriginalOrderNo, updateCountry,
            updateRequestedBy, updateClientApprovalBy, updateClientApprovalDate, updateClientApproval, updateDescription,
            updateRoom, updateRegion, updateSubRegion, updateArea, updateLocation, updateBuildingName, updateFloor, updateAssetId, updateClientOrderNo,
            updateContractorAssig, updateCntactPerson, updateAssignedDate, updateStartDate, updateEndDate, updatePhone, updateMobile, updateEmail, updateAuthorisedCost, updateAuthorisedHrs,
            updateApprovedBy, updateDateRequested, updateNewDueDate, updateRequired, updateApproved, updateExtensionReason,
            updateAdditionalHrs, updateCity, updateState, updatePostCode, EstimatedWoCost, ActualWorkOrderCost, ReportOnWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_work_order2);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());

        if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")) {
            fetchDashBoardListContractor();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Update WO");
        ImageView image = (ImageView) findViewById(R.id.tree);
        if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker")) {
            image.setVisibility(View.INVISIBLE);
        } else {
            image.setVisibility(View.VISIBLE);
        }

        fetchDashBoardListFM();

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager")) {
                    Intent intent = new Intent(UpdateWorkOrder2.this, TreeStructure.class);
                    intent.putExtra("list", list);
                    startActivity(intent);
                    //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                } else if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")) {
                    Intent intent = new Intent(UpdateWorkOrder2.this, TreeStructure.class);
                    intent.putExtra("contrctTreeList", contrctTreeList);
                    startActivity(intent);
                    //    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }
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

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });


        userrole = preferenceManagerWorkOrder.getKey_User_Role();
        companyid = preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename = preferenceManagerWorkOrder.getKey_User_Name();

        etReportOnwork = (EditText) findViewById(R.id.etReportOnwork);
      //  etReportOnwork.setText(ReportOnWork);
        et_room = findViewById(R.id.et_wo_up_room);
        //et_region = findViewById(R.id.et_wo_up_region);
        et_subRegion = findViewById(R.id.et_wo_up_sub_region);
        et_area = findViewById(R.id.et_wo_up_area);
        et_location = findViewById(R.id.et_wo_up_location);
        et_buildingName = findViewById(R.id.et_wo_up_building_name);
        et_floor = findViewById(R.id.et_wo_up_floor);
        // et_assetId=findViewById(R.id.update_spinner_asset_id);
        auto_address1 = findViewById(R.id.update_address1);
        //auto_address2 = findViewById(R.id.update_address2);
       // auto_address1.setText(updateAddress);
        et_city = (EditText) findViewById(R.id.update_city);
        et_country = findViewById(R.id.update_country);
       // et_city.setText(updateCity);
        et_state = (EditText) findViewById(R.id.update_state);
        //et_state.setText(updateState);
        et_postcode = (EditText) findViewById(R.id.update_post_code);
        //et_postcode.setText(updatePostCode);
        et_latitude = findViewById(R.id.et_update_latitude);
        et_longitude = findViewById(R.id.et_update_longitude);

        previous = (Button) findViewById(R.id.update_btn_previous);


       // et_room.setText(updateRoom);
        //et_area.setText(updateArea);
        //et_region.setText(updateRegion);
      //  et_subRegion.setText(updateSubRegion);
        //et_location.setText(updateLocation);
       // et_buildingName.setText(updateBuildingName);
       // et_floor.setText(updateFloor);

       // if (Constants.workOrderDetails != null) {

            UtilityFunction.checkAutoCompleteTextSetValue(Constants.workOrderDetails.getAddress1(), auto_address1);
          //  UtilityFunction.checkAutoCompleteTextSetValue(Constants.workOrderDetails.getAddress2(), auto_address2);

            UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getBuildingname(), et_buildingName);
            UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getLocationid(), et_location);

            UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getFloor(), et_floor);
            UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getRoom(), et_room);

            UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getWorkcity(), et_city);
            UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getWorkstate(), et_state);

            UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getWorkpostcode(), et_postcode);
            UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getWorkcountry(), et_country);

            UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getSubregionid(), et_subRegion);
            UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getArea(), et_area);
            // UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getRegionid(), et_region);

            UtilityFunction.checkEditTextSetValue(String.valueOf(Constants.workOrderDetails.getLatitude()), et_latitude);
            UtilityFunction.checkEditTextSetValue(String.valueOf(Constants.workOrderDetails.getLongitude()), et_longitude);
            UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getReportonwork(),etReportOnwork);

       // }


        Bundle intent = getIntent().getExtras();
        if (intent != null) {
            updateClient = intent.getString("updateClient");
            updateClientNo = intent.getString("updateClientNo");
            updatePoNumber = intent.getString("updatePoNumber");
            updateWarningLevel = intent.getString("updateWarningLevel");
            updateOrderStatus = intent.getString("updateOrderStatus");
            updatePriority = intent.getString("updatePriority");
            updateOrderType = intent.getString("updateOrderType");
            updateAddress = intent.getString("updateAddress");
            updateDateRaised = intent.getString("updateDateRaised");
            updateDueDate = intent.getString("updateDueDate");
            updateWONumber = intent.getString("updateWONumber");
            updateOriginalOrderNo = intent.getString("updateOriginalOrderNo");
            updateRequestedBy = intent.getString("updateRequestedBy");
            updateClientApprovalBy = intent.getString("updateClientApprovalBy");
            updateClientApprovalDate = intent.getString("updateClientApprovalDate");
            updateClientApproval = intent.getString("updateClientApproval");
            updateDescription = intent.getString("updateDescription");
            updateRoom = intent.getString("updateRoom");

            updateRegion = intent.getString("updateRegion");
            updateSubRegion = intent.getString("updateSubRegion");
            updateArea = intent.getString("updateArea");

            updateLocation = intent.getString("updateLocation");
            updateBuildingName = intent.getString("updateBuildingName");
            updateFloor = intent.getString("updateFloor");
            updateAssetId = intent.getString("updateAssetId");
            updateClientOrderNo = intent.getString("updateClientOrderNo");
            updateContractorAssig = intent.getString("updateContractorAssig");
            updateCntactPerson = intent.getString("updateCntactPerson");
            updateAssignedDate = intent.getString("updateAssignedDate");
            updateStartDate = intent.getString("updateStartDate");
            updateEndDate = intent.getString("updateEndDate");
            updatePhone = intent.getString("updatePhone");
            updateMobile = intent.getString("updateMobile");
            updateEmail = intent.getString("updateEmail");
            updateAuthorisedCost = intent.getString("updateAuthorisedCost");
            updateAuthorisedHrs = intent.getString("updateAuthorisedHrs");
            updateApprovedBy = intent.getString("updateApprovedBy");
            updateDateRequested = intent.getString("updateDateRequested");
            updateNewDueDate = intent.getString("updateNewDueDate");
            updateRequired = intent.getString("updateRequired");
            updateApproved = intent.getString("updateApproved");
            updateExtensionReason = intent.getString("updateExtensionReason");
            updateAdditionalHrs = intent.getString("updateAdditionalHrs");
            updateCity = intent.getString("updateCity");
            updateState = intent.getString("updateState");
            updatePostCode = intent.getString("updatePostCode");
            EstimatedWoCost = intent.getString("updateEstimatedWoCost");
            ActualWorkOrderCost = intent.getString("updateActualWorkOrderCost");
            ReportOnWork = intent.getString("updateReportOnWork");
            ID = intent.getString("ID");
            updateCountry = intent.getString("updateCountry");
        }


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateWorkOrder2.this, UpdateWorkOrder1.class);
                Bundle bundle = new Bundle();
                bundle.putString("updateClient", updateClient);
                bundle.putString("updateClientNo", updateClientNo);
                bundle.putString("updatePoNumber", updatePoNumber);
                bundle.putString("updateWarningLevel", updateWarningLevel);
                bundle.putString("updateOrderStatus", updateOrderStatus);
                bundle.putString("updateCountry", updateCountry);
                bundle.putString("updatePriority", updatePriority);
                bundle.putString("updateOrderType", updateOrderType);
                bundle.putString("updateAddress", updateAddress);
                bundle.putString("updateDateRaised", updateDateRaised);
                bundle.putString("updateDueDate", updateDueDate);
                bundle.putString("updateWONumber", updateWONumber);
                bundle.putString("updateOriginalOrderNo", updateOriginalOrderNo);
                bundle.putString("updateRequestedBy", updateRequestedBy);
                bundle.putString("updateClientApprovalBy", updateClientApprovalBy);
                bundle.putString("updateClientApprovalDate", updateClientApprovalDate);
                bundle.putString("updateClientApproval", updateClientApproval);
                bundle.putString("updateDescription", updateDescription);
                bundle.putString("updateRoom", updateRoom);
                bundle.putString("updateRegion", updateRegion);
                bundle.putString("updateSubRegion", updateSubRegion);
                bundle.putString("updateArea", updateArea);
                bundle.putString("updateLocation", updateLocation);
                bundle.putString("updateBuildingName", updateBuildingName);
                bundle.putString("updateFloor", updateFloor);
                bundle.putString("updateAssetId", updateAssetId);
                bundle.putString("updateClientOrderNo", updateClientOrderNo);
                bundle.putString("updateContractorAssig", updateContractorAssig);
                bundle.putString("updateCntactPerson", updateCntactPerson);
                bundle.putString("updateAssignedDate", updateAssignedDate);
                bundle.putString("updateStartDate", updateStartDate);
                bundle.putString("updateEndDate", updateEndDate);
                bundle.putString("updatePhone", updatePhone);
                bundle.putString("updateMobile", updateMobile);
                bundle.putString("updateEmail", updateEmail);
                bundle.putString("updateAuthorisedCost", updateAuthorisedCost);
                bundle.putString("updateAuthorisedHrs", updateAuthorisedHrs);
                bundle.putString("updateApprovedBy", updateApprovedBy);
                bundle.putString("updateDateRequested", updateDateRequested);
                bundle.putString("updateNewDueDate", updateNewDueDate);
                bundle.putString("updateRequired", updateRequired);
                bundle.putString("updateApproved", updateApproved);
                bundle.putString("updateExtensionReason", updateExtensionReason);
                bundle.putString("updateAdditionalHrs", updateAdditionalHrs);
                bundle.putString("updateCity", updateCity);
                bundle.putString("updateState", updateState);
                bundle.putString("updatePostCode", updatePostCode);
                bundle.putString("ID", ID);
                bundle.putString("updateEstimatedWoCost", EstimatedWoCost);
                bundle.putString("updateActualWorkOrderCost", ActualWorkOrderCost);
                bundle.putString("updateReportOnWork", ReportOnWork);
                intent.putExtras(bundle);
                startActivity(intent);
                //    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });
        nextTO = (Button) findViewById(R.id.update_btn_next);
        nextTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextEvent();
                //    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        //  fetchRegionDropDownList();
        //  fetchAreaDropDownList();
        //  fetchLocationDropDownList();
        // fetchBuildingDropDownList();
        /*fetchAssetDropDownList();*/
        //  fetchSubRegionDropDownList();
        //   fetchFloorDropDownList();
        //fetchRoomDropDownList();


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
                        UpdateWorkOrder2.this, new GeocoderHandlerfrom());

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

                    from_city = UtilityFunction.filterAddress(UpdateWorkOrder2.this, address[4], address[5], "city");//address[0];
                    Log.d("City", from_city);
                    Constants.FROM_CITY = from_city;
                    et_city.setText(from_city);
                    et_state.setText(UtilityFunction.filterAddress(UpdateWorkOrder2.this, address[4], address[5], "state"));
                    et_postcode.setText(UtilityFunction.filterAddress(UpdateWorkOrder2.this, address[4], address[5], "pincode"));
                    from_country = UtilityFunction.filterAddress(UpdateWorkOrder2.this, address[4], address[5], "country");
                    // Log.d("print",address[i]);
                    et_latitude.setText(address[4]);
                    et_longitude.setText(address[5]);





                }
                //  oaddress.setText(ocity.getText().toString()+" ,"+ostate.getText().toString()+" ,"+ocountry.getText().toString());

            } catch (Exception e) {
                Log.d("FromCity", e.toString());
            }
        }
    }


    private void nextEvent() {
        if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker")) {
            updateRoom = et_room.getText().toString();
            // updateRegion = et_region.getText().toString();
            updateSubRegion = et_subRegion.getText().toString();
            updateLocation = et_location.getText().toString();
            updateBuildingName = et_buildingName.getText().toString();
            updateFloor = et_floor.getText().toString();
            updateArea = et_area.getText().toString().trim();


            updateAddress = auto_address1.getText().toString().trim();
            updateCity = et_city.getText().toString().trim();
            updateState = et_state.getText().toString().trim();
            updatePostCode = et_postcode.getText().toString().trim();
            ReportOnWork = etReportOnwork.getText().toString().trim();
            Intent intent = new Intent(UpdateWorkOrder2.this, UpdateWorkOrder3.class);
            Bundle bundle = new Bundle();
            bundle.putString("updateClient", updateClient);
            bundle.putString("updateClientNo", updateClientNo);
            bundle.putString("updatePoNumber", updatePoNumber);
            bundle.putString("updateWarningLevel", updateWarningLevel);
            bundle.putString("updateOrderStatus", updateOrderStatus);
            bundle.putString("updatePriority", updatePriority);
            bundle.putString("updateOrderType", updateOrderType);
            bundle.putString("updateAddress", updateAddress);
            bundle.putString("updateDateRaised", updateDateRaised);
            bundle.putString("updateCountry", updateCountry);
            bundle.putString("updateDueDate", updateDueDate);
            bundle.putString("updateWONumber", updateWONumber);
            bundle.putString("updateOriginalOrderNo", updateOriginalOrderNo);
            bundle.putString("updateRequestedBy", updateRequestedBy);
            bundle.putString("updateClientApprovalBy", updateClientApprovalBy);
            bundle.putString("updateClientApprovalDate", updateClientApprovalDate);
            bundle.putString("updateClientApproval", updateClientApproval);
            bundle.putString("updateDescription", updateDescription);
            bundle.putString("updateRoom", updateRoom);
            bundle.putString("updateRegion", updateRegion);
            bundle.putString("updateSubRegion", updateSubRegion);
            bundle.putString("updateArea", updateArea);
            bundle.putString("updateLocation", updateLocation);
            bundle.putString("updateBuildingName", updateBuildingName);
            bundle.putString("updateFloor", updateFloor);
            bundle.putString("updateAssetId", updateAssetId);
            bundle.putString("updateClientOrderNo", updateClientOrderNo);
            bundle.putString("updateContractorAssig", updateContractorAssig);
            bundle.putString("updateCntactPerson", updateCntactPerson);
            bundle.putString("updateAssignedDate", updateAssignedDate);
            bundle.putString("updateStartDate", updateStartDate);
            bundle.putString("updateEndDate", updateEndDate);
            bundle.putString("updatePhone", updatePhone);
            bundle.putString("updateMobile", updateMobile);
            bundle.putString("updateEmail", updateEmail);
            bundle.putString("updateAuthorisedCost", updateAuthorisedCost);
            bundle.putString("updateAuthorisedHrs", updateAuthorisedHrs);
            bundle.putString("updateApprovedBy", updateApprovedBy);
            bundle.putString("updateDateRequested", updateDateRequested);
            bundle.putString("updateNewDueDate", updateNewDueDate);
            bundle.putString("updateRequired", updateRequired);
            bundle.putString("updateApproved", updateApproved);
            bundle.putString("updateExtensionReason", updateExtensionReason);
            bundle.putString("updateAdditionalHrs", updateAdditionalHrs);
            bundle.putString("updateCity", updateCity);
            bundle.putString("updateState", updateState);
            bundle.putString("updatePostCode", updatePostCode);
            bundle.putString("ID", ID);
            bundle.putString("updateEstimatedWoCost", EstimatedWoCost);
            bundle.putString("updateActualWorkOrderCost", ActualWorkOrderCost);
            bundle.putString("updateReportOnWork", ReportOnWork);
            intent.putExtras(bundle);
            intent.putExtra("list", list);
            intent.putExtra("contrctTreeList", contrctTreeList);
            // Constants.orderDetails.setSitename();
            // Constants.orderDetails.setSiteid();
            //  Constants.orderDetails.setRegionid();
            Constants.orderDetails.setSitename("");
            Constants.orderDetails.setSiteid("1");
            Constants.orderDetails.setReportonwork(etReportOnwork.getText().toString());
            Constants.orderDetails.setSubregionid(et_subRegion.getText().toString());
            Constants.orderDetails.setArea(et_area.getText().toString());
            Constants.orderDetails.setLocationid(et_location.getText().toString());
            Constants.orderDetails.setBuildingname(et_buildingName.getText().toString());
            Constants.orderDetails.setFloor(et_floor.getText().toString());
            Constants.orderDetails.setRoom(et_room.getText().toString());

            try {
                String[] Address=auto_address1.getText().toString().split(",");
                if (Address.length<3)
                {
                    Constants.orderDetails.setAddress1(Address[0]);
                }else if (Address.length>3){
                    Constants.orderDetails.setAddress1(Address[0]+", "+Address[1]);

                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }

            Constants.orderDetails.setAddress2("");
            Constants.orderDetails.setWorkcity(et_city.getText().toString());
            Constants.orderDetails.setWorkstate(et_state.getText().toString());
            Constants.orderDetails.setWorkpostcode(et_postcode.getText().toString());

            // Constants.orderDetails.set(etp);
            Constants.orderDetails.setLatitude(Double.parseDouble(et_longitude.getText().toString()));
            Constants.orderDetails.setLongitude(Double.parseDouble(et_latitude.getText().toString()));


            startActivity(intent);
        } else {
            updateAddress = auto_address1.getText().toString().trim();
            updateCity = et_city.getText().toString().trim();
            updateState = et_state.getText().toString().trim();
            updatePostCode = et_postcode.getText().toString().trim();
            ReportOnWork = etReportOnwork.getText().toString().trim();
            Intent intent = new Intent(UpdateWorkOrder2.this, UpdateWorkOrder3.class);
            Bundle bundle = new Bundle();
            bundle.putString("updateClient", updateClient);
            bundle.putString("updateClientNo", updateClientNo);
            bundle.putString("updatePoNumber", updatePoNumber);
            bundle.putString("updateWarningLevel", updateWarningLevel);
            bundle.putString("updateOrderStatus", updateOrderStatus);
            bundle.putString("updatePriority", updatePriority);
            bundle.putString("updateOrderType", updateOrderType);
            bundle.putString("updateAddress", updateAddress);
            bundle.putString("updateDateRaised", updateDateRaised);
            bundle.putString("updateCountry", updateCountry);
            bundle.putString("updateDueDate", updateDueDate);
            bundle.putString("updateWONumber", updateWONumber);
            bundle.putString("updateOriginalOrderNo", updateOriginalOrderNo);
            bundle.putString("updateRequestedBy", updateRequestedBy);
            bundle.putString("updateClientApprovalBy", updateClientApprovalBy);
            bundle.putString("updateClientApprovalDate", updateClientApprovalDate);
            bundle.putString("updateClientApproval", updateClientApproval);
            bundle.putString("updateDescription", updateDescription);
            bundle.putString("updateRoom", updateRoom);
            bundle.putString("updateRegion", updateRegion);
            bundle.putString("updateSubRegion", updateSubRegion);
            bundle.putString("updateArea", updateArea);
            bundle.putString("updateLocation", updateLocation);
            bundle.putString("updateBuildingName", updateBuildingName);
            bundle.putString("updateFloor", updateFloor);
            bundle.putString("updateAssetId", updateAssetId);
            bundle.putString("updateClientOrderNo", updateClientOrderNo);
            bundle.putString("updateContractorAssig", updateContractorAssig);
            bundle.putString("updateCntactPerson", updateCntactPerson);
            bundle.putString("updateAssignedDate", updateAssignedDate);
            bundle.putString("updateStartDate", updateStartDate);
            bundle.putString("updateEndDate", updateEndDate);
            bundle.putString("updatePhone", updatePhone);
            bundle.putString("updateMobile", updateMobile);
            bundle.putString("updateEmail", updateEmail);
            bundle.putString("updateAuthorisedCost", updateAuthorisedCost);
            bundle.putString("updateAuthorisedHrs", updateAuthorisedHrs);
            bundle.putString("updateApprovedBy", updateApprovedBy);
            bundle.putString("updateDateRequested", updateDateRequested);
            bundle.putString("updateNewDueDate", updateNewDueDate);
            bundle.putString("updateRequired", updateRequired);
            bundle.putString("updateApproved", updateApproved);
            bundle.putString("updateExtensionReason", updateExtensionReason);
            bundle.putString("updateAdditionalHrs", updateAdditionalHrs);
            bundle.putString("updateCity", updateCity);
            bundle.putString("updateState", updateState);
            bundle.putString("updatePostCode", updatePostCode);
            bundle.putString("ID", ID);
            bundle.putString("updateEstimatedWoCost", EstimatedWoCost);
            bundle.putString("updateActualWorkOrderCost", ActualWorkOrderCost);
            bundle.putString("updateReportOnWork", ReportOnWork);
            intent.putExtras(bundle);
            intent.putExtra("list", list);
            intent.putExtra("contrctTreeList", contrctTreeList);

           /* Constants.orderDetails.setSitename("");
            Constants.orderDetails.setSiteid("1");
            //  Constants.orderDetails.setRegionid(et_region.getText().toString());
            Constants.orderDetails.setReportonwork(ReportOnWork);
            Constants.orderDetails.setSubregionid(et_subRegion.getText().toString());
            Constants.orderDetails.setArea(et_area.getText().toString());
            Constants.orderDetails.setLocationid(et_location.getText().toString());
            Constants.orderDetails.setBuildingname(et_buildingName.getText().toString());
            Constants.orderDetails.setFloor(et_floor.getText().toString());
            Constants.orderDetails.setRoom(et_room.getText().toString());
            Constants.orderDetails.setAddress1(auto_address1.getText().toString());
            Constants.orderDetails.setAddress2("");
            Constants.orderDetails.setWorkcity(et_city.getText().toString());
            Constants.orderDetails.setWorkstate(et_state.getText().toString());
            Constants.orderDetails.setWorkpostcode(et_postcode.getText().toString());
            // Constants.orderDetails.set(etp);
            if (et_latitude.getText().toString().equals("")) {

            } else {
                Constants.orderDetails.setLatitude(Double.parseDouble(et_latitude.getText().toString()));
            }

            if (et_longitude.getText().toString().equals("")) {

            } else {
                Constants.orderDetails.setLongitude(Double.parseDouble(et_longitude.getText().toString()));
            }*/

            Constants.orderDetails.setSitename("");
            Constants.orderDetails.setSiteid("1");
            Constants.orderDetails.setReportonwork(etReportOnwork.getText().toString());
            Constants.orderDetails.setSubregionid(et_subRegion.getText().toString());
            Constants.orderDetails.setArea(et_area.getText().toString());
            Constants.orderDetails.setLocationid(et_location.getText().toString());
            Constants.orderDetails.setBuildingname(et_buildingName.getText().toString());
            Constants.orderDetails.setFloor(et_floor.getText().toString());
            Constants.orderDetails.setRoom(et_room.getText().toString());
            Constants.orderDetails.setAddress1(auto_address1.getText().toString());
            Constants.orderDetails.setAddress2("");
            Constants.orderDetails.setWorkcity(et_city.getText().toString());
            Constants.orderDetails.setWorkstate(et_state.getText().toString());
            Constants.orderDetails.setWorkpostcode(et_postcode.getText().toString());

            // Constants.orderDetails.set(etp);
            Constants.orderDetails.setLatitude(Double.parseDouble(et_longitude.getText().toString()));
            Constants.orderDetails.setLongitude(Double.parseDouble(et_latitude.getText().toString()));

            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem refresh = menu.findItem(R.id.menu_refresh);
        refresh.setVisible(false);

        if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Contractor")) {

            MenuItem m_asset = menu.findItem(R.id.menu_asset);
            m_asset.setVisible(false);
            /*MenuItem refresh = menu.findItem(R.id.menu_refresh);
            refresh.setVisible(false);*/
        }

        if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker")) {
            MenuItem dashboard = menu.findItem(R.id.menu_dashboard);
            dashboard.setVisible(false);
            MenuItem m_asset = menu.findItem(R.id.menu_asset);
            m_asset.setVisible(false);
            MenuItem m_about_us = menu.findItem(R.id.menu_about_us);
            m_about_us.setVisible(false);
            MenuItem m_purchase_order = menu.findItem(R.id.menu_purchase_order);
            m_purchase_order.setVisible(false);
            /*MenuItem refresh = menu.findItem(R.id.menu_refresh);
            refresh.setVisible(false);*/
        }
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
                if (preferenceManagerWorkOrder.getKey_User_Role().equals("Worker")) {
                    startActivity(new Intent(getApplicationContext(), WorkerSearchList.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), SearchWorkOrder.class));

                }
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

    private void fetchRoomDropDownList() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<RoomDropDownList>> ListCall = apiServicesWorkOrder.roomdropdown("application/json", "api/dropdown/room?floor_Name=" + updateFloor);
            ListCall.enqueue(new Callback<List<RoomDropDownList>>() {
                @Override
                public void onResponse(Call<List<RoomDropDownList>> call, Response<List<RoomDropDownList>> response) {
                    if (response.body() != null) {
                        roomDropDownLists = response.body();
                        for (int i = 0; i < roomDropDownLists.size(); i++) {
                            if (roomDropDownLists.get(i).getValue().equals(updateRoom)) {
                                showRoomDropDownList(roomDropDownLists.get(i).getText());
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<RoomDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    private void showRoomDropDownList(String compareValue) {
        if (getApplicationContext() != null) {
            String item[] = new String[roomDropDownLists.size()];
            for (int i = 0; i < roomDropDownLists.size(); i++) {
                item[i] = roomDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            // room.setAdapter(adapter);
         /*   if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                room.setSelection(spinnerPosition);
            }*/
            /*room.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateRoom=roomDropDownLists.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });*/
        }
    }

    private void fetchSubRegionDropDownList() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<SubRegionDropDownList>> ListCall = apiServicesWorkOrder.subregionorderdropdown("application/json", "api/dropdown/getsubregionby?Id=" + updateRegion);
            ListCall.enqueue(new Callback<List<SubRegionDropDownList>>() {
                @Override
                public void onResponse(Call<List<SubRegionDropDownList>> call, Response<List<SubRegionDropDownList>> response) {
                    if (response.body() != null) {
                        subRegionDropDownLists = response.body();
                        for (int i = 0; i < subRegionDropDownLists.size(); i++) {
                            if (subRegionDropDownLists.get(i).getValue().equals(updateSubRegion)) {
                                showSubRegionDropDownList(subRegionDropDownLists.get(i).getText());
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

    private void showSubRegionDropDownList(String compareValue) {
        if (getApplicationContext() != null) {
            String item[] = new String[subRegionDropDownLists.size()];
            for (int i = 0; i < subRegionDropDownLists.size(); i++) {
                item[i] = subRegionDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            //  subRegion.setAdapter(adapter);
       /*     if(compareValue!=null){
                int position=adapter.getPosition(compareValue);
                subRegion.setSelection(position);
            }*/
       /*     subRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    private void fetchFloorDropDownList() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<FloorDropDownList>> ListCall = apiServicesWorkOrder.floordropdown("application/json", "api/dropdown/floor?&building_Name=" + updateBuildingName);
            ListCall.enqueue(new Callback<List<FloorDropDownList>>() {
                @Override
                public void onResponse(Call<List<FloorDropDownList>> call, Response<List<FloorDropDownList>> response) {
                    if (response.body() != null) {
                        floorDropDownLists = response.body();
                        for (int i = 0; i < floorDropDownLists.size(); i++) {
                            if (floorDropDownLists.get(i).getValue().equals(updateFloor)) {
                                showFloorDropDownList(floorDropDownLists.get(i).getText());
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<FloorDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    private void showFloorDropDownList(String compareValue) {
        if (getApplicationContext() != null) {
            String item[] = new String[floorDropDownLists.size()];
            for (int i = 0; i < floorDropDownLists.size(); i++) {
                item[i] = floorDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            //floor.setAdapter(adapter);
           /* if(compareValue!=null){
                int position=adapter.getPosition(compareValue);
                floor.setSelection(position);
            }*/
          /*  floor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateFloor=floorDropDownLists.get(position).getText();
                    fetchRoomDropDownList();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });*/
        }
    }

    /*private void showAssetDropDownList(String compareValue){
        if(getApplicationContext()!=null) {String item[]=new String[assetDropDownLists.size()];
            for(int i=0;i<assetDropDownLists.size();i++)
            {
                item[i]=assetDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_layout
                    ,item);
            try{
                adapter.setDropDownViewResource(R.layout.spinner_layout);
                assetId.setAdapter(adapter);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(compareValue!=null){
                int position=adapter.getPosition(compareValue);
                assetId.setSelection(position);
            }
            assetId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateAssetId=assetDropDownLists.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }*/
    /*private void fetchAssetDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServices = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetDropDownList>> ListCall=apiServices.assetdropdown("application/json","api/dropdown/getaseetby?rolename="+preferenceManagerWorkOrder.getKey_User_Role()+"&companyid="+companyid);
            ListCall.enqueue(new Callback<List<AssetDropDownList>>() {
                @Override
                public void onResponse(Call<List<AssetDropDownList>> call, Response<List<AssetDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        assetDropDownLists=response.body();
                        for(int i=0;i<assetDropDownLists.size();i++) {
                            if(assetDropDownLists.get(i).getValue().equals(updateAssetId)) {
                                showAssetDropDownList(assetDropDownLists.get(i).getText());
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<AssetDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }*/
    private void showBuildingDropDownList(String compareValue) {
        String item[] = new String[buildingDropDownLists.size()];
        for (int i = 0; i < buildingDropDownLists.size(); i++) {
            item[i] = buildingDropDownLists.get(i).getText();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
        adapter.setDropDownViewResource(R.layout.fortitle);
        // buildingName.setAdapter(adapter);
       /* if(compareValue!=null)
        {
            int position=adapter.getPosition(compareValue);
            buildingName.setSelection(position);
        }*/
       /* buildingName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateBuildingName=buildingDropDownLists.get(position).getText();
                fetchFloorDropDownList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    private void fetchBuildingDropDownList() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<BuildingDropDownList>> ListCall = apiServicesWorkOrder.buildingdropdown("application/json", "api/dropdown/building?location_id=" + updateLocation);
            ListCall.enqueue(new Callback<List<BuildingDropDownList>>() {
                @Override
                public void onResponse(Call<List<BuildingDropDownList>> call, Response<List<BuildingDropDownList>> response) {
                    if (response.body() != null) {
                        buildingDropDownLists = response.body();
                        for (int i = 0; i < buildingDropDownLists.size(); i++) {
                            if (buildingDropDownLists.get(i).getText().equals(updateBuildingName)) {
                                showBuildingDropDownList(buildingDropDownLists.get(i).getText());
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<BuildingDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    private void fetchLocationDropDownList() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetLocationResponse>> ListCall = apiServicesWorkOrder.locationdropdown("application/json", "api/dropdown/locationby?regionid=" + updateRegion + "&subRegionId=" + updateSubRegion + "&AreaId=" + updateArea + "&ClientId=" + updateClientNo);
            //final Call<List<AssetLocationResponse>> ListCall=apiServicesWorkOrder.locationdropdown("application/json","api/dropdown/locationby?regionid=3&subRegionId=7&AreaId=7&ClientId=319907");

            ListCall.enqueue(new Callback<List<AssetLocationResponse>>() {
                @Override
                public void onResponse(Call<List<AssetLocationResponse>> call, Response<List<AssetLocationResponse>> response) {
                    if (response.body() != null) {
                        locationDropDownLists = response.body();
                        for (int i = 0; i < locationDropDownLists.size(); i++) {

                            if (locationDropDownLists.get(i).getId().equals(Integer.parseInt(updateLocation))) {
                                showLocationDropDown(locationDropDownLists.get(i).getSiteName());
                            }
                        }

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

    private void showLocationDropDown(String compareValue) {
        String item[] = new String[locationDropDownLists.size()];
        for (int i = 0; i < locationDropDownLists.size(); i++) {
            item[i] = locationDropDownLists.get(i).getSiteName();
            // item[i]=locationDropDownLists.get(i).getValue();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
        adapter.setDropDownViewResource(R.layout.fortitle);
        // location.setAdapter(adapter);
       /* if(compareValue!=null)
        {
            int position=adapter.getPosition(compareValue);
            location.setSelection(position);
        }*/
      /*  location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateLocation= String.valueOf(locationDropDownLists.get(position).getId());
                fetchBuildingDropDownList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    private void fetchRegionDropDownList() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<RegionDropDownList>> ListCall = apiServicesWorkOrder.regiondropdown("application/json", "api/dropdown/getregiontby");
            ListCall.enqueue(new Callback<List<RegionDropDownList>>() {
                @Override
                public void onResponse(Call<List<RegionDropDownList>> call, Response<List<RegionDropDownList>> response) {
                    if (response.body() != null) {
                        regionDropDownLists = response.body();
                        for (int i = 0; i < regionDropDownLists.size(); i++) {

                            if (regionDropDownLists.get(i).getValue().equals(updateRegion)) {
                                showRegionDropDownList(regionDropDownLists.get(i).getText());
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

    private void showRegionDropDownList(String compareValue) {
        if (getApplicationContext() != null) {
            String item[] = new String[regionDropDownLists.size()];
            for (int i = 0; i < regionDropDownLists.size(); i++) {
                item[i] = regionDropDownLists.get(i).getText();
                // item[i]=regionDropDownLists.get(i).getValue();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            //   region.setAdapter(adapter);
          /*  if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                region.setSelection(spinnerPosition);
            }*/
           /* region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateRegion=regionDropDownLists.get(position).getValue();
                    fetchSubRegionDropDownList();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });*/

        }
    }

    private void fetchAreaDropDownList() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AreaDropDownList>> ListCall = apiServicesWorkOrder.areadropdown("application/json", "api/dropdown/area");
            ListCall.enqueue(new Callback<List<AreaDropDownList>>() {
                @Override
                public void onResponse(Call<List<AreaDropDownList>> call, Response<List<AreaDropDownList>> response) {
                    if (response.body() != null) {
                        areaDropDownLists = response.body();
                        for (int i = 0; i < areaDropDownLists.size(); i++) {
                            if (areaDropDownLists.get(i).getValue().equals(updateArea)) {
                                showAreaDropDownList(areaDropDownLists.get(i).getText());
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

    private void showAreaDropDownList(String compareValue) {
        String item[] = new String[areaDropDownLists.size()];
        for (int i = 0; i < areaDropDownLists.size(); i++) {
            item[i] = areaDropDownLists.get(i).getText();
            //  item[i]=areaDropDownLists.get(i).getValue();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
        adapter.setDropDownViewResource(R.layout.fortitle);
        //   area.setAdapter(adapter);
       /* if(compareValue!=null)
        {
            int spinnerPosition=adapter.getPosition(compareValue);
            area.setSelection(spinnerPosition);
        }*/
      /*  area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateArea=areaDropDownLists.get(position).getValue();
                fetchLocationDropDownList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    private void fetchDashBoardListContractor() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            //api/home/linktree?rolename=Super%20Administrator&companyid=319896&parentcompanyid=319895
            final Call<DashBoardContractor> workOrderResponseModelCall = apiServicesWorkOrder.dashBoardListContractor("application/json", "api/home/linktree?rolename=" + preferenceManagerWorkOrder.getKey_User_Role() + "&companyid=" + preferenceManagerWorkOrder.getKey_Person_Company_Id() + "&parentcompanyid=" + preferenceManagerWorkOrder.getKey_Parent_Company_Id());
            workOrderResponseModelCall.enqueue(new Callback<DashBoardContractor>() {
                @Override
                public void onResponse(Call<DashBoardContractor> call, Response<DashBoardContractor> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if (response.body() != null) {
                            dashContractors = response.body();
                            /*company_number.setText(String.valueOf(dashContractors.getCompanycoubt()));
                            purchase_number.setText(String.valueOf(dashContractors.getPurchaseorderount()));
                            asset_number.setText(String.valueOf(dashContractors.getAssetcount()));
                            work_number.setText(String.valueOf(dashContractors.getWordercount()));*/
                            contrctTreeList = (ArrayList<ContrctTree>) dashContractors.getTreestuctutr();
                            Handler handler = new Handler();
                            handler.post(new Runnable() {
                                public void run() {
                                    try {
                                        // code to execute
                                        Thread.sleep(3000);
                                    } catch (Exception e) {

                                    }
                                    /*dialog.dismiss();*/
                                }
                            });
                        } else {
                            Toast.makeText(getApplicationContext(), response.errorBody().string().toString(), Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        Log.v("Exception", e.toString());
                    }
                }

                @Override
                public void onFailure(Call<DashBoardContractor> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
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
                            /*company_number.setText(String.valueOf(responses.getCompanycoubt()));
                            purchase_number.setText(String.valueOf(responses.getPurchaseorderount()));
                            asset_number.setText(String.valueOf(responses.getAssetcount()));
                            work_number.setText(String.valueOf(responses.getWordercount()));*/
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
