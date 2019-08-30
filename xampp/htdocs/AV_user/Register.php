<?php
	$con=mysqli_connect("localhost","root","","av_delivery");
	
	if (!$con) {
		printf("Connect failed: %s\n", mysqli_connect_error());
		exit();
	}

	$username = $_POST["username"];
	$password = $_POST["userpass"];
	$gender = $_POST["gender"];
	$phone = $_POST["phone"];
	$address = $_POST["address"];
	$time_now = $_POST["time_now"];
	
	$statement = mysqli_prepare($con, "INSERT INTO user VALUES (0,?,?,?,?,?,?,'')")
	or die(mysqli_error($con));
	mysqli_stmt_bind_param($statement, "ssssss",  $username, $password, $gender, $phone, $time_now, $address);
	mysqli_stmt_execute($statement);

	/*
	if ($result['username']== ''){
		echo "No_match";
	}
	else{
		echo json_encode($result);
	}*/
	//echo  date('Y-m-d', time());
	echo "YAQQ";
	//echo 1;
	mysqli_stmt_close($statement);
	
	mysqli_close($con);
?>