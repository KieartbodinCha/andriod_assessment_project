package com.example.nook.assessment.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nook.assessment.R;
import com.example.nook.assessment.database.DatabaseSchool;
import com.example.nook.assessment.manager.CFAS;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ActivityUploadImage extends Activity {
    public static final int REQUEST_GALLERY = 1;


    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_13);

        imageView1 = (ImageView) findViewById(R.id.uploadImage1);
        imageView2 = (ImageView) findViewById(R.id.uploadImage2);
        imageView3 = (ImageView) findViewById(R.id.uploadImage3);
        imageView4 = (ImageView) findViewById(R.id.uploadImage4);

        Button buttonIntent = (Button) findViewById(R.id.activity13SelectImg);
        buttonIntent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent
                        , "Select Picture"), REQUEST_GALLERY);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode
            , Intent data) {
        if (requestCode == REQUEST_GALLERY && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                byte[] bytes = null;
                if (imageView1.getDrawable() == null) {
                    imageView1.setImageBitmap(bitmap);
                    bytes = convertToBytes(bitmap);
                    CFAS.getInstance().getSchool().setImg1(bytes);
                } else if (imageView2.getDrawable() == null) {
                    imageView2.setImageBitmap(bitmap);
                    bytes = convertToBytes(bitmap);
                    CFAS.getInstance().getSchool().setImg2(bytes);
                } else if (imageView3.getDrawable() == null) {
                    imageView3.setImageBitmap(bitmap);
                    bytes = convertToBytes(bitmap);
                    CFAS.getInstance().getSchool().setImg3(bytes);
                } else if (imageView4.getDrawable() == null) {
                    imageView4.setImageBitmap(bitmap);
                    bytes = convertToBytes(bitmap);
                    CFAS.getInstance().getSchool().setImg4(bytes);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private byte[] convertToBytes(Bitmap image) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 50, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public void onClickSave(View view) {
        Intent intent = new Intent(ActivityUploadImage.this, ActivityResult.class);
        Log.i("TAG", "onClickSave: " + CFAS.getInstance().getSchool().toString());

        int count = 0;
        int count2 = 0;
        String pass = "1";
        String fail = "0";

        if (CFAS.getInstance().getSchool().getChoice1().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice1().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice2().equals(pass)) {
            count++;
        }
        if (CFAS.getInstance().getSchool().getChoice3().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice4().equals(pass)) {
            count++;
        }
        if (CFAS.getInstance().getSchool().getChoice5().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice6().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice7().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice8().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice9().equals(pass)) {
            count++;
        }
        if (CFAS.getInstance().getSchool().getChoice10().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice11().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice12().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice13().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice14().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice15().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice16().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice17().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice18().equals(pass)) {
            count++;
        }
        if (CFAS.getInstance().getSchool().getChoice19().equals(pass)) {
            count++;
        }
        if (CFAS.getInstance().getSchool().getChoice20().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice21().equals(pass)) {
            count++;
        }
        if (CFAS.getInstance().getSchool().getChoice22().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice23().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice24().equals(pass)) {
            count++;
        }
        if (CFAS.getInstance().getSchool().getChoice25().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice26().equals(pass)) {
            count++;
        }
        if (CFAS.getInstance().getSchool().getChoice27().equals(pass)) {
            count++;
            count2++;
        }
        if (CFAS.getInstance().getSchool().getChoice28().equals(pass)) {
            count++;
        }
        if (CFAS.getInstance().getSchool().getChoice29().equals(pass)) {
            count++;
        }
        if (CFAS.getInstance().getSchool().getChoice30().equals(pass)) {
            count++;
            count2++;
        }

        Log.i("TAG", "onCreate: " + count);
        Log.i("TAG", "onCreate: " + count2);


        String txtResult = "";
        if (count >= 30) {
            txtResult = "ผ่าน";
        } else if (count2 >= 20) {
            txtResult = "ผ่าน";
        } else {
            txtResult = "ไม่ผ่าน";
        }

        intent.putExtra("txtResult", txtResult);
        intent.putExtra("txtCount", count);
        ///เพิ่มมาเก็บข้อมูลตอนท้าย
        // Dialog

        DatabaseSchool mDb = new DatabaseSchool(this);
        // Save Data
        long saveStatus = mDb.insertData(CFAS.getInstance().getSchool());
        if (saveStatus < 0) {
            final AlertDialog.Builder adb = new AlertDialog.Builder(this);
            AlertDialog ad = adb.create();
            ad.setMessage("Error!! ");
            ad.show();
        } else {
            Toast.makeText(this, "Add Data Successfully. ",
                    Toast.LENGTH_SHORT).show();
        }
        startActivity(intent);
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(ActivityUploadImage.this, ActivityGPage2.class);
        Log.i("TAG", "onClickBack: " + CFAS.getInstance().getSchool().toString());
        startActivity(intent);
    }
}
