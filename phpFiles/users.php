<?php

include("connection.php");

$username=$_GET["username"];
$password=hash("sha256", $_GET["password"]);


$mysql = $connection->prepare("SELECT * FROM users WHERE username= ?");
$mysql->bind_param("s", $username);
	$mysql->execute();
    $results = $mysql->get_result();
    $temp['login']="";
    while($data = $results->fetch_assoc()){

        if($data['password']==$password){
         $temp['login']=$username;

        }

    }

$json = json_encode($temp);
print "{{\"th\":[".$json."]}";



?>