package com.example.nook.assessment;


import org.json.JSONObject;

public class DBFileConfig {
    public static JSONObject profile;

    public static String image_p[];
    public static String dataListCategory = "";
    public static String dataListS = "";


    public static String category_id = "";
    public static String type_id = "";
    public static String order_id = "";


    public static String nameTitle = "";
    public static String[] dataList;


    public static String temp = "";


    public static class Config {
        public static final boolean DEVELOPER_MODE = false;
    }

    public static class Extra {
        public static final String IMAGES = "IMAGES";
        public static final String IMAGE_POSITION = "IMAGE_POSITION";
    }

}
