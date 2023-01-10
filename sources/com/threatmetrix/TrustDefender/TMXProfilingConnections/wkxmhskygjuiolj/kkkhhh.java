package com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj;

import android.os.Build;
import com.threatmetrix.TrustDefender.TMXProfilingConnectionsInterface;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CRLException;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.text.Typography;

public class kkkhhh {
    public static int b006C006Cllll = 1;
    public static int b006Clllll = b006Cl006Clll();
    public static final int b00740074tttt = 64;
    private static final boolean b0074t0074ttt;
    public static int bl006Cllll = 10;
    public static int bll006Clll = 2;
    private static final String btt0074ttt = kkhhhh.bj006A006A006Ajj(kkkhhh.class);
    private final int b007400740074ttt;
    @Nullable
    private byte[][] b00740074t0074tt;
    private HttpsURLConnection b0074t00740074tt;
    @Nonnull
    private final Map<String, String> b0074tt0074tt = new HashMap();
    private final TMXProfilingConnectionsInterface.TMXHttpResponseCode bt00740074ttt = new TMXProfilingConnectionsInterface.TMXHttpResponseCode(-2);
    @Nullable
    private byte[][] bt0074t0074tt;
    private URL btt00740074tt;
    private final hhhkhh bttt0074tt;

    static {
        boolean z;
        if (Build.VERSION.SDK_INT <= 19) {
            z = true;
            int i = b006Clllll;
            if (((b006C006Cllll + i) * i) % bll006Clll != bl006Cllll) {
            }
        } else {
            z = false;
        }
        b0074t0074ttt = z;
    }

    public kkkhhh(@Nullable byte[][] bArr, @Nullable byte[][] bArr2, int i) {
        this.bt0074t0074tt = bArr;
        this.b00740074t0074tt = bArr2;
        this.b007400740074ttt = i;
        hhhkhh hhhkhh = null;
        this.btt00740074tt = null;
        this.b0074t00740074tt = null;
        this.bttt0074tt = b0074t0074ttt ? new hhhkhh() : hhhkhh;
    }

    private void b006A006A006A006Aj006A(Exception exc) {
        TMXProfilingConnectionsInterface.TMXHttpResponseCode tMXHttpResponseCode;
        int i;
        if (exc.getCause() instanceof CertificateException) {
            if (b006Aj006A006Aj006A(exc.getCause(), CertificateNotYetValidException.class)) {
                tMXHttpResponseCode = this.bt00740074ttt;
                i = -10;
            } else if (b006Aj006A006Aj006A(exc.getCause(), CertificateExpiredException.class)) {
                tMXHttpResponseCode = this.bt00740074ttt;
                i = -9;
            } else if (b006Aj006A006Aj006A(exc.getCause(), CertificateEncodingException.class)) {
                tMXHttpResponseCode = this.bt00740074ttt;
                i = -8;
            } else {
                tMXHttpResponseCode = this.bt00740074ttt;
                i = -7;
            }
        } else if (exc.getCause() instanceof CertPathBuilderException) {
            tMXHttpResponseCode = this.bt00740074ttt;
            i = -12;
        } else if (exc.getCause() instanceof CertPathValidatorException) {
            tMXHttpResponseCode = this.bt00740074ttt;
            i = -13;
        } else {
            int i2 = b006Clllll;
            if (((b006C006Cllll + i2) * i2) % b006Cll006Cll() != bl006Cllll) {
                b006Clllll = b006Cl006Clll();
                bl006Cllll = 89;
            }
            if (exc.getCause() instanceof CertStoreException) {
                tMXHttpResponseCode = this.bt00740074ttt;
                i = -14;
            } else if (exc.getCause() instanceof CRLException) {
                tMXHttpResponseCode = this.bt00740074ttt;
                i = -15;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                tMXHttpResponseCode = this.bt00740074ttt;
                i = -5;
            } else if (exc instanceof UnknownHostException) {
                tMXHttpResponseCode = this.bt00740074ttt;
                i = -3;
            } else if (exc instanceof SocketTimeoutException) {
                tMXHttpResponseCode = this.bt00740074ttt;
                i = -4;
            } else if (this.bt00740074ttt.getHttpResponseCode() == -2) {
                tMXHttpResponseCode = this.bt00740074ttt;
                i = -1;
            } else {
                return;
            }
        }
        tMXHttpResponseCode.setHttpResponseCode(i);
    }

