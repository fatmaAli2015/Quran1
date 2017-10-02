package com.fatmaali.quran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Web_html extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_html);
        WebView webView = (WebView) findViewById(R.id.webv_html);
        Intent data = getIntent();
        int page = data.getExtras().getInt("page");
        page++;
        webView.loadUrl("file:///android_asset/html/"+page+".html");
    }
}
