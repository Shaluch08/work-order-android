package com.workorder.app.workorderapplication.activity;

import android.app.Dialog;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.workOrderModel.AreaDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.UpdateWorkOrderAllocation;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderResponseModel;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkerDropDownList;
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

public class UpdateWorkOrderAllocate extends AppCompatActivity {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    List<WorkOrderResponseModel> responseModel;
    Spinner workerName, tradeCategory;
   static EditText workingHrs, totalHrs;
    EditText swp;
    Button submit,btnBack;
    List<AreaDropDownList> areaDropDownLists;
    List<WorkerDropDownList> lists;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String companyid, WorkOrderId, Id;
    UpdateWorkOrderAllocation updateWorkAllocation;
    String updateWorkerName, updateTradeCategory, updateWorkingHrs, updateTotalHrs, updateSwp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_work_order_allocate);
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
        getSupportActionBar().setTitle("Update WO");
        ImageView image=(ImageView) findViewById(R.id.tree);
        image.setVisibility(View.INVISIBLE);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UpdateWorkOrderAllocate.this,TreeStructure.class);
                if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
                {
                    intent.putExtra("list",arrayList);
                }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
                    intent.putExtra("contrctTreeList",contrctTrees);

                }
                startActivity(intent);
              //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                Toast.makeText(UpdateWorkOrderAllocate.this,"Action Escalation Tree", Toast.LENGTH_LONG).show();
            }
        });

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }

        Bundle intent=getIntent().getExtras();
        if (intent!= null) {
            WorkOrderId = intent.getString("WorkOrderId");
            Id = intent.getString("Id");
        }
        companyid = preferenceManagerWorkOrder.getKey_Person_Company_Id();
        workerName = (Spinner) findViewById(R.id.create_workingName);
        tradeCategory = (Spinner) findViewById(R.id.createcategory);
        workingHrs = (EditText) findViewById(R.id.create_workingHrs);
        workingHrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTruitonTimePickerDialog(v);
            }
        });
        totalHrs = (EditText) findViewById(R.id.create_totalHrs);
        totalHrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTruitonTimePickerDialog1(v);
            }
        });
        swp = (EditText) findViewById(R.id.create_swp);
        submit = (Button) findViewById(R.id.create);
        submit.setVisibility(View.INVISIBLE);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
           //     overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

       /* btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UpdateWorkOrderAllocate.this,WorkOrderAllocationList.class);
                startActivity(intent);
            }
        });*/

        fetchEditAllocationDetails();
    }

    private void requestFocus(View view)
    {
        if(view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }
    private void validate()
    {
        if(workerName.getSelectedItem().toString().trim().equals(""))
        {
            View selectedView = workerName.getSelectedView();
            TextView tv=(TextView) selectedView;
            if(tv.getText().toString().trim().equals("")) {
                tv.setError("Please Select Work Name");
                requestFocus(tv);
            }
            Toast.makeText(UpdateWorkOrderAllocate.this, "Please Select Work Name", Toast.LENGTH_LONG).show();
        }else if(tradeCategory.getSelectedItem().toString().trim().equals(""))
        {
            View selectedView = tradeCategory.getSelectedView();
            TextView tv=(TextView) selectedView;
            if(tv.getText().toString().trim().equals("")) {
                tv.setError("Please Select Trade Category");
                requestFocus(tv);
            }
            Toast.makeText(UpdateWorkOrderAllocate.this, "Please Select Trade Category", Toast.LENGTH_LONG).show();
        }else if(workingHrs.getText().toString().trim().equals(""))
        {
            workingHrs.setError("Please Enter Update Working Hours");
            requestFocus(workingHrs);
        }else if(totalHrs.getText().toString().trim().equals(""))
        {
            totalHrs.setError("Please Enter Update Total Hours");
            requestFocus(totalHrs);
        }else
        {
            UpdateWorkOrderAllocation();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Contractor")){

            MenuItem m_asset = menu.findItem(R.id.menu_asset);
            m_asset.setVisible(false);
            MenuItem refresh = menu.findItem(R.id.menu_refresh);
            refresh.setVisible(false);
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
            workingHrs.setText(hourOfDay + ":" + minute);
        }
    }
    public void showTruitonTimePickerDialog1(View v) {
        DialogFragment newFragment = new TimePickerFragment1();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
    public static class TimePickerFragment1 extends DialogFragment implements
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
            totalHrs.setText(hourOfDay + ":" + minute);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void fetchEditAllocationDetails() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<UpdateWorkOrderAllocation> loginResponseCall =
                    apiServicesWorkOrder.updateList("application/json", "api/workerperson/EditAllocation?id=" + Id);
            loginResponseCall.enqueue(new Callback<UpdateWorkOrderAllocation>() {
                @Override
                public void onResponse(Call<UpdateWorkOrderAllocation> call, Response<UpdateWorkOrderAllocation> response) {
                    try {
                        int codeStatus = response.code();
                        // TODO NULL CHECK OF RESPONSE
                        updateWorkAllocation = response.body();
                        updateWorkerName = String.valueOf(updateWorkAllocation.getPersonId());
                        updateTradeCategory = String.valueOf(updateWorkAllocation.getTradeCategoriesId());
                        updateWorkingHrs = updateWorkAllocation.getWorkingHours();
                        workingHrs.setText(updateWorkingHrs);
                        updateTotalHrs = String.valueOf(updateWorkAllocation.getTotalHours());
                        totalHrs.setText(updateTotalHrs);
                        updateSwp = updateWorkAllocation.getSwms();
                        WorkOrderId= String.valueOf(updateWorkAllocation.getWorkOrderId());
                        swp.setText(updateSwp);
                        fetchTradeDropDownList();
                        fetchWorkDropDownList();
                    } catch (Exception e) {
                        Log.v("Error", e.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<UpdateWorkOrderAllocation> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }

    public void UpdateWorkOrderAllocation() {
        updateWorkingHrs = workingHrs.getText().toString().trim();
        updateTotalHrs = totalHrs.getText().toString().trim();
        updateSwp = swp.getText().toString().trim();
        UpdateWorkOrderAllocation request = new UpdateWorkOrderAllocation();
        request.setWorkingHours(updateWorkingHrs);
        request.setTotalHours(Long.parseLong(updateTotalHrs));
        request.setSwms(updateSwp);
        request.setId(Long.parseLong(Id));
        request.setCreatedBy(Long.parseLong(companyid));
        request.setPersonId(Long.parseLong(updateWorkerName));
        request.setTradeCategoriesId(Long.parseLong(updateTradeCategory));
        request.setWorkOrderId(Long.parseLong( WorkOrderId));
        request.setUpdatedBy(preferenceManagerWorkOrder.getKey_Person_Company_Id());
        request.setIsDeleted(false);
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<String> loginResponseCall =
                    apiServicesWorkOrder.updateWorkAllocation("application/json", request);
            loginResponseCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    try {
                        int codeStatus = response.code();
                        // TODO NULL CHECK OF RESPONSE
                        String result = response.body();
                        Toast.makeText(getApplicationContext(), "" + result, Toast.LENGTH_LONG).show();
                        Bundle bundle=new Bundle();
                        bundle.putString("WorkOrderId",WorkOrderId);
                        startActivity(new Intent(UpdateWorkOrderAllocate.this,WorkOrderAllocationList.class).putExtras(bundle));
                        finish();
                    } catch (Exception e) {
                        Log.v("Error", e.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }

    public void fetchWorkDropDownList() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<WorkerDropDownList>> listCall = apiServicesWorkOrder.workerDropDownList("application/json", "api/workerperson/getworkername?personcompanyid="+ preferenceManagerWorkOrder.getKey_Person_Company_Id());
            listCall.enqueue(new Callback<List<WorkerDropDownList>>() {
                @Override
                public void onResponse(Call<List<WorkerDropDownList>> call, Response<List<WorkerDropDownList>> response) {
                    if (response.body() != null) {
                        lists = response.body();
                        if (updateWorkerName != null) {
                            for (int i = 0; i < lists.size(); i++) {
                                if (lists.get(i).getValue().equals((updateWorkerName))) {
                                    showWorkerDropDownList(lists.get(i).getText());
                                }
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<WorkerDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }

    public void showWorkerDropDownList(String compareValue) {
        if (getApplicationContext() != null) {
            String item[] = new String[lists.size()];
            for (int i = 0; i < lists.size(); i++) {
                item[i] = lists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_layout, item);
            adapter.setDropDownViewResource(R.layout.spinner_layout);
            workerName.setAdapter(adapter);

            if (compareValue != null) {
                int spinnerPosition = adapter.getPosition(compareValue);
                workerName.setSelection(spinnerPosition);
            }
            workerName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateWorkerName = String.valueOf(lists.get(position).getValue());

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


        }
    }

    public void fetchTradeDropDownList() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AreaDropDownList>> listCall = apiServicesWorkOrder.areadropdown("application/json", "api/workerperson/gettradecategories");
            listCall.enqueue(new Callback<List<AreaDropDownList>>() {
                @Override
                public void onResponse(Call<List<AreaDropDownList>> call, Response<List<AreaDropDownList>> response) {
                    if (response.body() != null) {
                        areaDropDownLists = response.body();
                        if (updateTradeCategory != null) {
                            for (int i = 0; i < areaDropDownLists.size(); i++) {
                                if (areaDropDownLists.get(i).getValue().equals(updateTradeCategory)) {
                                    showTradeDropDownList(areaDropDownLists.get(i).getText());
                                }
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
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showTradeDropDownList(String compareValue) {
        if (getApplicationContext() != null) {
            String item[] = new String[areaDropDownLists.size()];
            for (int i = 0; i < areaDropDownLists.size(); i++) {
                item[i] = areaDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_layout, item);
            adapter.setDropDownViewResource(R.layout.spinner_layout);
            tradeCategory.setAdapter(adapter);

            if (compareValue != null) {
                int spinnerPosition = adapter.getPosition(compareValue);
                tradeCategory.setSelection(spinnerPosition);
            }
            tradeCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updateTradeCategory = areaDropDownLists.get(position).getValue();

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


        }
    }
}
