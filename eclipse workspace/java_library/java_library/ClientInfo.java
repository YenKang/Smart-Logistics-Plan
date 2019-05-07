
public class ClientInfo {

	private boolean request;
	private int user_id;
	double[] result= new double[4];
	private double sender_lng;
	private double sender_lat;
	private double receiver_lng;
	private double receiver_lat;

	public ClientInfo() {
		sender_lat = 0.0;
		sender_lng = 0.0;
		receiver_lat = 0.0;
		receiver_lng = 0.0;
	}
	
	
	public ClientInfo(double s_lng, double s_lat, double r_lng, double r_lat){
		request = true;
		sender_lat = s_lat;
		sender_lng = s_lng;
		receiver_lat = r_lat;
		receiver_lng = r_lng; // should be written in "lon"
	}
	
	public double[] getLatLng() {
		result[0] = sender_lng;
		result[1] = sender_lat;
		result[2] = receiver_lng; // should be written in "lon"
		result[3] = receiver_lat; 
		return result;
	}
	
	
}
