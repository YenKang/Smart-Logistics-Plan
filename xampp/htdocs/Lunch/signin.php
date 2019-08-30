<?php
include('cookie_check.php');
?>


<html>
<head>
<!-- 加上以下這一行，以免有亂碼產生 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>測試</title>
</head>
<body bgcolor="white">
<hr size=1>
<center>
<!--以下是您的站台名稱-->
<font size=5 color=red>餐廳評論區</font>
<br>
<!--以下是您的版權宣告-->
<hr size=1>
<table align=center border=0><tr><td>

<!--以下是表單內容, 共有二個欄位: 姓名及留言內容, 您可以自行再增添; 
表單採 POST 呼叫法, cgi 程式名稱是 GBK.cgi -->
<form name="ols3" method="post" action="GBK.cgi">

<!--姓名欄位的名稱是 name-->
姓名: <?php echo $_COOKIE['uname']; ?> <input type="hidden" name="name" value="<?php echo $_COOKIE['uname']; ?>">
<br><br>
年齡：<?php echo $_COOKIE['age']; ?> <input type="hidden" name="age" value="<?php echo $_COOKIE['age']; ?>">
<br><br>
<!--留言內容欄位的名稱是 comment-->
留言內容:<br><br>
<textarea name="comment" rows="5" cols="45"></textarea>
<p>
<input type="submit" value="確定"> <input type="reset" value="清除">
<input type="button" value="回上一頁" onClick="history.back()">
</form>

</td></tr></table></center>
</body>
</html>