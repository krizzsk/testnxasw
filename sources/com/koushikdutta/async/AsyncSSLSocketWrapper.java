package com.koushikdutta.async;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.Pair;
import com.koushikdutta.async.AsyncSSLSocketWrapper;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.ListenCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.SimpleCancellable;
import com.koushikdutta.async.http.SSLEngineSNIConfigurator;
import com.koushikdutta.async.util.Allocator;
import com.koushikdutta.async.util.StreamUtility;
import com.koushikdutta.async.wrapper.AsyncSocketWrapper;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.math.BigInteger;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.Date;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

public class AsyncSSLSocketWrapper implements AsyncSSLSocket, AsyncSocketWrapper {

    /* renamed from: a */
    static SSLContext f57995a = null;

    /* renamed from: b */
    static SSLContext f57996b = null;

    /* renamed from: c */
    static TrustManager[] f57997c = null;

    /* renamed from: d */
    static HostnameVerifier f57998d = null;

    /* renamed from: w */
    static final /* synthetic */ boolean f57999w = (!AsyncSSLSocketWrapper.class.desiredAssertionStatus());

    /* renamed from: x */
    private static final String f58000x = "AsyncSSLSocketWrapper";

    /* renamed from: A */
    private boolean f58001A;

    /* renamed from: e */
    AsyncSocket f58002e;

    /* renamed from: f */
    BufferedDataSink f58003f;

    /* renamed from: g */
    boolean f58004g;

    /* renamed from: h */
    SSLEngine f58005h;

    /* renamed from: i */
    boolean f58006i;

    /* renamed from: j */
    HostnameVerifier f58007j;

    /* renamed from: k */
    HandshakeCallback f58008k;

    /* renamed from: l */
    X509Certificate[] f58009l;

    /* renamed from: m */
    WritableCallback f58010m;

    /* renamed from: n */
    DataCallback f58011n;

    /* renamed from: o */
    TrustManager[] f58012o;

    /* renamed from: p */
    boolean f58013p;

    /* renamed from: q */
    boolean f58014q;

    /* renamed from: r */
    Exception f58015r;

    /* renamed from: s */
    final ByteBufferList f58016s = new ByteBufferList();

