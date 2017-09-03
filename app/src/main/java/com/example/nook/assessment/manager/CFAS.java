package com.example.nook.assessment.manager;

import com.example.nook.assessment.model.School;


/**
 * Created by metis on 2/3/17.
 */
public class CFAS {
//public class CFAS extends AppCompatActivity {

    private static CFAS instance;

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
