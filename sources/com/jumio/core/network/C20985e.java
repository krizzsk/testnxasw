package com.jumio.core.network;

import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: com.jumio.core.network.e */
/* compiled from: TLSSocketFactory */
public class C20985e extends SSLSocketFactory {

    /* renamed from: a */
    public final SSLSocketFactory f57761a;

    public C20985e(TrustManager[] trustManagerArr) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sSLContext;
        if (Build.VERSION.SDK_INT >= 16) {
            sSLContext = SSLContext.getInstance("TLSv1.2");
        } else {
            sSLContext = SSLContext.getInstance("TLS");
        }
        sSLContext.init((KeyManager[]) null, trustManagerArr, (SecureRandom) null);
        this.f57761a = sSLContext.getSocketFactory();
    }

    /* renamed from: a */
    public final Socket mo172402a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
        }
        return socket;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return mo172402a(this.f57761a.createSocket(socket, str, i, z));
    }

    public String[] getDefaultCipherSuites() {
        return this.f57761a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f57761a.getSupportedCipherSuites();
    }

    public Socket createSocket(String str, int i) throws IOException {
        return mo172402a(this.f57761a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return mo172402a(this.f57761a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return mo172402a(this.f57761a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return mo172402a(this.f57761a.createSocket(inetAddress, i, inetAddress2, i2));
    }
}
