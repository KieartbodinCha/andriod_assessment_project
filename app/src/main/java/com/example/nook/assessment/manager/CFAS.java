package com.example.nook.assessment.manager;

import com.example.nook.assessment.model.School;
import com.example.nook.assessment.model.SimpleModel;


/**
 * Created by metis on 2/3/17.
 */
public class CFAS {
//public class CFAS extends AppCompatActivity {

    //TODO: Change WebURL
    public static final String END_POINT = "http://172.23.248.130:8888/api_assessment_project/";

    private static CFAS instance;
    public SimpleModel[] provinces;
    public SimpleModel[] amphurs;

    private School school;

    public CFAS() {
        if (school == null) {
            school = new School();
        }
    }

    public static CFAS getInstance() {
        if (instance == null) {
            instance = new CFAS();
        }
        return instance;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
