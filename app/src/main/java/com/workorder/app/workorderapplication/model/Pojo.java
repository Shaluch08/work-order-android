package com.workorder.app.workorderapplication.model;

public class Pojo {


    /**
     * disabled : false
     * group : null
     * selected : false
     * text : Select Title
     * value : 0
     */

    private boolean disabled;
    private Object group;
    private boolean selected;
    private String text;
    private String value;

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Object getGroup() {
        return group;
    }

    public void setGroup(Object group) {
        this.group = group;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
