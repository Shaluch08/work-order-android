package com.workorder.app.workorderapplication.model.dashboardModel.contractor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bharat Tripathi on 27-May-18.
 */

public class ContrctTree implements Serializable {
    @SerializedName("contID")
    @Expose
    private Integer contID;
    @SerializedName("contName")
    @Expose
    private String contName;
    @SerializedName("clients")
    @Expose
    private List<ClientContract> clientContracts = null;
    public Integer getContID() {
        return contID;
    }

    public void setContID(Integer contID) {
        this.contID = contID;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public ArrayList<ClientContract> getClientContracts() {
        return (ArrayList<ClientContract>) clientContracts;
    }

    public void setClientContracts(ArrayList<ClientContract> clientContracts) {
        this.clientContracts = clientContracts;
    }

}
