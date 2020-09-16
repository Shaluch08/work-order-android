package com.workorder.app.workorderapplication.activity;

import android.view.View;

import com.workorder.app.workorderapplication.treeview.base.BaseNodeViewBinder;
import com.workorder.app.workorderapplication.treeview.base.BaseNodeViewFactory;


/**
 * Created by zxy on 17/4/23.
 */

public class MyNodeViewFactory extends BaseNodeViewFactory {

    @Override
    public BaseNodeViewBinder getNodeViewBinder(View view, int level) {
        switch (level) {
            case 0:
               return new FirstLevelNodeViewBinder(view);
            case 1:
                return new SecondLevelNodeViewBinder(view);
            case 2:
                return new ThirdLevelNodeViewBinder(view);
            case 3:
                return new FourthLevelNodeViewBinder (view);
            case 4:
                return new FifthLevelNodeViewBinder(view);
            case 5:
                return new SixthLevelNodeViewBinder(view);
            case 6:
                return new SevenLevelNodeViewBinder(view);
            case 7:
                return  new EigthLevelNodeViewBinder(view);
            default:
                return null;
        }
    }
}
