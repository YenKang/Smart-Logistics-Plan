import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class test1231 {

	public static void main(String[] args) throws IOException {
		// TODO 自動產生的方法 Stub
		SimpleDateFormat sdft = new SimpleDateFormat("yyMMddhhmmss");
		Date nowdate = new Date();
		String str = sdft.format(nowdate);
		System.out.println(str);

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
