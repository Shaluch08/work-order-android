package com.workorder.app.workorderapplication.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.model.assetModel.AssetDropDownList;
import com.workorder.app.workorderapplication.model.assetModel.EditAssetsDetails;
import com.workorder.app.workorderapplication.model.dashboardModel.AdminTreeStructure;
import com.workorder.app.workorderapplication.model.dashboardModel.AssetList;
import com.workorder.app.workorderapplication.model.dashboardModel.ClientList;
import com.workorder.app.workorderapplication.model.dashboardModel.ClientPO;
import com.workorder.app.workorderapplication.model.dashboardModel.ClientTreeStructure;
import com.workorder.app.workorderapplication.model.dashboardModel.Conrector;
import com.workorder.app.workorderapplication.model.dashboardModel.Treestuctutr;
import com.workorder.app.workorderapplication.model.dashboardModel.WorkOrderList;
import com.workorder.app.workorderapplication.model.dashboardModel.WorkerList;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ClientContract;
import com.workorder.app.workorderapplication.model.dashboardModel.contractor.ContrctTree;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;
import com.workorder.app.workorderapplication.treeview.TreeNode;
import com.workorder.app.workorderapplication.treeview.TreeView;

import java.util.ArrayList;
import java.util.List;

public class TreeStructure extends AppCompatActivity {
    public ViewGroup viewGroup;
    public TreeNode root;
    public TreeView treeView;
    int siz;
    EditAssetsDetails editAssetsDetails;
    ArrayList<Treestuctutr> arrayList;
    ArrayList<ContrctTree> contrctTrees;
    ArrayList<ClientTreeStructure> clientTreelist;
    ArrayList<ClientList> clientLists;
    ArrayList<ClientPO> clientPOArrayList;
    ArrayList<AdminTreeStructure> adminTreeStructures;
    ArrayList<ClientPO> clientDemoPOArrayList;
    ArrayList<Conrector> conrectorDemoArrayList;
    ArrayList<Conrector> conrectorArrayList;
    ArrayList<WorkOrderList> workOrderListArrayList;
    ArrayList<WorkOrderList> workOrderDemoList;
    ArrayList<AssetList> assetListArrayList;
    ArrayList<WorkerList> workerListArrayList;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;
    String image_url="http://109.228.49.117:8095/WarningLevel/SmallImage/";
    ArrayList<ClientContract> clientContracts;
    ArrayList<AssetDropDownList> assetDropDownLists;
    String ClientName="",ClientId="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_structure);

        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(getApplicationContext());

