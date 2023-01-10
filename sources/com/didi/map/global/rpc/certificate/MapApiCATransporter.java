package com.didi.map.global.rpc.certificate;

import com.didichuxing.foundation.net.Transporter;
import didinet.RootCAPinningManager;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class MapApiCATransporter implements Transporter {
    /* renamed from: a */
    private boolean m23131a() {
        return false;
    }

    public HostnameVerifier getHostnameVerifier() {
        return null;
    }

    public SocketFactory getSocketFactory() {
        return SocketFactory.getDefault();
    }

    public SSLSocketFactory getSslSocketFactory() {
        if (!m23131a()) {
            return RootCAPinningManager.getInstance().getSslSocketFactory();
        }
        return RootCAPinningManager.getInstance().getSystemDefaultSslSocketFactory();
    }

    public TrustManager getTrustManager() {
        if (!m23131a()) {
            return RootCAPinningManager.getInstance().getX509TrustManager();
        }
        return RootCAPinningManager.getInstance().getSystemDefaultTrustManager();
    }
}
