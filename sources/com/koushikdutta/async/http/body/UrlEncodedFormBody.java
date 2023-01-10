package com.koushikdutta.async.http.body;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.C21121Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.NameValuePair;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;

public class UrlEncodedFormBody implements AsyncHttpRequestBody<Multimap> {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Multimap f58181a;

    /* renamed from: b */
    private byte[] f58182b;

    public String getContentType() {
        return "application/x-www-form-urlencoded; charset=utf-8";
    }

    public boolean readFullyOnRequest() {
        return true;
    }

    public UrlEncodedFormBody(Multimap multimap) {
        this.f58181a = multimap;
    }

    public UrlEncodedFormBody(List<NameValuePair> list) {
        this.f58181a = new Multimap(list);
    }

    /* renamed from: a */
    private void m44067a() {
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<NameValuePair> it = this.f58181a.iterator();
            boolean z = true;
            while (it.hasNext()) {
                NameValuePair next = it.next();
                if (next.getValue() != null) {
                    if (!z) {
                        sb.append(Typography.amp);
                    }
                    z = false;
                    sb.append(URLEncoder.encode(next.getName(), "UTF-8"));
                    sb.append('=');
                    sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
                }
            }
            this.f58182b = sb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        if (this.f58182b == null) {
            m44067a();
        }
        C21121Util.writeAll(dataSink, this.f58182b, completedCallback);
    }

    public void parse(DataEmitter dataEmitter, final CompletedCallback completedCallback) {
        final ByteBufferList byteBufferList = new ByteBufferList();
        dataEmitter.setDataCallback(new DataCallback() {
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                byteBufferList.get(byteBufferList);
            }
        });
        dataEmitter.setEndCallback(new CompletedCallback() {
            public void onCompleted(Exception exc) {
                if (exc == null) {
                    try {
                        Multimap unused = UrlEncodedFormBody.this.f58181a = Multimap.parseUrlEncoded(byteBufferList.readString());
                        completedCallback.onCompleted((Exception) null);
                    } catch (Exception e) {
                        completedCallback.onCompleted(e);
                    }
                } else {
                    throw exc;
                }
            }
        });
    }

    public UrlEncodedFormBody() {
    }

    public int length() {
        if (this.f58182b == null) {
            m44067a();
        }
        return this.f58182b.length;
    }

    public Multimap get() {
        return this.f58181a;
    }
}
