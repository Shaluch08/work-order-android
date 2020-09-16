package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
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
import android.widget.TimePicker;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.workOrderModel.ClientDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.UpdateWorkOrderRequest;
import com.workorder.app.workorderapplication.model.workOrderModel.WOCreateSuccessPOJO;
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

public class UpdateWorkOrder4 extends AppCompatActivity {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    List<ClientDropDownList> clientDropDownLists;
    Button previous, submit;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String userrole, companyid, clientId, rolename;
    Spinner approvedBy;
    static EditText dateRequested, newDueDate;
    EditText extensionReason;
    static EditText additionalHrs;
    CheckBox required, approved;
    String ID;
    String updateClient, updateClientNo, updatePoNumber, updateWarningLevel,
            updateOrderStatus,updatePriority, updateOrderType, updateAddress,
            updateDateRaised,updateDueDate,updateWONumber, updateOriginalOrderNo,
            updateCountry,updateRequestedBy,updateClientApprovalBy, updateClientApprovalDate,
            updateClientApproval,updateDescription,updateRoom, updateRegion, updateSubRegion,
            updateArea,updateLocation, updateBuildingName, updateFloor, updateAssetId,
            updateClientOrderNo,updateContractorAssig, updateCntactPerson,
            updateAssignedDate, updateStartDate,updateEndDate, updatePhone, updateMobile,
            updateEmail, updateAuthorisedCost,updateAuthorisedHrs,updateApprovedBy,
            updateDateRequested, updateNewDueDate,updateRequired, updateApproved,
            updateExtensionReason, updateAdditionalHrs,updateCity, updateState, updatePostCode,
            EstimatedWoCost,ActualWorkOrderCost,ReportOnWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_work_order4);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
        {
            ArrayList<Treestuctutr> list= (ArrayList<Treestuctutr>) getIntent().getSerializableExtra("list");
            arrayList=list;
        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
            ArrayList<ContrctTree> contrctTreeArrayList=(ArrayList<ContrctTree>)getIntent().getSerializableExtra("contrctTreeList");
            contrctTrees=contrctTreeArrayList;
        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker")){
            submit = (Button)findViewById(R.id.update_btn_submit);
            submit.setVisibility(View.INVISIBLE);

        }

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Update WO");
        ImageView image=(ImageView) findViewById(R.id.tree);
        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker"))
        {
            image.setVisibility(View.INVISIBLE);
        }
        else
        {
            image.setVisibility(View.VISIBLE);
        }

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UpdateWorkOrder4.this,TreeStructure.class);
                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    intent.putExtra("list",arrayList);
                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
                    intent.putExtra("contrctTreeList",contrctTrees);

                }
                startActivity(intent);
             //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                Toast.makeText(UpdateWorkOrder4.this,"Action Escalation Tree", Toast.LENGTH_SHORT).show();
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

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        Bundle intent=getIntent().getExtras();
        if(intent!=null)
        {
            updateCountry=intent.getString("updateCountry");
            ID=intent.getString("ID");
            updateClient=intent.getString("updateClient");
            updateClientNo=intent.getString("updateClientNo");
            updatePoNumber=intent.getString("updatePoNumber");
            updateWarningLevel=intent.getString("updateWarningLevel");
            updateOrderStatus=intent.getString("updateOrderStatus");
            updatePriority=intent.getString("updatePriority");
            updateOrderType=intent.getString("updateOrderType");
            updateAddress=intent.getString("updateAddress");
            updateDateRaised=intent.getString("updateDateRaised");
            updateDueDate=intent.getString("updateDueDate");
            updateWONumber=intent.getString("updateWONumber");
            updateOriginalOrderNo=intent.getString("updateOriginalOrderNo");
            updateRequestedBy=intent.getString("updateRequestedBy");
            updateClientApprovalBy=intent.getString("updateClientApprovalBy");
            updateClientApprovalDate=intent.getString("updateClientApprovalDate");
            updateClientApproval=intent.getString("updateClientApproval");
            updateDescription=intent.getString("updateDescription");
            updateRoom=intent.getString("updateRoom");
            updateRegion=intent.getString("updateRegion");
            updateSubRegion=intent.getString("updateSubRegion");
            updateArea=intent.getString("updateArea");
            updateLocation=intent.getString("updateLocation");
            updateBuildingName=intent.getString("updateBuildingName");
            updateFloor=intent.getString("updateFloor");
            updateAssetId=intent.getString("updateAssetId");
            updateClientOrderNo=intent.getString("updateClientOrderNo");
            updateContractorAssig=intent.getString("updateContractorAssig");
            updateCntactPerson=intent.getString("updateCntactPerson");
            updateAssignedDate=intent.getString("updateAssignedDate");
            updateStartDate=intent.getString("updateStartDate");
            updateEndDate=intent.getString("updateEndDate");
            updatePhone=intent.getString("updatePhone");
            updateMobile=intent.getString("updateMobile");
            updateEmail=intent.getString("updateEmail");
            updateAuthorisedCost=intent.getString("updateAuthorisedCost");
            updateAuthorisedHrs=intent.getString("updateAuthorisedHrs");
            updateApprovedBy=intent.getString("updateApprovedBy");
            updateDateRequested=intent.getString("updateDateRequested");
            updateNewDueDate=intent.getString("updateNewDueDate");
            updateRequired=intent.getString("updateRequired");
            updateApproved=intent.getString("updateApproved");
            updateExtensionReason=intent.getString("updateExtensionReason");
            updateAdditionalHrs=intent.getString("updateAdditionalHrs");
            updateCity=intent.getString("updateCity");
            updateState=intent.getString("updateState");
            updatePostCode=intent.getString("updatePostCode");
            EstimatedWoCost=intent.getString("updateEstimatedWoCost");
            ActualWorkOrderCost=intent.getString("updateActualWorkOrderCost");
            ReportOnWork=intent.getString("updateReportOnWork");
        }

        userrole= preferenceManagerWorkOrder.getKey_User_Role();
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename= preferenceManagerWorkOrder.getKey_User_Name();

        approvedBy=(Spinner) findViewById(R.id.update_spinner_approvedBy);
        dateRequested=(EditText)findViewById(R.id.update_date_requested);
        dateRequested.setEnabled(false);
        //dateRequested.setText(updateDateRequested);
        dateRequested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        newDueDate=(EditText)findViewById(R.id.update_new_due_date);
       // newDueDate.setText(updateNewDueDate);
        newDueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });
        extensionReason=(EditText)findViewById(R.id.update_extensionReason);
        //extensionReason.setEnabled(false);
        //extensionReason.setText(updateExtensionReason);
        additionalHrs=(EditText)findViewById(R.id.update_additionalHrs);
        //additionalHrs.setText(updateAdditionalHrs);


        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getDaterequested(),dateRequested);
        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getNewduedate(),newDueDate);
        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getExtensionreason(),extensionReason);
        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getAdditionalhrs(),additionalHrs);

        additionalHrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTruitonTimePickerDialog(v);
            }
        });

        required=(CheckBox) findViewById(R.id.update_required);
        required.setChecked(Boolean.valueOf(updateRequired));
        approved=(CheckBox) findViewById(R.id.update_approved);
        approved.setChecked(Boolean.valueOf(updateApproved));
        required.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (required.isChecked()){
                    dateRequested.setEnabled(true);
                    if (dateRequested.getText().toString().trim().isEmpty()){
                        dateRequested.setError("Please Enter Date Requested");
                        requestFocus(dateRequested);
                    }else if (extensionReason.getText().toString().trim().isEmpty()){
                        extensionReason.setError("Please Select Extension Reason");
                        requestFocus(extensionReason);
                    }
                    extensionReason.setEnabled(true);
                }else {
                    dateRequested.setEnabled(false);
                    extensionReason.setEnabled(false);
                }
            }
        });

        previous=(Button)findViewById(R.id.update_btn_previous);
        submit=(Button)findViewById(R.id.update_btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitEvent();
            //    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                           }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UpdateWorkOrder4.this,UpdateWorkOrder3.class);
                Bundle bundle=new Bundle();
                bundle.putString("updateClient",updateClient);
                bundle.putString("updateClientNo",updateClientNo);
                bundle.putString("updatePoNumber",updatePoNumber);
                bundle.putString("updateWarningLevel",updateWarningLevel);
                bundle.putString("updateOrderStatus",updateOrderStatus);
                bundle.putString("updatePriority",updatePriority);
                bundle.putString("updateOrderType",updateOrderType);
                bundle.putString("updateCountry",updateCountry);
                bundle.putString("updateAddress",updateAddress);
                bundle.putString("updateDateRaised",updateDateRaised);
                bundle.putString("updateDueDate",updateDueDate);
                bundle.putString("updateWONumber",updateWONumber);
                bundle.putString("updateOriginalOrderNo",updateOriginalOrderNo);
                bundle.putString("updateRequestedBy",updateRequestedBy);
                bundle.putString("updateClientApprovalBy",updateClientApprovalBy);
                bundle.putString("updateClientApprovalDate",updateClientApprovalDate);
                bundle.putString("updateClientApproval",updateClientApproval);
                bundle.putString("updateDescription",updateDescription);
                bundle.putString("updateRoom",updateRoom);
                bundle.putString("updateRegion",updateRegion);
                bundle.putString("updateSubRegion",updateSubRegion);
                bundle.putString("updateArea",updateArea);
                bundle.putString("updateLocation",updateLocation);
                bundle.putString("updateBuildingName",updateBuildingName);
                bundle.putString("updateFloor",updateFloor);
                bundle.putString("updateAssetId",updateAssetId);
                bundle.putString("updateClientOrderNo",updateClientOrderNo);
                bundle.putString("updateContractorAssig",updateContractorAssig);
                bundle.putString("updateCntactPerson",updateCntactPerson);
                bundle.putString("updateAssignedDate",updateAssignedDate);
                bundle.putString("updateStartDate",updateStartDate);
                bundle.putString("updateEndDate",updateEndDate);
                bundle.putString("updatePhone",updatePhone);
                bundle.putString("updateMobile",updateMobile);
                bundle.putString("updateEmail",updateEmail);
                bundle.putString("updateAuthorisedCost",updateAuthorisedCost);
                bundle.putString("updateAuthorisedHrs",updateAuthorisedHrs);
                bundle.putString("updateApprovedBy",updateApprovedBy);
                bundle.putString("updateDateRequested",updateDateRequested);
                bundle.putString("updateNewDueDate",updateNewDueDate);
                bundle.putString("updateRequired",updateRequired);
                bundle.putString("updateApproved",updateApproved);
                bundle.putString("updateExtensionReason",updateExtensionReason);
                bundle.putString("updateAdditionalHrs",updateAdditionalHrs);
                bundle.putString("updateCity",updateCity);
                bundle.putString("updateState",updateState);
                bundle.putString("updatePostCode",updatePostCode);
                bundle.putString("ID",ID);
                bundle.putString("updateEstimatedWoCost",EstimatedWoCost);
                bundle.putString("updateActualWorkOrderCost",ActualWorkOrderCost);
                bundle.putString("updateReportOnWork",ReportOnWork);
                intent.putExtras(bundle);
                startActivity(intent);
              //  overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });
        fetchClientDropDown();
    }

    public void showDatePickerDialog(View v){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showDatePickerDialog1(View v){
        DialogFragment newFragment = new DatePickerFragment1();
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

            if (day < 10) {
                days = "0" + day;
            } else {
                days = String.valueOf(day);
            }

            String date = months  + "-" + days + "-" + year;
            newDueDate.setText(date);
        }
    }

    public static  class DatePickerFragment extends DialogFragment implements
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

            String date = months  + "-" +days  + "-" + year;
            dateRequested.setText(date);
        }
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
            String hour,min;
            if (hourOfDay<10)
            {
                hour="0"+hourOfDay;
            }else
            {
                hour=""+hourOfDay;
            }

            if (minute<10)
            {
                min="0"+minute;
            }else {
                min=""+minute;
            }

            String time=hour+":"+min;

            additionalHrs.setText(time);
        }
    }


    private void requestFocus(View view)
    {
        if(view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }

ProgressDialog dialog;
    private void submitEvent()
    {
      try {
          dialog=new ProgressDialog(this);
          dialog.setCancelable(false);
          dialog.setMessage("Please Wait..");
            /*if(dateRequested.getText().toString().trim().isEmpty())
        {
            dateRequested.setError("Please Enter Date Requested");
            requestFocus(dateRequested);
        }else*/ if(approvedBy.getSelectedItem().toString().trim().equals("Select Client Contract"))
          {
              View v= approvedBy.getSelectedView();
              TextView tv= (TextView) v;
              if(tv.getText().toString().trim().equals("Select ClientContract")){
                  tv.setError("Please Select ClientContract");
              }
              Toast.makeText(this, "Please Select ClientContract", Toast.LENGTH_LONG).show();
          }else if(newDueDate.getText().toString().trim().isEmpty()) {
              newDueDate.setError("Please Enter New Due Date");
              requestFocus(newDueDate);
          }else if(additionalHrs.getText().toString().trim().isEmpty())
          {
              additionalHrs.setError("Please Enter Additional Hours");
              requestFocus(additionalHrs);
          }else if (extensionReason.getText().toString().trim().isEmpty()){
              extensionReason.setError("Please Enter Extension Reason");
              requestFocus(extensionReason);
          }
          else {


            //  updateRequired= String.valueOf(required.isChecked());

              if (required.isChecked())
              {
                  Constants.orderDetails.setExtensionrequired(true);
              }else {
                  Constants.orderDetails.setExtensionrequired(false);
              }

              Constants.orderDetails.setDaterequested(dateRequested.getText().toString());
              Constants.orderDetails.setExtensionreason(extensionReason.getText().toString());

              if (approved.isChecked())
              {
                  Constants.orderDetails.setExtensionapproved(true);
              }else {
                  Constants.orderDetails.setExtensionapproved(false);

              }
              Constants.orderDetails.setExtensionapprovedbyid(Integer.parseInt(updateApprovedBy));
              Constants.orderDetails.setNewduedate(newDueDate.getText().toString());
              Constants.orderDetails.setAdditionalhrs(additionalHrs.getText().toString());
              Constants.orderDetails.setUpdatedby(Integer.parseInt(preferenceManagerWorkOrder.getKey_Person_Company_Id()));

/*
              updateApproved= String.valueOf(approved.isChecked());
              updateNewDueDate=newDueDate.getText().toString().trim();
              updateExtensionReason=extensionReason.getText().toString().trim();
              updateDateRequested=dateRequested.getText().toString().trim();
              updateAdditionalHrs=additionalHrs.getText().toString().trim();

              Log.d("DateRaised",updateDateRaised);
              Log.d("DueDate",updateDueDate);
              Log.d("ClientApproval",updateClientApprovalDate);
              Log.d("AssignedDate",updateAssignedDate);
              Log.d("StartDate",updateStartDate);
              Log.d("EndDate",updateEndDate);
              Log.d("DateRequested",updateDateRequested);
              Log.d("NewDueDate",updateNewDueDate);*/


              final UpdateWorkOrderRequest request=new UpdateWorkOrderRequest();
              request.setId(ID);
              if (Constants.orderDetails.getClientid()==null)
              {
              }else {
                  request.setClientid(String.valueOf(Constants.orderDetails.getClientid()));
              }
              request.setPoNumber(Constants.orderDetails.getPonumber());
              request.setWorkOrderNumber(Constants.orderDetails.getWorkordernumber());
              request.setDateraised(Constants.orderDetails.getDateraised());
              request.setDuedate(Constants.orderDetails.getDuedate());

              request.setWorkCountry(Constants.orderDetails.getWorkcountry());
              request.setWarningLevel(Constants.orderDetails.getWarninglevel());
              request.setEntityStatus(Constants.orderDetails.getEntitystatus());
              request.setPriority(Constants.orderDetails.getPriority());
              request.setWorkOrderType(Constants.orderDetails.getWorkordertype());
              request.setClientworkorderno(Constants.orderDetails.getClientworkorderno());
              request.setOriginalWorkOrderNo(Constants.orderDetails.getOriginalworkorderno());
              request.setRequestedBy(String.valueOf(Constants.orderDetails.getRequestedby()));
              request.setClientapprovaldate(Constants.orderDetails.getClientapprovaldate());
              request.setExtensionApprovedById(String.valueOf(Constants.orderDetails.getApprovedbyid()));
              request.setClientapproval(Constants.orderDetails.getClientapproval());
              request.setDescription(Constants.orderDetails.getDescription());
               if (Constants.orderDetails.getAssignedtopm()==null)
               {
                   request.setAssignedToPM(0);
               }else {
                   request.setAssignedToPM(Integer.valueOf(Constants.orderDetails.getAssignedtopm()));
               }



               if (Constants.orderDetails.getManagementcompanyid()==null)
               {
                   request.setManagementCompanyId(0);
               }else {
                   request.setManagementCompanyId(Integer.parseInt(Constants.orderDetails.getManagementcompanyid()));
               }
               request.setSiteName(Constants.orderDetails.getSitename());
              request.setRegionId(Constants.orderDetails.getRegionid());
              request.setSubRegionId(Constants.orderDetails.getSubregionid());
              request.setArea(Constants.orderDetails.getArea());
              request.setLocationId(Constants.orderDetails.getLocationid());
              request.setBuildingname(Constants.orderDetails.getBuildingname());

              request.setFloorNo(Constants.orderDetails.getFloorno());
              request.setRoom(Constants.orderDetails.getRoom());
              request.setAssetid(Constants.orderDetails.getAssetid());
              request.setAddress1(Constants.orderDetails.getAddress1());
              request.setWorkCity(Constants.orderDetails.getWorkcity());
              request.setWorkState(Constants.orderDetails.getWorkstate());
              request.setWorkPostCode(Constants.orderDetails.getWorkpostcode());
              request.setPhone(Constants.orderDetails.getPhone());
              request.setMobile(Constants.orderDetails.getMobile());
              //request.setAssignedto(String.valueOf(Constants.orderDetails.getAssignedto()));
              request.setContactperson(Constants.orderDetails.getContactperson());
              request.setAssigneddate(Constants.orderDetails.getAssigneddate());
              request.setStartDate(Constants.orderDetails.getStartdate());
              request.setEndDate(Constants.orderDetails.getEnddate());
              request.setReportOnWork(Constants.orderDetails.getReportonwork());

              if (Constants.orderDetails.getAuthorizedcost()==null)
              {

              }

              request.setAuthorizedcost(String.valueOf(Constants.orderDetails.getAuthorizedcost()));


              request.setEstimatedWorkOrderCost(Double.parseDouble(Constants.orderDetails.getEstimatedworkordercost()));
              request.setDuedate(Constants.orderDetails.getDuedate());

              try {
                /*  if (updateAuthorisedCost!=null)
                  {
                      request.setAuthorizedCost(updateAuthorisedCost);
                  }else {
                      Toast.makeText(this, "Authorised Cost not Found.", Toast.LENGTH_SHORT).show();
                  }*/

                 // if (updateAuthorisedHrs!=null) {
                      request.setEstimatedHour(Constants.orderDetails.getEstimatedhour());
               //   }
              }catch (Exception e)
              {
                  Log.d("Exception",e.toString());
              }

              request.setCompanyWorkOrderNo(Constants.orderDetails.getCompanyworkorderno());
              if (Constants.orderDetails.getProcesstype()==null)
              {
               request.setProcessType(1);
              }else {
                  request.setProcessType(Integer.parseInt(Constants.orderDetails.getProcesstype()));
              }
              request.setReactiveCriticality(0);
              request.setEmail(Constants.orderDetails.getEmail());
              request.setExtensionApproved(String.valueOf(Constants.orderDetails.getExtensionapproved()));
              request.setExtensionApprovedById(String.valueOf(Constants.orderDetails.getExtensionapprovedbyid()));
              request.setDateRequested(dateRequested.getText().toString());
              request.setNewDueDate(newDueDate.getText().toString());
              request.setExtensionRequired(String.valueOf(Constants.orderDetails.getExtensionrequired()));
              request.setExtensionReason(Constants.orderDetails.getExtensionreason());
              request.setAdditionHrs(additionalHrs.getText().toString());

              if (Constants.orderDetails.getLatitude()==null)
              {
                  request.setLatitude("");
              }else {
                  request.setLatitude(String.valueOf(Constants.orderDetails.getLatitude()));
              }
              if (Constants.orderDetails.getLongitude()==null)
              {
                  request.setLongitude("");
              }else {
                  request.setLongitude(String.valueOf(Constants.orderDetails.getLongitude()));
              }

              if (Constants.orderDetails.getCompanyworkorderno()==null)
              {
                  request.setCompanyWorkOrderNo("");
              }else {
                  request.setCompanyWorkOrderNo(Constants.orderDetails.getCompanyworkorderno());
              }

              if (Constants.orderDetails.getAddress2()==null)
              {
                  request.setAddress2("");
              }else {
                  request.setAddress2(Constants.orderDetails.getAddress2());
              }
              if (Constants.orderDetails.getFloorno()==null)
              {
               request.setFloorNo("1");
              }else {
                  request.setFloorNo(Constants.orderDetails.getFloorno());
              }
              if (Constants.orderDetails.getEstimatedhour()==null)
              {
                  request.setEstimatedHour("4");
              }else {
                  request.setEstimatedHour(Constants.orderDetails.getEstimatedhour());
              }      //  request.setAdditionalHrs(updateAdditionalHrs);
            //  request.se(Constants.orderDetails.getIsdeleted());
             // request.setWarnnigUrl(Constants.orderDetails.getWarnnigurl());
            //  request.setDeletedBy(Constants.orderDetails.getDeletedby());
            //  request.setDeletedDate(Constants.orderDetails.getDeleteddate());
            //  request.(preferenceManagerWorkOrder.getKey_Person_Company_Id());


              if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
                  dialog.show();
                  ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
                  final Call<WOCreateSuccessPOJO> loginResponseCall =
                          apiServicesWorkOrder.updateWorkOrder("application/json",request);
                  loginResponseCall.enqueue(new Callback<WOCreateSuccessPOJO>() {
                      @Override
                      public void onResponse(Call<WOCreateSuccessPOJO> call, Response<WOCreateSuccessPOJO> response) {
                          try {
                            //  int codeStatus=response.code();
                              // TODO NULL CHECK OF RESPONSE
                             // String result=response.body();

                            //  Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_LONG).show();
                             if (response.body().getMsg().equals("Work Order Updated Successfully")) {
                                 Toast.makeText(UpdateWorkOrder4.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                                 startActivity(new Intent(UpdateWorkOrder4.this, SearchWorkOrder.class));
                                  finishAffinity();
                                 dialog.dismiss();
                             }else {
                                 Toast.makeText(UpdateWorkOrder4.this, ""+response.body().getMsg(), Toast.LENGTH_SHORT).show();
                             dialog.dismiss();
                             }
                          } catch (Exception e) {
                              Log.v("Error",e.getMessage());
                              dialog.dismiss();
                          }
                      }

                      @Override
                      public void onFailure(Call<WOCreateSuccessPOJO> call, Throwable t) {
                          t.printStackTrace();
                        //  System.out.println(t.getMessage() + t.getLocalizedMessage());
                          Log.d("Exception",t.getMessage());
                          dialog.dismiss();
                      }
                  });
              } else {
                  Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
              }
          }
      }catch (Exception e)
      {
         e.printStackTrace();
      }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem refresh = menu.findItem(R.id.menu_refresh);
        refresh.setVisible(false);

        if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Contractor")){

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
                if (preferenceManagerWorkOrder.getKey_User_Role().equals("Worker")){
                    startActivity(new Intent(getApplicationContext(),WorkerSearchList.class));
                }else {
                    startActivity(new Intent(getApplicationContext(),SearchWorkOrder.class));

                }
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


    private void fetchClientDropDown(){
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<ClientDropDownList>> poListCall= apiServicesWorkOrder.clientdropdown("application/json","api/dropdown/getallclientlist?rolename="+userrole+"&companyid="+companyid);
            poListCall.enqueue(new Callback<List<ClientDropDownList>>() {
                @Override
                public void onResponse(Call<List<ClientDropDownList>> call, Response<List<ClientDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        clientDropDownLists=response.body();
                        for(int i=0;i<clientDropDownLists.size();i++) {
                            if(clientDropDownLists.get(i).getValue().equals(updateClient)) {
                                showClientDropDownList(clientDropDownLists.get(i).getText());
                            }
                        }
                    }
                }


                @Override
                public void onFailure(Call<List<ClientDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }


    private void showClientDropDownList(String compareValue)
    {

        if(getApplicationContext()!=null)
        {
            String item[]=new String[clientDropDownLists.size()];
            for(int i=0;i<clientDropDownLists.size();i++)
            {
                item[i]=clientDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            approvedBy.setAdapter(adapter);
            if(compareValue!=null)
            {
                int position=adapter.getPosition(compareValue);
                approvedBy.setSelection(position);
            }
            approvedBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateApprovedBy= clientDropDownLists.get(position).getValue();
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
