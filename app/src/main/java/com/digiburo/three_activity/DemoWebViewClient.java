package com.digiburo.three_activity;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DemoWebViewClient extends WebViewClient {
    private final String LOG_TAG = getClass().getName();

    //
    //private UrlInterceptListener urlInterceptListener;

    /**
     * ctor
     * @param arg
     */
    //public DemoWebViewClient(UrlInterceptListener arg) {
    //  urlInterceptListener = arg;
    //}

    @Override
    public void onLoadResource(WebView webView, String url) {
        Log.d(LOG_TAG, "load:" + url);
    }

    @Override
    public void onPageFinished(WebView webView, String url) {
        Log.d(LOG_TAG, "pageFinished:" + url);
    }

    @Override
    public void onPageStarted(WebView webView, String url, Bitmap favicon) {
        Log.d(LOG_TAG, "pageStarted:" + url);
    }

    @Override
    public void onReceivedError(WebView webView, int errorCode, String description, String url) {
        Log.d(LOG_TAG, "error:" + errorCode + ":" + description + ":" + url);
    }

    @Override
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler handler, String host, String realm) {
        Log.d(LOG_TAG, "authRequest:" + host + ":" + realm);
    }

    @Override
    public void onReceivedLoginRequest(WebView webView, String realm, String account, String args) {
        Log.d(LOG_TAG, "loginRequest:" + realm + ":" + account);
    }

    @Override
    public void onReceivedSslError(WebView webView, SslErrorHandler handler, SslError error) {
        Log.d(LOG_TAG, "sslError");
    }

    @Override
    public void onScaleChanged(WebView webView, float oldScale, float newScale) {
        Log.d(LOG_TAG, "scaleChanged:" + oldScale + ":" + newScale);
    }

    @Override
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        Log.d(LOG_TAG, "unhandledKey:" + keyEvent);
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
        Log.d(LOG_TAG, "interceptRequest:" + url);
        return null;
    }

    @Override
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        Log.d(LOG_TAG, "overrideKeyEvent:" + keyEvent);
        return true;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        Log.d(LOG_TAG, "overrideUrl:" + url);

        if (url.equals("https://www.facebook.com/")) {
            Log.d(LOG_TAG, "facebook match");
            webView.loadUrl(url);
            return true;
        } else if (url.equals("https://www.google.com/")) {
            Log.d(LOG_TAG, "google match");
            webView.loadUrl("https://www.amazon.com");
            return false;
        } else {
            Log.d(LOG_TAG, "no match:" + url);
        }

        return false;
    }
}
