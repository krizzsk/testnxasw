package com.koushikdutta.async.http.body;

import com.koushikdutta.async.C21121Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.DocumentParser;
import com.koushikdutta.async.util.Charsets;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

public class DocumentBody implements AsyncHttpRequestBody<Document> {
    public static final String CONTENT_TYPE = "application/xml";

    /* renamed from: a */
    ByteArrayOutputStream f58153a;

    /* renamed from: b */
    Document f58154b;

    public String getContentType() {
        return CONTENT_TYPE;
    }

    public boolean readFullyOnRequest() {
        return true;
    }

    public DocumentBody() {
        this((Document) null);
    }

    public DocumentBody(Document document) {
        this.f58154b = document;
    }

    /* renamed from: a */
    private void m44064a() {
        if (this.f58153a == null) {
            try {
                DOMSource dOMSource = new DOMSource(this.f58154b);
                Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
                this.f58153a = new ByteArrayOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f58153a, Charsets.UTF_8);
                newTransformer.transform(dOMSource, new StreamResult(outputStreamWriter));
                outputStreamWriter.flush();
            } catch (Exception unused) {
            }
        }
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        m44064a();
        C21121Util.writeAll(dataSink, this.f58153a.toByteArray(), completedCallback);
    }

    public void parse(DataEmitter dataEmitter, final CompletedCallback completedCallback) {
        new DocumentParser().parse(dataEmitter).setCallback(new FutureCallback<Document>() {
            public void onCompleted(Exception exc, Document document) {
                DocumentBody.this.f58154b = document;
                completedCallback.onCompleted(exc);
            }
        });
    }

    public int length() {
        m44064a();
        return this.f58153a.size();
    }

    public Document get() {
        return this.f58154b;
    }
}
