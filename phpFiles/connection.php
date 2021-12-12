<?php


$server = "localhost";
$username = "root";
$password = "";
$dbname = "sara_project";

$connection = new mysqli($server, $username, $password, $dbname);

if($connection->connect_error){
	die("Failed");
}


?>