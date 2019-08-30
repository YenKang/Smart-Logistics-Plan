<?php
session_start();
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "eating_lunch";

$con = mysqli_connect($servername, $username, $password, $dbname);
if (!$con) {
    die("Connection failed: " . mysqli_connect_error());
}

mysqli_query($con,"set names utf8");

if (!isset($_COOKIE['user'])||!isset($_COOKIE['pass'])||!isset($_COOKIE['uname'])){
	header("Location: login.php");
}
else{
	$username = $_COOKIE['user'];
	$password = $_COOKIE['pass'];
	$sql = "SELECT * FROM user WHERE username = '".$username."' AND password = '".$password."'";
	$result = mysqli_query($con, $sql);
	$i=0;
	$list_arr=array();
	while($list=$result->fetch_row()){  //判斷是否還有資料沒有取完，如果取完，則停止while迴圈。
		$list_arr[$i]=$list;
		$i++;
	}
	if ($i==0){
		header("Location:login.php");
	}
	else{
	}
}

#echo $_SESSION['count'];
$_SESSION['count'] = 1;
$con ->close();
?>