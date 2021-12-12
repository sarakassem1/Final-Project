<?php 
include("connection.php");
$username="j";
$phone=723;
$e="add";
$age=1;
$pass=hash("sha256","1");


$mysql = $connection->prepare("INSERT INTO users(username,phone,email,age,password) VALUES (?,?,?,?,?)");
$mysql->bind_param("sisis", $username,$phone,$e,$age,$pass);

	$mysql->execute();


?>