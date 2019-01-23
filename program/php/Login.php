<?php
	$con=mysqli_connect("localhost","root","","av_delivery");
	
	if (!$con) {
		printf("Connect failed: %s\n", mysqli_connect_error());
		exit();
	}

	$username = $_POST["username"];
	$password = $_POST["password"];

	
	$statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ? AND password = ?")or die(mysqli_error($con));
	mysqli_stmt_bind_param($statement, "ss", $username, $password);
	mysqli_stmt_execute($statement);
	
	/*$statement = mysqli_prepare($con, $sql)or die(mysqli_error($con));
	//mysqli_stmt_bind_param($statement, "ss", $username, $password);
	mysqli_stmt_execute($statement);
	*/
	
	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $userID, $username, $password, $gender, $phone_number, $register_time, $user_address);
	
	$result = array();
	$result['username'] = '';
	
	while(mysqli_stmt_fetch($statement)){
	
		$result['user_id'] = $userID;
		$result['username'] = $username;
		$result['password'] = $password;
		$result['phone_number'] = $phone_number;
		$result['gender'] = $gender;
		$result['register_time'] = $register_time;
	}
	
	if ($result['username']== ''){
		echo "No_match";
	}
	else{
		echo json_encode($result);
	}
	mysqli_stmt_close($statement);
	
	mysqli_close($con);
?>