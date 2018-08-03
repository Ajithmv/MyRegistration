package com.example.welcome.myregistration;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.KeyStore;
import java.util.jar.Attributes;

public class SplashActivity extends AppCompatActivity {
    EditText splash;

    private static int SPLASHTIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash = (EditText)findViewById(R.id.etSecondPage);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
                SharedPreferences set = getSharedPreferences("MyPreferences", MODE_PRIVATE);
                final SharedPreferences.Editor editor = sharedPreferences.edit();

                final String name2 = set.getString("Name", "");

                //Toast.makeText(SplashActivity.this,  "Name. "+name2, Toast.LENGTH_SHORT).show();//

                if (!name2.equals("")){
                    Intent send = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(send);
                }
                else{
                        Intent s = new Intent(SplashActivity.this, RegistrationActivity.class);
                        startActivity(s);
                }
            }
        }, SPLASHTIME);

            }

        };


