package com.workorder.app.workorderapplication.model.dashboardModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bharat Tripathi on 16-May-18.
 */

public class ClientList implements Serializable {
    @SerializedName("clientID")
    @Expose
    private Integer clientID;
    @SerializedName("clientName")
    @Expose
    private String clientName;
    @SerializedName("clientPO")
    @Expose
    private List<ClientPO> clientPO = null;
    @SerializedName("conrector")
    @Expose
    private List<Conrector> conrector = null;
    @SerializedName("warnnigUrl")
    @Expose
    private String warnnigUrl;





  public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<ClientPO> getClientPO() {
        return clientPO;
    }

    public void setClientPO(List<ClientPO> clientPO) {
        this.clientPO = clientPO;
    }

    public List<Conrector> getConrector() {
        return conrector;
    }

    public void setConrector(List<Conrector> conrector) {
        this.conrector = conrector;
    }

    public String getWarnnigUrl() {
        return warnnigUrl;
    }

    public void setWarnnigUrl(String warnnigUrl) {
        this.warnnigUrl = warnnigUrl;
    }

}
