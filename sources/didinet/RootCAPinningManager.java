package didinet;

import android.os.Build;
import didihttp.internal.tls.TLSSocketFactory;
import didinet.ApolloAPI;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.Collection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class RootCAPinningManager {

    /* renamed from: e */
    private static final String f59907e = "root_ca_pinning";

    /* renamed from: f */
    private static final String f59908f = "disable_share_same_system_ssl";

    /* renamed from: h */
    private static RootCAPinningManager f59909h = null;

    /* renamed from: i */
    private static final long f59910i = 15552000;

    /* renamed from: j */
    private static final int f59911j = 1000;

    /* renamed from: k */
    private static final int f59912k = 0;

    /* renamed from: a */
    private SSLSocketFactory f59913a;

    /* renamed from: b */
    private X509TrustManager f59914b;

    /* renamed from: c */
    private volatile SSLSocketFactory f59915c;

    /* renamed from: d */
    private volatile X509TrustManager f59916d;

    /* renamed from: g */
    private ApolloAPI f59917g = NetEngine.getInstance().getApolloAPI();

    private RootCAPinningManager() {
        X509TrustManager b = m45081b();
        this.f59914b = b;
        this.f59913a = m45078a(b);
        if (this.f59917g.getToggle(f59907e).allow()) {
            C218071 r0 = new Runnable() {
                public void run() {
                    RootCAPinningManager.this.m45079a();
                }
            };
            if (((Integer) this.f59917g.getToggle(f59907e).getExperiment().getParam("async", 0)).intValue() == 0) {
                new Thread(r0).start();
            } else {
                r0.run();
            }
        }
        int i = ((1615977213 - (System.currentTimeMillis() / 1000)) > f59910i ? 1 : ((1615977213 - (System.currentTimeMillis() / 1000)) == f59910i ? 0 : -1));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45079a() {
        try {
            Collection<? extends Certificate> a = CertificateSource.m45044a();
            if (a != null) {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load((InputStream) null, (char[]) null);
                int i = 0;
                for (Certificate certificateEntry : a) {
                    instance.setCertificateEntry(String.valueOf(i), certificateEntry);
                    i++;
                }
                TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance2.init(instance);
                TrustManager[] trustManagers = instance2.getTrustManagers();
                if (trustManagers != null && trustManagers.length > 0) {
                    this.f59916d = (X509TrustManager) trustManagers[0];
                }
                SSLContext instance3 = SSLContext.getInstance("TLS");
                instance3.init((KeyManager[]) null, new TrustManager[]{this.f59916d}, (SecureRandom) null);
                this.f59915c = m45077a(instance3);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private X509TrustManager m45081b() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private SSLSocketFactory m45078a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return m45077a(instance);
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private SSLSocketFactory m45077a(SSLContext sSLContext) {
        if (Build.VERSION.SDK_INT <= 19) {
            return new TLSSocketFactory(sSLContext);
        }
        return sSLContext.getSocketFactory();
    }

    public static RootCAPinningManager getInstance() {
        if (f59909h == null) {
            synchronized (RootCAPinningManager.class) {
                if (f59909h == null) {
                    f59909h = new RootCAPinningManager();
                }
            }
        }
        return f59909h;
    }

    public SSLSocketFactory getSslSocketFactory() {
        if (this.f59915c == null || this.f59916d == null || !this.f59917g.getToggle(f59907e).allow()) {
            return getSystemDefaultSslSocketFactory();
        }
        return this.f59915c;
    }

    public X509TrustManager getX509TrustManager() {
        if (this.f59915c == null || this.f59916d == null || !this.f59917g.getToggle(f59907e).allow()) {
            return getSystemDefaultTrustManager();
        }
        return this.f59916d;
    }

    public SSLSocketFactory getSystemDefaultSslSocketFactory() {
        if (m45082c()) {
            return this.f59913a;
        }
        return m45078a(m45081b());
    }

    public X509TrustManager getSystemDefaultTrustManager() {
        if (m45082c()) {
            return this.f59914b;
        }
        return m45081b();
    }

    /* renamed from: c */
    private boolean m45082c() {
        int i;
        ApolloAPI.Toggle toggle = this.f59917g.getToggle(f59908f);
        ApolloAPI.Experiment experiment = toggle.getExperiment();
        if (experiment == null) {
            i = -1;
        } else {
            i = ((Integer) experiment.getParam("open_share", 0)).intValue();
        }
        if (!toggle.allow() || i != 1) {
            return false;
        }
        return true;
    }
}
