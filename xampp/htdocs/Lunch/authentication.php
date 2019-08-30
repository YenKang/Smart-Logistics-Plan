<?php
session_start();
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "eating_lunch";

$con = new PDO("mysql:host =$servername;dbname=$dbname",$username,$password);
if (!$con) {
    die("Connection failed: " . mysqli_connect_error());
}

#mysqli_query($con,"set names utf8");

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
	$stmt = $con->prepare('SELECT * FROM user WHERE username = :username and password = :password');
	$stmt->bindValue(':username',$username, PDO::PARAM_STR);
	$stmt->bindValue(':password',$password, PDO::PARAM_STR);
	$stmt->execute();
	$result = $stmt->fetch();
	if(isset($result[0])!=1){
		header("Location: login.php");
	}
	else{
		echo $result[0]."  ";
		$cookieTime = (time()+600);
		setcookie("user",$result[1],$cookieTime);
		setcookie("pass",$result[2],$cookieTime);
		setcookie("uname",$result[3],$cookieTime);
		setcookie("age",$result[4],$cookieTime);
		header("Location: index.php");
	}
	

}


#echo $_SESSION['count'];
$_SESSION['count'] = 1;
#$con ->close();
?>