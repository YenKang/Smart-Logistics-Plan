<?php
	$con=mysqli_connect("localhost","root","","av_delivery");
	
	if (!$con) {
		printf("Connect failed: %s\n", mysqli_connect_error());
		exit();
	}

	
	$password = "";
	$username = "";
	$sql = "SELECT * FROM user WHERE username = 'bosen' collate Latin1_General_CS_AI <> username";
	$statement = mysqli_prepare($con, $sql)or die(mysqli_error($con));
	//mysqli_stmt_bind_param($statement, "ss", $username, $password);
	mysqli_stmt_execute($statement);
	
	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $userID, $username, $password, $gender, $phone_number, $register_time, $user_address);
	
	$result = array();
	
	while(mysqli_stmt_fetch($statement)){
	
		$result['username'] = $username;
		$result['password'] = $phone_number;
	}
	
	echo json_encode($result);
	
	mysqli_stmt_close($statement);
	
	mysqli_close($con);
?>