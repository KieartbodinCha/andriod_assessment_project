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

public class ActivityDPage3 extends Activity {
    RadioButton cho33, cho34, cho35, cho36;
    EditText co20, co21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_08);
        cho33 = (RadioButton) findViewById(R.id.choice20True);
        cho34 = (RadioButton) findViewById(R.id.choice20False);
        cho35 = (RadioButton) findViewById(R.id.choice21True);
        cho36 = (RadioButton) findViewById(R.id.choice21False);
        co20 = (EditText) findViewById(R.id.choice20Comment);
        co21 = (EditText) findViewById(R.id.choice21Comment);

    }

    public void onClickNext(View view) {
        Log.i("TAG", "onClickNext: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityDPage3.this, ActivityEPage1.class);
        saveState(intent);
        startActivity(intent);
    }

    public void onClickBack(View view) {
        Log.i("TAG", "onClickBack: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityDPage3.this, ActivityDPage2.class);
        saveState(intent);
        startActivity(intent);
    }

    private void saveState(Intent intent) {
        String ch20 = "";
        String ch21 = "";
        if (cho33.isChecked()) {
            ch20 = "1";
        }
        if (cho34.isChecked()) {
            ch20 = "0";
        }
        if (cho35.isChecked()) {
            ch21 = "1";
        }
        if (cho36.isChecked()) {
            ch21 = "0";
        }
        CFAS.getInstance().getSchool().setChoice20(ch20);
        CFAS.getInstance().getSchool().setChoice21(ch21);

        CFAS.getInstance().getSchool().setComment20(co20.getText().toString());
        CFAS.getInstance().getSchool().setComment21(co21.getText().toString());

    }
}
