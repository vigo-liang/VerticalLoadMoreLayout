package com.stone.verticalslide.vericalView;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 *可以继续向上拖动查看更多的recycleView
 */
public class VericalFristRecyclerView extends RecyclerView {

    private float downY;
    /**
     * 最后一个可见的item的位置
     */
    private int lastVisibleItemPosition;
    /**
     * 最后一个的位置
     */
    private int[] lastPositions;

    private boolean isBottom;

    public VericalFristRecyclerView(Context context) {
        this(context, null);
    }

    public VericalFristRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VericalFristRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null) {
            if (layoutManager instanceof GridLayoutManager) {
                lastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            } else if (layoutManager instanceof LinearLayoutManager) {
                lastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                if (lastPositions == null) {
                    lastPositions = new int[staggeredGridLayoutManager.getSpanCount()];
                }
                staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(lastPositions);
                lastVisibleItemPosition = findMax(lastPositions);
            }
        } else {
            throw new RuntimeException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
        }

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            downY = ev.getRawY();

            int totalItemCount = layoutManager.getItemCount();

            isBottom = lastVisibleItemPosition == totalItemCount - 1; //是否滑到底部

        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            if (isBottom) {
                if (ev.getRawY() - downY < 0) {//继续向上滑动
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return super.dispatchTouchEvent(ev);
                }
            }
        }

        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);

    }

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value >= max) {
                max = value;
            }
        }
        return max;
    }
}
