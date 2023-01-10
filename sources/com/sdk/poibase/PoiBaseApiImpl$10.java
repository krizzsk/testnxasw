package com.sdk.poibase;

import com.sdk.poibase.model.IHttpListener;
import java.io.IOException;

class PoiBaseApiImpl$10 implements Runnable {
    final /* synthetic */ C21489a this$0;
    final /* synthetic */ IHttpListener val$listener;

    PoiBaseApiImpl$10(C21489a aVar, IHttpListener iHttpListener) {
        this.this$0 = aVar;
        this.val$listener = iHttpListener;
    }

    public void run() {
        this.val$listener.onFail((IOException) null);
    }
}
