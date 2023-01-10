package com.koushikdutta.async.http.body;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.C21121Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.ByteBufferListParser;

public class ByteBufferListRequestBody implements AsyncHttpRequestBody<ByteBufferList> {
    public static String CONTENT_TYPE = "application/binary";

    /* renamed from: a */
    ByteBufferList f58152a;

    public boolean readFullyOnRequest() {
        return true;
    }

    public ByteBufferListRequestBody() {
    }

    public ByteBufferListRequestBody(ByteBufferList byteBufferList) {
        this.f58152a = byteBufferList;
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        C21121Util.writeAll(dataSink, this.f58152a, completedCallback);
    }

    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        new ByteBufferListParser().parse(dataEmitter).setCallback(new FutureCallback(completedCallback) {
            public final /* synthetic */ CompletedCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void onCompleted(Exception exc, Object obj) {
                ByteBufferListRequestBody.this.m44063a(this.f$1, exc, (ByteBufferList) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m44063a(CompletedCallback completedCallback, Exception exc, ByteBufferList byteBufferList) {
        this.f58152a = byteBufferList;
        completedCallback.onCompleted(exc);
    }

    public String getContentType() {
        return CONTENT_TYPE;
    }

    public int length() {
        return this.f58152a.remaining();
    }

    public ByteBufferList get() {
        return this.f58152a;
    }
}
