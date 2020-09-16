package com.workorder.app.workorderapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.model.materialModel.MaterialEditList;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MaterialsUsed extends AppCompatActivity {
    ArrayList<MaterialEditList> arrayList;

    Toolbar Materialtoolbar;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String WorkOrderId;
    int id;
    EditText etMaterial,etMaterialDesc,etQuantity,etCost;
    Button btnSave1,btnBack1,btnHome1;
    String UpdateMaterialCode,UpdateMaterialDesc,UpdateQuantity,UpdateCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials_used);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());

        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Worker"))
        {
            ArrayList<MaterialEditList> list= (ArrayList<MaterialEditList>) getIntent().getSerializableExtra("list");
            arrayList=list;
        }

        Materialtoolbar= (android.support.v7.widget.Toolbar) findViewById(R.id.Materialtoolbar);
        setSupportActionBar(Materialtoolbar);
        getSupportActionBar().setTitle("Materials Used");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            Materialtoolbar.setTitleTextColor(getResources().getColor(R.color.white));
            Materialtoolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }

        Bundle intent=getIntent().getExtras();
        if (intent!= null) {
            WorkOrderId = intent.getString("WorkOrderId");
            id = intent.getInt("id");
        }

        etMaterial = (EditText) findViewById(R.id.etMaterial);
        etMaterialDesc = (EditText)findViewById(R.id.etMaterialDesc);
        etQuantity = (EditText)findViewById(R.id.etQuantity);
        etCost = (EditText)findViewById(R.id.etCost);


        btnSave1 = (Button)findViewById(R.id.btnSave1);

        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        btnBack1 = (Button)findViewById(R.id.btnBack1);
        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("workOrderId", WorkOrderId);
                Intent intent = new Intent(MaterialsUsed.this,WorkerWOUpdate.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });




        fetchMaterialEditList();
    }



    private void requestFocus(View view)
    {
        if(view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }


    private void validate() {
        if (etMaterial.getText().toString().trim().isEmpty()) {
            etMaterial.setError("Please Enter  Update Material");
            requestFocus(etMaterial);
        } else if (etQuantity.getText().toString().trim().isEmpty()) {
            etQuantity.setError("Please Enter Update Qunatity");
            requestFocus(etQuantity);
        } else if (etCost.getText().toString().trim().isEmpty()) {
            etCost.setError("Please Enter Update Cost");
            requestFocus(etCost);
        }else if (etMaterialDesc.getText().toString().trim().isEmpty()){
            etMaterialDesc.setError("Please Enter Update Material Description");
        }

        else {
            updateMaterial();
        }


    }


    public void fetchMaterialEditList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<MaterialEditList> loginResponseCall =
                    apiServicesWorkOrder.editmaterialDetails("application/json", "api/WorkMaterial/EditMaterial?id="+id);
            loginResponseCall.enqueue(new Callback<MaterialEditList>() {
                @Override
                public void onResponse(Call<MaterialEditList> call, Response<MaterialEditList> response) {
                    try {
                        int codeStatus = response.code();
                        // TODO NULL CHECK OF RESPONSE
                        MaterialEditList materialEditList = response.body();
                        UpdateMaterialCode=materialEditList.getMaterialUsed();
                        etMaterial.setText(UpdateMaterialCode);
                        UpdateQuantity= String.valueOf(materialEditList.getMaterialQuntity());
                        etQuantity.setText(UpdateQuantity);
                        UpdateCost= String.valueOf(materialEditList.getMaterialCost());
                        etCost.setText(UpdateCost);
                        UpdateMaterialDesc= String.valueOf(materialEditList.getMaterialCost());
                        etMaterialDesc.setText(UpdateMaterialDesc);
                        WorkOrderId= String.valueOf(materialEditList.getWorkOrderId());
                    } catch (Exception e) {
                        Log.v("Error", e.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<MaterialEditList> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }


    public void updateMaterial()
    {
        UpdateMaterialCode=etMaterial.getText().toString().trim();
        UpdateQuantity=etQuantity.getText().toString().trim();
        UpdateCost=etCost.getText().toString().trim();
        MaterialEditList request=new MaterialEditList();
        request.setMaterialUsed(UpdateMaterialCode);
        request.setMaterialQuntity(Integer.parseInt(UpdateQuantity));
        request.setMaterialCost(Integer.parseInt(UpdateCost));
        request.setUpdatedBy(preferenceManagerWorkOrder.getKey_Person_Company_Id());
        request.setId(id);
        request.setWorkOrderId(Integer.parseInt(WorkOrderId));
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<String> loginResponseCall =
                    apiServicesWorkOrder.updateMaterial("application/json", request);
            loginResponseCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    try {
                        int codeStatus = response.code();
                        // TODO NULL CHECK OF RESPONSE
                        String result = response.body();
                        Toast.makeText(getApplicationContext(), "" + result, Toast.LENGTH_SHORT).show();
                        Bundle bundle=new Bundle();
                        bundle.putString("WorkOrderId",WorkOrderId);
                        Intent intent=new Intent(MaterialsUsed.this,WorkerSearchList.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        /*finish();*/
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
}
