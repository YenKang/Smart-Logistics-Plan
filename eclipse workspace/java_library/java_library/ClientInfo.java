
public class ClientInfo {

	private int requestNo;
	private double sender_lng;
	private double sender_lat;
	private double receiver_lng;
	private double receiver_lat;
	private int timeArrived;
	private String sender_id, receiver_id, cargo_content;
	private int price, size;
	private double weight;
	private String truckNo;
	
	private String containerNo;
	
	public ClientInfo() {
	}
	
	public ClientInfo(int requestNo){
		this.requestNo = requestNo;
	}
	
	public String getContainerNo() {
		return containerNo;
	}
	
	public void setContainerNo(String container_id) {
		this.containerNo = container_id;
	}
	
	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}
	
	public String getTruckNo() {
		return truckNo;
	}
	
	public void setSenderId(String sender_id) {
		this.sender_id = sender_id;
	}
	public void setReceiverId(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	
	public void setLatLng(double sender_lng, double sender_lat, double receiver_lng, double receiver_lat) {
		this.sender_lng = sender_lng;
		this.sender_lat = sender_lat;
		this.receiver_lng = receiver_lng;
		this.receiver_lat = receiver_lat;
	}
	
	public void setContainerSpec(int price, int size, double weight, String cargo_content) {
		this.price = price;
		this.size = size;
		this.weight = weight;
		this.cargo_content = cargo_content;
	}
	
	public void setTimeArrived(int timeArrived) {
		this.timeArrived = timeArrived;
	}
	
	public int getRequestNo() {
		return this.requestNo;
	}
	
	public int getTimeArrived() {
		return timeArrived;
	}
	
	public String getSenderID() {
		return sender_id;
	}
	
	public String getReceiverID() {
		return receiver_id;
	}
	
	public String getCargoContent() {
		return cargo_content;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getPrice() {
		return price;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double[] getLngLat() {
		double[] result= new double[4];
		result[0] = sender_lng;
		result[1] = sender_lat;
		result[2] = receiver_lng; 
		result[3] = receiver_lat; 
		return result;
	}
	
}
