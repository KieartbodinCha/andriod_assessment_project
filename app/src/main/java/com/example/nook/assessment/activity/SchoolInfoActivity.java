package com.example.nook.assessment.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.example.nook.assessment.R;
import com.example.nook.assessment.manager.CFAS;

public class SchoolInfoActivity extends Activity {

    EditText placeName;
    EditText canteenName;
    EditText ownerName;
    EditText departmentName;
    EditText addressName;
    EditText districtName;
    EditText province;
    EditText studentCount;
    EditText customerCount;
    EditText operationCount;
    EditText assessorName;
    EditText assessmentCount;
    EditText assessmentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_main);
        ScrollView sv = new ScrollView(this);
        RelativeLayout ll = new RelativeLayout(this);
        ll.setOverScrollMode(RelativeLayout.VISIBLE);
        sv.addView(ll);

        placeName = (EditText) findViewById(R.id.placeName);
        canteenName = (EditText) findViewById(R.id.canteenName);
        ownerName = (EditText) findViewById(R.id.ownerName);
        departmentName = (EditText) findViewById(R.id.departmentName);
        addressName = (EditText) findViewById(R.id.addressName);
        districtName = (EditText) findViewById(R.id.districtName);
        province = (EditText) findViewById(R.id.province);
        studentCount = (EditText) findViewById(R.id.studentCount);
        customerCount = (EditText) findViewById(R.id.customerCount);
        operationCount = (EditText) findViewById(R.id.operationCount);
        assessorName = (EditText) findViewById(R.id.assessorName);
        assessmentCount = (EditText) findViewById(R.id.assessmentCount);
        assessmentDate = (EditText) findViewById(R.id.assessmentDate);


    }

    public void onClickNextFromMain(View view) {
        Intent intent = new Intent(SchoolInfoActivity.this, BasicInfoActivity.class);
        saveState();
        Log.i("TAG", "onClickNextFromMain: " + CFAS.getInstance().getSchool().toString());
        startActivity(intent);
    }

    public void onClickBackFromMain(View view) {
        Intent intent = new Intent(SchoolInfoActivity.this, MainActivity.class);
        Log.i("TAG", "onClickBackFromMain: " + CFAS.getInstance().getSchool().toString());
        saveState();
        startActivity(intent);
    }

    private void saveState() {

        CFAS.getInstance().getSchool().setPlaceName(placeName.getText().toString());
        CFAS.getInstance().getSchool().setCanteenName(canteenName.getText().toString());
        CFAS.getInstance().getSchool().setOwnerName(ownerName.getText().toString());
        CFAS.getInstance().getSchool().setDepartmentName(departmentName.getText().toString());
        CFAS.getInstance().getSchool().setDistrict(districtName.getText().toString());
        CFAS.getInstance().getSchool().setProvince(province.getText().toString());
        CFAS.getInstance().getSchool().setAddressName(addressName.getText().toString());
        CFAS.getInstance().getSchool().setStudentCount(studentCount.getText().toString());
        CFAS.getInstance().getSchool().setCustomerCount(customerCount.getText().toString());
        CFAS.getInstance().getSchool().setOperationCount(operationCount.getText().toString());
        CFAS.getInstance().getSchool().setAssessorName(assessorName.getText().toString());
        CFAS.getInstance().getSchool().setAssessmentCount(assessmentCount.getText().toString());
        CFAS.getInstance().getSchool().setAssessmentDate(assessmentDate.getText().toString());

    }

}