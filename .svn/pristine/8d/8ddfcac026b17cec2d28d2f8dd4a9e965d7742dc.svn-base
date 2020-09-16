package com.workorder.app.workorderapplication.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;
import com.workorder.app.search_autocomplete.GeocodingLocation;
import com.workorder.app.search_autocomplete.PlacesAutoCompleteAdapter;
import com.workorder.app.search_autocomplete.Prediction;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.workorderapplication.model.assetModel.AssetCategoryDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.AssetConditionDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.AssetLocationResponse;
import com.workorder.app.workorderapplication.model.assetModel.ContractTypeDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.SubCategoryDropDownList;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.workOrderModel.AreaDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.RegionDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.SubRegionDropDownList;
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

public class Asset1 extends AppCompatActivity {
    Button next;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    List<AreaDropDownList> areaDropDownLists;
    List<ContractTypeDropDownList> contractTypeDropDownLists;
    List<AssetCategoryDropDownList> assetCategoryDropDownLists;
    List<SubCategoryDropDownList> subCategoryDropDownLists;
    List<AssetConditionDropDownList> conditionDropDownLists;
    List<RegionDropDownList> regionDropDownLists;
    List<SubRegionDropDownList> subRegionDropDownLists;
    List<AssetLocationResponse> locationDropDownLists;
    String userrole,companyid,clientId,rolename;
    Spinner contractType,assetCategory,subCategory,assetCondition,region,subRegion,
            location,area;
    EditText et_region,et_sub_region,et_area,et_location_id,et_latitude,et_longitude;
    static EditText conditionDate;
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    AutoCompleteTextView auto_address1;
    EditText et_city,et_state,et_pincode,et_building_name,et_room,et_country;
    EditText assetCode,assetComent;
    String Client,AssetType,AssetStatus,Priority,WarningLevel,LoadDate,ClientNo,AssetId,
            AssetName,Description,ContractNo, ContractType="",AssetCategory,SubCategory,
            AssetCondition,Region,SubRegion,Location="",Area="",ConditionDate,AssetCode,
            AssetComent,BuildingName,Room;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset1);
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
        getSupportActionBar().setTitle("ADD NEW ASSET");
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }
        Bundle intent=getIntent().getExtras();
        if(getIntent()!=null)
        {
            Client=intent.getString("ClientContract");
            AssetType=intent.getString("AssetType");
            AssetStatus=intent.getString("AssetStatus");
            Priority=intent.getString("Priority");
            WarningLevel=intent.getString("WarningLevel");
            ClientNo=intent.getString("ClientNo");
            AssetId=intent.getString("AssetId");
            AssetName=intent.getString("AssetName");
            Description=intent.getString("Description");
            LoadDate=intent.getString("LoadDate");
            ContractNo=intent.getString("ContractNo");
        }
        userrole= preferenceManagerWorkOrder.getKey_User_Role();
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        rolename= preferenceManagerWorkOrder.getKey_User_Name();
        contractType=(Spinner)findViewById(R.id.spinner_contract_type);
        assetCategory=(Spinner)findViewById(R.id.spinner_asset_category);
        subCategory=(Spinner)findViewById(R.id.spinner_sub_category);
        assetCondition=(Spinner)findViewById(R.id.spinner_asset_condition);
       // et_region=findViewById(R.id.et_asset_up_region);
        et_sub_region=findViewById(R.id.et_asset_up_sub_region);
        et_area=findViewById(R.id.et_asset_up_area);
        et_location_id=findViewById(R.id.et_asset_up_location);
        auto_address1=findViewById(R.id.asset_address1);
       // auto_address2=findViewById(R.id.asset_address2);
        et_city=findViewById(R.id.asset_city);
        et_state=findViewById(R.id.asset_state);
        et_pincode=findViewById(R.id.asset_post_code);
        et_latitude=findViewById(R.id.et_asset_latitude);
        et_longitude=findViewById(R.id.et_asset_longitude);
        et_country=findViewById(R.id.asset_country);


        conditionDate=(EditText) findViewById(R.id.condition_date);
        conditionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1(v);
            }
        });
        assetCode=(EditText)findViewById(R.id.asset_code);
        assetComent=(EditText)findViewById(R.id.asset_comments);
        et_building_name=(EditText)findViewById(R.id.asset_building_name);
        et_room=(EditText)findViewById(R.id.asset_room);
        next=(Button) findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   nextEvent();
                //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
        });

        Button pre=(Button) findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Asset1.this,Asset.class);
                Bundle bundle=new Bundle();
                bundle.putString("ClientContract",Client);
                bundle.putString("AssetType",AssetType);
                bundle.putString("AssetStatus",AssetStatus);
                bundle.putString("Priority",Priority);
                bundle.putString("WarningLevel",WarningLevel);
                bundle.putString("ClientNo",ClientNo);
                bundle.putString("AssetId",AssetId);
                bundle.putString("AssetName",AssetName);
                bundle.putString("Description",Description);
                bundle.putString("LoadDate",LoadDate);
                bundle.putString("ContractNo",ContractNo);
                intent.putExtras(bundle);
                startActivity(intent);
             //   overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });
        fetchContractTypeDropDown();
        fetchAssetCategoryDropDown();
        fetchSubCategoryDropDown();
        fetchAssetConditionDropDown();
     //   fetchRegionDropDown();
        //fetchSubRegionDropDown();
       // fetchAreaDropDown();
      //  fetchLocationDropDown();


        loadData();

        auto_address1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("Before","now here");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("textch","before");
            }

            @Override
            public void afterTextChanged(Editable s) {
                GeocodingLocation locationAddress = new GeocodingLocation();
                locationAddress.getAddressFromLocation(auto_address1.getText().toString(),
                        Asset1.this, new GeocoderHandlerfrom());
            }
        });

    }



    private void loadData() {
        List<Prediction> predictions = new ArrayList<>();
        PlacesAutoCompleteAdapter placesAutoCompleteAdapter = new PlacesAutoCompleteAdapter(getApplicationContext(), predictions);

        auto_address1.setThreshold(1);
        auto_address1.setAdapter(placesAutoCompleteAdapter);


        //dtocity.setText();
//      Log.d("PlaceId",Utility.prediction.getPlaceId());
        //placesAutoCompleteAdapter.getItem();


        // autoCompleteTextViewPlace.setOn

    }
    String from_city="",from_country="";
    String to_city="",to_country="";

    private class GeocoderHandlerfrom extends Handler {
        @Override
        public void handleMessage(Message message) {
            try {
                String locationAddress;
                switch (message.what) {
                    case 1:
                        Bundle bundle = message.getData();
                        locationAddress = bundle.getString("address");
                        break;
                    default:
                        locationAddress = null;
                }
                Log.d("logi",locationAddress);
                //autoCompleteTextViewPlace.setText("");

                //locationAddress.length();
                // oaddress.setText(dfromcity.getText().toString());
                String[] address = locationAddress.split(",");
                if(address.length>3) {
                    // ocity.setText(address[0]);
                    // ostate.setText(address[1]);
                    //  ocountry.setText(address[2]);
                    //  opin.setText(address[3]);
                    //start1=address[4];
                    // start2=address[5];
                    // startlat=Double.parseDouble(start1);
                    //startlong=Double.parseDouble(start2);

                    from_city= UtilityFunction.filterAddress(Asset1.this,address[4],address[5],"city");//address[0];
                    Log.d("City",from_city);
                    Constants.FROM_CITY=from_city;
                    et_city.setText(from_city);
                    et_state.setText(UtilityFunction.filterAddress(Asset1.this,address[4],address[5],"state"));
                    et_pincode.setText(UtilityFunction.filterAddress(Asset1.this,address[4],address[5],"pincode"));
                    from_country=UtilityFunction.filterAddress(Asset1.this,address[4],address[5],"country");
                    // Log.d("print",address[i]);
                    et_latitude.setText(address[4]);
                    et_longitude.setText(address[5]);
                    et_country.setText(from_country);

                }
                //  oaddress.setText(ocity.getText().toString()+" ,"+ostate.getText().toString()+" ,"+ocountry.getText().toString());

            }catch (Exception e)
            {
                Log.d("FromCity",e.toString());
            }
        }
    }








    private void nextEvent()
    {
    try {
        if (contractType.getSelectedItem().toString().trim().equals("Select Contract Type")){
            View selectedView = contractType.getSelectedView();
            TextView tv = (TextView) selectedView;
            tv.setError("Select Contract Type");
            requestFocus(tv);
            Toast.makeText(this,"Select Contract Type", Toast.LENGTH_LONG).show();


        }else if(assetCode.getText().toString().trim().isEmpty())
        {
            assetCode.setError("Select Asset Code");
            requestFocus(assetCode);
        }else if(assetComent.getText().toString().trim().isEmpty())
        {
            assetComent.setError("Select Asset Comment");
            requestFocus(assetComent);
        }

        else if(assetCategory.getSelectedItem().toString().trim().equals("Select Category"))
        {
            View selectedView = assetCategory.getSelectedView();
            TextView tv=(TextView) selectedView;
            /*if(tv.getText().toString().trim().equals("Select Category"))*/
            tv.setError("Select Category");
            requestFocus(tv);

            Toast.makeText(Asset1.this, "Please Select Category", Toast.LENGTH_LONG).show();

        }else if(subCategory.getSelectedItem().toString().trim().equals("Select Category"))
        {
            View selectedView = subCategory.getSelectedView();
            TextView tv=(TextView) selectedView;
            /*if(tv.getText().toString().trim().equals("Select Category"))*/
            tv.setError("Select Category");
            requestFocus(tv);

            Toast.makeText(Asset1.this, "Please Select Category", Toast.LENGTH_LONG).show();

        }

        else if(conditionDate.getText().toString().trim().isEmpty())
        {
            conditionDate.setError("Please Enter Condition Date");
            requestFocus(conditionDate);
        }
        else if(assetCondition.getSelectedItem().toString().trim().equals("Select Asset Condition"))
        {
            View selectedView = assetCondition.getSelectedView();
            TextView tv=(TextView) selectedView;
            /*if(tv.getText().toString().trim().equals("Please Select Asset Condition"))*/
            tv.setError("Select Asset Condition");
            requestFocus(tv);

            Toast.makeText(Asset1.this, "Please Select Asset Condition", Toast.LENGTH_LONG).show();

        }else if(et_sub_region.getText().toString().trim().equals(""))
        {
            et_sub_region.requestFocus();

        }
        else if(et_area.getText().toString().equals(""))
        {
           et_area.requestFocus();
           et_area.setError("Please enter area.");
        }else if (et_location_id.getText().toString().equals(""))
        {
              et_location_id.requestFocus();
              et_location_id.setError("Please enter location id.");
        }else if(et_building_name.getText().toString().trim().isEmpty()){
            et_building_name.setError("Please Enter Building Name");
            requestFocus(et_building_name);
        }else if(et_room.getText().toString().trim().isEmpty()){
            et_room.requestFocus();
            et_room.setError("Please Enter Room");
        }else {
            ConditionDate=conditionDate.getText().toString().trim();
            AssetCode=assetCode.getText().toString().trim();
            AssetComent=assetComent.getText().toString().trim();
            BuildingName=et_building_name.getText().toString().trim();
            Room=et_room.getText().toString().trim();

            Constants.createAssetModel.setContractType(ContractType);
            Constants.createAssetModel.setAssetCode(assetCode.getText().toString());
            Constants.createAssetModel.setComments(assetComent.getText().toString());
            Constants.createAssetModel.setAssetCategoryId(AssetCategory);
            Constants.createAssetModel.setAssetSubCategoryId(SubCategory);
            Constants.createAssetModel.setConditionDate(UtilityFunction.ddMMyyyyToMMddyyyy(conditionDate.getText().toString()));
            Constants.createAssetModel.setCondition(AssetCondition);
            Constants.createAssetModel.setRegionId("1");
            Constants.createAssetModel.setSubRegionId(et_sub_region.getText().toString());
            Constants.createAssetModel.setArea(et_area.getText().toString());
            Constants.createAssetModel.setLocationId(et_location_id.getText().toString());
            Constants.createAssetModel.setAddress1(auto_address1.getText().toString());
            Constants.createAssetModel.setAddress2("");
            Constants.createAssetModel.setCity(et_city.getText().toString());
            Constants.createAssetModel.setState(et_state.getText().toString());
            Constants.createAssetModel.setPostcode(et_pincode.getText().toString());
            Constants.createAssetModel.setCountry(et_country.getText().toString());
            Constants.createAssetModel.setLatitude(Double.parseDouble(et_latitude.getText().toString()));
            Constants.createAssetModel.setLongitude(Double.parseDouble(et_longitude.getText().toString()));
            Constants.createAssetModel.setBuildingName(et_building_name.getText().toString());
            Constants.createAssetModel.setRoom(et_room.getText().toString());


            Intent intent=new Intent(Asset1.this,Asset2.class);
            Bundle bundle=new Bundle();
            bundle.putString("ClientContract",Client);
            bundle.putString("AssetType",AssetType);
            bundle.putString("AssetStatus",AssetStatus);
            bundle.putString("Priority",Priority);
            bundle.putString("WarningLevel",WarningLevel);
            bundle.putString("ClientNo",ClientNo);
            bundle.putString("AssetId",AssetId);
            bundle.putString("AssetName",AssetName);
            bundle.putString("Description",Description);
            bundle.putString("ContractType",ContractType);
            bundle.putString("AssetCategory",AssetCategory);
            bundle.putString("SubCategory",SubCategory);
            bundle.putString("AssetCondition",AssetCondition);
            bundle.putString("Region",Region);
            bundle.putString("SubRegion",SubRegion);
            bundle.putString("Location",Location);
            bundle.putString("ConditionDate",ConditionDate);
            bundle.putString("AssetCode",AssetCode);
            bundle.putString("AssetComent",AssetComent);
            bundle.putString("BuildingName",BuildingName);
            bundle.putString("Room",Room);
            bundle.putString("Area",Area);
            bundle.putString("LoadDate",LoadDate);
            bundle.putString("ContractNo",ContractNo);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }catch (Exception e)
    {
        Toast.makeText(this, "Data not found", Toast.LENGTH_SHORT).show();
    }
    }
    private void requestFocus(View view)
    {
        if(view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem refresh = menu.findItem(R.id.menu_refresh);
        refresh.setVisible(false);
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
               // startActivity(new Intent(Asset1.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
              //  finish();
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

    public void fetchContractTypeDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<ContractTypeDropDownList>> listCall= apiServicesWorkOrder.ctDropDownList("application/json","api/assetsdropdown/getcontractType");
            listCall.enqueue(new Callback<List<ContractTypeDropDownList>>() {
                @Override
                public void onResponse(Call<List<ContractTypeDropDownList>> call, Response<List<ContractTypeDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        contractTypeDropDownLists=response.body();
                        showContractTypeDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<ContractTypeDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showContractTypeDropDownList(){
        if(getApplicationContext()!=null)
        {
            String item[]=new String[contractTypeDropDownLists.size()];
            for(int i=0;i<contractTypeDropDownLists.size();i++)
            {
                item[i]=contractTypeDropDownLists.get(i).getText();
            }
          if (item.length>0)
          {
              ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
              adapter.setDropDownViewResource(R.layout.fortitle);
              contractType.setAdapter(adapter);
              contractType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                  @Override
                  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                      ContractType= contractTypeDropDownLists.get(position).getValue();

                  }
                  @Override
                  public void onNothingSelected(AdapterView<?> parent) {
                  }
              });
          }


        }
    }
    public void fetchAssetCategoryDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetCategoryDropDownList>> listCall= apiServicesWorkOrder.assetcatDropDownList("application/json","api/assetsdropdown/getassetcategories");
            listCall.enqueue(new Callback<List<AssetCategoryDropDownList>>() {
                @Override
                public void onResponse(Call<List<AssetCategoryDropDownList>> call, Response<List<AssetCategoryDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        assetCategoryDropDownLists=response.body();
                        showAssetCategoryDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<AssetCategoryDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showAssetCategoryDropDownList()
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[assetCategoryDropDownLists.size()];
            for(int i=0;i<assetCategoryDropDownLists.size();i++)
            {
                item[i]=assetCategoryDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            assetCategory.setAdapter(adapter);
            assetCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AssetCategory= assetCategoryDropDownLists.get(position).getValue();
                    fetchSubCategoryDropDown();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


        }
    }
    public void fetchSubCategoryDropDown()
    {

        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<SubCategoryDropDownList>> listCall= apiServicesWorkOrder.subcatDropDownList("application/json","api/assetsdropdown/getsubassetcategories?assetcategoriesId="+AssetCategory);
            listCall.enqueue(new Callback<List<SubCategoryDropDownList>>() {
                @Override
                public void onResponse(Call<List<SubCategoryDropDownList>> call, Response<List<SubCategoryDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        subCategoryDropDownLists=response.body();
                        showSubCategoryDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<SubCategoryDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showSubCategoryDropDownList()
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[subCategoryDropDownLists.size()];
            for(int i=0;i<subCategoryDropDownLists.size();i++)
            {
                item[i]=subCategoryDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            subCategory.setAdapter(adapter);
            subCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SubCategory= subCategoryDropDownLists.get(position).getValue();

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


        }
    }
    public void fetchAssetConditionDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetConditionDropDownList>> listCall= apiServicesWorkOrder.conditionDropDownList("application/json","api/assetsdropdown/getassetcondition");
            listCall.enqueue(new Callback<List<AssetConditionDropDownList>>() {
                @Override
                public void onResponse(Call<List<AssetConditionDropDownList>> call, Response<List<AssetConditionDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        conditionDropDownLists=response.body();
                        showAssetConditionDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<AssetConditionDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showAssetConditionDropDownList()
    {
        if(getApplicationContext()!=null)
        {
            String item[]=new String[conditionDropDownLists.size()];
            for(int i=0;i<conditionDropDownLists.size();i++)
            {
                item[i]=conditionDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            assetCondition.setAdapter(adapter);
            assetCondition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AssetCondition= conditionDropDownLists.get(position).getValue();

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


        }
    }
    public void fetchRegionDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<RegionDropDownList>> ListCall= apiServicesWorkOrder.regiondropdown("application/json","api/assetsdropdown/getregion");
            ListCall.enqueue(new Callback<List<RegionDropDownList>>() {
                @Override
                public void onResponse(Call<List<RegionDropDownList>> call, Response<List<RegionDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        regionDropDownLists=response.body();
                        showRegionDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<RegionDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showRegionDropDownList()
    {
        if(getApplicationContext()!=null){
            String item[]=new String[regionDropDownLists.size()];
            for(int i=0;i<regionDropDownLists.size();i++)
            {
                item[i]=regionDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            region.setAdapter(adapter);
            region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Region=regionDropDownLists.get(position).getValue();
                    fetchSubRegionDropDown();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
    }
    public void fetchSubRegionDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<SubRegionDropDownList>> ListCall= apiServicesWorkOrder.subregionorderdropdown("application/json","api/assetsdropdown/getsubregionb?regionId="+Region);
            ListCall.enqueue(new Callback<List<SubRegionDropDownList>>() {
                @Override
                public void onResponse(Call<List<SubRegionDropDownList>> call, Response<List<SubRegionDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        subRegionDropDownLists=response.body();
                        showSubRegionDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<SubRegionDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public  void showSubRegionDropDownList()
    {
        if(getApplicationContext()!=null) {
            String item[]=new String[subRegionDropDownLists.size()];
            for(int i=0;i<subRegionDropDownLists.size();i++)
            {
                item[i]=subRegionDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            subRegion.setAdapter(adapter);
            subRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SubRegion=subRegionDropDownLists.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    public void fetchAreaDropDown()
    {
        if(UtilityWorkOrder.isNetworkAvailable(getApplicationContext()))
        {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AreaDropDownList>> ListCall= apiServicesWorkOrder.areadropdown("application/json","api/assetsdropdown/getarea");
            ListCall.enqueue(new Callback<List<AreaDropDownList>>() {
                @Override
                public void onResponse(Call<List<AreaDropDownList>> call, Response<List<AreaDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        areaDropDownLists=response.body();
                        showAreaDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<AreaDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });

        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showAreaDropDownList()
    {
        String item[]=new String[areaDropDownLists.size()];
        for(int i=0;i<areaDropDownLists.size();i++)
        {
            item[i]=areaDropDownLists.get(i).getText();

        }
        if (item.length>0)
        {
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            area.setAdapter(adapter);
            area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Area=areaDropDownLists.get(position).getValue();
                    fetchLocationDropDown();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    public void fetchLocationDropDown()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetLocationResponse>> ListCall= apiServicesWorkOrder.locationdropdown("application/json","api/assetsdropdown/getlocation?regionid="+Region+"&subRegionId="+SubRegion+"&AreaId="+Area+"&ClientId="+ClientNo);
            ListCall.enqueue(new Callback<List<AssetLocationResponse>>() {
                @Override
                public void onResponse(Call<List<AssetLocationResponse>> call, Response<List<AssetLocationResponse>> response) {
                    if(response.body()!=null)
                    {
                        locationDropDownLists=response.body();
                        showLocationDropDown();
                    }
                }

                @Override
                public void onFailure(Call<List<AssetLocationResponse>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    public void showLocationDropDown()
    {

        String item[]=new String[locationDropDownLists.size()];
        for(int i=0;i<locationDropDownLists.size();i++)
        {
            item[i]=locationDropDownLists.get(i).getSiteName();
            // item[i]=locationDropDownLists.get(i).getValue();
        }
     if (item.length>0)
     {
         ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
         adapter.setDropDownViewResource(R.layout.fortitle);
         location.setAdapter(adapter);
         location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 Location= String.valueOf(locationDropDownLists.get(position).getId());
                 String loc=locationDropDownLists.get(position).getBuildingName();
                 et_building_name.setText(loc);
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });
     }
    }
    public void showDatePickerDialog1(View v){
        DialogFragment newFragment = new DatePickerFragment1();
        newFragment.show(getSupportFragmentManager(), "datePicker");
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

            String date =months  + "-" + days + "-" + year;
            conditionDate.setText(date);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
