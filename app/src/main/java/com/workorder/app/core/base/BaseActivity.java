package com.workorder.app.core.base;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;


public abstract class BaseActivity extends AppCompatActivity {

    ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        /*String lan = LocaleHelper.getLanguage(this);
        if (lan.equals("ar")) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            }}*/
        super.onCreate(savedInstanceState);
        //  Restrict to portrait mode

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
//    }

    public ProgressDialog showProgressDialog(@Nullable String title, @Nullable String description) {
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setTitle(title);
        dialog.setMessage(description);
        dialog.show();
        return dialog;
    }

    public void hideDialog() {
        if (dialog != null)
            dialog.dismiss();
    }



    public void toast(String message) {
        try {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            log("Window has been closed");
        }
    }

    public abstract void init();

    public abstract void log(String message);

    public void log(String className, String message) {
     //   Log.d(Const.DEBUG_TAG, className + " : " + message);
    }

    @Override
    public void onStop() {
        super.onStop();
        hideDialog();
    }


}

