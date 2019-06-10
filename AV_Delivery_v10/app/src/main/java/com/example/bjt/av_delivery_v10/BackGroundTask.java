package com.example.bjt.av_delivery_v10;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

// 要使用 AsyncTask，必定要建立一個繼承自 AsyncTask 的子類別，並傳入 3 項資料：
// Params -- 要執行 doInBackground() 時傳入的參數，數量可以不止一個
// Progress -- doInBackground() 執行過程中回傳給 UI thread 的資料，數量可以不止一個
// Rsesult -- 傳回執行結果， 若您沒有參數要傳入，則填入 Void (注意 V 為大寫)。

public class BackGroundTask extends AsyncTask<String, Void, String> {


    AlertDialog alertDialog;
    /////
    Context ctx;
    BackGroundTask(Context ctx){
        this.ctx = ctx;
    }
    /////

    // AsyncTask 執行前的準備工作，例如畫面上顯示進度表
    @Override
    protected void onPreExecute() {
        /*alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information...");*/
    }

    @Override
    protected String doInBackground(String... params) {

        String reg_url = "http://140.116.72.134/AV_user/register.php";
        // 記得改回來 0610
        String login_url = "http://140.116.72.162/AV_user/Login.php";
        String method = params[0];
        if (method.equals("register")){
            String name = params[1];
            String user_name = params[2];
            String user_pass = params[3];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);

                /// 寫入資料
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("user","UTF-8") + "=" +URLEncoder.encode(name,"UTF-8") + "&" +
                        URLEncoder.encode("user_name","UTF-8") + "=" +URLEncoder.encode(user_name,"UTF-8") + "&" +
                        URLEncoder.encode("user_pass","UTF-8") + "=" +URLEncoder.encode(user_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                ///

                /// 讀取資料
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                /// 放入回傳值中
                String response ="";
                String line ="";

                while ((line = bufferedReader.readLine()) != null){
                    response = response + line;
                }
                bufferedReader.close();
                inputStream.close();
                ///

                //InputStream IS = httpURLConnection.getInputStream();
                //IS.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("login")){
            String login_name = params[1];
            String login_pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                // 輸出
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")
                        +"&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                // 輸入
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                //JSONArray a;
                String response ="";
                String line ="";

                while ((line = bufferedReader.readLine()) != null){
                    response = response + line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "0";
    }

    // 用來顯示目前的進度
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    // 執行完的結果 - Result 會傳入這裡
    @Override
    protected void onPostExecute(String result){

        if (result.equals("No_match")) {
            Toast.makeText(ctx, "帳號密碼錯誤，請重新輸入。", Toast.LENGTH_LONG).show();
            Intent it = new Intent();
            it.setClass(ctx, Login.class);
            ctx.startActivity(it);
        }
        else {
            //Toast.makeText(ctx, "登入成功！", Toast.LENGTH_LONG).show();
            try {
                JSONObject jsonObject = new JSONObject(result);
                int user_id = jsonObject.getInt("user_id");
                String username = jsonObject.getString("username");
                String password = jsonObject.getString("password");
                String phone_number = jsonObject.getString("phone_number");
                String gender = jsonObject.getString("gender");
                String register_time = jsonObject.getString("register_time");

                Toast.makeText(ctx, jsonObject.getString("device_key"), Toast.LENGTH_LONG).show();

                Intent it = new Intent();
                it.setClass(ctx, AccountActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("user_id",user_id);
                bundle.putString("username",username);
                bundle.putString("password",password);
                bundle.putString("phone_number",phone_number);
                bundle.putString("gender",gender);
                bundle.putString("register_time",register_time);
                // 儲存用來進行推播通知的 key
                bundle.putString("device_key", jsonObject.getString("device_key"));
                it.putExtras(bundle);
                ctx.startActivity(it);
                Toast.makeText(ctx, "您好，"+username, Toast.LENGTH_LONG).show();
                // int user_id = Integer.parseInt(testS);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        /*if(result.equals("login_success")) {
            //Toast.makeText(ctx,result, Toast.LENGTH_LONG).show();
            //ctx.startActivity(new Intent(ctx, MainActivity.class));
            //Toast.makeText(ctx, "Login Success!!", Toast.LENGTH_LONG).show();
            Intent it = new Intent();
            it.setClass(ctx,MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("RS",result);
            it.putExtras(bundle);
            ctx.startActivity(it);
        }*/
        /*
        if (result.equals("register_success")) {
            //alertDialog.setMessage("Register Success!!");
            //alertDialog.show();
            Toast.makeText(ctx, "Register Success!!", Toast.LENGTH_LONG).show();
        }
        else if (result.equals("username_duplicate")) {
            //alertDialog.setMessage("Register Success!!");
            //alertDialog.show();
            Toast.makeText(ctx, "Username Duplicate!!", Toast.LENGTH_LONG).show();
        }
        */
    }
}
