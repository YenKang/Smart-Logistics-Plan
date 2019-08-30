<?php
   //設定網頁的type及編碼，因為Android中使用了utf-8，所以這裡一定要設定，
   //否則回傳的中文資料會變成亂碼
   header("Content-Type:text/html; charset=utf-8");
   $MyName = $_POST["MyName"];
   $MyMessage = $_POST["MyMessage"];    
   echo "我的姓名是：" . $MyName  . "  傳送的訊息是："  . $MyMessage ;
?>  