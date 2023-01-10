package com.koushikdutta.async.http.body;

import android.text.TextUtils;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.C21121Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ContinuationCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Continuation;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.server.BoundaryEmitter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

public class MultipartFormDataBody extends BoundaryEmitter implements AsyncHttpRequestBody<Multimap> {
    public static final String CONTENT_TYPE = "multipart/form-data";
    public static final String PRIMARY_TYPE = "multipart/";

    /* renamed from: a */
    LineEmitter f58162a;

    /* renamed from: b */
    Headers f58163b;

    /* renamed from: c */
    ByteBufferList f58164c;

    /* renamed from: d */
    Part f58165d;

    /* renamed from: e */
    String f58166e = "multipart/form-data";

    /* renamed from: f */
    MultipartCallback f58167f;

    /* renamed from: g */
    int f58168g;

    /* renamed from: h */
    int f58169h;

    /* renamed from: k */
    private ArrayList<Part> f58170k;

    public interface MultipartCallback {
        void onPart(Part part);
    }

    public boolean readFullyOnRequest() {
        return false;
    }

    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        setDataEmitter(dataEmitter);
        setEndCallback(completedCallback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo173557a() {
        if (this.f58164c != null) {
            if (this.f58163b == null) {
                this.f58163b = new Headers();
            }
            String peekString = this.f58164c.peekString();
            String name = TextUtils.isEmpty(this.f58165d.getName()) ? "unnamed" : this.f58165d.getName();
            StringPart stringPart = new StringPart(name, peekString);
            stringPart.f58173b = this.f58165d.f58173b;
            addPart(stringPart);
            this.f58163b.add(name, peekString);
            this.f58165d = null;
            this.f58164c = null;
        }
    }

    public String getField(String str) {
        Headers headers = this.f58163b;
        if (headers == null) {
            return null;
        }
        return headers.get(str);
    }

    /* access modifiers changed from: protected */
    public void onBoundaryEnd() {
        super.onBoundaryEnd();
        mo173557a();
    }

    /* access modifiers changed from: protected */
    public void onBoundaryStart() {
        final Headers headers = new Headers();
        LineEmitter lineEmitter = new LineEmitter();
        this.f58162a = lineEmitter;
        lineEmitter.setLineCallback(new LineEmitter.StringCallback() {
            public void onStringAvailable(String str) {
                if (!StringUtils.f7475CR.equals(str)) {
                    headers.addLine(str);
                    return;
                }
                MultipartFormDataBody.this.mo173557a();
                MultipartFormDataBody.this.f58162a = null;
                MultipartFormDataBody.this.setDataCallback((DataCallback) null);
                Part part = new Part(headers);
                if (MultipartFormDataBody.this.f58167f != null) {
                    MultipartFormDataBody.this.f58167f.onPart(part);
                }
                if (MultipartFormDataBody.this.getDataCallback() == null) {
                    MultipartFormDataBody.this.f58165d = part;
                    MultipartFormDataBody.this.f58164c = new ByteBufferList();
                    MultipartFormDataBody.this.setDataCallback(new DataCallback() {
                        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                            byteBufferList.get(MultipartFormDataBody.this.f58164c);
                        }
                    });
                }
            }
        });
        setDataCallback(this.f58162a);
    }

    public MultipartFormDataBody(String str) {
        String string = Multimap.parseSemicolonDelimited(str).getString("boundary");
        if (string == null) {
            report(new Exception("No boundary found for multipart/form-data"));
        } else {
            setBoundary(string);
        }
    }

    public void setMultipartCallback(MultipartCallback multipartCallback) {
        this.f58167f = multipartCallback;
    }

    public MultipartCallback getMultipartCallback() {
        return this.f58167f;
    }

    public void write(AsyncHttpRequest asyncHttpRequest, final DataSink dataSink, final CompletedCallback completedCallback) {
        if (this.f58170k != null) {
            Continuation continuation = new Continuation(new CompletedCallback() {
                public void onCompleted(Exception exc) {
                    completedCallback.onCompleted(exc);
                }
            });
            Iterator<Part> it = this.f58170k.iterator();
            while (it.hasNext()) {
                final Part next = it.next();
                continuation.add((ContinuationCallback) new ContinuationCallback() {
                    public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
                        byte[] bytes = next.getRawHeaders().toPrefixString(MultipartFormDataBody.this.getBoundaryStart()).getBytes();
                        C21121Util.writeAll(dataSink, bytes, completedCallback);
                        MultipartFormDataBody.this.f58168g += bytes.length;
                    }
                }).add((ContinuationCallback) new ContinuationCallback() {
                    public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
                        long length = next.length();
                        if (length >= 0) {
                            MultipartFormDataBody multipartFormDataBody = MultipartFormDataBody.this;
                            multipartFormDataBody.f58168g = (int) (((long) multipartFormDataBody.f58168g) + length);
                        }
                        next.write(dataSink, completedCallback);
                    }
                }).add((ContinuationCallback) new ContinuationCallback() {
                    public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
                        byte[] bytes = "\r\n".getBytes();
                        C21121Util.writeAll(dataSink, bytes, completedCallback);
                        MultipartFormDataBody.this.f58168g += bytes.length;
                    }
                });
            }
            continuation.add((ContinuationCallback) new ContinuationCallback() {
                static final /* synthetic */ boolean $assertionsDisabled = false;

                static {
                    Class<MultipartFormDataBody> cls = MultipartFormDataBody.class;
                }

                public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
                    byte[] bytes = MultipartFormDataBody.this.getBoundaryEnd().getBytes();
                    C21121Util.writeAll(dataSink, bytes, completedCallback);
                    MultipartFormDataBody.this.f58168g += bytes.length;
                }
            });
            continuation.start();
        }
    }

    public String getContentType() {
        if (getBoundary() == null) {
            setBoundary("----------------------------" + UUID.randomUUID().toString().replace("-", ""));
        }
        return this.f58166e + "; boundary=" + getBoundary();
    }

    public int length() {
        if (getBoundary() == null) {
            setBoundary("----------------------------" + UUID.randomUUID().toString().replace("-", ""));
        }
        int i = 0;
        Iterator<Part> it = this.f58170k.iterator();
        while (it.hasNext()) {
            Part next = it.next();
            String prefixString = next.getRawHeaders().toPrefixString(getBoundaryStart());
            if (next.length() == -1) {
                return -1;
            }
            i = (int) (((long) i) + next.length() + ((long) prefixString.getBytes().length) + ((long) 2));
        }
        int length = i + getBoundaryEnd().getBytes().length;
        this.f58169h = length;
        return length;
    }

    public MultipartFormDataBody() {
    }

    public void setContentType(String str) {
        this.f58166e = str;
    }

    public List<Part> getParts() {
        if (this.f58170k == null) {
            return null;
        }
        return new ArrayList(this.f58170k);
    }

    public void addFilePart(String str, File file) {
        addPart(new FilePart(str, file));
    }

    public void addStringPart(String str, String str2) {
        addPart(new StringPart(str, str2));
    }

    public void addPart(Part part) {
        if (this.f58170k == null) {
            this.f58170k = new ArrayList<>();
        }
        this.f58170k.add(part);
    }

    public Multimap get() {
        return new Multimap(this.f58163b.getMultiMap());
    }

    public String toString() {
        Iterator<Part> it = getParts().iterator();
        return it.hasNext() ? it.next().toString() : "multipart content is empty";
    }
}
