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

public class ActivityGPage1 extends Activity {
    RadioButton cho47, cho48, cho49, cho50;
    EditText co27, co28;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_11);
        cho47 = (RadioButton) findViewById(R.id.choice27True);
        cho48 = (RadioButton) findViewById(R.id.choice27False);
        cho49 = (RadioButton) findViewById(R.id.choice28True);
        cho50 = (RadioButton) findViewById(R.id.choice28False);
        co27 = (EditText) findViewById(R.id.choice27Comment);
        co28 = (EditText) findViewById(R.id.choice28Comment);
    }

    public void onClickNext(View view) {
        Log.i("TAG", "onClickNext: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityGPage1.this, ActivityGPage2.class);
        saveState(intent);
        startActivity(intent);
    }

    public void onClickBack(View view) {
        Log.i("TAG", "onClickBack: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityGPage1.this, ActivityFPage1.class);
        saveState(intent);
        startActivity(intent);
    }

    private void saveState(Intent intent) {

        String ch27 = "";
        String ch28 = "";
        if (cho47.isChecked()) {
            ch27 = "1";
        }
        if (cho48.isChecked()) {
            ch27 = "0";
        }
        if (cho49.isChecked()) {
            ch28 = "1";
        }
        if (cho50.isChecked()) {
            ch28 = "0";
        }

        CFAS.getInstance().getSchool().setChoice27(ch27);
        CFAS.getInstance().getSchool().setChoice28(ch28);

        CFAS.getInstance().getSchool().setComment27(co27.getText().toString());
        CFAS.getInstance().getSchool().setComment28(co28.getText().toString());


    }
}
