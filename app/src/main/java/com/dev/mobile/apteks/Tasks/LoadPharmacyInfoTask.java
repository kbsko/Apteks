package com.dev.mobile.apteks.Tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.mobile.apteks.Models.Pharmacy;
import com.dev.mobile.apteks.R;

/**
 * Created by User on 29.04.2015.
 */
public class LoadPharmacyInfoTask extends AsyncTask<Void, Void, Pharmacy> {
    private View view;
    private String href;


    public LoadPharmacyInfoTask(View v, String h) {
        this.view = v;
        this.href = h;
    }

    @Override
    protected void onPreExecute() {
        this.view.findViewById(R.id.contactLayout).setVisibility(View.GONE);
        this.view.findViewById(R.id.contactProgressBar).setVisibility(View.VISIBLE);

        super.onPreExecute();
    }

    @Override
    protected Pharmacy doInBackground(Void... params) {
        try {
            return Pharmacy.getPharmacyInfo(this.href);
        }catch(Exception ex) {
            Log.d("tag", ex.toString());
        }

        return null;
    }

    @Override
    protected void onPostExecute(Pharmacy pharmacy) {

        if(pharmacy == null) {
            Toast.makeText(this.view.getContext(), "Ошибка при получении информации", Toast.LENGTH_LONG);
            this.view.findViewById(R.id.contactProgressBar).setVisibility(View.GONE);

            return;
        }

        ((TextView) this.view.findViewById(R.id.pharmacyCity)).setText(pharmacy.getPharmacyCity());
        ((TextView) this.view.findViewById(R.id.pharmacyAddress)).setText(pharmacy.getPharmacyAddress());
        ((TextView) this.view.findViewById(R.id.pharmacyDistrict)).setText(pharmacy.getPharmacyDistrict());
        ((TextView) this.view.findViewById(R.id.pharmacyBus)).setText(pharmacy.getPharmacyBuses());
        ((TextView) this.view.findViewById(R.id.pharmacyPhone)).setText(pharmacy.getPharmacyPhone());




        this.view.findViewById(R.id.contactLayout).setVisibility(View.VISIBLE);
        this.view.findViewById(R.id.contactProgressBar).setVisibility(View.GONE);





        super.onPostExecute(pharmacy);
    }


}
