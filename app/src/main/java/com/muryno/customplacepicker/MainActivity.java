package com.muryno.customplacepicker;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

    public static final String TAG=MainActivity.class.getSimpleName();
    String getCountry;

    @BindView(R.id.country)
    EditText addcountry;

    @BindView(R.id.addres)
    EditText mAddress;

    @BindView(R.id.street)
    EditText mstreet;

    @BindView(R.id.apt)
    EditText aptLoc;

    @BindView(R.id.city_id)
    EditText mCity;
    @BindView(R.id.state_id)
    EditText mstates;
    @BindView(R.id.post_cd)
    EditText post_cd;

    @BindView(R.id.spin_kit)
    ProgressBar progressBar;

    @BindView(R.id.nextfur)
    Button fur_next;



    String countryEntered;
    String mstate;
    String pst_cd;

    double lat  ;
    double lng;

    String country;
    String street;
    String city;
    String aptt;
    String state;
    String address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        addcountry.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), CountryRadiobtn.class);
            startActivity(i);

        });


        mstreet.setOnClickListener(v -> placeAutocomplete());


        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            getCountry = extras.getString("country");
            countryEntered = extras.getString("countryCode");
            if (getCountry != null) {
                addcountry.setText(getCountry);
            }
        }

        fur_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getBaseContext(), MapsCirclesActivity.class);
                // Passing latitude and longitude to the MapActiv
                intent.putExtra("lat", lat);
                intent.putExtra("lng", lng);
                startActivity(intent);
            }
        });





        country = addcountry.getText().toString();
        street = mstreet.getText().toString();
        city = mCity.getText().toString();
        state = mstates.getText().toString();
        aptt = aptLoc.getText().toString();
        address = mAddress.getText().toString();
    }
    public void progressbar() {
        ThreeBounce doubleBounce = new ThreeBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void placeAutocomplete(){
        try {
            AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                    .setTypeFilter(AutocompleteFilter.TYPE_FILTER_ESTABLISHMENT).setCountry(countryEntered)
                    .build();


            Intent intent =
                    new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .setFilter(typeFilter)
                            .build(this);
            startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            // TODO: Handle the error.
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                final Place place = PlaceAutocomplete.getPlace(this,data);
                Geocoder geocoder = new Geocoder(this);
                try
                {
                    List<Address> addresses = geocoder.getFromLocation(place.getLatLng().latitude,place.getLatLng().longitude, 1);
                    city = addresses.get(0).getSubAdminArea();
                    street=addresses.get(0).getAddressLine(0);
                    pst_cd=addresses.get(0).getPostalCode();
                    mstate=   addresses.get(0).getAdminArea();
                    country= addresses.get(0).getCountryName();


                    lat=addresses.get(0).getLatitude();
                    lng=addresses.get(0).getLongitude();

                    mstreet.setText(street);
                    mCity.setText(city);
                    mstates.setText(mstate);
                    addcountry.setText(country);
                    post_cd.setText(pst_cd);

                } catch (IOException e){
                    e.printStackTrace();
                }


            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);

                Log.i(TAG, status.getStatusMessage());

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
    }

    private void attemptLogin() {

        // Store values at the time of the login attempt.


        if (TextUtils.isEmpty(country)) {
            addcountry.setError("Please select Listing country");
            addcountry.requestFocus();
            return ;
        }


        if (TextUtils.isEmpty(city) && TextUtils.isEmpty(street)) {
            mCity.setError("Please Enter Listing Street and City");
            mCity.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(state)) {
            mstates.setError("Please Enter Listing State");
            mstates.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(address)) {
            mstates.setError("Please Enter Listing address");
            mstates.requestFocus();
            return;
        }



    }

}
