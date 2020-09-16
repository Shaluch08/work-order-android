package com.workorder.app.workorderapplication.remote;


import com.workorder.app.pojo.CreateActivityPOJO;
import com.workorder.app.pojo.CreateAssetPOJO;
import com.workorder.app.workorderapplication.activity.Demo;
import com.workorder.app.workorderapplication.model.Pojo;
import com.workorder.app.workorderapplication.model.UpdateAssetPOJO;
import com.workorder.app.workorderapplication.model.assetModel.AssetCategoryDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.AssetConditionDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.AssetCreateResponsePOJO;
import com.workorder.app.workorderapplication.model.assetModel.AssetDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.AssetLocationResponse;
import com.workorder.app.workorderapplication.model.assetModel.AssetRequestModel;
import com.workorder.app.workorderapplication.model.assetModel.AssetResponseModel;
import com.workorder.app.workorderapplication.model.assetModel.AssetStatusDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.AssetTypeDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.ComponentOfAssetDropDown;
import com.workorder.app.workorderapplication.model.assetModel.ContractTypeDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.EditAssetsDetails;
import com.workorder.app.workorderapplication.model.assetModel.InspectionFrequencyDropDown;
import com.workorder.app.workorderapplication.model.assetModel.MaintenanceFrequencyDropDown;
import com.workorder.app.workorderapplication.model.assetModel.MaintenanceStrategyDropDown;
import com.workorder.app.workorderapplication.model.assetModel.OldAssetDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.ReactiveCriticalityDropDown;
import com.workorder.app.workorderapplication.model.assetModel.SubCategoryDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.SupplierDropDownList;
import com.workorder.app.workorderapplication.model.clientList.ClientListResponse;
import com.workorder.app.workorderapplication.model.clientList.ClientResponse;
import com.workorder.app.workorderapplication.model.dashboardModel.DashBoardAdmin;
import com.workorder.app.workorderapplication.model.dashboardModel.DashBoardResponse;
import com.workorder.app.workorderapplication.model.dashboardModel.DashboardClient;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.DashBoardContractor;
import com.workorder.app.workorderapplication.model.history.HistoryDetailsModel;
import com.workorder.app.workorderapplication.model.history.HistoryModel;
import com.workorder.app.workorderapplication.model.login.LoginRequestModel;
import com.workorder.app.workorderapplication.model.login.LoginResponseModel;
import com.workorder.app.workorderapplication.model.materialModel.MaterialEditList;
import com.workorder.app.workorderapplication.model.materialModel.MaterialList;
import com.workorder.app.workorderapplication.model.materialModel.MaterialRequest;
import com.workorder.app.workorderapplication.model.purchaseOrderModel.PurchaseOrderResponseModel;
import com.workorder.app.workorderapplication.model.workOrderModel.AproveByDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.AreaDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.BuildingDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.ClientDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.ContactPersonDetails;
import com.workorder.app.workorderapplication.model.workOrderModel.ContactPersonDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.ContractorAssignDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.EditWorkOrderDetails;
import com.workorder.app.workorderapplication.model.workOrderModel.FloorDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.OrderStatusDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.OrderTypeDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.OriginalOrderDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.PriorityDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.PurchaseOrderDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.RegionDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.RequestByDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.RoomDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.SubRegionDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.UpdateWorkOrderAllocation;
import com.workorder.app.workorderapplication.model.workOrderModel.UpdateWorkOrderRequest;
import com.workorder.app.workorderapplication.model.workOrderModel.WOCreateSuccessPOJO;
import com.workorder.app.workorderapplication.model.workOrderModel.WarningLevelDropDownList;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderAllocationListResponse;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderAllocationRequest;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderPostResquest;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderResponseModel;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkerDropDownList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Bharat Tripathi on 02-May-18.
 */

public interface ApiServicesWorkOrder {
    @POST("api/account/login")
    public Call<LoginResponseModel> postLogin(
            @Header("Content-Type")
                    String headerValue,
            @Body LoginRequestModel loginRequestModel
    );

    @POST("api/order/createorders")
    public Call<WOCreateSuccessPOJO> workOrderResponse(
            @Header("Content-Type")
                    String headerValue,
            @Body WorkOrderPostResquest postResquest
    );

