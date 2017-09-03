package com.example.nook.assessment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.example.nook.assessment.R;
import com.example.nook.assessment.manager.CFAS;

public class BasicInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_01);
    }

    public void onClickNextFromSchool1(View v) {
        Intent intent = new Intent(this, ActivityAPage1.class);
        saveState(intent);
        startActivity(intent);
        Log.i("TAG", "onClickNextFromSchool1: " + CFAS.getInstance().getSchool().toString());
    }

    public void onClickBackFromSchool1(View view) {
        Intent intent = new Intent(this, SchoolInfoActivity.class);
        saveState(intent);
        startActivity(intent);
        Log.i("TAG", "onClickBackFromSchool1: " + CFAS.getInstance().getSchool().toString());
    }

    private void saveState(Intent intent) {
        RadioButton basicTrainRadioTrue = (RadioButton) findViewById(R.id.basicTrainRadioTrue);
        RadioButton basicTrainRadioFalse = (RadioButton) findViewById(R.id.basicTrainRadioFalse);
        RadioButton basicServiceTypeRadioInsider = (RadioButton) findViewById(R.id.basicServiceTypeRadioInsider);
        RadioButton basicServiceTypeRadioOutsider = (RadioButton) findViewById(R.id.basicServiceTypeRadioOutsider);
        RadioButton basicServiceTypeRadioBoth = (RadioButton) findViewById(R.id.basicServiceTypeRadioBoth);
        RadioButton basicLunchOrganizeTrue = (RadioButton) findViewById(R.id.basicLunchOrganizeTrue);
        RadioButton basicLunchOrganizeFalse = (RadioButton) findViewById(R.id.basicLunchOrganizeFalse);

        String haveTrain = "";
        String serviceType = "";
        String lunchOrganize = "";

        if (basicTrainRadioTrue.isChecked()) {
            haveTrain = "1";
        }
        if (basicTrainRadioFalse.isChecked()) {
            haveTrain = "0";
        }
        if (basicServiceTypeRadioInsider.isChecked()) {
            serviceType = "0";
        }
        if (basicServiceTypeRadioOutsider.isChecked()) {
            serviceType = "1";
        }
        if (basicServiceTypeRadioBoth.isChecked()) {
            serviceType = "2";
        }
        if (basicLunchOrganizeTrue.isChecked()) {
            lunchOrganize = "0";
        }
        if (basicLunchOrganizeFalse.isChecked()) {
            lunchOrganize = "1";
        }

        CFAS.getInstance().getSchool().setBasicTrain(haveTrain);
        CFAS.getInstance().getSchool().setBasicServiceType(serviceType);
        CFAS.getInstance().getSchool().setBasicLunchOrganize(lunchOrganize);
    }
}
