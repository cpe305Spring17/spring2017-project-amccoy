package aidanmccoy.alarmclock;

import android.app.AlarmManager;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.*;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class SetAlarmsActivity extends AppCompatActivity {

    Button monBtn;
    AlarmManager alarmManager;
    Calendar calendar;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_alarms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("tag", "onCreate entered");

        calendar = Calendar.getInstance();
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(SetAlarmsActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(SetAlarmsActivity.this,0,intent,0);
    }

    public void goToCalendar(View view) {
//        Intent intent = new Intent(this, Calendar.class);
//        startActivity(intent);

    }

    public void onMonBtn(View v) {
        Log.d("tag", "onMonBtn entered");
        DialogFragment newFragment = new MonTimePickerFragment();
        newFragment.show(getFragmentManager(), "TimePicker");

    }

    public void onTueBtn(View v) {
        Log.d("tag", "onTueBtn entered");
        DialogFragment newFragment = new TueTimePickerFragment();
        newFragment.show(getFragmentManager(), "TimePicker");
    }

    public void onWedBtn(View v) {
        Log.d("tag", "onWedBtn entered");
        DialogFragment newFragment = new WedTimePickerFragment();
        newFragment.show(getFragmentManager(), "TimePicker");
    }

    public void onThuBtn(View v) {
        Log.d("tag", "onThuBtn entered");
        DialogFragment newFragment = new ThuTimePickerFragment();
        newFragment.show(getFragmentManager(), "TimePicker");
    }


    public void onFriBtn(View v) {
        Log.d("tag", "onFriBtn entered");
        DialogFragment newFragment = new FriTimePickerFragment();
        newFragment.show(getFragmentManager(), "TimePicker");
    }

    public void onSatBtn(View v) {
        Log.d("tag", "onSatBtn entered");
        DialogFragment newFragment = new SatTimePickerFragment();
        newFragment.show(getFragmentManager(), "TimePicker");
    }

    public void onSunBtn(View v) {
        Log.d("tag", "onSunBtn entered");
        DialogFragment newFragment = new SunTimePickerFragment();
        newFragment.show(getFragmentManager(), "TimePicker");
    }

}
