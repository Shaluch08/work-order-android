package com.workorder.app.workorderapplication.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.model.login.LoginRequestModel;
import com.workorder.app.workorderapplication.model.login.LoginResponseModel;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText user,password;
    Button signIn;
    String username1,userrole,userid;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    ProgressDialog progressDialog;
    TextView sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_work_order);
        progressDialog = new ProgressDialog(this, R.style.AppCompatAlertDialogStyle);
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());
        user= (EditText) findViewById(R.id.user_id);
        password=(EditText) findViewById(R.id.user_password);
        signIn= (Button)findViewById(R.id.signIn);
         sms=(TextView) findViewById(R.id.DisPlay);

         user.setText("demobrisullclient@gmail.com");
         password.setText("P@ssword123");

        signIn.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callLogin();
            }
        });
    }
    public void callLogin()
    {
        if (user.getText().toString().matches("")) {
          user.setError("Please Enter Your Name");
        }if(password.getText().toString().matches("")){
            password.setText("Please Enter Your Password");
        }
        else {
            progressDialog.setMessage("Authenticating...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(false);
            progressDialog.show();
            LoginRequestModel loginRequestModel=new LoginRequestModel();
            String musername = user.getText().toString().trim();
            String mpassword = password.getText().toString().trim();
            loginRequestModel.setUserName(musername);
            loginRequestModel.setPassword(mpassword);
            if (UtilityWorkOrder.isNetworkAvailable(this)) {
                ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
                final Call<LoginResponseModel> loginResponseCall =
                        apiServicesWorkOrder.postLogin("application/json",loginRequestModel);
                loginResponseCall.enqueue(new Callback<LoginResponseModel>() {
                    @Override
                    public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                        try {
                            int codeStatus=response.code();
                            // TODO NULL CHECK OF RESPONSE
                            if (response.isSuccessful()) {
                                Log.d("LoginResponse",response.toString());
                                if(response.body().userrole!=null)
                                {
                                    Log.v("Response",response.body().toString());


                                    if(response.body().userrole.trim().equals("BBM"))
                                        preferenceManagerWorkOrder.setKey_User_Role("Finance Manager");
                                    else
                                    preferenceManagerWorkOrder.setKey_User_Role(response.body().userrole);
                                    preferenceManagerWorkOrder.setKey_User_Name(response.body().username);
                                    preferenceManagerWorkOrder.setKey_User_Id(String.valueOf(response.body().userid));
                                    preferenceManagerWorkOrder.setKey_Person_Company_Id(String.valueOf(response.body().personcompanyid));
                                    preferenceManagerWorkOrder.setKey_Parent_Company_Id(String.valueOf(response.body().parentcompanyid));
                                    username1=response.body().getUsername();
                                    userid= String.valueOf(response.body().getUserid());
                                    userrole=response.body().getUserrole();
                                    if (userrole.toString().trim().equals("Worker")){

                                        Intent intent = new Intent(LoginActivity.this,WorkerSearchList.class);
                                        startActivity(intent);
                                    }else if (userrole.toString().equals("Landlord")){
                                        Bundle bundle=new Bundle();
                                        bundle.putString("Id", preferenceManagerWorkOrder.getKey_Person_Company_Id());
                                        Intent intent = new Intent(LoginActivity.this,SearchWorkOrder.class);
                                        intent.putExtras(bundle);
                                        startActivity(intent);
                                    }else if (userrole.toString().trim().equals("Worker")){

                                        Intent intent = new Intent(LoginActivity.this,WorkerSearchList.class);
                                        startActivity(intent);
                                    }else if (userrole.toString().trim().equals("Client")) {
                                        Bundle bundle=new Bundle();
                                        bundle.putString("Id", preferenceManagerWorkOrder.getKey_Person_Company_Id());
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        intent.putExtras(bundle);
                                        startActivity(intent);
                                    }

                                    else if (userrole.toString().trim().equals("Client")) {
                                        Bundle bundle=new Bundle();
                                        bundle.putString("Id", preferenceManagerWorkOrder.getKey_Person_Company_Id());
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        intent.putExtras(bundle);
                                        startActivity(intent);
                                    }
                                    else {
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        intent.putExtra("username", username1);
                                        intent.putExtra("userrole", userrole);
                                        startActivity(intent);
                                        progressDialog.dismiss();
                                    }
                                }else {
                                    sms.setText("Invalid Username or Password");
                                    sms.setVisibility(View.VISIBLE);
                                    progressDialog.dismiss();
                                }

                            } else {
                                sms.setText("Invalid Username or Password");
                                sms.setVisibility(View.VISIBLE);
                            }
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            Log.v("Error",e.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponseModel> call, Throwable t) {

                        t.printStackTrace();
                        System.out.println(t.getMessage() + t.getLocalizedMessage());
                        sms.setText(t.getLocalizedMessage());
                        sms.setVisibility(View.VISIBLE);
                    }
                });
            } else {
                    sms.setText("NetworkWorkOrder is not available");
                sms.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
            }
        }
    }
}
