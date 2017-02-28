package com.example.administrator.androidrelatejs;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView contentWebView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        contentWebView = (WebView) findViewById(R.id.webView);
        // 启用javascript
        contentWebView.getSettings().setJavaScriptEnabled(true);
        // 从assets目录下面的加载html
        contentWebView.loadUrl("file:///android_asset/web.html");
        contentWebView.addJavascriptInterface(MainActivity.this,"android");


    }

    public void javaCallJs(View v){
        // 传递参数调用JS的方法
        contentWebView.loadUrl("javascript:javacalljswith(" + "'http://blog.csdn.net/Leejizhou'" + ")");

    }

    public void javaCallJsWith(View v){
        runOnUiThread(new Runnable() {

            public void run() {
                Toast.makeText(MainActivity.this,"show",Toast.LENGTH_LONG).show();

            }
        });

    }

    public void startFunction(final String text){
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                new AlertDialog.Builder(MainActivity.this).setMessage(text).show();

            }
        });


    }

}
