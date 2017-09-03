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

public class ActivityGPage2 extends Activity {
    RadioButton cho51, cho52, cho53, cho54;
    EditText co29, co30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_12);

        cho51 = (RadioButton) findViewById(R.id.choice29True);
        cho52 = (RadioButton) findViewById(R.id.choice29False);
        cho53 = (RadioButton) findViewById(R.id.choice30True);
        cho54 = (RadioButton) findViewById(R.id.choice30False);
        co29 = (EditText) findViewById(R.id.choice29Comment);
        co30 = (EditText) findViewById(R.id.choice30Comment);
    }


    public void onClickNext(View view) {
        Log.i("TAG", "onClickNext: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityGPage2.this, ActivityUploadImage.class);
        saveState(intent);
        startActivity(intent);
    }

    public void onClickBack(View view) {
        Log.i("TAG", "onClickBack: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityGPage2.this, ActivityGPage1.class);
        saveState(intent);
        startActivity(intent);
    }

    private void saveState(Intent intent) {

        String ch29 = "";
        String ch30 = "";
        if (cho51.isChecked()) {
            ch29 = "1";
        }
        if (cho52.isChecked()) {
            ch29 = "0";
        }
        if (cho53.isChecked()) {
            ch30 = "1";
        }
        if (cho54.isChecked()) {
            ch30 = "0";
        }

        CFAS.getInstance().getSchool().setChoice29(ch29);
        CFAS.getInstance().getSchool().setChoice30(ch30);

        CFAS.getInstance().getSchool().setComment29(co29.getText().toString());
        CFAS.getInstance().getSchool().setComment30(co30.getText().toString());




    }
}
