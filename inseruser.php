<?php
include_once './db_functions.php';
//Create Object for DB_Functions clas
$db = new DB_Functions();
//Get JSON posted by Android Application
$json = school["usersJSON"];
//Remove Slashes
if (get_magic_quotes_gpc()){
$json = stripslashes($json);
}
//Decode JSON into an Array
$data = json_decode($json);
//Util arrays to create response JSON
$a=array();
$b=array();
$c=array();
$d=array();
$e=array();
$f=array();
$g=array();
$h=array();
$j=array();
$k=array();
$l=array();
$m=array();
$n=array();
$o=array();
$p=array();
$q=array();
//Loop through an Array and insert data read from JSON into MySQL DB
for($i=0; $i<count($data) ; $i++)
{
//Store User into MySQL DB
$res = $db->storeUser($data[$i]->$schId,$data[$i]->$schName,$data[$i]->$schCanteenName,$data[$i]->$schDepart,$data[$i]->$schStaffNum,
$data[$i]->$schAddress,$data[$i]->$schtClient,$data[$i]->$schChef,$data[$i]->$schNameSurvey,$data[$i]->$schSurveyDate,$data[$i]->$schTain,
$data[$i]->$schService,$data[$i]->$schLuch,$data[$i]->$schSurvey,$data[$i]->$schDistric,$data[$i]->$schProvince);
    //Based on inserttion, create JSON response
    if($res){
        $b["id"] = $data[$i]->schId;
        $b["status"] = 'yes';
        array_push($a,$b,$c,$d,$e,$f,$g,$h,$j,$k,$l,$m,$n,$o,$p,$q);
    }else{
        $b["id"] = $data[$i]->schId;
        $b["status"] = 'no';
        array_push($a,$b,$c,$d,$e,$f,$g,$h,$j,$k,$l,$m,$n,$o,$p,$q);
    }
}
//Post JSON response back to Android Application
echo json_encode($a);
?>
