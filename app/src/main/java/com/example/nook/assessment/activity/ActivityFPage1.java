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

public class ActivityFPage1 extends Activity {
    RadioButton cho43, cho44, cho45, cho46;
    EditText co25, co26;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_10);
        cho43 = (RadioButton) findViewById(R.id.choice25True);
        cho44 = (RadioButton) findViewById(R.id.choice25False);
        cho45 = (RadioButton) findViewById(R.id.choice26True);
        cho46 = (RadioButton) findViewById(R.id.choice26False);
        co25 = (EditText) findViewById(R.id.choice25Comment);
        co26 = (EditText) findViewById(R.id.choice26Comment);

    }

    public void onClickNext(View view) {
        Log.i("TAG", "onClickNext: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityFPage1.this, ActivityGPage1.class);
        saveState(intent);
        startActivity(intent);

    }

    public void onClickBack(View view) {
        Log.i("TAG", "onClickBack: " + CFAS.getInstance().getSchool().toString());
        Intent intent = new Intent(ActivityFPage1.this, ActivityEPage1.class);
        saveState(intent);
        startActivity(intent);

    }

    private void saveState(Intent intent) {

        String ch25 = "";
        String ch26 = "";
        if (cho43.isChecked()) {
            ch25 = "1";
        }
        if (cho44.isChecked()) {
            ch25 = "0";
        }
        if (cho45.isChecked()) {
            ch26 = "1";
        }
        if (cho46.isChecked()) {
            ch26 = "0";
        }
        CFAS.getInstance().getSchool().setChoice25(ch25);
        CFAS.getInstance().getSchool().setChoice26(ch26);

        CFAS.getInstance().getSchool().setComment25(co25.getText().toString());
        CFAS.getInstance().getSchool().setComment26(co26.getText().toString());


    }
}
