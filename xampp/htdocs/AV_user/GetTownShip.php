<?php
	header('Content-Type: text/html; charset=utf-8');
	$con=mysqli_connect("localhost","root","","av_delivery");
	mysqli_set_charset($con, "utf8");
	
	if (!$con) {
		printf("Connect failed: %s\n", mysqli_connect_error());
		exit();
	}
	
	$county_id = $_POST["county_id"];
	
	$statement = mysqli_prepare($con, "SELECT * FROM township WHERE county_id = ?")or die(mysqli_error($con));
	mysqli_stmt_bind_param($statement, "i", $county_id);
	
	mysqli_stmt_execute($statement);
	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $ID, $township_name, $notimportant);
	
	$result = array(array());
	#$result[0] = '';
	
	$i = 0;
	while(mysqli_stmt_fetch($statement)){
	
		$result[$i]['ID'] = $ID;
		$result[$i]['township_name'] = $township_name;
		$i = $i +1;
	}
	
	if ($result[0]== ''){
		echo "No_match";
	}

	else{
		echo json_encode($result, JSON_UNESCAPED_UNICODE);
	}
	mysqli_stmt_close($statement);
	mysqli_close($con);
?>