package com.workorder.app.workorderapplication.activity;

import java.io.Serializable;
import java.util.List;

public class Demo implements Serializable {

    /**
     * companycoubt : 1
     * purchaseorderount : 0
     * assetcount : 6
     * wordercount : 9
     * treestuctutr : [{"clientID":2125,"clientName":"DEEKSHA","clientPO":[{"poid":155,"poName":"1001 DT CPO","warnnigUrl":"SmallOK.png"},{"poid":157,"poName":"1003 DT CPO","warnnigUrl":"SmallSevere.png"},{"poid":158,"poName":"1004 DT CPO","warnnigUrl":"SmallOK.png"},{"poid":161,"poName":"1002 DT PO","warnnigUrl":"SmallOK.png"}],"conrector":[{"contID":2126,"contName":"DIVYA CONTRACTOR","workOrderList":[{"workorderID":10,"workOrderNumber":"1003 DT WO","assetList":[{"assetId":2,"assetName":"WATER COLLER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallSevere.png"}],"workerList":[{"workerId":25,"workerName":"Sumeet Worker","warnnigUrl":"SmallOK.png"},{"workerId":26,"workerName":"Mohd zahid","warnnigUrl":"SmallOK.png"}],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":16,"workOrderNumber":"W1","assetList":[{"assetId":2,"assetName":"WATER COLLER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallSevere.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":17,"workOrderNumber":"W2","assetList":[{"assetId":2,"assetName":"WATER COLLER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallSevere.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":18,"workOrderNumber":"W3","assetList":[{"assetId":1,"assetName":"AIR CONDITIONER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallMinor.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":19,"workOrderNumber":"W4","assetList":[{"assetId":2,"assetName":"WATER COLLER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallSevere.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":22,"workOrderNumber":"1001 DT WO","assetList":[{"assetId":9,"assetName":"AIR COND","assetWarnnigLevelValue":null,"warnnigUrl":"SmallMinor.png"}],"workerList":[],"warWarnnigLevelValue":2,"warnnigUrl":"SmallMinor.png"},{"workorderID":29,"workOrderNumber":"WO-000029","assetList":[],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":31,"workOrderNumber":"WO-000030","assetList":[{"assetId":1,"assetName":"AIR CONDITIONER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallMinor.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":42,"workOrderNumber":"WO-000042","assetList":[{"assetId":79,"assetName":"dsfdsfs","assetWarnnigLevelValue":null,"warnnigUrl":"SmallOK.png"}],"workerList":[{"workerId":29,"workerName":"DIVYA EMPLOYEE","warnnigUrl":"SmallOK.png"}],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"}],"warnnigUrl":"SmallMinor.png"}],"warnnigUrl":"SmallMinor.png"}]
     */

    private int companycoubt;
    private int purchaseorderount;
    private int assetcount;
    private int wordercount;
    private List<TreestuctutrBean> treestuctutr;

    public int getCompanycoubt() {
        return companycoubt;
    }

    public void setCompanycoubt(int companycoubt) {
        this.companycoubt = companycoubt;
    }

    public int getPurchaseorderount() {
        return purchaseorderount;
    }

    public void setPurchaseorderount(int purchaseorderount) {
        this.purchaseorderount = purchaseorderount;
    }

    public int getAssetcount() {
        return assetcount;
    }

    public void setAssetcount(int assetcount) {
        this.assetcount = assetcount;
    }

    public int getWordercount() {
        return wordercount;
    }

    public void setWordercount(int wordercount) {
        this.wordercount = wordercount;
    }

    public List<TreestuctutrBean> getTreestuctutr() {
        return treestuctutr;
    }

    public void setTreestuctutr(List<TreestuctutrBean> treestuctutr) {
        this.treestuctutr = treestuctutr;
    }

