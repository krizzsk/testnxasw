package com.koushikdutta.async.http.body;

import com.koushikdutta.async.C21121Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import java.io.InputStream;

public class StreamBody implements AsyncHttpRequestBody<InputStream> {
    public static final String CONTENT_TYPE = "application/binary";

    /* renamed from: a */
    InputStream f58175a;

    /* renamed from: b */
    int f58176b;

    /* renamed from: c */
    String f58177c = "application/binary";

    public StreamBody(InputStream inputStream, int i) {
        this.f58175a = inputStream;
        this.f58176b = i;
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        InputStream inputStream = this.f58175a;
        int i = this.f58176b;
        C21121Util.pump(inputStream, i < 0 ? 2147483647L : (long) i, dataSink, completedCallback);
    }

    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        throw new AssertionError("not implemented");
    }

    public String getContentType() {
        return this.f58177c;
    }

    public StreamBody setContentType(String str) {
        this.f58177c = str;
        return this;
    }

    public boolean readFullyOnRequest() {
        throw new AssertionError("not implemented");
    }

    public int length() {
        return this.f58176b;
    }

    public InputStream get() {
        return this.f58175a;
    }
}
