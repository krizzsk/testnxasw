package didihttp.internal.platform;

import android.os.Build;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import didihttp.Protocol;
import didihttp.internal.C21750Util;
import didihttp.internal.tls.CertificateChainCleaner;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

class AndroidPlatform extends Platform {

    /* renamed from: a */
    private static final int f59640a = 4000;

    /* renamed from: b */
    private final Class<?> f59641b;

    /* renamed from: c */
    private final C21784b<Socket> f59642c;

    /* renamed from: d */
    private final C21784b<Socket> f59643d;

    /* renamed from: e */
    private final C21784b<Socket> f59644e;

    /* renamed from: f */
    private final C21784b<Socket> f59645f;

    /* renamed from: g */
    private final CloseGuard f59646g = CloseGuard.get();

    public AndroidPlatform(Class<?> cls, C21784b<Socket> bVar, C21784b<Socket> bVar2, C21784b<Socket> bVar3, C21784b<Socket> bVar4) {
        this.f59641b = cls;
        this.f59642c = bVar;
        this.f59643d = bVar2;
        this.f59644e = bVar3;
        this.f59645f = bVar4;
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (C21750Util.isAndroidGetsocknameError(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (SecurityException e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e3);
                throw iOException2;
            }
            throw e3;
        }
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Object a = m44947a(sSLSocketFactory, this.f59641b, "sslParameters");
        if (a == null) {
            try {
                a = m44947a(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.trustManager(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) m44947a(a, X509TrustManager.class, "x509TrustManager");
        if (x509TrustManager != null) {
            return x509TrustManager;
        }
        return (X509TrustManager) m44947a(a, X509TrustManager.class, "trustManager");
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f59642c.mo180142b(sSLSocket, true);
            this.f59643d.mo180142b(sSLSocket, str);
        }
        C21784b<Socket> bVar = this.f59645f;
        if (bVar != null && bVar.mo180141a(sSLSocket)) {
            this.f59645f.mo180144d(sSLSocket, m44948a(list));
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        byte[] bArr;
        C21784b<Socket> bVar = this.f59644e;
        if (bVar == null || !bVar.mo180141a(sSLSocket) || (bArr = (byte[]) this.f59644e.mo180144d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, C21750Util.UTF_8);
    }

    public void log(int i, String str, Throwable th) {
        int min;
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            int i4 = indexOf != -1 ? indexOf : length;
            while (true) {
                min = Math.min(i4, i3 + 4000);
                SystemUtils.log(i2, "OkHttp", str.substring(i3, min), (Throwable) null, "didihttp.internal.platform.AndroidPlatform", 152);
                if (min >= i4) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    public Object getStackTraceForCloseable(String str) {
        return this.f59646g.createAndOpen(str);
    }

    public void logCloseableLeak(String str, Object obj) {
        if (!this.f59646g.warnIfOpen(obj)) {
            log(5, str, (Throwable) null);
        }
    }

    public boolean isCleartextTrafficPermitted(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(invoke, new Object[]{str})).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            throw new AssertionError();
        }
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new AndroidCertificateChainCleaner(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return super.buildCertificateChainCleaner(x509TrustManager);
        }
    }

    /* renamed from: a */
    public static Platform m44944a() {
        Class<?> cls;
        C21784b bVar;
        C21784b bVar2;
        Class<byte[]> cls2 = byte[].class;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls3 = cls;
        C21784b bVar3 = new C21784b((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        C21784b bVar4 = new C21784b((Class<?>) null, "setHostname", String.class);
        try {
            Class.forName("android.net.Network");
            bVar2 = new C21784b(cls2, "getAlpnSelectedProtocol", new Class[0]);
            try {
                bVar = new C21784b((Class<?>) null, "setAlpnProtocols", cls2);
            } catch (ClassNotFoundException unused3) {
                bVar = null;
                return new AndroidPlatform(cls3, bVar3, bVar4, bVar2, bVar);
            }
        } catch (ClassNotFoundException unused4) {
            bVar2 = null;
            bVar = null;
            return new AndroidPlatform(cls3, bVar3, bVar4, bVar2, bVar);
        }
        return new AndroidPlatform(cls3, bVar3, bVar4, bVar2, bVar);
    }

    static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
        private final Method checkServerTrusted;
        private final Object x509TrustManagerExtensions;

        public int hashCode() {
            return 0;
        }

        AndroidCertificateChainCleaner(Object obj, Method method) {
            this.x509TrustManagerExtensions = obj;
            this.checkServerTrusted = method;
        }

        public List<Certificate> clean(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof AndroidCertificateChainCleaner;
        }
    }

    static final class CloseGuard {
        private final Method getMethod;
        private final Method openMethod;
        private final Method warnIfOpenMethod;

        CloseGuard(Method method, Method method2, Method method3) {
            this.getMethod = method;
            this.openMethod = method2;
            this.warnIfOpenMethod = method3;
        }

        /* access modifiers changed from: package-private */
        public Object createAndOpen(String str) {
            Method method = this.getMethod;
            if (method != null) {
                try {
                    Object invoke = method.invoke((Object) null, new Object[0]);
                    this.openMethod.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean warnIfOpen(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.warnIfOpenMethod.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        static CloseGuard get() {
            Method method;
            Method method2;
            Method method3;
            Method method4 = null;
            if (Build.VERSION.SDK_INT < 30) {
                try {
                    Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                    method3 = cls.getMethod("get", new Class[0]);
                    try {
                        method = cls.getMethod("open", new Class[]{String.class});
                        try {
                            method4 = cls.getMethod("warnIfOpen", new Class[0]);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        method = null;
                    }
                } catch (Exception unused3) {
                    method3 = null;
                    method = null;
                }
                method2 = method4;
                method4 = method3;
            } else {
                method2 = null;
                method = null;
            }
            return new CloseGuard(method4, method, method2);
        }
    }
}
