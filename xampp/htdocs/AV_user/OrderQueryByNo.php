<?php
	header('Content-Type: text/html; charset=utf-8');
	$con=mysqli_connect("localhost","root","","av_delivery");
	mysqli_set_charset($con, "utf8");
	
	if (!$con) {
		printf("Connect failed: %s\n", mysqli_connect_error());
		exit();
	}
	
	$order_number = $_POST["order_number"];
	
	$statement = mysqli_prepare($con, "SELECT * FROM user_order WHERE order_number = ?")or die(mysqli_error($con));
	mysqli_stmt_bind_param($statement, "s", $order_number);
	
	mysqli_stmt_execute($statement);
	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $t1, $t2, $t3, $t4, $t5, $t6, $t7, $t8, $t9, $t10, $t11, $t12, $t13, $t14, $t15, $t16, $t17, $t18, $t19, $t20);
	
/*
	$sql ="select * from `user_order` where 1";
	$result = mysqli_query($con, $sql);
	/*while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC)) {
    print_r( $row);
}
	$row = mysqli_fetch_array($result, MYSQLI_ASSOC);
	echo json_encode($row, JSON_UNESCAPED_UNICODE);
	$row = mysqli_fetch_array($result, MYSQLI_ASSOC);
	echo($row);
*/
	$result = array(array());
	$i=0;
	$result[0]["id"]="";
	while(mysqli_stmt_fetch($statement)){
		$result[$i]["id"] = $t1;
		$result[$i]["order_number"] = $t2;
		$result[$i]["sender_name"] = $t3;
		$result[$i]["receiver_name"] = $t4;
		$result[$i]["container_id"] = $t5;
		$result[$i]["in_time"] = $t6;
		$result[$i]["out_time"] = $t7;
		$result[$i]["truck_id"] = $t8;
		$result[$i]["status"] = $t9;
		$result[$i]["weight"] = $t10;
		$result[$i]["cargo_content"] = $t11;
		$result[$i]["size"] = $t12;
		$result[$i]["price"] = $t13;
		$result[$i]["sender_lng"] = $t14;
		$result[$i]["sender_lat"] = $t15;
		$result[$i]["receiver_lng"] = $t16;
		$result[$i]["receiver_lat"] = $t17;
		$result[$i]["order_time"] = $t18;
		$result[$i]["sender_time"] = $t19;
		$result[$i]["receiver_time"] = $t20;
		$i = $i+1;
	}
	
	if ($result[0]["id"]== ''){
		echo "No_match";
	}

	else{
		echo json_encode($result, JSON_UNESCAPED_UNICODE);
	}
	//mysqli_stmt_close($statement);
	mysqli_close($con);
?>