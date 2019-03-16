#### 2018-10-10(三)

## [001]無人貨運車系統 初版發想

版本：version1

----

### 1.寄件人填寫下單

- 1-1.我要寄件：
填寫寄件人資訊，提供姓名、電話、寄件地址、寄託物、寄託物價值、寄物重量、備註、希望上門取件時間、線上付費、並提交訂單。
之後等待系統“30分鐘”回覆，回覆內容會告訴寄件者多久之後，無人貨車到寄件地址。

- 1-2.當系統成功對寄件人收費後，然後系統會根據該寄件人的寄件地址與目的收件地址，規劃出一條預設路徑，並且安排車子去寄件人的寄件地址，並且回覆寄件人多久會到該地址。

- 1-3.無人貨車收到server端的信息後，前往寄件人的地址，在路途中server端能夠即時監控車子的GPS軌跡，並且確認前往地址的方向，以及預估時間。

### 2.無人車抵達寄件人地址

- 2-1.無人車到達約定地址，寄件人會把寄件物放進無人車的貨櫃中，而此時無人貨車會檢驗寄件物的重量是否合格，是否與寄件單填相符合，若不符合，會給予提示，若符合的話，將會提供審核成功的通知，並且send message給寄件人一組“運單號”，

- 這組運單號會顯示“地圖模式”與“文字模式”，地圖模式是會顯示貨目前在哪一區，是一個固定點的概念，而非持續移動的動態; 文字動態是具體時間的收貨、經過哪一關口等文字資訊。

