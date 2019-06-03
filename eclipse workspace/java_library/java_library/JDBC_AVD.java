import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.org.apache.regexp.internal.recompile;

public class JDBC_AVD {
	  // 建立連線物件
	  private Connection con = null; //Database objects 
	  private Statement stat = null; 
	  private ResultSet rs = null;   
	  private ResultSet rsTest = null;
	  //結果集 
	  private PreparedStatement pst = null; 
	  //執行,傳入之sql為預儲之字申,需要傳入變數之位置 
	  //先利用?來做標示 
	  
	  private String username,password;
	  
	  private String selectSQL; 
	  
	  public JDBC_AVD() {
		   try {
			    Class.forName("com.mysql.jdbc.Driver");
			    con = (Connection) DriverManager.getConnection( 
				 	  "jdbc:mysql://127.0.0.1/av_delivery?useUnicode=true&characterEncoding=Big5", "root",""); 
		   } catch (ClassNotFoundException | SQLException e) {
			    // TODO 自動產生的 catch 區塊
			    e.printStackTrace();
		   } 
	  }
	  
	  public JDBC_AVD( String usernameX,String passwordX) 
	  { 
		  username = usernameX;
		  password = passwordX;
		  selectSQL = "select user_id from user where username = '"+username+"' and password = '"+password+"';";
		  try { 
			  Class.forName("com.mysql.jdbc.Driver"); 
			  // 註冊driver 
			  con = (Connection) DriverManager.getConnection( 
					  "jdbc:mysql://140.116.72.134/av_delivery?useUnicode=true&characterEncoding=Big5", "root",""); 
			  // System.out.println("fuck!!Ya~"); 
			  // 取得connection 
			  // jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=Big5
			  // localhost是主機名,test是database名
			  // useUnicode=true&characterEncoding=Big5使用的編碼 
		  } 
		  catch(ClassNotFoundException e) 
		  { 
			  System.out.println("DriverClassNotFound :"+e.toString()); 
		  }//有可能會產生sqlexception 
		  catch(SQLException x) { 
			  System.out.println("Exception :"+x.toString()); 
		  } 
	  } 
	  
	  // 初始化貨車資訊
	  public void insertVehicle(String truck_No, double lat_now, double lng_now, double speed) {
		   String sql = "insert into truck (id, truck_number, lat_now, lng_now, lat_dest, lng_dest, "
			   		+ "speed) values (?,?,?,?,?,?,?)";
			   try {
				   pst = (PreparedStatement) con.prepareStatement(sql);
				   pst.setInt(1, 0);
				   pst.setString(2, truck_No);
				   pst.setDouble(3, lat_now);
				   pst.setDouble(4, lng_now);
				   pst.setDouble(5, -0.0);
				   pst.setDouble(6, -0.0);
				   pst.setDouble(7, speed);
				   pst.executeUpdate();
				   
			   } catch (SQLException e) {
				   // TODO 自動產生的 catch 區塊
				   e.printStackTrace();
			   }
	  }
	  
	  // 初始化貨櫃資訊
	  public void insertContainer(String container_number, int size, int status, String lock_password, String truck_id) {
		   String sql = "insert into container (id, container_number, size, status, lock_password, truck_id) values (?,?,?,?,?,?)";
			   try {
				   pst = (PreparedStatement) con.prepareStatement(sql);
				   pst.setInt(1, 0);
				   pst.setString(2, container_number);
				   pst.setInt(3, size);
				   pst.setInt(4, status);
				   pst.setString(5, lock_password);
				   pst.setString(6, truck_id);
				   pst.executeUpdate();
				   
			   } catch (SQLException e) {
				   // TODO 自動產生的 catch 區塊
				   e.printStackTrace();
			   }
	  }
	  
