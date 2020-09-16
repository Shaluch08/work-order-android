package com.workorder.app.workorderapplication.remote;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.workorder.app.pojo.LoginPOJO;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Bharat Tripathi on 02-May-18.
 */

public class PreferenceManagerWorkOrder {
    private static final String NAME = "ClearWorkOrder";
    private static final String Key_User_Name= "usrname";
    private static final String Key_User_Role="userrole";
    private static final String Key_User_Id="userid";
    private static final String Key_Person_Company_Id="personcompanyid";
    private static final String Key_Parent_Company_Id="parentcompanyid";
    private static PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    private static String date_raised="dateraised";
    private  static String Asset_ID="asset_Id";
    private SharedPreferences mSharedPreferences;
    private PreferenceManagerWorkOrder(Context context) {
        this.mSharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }
    public static PreferenceManagerWorkOrder getInstance(Context context) {
        if (preferenceManagerWorkOrder == null) {
            preferenceManagerWorkOrder = new PreferenceManagerWorkOrder(context);
        }

        return preferenceManagerWorkOrder;
    }
    public String getAsset_ID()
    {
        return  mSharedPreferences.getString(Asset_ID,"");
    }
    public void setAsset_ID(String assetId)
    {
        SharedPreferences.Editor editor=mSharedPreferences.edit();
        editor.putString(Asset_ID,assetId);
        editor.commit();
    }

    public static void SaveLoginData(Context context, LoginPOJO responseData)
    {
        SharedPreferences sp = context.getSharedPreferences(NAME, MODE_PRIVATE);
        String json=new Gson().toJson(responseData);
        sp.edit().putString("LoginData",json).apply();
        Log.d("LoginData",json);
    }
    public static LoginPOJO GetLoginData(Context context)
    {
        SharedPreferences sp = context.getSharedPreferences(NAME, MODE_PRIVATE);
        String json=sp.getString("LoginData","");
        Log.d("LoginData",json);
        if (json.equalsIgnoreCase(""))
        {
            return null;
        }else {
            LoginPOJO responseData = new Gson().fromJson(json, LoginPOJO.class);
            return responseData;
        }
        // sp.edit().putString("LoginData",json).apply();

    }

    public String getDate_raised()
    {
        return mSharedPreferences.getString(date_raised,"");

    }
    public void setDate_raised(String date_raised)
    {
        SharedPreferences.Editor editor=mSharedPreferences.edit();
        editor.putString(date_raised,date_raised);
        editor.commit();
    }
    public String getKey_Parent_Company_Id() {
        return mSharedPreferences.getString(Key_Parent_Company_Id,"");
    }
    public void setKey_Parent_Company_Id(String parent_company_id)
    {
        SharedPreferences.Editor editor=mSharedPreferences.edit();
        editor.putString(Key_Parent_Company_Id,parent_company_id);
        editor.commit();
    }
    public String getKey_Person_Company_Id()
    {
        return mSharedPreferences.getString(Key_Person_Company_Id,"");
    }
    public void setKey_Person_Company_Id(String person_company_id)
    {
        SharedPreferences.Editor editor=mSharedPreferences.edit();
        editor.putString(Key_Person_Company_Id,person_company_id);
        editor.commit();
    }
    public String getKey_User_Name() {
        return mSharedPreferences.getString(Key_User_Name,"");
    }
    public String getKey_User_Role() {
        return mSharedPreferences.getString(Key_User_Role,"");
    }
    public String getKey_User_Id() {
        return mSharedPreferences.getString(Key_User_Id,"");
    }
    public void setKey_User_Name(String user_name)
    {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(Key_User_Name,user_name);
        editor.commit();
    }
    public void setKey_User_Id(String user_id)
    {
        SharedPreferences.Editor editor=mSharedPreferences.edit();
        editor.putString(Key_User_Id,user_id);
        editor.commit();
    }



    public void setKey_User_Role(String user_role)
    {
        SharedPreferences.Editor editor=mSharedPreferences.edit();
        editor.putString(Key_User_Role,user_role);
        editor.commit();
    }
}
