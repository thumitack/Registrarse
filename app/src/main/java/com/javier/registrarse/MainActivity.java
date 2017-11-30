package com.javier.registrarse;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SelectedDateView = (TextView) findViewById(R.id.tvBirthday);
    }




    // PICK DATE

    public static TextView SelectedDateView;

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            SelectedDateView.setText((month + 1) + "-" + day + "-" + year);
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        //newFragment.setStyle(DialogFragment.STYLE_NO_FRAME, R.style.AppTheme);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void nextActivity (View v){

        Intent intent = new Intent(MainActivity.this, Confirm.class);
        intent.putExtra(getResources().getString(R.string.pName),((TextView) findViewById(R.id.tiName)).getText().toString());
        intent.putExtra(getResources().getString(R.string.pBirthday),((TextView) findViewById(R.id.tvBirthday)).getText().toString());
        intent.putExtra(getResources().getString(R.string.pPhone),((TextView) findViewById(R.id.tiPhone)).getText().toString());
        intent.putExtra(getResources().getString(R.string.pEmail),((TextView) findViewById(R.id.tiEmail)).getText().toString());
        intent.putExtra(getResources().getString(R.string.pDetails),((TextView) findViewById(R.id.tiDetails)).getText().toString());
        startActivity(intent);
    }

}
