package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.model.workOrderModel.EditWorkOrderDetails;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExtensionRequired extends AppCompatActivity {
    Toolbar Exttoolbar;
    android.support.v7.app.AlertDialog AlertDialog;
    EditWorkOrderDetails editWorkOrderDetailsList;
    Context mContext;
    EditText region;
    static EditText datereq;
    Button btnUpdateExtReq,btnback,btnSave,btnHome;
    String userrole, companyid, clientId, rolename, WorkOrderId, ExtesionReq, dateRequ;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extension_required);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        Exttoolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.Exttoolbar);
        setSupportActionBar(Exttoolbar);
        getSupportActionBar().setTitle("Extension Required");
        Exttoolbar.setTitleTextColor(getResources().getColor(R.color.white));
        Exttoolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        Bundle intent = getIntent().getExtras();
        if (intent != null) {
            WorkOrderId = intent.getString("WorkOrderId");
        }
        userrole = preferenceManagerWorkOrder.getKey_User_Role();
        companyid = preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename = preferenceManagerWorkOrder.getKey_User_Name();
        datereq = (EditText) findViewById(R.id.etdateReq);
        region = (EditText) findViewById(R.id.etExtension);
        btnUpdateExtReq = (Button)findViewById(R.id.btnSave);


        datereq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });

        btnUpdateExtReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extensionRequired();
            }
        });
        btnback = (Button)findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateRequ=datereq.getText().toString().trim();
                ExtesionReq=region.getText().toString().trim();
                if (!dateRequ.isEmpty()){
                    onBackPressed();
                }else {
                    Bundle bundle = new Bundle();
                    bundle.putString("workOrderId", WorkOrderId);
                    Intent intent = new Intent(ExtensionRequired.this,WorkerSearchList.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }

            }
        });


        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateExtention();
            }
        });

        btnHome = (Button)findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateRequ=datereq.getText().toString().trim();
                ExtesionReq=region.getText().toString().trim();
                if (!dateRequ.isEmpty()){
                    onBackPressed();
                }else {
                    Bundle bundle = new Bundle();
                    bundle.putString("workOrderId", WorkOrderId);
                    Intent intent = new Intent(ExtensionRequired.this,WorkerSearchList.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();

                }
            }
        });
    }


    @Override
    public void onBackPressed() {

        final android.support.v7.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        /*builder.setTitle("Title");*/
        //Setting message manually and performing action on button click
        builder.setMessage("Updates have been made. These will be lost if you do not select Save. Do you wish to Save the data entered?");
        //This will not allow to close dialogbox until user selects an option
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                /*WorkOrderId=item.getWorkOrderId();*/
                ValidateExtention();

                //builder.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //  Action for 'NO' Button
                Bundle bundle = new Bundle();
                bundle.putString("workOrderId", WorkOrderId);
                Intent intent = new Intent(ExtensionRequired.this,WorkerSearchList.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                /*Toast.makeText(mContext, "Cancel", Toast.LENGTH_SHORT).show();*/
                dialog.cancel();
            }
        });

        //Creating dialog box
        AlertDialog  = builder.create();
        //Setting the title manually
        //alert.setTitle("AlertDialogExample");
        AlertDialog.show();
    }


    public void showDatePickerDialog1(View v) {
        DialogFragment newFragment1 = new ExtensionRequired.DatePickerFragment1();
        newFragment1.show(getSupportFragmentManager(), "datePicker");
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
            /*datereq.setText( year+ "/" + (month + 1) + "/" + day);*/
            datereq.setText(year+ "/" + (month+1) + "/" +day);

        }
    }
public void  ValidateExtention()
{
    if(datereq.getText().toString().trim().isEmpty())
    {
        if (AlertDialog!=null)
        {
            AlertDialog.dismiss();
        }
        datereq.setError("Please Enter Date Requested");
        requestFocus(datereq);

    }else  if(region.getText().toString().trim().isEmpty())
    {
        if (AlertDialog!=null)
        {
            AlertDialog.dismiss();
        }
        region.setError("Please Enter Extension Reason");
        requestFocus(region);
    } else {
        dateRequ=datereq.getText().toString().trim();
        ExtesionReq=region.getText().toString().trim();
        extensionRequired();

        }

}

    public void extensionRequired() {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<String> loginResponseCall =
                    apiServicesWorkOrder.ExtensionRequierd("application/json", "api/order/UpdateWorkOrderExtention?WorkOrderID="+WorkOrderId + "&DateRequested="+dateRequ+"&ExtentionRegion="+ExtesionReq);
            loginResponseCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    try {
                        int codeStatus = response.code();
                        // TODO NULL CHECK OF RESPONSE
                        String result = response.body();
                        Toast.makeText(getApplicationContext(), "" + result, Toast.LENGTH_SHORT).show();
                        Bundle bundle = new Bundle();
                        bundle.putString("workOrderId", WorkOrderId);
                        Intent intent = new Intent(ExtensionRequired.this, WorkerWOUpdate.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
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
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }





    }
    private void requestFocus(View view)
    {
        if(view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }

}
