import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class FcmNotify {
	
	public final static String AUTH_KEY_FCM = "AIzaSyAyhmma-YLNEm2fwC2HrrI3R8_LybtDZcc";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
    
    private String user_mac_token="";
    
    public FcmNotify() {
		// TODO 自動產生的建構子 Stub
	}
    
    // userDeviceIdKey is the device id you will query from your database
    public void pushFCMNotification(String userDeviceIdKey, String title, String message) throws Exception {

        String authKey = AUTH_KEY_FCM;   // You FCM AUTH key
        String FMCurl = API_URL_FCM;

        URL url = new URL(FMCurl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + authKey);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject json = new JSONObject();
        json.put("to", userDeviceIdKey.trim());
        JSONObject info = new JSONObject();
        info.put("title", title); // Notification title
        info.put("body", message); // Notification body
        json.put("notification", info);
        System.out.println(json.toString());

        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(json.toString());
        wr.flush();
        conn.getInputStream();
       // System.out.println(url.getH);
    }
}
