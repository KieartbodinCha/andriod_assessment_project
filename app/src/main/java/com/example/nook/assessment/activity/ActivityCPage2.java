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

import com.example.nook.assessment.R;
import com.example.nook.assessment.manager.CFAS;

public class ActivityCPage2 extends Activity {
    RadioButton choice11True, choice11False, choice12True, choice12False, choice13True, choice13False, choice14True, choice14False;
    EditText co11, co12, co13, co14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_05);

        ScrollView sv = new ScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOverScrollMode(LinearLayout.VISIBLE);
        sv.addView(ll);

        choice11True = (RadioButton) findViewById(R.id.choice11RadioTrue);
        choice11False = (RadioButton) findViewById(R.id.choice11RadioFalse);
        choice12True = (RadioButton) findViewById(R.id.choice12RadioTrue);
        choice12False = (RadioButton) findViewById(R.id.choice12RadioFalse);
        choice13True = (RadioButton) findViewById(R.id.choice13RadioTrue);
        choice13False = (RadioButton) findViewById(R.id.choice13RadioFalse);
        choice14True = (RadioButton) findViewById(R.id.choice14RadioTrue);
        choice14False = (RadioButton) findViewById(R.id.choice14RadioFalse);
        co11 = (EditText) findViewById(R.id.choice11Comment);
        co12 = (EditText) findViewById(R.id.choice12Comment);
        co13 = (EditText) findViewById(R.id.choice13Comment);
        co14 = (EditText) findViewById(R.id.choice14Comment);
    }

    public void onClickNext(View view) {
        Log.i("TAG", "onClickNext: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityCPage2.this, ActivityDPage1.class);
        saveState(intent);
        startActivity(intent);
    }

    public void onClickBack(View view) {
        Log.i("TAG", "onClickBack: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityCPage2.this, ActivityCPage1.class);
        saveState(intent);
        startActivity(intent);
    }

    private void saveState(Intent intent) {

        String ch11 = "";
        String ch12 = "";
        String ch13 = "";
        String ch14 = "";
        if (choice11True.isChecked()) {
            ch11 = "1";
        }
        if (choice11False.isChecked()) {
            ch11 = "0";
        }
        if (choice12True.isChecked()) {
            ch12 = "1";
        }
        if (choice12False.isChecked()) {
            ch12 = "0";
        }
        if (choice13True.isChecked()) {
            ch13 = "1";
        }
        if (choice13False.isChecked()) {
            ch13 = "0";
        }
        if (choice14True.isChecked()) {
            ch14 = "1";
        }
        if (choice14False.isChecked()) {
            ch14 = "0";
        }

        CFAS.getInstance().getSchool().setChoice11(ch11);
        CFAS.getInstance().getSchool().setChoice12(ch12);
        CFAS.getInstance().getSchool().setChoice13(ch13);
        CFAS.getInstance().getSchool().setChoice14(ch14);

        CFAS.getInstance().getSchool().setComment11(co11.getText().toString());
        CFAS.getInstance().getSchool().setComment12(co12.getText().toString());
        CFAS.getInstance().getSchool().setComment13(co13.getText().toString());
        CFAS.getInstance().getSchool().setComment14(co14.getText().toString());

    }
}

