package com.felipecsl.abslistviewhelper.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.felipecsl.abslistviewhelper.library.AbsListViewHelper;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private AbsListViewHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView gridView = (GridView) findViewById(R.id.gridView);
        final View gridHeader = findViewById(R.id.gridHeader);
        final View gridFooter = findViewById(R.id.gridFooter);

        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            items.add("Item " + i);

        helper = new AbsListViewHelper(gridView, savedInstanceState)
                .setHeaderView(gridHeader)
                .setFooterView(gridFooter);

        gridView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        helper.onSaveInstanceState(outState);
    }
}
