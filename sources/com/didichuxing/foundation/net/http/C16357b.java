package com.didichuxing.foundation.net.http;

import com.didichuxing.foundation.net.MimeType;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.didichuxing.foundation.net.http.b */
/* compiled from: ByteArrayMultipartBody */
class C16357b extends C16356a {

    /* renamed from: g */
    private final byte[] f50153g;

    public void close() throws IOException {
    }

    public String getTransferEncoding() {
        return "binary";
    }

    public C16357b(byte[] bArr) {
        this(bArr, MimeType.APPLICATION_OCTET_STREAM);
    }

    public C16357b(byte[] bArr, MimeType mimeType) {
        this(bArr, mimeType, (String) null);
    }

    public C16357b(byte[] bArr, MimeType mimeType, String str) {
        super(mimeType, str);
        this.f50153g = bArr;
    }

    public C16357b(byte[] bArr, String str) {
        this(bArr, MimeType.APPLICATION_OCTET_STREAM, str);
    }

    public long getContentLength() {
        return (long) this.f50153g.length;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.f50153g);
    }

    public InputStream getContent() throws IOException {
        return new ByteArrayInputStream(this.f50153g);
    }
}
