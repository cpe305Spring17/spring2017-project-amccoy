package aidanmccoy.alarmclock;

import android.*;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;

public class SetPlaces extends AppCompatActivity {

    private TextView get_place;
    private Button setPlace;
    int PLACE_PICKER_REQUEST = 1;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private Button getLocation;
    private TextView currentLocation;
    private TextView alarmStatus;

    private Place homePlace;
    private Location homeLocation;
    LatLng latlng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_places);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        get_place = (TextView) findViewById(R.id.placesText);
        setPlace = (Button) findViewById(R.id.setPlace);

        getLocation = (Button) findViewById(R.id.GetLocation);
        currentLocation = (TextView) findViewById(R.id.CurrentLocation);

        alarmStatus = (TextView) findViewById(R.id.alarmStatus);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d("tag", "On Location CHanged enterd");
                currentLocation.setText("Current Location is:\n" + location.getLatitude() + " " + location.getLongitude());
                latlng = homePlace.getLatLng();

                Log.d("tag", "homePlace latlng is " + latlng.toString());

                homeLocation = new Location("McCoy GPS");
                homeLocation.setLatitude(latlng.latitude);
                homeLocation.setLongitude(latlng.longitude);
                Log.d("tag", "distance between is " + homeLocation.distanceTo(location));


                if (homeLocation.distanceTo(location) > 50) {
                    Log.d("tag", "location too far");
                    alarmStatus.setText("Away, Alarms Off");

                } else {
                    Log.d("tag", "location the same");
                    alarmStatus.setText("Home, Alarms On");
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[] {
                    android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET
            }, 10);
            return;
        } else {
            configureButton();
        }

        setPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                Intent intent;
                try {
                    intent = builder.build(SetPlaces.this);
                    startActivityForResult(intent, PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    configureButton();
                return;
        }
    }

    private void configureButton() {
        getLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("tag", "configureBtn on click entered");
                locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if(resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);
                homePlace = place;
                String address = String.format("Home is set as %s", place.getAddress());
                get_place.setText(address);
                locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
            }
        }
    }

}
