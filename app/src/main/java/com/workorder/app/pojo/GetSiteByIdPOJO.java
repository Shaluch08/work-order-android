package com.workorder.app.pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.workorder.app.pojo.assesment.SiteLocationPOJO;

import java.io.Serializable;

public class GetSiteByIdPOJO implements Serializable {
    @SerializedName("riskAssesmentID")
    @Expose
    private String riskAssesmentID;
    @SerializedName("riskAssesment")
    @Expose
    private RiskAssesmentPOJO riskAssesment;
    @SerializedName("siteLocationId")
    @Expose
    private String siteLocationId;
    @SerializedName("siteLocation")
    @Expose
    private SiteLocationPOJO siteLocation;
    @SerializedName("escalationLevel")
    @Expose
    private String escalationLevel;
    @SerializedName("warningLevel")
    @Expose
    private String warningLevel;
    @SerializedName("entityText")
    @Expose
    private String entityText;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("entityStatus")
    @Expose
    private String entityStatus;
    @SerializedName("createdDate")
    @Expose
    private Object createdDate;
    @SerializedName("createdBy")
    @Expose
    private Object createdBy;
    @SerializedName("updatedDate")
    @Expose
    private Object updatedDate;
    @SerializedName("updatedBy")
    @Expose
    private Object updatedBy;
    @SerializedName("deletedDate")
    @Expose
    private Object deletedDate;
    @SerializedName("deletedBy")
    @Expose
    private Object deletedBy;
    @SerializedName("isDeleted")
    @Expose
    private Object isDeleted;

    public String getRiskAssesmentPOJOID() {
        return riskAssesmentID;
    }

    public void setRiskAssesmentPOJOID(String riskAssesmentID) {
        this.riskAssesmentID = riskAssesmentID;
    }

    public RiskAssesmentPOJO getRiskAssesmentPOJO() {
        return riskAssesment;
    }

    public void setRiskAssesmentPOJO(RiskAssesmentPOJO riskAssesment) {
        this.riskAssesment = riskAssesment;
    }

    public String getSiteLocationPOJOId() {
        return siteLocationId;
    }

    public void setSiteLocationPOJOId(String siteLocationId) {
        this.siteLocationId = siteLocationId;
    }

    public SiteLocationPOJO getSiteLocationPOJO() {
        return siteLocation;
    }

    public void setSiteLocationPOJO(SiteLocationPOJO siteLocation) {
        this.siteLocation = siteLocation;
    }

    public String getEscalationLevel() {
        return escalationLevel;
    }

    public void setEscalationLevel(String escalationLevel) {
        this.escalationLevel = escalationLevel;
    }

    public String getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(String warningLevel) {
        this.warningLevel = warningLevel;
    }

    public String getEntityText() {
        return entityText;
    }

    public void setEntityText(String entityText) {
        this.entityText = entityText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(String entityStatus) {
        this.entityStatus = entityStatus;
    }

    public Object getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Object createdDate) {
        this.createdDate = createdDate;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Object getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Object updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Object getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Object deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Object getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Object deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Object getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Object isDeleted) {
        this.isDeleted = isDeleted;
    }
}
