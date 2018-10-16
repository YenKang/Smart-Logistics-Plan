### 2018-10-16(二)

### 【短期目標】

> - 1.user能在android手機上，執行”下單“動作，手機把下單的data傳送到server端

> - 2.Server能正確接收該data，並顯示android下單data

> - 3.計算下單的起終點為止，並加入truck address data，規劃出一條path

###【老師評論】
>  #### 1.平台建構：
先構思一個平台，該平台中，有哪些子系統是該有的？

>  #### 2.實際規劃：
如果我們做這樣一個平台，哪些實驗是需要做的？哪些可以做demo用的？因為我們demo跟實際的會有差別，所以列出差異性

> #### 3.演算法設計：
規定車子跑哪些點，如何安排車子到貨的先後順序

- 先以1台車與１件包裹為主，下單時，訂好“收件時間”＋“大概取貨時間”，取貨前，車子給寄件人一個通知，這邊要考慮取貨時user是否在現場(這裡的user包括sender與receiver)，

- 另外，在接收sender的package後，在送貨前通知receiver訊息，了了收件者是否能在“某時間點取貨"，確認receiver“available time point”，

- 而在sender填單時，並不會看到truck的地址資訊，這項資訊只會在system端顯示出來

- 在sumo(或是其他款交通模擬軟體)部分要與android app做搭配，例如車子若是沒有到sender address，sender的手機自然也不能做一些function，也就是說要再另外加入一個trigger機制。


### 備註：
- 更重要的事情，資料庫中要有哪些attribute，如果要定義一台車子是一個object，該車子的櫃子大小、櫃子尺寸，而routing在**現階段就用“shortest path”**的篩選方式，先把底部的基礎做確實。

### 要提proposal的前提條件
- 至於提畢業proposal的前提條件，把該系統的規模(scale)仔細考過，計畫要做哪些事情、需要展示哪些成果、會用到哪些survey的tool