        if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager")) {
            ArrayList<Treestuctutr> list= (ArrayList<Treestuctutr>) getIntent().getSerializableExtra("list");
            arrayList=list;

        }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")){
            ArrayList<ContrctTree> contrctTreeArrayList=(ArrayList<ContrctTree>)getIntent().getSerializableExtra("contrctTreeList");
            contrctTrees=contrctTreeArrayList;
        }else if (preferenceManagerWorkOrder.getKey_User_Role().toString().equals("Client")){

//            ArrayList<Demo.TreestuctutrBean> clientlist= (ArrayList<Demo.TreestuctutrBean>) getIntent().getSerializableExtra("clientlist");
//
//            Demo demo = null;
//            clientlist=(ArrayList<Demo.TreestuctutrBean>) demo.getTreestuctutr();
            clientTreelist= (ArrayList<ClientTreeStructure>) getIntent().getSerializableExtra("clientlist");//MainActivity.clientlist;

            String CName=clientTreelist.get(0).getClientName();
            String CImg=clientTreelist.get(0).getWarnnigUrl();
            int CId=clientTreelist.get(0).getClientID();

            ClientName=CName;
            ClientId= String.valueOf(CId);
        }else {
            ArrayList<AdminTreeStructure> list= (ArrayList<AdminTreeStructure>) getIntent().getSerializableExtra("adminlist");
            adminTreeStructures=list;
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Action Escalation Tree");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }



        viewGroup = (RelativeLayout) findViewById(R.id.container);
        root = TreeNode.root();

        buildTree();

        treeView = new TreeView(root, TreeStructure.this, new MyNodeViewFactory());
        View view = treeView.getView();
        view.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        viewGroup.addView(view);

        /*
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
              try {

                  viewGroup = (RelativeLayout) findViewById(R.id.container);
                  root = TreeNode.root();
                  buildTree();
                  treeView = new TreeView(root, TreeStructure.this, new MyNodeViewFactory());
                  View view = treeView.getView();
                  view.setLayoutParams(new ViewGroup.LayoutParams(
                          ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                  viewGroup.addView(view);

                  Thread.sleep(100);

              }catch (Exception e){

              }
            }
        });
        */

    }
    public void buildTreeAsset()
    {

    }
    public void buildTree() {
        try
        {
            if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Finance Manager"))
            {
                for (int i = 0; i <arrayList.size(); i++) {
                    String fmimage=image_url+arrayList.get(i).getWarnnigUrl();
                    TreeNode treeNode = new TreeNode("FM Manager:-"+arrayList.get(i).getFmName()+"\t"+fmimage);
                    treeNode.setLevel(0);
                    clientLists= (ArrayList<ClientList>) arrayList.get(i).getClientList();
                    ArrayList<ClientList> clientListArrayList=clientLists;
                    for (int j = 0; j < clientListArrayList.size(); j++) {
                        String clientimage=image_url+clientListArrayList.get(j).getWarnnigUrl();
                        TreeNode treeNode1 = new TreeNode("Client:-"+clientListArrayList.get(j).getClientName()+"\t"+clientimage);
                        treeNode1.setLevel(1);
                        TreeNode treeNode2 = new TreeNode("Purchase Order");
                        treeNode2.setLevel(2);
                        clientPOArrayList= (ArrayList<ClientPO>) clientLists.get(j).getClientPO();
                        ArrayList<ClientPO> clientPOs=clientPOArrayList;
                        for(int po=0;po<clientPOs.size();po++)
                        {
                            String poimage=image_url+clientPOs.get(po).getWarnnigUrl();
                            TreeNode treeNode4=new TreeNode(clientPOs.get(po).getPoName()+"\t"+poimage);
                            treeNode4.setLevel(3);
                            treeNode2.addChild(treeNode4);
                        }
                        treeNode1.addChild(treeNode2);
                        TreeNode treeNode3=new TreeNode("Contractors");
                        treeNode3.setLevel(2);
                        conrectorArrayList= (ArrayList<Conrector>) clientLists.get(j).getConrector();
                        ArrayList<Conrector> conrectors=conrectorArrayList;
                        for(int con=0;con<conrectors.size();con++)
                        {
                            String contrctimage=image_url+conrectors.get(con).getWarnnigUrl();
                            TreeNode treeNode5=new TreeNode(conrectors.get(con).getContName()+"\t"+contrctimage);
                            treeNode5.setLevel(3);
                            TreeNode treeNode6=new TreeNode("Work Order");
                            treeNode6.setLevel(4);
                            workOrderListArrayList= (ArrayList<WorkOrderList>) conrectors.get(con).getWorkOrderList();
                            ArrayList<WorkOrderList> workOrderLists=workOrderListArrayList;

                            for(int n=0;n<workOrderLists.size();n++) {
                                String woimage=image_url+workOrderLists.get(n).getWarnnigUrl();
                                final TreeNode treeNode7 = new TreeNode(workOrderLists.get(n).getWorkOrderNumber()+"\t"+woimage);
                                treeNode7.setLevel(5);
                                TreeNode treeNode8=new TreeNode("Asset");
                                treeNode8.setLevel(6);
                                assetListArrayList= (ArrayList<AssetList>) workOrderListArrayList.get(n).getAssetList();
                                ArrayList<AssetList> assetLists=assetListArrayList;
                                for(int l=0;l<assetLists.size();l++)
                                {
                                    String assetimage=image_url+assetLists.get(l).getWarnnigUrl();
                                    TreeNode treeNode10=new TreeNode(assetLists.get(l).getAssetName()+"\t"+assetimage);
                                    treeNode10.setLevel(7);
                                    treeNode8.addChild(treeNode10);
                                }
                                treeNode7.addChild(treeNode8);
                                TreeNode treeNode9=new TreeNode("Worker");
                                treeNode9.setLevel(6);
                                workerListArrayList= (ArrayList<WorkerList>) workOrderListArrayList.get(n).getWorkerList();
                                ArrayList<WorkerList> workerLists=workerListArrayList;
                                for(int w=0;w<workerLists.size();w++)
                                {
                                    String workerimage=image_url+workerLists.get(w).getWarnnigUrl();
                                    TreeNode treeNode11=new TreeNode(workerLists.get(w).getWorkerName()+"\t"+workerimage);
                                    treeNode11.setLevel(7);
                                    treeNode9.addChild(treeNode11);
                                }
                                treeNode7.addChild(treeNode9);
                                treeNode6.addChild(treeNode7);
                            }
                            treeNode5.addChild(treeNode6);
                            treeNode3.addChild(treeNode5);
                        }
                        treeNode1.addChild(treeNode3);
                        treeNode.addChild(treeNode1);
                    }
                    root.addChild(treeNode);
                }
            }else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Contractor")) {
                String clientimage=null;
                for(int g=0;g<contrctTrees.size();g++)
                {
                    clientContracts=contrctTrees.get(g).getClientContracts();
                    clientimage=image_url+clientContracts.get(g).getWarnnigUrl();
                    for (int i = 0; i < clientContracts.size(); i++) {
                        TreeNode treeNode = new TreeNode("Client:-"+clientContracts.get(i).getClientName()+"\t"+clientimage);
                        treeNode.setLevel(1);
                        TreeNode treeNode2=new TreeNode("Contractor");
                        conrectorArrayList= (ArrayList<Conrector>) clientContracts.get(i).getConrector();
                        String conimage=image_url+clientContracts.get(i).getWarnnigUrl();
                        for(int b=0;b<conrectorArrayList.size();b++)
                        {
                            TreeNode treeNode4=new TreeNode(conrectorArrayList.get(b).getContName()+"\t"+conimage);
                            treeNode4.setLevel(3);
                            TreeNode treeNode5=new TreeNode("WorkOrder");
                            treeNode5.setLevel(4);
                            workOrderListArrayList= (ArrayList<WorkOrderList>) conrectorArrayList.get(b).getWorkOrderList();
                            String worklistimage=image_url+conrectorArrayList.get(b).getWarnnigUrl();
                            for(int z=0;z<workOrderListArrayList.size();z++)
                            {
                                TreeNode treeNode6=new TreeNode(workOrderListArrayList.get(z).getWorkOrderNumber()+"\t"+worklistimage);
                                treeNode6.setLevel(5);
                                TreeNode treeNode7=new TreeNode("Asset");
                                treeNode7.setLevel(6);
                                assetListArrayList= (ArrayList<AssetList>) workOrderListArrayList.get(z).getAssetList();
                                String assetimage=image_url+workOrderListArrayList.get(z).getWarnnigUrl();
                                for(int x=0;x<assetListArrayList.size();x++)
                                {
                                    TreeNode treeNode9=new TreeNode(assetListArrayList.get(x).getAssetName()+"\t"+assetimage);
                                    treeNode9.setLevel(7);
                                    treeNode7.addChild(treeNode9);
                                }
                                treeNode6.addChild(treeNode7);
                                TreeNode treeNode8=new TreeNode("Worker");
                                treeNode8.setLevel(6);
                                workerListArrayList= (ArrayList<WorkerList>) workOrderListArrayList.get(z).getWorkerList();
                                String workerimage=image_url+workOrderListArrayList.get(z).getWarnnigUrl();
                                for(int q=0;q<workerListArrayList.size();q++)
                                {
                                    TreeNode treeNode10=new TreeNode(workerListArrayList.get(q).getWorkerName()+"\t"+workerimage);
                                    treeNode10.setLevel(7);
                                    treeNode8.addChild(treeNode10);
                                }
                                treeNode6.addChild(treeNode8);
                                treeNode5.addChild(treeNode6);
                            }
                            treeNode4.addChild(treeNode5);
                            treeNode2.addChild(treeNode4);
                        }
                        treeNode2.setLevel(2);
                        treeNode.addChild(treeNode2);
                        root.addChild(treeNode);
                    }
                }
            }

            else if(preferenceManagerWorkOrder.getKey_User_Role().toString().trim().equals("Client")) {
                ArrayList<ClientTreeStructure> clientListArrayList=clientTreelist;




                for (int j = 0; j < clientListArrayList.size(); j++) {

                    String CName=clientListArrayList.get(j).getClientName();
                    String CImg=image_url+clientListArrayList.get(j).getWarnnigUrl();
                    // int CId=clientTreelist.get(0).getClientID();

                    TreeNode treeNode = new TreeNode("Client :-"+CName+"\t"+CImg);
                    treeNode.setLevel(0);
                    TreeNode treeNode2 = new TreeNode("Purchase Order"/*+"\t"+CImg*/);
                    treeNode2.setLevel(1);
                    TreeNode treeNode3=new TreeNode("Contractors"/*+"\t"+CImg*//*+"\t"+CImg*/);
                    treeNode3.setLevel(2);
                    treeNode.addChild(treeNode2);
                    treeNode.addChild(treeNode3);

                    String clientimage=image_url+clientListArrayList.get(j).getWarnnigUrl();
                    TreeNode treeNode1 = new TreeNode("Client:-"+clientListArrayList.get(j).getClientName()+"\t"+clientimage);
                    Log.d("ImageUrl",clientimage);
                    treeNode1.setLevel(0);

                    clientDemoPOArrayList= (ArrayList<ClientPO>) clientListArrayList.get(j).getClientPO();
                    //ArrayList<ClientPO> clientPOs=clientPOArrayList;

                    try{
                        for(int po=0;po<clientDemoPOArrayList.size();po++) {
                            String poimage=image_url+clientDemoPOArrayList.get(po).getWarnnigUrl();
                            TreeNode treeNode4=new TreeNode(clientDemoPOArrayList.get(po).getPoName()+"\t"+poimage);
                            treeNode4.setLevel(2);
                            treeNode2.addChild(treeNode4);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }


                    conrectorDemoArrayList= (ArrayList<Conrector>) clientListArrayList.get(j).getConrector();
                    ArrayList<Conrector> conrectors=conrectorDemoArrayList;
                    for(int con=0;con<conrectorDemoArrayList.size();con++)
                    {
                        String contrctimage=image_url+conrectorDemoArrayList.get(con).getWarnnigUrl();
                        TreeNode treeNode5=new TreeNode(conrectorDemoArrayList.get(con).getContName()+"\t"+contrctimage);
                        treeNode5.setLevel(2);
                        TreeNode treeNode6=new TreeNode("Work Order");
                        treeNode6.setLevel(3);
                        workOrderDemoList= (ArrayList<WorkOrderList>) conrectorDemoArrayList.get(con).getWorkOrderList();
                        ArrayList<WorkOrderList> workOrderLists=workOrderDemoList;

                        for(int n=0;n<workOrderLists.size();n++) {
                            String woimage=image_url+workOrderLists.get(n).getWarnnigUrl();
                            final TreeNode treeNode7 = new TreeNode(workOrderLists.get(n).getWorkOrderNumber()+"\t"+woimage);
                            treeNode7.setLevel(4);
                            TreeNode treeNode8=new TreeNode("Asset");
                            treeNode8.setLevel(5);
                            try
                            {
                                assetListArrayList= (ArrayList<AssetList>) workOrderLists.get(n).getAssetList();
                                ArrayList<AssetList> assetLists=assetListArrayList;
                                for(int l=0;l<assetLists.size();l++)
                                {
                                    String assetimage=image_url+assetLists.get(l).getWarnnigUrl();
                                    TreeNode treeNode10=new TreeNode(assetLists.get(l).getAssetName()+"\t"+assetimage);
                                    treeNode10.setLevel(6);
                                    treeNode8.addChild(treeNode10);
                                }
                            }catch (Exception e)
                            {
                                Log.d("TreeException",e.toString());
                            }
                            treeNode7.addChild(treeNode8);
                            TreeNode treeNode9=new TreeNode("Worker");
                            treeNode9.setLevel(5);

                            try{
                                workerListArrayList= (ArrayList<WorkerList>) workOrderListArrayList.get(n).getWorkerList();
                                ArrayList<WorkerList> workerLists=workerListArrayList;
                                for(int w=0;w<workerLists.size();w++)
                                {
                                    String workerimage=image_url+workerLists.get(w).getWarnnigUrl();
                                    TreeNode treeNode11=new TreeNode(workerLists.get(w).getWorkerName()+"\t"+workerimage);
                                    treeNode11.setLevel(6);
                                    treeNode9.addChild(treeNode11);
                                }
                            }catch (Exception e)
                            {
                                Log.d("Tree2Exception",e.toString());
                            }
                            treeNode7.addChild(treeNode9);
                            treeNode6.addChild(treeNode7);
                        }
                        treeNode5.addChild(treeNode6);
                        treeNode3.addChild(treeNode5);





                    }
                    root.addChild(treeNode);
                }

            }else
            {
                generateTree(preferenceManagerWorkOrder.getKey_User_Role());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void generateClientTree()
    {

    }


    public void generateTree(String nodeName)
    {
        //TreeNode node=new TreeNode(nodeName);
       // node.setLevel(0);
      try {
          for (int k=0;k<adminTreeStructures.size();k++)
          {
              String adminimage=image_url+adminTreeStructures.get(k).getWarnnigUrl();
              TreeNode treeNode = new TreeNode("Company:-"+((adminTreeStructures.get(k).getCompanyName()==null)?"":adminTreeStructures.get(k).getCompanyName())+"\t"+adminimage);
              treeNode.setLevel(0);

              arrayList=adminTreeStructures.get(k).getFmList();

              for (int i = 0; i <arrayList.size(); i++) {
                  //String fmimage=image_url+arrayList.get(i).getWarnnigUrl();
                  //TreeNode treeNode = new TreeNode(nodeName+":-"+arrayList.get(i).getFmName()+"\t"+fmimage);
                  // treeNode.setLevel(0);o
                  clientLists= (ArrayList<ClientList>) arrayList.get(i).getClientList();
                  ArrayList<ClientList> clientListArrayList=clientLists;
                  for (int j = 0; j < clientListArrayList.size(); j++) {
                      String clientimage=image_url+clientListArrayList.get(j).getWarnnigUrl();
                      TreeNode treeNode1 = new TreeNode("Client:-"+clientListArrayList.get(j).getClientName()+"\t"+clientimage);
                      treeNode1.setLevel(1);
                      TreeNode treeNode2 = new TreeNode("Purchase Order");
                      treeNode2.setLevel(2);
                      clientPOArrayList= (ArrayList<ClientPO>) clientLists.get(j).getClientPO();
                      ArrayList<ClientPO> clientPOs=clientPOArrayList;
                      for(int po=0;po<clientPOs.size();po++)
                      {
                          String poimage=image_url+clientPOs.get(po).getWarnnigUrl();
                          TreeNode treeNode4=new TreeNode(clientPOs.get(po).getPoName()+"\t"+poimage);
                          treeNode4.setLevel(3);
                          treeNode2.addChild(treeNode4);
                      }
                      treeNode1.addChild(treeNode2);
                      TreeNode treeNode3=new TreeNode("Contractors");
                      treeNode3.setLevel(2);
                      conrectorArrayList= (ArrayList<Conrector>) clientLists.get(j).getConrector();
                      ArrayList<Conrector> conrectors=conrectorArrayList;
                      for(int con=0;con<conrectors.size();con++)
                      {
                          String contrctimage=image_url+conrectors.get(con).getWarnnigUrl();
                          TreeNode treeNode5=new TreeNode(conrectors.get(con).getContName()+"\t"+contrctimage);
                          treeNode5.setLevel(3);
                          TreeNode treeNode6=new TreeNode("Work Order");
                          treeNode6.setLevel(4);
                          workOrderListArrayList= (ArrayList<WorkOrderList>) conrectors.get(con).getWorkOrderList();
                          ArrayList<WorkOrderList> workOrderLists=workOrderListArrayList;

                          for(int n=0;n<workOrderLists.size();n++) {
                              String woimage=image_url+workOrderLists.get(n).getWarnnigUrl();
                              final TreeNode treeNode7 = new TreeNode(workOrderLists.get(n).getWorkOrderNumber()+"\t"+woimage);
                              treeNode7.setLevel(5);
                              TreeNode treeNode8=new TreeNode("Asset");
                              treeNode8.setLevel(6);
                              assetListArrayList= (ArrayList<AssetList>) workOrderListArrayList.get(n).getAssetList();
                              ArrayList<AssetList> assetLists=assetListArrayList;
                              for(int l=0;l<assetLists.size();l++)
                              {
                                  String assetimage=image_url+assetLists.get(l).getWarnnigUrl();
                                  TreeNode treeNode10=new TreeNode(assetLists.get(l).getAssetName()+"\t"+assetimage);
                                  treeNode10.setLevel(7);
                                  treeNode8.addChild(treeNode10);
                              }
                              treeNode7.addChild(treeNode8);
                              TreeNode treeNode9=new TreeNode("Worker");
                              treeNode9.setLevel(6);
                              workerListArrayList= (ArrayList<WorkerList>) workOrderListArrayList.get(n).getWorkerList();
                              ArrayList<WorkerList> workerLists=workerListArrayList;
                              for(int w=0;w<workerLists.size();w++)
                              {
                                  String workerimage=image_url+workerLists.get(w).getWarnnigUrl();
                                  TreeNode treeNode11=new TreeNode(workerLists.get(w).getWorkerName()+"\t"+workerimage);
                                  treeNode11.setLevel(7);
                                  treeNode9.addChild(treeNode11);
                              }
                              treeNode7.addChild(treeNode9);
                              treeNode6.addChild(treeNode7);
                          }
                          treeNode5.addChild(treeNode6);
                          treeNode3.addChild(treeNode5);
                      }
                      treeNode1.addChild(treeNode3);
                      treeNode.addChild(treeNode1);
                  }

              }
              root.addChild(treeNode);
          }
      }catch (Exception e)
      {
          Log.d("TreeException",e.toString());
      }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.select_all:
                treeView.selectAll();
                break;
            case R.id.deselect_all:
                treeView.deselectAll();
                break;
            case R.id.expand_all:
                treeView.expandAll();
                break;
            case R.id.collapse_all:
                treeView.collapseAll();
                break;
            case R.id.expand_level:
                treeView.expandLevel(1);
                break;
            case R.id.collapse_level:
                treeView.collapseLevel(1);
                break;
            case R.id.show_select_node:
                Toast.makeText(getApplication(), getSelectedNodes(), Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private String getSelectedNodes() {
        StringBuilder stringBuilder = new StringBuilder("You have selected: ");
        List<TreeNode> selectedNodes = treeView.getSelectedNodes();
        for (int i = 0; i < selectedNodes.size(); i++) {
            if (i < 5) {
                stringBuilder.append(selectedNodes.get(i).getValue().toString() + ",");
            } else {
                stringBuilder.append("...and " + (selectedNodes.size() - 5) + " more.");
                break;
            }
        }
        return stringBuilder.toString();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
