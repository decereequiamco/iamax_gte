package com.gte_iamax.android.iamax_gte;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    //NOTE: NO SPIN AS OF THE MOMENT

    TextView linkLogin;
    EditText et_username, et_password, et_password2, et_mobNum, et_spin;
    Button btnRegister;
    DataBaseHelper databaseHandler;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
//        getSupportActionBar().hide();


        prefs = getSharedPreferences("inUser", MODE_PRIVATE);

        linkLogin = (TextView) findViewById(R.id.link_login);

        linkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NavDrawer.class);
                startActivity(intent);

            }
        });


        //get Reference of View
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        et_password2 = (EditText) findViewById(R.id.et_password2);
        et_mobNum = (EditText) findViewById(R.id.et_mobNum);
        et_spin = (EditText) findViewById(R.id.et_spin);

        /*et_password2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(!et_password.equals(et_password2))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return false;
                }else{
                    return true;
                }
            }
        });*/

        btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInputValidity()) {
                    if (!databaseHandler.checkUserExistence(et_username.getText().toString().trim())) {
                        User user = new User();
                        user.setUsername(et_username.getText().toString());
                        user.setPassword(et_password.getText().toString());
                        user.setMobileNum(et_mobNum.getText().toString());
                        user.setS_pin(et_spin.getText().toString());
                        databaseHandler.addUser(user);
                        et_username.setText("");
                        et_password.setText("");
                        et_password2.setText("");
                        et_mobNum.setText("");
                        et_spin.setText("");
                        Toast.makeText(Register.this, "Registered Successfully\nPlease Login",
                                Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Register.this, "Username already exists",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }


    private boolean checkInputValidity() {
        String username, password, password2, mobileNumber, spin;
        username = et_username.getText().toString().trim();
        password = et_password.getText().toString().trim();
        password2 = et_password2.getText().toString().trim();
        mobileNumber = et_mobNum.getText().toString().trim();
        spin = et_spin.getText().toString().trim();
//        if (username.equals("") || password.equals("") || password2.equals("") || mobileNumber.equals("") || spin.equals("")) {
//            Toast.makeText(Register.this, "No field can be left empty", Toast.LENGTH_SHORT).show();
            if (username.equals("")){
                et_username.setError("Please Input Value");
            }
            else if(password.equals("")) {
                et_password.setError("Please Input Value");

            }
            else if(password2.equals("")){
                et_password2.setError("Please Input Value");
            }
            else if(mobileNumber.equals("")){
                et_mobNum.setError("Please Input Value");
            }
            else if(spin.equals("")){
                et_spin.setError("Please Input Value");
            }

    /*else if(!password.equals(password2))
        {
            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
            return false;
        }*/ //else {
            //return true;
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }

}
