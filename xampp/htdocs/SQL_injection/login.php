<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "injection_test";

$con = new PDO("mysql:host=$servername;dbname=$dbname",$username);

#mysqli_query($con,"set names utf8");

$userLogin = $_POST["UserName"];
$userLoginPass = $_POST["UserPass"];
#echo "".$userLogin."";

$stmt = $con->prepare('SELECT name, password FROM user WHERE username = :userLogin and password = :userLoginPass');
$stmt->bindValue(':userLogin',$userLogin, PDO::PARAM_STR);
$stmt->bindValue(':userLoginPass',$userLoginPass, PDO::PARAM_STR);
$stmt->execute();

$result = $stmt->fetch();

#$sql = "SELECT name, password FROM user WHERE username ='".$userLogin."' AND password ='".$userLoginPass."'";
#$sql = "SELECT name, password FROM user WHERE username ='' or 1=1";
#echo $sql."<br>";
#$result = $con->query($sql);

#$con ->close();
?>

<html>
<head>
<title>測試</title>
<style type="text/css"> 
    div { 
       
	  margin-top:10%; 
	margin-left:10%; 
	margin-right:auto; 
	margin-bottom:20px; 
	border: 1px solid 000000; 
    } 
</style> 
<div>
	查詢使用者資料：<br></br>
	<form action="login.php" method="post">
	帳號：<input type="text" name="UserName"> 
	密碼：<input type="password" name="UserPass"> 
	<input type="submit" name="SB" value="登入">
	</form>
<?php 
	if ($result[0]!=""){
	echo "使用者名稱: " . $result["name"]. "  密碼: " . $result["password"]."<br>";
}
?>
</div>
</head>
<body>
</body>
</html>