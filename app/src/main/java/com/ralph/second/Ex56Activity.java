package com.ralph.second;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by 果占先 on 2016/6/13.
 */
public class Ex56Activity extends BaseActivity {
    WebView webView;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex56_layout);
        webView = (WebView) findViewById(R.id.webView);
        //webView.loadUrl("http://lihongxun945.github.io/jquery-weui/dist/demos/");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/www/index.html");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }
}
