package com.workorder.app.workorderapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.model.Pojo;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.UtilityWorkOrder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Regis extends AppCompatActivity {
    Spinner spinner;
    List<Pojo> assetDropDownLists;
    String Client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        spinner = (Spinner)findViewById(R.id.spinner);

        fetchClientDropDown();
    }

    private void fetchClientDropDown(){
        if (UtilityWorkOrder.isNetworkAvailable(getApplicationContext())) {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<List<Pojo>> listCall= apiServicesWorkOrder.TitleForregistretion("application/json","api/account/titlefor");
            listCall.enqueue(new Callback<List<Pojo>>() {
                @Override
                public void onResponse(Call<List<Pojo>> call, Response<List<Pojo>> response) {
                    if(response.body()!=null)
                    {
                        assetDropDownLists=response.body();
                        showClientDropDownList();
                    }
                }

                @Override
                public void onFailure(Call<List<Pojo>> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "NetworkWorkOrder is not available", Toast.LENGTH_LONG).show();
        }
    }
    private void showClientDropDownList()
    {

        if(getApplicationContext()!=null)
        {
            int size=assetDropDownLists.size();
            String item[]=new String[size];
            for(int i=0;i<size;i++)
            {
                item[i]=assetDropDownLists.get(i).getText();
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_layout,item) ;
            adapter.setDropDownViewResource(R.layout.spinner_layout);
            spinner.setAdapter(adapter);
            spinner.setPopupBackgroundResource(R.color.even);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Client= assetDropDownLists.get(position).getValue();
                    /*clientNumber.setText(Client);
                    clientNumber.setEnabled(false);*/
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


        }
    }
}
