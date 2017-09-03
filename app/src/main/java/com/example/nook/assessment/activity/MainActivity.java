package com.example.nook.assessment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nook.assessment.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNext(View view) {
        Intent intent = new Intent(MainActivity.this, SchoolInfoActivity.class);
        startActivity(intent);
    }

    public void onClickAll(View view) {
        Intent intent = new Intent(MainActivity.this, SchoolListActivity.class);
        startActivity(intent);
    }

    public void onClickNext3(View view) {
        Intent intent = new Intent(MainActivity.this, RecommendActivity.class);
        startActivity(intent);
    }
}