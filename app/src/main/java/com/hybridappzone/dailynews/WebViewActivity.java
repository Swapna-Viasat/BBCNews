package com.hybridappzone.dailynews;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by swapna on 20/11/2017.
 */

public class WebViewActivity  extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.weblayout);

        WebView wv=(WebView)findViewById(R.id.webview);

        WebSettings ws=wv.getSettings();
        wv.getSettings().setJavaScriptEnabled(true);
        Bundle extras = getIntent().getExtras();
        String mWebUrl = null;
        if (extras != null) {
            mWebUrl = extras.getString("Url");
        }
        wv.loadUrl(mWebUrl.toString());

    }

}
