package com.example.welcome.myregistration;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity{

    EditText mname;
    EditText mphoneNumber;
    EditText memail;
    EditText mpassword;
    Button mregister;
    Button mnext;
    Button login;

    public static final String MyPREFERENCES="MyPreferences";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mname = (EditText)findViewById(R.id.etName);
        mphoneNumber = (EditText)findViewById(R.id.etPhone);
        memail = (EditText)findViewById(R.id.etEmail);
        mpassword = (EditText)findViewById(R.id.etPassword);
        mregister = (Button)findViewById(R.id.etRegister);
        mnext = (Button)findViewById(R.id.etNext);
        login = (Button)findViewById(R.id.etlogin);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = mname.getText().toString();
                String ph = mphoneNumber.getText().toString();
                String e = memail.getText().toString();
                String pas = mpassword.getText().toString();

                SharedPreferences.Editor editor=sharedPreferences.edit();

                editor.putString("Name", n);
                editor.putString("PhoneNumber", ph);
                editor.putString("Email", e);
                editor.putString("Password", pas);

                editor.commit();
                Toast.makeText(RegistrationActivity.this, "Thanks", Toast.LENGTH_LONG).show();
            }
        });

        mnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(in);


            }
        });

    }
}
