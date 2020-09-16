package com.workorder.app.workorderapplication.model.dashboardModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bharat Tripathi on 16-May-18.
 */

public class FmList {
    @SerializedName("fmid")
    @Expose
    private Integer fmid;
    @SerializedName("fmName")
    @Expose
    private String fmName;
    @SerializedName("clientList")
    @Expose
    private List<ClientList> clientList = null;
    @SerializedName("warnnigUrl")
    @Expose
    private String warnnigUrl;

    public Integer getFmid() {
        return fmid;
    }

    public void setFmid(Integer fmid) {
        this.fmid = fmid;
    }

    public String getFmName() {
        return fmName;
    }

    public void setFmName(String fmName) {
        this.fmName = fmName;
    }

    public List<ClientList> getClientList() {
        return clientList;
    }

    public void setClientList(List<ClientList> clientList) {
        this.clientList = clientList;
    }

    public String getWarnnigUrl() {
        return warnnigUrl;
    }

    public void setWarnnigUrl(String warnnigUrl) {
        this.warnnigUrl = warnnigUrl;
    }
}
