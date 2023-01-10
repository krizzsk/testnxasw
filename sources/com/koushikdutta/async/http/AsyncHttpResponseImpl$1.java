package com.koushikdutta.async.http;

import com.koushikdutta.async.callback.CompletedCallback;

class AsyncHttpResponseImpl$1 implements CompletedCallback {
    final /* synthetic */ C21182a this$0;

    AsyncHttpResponseImpl$1(C21182a aVar) {
        this.this$0 = aVar;
    }

    public void onCompleted(Exception exc) {
        this.this$0.onRequestCompleted(exc);
    }
}
