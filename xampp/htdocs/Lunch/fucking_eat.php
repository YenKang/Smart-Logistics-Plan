<?php
session_start();
$_SESSION['count'] = 0;
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "eating_lunch";


$con = mysqli_connect($servername, $username, $password, $dbname);
if (!$con) {
    die("Connection failed: " . mysqli_connect_error());
}
mysqli_query($con,"set names utf8");

if (isset($_POST['money'])==1){
	$_SESSION['count'] = 1;
}

if ($_SESSION['count'] == 1){
	$money = 9999;
	$sql = "SELECT name FROM restaurant WHERE 1=1";
	if(isset($_POST["riding"])==1) {
		$sql .= " AND riding =1";
	}
	if(isset($_POST["noodles"])==1) {
		$sql .= " AND noodles =1";
	}
	if(isset($_POST["rice"])==1) {
		$sql .= " AND rice =1";
	}
	if(isset($_POST["steak"])==1) {
		$sql .= " AND steak =1";
	}
	if(isset($_POST["quick"])==1) {
		$sql .= " AND quick =1";
	}
	if ($_POST['money'] == "one"){
		$money = 100;
	}
	else if ($_POST['money'] == "two"){
		$money = 200;
	}
	else if ($_POST['money'] == "three"){
		$money = 300;
	}
	else{
		$sql .= " AND money = 999";
	}
	$sql .= " AND money < ".$money."";
	#echo $sql;
	$result = mysqli_query($con, $sql);
	$i=0;
	$list_arr=array();
	while($list=$result->fetch_row()){  //判斷是否還有資料沒有取完，如果取完，則停止while迴圈。
		$list_arr[$i]=$list;
		#echo $list[0];
		$i++;
	}
	if ($i ==0){
		echo "<script>alert('無符合條件之餐廳。');</script>";
	}
	else {
		$rand_No = mt_rand(1, $i)-1;
		#echo $rand_No;
		$recom_res = $list_arr[$rand_No][0];
	}
	#echo $list_arr[1][0];
	#$sql = "SELECT name FROM restaurant WHERE riding ='".$rd."' AND noodles ='".$nd."' AND rice ='".$rc."' AND steak =';
	#mysqli_query($con, $sql);
	
}
#$sql = "SELECT name, password FROM user WHERE username ='".$userLogin."' AND password ='".$userLoginPass."'";

#echo $sql."<br>";

#$result = $con->query($sql);

#$sql = "SELECT name, password FROM user WHERE username ='".$userLogin."' AND password ='".$userLoginPass."'";
#$sql = "SELECT name, password FROM user WHERE username ='' or 1=1";
#echo $sql."<br>";
#$result = $con->query($sql);


#echo $_SESSION['count'];
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
<?php echo '<script type="text/javascript">';
echo "alert('建議吃 ".$recom_res." 。')";
echo "</script>"; ?>
<div class = "demo2-bg">
<div class = "demo2">
<div class = "tt">
	<font style="background-color:#FFCCCC">輸入條件：</font><br>
	<form action="#" method="post">
	<font style="background-color:#FFCCCC">騎車：</font><input type="checkBox" style="zoom:1.5" name="riding"> <br>
	<font style="background-color:#FFCCCC">麵類：</font><input type="checkBox" name="noodles" > <br>
	<font style="background-color:#FFCCCC">飯類：</font><input type="checkBox" name="rice" > <br>
	<font style="background-color:#FFCCCC">牛排：</font><input type="checkBox" name="steak" > <br>
	<font style="background-color:#FFCCCC">速食：</font><input type="checkBox" name="quick" > <br>
	<font style="background-color:#FFCCCC">價位：</font><input type="radio" name="money" value="one" checked> 100以內
	<input type="radio" name="money" value="two"> 200以內<input type="radio" name="money" value="three"> 300以內
	<input type="radio" name="money" value="happyday"> 慶祝日 <br>
	<!-- <font style="background-color:#FFCCCC">評價大於多少：</font><input type="text" maxlength="1" onkeyup="value=value.replace(/[^\d]/g,'')" size = "1" name="rate"> <br> -->
	<input type="submit" style="width:100px;height:50px;margin-bottom:5px;" name="SB" value="提交囉~~">
	</form>
	<form action = "index.php" method = "get">
	<input type="submit" style="width:100px;height:50px;margin-bottom:5px;" name="return" value="返回主頁">
	</form>
</div>
</div>
</div>
</head>
<body>
</body>
</html>