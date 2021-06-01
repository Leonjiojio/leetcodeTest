package com.sinovoice.leetcodetest;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        findViewById(R.id.btn_close_ime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                hideIME(HttpActivity.this);
            }
        });
    }
    private HttpClient createHttpClient(){
        HttpParams mdefaultParams=new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(mdefaultParams,15000);
        HttpConnectionParams.setSoTimeout(mdefaultParams,15000);
        HttpConnectionParams.setTcpNoDelay(mdefaultParams,true);
        HttpProtocolParams.setVersion(mdefaultParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(mdefaultParams, HTTP.UTF_8);
        HttpProtocolParams.setUseExpectContinue(mdefaultParams,true);
        HttpClient mhttpClient=new DefaultHttpClient(mdefaultParams);
        return mhttpClient;
    }
    private void userGet(){
        HttpGet httpGet=new HttpGet();

        httpGet.addHeader("Connection","Keep-Alive");
        try {

            HttpClient httpClient=createHttpClient();
            HttpResponse httpResponse=httpClient.execute(httpGet);
            HttpEntity httpEntity=httpResponse.getEntity();
            int code=httpResponse.getStatusLine().getStatusCode();
            if (null!=httpEntity){
                InputStream inputStream=httpEntity.getContent();
            }
        }catch ( Exception e){
            e.printStackTrace();
        }
    }


    private void okhttpTest(){
        Request.Builder requestbuilder=new Request.Builder().url("");
        requestbuilder.method("GET",null);
        Request request=requestbuilder.build();
        OkHttpClient okHttpClient=new OkHttpClient();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    private HttpURLConnection gethttpUrlconnectiopn(String urlStr){
        HttpURLConnection httpURLConnection=null;
        try {
            URL url=new URL(urlStr);
            httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection","Keep-Alive");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  httpURLConnection;
    }

    public static void hideIME(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
        View v = activity.getWindow().peekDecorView();
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
}