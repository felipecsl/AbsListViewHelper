package com.felipecsl.abslistviewhelper.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.felipecsl.abslistviewhelper.library.AbsListViewHelper;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private GridView gridView;
    private View gridHeader;
    private View gridFooter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);
        gridHeader = findViewById(R.id.gridHeader);
        gridFooter = findViewById(R.id.gridFooter);

        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            items.add("Item " + i);
        final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        gridView.setAdapter(spinnerAdapter);

        new AbsListViewHelper(gridView)
                .setHeaderView(gridHeader)
                .setFooterView(gridFooter);
    }

    @Override protected void onResume() {
        super.onResume();
        gridView.scrollTo(0, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
