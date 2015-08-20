package com.felipecsl.abslistviewhelper.library.widget;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;

import android.support.v4.view.ViewCompat;

public class HeaderAbsListViewScrollListener implements AbsListView.OnScrollListener {
    private final View headerView;
    private int paddingTop;
    private float translationY;

    public HeaderAbsListViewScrollListener(final View headerView, Bundle savedState) {
        this.headerView = headerView;

        if (savedState != null) {
            paddingTop = savedState.getInt("HEADER_PADDING");
            translationY = savedState.getFloat("HEADER_TRANSLATION_Y");
            ViewCompat.setTranslationY(headerView, translationY);
        }
    }

    @Override public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem == 0) {
            final View firstView = view.getChildAt(0);
            if (firstView != null) {
                translationY = ViewCompat.getY(firstView) - (paddingTop / 2) - headerView.getHeight();
                ViewCompat.setTranslationY(headerView, translationY);
            }
        }
    }

    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("HEADER_PADDING", paddingTop);
        outState.putFloat("HEADER_TRANSLATION_Y", translationY);
    }
}
