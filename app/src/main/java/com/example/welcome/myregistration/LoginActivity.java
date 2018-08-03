package com.example.welcome.myregistration;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText musername, mpassword;

    Button mlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        musername = (EditText)findViewById(R.id.etUsername);
        mpassword = (EditText)findViewById(R.id.etPassword);
        mlogin = (Button) findViewById(R.id.etLogin);

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = musername.getText().toString();
                String password = mpassword.getText().toString();

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                SharedPreferences set = getSharedPreferences("MyPreferences", MODE_PRIVATE);

                String name1 = set.getString("Name",  "");
                String password1 = set.getString("Password",  "");

                if ((name.equals(name1)) && (password.equals(password1))){

                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);

                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("Name", "true");
                    editor.commit();

                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
