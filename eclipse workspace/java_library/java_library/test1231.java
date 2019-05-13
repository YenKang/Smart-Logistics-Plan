import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class test1231 {

	public static void main(String[] args) throws IOException {
		// TODO 自動產生的方法 Stub
		
		ArrayList  a =new ArrayList(3);
		a.add(1);
		a.add(2);
		a.add(3);
		System.out.println(a.get(0));
		a.clear();
		a.add(444);
		System.out.println(a.get(1));
		
		// JDBC_AVD init = new JDBC_AVD();
		//a.insertOrder();
		//SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		//Date date = new Date();
		//String strDate = sdFormat.format(date);
		//System.out.println(strDate);
		/*java.util.Date utilDate = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(utilDate);
		cal.set(Calendar.MILLISECOND, 0);
		System.out.println(new java.sql.Timestamp(utilDate.getTime()));
		System.out.println(new java.sql.Timestamp(cal.getTimeInMillis())); */
		
		/*Date date = new Date();
		java.sql.Timestamp timestamp =new Timestamp(date.getTime());
		System.out.println(timestamp);*/
	}

}
