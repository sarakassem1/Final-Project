<?php
include("connection.php");


$mysql = $connection->prepare("SELECT * FROM psychologists ");

	$mysql->execute();
    $results = $mysql->get_result();

    while($data = $results->fetch_assoc()){

    $temp[]=$data;
    

}
$json = json_encode($temp);
print $json;







?>