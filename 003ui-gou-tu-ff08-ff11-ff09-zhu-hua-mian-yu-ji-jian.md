#### 2018-10-12(五)

## [003]UI 構圖 （１）主畫面與寄件



版本：version1

----
### UI介紹


在寄件人使用app時，首先會ㄒshow出主畫面的資訊，包括

> - 1.使用者的頭貼
> - 2.使用者的帳號
> - 3.Send:我要寄件，代表要新增送貨訂單
> - 4.History List:能查詢歷史紀錄的訂單
> - 5.My received packages:顯示過去收貨的訂單詳情
> - 6.Sent Packages:過去“寄貨”的歷史資訊
> - Tracking No.：能直接查詢運貨單號

![](/assets/iSend_main.png)

### 在主畫面，點擊“Send”之後

- 畫面會出現，目前phone所在的address，以地圖形式顯示，另外，在sender location(寄件人地址)，這個地址原則是default，另外也能讓user去更改。

- 另外，像是收件人名字、收件人電話、收件人地址、包裹品名，填完後點擊下一頁

- 下一頁，是填寫“到點取貨的時間”，並且畫面會提供“該區的最近的無人貨車輛”以供user參考，使得心裡有一個譜，能知道貨車到“sender address”的距離，接著，就是填寫expect arrival time，希望車子在什麼日期，什麼時間點能到user的sender address

![](/assets/iSend_send.png)

### 下一步計畫

- 下一步，會查詢sumo的相關功能，例如import sender address的經緯度，然後畫出相關路線的動畫圖式

- 另外，研究android傳遞data的相關資訊，還有如何在android內，顯示user自己當前的address，並且以圖示呈現在android手機上。

