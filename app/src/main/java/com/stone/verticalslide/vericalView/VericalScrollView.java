package com.stone.verticalslide.vericalView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class VericalScrollView extends ScrollView {

    boolean isAtBottom = true; // 如果是true，则允许拖动至底部的下一页
    private float downY;

    public VericalScrollView(Context arg0) {
        this(arg0, null);
    }

    public VericalScrollView(Context arg0, AttributeSet arg1) {
        this(arg0, arg1, 0);
    }

    public VericalScrollView(Context arg0, AttributeSet arg1, int arg2) {
        super(arg0, arg1, arg2);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            downY = ev.getRawY();
            isAtBottom = isAtBottom();
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            if (!isAtBottom) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return super.dispatchTouchEvent(ev);
            } else {
                if (ev.getRawY() - downY < 2) {
                    // flag设置，由父类去消费
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return super.dispatchTouchEvent(ev);
                }
            }
        }
        // 通知父view是否要处理touch事件
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }

    private boolean isAtBottom() {
        return getScrollY() + getMeasuredHeight() >= computeVerticalScrollRange() - 2;
    }



}
