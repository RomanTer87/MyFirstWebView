package com.example.mywebview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;
    WebView webView;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.edit_text_id);
        webView = findViewById(R.id.webView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FindContent();
            }
        });
    }

    public void FindContent(){
        String query = editText.getText().toString().trim();
        if(!query.isEmpty())
        {
            WebSettings webS = webView.getSettings();
            webS.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://google.com/search?q="+query);
        }

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(webView.canGoBack())
                    webView.goBack();
                else
                    finish();

            }
        });
    }
}