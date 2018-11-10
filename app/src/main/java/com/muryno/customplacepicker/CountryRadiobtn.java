package com.muryno.customplacepicker;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;


import com.github.ybq.android.spinkit.style.ThreeBounce;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryRadiobtn extends AppCompatActivity {

    Button next;
    private RadioGroup radiogrp;

    @BindView(R.id.spin_kit)
    ProgressBar progressBar;

    private boolean isChecking = true;
    private int mCheckedId = R.id.rbtn1;
    String country;
    String countryCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_radiobtn);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        next = (Button) findViewById(R.id.next);

        ThreeBounce doubleBounce = new ThreeBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        radiogrp = (RadioGroup) findViewById(R.id.country_rbtn);

        final Handler handler = new Handler();
        radiogrp.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                radiogrp.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
            }
        }, 3000);

        radiogrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mCheckedId = checkedId;
                }
                isChecking = true;
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedValue();
                if (mCheckedId == -1) {
                    return;
                }
                saveCountry();
            }
        });

    }


    public void clickedValue() {

        switch (mCheckedId) {
            case R.id.rbtn1:
                country = "Nigeria";
                countryCode = "ng";
                break;
            case R.id.rbtn2:
                country = "Afghanistan";
                countryCode = "af";
                break;
            case R.id.rbtn3:
                country = "Aland island";
                countryCode = "ax";
                break;

            case R.id.rbtn4:
                country = "Albania";
                countryCode = "al";
                break;

            case R.id.rbtn5:
                country = "Algeria";
                countryCode = "dz";
                break;

            case R.id.rbtn6:
                country = "American samoa";
                countryCode = "as";
                break;

            case R.id.rbtn7:
                country = "Andorra";
                countryCode = "ad";
                break;

            case R.id.rbtn8:
                country = "Angola";
                countryCode = "ao";
                break;

            case R.id.rbtn9:
                country = "Anguilla";
                countryCode = "al";
                break;

            case R.id.rbtn10:
                country = "Antarctica";
                countryCode = "aq";
                break;

            case R.id.rbtn12:
                country = "Argentina";
                countryCode = "ar";
                break;
            case R.id.rbtn13:
                country = "Armenia";
                countryCode = "am";
                break;

            case R.id.rbtn15:
                country = "Azerbaijan";
                countryCode = "az";
                break;


            case R.id.rbtn17:
                country = "Bahrain";
                countryCode = "bh";
                break;


            case R.id.rbtn20:
                country = "Belarus";
                countryCode = "by";
                break;

            case R.id.rbtn21:
                country = "Belgium";
                countryCode = "be";
                break;


            case R.id.rbtn23:
                country = "Benin";
                countryCode = "bj";
                break;


            case R.id.rbtn26:
                country = "Bolivia";
                countryCode = "bo";
                break;

            case R.id.rbtn27:
                country = "Caribbean Netherlands";
                countryCode = "bq";
                break;

            case R.id.rbtn28:
                country = "Bosnia and Herzegovina";
                countryCode = "ba";
                break;


            case R.id.rbtn31:
                country = "Brazil";
                countryCode = "br";
                break;

            case R.id.rbtn32:
                country = "British Indian Ocean Territory";
                countryCode = "io";
                break;


            case R.id.rbtn34:
                country = "Bulgaria";
                countryCode = "bg";
                break;

            case R.id.rbtn35:
                country = "Burkina Faso";
                countryCode = "bf";
                break;

            case R.id.rbtn39:
                country = "Cameroon";
                countryCode = "cm";
                break;

            case R.id.rbtn40:
                country = "Canada";
                countryCode = "ca";
                break;

            case R.id.rbtn43:
                country = "Central Africa Republic";
                countryCode = "cf";
                break;

            case R.id.rbtn44:
                country = "Chad";
                countryCode = "td";
                break;

            case R.id.rbtn45:
                country = "Chile";
                countryCode = "cl";
                break;

            case R.id.rbtn46:
                country = "China";
                countryCode = "cl";
                break;

            case R.id.rbtn47:
                country = "Christmas Island";
                countryCode = "cx";
                break;


            case R.id.rbtn49:
                country = "Colombia";
                countryCode = "co";
                break;


            case R.id.rbtn51:
                country = "Democratic Republic of Congo";
                countryCode = "cd";
                break;

            case R.id.rbtn52:
                country = "Cook Island";
                countryCode = "ck";
                break;

            case R.id.rbtn53:
                country = "Costa Rica";
                countryCode = "cr";
                break;

            case R.id.rbtn54:
                country = "Ivory Coast";
                countryCode = "cl";
                break;

            case R.id.rbtn55:
                country = "Croatia";
                countryCode = "hr";
                break;

            case R.id.rbtn57:
                country = "Cyprus";
                countryCode = "cy";
                break;

            case R.id.rbtn58:
                country = "Czech Republic";
                countryCode = "cz";
                break;

            case R.id.rbtn59:
                country = "Denmark";
                countryCode = "dk";
                break;

            case R.id.rbtn63:
                countryCode = "ec";
                country = "Ecuador";
                break;

            case R.id.rbtn64:
                country = "Egypt";
                countryCode = "eg";
                break;

            case R.id.rbtn65:
                country = "El Salvador";
                countryCode = "sv";
                break;

            case R.id.rbtn66:
                country = "Equatorial Guinea";
                countryCode = "gq";
                break;

            case R.id.rbtn67:
                country = "Eritrea";
                countryCode = "er";
                break;

            case R.id.rbtn68:
                country = "Estonia";
                countryCode = "ee";
                break;


            case R.id.rbtn70:
                country = "Faroe Islands";
                countryCode = "fo";
                break;


            case R.id.rbtn72:
                country = "Finland";
                countryCode = "fl";
                break;

            case R.id.rbtn73:
                country = "France";
                countryCode = "fr";
                break;

            case R.id.rbtn78:
                country = "Gabon";
                countryCode = "ga";

                break;

            case R.id.rbtn79:
                country = "Gambia";
                countryCode = "gm";
                break;

            case R.id.rbtn80:
                country = "Georgia";
                countryCode = "ge";
                break;

            case R.id.rbtn81:
                country = "Germany";
                countryCode = "de";
                break;

            case R.id.rbtn82:
                country = "Ghana";
                countryCode = "gh";
                break;

            case R.id.rbtn83:
                country = "Gibraltar";
                countryCode = "gl";
                break;

            case R.id.rbtn84:
                country = "Greece";
                countryCode = "gr";
                break;

            case R.id.rbtn85:
                country = "Greenland";
                countryCode = "gl";
                break;

            case R.id.rbtn86:
                country = "Grenada";
                countryCode = "gd";
                break;


            case R.id.rbtn90:
                country = "Guinea";
                countryCode = "gn";
                break;

            case R.id.rbtn93:
                country = "Haiti";
                countryCode = "ht";
                break;


            case R.id.rbtn95:
                country = "Honduras";
                countryCode = "hn";
                break;

            case R.id.rbtn96:
                country = "Hong Kong";
                countryCode = "hk";
                break;

            case R.id.rbtn97:
                country = "Hungary";
                countryCode = "hu";
                break;

            case R.id.rbtn98:
                country = "Iceland";
                countryCode = "is";
                break;

            case R.id.rbtn99:
                country = "India";
                countryCode = "in";
                break;

            case R.id.rbtn100:
                country = "Indonesia";
                countryCode = "userID";
                break;

            case R.id.rbtn101:
                country = "Iraq";
                countryCode = "iq";
                break;

            case R.id.rbtn102:
                country = "Ireland";
                countryCode = "ie";
                break;

            case R.id.rbtn104:
                country = "Israel";
                countryCode = "il";
                break;

            case R.id.rbtn105:
                country = "Italy";
                countryCode = "it";
                break;

            case R.id.rbtn106:
                country = "Jamaica";
                countryCode = "jm";
                break;

            case R.id.rbtn107:
                country = "Japan";
                countryCode = "jp";
                break;

            case R.id.rbtn108:
                country = "Jersey";
                countryCode = "je";
                break;

            case R.id.rbtn109:
                country = "Jordan";
                countryCode = "jo";
                break;

            case R.id.rbtn110:
                country = "Kazakhstan";
                countryCode = "kz";
                break;

            case R.id.rbtn111:
                country = "Kenya";
                countryCode = "ke";
                break;

            case R.id.rbtn114:
                country = "Kuwait";
                countryCode = "kw";
                break;

            case R.id.rbtn117:
                country = "Latvia";
                countryCode = "lv";
                break;

            case R.id.rbtn118:
                country = "Lebanon";
                countryCode = "lb";
                break;

            case R.id.rbtn119:
                country = "Liberia";
                countryCode = "lr";
                break;

            case R.id.rbtn120:
                country = "Libya";
                countryCode = "ly";
                break;

            case R.id.rbtn121:
                country = "Liechtenstein";
                countryCode = "li";
                break;

            case R.id.rbtn122:
                country = "Lithuania";
                countryCode = "lt";
                break;

            case R.id.rbtn123:
                country = "Luxembourg";
                countryCode = "lu";
                break;

            case R.id.rbtn124:
                country = "Montenegro";
                countryCode = "mo";
                break;

            case R.id.rbtn126:
                country = "Macedonia";
                countryCode = "mk";
                break;

            case R.id.rbtn127:
                country = "Madagascar";
                countryCode = "mg";
                break;

            case R.id.rbtn128:
                country = "Malawi";
                countryCode = "mw";
                break;

            case R.id.rbtn129:
                country = "Malaysia";
                countryCode = "my";
                break;

            case R.id.rbtn130:
                country = "Maldives";
                countryCode = "mv";
                break;

            case R.id.rbtn131:
                country = "Mali";
                countryCode = "ml";
                break;

            case R.id.rbtn132:
                country = "Malta";
                countryCode = "mt";
                break;

            case R.id.rbtn138:
                country = "Mexico";
                countryCode = "mx";
                break;


            case R.id.rbtn140:
                country = "Moldova";
                countryCode = "md";
                break;

            case R.id.rbtn141:
                country = "Monaco";
                countryCode = "mc";
                break;


            case R.id.rbtn144:
                country = "Morocco";
                countryCode = "ma";
                break;

            case R.id.rbtn150:
                country = "Netherlands";
                countryCode = "nl";
                break;


            case R.id.rbtn152:
                country = "New Zealand";
                countryCode = "nz";
                break;


            case R.id.rbtn154:
                country = "Niger";
                countryCode = "ne";
                break;


            case R.id.rbtn159:
                country = "Norway";
                countryCode = "no";
                break;

            case R.id.rbtn160:
                country = "Oman";
                countryCode = "om";
                break;

            case R.id.rbtn161:
                country = "Pakistan";
                countryCode = "pk";
                break;

            case R.id.rbtn164:
                country = "Panama";
                countryCode = "pa";
                break;


            case R.id.rbtn167:
                country = "Paraguay";
                countryCode = "py";
                break;

            case R.id.rbtn168:
                country = "peru";
                countryCode = "pe";
                break;

            case R.id.rbtn169:
                country = "Philippines";
                countryCode = "ph";
                break;

            case R.id.rbtn170:
                country = "Poland";
                countryCode = "pl";
                break;

            case R.id.rbtn171:
                country = "Portugal";
                countryCode = "pt";
                break;

            case R.id.rbtn172:
                country = "Qatar";
                countryCode = "qa";
                break;

            case R.id.rbtn173:
                country = "Romania";
                countryCode = "ro";
                break;

            case R.id.rbtn174:
                country = "Lesotho";
                countryCode = "lb";
                break;

            case R.id.rbtn175:
                country = "Serbia";
                countryCode = "rs";
                break;

            case R.id.rbtn176:
                country = "Russia";
                countryCode = "ru";
                break;

            case R.id.rbtn177:
                country = "Rwanda";
                countryCode = "rw";
                break;

            case R.id.rbtn179:
                country = "Saudi Arabia";
                countryCode = "sa";
                break;

            case R.id.rbtn180:
                country = "Senegal";
                countryCode = "sn";
                break;

            case R.id.rbtn7181:
                country = "Sierra Leone";
                countryCode = "sl";
                break;

            case R.id.rbtn182:
                country = "Singapore";
                countryCode = "sg";
                break;

            case R.id.rbtn183:
                country = "Slovakia";
                countryCode = "sk";
                break;

            case R.id.rbtn184:
                country = "Slovenia";
                countryCode = "sl";
                break;

            case R.id.rbtn186:
                country = "Somalia";
                countryCode = "so";
                break;

            case R.id.rbtn187:
                country = "South Africa";
                countryCode = "za";
                break;

            case R.id.rbtn188:
                country = "South Korea ";
                countryCode = "sk";
                break;

            case R.id.rbtn189:
                country = "South Sudan";
                countryCode = "ss";
                break;

            case R.id.rbtn190:
                country = "Spain";
                countryCode = "es";
                break;


            case R.id.rbtn193:
                country = "Sudan";
                countryCode = "sd";
                break;

            case R.id.rbtn194:
                country = "Swaziland";
                countryCode = "sz";
                break;

            case R.id.rbtn195:
                country = "Sweden";
                countryCode = "se";
                break;

            case R.id.rbtn196:
                country = "Switzerland";
                countryCode = "ch";
                break;


            case R.id.rbtn199:
                country = "Thailand";
                countryCode = "th";
                break;

            case R.id.rbtn200:
                country = "Togo";
                countryCode = "tg";
                break;


            case R.id.rbtn202:
                country = "Tunisia";
                countryCode = "tn";
                break;

            case R.id.rbtn203:
                country = "Turkey";
                countryCode = "tr";
                break;

            case R.id.rbtn204:
                country = "Uganda";
                countryCode = "ug";
                break;

            case R.id.rbtn205:
                country = "Ukraine";
                countryCode = "ua";
                break;

            case R.id.rbtn206:
                country = "United Arab Emirates";
                countryCode = "ae";
                break;

            case R.id.rbtn207:
                country = "United Kingdom";
                countryCode = "gb";
                break;

            case R.id.rbtn208:
                country = "United State";
                countryCode = "us";
                break;

            case R.id.rbtn210:
                country = "Uruguay";
                countryCode = "uy";
                break;

            case R.id.rbtn1211:
                country = "Uzbekistan";
                countryCode = "uz";
                break;

            case R.id.rbtn212:
                country = "Venezuela";
                countryCode = "ve";
                break;

            case R.id.rbtn213:
                country = "Vietnam";
                countryCode = "vn";
                break;

            case R.id.rbtn214:
                country = "Western Sahara";
                countryCode = "eh";
                break;

            case R.id.rbtn216:
                country = "Zambia";
                countryCode = "zm";
                break;


            case R.id.rbtn217:
                country = "Zimbabwe";
                countryCode = "zw";
                break;


        }


    }

    private void saveCountry() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        Bundle extras = new Bundle();
        extras.putString("country", country);
        extras.putString("countryCode", countryCode);
        intent.putExtras(extras);
        startActivity(intent);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
