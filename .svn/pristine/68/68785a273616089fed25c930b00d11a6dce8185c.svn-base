package com.workorder.app.workorderapplication.remote;

/**
 * Created by Bharat Tripathi on 02-May-18.
 */

public class NetworkWorkOrder {
    private static NetworkWorkOrder instance;
    private final ApiServicesWorkOrder apiServicesWorkOrder;


    private NetworkWorkOrder() {
        apiServicesWorkOrder = RetrofitManagerWorkOrder.getInstance().create(ApiServicesWorkOrder.class);
    }

    public static NetworkWorkOrder getInstance() {
      //  if (instance==null){
            instance=new NetworkWorkOrder();
      //  }
        return instance;
    }

    public ApiServicesWorkOrder getApiServicesWorkOrder() {
        return apiServicesWorkOrder;
    }

}
