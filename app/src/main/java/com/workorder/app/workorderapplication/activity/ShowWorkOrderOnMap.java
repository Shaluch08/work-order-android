package com.workorder.app.workorderapplication.activity;

import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.workorder.app.R;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;

import java.util.ArrayList;
import java.util.List;

public class ShowWorkOrderOnMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    List<Marker> markers=new ArrayList<>();
    List<LatLng> latLngList=new ArrayList<>();
    ImageView iv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_work_order_on_map);

        iv_back=findViewById(R.id.iv_show_work_order_back);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.show_work_order_map);
        mapFragment.getMapAsync(this);


        for (int i=0;i< Constants.workOrderList.size();i++)
        {
            Log.v("lat", String.valueOf(Constants.workOrderList.get(i).getLatitude()));
            Log.v("long", String.valueOf(Constants.workOrderList.get(i).getLongitude()));
            if((Constants.workOrderList.get(i).getLatitude()== null) || Constants.workOrderList.get(i).getLongitude()==null){

            }else {
                latLngList.add(new LatLng(Constants.workOrderList.get(i).getLatitude(),Constants.workOrderList.get(i).getLongitude()));
            }
        }

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        try {
            for (int i = 0; i < latLngList.size(); i++) {
                String t=Constants.workOrderList.get(i).getWorkOrderNumber()+","+"Priority : "+Constants.workOrderList.get(i).getPriority()+", "+"Warning level : "+Constants.workOrderList.get(i).getWarningText();
                Marker marker = mMap.addMarker(new MarkerOptions().position(latLngList.get(i)).title(t));
                markers.add(marker);
            }
        }catch (Exception e){

        }


        // Add a marker in Sydney and move the camera
        // LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //  mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        new CountDownTimer(1500, 100) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                showAllMarker();
            }
        }.start();
    }

    public void showAllMarker()
    {
        if (markers.size()>0 && mMap!=null)
        {
            int padding=50;
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Marker marker : markers) {
                builder.include(marker.getPosition());
            }
            LatLngBounds bounds = builder.build();
            CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
            mMap.moveCamera(cu);
        }
    }


}
