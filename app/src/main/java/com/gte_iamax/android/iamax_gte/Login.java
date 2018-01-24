package com.gte_iamax.android.iamax_gte;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    //NOTE: NO SPIN AS OF THE MOMENT

    EditText et_Username, et_Password, et_Spin;
    TextView linkLog;
    Button btnLogin;

    SharedPreferences prefs;

    DataBaseHelper databaseHandler;

    @SuppressLint("NewApi")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Login.this.finishAffinity();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
//        getSupportActionBar().hide();

        //get Reference of Views
        et_Username = (EditText) findViewById(R.id.et_username);
        et_Password = (EditText) findViewById(R.id.et_password);
        et_Spin = (EditText) findViewById(R.id.et_spin);
        linkLog = (TextView) findViewById(R.id.tlink_register);

        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get The User name and Password
                final EditText userName = (EditText) findViewById(R.id.et_username);
                final EditText password = (EditText) findViewById(R.id.et_password);
                final String spin = et_Spin.getText().toString();

                Button btnLogin = (Button) findViewById(R.id.btn_login);

                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (databaseHandler.checkUser(userName.getText().toString().trim(),
                                password.getText().toString().trim())) {
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString("username", et_Username.getText().toString());
                            editor.putString("password", et_Password.getText().toString());
                            editor.commit();
                            Intent intent = new Intent(Login.this, MainActivity.class); // for the meantime MainAct sa, change to Homescreen para ig login mao na dritso musud
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "Wrong Credential",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

        linkLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
                finish();
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }
}