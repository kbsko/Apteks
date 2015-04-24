package com.dev.mobile.apteks;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class AboutPharmacyActivity extends ActionBarActivity {

    public void findme(View view) {
        String geoURI = "geo:0,0?q=красноярск+заводская 4&z=20";
        Uri geo = Uri.parse(geoURI);
        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
        startActivity(geoMap);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_apteks);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


}
