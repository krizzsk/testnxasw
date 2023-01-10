package didihttp;

import android.os.SystemClock;
import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.google.common.net.HttpHeaders;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class ServerCallItem {

    /* renamed from: A */
    private String f59276A;

    /* renamed from: B */
    private List<Certificate> f59277B;

    /* renamed from: C */
    private List<Certificate> f59278C;

    /* renamed from: D */
    private Principal f59279D;

    /* renamed from: E */
    private Principal f59280E;

    /* renamed from: F */
    private long f59281F;

    /* renamed from: G */
    private byte[] f59282G;

    /* renamed from: H */
    private int f59283H;

    /* renamed from: I */
    private Protocol f59284I;

    /* renamed from: J */
    private boolean f59285J;

    /* renamed from: K */
    private long f59286K;

    /* renamed from: L */
    private long f59287L;

    /* renamed from: M */
    private Throwable f59288M;

    /* renamed from: N */
    private boolean f59289N;

    /* renamed from: O */
    private boolean f59290O;

    /* renamed from: P */
    private String f59291P;

    /* renamed from: Q */
    private String f59292Q;

    /* renamed from: R */
    private int f59293R;

    /* renamed from: S */
    private long f59294S = 0;

    /* renamed from: T */
    private int f59295T = -1;

    /* renamed from: a */
    private long f59296a;

    /* renamed from: b */
    private long f59297b;

    /* renamed from: c */
    private long f59298c;

    /* renamed from: d */
    private long f59299d;

    /* renamed from: e */
    private long f59300e;

    /* renamed from: f */
    private long f59301f;

    /* renamed from: g */
    private long f59302g;

    /* renamed from: h */
    private long f59303h;

    /* renamed from: i */
    private long f59304i;

    /* renamed from: j */
    private long f59305j;

    /* renamed from: k */
    private long f59306k;

    /* renamed from: l */
    private long f59307l;

    /* renamed from: m */
    private long f59308m;

    /* renamed from: n */
    private int f59309n = 0;

    /* renamed from: o */
    private long f59310o;

    /* renamed from: p */
    private long f59311p;

    /* renamed from: q */
    private String f59312q;

    /* renamed from: r */
    private String f59313r;

    /* renamed from: s */
    private String f59314s;

    /* renamed from: t */
    private String f59315t;

    /* renamed from: u */
    private InetAddress f59316u;

    /* renamed from: v */
    private int f59317v;

    /* renamed from: w */
    private InetAddress f59318w;

    /* renamed from: x */
    private int f59319x;

    /* renamed from: y */
    private Proxy f59320y;

    /* renamed from: z */
    private TlsVersion f59321z;

    /* renamed from: a */
    private long m44761a(long j) {
        if (j < 0) {
            return 0;
        }
        return j;
    }

    public void traceStart() {
        this.f59297b = SystemClock.uptimeMillis();
        this.f59309n = 1;
        this.f59296a = System.currentTimeMillis();
    }

    public void traceEnd() {
        this.f59298c = SystemClock.uptimeMillis();
        this.f59309n = 12;
    }

    public void traceDnsLookupStart() {
        this.f59299d = SystemClock.uptimeMillis();
        this.f59309n = 2;
    }

    public void traceDnsLookupEnd() {
        this.f59300e = SystemClock.uptimeMillis();
        this.f59309n = 3;
    }

    public void traceConnectStart() {
        this.f59301f = SystemClock.uptimeMillis();
        this.f59309n = 4;
    }

    public void traceConnectEnd() {
        this.f59302g = SystemClock.uptimeMillis();
        this.f59309n = 7;
    }

    public void traceHandShakeStart() {
        this.f59303h = SystemClock.uptimeMillis();
        this.f59309n = 5;
    }

    public void traceHandShakeEnd() {
        this.f59304i = SystemClock.uptimeMillis();
        this.f59309n = 6;
    }

    public void traceRequestSendStart() {
        this.f59305j = SystemClock.uptimeMillis();
        this.f59309n = 8;
    }

    public void traceRequestSendEnd() {
        this.f59306k = SystemClock.uptimeMillis();
        this.f59309n = 9;
    }

    public void traceResponseReceiveStart() {
        this.f59307l = SystemClock.uptimeMillis();
        this.f59309n = 10;
    }

    public void traceResponseReceiveEnd() {
        this.f59308m = SystemClock.uptimeMillis();
        this.f59309n = 11;
    }

    public int getState() {
        int i = this.f59309n;
        if (i - 1 > 10) {
            return 10;
        }
        return i - 1;
    }

    public long getTotalCostTime() {
        return m44761a(this.f59298c - this.f59297b);
    }

    public long getDnsLookupTime() {
        return m44761a(this.f59300e - this.f59299d);
    }

    public long getConnectTime() {
        return m44761a(this.f59302g - this.f59301f);
    }

    public long getHandShakeTime() {
        return m44761a(this.f59304i - this.f59303h);
    }

    public long getRequestSendTime() {
        return m44761a(this.f59306k - this.f59305j);
    }

    public long getResponseReceiveTime() {
        return m44761a(this.f59308m - this.f59307l);
    }

    public long getStartTimeStamp() {
        return this.f59296a;
    }

    public long getStartTime() {
        return this.f59297b;
    }

    public long getEndTime() {
        return this.f59298c;
    }

    public long getDnsLookupStartTime() {
        return this.f59299d;
    }

    public long getDnsLookupEndTime() {
        return this.f59300e;
    }

    public long getConnectStartTime() {
        return this.f59301f;
    }

    public long getConnectEndTime() {
        return this.f59302g;
    }

    public long getSslHandShakeStartTime() {
        return this.f59303h;
    }

    public long getSslHandShakeEndTime() {
        return this.f59304i;
    }

    public long getRequestSendStartTime() {
        return this.f59305j;
    }

    public long getRequestSendEndTime() {
        return this.f59306k;
    }

    public long getResponseReceiveStartTime() {
        return this.f59307l;
    }

    public long getResponseReceiveEndTime() {
        return this.f59308m;
    }

    public String getTimeDescJson() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.f59296a);
        jSONArray.put(m44761a(this.f59299d - this.f59297b));
        jSONArray.put(m44761a(this.f59300e - this.f59297b));
        jSONArray.put(m44761a(this.f59301f - this.f59297b));
        jSONArray.put(m44761a(this.f59303h - this.f59297b));
        jSONArray.put(m44761a(this.f59304i - this.f59297b));
        jSONArray.put(m44761a(this.f59302g - this.f59297b));
        jSONArray.put(m44761a(this.f59305j - this.f59297b));
        jSONArray.put(m44761a(this.f59306k - this.f59297b));
        jSONArray.put(m44761a(this.f59307l - this.f59297b));
        jSONArray.put(m44761a(this.f59308m - this.f59297b));
        return jSONArray.toString();
    }

    public long getSinkCount() {
        return this.f59310o;
    }

    public void setSinkCount(long j) {
        this.f59310o = j;
    }

    public long getSourceCount() {
        return this.f59311p;
    }

    public void setSourceCount(long j) {
        this.f59311p = j;
    }

    public void setRequest(Request request) {
        if (request != null) {
            String header = request.header(HttpHeaders.HOST);
            if (TextUtils.isEmpty(header)) {
                this.f59312q = request.f59254a.f59221l;
            } else {
                this.f59312q = header;
            }
            this.f59313r = request.f59254a.encodedPath();
            this.f59314s = request.f59255b;
            this.f59315t = request.f59254a.f59220k;
            List<String> headers = request.headers("didi-header-rid");
            if (headers != null && !headers.isEmpty()) {
                this.f59291P = headers.get(0);
            }
            List<String> headers2 = request.headers(HttpHeaders.COOKIE);
            this.f59286K = 0;
            for (String bytes : headers2) {
                this.f59286K += (long) bytes.getBytes().length;
            }
        }
    }

    public String getHost() {
        return this.f59312q;
    }

    public String getPath() {
        return this.f59313r;
    }

    public String getMethod() {
        return this.f59314s;
    }

    public String getScheme() {
        return this.f59315t;
    }

    public void setResponse(Response response) {
        this.f59283H = response.f59262c;
        List<String> headers = response.headers("Set-Cookie");
        this.f59287L = 0;
        for (String bytes : headers) {
            this.f59287L += (long) bytes.getBytes().length;
        }
    }

    public int getResponseCode() {
        return this.f59283H;
    }

    public Throwable getThrowable() {
        return this.f59288M;
    }

    public void setThrowable(Throwable th) {
        this.f59288M = th;
    }

    public boolean hasError() {
        return this.f59288M != null;
    }

    public boolean isCloseConnection() {
        return this.f59290O;
    }

    public void setCloseConnection(boolean z) {
        this.f59290O = z;
    }

    public boolean isUseHttpDns() {
        return this.f59289N;
    }

    public void setUseHttpDns(boolean z) {
        this.f59289N = z;
    }

    public void setSocket(Socket socket) {
        if (socket != null) {
            this.f59316u = socket.getInetAddress();
            this.f59317v = socket.getPort();
            this.f59318w = socket.getLocalAddress();
            this.f59319x = socket.getLocalPort();
        }
    }

    public int getRemotePort() {
        return this.f59317v;
    }

    public InetAddress getRemoteAddress() {
        return this.f59316u;
    }

    public InetAddress getLocalAddress() {
        return this.f59318w;
    }

    public int getLocalPort() {
        return this.f59319x;
    }

    public Protocol getProtocol() {
        return this.f59284I;
    }

    public void setProtocol(Protocol protocol) {
        this.f59284I = protocol;
    }

    public boolean isConnReused() {
        return this.f59285J;
    }

    public void setConnReused(boolean z) {
        this.f59285J = z;
    }

    public void setHandShake(Handshake handshake) {
        if (handshake != null) {
            this.f59321z = handshake.tlsVersion();
            this.f59276A = handshake.cipherSuite().javaName();
            this.f59277B = handshake.peerCertificates();
            this.f59278C = handshake.localCertificates();
            this.f59279D = handshake.peerPrincipal();
            this.f59280E = handshake.localPrincipal();
            this.f59281F = 0;
            List<Certificate> list = this.f59277B;
            if (list != null && !list.isEmpty()) {
                for (Certificate next : this.f59277B) {
                    if (next != null) {
                        try {
                            byte[] encoded = next.getEncoded();
                            if (encoded != null) {
                                this.f59281F += (long) encoded.length;
                            }
                        } catch (CertificateEncodingException unused) {
                        }
                    }
                }
            }
            this.f59282G = handshake.getSessionId();
        }
    }

    public TlsVersion getTlsVersion() {
        return this.f59321z;
    }

    public String getCipherSuite() {
        return this.f59276A;
    }

    public List<Certificate> getPeerCertificates() {
        return Collections.unmodifiableList(this.f59277B);
    }

    public List<Certificate> getLocalCertificates() {
        return Collections.unmodifiableList(this.f59278C);
    }

    public Principal getPeerPrincipal() {
        return this.f59279D;
    }

    public Principal getLocalPrincipal() {
        return this.f59280E;
    }

    public String getTraceId() {
        return this.f59291P;
    }

    public Proxy getProxy() {
        return this.f59320y;
    }

    public void setProxy(Proxy proxy) {
        this.f59320y = proxy;
    }

    public long getPeerCertificatesSize() {
        return this.f59281F;
    }

    public long getRequestCookieSize() {
        return this.f59286K;
    }

    public long getResponseSetCookieSize() {
        return this.f59287L;
    }

    public void setConfigVersion(String str) {
        this.f59292Q = str;
    }

    public byte[] getSessionId() {
        return this.f59282G;
    }

    public String getConfigVersion() {
        return this.f59292Q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179618a(Map map) {
        map.put(Constants.STATE_CODE, Integer.valueOf(this.f59283H));
        map.put("up", Long.valueOf(this.f59310o));
        long j = this.f59311p;
        if ("https".equals(this.f59315t) && !this.f59285J) {
            long j2 = j + this.f59281F;
            byte[] bArr = this.f59282G;
            j = j2 + (bArr == null ? 0 : (long) bArr.length);
        }
        map.put("down", Long.valueOf(j));
        map.put("traceid", this.f59291P);
        map.put("method", this.f59314s);
        map.put(Constants.REUSE_CON, Integer.valueOf(this.f59285J ? 1 : 0));
        map.put(Constants.CON_STATE, Integer.valueOf(getState()));
        Protocol protocol = this.f59284I;
        map.put("proto", Integer.valueOf(protocol != null ? protocol.ordinal() : -1));
        map.put("conTimeStamp", getTimeDescJson());
        map.put(Constants.HTTP_DNS, Integer.valueOf(this.f59289N ? 1 : 0));
        InetAddress localAddress = getLocalAddress();
        if (localAddress != null) {
            map.put("localIp", "" + localAddress.getHostAddress());
        }
        InetAddress remoteAddress = getRemoteAddress();
        if (remoteAddress != null) {
            map.put("ip", "" + remoteAddress.getHostAddress());
        }
        long j3 = this.f59286K;
        if (j3 > 0) {
            map.put("reqCkSz", Long.valueOf(j3));
        }
        long j4 = this.f59287L;
        if (j4 > 0) {
            map.put("rspCkSz", Long.valueOf(j4));
        }
        Proxy proxy = getProxy();
        if (!(proxy == null || proxy.type() == Proxy.Type.DIRECT)) {
            map.put("pxy", "" + proxy);
        }
        if (!TextUtils.isEmpty(this.f59292Q)) {
            map.put("cfg", this.f59292Q);
        }
        map.put("appState", Integer.valueOf(this.f59293R));
        long j5 = this.f59294S;
        if (j5 > 0) {
            map.put("bkgDur", Long.valueOf(j5));
        }
        map.put("bootStatus", Integer.valueOf(this.f59295T));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo179619b(Map map) {
        map.put("Protocol", "" + this.f59284I);
        map.put("Scheme", "" + this.f59315t);
        map.put(HttpHeaders.HOST, "" + this.f59312q);
        map.put("Path", "" + this.f59313r);
        map.put("Method", "" + this.f59314s);
        map.put("State", Integer.valueOf(getState()));
        map.put("time", getTimeDescJson());
        map.put("ConnectionReused", Boolean.valueOf(this.f59285J));
        map.put("TraceID", "" + this.f59291P);
        map.put("HttpDNS", Boolean.valueOf(this.f59289N));
        map.put("RemoteAddress", "" + this.f59316u);
        map.put("RemotePort", Integer.valueOf(this.f59317v));
        map.put("LocalAddress", "" + this.f59318w);
        map.put("LocalPort", Integer.valueOf(this.f59319x));
        map.put("Proxy", "" + this.f59320y);
        map.put("tlsVersion", "" + this.f59321z);
        map.put("cipherSuite", "" + this.f59276A);
        map.put("responseCode", Integer.valueOf(this.f59283H));
        map.put("appState", Integer.valueOf(this.f59293R));
        long j = this.f59294S;
        if (j > 0) {
            map.put("bkgDur", Long.valueOf(j));
        }
        map.put("bootStatus", Integer.valueOf(this.f59295T));
    }

    public String toString() {
        return "ServerCallItem{" + "Protocol=" + this.f59284I + ", RemoteAddress=" + this.f59316u + ", RemotePort=" + this.f59317v + ", LocalAddress=" + this.f59318w + ", LocalPort=" + this.f59319x + ", proxy=" + this.f59320y + ", TotalCostTime=" + getTotalCostTime() + ", DnsLookupTime=" + getDnsLookupTime() + ", ConnectTime=" + getConnectTime() + ", HandShakeTime=" + getHandShakeTime() + ", RequestSendTime=" + getRequestSendTime() + ", ResponseReceiveTime=" + getResponseReceiveTime() + ", times=" + getTimeDescJson() + ", ConnectionReused=" + this.f59285J + ", sinkCount=" + this.f59310o + ", sourceCount=" + this.f59311p + ", host='" + this.f59312q + '\'' + ", path='" + this.f59313r + '\'' + ", method='" + this.f59314s + '\'' + ", scheme='" + this.f59315t + '\'' + ", tlsVersion=" + this.f59321z + ", cipherSuite=" + this.f59276A + ", peerCertificatesSize=" + this.f59281F + ", peerPrincipal=" + this.f59279D + ", localPrincipal=" + this.f59280E + ", requestCookieSize=" + this.f59286K + ", responseCode=" + this.f59283H + ", responseSetCookieSize=" + this.f59287L + ", throwable=" + this.f59288M + ", useHttpDns=" + this.f59289N + ", closeConnection=" + this.f59290O + ", state=" + getState() + ", traceId=" + this.f59291P + '}';
    }

    public void setAppState(int i) {
        this.f59293R = i;
    }

    public void setBkgDur(long j) {
        this.f59294S = j;
    }

    public void setBootStatus(int i) {
        this.f59295T = i;
    }
}
