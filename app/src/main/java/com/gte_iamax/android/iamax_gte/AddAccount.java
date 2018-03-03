package com.gte_iamax.android.iamax_gte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.rilixtech.materialfancybutton.MaterialFancyButton;

public class AddAccount extends AppCompatActivity {
   private MaterialFancyButton clrBtn,addBtn;
    private RadioGroup gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        clrBtn = (MaterialFancyButton) findViewById(R.id.clear);
        addBtn = (MaterialFancyButton) findViewById(R.id.add);
        gender = (RadioGroup) findViewById(R.id.rgGender);
    }

}
