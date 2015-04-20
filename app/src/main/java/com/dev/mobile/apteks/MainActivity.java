package com.dev.mobile.apteks;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    public void findlek(View view) {
        TextView textView;
        textView=(TextView)findViewById(R.id.textView);
        textView.setText("Set Find Lekarstv");

     }


    public void findaptek(View view) {
        TextView textView;
        textView=(TextView)findViewById(R.id.textView);
        textView.setText("Version 1");
        String geoURI = "geo:0,0?q=красноярск+аптеки&z=20";
        Uri geo = Uri.parse(geoURI);
        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
        startActivity(geoMap);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }




}
