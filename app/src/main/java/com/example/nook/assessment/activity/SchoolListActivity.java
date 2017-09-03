package com.example.nook.assessment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import com.example.nook.assessment.R;
import com.example.nook.assessment.database.DatabaseSchool;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;

import cz.msebera.android.httpclient.Header;

public class SchoolListActivity extends AppCompatActivity {
    DatabaseSchool mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_list);

        mDb = new DatabaseSchool(this);
        final List<HashMap<String, Object>> NameList = mDb.SelectAllData();

        // listView1
        ListView lisView1 = (ListView) findViewById(R.id.listView1);

        SimpleAdapter sAdap;
        sAdap = new SimpleAdapter(SchoolListActivity.this, NameList, R.layout.activity_column,
                new String[]{"ID", "PLACE_NAME"}, new int[]{R.id.activityColumnColName, R.id.activityColumnColProvince});
        lisView1.setAdapter(sAdap);

        lisView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int position, long mylng) {
                Intent newActivity = new Intent(SchoolListActivity.this, SchoolDetailActivity.class);
                newActivity.putExtra("ID", NameList.get(position).get("ID").toString());
                startActivity(newActivity);

            }
        });

        final Button cancel = (Button) findViewById(R.id.btnback);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent newActivity = new Intent(SchoolListActivity.this, MainActivity.class);
                startActivity(newActivity);
            }
        });

    }

    public void onClickSynch(View view) {

        Executors.newSingleThreadExecutor().submit(new Runnable() {
            @Override
            public void run() {
                synch_new();
            }
        });
    }

    private void synch_new() {
        //TODO Change this
        String url = "http://192.168.1.103:8090/assessment-service/api/savedata.php";
        SyncHttpClient client = new SyncHttpClient();
        client.addHeader("Content-Type", "application/x-www-form-urlencoded");
        client.post(url, createRequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                System.out.println(responseString);
                super.onSuccess(statusCode, headers, responseString);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });
    }

    public RequestParams createRequestParams() {
        DatabaseSchool mDb = new DatabaseSchool(this);
        List<HashMap<String, Object>> schoolList = mDb.SelectAllData();
        RequestParams params = new RequestParams();
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(schoolList);
        params.put("data", schoolList);
        return params;
    }
}