    public static class TreestuctutrBean  implements Serializable{
        /**
         * clientID : 2125
         * clientName : DEEKSHA
         * clientPO : [{"poid":155,"poName":"1001 DT CPO","warnnigUrl":"SmallOK.png"},{"poid":157,"poName":"1003 DT CPO","warnnigUrl":"SmallSevere.png"},{"poid":158,"poName":"1004 DT CPO","warnnigUrl":"SmallOK.png"},{"poid":161,"poName":"1002 DT PO","warnnigUrl":"SmallOK.png"}]
         * conrector : [{"contID":2126,"contName":"DIVYA CONTRACTOR","workOrderList":[{"workorderID":10,"workOrderNumber":"1003 DT WO","assetList":[{"assetId":2,"assetName":"WATER COLLER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallSevere.png"}],"workerList":[{"workerId":25,"workerName":"Sumeet Worker","warnnigUrl":"SmallOK.png"},{"workerId":26,"workerName":"Mohd zahid","warnnigUrl":"SmallOK.png"}],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":16,"workOrderNumber":"W1","assetList":[{"assetId":2,"assetName":"WATER COLLER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallSevere.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":17,"workOrderNumber":"W2","assetList":[{"assetId":2,"assetName":"WATER COLLER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallSevere.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":18,"workOrderNumber":"W3","assetList":[{"assetId":1,"assetName":"AIR CONDITIONER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallMinor.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":19,"workOrderNumber":"W4","assetList":[{"assetId":2,"assetName":"WATER COLLER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallSevere.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":22,"workOrderNumber":"1001 DT WO","assetList":[{"assetId":9,"assetName":"AIR COND","assetWarnnigLevelValue":null,"warnnigUrl":"SmallMinor.png"}],"workerList":[],"warWarnnigLevelValue":2,"warnnigUrl":"SmallMinor.png"},{"workorderID":29,"workOrderNumber":"WO-000029","assetList":[],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":31,"workOrderNumber":"WO-000030","assetList":[{"assetId":1,"assetName":"AIR CONDITIONER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallMinor.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":42,"workOrderNumber":"WO-000042","assetList":[{"assetId":79,"assetName":"dsfdsfs","assetWarnnigLevelValue":null,"warnnigUrl":"SmallOK.png"}],"workerList":[{"workerId":29,"workerName":"DIVYA EMPLOYEE","warnnigUrl":"SmallOK.png"}],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"}],"warnnigUrl":"SmallMinor.png"}]
         * warnnigUrl : SmallMinor.png
         */

        private int clientID;
        private String clientName;
        private String warnnigUrl;
        private List<ClientPOBean> clientPO;
        private List<ConrectorBean> conrector;

        public int getClientID() {
            return clientID;
        }

