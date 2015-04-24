package com.dev.mobile.apteks.Tasks;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.dev.mobile.apteks.Adapters.FindDrugsAdapter;
import com.dev.mobile.apteks.Models.Drug;
import com.dev.mobile.apteks.R;

import java.util.ArrayList;


public class FindDrugTask  extends AsyncTask <Void, Void, ArrayList<Drug>>{
    private String searchString;
    private View view;
    private FindDrugsAdapter adapter;

    public FindDrugTask(View v, FindDrugsAdapter ad, String input) {
        this.searchString = input;
        this.view = v;
        this.adapter = ad;
    }

    @Override
    protected ArrayList<Drug> doInBackground(Void... params) {
        try {
            return Drug.findDrug(this.searchString);
        } catch(Exception ex) {

        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        view.findViewById(R.id.findDrugProgressBar).setVisibility(View.VISIBLE);
        this.adapter.clear();

        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(ArrayList<Drug> data) {
        super.onPostExecute(data);

        view.findViewById(R.id.findDrugProgressBar).setVisibility(View.GONE);

        this.adapter.updateContent(data);


        if(this.adapter.isRealEmpty()) {
            view.findViewById(R.id.empty).setVisibility(View.VISIBLE);
        } else {
            view.findViewById(R.id.empty).setVisibility(View.GONE);
        }



    }
}
