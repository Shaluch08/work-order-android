package com.workorder.app.workorderapplication.remote;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.workorder.app.util.UrlClass;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bharat Tripathi on 02-May-18.
 */

public class RetrofitManagerWorkOrder {
    private static final String TAG = "RetrofitManagerWorkOrder";
    //Singleton class
    private static Retrofit retrofit;
    public static String BASE_URL="http://109.228.49.117:8095/";

    public static Retrofit getInstance()
    {
/*
        if(retrofit == null)
        {
*/

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            Log.d("RetrofitBaseUrl",BASE_URL);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(interceptor);
            httpClient.readTimeout(4, TimeUnit.HOURS);
            httpClient.writeTimeout(4, TimeUnit.HOURS);
            httpClient.connectTimeout(4, TimeUnit.MINUTES);
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder().baseUrl(UrlClass.BASE_URL)//"http://109.228.49.117:8095"
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();
        //}
        return retrofit;
    }
}
