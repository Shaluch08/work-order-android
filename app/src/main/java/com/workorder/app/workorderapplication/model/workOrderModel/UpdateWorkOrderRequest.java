package com.workorder.app.workorderapplication.model.workOrderModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateWorkOrderRequest {



    @SerializedName("assignedto")
    @Expose
    private String assignedto;
    @SerializedName("poNumber")
    @Expose
    private String poNumber;
    @SerializedName("workOrderNumber")
    @Expose
    private String workOrderNumber;
    @SerializedName("clientid")
    @Expose
    private String clientid;
    @SerializedName("warningLevel")
    @Expose
    private Integer warningLevel;
    @SerializedName("floorNo")
    @Expose
    private String floorNo;
    @SerializedName("ManagementCompanyId")
    @Expose
    private Integer managementCompanyId;
    @SerializedName("Latitude")
    @Expose
    private String latitude;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("duedate")
    @Expose
    private String duedate;
    @SerializedName("estimatedHour")
    @Expose
    private String estimatedHour;
    @SerializedName("buildingname")
    @Expose
    private String buildingname;
    @SerializedName("workState")
    @Expose
    private String workState;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("Address2")
    @Expose
    private String address2;
    @SerializedName("workPostCode")
    @Expose
    private String workPostCode;
    @SerializedName("clientapproval")
    @Expose
    private Boolean clientapproval;
    @SerializedName("clientapprovaldate")
    @Expose
    private String clientapprovaldate;
    @SerializedName("regionId")
    @Expose
    private String regionId;
    @SerializedName("contactperson")
    @Expose
    private String contactperson;
    @SerializedName("originalWorkOrderNo")
    @Expose
    private String originalWorkOrderNo;
    @SerializedName("AssignedToPM")
    @Expose
    private Integer assignedToPM;
    @SerializedName("SiteName")
    @Expose
    private String siteName;
    @SerializedName("dateRequested")
    @Expose
    private String dateRequested;
    @SerializedName("subRegionId")
    @Expose
    private String subRegionId;
    @SerializedName("clientworkorderno")
    @Expose
    private String clientworkorderno;
    @SerializedName("entityStatus")
    @Expose
    private Integer entityStatus;
    @SerializedName("ProcessType")
    @Expose
    private Integer processType;
    @SerializedName("assigneddate")
    @Expose
    private String assigneddate;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("LocationId")
    @Expose
    private String locationId;
    @SerializedName("newDueDate")
    @Expose
    private String newDueDate;
    @SerializedName("ReactiveCriticality")
    @Expose
    private Integer reactiveCriticality;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("extensionReason")
    @Expose
    private String extensionReason;
    @SerializedName("authorizedcost")
    @Expose
    private String authorizedcost;
    @SerializedName("extensionRequired")
    @Expose
    private String extensionRequired;
    @SerializedName("requestedBy")
    @Expose
    private String requestedBy;
    @SerializedName("extensionApprovedById")
    @Expose
    private String extensionApprovedById;
    @SerializedName("CompanyWorkOrderNo")
    @Expose
    private String companyWorkOrderNo;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("dateraised")
    @Expose
    private String dateraised;
    @SerializedName("room")
    @Expose
    private String room;
    @SerializedName("assetid")
    @Expose
    private Integer assetid;
    @SerializedName("workCountry")
    @Expose
    private String workCountry;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("workCity")
    @Expose
    private String workCity;
    @SerializedName("EndDate")
    @Expose
    private String endDate;
    @SerializedName("EstimatedWorkOrderCost")
    @Expose
    private Double estimatedWorkOrderCost;
    @SerializedName("workOrderType")
    @Expose
    private Integer workOrderType;
    @SerializedName("Longitude")
    @Expose
    private String longitude;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("extensionApproved")
    @Expose
    private String extensionApproved;
    @SerializedName("reportOnWork")
    @Expose
    private String reportOnWork;
    @SerializedName("additionalHrs")
    @Expose
    private String additionHrs;
    public String getReportOnWork() {
        return reportOnWork;
    }

    public void setReportOnWork(String reportOnWork) {
        this.reportOnWork = reportOnWork;
    }
    public String getAdditionHrs() {
        return additionHrs;
    }

    public void setAdditionHrs(String additionHrs) {
        this.additionHrs = additionHrs;
    }


    public String getAssignedto() {
        return assignedto;
    }

    public void setAssignedto(String assignedto) {
        this.assignedto = assignedto;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public Integer getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(Integer warningLevel) {
        this.warningLevel = warningLevel;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public Integer getManagementCompanyId() {
        return managementCompanyId;
    }

    public void setManagementCompanyId(Integer managementCompanyId) {
        this.managementCompanyId = managementCompanyId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getEstimatedHour() {
        return estimatedHour;
    }

    public void setEstimatedHour(String estimatedHour) {
        this.estimatedHour = estimatedHour;
    }

    public String getBuildingname() {
        return buildingname;
    }

    public void setBuildingname(String buildingname) {
        this.buildingname = buildingname;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getWorkPostCode() {
        return workPostCode;
    }

    public void setWorkPostCode(String workPostCode) {
        this.workPostCode = workPostCode;
    }

    public Boolean getClientapproval() {
        return clientapproval;
    }

    public void setClientapproval(Boolean clientapproval) {
        this.clientapproval = clientapproval;
    }

    public String getClientapprovaldate() {
        return clientapprovaldate;
    }

    public void setClientapprovaldate(String clientapprovaldate) {
        this.clientapprovaldate = clientapprovaldate;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getOriginalWorkOrderNo() {
        return originalWorkOrderNo;
    }

    public void setOriginalWorkOrderNo(String originalWorkOrderNo) {
        this.originalWorkOrderNo = originalWorkOrderNo;
    }

    public Integer getAssignedToPM() {
        return assignedToPM;
    }

    public void setAssignedToPM(Integer assignedToPM) {
        this.assignedToPM = assignedToPM;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(String dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getSubRegionId() {
        return subRegionId;
    }

    public void setSubRegionId(String subRegionId) {
        this.subRegionId = subRegionId;
    }

    public String getClientworkorderno() {
        return clientworkorderno;
    }

    public void setClientworkorderno(String clientworkorderno) {
        this.clientworkorderno = clientworkorderno;
    }

    public Integer getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(Integer entityStatus) {
        this.entityStatus = entityStatus;
    }

    public Integer getProcessType() {
        return processType;
    }

    public void setProcessType(Integer processType) {
        this.processType = processType;
    }

    public String getAssigneddate() {
        return assigneddate;
    }

    public void setAssigneddate(String assigneddate) {
        this.assigneddate = assigneddate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getNewDueDate() {
        return newDueDate;
    }

    public void setNewDueDate(String newDueDate) {
        this.newDueDate = newDueDate;
    }

    public Integer getReactiveCriticality() {
        return reactiveCriticality;
    }

    public void setReactiveCriticality(Integer reactiveCriticality) {
        this.reactiveCriticality = reactiveCriticality;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getExtensionReason() {
        return extensionReason;
    }

    public void setExtensionReason(String extensionReason) {
        this.extensionReason = extensionReason;
    }

    public String getAuthorizedcost() {
        return authorizedcost;
    }

    public void setAuthorizedcost(String authorizedcost) {
        this.authorizedcost = authorizedcost;
    }

    public String getExtensionRequired() {
        return extensionRequired;
    }

    public void setExtensionRequired(String extensionRequired) {
        this.extensionRequired = extensionRequired;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getExtensionApprovedById() {
        return extensionApprovedById;
    }

    public void setExtensionApprovedById(String extensionApprovedById) {
        this.extensionApprovedById = extensionApprovedById;
    }

    public String getCompanyWorkOrderNo() {
        return companyWorkOrderNo;
    }

    public void setCompanyWorkOrderNo(String companyWorkOrderNo) {
        this.companyWorkOrderNo = companyWorkOrderNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateraised() {
        return dateraised;
    }

    public void setDateraised(String dateraised) {
        this.dateraised = dateraised;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getAssetid() {
        return assetid;
    }

    public void setAssetid(Integer assetid) {
        this.assetid = assetid;
    }

    public String getWorkCountry() {
        return workCountry;
    }

    public void setWorkCountry(String workCountry) {
        this.workCountry = workCountry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getEstimatedWorkOrderCost() {
        return estimatedWorkOrderCost;
    }

    public void setEstimatedWorkOrderCost(Double estimatedWorkOrderCost) {
        this.estimatedWorkOrderCost = estimatedWorkOrderCost;
    }

    public Integer getWorkOrderType() {
        return workOrderType;
    }

    public void setWorkOrderType(Integer workOrderType) {
        this.workOrderType = workOrderType;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getExtensionApproved() {
        return extensionApproved;
    }

    public void setExtensionApproved(String extensionApproved) {
        this.extensionApproved = extensionApproved;
    }

}