    /* renamed from: t */
    final DataCallback f58017t = new DataCallback() {
        final Allocator allocator = new Allocator().setMinAlloc(8192);
        final ByteBufferList buffered = new ByteBufferList();

        /* JADX WARNING: Removed duplicated region for block: B:38:0x0027 A[LOOP:0: B:9:0x0027->B:38:0x0027, LOOP_END, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00c2 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onDataAvailable(com.koushikdutta.async.DataEmitter r8, com.koushikdutta.async.ByteBufferList r9) {
            /*
                r7 = this;
                com.koushikdutta.async.AsyncSSLSocketWrapper r8 = com.koushikdutta.async.AsyncSSLSocketWrapper.this
                boolean r8 = r8.f58004g
                if (r8 == 0) goto L_0x0007
                return
            L_0x0007:
                r8 = 0
                com.koushikdutta.async.AsyncSSLSocketWrapper r0 = com.koushikdutta.async.AsyncSSLSocketWrapper.this     // Catch:{ SSLException -> 0x00cf }
                r1 = 1
                r0.f58004g = r1     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.ByteBufferList r0 = r7.buffered     // Catch:{ SSLException -> 0x00cf }
                r9.get((com.koushikdutta.async.ByteBufferList) r0)     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.ByteBufferList r9 = r7.buffered     // Catch:{ SSLException -> 0x00cf }
                boolean r9 = r9.hasRemaining()     // Catch:{ SSLException -> 0x00cf }
                if (r9 == 0) goto L_0x0025
                com.koushikdutta.async.ByteBufferList r9 = r7.buffered     // Catch:{ SSLException -> 0x00cf }
                java.nio.ByteBuffer r9 = r9.getAll()     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.ByteBufferList r0 = r7.buffered     // Catch:{ SSLException -> 0x00cf }
                r0.add((java.nio.ByteBuffer) r9)     // Catch:{ SSLException -> 0x00cf }
            L_0x0025:
                java.nio.ByteBuffer r9 = com.koushikdutta.async.ByteBufferList.EMPTY_BYTEBUFFER     // Catch:{ SSLException -> 0x00cf }
            L_0x0027:
                int r0 = r9.remaining()     // Catch:{ SSLException -> 0x00cf }
                if (r0 != 0) goto L_0x003b
                com.koushikdutta.async.ByteBufferList r0 = r7.buffered     // Catch:{ SSLException -> 0x00cf }
                int r0 = r0.size()     // Catch:{ SSLException -> 0x00cf }
                if (r0 <= 0) goto L_0x003b
                com.koushikdutta.async.ByteBufferList r9 = r7.buffered     // Catch:{ SSLException -> 0x00cf }
                java.nio.ByteBuffer r9 = r9.remove()     // Catch:{ SSLException -> 0x00cf }
            L_0x003b:
                int r0 = r9.remaining()     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.AsyncSSLSocketWrapper r2 = com.koushikdutta.async.AsyncSSLSocketWrapper.this     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.ByteBufferList r2 = r2.f58016s     // Catch:{ SSLException -> 0x00cf }
                int r2 = r2.remaining()     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.util.Allocator r3 = r7.allocator     // Catch:{ SSLException -> 0x00cf }
                java.nio.ByteBuffer r3 = r3.allocate()     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.AsyncSSLSocketWrapper r4 = com.koushikdutta.async.AsyncSSLSocketWrapper.this     // Catch:{ SSLException -> 0x00cf }
                javax.net.ssl.SSLEngine r4 = r4.f58005h     // Catch:{ SSLException -> 0x00cf }
                javax.net.ssl.SSLEngineResult r4 = r4.unwrap(r9, r3)     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.AsyncSSLSocketWrapper r5 = com.koushikdutta.async.AsyncSSLSocketWrapper.this     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.AsyncSSLSocketWrapper r6 = com.koushikdutta.async.AsyncSSLSocketWrapper.this     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.ByteBufferList r6 = r6.f58016s     // Catch:{ SSLException -> 0x00cf }
                r5.mo173059a((com.koushikdutta.async.ByteBufferList) r6, (java.nio.ByteBuffer) r3)     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.util.Allocator r3 = r7.allocator     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.AsyncSSLSocketWrapper r5 = com.koushikdutta.async.AsyncSSLSocketWrapper.this     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.ByteBufferList r5 = r5.f58016s     // Catch:{ SSLException -> 0x00cf }
                int r5 = r5.remaining()     // Catch:{ SSLException -> 0x00cf }
                int r5 = r5 - r2
                long r5 = (long) r5     // Catch:{ SSLException -> 0x00cf }
                r3.track(r5)     // Catch:{ SSLException -> 0x00cf }
                javax.net.ssl.SSLEngineResult$Status r3 = r4.getStatus()     // Catch:{ SSLException -> 0x00cf }
                javax.net.ssl.SSLEngineResult$Status r5 = javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW     // Catch:{ SSLException -> 0x00cf }
                r6 = -1
                if (r3 != r5) goto L_0x0085
                com.koushikdutta.async.util.Allocator r0 = r7.allocator     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.util.Allocator r3 = r7.allocator     // Catch:{ SSLException -> 0x00cf }
                int r3 = r3.getMinAlloc()     // Catch:{ SSLException -> 0x00cf }
                int r3 = r3 * 2
                r0.setMinAlloc(r3)     // Catch:{ SSLException -> 0x00cf }
            L_0x0083:
                r0 = -1
                goto L_0x00a9
            L_0x0085:
                javax.net.ssl.SSLEngineResult$Status r3 = r4.getStatus()     // Catch:{ SSLException -> 0x00cf }
                javax.net.ssl.SSLEngineResult$Status r5 = javax.net.ssl.SSLEngineResult.Status.BUFFER_UNDERFLOW     // Catch:{ SSLException -> 0x00cf }
                if (r3 != r5) goto L_0x00a9
                com.koushikdutta.async.ByteBufferList r0 = r7.buffered     // Catch:{ SSLException -> 0x00cf }
                r0.addFirst(r9)     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.ByteBufferList r9 = r7.buffered     // Catch:{ SSLException -> 0x00cf }
                int r9 = r9.size()     // Catch:{ SSLException -> 0x00cf }
                if (r9 > r1) goto L_0x009b
                goto L_0x00c7
            L_0x009b:
                com.koushikdutta.async.ByteBufferList r9 = r7.buffered     // Catch:{ SSLException -> 0x00cf }
                java.nio.ByteBuffer r9 = r9.getAll()     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.ByteBufferList r0 = r7.buffered     // Catch:{ SSLException -> 0x00cf }
                r0.addFirst(r9)     // Catch:{ SSLException -> 0x00cf }
                java.nio.ByteBuffer r9 = com.koushikdutta.async.ByteBufferList.EMPTY_BYTEBUFFER     // Catch:{ SSLException -> 0x00cf }
                goto L_0x0083
            L_0x00a9:
                com.koushikdutta.async.AsyncSSLSocketWrapper r3 = com.koushikdutta.async.AsyncSSLSocketWrapper.this     // Catch:{ SSLException -> 0x00cf }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = r4.getHandshakeStatus()     // Catch:{ SSLException -> 0x00cf }
                r3.m43884a((javax.net.ssl.SSLEngineResult.HandshakeStatus) r4)     // Catch:{ SSLException -> 0x00cf }
                int r3 = r9.remaining()     // Catch:{ SSLException -> 0x00cf }
                if (r3 != r0) goto L_0x0027
                com.koushikdutta.async.AsyncSSLSocketWrapper r0 = com.koushikdutta.async.AsyncSSLSocketWrapper.this     // Catch:{ SSLException -> 0x00cf }
                com.koushikdutta.async.ByteBufferList r0 = r0.f58016s     // Catch:{ SSLException -> 0x00cf }
                int r0 = r0.remaining()     // Catch:{ SSLException -> 0x00cf }
                if (r2 != r0) goto L_0x0027
                com.koushikdutta.async.ByteBufferList r0 = r7.buffered     // Catch:{ SSLException -> 0x00cf }
                r0.addFirst(r9)     // Catch:{ SSLException -> 0x00cf }
            L_0x00c7:
                com.koushikdutta.async.AsyncSSLSocketWrapper r9 = com.koushikdutta.async.AsyncSSLSocketWrapper.this     // Catch:{ SSLException -> 0x00cf }
                r9.onDataAvailable()     // Catch:{ SSLException -> 0x00cf }
                goto L_0x00d5
            L_0x00cd:
                r9 = move-exception
                goto L_0x00da
            L_0x00cf:
                r9 = move-exception
                com.koushikdutta.async.AsyncSSLSocketWrapper r0 = com.koushikdutta.async.AsyncSSLSocketWrapper.this     // Catch:{ all -> 0x00cd }
                r0.m43882a((java.lang.Exception) r9)     // Catch:{ all -> 0x00cd }
            L_0x00d5:
                com.koushikdutta.async.AsyncSSLSocketWrapper r9 = com.koushikdutta.async.AsyncSSLSocketWrapper.this
                r9.f58004g = r8
                return
            L_0x00da:
                com.koushikdutta.async.AsyncSSLSocketWrapper r0 = com.koushikdutta.async.AsyncSSLSocketWrapper.this
                r0.f58004g = r8
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.AsyncSSLSocketWrapper.C210946.onDataAvailable(com.koushikdutta.async.DataEmitter, com.koushikdutta.async.ByteBufferList):void");
        }
    };

    /* renamed from: u */
    ByteBufferList f58018u = new ByteBufferList();

    /* renamed from: v */
    CompletedCallback f58019v;

    /* renamed from: y */
    private int f58020y;

    /* renamed from: z */
    private String f58021z;

    public interface HandshakeCallback {
        void onHandshakeCompleted(Exception exc, AsyncSSLSocket asyncSSLSocket);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m43886a(String str, SSLSession sSLSession) {
        return true;
    }

    public String charset() {
        return null;
    }

    static {
        try {
            if (Build.VERSION.SDK_INT > 15) {
                f57995a = SSLContext.getInstance("Default");
                try {
                    f57996b = SSLContext.getInstance("TLS");
                    TrustManager[] trustManagerArr = {new X509TrustManager() {
                        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                        }

                        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                        }

                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }};
                    f57997c = trustManagerArr;
                    f57996b.init((KeyManager[]) null, trustManagerArr, (SecureRandom) null);
                    f57998d = $$Lambda$AsyncSSLSocketWrapper$1Kylp8YvQqEfd6pNky0lA15quo.INSTANCE;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e2) {
            try {
                f57995a = SSLContext.getInstance("TLS");
                f57995a.init((KeyManager[]) null, new TrustManager[]{new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }

                    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                        for (X509Certificate x509Certificate : x509CertificateArr) {
                            if (!(x509Certificate == null || x509Certificate.getCriticalExtensionOIDs() == null)) {
                                x509Certificate.getCriticalExtensionOIDs().remove("2.5.29.15");
                            }
                        }
                    }
                }}, (SecureRandom) null);
            } catch (Exception e3) {
                e2.printStackTrace();
                e3.printStackTrace();
            }
        }
    }

    public static SSLContext getDefaultSSLContext() {
        return f57995a;
    }

    public static void handshake(AsyncSocket asyncSocket, String str, int i, SSLEngine sSLEngine, TrustManager[] trustManagerArr, HostnameVerifier hostnameVerifier, boolean z, HandshakeCallback handshakeCallback) {
        final HandshakeCallback handshakeCallback2 = handshakeCallback;
        AsyncSSLSocketWrapper asyncSSLSocketWrapper = new AsyncSSLSocketWrapper(asyncSocket, str, i, sSLEngine, trustManagerArr, hostnameVerifier, z);
        asyncSSLSocketWrapper.f58008k = handshakeCallback2;
        C210913 r1 = new CompletedCallback() {
            public void onCompleted(Exception exc) {
                if (exc != null) {
                    handshakeCallback2.onHandshakeCompleted(exc, (AsyncSSLSocket) null);
                } else {
                    handshakeCallback2.onHandshakeCompleted(new SSLException("socket closed during handshake"), (AsyncSSLSocket) null);
                }
            }
        };
        AsyncSocket asyncSocket2 = asyncSocket;
        asyncSocket.setClosedCallback(r1);
        try {
            asyncSSLSocketWrapper.f58005h.beginHandshake();
            asyncSSLSocketWrapper.m43884a(asyncSSLSocketWrapper.f58005h.getHandshakeStatus());
        } catch (SSLException e) {
            asyncSSLSocketWrapper.m43882a((Exception) e);
        }
    }

    public static Cancellable connectSocket(AsyncServer asyncServer, String str, int i, ConnectCallback connectCallback) {
        return connectSocket(asyncServer, str, i, false, connectCallback);
    }

    public static Cancellable connectSocket(AsyncServer asyncServer, String str, int i, boolean z, ConnectCallback connectCallback) {
        SimpleCancellable simpleCancellable = new SimpleCancellable();
        simpleCancellable.setParent(asyncServer.connectSocket(str, i, new ConnectCallback(connectCallback, str, i, z) {
            public final /* synthetic */ ConnectCallback f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ int f$3;
            public final /* synthetic */ boolean f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void onConnectCompleted(Exception exc, AsyncSocket asyncSocket) {
                AsyncSSLSocketWrapper.m43881a(SimpleCancellable.this, this.f$1, this.f$2, this.f$3, this.f$4, exc, asyncSocket);
            }
        }));
        return simpleCancellable;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m43881a(SimpleCancellable simpleCancellable, ConnectCallback connectCallback, String str, int i, boolean z, Exception exc, AsyncSocket asyncSocket) {
        HostnameVerifier hostnameVerifier = null;
        if (exc == null) {
            SSLEngine createSSLEngine = (z ? f57996b : f57995a).createSSLEngine(str, i);
            TrustManager[] trustManagerArr = z ? f57997c : null;
            if (z) {
                hostnameVerifier = f57998d;
            }
            handshake(asyncSocket, str, i, createSSLEngine, trustManagerArr, hostnameVerifier, true, new HandshakeCallback(connectCallback) {
                public final /* synthetic */ ConnectCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final void onHandshakeCompleted(Exception exc, AsyncSSLSocket asyncSSLSocket) {
                    AsyncSSLSocketWrapper.m43880a(SimpleCancellable.this, this.f$1, exc, asyncSSLSocket);
                }
            });
        } else if (simpleCancellable.setComplete()) {
            connectCallback.onConnectCompleted(exc, (AsyncSocket) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m43880a(SimpleCancellable simpleCancellable, ConnectCallback connectCallback, Exception exc, AsyncSSLSocket asyncSSLSocket) {
        if (!simpleCancellable.setComplete()) {
            if (asyncSSLSocket != null) {
                asyncSSLSocket.close();
            }
        } else if (exc != null) {
            connectCallback.onConnectCompleted(exc, (AsyncSocket) null);
        } else {
            connectCallback.onConnectCompleted((Exception) null, asyncSSLSocket);
        }
    }

    private AsyncSSLSocketWrapper(AsyncSocket asyncSocket, String str, int i, SSLEngine sSLEngine, TrustManager[] trustManagerArr, HostnameVerifier hostnameVerifier, boolean z) {
        this.f58002e = asyncSocket;
        this.f58007j = hostnameVerifier;
        this.f58013p = z;
        this.f58012o = trustManagerArr;
        this.f58005h = sSLEngine;
        this.f58021z = str;
        this.f58020y = i;
        sSLEngine.setUseClientMode(z);
        BufferedDataSink bufferedDataSink = new BufferedDataSink(asyncSocket);
        this.f58003f = bufferedDataSink;
        bufferedDataSink.setWriteableCallback(new WritableCallback() {
            public void onWriteable() {
                if (AsyncSSLSocketWrapper.this.f58010m != null) {
                    AsyncSSLSocketWrapper.this.f58010m.onWriteable();
                }
            }
        });
        this.f58002e.setEndCallback(new CompletedCallback() {
            public void onCompleted(Exception exc) {
                if (!AsyncSSLSocketWrapper.this.f58014q) {
                    AsyncSSLSocketWrapper.this.f58014q = true;
                    AsyncSSLSocketWrapper.this.f58015r = exc;
                    if (!AsyncSSLSocketWrapper.this.f58016s.hasRemaining() && AsyncSSLSocketWrapper.this.f58019v != null) {
                        AsyncSSLSocketWrapper.this.f58019v.onCompleted(exc);
                    }
                }
            }
        });
        this.f58002e.setDataCallback(this.f58017t);
    }

    public void onDataAvailable() {
        CompletedCallback completedCallback;
        C21121Util.emitAllData(this, this.f58016s);
        if (this.f58014q && !this.f58016s.hasRemaining() && (completedCallback = this.f58019v) != null) {
            completedCallback.onCompleted(this.f58015r);
        }
    }

    public SSLEngine getSSLEngine() {
        return this.f58005h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo173059a(ByteBufferList byteBufferList, ByteBuffer byteBuffer) {
        byteBuffer.flip();
        if (byteBuffer.hasRemaining()) {
            byteBufferList.add(byteBuffer);
        } else {
            ByteBufferList.reclaim(byteBuffer);
        }
    }

    public void end() {
        this.f58002e.end();
    }

    public String getHost() {
        return this.f58021z;
    }

    public int getPort() {
        return this.f58020y;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m43884a(SSLEngineResult.HandshakeStatus handshakeStatus) {
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            this.f58005h.getDelegatedTask().run();
        }
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            write(this.f58018u);
        }
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            this.f58017t.onDataAvailable(this, new ByteBufferList());
        }
        try {
            if (this.f58006i) {
                return;
            }
            if (this.f58005h.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING || this.f58005h.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                if (this.f58013p) {
                    boolean z = false;
                    try {
                        this.f58009l = (X509Certificate[]) this.f58005h.getSession().getPeerCertificates();
                        if (this.f58021z != null) {
                            if (this.f58007j == null) {
                                new StrictHostnameVerifier().verify(this.f58021z, StrictHostnameVerifier.getCNs(this.f58009l[0]), StrictHostnameVerifier.getDNSSubjectAlts(this.f58009l[0]));
                            } else if (!this.f58007j.verify(this.f58021z, this.f58005h.getSession())) {
                                throw new SSLException("hostname <" + this.f58021z + "> has been denied");
                            }
                        }
                        e = null;
                        z = true;
                    } catch (SSLException e) {
                        e = e;
                    }
                    this.f58006i = true;
                    if (!z) {
                        AsyncSSLException asyncSSLException = new AsyncSSLException(e);
                        m43882a((Exception) asyncSSLException);
                        if (!asyncSSLException.getIgnore()) {
                            throw asyncSSLException;
                        }
                    }
                } else {
                    this.f58006i = true;
                }
                this.f58008k.onHandshakeCompleted((Exception) null, this);
                this.f58008k = null;
                this.f58002e.setClosedCallback((CompletedCallback) null);
                getServer().post(new Runnable() {
                    public void run() {
                        if (AsyncSSLSocketWrapper.this.f58010m != null) {
                            AsyncSSLSocketWrapper.this.f58010m.onWriteable();
                        }
                    }
                });
                onDataAvailable();
            }
        } catch (Exception e2) {
            m43882a(e2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo173058a(int i) {
        int i2 = (i * 3) / 2;
        if (i2 == 0) {
            return 8192;
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.koushikdutta.async.ByteBufferList r7) {
        /*
            r6 = this;
            boolean r0 = r6.f58001A
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            com.koushikdutta.async.BufferedDataSink r0 = r6.f58003f
            int r0 = r0.remaining()
            if (r0 <= 0) goto L_0x000e
            return
        L_0x000e:
            r0 = 1
            r6.f58001A = r0
            int r0 = r7.remaining()
            int r0 = r6.mo173058a((int) r0)
            java.nio.ByteBuffer r0 = com.koushikdutta.async.ByteBufferList.obtain(r0)
            r1 = 0
            r2 = r1
        L_0x001f:
            boolean r3 = r6.f58006i
            if (r3 == 0) goto L_0x002b
            int r3 = r7.remaining()
            if (r3 != 0) goto L_0x002b
            goto L_0x00ad
        L_0x002b:
            int r3 = r7.remaining()
            java.nio.ByteBuffer[] r4 = r7.getAllArray()     // Catch:{ SSLException -> 0x0091 }
            javax.net.ssl.SSLEngine r5 = r6.f58005h     // Catch:{ SSLException -> 0x0091 }
            javax.net.ssl.SSLEngineResult r2 = r5.wrap(r4, r0)     // Catch:{ SSLException -> 0x0091 }
            r7.addAll((java.nio.ByteBuffer[]) r4)     // Catch:{ SSLException -> 0x0091 }
            r0.flip()     // Catch:{ SSLException -> 0x0091 }
            com.koushikdutta.async.ByteBufferList r4 = r6.f58018u     // Catch:{ SSLException -> 0x0091 }
            r4.add((java.nio.ByteBuffer) r0)     // Catch:{ SSLException -> 0x0091 }
            boolean r4 = f57999w     // Catch:{ SSLException -> 0x0091 }
            if (r4 != 0) goto L_0x0057
            com.koushikdutta.async.ByteBufferList r4 = r6.f58018u     // Catch:{ SSLException -> 0x0091 }
            boolean r4 = r4.hasRemaining()     // Catch:{ SSLException -> 0x0091 }
            if (r4 != 0) goto L_0x0051
            goto L_0x0057
        L_0x0051:
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ SSLException -> 0x0091 }
            r4.<init>()     // Catch:{ SSLException -> 0x0091 }
            throw r4     // Catch:{ SSLException -> 0x0091 }
        L_0x0057:
            com.koushikdutta.async.ByteBufferList r4 = r6.f58018u     // Catch:{ SSLException -> 0x0091 }
            int r4 = r4.remaining()     // Catch:{ SSLException -> 0x0091 }
            if (r4 <= 0) goto L_0x0066
            com.koushikdutta.async.BufferedDataSink r4 = r6.f58003f     // Catch:{ SSLException -> 0x0091 }
            com.koushikdutta.async.ByteBufferList r5 = r6.f58018u     // Catch:{ SSLException -> 0x0091 }
            r4.write(r5)     // Catch:{ SSLException -> 0x0091 }
        L_0x0066:
            int r0 = r0.capacity()     // Catch:{ SSLException -> 0x0091 }
            javax.net.ssl.SSLEngineResult$Status r4 = r2.getStatus()     // Catch:{ SSLException -> 0x008e }
            javax.net.ssl.SSLEngineResult$Status r5 = javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW     // Catch:{ SSLException -> 0x008e }
            if (r4 != r5) goto L_0x007a
            int r0 = r0 * 2
            java.nio.ByteBuffer r0 = com.koushikdutta.async.ByteBufferList.obtain(r0)     // Catch:{ SSLException -> 0x008e }
            r3 = -1
            goto L_0x0095
        L_0x007a:
            int r0 = r7.remaining()     // Catch:{ SSLException -> 0x008e }
            int r0 = r6.mo173058a((int) r0)     // Catch:{ SSLException -> 0x008e }
            java.nio.ByteBuffer r0 = com.koushikdutta.async.ByteBufferList.obtain(r0)     // Catch:{ SSLException -> 0x008e }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = r2.getHandshakeStatus()     // Catch:{ SSLException -> 0x0091 }
            r6.m43884a((javax.net.ssl.SSLEngineResult.HandshakeStatus) r4)     // Catch:{ SSLException -> 0x0091 }
            goto L_0x0095
        L_0x008e:
            r4 = move-exception
            r0 = r1
            goto L_0x0092
        L_0x0091:
            r4 = move-exception
        L_0x0092:
            r6.m43882a((java.lang.Exception) r4)
        L_0x0095:
            int r4 = r7.remaining()
            if (r3 != r4) goto L_0x00a5
            if (r2 == 0) goto L_0x00ad
            javax.net.ssl.SSLEngineResult$HandshakeStatus r3 = r2.getHandshakeStatus()
            javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP
            if (r3 != r4) goto L_0x00ad
        L_0x00a5:
            com.koushikdutta.async.BufferedDataSink r3 = r6.f58003f
            int r3 = r3.remaining()
            if (r3 == 0) goto L_0x001f
        L_0x00ad:
            r7 = 0
            r6.f58001A = r7
            com.koushikdutta.async.ByteBufferList.reclaim(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.AsyncSSLSocketWrapper.write(com.koushikdutta.async.ByteBufferList):void");
    }

    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f58010m = writableCallback;
    }

    public WritableCallback getWriteableCallback() {
        return this.f58010m;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m43882a(Exception exc) {
        HandshakeCallback handshakeCallback = this.f58008k;
        if (handshakeCallback != null) {
            this.f58008k = null;
            this.f58002e.setDataCallback(new DataCallback.NullDataCallback());
            this.f58002e.end();
            this.f58002e.setClosedCallback((CompletedCallback) null);
            this.f58002e.close();
            handshakeCallback.onHandshakeCompleted(exc, (AsyncSSLSocket) null);
            return;
        }
        CompletedCallback endCallback = getEndCallback();
        if (endCallback != null) {
            endCallback.onCompleted(exc);
        }
    }

    public void setDataCallback(DataCallback dataCallback) {
        this.f58011n = dataCallback;
    }

    public DataCallback getDataCallback() {
        return this.f58011n;
    }

    public boolean isChunked() {
        return this.f58002e.isChunked();
    }

    public boolean isOpen() {
        return this.f58002e.isOpen();
    }

    public void close() {
        this.f58002e.close();
    }

    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f58002e.setClosedCallback(completedCallback);
    }

    public CompletedCallback getClosedCallback() {
        return this.f58002e.getClosedCallback();
    }

    public void setEndCallback(CompletedCallback completedCallback) {
        this.f58019v = completedCallback;
    }

    public CompletedCallback getEndCallback() {
        return this.f58019v;
    }

    public void pause() {
        this.f58002e.pause();
    }

    public void resume() {
        this.f58002e.resume();
        onDataAvailable();
    }

    public boolean isPaused() {
        return this.f58002e.isPaused();
    }

    public AsyncServer getServer() {
        return this.f58002e.getServer();
    }

    public AsyncSocket getSocket() {
        return this.f58002e;
    }

    public DataEmitter getDataEmitter() {
        return this.f58002e;
    }

    public X509Certificate[] getPeerCertificates() {
        return this.f58009l;
    }

    /* renamed from: a */
    private static Certificate m43876a(KeyPair keyPair, String str) throws Exception {
        BouncyCastleProvider bouncyCastleProvider = new BouncyCastleProvider();
        Security.addProvider(bouncyCastleProvider);
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        X500Name x500Name = new X500Name("CN=" + str);
        BigInteger bigInteger = new BigInteger(Long.toString(currentTimeMillis));
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(1, 1);
        Date time = instance.getTime();
        ContentSigner build = new JcaContentSignerBuilder("SHA256WithRSA").build(keyPair.getPrivate());
        JcaX509v3CertificateBuilder jcaX509v3CertificateBuilder = new JcaX509v3CertificateBuilder(x500Name, bigInteger, date, time, x500Name, keyPair.getPublic());
        jcaX509v3CertificateBuilder.addExtension(new ASN1ObjectIdentifier("2.5.29.19"), true, new BasicConstraints(true));
        return new JcaX509CertificateConverter().setProvider(bouncyCastleProvider).getCertificate(jcaX509v3CertificateBuilder.build(build));
    }

    public static Pair<KeyPair, Certificate> selfSignCertificate(Context context, String str) throws Exception {
        KeyPair keyPair;
        Certificate certificate;
        File fileStreamPath = context.getFileStreamPath(str + "-key.txt");
        try {
            String[] split = StreamUtility.readFile(fileStreamPath).split("\n");
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(split[0], 0));
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decode(split[1], 0));
            certificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.decode(split[2], 0)));
            KeyFactory instance = KeyFactory.getInstance("RSA");
            keyPair = new KeyPair(instance.generatePublic(x509EncodedKeySpec), instance.generatePrivate(pKCS8EncodedKeySpec));
        } catch (Exception unused) {
            KeyPairGenerator instance2 = KeyPairGenerator.getInstance("RSA");
            instance2.initialize(2048);
            keyPair = instance2.generateKeyPair();
            certificate = m43876a(keyPair, str);
            StreamUtility.writeFile(fileStreamPath, Base64.encodeToString(keyPair.getPublic().getEncoded(), 2) + "\n" + Base64.encodeToString(keyPair.getPrivate().getEncoded(), 2) + "\n" + Base64.encodeToString(certificate.getEncoded(), 2));
        }
        return new Pair<>(keyPair, certificate);
    }

    public static AsyncSSLServerSocket listenSecure(Context context, AsyncServer asyncServer, String str, InetAddress inetAddress, int i, ListenCallback listenCallback) {
        ObjectHolder objectHolder = new ObjectHolder();
        asyncServer.run(new Runnable(context, str, objectHolder, asyncServer, inetAddress, i, listenCallback) {
            public final /* synthetic */ Context f$0;
            public final /* synthetic */ String f$1;
            public final /* synthetic */ AsyncSSLSocketWrapper.ObjectHolder f$2;
            public final /* synthetic */ AsyncServer f$3;
            public final /* synthetic */ InetAddress f$4;
            public final /* synthetic */ int f$5;
            public final /* synthetic */ ListenCallback f$6;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
            }

            public final void run() {
                AsyncSSLSocketWrapper.m43877a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
            }
        });
        return (AsyncSSLServerSocket) objectHolder.held;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m43877a(Context context, String str, ObjectHolder objectHolder, AsyncServer asyncServer, InetAddress inetAddress, int i, ListenCallback listenCallback) {
        try {
            Pair<KeyPair, Certificate> selfSignCertificate = selfSignCertificate(context, str);
            AsyncServer asyncServer2 = asyncServer;
            objectHolder.held = listenSecure(asyncServer2, ((KeyPair) selfSignCertificate.first).getPrivate(), (Certificate) selfSignCertificate.second, inetAddress, i, listenCallback);
        } catch (Exception e) {
            listenCallback.onCompleted(e);
        }
    }

    public static AsyncSSLServerSocket listenSecure(AsyncServer asyncServer, String str, String str2, InetAddress inetAddress, int i, ListenCallback listenCallback) {
        return listenSecure(asyncServer, Base64.decode(str, 0), Base64.decode(str2, 0), inetAddress, i, listenCallback);
    }

    private static class ObjectHolder<T> {
        T held;

        private ObjectHolder() {
        }
    }

    public static AsyncSSLServerSocket listenSecure(AsyncServer asyncServer, byte[] bArr, byte[] bArr2, InetAddress inetAddress, int i, ListenCallback listenCallback) {
        ObjectHolder objectHolder = new ObjectHolder();
        asyncServer.run(new Runnable(bArr, bArr2, objectHolder, asyncServer, inetAddress, i, listenCallback) {
            public final /* synthetic */ byte[] f$0;
            public final /* synthetic */ byte[] f$1;
            public final /* synthetic */ AsyncSSLSocketWrapper.ObjectHolder f$2;
            public final /* synthetic */ AsyncServer f$3;
            public final /* synthetic */ InetAddress f$4;
            public final /* synthetic */ int f$5;
            public final /* synthetic */ ListenCallback f$6;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
            }

            public final void run() {
                AsyncSSLSocketWrapper.m43885a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
            }
        });
        return (AsyncSSLServerSocket) objectHolder.held;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m43885a(byte[] bArr, byte[] bArr2, ObjectHolder objectHolder, AsyncServer asyncServer, InetAddress inetAddress, int i, ListenCallback listenCallback) {
        try {
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(bArr);
            AsyncServer asyncServer2 = asyncServer;
            objectHolder.held = listenSecure(asyncServer2, KeyFactory.getInstance("RSA").generatePrivate(pKCS8EncodedKeySpec), CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr2)), inetAddress, i, listenCallback);
        } catch (Exception e) {
            listenCallback.onCompleted(e);
        }
    }

    public static AsyncSSLServerSocket listenSecure(AsyncServer asyncServer, PrivateKey privateKey, Certificate certificate, InetAddress inetAddress, int i, ListenCallback listenCallback) {
        ObjectHolder objectHolder = new ObjectHolder();
        asyncServer.run(new Runnable(privateKey, certificate, asyncServer, inetAddress, i, listenCallback, objectHolder) {
            public final /* synthetic */ PrivateKey f$0;
            public final /* synthetic */ Certificate f$1;
            public final /* synthetic */ AsyncServer f$2;
            public final /* synthetic */ InetAddress f$3;
            public final /* synthetic */ int f$4;
            public final /* synthetic */ ListenCallback f$5;
            public final /* synthetic */ AsyncSSLSocketWrapper.ObjectHolder f$6;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
            }

            public final void run() {
                AsyncSSLSocketWrapper.m43883a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
            }
        });
        return (AsyncSSLServerSocket) objectHolder.held;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m43883a(final PrivateKey privateKey, final Certificate certificate, AsyncServer asyncServer, InetAddress inetAddress, int i, ListenCallback listenCallback, ObjectHolder objectHolder) {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load((KeyStore.LoadStoreParameter) null);
            instance.setKeyEntry("key", privateKey, (char[]) null, new Certificate[]{certificate});
            KeyManagerFactory instance2 = KeyManagerFactory.getInstance("X509");
            instance2.init(instance, "".toCharArray());
            TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance3.init(instance);
            SSLContext instance4 = SSLContext.getInstance("TLS");
            instance4.init(instance2.getKeyManagers(), instance3.getTrustManagers(), (SecureRandom) null);
            final AsyncServerSocket listenSecure = listenSecure(asyncServer, instance4, inetAddress, i, listenCallback);
            objectHolder.held = new AsyncSSLServerSocket() {
                public PrivateKey getPrivateKey() {
                    return privateKey;
                }

                public Certificate getCertificate() {
                    return certificate;
                }

                public void stop() {
                    listenSecure.stop();
                }

                public int getLocalPort() {
                    return listenSecure.getLocalPort();
                }
            };
        } catch (Exception e) {
            listenCallback.onCompleted(e);
        }
    }

    public static AsyncServerSocket listenSecure(AsyncServer asyncServer, final SSLContext sSLContext, InetAddress inetAddress, final int i, final ListenCallback listenCallback) {
        final C210979 r0 = new SSLEngineSNIConfigurator() {
            public SSLEngine createEngine(SSLContext sSLContext, String str, int i) {
                SSLEngine createEngine = super.createEngine(sSLContext, str, i);
                createEngine.setEnabledCipherSuites(new String[]{"TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384"});
                return createEngine;
            }
        };
        return asyncServer.listen(inetAddress, i, new ListenCallback() {
            public void onAccepted(AsyncSocket asyncSocket) {
                int i = i;
                AsyncSSLSocketWrapper.handshake(asyncSocket, (String) null, i, r0.createEngine(sSLContext, (String) null, i), (TrustManager[]) null, (HostnameVerifier) null, false, new HandshakeCallback(listenCallback) {
                    public final /* synthetic */ ListenCallback f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onHandshakeCompleted(Exception exc, AsyncSSLSocket asyncSSLSocket) {
                        AsyncSSLSocketWrapper.C2108910.lambda$onAccepted$0(AsyncSocket.this, this.f$1, exc, asyncSSLSocket);
                    }
                });
            }

            static /* synthetic */ void lambda$onAccepted$0(AsyncSocket asyncSocket, ListenCallback listenCallback, Exception exc, AsyncSSLSocket asyncSSLSocket) {
                if (exc != null) {
                    asyncSocket.close();
                } else {
                    listenCallback.onAccepted(asyncSSLSocket);
                }
            }

            public void onListening(AsyncServerSocket asyncServerSocket) {
                listenCallback.onListening(asyncServerSocket);
            }

            public void onCompleted(Exception exc) {
                listenCallback.onCompleted(exc);
            }
        });
    }
}
