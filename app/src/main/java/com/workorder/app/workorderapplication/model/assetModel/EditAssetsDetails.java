package com.workorder.app.workorderapplication.model.assetModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EditAssetsDetails implements Serializable {
    @SerializedName("asset_id")
    @Expose
    private Integer assetId;
    @SerializedName("assetname")
    @Expose
    private String assetname;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("assettype")
    @Expose
    private Integer assettype;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("assetcode")
    @Expose
    private String assetcode;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("make")
    @Expose
    private Integer make;
    @SerializedName("modelno")
    @Expose
    private String modelno;
    @SerializedName("serialno")
    @Expose
    private String serialno;
    @SerializedName("barcode")
    @Expose
    private String barcode;
    @SerializedName("personid")
    @Expose
    private Integer personid;
    @SerializedName("clientno")
    @Expose
    private String clientno;
    @SerializedName("assetid")
    @Expose
    private String assetid;
    @SerializedName("assetcategoryid")
    @Expose
    private Integer assetcategoryid;
    @SerializedName("assetsubcategoryid")
    @Expose
    private String assetsubcategoryid;
    @SerializedName("conditiondate")
    @Expose
    private String conditiondate;
    @SerializedName("condition")
    @Expose
    private Integer condition;
    @SerializedName("strategy")
    @Expose
    private Integer strategy;
    @SerializedName("criticality")
    @Expose
    private Integer criticality;
    @SerializedName("nextinspectiondate")
    @Expose
    private String nextinspectiondate;
    @SerializedName("nextmaintenancedate")
    @Expose
    private String nextmaintenancedate;
    @SerializedName("inspectionfrequency")
    @Expose
    private Integer inspectionfrequency;
    @SerializedName("lastinspectiondate")
    @Expose
    private String lastinspectiondate;
    @SerializedName("lastmaintenancedate")
    @Expose
    private String lastmaintenancedate;
    @SerializedName("inspectionprocedureresult")
    @Expose
    private String inspectionprocedureresult;
    @SerializedName("inspectioncomments")
    @Expose
    private String inspectioncomments;
    @SerializedName("oldassetid")
    @Expose
    private Integer oldassetid;
    @SerializedName("statutorymaintenance")
    @Expose
    private Boolean statutorymaintenance;
    @SerializedName("maintenanceprocedureresult")
    @Expose
    private String maintenanceprocedureresult;
    @SerializedName("maintenancecomments")
    @Expose
    private String maintenancecomments;
    @SerializedName("maintenacefrequency")
    @Expose
    private String maintenacefrequency;
    @SerializedName("suppliername")
    @Expose
    private String suppliername;
    @SerializedName("ordernumber")
    @Expose
    private String ordernumber;
    @SerializedName("subcomponent")
    @Expose
    private Boolean subcomponent;
    @SerializedName("subcomponentid")
    @Expose
    private Integer subcomponentid;
    @SerializedName("componentdescription")
    @Expose
    private String componentdescription;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("replacementyear")
    @Expose
    private String replacementyear;
    @SerializedName("contracttype")
    @Expose
    private Integer contracttype;
    @SerializedName("dateinstalled")
    @Expose
    private String dateinstalled;
    @SerializedName("commissioned")
    @Expose
    private String commissioned;
    @SerializedName("decommissioned")
    @Expose
    private String decommissioned;
    @SerializedName("qtylife")
    @Expose
    private String qtylife;
    @SerializedName("specificrequirement")
    @Expose
    private String specificrequirement;
    @SerializedName("purchasecost")
    @Expose
    private Double purchasecost;
    @SerializedName("energyrating")
    @Expose
    private Integer energyrating;
    @SerializedName("warrantylength")
    @Expose
    private String warrantylength;
    @SerializedName("warrantyexpiration")
    @Expose
    private String warrantyexpiration;
    @SerializedName("expectedreplacementcost")
    @Expose
    private Double expectedreplacementcost;
    @SerializedName("partswarrantystartdate")
    @Expose
    private String partswarrantystartdate;
    @SerializedName("partswarrantydateentered")
    @Expose
    private String partswarrantydateentered;
    @SerializedName("partswarrantycomments")
    @Expose
    private String partswarrantycomments;
    @SerializedName("partswarrantyenterby")
    @Expose
    private String partswarrantyenterby;
    @SerializedName("labourwarrantystartdate")
    @Expose
    private String labourwarrantystartdate;
    @SerializedName("labourwarrantyenddate")
    @Expose
    private String labourwarrantyenddate;
    @SerializedName("labourwarrantydateentered")
    @Expose
    private String labourwarrantydateentered;
    @SerializedName("labourwarrantyenterby")
    @Expose
    private String labourwarrantyenterby;
    @SerializedName("labourwarrantycomments")
    @Expose
    private String labourwarrantycomments;
    @SerializedName("omlink")
    @Expose
    private String omlink;
    @SerializedName("drawingnumber")
    @Expose
    private String drawingnumber;
    @SerializedName("warninglevel")
    @Expose
    private Integer warninglevel;
    @SerializedName("escalationlevel")
    @Expose
    private Integer escalationlevel;
    @SerializedName("entitystatus")
    @Expose
    private Integer entitystatus;
    @SerializedName("contractno")
    @Expose
    private String contractno;
    @SerializedName("loaddate")
    @Expose
    private String loaddate;
    @SerializedName("regionid")
    @Expose
    private String regionid;
    @SerializedName("subregionid")
    @Expose
    private String subregionid;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("locationid")
    @Expose
    private String locationid;
    @SerializedName("buildingname")
    @Expose
    private String buildingname;
    @SerializedName("room")
    @Expose
    private String room;
    @SerializedName("floor")
    @Expose
    private String floor;
    @SerializedName("supplierid")
    @Expose
    private String supplierid;
    @SerializedName("qualifeexpectancy")
    @Expose
    private Integer qualifeexpectancy;
    @SerializedName("replacementdate")
    @Expose
    private String replacementdate;
    @SerializedName("comcommissioned")
    @Expose
    private String comcommissioned;
    @SerializedName("comdecommissioned")
    @Expose
    private String comdecommissioned;
    @SerializedName("estmaintenancecost")
    @Expose
    private Double estmaintenancecost;
    @SerializedName("warrantylengthinmonth")
    @Expose
    private Integer warrantylengthinmonth;
    @SerializedName("warrantylengthinyear")
    @Expose
    private Integer warrantylengthinyear;
    @SerializedName("assetuse")
    @Expose
    private String assetuse;
    @SerializedName("roomname")
    @Expose
    private String roomname;
    @SerializedName("warnnigurl")
    @Expose
    private String warnnigurl;
    @SerializedName("createddate")
    @Expose
    private String createddate;
    @SerializedName("createdby")
    @Expose
    private Integer createdby;
    @SerializedName("updateddate")
    @Expose
    private String updateddate;
    @SerializedName("updatedby")
    @Expose
    private Integer updatedby;
    @SerializedName("deleteddate")
    @Expose
    private String deleteddate;
    @SerializedName("deletedby")
    @Expose
    private String deletedby;
    @SerializedName("isdeleted")
    @Expose
    private Boolean isdeleted;
    @SerializedName("maintenancecode")
    @Expose
    private String maintenancecode;
    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("postcode")
    @Expose
    private String postcode;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("selectedmaintenacefrq")
    @Expose
    private String selectedmaintenacefrq;
    @SerializedName("nextmaintenancecode")
    @Expose
    private String nextmaintenancecode;
    @SerializedName("removednextmaintenancecode")
    @Expose
    private String removednextmaintenancecode;
    @SerializedName("processtype")
    @Expose
    private Integer processtype;
    @SerializedName("maintenanceprocedure")
    @Expose
    private String maintenanceprocedure;
    @SerializedName("contractorid")
    @Expose
    private String contractorid;
    @SerializedName("useridreferencenumber")
    @Expose
    private String useridreferencenumber;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("partswarrantyexpirydate")
    @Expose
    private String partswarrantyexpirydate;
    @SerializedName("partswarrantylength")
    @Expose
    private String partswarrantylength;

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getAssetname() {
        return assetname;
    }

    public void setAssetname(String assetname) {
        this.assetname = assetname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAssettype() {
        return assettype;
    }

    public void setAssettype(Integer assettype) {
        this.assettype = assettype;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getAssetcode() {
        return assetcode;
    }

    public void setAssetcode(String assetcode) {
        this.assetcode = assetcode;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getMake() {
        return make;
    }

    public void setMake(Integer make) {
        this.make = make;
    }

    public String getModelno() {
        return modelno;
    }

    public void setModelno(String modelno) {
        this.modelno = modelno;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public String getClientno() {
        return clientno;
    }

    public void setClientno(String clientno) {
        this.clientno = clientno;
    }

    public String getAssetid() {
        return assetid;
    }

    public void setAssetid(String assetid) {
        this.assetid = assetid;
    }

    public Integer getAssetcategoryid() {
        return assetcategoryid;
    }

    public void setAssetcategoryid(Integer assetcategoryid) {
        this.assetcategoryid = assetcategoryid;
    }

    public String getAssetsubcategoryid() {
        return assetsubcategoryid;
    }

    public void setAssetsubcategoryid(String assetsubcategoryid) {
        this.assetsubcategoryid = assetsubcategoryid;
    }

    public String getConditiondate() {
        return conditiondate;
    }

    public void setConditiondate(String conditiondate) {
        this.conditiondate = conditiondate;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public Integer getStrategy() {
        return strategy;
    }

    public void setStrategy(Integer strategy) {
        this.strategy = strategy;
    }

    public Integer getCriticality() {
        return criticality;
    }

    public void setCriticality(Integer criticality) {
        this.criticality = criticality;
    }

    public String getNextinspectiondate() {
        return nextinspectiondate;
    }

    public void setNextinspectiondate(String nextinspectiondate) {
        this.nextinspectiondate = nextinspectiondate;
    }

    public String getNextmaintenancedate() {
        return nextmaintenancedate;
    }

    public void setNextmaintenancedate(String nextmaintenancedate) {
        this.nextmaintenancedate = nextmaintenancedate;
    }

    public Integer getInspectionfrequency() {
        return inspectionfrequency;
    }

    public void setInspectionfrequency(Integer inspectionfrequency) {
        this.inspectionfrequency = inspectionfrequency;
    }

    public String getLastinspectiondate() {
        return lastinspectiondate;
    }

    public void setLastinspectiondate(String lastinspectiondate) {
        this.lastinspectiondate = lastinspectiondate;
    }

    public String getLastmaintenancedate() {
        return lastmaintenancedate;
    }

    public void setLastmaintenancedate(String lastmaintenancedate) {
        this.lastmaintenancedate = lastmaintenancedate;
    }

    public String getInspectionprocedureresult() {
        return inspectionprocedureresult;
    }

    public void setInspectionprocedureresult(String inspectionprocedureresult) {
        this.inspectionprocedureresult = inspectionprocedureresult;
    }

    public String getInspectioncomments() {
        return inspectioncomments;
    }

    public void setInspectioncomments(String inspectioncomments) {
        this.inspectioncomments = inspectioncomments;
    }

    public Integer getOldassetid() {
        return oldassetid;
    }

    public void setOldassetid(Integer oldassetid) {
        this.oldassetid = oldassetid;
    }

    public Boolean getStatutorymaintenance() {
        return statutorymaintenance;
    }

    public void setStatutorymaintenance(Boolean statutorymaintenance) {
        this.statutorymaintenance = statutorymaintenance;
    }

    public String getMaintenanceprocedureresult() {
        return maintenanceprocedureresult;
    }

    public void setMaintenanceprocedureresult(String maintenanceprocedureresult) {
        this.maintenanceprocedureresult = maintenanceprocedureresult;
    }

    public String getMaintenancecomments() {
        return maintenancecomments;
    }

    public void setMaintenancecomments(String maintenancecomments) {
        this.maintenancecomments = maintenancecomments;
    }

    public String getMaintenacefrequency() {
        return maintenacefrequency;
    }

    public void setMaintenacefrequency(String maintenacefrequency) {
        this.maintenacefrequency = maintenacefrequency;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Boolean getSubcomponent() {
        return subcomponent;
    }

    public void setSubcomponent(Boolean subcomponent) {
        this.subcomponent = subcomponent;
    }

    public Integer getSubcomponentid() {
        return subcomponentid;
    }

    public void setSubcomponentid(Integer subcomponentid) {
        this.subcomponentid = subcomponentid;
    }

    public String getComponentdescription() {
        return componentdescription;
    }

    public void setComponentdescription(String componentdescription) {
        this.componentdescription = componentdescription;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getReplacementyear() {
        return replacementyear;
    }

    public void setReplacementyear(String replacementyear) {
        this.replacementyear = replacementyear;
    }

    public Integer getContracttype() {
        return contracttype;
    }

    public void setContracttype(Integer contracttype) {
        this.contracttype = contracttype;
    }

    public String getDateinstalled() {
        return dateinstalled;
    }

    public void setDateinstalled(String dateinstalled) {
        this.dateinstalled = dateinstalled;
    }

    public String getCommissioned() {
        return commissioned;
    }

    public void setCommissioned(String commissioned) {
        this.commissioned = commissioned;
    }

    public String getDecommissioned() {
        return decommissioned;
    }

    public void setDecommissioned(String decommissioned) {
        this.decommissioned = decommissioned;
    }

    public String getQtylife() {
        return qtylife;
    }

    public void setQtylife(String qtylife) {
        this.qtylife = qtylife;
    }

    public String getSpecificrequirement() {
        return specificrequirement;
    }

    public void setSpecificrequirement(String specificrequirement) {
        this.specificrequirement = specificrequirement;
    }

    public Double getPurchasecost() {
        return purchasecost;
    }

    public void setPurchasecost(Double purchasecost) {
        this.purchasecost = purchasecost;
    }

    public Integer getEnergyrating() {
        return energyrating;
    }

    public void setEnergyrating(Integer energyrating) {
        this.energyrating = energyrating;
    }

    public String getWarrantylength() {
        return warrantylength;
    }

    public void setWarrantylength(String warrantylength) {
        this.warrantylength = warrantylength;
    }

    public String getWarrantyexpiration() {
        return warrantyexpiration;
    }

    public void setWarrantyexpiration(String warrantyexpiration) {
        this.warrantyexpiration = warrantyexpiration;
    }

    public Double getExpectedreplacementcost() {
        return expectedreplacementcost;
    }

    public void setExpectedreplacementcost(Double expectedreplacementcost) {
        this.expectedreplacementcost = expectedreplacementcost;
    }

    public String getPartswarrantystartdate() {
        return partswarrantystartdate;
    }

    public void setPartswarrantystartdate(String partswarrantystartdate) {
        this.partswarrantystartdate = partswarrantystartdate;
    }

    public String getPartswarrantydateentered() {
        return partswarrantydateentered;
    }

    public void setPartswarrantydateentered(String partswarrantydateentered) {
        this.partswarrantydateentered = partswarrantydateentered;
    }

    public String getPartswarrantycomments() {
        return partswarrantycomments;
    }

    public void setPartswarrantycomments(String partswarrantycomments) {
        this.partswarrantycomments = partswarrantycomments;
    }

    public String getPartswarrantyenterby() {
        return partswarrantyenterby;
    }

    public void setPartswarrantyenterby(String partswarrantyenterby) {
        this.partswarrantyenterby = partswarrantyenterby;
    }

    public String getLabourwarrantystartdate() {
        return labourwarrantystartdate;
    }

    public void setLabourwarrantystartdate(String labourwarrantystartdate) {
        this.labourwarrantystartdate = labourwarrantystartdate;
    }

    public String getLabourwarrantyenddate() {
        return labourwarrantyenddate;
    }

    public void setLabourwarrantyenddate(String labourwarrantyenddate) {
        this.labourwarrantyenddate = labourwarrantyenddate;
    }

    public String getLabourwarrantydateentered() {
        return labourwarrantydateentered;
    }

    public void setLabourwarrantydateentered(String labourwarrantydateentered) {
        this.labourwarrantydateentered = labourwarrantydateentered;
    }

    public String getLabourwarrantyenterby() {
        return labourwarrantyenterby;
    }

    public void setLabourwarrantyenterby(String labourwarrantyenterby) {
        this.labourwarrantyenterby = labourwarrantyenterby;
    }

    public String getLabourwarrantycomments() {
        return labourwarrantycomments;
    }

    public void setLabourwarrantycomments(String labourwarrantycomments) {
        this.labourwarrantycomments = labourwarrantycomments;
    }

    public String getOmlink() {
        return omlink;
    }

    public void setOmlink(String omlink) {
        this.omlink = omlink;
    }

    public String getDrawingnumber() {
        return drawingnumber;
    }

    public void setDrawingnumber(String drawingnumber) {
        this.drawingnumber = drawingnumber;
    }

    public Integer getWarninglevel() {
        return warninglevel;
    }

    public void setWarninglevel(Integer warninglevel) {
        this.warninglevel = warninglevel;
    }

    public Integer getEscalationlevel() {
        return escalationlevel;
    }

    public void setEscalationlevel(Integer escalationlevel) {
        this.escalationlevel = escalationlevel;
    }

    public Integer getEntitystatus() {
        return entitystatus;
    }

    public void setEntitystatus(Integer entitystatus) {
        this.entitystatus = entitystatus;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public String getLoaddate() {
        return loaddate;
    }

    public void setLoaddate(String loaddate) {
        this.loaddate = loaddate;
    }

    public String getRegionid() {
        return regionid;
    }

    public void setRegionid(String regionid) {
        this.regionid = regionid;
    }

    public String getSubregionid() {
        return subregionid;
    }

    public void setSubregionid(String subregionid) {
        this.subregionid = subregionid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    public String getBuildingname() {
        return buildingname;
    }

    public void setBuildingname(String buildingname) {
        this.buildingname = buildingname;
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

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }

    public Integer getQualifeexpectancy() {
        return qualifeexpectancy;
    }

    public void setQualifeexpectancy(Integer qualifeexpectancy) {
        this.qualifeexpectancy = qualifeexpectancy;
    }

    public String getReplacementdate() {
        return replacementdate;
    }

    public void setReplacementdate(String replacementdate) {
        this.replacementdate = replacementdate;
    }

    public String getComcommissioned() {
        return comcommissioned;
    }

    public void setComcommissioned(String comcommissioned) {
        this.comcommissioned = comcommissioned;
    }

    public String getComdecommissioned() {
        return comdecommissioned;
    }

    public void setComdecommissioned(String comdecommissioned) {
        this.comdecommissioned = comdecommissioned;
    }

    public Double getEstmaintenancecost() {
        return estmaintenancecost;
    }

    public void setEstmaintenancecost(Double estmaintenancecost) {
        this.estmaintenancecost = estmaintenancecost;
    }

    public Integer getWarrantylengthinmonth() {
        return warrantylengthinmonth;
    }

    public void setWarrantylengthinmonth(Integer warrantylengthinmonth) {
        this.warrantylengthinmonth = warrantylengthinmonth;
    }

    public Integer getWarrantylengthinyear() {
        return warrantylengthinyear;
    }

    public void setWarrantylengthinyear(Integer warrantylengthinyear) {
        this.warrantylengthinyear = warrantylengthinyear;
    }

    public String getAssetuse() {
        return assetuse;
    }

    public void setAssetuse(String assetuse) {
        this.assetuse = assetuse;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getWarnnigurl() {
        return warnnigurl;
    }

    public void setWarnnigurl(String warnnigurl) {
        this.warnnigurl = warnnigurl;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public Integer getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    public String getUpdateddate() {
        return updateddate;
    }

    public void setUpdateddate(String updateddate) {
        this.updateddate = updateddate;
    }

    public Integer getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(Integer updatedby) {
        this.updatedby = updatedby;
    }

    public String getDeleteddate() {
        return deleteddate;
    }

    public void setDeleteddate(String deleteddate) {
        this.deleteddate = deleteddate;
    }

    public String getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(String deletedby) {
        this.deletedby = deletedby;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getMaintenancecode() {
        return maintenancecode;
    }

    public void setMaintenancecode(String maintenancecode) {
        this.maintenancecode = maintenancecode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSelectedmaintenacefrq() {
        return selectedmaintenacefrq;
    }

    public void setSelectedmaintenacefrq(String selectedmaintenacefrq) {
        this.selectedmaintenacefrq = selectedmaintenacefrq;
    }

    public String getNextmaintenancecode() {
        return nextmaintenancecode;
    }

    public void setNextmaintenancecode(String nextmaintenancecode) {
        this.nextmaintenancecode = nextmaintenancecode;
    }

    public String getRemovednextmaintenancecode() {
        return removednextmaintenancecode;
    }

    public void setRemovednextmaintenancecode(String removednextmaintenancecode) {
        this.removednextmaintenancecode = removednextmaintenancecode;
    }

    public Integer getProcesstype() {
        return processtype;
    }

    public void setProcesstype(Integer processtype) {
        this.processtype = processtype;
    }

    public String getMaintenanceprocedure() {
        return maintenanceprocedure;
    }

    public void setMaintenanceprocedure(String maintenanceprocedure) {
        this.maintenanceprocedure = maintenanceprocedure;
    }

    public String getContractorid() {
        return contractorid;
    }

    public void setContractorid(String contractorid) {
        this.contractorid = contractorid;
    }

    public String getUseridreferencenumber() {
        return useridreferencenumber;
    }

    public void setUseridreferencenumber(String useridreferencenumber) {
        this.useridreferencenumber = useridreferencenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPartswarrantyexpirydate() {
        return partswarrantyexpirydate;
    }

    public void setPartswarrantyexpirydate(String partswarrantyexpirydate) {
        this.partswarrantyexpirydate = partswarrantyexpirydate;
    }

    public String getPartswarrantylength() {
        return partswarrantylength;
    }

    public void setPartswarrantylength(String partswarrantylength) {
        this.partswarrantylength = partswarrantylength;
    }

}