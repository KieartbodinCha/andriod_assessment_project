package com.example.nook.assessment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.nook.assessment.R;
import com.example.nook.assessment.manager.CFAS;

public class ActivityDPage1 extends Activity {
    RadioButton cho23, cho24, cho25, cho26;
    EditText co15, co16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_06);

        cho23 = (RadioButton) findViewById(R.id.choice15True);
        cho24 = (RadioButton) findViewById(R.id.choice15False);
        cho25 = (RadioButton) findViewById(R.id.choice16True);
        cho26 = (RadioButton) findViewById(R.id.choice16False);
        co15 = (EditText) findViewById(R.id.choice15Comment);
        co16 = (EditText) findViewById(R.id.choice16Comment);
    }

    public void onClickNext(View view) {
        Log.i("TAG", "onClickNext: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityDPage1.this, ActivityDPage2.class);
        saveState(intent);
        startActivity(intent);
    }

    public void onClickBack(View view) {
        Log.i("TAG", "onClickBack: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityDPage1.this, ActivityCPage2.class);
        saveState(intent);
        startActivity(intent);
    }

    private void saveState(Intent intent) {
        String ch15 = "";
        String ch16 = "";
        if (cho23.isChecked()) {
            ch15 = "1";
        }
        if (cho24.isChecked()) {
            ch15 = "0";
        }
        if (cho25.isChecked()) {
            ch16 = "1";
        }
        if (cho26.isChecked()) {
            ch16 = "0";
        }

        CFAS.getInstance().getSchool().setChoice15(ch15);
        CFAS.getInstance().getSchool().setChoice16(ch16);

        CFAS.getInstance().getSchool().setComment15(co15.getText().toString());
        CFAS.getInstance().getSchool().setComment16(co16.getText().toString());

    }
}
