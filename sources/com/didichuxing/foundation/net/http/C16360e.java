package com.didichuxing.foundation.net.http;

import com.didichuxing.foundation.net.MimeType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.didichuxing.foundation.net.http.e */
/* compiled from: InputStreamMultipartBody */
class C16360e extends C16356a {

    /* renamed from: g */
    private final InputStream f50160g;

    public String getTransferEncoding() {
        return "binary";
    }

    public C16360e(InputStream inputStream) {
        this(inputStream, MimeType.APPLICATION_OCTET_STREAM);
    }

    public C16360e(InputStream inputStream, MimeType mimeType) {
        this(inputStream, mimeType, (String) null);
    }

    public C16360e(InputStream inputStream, MimeType mimeType, String str) {
        super(mimeType, str);
        this.f50160g = inputStream;
    }

    public long getContentLength() {
        try {
            return (long) this.f50160g.available();
        } catch (IOException unused) {
            return -1;
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = this.f50160g.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            } finally {
                this.f50160g.close();
            }
        }
    }

    /* renamed from: a */
    public InputStream mo123719a() {
        return this.f50160g;
    }

    public InputStream getContent() throws IOException {
        return this.f50160g;
    }

    public void close() throws IOException {
        this.f50160g.close();
    }
}
