<?php

class DB_Functions {

    private $db;

    //put your code here
    // constructor
    function __construct() {
        include_once './dbconnect.php';
        // connecting to database
        $this->db = new DB_Connect();
        $this->db->connect();
    }

    // destructor
    function __destruct() {

    }

    /**
     * Storing new user
     * returns user details
     */
    public function school ($schId,$schName,$schCanteenName,$schDepart,$schStaffNum,$schAddress,$schtClient,$schChef,
    $schNameSurvey,$schSurveyDate,$schTain,$schService,$schLuch,$schSurvey,$schDistric,$schProvince) {
        // Insert user into database
        $result = mysql_query("INSERT INTO school VALUES($schId,$schName,$schCanteenName,$schDepart,$schStaffNum,$schAddress,$schtClient,$schChef,
        $schNameSurvey,$schSurveyDate,$schTain,$schService,$schLuch,$schSurvey,$schDistric,$schProvince)");

        if ($result) {
            return true;
        } else {
            if( mysql_errno() == 1062) {
                // Duplicate key - Primary Key Violation
                return true;
            } else {
                // For other errors
                return false;
            }
        }
    }
     /**
     * Getting all users
     */
    public function getAllUsers() {
        $result = mysql_query("select * FROM school");
        return $result;
    }
}

?>
