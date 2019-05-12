import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class JDBC_AVD {
	  // �إ߳s�u����
	  private Connection con = null; //Database objects 
	  private Statement stat = null; 
	  private ResultSet rs = null;   
	  private ResultSet rsTest = null;
	  //���G�� 
	  private PreparedStatement pst = null; 
	  //����,�ǤJ��sql���w�x���r��,�ݭn�ǤJ�ܼƤ���m 
	  //���Q��?�Ӱ��Х� 
	  
	  private String username,password;
	  
	  private String selectSQL; 
	  
	  public JDBC_AVD() {
		   try {
			    Class.forName("com.mysql.jdbc.Driver");
			    con = (Connection) DriverManager.getConnection( 
				 	  "jdbc:mysql://127.0.0.1/av_delivery?useUnicode=true&characterEncoding=Big5", "root",""); 
		   } catch (ClassNotFoundException | SQLException e) {
			    // TODO �۰ʲ��ͪ� catch �϶�
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
			  // ���Udriver 
			  con = (Connection) DriverManager.getConnection( 
					  "jdbc:mysql://140.116.72.134/av_delivery?useUnicode=true&characterEncoding=Big5", "root",""); 
			  // System.out.println("fuck!!Ya~"); 
			  // ���oconnection 
			  // jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=Big5
			  // localhost�O�D���W,test�Odatabase�W
			  // useUnicode=true&characterEncoding=Big5�ϥΪ��s�X 
		  } 
		  catch(ClassNotFoundException e) 
		  { 
			  System.out.println("DriverClassNotFound :"+e.toString()); 
		  }//���i��|����sqlexception 
		  catch(SQLException x) { 
			  System.out.println("Exception :"+x.toString()); 
		  } 
	  } 
	  
	  // ��l�Ƴf����T
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
				   // TODO �۰ʲ��ͪ� catch �϶�
				   e.printStackTrace();
			   }
	  }
	  
	  // ��l�Ƴf�d��T
	  public void insertContainer(String container_number, int size, String lock_password, int truck_id) {
		   String sql = "insert into container (id, container_number, size, status, lock_password, truck_id) values (?,?,?,?,?,?)";
			   try {
				   pst = (PreparedStatement) con.prepareStatement(sql);
				   pst.setInt(1, 0);
				   pst.setString(2, container_number);
				   pst.setInt(3, size);
				   pst.setInt(4, 0);
				   pst.setString(5, lock_password);
				   pst.setInt(6, truck_id);
				   pst.executeUpdate();
				   
			   } catch (SQLException e) {
				   // TODO �۰ʲ��ͪ� catch �϶�
				   e.printStackTrace();
			   }
	  }
	  
	  // �ϥΪ̤U�q��åB���\��w�f��
	  public void insertOrder(String sender_name, String receiver_name, int container_id, int truck_id,
			  double weight, String cargo_content, int size, int price) {
		   String sql = "insert into user_order (id, sender_name, receiver_name, container_id, in_time, out_time, "
		   		+ "truck_id, status, weight, cargo_content, size, price) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		   try {
			   pst = (PreparedStatement) con.prepareStatement(sql);
			   pst.setInt(1, 0);
			   pst.setString(2, sender_name);
			   pst.setString(3, receiver_name);
			   pst.setInt(4, container_id);
			   Date date = new Date();
			   java.sql.Timestamp timestamp =new Timestamp(date.getTime());
			   pst.setTimestamp(5, timestamp);
			   pst.setTimestamp(6, timestamp);
			   pst.setInt(7, truck_id);
			   pst.setInt(8, 0);
			   pst.setDouble(9, weight);
			   pst.setString(10, cargo_content);
			   pst.setInt(11, size);
			   pst.setInt(12, price);
			   pst.executeUpdate();
			   
		   } catch (SQLException e) {
			   // TODO �۰ʲ��ͪ� catch �϶�
			   e.printStackTrace();
		   }
	  }
	  
	  
	  // �n�J�è��ouser_id
	  public int Login(int user_id)
	  { 
	    try 
	    { 
	      System.out.println(selectSQL); 
	      stat = (Statement) con.createStatement();
	      rsTest = stat.executeQuery(selectSQL);//rsTest����RS�O�_����
	      //System.out.println(rsTest.next()); 
	      if (rsTest.next()==true){	 //�Y���h�i�J�i�@�B���s����ƶ��q    
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

	   
	  //����ϥΧ���Ʈw��,�O�o�n�����Ҧ�Object 
	  //�_�h�b����Timeout��,�i��|��Connection poor�����p 
	  private void Close() 
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
		  } 
		  catch(SQLException e) 
		  { 
			  System.out.println("Close Exception :" + e.toString()); 
		  } 
	  } 
}


