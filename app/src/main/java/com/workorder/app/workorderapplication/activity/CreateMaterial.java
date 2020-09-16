package com.workorder.app.workorderapplication.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.materialModel.MaterialRequest;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateMaterial extends AppCompatActivity {
        EditText material,qunatity,cost,materialcode;
        String Material,Qunatity,Cost,Materialcode;
        Button btnBack1,btnHome1;
    String WorkOrderId;
    android.support.v7.app.AlertDialog AlertDialog;
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_material);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
        {
            ArrayList<Treestuctutr> list= (ArrayList<Treestuctutr>) getIntent().getSerializableExtra("list");
            arrayList=list;
        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
            ArrayList<ContrctTree> contrctTreeArrayList=(ArrayList<ContrctTree>)getIntent().getSerializableExtra("contrctTreeList");
            contrctTrees=contrctTreeArrayList;
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.Materialtoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add New Material");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }
        Bundle intent=getIntent().getExtras();
        if(intent!=null)
        {
            WorkOrderId=intent.getString("WorkOrderId");
        }
        material= (EditText) findViewById(R.id.create_material);
    qunatity= (EditText) findViewById(R.id.create_quantity);
    materialcode=(EditText) findViewById(R.id.etMaterial);
    cost= (EditText) findViewById(R.id.create_cost);
    Button submit= (Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            validate();
       //     overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    });
        btnBack1 = (Button)findViewById(R.id.btnBack1);
        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (material.getText().toString().trim().isEmpty() &&
                        qunatity.getText().toString().trim().isEmpty() &&
                        cost.getText().toString().trim().isEmpty() ){
                    Bundle bundle = new Bundle();
                    bundle.putString("workOrderId", WorkOrderId);
                    Intent intent = new Intent(CreateMaterial.this,WorkerSearchList.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();

                }else {
                    onBackPressed();
                }



            }
        });

        btnHome1 = (Button)findViewById(R.id.btnHome1);
        btnHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (material.getText().toString().trim().isEmpty() &&
                        qunatity.getText().toString().trim().isEmpty() &&
                        cost.getText().toString().trim().isEmpty() ){
                    Bundle bundle = new Bundle();
                    bundle.putString("workOrderId", WorkOrderId);
                    Intent intent = new Intent(CreateMaterial.this,WorkerSearchList.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();

                }else {
                    onBackPressed();
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
                validate();
                //builder.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //  Action for 'NO' Button
                Bundle bundle = new Bundle();
                bundle.putString("workOrderId", WorkOrderId);
                Intent intent = new Intent(CreateMaterial.this,WorkerSearchList.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                /*Toast.makeText(mContext, "Cancel", Toast.LENGTH_LONG).show();*/
                dialog.cancel();
            }
        });

        //Creating dialog box
        AlertDialog  = builder.create();
        //Setting the title manually
        //alert.setTitle("AlertDialogExample");
        AlertDialog.show();
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
    if(material.getText().toString().trim().isEmpty())
    {
        if (AlertDialog!=null)
        {
            AlertDialog.dismiss();
        }
        material.setError("Please Enter  Material");
        requestFocus(material);
    }else  if(qunatity.getText().toString().trim().isEmpty())
    {
        if (AlertDialog!=null)
        {
            AlertDialog.dismiss();
        }
        qunatity.setError("Please Enter  Qunatity");
        requestFocus(qunatity);
    }else  if(cost.getText().toString().trim().isEmpty())
    {
        if (AlertDialog!=null)
        {
            AlertDialog.dismiss();
        }
        cost.setError("Please Enter  Cost");
        requestFocus(cost);
    }else {
        createMaterial();
    }
}
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    public void createMaterial()
    {

        Material=material.getText().toString().trim();
        Qunatity=qunatity.getText().toString().trim();
        Cost=cost.getText().toString().trim();
        Materialcode=materialcode.getText().toString().trim();
        MaterialRequest request=new MaterialRequest();
        request.setMaterialUsed(Material);
        request.setWorkOrderId(Integer.parseInt(WorkOrderId));
        request.setMaterialQuntity(Integer.parseInt(Qunatity));
        request.setMaterialCost(Integer.parseInt(Cost));
        request.setMaterialCode(Materialcode);
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<String> loginResponseCall =
                    apiServicesWorkOrder.createMaterial("application/json",request);
            loginResponseCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    try {
                        int codeStatus=response.code();
                        // TODO NULL CHECK OF RESPONSE
                        String result=response.body();
                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_LONG).show();
                        Bundle bundle=new Bundle();
                        bundle.putString("WorkOrderId",WorkOrderId);
                        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker"))
                        {

                            Intent intent=new Intent(CreateMaterial.this,WorkerWOUpdate.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {
                            Intent intent=new Intent(CreateMaterial.this,MaterialUsedList.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            finish();
                        }

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
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        if (preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker")) {
            MenuItem dashboard = menu.findItem(R.id.menu_dashboard);
            dashboard.setVisible(false);
            MenuItem m_asset = menu.findItem(R.id.menu_asset);
            m_asset.setVisible(false);
            MenuItem m_about_us = menu.findItem(R.id.menu_about_us);
            m_about_us.setVisible(false);
            MenuItem m_purchase_order = menu.findItem(R.id.menu_purchase_order);
            m_purchase_order.setVisible(false);
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
                startActivity(new Intent(getApplicationContext(),WorkerSearchList.class));
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
}
