package com.workorder.app.workorderapplication.model.workOrderModel;

import com.google.gson.annotations.SerializedName;

public class WorkOrderResponse {
    @SerializedName("Result")
   public String result;

    public String getResponse() {
        return result;
    }

    public void result(String response) {
        this.result = response;
    }
}
