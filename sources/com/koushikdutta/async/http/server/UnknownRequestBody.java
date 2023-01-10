package com.koushikdutta.async.http.server;

import com.koushikdutta.async.C21121Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;

public class UnknownRequestBody implements AsyncHttpRequestBody<Void> {

    /* renamed from: a */
    int f58278a = -1;

    /* renamed from: b */
    DataEmitter f58279b;

    /* renamed from: c */
    private String f58280c;

    public Void get() {
        return null;
    }

    public boolean readFullyOnRequest() {
        return false;
    }

    public UnknownRequestBody(String str) {
        this.f58280c = str;
    }

    public UnknownRequestBody(DataEmitter dataEmitter, String str, int i) {
        this.f58280c = str;
        this.f58279b = dataEmitter;
        this.f58278a = i;
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        C21121Util.pump(this.f58279b, dataSink, completedCallback);
        if (this.f58279b.isPaused()) {
            this.f58279b.resume();
        }
    }

    public String getContentType() {
        return this.f58280c;
    }

    public int length() {
        return this.f58278a;
    }

    @Deprecated
    public void setCallbacks(DataCallback dataCallback, CompletedCallback completedCallback) {
        this.f58279b.setEndCallback(completedCallback);
        this.f58279b.setDataCallback(dataCallback);
    }

    public DataEmitter getEmitter() {
        return this.f58279b;
    }

    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        this.f58279b = dataEmitter;
        dataEmitter.setEndCallback(completedCallback);
        dataEmitter.setDataCallback(new DataCallback.NullDataCallback());
    }
}
