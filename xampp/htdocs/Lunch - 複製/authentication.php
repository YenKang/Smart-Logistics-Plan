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

if ( isset($_POST['username'])!=1){
	header("Location: login.php");
}

$username = $_POST['username'];
$password = $_POST['password'];

if ($username == '' || $password == '')
{
	echo "<script>alert('未輸入帳號或密碼!!')</script>";
    header("Location: login.php");
}
else{
	$sql = "SELECT * FROM user WHERE username = '".$username."' AND password = '".$password."'";
	$result = mysqli_query($con, $sql);
	$i=0;
	$list_arr=array();
	while($list=$result->fetch_row()){ 
		$list_arr[$i]=$list;
		$i++;
	}
	if ($i==0){
		header("Location: login.php");
	}
	else{
		echo $list_arr[0][1]."  ";
		$cookieTime = (time()+60);
		setcookie("user",$list_arr[0][1],$cookieTime);
		setcookie("pass",$list_arr[0][2],$cookieTime);
		setcookie("uname",$list_arr[0][3],$cookieTime);
		setcookie("age",$list_arr[0][4],$cookieTime);
		header("Location: index.php");
	}
	

}


#echo $_SESSION['count'];
$_SESSION['count'] = 1;
$con ->close();
?>