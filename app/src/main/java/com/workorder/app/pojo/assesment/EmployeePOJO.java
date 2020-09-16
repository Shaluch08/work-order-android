package com.workorder.app.pojo.assesment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EmployeePOJO implements Serializable {
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("companyName")
    @Expose
    private String companyName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("locationType")
    @Expose
    private String locationType;
    @SerializedName("locationCode")
    @Expose
    private String locationCode;
    @SerializedName("dashboardID")
    @Expose
    private String dashboardID;
    @SerializedName("hoursPerDay")
    @Expose
    private String hoursPerDay;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("resourced")
    @Expose
    private Boolean resourced;
    @SerializedName("personStatus")
    @Expose
    private String personStatus;
    @SerializedName("personalPhone")
    @Expose
    private String personalPhone;
    @SerializedName("personalMobile")
    @Expose
    private String personalMobile;
    @SerializedName("personalEmail")
    @Expose
    private String personalEmail;
    @SerializedName("personalFax")
    @Expose
    private String personalFax;
    @SerializedName("personalBleeper")
    @Expose
    private String personalBleeper;
    @SerializedName("personalWebAddr")
    @Expose
    private String personalWebAddr;
    @SerializedName("personalAddress1")
    @Expose
    private String personalAddress1;
    @SerializedName("personalAddress2")
    @Expose
    private String personalAddress2;
    @SerializedName("personalCity")
    @Expose
    private String personalCity;
    @SerializedName("personalState")
    @Expose
    private String personalState;
    @SerializedName("personalCountry")
    @Expose
    private String personalCountry;
    @SerializedName("businessPhone")
    @Expose
    private String businessPhone;
    @SerializedName("businessMobile")
    @Expose
    private String businessMobile;
    @SerializedName("businessEmail")
    @Expose
    private String businessEmail;
    @SerializedName("businessFax")
    @Expose
    private String businessFax;
    @SerializedName("businessWebAddr")
    @Expose
    private String businessWebAddr;
    @SerializedName("businessBleeper")
    @Expose
    private String businessBleeper;
    @SerializedName("businessCity")
    @Expose
    private String businessCity;
    @SerializedName("businessState")
    @Expose
    private String businessState;
    @SerializedName("businessCountry")
    @Expose
    private String businessCountry;
    @SerializedName("businessAddress1")
    @Expose
    private String businessAddress1;
    @SerializedName("businessAddress2")
    @Expose
    private String businessAddress2;
    @SerializedName("roleId")
    @Expose
    private String roleId;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("innerAllocation")
    @Expose
    private String innerAllocation;
    @SerializedName("innerAvailability")
    @Expose
    private String innerAvailability;
    @SerializedName("innerHourlyRates")
    @Expose
    private String innerHourlyRates;
    @SerializedName("outOfHour")
    @Expose
    private Boolean outOfHour;
    @SerializedName("outOfHourContactName")
    @Expose
    private String outOfHourContactName;
    @SerializedName("outOfHourEmail")
    @Expose
    private String outOfHourEmail;
    @SerializedName("outOfHourStartTime")
    @Expose
    private String outOfHourStartTime;
    @SerializedName("outOfHourEndTime")
    @Expose
    private String outOfHourEndTime;
    @SerializedName("companyType")
    @Expose
    private String companyType;
    @SerializedName("parentPersonID")
    @Expose
    private String parentPersonID;
    @SerializedName("parentPerson")
    @Expose
    private String parentPerson;
    @SerializedName("personalPostCode")
    @Expose
    private String personalPostCode;
    @SerializedName("businessPostCode")
    @Expose
    private String businessPostCode;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("assignToID")
    @Expose
    private String assignToID;
    @SerializedName("assignTo")
    @Expose
    private String assignTo;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getDashboardID() {
        return dashboardID;
    }

    public void setDashboardID(String dashboardID) {
        this.dashboardID = dashboardID;
    }

    public String getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(String hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
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

    public Boolean getResourced() {
        return resourced;
    }

    public void setResourced(Boolean resourced) {
        this.resourced = resourced;
    }

    public String getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(String personStatus) {
        this.personStatus = personStatus;
    }

    public String getPersonalPhone() {
        return personalPhone;
    }

    public void setPersonalPhone(String personalPhone) {
        this.personalPhone = personalPhone;
    }

    public String getPersonalMobile() {
        return personalMobile;
    }

    public void setPersonalMobile(String personalMobile) {
        this.personalMobile = personalMobile;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getPersonalFax() {
        return personalFax;
    }

    public void setPersonalFax(String personalFax) {
        this.personalFax = personalFax;
    }

    public String getPersonalBleeper() {
        return personalBleeper;
    }

    public void setPersonalBleeper(String personalBleeper) {
        this.personalBleeper = personalBleeper;
    }

    public String getPersonalWebAddr() {
        return personalWebAddr;
    }

    public void setPersonalWebAddr(String personalWebAddr) {
        this.personalWebAddr = personalWebAddr;
    }

    public String getPersonalAddress1() {
        return personalAddress1;
    }

    public void setPersonalAddress1(String personalAddress1) {
        this.personalAddress1 = personalAddress1;
    }

    public String getPersonalAddress2() {
        return personalAddress2;
    }

    public void setPersonalAddress2(String personalAddress2) {
        this.personalAddress2 = personalAddress2;
    }

    public String getPersonalCity() {
        return personalCity;
    }

    public void setPersonalCity(String personalCity) {
        this.personalCity = personalCity;
    }

    public String getPersonalState() {
        return personalState;
    }

    public void setPersonalState(String personalState) {
        this.personalState = personalState;
    }

    public String getPersonalCountry() {
        return personalCountry;
    }

    public void setPersonalCountry(String personalCountry) {
        this.personalCountry = personalCountry;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getBusinessMobile() {
        return businessMobile;
    }

    public void setBusinessMobile(String businessMobile) {
        this.businessMobile = businessMobile;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getBusinessFax() {
        return businessFax;
    }

    public void setBusinessFax(String businessFax) {
        this.businessFax = businessFax;
    }

    public String getBusinessWebAddr() {
        return businessWebAddr;
    }

    public void setBusinessWebAddr(String businessWebAddr) {
        this.businessWebAddr = businessWebAddr;
    }

    public String getBusinessBleeper() {
        return businessBleeper;
    }

    public void setBusinessBleeper(String businessBleeper) {
        this.businessBleeper = businessBleeper;
    }

    public String getBusinessCity() {
        return businessCity;
    }

    public void setBusinessCity(String businessCity) {
        this.businessCity = businessCity;
    }

    public String getBusinessState() {
        return businessState;
    }

    public void setBusinessState(String businessState) {
        this.businessState = businessState;
    }

    public String getBusinessCountry() {
        return businessCountry;
    }

    public void setBusinessCountry(String businessCountry) {
        this.businessCountry = businessCountry;
    }

    public String getBusinessAddress1() {
        return businessAddress1;
    }

    public void setBusinessAddress1(String businessAddress1) {
        this.businessAddress1 = businessAddress1;
    }

    public String getBusinessAddress2() {
        return businessAddress2;
    }

    public void setBusinessAddress2(String businessAddress2) {
        this.businessAddress2 = businessAddress2;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getInnerAllocation() {
        return innerAllocation;
    }

    public void setInnerAllocation(String innerAllocation) {
        this.innerAllocation = innerAllocation;
    }

    public String getInnerAvailability() {
        return innerAvailability;
    }

    public void setInnerAvailability(String innerAvailability) {
        this.innerAvailability = innerAvailability;
    }

    public String getInnerHourlyRates() {
        return innerHourlyRates;
    }

    public void setInnerHourlyRates(String innerHourlyRates) {
        this.innerHourlyRates = innerHourlyRates;
    }

    public Boolean getOutOfHour() {
        return outOfHour;
    }

    public void setOutOfHour(Boolean outOfHour) {
        this.outOfHour = outOfHour;
    }

    public String getOutOfHourContactName() {
        return outOfHourContactName;
    }

    public void setOutOfHourContactName(String outOfHourContactName) {
        this.outOfHourContactName = outOfHourContactName;
    }

    public String getOutOfHourEmail() {
        return outOfHourEmail;
    }

    public void setOutOfHourEmail(String outOfHourEmail) {
        this.outOfHourEmail = outOfHourEmail;
    }

    public String getOutOfHourStartTime() {
        return outOfHourStartTime;
    }

    public void setOutOfHourStartTime(String outOfHourStartTime) {
        this.outOfHourStartTime = outOfHourStartTime;
    }

    public String getOutOfHourEndTime() {
        return outOfHourEndTime;
    }

    public void setOutOfHourEndTime(String outOfHourEndTime) {
        this.outOfHourEndTime = outOfHourEndTime;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getParentPersonID() {
        return parentPersonID;
    }

    public void setParentPersonID(String parentPersonID) {
        this.parentPersonID = parentPersonID;
    }

    public String getParentPerson() {
        return parentPerson;
    }

    public void setParentPerson(String parentPerson) {
        this.parentPerson = parentPerson;
    }

    public String getPersonalPostCode() {
        return personalPostCode;
    }

    public void setPersonalPostCode(String personalPostCode) {
        this.personalPostCode = personalPostCode;
    }

    public String getBusinessPostCode() {
        return businessPostCode;
    }

    public void setBusinessPostCode(String businessPostCode) {
        this.businessPostCode = businessPostCode;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAssignToID() {
        return assignToID;
    }

    public void setAssignToID(String assignToID) {
        this.assignToID = assignToID;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
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
