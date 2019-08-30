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

if ($_SESSION['count'] == 1){
	$rd = 0;
	$nd = 0;
	$rc = 0;
	$st = 0;
	$qk = 0;
	$hp = 0;
	if($_POST["restaurant_name"]!=""){
		if(isset($_POST["riding"])==1) {
			$rd = 1;
		}
		if(isset($_POST["noodles"])==1) {
			$nd = 1;
		}
		if(isset($_POST["rice"])==1) {
			$rc = 1;
		}
		if(isset($_POST["steak"])==1) {
			$st = 1;
		}
		if(isset($_POST["quick"])==1) {
			$qk = 1;
		}
		if(isset($_POST["hotpot"])==1) {
			$hp = 1;
		}
		if ($_POST['money']=="one"){
			$money = 99;
		}
		else if ($_POST['money']=="two"){
			$money = 199;
		}
		else if ($_POST['money']=="three"){
			$money = 299;
		}
		else {
			$money = 999;
		}
		$sql = "INSERT INTO restaurant(name, riding, noodles, rice, steak, quick, hotpot, money) VALUES 
		('".$_POST["restaurant_name"]."','".$rd."','".$nd."','".$rc."','".$st."','".$qk."','".$hp."','".$money."')";
		mysqli_query($con, $sql);
	}
	else{
		echo "<script>alert('未輸入餐廳名稱！');</script>";
	}
}

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
    background: url(802011.png);
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
	新增餐廳：<br>
	<form action="#" method="post">
	<font style="background-color:#FFCCCC">餐廳名稱：</font><input type="text" name="restaurant_name"> <br>
	<font style="background-color:#FFCCCC">需要騎車：</font><input type="checkBox" name="riding"> <br>
	<font style="background-color:#FFCCCC">麵類：</font><input type="checkBox" name="noodles" > <br>
	<font style="background-color:#FFCCCC">飯類：</font><input type="checkBox" name="rice" > <br>
	<font style="background-color:#FFCCCC">牛排：</font><input type="checkBox" name="steak" > <br>
	<font style="background-color:#FFCCCC">速食：</font><input type="checkBox" name="quick" > <br>
	<font style="background-color:#FFCCCC">火鍋：</font><input type="checkBox" name="hotpot" > <br>
	<font style="background-color:#FFCCCC">價位：</font><input type="radio" name="money" value="one" checked> 100以內
	<input type="radio" name="money" value="two"> 200以內<input type="radio" name="money" value="three"> 300以內
	<input type="radio" name="money" value="happyday"> 超貴
	<br>
	<input type="submit" style="width:100px;height:50px;margin-bottom:5px;" name="SB" value="提交囉~~" onclick="return(confirm('確認要送出本表單嗎？'))">
	</form>
	<form action = "index.php">
	<input type="submit" style="width:100px;height:50px;margin-bottom:5px;" name="return" value="返回主頁">
	</form>
</div>
</div>
</div>
</head>
<body>
</body>
</html>