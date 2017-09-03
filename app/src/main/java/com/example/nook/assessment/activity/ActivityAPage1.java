package com.example.nook.assessment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.nook.assessment.R;
import com.example.nook.assessment.manager.CFAS;


public class ActivityAPage1 extends Activity {
    RadioButton aes1, aes2, ta1, ta2, ar1, ar2;
    EditText co1, co2, co3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_02);

        aes1 = (RadioButton) findViewById(R.id.activity02CleanRadioTrue);
        aes2 = (RadioButton) findViewById(R.id.activity02CleanRadioFalse);
        ta1 = (RadioButton) findViewById(R.id.activity02TableRadioTrue);
        ta2 = (RadioButton) findViewById(R.id.activity02TableRadioFalse);
        ar1 = (RadioButton) findViewById(R.id.activity02AirFlowRadioTrue);
        ar2 = (RadioButton) findViewById(R.id.activity02AirFlowRadioFalse);
        co1 = (EditText) findViewById(R.id.activity02CleanComment);
        co2 = (EditText) findViewById(R.id.activity02TableComment);
        co3 = (EditText) findViewById(R.id.activity02AirFlowComment);

    }

    public void onClickNext(View view) {
        Log.i("TAG", "onClickNext: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(this, ActivityBPage1.class);
        saveState(intent);
        startActivity(intent);
    }

    public void onClickBack(View view) {
        Log.i("TAG", "onClickBack: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(this, BasicInfoActivity.class);
        saveState(intent);
        startActivity(intent);
    }

    private void saveState(Intent intent) {

        String ch1 = "";
        String ch2 = "";
        String ch3 = "";

        if (aes1.isChecked()) {
            ch1 = "1";
        }
        if (aes2.isChecked()) {
            ch1 = "0";
        }
        if (ta1.isChecked()) {
            ch2 = "1";
        }
        if (ta2.isChecked()) {
            ch2 = "0";
        }
        if (ar1.isChecked()) {
            ch3 = "1";
        }
        if (ar2.isChecked()) {
            ch3 = "0";
        }

        CFAS.getInstance().getSchool().setChoice1(ch1);
        CFAS.getInstance().getSchool().setChoice2(ch2);
        CFAS.getInstance().getSchool().setChoice3(ch3);

        CFAS.getInstance().getSchool().setComment1(co1.getText().toString());
        CFAS.getInstance().getSchool().setComment2(co2.getText().toString());
        CFAS.getInstance().getSchool().setComment3(co3.getText().toString());
    }
}


