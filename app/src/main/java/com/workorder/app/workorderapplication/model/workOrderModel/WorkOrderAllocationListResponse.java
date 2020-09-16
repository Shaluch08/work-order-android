package com.workorder.app.workorderapplication.model.workOrderModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bharat Tripathi on 03-May-18.
 */

public class WorkOrderAllocationListResponse {
    @SerializedName("personId")
    @Expose
    private Integer personId;
    @SerializedName("person")
    @Expose
    private Person person;
    @SerializedName("workOrderId")
    @Expose
    private Integer workOrderId;
    @SerializedName("workOrder")
    @Expose
    private WorkOrder workOrder;
    @SerializedName("tradeCategoriesId")
    @Expose
    private Integer tradeCategoriesId;
    @SerializedName("tradeCategories")
    @Expose
    private TradeCategories tradeCategories;
    @SerializedName("workingHours")
    @Expose
    private String workingHours;
    @SerializedName("totalHours")
    @Expose
    private String totalHours;
    @SerializedName("swms")
    @Expose
    private String swms;
    @SerializedName("escalationLevel")
    @Expose
    private Integer escalationLevel;
    @SerializedName("warningLevel")
    @Expose
    private Integer warningLevel;
    @SerializedName("entityText")
    @Expose
    private String entityText;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("entityStatus")
    @Expose
    private Integer entityStatus;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("createdBy")
    @Expose
    private Integer createdBy;
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

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Integer workOrderId) {
        this.workOrderId = workOrderId;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    public Integer getTradeCategoriesId() {
        return tradeCategoriesId;
    }

    public void setTradeCategoriesId(Integer tradeCategoriesId) {
        this.tradeCategoriesId = tradeCategoriesId;
    }

    public TradeCategories getTradeCategories() {
        return tradeCategories;
    }

    public void setTradeCategories(TradeCategories tradeCategories) {
        this.tradeCategories = tradeCategories;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    public String getSwms() {
        return swms;
    }

    public void setSwms(String swms) {
        this.swms = swms;
    }

    public Integer getEscalationLevel() {
        return escalationLevel;
    }

    public void setEscalationLevel(Integer escalationLevel) {
        this.escalationLevel = escalationLevel;
    }

    public Integer getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(Integer warningLevel) {
        this.warningLevel = warningLevel;
    }

    public String getEntityText() {
        return entityText;
    }

    public void setEntityText(String entityText) {
        this.entityText = entityText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(Integer entityStatus) {
        this.entityStatus = entityStatus;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
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
    public class TradeCategories {

        @SerializedName("tradeName")
        @Expose
        private String tradeName;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("parentTradeId")
        @Expose
        private Object parentTradeId;
        @SerializedName("parentTrade")
        @Expose
        private Object parentTrade;
        @SerializedName("escalationLevel")
        @Expose
        private Integer escalationLevel;
        @SerializedName("warningLevel")
        @Expose
        private Integer warningLevel;
        @SerializedName("entityText")
        @Expose
        private String entityText;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("entityStatus")
        @Expose
        private Integer entityStatus;
        @SerializedName("createdDate")
        @Expose
        private Object createdDate;
        @SerializedName("createdBy")
        @Expose
        private Integer createdBy;
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

        public String getTradeName() {
            return tradeName;
        }

        public void setTradeName(String tradeName) {
            this.tradeName = tradeName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getParentTradeId() {
            return parentTradeId;
        }

        public void setParentTradeId(Object parentTradeId) {
            this.parentTradeId = parentTradeId;
        }

        public Object getParentTrade() {
            return parentTrade;
        }

        public void setParentTrade(Object parentTrade) {
            this.parentTrade = parentTrade;
        }

        public Integer getEscalationLevel() {
            return escalationLevel;
        }

        public void setEscalationLevel(Integer escalationLevel) {
            this.escalationLevel = escalationLevel;
        }

        public Integer getWarningLevel() {
            return warningLevel;
        }

        public void setWarningLevel(Integer warningLevel) {
            this.warningLevel = warningLevel;
        }

        public String getEntityText() {
            return entityText;
        }

        public void setEntityText(String entityText) {
            this.entityText = entityText;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getEntityStatus() {
            return entityStatus;
        }

        public void setEntityStatus(Integer entityStatus) {
            this.entityStatus = entityStatus;
        }

        public Object getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(Object createdDate) {
            this.createdDate = createdDate;
        }

        public Integer getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Integer createdBy) {
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
    public  class WorkOrder {

        @SerializedName("poNumber")
        @Expose
        private String poNumber;
        @SerializedName("dueDate")
        @Expose
        private String dueDate;
        @SerializedName("dateRaised")
        @Expose
        private String dateRaised;
        @SerializedName("workOrderNumber")
        @Expose
        private String workOrderNumber;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("priority")
        @Expose
        private Integer priority;
        @SerializedName("workOrderType")
        @Expose
        private Integer workOrderType;
        @SerializedName("originalWorkOrder")
        @Expose
        private String originalWorkOrder;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("clientId")
        @Expose
        private Integer clientId;
        @SerializedName("client")
        @Expose
        private Object client;
        @SerializedName("regionId")
        @Expose
        private Integer regionId;
        @SerializedName("region")
        @Expose
        private Object region;
        @SerializedName("subRegionId")
        @Expose
        private Integer subRegionId;
        @SerializedName("subRegion")
        @Expose
        private Object subRegion;
        @SerializedName("area")
        @Expose
        private Integer area;
        @SerializedName("locationId")
        @Expose
        private Integer locationId;
        @SerializedName("location")
        @Expose
        private Object location;
        @SerializedName("buildingName")
        @Expose
        private String buildingName;
        @SerializedName("room")
        @Expose
        private String room;
        @SerializedName("floor")
        @Expose
        private String floor;
        @SerializedName("attachedImageUrl")
        @Expose
        private Object attachedImageUrl;
        @SerializedName("assetId")
        @Expose
        private Integer assetId;
        @SerializedName("asset")
        @Expose
        private Object asset;
        @SerializedName("workAddress1")
        @Expose
        private String workAddress1;
        @SerializedName("workAddress2")
        @Expose
        private Object workAddress2;
        @SerializedName("workCity")
        @Expose
        private String workCity;
        @SerializedName("workState")
        @Expose
        private String workState;
        @SerializedName("workPostCode")
        @Expose
        private String workPostCode;
        @SerializedName("workCountry")
        @Expose
        private Object workCountry;
        @SerializedName("assignedId")
        @Expose
        private Integer assignedId;
        @SerializedName("assigned")
        @Expose
        private Object assigned;
        @SerializedName("assignedDate")
        @Expose
        private String assignedDate;
        @SerializedName("startDate")
        @Expose
        private Object startDate;
        @SerializedName("endDate")
        @Expose
        private String endDate;
        @SerializedName("authorizedCost")
        @Expose
        private Integer authorizedCost;
        @SerializedName("estimatedHour")
        @Expose
        private Integer estimatedHour;
        @SerializedName("allocatedTo")
        @Expose
        private Object allocatedTo;
        @SerializedName("roleAllocation")
        @Expose
        private Object roleAllocation;
        @SerializedName("tradeRequired")
        @Expose
        private Object tradeRequired;
        @SerializedName("clientJobAllocationDetail")
        @Expose
        private Object clientJobAllocationDetail;
        @SerializedName("siteName")
        @Expose
        private Object siteName;
        @SerializedName("requestedById")
        @Expose
        private Integer requestedById;
        @SerializedName("requestedBy")
        @Expose
        private Object requestedBy;
        @SerializedName("contactName")
        @Expose
        private String contactName;
        @SerializedName("address")
        @Expose
        private Object address;
        @SerializedName("contactPhone")
        @Expose
        private String contactPhone;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("clientWorkOrderNo")
        @Expose
        private String clientWorkOrderNo;
        @SerializedName("clientApproval")
        @Expose
        private Boolean clientApproval;
        @SerializedName("clientApprovalDate")
        @Expose
        private String clientApprovalDate;
        @SerializedName("approvedById")
        @Expose
        private Integer approvedById;
        @SerializedName("extensionRequired")
        @Expose
        private Boolean extensionRequired;
        @SerializedName("dateRequested")
        @Expose
        private Object dateRequested;
        @SerializedName("extensionReason")
        @Expose
        private String extensionReason;
        @SerializedName("extensionApproved")
        @Expose
        private Boolean extensionApproved;
        @SerializedName("extensionApprovedById")
        @Expose
        private Integer extensionApprovedById;
        @SerializedName("newDueDate")
        @Expose
        private Object newDueDate;
        @SerializedName("additionalHrs")
        @Expose
        private String additionalHrs;
        @SerializedName("escalationLevel")
        @Expose
        private Integer escalationLevel;
        @SerializedName("warningLevel")
        @Expose
        private Integer warningLevel;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("entityStatus")
        @Expose
        private Integer entityStatus;
        @SerializedName("createdDate")
        @Expose
        private String createdDate;
        @SerializedName("createdBy")
        @Expose
        private Integer createdBy;
        @SerializedName("updatedDate")
        @Expose
        private String updatedDate;
        @SerializedName("updatedBy")
        @Expose
        private Integer updatedBy;
        @SerializedName("deletedDate")
        @Expose
        private Object deletedDate;
        @SerializedName("deletedBy")
        @Expose
        private Object deletedBy;
        @SerializedName("isDeleted")
        @Expose
        private Boolean isDeleted;
        @SerializedName("entityText")
        @Expose
        private String entityText;

        public String getPoNumber() {
            return poNumber;
        }

        public void setPoNumber(String poNumber) {
            this.poNumber = poNumber;
        }

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }

        public String getDateRaised() {
            return dateRaised;
        }

        public void setDateRaised(String dateRaised) {
            this.dateRaised = dateRaised;
        }

        public String getWorkOrderNumber() {
            return workOrderNumber;
        }

        public void setWorkOrderNumber(String workOrderNumber) {
            this.workOrderNumber = workOrderNumber;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getPriority() {
            return priority;
        }

        public void setPriority(Integer priority) {
            this.priority = priority;
        }

        public Integer getWorkOrderType() {
            return workOrderType;
        }

        public void setWorkOrderType(Integer workOrderType) {
            this.workOrderType = workOrderType;
        }

        public String getOriginalWorkOrder() {
            return originalWorkOrder;
        }

        public void setOriginalWorkOrder(String originalWorkOrder) {
            this.originalWorkOrder = originalWorkOrder;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getClientId() {
            return clientId;
        }

        public void setClientId(Integer clientId) {
            this.clientId = clientId;
        }

        public Object getClient() {
            return client;
        }

        public void setClient(Object client) {
            this.client = client;
        }

        public Integer getRegionId() {
            return regionId;
        }

        public void setRegionId(Integer regionId) {
            this.regionId = regionId;
        }

        public Object getRegion() {
            return region;
        }

        public void setRegion(Object region) {
            this.region = region;
        }

        public Integer getSubRegionId() {
            return subRegionId;
        }

        public void setSubRegionId(Integer subRegionId) {
            this.subRegionId = subRegionId;
        }

        public Object getSubRegion() {
            return subRegion;
        }

        public void setSubRegion(Object subRegion) {
            this.subRegion = subRegion;
        }

        public Integer getArea() {
            return area;
        }

        public void setArea(Integer area) {
            this.area = area;
        }

        public Integer getLocationId() {
            return locationId;
        }

        public void setLocationId(Integer locationId) {
            this.locationId = locationId;
        }

        public Object getLocation() {
            return location;
        }

        public void setLocation(Object location) {
            this.location = location;
        }

        public String getBuildingName() {
            return buildingName;
        }

        public void setBuildingName(String buildingName) {
            this.buildingName = buildingName;
        }

        public String getRoom() {
            return room;
        }

        public void setRoom(String room) {
            this.room = room;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public Object getAttachedImageUrl() {
            return attachedImageUrl;
        }

        public void setAttachedImageUrl(Object attachedImageUrl) {
            this.attachedImageUrl = attachedImageUrl;
        }

        public Integer getAssetId() {
            return assetId;
        }

        public void setAssetId(Integer assetId) {
            this.assetId = assetId;
        }

        public Object getAsset() {
            return asset;
        }

        public void setAsset(Object asset) {
            this.asset = asset;
        }

        public String getWorkAddress1() {
            return workAddress1;
        }

        public void setWorkAddress1(String workAddress1) {
            this.workAddress1 = workAddress1;
        }

        public Object getWorkAddress2() {
            return workAddress2;
        }

        public void setWorkAddress2(Object workAddress2) {
            this.workAddress2 = workAddress2;
        }

        public String getWorkCity() {
            return workCity;
        }

        public void setWorkCity(String workCity) {
            this.workCity = workCity;
        }

        public String getWorkState() {
            return workState;
        }

        public void setWorkState(String workState) {
            this.workState = workState;
        }

        public String getWorkPostCode() {
            return workPostCode;
        }

        public void setWorkPostCode(String workPostCode) {
            this.workPostCode = workPostCode;
        }

        public Object getWorkCountry() {
            return workCountry;
        }

        public void setWorkCountry(Object workCountry) {
            this.workCountry = workCountry;
        }

        public Integer getAssignedId() {
            return assignedId;
        }

        public void setAssignedId(Integer assignedId) {
            this.assignedId = assignedId;
        }

        public Object getAssigned() {
            return assigned;
        }

        public void setAssigned(Object assigned) {
            this.assigned = assigned;
        }

        public String getAssignedDate() {
            return assignedDate;
        }

        public void setAssignedDate(String assignedDate) {
            this.assignedDate = assignedDate;
        }

        public Object getStartDate() {
            return startDate;
        }

        public void setStartDate(Object startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public Integer getAuthorizedCost() {
            return authorizedCost;
        }

        public void setAuthorizedCost(Integer authorizedCost) {
            this.authorizedCost = authorizedCost;
        }

        public Integer getEstimatedHour() {
            return estimatedHour;
        }

        public void setEstimatedHour(Integer estimatedHour) {
            this.estimatedHour = estimatedHour;
        }

        public Object getAllocatedTo() {
            return allocatedTo;
        }

        public void setAllocatedTo(Object allocatedTo) {
            this.allocatedTo = allocatedTo;
        }

        public Object getRoleAllocation() {
            return roleAllocation;
        }

        public void setRoleAllocation(Object roleAllocation) {
            this.roleAllocation = roleAllocation;
        }

        public Object getTradeRequired() {
            return tradeRequired;
        }

        public void setTradeRequired(Object tradeRequired) {
            this.tradeRequired = tradeRequired;
        }

        public Object getClientJobAllocationDetail() {
            return clientJobAllocationDetail;
        }

        public void setClientJobAllocationDetail(Object clientJobAllocationDetail) {
            this.clientJobAllocationDetail = clientJobAllocationDetail;
        }

        public Object getSiteName() {
            return siteName;
        }

        public void setSiteName(Object siteName) {
            this.siteName = siteName;
        }

        public Integer getRequestedById() {
            return requestedById;
        }

        public void setRequestedById(Integer requestedById) {
            this.requestedById = requestedById;
        }

        public Object getRequestedBy() {
            return requestedBy;
        }

        public void setRequestedBy(Object requestedBy) {
            this.requestedBy = requestedBy;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public String getContactPhone() {
            return contactPhone;
        }

        public void setContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getClientWorkOrderNo() {
            return clientWorkOrderNo;
        }

        public void setClientWorkOrderNo(String clientWorkOrderNo) {
            this.clientWorkOrderNo = clientWorkOrderNo;
        }

        public Boolean getClientApproval() {
            return clientApproval;
        }

        public void setClientApproval(Boolean clientApproval) {
            this.clientApproval = clientApproval;
        }

        public String getClientApprovalDate() {
            return clientApprovalDate;
        }

        public void setClientApprovalDate(String clientApprovalDate) {
            this.clientApprovalDate = clientApprovalDate;
        }

        public Integer getApprovedById() {
            return approvedById;
        }

        public void setApprovedById(Integer approvedById) {
            this.approvedById = approvedById;
        }

        public Boolean getExtensionRequired() {
            return extensionRequired;
        }

        public void setExtensionRequired(Boolean extensionRequired) {
            this.extensionRequired = extensionRequired;
        }

        public Object getDateRequested() {
            return dateRequested;
        }

        public void setDateRequested(Object dateRequested) {
            this.dateRequested = dateRequested;
        }

        public String getExtensionReason() {
            return extensionReason;
        }

        public void setExtensionReason(String extensionReason) {
            this.extensionReason = extensionReason;
        }

        public Boolean getExtensionApproved() {
            return extensionApproved;
        }

        public void setExtensionApproved(Boolean extensionApproved) {
            this.extensionApproved = extensionApproved;
        }

        public Integer getExtensionApprovedById() {
            return extensionApprovedById;
        }

        public void setExtensionApprovedById(Integer extensionApprovedById) {
            this.extensionApprovedById = extensionApprovedById;
        }

        public Object getNewDueDate() {
            return newDueDate;
        }

        public void setNewDueDate(Object newDueDate) {
            this.newDueDate = newDueDate;
        }

        public String getAdditionalHrs() {
            return additionalHrs;
        }

        public void setAdditionalHrs(String additionalHrs) {
            this.additionalHrs = additionalHrs;
        }

        public Integer getEscalationLevel() {
            return escalationLevel;
        }

        public void setEscalationLevel(Integer escalationLevel) {
            this.escalationLevel = escalationLevel;
        }

        public Integer getWarningLevel() {
            return warningLevel;
        }

        public void setWarningLevel(Integer warningLevel) {
            this.warningLevel = warningLevel;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getEntityStatus() {
            return entityStatus;
        }

        public void setEntityStatus(Integer entityStatus) {
            this.entityStatus = entityStatus;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public Integer getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
        }

        public String getUpdatedDate() {
            return updatedDate;
        }

        public void setUpdatedDate(String updatedDate) {
            this.updatedDate = updatedDate;
        }

        public Integer getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(Integer updatedBy) {
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

        public String getEntityText() {
            return entityText;
        }

        public void setEntityText(String entityText) {
            this.entityText = entityText;
        }

    }
}
