<?php

include("connection.php");

$type=$_GET["type"];


$mysql = $connection->prepare("SELECT qoute FROM quotes WHERE type='".$type. "'");

	$mysql->execute();
    $results = $mysql->get_result();

    $data = $results->fetch_assoc();

         $temp['qoute']=$data['qoute'];

        


$json = json_encode($temp);
print "{{\"th\":[".$json."]}";



?>