package com.example.daobunso.network;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public class JsonCallable implements Callable<String> {
    private final static String TAG = "TAG_JsonCallable";
    private final String url;
    private final String outStr;

    public JsonCallable(String url, String outStr) {
        this.url = url;
        this.outStr = outStr;
    }

    @Override
    public String call() {
        return getData();
    }

    private String getData() {
        HttpURLConnection connection = null;
        StringBuilder inStr = new StringBuilder();
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setDoInput(true); // allow inputs
            connection.setDoOutput(true); // allow outputs
            // 不知道請求內容大小時可以呼叫此方法將請求內容分段傳輸，設定0代表使用預設大小
            connection.setChunkedStreamingMode(0);
            connection.setUseCaches(false); // do not use a cached copy
            connection.setRequestMethod("POST");
            connection.setRequestProperty("content-type", "application/json");
            connection.setRequestProperty("charset", "UTF-8");

            try (
                    BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(connection.getOutputStream()))
            ) {
                bw.write(outStr); //把資訊送到server端
                Log.d(TAG, "output: " + outStr);
            }

            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        inStr.append(line);
                    }
                }
            } else {
                Log.d(TAG, "response code: " + responseCode);
            }
        } catch (IOException e) {
            Log.e(TAG, e.toString());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        Log.d(TAG, "input: " + inStr);
        return inStr.toString();  // inStr 是一個 StringBuilder 型態
    }
}
