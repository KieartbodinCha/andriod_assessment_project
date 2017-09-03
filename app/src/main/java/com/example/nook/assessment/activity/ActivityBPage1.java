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

public class ActivityBPage1 extends Activity {

    RadioButton cho1, cho2, cho3, cho4, cho5, cho6, cho7, cho8;
    EditText co4, co5, co6, co7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_03);

        ScrollView sv = new ScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOverScrollMode(LinearLayout.VISIBLE);
        sv.addView(ll);

        cho1 = (RadioButton) findViewById(R.id.activity03FloorRadioTrue);
        cho2 = (RadioButton) findViewById(R.id.activity03FloorRadioFalse);
        cho3 = (RadioButton) findViewById(R.id.activity03AirFlowRadioTrue);
        cho4 = (RadioButton) findViewById(R.id.activity03AirFlowRadioFalse);
        cho5 = (RadioButton) findViewById(R.id.activity03NotCookOnFloorRadioTrue);
        cho6 = (RadioButton) findViewById(R.id.activity03NotCookOnFloorRadioFalse);
        cho7 = (RadioButton) findViewById(R.id.activity03CleanRadioTrue);
        cho8 = (RadioButton) findViewById(R.id.activity03CleanRadioFalse);
        co4 = (EditText) findViewById(R.id.activity03FloorComment);
        co5 = (EditText) findViewById(R.id.activity03AirFlowComment);
        co6 = (EditText) findViewById(R.id.activity03NotCookOnFloorComment);
        co7 = (EditText) findViewById(R.id.activity03CleanComment);

    }

    public void onClickNext(View view) {
        Log.i("TAG", "onClickNext: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityBPage1.this, ActivityCPage1.class);
        saveState(intent);
        startActivity(intent);
    }

    public void onClickBack(View view) {
        Log.i("TAG", "onClickBack: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityBPage1.this, ActivityAPage1.class);
        saveState(intent);
        startActivity(intent);
    }

    private void saveState(Intent intent) {
        String ch4 = "";
        String ch5 = "";
        String ch6 = "";
        String ch7 = "";

        if (cho1.isChecked()) {
            ch4 = "1";
        }
        if (cho2.isChecked()) {
            ch4 = "0";
        }
        if (cho3.isChecked()) {
            ch5 = "1";
        }
        if (cho4.isChecked()) {
            ch5 = "0";
        }
        if (cho5.isChecked()) {
            ch6 = "1";
        }
        if (cho6.isChecked()) {
            ch6 = "0";
        }
        if (cho7.isChecked()) {
            ch7 = "1";
        }
        if (cho8.isChecked()) {
            ch7 = "0";
        }

        CFAS.getInstance().getSchool().setChoice4(ch4);
        CFAS.getInstance().getSchool().setChoice5(ch5);
        CFAS.getInstance().getSchool().setChoice6(ch6);
        CFAS.getInstance().getSchool().setChoice7(ch7);

        CFAS.getInstance().getSchool().setComment4(co4.getText().toString());
        CFAS.getInstance().getSchool().setComment5(co5.getText().toString());
        CFAS.getInstance().getSchool().setComment6(co6.getText().toString());
        CFAS.getInstance().getSchool().setComment7(co7.getText().toString());

    }
}
