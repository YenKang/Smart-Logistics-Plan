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
//列出所有餐廳的函式
function SelectAll($connection){
	$sql = "SELECT name FROM restaurant";
	$result = mysqli_query($connection, $sql);
	$i=0;
	$list_arr=array();
	while($list=$result->fetch_row()){  //判斷是否還有資料沒有取完，如果取完，則停止while迴圈。
		$list_arr[$i]=$list;
		$i++;
	}
	$option = '';
	for ($j = 0; $j<$i; $j++){
		$option .= '<option value = "'.$list_arr[$j][0].'">'.$list_arr[$j][0].'</option>';
	}
	return $option;
}
//判斷是否使用者使用過濾功能
if (isset($_POST['filter'])==1){
	$_SESSION['count'] = 2;
}
//判斷使用者是否使用評價功能
if (isset($_POST['SB2'])==1){
	$_SESSION['count'] = 1;
}
#echo $_SESSION['count'];
//初始畫面
if ($_SESSION['count'] == 0){
	$option =SelectAll($con);
}
//使用者進行評價動作
if ($_SESSION['count'] == 1){
	$option =SelectAll($con);
	$rtn = $_POST['rtn'];
	$good_eat = $_POST['good_eat'];
	$service = $_POST['service'];
	$crowded = $_POST['crowded'];
	$clean = $_POST['clean'];
	$cp = $_POST['cp'];
	$user_score = ($good_eat + $service + $crowded + $clean + $cp )/5;
	$sql = "SELECT score, score_No FROM restaurant WHERE name = '".$rtn."'";
	$result = mysqli_query($con, $sql);
	$score_and_No = $result->fetch_row();
	//echo $score_and_No[0];echo $score_and_No[1];
	//echo ($score_and_No[0] * $score_and_No[1] + $user_score)/ ($score_and_No[1] + 1);
	$new_score = ($score_and_No[0] * $score_and_No[1] + $user_score)/ ($score_and_No[1] + 1);
	$new_score_No = $score_and_No[1]+1;
	$sql2 = "UPDATE restaurant SET score = ".$new_score." WHERE name = '".$rtn."'";
	$sql3 = "UPDATE restaurant SET score_No = ".$new_score_No." WHERE name = '".$rtn."'";
	mysqli_query($con, $sql2);
	mysqli_query($con, $sql3);
}
//使用者使用過濾功能
if ($_SESSION['count'] == 2){
	if ($_POST['filter'] ==""){ //使用者無輸入過濾值，顯示全部
		$option = SelectAll($con);
	}
	else{ //使用者有輸入過濾值
		$ft = $_POST['filter'];
		$sql = "SELECT name FROM restaurant WHERE name Like '%".$ft."%'";
		#$sql = "UPDATE restaurant SET score = 5 WHERE name Like '%麥當勞%'";
		echo $sql;
		$result = mysqli_query($con, $sql);
		$i=0;
		$list_arr=array();
		#while($list=$result->fetch_row()){  //判斷是否還有資料沒有取完，如果取完，則停止while迴圈。
		#	$list_arr[$i]=$list;
		#	$i++;
		#}
		if ($i ==0){ //查無資料
			echo "<script>alert('無符合之餐廳名稱！');</script>";
			$option =SelectAll($con);
		}
		else{ //過濾成功
			$option = '';
			for ($j = 0; $j<$i; $j++){
				$option .= '<option value = "'.$list_arr[$j][0].'">'.$list_arr[$j][0].'</option>';
			}
		}
	}
}

#echo $_SESSION['count'];
$_SESSION['count'] = 0;
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
	<form action = "#" method = "post">店名過濾：<input type = "text" name = "filter"></input>
	<input type="submit" style="width:55px;height:22px;" name="SB1" value="確認">
	</form>
	<form action="#" method="post">
	<font style="background-color:#FFCCCC">請選擇評論店家名稱：</font>
	<select name = "rtn">
	<?php echo $option; ?>
	</select> <br>
	<font style="background-color:#FFCCCC">整體美味度：</font>
	<input type="radio" name="good_eat" value="1" checked > 1
	<input type="radio" name="good_eat" value="2"> 2
	<input type="radio" name="good_eat" value="3"> 3
	<input type="radio" name="good_eat" value="4"> 4
	<input type="radio" name="good_eat" value="5"> 5<br>
	<font style="background-color:#FFCCCC">服務態度：</font>
	<input type="radio" name="service" value="1" checked > 1
	<input type="radio" name="service" value="2"> 2
	<input type="radio" name="service" value="3"> 3
	<input type="radio" name="service" value="4"> 4
	<input type="radio" name="service" value="5"> 5<br>
	<font style="background-color:#FFCCCC">排隊、擁擠程度 (1分為擁擠，5分為舒適)：</font>
	<input type="radio" name="crowded" value="1" checked > 1
	<input type="radio" name="crowded" value="2"> 2
	<input type="radio" name="crowded" value="3"> 3
	<input type="radio" name="crowded" value="4"> 4
	<input type="radio" name="crowded" value="5"> 5<br>
	<font style="background-color:#FFCCCC">環境整潔度：</font>
	<input type="radio" name="clean" value="1" checked > 1
	<input type="radio" name="clean" value="2"> 2
	<input type="radio" name="clean" value="3"> 3
	<input type="radio" name="clean" value="4"> 4
	<input type="radio" name="clean" value="5"> 5<br>
	<font style="background-color:#FFCCCC">性價比：</font>
	<input type="radio" name="cp" value="1" checked > 1
	<input type="radio" name="cp" value="2"> 2
	<input type="radio" name="cp" value="3"> 3
	<input type="radio" name="cp" value="4"> 4
	<input type="radio" name="cp" value="5"> 5<br>
	<input type="submit" style="width:100px;height:50px;margin-bottom:5px;" name="SB2" value="提交囉~~" 
	onclick="return(confirm('確認要送出本表單嗎？'))">
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