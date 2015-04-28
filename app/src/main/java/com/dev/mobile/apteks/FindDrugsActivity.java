package com.dev.mobile.apteks;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.dev.mobile.apteks.Adapters.FindDrugsAdapter;
import com.dev.mobile.apteks.Models.Drug;
import com.dev.mobile.apteks.Tasks.FindDrugTask;
import com.dev.mobile.apteks.Tasks.LoadPageDrugTask;


public class FindDrugsActivity extends ActionBarActivity { //implements View.OnClickListener {
    private FindDrugsAdapter adapter;
    private boolean loadingFlag = false;
    private String searchString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // TODO create landscape layouts

        setContentView(R.layout.activity_find_drugs);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("Поиск лекарств");
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(0xff0F7D1A);
        actionBar.setBackgroundDrawable(colorDrawable);



        ListView lsView = (ListView) findViewById(R.id.findDrugsListView);

        View header = getLayoutInflater().inflate(R.layout.find_drugs_selectors, lsView, false);
        lsView.addHeaderView(header, null, false);

        View footer = getLayoutInflater().inflate(R.layout.load_more, lsView, false);
        lsView.addFooterView(footer);


        this.adapter = new FindDrugsAdapter(this);

        lsView.setAdapter(this.adapter);
    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        final EditText editTextSearching = (EditText) findViewById(R.id.textSearchName);

        editTextSearching.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    searchString = editTextSearching.getText().toString();

                    new FindDrugTask(findViewById(android.R.id.content), adapter, searchString).execute();

                    return true;
                }
                return false;
            }
        });

        ListView lsView = (ListView) findViewById(R.id.findDrugsListView);


        lsView.setOnScrollListener(new AbsListView.OnScrollListener() {

            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 2) {
                    if (!loadingFlag && !Drug.getEmptyAnswerFlag()) {
                        loadingFlag = true;

                        findViewById(R.id.loadMoreFrameLayout).setVisibility(View.VISIBLE);

                        new LoadPageDrugTask(findViewById(android.R.id.content), adapter, searchString, FindDrugsActivity.this).execute();

                    }
                }
            }
        });
    }

    public void resetLoadingFlag() {
        this.loadingFlag = false;
    }



    public void aboutAptek(View view) {
        Intent intent = new Intent(this, AboutPharmacyActivity.class);
        TextView phName;
        TextView phAdress;
        phName=(TextView) view.findViewById(R.id.pharmacyName);
        String pharmacyName=phName.getText().toString();
        phAdress=(TextView) view.findViewById(R.id.pharmacyadress);
        String pharmacyAdress=phAdress.getText().toString();
        intent.putExtra("pharmacyname", pharmacyName);
        intent.putExtra("pharmacyadress", pharmacyAdress);
        startActivity(intent);
    }


    //@Override
    public void onClick(View v) {
        if(v.getId() == R.id.clearSearchFieldButton) {
            ((EditText)findViewById(R.id.textSearchName)).setText("");
        }
        //Log.i("tag", "tag");
    }
}
