package com.workorder.app.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.workorder.app.pojo.WorkOrderPOJO;
import com.workorder.app.pojo.docPOJO.AttachementPOJO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PrefManager {

    private static final String PREF_NAME = "OfflineSurvey";

    public static void saveworkorder(Context context, List<WorkOrderPOJO> clickPostPOJO) {
        SharedPreferences mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(clickPostPOJO);
        prefsEditor.putString("SurveyType", json);
        prefsEditor.apply();
    }
    public static List<WorkOrderPOJO> getsaveworkorder(Context context) {
        SharedPreferences mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String json = mPrefs.getString("SAVE_IN_DRAFT", "");
        Gson gson = new Gson();

        if (json.equalsIgnoreCase("")) {
            return new ArrayList<WorkOrderPOJO>();
        }
        List<WorkOrderPOJO> clickPostPOJO = Arrays.asList(gson.fromJson(json, WorkOrderPOJO[].class));

        return clickPostPOJO;
    }



    public static void saveswms(Context context, List<AttachementPOJO> clickPostPOJO) {
        SharedPreferences mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(clickPostPOJO);
        prefsEditor.putString("SurveyType", json);
        prefsEditor.apply();
    }
    public static List<AttachementPOJO> getswms(Context context) {
        SharedPreferences mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String json = mPrefs.getString("SAVE_IN_DRAFT", "");
        Gson gson = new Gson();

        if (json.equalsIgnoreCase("")) {
        return new ArrayList<AttachementPOJO>();
        }
        List<AttachementPOJO> clickPostPOJO = Arrays.asList(gson.fromJson(json, AttachementPOJO[].class));

        return clickPostPOJO;
    }



}
