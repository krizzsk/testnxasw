package com.didichuxing.foundation.net;

import com.didichuxing.foundation.p188io.Streams;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public abstract class CertificateTransporter implements Transporter {
    public static final String BEGIN_CERTIFICATE = "-----BEGIN CERTIFICATE-----\n";
    public static final String END_CERTIFICATE = "\n-----END CERTIFICATE-----";

    /* renamed from: a */
    private final TrustManager[] f50127a;

    /* renamed from: b */
    private final SSLSocketFactory f50128b;

    public HostnameVerifier getHostnameVerifier() {
        return null;
    }

    /* renamed from: a */
    private static Certificate m37483a(String str, InputStream inputStream) throws CertificateException {
        return CertificateFactory.getInstance(str).generateCertificate(inputStream);
    }

    /* renamed from: a */
    private static Certificate m37482a(String str, File file) throws FileNotFoundException, CertificateException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return m37483a(str, (InputStream) fileInputStream);
        } finally {
            Streams.closeQuietly(fileInputStream);
        }
    }

    /* renamed from: a */
    private static Certificate m37484a(String str, byte[] bArr) throws CertificateException {
        return m37483a(str, (InputStream) new ByteArrayInputStream(bArr));
    }

    protected CertificateTransporter(String str, File file) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {
        this(m37482a(str, file));
    }

    protected CertificateTransporter(String str, byte[] bArr) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {
        this(m37484a(str, bArr));
    }

    protected CertificateTransporter(String str, InputStream inputStream) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        this(m37483a(str, inputStream));
    }

    protected CertificateTransporter(Certificate certificate) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException {
        KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
        instance.load((InputStream) null, (char[]) null);
        instance.setCertificateEntry("ca", certificate);
        TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance2.init(instance);
        this.f50127a = instance2.getTrustManagers();
        SSLContext instance3 = SSLContext.getInstance("TLS");
        instance3.init((KeyManager[]) null, this.f50127a, (SecureRandom) null);
        this.f50128b = instance3.getSocketFactory();
    }

    public SocketFactory getSocketFactory() {
        return SocketFactory.getDefault();
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f50128b;
    }

    public TrustManager getTrustManager() {
        TrustManager[] trustManagerArr = this.f50127a;
        if (trustManagerArr == null || trustManagerArr.length <= 0) {
            return null;
        }
        return trustManagerArr[0];
    }
}