        public void setClientID(int clientID) {
            this.clientID = clientID;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public String getWarnnigUrl() {
            return warnnigUrl;
        }

        public void setWarnnigUrl(String warnnigUrl) {
            this.warnnigUrl = warnnigUrl;
        }

        public List<ClientPOBean> getClientPO() {
            return clientPO;
        }

        public void setClientPO(List<ClientPOBean> clientPO) {
            this.clientPO = clientPO;
        }

        public List<ConrectorBean> getConrector() {
            return conrector;
        }

        public void setConrector(List<ConrectorBean> conrector) {
            this.conrector = conrector;
        }

        public static class ClientPOBean {
            /**
             * poid : 155
             * poName : 1001 DT CPO
             * warnnigUrl : SmallOK.png
             */

            private int poid;
            private String poName;
            private String warnnigUrl;

            public int getPoid() {
                return poid;
            }

            public void setPoid(int poid) {
                this.poid = poid;
            }

            public String getPoName() {
                return poName;
            }

            public void setPoName(String poName) {
                this.poName = poName;
            }

            public String getWarnnigUrl() {
                return warnnigUrl;
            }

            public void setWarnnigUrl(String warnnigUrl) {
                this.warnnigUrl = warnnigUrl;
            }
        }

        public static class ConrectorBean {
            /**
             * contID : 2126
             * contName : DIVYA CONTRACTOR
             * workOrderList : [{"workorderID":10,"workOrderNumber":"1003 DT WO","assetList":[{"assetId":2,"assetName":"WATER COLLER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallSevere.png"}],"workerList":[{"workerId":25,"workerName":"Sumeet Worker","warnnigUrl":"SmallOK.png"},{"workerId":26,"workerName":"Mohd zahid","warnnigUrl":"SmallOK.png"}],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":16,"workOrderNumber":"W1","assetList":[{"assetId":2,"assetName":"WATER COLLER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallSevere.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":17,"workOrderNumber":"W2","assetList":[{"assetId":2,"assetName":"WATER COLLER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallSevere.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":18,"workOrderNumber":"W3","assetList":[{"assetId":1,"assetName":"AIR CONDITIONER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallMinor.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":19,"workOrderNumber":"W4","assetList":[{"assetId":2,"assetName":"WATER COLLER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallSevere.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":22,"workOrderNumber":"1001 DT WO","assetList":[{"assetId":9,"assetName":"AIR COND","assetWarnnigLevelValue":null,"warnnigUrl":"SmallMinor.png"}],"workerList":[],"warWarnnigLevelValue":2,"warnnigUrl":"SmallMinor.png"},{"workorderID":29,"workOrderNumber":"WO-000029","assetList":[],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":31,"workOrderNumber":"WO-000030","assetList":[{"assetId":1,"assetName":"AIR CONDITIONER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallMinor.png"}],"workerList":[],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"},{"workorderID":42,"workOrderNumber":"WO-000042","assetList":[{"assetId":79,"assetName":"dsfdsfs","assetWarnnigLevelValue":null,"warnnigUrl":"SmallOK.png"}],"workerList":[{"workerId":29,"workerName":"DIVYA EMPLOYEE","warnnigUrl":"SmallOK.png"}],"warWarnnigLevelValue":1,"warnnigUrl":"SmallOK.png"}]
             * warnnigUrl : SmallMinor.png
             */

            private int contID;
            private String contName;
            private String warnnigUrl;
            private List<WorkOrderListBean> workOrderList;

            public int getContID() {
                return contID;
            }

            public void setContID(int contID) {
                this.contID = contID;
            }

            public String getContName() {
                return contName;
            }

            public void setContName(String contName) {
                this.contName = contName;
            }

            public String getWarnnigUrl() {
                return warnnigUrl;
            }

            public void setWarnnigUrl(String warnnigUrl) {
                this.warnnigUrl = warnnigUrl;
            }

            public List<WorkOrderListBean> getWorkOrderList() {
                return workOrderList;
            }

            public void setWorkOrderList(List<WorkOrderListBean> workOrderList) {
                this.workOrderList = workOrderList;
            }

            public static class WorkOrderListBean {
                /**
                 * workorderID : 10
                 * workOrderNumber : 1003 DT WO
                 * assetList : [{"assetId":2,"assetName":"WATER COLLER","assetWarnnigLevelValue":null,"warnnigUrl":"SmallSevere.png"}]
                 * workerList : [{"workerId":25,"workerName":"Sumeet Worker","warnnigUrl":"SmallOK.png"},{"workerId":26,"workerName":"Mohd zahid","warnnigUrl":"SmallOK.png"}]
                 * warWarnnigLevelValue : 1
                 * warnnigUrl : SmallOK.png
                 */

                private int workorderID;
                private String workOrderNumber;
                private int warWarnnigLevelValue;
                private String warnnigUrl;
                private List<AssetListBean> assetList;
                private List<WorkerListBean> workerList;

                public int getWorkorderID() {
                    return workorderID;
                }

                public void setWorkorderID(int workorderID) {
                    this.workorderID = workorderID;
                }

                public String getWorkOrderNumber() {
                    return workOrderNumber;
                }

                public void setWorkOrderNumber(String workOrderNumber) {
                    this.workOrderNumber = workOrderNumber;
                }

                public int getWarWarnnigLevelValue() {
                    return warWarnnigLevelValue;
                }

                public void setWarWarnnigLevelValue(int warWarnnigLevelValue) {
                    this.warWarnnigLevelValue = warWarnnigLevelValue;
                }

                public String getWarnnigUrl() {
                    return warnnigUrl;
                }

                public void setWarnnigUrl(String warnnigUrl) {
                    this.warnnigUrl = warnnigUrl;
                }

                public List<AssetListBean> getAssetList() {
                    return assetList;
                }

                public void setAssetList(List<AssetListBean> assetList) {
                    this.assetList = assetList;
                }

                public List<WorkerListBean> getWorkerList() {
                    return workerList;
                }

                public void setWorkerList(List<WorkerListBean> workerList) {
                    this.workerList = workerList;
                }

                public static class AssetListBean {
                    /**
                     * assetId : 2
                     * assetName : WATER COLLER
                     * assetWarnnigLevelValue : null
                     * warnnigUrl : SmallSevere.png
                     */

                    private int assetId;
                    private String assetName;
                    private Object assetWarnnigLevelValue;
                    private String warnnigUrl;

                    public int getAssetId() {
                        return assetId;
                    }

                    public void setAssetId(int assetId) {
                        this.assetId = assetId;
                    }

                    public String getAssetName() {
                        return assetName;
                    }

                    public void setAssetName(String assetName) {
                        this.assetName = assetName;
                    }

                    public Object getAssetWarnnigLevelValue() {
                        return assetWarnnigLevelValue;
                    }

                    public void setAssetWarnnigLevelValue(Object assetWarnnigLevelValue) {
                        this.assetWarnnigLevelValue = assetWarnnigLevelValue;
                    }

                    public String getWarnnigUrl() {
                        return warnnigUrl;
                    }

                    public void setWarnnigUrl(String warnnigUrl) {
                        this.warnnigUrl = warnnigUrl;
                    }
                }

                public static class WorkerListBean {
                    /**
                     * workerId : 25
                     * workerName : Sumeet Worker
                     * warnnigUrl : SmallOK.png
                     */

                    private int workerId;
                    private String workerName;
                    private String warnnigUrl;

                    public int getWorkerId() {
                        return workerId;
                    }

                    public void setWorkerId(int workerId) {
                        this.workerId = workerId;
                    }

                    public String getWorkerName() {
                        return workerName;
                    }

                    public void setWorkerName(String workerName) {
                        this.workerName = workerName;
                    }

                    public String getWarnnigUrl() {
                        return warnnigUrl;
                    }

                    public void setWarnnigUrl(String warnnigUrl) {
                        this.warnnigUrl = warnnigUrl;
                    }
                }
            }
        }
    }
}