    @POST("api/order/UpdateWorkOrderDetails")
    public Call<WOCreateSuccessPOJO> updateWorkOrder(
            @Header("Content-Type")
                    String headerValue,
            @Body UpdateWorkOrderRequest request
    );

    @POST("api/assets/UpdateAssetDetails")
    public Call<AssetCreateResponsePOJO> updateAsset(
            @Header("Content-Type")
                    String headerValue,
            @Body UpdateAssetPOJO request
    );

    //   @Field("companyid")
    //                    String fieldValue,


    @POST("api/assets/createassets")
    public Call<AssetCreateResponsePOJO> createAsset(
            @Header("Content-Type")
                    String headerValue,
            @Body CreateAssetPOJO request
    );

    @POST("api/workerperson/updateAllocation")
    public Call<String> updateWorkAllocation(
            @Header("Content-Type")
                    String headerValue,
            @Body UpdateWorkOrderAllocation request
    );

    @POST("api/workerperson/createAllocation")
    public Call<String> createAllocation(
            @Header("Content-Type")
                    String headerValue,
            @Body WorkOrderAllocationRequest request
    );

    @POST("api/WorkMaterial/createMaterial")
    public Call<String> createMaterial(
            @Header("Content-Type")
                    String headerValue,
            @Body MaterialRequest request
    );

    @POST("api/WorkMaterial/updateMaterial")
    public Call<String> updateMaterial(
            @Header("Content-Type")
                    String headerValue,
            @Body MaterialEditList request
    );

    @GET
    Call<List<WorkerDropDownList>> workerDropDownList(@Header("Content-Type")
                                                              String headerValue,
                                                      @Url String url);

    @GET
    Call<UpdateWorkOrderAllocation> updateList(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );

    @GET
    public Call<String> deletematerial(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );

    @GET
    public Call<String> deleteWorkAllocation(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );

    @GET
    Call<List<WorkOrderAllocationListResponse>> allocationList(@Header("Content-Type") String headerValue, @Url String url);

    @GET
    Call<String> delete(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );


    // for Fetch Work Order List
    @GET
    Call<List<WorkOrderResponseModel>> workOrderList(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );

    @GET
    Call<List<WorkOrderResponseModel>> workerlist(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );

    @GET
    Call<EditWorkOrderDetails> editworkOrderDetails(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );

    @GET
    Call<MaterialEditList> editmaterialDetails(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );

    @GET
    Call<EditAssetsDetails> editAssetDetails(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );

    @GET
    Call<String> updateWorkOrderStatus(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );


    //For Fetch Asset List
    @GET
    Call<List<AssetResponseModel>> assetList(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );

    //For Fetch PO List
    @GET
    Call<List<PurchaseOrderResponseModel>> poList(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );
//For Work Order All DropDownList

