package com.workorder.app.util;

import com.workorder.app.activity.HomeActivity;
import com.workorder.app.pojo.CreateAssetPOJO;
import com.workorder.app.pojo.GetSiteByIdPOJO;
import com.workorder.app.pojo.GetWorkerPOJO;
import com.workorder.app.pojo.HomeStatusPOJO;
import com.workorder.app.pojo.LoginPOJO;
import com.workorder.app.pojo.WorkOrderPOJO;
import com.workorder.app.pojo.assesment.AssesmentHomePOJO;
import com.workorder.app.pojo.docPOJO.DocListPOJO;
import com.workorder.app.pojo.survey.SurveyPOJO;
import com.workorder.app.pojo.survey.SurveyTempPOJO;
import com.workorder.app.search_autocomplete.Prediction;
import com.workorder.app.workorderapplication.model.UpdateAssetPOJO;
import com.workorder.app.workorderapplication.model.assetModel.AssetRequestModel;
import com.workorder.app.workorderapplication.model.assetModel.EditAssetsDetails;
import com.workorder.app.workorderapplication.model.workOrderModel.EditWorkOrderDetails;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderPostResquest;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderResponseModel;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static List<GetSiteByIdPOJO> getSiteList=new ArrayList<>();
    public static List<GetWorkerPOJO> workerPOJOList=new ArrayList<>();
    //public static LoginResponseWorkOrderModel loginResponse;

    public static List<AssesmentHomePOJO> assesmentHomePOJOList=new ArrayList<>();

    public static List<WorkOrderPOJO> workOrderPOJOList=new ArrayList<>();
    public static List<SurveyPOJO> surveyList=new ArrayList<>();
    public static List<SurveyTempPOJO> surveytemplateList=new ArrayList<>();


    public static HomeStatusPOJO homeStatusPOJO;

    public static String USER_ID="";
    public static AssesmentHomePOJO assesmentHomePOJO;

    public static WorkOrderPOJO workOrderPOJO;
    public static DocListPOJO docListPOJO;

    public static SurveyPOJO surveyPOJO;


    public static LoginPOJO loginPOJO;

    public static int SEND_STATUS;
    public static String SEND_STATUS1;
    public static int CHECKED_POSITION=-1;


    public static int TIME_PERIOD=-1;


    public static double CURRENT_LAT;
    public static double CURRENT_LNG;
    public static String PROVIDER="";
    public static String DISTANCE="";

    public static String TASK_ID="67";
    public static final String HOME_ACTIVITY="home activity is opened";
    public static final String SHOW_DOCUMENT_ACTIVITY="Show Document activity is opened";
    public static final String SHOW_SURVEY_ACTIVITY="Show SURVEY activity is opened";
    public static String ACTIVITY_NAME= HOME_ACTIVITY;


    public static WorkOrderPostResquest workOrderPostResquest;

    public static Prediction prediction;
    public static String FROM_CITY="";
    public static String FROM_COUNTRY="";
    public static String TO_COUNTRY="";

    public static List<WorkOrderResponseModel> workOrderList=new ArrayList<>();
    public static CreateAssetPOJO createAssetModel=new CreateAssetPOJO();
    public static UpdateAssetPOJO updateAssetPOJO=new UpdateAssetPOJO();

    public static EditAssetsDetails assetsDetails;

    public static EditWorkOrderDetails orderDetails;

    public static EditWorkOrderDetails workOrderDetails;



}
