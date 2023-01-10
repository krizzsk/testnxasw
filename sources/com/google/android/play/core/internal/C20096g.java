package com.google.android.play.core.internal;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/* renamed from: com.google.android.play.core.internal.g */
final class C20096g extends C20097h {

    /* renamed from: a */
    private final byte[] f56121a;

    public C20096g(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f56121a = bArr;
    }

    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.f56121a;
    }
}
