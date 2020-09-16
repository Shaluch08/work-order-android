package com.workorder.app.pojo.survey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SurveyTempPOJO implements Serializable {

    @SerializedName("workOrderId")
    @Expose
    private String workOrderId;

    @SerializedName("surveyTemplateId")
    @Expose
    private String surveyTemplateId;

    @SerializedName("surveyName")
    @Expose
    private String surveyName;

    @SerializedName("surveyDetail")
    @Expose
    private String surveyDetail;

    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getSurveyTemplateId() {
        return surveyTemplateId;
    }

    public void setSurveyTemplateId(String surveyTemplateId) {
        this.surveyTemplateId = surveyTemplateId;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getSurveyDetail() {
        return surveyDetail;
    }

    public void setSurveyDetail(String surveyDetail) {
        this.surveyDetail = surveyDetail;
    }
}
