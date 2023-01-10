package com.didichuxing.foundation.net.http;

import com.didichuxing.foundation.net.MimeType;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* renamed from: com.didichuxing.foundation.net.http.f */
/* compiled from: StringMultipartBody */
class C16361f extends C16357b {
    public String getTransferEncoding() {
        return C16358c.f50155b;
    }

    /* renamed from: a */
    private static byte[] m37500a(String str, MimeType mimeType) {
        Charset charset = mimeType.getCharset();
        if (charset == null) {
            charset = f50157d;
        }
        String name = charset.name();
        try {
            return str.getBytes(name);
        } catch (UnsupportedEncodingException unused) {
            throw new UnsupportedCharsetException(name);
        }
    }

    public C16361f(String str) {
        super(m37500a(str, MimeType.TEXT_PLAIN), MimeType.TEXT_PLAIN, (String) null);
    }

    public C16361f(String str, MimeType mimeType) {
        super(m37500a(str, mimeType), mimeType, (String) null);
    }
}
