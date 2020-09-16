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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UrlClass;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.webservicecallback.GetApiCallback;
import com.workorder.app.webservicecallback.OnTaskCompleted;
import com.workorder.app.webservicecallback.SendData;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.workOrderModel.ContactPersonDetails;
import com.workorder.app.workorderapplication.model.workOrderModel.ContactPersonDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.ContractorAssignDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.WOCreateSuccessPOJO;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderPostResquest;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderResponse;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Work_Order2 extends AppCompatActivity {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    List<ContractorAssignDropDownList> contractorAssignDropDownLists;
    Spinner contractor,contactPerson;
    List<ContactPersonDropDownList> contactPersonDropDownLists;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String clientId,rolename,companyid;
    EditText phone,mobile,email;
    static EditText assigneddate,startdate,enddate;
    EditText authorisedcost,country;
    static EditText authorisedhour;
    String contractorID,contactPersonId;
    ContactPersonDetails contactPersonDetails;
    String floor_Name,Country,phonenumber,mobilenumber,email1,assigndate,strtdate,enddte,authorisedcst,authorishour;
    ProgressDialog dialog;
    WorkOrderResponse response;
    WorkOrderPostResquest resquest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work__order2);
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
        getSupportActionBar().setTitle("Add New Work Order");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }
             Bundle intent=getIntent().getExtras();
       dialog=new ProgressDialog(this);
       dialog.setCancelable(false);
       dialog.setMessage("Please wait.");
        country=(EditText) findViewById(R.id.country);
        country.setText(Constants.workOrderPostResquest.getWorkCountry());
        phone=(EditText) findViewById(R.id.phone);
        phone.setEnabled(false);
        mobile=(EditText) findViewById(R.id.mobile);
        mobile.setEnabled(false);
        email=(EditText) findViewById(R.id.email);
        email.setEnabled(false);
        assigneddate=(EditText) findViewById(R.id.assigned_date);
        assigneddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        startdate=(EditText) findViewById(R.id.start_date);
        startdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });
        enddate=(EditText)findViewById(R.id.end_date);
        enddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog2(v);
            }
        });
        authorisedcost=(EditText)findViewById(R.id.authorised_cost);
        authorisedhour=(EditText)findViewById(R.id.authorised_hour);
        authorisedhour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTruitonTimePickerDialog(v);
            }
        });
        rolename= preferenceManagerWorkOrder.getKey_User_Name();
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        contractor=(Spinner) findViewById(R.id.spinner_contractor_assi);
        contactPerson=findViewById(R.id.spinner_contact_person);
        Button pre=(Button) findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
              /*  Intent intent=new Intent(Work_Order2.this,Work_Order1.class);

               startActivity(intent);*/
             //   overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });
        Button submit=(Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitEvent();
            //    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
            authorisedhour.setText(time);
        }
    }
    private void requestFocus(View view)
    {
        if(view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }
    private void submitEvent(){
        if(country.getText().toString().equals("")){
            country.requestFocus();
            country.setError("Please enter country name");
        }else if (contractor.getSelectedItemPosition()==0) {
            Toast.makeText(this, "Please Select Contractor", Toast.LENGTH_SHORT).show();
        }else if(phone.getText().toString().equals("")){
            phone.setError("Please Enter Phone");
            requestFocus(phone);
        }else if(mobile.getText().toString().trim().isEmpty()){
            mobile.setError("Please Enter Mobile");
            requestFocus(mobile);
        }else if(email.getText().toString().trim().isEmpty()){
            email.setError("Please Enter Email");
            requestFocus(email);
        }else if(startdate.getText().toString().trim().isEmpty()){
            startdate.setError("Please Enter Start Date");

            requestFocus(startdate);
        }else if(enddate.getText().toString().trim().isEmpty()){
            enddate.setError("Please Enter End Date");
            requestFocus(enddate);
        }else if(authorisedcost.getText().toString().trim().isEmpty()){
            authorisedcost.setError("Please Enter Authorised Cost");
            requestFocus(country);
        }else if(authorisedhour.getText().toString().trim().isEmpty()){
            authorisedhour.setError("Please Enter Authorised Hour");
            requestFocus(authorisedhour);
        }else {
            Country=country.getText().toString();
            phonenumber=phone.getText().toString();
            mobilenumber=mobile.getText().toString();
            email1=email.getText().toString();
            assigndate=assigneddate.getText().toString();
            strtdate=startdate.getText().toString();
            enddte=enddate.getText().toString();
            authorisedcst=authorisedcost.getText().toString();
            authorishour=authorisedhour.getText().toString();
 /*           WorkOrderPostResquest workOrderPostResquest=new WorkOrderPostResquest();
            workOrderPostResquest.setClientId(clientId);
            workOrderPostResquest.setPoNumber(poNo);
            workOrderPostResquest.setWorkOrderNumber(workOrderNo);
            workOrderPostResquest.setDateRaised(dateraised);
            workOrderPostResquest.setDueDate(duedate);
            workOrderPostResquest.setWarningLevel(Integer.parseInt(warning));
            workOrderPostResquest.setEntityStatus(Integer.parseInt(orderstatus));
            workOrderPostResquest.setPriority(Integer.parseInt(priorty));
            workOrderPostResquest.setWorkOrderType(Integer.parseInt(ordertype));
            workOrderPostResquest.setClientWorkOrderNo(clientorderNo);
            workOrderPostResquest.setWorkCountry(Country);
            workOrderPostResquest.setOriginalWorkOrderNo(originalorder);
            workOrderPostResquest.setRequestedBy(requestby);
            workOrderPostResquest.setClientApprovalDate(clientaproveddate);
            workOrderPostResquest.setApprovedById(clientaproveby);
            workOrderPostResquest.setClientApproval(clientaprov);
            workOrderPostResquest.setDescription(desciption);
            workOrderPostResquest.setRegionId(regionId);
            workOrderPostResquest.setSubRegionId(subRegionId);
            workOrderPostResquest.setArea(AreaId);
            workOrderPostResquest.setLocationId(location_id);
            workOrderPostResquest.setBuildingName(building_Name);
            workOrderPostResquest.setFloorNo(floor_Name);
            workOrderPostResquest.setRoom(roomno);
            workOrderPostResquest.setAssetId(Integer.parseInt(assetID));
            workOrderPostResquest.setAddress1(addrss);
            workOrderPostResquest.setWorkCity(cit);
            workOrderPostResquest.setWorkState(stat);
            workOrderPostResquest.setWorkPostCode(postcode);
            workOrderPostResquest.setPhone(phonenumber);
            workOrderPostResquest.setMobile(mobilenumber);
            workOrderPostResquest.setAssignedTo(contractorID);
            workOrderPostResquest.setContactPerson(contactPersonId);
            workOrderPostResquest.setAssignedDate(assigndate);
            workOrderPostResquest.setStartDate(strtdate);
            workOrderPostResquest.setEndDate(enddte);
            workOrderPostResquest.setAuthorizedCost(authorisedcst);
            workOrderPostResquest.setEstimatedHour(authorishour);
            workOrderPostResquest.setEmail(email1);*/
            Constants.workOrderPostResquest.setManagementCompanyId(1);
            //Constants.workOrderPostResquest.setApprovedById(Constants.loginPOJO.getPersonCompanyId());
           // workOrderPostResquest.setEstimatedWorkOrderCost(Constants.workOrderPostResquest.getEstimatedWorkOrderCost());
           // Constants.workOrderPostResquest.setiD("32");
            Constants.workOrderPostResquest.setMobile(mobilenumber);
            Constants.workOrderPostResquest.setCompanyWorkOrderNo("");
           // Constants.workOrderPostResquest.setWorkCountry(country.getText().toString());
            Constants.workOrderPostResquest.setPhone(phonenumber);
         //   Constants.workOrderPostResquest.set(email1);
            Constants.workOrderPostResquest.setStartDate(strtdate);
            Constants.workOrderPostResquest.setEndDate(enddte);
            Constants.workOrderPostResquest.setAssigneddate(assigndate);
            Constants.workOrderPostResquest.setContactperson(contactPersonId);
            //Constants.workOrderPostResquest.setReactivecriticality(1);
            Constants.workOrderPostResquest.setAuthorizedcost(authorisedcst);
            Constants.workOrderPostResquest.setAssignedToPM(14);
          /*  Constants.workOrderPostResquest.setLatitude("28.5355");
            Constants.workOrderPostResquest.setLongitude("77.3910");
            Constants.workOrderPostResquest.setAddress2("kfdskjaffsd");*/
            Constants.workOrderPostResquest.setEntityStatus(1);
            Constants.workOrderPostResquest.setEstimatedHour("16");





            if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
                dialog.show();
                ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
                final Call<WOCreateSuccessPOJO> loginResponseCall =
                        apiServicesWorkOrder.workOrderResponse("application/json",Constants.workOrderPostResquest);
                loginResponseCall.enqueue(new Callback<WOCreateSuccessPOJO>() {
                    @Override
                    public void onResponse(Call<WOCreateSuccessPOJO> call, Response<WOCreateSuccessPOJO> response) {
                        try {
                            int codeStatus=response.code();
                            // TODO NULL CHECK OF RESPONSE
                          //  String result=response.body();
                           // Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
                           // Log.d("Result",response.toString());
                           // JSONObject jsonObject=new JSONObject(response.toString());

                            if (response.body().isStatus()) {
                                Intent intent = new Intent(Work_Order2.this, SearchWorkOrder.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                Toast.makeText(getApplicationContext(), ""+response.body().getMsg(), Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                                finish();
                            }else {
                                Toast.makeText(Work_Order2.this, ""+response.errorBody(), Toast.LENGTH_SHORT).show();
                            }
                          dialog.dismiss();

                        } catch (Exception e) {
                            Log.v("Error",e.getMessage());
                            dialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<WOCreateSuccessPOJO> call, Throwable t) {
                        t.printStackTrace();
                        System.out.println(t.getMessage() + t.getLocalizedMessage());
                        dialog.dismiss();
                    }
                });
            } else {
                Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
            }
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
              /*  startActivity(new Intent(this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();*/
                UtilityFunction.logOutAlert(this);
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
    public void showDatePickerDialog1(View v){
        DialogFragment newFragment = new DatePickerFragment1();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    public void showDatePickerDialog2(View v){
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
            enddate.setText(date);//year + "/" + (month + 1) + "/" + day
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

            startdate.setText(date);//year + "/" + (month + 1) + "/" + day
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

            String date = months  + "-" + days + "-" + year;


            assigneddate.setText(date);//year + "/" + (month + 1) + "/" + day
        }
    }
    private void fetchContactPersonDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<ContactPersonDropDownList>> ListCall= apiServicesWorkOrder.contactpersonbyordropdown("application/json","api/dropdown/getcontracterassign?contractorId="+contractorID);
            ListCall.enqueue(new Callback<List<ContactPersonDropDownList>>() {
                @Override
                public void onResponse(Call<List<ContactPersonDropDownList>> call, Response<List<ContactPersonDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        contactPersonDropDownLists=response.body();
                        showContactPersonDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<ContactPersonDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showContactPersonDropDownList()
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[contactPersonDropDownLists.size()];
            for(int i=0;i<contactPersonDropDownLists.size();i++)
            {
                item[i]=contactPersonDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            contactPerson.setAdapter(adapter);
            contactPerson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    contactPersonId=contactPersonDropDownLists.get(position).getValue();
                    fetchContactPersonDetails();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    private void fetchContactPersonDetails()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<ContactPersonDetails> ListCall= apiServicesWorkOrder.contactPersonDetails("application/json","api/dropdown/getcontactperson?clientId="+contactPersonId);
            ListCall.enqueue(new Callback<ContactPersonDetails>() {
                @Override
                public void onResponse(Call<ContactPersonDetails> call, Response<ContactPersonDetails> response) {
                    if(response.body()!=null)
                    {
                        contactPersonDetails=response.body();
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
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void fetchContractorDropDownList()
    {

        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<ContractorAssignDropDownList>> ListCall= apiServicesWorkOrder.contractordropdown("application/json","api/dropdown/getacontractor?companyid="+companyid);
            ListCall.enqueue(new Callback<List<ContractorAssignDropDownList>>() {
                @Override
                public void onResponse(Call<List<ContractorAssignDropDownList>> call, Response<List<ContractorAssignDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        contractorAssignDropDownLists=response.body();
                        showContractorDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<ContractorAssignDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showContractorDropDownList()
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[contractorAssignDropDownLists.size()];
            for(int i=0;i<contractorAssignDropDownLists.size();i++)
            {
                item[i]=contractorAssignDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            contractor.setAdapter(adapter);
            contractor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    contractorID=contractorAssignDropDownLists.get(position).getValue();
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
