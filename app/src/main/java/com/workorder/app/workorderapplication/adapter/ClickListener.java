package com.workorder.app.workorderapplication.adapter;

/**
 * Created by Bharat Tripathi on 03-May-18.
 */

public interface ClickListener {
    public void editClick(Integer position);
    public void deleteClick(Integer position);
    public void addWorker(Integer position);
    public void materialClickListener(Integer position);
    public void historyClickListener(Integer position);
}
