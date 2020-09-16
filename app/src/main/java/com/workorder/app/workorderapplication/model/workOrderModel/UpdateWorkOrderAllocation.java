package com.workorder.app.workorderapplication.model.workOrderModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bharat Tripathi on 06-May-18.
 */

public class UpdateWorkOrderAllocation {
    @SerializedName("personId")
    @Expose
    private Long personId;

    @SerializedName("workOrderId")
    @Expose
    private long workOrderId;

    @SerializedName("tradeCategoriesId")
    @Expose
    private Long tradeCategoriesId;

    @SerializedName("workingHours")
    @Expose
    private String workingHours;
    @SerializedName("totalHours")
    @Expose
    private Long totalHours;
    @SerializedName("swms")
    @Expose
    private String swms;
    @SerializedName("escalationLevel")
    @Expose
    private Long escalationLevel;
    @SerializedName("warningLevel")
    @Expose
    private Long warningLevel;
    @SerializedName("entityText")
    @Expose
    private String entityText;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("entityStatus")
    @Expose
    private Long entityStatus;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("createdBy")
    @Expose
    private Long createdBy;
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
    private Boolean isDeleted;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }





    public long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(long workOrderId) {
        this.workOrderId = workOrderId;
    }





    public Long getTradeCategoriesId() {
        return tradeCategoriesId;
    }

    public void setTradeCategoriesId(Long tradeCategoriesId) {
        this.tradeCategoriesId = tradeCategoriesId;
    }




    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public Long getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Long totalHours) {
        this.totalHours = totalHours;
    }

    public String getSwms() {
        return swms;
    }

    public void setSwms(String swms) {
        this.swms = swms;
    }

    public Long getEscalationLevel() {
        return escalationLevel;
    }

    public void setEscalationLevel(Long escalationLevel) {
        this.escalationLevel = escalationLevel;
    }

    public Long getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(Long warningLevel) {
        this.warningLevel = warningLevel;
    }

    public String getEntityText() {
        return entityText;
    }

    public void setEntityText(String entityText) {
        this.entityText = entityText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(Long entityStatus) {
        this.entityStatus = entityStatus;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