    private int b006A006Ajjj006A(boolean z, @Nullable List<Certificate> list) {
        try {
            if (this.bt0074t0074tt == null && this.b00740074t0074tt == null) {
                return 200;
            }
            int i = -6;
            if (!z) {
                kkhhhh.b006A006Aj006Ajj(btt0074ttt, kkhhkh.bj006A006A006A006A006A("g\u0002\u0010\u0007\u0017\r\u0007\u0012\rH\u0010\f\u0015\u0019\u0013\u0013", 'O', 5));
                return -6;
            }
            if (list != null) {
                int i2 = b006Clllll;
                if (((b006C006Cllll + i2) * i2) % bll006Clll != bl006Cllll) {
                    b006Clllll = 58;
                    bl006Cllll = 87;
                }
                if (!list.isEmpty()) {
                    Certificate certificate = list.get(0);
                    if (this.b00740074t0074tt != null) {
                        i = bjj006Ajj006A(certificate);
                    }
                    if (i == 200) {
                        return i;
                    }
                    try {
                        return this.bt0074t0074tt != null ? bj006Ajjj006A(certificate) : i;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            kkhhhh.b006A006Aj006Ajj(btt0074ttt, kkhhkh.bj006A006A006A006A006A("r\u0012 Y(T(\u001c,+# 2\"]\"%36,*.)(<.", 'W', 5));
            return -6;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static boolean b006Aj006A006Aj006A(Throwable th, Class<?> cls) {
        do {
            th = th.getCause();
            int i = b006Clllll;
            if ((i * (b006C006Cllll + i)) % bll006Clll != 0) {
                b006Clllll = 14;
                bl006Cllll = b006Cl006Clll();
            }
            if (th == null) {
                return false;
            }
        } while (!cls.isInstance(th));
        return true;
    }

    public static int b006Cl006Clll() {
        return 19;
    }

    public static int b006Cll006Cll() {
        return 2;
    }

    private static boolean bj006A006Ajj006A(byte[][] bArr, byte[] bArr2) {
        while (true) {
            try {
                int[] iArr = new int[-1];
            } catch (Exception unused) {
                b006Clllll = b006Cl006Clll();
                if (!(bArr2 == null || bArr == null || bArr.length == 0)) {
                    for (byte[] equals : bArr) {
                        if (Arrays.equals(bArr2, equals)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
    }

    private int bj006Ajjj006A(@Nonnull Certificate certificate) {
        try {
            byte[] bj006A006A006A006Aj = hkkhhh.bj006A006A006A006Aj(certificate.getEncoded());
            if (bj006A006A006A006Aj != null) {
                try {
                    if (bj006A006Ajj006A(this.bt0074t0074tt, bj006A006A006A006Aj)) {
                        return 200;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            String str = btt0074ttt;
            StringBuilder sb = new StringBuilder();
            int i = b006Clllll;
            if ((i * (b006C006Cllll + i)) % bll006Clll != 0) {
                b006Clllll = b006Cl006Clll();
                bl006Cllll = b006Cl006Clll();
            }
            try {
                sb.append(kkhhkh.b006Aj006A006A006A006A("\f07!+'![\u001e\u001f+, \u001c\u001e\u0017\u0014&\u0016[N\u0016\u001c\u001f\u001fI\u0012\u001bF\u001b\u0018\r\u0011\t@", 'g', Typography.copyright, 2));
                sb.append(bj006A006A006A006Aj == null ? kkhhkh.bj006A006A006A006A006A("V^VW", 246, 1) : hkkhhh.bj006Aj006A006Aj(bj006A006A006A006Aj));
                kkhhhh.b006A006Aj006Ajj(str, sb.toString());
                return -6;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (CertificateEncodingException e3) {
            kkhhhh.b006Aj006A006Ajj(btt0074ttt, kkhhkh.bj006A006A006A006A006A("\u0003\"0i8d<,:20Dk03AD:8<76J<wTW", 222, 5), e3.toString());
            return -8;
        }
    }

    private int bjj006Ajj006A(@Nonnull Certificate certificate) {
        byte[] bj006A006A006A006Aj = hkkhhh.bj006A006A006A006Aj(certificate.getPublicKey().getEncoded());
        if (bj006A006A006A006Aj != null && bj006A006Ajj006A(this.b00740074t0074tt, bj006A006A006A006Aj)) {
            return 200;
        }
        String str = btt0074ttt;
        StringBuilder sb = new StringBuilder();
        if (((b006Cl006Clll() + b006C006Cllll) * b006Cl006Clll()) % b006Cll006Cll() != bl006Cllll) {
            b006Clllll = b006Cl006Clll();
            bl006Cllll = 3;
        }
        sb.append(kkhhkh.b006Aj006A006A006A006A("1W`LXVR\u000f`fT_]X\u0016b]r\u001ac]pf+ iqvx%oz(~}tzt.", 'o', 135, 0));
        sb.append(bj006A006A006A006Aj == null ? kkhhkh.bj006A006A006A006A006A("2:23", 234, 1) : hkkhhh.bj006Aj006A006Aj(bj006A006A006A006Aj));
        kkhhhh.b006A006Aj006Ajj(str, sb.toString());
        return -6;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: char} */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r0v29, types: [java.net.URLConnection, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0169, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x016a, code lost:
        if (r6 != null) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01f0, code lost:
        if (r6 == null) goto L_0x01f5;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0244 A[SYNTHETIC, Splitter:B:100:0x0244] */
    /* JADX WARNING: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0195 A[Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178, all -> 0x0240 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01b2 A[Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178, all -> 0x0240 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01c7 A[Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178, all -> 0x0240 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ca A[Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178, all -> 0x0240 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x023b A[SYNTHETIC, Splitter:B:95:0x023b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private javax.net.ssl.HttpsURLConnection bjjj006Aj006A(java.lang.String r17, byte[] r18, boolean r19) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = -1
            r5 = 2
            r6 = 3
            boolean r0 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.hkkhhh.bjj006A006A006Aj(r17)     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            r8 = 85
            r9 = 35
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = "'21,"
            r10 = 227(0xe3, float:3.18E-43)
            java.lang.String r0 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.b006Aj006A006A006A006A(r0, r10, r9, r5)     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            boolean r0 = r2.startsWith(r0)     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            if (r0 != 0) goto L_0x0038
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            r0.<init>()     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            java.lang.String r10 = "grqln4('"
            r11 = 4
            java.lang.String r10 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.bj006A006A006A006A006A(r10, r8, r11)     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            r0.append(r10)     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            r0.append(r2)     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            java.lang.String r0 = r0.toString()     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            goto L_0x0039
        L_0x0038:
            r0 = r2
        L_0x0039:
            java.net.URL r10 = new java.net.URL     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            r10.<init>(r0)     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            java.net.ProxySelector r11 = java.net.ProxySelector.getDefault()     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            r12 = 1
            if (r11 != 0) goto L_0x005d
            java.lang.String r0 = btt0074ttt     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            java.lang.String r11 = "\r--':07a12.66[$-X&,\"!"
            r13 = 182(0xb6, float:2.55E-43)
            java.lang.String r11 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.bj006A006A006A006A006A(r11, r13, r6)     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh.hhkhhh.b00740074tt00740074(r0, r11)     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            r0.<init>(r12)     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            java.net.Proxy r11 = java.net.Proxy.NO_PROXY     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            r0.add(r11)     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            goto L_0x0066
        L_0x005d:
            java.net.URI r13 = new java.net.URI     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            r13.<init>(r0)     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
            java.util.List r0 = r11.select(r13)     // Catch:{ MalformedURLException -> 0x028d, URISyntaxException -> 0x028b, SecurityException -> 0x0273 }
        L_0x0066:
            java.util.Iterator r4 = r0.iterator()     // Catch:{ Exception -> 0x0271 }
            r11 = 0
        L_0x006b:
            boolean r0 = r4.hasNext()     // Catch:{ Exception -> 0x0271 }
            if (r0 == 0) goto L_0x0248
            java.lang.Object r0 = r4.next()     // Catch:{ Exception -> 0x0271 }
            r13 = r0
            java.net.Proxy r13 = (java.net.Proxy) r13     // Catch:{ Exception -> 0x0271 }
            r14 = 5
            java.net.URLConnection r0 = r10.openConnection(r13)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            boolean r7 = r0 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            if (r7 != 0) goto L_0x00cb
            java.lang.String r7 = btt0074ttt     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r9.<init>()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.lang.String r6 = "2V]GQMG\u0002DOMLB?OCHFvJND8q"
            r15 = 189(0xbd, float:2.65E-43)
            java.lang.String r6 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.b006Aj006A006A006A006A(r6, r8, r15, r5)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r9.append(r6)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.lang.String r0 = r0.getName()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r9.append(r0)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            int r0 = b006Clllll
            int r6 = bl006C006Clll()
            int r6 = r6 + r0
            int r0 = r0 * r6
            int r6 = bll006Clll
            int r0 = r0 % r6
            if (r0 == 0) goto L_0x00b6
            r0 = 27
            b006Clllll = r0
            int r0 = b006Cl006Clll()
            bl006Cllll = r0
        L_0x00b6:
            java.lang.String r0 = ",vu}\u0004w3}\nD"
            r6 = 6
            java.lang.String r0 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.bj006A006A006A006A006A(r0, r6, r14)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r9.append(r0)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.lang.String r0 = r9.toString()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh.hhkhhh.btt0074007400740074(r7, r0)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r6 = 3
            r9 = 35
            goto L_0x006b
        L_0x00cb:
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.hhhkhh r6 = r1.bttt0074tt     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            if (r6 == 0) goto L_0x00d7
            r6 = r0
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.hhhkhh r7 = r1.bttt0074tt     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r6.setSSLSocketFactory(r7)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
        L_0x00d7:
            r6 = r0
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            int r0 = r1.b007400740074ttt     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r6.setConnectTimeout(r0)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            int r0 = r1.b007400740074ttt     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r6.setReadTimeout(r0)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r6.setInstanceFollowRedirects(r12)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r7 = 0
            r6.setUseCaches(r7)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r6.setDoInput(r12)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.b0074tt0074tt     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
        L_0x00f8:
            boolean r7 = r0.hasNext()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            if (r7 == 0) goto L_0x0114
            java.lang.Object r7 = r0.next()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.lang.Object r9 = r7.getKey()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.lang.Object r7 = r7.getValue()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r6.setRequestProperty(r9, r7)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            goto L_0x00f8
        L_0x0114:
            if (r19 == 0) goto L_0x0137
            java.lang.String r0 = "\n\n\u000f\u0011"
            r7 = 215(0xd7, float:3.01E-43)
            r9 = 158(0x9e, float:2.21E-43)
            r15 = 0
            java.lang.String r0 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.b006Aj006A006A006A006A(r0, r7, r9, r15)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r6.setRequestMethod(r0)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r6.setDoOutput(r12)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            if (r3 == 0) goto L_0x0146
            java.io.OutputStream r0 = r6.getOutputStream()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r0.write(r3)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r0.flush()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r0.close()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            goto L_0x0146
        L_0x0137:
            java.lang.String r0 = "'&6"
            r7 = 74
            java.lang.String r0 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.bj006A006A006A006A006A(r0, r7, r12)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r6.setRequestMethod(r0)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            r7 = 0
            r6.setDoOutput(r7)     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
        L_0x0146:
            r6.connect()     // Catch:{ SSLPeerUnverifiedException -> 0x0226, IOException -> 0x01f8, SecurityException -> 0x01cb, IllegalArgumentException -> 0x017c, all -> 0x0178 }
            java.security.cert.Certificate[] r0 = r6.getServerCertificates()     // Catch:{ SSLPeerUnverifiedException -> 0x0175, IOException -> 0x0172, SecurityException -> 0x0170, IllegalArgumentException -> 0x016e }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SSLPeerUnverifiedException -> 0x0175, IOException -> 0x0172, SecurityException -> 0x0170, IllegalArgumentException -> 0x016e }
            com.threatmetrix.TrustDefender.TMXProfilingConnectionsInterface$TMXHttpResponseCode r7 = r1.bt00740074ttt     // Catch:{ SSLPeerUnverifiedException -> 0x0175, IOException -> 0x0172, SecurityException -> 0x0170, IllegalArgumentException -> 0x016e }
            if (r0 == 0) goto L_0x0157
            r9 = 1
            goto L_0x0158
        L_0x0157:
            r9 = 0
        L_0x0158:
            int r0 = r1.b006A006Ajjj006A(r9, r0)     // Catch:{ SSLPeerUnverifiedException -> 0x0175, IOException -> 0x0172, SecurityException -> 0x0170, IllegalArgumentException -> 0x016e }
            r7.setHttpResponseCode(r0)     // Catch:{ SSLPeerUnverifiedException -> 0x0175, IOException -> 0x0172, SecurityException -> 0x0170, IllegalArgumentException -> 0x016e }
            com.threatmetrix.TrustDefender.TMXProfilingConnectionsInterface$TMXHttpResponseCode r0 = r1.bt00740074ttt     // Catch:{ SSLPeerUnverifiedException -> 0x0175, IOException -> 0x0172, SecurityException -> 0x0170, IllegalArgumentException -> 0x016e }
            int r0 = r0.getHttpResponseCode()     // Catch:{ SSLPeerUnverifiedException -> 0x0175, IOException -> 0x0172, SecurityException -> 0x0170, IllegalArgumentException -> 0x016e }
            r7 = 200(0xc8, float:2.8E-43)
            if (r0 != r7) goto L_0x016a
            return r6
        L_0x016a:
            if (r6 == 0) goto L_0x01f5
            goto L_0x01f2
        L_0x016e:
            r0 = move-exception
            goto L_0x017e
        L_0x0170:
            r0 = move-exception
            goto L_0x01cd
        L_0x0172:
            r0 = move-exception
            goto L_0x01fa
        L_0x0175:
            r0 = move-exception
            goto L_0x0228
        L_0x0178:
            r0 = move-exception
            r7 = 0
            goto L_0x0242
        L_0x017c:
            r0 = move-exception
            r6 = 0
        L_0x017e:
            java.lang.String r7 = btt0074ttt     // Catch:{ all -> 0x0240 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0240 }
            r9.<init>()     // Catch:{ all -> 0x0240 }
            java.lang.String r14 = "$OMLB?OCHFv<6=?GC5\tm\u0016:A+51+e562::_"
            r15 = 31
            r8 = 3
            java.lang.String r14 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.bj006A006A006A006A006A(r14, r15, r8)     // Catch:{ all -> 0x0240 }
            r9.append(r14)     // Catch:{ all -> 0x0240 }
            r8 = 116(0x74, float:1.63E-43)
            if (r13 == 0) goto L_0x01b2
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0240 }
            r14.<init>()     // Catch:{ all -> 0x0240 }
            java.lang.String r15 = "gme[\u0017"
            r12 = 230(0xe6, float:3.22E-43)
            r5 = 0
            java.lang.String r5 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.b006Aj006A006A006A006A(r15, r12, r8, r5)     // Catch:{ all -> 0x0240 }
            r14.append(r5)     // Catch:{ all -> 0x0240 }
            java.lang.String r5 = r13.toString()     // Catch:{ all -> 0x0240 }
            r14.append(r5)     // Catch:{ all -> 0x0240 }
            java.lang.String r5 = r14.toString()     // Catch:{ all -> 0x0240 }
            goto L_0x01bb
        L_0x01b2:
            java.lang.String r5 = ":=;EGn9DqAIAB\u0005"
            r12 = 170(0xaa, float:2.38E-43)
            r13 = 0
            java.lang.String r5 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.b006Aj006A006A006A006A(r5, r8, r12, r13)     // Catch:{ all -> 0x0240 }
        L_0x01bb:
            r9.append(r5)     // Catch:{ all -> 0x0240 }
            java.lang.String r5 = r9.toString()     // Catch:{ all -> 0x0240 }
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh.hhkhhh.btt0074007400740074(r7, r5)     // Catch:{ all -> 0x0240 }
            if (r11 != 0) goto L_0x01c8
            r11 = r0
        L_0x01c8:
            if (r6 == 0) goto L_0x01f5
            goto L_0x01f2
        L_0x01cb:
            r0 = move-exception
            r6 = 0
        L_0x01cd:
            java.lang.String r5 = btt0074ttt     // Catch:{ all -> 0x0240 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0240 }
            r7.<init>()     // Catch:{ all -> 0x0240 }
            java.lang.String r8 = "`\u000e\u000e\u000f\u0007\u0006\u0018\u000e\u0015\u0015G\u000f\u000b\u0014\u0018\" \u0014iPu\"\"[*V \u001a0 [-#1-*56-44f<8i@?2mC8:ErDGEOQ\u0007"
            r9 = 205(0xcd, float:2.87E-43)
            java.lang.String r8 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.bj006A006A006A006A006A(r8, r9, r14)     // Catch:{ all -> 0x0240 }
            r7.append(r8)     // Catch:{ all -> 0x0240 }
            java.lang.String r8 = r13.toString()     // Catch:{ all -> 0x0240 }
            r7.append(r8)     // Catch:{ all -> 0x0240 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0240 }
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh.hhkhhh.btt0074007400740074(r5, r7)     // Catch:{ all -> 0x0240 }
            if (r11 != 0) goto L_0x01f0
            r11 = r0
        L_0x01f0:
            if (r6 == 0) goto L_0x01f5
        L_0x01f2:
            r6.disconnect()     // Catch:{ Exception -> 0x026d }
        L_0x01f5:
            r5 = 35
            goto L_0x021d
        L_0x01f8:
            r0 = move-exception
            r6 = 0
        L_0x01fa:
            if (r11 != 0) goto L_0x01fd
            r11 = r0
        L_0x01fd:
            if (r6 == 0) goto L_0x01f5
            int r0 = b006Clllll
            int r5 = b006C006Cllll
            int r5 = r5 + r0
            int r5 = r5 * r0
            int r0 = bll006Clll
            int r5 = r5 % r0
            int r0 = bl006Cllll
            if (r5 == r0) goto L_0x0218
            r5 = 35
            b006Clllll = r5
            int r0 = b006Cl006Clll()
            bl006Cllll = r0
            goto L_0x021a
        L_0x0218:
            r5 = 35
        L_0x021a:
            r6.disconnect()     // Catch:{ Exception -> 0x026d }
        L_0x021d:
            r5 = 2
            r6 = 3
            r8 = 85
            r9 = 35
            r12 = 1
            goto L_0x006b
        L_0x0226:
            r0 = move-exception
            r6 = 0
        L_0x0228:
            java.lang.String r2 = btt0074ttt     // Catch:{ all -> 0x0240 }
            java.lang.String r3 = "Sijx'}w\u0001p~vtxuu"
            r4 = 130(0x82, float:1.82E-43)
            r5 = 0
            java.lang.String r3 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.bj006A006A006A006A006A(r3, r4, r5)     // Catch:{ all -> 0x0240 }
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh.bjj006A006Ajj(r2, r3, r0)     // Catch:{ all -> 0x0240 }
            r1.b006A006A006A006Aj006A(r0)     // Catch:{ all -> 0x0240 }
            if (r6 == 0) goto L_0x023e
            r6.disconnect()     // Catch:{ Exception -> 0x0271 }
        L_0x023e:
            r2 = 0
            return r2
        L_0x0240:
            r0 = move-exception
            r7 = r6
        L_0x0242:
            if (r7 == 0) goto L_0x0247
            r7.disconnect()     // Catch:{ Exception -> 0x026d }
        L_0x0247:
            throw r0     // Catch:{ Exception -> 0x026d }
        L_0x0248:
            if (r11 == 0) goto L_0x026f
            java.lang.String r0 = btt0074ttt     // Catch:{ Exception -> 0x026d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026d }
            r3.<init>()     // Catch:{ Exception -> 0x026d }
            java.lang.String r4 = "Ihvwy,p}}~vu\b4\n\u00067\u000b~\b\u000b\u0011\u0003>\b\u0010\u0015\u0017C"
            r5 = 61
            r6 = 199(0xc7, float:2.79E-43)
            r7 = 3
            java.lang.String r4 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.b006Aj006A006A006A006A(r4, r5, r6, r7)     // Catch:{ Exception -> 0x026d }
            r3.append(r4)     // Catch:{ Exception -> 0x0271 }
            r3.append(r2)     // Catch:{ Exception -> 0x0271 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0271 }
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh.bjj006A006Ajj(r0, r2, r11)     // Catch:{ Exception -> 0x0271 }
            r1.b006A006A006A006Aj006A(r11)     // Catch:{ Exception -> 0x0271 }
            goto L_0x026f
        L_0x026d:
            r0 = move-exception
            throw r0
        L_0x026f:
            r2 = 0
            return r2
        L_0x0271:
            r0 = move-exception
            goto L_0x02a3
        L_0x0273:
            r0 = move-exception
            java.lang.String r2 = btt0074ttt     // Catch:{ Exception -> 0x0271 }
            java.lang.String r3 = "&98KIAMSzI>L@GFT\u0003HJTPMM\nLOPSbc"
            r5 = 150(0x96, float:2.1E-43)
            r6 = 59
            r7 = 3
            java.lang.String r3 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.b006Aj006A006A006A006A(r3, r5, r6, r7)     // Catch:{ Exception -> 0x0271 }
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh.bjj006A006Ajj(r2, r3, r0)     // Catch:{ Exception -> 0x0271 }
            com.threatmetrix.TrustDefender.TMXProfilingConnectionsInterface$TMXHttpResponseCode r0 = r1.bt00740074ttt     // Catch:{ Exception -> 0x0271 }
            r0.setHttpResponseCode(r4)     // Catch:{ Exception -> 0x0271 }
            r2 = 0
            return r2
        L_0x028b:
            r0 = move-exception
            goto L_0x028e
        L_0x028d:
            r0 = move-exception
        L_0x028e:
            java.lang.String r2 = btt0074ttt     // Catch:{ Exception -> 0x0271 }
            java.lang.String r3 = "!EL6@<6p%!\u001a"
            r5 = 147(0x93, float:2.06E-43)
            r6 = 2
            java.lang.String r3 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.bj006A006A006A006A006A(r3, r5, r6)     // Catch:{ Exception -> 0x0271 }
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh.bjj006A006Ajj(r2, r3, r0)     // Catch:{ Exception -> 0x0271 }
            com.threatmetrix.TrustDefender.TMXProfilingConnectionsInterface$TMXHttpResponseCode r0 = r1.bt00740074ttt     // Catch:{ Exception -> 0x0271 }
            r0.setHttpResponseCode(r4)     // Catch:{ Exception -> 0x0271 }
            r2 = 0
            return r2
        L_0x02a3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkkhhh.bjjj006Aj006A(java.lang.String, byte[], boolean):javax.net.ssl.HttpsURLConnection");
    }

    public static int bl006C006Clll() {
        return 1;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [byte[], java.lang.String] */
    public int b006A006A006Ajj006A(String str) {
        ? r0 = 0;
        HttpsURLConnection bjjj006Aj006A = bjjj006Aj006A(str, r0, false);
        if (bjjj006Aj006A == null) {
            String str2 = btt0074ttt;
            kkhhhh.b006A006Aj006Ajj(str2, kkhhkh.b006Aj006A006A006A006A("e\u0013\u0013\u0014\f\u000b\u001d\u0013\u001a\u001aL\u0014\u0010\u0019\u001d'%\u0019nU\u001a\u0019'Y)+1]\"2&#7)d)667/.@6==oEAr", Typography.section, 6, 0) + str);
        } else {
            this.btt00740074tt = bjjj006Aj006A.getURL();
            this.b0074t00740074tt = bjjj006Aj006A;
            try {
                int responseCode = bjjj006Aj006A.getResponseCode();
                while (true) {
                    try {
                        r0.length();
                    } catch (Exception unused) {
                        b006Clllll = 80;
                        this.bt00740074ttt.setHttpResponseCode(responseCode);
                        return responseCode;
                    }
                }
            } catch (IOException e) {
                String str3 = btt0074ttt;
                kkhhhh.bjj006A006Ajj(str3, kkhhkh.b006Aj006A006A006A006A("7b`_URbV[Y\nOIPRZVH\u0002\t", 202, 191, 1) + str + kkhhkh.bj006A006A006A006A006A("\u001c,\u0011", 'F', 2), e);
                b006A006A006A006Aj006A(e);
            }
        }
        return this.bt00740074ttt.getHttpResponseCode();
    }

    public TMXProfilingConnectionsInterface.TMXHttpResponseCode b006A006Aj006Aj006A() {
        return this.bt00740074ttt;
    }

    public void b006Aj006Ajj006A() {
        int i = b006Clllll;
        if (((b006C006Cllll + i) * i) % bll006Clll != bl006Cllll) {
            b006Clllll = b006Cl006Clll();
            bl006Cllll = 5;
        }
        HttpsURLConnection httpsURLConnection = this.b0074t00740074tt;
        if (httpsURLConnection != null) {
            httpsURLConnection.disconnect();
            this.b0074t00740074tt = null;
        }
    }

    @Nullable
    public String b006Ajj006Aj006A() {
        try {
            URL url = this.btt00740074tt;
            if (url == null) {
                int i = b006Clllll;
                if (((b006C006Cllll + i) * i) % bll006Clll != bl006Cllll) {
                    b006Clllll = b006Cl006Clll();
                    bl006Cllll = 62;
                }
                return null;
            }
            try {
                return url.getHost();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void b006Ajjjj006A(@Nonnull Map<String, String> map) {
        if (((b006Clllll + bl006C006Clll()) * b006Clllll) % bll006Clll != bl006Cllll) {
            b006Clllll = 37;
            bl006Cllll = 88;
        }
        this.b0074tt0074tt.putAll(map);
    }

    public int bj006A006A006Aj006A(String str, byte[] bArr) {
        try {
            HttpsURLConnection bjjj006Aj006A = bjjj006Aj006A(str, bArr, true);
            if (bjjj006Aj006A == null) {
                return this.bt00740074ttt.getHttpResponseCode();
            }
            this.btt00740074tt = bjjj006Aj006A.getURL();
            try {
                this.b0074t00740074tt = bjjj006Aj006A;
                try {
                    int responseCode = bjjj006Aj006A.getResponseCode();
                    this.bt00740074ttt.setHttpResponseCode(responseCode);
                    return responseCode;
                } catch (IOException e) {
                    String str2 = btt0074ttt;
                    int i = b006Clllll;
                    if (((b006C006Cllll + i) * i) % bll006Clll != bl006Cllll) {
                        b006Clllll = 9;
                        bl006Cllll = b006Cl006Clll();
                    }
                    kkhhhh.bjj006A006Ajj(str2, kkhhkh.bj006A006A006A006A006A("g\u0007\u0015\u0016\u0018\u001eJ\u001c\u001c!#P", 139, 1), e);
                    b006A006A006A006Aj006A(e);
                    return this.bt00740074ttt.getHttpResponseCode();
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    @Nullable
    public InputStream bj006Aj006Aj006A() throws IOException {
        HttpsURLConnection httpsURLConnection = this.b0074t00740074tt;
        if (httpsURLConnection == null) {
            return null;
        }
        InputStream inputStream = httpsURLConnection.getInputStream();
        int b006Cl006Clll = b006Cl006Clll();
        if ((b006Cl006Clll * (bl006C006Clll() + b006Cl006Clll)) % bll006Clll != 0) {
            b006Clllll = 52;
            bl006Cllll = b006Cl006Clll();
        }
        return inputStream;
    }

    @Nullable
    public String bjj006A006Aj006A() {
        URL url = this.btt00740074tt;
        if (url == null) {
            return null;
        }
        return url.toString();
    }
}
