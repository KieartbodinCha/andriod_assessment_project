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

public class ActivityEPage1 extends Activity {
    RadioButton cho37, cho38, cho39, cho40, cho41, cho42;
    EditText co22, co23, co24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_09);

        ScrollView sv = new ScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOverScrollMode(LinearLayout.VISIBLE);
        sv.addView(ll);

        cho37 = (RadioButton) findViewById(R.id.choice22True);
        cho38 = (RadioButton) findViewById(R.id.choice22False);
        cho39 = (RadioButton) findViewById(R.id.choice23True);
        cho40 = (RadioButton) findViewById(R.id.choice23False);
        cho41 = (RadioButton) findViewById(R.id.choice24True);
        cho42 = (RadioButton) findViewById(R.id.choice24False);
        co22 = (EditText) findViewById(R.id.choice22Comment);
        co23 = (EditText) findViewById(R.id.choice23Comment);
        co24 = (EditText) findViewById(R.id.choice24Comment);
    }

    public void onClickNext(View view) {
        Log.i("TAG", "onClickNext: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityEPage1.this, ActivityFPage1.class);
        saveState(intent);
        startActivity(intent);
    }

    public void onClickBack(View view) {
        Log.i("TAG", "onClickBack: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityEPage1.this, ActivityDPage3.class);
        saveState(intent);
        startActivity(intent);

    }

    private void saveState(Intent intent) {
        String ch22 = "";
        String ch23 = "";
        String ch24 = "";
        if (cho37.isChecked()) {
            ch22 = "1";
        }
        if (cho38.isChecked()) {
            ch22 = "0";
        }
        if (cho39.isChecked()) {
            ch23 = "1";
        }
        if (cho40.isChecked()) {
            ch23 = "0";
        }
        if (cho41.isChecked()) {
            ch24 = "1";
        }
        if (cho42.isChecked()) {
            ch24 = "0";
        }

        CFAS.getInstance().getSchool().setChoice22(ch22);
        CFAS.getInstance().getSchool().setChoice23(ch23);
        CFAS.getInstance().getSchool().setChoice24(ch24);

        CFAS.getInstance().getSchool().setComment22(co22.getText().toString());
        CFAS.getInstance().getSchool().setComment23(co23.getText().toString());
        CFAS.getInstance().getSchool().setComment24(co24.getText().toString());




    }
}
