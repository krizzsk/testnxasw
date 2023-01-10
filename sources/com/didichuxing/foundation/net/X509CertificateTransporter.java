package com.didichuxing.foundation.net;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class X509CertificateTransporter extends CertificateTransporter {

    /* renamed from: a */
    private static final String f50137a = "X.509";

    public X509CertificateTransporter(File file) throws CertificateException, NoSuchAlgorithmException, KeyManagementException, KeyStoreException, IOException {
        super(f50137a, file);
    }

    public X509CertificateTransporter(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, KeyManagementException, KeyStoreException, IOException {
        super(f50137a, bArr);
    }

    public X509CertificateTransporter(InputStream inputStream) throws CertificateException, NoSuchAlgorithmException, KeyManagementException, KeyStoreException, IOException {
        super(f50137a, inputStream);
    }
}
