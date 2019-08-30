<?php
	header('Content-Type: text/html; charset=utf-8');
	$con=mysqli_connect("localhost","root","","av_delivery");
	mysqli_set_charset($con, "utf8");
	
	if (!$con) {
		printf("Connect failed: %s\n", mysqli_connect_error());
		exit();
	}
	
	$receiver_id = $_POST["receiver_id"];
	
	$statement = mysqli_prepare($con, "SELECT user_id FROM user WHERE username = ?")or die(mysqli_error($con));
	mysqli_stmt_bind_param($statement, "s", $receiver_id);
	
	mysqli_stmt_execute($statement);
	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $ID);
	
	$result = '';
	
	while(mysqli_stmt_fetch($statement)){
		$result = $ID;
	}
	
	if ($result== ''){
		echo "No_match";
	}

	else{
		echo json_encode($result, JSON_UNESCAPED_UNICODE);
	}
	mysqli_stmt_close($statement);
	mysqli_close($con);
?>