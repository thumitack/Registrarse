package com.javier.registrarse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Confirm extends AppCompatActivity {

    private TextView tvName;
    private TextView tvBirthday;
    private TextView tvPhone;
    private TextView tvEmail;
    private TextView tvDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Bundle params = getIntent().getExtras();

        String name = params.getString(getResources().getString(R.string.pName));
        String birthday = params.getString(getResources().getString(R.string.pBirthday));
        String phone = params.getString(getResources().getString(R.string.pPhone));
        String email = params.getString(getResources().getString(R.string.pEmail));
        String details = params.getString(getResources().getString(R.string.pDetails));

        tvName = (TextView) findViewById(R.id.tvName);
        tvBirthday = (TextView) findViewById(R.id.tvBirthday);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDetails = (TextView) findViewById(R.id.tvDetails);


        tvName.setText(getResources().getString(R.string.name)+ ": " +name);
        tvBirthday.setText(getResources().getString(R.string.birthday)+ ": " +birthday);
        tvPhone.setText(getResources().getString(R.string.phone)+ ": " +phone);
        tvEmail.setText(getResources().getString(R.string.email)+ ": " +email);
        tvDetails.setText(getResources().getString(R.string.details)+ ": " +details);
    }

    public void reviewData (View v){
        finish();
    }
}
