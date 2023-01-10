package com.koushikdutta.async.http.body;

import com.koushikdutta.async.C21121Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.StringParser;

public class StringBody implements AsyncHttpRequestBody<String> {
    public static final String CONTENT_TYPE = "text/plain";

    /* renamed from: a */
    byte[] f58178a;

    /* renamed from: b */
    String f58179b;

    public String getContentType() {
        return "text/plain";
    }

    public boolean readFullyOnRequest() {
        return true;
    }

    public StringBody() {
    }

    public StringBody(String str) {
        this();
        this.f58179b = str;
    }

    public void parse(DataEmitter dataEmitter, final CompletedCallback completedCallback) {
        new StringParser().parse(dataEmitter).setCallback(new FutureCallback<String>() {
            public void onCompleted(Exception exc, String str) {
                StringBody.this.f58179b = str;
                completedCallback.onCompleted(exc);
            }
        });
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        if (this.f58178a == null) {
            this.f58178a = this.f58179b.getBytes();
        }
        C21121Util.writeAll(dataSink, this.f58178a, completedCallback);
    }

    public int length() {
        if (this.f58178a == null) {
            this.f58178a = this.f58179b.getBytes();
        }
        return this.f58178a.length;
    }

    public String toString() {
        return this.f58179b;
    }

    public String get() {
        return toString();
    }
}
