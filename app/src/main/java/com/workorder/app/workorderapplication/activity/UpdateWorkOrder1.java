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
import android.widget.CompoundButton;
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
import com.workorder.app.workorderapplication.model.dashboardModel.DashBoardResponse;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.workOrderModel.AproveByDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.AssetProcessTypePOJO;
import com.workorder.app.workorderapplication.model.workOrderModel.OriginalOrderDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.RequestByDropDownList;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateWorkOrder1 extends AppCompatActivity {
    ArrayList<Treestuctutr> list;
    ArrayList<ContrctTree> contrctTrees;
    DashBoardResponse responses;
    List<RequestByDropDownList> requestByDropDownLists;
    List<AproveByDropDownList> aproveByDropDownLists;
    List<OriginalOrderDropDownList> originalOrderDropDownLists;
    Button previous,nextTO;
    String updateClient,updateClientNo,updatePoNumber,updateWarningLevel,updateOrderStatus,updatePriority,updateOrderType,updateAddress,
            updateDateRaised,updateDueDate,updateWONumber,updateOriginalOrderNo,updateCountry,
            updateRequestedBy,updateClientApprovalBy,updateClientApprovalDate,updateClientApproval,updateDescription,
            updateRoom,updateRegion,updateSubRegion,updateArea,updateLocation,updateBuildingName,updateFloor,updateAssetId,updateClientOrderNo,
            updateContractorAssig,updateCntactPerson,updateAssignedDate,updateStartDate,updateEndDate,updatePhone,updateMobile,updateEmail,updateAuthorisedCost,updateAuthorisedHrs,
            updateApprovedBy,updateDateRequested,updateNewDueDate,updateRequired,updateApproved,updateExtensionReason,updateAdditionalHrs,updateCity,updateState,updatePostCode,
            EstimatedWoCost,ActualWorkOrderCost,ReportOnWork;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    Spinner originalOrderNo,requestedBy,clientApprovalBy;
    static EditText clientApprovalDate;
    EditText EstWoCost;
    TextView tvAct;
    EditText description,clientOrderNo;
    CheckBox clientApproval;
    Spinner sp_process_type;
    String userrole,companyid,clientId,rolename;
    String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_work_order1);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        /*if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
        {
            ArrayList<Treestuctutr> list= (ArrayList<Treestuctutr>) getIntent().getSerializableExtra("list");
            list=list;
        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
            ArrayList<ContrctTree> contrctTreeArrayList=(ArrayList<ContrctTree>)getIntent().getSerializableExtra("contrctTreeList");
            contrctTrees=contrctTreeArrayList;
        }*/
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

        fetchDashBoardListFM();

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    Intent intent=new Intent(UpdateWorkOrder1.this,TreeStructure.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                  //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
                    Intent intent=new Intent(UpdateWorkOrder1.this,TreeStructure.class);
                    intent.putExtra("contrctTreeList",contrctTrees);
                    startActivity(intent);
                 //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }
                /*startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                Toast.makeText(UpdateWorkOrder1.this,"Action Escalation Tree",Toast.LENGTH_SHORT).show();*/
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
      sp_process_type=findViewById(R.id.spinner_process_type);

        Bundle intent=getIntent().getExtras();
        if (intent != null) {
            updateCountry=intent.getString("updateCountry");
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
            updateClientOrderNo=intent.getString("updateClientOrderNo");
            updateDescription=intent.getString("updateDescription");
            updateRoom=intent.getString("updateRoom");
            updateRegion=intent.getString("updateRegion");
            updateSubRegion=intent.getString("updateSubRegion");
            updateArea=intent.getString("updateArea");
            updateLocation=intent.getString("updateLocation");
            updateBuildingName=intent.getString("updateBuildingName");
            updateFloor=intent.getString("updateFloor");
            updateAssetId=intent.getString("updateAssetId");
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
            ID=intent.getString("ID");
        }

        userrole= preferenceManagerWorkOrder.getKey_User_Role();
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename= preferenceManagerWorkOrder.getKey_User_Name();
        EstWoCost = (EditText) findViewById(R.id.et_est_wo_cost);


        //EstWoCost.setText(EstimatedWoCost);
        tvAct = (TextView)findViewById(R.id.tvAct);
        //tvAct.setText(ActualWorkOrderCost);
        originalOrderNo=(Spinner)findViewById(R.id.update_spinner_original_order_no);
        requestedBy=(Spinner)findViewById(R.id.update_spinner_requested_by);
        clientApprovalBy=(Spinner)findViewById(R.id.update_spinner_client_approval_by);
        //clientApprovalBy.setEnabled(false);
        clientApprovalDate=(EditText)findViewById(R.id.update_client_approval_date);
        //clientApprovalDate.setEnabled(false);


        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getEstimatedworkordercost(),EstWoCost);
        UtilityFunction.checkTextViewSetValue(String.valueOf(Constants.workOrderDetails.getActualworkordercost()),tvAct);
        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getClientapprovaldate(),clientApprovalDate);

        clientApprovalDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        description=(EditText)findViewById(R.id.update_txt_scope_description);

        clientOrderNo=(EditText)findViewById(R.id.update_client_order_no);
       // clientOrderNo.setText(updateClientOrderNo);
        clientApproval=(CheckBox) findViewById(R.id.update_client_approval);
        clientApproval.setChecked(Boolean.valueOf(updateClientApproval));

        if (clientApproval.isChecked())
        {
            clientApprovalDate.setEnabled(true);
            description.setEnabled(true);
            clientApprovalBy.setEnabled(true);

        }else {
            clientApprovalDate.setEnabled(false);
            description.setEnabled(false);
            clientApprovalBy.setEnabled(false);

        }

      //  description.setText(updateDescription);
        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getDescription(),description);
        UtilityFunction.checkEditTextSetValue(Constants.workOrderDetails.getClientworkorderno(),clientOrderNo);
        clientApproval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    description.setEnabled(true);
                    clientApprovalBy.setEnabled(true);
                    clientApprovalDate.setEnabled(true);
                    if (clientApprovalDate.getText().toString().trim().isEmpty()) {
                        clientApprovalDate.setError("Please Select Client Approval Date");
                        requestFocus(clientApprovalDate);
                    }else if (description.getText().toString().trim().isEmpty()){
                        description.setError("Please Select Description");
                        requestFocus(description);
                    }
                }else {
                    description.setEnabled(false);
                    clientApprovalBy.setEnabled(false);
                    clientApprovalDate.setEnabled(false);
                }
            }
        });
        /*clientApproval.setChecked(Boolean.valueOf(updateClientApproval));*/
        previous=(Button)findViewById(R.id.update_btn_previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UpdateWorkOrder1.this,UpdateWorkOrder.class);
                Bundle bundle=new Bundle();
                bundle.putString("WorkOrderId",ID);
                bundle.putString("updateClient",updateClient);
                bundle.putString("updateClientNo",updateClientNo);
                bundle.putString("updatePoNumber",updatePoNumber);
                bundle.putString("updateWarningLevel",updateWarningLevel);
                bundle.putString("updateOrderStatus",updateOrderStatus);
                bundle.putString("updatePriority",updatePriority);
                bundle.putString("updateOrderType",updateOrderType);
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
                bundle.putString("updateCountry",updateCountry);
                bundle.putString("updateClientOrderNo",updateClientOrderNo);
                bundle.putString("updateEstimatedWoCost",EstimatedWoCost);
                bundle.putString("updateActualWorkOrderCost",ActualWorkOrderCost);
                bundle.putString("updateReportOnWork",ReportOnWork);
                intent.putExtras(bundle);
                intent.putExtra("list",list);
                intent.putExtra("contrctTreeList",contrctTrees);
                startActivity(intent);
            //    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });
        clientOrderNo=(EditText) findViewById(R.id.update_client_order_no);
        clientOrderNo.setText(updateClientOrderNo);
        nextTO=(Button)findViewById(R.id.update_btn_next);
        nextTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextEvent();
             //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        fetchClientAproveByDropDownList();
        fetchRequestByDropDownList();
        fetchOriginalOrderDropDownList();
        fetProcessTypeDropDown();
    }

    List<AssetProcessTypePOJO> processTypePOJOList = new ArrayList<>();
    String[] processTypeList;

    public void fetProcessTypeDropDown() {
        new GetApiCallback(this, UrlClass.WO_PROCESS_TYPE_URL, new OnTaskCompleted<String>() {
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
                    sp_process_type.setAdapter(new ArrayAdapter<String>(UpdateWorkOrder1.this, android.R.layout.simple_list_item_1, processTypeList));


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, true).execute();
    }

    private void requestFocus(View view)
    {
        if(view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }
    private void nextEvent() {

                if (preferenceManagerWorkOrder.getKey_User_Role().equals("Worker")) {

                    updateDescription = description.getText().toString().trim();
                    updateClientApproval = String.valueOf(clientApproval.isChecked());
                    updateClientApprovalDate = clientApprovalDate.getText().toString().trim();
                    updateClientOrderNo = clientOrderNo.getText().toString().trim();

                    Intent intent = new Intent(UpdateWorkOrder1.this, UpdateWorkOrder2.class);
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
                    bundle.putString("updateEstimatedWoCost",EstimatedWoCost);
                    bundle.putString("updateActualWorkOrderCost",ActualWorkOrderCost);
                    bundle.putString("updateReportOnWork",ReportOnWork);
                    intent.putExtras(bundle);

                    Constants.orderDetails.setClientworkorderno(updateClientNo);
                    Constants.orderDetails.setEstimatedworkordercost(EstimatedWoCost);
                    Constants.orderDetails.setOriginalworkorderno(updateOriginalOrderNo);
                    Constants.orderDetails.setActualworkordercost(Double.parseDouble(ActualWorkOrderCost));
                    Constants.orderDetails.setProcesstype(String.valueOf(processTypePOJOList.get(sp_process_type.getSelectedItemPosition()).getSubtypeid()));
                    Constants.orderDetails.setRequestedby(Integer.parseInt(updateRequestedBy));
                    Constants.orderDetails.setClientapproval(Boolean.parseBoolean(updateClientApproval));
                    Constants.orderDetails.setClientapprovaldate(updateClientApprovalDate);
                    Constants.orderDetails.setApprovedbyid(Integer.parseInt(updateApprovedBy));
                    Constants.orderDetails.setDescription(updateDescription);



                    startActivity(intent);

                } else {
                    updateDescription = description.getText().toString().trim();
                    updateClientApproval = String.valueOf(clientApproval.isChecked());
                    updateClientApprovalDate = clientApprovalDate.getText().toString().trim();
                    updateClientOrderNo = clientOrderNo.getText().toString().trim();
                    Intent intent = new Intent(UpdateWorkOrder1.this, UpdateWorkOrder2.class);
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
                    bundle.putString("updateEstimatedWoCost",EstimatedWoCost);
                    bundle.putString("updateActualWorkOrderCost",ActualWorkOrderCost);
                    bundle.putString("updateReportOnWork",ReportOnWork);
                    intent.putExtras(bundle);
                    Constants.orderDetails.setClientworkorderno(updateClientNo);
                    Constants.orderDetails.setEstimatedworkordercost(EstimatedWoCost);
                    Constants.orderDetails.setOriginalworkorderno(updateOriginalOrderNo);
                    Constants.orderDetails.setActualworkordercost(Double.parseDouble(ActualWorkOrderCost));
                    Constants.orderDetails.setRequestedby(Integer.parseInt(updateRequestedBy));
                    Constants.orderDetails.setClientapproval(Boolean.parseBoolean(updateClientApproval));
                    Constants.orderDetails.setClientapprovaldate(updateClientApprovalDate);
                    Constants.orderDetails.setApprovedbyid(Integer.parseInt(updateApprovedBy));
                    Constants.orderDetails.setDescription(updateDescription);

                    startActivity(intent);
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
    public void showDatePickerDialog(View v){
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

            String date = months  + "-" +  days+ "-" + year;
            String DateValue=(year+"/"+(month+1)+"/"+day);
            clientApprovalDate.setText(date);
        }
    }
    private void fetchOriginalOrderDropDownList()
    {

        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<OriginalOrderDropDownList>> ListCall= apiServicesWorkOrder.originalorderdropdown("application/json","api/dropdown/getworkorder?rolename="+rolename+"&companyid="+companyid);
            ListCall.enqueue(new Callback<List<OriginalOrderDropDownList>>() {
                @Override
                public void onResponse(Call<List<OriginalOrderDropDownList>> call, Response<List<OriginalOrderDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        originalOrderDropDownLists=response.body();

                        for(int i=0;i<originalOrderDropDownLists.size();i++) {
                            String abc=originalOrderDropDownLists.get(i).getValue();
                            if (originalOrderDropDownLists.get(i).getValue().equals(updateOriginalOrderNo)) {
                                showOriginalOrderDropDownList(originalOrderDropDownLists.get(i).getText());
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<OriginalOrderDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    private  void showOriginalOrderDropDownList(String compareValue)
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[originalOrderDropDownLists.size()];
            for(int i=0;i<originalOrderDropDownLists.size();i++)
            {
                item[i]=originalOrderDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            originalOrderNo.setAdapter(adapter);
            if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                originalOrderNo.setSelection(spinnerPosition);
            }
            originalOrderNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateOriginalOrderNo=originalOrderDropDownLists.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    private void fetchClientAproveByDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AproveByDropDownList>> ListCall= apiServicesWorkOrder.aprovebyordropdown("application/json","api/dropdown/aproveby?companyid="+ preferenceManagerWorkOrder.getKey_Person_Company_Id());
            ListCall.enqueue(new Callback<List<AproveByDropDownList>>() {
                @Override
                public void onResponse(Call<List<AproveByDropDownList>> call, Response<List<AproveByDropDownList>> response) {
                    if(response.body()!=null) {
                        aproveByDropDownLists = response.body();
                        for (int i = 0; i < aproveByDropDownLists.size(); i++) {
                            showAproveByDropDownList(aproveByDropDownLists.get(i).getText());

                            /*if(aproveByDropDownLists.get(i).getValue().equals(updateClientApprovalBy)){
                                showAproveByDropDownList(aproveByDropDownLists.get(i).getText());
                            }*/
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<AproveByDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showAproveByDropDownList(String compareValue)
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[aproveByDropDownLists.size()];
            for(int i=0;i<aproveByDropDownLists.size();i++)
            {
                item[i]=aproveByDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            clientApprovalBy.setAdapter(adapter);
            if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                clientApprovalBy.setSelection(spinnerPosition);
            }
            clientApprovalBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateApprovedBy= String.valueOf(aproveByDropDownLists.get(position).getValue());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    private void fetchRequestByDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<RequestByDropDownList>> ListCall= apiServicesWorkOrder.requestbyordropdown("application/json","api/dropdown/getrequestby?clientId="+updateClientNo);
            ListCall.enqueue(new Callback<List<RequestByDropDownList>>() {
                @Override
                public void onResponse(Call<List<RequestByDropDownList>> call, Response<List<RequestByDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        requestByDropDownLists=response.body();
                        for(int i=0;i<requestByDropDownLists.size();i++){

                            if(requestByDropDownLists.get(i).getValue().equals(updateRequestedBy));
                            {
                                showRequestByDropDownList(requestByDropDownLists.get(i).getText());
                            }
                        }
                    }
                }
                @Override
                public void onFailure(Call<List<RequestByDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showRequestByDropDownList(String compareValue)
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[requestByDropDownLists.size()];
            for(int i=0;i<requestByDropDownLists.size();i++)
            {
                item[i]=requestByDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            requestedBy.setAdapter(adapter);
            if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                requestedBy.setSelection(spinnerPosition);
            }
            requestedBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateRequestedBy= String.valueOf(requestByDropDownLists.get(position).getValue());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    public void fetchDashBoardListFM()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final PreferenceManagerWorkOrder preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
            final Call<DashBoardResponse> workOrderResponseModelCall= apiServicesWorkOrder.dashBoardListFm("application/json","api/home/linktree?rolename="+ preferenceManagerWorkOrder.getKey_User_Role()+"&companyid="+ preferenceManagerWorkOrder.getKey_Person_Company_Id()+"&parentcompanyid="+ preferenceManagerWorkOrder.getKey_Parent_Company_Id());
            workOrderResponseModelCall.enqueue(new Callback<DashBoardResponse>() {
                @Override
                public void onResponse(Call<DashBoardResponse> call, Response<DashBoardResponse> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if(response.body()!=null)
                        {
                            responses=response.body();
                            /*company_number.setText(String.valueOf(responses.getCompanycoubt()));
                            purchase_number.setText(String.valueOf(responses.getPurchaseorderount()));
                            asset_number.setText(String.valueOf(responses.getAssetcount()));
                            work_number.setText(String.valueOf(responses.getWordercount()));*/
                            list= (ArrayList<Treestuctutr>) responses.getTreestuctutr();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), response.errorBody().string().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e)
                    {
                        Log.v("Exception",e.toString());
                    }
                }

                @Override
                public void onFailure(Call<DashBoardResponse> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
}
