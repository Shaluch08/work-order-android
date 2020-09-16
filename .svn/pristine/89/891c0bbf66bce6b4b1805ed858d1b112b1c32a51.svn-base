package com.workorder.app.workorderapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.model.workOrderModel.EditWorkOrderDetails;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExtensionDetails extends AppCompatActivity {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    SimpleDateFormat newformat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());


    EditWorkOrderDetails editWorkOrderDetailsList;
    EditText update_date_requested,update_new_due_date,update_additionalHrs,update_extensionReason;
    static EditText datereq;
    Context mContext;
    Button update_btn_previous;
    Toolbar ExtDtltoolbar;
    CheckBox update_approved;
    String userrole, companyid, clientId, rolename, WorkOrderId, extentionresion, dateRequ,updateApproved,dewdate,aditionhour;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extension_details);



        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        ExtDtltoolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.ExtDtltoolbar);
        setSupportActionBar(ExtDtltoolbar);
        getSupportActionBar().setTitle("Extension Details");
        ExtDtltoolbar.setTitleTextColor(getResources().getColor(R.color.white));
        ExtDtltoolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        Bundle intent = getIntent().getExtras();
        if (intent != null) {
            WorkOrderId = intent.getString("WorkOrderId");
        }
        userrole = preferenceManagerWorkOrder.getKey_User_Role();
        companyid = preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename = preferenceManagerWorkOrder.getKey_User_Name();
        update_date_requested = (EditText) findViewById(R.id.update_date_requested);
        update_new_due_date = (EditText) findViewById(R.id.update_new_due_date);
        update_additionalHrs = (EditText) findViewById(R.id.update_additionalHrs);
        update_extensionReason = (EditText) findViewById(R.id.update_extensionReason);
        update_approved = (CheckBox)findViewById(R.id.update_approved);
        update_btn_previous = (Button)findViewById(R.id.update_btn_previous);
        update_btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("workOrderId", WorkOrderId);
                Intent intent = new Intent(ExtensionDetails.this,WorkerWOUpdate.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                    }
                });

                //Creating dialog box

        fetchExtensionDetails();
    }

    private void fetchExtensionDetails()
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
                        Log.v("Success",response.body()+"");
                        extentionresion= String.valueOf(editWorkOrderDetailsList.getExtensionrequired());
                        dateRequ= String.valueOf(editWorkOrderDetailsList.getDaterequested());
                                updateApproved= String.valueOf(editWorkOrderDetailsList.getExtensionapproved());
                                        dewdate= String.valueOf(editWorkOrderDetailsList.getNewduedate());
                                aditionhour= String.valueOf(editWorkOrderDetailsList.getAdditionalhrs());
if(extentionresion !="null") {
    update_extensionReason.setText(editWorkOrderDetailsList.getExtensionreason().toString());
}
                        if (dateRequ != "null"){
                            update_approved.setChecked(Boolean.valueOf(editWorkOrderDetailsList.getExtensionapproved()));
                        }
                        if(aditionhour !="null") {
                            update_additionalHrs.setText(editWorkOrderDetailsList.getAdditionalhrs().toString());

                        }

                        if(dateRequ !="null")
                        {
                            String RequestedDate= String.valueOf(editWorkOrderDetailsList.getDaterequested());
                            String[]reqdate=RequestedDate.split("T");
                            try{
                                Date date25=simpleDateFormat.parse(reqdate[0]);
                                update_date_requested.setText(newformat.format(date25) );
                            }catch (Exception e)
                            {
                                e.printStackTrace();
                            }

                        }
                        if(dewdate !="null")
                        {
                            String RequestedDate= String.valueOf(editWorkOrderDetailsList.getNewduedate());
                            String[]reqdate=RequestedDate.split("T");
                            try{
                                Date date25=simpleDateFormat.parse(reqdate[0]);
                                update_new_due_date.setText(newformat.format(date25) );
                            }catch (Exception e)
                            {
                                e.printStackTrace();
                            }

                        }
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
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }

    }

