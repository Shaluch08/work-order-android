package com.workorder.app.workorderapplication.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportOnWork extends AppCompatActivity {
    Button btnSave2,btnback2,btnHome;
    String WorkOrderId,ReportOnWorkOrder;
    EditText etToReport;
    Context mContext;

    Toolbar Reporttoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_on_work);

        Reporttoolbar= (android.support.v7.widget.Toolbar) findViewById(R.id.Reporttoolbar);
        setSupportActionBar(Reporttoolbar);
        getSupportActionBar().setTitle("Report On Work");

        Reporttoolbar.setTitleTextColor(getResources().getColor(R.color.white));
        Reporttoolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        Bundle intent=getIntent().getExtras();
        if(intent!=null)
        {
            WorkOrderId=intent.getString("WorkOrderId");
        }
        etToReport=(EditText)findViewById(R.id.etWoReport);

        btnSave2 = (Button)findViewById(R.id.btnSave2);
        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateOnReport ();


            }
        });

        btnback2 = (Button)findViewById(R.id.btnback2);
        btnback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReportOnWorkOrder= etToReport.getText().toString().trim();
                if (!ReportOnWorkOrder.isEmpty()){
                    onBackPressed();
                }else {
                    Bundle bundle = new Bundle();
                    bundle.putString("workOrderId", WorkOrderId);
                    Intent intent = new Intent(ReportOnWork.this,WorkerSearchList.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }


            }
        });

        btnHome = (Button)findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReportOnWorkOrder= etToReport.getText().toString().trim();
                if (!ReportOnWorkOrder.isEmpty()){
                    onBackPressed();
                }else {
                    Bundle bundle = new Bundle();
                    bundle.putString("workOrderId", WorkOrderId);
                    Intent intent = new Intent(ReportOnWork.this,WorkerSearchList.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }

    @Override
    public void onBackPressed() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        /*builder.setTitle("Title");*/
        //Setting message manually and performing action on button click
        builder.setMessage("Updates have been made. These will be lost if you do not select Save. Do you wish to Save the data entered?");
        //This will not allow to close dialogbox until user selects an option
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                        /*WorkOrderId=item.getWorkOrderId();*/
                        validateOnReport ();
                        finish();
                //builder.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //  Action for 'NO' Button
                Bundle bundle = new Bundle();
                bundle.putString("workOrderId", WorkOrderId);
                Intent intent = new Intent(ReportOnWork.this,WorkerSearchList.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                /*Toast.makeText(mContext, "Cancel", Toast.LENGTH_SHORT).show();*/
                dialog.cancel();
            }
        });


        AlertDialog alert = builder.create();

        alert.show();
    }

    public void reportOnWork()
    {
          ReportOnWorkOrder= etToReport.getText().toString().trim();

        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<String> loginResponseCall =
                    apiServicesWorkOrder.UpdateReportToWork("application/json","api/order/UpdateWorkOrderReport?WorkOrderID="+WorkOrderId+"&Reportdesc="+ReportOnWorkOrder);
            loginResponseCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    try {
                        int codeStatus=response.code();
                        // TODO NULL CHECK OF RESPONSE
                        String result=response.body();
                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
                        Bundle bundle=new Bundle();
                        bundle.putString("workOrderId",WorkOrderId);
                        Intent intent=new Intent(ReportOnWork.this,WorkerWOUpdate.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        Log.v("Error",e.getMessage());
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



    public void validateOnReport ()
    {
        if(etToReport.getText().toString().trim().isEmpty())
        {
            etToReport.setError("Please Enter Work Order Report");
            requestFocus(etToReport);

        } else {
            reportOnWork();

        }

    }

  public void   requestFocus(View view){
      if(view.requestFocus())
      {
          getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
      }

    }


}
