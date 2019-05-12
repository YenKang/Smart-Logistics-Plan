package com.example.bjt.av_delivery_v10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

// 進入程式後主功能頁面
public class MainActivity extends AppCompatActivity {

    private Button account, send, myOrder, testbyabout;
    private Socket clientSocket;
    private String temp;
    private JSONObject jsonR, jsonW;
    Map hashmap = new HashMap();
    JSONObject jsonTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SharedPreferences sharedPreferences = getSharedPreferences("user_info",0);
        account = findViewById(R.id.account_button);
        send = findViewById(R.id.send_button);
        myOrder = findViewById(R.id.my_package_button);
        testbyabout = findViewById(R.id.about_button);
        hashmap.put("sender_lng", 120.213878);
        hashmap.put("sender_lat", 22.996839);
        jsonTest = new JSONObject(hashmap);
        // 負責監聽按鈕事件的函式
        processControllers();
    }

    // 負責監聽本頁面所有按鈕事件的函式
    private void processControllers() {
        // 進入會員頁面
        View.OnClickListener accountListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Login.class);
                startActivity(i);
            }
        };
        account.setOnClickListener(accountListener);

        // 進入使用者寄貨畫面
        View.OnClickListener sendListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), SendActivity.class);
                startActivity(i);
            }
        };
        send.setOnClickListener(sendListener);

        // 進入我的訂單畫面
        View.OnClickListener myOrderListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MyOrderActivity.class);
                startActivity(i);
            }
        };
        myOrder.setOnClickListener(myOrderListener);

        // 測式按鈕，目前為測式 socket 連線之用
        View.OnClickListener testListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread threadSocket = new Thread(Connection);
                threadSocket.start();
                System.out.println("123");
            }
        };
        testbyabout.setOnClickListener(testListener);

    }

    private Runnable Connection = new Runnable() {
        @Override
        public void run() {
            OutputStream output = null;
            InputStream input = null;
            try{
                InetAddress serverIP = InetAddress.getByName("140.116.72.162"); //Bryan's IP address =140.116.72.162
                int serverPort = 6678;
                clientSocket = new Socket(serverIP, serverPort);
                //System.out.println("456");

                // 取得網路輸出流 //////////////////////////////////////////
                output = new DataOutputStream(clientSocket.getOutputStream());
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output));
                //bw.write("123");
                bw.write(jsonTest.toString());
                bw.flush();
                // 指關閉輸出流
                clientSocket.shutdownOutput();

                // 取得網路輸入流 /////////////////////////////////////////////
                input = new DataInputStream(clientSocket.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(input));
                temp = br.readLine();
                System.out.println(temp);
                bw.close();
                br.close();
                output.close();
                input.close();
                //clientSocket.close();
                /*while (clientSocket.isConnected()) {
                    //宣告一個緩衝,從br串流讀取 Server 端傳來的訊息
                    temp = br.readLine();
                    System.out.println(temp);
                    //break;
                }*/
            }
            catch (Exception e){
                //當斷線時會跳到 catch,可以在這裡處理斷開連線後的邏輯
                e.printStackTrace();
                System.out.println("斷線囉~~");
                Log.e("text","Socket連線="+e.toString());
            }
            finally
            {
                try
                {
                    if ( input != null )
                        input.close();
                    if ( output != null )
                        output.close();
                    if ( clientSocket != null && !clientSocket.isClosed() )
                        clientSocket.close();
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }
            }
        }
    };
}























