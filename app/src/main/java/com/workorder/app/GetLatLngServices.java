package com.workorder.app;

import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.workorder.app.util.Constants;

import java.util.Timer;
import java.util.TimerTask;

public class GetLatLngServices extends Service implements LocationListener {

    boolean isGPSEnable = false;
    boolean isNetworkEnable = false;
    double latitude,longitude;
    LocationManager locationManager;
    Location location;
    private Handler mHandler = new Handler();
    private Timer mTimer = null;
    long notify_interval = 5000;

    public static String str_receiver = "servicetutorial.service.receiver";
    Intent intent;

    public GetLatLngServices() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mTimer = new Timer();
        mTimer.schedule(new TimerTaskToGetLocation(),5000,notify_interval);
         Log.d("ServeceCreate","Service is created");
        intent = new Intent(str_receiver);
        fn_getlocation();

    }


    @Override
    public void onLocationChanged(Location location) {
        fn_getlocation();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    private void fn_getlocation(){
        locationManager = (LocationManager)getApplicationContext().getSystemService(LOCATION_SERVICE);
        isGPSEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetworkEnable = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        Log.d("ServiceGetLocation","Getting your location");

        if (!isGPSEnable && !isNetworkEnable){
         Log.d("GPS","GPS is not enabled");
         //turnGPSOn();
        }else {
           if (isNetworkEnable){
               location = null;
               locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000,0,this);
               if (locationManager!=null){
                   location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                   if (location!=null){

                       Log.d("networklatitude",location.getLatitude()+"");
                       Log.d("networklongitude",location.getLongitude()+"");
                       Constants.PROVIDER=LocationManager.NETWORK_PROVIDER;
                       latitude = location.getLatitude();
                       longitude = location.getLongitude();
                       fn_update(location);
                   }
               }

           }else {
               location = null;
               locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,0,this);
               if (locationManager!=null){
                   location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                   if (location!=null){
                       Log.d("gpslatitude",location.getLatitude()+"");
                       Log.d("gpslongitude",location.getLongitude()+"");
                       Constants.PROVIDER=LocationManager.GPS_PROVIDER;
                       latitude = location.getLatitude();
                       longitude = location.getLongitude();
                       fn_update(location);
                   }
               }



           }


        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ServicDestroy","Service is Destroyed");
    }

    private class TimerTaskToGetLocation extends TimerTask {
        @Override
        public void run() {

            mHandler.post(new Runnable() {
                @Override
                public void run() {
               //turnGPSOn();
                }
            });

        }
    }
    private void turnGPSOn(){
        String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

        if(!provider.contains("gps")){ //if gps is disabled
            final Intent poke = new Intent();
            poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
            poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
            poke.setData(Uri.parse("3"));
            sendBroadcast(poke);
        }
    }

    private void fn_update(Location location){

        intent.putExtra("latutide",location.getLatitude()+"");
        intent.putExtra("longitude",location.getLongitude()+"");

        sendBroadcast(intent);
    }




}
