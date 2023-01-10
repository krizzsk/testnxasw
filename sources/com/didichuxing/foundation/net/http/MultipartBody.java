package com.didichuxing.foundation.net.http;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.p188io.CountingOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MultipartBody extends HttpBody {

    /* renamed from: a */
    private static final String f50140a = "--";

    /* renamed from: b */
    private static final String f50141b = "\r\n";

    /* renamed from: c */
    private static final char[] f50142c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: d */
    private static final String f50143d = "Content-Disposition";

    /* renamed from: e */
    private static final String f50144e = "Content-Type";

    /* renamed from: f */
    private static final String f50145f = "Content-Transfer-Encoding";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Charset f50146g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final String f50147h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final List<Part> f50148i;

    /* renamed from: j */
    private long f50149j;

    public void close() throws IOException {
    }

    /* renamed from: a */
    static String m37492a() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            char[] cArr = f50142c;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static byte[] m37496a(Charset charset, String str) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        int remaining = encode.remaining();
        byte[] bArr = new byte[remaining];
        System.arraycopy(encode.array(), 0, bArr, 0, remaining);
        return bArr;
    }

    /* renamed from: a */
    private static void m37495a(byte[] bArr, OutputStream outputStream) throws IOException {
        outputStream.write(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    private static void m37494a(String str, OutputStream outputStream) throws IOException {
        outputStream.write(m37496a(C16358c.f50157d, str));
    }

    private MultipartBody(Builder builder) {
        this.f50149j = -1;
        this.f50147h = builder.mBoundary != null ? builder.mBoundary : m37492a();
        this.f50146g = builder.mCharset != null ? builder.mCharset : C16358c.f50158e;
        this.f50148i = Collections.unmodifiableList(builder.mParts);
    }

    public String getBoundary() {
        return this.f50147h;
    }

    public Charset getCharset() {
        return this.f50146g;
    }

    public List<Part> getParts() {
        return this.f50148i;
    }

    public MimeType getContentType() {
        StringBuilder sb = new StringBuilder();
        sb.append("multipart/form-data; boundary=");
        sb.append(this.f50147h);
        if (this.f50146g != null) {
            sb.append("; charset=");
            sb.append(this.f50146g.name());
        }
        return MimeType.parse(sb.toString());
    }

    public InputStream getContent() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeTo(byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public long getContentLength() throws IOException {
        long j = this.f50149j;
        if (-1 != j) {
            return j;
        }
        CountingOutputStream countingOutputStream = new CountingOutputStream(new OutputStream() {
            public void write(int i) throws IOException {
            }
        });
        writeTo(countingOutputStream);
        long bytesWritten = countingOutputStream.getBytesWritten();
        this.f50149j = bytesWritten;
        return bytesWritten;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        m37491a(outputStream);
    }

    /* renamed from: a */
    private long m37491a(OutputStream outputStream) throws IOException {
        byte[] a = m37496a(this.f50146g, this.f50147h);
        CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
        for (Part next : this.f50148i) {
            m37494a(f50140a, (OutputStream) countingOutputStream);
            m37495a(a, (OutputStream) countingOutputStream);
            m37494a("\r\n", (OutputStream) countingOutputStream);
            for (HttpHeader obj : next.getHeaders()) {
                m37494a(obj.toString(), (OutputStream) countingOutputStream);
                m37494a("\r\n", (OutputStream) countingOutputStream);
            }
            long contentLength = next.getBody().getContentLength();
            if (-1 != contentLength) {
                m37494a("Content-Length: " + contentLength, (OutputStream) countingOutputStream);
                m37494a("\r\n", (OutputStream) countingOutputStream);
            }
            m37494a("\r\n", (OutputStream) countingOutputStream);
            next.getBody().writeTo(countingOutputStream);
            m37494a("\r\n", (OutputStream) countingOutputStream);
        }
        m37494a(f50140a, (OutputStream) countingOutputStream);
        m37495a(a, (OutputStream) countingOutputStream);
        m37494a(f50140a, (OutputStream) countingOutputStream);
        m37494a("\r\n", (OutputStream) countingOutputStream);
        return countingOutputStream.getBytesWritten();
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String mBoundary;
        /* access modifiers changed from: private */
        public Charset mCharset;
        /* access modifiers changed from: private */
        public final List<Part> mParts;

        public Builder() {
            this.mCharset = C16358c.f50158e;
            this.mBoundary = MultipartBody.m37492a();
            this.mParts = new ArrayList();
        }

        private Builder(MultipartBody multipartBody) {
            this.mCharset = C16358c.f50158e;
            this.mBoundary = MultipartBody.m37492a();
            this.mParts = new ArrayList();
            this.mCharset = multipartBody.f50146g;
            this.mBoundary = multipartBody.f50147h;
            this.mParts.addAll(multipartBody.f50148i);
        }

        public Charset getCharset() {
            return this.mCharset;
        }

        public Builder setCharset(Charset charset) {
            this.mCharset = charset;
            return this;
        }

        public String getBoundary() {
            return this.mBoundary;
        }

        public Builder setBoundary(String str) {
            this.mBoundary = str;
            return this;
        }

        public Builder addPart(Part part) {
            this.mParts.add(part);
            return this;
        }

        public Builder addPart(String str, MultipartEntity multipartEntity) {
            return addPart(new Part(str, multipartEntity, new HttpHeader[0]));
        }

        public Builder addPart(String str, byte[] bArr) {
            return addPart(str, (MultipartEntity) new C16357b(bArr));
        }

        public Builder addPart(String str, byte[] bArr, MimeType mimeType) {
            return addPart(str, (MultipartEntity) new C16357b(bArr, mimeType));
        }

        public Builder addPart(String str, File file) {
            return addPart(str, (MultipartEntity) new C16359d(file));
        }

        public Builder addPart(String str, File file, MimeType mimeType) {
            return addPart(str, (MultipartEntity) new C16359d(file, mimeType));
        }

        public Builder addPart(String str, InputStream inputStream) {
            return addPart(str, (MultipartEntity) new C16360e(inputStream));
        }

        public Builder addPart(String str, InputStream inputStream, MimeType mimeType) {
            return addPart(str, (MultipartEntity) new C16360e(inputStream, mimeType));
        }

        public Builder addPart(String str, Object obj) {
            return addPart(str, (MultipartEntity) new C16361f(String.valueOf(obj)));
        }

        public Builder addPart(String str, Object obj, MimeType mimeType) {
            return addPart(str, (MultipartEntity) new C16361f(String.valueOf(obj), mimeType));
        }

        public MultipartBody build() {
            return new MultipartBody(this);
        }
    }

    public static class Part {
        private final MultipartEntity mBody;
        private final List<HttpHeader> mHeaders;
        private final String mName;

        public Part(String str, MultipartEntity multipartEntity, HttpHeader... httpHeaderArr) {
            this.mName = str;
            this.mBody = multipartEntity;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SimpleHttpHeader("Content-Disposition", generateContentDisposition(multipartEntity)));
            arrayList.add(new SimpleHttpHeader("Content-Type", multipartEntity.getContentType().toString()));
            arrayList.add(new SimpleHttpHeader("Content-Transfer-Encoding", multipartEntity.getTransferEncoding()));
            if (httpHeaderArr != null && httpHeaderArr.length > 0) {
                for (HttpHeader add : httpHeaderArr) {
                    arrayList.add(add);
                }
            }
            this.mHeaders = Collections.unmodifiableList(arrayList);
        }

        public String getName() {
            return this.mName;
        }

        public List<HttpHeader> getHeaders() {
            return this.mHeaders;
        }

        public MultipartEntity getBody() {
            return this.mBody;
        }

        /* access modifiers changed from: protected */
        public String generateContentDisposition(MultipartEntity multipartEntity) {
            StringBuilder sb = new StringBuilder();
            sb.append("form-data; name=\"");
            sb.append(getName());
            sb.append(Const.jsQuote);
            String filename = multipartEntity.getFilename();
            if (filename != null) {
                sb.append("; filename=\"");
                sb.append(filename);
                sb.append(Const.jsQuote);
            }
            return sb.toString();
        }
    }
}
