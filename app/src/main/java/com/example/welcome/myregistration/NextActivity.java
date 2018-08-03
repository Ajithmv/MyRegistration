package com.example.welcome.myregistration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {
    TextView name, phoneNumber, email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        name = (TextView)findViewById(R.id.name);
        phoneNumber = (TextView)findViewById(R.id.phone);
        email = (TextView)findViewById(R.id.email);
        password = (TextView)findViewById(R.id.password);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
       // String n = sharedPreferences.getString(getString(R.string.app_name),"");

        SharedPreferences settings = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        String name1 = settings.getString("Name",  "");
        String phone = settings.getString("PhoneNumber","");
        String Email = settings.getString("Email","");
        String pas = settings.getString("Password","");

        name.setText(name1);
        phoneNumber.setText(phone);
        email.setText(Email);
        password.setText(pas);

        Toast.makeText(NextActivity.this, "The value is " + name1, Toast.LENGTH_LONG).show();

    }
}