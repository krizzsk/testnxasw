package com.didi.hawaii.p120ar.utils;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import didinet.RootCAPinningManager;

/* renamed from: com.didi.hawaii.ar.utils.CertificateEncryptionUtils */
public class CertificateEncryptionUtils {

    /* renamed from: a */
    static final String f25565a = "disable_certificate_encryption_toggle";

    public static HttpRpcClient.Builder addSslSocketFactoryForBuilder(HttpRpcClient.Builder builder) {
        RootCAPinningManager instance = RootCAPinningManager.getInstance();
        if (Apollo.getToggle(f25565a).allow()) {
            builder.setSSLSocketFactory(instance.getSystemDefaultSslSocketFactory(), instance.getSystemDefaultTrustManager());
        } else {
            builder.setSSLSocketFactory(instance.getSslSocketFactory(), instance.getX509TrustManager());
        }
        return builder;
    }
}
