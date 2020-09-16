package com.workorder.app.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RiskAssesmentPOJO implements Serializable
{
    @SerializedName("assesmentDate")
    @Expose
    private String assesmentDate;
    @SerializedName("referenceNumber")
    @Expose
    private String referenceNumber;
    @SerializedName("purchaseOrder")
    @Expose
    private String purchaseOrder;
    @SerializedName("workOrderNumber")
    @Expose
    private String workOrderNumber;
    @SerializedName("permitNumber")
    @Expose
    private String permitNumber;
    @SerializedName("workStartDate")
    @Expose
    private String workStartDate;
    @SerializedName("workEndDate")
    @Expose
    private String workEndDate;
    @SerializedName("companyID")
    @Expose
    private String companyID;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("orderLocation")
    @Expose
    private String orderLocation;
    @SerializedName("clientID")
    @Expose
    private String clientID;
    @SerializedName("client")
    @Expose
    private String client;
    @SerializedName("placeofWorkAddress")
    @Expose
    private String placeofWorkAddress;
    @SerializedName("riskCategoryID")
    @Expose
    private String riskCategoryID;
    @SerializedName("tradeCategoryID")
    @Expose
    private String tradeCategoryID;
    @SerializedName("riskAssessmentNo")
    @Expose
    private String riskAssessmentNo;
    @SerializedName("typeofAssessment")
    @Expose
    private String typeofAssessment;
    @SerializedName("templatesId")
    @Expose
    private String templatesId;
    @SerializedName("templates")
    @Expose
    private String templates;
    @SerializedName("documentDownload")
    @Expose
    private String documentDownload;
    @SerializedName("document_Upload_Date")
    @Expose
    private String documentUploadDate;
    @SerializedName("employeeId")
    @Expose
    private String employeeId;
    @SerializedName("employee")
    @Expose
    private String employee;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("scopeOfWork")
    @Expose
    private String scopeOfWork;
    @SerializedName("isCompleted")
    @Expose
    private Boolean isCompleted;
    @SerializedName("contractorSiteManager")
    @Expose
    private String contractorSiteManager;
    @SerializedName("contractorSiteMngrMNo")
    @Expose
    private String contractorSiteMngrMNo;
    @SerializedName("projectName")
    @Expose
    private String projectName;
    @SerializedName("principalContractor")
    @Expose
    private String principalContractor;
    @SerializedName("workingContractor")
    @Expose
    private String workingContractor;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("siteId")
    @Expose
    private String siteId;
    @SerializedName("countryId")
    @Expose
    private String countryId;
    @SerializedName("stateId")
    @Expose
    private String stateId;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("companyWorkOrderNumber")
    @Expose
    private String companyWorkOrderNumber;
    @SerializedName("managementCompanyId")
    @Expose
    private String managementCompanyId;
    @SerializedName("managementCompany")
    @Expose
    private String managementCompany;
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
    private String createdDate;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("updatedDate")
    @Expose
    private String updatedDate;
    @SerializedName("updatedBy")
    @Expose
    private String updatedBy;
    @SerializedName("deletedDate")
    @Expose
    private String deletedDate;
    @SerializedName("deletedBy")
    @Expose
    private String deletedBy;
    @SerializedName("isDeleted")
    @Expose
    private Boolean isDeleted;

    public String getAssesmentDate() {
        return assesmentDate;
    }

    public void setAssesmentDate(String assesmentDate) {
        this.assesmentDate = assesmentDate;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public String getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    public String getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(String workStartDate) {
        this.workStartDate = workStartDate;
    }

    public String getWorkEndDate() {
        return workEndDate;
    }

    public void setWorkEndDate(String workEndDate) {
        this.workEndDate = workEndDate;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOrderLocation() {
        return orderLocation;
    }

    public void setOrderLocation(String orderLocation) {
        this.orderLocation = orderLocation;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getPlaceofWorkAddress() {
        return placeofWorkAddress;
    }

    public void setPlaceofWorkAddress(String placeofWorkAddress) {
        this.placeofWorkAddress = placeofWorkAddress;
    }

    public String getRiskCategoryID() {
        return riskCategoryID;
    }

    public void setRiskCategoryID(String riskCategoryID) {
        this.riskCategoryID = riskCategoryID;
    }

    public String getTradeCategoryID() {
        return tradeCategoryID;
    }

    public void setTradeCategoryID(String tradeCategoryID) {
        this.tradeCategoryID = tradeCategoryID;
    }

    public String getRiskAssessmentNo() {
        return riskAssessmentNo;
    }

    public void setRiskAssessmentNo(String riskAssessmentNo) {
        this.riskAssessmentNo = riskAssessmentNo;
    }

    public String getTypeofAssessment() {
        return typeofAssessment;
    }

    public void setTypeofAssessment(String typeofAssessment) {
        this.typeofAssessment = typeofAssessment;
    }

    public String getTemplatesId() {
        return templatesId;
    }

    public void setTemplatesId(String templatesId) {
        this.templatesId = templatesId;
    }

    public String getTemplates() {
        return templates;
    }

    public void setTemplates(String templates) {
        this.templates = templates;
    }

    public String getDocumentDownload() {
        return documentDownload;
    }

    public void setDocumentDownload(String documentDownload) {
        this.documentDownload = documentDownload;
    }

    public String getDocumentUploadDate() {
        return documentUploadDate;
    }

    public void setDocumentUploadDate(String documentUploadDate) {
        this.documentUploadDate = documentUploadDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScopeOfWork() {
        return scopeOfWork;
    }

    public void setScopeOfWork(String scopeOfWork) {
        this.scopeOfWork = scopeOfWork;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getContractorSiteManager() {
        return contractorSiteManager;
    }

    public void setContractorSiteManager(String contractorSiteManager) {
        this.contractorSiteManager = contractorSiteManager;
    }

    public String getContractorSiteMngrMNo() {
        return contractorSiteMngrMNo;
    }

    public void setContractorSiteMngrMNo(String contractorSiteMngrMNo) {
        this.contractorSiteMngrMNo = contractorSiteMngrMNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPrincipalContractor() {
        return principalContractor;
    }

    public void setPrincipalContractor(String principalContractor) {
        this.principalContractor = principalContractor;
    }

    public String getWorkingContractor() {
        return workingContractor;
    }

    public void setWorkingContractor(String workingContractor) {
        this.workingContractor = workingContractor;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCompanyWorkOrderNumber() {
        return companyWorkOrderNumber;
    }

    public void setCompanyWorkOrderNumber(String companyWorkOrderNumber) {
        this.companyWorkOrderNumber = companyWorkOrderNumber;
    }

    public String getManagementCompanyId() {
        return managementCompanyId;
    }

    public void setManagementCompanyId(String managementCompanyId) {
        this.managementCompanyId = managementCompanyId;
    }

    public String getManagementCompany() {
        return managementCompany;
    }

    public void setManagementCompany(String managementCompany) {
        this.managementCompany = managementCompany;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
