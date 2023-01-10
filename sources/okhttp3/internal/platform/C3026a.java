package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.C3000Util;

/* renamed from: okhttp3.internal.platform.a */
/* compiled from: Jdk9Platform */
final class C3026a extends Platform {

    /* renamed from: a */
    final Method f7370a;

    /* renamed from: b */
    final Method f7371b;

    C3026a(Method method, Method method2) {
        this.f7370a = method;
        this.f7371b = method2;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> alpnProtocolNames = alpnProtocolNames(list);
            this.f7370a.invoke(sSLParameters, new Object[]{alpnProtocolNames.toArray(new String[alpnProtocolNames.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C3000Util.assertionError("unable to set ssl parameters", e);
        }
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f7371b.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C3000Util.assertionError("unable to get selected protocols", e);
        }
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    /* renamed from: a */
    public static C3026a m6943a() {
        try {
            return new C3026a(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
