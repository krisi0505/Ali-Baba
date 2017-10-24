package com.project.krisi.alibaba.errorHandling;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class HackyProblematicViewGroup extends LinearLayout {

    public HackyProblematicViewGroup(Context context) {
        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException e) {
            //uncomment if you really want to see these errors
            //e.printStackTrace();
            return false;
        }
    }
}
