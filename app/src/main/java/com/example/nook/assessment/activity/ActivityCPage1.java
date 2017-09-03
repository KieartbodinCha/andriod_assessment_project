package com.example.nook.assessment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.nook.assessment.R;
import com.example.nook.assessment.manager.CFAS;

public class ActivityCPage1 extends Activity {

    RadioButton cho9, cho10, cho11, cho12, cho13, cho14;
    EditText co8, co9, co10;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_04);

        ScrollView sv = new ScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOverScrollMode(LinearLayout.VISIBLE);
        sv.addView(ll);

        cho9 = (RadioButton) findViewById(R.id.activity04SealedWthDocRadioTrue);
        cho10 = (RadioButton) findViewById(R.id.activity04SealedWthDocRadioFalse);
        cho11 = (RadioButton) findViewById(R.id.activity04FreshRadioTrue);
        cho12 = (RadioButton) findViewById(R.id.activity04FreshRadioFalse);
        cho13 = (RadioButton) findViewById(R.id.activity04SealedAndQualityRadioTrue);
        cho14 = (RadioButton) findViewById(R.id.activity04SealedAndQualityRadioFalse);
        co8 = (EditText) findViewById(R.id.activity04SealedWthDocComment);
        co9 = (EditText) findViewById(R.id.activity04FreshComment);
        co10 = (EditText) findViewById(R.id.activity04SealedAndQualityComment);
    }

    public void onClickNext(View view) {
        Log.i("TAG", "onClickNext: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityCPage1.this, ActivityCPage2.class);
        saveState(intent);
        startActivity(intent);
    }

    public void onClickBack(View view) {
        Log.i("TAG", "onClickBack: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityCPage1.this, ActivityBPage1.class);
        saveState(intent);
        startActivity(intent);
    }

    private void saveState(Intent intent) {

        String ch8 = "";
        String ch9 = "";
        String ch10 = "";
        if (cho9.isChecked()) {
            ch8 = "1";
        }
        if (cho10.isChecked()) {
            ch8 = "0";
        }
        if (cho11.isChecked()) {
            ch9 = "1";
        }
        if (cho12.isChecked()) {
            ch9 = "0";
        }
        if (cho13.isChecked()) {
            ch10 = "1";
        }
        if (cho14.isChecked()) {
            ch10 = "0";
        }

        CFAS.getInstance().getSchool().setChoice8(ch8);
        CFAS.getInstance().getSchool().setChoice9(ch9);
        CFAS.getInstance().getSchool().setChoice10(ch10);

        CFAS.getInstance().getSchool().setComment8(co8.getText().toString());
        CFAS.getInstance().getSchool().setComment9(co9.getText().toString());
        CFAS.getInstance().getSchool().setComment10(co10.getText().toString());
    }

}
