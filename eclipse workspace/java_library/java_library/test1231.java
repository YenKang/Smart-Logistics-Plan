import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class test1231 {

	public static void main(String[] args) throws Exception {
		// TODO 自動產生的方法 Stub
		/*SimpleDateFormat sdft = new SimpleDateFormat("yyMMddhhmmss");
		Date nowdate = new Date();
		String str = sdft.format(nowdate);
		System.out.println(str);*/
		
		JDBC_AVD ttt123 = new JDBC_AVD();	
		String rsTest = ttt123.QueryDeviceKey("rerr");
		System.out.println(rsTest);
		/*
		FcmNotify testNotify  = new FcmNotify();
		String ts = "ceyC2imRkXo:APA91bGQqkLMjPhFZPP1FHmPdiMIPGpPANR7YxdkNyFQM46bTGd55Bt1K2ep6pDE8VWZ1StzpIjuO32xmKmf606vZVzI9Zr71dFDcLA6SeWDj9eMFH-8f2doArFWaP3PWO6LOsqS_zdX";
		testNotify.pushFCMNotification(ts, "HI", "FUCKU");
		*/
	/*
	// 測試新增 order 
	JDBC_AVD insertOrder = new JDBC_AVD();
	SimpleDateFormat sdft = new SimpleDateFormat("yyMMddhhmmss");
	Date nowdate = new Date();
	String str = sdft.format(nowdate);
	insertOrder.insertOrder(str, clientInfo.getSenderID(), clientInfo.getReceiverID(), "container_id_NO!",
			"1", clientInfo.getWeight(), clientInfo.getCargoContent(), clientInfo.getSize(), clientInfo.getPrice(), 
			sender_lng, sender_lat, lnglat[2], lnglat[3], sender_time);
	*/
   }
}
