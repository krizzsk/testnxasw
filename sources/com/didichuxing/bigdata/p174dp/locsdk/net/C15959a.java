package com.didichuxing.bigdata.p174dp.locsdk.net;

import java.io.ByteArrayInputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.net.a */
/* compiled from: LocationTransporter */
class C15959a {

    /* renamed from: a */
    private final SSLSocketFactory f48658a;

    /* renamed from: b */
    private final C15960b f48659b;

    public C15959a(String str) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        this.f48659b = new C15960b(m36498a(str));
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, new TrustManager[]{this.f48659b}, (SecureRandom) null);
        this.f48658a = instance.getSocketFactory();
    }

    /* renamed from: a */
    private static X509Certificate m36498a(String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        try {
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
            } catch (Throwable unused) {
            }
            return x509Certificate;
        } catch (Exception e) {
            try {
                e.printStackTrace();
                byteArrayInputStream.close();
                return null;
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            return null;
        }
        throw th;
    }

    /* renamed from: a */
    public SSLSocketFactory mo121216a() {
        return this.f48658a;
    }
}
