package com.felipecsl.abslistviewhelper.library.widget;

import android.view.View;
import android.widget.AbsListView;

import com.nineoldandroids.view.ViewHelper;

public class HeaderAbsListViewScrollListener implements AbsListView.OnScrollListener {
    private final View headerView;
    private int paddingTop;

    public HeaderAbsListViewScrollListener(final View headerView) {
        this.headerView = headerView;
    }

    @Override public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem == 0) {
            final View firstView = view.getChildAt(0);
            if (firstView != null)
                ViewHelper.setTranslationY(headerView, ViewHelper.getY(firstView) - (paddingTop / 2) - headerView.getHeight());
        }
    }

    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }
}
