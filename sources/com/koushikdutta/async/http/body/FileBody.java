package com.koushikdutta.async.http.body;

import com.koushikdutta.async.C21121Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import java.io.File;

public class FileBody implements AsyncHttpRequestBody<File> {
    public static final String CONTENT_TYPE = "application/binary";

    /* renamed from: a */
    File f58155a;

    /* renamed from: b */
    String f58156b = "application/binary";

    public FileBody(File file) {
        this.f58155a = file;
    }

    public FileBody(File file, String str) {
        this.f58155a = file;
        this.f58156b = str;
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        C21121Util.pump(this.f58155a, dataSink, completedCallback);
    }

    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        throw new AssertionError("not implemented");
    }

    public String getContentType() {
        return this.f58156b;
    }

    public void setContentType(String str) {
        this.f58156b = str;
    }

    public boolean readFullyOnRequest() {
        throw new AssertionError("not implemented");
    }

    public int length() {
        return (int) this.f58155a.length();
    }

    public File get() {
        return this.f58155a;
    }
}
