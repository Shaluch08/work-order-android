package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
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
import android.widget.TimePicker;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.workOrderModel.ContactPersonDetails;
import com.workorder.app.workorderapplication.model.workOrderModel.ContactPersonDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.ContractorAssignDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderResponse;
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

public class UpdateWorkOrder3 extends AppCompatActivity {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    List<ContractorAssignDropDownList> contractorAssignDropDownLists;
    List<ContactPersonDropDownList> contactPersonDropDownLists;
    Button previous, nextTO;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String userrole, companyid, clientId, rolename;
    Spinner contractorAssig, contactPerson;
    static EditText assignedDate, startDate, endDate, authorisedHrs;
    ContactPersonDetails contactPersonDetails;
    WorkOrderResponse response;
    String ID;
    EditText phone, mobile, email, authorisedCost, country;
    String updateClient, updateClientNo, updatePoNumber, updateWarningLevel, updateOrderStatus,
            updatePriority, updateOrderType, updateAddress, updateDateRaised, updateDueDate,
            updateWONumber, updateOriginalOrderNo, updateCountry, updateRequestedBy,
            updateClientApprovalBy, updateClientApprovalDate, updateClientApproval,
            updateDescription, updateRoom, updateRegion, updateSubRegion, updateArea,
            updateLocation, updateBuildingName, updateFloor, updateAssetId, updateClientOrderNo,
            updateContractorAssig, updateCntactPerson, updateAssignedDate, updateStartDate,
            updateEndDate, updatePhone, updateMobile, updateEmail, updateAuthorisedCost,
            updateAuthorisedHrs, updateApprovedBy, updateDateRequested, updateNewDueDate,
            updateRequired, updateApproved, updateExtensionReason, updateAdditionalHrs,
            updateCity, updateState, updatePostCode, EstimatedWoCost, ActualWorkOrderCost, ReportOnWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_work_order3);
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
        getSupportActionBar().setTitle("Update WO");
        ImageView image = (ImageView) findViewById(R.id.tree);
        if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker")) {
            image.setVisibility(View.INVISIBLE);
        } else {
            image.setVisibility(View.VISIBLE);
        }

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateWorkOrder3.this, TreeStructure.class);
                if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager")) {
                    intent.putExtra("list", arrayList);
                } else if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")) {
                    intent.putExtra("contrctTreeList", contrctTrees);

                }
                startActivity(intent);
                //     overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                Toast.makeText(UpdateWorkOrder3.this, "Action Escalation Tree", Toast.LENGTH_SHORT).show();
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


        Bundle intent = getIntent().getExtras();
        if (intent != null) {
            ID = intent.getString("ID");
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
            updateCountry = intent.getString("updateCountry");
            EstimatedWoCost = intent.getString("updateEstimatedWoCost");
            ActualWorkOrderCost = intent.getString("updateActualWorkOrderCost");
            ReportOnWork = intent.getString("updateReportOnWork");
        }

        userrole = preferenceManagerWorkOrder.getKey_User_Role();
        companyid = preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename = preferenceManagerWorkOrder.getKey_User_Name();
        country = (EditText) findViewById(R.id.update_country);
        //country.setText(updateCountry);
        contractorAssig = (Spinner) findViewById(R.id.update_spinner_contractor_assi);
        contactPerson = (Spinner) findViewById(R.id.update_spinner_contact_person);
        assignedDate = (EditText) findViewById(R.id.update_assigned_date);
       // assignedDate.setText(updateAssignedDate);
        assignedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        startDate = (EditText) findViewById(R.id.update_start_date);
        //startDate.setText(updateStartDate);
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });
        endDate = (EditText) findViewById(R.id.update_end_date);
       // endDate.setText(updateEndDate);
        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog2(v);
            }
        });
        phone = (EditText) findViewById(R.id.update_phone);
       // phone.setText(updatePhone);
        mobile = (EditText) findViewById(R.id.update_mobile);
       // mobile.setText(updateMobile);
        email = (EditText) findViewById(R.id.update_email);
        //email.setText(updateEmail);
        authorisedCost = (EditText) findViewById(R.id.update_authorised_cost);
       // authorisedCost.setText(updateAuthorisedCost);
        authorisedHrs = (EditText) findViewById(R.id.update_authorised_hour);
       // authorisedHrs.setText(updateAuthorisedHrs);
        UtilityFunction.checkEditTextSetValue(updateCountry,country);
        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getAssigneddate(),assignedDate);
        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getStartdate(),startDate);
        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getEnddate(),endDate);
        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getPhone(),phone);
        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getMobile(),mobile);
        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getEmail(),email);
        UtilityFunction.checkEditTextSetValue(String.valueOf(Constants.workOrderDetails.getAuthorizedcost()),authorisedCost);
        UtilityFunction.checkEditTextSetValue(updateAuthorisedHrs,authorisedHrs);
        /*authorisedHrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTruitonTimePickerDialog(v);
            }
        });*/
        previous = (Button) findViewById(R.id.update_btn_previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateWorkOrder3.this, UpdateWorkOrder2.class);
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
                bundle.putString("updateCountry", updateCountry);
                bundle.putString("ID", ID);
                bundle.putString("updateEstimatedWoCost", EstimatedWoCost);
                bundle.putString("updateActualWorkOrderCost", ActualWorkOrderCost);
                bundle.putString("updateReportOnWork", ReportOnWork);
                intent.putExtras(bundle);
                startActivity(intent);
                //  overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });
        nextTO = (Button) findViewById(R.id.update_btn_next);
        nextTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextEvent();
                //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        fetchContractorDropDownList();
        fetchContactPersonDropDownList();
    }

    public void showTruitonTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public static class TimePickerFragment extends DialogFragment implements
            TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            String hour, min;
            if (hourOfDay < 10) {
                hour = "0" + hourOfDay;
            } else {
                hour = "" + hourOfDay;
            }

            if (minute < 10) {
                min = "0" + minute;
            } else {
                min = "" + minute;
            }

            String time = hour + ":" + min;
            authorisedHrs.setText(time);
        }
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }

    private void nextEvent() {

        if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker")) {

            updateCountry = country.getText().toString().trim();
            updateAssignedDate = assignedDate.getText().toString().trim();
            updateState = startDate.getText().toString().trim();
            updateEndDate = endDate.getText().toString().trim();
            updatePhone = phone.getText().toString().trim();
            updateMobile = mobile.getText().toString().trim();
            updateEmail = email.getText().toString().trim();
            updateAuthorisedCost = authorisedCost.getText().toString().trim();
            updateAuthorisedHrs = authorisedHrs.getText().toString().trim();
            Intent intent = new Intent(UpdateWorkOrder3.this, UpdateWorkOrder4.class);
            Bundle bundle = new Bundle();
            bundle.putString("updateClient", updateClient);
            bundle.putString("updateClientNo", updateClientNo);
            bundle.putString("updatePoNumber", updatePoNumber);
            bundle.putString("updateWarningLevel", updateWarningLevel);
            bundle.putString("updateOrderStatus", updateOrderStatus);
            bundle.putString("updatePriority", updatePriority);
            bundle.putString("updateOrderType", updateOrderType);
            bundle.putString("updateCountry", updateCountry);
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
            intent.putExtra("list", arrayList);
            intent.putExtra("contrctTreeList", contrctTrees);
            intent.putExtras(bundle);

            Constants.orderDetails.setWorkcountry(country.getText().toString());
            Constants.orderDetails.setAssignedto(Integer.parseInt(updateContractorAssig));
            Constants.orderDetails.setContactperson(updateCntactPerson);
            Constants.orderDetails.setPhone(phone.getText().toString());
            Constants.orderDetails.setMobile(mobile.getText().toString());
            Constants.orderDetails.setStartdate(startDate.getText().toString());
            Constants.orderDetails.setEnddate(endDate.getText().toString());
            Constants.orderDetails.setAuthorizedcost(Double.parseDouble(authorisedCost.getText().toString()));
            Constants.orderDetails.setAssigneddate(assignedDate.getText().toString());
            Constants.orderDetails.setAdditionalhrs(authorisedHrs.getText().toString());


            startActivity(intent);
        } else {
            updateCountry = country.getText().toString().trim();
            updateAssignedDate = assignedDate.getText().toString().trim();
            updateStartDate = startDate.getText().toString().trim();
            updateEndDate = endDate.getText().toString().trim();
            updatePhone = phone.getText().toString().trim();
            updateMobile = mobile.getText().toString().trim();
            updateEmail = email.getText().toString().trim();
            updateAuthorisedCost = authorisedCost.getText().toString().trim();
            updateAuthorisedHrs = authorisedHrs.getText().toString().trim();
            Intent intent = new Intent(UpdateWorkOrder3.this, UpdateWorkOrder4.class);
            Bundle bundle = new Bundle();
            bundle.putString("updateClient", updateClient);
            bundle.putString("updateClientNo", updateClientNo);
            bundle.putString("updatePoNumber", updatePoNumber);
            bundle.putString("updateWarningLevel", updateWarningLevel);
            bundle.putString("updateOrderStatus", updateOrderStatus);
            bundle.putString("updatePriority", updatePriority);
            bundle.putString("updateOrderType", updateOrderType);
            bundle.putString("updateCountry", updateCountry);
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
            intent.putExtra("list", arrayList);
            intent.putExtra("contrctTreeList", contrctTrees);
            intent.putExtras(bundle);
            Constants.orderDetails.setWorkcountry(country.getText().toString());
            Constants.orderDetails.setAssignedto(Integer.parseInt(updateContractorAssig));
            Constants.orderDetails.setContactperson(updateCntactPerson);
            Constants.orderDetails.setPhone(phone.getText().toString());
            Constants.orderDetails.setMobile(mobile.getText().toString());
            Constants.orderDetails.setStartdate(startDate.getText().toString());
            Constants.orderDetails.setEnddate(endDate.getText().toString());
            if (authorisedCost.getText().toString().equals(""))
            {

            }else {
                Constants.orderDetails.setAuthorizedcost(Double.parseDouble(authorisedCost.getText().toString()));
            }
            Constants.orderDetails.setAssigneddate(assignedDate.getText().toString());


            Constants.orderDetails.setAdditionalhrs(authorisedHrs.getText().toString());
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

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showDatePickerDialog1(View v) {
        DialogFragment newFragment = new DatePickerFragment1();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showDatePickerDialog2(View v) {
        DialogFragment newFragment = new DatePickerFragment2();
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
            return new DatePickerDialog(getContext(), this, year, month, day);
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

            String date = months + "-" +  days + "-" + year;
            endDate.setText(date);
        }
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
            return new DatePickerDialog(getContext(), this, year, month, day);
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
            startDate.setText(date);
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
            return new DatePickerDialog(getContext(), this, year, month, day);
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
            assignedDate.setText(date);
        }
    }

    private void fetchContactPersonDropDownList() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<ContactPersonDropDownList>> ListCall = apiServicesWorkOrder.contactpersonbyordropdown("application/json", "api/dropdown/getcontracterassign?rolename=" + rolename + "&companyid=" + companyid + "&contractorId=" + updateContractorAssig);
            ListCall.enqueue(new Callback<List<ContactPersonDropDownList>>() {
                @Override
                public void onResponse(Call<List<ContactPersonDropDownList>> call, Response<List<ContactPersonDropDownList>> response) {
                    if (response.body() != null) {
                        contactPersonDropDownLists = response.body();
                      /*  for(int i=0;i<contactPersonDropDownLists.size();i++) {
                            if(contactPersonDropDownLists.get(i).getValue().equals(updateCntactPerson)) {
                                showContactPersonDropDownList(contactPersonDropDownLists.get(i).getText());
                            }
                        }*/
                        showContactPersonDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<ContactPersonDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    private void showContactPersonDropDownList() {
        if (getApplicationContext() != null) {
            String item[] = new String[contactPersonDropDownLists.size()];
            for (int i = 0; i < contactPersonDropDownLists.size(); i++) {
                item[i] = contactPersonDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            contactPerson.setAdapter(adapter);
            int pos = 0;
            try {


                if (updateCntactPerson != null) {
                    for (int i = 0; i < contactPersonDropDownLists.size(); i++) {
                        if (contactPersonDropDownLists.get(i).getValue().equals(updateCntactPerson)) {
                            //   showContactPersonDropDownList(contactPersonDropDownLists.get(i).getText());
                            pos = i;
                        }
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            contactPerson.setSelection(pos);
         /*   if(compareValue!=null)
            {
                int position=adapter.getPosition(compareValue);
                contactPerson.setSelection(position);
            }*/
            contactPerson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    try {
                        updateCntactPerson = contactPersonDropDownLists.get(position).getValue();

                        fetchContactPersonDetails();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    private void fetchContactPersonDetails() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<ContactPersonDetails> ListCall = apiServicesWorkOrder.contactPersonDetails("application/json", "api/dropdown/getcontactperson?rolename=" + rolename + "&companyid=" + companyid + "&clientId=" + updateCntactPerson);
            ListCall.enqueue(new Callback<ContactPersonDetails>() {
                @Override
                public void onResponse(Call<ContactPersonDetails> call, Response<ContactPersonDetails> response) {
                    if (response.body() != null) {
                        contactPersonDetails = response.body();
                        email.setText(contactPersonDetails.getBusinessEmail());
                        phone.setText(contactPersonDetails.getBusinessPhone());
                        mobile.setText(contactPersonDetails.getBusinessMobile());
                    }
                }

                @Override
                public void onFailure(Call<ContactPersonDetails> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    private void fetchContractorDropDownList() {

        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<ContractorAssignDropDownList>> ListCall = apiServicesWorkOrder.contractordropdown("application/json", "api/dropdown/getacontractor?rolename=" + rolename + "&companyid=" + companyid);
            ListCall.enqueue(new Callback<List<ContractorAssignDropDownList>>() {
                @Override
                public void onResponse(Call<List<ContractorAssignDropDownList>> call, Response<List<ContractorAssignDropDownList>> response) {
                    if (response.body() != null) {
                        contractorAssignDropDownLists = response.body();
                   /*     for (int i = 0; i < contractorAssignDropDownLists.size(); i++) {
                            if (contractorAssignDropDownLists.get(i).getValue().equals(updateContractorAssig)) {
                                showContractorDropDownList(contractorAssignDropDownLists.get(i).getText());
                            }
                        }*/
                        showContractorDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<ContractorAssignDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    private void showContractorDropDownList() {
        if (getApplicationContext() != null) {
            String item[] = new String[contractorAssignDropDownLists.size()];
            for (int i = 0; i < contractorAssignDropDownLists.size(); i++) {
                item[i] = contractorAssignDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.fortitle, item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            contractorAssig.setAdapter(adapter);
            int pos=0;
            try {
                for (int i = 0; i < contractorAssignDropDownLists.size(); i++) {
                    if (contractorAssignDropDownLists.get(i).getValue().equals(updateContractorAssig)) {
                      pos=i;
                    }
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            contractorAssig.setSelection(pos);
            contractorAssig.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateContractorAssig = contractorAssignDropDownLists.get(position).getValue();
                    fetchContactPersonDropDownList();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
