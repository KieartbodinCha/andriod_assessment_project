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

public class ActivityDPage2 extends Activity {
    RadioButton choice17True, choice17False, choice18True, choice18False, choice19True, choice19False;
    EditText co17, co18, co19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_07);

        ScrollView sv = new ScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOverScrollMode(LinearLayout.VISIBLE);
        sv.addView(ll);

        choice17True = (RadioButton) findViewById(R.id.choice17True);
        choice17False = (RadioButton) findViewById(R.id.choice17False);
        choice18True = (RadioButton) findViewById(R.id.choice18True);
        choice18False = (RadioButton) findViewById(R.id.choice18False);
        choice19True = (RadioButton) findViewById(R.id.choice19True);
        choice19False = (RadioButton) findViewById(R.id.choice19False);
        co17 = (EditText) findViewById(R.id.choice17Comment);
        co18 = (EditText) findViewById(R.id.choice18Comment);
        co19 = (EditText) findViewById(R.id.choice19Comment);
    }

    public void onClickNext(View view) {
        Log.i("TAG", "onClickNext: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityDPage2.this, ActivityDPage3.class);
        saveState(intent);
        startActivity(intent);
    }

    public void onClickBack(View view) {
        Log.i("TAG", "onClickBack: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityDPage2.this, ActivityDPage1.class);
        saveState(intent);
        startActivity(intent);
    }

    private void saveState(Intent intent) {
        String ch17 = "";
        String ch18 = "";
        String ch19 = "";
        if (choice17True.isChecked()) {
            ch17 = "1";
        }
        if (choice17False.isChecked()) {
            ch17 = "0";
        }
        if (choice18True.isChecked()) {
            ch18 = "1";
        }
        if (choice18False.isChecked()) {
            ch18 = "0";
        }
        if (choice19True.isChecked()) {
            ch19 = "1";
        }
        if (choice19False.isChecked()) {
            ch19 = "0";
        }
        CFAS.getInstance().getSchool().setChoice17(ch17);
        CFAS.getInstance().getSchool().setChoice18(ch18);
        CFAS.getInstance().getSchool().setChoice19(ch19);

        CFAS.getInstance().getSchool().setComment17(co17.getText().toString());
        CFAS.getInstance().getSchool().setComment18(co18.getText().toString());
        CFAS.getInstance().getSchool().setComment19(co19.getText().toString());
    }
}
