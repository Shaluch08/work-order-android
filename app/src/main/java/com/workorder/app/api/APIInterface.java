package com.workorder.app.api;

import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderResponseModel;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @Headers("application/json")
    @GET("api/order/orderlist")
    Call<List<WorkOrderResponseModel>> getOrderList(@Query(value="rolename", encoded=true) String name, @Query("companyid") String companyid);


}
