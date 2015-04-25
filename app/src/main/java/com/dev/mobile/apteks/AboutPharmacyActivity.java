package com.dev.mobile.apteks;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class AboutPharmacyActivity extends ActionBarActivity {

    public void findme(View view) {
        String pharmacyadress = getIntent().getExtras().getString("pharmacyadress");
        String geoURI = "geo:0,0?q=красноярск+"+pharmacyadress+" 4&z=20";
        Uri geo = Uri.parse(geoURI);
        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
        startActivity(geoMap);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_apteks);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TextView pharmname;
        String pharmacyname = getIntent().getExtras().getString("pharmacyname");
        pharmname=(TextView) findViewById(R.id.textView2);
        pharmname.setText(pharmacyname);

        String pharmacyadress = getIntent().getExtras().getString("pharmacyadress");

        String[] array=this.getResources().getStringArray(R.array.empty);


        //Аптека Агава
        if (pharmacyadress.equals("Ботанический Бульвар, 23/1")) {
            array=this.getResources().getStringArray(R.array.botanichbulvar23);
        }
        if (pharmacyadress.equals("Новосибирская, 48")) {
            array=this.getResources().getStringArray(R.array.novosibirskaya48);
        }
        if (pharmacyadress.equals("Красноярский Рабочий, 77а")) {
            array=this.getResources().getStringArray(R.array.krasrab77);
        }
        if (pharmacyadress.equals("Воронова, 14/2")) {
            array=this.getResources().getStringArray(R.array.voronova14_2);
        }
        if (pharmacyadress.equals("Красноярский Рабочий, 97")) {
            array=this.getResources().getStringArray(R.array.krasrab97);
        }
        if (pharmacyadress.equals("Урванцева, 26")) {
            array=this.getResources().getStringArray(R.array.urvanceva26);
        }


        //Аптека Адонис
        if (pharmacyadress.equals("Партизана Железняка, 16а")) {
            array=this.getResources().getStringArray(R.array.partizana_gelez16);
        }
        if (pharmacyadress.equals("78 Добровольческой Бригады, 10")) {
            array=this.getResources().getStringArray(R.array.dobrolbrigad10);
        }

        //Аптека Айболит
        if (pharmacyadress.equals("Алексеева, 21")) {
            array=this.getResources().getStringArray(R.array.alekseeva21);
        }

        //Аптека Ангизия
        if (pharmacyadress.equals("Мужества, 24")) {
            array=this.getResources().getStringArray(R.array.mugestva24);
        }

        //Аптека на Матросова, ООО Сан-Дент

        if (pharmacyadress.equals("Александра Матросова, 11")) {
            array=this.getResources().getStringArray(R.array.alexandaramatrosova11);
        }


        //Аптека низких цен, сеть аптек

        if (pharmacyadress.equals("Академика Киренского, 58")) {
            array=this.getResources().getStringArray(R.array.kirenskogo58);
        }
        if (pharmacyadress.equals("60 лет Октября, 43")) {
            array=this.getResources().getStringArray(R.array.sixtyletoct43);
        }

        if (pharmacyadress.equals("Судостроительная, 93")) {
            array=this.getResources().getStringArray(R.array.sudostritelnaya93);
        }

        if (pharmacyadress.equals("Красноярский Рабочий, 176м/1")) {
            array=this.getResources().getStringArray(R.array.krasrab176);
        }
        if (pharmacyadress.equals("9 Мая, 10")) {
            array=this.getResources().getStringArray(R.array.dmaya10);
        }
        if (pharmacyadress.equals("Мира проспект, 128")) {
            array=this.getResources().getStringArray(R.array.mira128);
        }
        if (pharmacyadress.equals("Дубровинского, 106")) {
            array=this.getResources().getStringArray(R.array.dubrovinskogo106);
        }
        if (pharmacyadress.equals("Шахтеров, 44")) {
            array=this.getResources().getStringArray(R.array.shahterov44);
        }
        if (pharmacyadress.equals("Судостроительная, д.52а")) {
            array=this.getResources().getStringArray(R.array.sudostritelnaya52);
        }

        // Валерьянка
        if (pharmacyadress.equals("Батурина, 15")) {
            array=this.getResources().getStringArray(R.array.baturina15);
        }
       // Гиппократ
        if (pharmacyadress.equals("Светлогорский, 2")) {
            array=this.getResources().getStringArray(R.array.svetlogorskiy2);
        }
        //Красноярское фармацевтическое объединение
        if (pharmacyadress.equals("Мира проспект, 60")) {
            array=this.getResources().getStringArray(R.array.mira60);
        }
        //Кырдал, сеть аптек
        if (pharmacyadress.equals("Молокова, 17")) {
            array=this.getResources().getStringArray(R.array.molokova17);
        }
        if (pharmacyadress.equals("Славы, 7")) {
            array=this.getResources().getStringArray(R.array.slavi7);
        }

        //Лади
        if (pharmacyadress.equals("Металлургов, 8а")) {
            array=this.getResources().getStringArray(R.array.metallurgov8a);
        }
        //Нейрон, сеть аптек
        if (pharmacyadress.equals("Красноярский Рабочий, 66")) {
            array=this.getResources().getStringArray(R.array.krasrab66);
        }
        if (pharmacyadress.equals("Красноярский Рабочий, 100")) {
            array=this.getResources().getStringArray(R.array.krasrab100);
        }
        if (pharmacyadress.equals("Тотмина, 3")) {
            array=this.getResources().getStringArray(R.array.totmina3);
        }
        //Панацея
        if (pharmacyadress.equals("Взлетная, 6а")) {
            array=this.getResources().getStringArray(R.array.vzletnaya6a);
        }
       //Селена-Фарм
        if (pharmacyadress.equals("9 Мая, 37")) {
            array=this.getResources().getStringArray(R.array.dmaya37);
        }
        //Сибирская аптека
        if (pharmacyadress.equals("Борисевича, 20")) {
            array=this.getResources().getStringArray(R.array.borisevicha20);
        }
        if (pharmacyadress.equals("Аэровокзальная, 6")) {
            array=this.getResources().getStringArray(R.array.aerovokzalnaya6);
        }
        if (pharmacyadress.equals("Шевченко, 5")) {
            array=this.getResources().getStringArray(R.array.shevchenko5);
        }
        if (pharmacyadress.equals("Щорса, 41")) {
            array=this.getResources().getStringArray(R.array.shorsa41);
        }
        //Строймедтекс
        if (pharmacyadress.equals("Щорса, 66")) {
            array=this.getResources().getStringArray(R.array.shorsa66);
        }
        //ФармПрофи
        if (pharmacyadress.equals("60 лет образования СССР, проспект 7б")) {
            array=this.getResources().getStringArray(R.array.sixtyyearsussr7b);
        }
        if (pharmacyadress.equals("40 лет Победы, 30д")) {
            array=this.getResources().getStringArray(R.array.fourtyyearpobed30);
        }
        //Фе­никс, ООО
        if (pharmacyadress.equals("Заводская, 4")) {
            array=this.getResources().getStringArray(R.array.zavodskaya4);
        }





      //  pharmname.setText(pharmacyadress);

        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0; i<array.length; i++) {
            stringBuilder.append(array[i]+"\n");
        }

        TextView textView;
        textView= (TextView) findViewById(R.id.conactdata);
        textView.setText(stringBuilder.toString());



    }


}
