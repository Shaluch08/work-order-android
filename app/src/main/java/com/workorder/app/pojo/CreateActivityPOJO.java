package com.workorder.app.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CreateActivityPOJO  implements Serializable {
    @SerializedName("Latitude")
    @Expose
    private Double latitude;
    @SerializedName("WorkOrderNo")
    @Expose
    private String workOrderNo;
    @SerializedName("EndDate")
    @Expose
    private String endDate;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("AssesmentSiteId")
    @Expose
    private Integer assesmentSiteId;
    @SerializedName("Longitude")
    @Expose
    private Double longitude;
    @SerializedName("StartDate")
    @Expose
    private String startDate;
    @SerializedName("EmployeeID")
    @Expose
    private Integer employeeID;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getWorkOrderNo() {
        return workOrderNo;
    }

    public void setWorkOrderNo(String workOrderNo) {
        this.workOrderNo = workOrderNo;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAssesmentSiteId() {
        return assesmentSiteId;
    }

    public void setAssesmentSiteId(Integer assesmentSiteId) {
        this.assesmentSiteId = assesmentSiteId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

}
