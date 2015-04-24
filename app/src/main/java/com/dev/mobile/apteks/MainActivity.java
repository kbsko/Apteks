package com.dev.mobile.apteks;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // TODO create landscape layouts

    }


    public void findDrugs(View view) {

        Intent intent = new Intent(this, FindDrugsActivity.class);
        startActivity(intent);
    }


    public void findaptek(View view) {
        TextView textView;
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Version 1");
        String geoURI = "geo:0,0?q=красноярск+аптеки&z=20";
        Uri geo = Uri.parse(geoURI);
        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
        startActivity(geoMap);

    }


}
