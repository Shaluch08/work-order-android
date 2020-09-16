package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
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

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.workorderapplication.model.assetModel.AssetDropDownList;
import com.workorder.app.workorderapplication.model.dashboardModel.DashBoardResponse;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.DashBoardContractor;
import com.workorder.app.workorderapplication.model.workOrderModel.ClientDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.EditWorkOrderDetails;
import com.workorder.app.workorderapplication.model.workOrderModel.OrderStatusDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.OrderTypeDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.PriorityDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.PurchaseOrderDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.WarningLevelDropDownList;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateWorkOrder extends AppCompatActivity {
    ArrayList<Treestuctutr> list;
    ArrayList<ContrctTree> contrctTreeList;
    List<AssetDropDownList> assetDropDownLists;
    DashBoardResponse responses;
    DashBoardContractor dashContractors;
    /*EditText phone,mobile,email;*/
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    SimpleDateFormat newformat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    List<PurchaseOrderDropDownList> poList;
    List<OrderTypeDropDownList> otList;
    EditWorkOrderDetails editWorkOrderDetailsList;
    List<ClientDropDownList> clientDropDownLists;
    List<OrderStatusDropDownList> orderStatusDropDownLists;
    List<PriorityDropDownList> priorityDropDownLists;
    List<WarningLevelDropDownList> warningLevelDropDownLists;

    String updateClient,updateClientNo,updatePoNumber,updateWarningLevel,updateOrderStatus,
            updatePriority,updateOrderType,updateAddress,updateDateRaised,updateDueDate,
            updateWONumber,updateOriginalOrderNo,updateRequestedBy,updateClientApprovalBy,
            updateClientApprovalDate,updateClientApproval,updateDescription,updateCountry,
            updateRoom,updateRegion,updateSubRegion,updateArea,updateLocation,
            updateBuildingName,updateFloor,updateAssetId,updateClientOrderNo,
            updateContractorAssig,updateCntactPerson,updateAssignedDate,updateStartDate,
            updateEndDate,updatePhone,updateMobile,updateEmail,updateAuthorisedCost,
            updateAuthorisedHrs,updateApprovedBy,updateDateRequested,updateNewDueDate,
            updateRequired,updateApproved,updateExtensionReason,updateAdditionalHrs,
            updateCity,updateState,updatePostCode,EstimatedWoCost,ActualWorkOrderCost,ReportOnWork;

    Spinner client,poNumber,warningLevel,orderStatus,priority,orderType,assetId;

    static EditText dateRaised,dueDate;

    TextView clientNo,workOrderNo,clientOrderNo;

    PreferenceManagerWorkOrder preferenceManagerWorkOrder;

    Button previous,nextTO;

    ImageView image;

    Dialog dialog;

    Integer ID;

    String userrole,companyid,clientId,rolename,WorkOrderId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_work_order);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        /*if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
        {
            ArrayList<Treestuctutr> list= (ArrayList<Treestuctutr>) getIntent().getSerializableExtra("list");
            arrayList=list;
        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
            ArrayList<ContrctTree> contrctTreeArrayList=(ArrayList<ContrctTree>)getIntent().getSerializableExtra("contrctTreeList");
            contrctTreeList=contrctTreeArrayList;
        }*/

        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")) {
            fetchDashBoardListContractor();
        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Client")){
            fetchDashBoardListFM();
        }

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Update WO");
         image=(ImageView) findViewById(R.id.tree);

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
                    Intent intent=new Intent(UpdateWorkOrder.this,TreeStructure.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                 //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
                    Intent intent=new Intent(UpdateWorkOrder.this,TreeStructure.class);
                    intent.putExtra("contrctTreeList",contrctTreeList);
                    startActivity(intent);
                 //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Client")){
                    Intent intent=new Intent(UpdateWorkOrder.this,TreeStructure.class);
                    intent.putExtra("list",list);
                    startActivity(intent);
                 //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

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
            WorkOrderId=intent.getString("WorkOrderId");
        }

        userrole= preferenceManagerWorkOrder.getKey_User_Role();
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename= preferenceManagerWorkOrder.getKey_User_Name();
        client=(Spinner)findViewById(R.id.update_spinner_client);
        assetId = (Spinner)findViewById(R.id.update_spinner_asset_id);
        poNumber=(Spinner)findViewById(R.id.update_spinner_purchase_order_no);
        warningLevel=(Spinner)findViewById(R.id.update_spinner_warning_level);
        orderStatus=(Spinner)findViewById(R.id.update_spinner_order_status);
        priority=(Spinner)findViewById(R.id.update_spinner_priority);
        orderType=(Spinner)findViewById(R.id.update_spinner_order_type);
        dateRaised=(EditText)findViewById(R.id.update_raised_date);
        dueDate=(EditText)findViewById(R.id.update_due_date);
        clientNo=(TextView)findViewById(R.id.update_client_no);
        workOrderNo=(TextView)findViewById(R.id.update_work_order_no);
        previous=(Button)findViewById(R.id.update_btn_previous);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker"))
                {
                    Bundle bundle=new Bundle();
                    bundle.putString("workOrderId",WorkOrderId);
                    Intent intent = new Intent(UpdateWorkOrder.this,WorkerWOUpdate.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    startActivity(new Intent(UpdateWorkOrder.this,SearchWorkOrder.class));
                //    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
                }


            }
        });

        nextTO=(Button)findViewById(R.id.update_btn_next);

        nextTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextEvent();
             //   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        dateRaised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        dueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });

        getUpdateListWO();
        Constants.orderDetails=new EditWorkOrderDetails();

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
        if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Worker")){
            updateClientNo=clientNo.getText().toString().trim();
            updateWONumber=workOrderNo.getText().toString().trim();
            updateDueDate=dueDate.getText().toString().trim();
            updateDateRaised=dateRaised.getText().toString().trim();
            Intent intent=new Intent(UpdateWorkOrder.this,UpdateWorkOrder1.class);
            Bundle bundle = new Bundle();
            bundle.putString("updateClient",updateClient);
            bundle.putString("updateClientNo",updateClientNo);
            bundle.putString("updatePoNumber",updatePoNumber);
            bundle.putString("updateWarningLevel",updateWarningLevel);
            bundle.putString("updateOrderStatus",updateOrderStatus);
            bundle.putString("updatePriority",updatePriority);
            bundle.putString("updateOrderType",updateOrderType);
            bundle.putString("updateAddress",updateAddress);
            bundle.putString("updateDateRaised",updateDateRaised);
            bundle.putString("updateClientOrderNo",updateClientOrderNo);
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
            bundle.putString("ID",WorkOrderId);
            bundle.putString("updateCountry",updateCountry);
            bundle.putString("updateEstimatedWoCost",EstimatedWoCost);
            bundle.putString("updateActualWorkOrderCost",ActualWorkOrderCost);
            bundle.putString("updateReportOnWork",ReportOnWork);
            intent.putExtras(bundle);
            intent.putExtra("list",list);
            intent.putExtra("contrctTreeList",contrctTreeList);

            Constants.orderDetails.setId(ID);
            Constants.orderDetails.setClientid(editWorkOrderDetailsList.getClientid());
          /*  Constants.orderDetails.setClientworkorderno(updateClientOrderNo);
            Constants.orderDetails.setPonumber(updatePoNumber);
            Constants.orderDetails.setWorkordernumber(updateWONumber);
            Constants.orderDetails.setAssetid(Integer.parseInt(updateAssetId));*/

            Constants.orderDetails.setDateraised(updateDateRaised);
            Constants.orderDetails.setDuedate(updateDueDate);
            Constants.orderDetails.setClientworkorderno(updateClientOrderNo);
            Constants.orderDetails.setPonumber(updatePoNumber);
            Constants.orderDetails.setWorkordernumber(updateWONumber);
            Constants.orderDetails.setAssetid(Integer.parseInt(updateAssetId));
            Constants.orderDetails.setWarninglevel(Integer.parseInt(updateWarningLevel));
            // Missing Order Status
            Constants.orderDetails.setPriority(Integer.parseInt(updatePriority));
            Constants.orderDetails.setWorkordertype(Integer.parseInt(updateOrderType));
            Constants.orderDetails.setEntitystatus(Integer.parseInt(updateOrderStatus));
           // Constants.orderDetails.setPriority(Integer.parseInt(updatePriority));



            startActivity(intent);

        }else
        {


        if(client.getSelectedItem().toString().trim().equals("Select Client")){
            View v= client.getSelectedView();
            TextView tv= (TextView) v;

        }else if(clientNo.getText().toString().trim().isEmpty()){

        }else if(poNumber.getSelectedItem().toString().trim().equals("Select PO Number")){
            View v= poNumber.getSelectedView();
            TextView tv= (TextView) v;

        }else if(workOrderNo.getText().toString().trim().isEmpty()){

        }else if(dateRaised.getText().toString().trim().isEmpty()){

        }else if(dueDate.getText().toString().trim().isEmpty()){

        }else if(orderType.getSelectedItem().toString().trim().equals("Please Order Type")){
            View v= orderType.getSelectedView();
            TextView tv= (TextView) v;


        }else if(assetId.getSelectedItem().toString().trim().equals("Please Select Asset")){
            View v= assetId.getSelectedView();
            TextView tv= (TextView) v;
            Toast.makeText(this, "Please select Asset Id", Toast.LENGTH_SHORT).show();

        }
        else {
            updateClientNo=clientNo.getText().toString().trim();
            updateWONumber=workOrderNo.getText().toString().trim();
            updateDueDate=dueDate.getText().toString().trim();
            updateDateRaised=dateRaised.getText().toString().trim();
            Intent intent=new Intent(UpdateWorkOrder.this,UpdateWorkOrder1.class);
            Bundle bundle = new Bundle();
            bundle.putString("updateClient",updateClient);
            bundle.putString("updateClientNo",updateClientNo);
            bundle.putString("updatePoNumber",updatePoNumber);
            bundle.putString("updateWarningLevel",updateWarningLevel);
            bundle.putString("updateOrderStatus",updateOrderStatus);
            bundle.putString("updatePriority",updatePriority);
            bundle.putString("updateOrderType",updateOrderType);
            bundle.putString("updateAddress",updateAddress);
            bundle.putString("updateDateRaised",updateDateRaised);
            bundle.putString("updateClientOrderNo",updateClientOrderNo);
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
            bundle.putString("ID",WorkOrderId);
            bundle.putString("updateCountry",updateCountry);
            bundle.putString("updateEstimatedWoCost",EstimatedWoCost);
            bundle.putString("updateActualWorkOrderCost",ActualWorkOrderCost);
            bundle.putString("updateReportOnWork",ReportOnWork);
            intent.putExtras(bundle);
            intent.putExtra("list",list);
            intent.putExtra("contrctTreeList",contrctTreeList);
            Constants.orderDetails.setId(ID);
            Constants.orderDetails.setClientid(editWorkOrderDetailsList.getClientid());
            Constants.orderDetails.setDateraised(updateDateRaised);
            Constants.orderDetails.setDuedate(updateDueDate);
            Constants.orderDetails.setClientworkorderno(updateClientOrderNo);
            Constants.orderDetails.setPonumber(updatePoNumber);
            Constants.orderDetails.setWorkordernumber(updateWONumber);
            Constants.orderDetails.setAssetid(Integer.parseInt(updateAssetId));
            Constants.orderDetails.setWarninglevel(Integer.parseInt(updateWarningLevel));
            // Missing Order Status
            Constants.orderDetails.setPriority(Integer.parseInt(updatePriority));
            Constants.orderDetails.setWorkordertype(Integer.parseInt(updateOrderType));
            Constants.orderDetails.setEntitystatus(Integer.parseInt(updateOrderStatus));
            //Constants.orderDetails.setPriority(Integer.parseInt(updatePriority));

            startActivity(intent);
        }}
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
        else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker")){
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

    private void getUpdateListWO()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<EditWorkOrderDetails> details= apiServicesWorkOrder.editworkOrderDetails("application/json","api/order/EditWorkOrderDetails?rolename="+rolename+"&companyid="+companyid+"&id="+WorkOrderId);
            details.enqueue(new Callback<EditWorkOrderDetails>() {
                @Override
                public void onResponse(Call<EditWorkOrderDetails> call, Response<EditWorkOrderDetails> response) {
                    if(response.body()!=null)
                    {
                        editWorkOrderDetailsList=response.body();
                        Constants.workOrderDetails=response.body();
                        Log.v("Success",response.body()+"");
                        if(editWorkOrderDetailsList.getWorkcountry()!=null){
                        updateCountry=editWorkOrderDetailsList.getWorkcountry();}
                        ID=editWorkOrderDetailsList.getId();
                        updateClient= String.valueOf(editWorkOrderDetailsList.getClientid());
                        Log.d("ClientId",editWorkOrderDetailsList.getClientid()+"");
                        Log.d("Id",editWorkOrderDetailsList.getId()+"");

                        updateClientNo=editWorkOrderDetailsList.getClientno();
                        clientNo.setText(updateClientNo);
                        /*updatePhone = editWorkOrderDetailsList.getPhone().toString();
                        phone.setText(updatePhone);
                        updateEmail = editWorkOrderDetailsList.getEmail().toString();
                        email.setText(updateEmail);*/
                        updatePoNumber=editWorkOrderDetailsList.getPonumber();
                        updateWONumber=editWorkOrderDetailsList.getWorkordernumber();
                        Log.d("UpdateWorkOrder",updateWONumber);
                        workOrderNo.setText(updateWONumber);
                        if(editWorkOrderDetailsList.getDateraised()!=null) {
                          /*  String updateDateRaise = editWorkOrderDetailsList.getDateRaised();
                            String[] dat = updateDateRaise.split("T");

                            Date date1 = null;
                            try {
                                date1 = simpleDateFormat.parse(dat[0]);

                            } catch (ParseException e) {
                                e.printStackTrace();
                            }*/
                            updateDateRaised =editWorkOrderDetailsList.getDateraised();//UtilityFunction.getSplitedDate(); //newformat.format(date1);
                            dateRaised.setText(updateDateRaised);
                        }else {
                            dateRaised.setText("");
                        }

                        if(editWorkOrderDetailsList.getDuedate()!=null) {
                          /*  String updateDueDateRaise = editWorkOrderDetailsList.getDueDate();
                            String[] duedate = updateDueDateRaise.split("T");
                            Date date11 = null;
                            try {
                                date11 = simpleDateFormat.parse(duedate[0]);
                                updateDueDate = newformat.format(date11);
                                dueDate.setText(updateDueDate);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }*/
                          updateDueDate=editWorkOrderDetailsList.getDuedate();//UtilityFunction.getSplitedDate();
                          dueDate.setText(updateDueDate);
                        }else {
                            dueDate.setText("");
                        }
                        updateWarningLevel= String.valueOf(editWorkOrderDetailsList.getWarninglevel());
                        updateOrderStatus= String.valueOf(editWorkOrderDetailsList.getEntitystatus());
                        updatePriority= String.valueOf(editWorkOrderDetailsList.getPriority());
                        updateOrderType= String.valueOf(editWorkOrderDetailsList.getWorkordertype());
                        updateClientOrderNo=editWorkOrderDetailsList.getClientworkorderno();
                        updateOriginalOrderNo=editWorkOrderDetailsList.getOriginalworkorderno();
                        updateAssetId= String.valueOf(editWorkOrderDetailsList.getAssetid());
                        updateRequestedBy= String.valueOf(editWorkOrderDetailsList.getRequestedby());
                        updateDescription=editWorkOrderDetailsList.getDescription();
                    /*    if(editWorkOrderDetailsList.getClientapprovaldate()!=null)
                        {
                            String ApproveDate= String.valueOf(editWorkOrderDetailsList.getClientapprovaldate());
                            String[]approveDate=ApproveDate.split("T");
                            try {
                                Date date25=simpleDateFormat.parse(approveDate[0]);
                                updateClientApprovalDate=newformat.format(date25);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }*/
                  /*      if(editWorkOrderDetailsList.getEnddate()!=null)
                        {
                            String EndDate= String.valueOf( editWorkOrderDetailsList.getEnddate());
                            String end[]=EndDate.split("T");
                            try {
                                Date date22=simpleDateFormat.parse(end[0]);
                                updateEndDate=newformat.format(date22);
                            }catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }*/

                      if (editWorkOrderDetailsList.getClientapprovaldate()!=null)
                      {
                          updateClientApprovalDate=editWorkOrderDetailsList.getClientapprovaldate();
                      }
                        updateClientApproval= String.valueOf(editWorkOrderDetailsList.getClientapproval());
                        updateClientApprovalBy= String.valueOf(editWorkOrderDetailsList.getApprovedbyid());
                        updateAddress=editWorkOrderDetailsList.getAddress1();
                        updateCity=editWorkOrderDetailsList.getWorkcity();
                        updateState=editWorkOrderDetailsList.getWorkstate();
                        updatePostCode=editWorkOrderDetailsList.getWorkpostcode();
                        updateRegion= String.valueOf(editWorkOrderDetailsList.getRegionid());
                        updateSubRegion= String.valueOf(editWorkOrderDetailsList.getSubregionid());
                        updateArea= String.valueOf(editWorkOrderDetailsList.getArea());
                        updateBuildingName=editWorkOrderDetailsList.getBuildingname();
                        updateFloor=editWorkOrderDetailsList.getFloorno();
                        updateLocation= String.valueOf(editWorkOrderDetailsList.getLocationid());
                        updateRoom=editWorkOrderDetailsList.getRoom();
                        updateAssignedDate=editWorkOrderDetailsList.getAssigneddate();
                       /* if(editWorkOrderDetailsList.getAssigneddate()!=null)
                        {
                            String Assigdate= String.valueOf( editWorkOrderDetailsList.getAssigneddate());
                            String[]assigndate=Assigdate.split("T");
                            try{
                                Date date24=simpleDateFormat.parse(assigndate[0]);
                                updateAssignedDate=newformat.format(date24);
                            }catch (Exception e){
                                e.printStackTrace();
                            }

                        }*/
                        if(editWorkOrderDetailsList.getDaterequested()!=null)
                        {
                          //  String RequestedDate= String.valueOf(editWorkOrderDetailsList.getDaterequested());
                          //  String[]reqdate=RequestedDate.split("T");
                            try{
                               // Date date23=simpleDateFormat.parse(reqdate[0]);
                                //UtilityFunction.getSplitedDate();//newformat.format(date23);
                              //  Log.d("DateRequested",updateDateRequested);
                                updateDateRequested=editWorkOrderDetailsList.getDaterequested();
                            }catch (Exception e)
                            {
                                e.printStackTrace();
                            }

                        }
                        updateRequired= String.valueOf(editWorkOrderDetailsList.getExtensionrequired());
                        updateExtensionReason= String.valueOf(editWorkOrderDetailsList.getExtensionreason());
                        updateApproved= String.valueOf(editWorkOrderDetailsList.getExtensionapproved());
                        updateApprovedBy= String.valueOf(editWorkOrderDetailsList.getExtensionapprovedbyid());
                        if(editWorkOrderDetailsList.getNewduedate()!=null)
                        {
                           // String NewDate= String.valueOf();
                          //  String[]newDate=NewDate.split("T");
                            try{
                               // Date date22=simpleDateFormat.parse(newDate[0]);
                                updateNewDueDate=editWorkOrderDetailsList.getNewduedate();
                            }catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        updateAdditionalHrs= String.valueOf(editWorkOrderDetailsList.getAdditionalhrs());
                        updateCntactPerson=editWorkOrderDetailsList.getContactperson();
                        updateContractorAssig= String.valueOf(editWorkOrderDetailsList.getAssignedto());
                        updatePhone= String.valueOf(editWorkOrderDetailsList.getPhone());
                        /*phone.setText(updatePhone);*/
                        updateMobile= String.valueOf(editWorkOrderDetailsList.getMobile());
                        updateEmail= String.valueOf(editWorkOrderDetailsList.getEmail());
                        /*email.setText(updateEmail);*/
                        if(editWorkOrderDetailsList.getStartdate()!=null){
                           // String StartDate= String.valueOf();
                           // String[]startDate=StartDate.split("T");
                          //  Date date21= null;
                            try {

                                updateStartDate=editWorkOrderDetailsList.getStartdate();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                       if (editWorkOrderDetailsList.getEnddate()!=null)
                       {
                           updateEndDate=editWorkOrderDetailsList.getEnddate();
                       }


                        updateAuthorisedCost= String.valueOf(editWorkOrderDetailsList.getAuthorizedcost());
                        updateAuthorisedHrs= String.valueOf(editWorkOrderDetailsList.getEstimatedhour());
                        EstimatedWoCost= String.valueOf(editWorkOrderDetailsList.getEstimatedworkordercost());
                        ActualWorkOrderCost= String.valueOf(editWorkOrderDetailsList.getActualworkordercost());
                        ReportOnWork=editWorkOrderDetailsList.getReportonwork();
                        fetchPONUmberDropDown();
                        fetchOrderTypeDropDown();
                        fetchClientDropDown();
                        fetchWarningLevelDropDown();
                        fetchOrderStatusDropDown();
                        fetchPriorityDropDown();

                    }
                }

                @Override
                public void onFailure(Call<EditWorkOrderDetails> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                    Log.v("Error",t.getMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
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

            String date = months  + "-" + days + "-" + year;
            dueDate.setText(date);
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

            String date =  months+ "-" + days + "-" + year;
            dateRaised.setText(date);
        }
    }

    private void fetchPriorityDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<PriorityDropDownList>> poListCall= apiServicesWorkOrder.prioritydropdown("application/json","api/dropdown/getpriority?rolename="+rolename+"&companyid="+companyid);
            poListCall.enqueue(new Callback<List<PriorityDropDownList>>() {
                @Override
                public void onResponse(Call<List<PriorityDropDownList>> call, Response<List<PriorityDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        priorityDropDownLists=response.body();
                        for(int i=0;i<priorityDropDownLists.size();i++)
                        {
                            if(priorityDropDownLists.get(i).getValue().equals(updatePriority))
                            {
                                showPriorityDropDownList(priorityDropDownLists.get(i).getText());
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<PriorityDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }

    private void showPriorityDropDownList(String compareValue)
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[priorityDropDownLists.size()];
            for(int i=0;i<priorityDropDownLists.size();i++)
            {
                item[i]=priorityDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            priority.setAdapter(adapter);
            if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                priority.setSelection(spinnerPosition);
            }
            priority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updatePriority= priorityDropDownLists.get(position).getValue();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    private void fetchOrderStatusDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<OrderStatusDropDownList>> poListCall= apiServicesWorkOrder.oredrstatusdropdown("application/json","api/dropdown/getOrderStatus?rolename="+rolename+"&companyid="+companyid);
            poListCall.enqueue(new Callback<List<OrderStatusDropDownList>>() {
                @Override
                public void onResponse(Call<List<OrderStatusDropDownList>> call, Response<List<OrderStatusDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        orderStatusDropDownLists=response.body();
                      /*  for(int i=0;i<orderStatusDropDownLists.size();i++)
                        {
                            if(orderStatusDropDownLists.get(i).getValue().equals(updateOrderStatus))

                        }*/

                        showOrderStatusDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<OrderStatusDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }

    private void showOrderStatusDropDownList()
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[orderStatusDropDownLists.size()];
            for(int i=0;i<orderStatusDropDownLists.size();i++)
            {
                item[i]=orderStatusDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            orderStatus.setAdapter(adapter);
              int pos=0;
            try {
                if (updateOrderStatus!=null)
                {
                    for(int i=0;i<orderStatusDropDownLists.size();i++)
                    {
                        if(orderStatusDropDownLists.get(i).getValue().equals(updateOrderStatus))
                        {
                            pos=i;
                        }

                    }
                }
                orderStatus.setSelection(pos);
            }catch (Exception e)
            {
                e.printStackTrace();
            }

           /* if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                orderStatus.setSelection(spinnerPosition);
            }*/
            orderStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

              try {
                  updateOrderStatus= orderStatusDropDownLists.get(position).getValue();
              }catch (Exception e)
              {
                  e.printStackTrace();
              }

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }
    }

    private void fetchWarningLevelDropDown(){
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<WarningLevelDropDownList>> poListCall= apiServicesWorkOrder.wldropdown("application/json","api/dropdown/warninglevel");
            poListCall.enqueue(new Callback<List<WarningLevelDropDownList>>() {
                @Override
                public void onResponse(Call<List<WarningLevelDropDownList>> call, Response<List<WarningLevelDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        warningLevelDropDownLists=response.body();
                       /* for(int i=0;i<warningLevelDropDownLists.size();i++)
                        {
                            int abc=warningLevelDropDownLists.get(i).getLevel();
                            if(warningLevelDropDownLists.get(i).getLevel().equals(Integer.parseInt(updateWarningLevel)))
                            {
                                showWLDropDownList(warningLevelDropDownLists.get(i).getDescription());
                            }
                        }*/
                        showWLDropDownList();

                    }
                }

                @Override
                public void onFailure(Call<List<WarningLevelDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }

    private void showWLDropDownList()
    {
        if(getApplicationContext()!=null) {
            String item[] = new String[warningLevelDropDownLists.size()];
            for (int i = 0; i < warningLevelDropDownLists.size(); i++) {
                item[i] = warningLevelDropDownLists.get(i).getDescription();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);

            adapter.setDropDownViewResource(R.layout.fortitle);
            warningLevel.setAdapter(adapter);
            int pos=0;
            try {
                if (updateWarningLevel!=null)
                {
                    for (int i=0;i<warningLevelDropDownLists.size();i++)
                    {
                        if (updateWarningLevel.equals(String.valueOf(warningLevelDropDownLists.get(i).getLevel())))
                        {
                            pos=i;
                        }
                    }
                }
                warningLevel.setSelection(pos);
            }catch (Exception e)
            {
                e.printStackTrace();
            }

          /*  if(compareValue!=null)
            {
                int spinnerPosition=adapter.getPosition(compareValue);
                warningLevel.setSelection(spinnerPosition);
            }*/
            warningLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateWarningLevel= String.valueOf(warningLevelDropDownLists.get(position).getLevel());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
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
                            if(clientDropDownLists.get(i).getValue().equals(updateClient)){
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
                item[i] = clientDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            client.setAdapter(adapter);
            if (compareValue != null) {
                int spinnerPosition = adapter.getPosition(compareValue);
                client.setSelection(spinnerPosition);
            }
            client.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateClientNo= clientDropDownLists.get(position).getValue();

                    clientNo.setText(updateClientNo);
                    clientNo.setEnabled(false);
                    fetchAssetDropDownList();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
    }

    //    public int getItemPosition(int id)
//    {
//        for (int position=0; position<clientDropDownLists.size(); position++)
//        {
//            String abcd=clientDropDownLists.get(position).getValue();
//            if(Long.valueOf(abcd)==id)
//            {
//                return position;
//            }
//
//        }
//        return 0;
//    }

    private void fetchPONUmberDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<PurchaseOrderDropDownList>> poListCall= apiServicesWorkOrder.podropdown("application/json","api/dropdown/purchaseorder?rolename="+userrole+"&companyid="+companyid);
            poListCall.enqueue(new Callback<List<PurchaseOrderDropDownList>>() {
                @Override
                public void onResponse(Call<List<PurchaseOrderDropDownList>> call, Response<List<PurchaseOrderDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        poList=response.body();
                     /*   for(int i=0;i<poList.size();i++) {
                            if(poList.get(i).getValue().equals(updatePoNumber)) {

                            }
                        }*/
                        showPODropDownList();

                    }
                }

                @Override
                public void onFailure(Call<List<PurchaseOrderDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    private void showPODropDownList()
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[poList.size()];
            int pos=0;
            for(int i=0;i<poList.size();i++)
            {
                item[i]=poList.get(i).getText();


            }

           try {

            if (updatePoNumber!=null)
            {
                for(int i=0;i<poList.size();i++)
                {
                    //item[i]=poList.get(i).getText();
                    if (updatePoNumber.equals(poList.get(i).getValue()))
                    {
                        pos=i;
                    }

                }
            }

           }catch (Exception e)
           {
               e.printStackTrace();
           }

            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            poNumber.setAdapter(adapter);
           // if (updatePoNumber != null) {
              //  int spinnerPosition = adapter.getPosition(compareValue);
      try {
          poNumber.setSelection(pos);
          // }
          poNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  updatePoNumber= poList.get(position).getValue();
                  Log.v("Select PO",poList.get(position).getText());
                  Log.v("Value of Select PO",poList.get(position).getValue());

              }
              @Override
              public void onNothingSelected(AdapterView<?> parent) {

              }
          });
      }catch (Exception e)
      {
          e.printStackTrace();
      }
        }
    }

    private void fetchOrderTypeDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<OrderTypeDropDownList>> ListCall= apiServicesWorkOrder.otdropdown("application/json","api/dropdown/getordertype?rolename="+rolename+"&companyid="+companyid);
            ListCall.enqueue(new Callback<List<OrderTypeDropDownList>>() {
                @Override
                public void onResponse(Call<List<OrderTypeDropDownList>> call, Response<List<OrderTypeDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        otList=response.body();
                      /*  for(int i=0;i<otList.size();i++){
                            if(otList.get(i).getValue().equals(updateOrderType))
                            {

                            }
                        }*/

                        showOtDropDownList();

                    }
                }

                @Override
                public void onFailure(Call<List<OrderTypeDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "Network is not available", Toast.LENGTH_LONG).show();
        }
    }
    private void showOtDropDownList()
    {
        String item[]=new String[otList.size()];
        for(int i=0;i<otList.size();i++)
        {
            item[i]=otList.get(i).getText();
            //  item[i]=otList.get(i).getValue();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
        adapter.setDropDownViewResource(R.layout.fortitle);
        orderType.setAdapter(adapter);
        int pos=0;
       try {
          if (updateWONumber!=null) {
              for (int i = 0; i < otList.size(); i++) {
                if (updateWONumber.equals(otList.get(i).getValue()))
                {
                 pos=i;
                }
              }
          }
          orderType.setSelection(pos);
       }catch (Exception e)
       {
           e.printStackTrace();
       }
       /* if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            orderType.setSelection(spinnerPosition);
        }*/
        orderType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    updateOrderType=otList.get(position).getValue();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
            final Call<DashBoardContractor> workOrderResponseModelCall= apiServicesWorkOrder.dashBoardListContractor("application/json","api/home/linktree?rolename="+ preferenceManagerWorkOrder.getKey_User_Role()+"&companyid="+ preferenceManagerWorkOrder.getKey_Person_Company_Id()+"&parentcompanyid="+ preferenceManagerWorkOrder.getKey_Parent_Company_Id());
            workOrderResponseModelCall.enqueue(new Callback<DashBoardContractor>() {
                @Override
                public void onResponse(Call<DashBoardContractor> call, Response<DashBoardContractor> response) {
                    try {
                        // TODO NULL CHECK OF RESPONSE
                        if(response.body()!=null)
                        {
                            dashContractors=response.body();
                            /*company_number.setText(String.valueOf(dashContractors.getCompanycoubt()));
                            purchase_number.setText(String.valueOf(dashContractors.getPurchaseorderount()));
                            asset_number.setText(String.valueOf(dashContractors.getAssetcount()));
                            work_number.setText(String.valueOf(dashContractors.getWordercount()));*/
                            contrctTreeList= (ArrayList<ContrctTree>) dashContractors.getTreestuctutr();



                        }
                        else {
                            Toast.makeText(getApplicationContext(), response.errorBody().string().toString(), Toast.LENGTH_LONG).show();
                        }

                    }catch (Exception e)
                    {
                        Log.v("Exception",e.toString());
                    }
                }

                @Override
                public void onFailure(Call<DashBoardContractor> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }

    private void showAssetDropDownList(final List<String> assetIdList){
        if(getApplicationContext()!=null) {
          /*  String item[]=new String[assetDropDownLists.size()];
            for(int i=0;i<assetDropDownLists.size();i++)
            {
                item[i]=assetDropDownLists.get(i).getText();
            }*/
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle
                    ,assetIdList);
            adapter.setDropDownViewResource(R.layout.fortitle);
            assetId.setAdapter(adapter);
           /* if(assetIdList!=null){
                int position=adapter.getPosition(assetIdList);
                assetId.setSelection(position);
            }*/
            assetId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    try {
                        updateAssetId=assetDropDownLists.get(position).getValue();

                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void fetchAssetDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetDropDownList>> ListCall= apiServicesWorkOrder.assetdropdown("application/json","api/dropdown/getaseetby?Clientid="+updateClientNo);
            ListCall.enqueue(new Callback<List<AssetDropDownList>>() {
                @Override
                public void onResponse(Call<List<AssetDropDownList>> call, Response<List<AssetDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        Log.d("AssetResponse",response.body().toString());
                        assetDropDownLists=response.body();
                        //   String[] assetId=new String[assetDropDownLists.size()];
                        List<String> assetList=new ArrayList<>();
                        assetList.add("Please Select Asset");
                        for (int i=0;i<response.body().size();i++)
                        {
                            Log.d("AssetId",response.body().get(i).getText());
                            assetList.add(assetDropDownLists.get(i).getText());
                        }



                        for(int i=0;i<assetDropDownLists.size();i++) {
                            if(assetDropDownLists.get(i).getValue().equals(updateAssetId)) {
                                //showAssetDropDownList(assetDropDownLists.get(i).getText());

                            }
                        }
                        showAssetDropDownList(assetList);

                    }
                }

                @Override
                public void onFailure(Call<List<AssetDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
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
