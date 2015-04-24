package com.dev.mobile.apteks;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.dev.mobile.apteks.Adapters.FindDrugsAdapter;
import com.dev.mobile.apteks.Tasks.FindDrugTask;


public class FindDrugsActivity extends ActionBarActivity {
    private FindDrugsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // TODO create landscape layouts


        setContentView(R.layout.activity_find_drugs);


        ListView lsView = (ListView) findViewById(R.id.findDrugsListView);

        View header = getLayoutInflater().inflate(R.layout.find_drugs_selectors, lsView, false);
        lsView.addHeaderView(header, null, false);

       this.adapter = new FindDrugsAdapter(this);

        lsView.setAdapter(this.adapter);




    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        final EditText searchString = (EditText) findViewById(R.id.textSearchName);

        searchString.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    new FindDrugTask(findViewById(android.R.id.content), adapter, searchString.getText().toString()).execute();

                    return true;
                }
                return false;
            }
        });
    }



    public void aboutAptek(View view) {
        Intent intent = new Intent(this, AboutPharmacyActivity.class);
        startActivity(intent);
    }



}
