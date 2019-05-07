import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class FcmNotif {
	// 記一下USERID: ePYLlxTtxzk:APA91bHFiM_ZhWOdPDQorJUhw2djV7rhx1ln1Hhhni_FrMYlJ3m
	// cYRSXymej7fxq6nwsqM0TyGI7k5BWMpcj2sr5lH8UN58289fguPqTTd23uHIN5htEmWq5Ns4WkmFOAFw2EtiK14vz

	public final static String AUTH_KEY_FCM = "AIzaSyAyhmma-YLNEm2fwC2HrrI3R8_LybtDZcc";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

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
	public static void main(String[] args) throws Exception {
		// TODO 自動產生的方法 Stub
		FcmNotif fcmN=new FcmNotif();
        fcmN.pushFCMNotification("ePYLlxTtxzk:APA91bHFiM_ZhWOdPDQorJUhw2djV7rhx1ln1Hhhni_FrMYlJ3mcYRSXymej7fxq6nwsqM0TyGI7k5BWMpcj2sr5lH8UN58289fguPqTTd23uHIN5htEmWq5Ns4WkmFOAFw2EtiK14vz", 
        		"myFirstMessage", "123456789");
        System.out.println("Done");
	}

}
