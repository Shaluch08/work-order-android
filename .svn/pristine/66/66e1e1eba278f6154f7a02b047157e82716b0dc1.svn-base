package com.workorder.app.workorderapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.workorder.app.workorderapplication.model.assetModel.AssetLocationResponse;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.model.workOrderModel.AreaDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.BuildingDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.FloorDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.RegionDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.RoomDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.SubRegionDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderPostResquest;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Work_Order1 extends AppCompatActivity {
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    List<RegionDropDownList> regionDropDownLists;
    List<AreaDropDownList> areaDropDownLists;
    List<AssetLocationResponse> locationDropDownLists;
    List<BuildingDropDownList> buildingDropDownLists;
    List<SubRegionDropDownList> subRegionDropDownLists;
    List<FloorDropDownList> floorDropDownLists;
    List<RoomDropDownList> roomDropDownLists;
    EditText et_city,et_state;
    AutoCompleteTextView et_address1;
    EditText et_room,et_region,et_subRegion,et_area,et_location,et_buildingName,et_floor,et_assetId;
    EditText et_post_cost,et_country;
    EditText et_latitude;
    EditText et_longitude;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String rolename,companyid;
    String regionId,subRegionId,AreaId,location_id,building_Name,floor_Name,
             postcode,stat,cit,addrss,roomno;

    boolean clientaprov;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work__order1);
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
        if (intent != null) {
            /*clientId=intent.getString("clientId");
            clientNo=intent.getString("clientNo");
            poNo=intent.getString("poNo");
            workOrderNo=intent.getString("workOrderNo");
            warning=intent.getString("warning");
            orderstatus=intent.getString("orderstatus");
            priorty=intent.getString("priorty");
            ordertype=intent.getString("ordertype");
            clientorderNo=intent.getString("clientorderNo");
            dateraised=intent.getString("dateraised");
            duedate=intent.getString("duedate");
            originalorder=intent.getString("originalorder");
            clientaproveddate=intent.getString("clientaproveddate");
            desciption=intent.getString("desciption");
            clientaproveby=intent.getString("clientaproveby");
            requestby=intent.getString("requestby");
            assetID = intent.getString("assetID");
            clientaprov=intent.getBoolean("clientaprov");*/
        }


        et_state=(EditText)findViewById(R.id.state);
        et_city=(EditText)findViewById(R.id.city);
        et_address1=findViewById(R.id.address1);
      //  et_address2=findViewById(R.id.address2);
        rolename= preferenceManagerWorkOrder.getKey_User_Role();
        companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
        et_room=findViewById(R.id.et_wo_up_room);
        //et_region=findViewById(R.id.et_wo_up_region);
        et_subRegion=findViewById(R.id.et_wo_up_sub_region);
        et_area=findViewById(R.id.et_wo_up_area);
        et_location=findViewById(R.id.et_wo_up_location);
        et_buildingName=findViewById(R.id.et_wo_up_building_name);
        et_floor=findViewById(R.id.et_wo_up_floor);
        et_post_cost=findViewById(R.id.et_post_code);
        et_country=findViewById(R.id.et_country);
        et_latitude=findViewById(R.id.et_latitude);
        et_longitude=findViewById(R.id.et_longitude);
        /*assetId=(Spinner)findViewById(R.id.spinner_asset_id);*/
        Button next=(Button) findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextEvent();
            //    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        Button pre=(Button) findViewById(R.id.btn_previous);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            //   Intent intent=new Intent(Work_Order1.this,WorkOrder1.class);
               /* Bundle bundle = new Bundle();
                bundle.putString("clientId",clientId);
                bundle.putString("clientNo",clientNo);
                bundle.putString("poNo",poNo);
                bundle.putString("workOrderNo",workOrderNo);
                bundle.putString("warning",warning);
                bundle.putString("orderstatus",orderstatus);
                bundle.putString("priorty",priorty);
                bundle.putString("ordertype",ordertype);
                bundle.putString("duedate",duedate);
                bundle.putString("clientorderNo",clientorderNo);
                bundle.putString("dateraised",dateraised);
                bundle.putString("originalorder",originalorder);
                bundle.putString("requestby",requestby);
                bundle.putString("clientaproveddate",clientaproveddate);
                bundle.putString("desciption",desciption);
                bundle.putBoolean("clientaprov",clientaprov);
                bundle.putString("clientaproveby",clientaproveby);
                intent.putExtras(bundle);*/
             //   startActivity(intent);
             //   overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_rigth);
            }
        });
       /* fetchRegionDropDownList();
        fetchAreaDropDownList();
        fetchLocationDropDownList();
        fetchBuildingDropDownList();
        *//*fetchAssetDropDownList();*//*
        fetchSubRegionDropDownList();
        fetchFloorDropDownList();
        fetchRoomDropDownList();*/

        loadData();

        et_address1.addTextChangedListener(new TextWatcher() {
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
                locationAddress.getAddressFromLocation(et_address1.getText().toString(),
                        Work_Order1.this, new GeocoderHandlerfrom());
            }
        });



    }
    private void requestFocus(View view)
    {
        if(view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }
    private void loadData() {
        List<Prediction> predictions = new ArrayList<>();
        PlacesAutoCompleteAdapter placesAutoCompleteAdapter = new PlacesAutoCompleteAdapter(getApplicationContext(), predictions);

        et_address1.setThreshold(1);
        et_address1.setAdapter(placesAutoCompleteAdapter);


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

                    from_city= UtilityFunction.filterAddress(Work_Order1.this,address[4],address[5],"city");//address[0];
                    Log.d("City",from_city);
                    Constants.FROM_CITY=from_city;
                    et_city.setText(from_city);
                    et_state.setText(UtilityFunction.filterAddress(Work_Order1.this,address[4],address[5],"state"));
                    et_post_cost.setText(UtilityFunction.filterAddress(Work_Order1.this,address[4],address[5],"pincode"));
                    from_country=UtilityFunction.filterAddress(Work_Order1.this,address[4],address[5],"country");
                    et_country.setText(address[2]);
                    // Log.d("print",address[i]);
                    et_latitude.setText(address[4]);
                    et_longitude.setText(address[5]);

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
           if(et_buildingName.getText().toString().equals("")){
               et_buildingName.requestFocus();
               et_buildingName.setError("Please enter Building name");
         /*   View v= building.getSelectedView();
            TextView tv= (TextView) v;
            if(tv.getText().toString().trim().equals("Select Building Name")){
                tv.setError("Please Select Building Name");
            }
            Toast.makeText(this, "Please Select Building Name", Toast.LENGTH_SHORT).show();*/
        }
        else if(et_floor.getText().toString().equals("")) {
            et_floor.requestFocus();
            et_floor.setError("Please enter Floor");
      /*      View v = floor.getSelectedView();
            TextView tv = (TextView) v;
            if (tv.getText().toString().trim().equals("Select Floor")) {
                tv.setError("Please Select Floor");
            }*/
          //  Toast.makeText(this, "Please Select Floor", Toast.LENGTH_SHORT).show();
        }else if(et_address1.getText().toString().trim().isEmpty())        {
          et_state.requestFocus();
            et_address1.setError("Please Enter Address");

        }else if(et_city.getText().toString().trim().isEmpty()){
            et_city.requestFocus();
            et_city.setError("Please Enter City");

        }else if(et_state.getText().toString().trim().isEmpty()){
           et_state.requestFocus();
            et_state.setError("Please Enter State");

        }else if(et_post_cost.getText().toString().trim().isEmpty()){
            et_post_cost.setError("Please Enter Post Code");
            requestFocus(et_post_cost);
        }else {

               postcode=et_post_cost.getText().toString();
               stat=et_state.getText().toString();
               cit=et_city.getText().toString();
               addrss=et_address1.getText().toString();


               Constants.workOrderPostResquest.setSiteName("");
               Constants.workOrderPostResquest.setRegionId("1");
               Constants.workOrderPostResquest.setSubRegionId(et_subRegion.getText().toString());
               Constants.workOrderPostResquest.setArea(et_area.getText().toString());
               Constants.workOrderPostResquest.setLocationId(et_location.getText().toString());
               Constants.workOrderPostResquest.setBuildingname(et_buildingName.getText().toString());
               Constants.workOrderPostResquest.setFloorNo(et_floor.getText().toString());
               Constants.workOrderPostResquest.setRoom(et_room.getText().toString());
               Constants.workOrderPostResquest.setAddress1(et_address1.getText().toString());
               Constants.workOrderPostResquest.setAddress2("");
               Constants.workOrderPostResquest.setWorkCity(et_city.getText().toString());
               Constants.workOrderPostResquest.setWorkState(et_state.getText().toString());
               Constants.workOrderPostResquest.setWorkPostCode(et_post_cost.getText().toString());
               Constants.workOrderPostResquest.setWorkCountry(et_country.getText().toString());
               Constants.workOrderPostResquest.setLatitude(et_latitude.getText().toString());
               Constants.workOrderPostResquest.setLongitude(et_longitude.getText().toString());
               Constants.workOrderPostResquest.setWorkCountry(from_country);




             /*Constants.workOrderPostResquest=new WorkOrderPostResquest();
               Constants.workOrderPostResquest.setRoom(et_room.getText().toString());
               Constants.workOrderPostResquest.setRegionId(et_region.getText().toString());
               Constants.workOrderPostResquest.setSubRegionId(et_subRegion.getText().toString());
               Constants.workOrderPostResquest.setLocationId(et_location.getText().toString());
               Constants.workOrderPostResquest.setBuildingName(et_buildingName.getText().toString());
               Constants.workOrderPostResquest.setFloor(et_floor.getText().toString());
               Constants.workOrderPostResquest.setArea(et_area.getText().toString());*/



            Intent intent=new Intent(Work_Order1.this,Work_Order2.class);


            startActivity(intent);
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
    private void fetchRoomDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<RoomDropDownList>> ListCall= apiServicesWorkOrder.roomdropdown("application/json","api/dropdown/room?rolename="+rolename+"&companyid="+companyid+"&floor_Name="+floor_Name);
            ListCall.enqueue(new Callback<List<RoomDropDownList>>() {
                @Override
                public void onResponse(Call<List<RoomDropDownList>> call, Response<List<RoomDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        roomDropDownLists=response.body();
                        showRoomDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<RoomDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showRoomDropDownList()
    {
        if(getApplicationContext()!=null) {
            String item[]=new String[roomDropDownLists.size()];
            for(int i=0;i<roomDropDownLists.size();i++)
            {
                item[i]=roomDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            //room.setAdapter(adapter);
           /* room.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    roomno=roomDropDownLists.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });*/
        }
    }
    private void showRegionDropDownList()
    {
        if(getApplicationContext()!=null){
            String item[]=new String[regionDropDownLists.size()];
            for(int i=0;i<regionDropDownLists.size();i++)
            {
                item[i]=regionDropDownLists.get(i).getText();
                // item[i]=regionDropDownLists.get(i).getValue();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
           /* region.setAdapter(adapter);
            region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    regionId=regionDropDownLists.get(position).getValue();
                    fetchSubRegionDropDownList();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });*/

        }
    }
    private void fetchSubRegionDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<SubRegionDropDownList>> ListCall= apiServicesWorkOrder.subregionorderdropdown("application/json","api/dropdown/getsubregionby?rolename="+rolename+"&companyid="+companyid+"&Id="+regionId);
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
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showSubRegionDropDownList()
    {
        if(getApplicationContext()!=null) {
            String item[]=new String[subRegionDropDownLists.size()];
            for(int i=0;i<subRegionDropDownLists.size();i++)
            {
                item[i]=subRegionDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
            adapter.setDropDownViewResource(R.layout.fortitle);
            /*subRegion.setAdapter(adapter);
            subRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    subRegionId=subRegionDropDownLists.get(position).getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });*/
        }
    }
    private void fetchFloorDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<FloorDropDownList>> ListCall= apiServicesWorkOrder.floordropdown("application/json","api/dropdown/floor?rolename="+rolename+"&companyid="+companyid+"&building_Name="+building_Name);
            ListCall.enqueue(new Callback<List<FloorDropDownList>>() {
                @Override
                public void onResponse(Call<List<FloorDropDownList>> call, Response<List<FloorDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        floorDropDownLists=response.body();
                        showFloorDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<FloorDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
    private void showFloorDropDownList()
    {
        if(getApplicationContext()!=null) {
            String item[]=new String[floorDropDownLists.size()];
            for(int i=0;i<floorDropDownLists.size();i++)
            {
                item[i]=floorDropDownLists.get(i).getText();
            }

            if (item.length>0) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle, item);
                adapter.setDropDownViewResource(R.layout.fortitle);
               /* floor.setAdapter(adapter);
                floor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        floor_Name = floorDropDownLists.get(position).getText();
                        fetchRoomDropDownList();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });*/
            }
        }
    }


    private void showBuildingDropDownList()
    {
        String item[]=new String[buildingDropDownLists.size()];
        for(int i=0;i<buildingDropDownLists.size();i++)
        {
            item[i]=buildingDropDownLists.get(i).getText();
            //  item[i]=buildingDropDownLists.get(i).getValue();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
        adapter.setDropDownViewResource(R.layout.fortitle);
      /*  building.setAdapter(adapter);
        building.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                building_Name=buildingDropDownLists.get(position).getText();
                fetchFloorDropDownList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }
    private void fetchBuildingDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<BuildingDropDownList>> ListCall= apiServicesWorkOrder.buildingdropdown("application/json","api/dropdown/building?rolename="+rolename+"&companyid="+companyid+"&location_id="+location_id);
            ListCall.enqueue(new Callback<List<BuildingDropDownList>>() {
                @Override
                public void onResponse(Call<List<BuildingDropDownList>> call, Response<List<BuildingDropDownList>> response) {
                    if(response.body()!=null)
                    {
                        buildingDropDownLists=response.body();
                        showBuildingDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<BuildingDropDownList>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }
  /*  private void fetchLocationDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AssetLocationResponse>> ListCall= apiServicesWorkOrder.locationdropdown("application/json","api/dropdown/locationby?rolename="+rolename+"&companyid="+companyid+"&regionid="+regionId+"&subRegionId="+subRegionId+"&AreaId="+AreaId+"&ClientId="+clientId);
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
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }
    }*/
    private void showLocationDropDown()
    {
        String item[]=new String[locationDropDownLists.size()];
        for(int i=0;i<locationDropDownLists.size();i++)
        {
            item[i]=locationDropDownLists.get(i).getSiteName();
            // item[i]=locationDropDownLists.get(i).getValue();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
        adapter.setDropDownViewResource(R.layout.fortitle);
       /* location.setAdapter(adapter);
        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                location_id= String.valueOf(locationDropDownLists.get(position).getId());
                fetchBuildingDropDownList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }
    private void fetchRegionDropDownList()
    {
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {

            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<RegionDropDownList>> ListCall= apiServicesWorkOrder.regiondropdown("application/json","api/dropdown/getregiontby?rolename="+rolename+"&companyid="+companyid);
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
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }


    }

    private void fetchAreaDropDownList()
    {
        if(UtilityWorkOrder.isNetworkAvailable(getApplicationContext()))
        {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<AreaDropDownList>> ListCall= apiServicesWorkOrder.areadropdown("application/json","api/dropdown/area?rolename="+rolename+"&companyid="+companyid);
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
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_SHORT).show();
        }

    }
    private void showAreaDropDownList()
    {
        String item[]=new String[areaDropDownLists.size()];
        for(int i=0;i<areaDropDownLists.size();i++)
        {
            item[i]=areaDropDownLists.get(i).getText();
            //  item[i]=areaDropDownLists.get(i).getValue();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.fortitle,item);
        adapter.setDropDownViewResource(R.layout.fortitle);
     /*   area.setAdapter(adapter);
        area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AreaId=areaDropDownLists.get(position).getValue();
                fetchLocationDropDownList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
