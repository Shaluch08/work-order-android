package com.workorder.app.workorderapplication.model.history;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bharat Tripathi on 30-May-18.
 */

public class HistoryModel implements Serializable {
    @SerializedName("timeStamp")
    @Expose
    private String timeStamp;
    @SerializedName("auditUserName")
    @Expose
    private String auditUserName;
    @SerializedName("auditType")
    @Expose
    private Integer auditType;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getAuditUserName() {
        return auditUserName;
    }

    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName;
    }

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
