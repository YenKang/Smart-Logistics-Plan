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
}
}