    @GET
    Call<List<ClientDropDownList>> clientdropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<OrderStatusDropDownList>> oredrstatusdropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<PriorityDropDownList>> prioritydropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<PurchaseOrderDropDownList>> podropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<OrderTypeDropDownList>> otdropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<RegionDropDownList>> regiondropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<AreaDropDownList>> areadropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<AssetLocationResponse>> locationdropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<BuildingDropDownList>> buildingdropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<AssetDropDownList>> assetdropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<ContractorAssignDropDownList>> contractordropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<RequestByDropDownList>> requestbyordropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<ContactPersonDropDownList>> contactpersonbyordropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<AproveByDropDownList>> aprovebyordropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<OriginalOrderDropDownList>> originalorderdropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<SubRegionDropDownList>> subregionorderdropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<FloorDropDownList>> floordropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<RoomDropDownList>> roomdropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<WarningLevelDropDownList>> wldropdown(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<ContactPersonDetails> contactPersonDetails(
            @Header("Content-Type")
                    String headreValue,
            @Url
                    String url
    );

    @GET
    Call<List<AssetDropDownList>> assetDropDownList(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );

    @GET
    Call<List<AssetTypeDropDownList>> assetTypeDropDownList(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );


    @GET
    Call<List<Pojo>> TitleForregistretion(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );

    @GET
    Call<List<AssetStatusDropDownList>> assetStatusDropDownList(@Header("Content-Type")
                                                                        String headerValue,
                                                                @Url String url);

    @GET
    Call<List<ContractTypeDropDownList>> ctDropDownList(@Header("Content-Type")
                                                                String headerValue,
                                                        @Url String url);

    @GET
    Call<List<AssetCategoryDropDownList>> assetcatDropDownList(@Header("Content-Type")
                                                                       String headerValue,
                                                               @Url String url);

    @GET
    Call<List<SubCategoryDropDownList>> subcatDropDownList(@Header("Content-Type")
                                                                   String headerValue,
                                                           @Url String url);

    @GET
    Call<List<AssetConditionDropDownList>> conditionDropDownList(@Header("Content-Type")
                                                                         String headerValue,
                                                                 @Url String url);

    @GET
    Call<List<ReactiveCriticalityDropDown>> rcDropDownList(@Header("Content-Type")
                                                                   String headerValue,
                                                           @Url String url);

    @GET
    Call<List<InspectionFrequencyDropDown>> ifDropDownList(@Header("Content-Type")
                                                                   String headerValue,
                                                           @Url String url);

    @GET
    Call<List<MaintenanceFrequencyDropDown>> mainfreqDropDownList(@Header("Content-Type")
                                                                          String headerValue,
                                                                  @Url String url);

    @GET
    Call<List<MaintenanceStrategyDropDown>> mainStrtDropDownList(@Header("Content-Type")
                                                                         String headerValue,
                                                                 @Url String url);

    @GET
    Call<List<OldAssetDropDownList>> oldAssetDropDownList(@Header("Content-Type")
                                                                  String headerValue,
                                                          @Url String url);

    @GET
    Call<List<SupplierDropDownList>> supplierDropDownList(@Header("Content-Type")
                                                                  String headerValue,
                                                          @Url String url);

    @GET
    Call<List<ComponentOfAssetDropDown>> comassetDropDownList(@Header("Content-Type")
                                                                      String headerValue,
                                                              @Url String url);

    @GET
    Call<List<ClientListResponse>> clientList(@Header("Content-Type")
                                                      String headerValue,
                                              @Url String url);

    @GET
    Call<List<ClientResponse>> List(@Header("Content-Type")
                                            String headerValue,
                                    @Url String url);

    @GET
    Call<List<MaterialList>> materialList(@Header("Content-Type")
                                                  String headerValue,
                                          @Url String url);

    @GET
    Call<DashBoardResponse> dashBoardListFm(@Header("Content-Type")
                                                    String headerValue,
                                            @Url String url);

    @GET
    Call<DashBoardContractor> dashBoardListContractor(@Header("Content-Type")
                                                              String headerValue,
                                                      @Url String url);


    @GET
    Call<DashBoardAdmin> dashBoardListAdmin(@Header("Content-Type")
                                                              String headerValue,
                                                 @Url String url);



    @GET
    Call<List<HistoryModel>> historyWOList(@Header("Content-Type")
                                                   String headerValue,
                                           @Url String url);

    @GET
    Call<List<HistoryDetailsModel>> historyDetailsWOList(@Header("Content-Type")
                                                                 String headerValue,
                                                         @Url String url);

    @GET
    Call<List<HistoryModel>> historyAssetList(@Header("Content-Type")
                                                      String headerValue,
                                              @Url String url);

    @GET
    Call<List<HistoryDetailsModel>> historyDetailsAssetList(@Header("Content-Type")
                                                                    String headerValue,
                                                            @Url String url);


    @GET
    Call<String> UpdateReportToWork(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );


    @GET
    Call<String> ExtensionRequierd(
            @Header("Content-Type")
                    String headerValue,
            @Url String url
    );

    @GET
    Call<DashboardClient> dashBoardListClient(@Header("Content-Type")
                                           String headerValue,
                                              @Url String url);


    @POST("api/SiteActivity/createactivity")
    public Call<String> createActivity(
            @Header("Content-Type")
                    String headerValue,
            @Body CreateActivityPOJO request
    );

}
