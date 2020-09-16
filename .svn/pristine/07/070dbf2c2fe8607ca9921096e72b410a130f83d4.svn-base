package com.workorder.app.workorderapplication.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.workorder.app.R;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.workorderapplication.model.assetModel.AssetCreateResponsePOJO;
import com.workorder.app.workorderapplication.model.assetModel.AssetRequestModel;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Asset6 extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    EditText et_parts_warranty_entered_date;
    EditText et_labour_warranty_entered_start;
    EditText et_parts_entered_by;
    EditText et_labour_warranty_entered_end;
    EditText et_warranty_comment;
    EditText et_labour_warranty_enntered_by;
    EditText et_labour_warranty_entered_date;
    EditText et_drawing_no;
    EditText et_om_link;

    String entered_by="";
    String pw_entered_dt="";
    String lw_entered_start="";
    String lw_entered_end="";
    String warrenty_comment="";
    String lw_entered_by="";
    String lw_entered_dt="";
    String drawing_no="";
    String om_link="";

    Button btn_prev;
    Button btn_submit;
    String Client,AssetType,AssetStatus,Priority,WarningLevel,LoadDate,ClientNo,AssetId,AssetName,Description,ContractNo,
            ContractType,AssetCategory,SubCategory,AssetCondition,Region,SubRegion,Location,Area,ConditionDate,AssetCode,
            AssetComent,BuildingName,Room,ReactiveCriticality,InspectionFrequency,NextInspectionDate,LastInspectionDate,RoomName
            ,Floor,AssetUse,EnergyRating,InspectionProcedureResult
            ,InspectionComments,MaintenanceStrategy,MaintenanceFrequency,NextMaintenanceDate,
            LastMaintenanceDate,MaintenanceProcedureResult,MaintenanceComments,
            SupplierName,ComponentOfAsset,OldAsset,SupplierId,OrderNumber,QualityLifeExpectancy,
            ComDescription,DateInstalled,ReplacementDate,ComissionDate,DeComissionDate,ComComissionDate,
            ComDateDeComission,WarrantyStart,WarrantyEnd,EstMaintenance,PurchaseCost,ExpectReplaceCost,Manufacturer,MakeYear,
            Model,SerialNo,BarCode,PartsWarrantyLengthMonth,PartsWarrantyLengthYear,PartsWarrantyComments;
    boolean StatutoryMaintenance,SubComponent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset6);
        et_parts_entered_by=findViewById(R.id.et_entered_by);
        et_parts_warranty_entered_date=findViewById(R.id.et_pw_date_enter);
        et_labour_warranty_entered_start=findViewById(R.id.et_lw_start);
        et_labour_warranty_entered_end=findViewById(R.id.et_lw_end);
        et_warranty_comment=findViewById(R.id.et_warranty_comments);
        et_labour_warranty_enntered_by=findViewById(R.id.et_lw_enteredBy);
        et_labour_warranty_entered_date=findViewById(R.id.et_lw_date_enter);
        et_drawing_no=findViewById(R.id.et_drawing_number);
        et_om_link=findViewById(R.id.et_om_link);
        btn_prev=findViewById(R.id.btn_previous);
        btn_submit=findViewById(R.id.btn_submit);

        Bundle intent=getIntent().getExtras();
        if(intent!=null)
        {
            InspectionComments=intent.getString("InspectionComments");
            Client=intent.getString("ClientContract");
            AssetType=intent.getString("AssetType");
            AssetStatus=intent.getString("AssetStatus");
            Priority=intent.getString("Priority");
            WarningLevel=intent.getString("WarningLevel");
            LoadDate=intent.getString("LoadDate");
            ClientNo=intent.getString("ClientNo");
            AssetId=intent.getString("AssetId");
            AssetName=intent.getString("AssetName");
            Description=intent.getString("Description");
            ContractNo=intent.getString("ContractNo");
            ContractType=intent.getString("ContractType");
            AssetCategory=intent.getString("AssetCategory");
            SubCategory=intent.getString("SubCategory");
            AssetCondition=intent.getString("AssetCondition");
            Region=intent.getString("Region");
            SubRegion=intent.getString("SubRegion");
            Location=intent.getString("Location");
            Area=intent.getString(  "Area");
            ConditionDate=intent.getString("ConditionDate");
            AssetCode=intent.getString("AssetCode");
            AssetComent=intent.getString("AssetComent");
            BuildingName=intent.getString("BuildingName");
            Room=intent.getString("Room");
            ReactiveCriticality=intent.getString("ReactiveCriticality");
            InspectionFrequency=intent.getString("InspectionFrequency");
            NextInspectionDate=intent.getString("NextInspectionDate");
            LastInspectionDate=intent.getString("LastInspectionDate");
            RoomName=intent.getString("RoomName");
            Floor=intent.getString("Floor");
            AssetUse=intent.getString("AssetUse");
            EnergyRating=intent.getString("EnergyRating");
            MaintenanceStrategy=intent.getString("MaintenanceStrategy");
            MaintenanceFrequency=intent.getString("MaintenanceFrequency");
            NextMaintenanceDate=intent.getString("NextMaintenanceDate");
            LastMaintenanceDate=intent.getString("LastMaintenanceDate");
            MaintenanceProcedureResult=intent.getString("MaintenanceProcedureResult");
            MaintenanceComments=intent.getString("MaintenanceComments");
            StatutoryMaintenance=intent.getBoolean("StatutoryMaintenance");
            InspectionProcedureResult=intent.getString("InspectionProcedureResult");
            SupplierName=intent.getString("SupplierName");
            ComponentOfAsset=intent.getString("ComponentOfAsset");
            OldAsset=intent.getString("OldAsset");
            SupplierId=intent.getString("SupplierId");
            OrderNumber=intent.getString("OrderNumber");
            QualityLifeExpectancy=intent.getString("QualityLifeExpectancy");
            ComDescription=intent.getString("ComDescription");
            DateInstalled=intent.getString("DateInstalled");
            ReplacementDate=intent.getString("ReplacementDate");
            ComissionDate=intent.getString("ComissionDate");
            DeComissionDate=intent.getString("DeComissionDate");
            ComComissionDate=intent.getString("ComComissionDate");
            InspectionProcedureResult=intent.getString("InspectionProcedureResult");
            SubComponent=intent.getBoolean("SubComponent");
            ComDateDeComission=intent.getString("ComDateDeComission");
            WarrantyStart=intent.getString("WarrantyStart");
            WarrantyEnd=intent.getString("WarrantyEnd");
            EstMaintenance=intent.getString("EstMaintenance");
            PurchaseCost=intent.getString("PurchaseCost");
            ExpectReplaceCost=intent.getString("ExpectReplaceCost");
            Manufacturer=intent.getString("Manufacturer");
            MakeYear=intent.getString("MakeYear");
            Model=intent.getString("Model");
            SerialNo=intent.getString("SerialNo");
            BarCode=intent.getString("BarCode");
            PartsWarrantyLengthMonth=intent.getString("PartsWarrantyLengthMonth");
            PartsWarrantyLengthYear=intent.getString("PartsWarrantyLengthYear");
            PartsWarrantyComments=intent.getString("PartsWarrantyComments");
        }

        request=new AssetRequestModel();
        request.setClient(Client);
        request.setAssetType(AssetType);
        request.setEntityStatus("1");
        request.setPriority(Priority);
        request.setWarningLevel(WarningLevel);
       // request.setUpdatedDate();
        request.setClientNo(ClientNo);

        request.setAsset_ID(AssetId);
        request.setAssetName(AssetName);
        request.setDescription(Description);
        request.setContractNo(ContractNo);
        request.setContractType(ContractType);
        request.setAssetType(AssetType);
        request.setAssetSubCategoryId(SubCategory);
        request.setCondition(AssetCondition);
        request.setRegionId(Region);
        request.setSubRegionId(SubRegion);
        request.setLocationId(Location);
        request.setArea(Area);
        request.setConditionDate(ConditionDate);
        request.setAssetCode(AssetCode);
        request.setComments(AssetComent);
        request.setBuildingName(BuildingName);
        request.setRoom(Room);
        request.setCriticality(ReactiveCriticality);
        request.setInspectionFrequency(InspectionFrequency);
        request.setNextInspectionDate(NextInspectionDate);
        request.setLastInspectionDate(LastInspectionDate);
        request.setRoomName(RoomName);
        request.setFloor(Floor);
        request.setAssetUse(AssetUse);
        request.setEnergyRating(EnergyRating);
        request.setInspectionProcedureResult(InspectionProcedureResult);
        request.setInspectionComments(InspectionComments);
        request.setStrategy(MaintenanceStrategy);
        request.setMaintenaceFrequency(MaintenanceFrequency);
        request.setNextMaintenanceDate(NextMaintenanceDate);
        request.setLastMaintenanceDate(LastMaintenanceDate);
        request.setMaintenanceProcedureResult(MaintenanceProcedureResult);
        request.setMaintenanceComments(MaintenanceComments);
        request.setSupplierName(SupplierName);
        request.setSubComponentId(ComponentOfAsset);
        request.setOldAssetID(OldAsset);
        request.setSupplierId(SupplierId);
        request.setOrderNumber(OrderNumber);
        request.setQuaLifeExpectancy(QualityLifeExpectancy);
        request.setComponentDescription(ComDescription);
        request.setDateInstalled(DateInstalled);
        request.setReplacementDate(ReplacementDate);
        request.setCommissioned(ComissionDate);
        request.setDecommissioned(DeComissionDate);
        request.setComCommissioned(ComComissionDate);
        request.setComDecommissioned(ComDateDeComission);
        request.setLabourWarrantyStartDate(WarrantyStart);
        request.setLabourWarrantyEndDate(WarrantyEnd);
        request.setEstMaintenanceCost(EstMaintenance);
        request.setPurchaseCost(PurchaseCost);
        request.setExpectedReplacementCost(ExpectReplaceCost);
        request.setManufacturer(Manufacturer);
        request.setMake(MakeYear);
        request.setModelNo(Model);
        request.setSerialNo(SerialNo);
        request.setBarCode(BarCode);
        request.setWarrantyLengthInMonth(PartsWarrantyLengthMonth);
        request.setWarrantyLengthInYear(PartsWarrantyLengthYear);
        request.setPartsWarrantyComments(PartsWarrantyComments);
    /*    request.setLabourWarrantyDateEntered(PartyWarrantyDateEntered);
        request.setLabourWarrantyStartDate(LabourWarrantyStart);
        request.setLabourWarrantyEndDate(LabourWarrantyEnd);
        request.setPartsWarrantyEnterBy(PartsWarrantyEnteredBy);
        request.setLabourWarrantyComments(WarrantyComments);
        request.setDrawingNumber(DrwaingNumber);
        request.setOMLink(OmLink);
        request.setLabourWarrantyEnterBy(LabourWarrantyEnteredBy);
        request.setLabourWarrantyDateEntered(LabourWarrantyDateEntered);*/
        request.setStatutoryMaintenance(StatutoryMaintenance);
        request.setSubComponent(SubComponent);



        setListner();
    }

    public void setListner()
    {
        et_parts_warranty_entered_date.setOnClickListener(this);
        et_labour_warranty_entered_start.setOnClickListener(this);
        et_labour_warranty_entered_end.setOnClickListener(this);
        et_labour_warranty_entered_date.setOnClickListener(this);
        btn_prev.setOnClickListener(this);
        btn_submit.setOnClickListener(this);

    }

   AssetRequestModel request;
    ProgressDialog progressDialog;
    public void callCreateAssetApi()
    {
        if (UtilityFunction.isNetworkAvailable(this))
        {
            progressDialog=new ProgressDialog(this);
            progressDialog.setMessage("Please Wait.");
            progressDialog.setCancelable(false);
            progressDialog.show();
        ApiServicesWorkOrder apiServicesWorkOrder=NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
        final Call<AssetCreateResponsePOJO> createAssetResponse=apiServicesWorkOrder.createAsset("application/json",Constants.createAssetModel);
        createAssetResponse.enqueue(new Callback<AssetCreateResponsePOJO>() {
            @Override
            public void onResponse(Call<AssetCreateResponsePOJO> call, Response<AssetCreateResponsePOJO> response) {
                try {
                    int codeStatus=response.code();
                    // TODO NULL CHECK OF RESPONSE
                   // String result=response.body();

                    Log.d("Result",response.body().toString());
                    //Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(Asset6.this,SearchAsset.class));

                  //  Toast.makeText(Asset6.this, ""+result, Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                    if (response.body().getMsg().equals("Asset Created Successfully"))
                    {
                        Toast.makeText(Asset6.this, ""+response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Asset6.this,SearchAsset.class);
                        startActivity(intent);
                        finishAffinity();
                    }else {
                        Toast.makeText(Asset6.this, ""+response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }


               } catch (Exception e) {
                    Log.d("Error",e.getMessage());
                    Toast.makeText(Asset6.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<AssetCreateResponsePOJO> call, Throwable t) {
                t.printStackTrace();
                progressDialog.dismiss();
                Toast.makeText(Asset6.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
               // System.out.println(t.getMessage() + t.getLocalizedMessage());
            }
        });
        }else {
            Toast.makeText(this, "Network not available.", Toast.LENGTH_SHORT).show();
        }
    }

  /*  public void callUpdateAssetApi()
    {

        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<String> loginResponseCall =
                    apiServicesWorkOrder.updateAsset("application/json",request);
            loginResponseCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    try {
                        int codeStatus=response.code();
                        // TODO NULL CHECK OF RESPONSE
                        String result=response.body();

                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(UpdateAsset6.this,SearchAsset.class));
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
    }*/


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.et_pw_date_enter:
                et_date=et_parts_warranty_entered_date;
                openDatePicker();
                break;
            case R.id.et_lw_start:
                et_date=et_labour_warranty_entered_start;
                openDatePicker();
                break;
            case R.id.et_lw_end:
                et_date=et_labour_warranty_entered_end;
                openDatePicker();
                break;
            case R.id.et_lw_date_enter:
                et_date=et_labour_warranty_entered_date;
                openDatePicker();
                break;
            case R.id.btn_previous:
                onBackPressed();
                finish();
            case R.id.btn_submit:
                entered_by=et_parts_entered_by.getText().toString().trim();
                pw_entered_dt=et_parts_warranty_entered_date.getText().toString().trim();
                lw_entered_start=et_labour_warranty_entered_start.getText().toString().trim();
                lw_entered_end=et_labour_warranty_entered_end.getText().toString().trim();
                warrenty_comment=et_warranty_comment.getText().toString().trim();
                lw_entered_by=et_labour_warranty_enntered_by.getText().toString().trim();
                lw_entered_dt=et_labour_warranty_entered_date.getText().toString().trim();
                drawing_no=et_drawing_no.getText().toString().trim();
                om_link=et_om_link.getText().toString().trim();
                if (entered_by.equals(""))
                {
                    et_parts_entered_by.requestFocus();
                    et_parts_entered_by.setError("Please enter parts entered by");
                }else if (pw_entered_dt.equals(""))
                {
                    et_parts_warranty_entered_date.requestFocus();
                    et_parts_warranty_entered_date.setError("Please enter date");
                }else if (lw_entered_start.equals(""))
                {
                    et_labour_warranty_entered_start.requestFocus();
                    et_labour_warranty_entered_start.setError("Please enter start date");
                }else if (lw_entered_end.equals(""))
                {
                    et_labour_warranty_entered_end.requestFocus();
                    et_labour_warranty_entered_end.setError("Please enter end date");
                }else if (lw_entered_by.equals(""))
                {
                    et_labour_warranty_enntered_by.requestFocus();
                    et_labour_warranty_enntered_by.setError("Please enter parts entered by");
                }else if (lw_entered_dt.equals(""))
                {
                    et_labour_warranty_entered_date.requestFocus();
                    et_labour_warranty_entered_date.setError("Please enter entered date");
                }else if (drawing_no.equals(""))
                {
                    et_drawing_no.requestFocus();
                    et_drawing_no.setError("Please enter drawing number");
                }else if (om_link.equals(""))
                {
                    et_om_link.requestFocus();
                    et_om_link.setError("Please enter om link");
                }else {

                /*    /////****************** Extra Field  **********************************
                    Constants.createAssetModel.setQtyLife(null);
                    int no_of_days=UtilityFunction.getDaysDifference(UtilityFunction.convertStringToDate(Constants.createAssetModel.getPartsWarrantyStartDate()),UtilityFunction.convertStringToDate(Constants.createAssetModel.getWarrantyExpiration()));
                    Constants.createAssetModel.setWarrantyLength(""+no_of_days);
                    Constants.createAssetModel.setPersonId(0);
                    Constants.createAssetModel.setEntityStatus(0);*/

                    Constants.createAssetModel.setPartsWarrantyEnterBy(entered_by);
                    Constants.createAssetModel.setPartsWarrantyDateEntered(pw_entered_dt);
                    Constants.createAssetModel.setLabourWarrantyStartDate(lw_entered_start);
                    Constants.createAssetModel.setLabourWarrantyEndDate(lw_entered_end);
                    Constants.createAssetModel.setLabourWarrantyComments(warrenty_comment);
                    Constants.createAssetModel.setLabourWarrantyEnterBy(lw_entered_by);
                    Constants.createAssetModel.setLabourWarrantyDateEntered(lw_entered_dt);
                    Constants.createAssetModel.setDrawingNumber(drawing_no);
                    Constants.createAssetModel.setOmLink(om_link);
                    Constants.createAssetModel.setUserName(Constants.loginPOJO.getUsername());
                    Constants.createAssetModel.setPersonId(Integer.parseInt(Constants.loginPOJO.getPersonCompanyId()));

                    callCreateAssetApi();


                }
                break;



        }
    }

    String selected_date = "";
    boolean is_custom_DT = false;
    EditText et_date, et_time;

    public void openDatePicker() {
        Calendar now = Calendar.getInstance();

        DatePickerDialog dpd = DatePickerDialog.newInstance(
                Asset6.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );


        dpd.show(this.getFragmentManager(), "Datepickerdialog");
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        String month = "";
        String day = "";
        if ((monthOfYear + 1) < 10) {
            month = "0" + (monthOfYear + 1);
        } else {
            month = String.valueOf(monthOfYear + 1);
        }

        if (dayOfMonth < 10) {
            day = "0" + dayOfMonth;
        } else {
            day = String.valueOf(dayOfMonth);
        }

        String date = month  + "-" +day  + "-" + year;
        selected_date = date;



        et_date.setText(date);

        //  et_date.setText(UtilityFunction.changeDateFormat(date));

        //  et_movement_date.setText(UtilityFunction.changeDateFormat(date));
    }
}
