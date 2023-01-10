package com.didichuxing.bigdata.p174dp.locsdk.net;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.net.b */
/* compiled from: LocationTrustManager */
class C15960b implements X509TrustManager {

    /* renamed from: a */
    X509Certificate f48660a;

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    C15960b(X509Certificate x509Certificate) {
        this.f48660a = x509Certificate;
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr[0].getIssuerX500Principal().equals(this.f48660a.getSubjectX500Principal())) {
            try {
                x509CertificateArr[0].verify(this.f48660a.getPublicKey());
                x509CertificateArr[0].checkValidity();
            } catch (Exception unused) {
                throw new CertificateException("Parent certificate of server was different than expected signing certificate");
            }
        } else {
            throw new CertificateException("Parent certificate of server was different than expected signing certificate");
        }
    }
}
