package com.example.drken.androidjokelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class JokeActivity extends AppCompatActivity {

    private static final String JOKE = "joke";
    private static final String DEFAULT_JOKE = "I don't know any jokes!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        String myJoke = intent.getStringExtra(JOKE);

        // Get a handle on the Web View for this fragment
        WebView webView = (WebView) findViewById(R.id.joke_webview);
        webView.loadData(myJoke, "text/html", "UTF-8");

    }
}
