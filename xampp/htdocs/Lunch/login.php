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



#echo $_SESSION['count'];
$_SESSION['count'] = 1;
$con ->close();
?>

<html>
<head>

<title>測試</title>
<style type="text/css"> 
div { 
	margin-right:auto; 
	margin-bottom:0px; 
	border: 1px solid 000000; 
}
.demo2-bg{
    background: url(802011.jpg);
    background-size: cover;
    width: 1920px;
    height: 1350px;
    position: relative;
}
.demo2{
    position: absolute;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    width: 1920px;
    height: 1350px;
    line-height: 50px;
    text-align: left;
    background:rgba(255,255,255,0.55);
}
.tt {      
	margin-top:15%; 
	margin-left:20%; 
	margin-right:auto; 
	margin-bottom:20px; 
	border: 1px solid 000000; 
} 
</style> 
<div class = "demo2-bg">
<div class = "demo2">
<div class = "tt">
	<form action="authentication.php" method="post">
	帳號：<input type="text" name="username"><br>
	密碼：<input type="password"  name="password"><br><br>
	<input type="submit" name="SB" value="登入">
	</form>
	<input type="button" value="回上一頁" onClick="history.back()">
</div>
</div>
</div>
</head>
<body>
</body>
</html>