package com.example.nook.assessment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.nook.assessment.R;
import com.example.nook.assessment.database.DatabaseSchool;

import java.util.Map;


public class SchoolDetailActivity extends AppCompatActivity {

    DatabaseSchool mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_detail);

        ScrollView sv = new ScrollView(this);
        RelativeLayout ll = new RelativeLayout(this);
        ll.setOverScrollMode(RelativeLayout.VISIBLE);
        sv.addView(ll);

        // Read var from Intent
        Intent intent = getIntent();
        String id = intent.getStringExtra("ID");

        // Show Data
        ShowData(id);

        // btnCancel (Cancel)
        final Button cancel = (Button) findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Open Form Show
                Intent newActivity = new Intent(SchoolDetailActivity.this, SchoolListActivity.class);
                startActivity(newActivity);
            }
        });
    }

    private void ShowData(String id) {
        TextView txtSchoolName = (TextView) findViewById(R.id.txtSchoolName);
        TextView txtOwnerName = (TextView) findViewById(R.id.txtOwnerName);
        TextView txtCanteenName = (TextView) findViewById(R.id.txtCanteenName);
        TextView txtDepartmentName = (TextView) findViewById(R.id.txtDepartmentName);
        TextView txtStudentCount = (TextView) findViewById(R.id.txtStudentCount);
        TextView txtAddress = (TextView) findViewById(R.id.txtAddress);
        TextView txtDistrict = (TextView) findViewById(R.id.txtDistrict);
        TextView txtProvince = (TextView) findViewById(R.id.txtProvince);
        TextView txtCustomerCount = (TextView) findViewById(R.id.txtCustomerCount);
        TextView txtOperationCount = (TextView) findViewById(R.id.txtOperationCount);
        TextView txtAssessmentCount = (TextView) findViewById(R.id.txtAssessmentCount);
//        TextView txtAssessmentResult = (TextView) findViewById(R.id.txtAssessmentResult);
        TextView txtAssessmentDate = (TextView) findViewById(R.id.txtAssessmentDate);

        TextView txtHaveTrain = (TextView) findViewById(R.id.txtHaveTrain);
        TextView txtServiceType = (TextView) findViewById(R.id.txtServiceType);
        TextView txtLunch = (TextView) findViewById(R.id.txtLunch);

        TextView txtNo1 = (TextView) findViewById(R.id.txtNo1);
        TextView txtNo2 = (TextView) findViewById(R.id.txtNo2);
        TextView txtNo3 = (TextView) findViewById(R.id.txtNo3);
        TextView txtNo4 = (TextView) findViewById(R.id.txtNo4);
        TextView txtNo5 = (TextView) findViewById(R.id.txtNo5);
        TextView txtNo6 = (TextView) findViewById(R.id.txtNo6);
        TextView txtNo7 = (TextView) findViewById(R.id.txtNo7);
        TextView txtNo8 = (TextView) findViewById(R.id.txtNo8);
        TextView txtNo9 = (TextView) findViewById(R.id.txtNo9);
        TextView txtNo10 = (TextView) findViewById(R.id.txtNo10);

        TextView txtNo11 = (TextView) findViewById(R.id.txtNo11);
        TextView txtNo12 = (TextView) findViewById(R.id.txtNo12);
        TextView txtNo13 = (TextView) findViewById(R.id.txtNo13);
        TextView txtNo14 = (TextView) findViewById(R.id.txtNo14);
        TextView txtNo15 = (TextView) findViewById(R.id.txtNo15);
        TextView txtNo16 = (TextView) findViewById(R.id.txtNo16);
        TextView txtNo17 = (TextView) findViewById(R.id.txtNo17);
        TextView txtNo18 = (TextView) findViewById(R.id.txtNo18);
        TextView txtNo19 = (TextView) findViewById(R.id.txtNo19);
        TextView txtNo20 = (TextView) findViewById(R.id.txtNo20);

        TextView txtNo21 = (TextView) findViewById(R.id.txtNo21);
        TextView txtNo22 = (TextView) findViewById(R.id.txtNo22);
        TextView txtNo23 = (TextView) findViewById(R.id.txtNo23);
        TextView txtNo24 = (TextView) findViewById(R.id.txtNo24);
        TextView txtNo25 = (TextView) findViewById(R.id.txtNo25);
        TextView txtNo26 = (TextView) findViewById(R.id.txtNo26);
        TextView txtNo27 = (TextView) findViewById(R.id.txtNo27);
        TextView txtNo28 = (TextView) findViewById(R.id.txtNo28);
        TextView txtNo29 = (TextView) findViewById(R.id.txtNo29);
        TextView txtNo30 = (TextView) findViewById(R.id.txtNo30);

        mDb = new DatabaseSchool(this);
        Map<String, Object> data = mDb.SelectData(id);
        if (data != null) {
            txtSchoolName.setText((String)data.get("PLACE_NAME"));
            txtOwnerName.setText((String)data.get("OWNER_NAME"));
            txtCanteenName.setText((String)data.get("CANTEEN_NAME"));
            txtDepartmentName.setText((String)data.get("DEPARTMENT_NAME"));
            txtStudentCount.setText((String)data.get("STUDENT_COUNT"));
            txtAddress.setText((String)data.get("ADDRESS"));
            txtDistrict.setText((String)data.get("DISTRICT"));
            txtProvince.setText((String)data.get("PROVINCE"));
            txtCustomerCount.setText((String)data.get("CUSTOMER_COUNT"));
            txtOperationCount.setText((String)data.get("OPERATION_COUNT"));
            txtAssessmentCount.setText((String)data.get("ASSESSMENT_COUNT"));
            txtAssessmentDate.setText((String)data.get("ASSESSMENT_DATE"));

            txtHaveTrain.setText(convertDataTrain((String)data.get("BASIC_TRAIN")));
            txtServiceType.setText(convertDataServiceType((String)data.get("BASIC_SERVICE_TYPE")));
            txtLunch.setText(convertDataLunch((String)data.get("BASIC_LUNCH_ORGANIZE")));

            txtNo1.setText(convertData((String)data.get("CHOICE1")));
            txtNo2.setText(convertData((String)data.get("CHOICE2")));
            txtNo3.setText(convertData((String)data.get("CHOICE3")));
            txtNo4.setText(convertData((String)data.get("CHOICE4")));
            txtNo5.setText(convertData((String)data.get("CHOICE5")));
            txtNo6.setText(convertData((String)data.get("CHOICE6")));
            txtNo7.setText(convertData((String)data.get("CHOICE7")));
            txtNo8.setText(convertData((String)data.get("CHOICE8")));
            txtNo9.setText(convertData((String)data.get("CHOICE9")));
            txtNo10.setText(convertData((String)data.get("CHOICE10")));

            txtNo11.setText(convertData((String)data.get("CHOICE11")));
            txtNo12.setText(convertData((String)data.get("CHOICE12")));
            txtNo13.setText(convertData((String)data.get("CHOICE13")));
            txtNo14.setText(convertData((String)data.get("CHOICE14")));
            txtNo15.setText(convertData((String)data.get("CHOICE15")));
            txtNo16.setText(convertData((String)data.get("CHOICE16")));
            txtNo17.setText(convertData((String)data.get("CHOICE17")));
            txtNo18.setText(convertData((String)data.get("CHOICE18")));
            txtNo19.setText(convertData((String)data.get("CHOICE19")));
            txtNo20.setText(convertData((String)data.get("CHOICE20")));

            txtNo21.setText(convertData((String)data.get("CHOICE21")));
            txtNo22.setText(convertData((String)data.get("CHOICE22")));
            txtNo23.setText(convertData((String)data.get("CHOICE23")));
            txtNo24.setText(convertData((String)data.get("CHOICE24")));
            txtNo25.setText(convertData((String)data.get("CHOICE25")));
            txtNo26.setText(convertData((String)data.get("CHOICE26")));
            txtNo27.setText(convertData((String)data.get("CHOICE27")));
            txtNo28.setText(convertData((String)data.get("CHOICE28")));
            txtNo29.setText(convertData((String)data.get("CHOICE29")));
            txtNo30.setText(convertData((String)data.get("CHOICE30")));
        }
    }

    private String convertData(String data) {
        String converted = "ไม่ผ่าน";
        if (data != null) {
            if ("1".equals(data)) {
                converted = "ผ่าน";
            }
        }
        return converted;
    }

    private String convertDataTrain(String data) {
        String converted = "ไม่เคย";
        if (data != null) {
            if ("1".equals(data)) {
                converted = "เคย";
            }
        }
        return converted;
    }

    private String convertDataServiceType(String data) {
        String converted = "";
        if (data != null) {
            if ("0".equals(data)) {
                converted = "หน่วยงานดำเนินการเองทั้งหมด";
            }else if ("1".equals(data)){
                converted = "ให้บุคคลภายนอกเข้ามาจำหน่ายอาหาร";
            }else if ("2".equals(data)){
                converted = "หน่วยงานและบุคคลภายนอกดำเนินการ";
            }
        }
        return converted;
    }
    private String convertDataLunch(String data) {
        String converted = "ไม่เคย";
        if (data != null) {
            if ("1".equals(data)) {
                converted = "เคย";
            }
        }
        return converted;
    }
}

