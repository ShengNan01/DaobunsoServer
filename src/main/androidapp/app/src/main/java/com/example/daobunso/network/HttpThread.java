package com.example.daobunso.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpThread extends Thread {

    String url;
    String newPassword;
    String newAccount;
    String newEmail;
    String UserName;

    public HttpThread(String url, String newPassword,String newAccount,String newEmail,String UserName) {
       this.url = url;
       this.newPassword = newPassword;
       this.newAccount = newAccount;
        this.newEmail = newEmail;
        this.UserName = UserName;
    }
    private void doGet() throws IOException {
        /*將username和password傳給Tomcat伺服器*/
        url=url+"?newPassword="+newPassword+"&;newAccount="+newAccount+"&;newEmail="+newEmail+"&;UserName="+UserName;
        try {
            URL httpUrl = new URL(url);
            /*獲取網路連線*/
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            /*設定請求方法為GET方法*/
            conn.setRequestMethod("GET");
            /*設定訪問超時時間*/
            conn.setReadTimeout(5000);
            BufferedReader reader=
                    new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String str;
            StringBuffer sb=new StringBuffer();
            //讀取伺服器返回的資訊
            while((str=reader.readLine())!=null)
            {
                sb.append(str);
            }

            // 把服務端返回的資料打印出來
            System.out.println("result"+sb.toString());
        }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
    }
            /*在run中呼叫doGet*/
            @Override public void run() {
                try {
                    doGet();
                }
                catch (IOException e)
                {  e.printStackTrace(); }
            }
    }


