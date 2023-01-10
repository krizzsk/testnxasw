package com.koushikdutta.async.http.body;

import com.koushikdutta.async.C21121Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.JSONArrayParser;
import org.json.JSONArray;

public class JSONArrayBody implements AsyncHttpRequestBody<JSONArray> {
    public static final String CONTENT_TYPE = "application/json";

    /* renamed from: a */
    byte[] f58158a;

    /* renamed from: b */
    JSONArray f58159b;

    public String getContentType() {
        return "application/json";
    }

    public boolean readFullyOnRequest() {
        return true;
    }

    public JSONArrayBody() {
    }

    public JSONArrayBody(JSONArray jSONArray) {
        this();
        this.f58159b = jSONArray;
    }

    public void parse(DataEmitter dataEmitter, final CompletedCallback completedCallback) {
        new JSONArrayParser().parse(dataEmitter).setCallback(new FutureCallback<JSONArray>() {
            public void onCompleted(Exception exc, JSONArray jSONArray) {
                JSONArrayBody.this.f58159b = jSONArray;
                completedCallback.onCompleted(exc);
            }
        });
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        C21121Util.writeAll(dataSink, this.f58158a, completedCallback);
    }

    public int length() {
        byte[] bytes = this.f58159b.toString().getBytes();
        this.f58158a = bytes;
        return bytes.length;
    }

    public JSONArray get() {
        return this.f58159b;
    }
}
