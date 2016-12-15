package com.example.nagaraj.web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button b;
    WebView web;
    private class WebClient extends WebViewClient{
        public boolean ShouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        et=(EditText) findViewById(R.id.URL);
        b=(Button) findViewById(R.id.button);
        web=(WebView) findViewById(R.id.webView);
        web.loadUrl("http://www.google.com");
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                web.setWebViewClient(new WebClient());
                web.loadUrl("http://"+et.getText().toString());
            }
        });
    }
}
