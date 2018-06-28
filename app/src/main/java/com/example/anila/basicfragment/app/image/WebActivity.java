package com.example.anila.basicfragment.app.image;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.anila.basicfragment.R;

public class WebActivity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        mWebView=findViewById(R.id.webview);
        mWebView.loadUrl("https://www.animalplanet.com");




    }
}
