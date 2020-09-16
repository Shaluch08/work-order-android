package com.workorder.app.workorderapplication.model.workOrderModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditWorkOrderDetails {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("clientid")
    @Expose
    private Integer clientid;
    @SerializedName("clientno")
    @Expose
    private String clientno;
    @SerializedName("ponumber")
    @Expose
    private String ponumber;
    @SerializedName("sitename")
    @Expose
    private String sitename;
    @SerializedName("workordernumber")
    @Expose
    private String workordernumber;
    @SerializedName("dateraised")
    @Expose
    private String dateraised;
    @SerializedName("duedate")
    @Expose
    private String duedate;
    @SerializedName("warninglevel")
    @Expose
    private Integer warninglevel;
    @SerializedName("entitystatus")
    @Expose
    private Integer entitystatus;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("workordertype")
    @Expose
    private Integer workordertype;
    @SerializedName("clientworkorderno")
    @Expose
    private String clientworkorderno;
    @SerializedName("originalworkorderno")
    @Expose
    private String originalworkorderno;
    @SerializedName("assetid")
    @Expose
    private Integer assetid;
    @SerializedName("requestedby")
    @Expose
    private Integer requestedby;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("clientapproval")
    @Expose
    private Boolean clientapproval;
    @SerializedName("clientapprovaldate")
    @Expose
    private String clientapprovaldate;
    @SerializedName("approvedbyid")
    @Expose
    private Integer approvedbyid;
    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("workcity")
    @Expose
    private String workcity;
    @SerializedName("workstate")
    @Expose
    private String workstate;
    @SerializedName("workpostcode")
    @Expose
    private String workpostcode;
    @SerializedName("workcountry")
    @Expose
    private String workcountry;
    @SerializedName("regionid")
    @Expose
    private String regionid;
    @SerializedName("siteid")
    @Expose
    private String siteid;
    @SerializedName("buildingname")
    @Expose
    private String buildingname;
    @SerializedName("floorno")
    @Expose
    private String floorno;
    @SerializedName("room")
    @Expose
    private String room;
    @SerializedName("attachphoto")
    @Expose
    private String attachphoto;
    @SerializedName("contactperson")
    @Expose
    private String contactperson;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("assignedto")
    @Expose
    private Integer assignedto;
    @SerializedName("assigneddate")
    @Expose
    private String assigneddate;
    @SerializedName("startdate")
    @Expose
    private String startdate;
    @SerializedName("enddate")
    @Expose
    private String enddate;
    @SerializedName("authorizedcost")
    @Expose
    private Double authorizedcost;
    @SerializedName("estimatedhour")
    @Expose
    private String estimatedhour;
    @SerializedName("escalationlevel")
    @Expose
    private Integer escalationlevel;
    @SerializedName("podate")
    @Expose
    private String podate;
    @SerializedName("subregionid")
    @Expose
    private String subregionid;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("locationid")
    @Expose
    private String locationid;
    @SerializedName("floor")
    @Expose
    private String floor;
    @SerializedName("attachedphoto")
    @Expose
    private String attachedphoto;
    @SerializedName("extensionrequired")
    @Expose
    private Boolean extensionrequired;
    @SerializedName("daterequested")
    @Expose
    private String daterequested;
    @SerializedName("extensionreason")
    @Expose
    private String extensionreason;
    @SerializedName("extensionapproved")
    @Expose
    private Boolean extensionapproved;
    @SerializedName("extensionapprovedbyid")
    @Expose
    private Integer extensionapprovedbyid;
    @SerializedName("newduedate")
    @Expose
    private String newduedate;
    @SerializedName("additionalhrs")
    @Expose
    private String additionalhrs;
    @SerializedName("estimatedworkordercost")
    @Expose
    private String estimatedworkordercost;
    @SerializedName("actualworkordercost")
    @Expose
    private Double actualworkordercost;
    @SerializedName("reportonwork")
    @Expose
    private String reportonwork;
    @SerializedName("processtype")
    @Expose
    private String processtype;
    @SerializedName("assignedtopm")
    @Expose
    private String assignedtopm;
    @SerializedName("reactivecriticality")
    @Expose
    private String reactivecriticality;
    @SerializedName("assignetoname")
    @Expose
    private String assignetoname;
    @SerializedName("landlordcommentdate")
    @Expose
    private String landlordcommentdate;
    @SerializedName("landlordcomment")
    @Expose
    private String landlordcomment;
    @SerializedName("propertymanagercommentdate")
    @Expose
    private String propertymanagercommentdate;
    @SerializedName("propertymanagercomment")
    @Expose
    private String propertymanagercomment;
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
    @SerializedName("companyworkorderno")
    @Expose
    private String companyworkorderno;
    @SerializedName("managementcompanyid")
    @Expose
    private String managementcompanyid;
    @SerializedName("templetetype")
    @Expose
    private Integer templetetype;
    @SerializedName("workername")
    @Expose
    private Integer workername;
    @SerializedName("tradecategory")
    @Expose
    private Integer tradecategory;
    @SerializedName("selectedswmstemp")
    @Expose
    private String selectedswmstemp;
    @SerializedName("riskassessmenttitle")
    @Expose
    private String riskassessmenttitle;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
  /*  @SerializedName("workOrderType")
    @Expose
    private Integer workOrderType;
    public Integer getWorkOrderType() {
        return workOrderType;
    }

    public void setWorkOrderType(Integer workOrderType) {
        this.workOrderType = workOrderType;
    }*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public String getClientno() {
        return clientno;
    }

    public void setClientno(String clientno) {
        this.clientno = clientno;
    }

    public String getPonumber() {
        return ponumber;
    }

    public void setPonumber(String ponumber) {
        this.ponumber = ponumber;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public String getWorkordernumber() {
        return workordernumber;
    }

    public void setWorkordernumber(String workordernumber) {
        this.workordernumber = workordernumber;
    }

    public String getDateraised() {
        return dateraised;
    }

    public void setDateraised(String dateraised) {
        this.dateraised = dateraised;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public Integer getWarninglevel() {
        return warninglevel;
    }

    public void setWarninglevel(Integer warninglevel) {
        this.warninglevel = warninglevel;
    }

    public Integer getEntitystatus() {
        return entitystatus;
    }

    public void setEntitystatus(Integer entitystatus) {
        this.entitystatus = entitystatus;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getWorkordertype() {
        return workordertype;
    }

    public void setWorkordertype(Integer workordertype) {
        this.workordertype = workordertype;
    }

    public String getClientworkorderno() {
        return clientworkorderno;
    }

    public void setClientworkorderno(String clientworkorderno) {
        this.clientworkorderno = clientworkorderno;
    }

    public String getOriginalworkorderno() {
        return originalworkorderno;
    }

    public void setOriginalworkorderno(String originalworkorderno) {
        this.originalworkorderno = originalworkorderno;
    }

    public Integer getAssetid() {
        return assetid;
    }

    public void setAssetid(Integer assetid) {
        this.assetid = assetid;
    }

    public Integer getRequestedby() {
        return requestedby;
    }

    public void setRequestedby(Integer requestedby) {
        this.requestedby = requestedby;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getApprovedbyid() {
        return approvedbyid;
    }

    public void setApprovedbyid(Integer approvedbyid) {
        this.approvedbyid = approvedbyid;
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

    public String getWorkcity() {
        return workcity;
    }

    public void setWorkcity(String workcity) {
        this.workcity = workcity;
    }

    public String getWorkstate() {
        return workstate;
    }

    public void setWorkstate(String workstate) {
        this.workstate = workstate;
    }

    public String getWorkpostcode() {
        return workpostcode;
    }

    public void setWorkpostcode(String workpostcode) {
        this.workpostcode = workpostcode;
    }

    public String getWorkcountry() {
        return workcountry;
    }

    public void setWorkcountry(String workcountry) {
        this.workcountry = workcountry;
    }

    public String getRegionid() {
        return regionid;
    }

    public void setRegionid(String regionid) {
        this.regionid = regionid;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getBuildingname() {
        return buildingname;
    }

    public void setBuildingname(String buildingname) {
        this.buildingname = buildingname;
    }

    public String getFloorno() {
        return floorno;
    }

    public void setFloorno(String floorno) {
        this.floorno = floorno;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getAttachphoto() {
        return attachphoto;
    }

    public void setAttachphoto(String attachphoto) {
        this.attachphoto = attachphoto;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAssignedto() {
        return assignedto;
    }

    public void setAssignedto(Integer assignedto) {
        this.assignedto = assignedto;
    }

    public String getAssigneddate() {
        return assigneddate;
    }

    public void setAssigneddate(String assigneddate) {
        this.assigneddate = assigneddate;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Double getAuthorizedcost() {
        return authorizedcost;
    }

    public void setAuthorizedcost(Double authorizedcost) {
        this.authorizedcost = authorizedcost;
    }

    public String getEstimatedhour() {
        return estimatedhour;
    }

    public void setEstimatedhour(String estimatedhour) {
        this.estimatedhour = estimatedhour;
    }

    public Integer getEscalationlevel() {
        return escalationlevel;
    }

    public void setEscalationlevel(Integer escalationlevel) {
        this.escalationlevel = escalationlevel;
    }

    public String getPodate() {
        return podate;
    }

    public void setPodate(String podate) {
        this.podate = podate;
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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getAttachedphoto() {
        return attachedphoto;
    }

    public void setAttachedphoto(String attachedphoto) {
        this.attachedphoto = attachedphoto;
    }

    public Boolean getExtensionrequired() {
        return extensionrequired;
    }

    public void setExtensionrequired(Boolean extensionrequired) {
        this.extensionrequired = extensionrequired;
    }

    public String getDaterequested() {
        return daterequested;
    }

    public void setDaterequested(String daterequested) {
        this.daterequested = daterequested;
    }

    public String getExtensionreason() {
        return extensionreason;
    }

    public void setExtensionreason(String extensionreason) {
        this.extensionreason = extensionreason;
    }

    public Boolean getExtensionapproved() {
        return extensionapproved;
    }

    public void setExtensionapproved(Boolean extensionapproved) {
        this.extensionapproved = extensionapproved;
    }

    public Integer getExtensionapprovedbyid() {
        return extensionapprovedbyid;
    }

    public void setExtensionapprovedbyid(Integer extensionapprovedbyid) {
        this.extensionapprovedbyid = extensionapprovedbyid;
    }

    public String getNewduedate() {
        return newduedate;
    }

    public void setNewduedate(String newduedate) {
        this.newduedate = newduedate;
    }

    public String getAdditionalhrs() {
        return additionalhrs;
    }

    public void setAdditionalhrs(String additionalhrs) {
        this.additionalhrs = additionalhrs;
    }

    public String getEstimatedworkordercost() {
        return estimatedworkordercost;
    }

    public void setEstimatedworkordercost(String estimatedworkordercost) {
        this.estimatedworkordercost = estimatedworkordercost;
    }

    public Double getActualworkordercost() {
        return actualworkordercost;
    }

    public void setActualworkordercost(Double actualworkordercost) {
        this.actualworkordercost = actualworkordercost;
    }

    public String getReportonwork() {
        return reportonwork;
    }

    public void setReportonwork(String reportonwork) {
        this.reportonwork = reportonwork;
    }

    public String getProcesstype() {
        return processtype;
    }

    public void setProcesstype(String processtype) {
        this.processtype = processtype;
    }

    public String getAssignedtopm() {
        return assignedtopm;
    }

    public void setAssignedtopm(String assignedtopm) {
        this.assignedtopm = assignedtopm;
    }

    public String getReactivecriticality() {
        return reactivecriticality;
    }

    public void setReactivecriticality(String reactivecriticality) {
        this.reactivecriticality = reactivecriticality;
    }

    public String getAssignetoname() {
        return assignetoname;
    }

    public void setAssignetoname(String assignetoname) {
        this.assignetoname = assignetoname;
    }

    public String getLandlordcommentdate() {
        return landlordcommentdate;
    }

    public void setLandlordcommentdate(String landlordcommentdate) {
        this.landlordcommentdate = landlordcommentdate;
    }

    public String getLandlordcomment() {
        return landlordcomment;
    }

    public void setLandlordcomment(String landlordcomment) {
        this.landlordcomment = landlordcomment;
    }

    public String getPropertymanagercommentdate() {
        return propertymanagercommentdate;
    }

    public void setPropertymanagercommentdate(String propertymanagercommentdate) {
        this.propertymanagercommentdate = propertymanagercommentdate;
    }

    public String getPropertymanagercomment() {
        return propertymanagercomment;
    }

    public void setPropertymanagercomment(String propertymanagercomment) {
        this.propertymanagercomment = propertymanagercomment;
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

    public String getCompanyworkorderno() {
        return companyworkorderno;
    }

    public void setCompanyworkorderno(String companyworkorderno) {
        this.companyworkorderno = companyworkorderno;
    }

    public String getManagementcompanyid() {
        return managementcompanyid;
    }

    public void setManagementcompanyid(String managementcompanyid) {
        this.managementcompanyid = managementcompanyid;
    }

    public Integer getTempletetype() {
        return templetetype;
    }

    public void setTempletetype(Integer templetetype) {
        this.templetetype = templetetype;
    }

    public Integer getWorkername() {
        return workername;
    }

    public void setWorkername(Integer workername) {
        this.workername = workername;
    }

    public Integer getTradecategory() {
        return tradecategory;
    }

    public void setTradecategory(Integer tradecategory) {
        this.tradecategory = tradecategory;
    }

    public String getSelectedswmstemp() {
        return selectedswmstemp;
    }

    public void setSelectedswmstemp(String selectedswmstemp) {
        this.selectedswmstemp = selectedswmstemp;
    }

    public String getRiskassessmenttitle() {
        return riskassessmenttitle;
    }

    public void setRiskassessmenttitle(String riskassessmenttitle) {
        this.riskassessmenttitle = riskassessmenttitle;
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



   /* private int id;
    private int clientId;
    private String clientNo;
    private String poNumber;
    private String workOrderNumber;
    private String dateRaised;
    private String dueDate;
    private int warningLevel;
    private int entityStatus;
    private int priority;
    private int workOrderType;
    private String clientWorkOrderNo;
    private String originalWorkOrderNo;
    private int assetId;
    private int requestedBy;
    private String description;
    private boolean clientApproval;
    private String clientApprovalDate;
    private int approvedById;
    private String address1;
    private String address2;
    private String workCity;
    private String workState;
    private String workPostCode;
    private String workCountry;
    private int regionId;
    private String siteId;
    private String buildingName;
    private String floorNo;
    private String room;
    private String attachPhoto;
    private String contactPerson;
    private String phone;
    private String mobile;
    private String email;
    private int assignedTo;
    private String assignedDate;
    private String startDate;
    private String endDate;
    private String authorizedCost;
    private String estimatedHour;
    private int escalationLevel;
    private String poDate;
    private int subRegionId;
    private int area;
    private int locationId;
    private String floor;
    private String attachedPhoto;
    private boolean extensionRequired;
    private String dateRequested;
    private String extensionReason;
    private boolean extensionApproved;
    private int extensionApprovedById;
    private String newDueDate;
    private String additionalHrs;
    private double estimatedWorkOrderCost;
    private double actualWorkOrderCost;
    private String reportonWork;
    private String processType;
    private String assignedToPM;
    private String warnnigUrl;
    private String createdDate;
    private int createdBy;
    private String updatedDate;
    private int updatedBy;
    private String deletedDate;
    private String deletedBy;
    private boolean isDeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
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

    public String getDateRaised() {
        return dateRaised;
    }

    public void setDateRaised(String dateRaised) {
        this.dateRaised = dateRaised;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(int warningLevel) {
        this.warningLevel = warningLevel;
    }

    public int getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(int entityStatus) {
        this.entityStatus = entityStatus;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getWorkOrderType() {
        return workOrderType;
    }

    public void setWorkOrderType(int workOrderType) {
        this.workOrderType = workOrderType;
    }

    public String getClientWorkOrderNo() {
        return clientWorkOrderNo;
    }

    public void setClientWorkOrderNo(String clientWorkOrderNo) {
        this.clientWorkOrderNo = clientWorkOrderNo;
    }

    public String getOriginalWorkOrderNo() {
        return originalWorkOrderNo;
    }

    public void setOriginalWorkOrderNo(String originalWorkOrderNo) {
        this.originalWorkOrderNo = originalWorkOrderNo;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public int getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(int requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isClientApproval() {
        return clientApproval;
    }

    public void setClientApproval(boolean clientApproval) {
        this.clientApproval = clientApproval;
    }

    public String getClientApprovalDate() {
        return clientApprovalDate;
    }

    public void setClientApprovalDate(String clientApprovalDate) {
        this.clientApprovalDate = clientApprovalDate;
    }

    public int getApprovedById() {
        return approvedById;
    }

    public void setApprovedById(int approvedById) {
        this.approvedById = approvedById;
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

    public String getWorkCountry() {
        return workCountry;
    }

    public void setWorkCountry(String workCountry) {
        this.workCountry = workCountry;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getAttachPhoto() {
        return attachPhoto;
    }

    public void setAttachPhoto(String attachPhoto) {
        this.attachPhoto = attachPhoto;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAuthorizedCost() {
        return authorizedCost;
    }

    public void setAuthorizedCost(String authorizedCost) {
        this.authorizedCost = authorizedCost;
    }

    public String getEstimatedHour() {
        return estimatedHour;
    }

    public void setEstimatedHour(String estimatedHour) {
        this.estimatedHour = estimatedHour;
    }

    public int getEscalationLevel() {
        return escalationLevel;
    }

    public void setEscalationLevel(int escalationLevel) {
        this.escalationLevel = escalationLevel;
    }

    public String getPoDate() {
        return poDate;
    }

    public void setPoDate(String poDate) {
        this.poDate = poDate;
    }

    public int getSubRegionId() {
        return subRegionId;
    }

    public void setSubRegionId(int subRegionId) {
        this.subRegionId = subRegionId;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getAttachedPhoto() {
        return attachedPhoto;
    }

    public void setAttachedPhoto(String attachedPhoto) {
        this.attachedPhoto = attachedPhoto;
    }

    public boolean isExtensionRequired() {
        return extensionRequired;
    }

    public void setExtensionRequired(boolean extensionRequired) {
        this.extensionRequired = extensionRequired;
    }

    public String getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(String dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getExtensionReason() {
        return extensionReason;
    }

    public void setExtensionReason(String extensionReason) {
        this.extensionReason = extensionReason;
    }

    public boolean isExtensionApproved() {
        return extensionApproved;
    }

    public void setExtensionApproved(boolean extensionApproved) {
        this.extensionApproved = extensionApproved;
    }

    public int getExtensionApprovedById() {
        return extensionApprovedById;
    }

    public void setExtensionApprovedById(int extensionApprovedById) {
        this.extensionApprovedById = extensionApprovedById;
    }

    public String getNewDueDate() {
        return newDueDate;
    }

    public void setNewDueDate(String newDueDate) {
        this.newDueDate = newDueDate;
    }

    public String getAdditionalHrs() {
        return additionalHrs;
    }

    public void setAdditionalHrs(String additionalHrs) {
        this.additionalHrs = additionalHrs;
    }

    public double getEstimatedWorkOrderCost() {
        return estimatedWorkOrderCost;
    }

    public void setEstimatedWorkOrderCost(int estimatedWorkOrderCost) {
        this.estimatedWorkOrderCost = estimatedWorkOrderCost;
    }

    public double getActualWorkOrderCost() {
        return actualWorkOrderCost;
    }

    public void setActualWorkOrderCost(int actualWorkOrderCost) {
        this.actualWorkOrderCost = actualWorkOrderCost;
    }

    public String getReportonWork() {
        return reportonWork;
    }

    public void setReportonWork(String reportonWork) {
        this.reportonWork = reportonWork;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getAssignedToPM() {
        return assignedToPM;
    }

    public void setAssignedToPM(String assignedToPM) {
        this.assignedToPM = assignedToPM;
    }

    public String getWarnnigUrl() {
        return warnnigUrl;
    }

    public void setWarnnigUrl(String warnnigUrl) {
        this.warnnigUrl = warnnigUrl;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
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

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }*/
}