package com.felipecsl.abslistviewhelper.library.widget;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;

import com.nineoldandroids.view.ViewHelper;

public class FooterAbsListViewScrollListener implements AbsListView.OnScrollListener {
    private final View footerView;
    private int paddingBottom;
    private float translationY;

    public FooterAbsListViewScrollListener(View footerView, Bundle savedState) {
        this.footerView = footerView;

        if (savedState != null) {
            paddingBottom = savedState.getInt("FOOTER_PADDING");
            translationY = savedState.getFloat("FOOTER_TRANSLATION_Y");
            ViewHelper.setTranslationY(footerView, translationY);
        }
    }

    @Override public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem + visibleItemCount >= totalItemCount) {
            final View lastView = view.getChildAt(view.getChildCount() - 1);
            if (lastView != null) {
                translationY = footerView.getHeight() - (view.getHeight() - (ViewHelper.getY(lastView) + lastView.getHeight())) + (paddingBottom / 2);
                ViewHelper.setTranslationY(footerView, translationY);
            }
        } else {
            translationY = footerView.getHeight();
            ViewHelper.setTranslationY(footerView, translationY);
        }
    }

    public void setPaddingBottom(final int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("FOOTER_PADDING", paddingBottom);
        outState.putFloat("FOOTER_TRANSLATION_Y", translationY);
    }
}
