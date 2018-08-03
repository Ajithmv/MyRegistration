package com.example.welcome.myregistration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button mLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mLogout = (Button)findViewById(R.id.etLogout);

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeActivity.this, RegistrationActivity.class);

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(HomeActivity.this);
                SharedPreferences set = getSharedPreferences("MyPreferences", MODE_PRIVATE);

                final SharedPreferences.Editor editor = set.edit();

                editor.remove("Name");
                editor.commit();
                editor.clear();
                editor.apply();

                startActivity(intent);
                finish();

            }
        });
    }

}

