package com.example.nook.assessment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.nook.assessment.R;
import com.example.nook.assessment.manager.CFAS;

public class ActivityResult extends Activity {

    private TextView txtCount;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_14);

        txtCount = (TextView) findViewById(R.id.passCount);
        txtResult = (TextView) findViewById(R.id.result);

        Log.i("TAG", "onClickNext: " + CFAS.getInstance().getSchool().toString());

        txtResult.setText((String) getIntent().getExtras().get("txtResult"));
        txtCount.setText("" + (int) getIntent().getExtras().get("txtCount"));

    }

    public void onClickNext(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}

