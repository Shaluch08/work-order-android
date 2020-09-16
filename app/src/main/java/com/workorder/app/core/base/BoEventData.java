package com.workorder.app.core.base;

public class BoEventData {
    public static final int EVENT_POST_CATEGORY = 1;
    public static final int EVENT_POST_PRODUCT = 2;

    public final int eventType;

    public int getId() {
        return Id;
    }

    public String getData() {
        return data;
    }

    public Object getObject() {
        return object;
    }

    public int Id;
    public String data;
    public Object object;

    public BoEventData(int eventType, int Id) {
        this.eventType = eventType;
        this.Id = Id;
    }


    public BoEventData(int eventType, int Id, String data) {
        this.eventType = eventType;
        this.data = data;
        this.Id = Id;
    }
    public BoEventData(int eventType, int Id, Object object) {
        this.eventType = eventType;
        this.object = object;
        this.Id = Id;
    }
    public BoEventData(int eventType, int Id, String data, Object object) {
        this.eventType = eventType;
        this.Id = Id;
        this.data = data;
        this.object = object;
    }

}
