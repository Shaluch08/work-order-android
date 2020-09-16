package com.workorder.app.workorderapplication.activity;

import android.content.Intent;
import android.os.Bundle;
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
import com.workorder.app.workorderapplication.model.materialModel.MaterialEditList;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateMaterialUsed extends AppCompatActivity {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    EditText updatematerial,updatequnatity,updatecost;
    String updateMaterial,updateQunatity,updateCost,WorkOrderId;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    int  id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_material_used);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
        {
            ArrayList<Treestuctutr> list= (ArrayList<Treestuctutr>) getIntent().getSerializableExtra("list");
            arrayList=list;
        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
            ArrayList<ContrctTree> contrctTreeArrayList=(ArrayList<ContrctTree>)getIntent().getSerializableExtra("contrctTreeList");
            contrctTrees=contrctTreeArrayList;
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Update Material Used");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }
        Bundle intent=getIntent().getExtras();
        if (intent!= null) {
            WorkOrderId = intent.getString("WorkOrderId");
            id = intent.getInt("id");
        }

        updatematerial= (EditText) findViewById(R.id.create_material);
        updatequnatity= (EditText) findViewById(R.id.create_quantity);
        updatecost= (EditText) findViewById(R.id.create_cost);
        Button submit= (Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
              //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
    private void validate()
    {
        if(updatematerial.getText().toString().trim().isEmpty())
        {
            updatematerial.setError("Please Enter  Update Material");
            requestFocus(updatematerial);
        }else  if(updatequnatity.getText().toString().trim().isEmpty())
        {
            updatequnatity.setError("Please Enter Update Qunatity");
            requestFocus(updatequnatity);
        }else  if(updatecost.getText().toString().trim().isEmpty())
        {
            updatecost.setError("Please Enter Update Cost");
            requestFocus(updatecost);
        }else {
            updateMaterial();
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
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
                        updateMaterial=materialEditList.getMaterialUsed();
                        updatematerial.setText(updateMaterial);
                        updateQunatity= String.valueOf(materialEditList.getMaterialQuntity());
                        updatequnatity.setText(updateQunatity);
                        updateCost= String.valueOf(materialEditList.getMaterialCost());
                        updatecost.setText(updateCost);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_dashboard:
                Toast.makeText(this, "DashBoard", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),Dashboard.class));
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
    public void updateMaterial()
    {
        updateMaterial=updatematerial.getText().toString().trim();
        updateQunatity=updatequnatity.getText().toString().trim();
        updateCost=updatecost.getText().toString().trim();
        MaterialEditList request=new MaterialEditList();
        request.setMaterialUsed(updateMaterial);
        request.setMaterialQuntity(Integer.parseInt(updateQunatity));
        request.setMaterialCost(Integer.parseInt(updateCost));
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
                        Intent intent=new Intent(UpdateMaterialUsed.this,MaterialUsedList.class);
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
