package com.workorder.app.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.workorder.app.R;
import com.workorder.app.pojo.LoginPOJO;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UrlClass;
import com.workorder.app.webservicecallback.OnTaskCompleted;
import com.workorder.app.webservicecallback.SendData;

import org.json.JSONObject;

public class ChangePassword extends Fragment {
    EditText oldpass;
    EditText newPass;
    EditText confirmpass;
    Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_change__password, container, false);

        oldpass = rootView.findViewById(R.id.oldpass);
        newPass = rootView.findViewById(R.id.newPass);
        confirmpass = rootView.findViewById(R.id.confirmpass);
        submit = rootView.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changepass();
            }
        });

        return rootView;

    }



    private void changepass() {
        if (oldpass.getText().toString().equals("")) {
            oldpass.requestFocus();
            oldpass.setError("Please enter old password");
        } else if (newPass.getText().toString().equals("")) {
            newPass.requestFocus();
            newPass.setError("Please enter new password");
        }else if (confirmpass.getText().toString().equals("")) {
            confirmpass.requestFocus();
            confirmpass.setError("Please enter confirm password");
        }else if (!confirmpass.getText().toString().equalsIgnoreCase(newPass.getText().toString())) {
            Toast.makeText(getContext(),"Please enter new password and confirm password same",Toast.LENGTH_LONG).show();
        }else {
            try {
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("OldPassword", oldpass.getText().toString().trim());
                jsonObject.put("NewPassword", newPass.getText().toString().trim());

                //jsonObject.put("grant_type","password");
                // UrlClass.BASE_URL="http://109.228.49.117:8095/api/";
                new SendData(getContext(), jsonObject, UrlClass.Change_Password, new OnTaskCompleted<String>() {
                    @Override
                    public void onTaskCompleted(String response) {
                        try {

                            Log.v("response",response);
                        } catch (Exception e) {
                            //   progressDialog.dismiss();
                            //progressDialog.dismiss();
                            Log.d("ResponseException", e.toString());
                        }
                    }
                }, true).execute();

            } catch (Exception e) {
                // progressDialog.dismiss();
                Log.d("LoginExceptio", e.toString());
            }

        }
    }
}
