#!/usr/local/bin/perl

# 先定義留言寫入的 HTML 檔案位置及名稱
#$gbkhtml="C:\xampp\htdocs\Lunch\gbk.html";

# 設定留言板的 URL 位址
$gbkurl="140.116.72.134/Lunch/gbk.html";

# 取得表單傳遞過來的內容
read(STDIN, $temp, $ENV{'CONTENT_LENGTH'});
@pairs=split(/&/,$temp);
foreach $item(@pairs)  {
  ($key,$content)=split (/=/,$item,2);
  $content=~tr/+/ /;
  $content=~ s/%(..)/pack("c",hex($1))/ge;
  $OLS3{$key}=$content;
}

#經過上述動作，此時留言者姓名及內容，已分別放在 $OLS3{'name'} 及 $OLS3{'comment'} 中
$name=$OLS3{'name'};
$comment=$OLS3{'comment'};

# 處理斷行問題
$comment=~ s/\cM\n/<br>\n/g;

# 取得留言時間
($sec,$min,$hour,$mday,$mon,$year,$wday,$yday,$isdst)=gmtime(time+8*60*60);
if (length ($min) == 1) {$min = '0'.$min;}
if (length ($sec) == 1) {$sec = '0'.$sec;}
$mon+=1;
$date="$mon/$mday/$year, $hour:$min:$sec";

# 開啟HTML檔, 並讀出所有的內容
open(FHD, "$gbkhtml") || die "Content-type: text/html\n\n 開啟檔案錯誤!\n";
@all=<FHD>;
close(FHD);

# 重新開啟HTML檔, 以便更新其留言內容
open(FHD, ">$gbkhtml") || die "Content-type: text/html\n\n 開啟檔案錯誤!\n";

# 利用迴圈, 將原檔案內容依次寫回, 並在其過程中寫入新的留言
foreach $line(@all) {

   # 該列是否為標記? 若是, 表示該處為新留言開始要寫入的地方
   if ($line =~ /<!--ols3-->/)  {

    # 寫回原來的標記, 以後方可繼續使用
      print FHD "<!--ols3-->\n";

     # 寫入新的留言
      print FHD "姓名: $name [時間: $date]<p>$comment<hr size=1>\n";

   } else {

    # 若該列不是標記, 表示是舊有的內容, 則不予改變地將它寫回
    print FHD $line;
  }
}

# 關畢 HTML 檔
close(FHD);

# 接下來, 感謝一下留言的網友, 三秒後回到顯示留言畫面
print "Content-type: text/html\n\n";
print "<html><head>\n";
print "<META HTTP-EQUIV=REFRESH CONTENT=\"3;URL=$gbkurl\">\n";
print "<title>Thanks!</title></head>\n";
print "<body bgcolor=white><center>\n";
print "謝謝您的留言!\n";
print "</center></body></html>\n";