	  // 使用者下訂單並且成功選定貨車
	  public void insertOrder(String order_No, String sender_name, String receiver_name, String container_id, String truck_id,
			  double weight, String cargo_content, int size, int price, double sender_lng, double sender_lat,
			  double receiver_lng, double receiver_lat, int sender_time) {
		   String sql = "insert into user_order (id, order_number, sender_name, receiver_name, container_id, in_time, out_time, "
		   		+ "truck_id, status, weight, cargo_content, size, price, sender_lng, sender_lat, receiver_lng, receiver_lat, order_time,"
		   		+ " sender_time, receiver_time) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		   try {
			   pst = (PreparedStatement) con.prepareStatement(sql);
			   pst.setInt(1, 0);
			   pst.setString(2, order_No);
			   pst.setString(3, sender_name);
			   pst.setString(4, receiver_name);
			   pst.setString(5, container_id);
			   Date date = new Date();
			   java.sql.Timestamp timestamp =new Timestamp(date.getTime());
			   pst.setTimestamp(6, timestamp); 
			   pst.setTimestamp(7, timestamp);
			   pst.setString(8, truck_id);
			   pst.setString(9,"00");
			   pst.setDouble(10, weight);
			   pst.setString(11, cargo_content);
			   pst.setInt(12, size);
			   pst.setInt(13, price);
			   pst.setDouble(14, sender_lng);
			   pst.setDouble(15, sender_lat);
			   pst.setDouble(16, receiver_lng);
			   pst.setDouble(17, receiver_lat);
			   Date dateOrder = new Date();
			   java.sql.Timestamp timestampOrder =new Timestamp(dateOrder.getTime());
			   pst.setTimestamp(18, timestampOrder); 
			   pst.setInt(19, sender_time);
			   pst.setInt(20, 0);
			   pst.executeUpdate();
			   
		   } catch (SQLException e) {
			   // TODO 自動產生的 catch 區塊
			   e.printStackTrace();
		   }
	  }
	  
	// 取得使用者的 Device_ID
		  public String QueryDeviceKey(String user_name)
		  { 
			  String result = "No";
		    try 
		    {  
		    	String sql = "select device_key from user where username = ? ";
		    	pst = (PreparedStatement) con.prepareStatement(sql);
		    	pst.setString(1, user_name);
		    	rs = pst.executeQuery();
		      
		    	while(rs.next()) {
		    		result = rs.getString("device_key");
		    	}
		    	System.out.println(result); 
		    	return result;		      
		    } 
		    catch(SQLException e) 
		    { 
		      System.out.println("DropDB Exception :" + e.toString()); 
		    } 
		    finally 
		    { 
		      Close(); 
		      System.out.println("already close!");
		    }
		    return "No";   
		  } 
		  //////////////////////////////////////////////
	  
	  
	  // 登入並取得user_id
	  public int Login(int user_id)
	  { 
	    try 
	    { 
	      System.out.println(selectSQL); 
	      stat = (Statement) con.createStatement();
	      rsTest = stat.executeQuery(selectSQL);//rsTest測試RS是否有值
	      //System.out.println(rsTest.next()); 
	      if (rsTest.next()==true){	 //若有則進入進一步的存取資料階段    
	    	  rs = stat.executeQuery(selectSQL); 
	    	  //System.out.println("ID\t\tName\t\tPASSWORD"); 
	    	  while(rs.next()) 
	    	  { 
	    		  user_id = rs.getInt("user_id");
	    		  return user_id;
	    	  } 
	      }
	      else{
	    	  	  return 0;
	      }
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	      System.out.println("already close!");
	    }
	    return 0;   
	  } 
	  //////////////////////////////////////////////

	   
	  //完整使用完資料庫後,記得要關閉所有Object 
	  //否則在等待Timeout時,可能會有Connection poor的狀況 
	  public void Close() 
	  { 
		  try 
		  { 
			  if(rs!=null) { 
				  rs.close(); 
				  rs = null; 
			  } 
			  if(stat!=null) { 
				  stat.close(); 
				  stat = null; 
			  } 
			  if(pst!=null) { 
				  pst.close(); 
				  pst = null; 
			  }
			  con.close();
			  // System.out.println("already close!");
		  } 
		  catch(SQLException e) 
		  { 
			  System.out.println("Close Exception :" + e.toString()); 
		  } 
	  } 
}


