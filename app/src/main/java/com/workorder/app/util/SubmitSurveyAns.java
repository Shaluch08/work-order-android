package com.workorder.app.util;

import org.json.JSONArray;

public class SubmitSurveyAns {

    String questionID ;String answerID;String surveyAnswerID; String surveyID; String SurveyorIDt;

    public SubmitSurveyAns(String questionID ,String answerID,String surveyAnswerID, String surveyID, String SurveyorIDt){

        this.questionID = questionID;

        this.answerID = answerID;

        this.surveyAnswerID = surveyAnswerID;

        this.surveyID = surveyID;

        this.SurveyorIDt = SurveyorIDt;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    public String getSurveyAnswerID() {
        return surveyAnswerID;
    }

    public void setSurveyAnswerID(String surveyAnswerID) {
        this.surveyAnswerID = surveyAnswerID;
    }

    public String getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(String surveyID) {
        this.surveyID = surveyID;
    }

    public String getSurveyorIDt() {
        return SurveyorIDt;
    }

    public void setSurveyorIDt(String surveyorIDt) {
        SurveyorIDt = surveyorIDt;
    }
}
