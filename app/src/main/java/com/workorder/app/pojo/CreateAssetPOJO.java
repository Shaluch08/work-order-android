package com.workorder.app.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CreateAssetPOJO implements Serializable {
    @SerializedName("maintenanceComments")
    @Expose
    private String maintenanceComments;
    @SerializedName("assetCategoryId")
    @Expose
    private String assetCategoryId;
    @SerializedName("personId")
    @Expose
    private Integer personId;
    @SerializedName("maintenanceCode")
    @Expose
    private String maintenanceCode;
    @SerializedName("labourWarrantyDateEntered")
    @Expose
    private String labourWarrantyDateEntered;
    @SerializedName("subRegionId")
    @Expose
    private String subRegionId;
    @SerializedName("warrantyLengthInMonth")
    @Expose
    private Integer warrantyLengthInMonth;
    @SerializedName("orderNumber")
    @Expose
    private String orderNumber;
    @SerializedName("roomName")
    @Expose
    private String roomName;
    @SerializedName("labourWarrantyComments")
    @Expose
    private String labourWarrantyComments;
    @SerializedName("assetSubCategoryId")
    @Expose
    private String assetSubCategoryId;
    @SerializedName("oldAssetID")
    @Expose
    private String oldAssetID;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("warrantyLengthInYear")
    @Expose
    private String warrantyLengthInYear;
    @SerializedName("expectedReplacementCost")
    @Expose
    private String expectedReplacementCost;
    @SerializedName("nextMaintenanceCode")
    @Expose
    private String nextMaintenanceCode;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("commissioned")
    @Expose
    private String commissioned;
    @SerializedName("loadDate")
    @Expose
    private String loadDate;
    @SerializedName("comDecommissioned")
    @Expose
    private String comDecommissioned;
    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("estMaintenanceCost")
    @Expose
    private String estMaintenanceCost;
    @SerializedName("labourWarrantyStartDate")
    @Expose
    private String labourWarrantyStartDate;
    @SerializedName("nextInspectionDate")
    @Expose
    private String nextInspectionDate;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("warrantyExpiration")
    @Expose
    private String warrantyExpiration;
    @SerializedName("room")
    @Expose
    private String room;
    @SerializedName("processType")
    @Expose
    private String processType;
    @SerializedName("supplierName")
    @Expose
    private String supplierName;
    @SerializedName("maintenanceProcedure")
    @Expose
    private String maintenanceProcedure;
    @SerializedName("dateInstalled")
    @Expose
    private String dateInstalled;
    @SerializedName("drawingNumber")
    @Expose
    private String drawingNumber;
    @SerializedName("nextMaintenanceDate")
    @Expose
    private String nextMaintenanceDate;
    @SerializedName("strategy")
    @Expose
    private String strategy;
    @SerializedName("decommissioned")
    @Expose
    private String decommissioned;
    @SerializedName("criticality")
    @Expose
    private String criticality;
    @SerializedName("maintenaceFrequency")
    @Expose
    private String maintenaceFrequency;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("contractorId")
    @Expose
    private String contractorId;
    @SerializedName("userIdReferenceNumber")
    @Expose
    private String userIdReferenceNumber;
    @SerializedName("subComponent")
    @Expose
    private Boolean subComponent;
    @SerializedName("inspectionProcedureResult")
    @Expose
    private String inspectionProcedureResult;
    @SerializedName("postcode")
    @Expose
    private String postcode;
    @SerializedName("assetID")
    @Expose
    private String assetID;
    @SerializedName("maintenanceProcedureResult")
    @Expose
    private String maintenanceProcedureResult;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("warningLevel")
    @Expose
    private Integer warningLevel;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("warnnigUrl")
    @Expose
    private String warnnigUrl;
    @SerializedName("replacementDate")
    @Expose
    private String replacementDate;
    @SerializedName("subComponentId")
    @Expose
    private String subComponentId;
    @SerializedName("escalationLevel")
    @Expose
    private String escalationLevel;
    @SerializedName("serialNo")
    @Expose
    private String serialNo;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("inspectionFrequency")
    @Expose
    private String inspectionFrequency;
    @SerializedName("buildingName")
    @Expose
    private String buildingName;
    @SerializedName("lastInspectionDate")
    @Expose
    private String lastInspectionDate;
    @SerializedName("labourWarrantyEnterBy")
    @Expose
    private String labourWarrantyEnterBy;
    @SerializedName("contractNo")
    @Expose
    private String contractNo;
    @SerializedName("assetUse")
    @Expose
    private String assetUse;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("partsWarrantyEnterBy")
    @Expose
    private String partsWarrantyEnterBy;
    @SerializedName("make")
    @Expose
    private String make;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("purchaseCost")
    @Expose
    private String purchaseCost;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("partsWarrantyStartDate")
    @Expose
    private String partsWarrantyStartDate;
    @SerializedName("lastMaintenanceDate")
    @Expose
    private String lastMaintenanceDate;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("quaLifeExpectancy")
    @Expose
    private Integer quaLifeExpectancy;
    @SerializedName("supplierId")
    @Expose
    private String supplierId;
    @SerializedName("energyRating")
    @Expose
    private String energyRating;
    @SerializedName("qtyLife")
    @Expose
    private Integer qtyLife;
    @SerializedName("selectedMaintenaceFrQ")
    @Expose
    private String selectedMaintenaceFrQ;
    @SerializedName("barCode")
    @Expose
    private String barCode;
    @SerializedName("removedNextMaintenanceCode")
    @Expose
    private String removedNextMaintenanceCode;
    @SerializedName("specificRequirement")
    @Expose
    private String specificRequirement;
    @SerializedName("partsWarrantyDateEntered")
    @Expose
    private String partsWarrantyDateEntered;
    @SerializedName("statutoryMaintenance")
    @Expose
    private Boolean statutoryMaintenance;
    @SerializedName("warrantyLength")
    @Expose
    private String warrantyLength;
    @SerializedName("comCommissioned")
    @Expose
    private String comCommissioned;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("modelNo")
    @Expose
    private String modelNo;
    @SerializedName("assetType")
    @Expose
    private Integer assetType;
    @SerializedName("entityStatus")
    @Expose
    private Integer entityStatus;
    @SerializedName("assetCode")
    @Expose
    private String assetCode;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("conditionDate")
    @Expose
    private String conditionDate;
    @SerializedName("clientNo")
    @Expose
    private String clientNo;
    @SerializedName("contractType")
    @Expose
    private String contractType;
    @SerializedName("assetName")
    @Expose
    private String assetName;
    @SerializedName("omLink")
    @Expose
    private String omLink;
    @SerializedName("partsWarrantyComments")
    @Expose
    private String partsWarrantyComments;
    @SerializedName("replacementYear")
    @Expose
    private String replacementYear;
    @SerializedName("regionId")
    @Expose
    private String regionId;
    @SerializedName("floor")
    @Expose
    private String floor;
    @SerializedName("componentDescription")
    @Expose
    private String componentDescription;
    @SerializedName("labourWarrantyEndDate")
    @Expose
    private String labourWarrantyEndDate;
    @SerializedName("inspectionComments")
    @Expose
    private String inspectionComments;
    @SerializedName("locationId")
    @Expose
    private String locationId;

    public String getMaintenanceComments() {
        return maintenanceComments;
    }

    public void setMaintenanceComments(String maintenanceComments) {
        this.maintenanceComments = maintenanceComments;
    }

    public String getAssetCategoryId() {
        return assetCategoryId;
    }

    public void setAssetCategoryId(String assetCategoryId) {
        this.assetCategoryId = assetCategoryId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getMaintenanceCode() {
        return maintenanceCode;
    }

    public void setMaintenanceCode(String maintenanceCode) {
        this.maintenanceCode = maintenanceCode;
    }

    public String getLabourWarrantyDateEntered() {
        return labourWarrantyDateEntered;
    }

    public void setLabourWarrantyDateEntered(String labourWarrantyDateEntered) {
        this.labourWarrantyDateEntered = labourWarrantyDateEntered;
    }

    public String getSubRegionId() {
        return subRegionId;
    }

    public void setSubRegionId(String subRegionId) {
        this.subRegionId = subRegionId;
    }

    public Integer getWarrantyLengthInMonth() {
        return warrantyLengthInMonth;
    }

    public void setWarrantyLengthInMonth(Integer warrantyLengthInMonth) {
        this.warrantyLengthInMonth = warrantyLengthInMonth;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getLabourWarrantyComments() {
        return labourWarrantyComments;
    }

    public void setLabourWarrantyComments(String labourWarrantyComments) {
        this.labourWarrantyComments = labourWarrantyComments;
    }

    public String getAssetSubCategoryId() {
        return assetSubCategoryId;
    }

    public void setAssetSubCategoryId(String assetSubCategoryId) {
        this.assetSubCategoryId = assetSubCategoryId;
    }

    public String getOldAssetID() {
        return oldAssetID;
    }

    public void setOldAssetID(String oldAssetID) {
        this.oldAssetID = oldAssetID;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getWarrantyLengthInYear() {
        return warrantyLengthInYear;
    }

    public void setWarrantyLengthInYear(String warrantyLengthInYear) {
        this.warrantyLengthInYear = warrantyLengthInYear;
    }

    public String getExpectedReplacementCost() {
        return expectedReplacementCost;
    }

    public void setExpectedReplacementCost(String expectedReplacementCost) {
        this.expectedReplacementCost = expectedReplacementCost;
    }

    public String getNextMaintenanceCode() {
        return nextMaintenanceCode;
    }

    public void setNextMaintenanceCode(String nextMaintenanceCode) {
        this.nextMaintenanceCode = nextMaintenanceCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCommissioned() {
        return commissioned;
    }

    public void setCommissioned(String commissioned) {
        this.commissioned = commissioned;
    }

    public String getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(String loadDate) {
        this.loadDate = loadDate;
    }

    public String getComDecommissioned() {
        return comDecommissioned;
    }

    public void setComDecommissioned(String comDecommissioned) {
        this.comDecommissioned = comDecommissioned;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getEstMaintenanceCost() {
        return estMaintenanceCost;
    }

    public void setEstMaintenanceCost(String estMaintenanceCost) {
        this.estMaintenanceCost = estMaintenanceCost;
    }

    public String getLabourWarrantyStartDate() {
        return labourWarrantyStartDate;
    }

    public void setLabourWarrantyStartDate(String labourWarrantyStartDate) {
        this.labourWarrantyStartDate = labourWarrantyStartDate;
    }

    public String getNextInspectionDate() {
        return nextInspectionDate;
    }

    public void setNextInspectionDate(String nextInspectionDate) {
        this.nextInspectionDate = nextInspectionDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(String warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getMaintenanceProcedure() {
        return maintenanceProcedure;
    }

    public void setMaintenanceProcedure(String maintenanceProcedure) {
        this.maintenanceProcedure = maintenanceProcedure;
    }

    public String getDateInstalled() {
        return dateInstalled;
    }

    public void setDateInstalled(String dateInstalled) {
        this.dateInstalled = dateInstalled;
    }

    public String getDrawingNumber() {
        return drawingNumber;
    }

    public void setDrawingNumber(String drawingNumber) {
        this.drawingNumber = drawingNumber;
    }

    public String getNextMaintenanceDate() {
        return nextMaintenanceDate;
    }

    public void setNextMaintenanceDate(String nextMaintenanceDate) {
        this.nextMaintenanceDate = nextMaintenanceDate;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getDecommissioned() {
        return decommissioned;
    }

    public void setDecommissioned(String decommissioned) {
        this.decommissioned = decommissioned;
    }

    public String getCriticality() {
        return criticality;
    }

    public void setCriticality(String criticality) {
        this.criticality = criticality;
    }

    public String getMaintenaceFrequency() {
        return maintenaceFrequency;
    }

    public void setMaintenaceFrequency(String maintenaceFrequency) {
        this.maintenaceFrequency = maintenaceFrequency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContractorId() {
        return contractorId;
    }

    public void setContractorId(String contractorId) {
        this.contractorId = contractorId;
    }

    public String getUserIdReferenceNumber() {
        return userIdReferenceNumber;
    }

    public void setUserIdReferenceNumber(String userIdReferenceNumber) {
        this.userIdReferenceNumber = userIdReferenceNumber;
    }

    public Boolean getSubComponent() {
        return subComponent;
    }

    public void setSubComponent(Boolean subComponent) {
        this.subComponent = subComponent;
    }

    public String getInspectionProcedureResult() {
        return inspectionProcedureResult;
    }

    public void setInspectionProcedureResult(String inspectionProcedureResult) {
        this.inspectionProcedureResult = inspectionProcedureResult;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getMaintenanceProcedureResult() {
        return maintenanceProcedureResult;
    }

    public void setMaintenanceProcedureResult(String maintenanceProcedureResult) {
        this.maintenanceProcedureResult = maintenanceProcedureResult;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(Integer warningLevel) {
        this.warningLevel = warningLevel;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getWarnnigUrl() {
        return warnnigUrl;
    }

    public void setWarnnigUrl(String warnnigUrl) {
        this.warnnigUrl = warnnigUrl;
    }

    public String getReplacementDate() {
        return replacementDate;
    }

    public void setReplacementDate(String replacementDate) {
        this.replacementDate = replacementDate;
    }

    public String getSubComponentId() {
        return subComponentId;
    }

    public void setSubComponentId(String subComponentId) {
        this.subComponentId = subComponentId;
    }

    public String getEscalationLevel() {
        return escalationLevel;
    }

    public void setEscalationLevel(String escalationLevel) {
        this.escalationLevel = escalationLevel;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInspectionFrequency() {
        return inspectionFrequency;
    }

    public void setInspectionFrequency(String inspectionFrequency) {
        this.inspectionFrequency = inspectionFrequency;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getLastInspectionDate() {
        return lastInspectionDate;
    }

    public void setLastInspectionDate(String lastInspectionDate) {
        this.lastInspectionDate = lastInspectionDate;
    }

    public String getLabourWarrantyEnterBy() {
        return labourWarrantyEnterBy;
    }

    public void setLabourWarrantyEnterBy(String labourWarrantyEnterBy) {
        this.labourWarrantyEnterBy = labourWarrantyEnterBy;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getAssetUse() {
        return assetUse;
    }

    public void setAssetUse(String assetUse) {
        this.assetUse = assetUse;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPartsWarrantyEnterBy() {
        return partsWarrantyEnterBy;
    }

    public void setPartsWarrantyEnterBy(String partsWarrantyEnterBy) {
        this.partsWarrantyEnterBy = partsWarrantyEnterBy;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(String purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPartsWarrantyStartDate() {
        return partsWarrantyStartDate;
    }

    public void setPartsWarrantyStartDate(String partsWarrantyStartDate) {
        this.partsWarrantyStartDate = partsWarrantyStartDate;
    }

    public String getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(String lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getQuaLifeExpectancy() {
        return quaLifeExpectancy;
    }

    public void setQuaLifeExpectancy(Integer quaLifeExpectancy) {
        this.quaLifeExpectancy = quaLifeExpectancy;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getEnergyRating() {
        return energyRating;
    }

    public void setEnergyRating(String energyRating) {
        this.energyRating = energyRating;
    }

    public Integer getQtyLife() {
        return qtyLife;
    }

    public void setQtyLife(Integer qtyLife) {
        this.qtyLife = qtyLife;
    }

    public String getSelectedMaintenaceFrQ() {
        return selectedMaintenaceFrQ;
    }

    public void setSelectedMaintenaceFrQ(String selectedMaintenaceFrQ) {
        this.selectedMaintenaceFrQ = selectedMaintenaceFrQ;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getRemovedNextMaintenanceCode() {
        return removedNextMaintenanceCode;
    }

    public void setRemovedNextMaintenanceCode(String removedNextMaintenanceCode) {
        this.removedNextMaintenanceCode = removedNextMaintenanceCode;
    }

    public String getSpecificRequirement() {
        return specificRequirement;
    }

    public void setSpecificRequirement(String specificRequirement) {
        this.specificRequirement = specificRequirement;
    }

    public String getPartsWarrantyDateEntered() {
        return partsWarrantyDateEntered;
    }

    public void setPartsWarrantyDateEntered(String partsWarrantyDateEntered) {
        this.partsWarrantyDateEntered = partsWarrantyDateEntered;
    }

    public Boolean getStatutoryMaintenance() {
        return statutoryMaintenance;
    }

    public void setStatutoryMaintenance(Boolean statutoryMaintenance) {
        this.statutoryMaintenance = statutoryMaintenance;
    }

    public String getWarrantyLength() {
        return warrantyLength;
    }

    public void setWarrantyLength(String warrantyLength) {
        this.warrantyLength = warrantyLength;
    }

    public String getComCommissioned() {
        return comCommissioned;
    }

    public void setComCommissioned(String comCommissioned) {
        this.comCommissioned = comCommissioned;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public Integer getAssetType() {
        return assetType;
    }

    public void setAssetType(Integer assetType) {
        this.assetType = assetType;
    }

    public Integer getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(Integer entityStatus) {
        this.entityStatus = entityStatus;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getConditionDate() {
        return conditionDate;
    }

    public void setConditionDate(String conditionDate) {
        this.conditionDate = conditionDate;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getOmLink() {
        return omLink;
    }

    public void setOmLink(String omLink) {
        this.omLink = omLink;
    }

    public String getPartsWarrantyComments() {
        return partsWarrantyComments;
    }

    public void setPartsWarrantyComments(String partsWarrantyComments) {
        this.partsWarrantyComments = partsWarrantyComments;
    }

    public String getReplacementYear() {
        return replacementYear;
    }

    public void setReplacementYear(String replacementYear) {
        this.replacementYear = replacementYear;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getComponentDescription() {
        return componentDescription;
    }

    public void setComponentDescription(String componentDescription) {
        this.componentDescription = componentDescription;
    }

    public String getLabourWarrantyEndDate() {
        return labourWarrantyEndDate;
    }

    public void setLabourWarrantyEndDate(String labourWarrantyEndDate) {
        this.labourWarrantyEndDate = labourWarrantyEndDate;
    }

    public String getInspectionComments() {
        return inspectionComments;
    }

    public void setInspectionComments(String inspectionComments) {
        this.inspectionComments = inspectionComments;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
