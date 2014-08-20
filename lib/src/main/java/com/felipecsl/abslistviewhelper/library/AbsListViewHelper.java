package com.felipecsl.abslistviewhelper.library;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;

import com.felipecsl.abslistviewhelper.library.widget.FooterAbsListViewScrollListener;
import com.felipecsl.abslistviewhelper.library.widget.HeaderAbsListViewScrollListener;

public class AbsListViewHelper {
    private final CompositeAbsListViewOnScrollListener scrollListener = new CompositeAbsListViewOnScrollListener();
    private final AbsListView absListView;
    private HeaderAbsListViewScrollListener headerListener;
    private FooterAbsListViewScrollListener footerListener;

    public AbsListViewHelper(final AbsListView absListView) {
        this.absListView = absListView;
        absListView.setClipToPadding(false);
        absListView.setOnScrollListener(scrollListener);
    }

    public AbsListViewHelper setHeaderView(final View headerView) {
        headerListener = new HeaderAbsListViewScrollListener(headerView);
        scrollListener.registerOnScrollListener(headerListener);

        headerView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override public void onGlobalLayout() {
                        if (headerView.getHeight() == 0)
                            return;

                        headerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        int paddingTop = headerView.getHeight() + dpToPx(absListView.getContext(), 10);
                        headerListener.setPaddingTop(dpToPx(absListView.getContext(), 10));
                        absListView.setPadding(
                                absListView.getPaddingLeft(),
                                paddingTop,
                                absListView.getPaddingRight(),
                                absListView.getPaddingBottom());
                    }
                });
        return this;
    }

    public AbsListViewHelper setFooterView(final View footerView) {
        footerListener = new FooterAbsListViewScrollListener(footerView);
        scrollListener.registerOnScrollListener(footerListener);

        footerView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override public void onGlobalLayout() {
                        if (footerView.getHeight() == 0)
                            return;

                        footerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        int paddingBottom = footerView.getHeight() + dpToPx(absListView.getContext(), 10);
                        footerListener.setPaddingBottom(dpToPx(absListView.getContext(), 10));
                        absListView.setPadding(
                                absListView.getPaddingLeft(),
                                absListView.getPaddingTop(),
                                absListView.getPaddingRight(),
                                paddingBottom);
                    }
                });
        return this;
    }

    public AbsListViewHelper registerOnScrollListener(AbsListView.OnScrollListener listener) {
        scrollListener.registerOnScrollListener(listener);
        return this;
    }

    public AbsListView.OnScrollListener getOnScrollListener() {
        return scrollListener;
    }

    private static int dpToPx(final Context context, final float dp) {
        // Took from http://stackoverflow.com/questions/8309354/formula-px-to-dp-dp-to-px-android
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dp * scale) + 0.5f);
    }
}
