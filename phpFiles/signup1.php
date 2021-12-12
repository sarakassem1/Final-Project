<?php

include("connection.php");

if(isset($_GET["username"]) && $_GET["username"] != ""){
	$username = $_GET["username"];
}else{
    die("!!");}
if(isset($_GET["phone"]) && $_GET["phone"] != ""){
	$phone = $_GET["phone"];
}else{
    die("!!");}
if(isset($_GET["email"]) && $_GET["email"] != ""){
	$email = $_GET["email"];
}else{
    die("!!");}
if(isset($_GET["age"]) && $_GET["age"] != ""){
	$age = $_GET["age"];
}else{
    die("!!");
}
if(isset($_GET["password"]) && $_GET["password"] != ""){
	$password = hash("sha256", $_GET["password"]);
}else{
    die("!!");
}

$mysql= $connection->prepare("INSERT INTO users(username,phone,email,age,password) VALUES (?,?,?,?,?)");
$mysql->bind_param("sisis", $username,$phone,$email,$age,$password);
$mysql->execute();

$res['result']="inserted";
$json = json_encode($res);
print $json;
$mysql->close();
$connection->close();




?>