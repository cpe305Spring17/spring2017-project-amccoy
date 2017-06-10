package aidanmccoy.alarmclock;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

/**
 * Created by aidanmccoy on 5/19/17.
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private Time pickedTime;

    public Time getTime() {
        return pickedTime;
    }

    public void setTime(Time time) {
        pickedTime = time;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        pickedTime.setHours(hourOfDay);
        pickedTime.setMinutes(minute);
        Log.d("tag", "The time set is:" + pickedTime.toString());

        TextView monTime = (TextView) getActivity().findViewById(R.id.monTime);
        monTime.setText(String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
    }
}
