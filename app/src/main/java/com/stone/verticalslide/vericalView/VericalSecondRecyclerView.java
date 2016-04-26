package com.stone.verticalslide.vericalView;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 下拉可以回到上个界面的recycleView
 */
public class VericalSecondRecyclerView extends RecyclerView {

    private float downY;
    /**
     * 第一个可见的item的位置
     */
    private int firstVisibleItemPosition;
    /**
     * 第一个的位置
     */
    private int[] firstPositions;

    private boolean isTop;

    public VericalSecondRecyclerView(Context context) {
        this(context, null);
    }

    public VericalSecondRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VericalSecondRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null) {
            if (layoutManager instanceof GridLayoutManager) {
                firstVisibleItemPosition = ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            } else if (layoutManager instanceof LinearLayoutManager) {
                firstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                if (firstPositions == null) {
                    firstPositions = new int[staggeredGridLayoutManager.getSpanCount()];
                }
                staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(firstPositions);
                firstVisibleItemPosition = findMin(firstPositions);
            }
        } else {
            throw new RuntimeException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
        }

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            downY = ev.getRawY();
            isTop = firstVisibleItemPosition == 0 && getChildAt(0).getTop() >= 0;//是否是顶端

        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {

            if (isTop) {
                if (ev.getRawY() - downY > 0) {//继续向下滑动
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return super.dispatchTouchEvent(ev);
                }
            }
        }

        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);

    }

    private int findMin(int[] firstPositions) {
        int min = firstPositions[0];
        for (int value : firstPositions) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
