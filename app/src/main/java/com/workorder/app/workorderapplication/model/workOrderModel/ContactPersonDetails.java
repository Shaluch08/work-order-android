package com.workorder.app.workorderapplication.model.workOrderModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactPersonDetails {

    @Expose
    private String businessPhone;
    @SerializedName("businessMobile")
    @Expose
    private String businessMobile;
    @SerializedName("businessEmail")
    @Expose
    private String businessEmail;


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


    }
