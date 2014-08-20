package com.felipecsl.abslistviewhelper.library.widget;

import android.view.View;
import android.widget.AbsListView;

import com.nineoldandroids.view.ViewHelper;

public class FooterAbsListViewScrollListener implements AbsListView.OnScrollListener {

    private View footerView;
    private int paddingBottom;

    public FooterAbsListViewScrollListener(View footerView) {
        this.footerView = footerView;
    }

    @Override public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void setPaddingBottom(final int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem + visibleItemCount >= totalItemCount) {
            final View lastView = view.getChildAt(view.getChildCount() - 1);
            if (lastView != null)
                ViewHelper.setTranslationY(footerView, footerView.getHeight() - (view.getHeight() - (ViewHelper.getY(lastView) + lastView.getHeight())) + (paddingBottom / 2));
        } else
            ViewHelper.setTranslationY(footerView, footerView.getHeight());
    }
}
