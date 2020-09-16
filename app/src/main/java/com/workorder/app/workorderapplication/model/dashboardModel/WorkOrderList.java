package com.workorder.app.workorderapplication.model.dashboardModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bharat Tripathi on 16-May-18.
 */

public class WorkOrderList implements Serializable {
    @SerializedName("workorderID")
    @Expose
    private Integer workorderID;
    @SerializedName("workOrderNumber")
    @Expose
    private String workOrderNumber;
    @SerializedName("assetList")
    @Expose
    private List<AssetList> assetList = null;
    @SerializedName("workerList")
    @Expose
    private List<WorkerList> workerList = null;
    @SerializedName("warWarnnigLevelValue")
    @Expose
    private Integer warWarnnigLevelValue;
    @SerializedName("warnnigUrl")
    @Expose
    private String warnnigUrl;
    public Integer getWorkorderID() {
        return workorderID;
    }

    public void setWorkorderID(Integer workorderID) {
        this.workorderID = workorderID;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public List<AssetList> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<AssetList> assetList) {
        this.assetList = assetList;
    }

    public List<WorkerList> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<WorkerList> workerList) {
        this.workerList = workerList;
    }

    public Integer getWarWarnnigLevelValue() {
        return warWarnnigLevelValue;
    }

    public void setWarWarnnigLevelValue(Integer warWarnnigLevelValue) {
        this.warWarnnigLevelValue = warWarnnigLevelValue;
    }

    public String getWarnnigUrl() {
        return warnnigUrl;
    }

    public void setWarnnigUrl(String warnnigUrl) {
        this.warnnigUrl = warnnigUrl;
    }

}
