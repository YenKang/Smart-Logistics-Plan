import java.util.ArrayList;

public class AssignResult {

	private int rs;
	private String timeFilter;
	
	public AssignResult() {
		// TODO
		rs = 1;
		timeFilter = "000000000000";
	}	
	
	public int getResult() {
	    return rs;
	}
	
	public String getTF() {
		return timeFilter;
	}

	public void setResult(int rs) {
	    this.rs = rs;
	}
	public void setTF(String timeFilter) {
		    this.timeFilter = timeFilter;
	}
}
