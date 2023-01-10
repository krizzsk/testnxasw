package didihttp;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.google.firebase.messaging.Constants;
import didihttp.internal.trace.Tree;
import didinet.Logger;
import didinet.NetEngine;
import didinet.NetworkStateManager;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import org.json.JSONArray;

public class StatisticalContext {

    /* renamed from: a */
    private static String f59322a;

    /* renamed from: A */
    private String f59323A;

    /* renamed from: B */
    private TransDGCode f59324B = TransDGCode.NONE;

    /* renamed from: C */
    private StringBuilder f59325C = new StringBuilder();

    /* renamed from: b */
    private DidiHttpClient f59326b;

    /* renamed from: c */
    private Call f59327c;

    /* renamed from: d */
    private LinkedList<ServerCallItem> f59328d = new LinkedList<>();

    /* renamed from: e */
    private int f59329e = 0;

    /* renamed from: f */
    private int f59330f = 0;

    /* renamed from: g */
    private int f59331g = 0;

    /* renamed from: h */
    private Throwable f59332h;

    /* renamed from: i */
    private long f59333i;

    /* renamed from: j */
    private long f59334j;

    /* renamed from: k */
    private long f59335k;

    /* renamed from: l */
    private Dns f59336l;

    /* renamed from: m */
    private List<String> f59337m = new LinkedList();

    /* renamed from: n */
    private Request f59338n;

    /* renamed from: o */
    private Tree f59339o;

    /* renamed from: p */
    private int f59340p;

    /* renamed from: q */
    private long f59341q;

    /* renamed from: r */
    private long f59342r;

    /* renamed from: s */
    private String f59343s;

    /* renamed from: t */
    private String f59344t;

    /* renamed from: u */
    private boolean f59345u;

    /* renamed from: v */
    private boolean f59346v;

    /* renamed from: w */
    private int f59347w;

    /* renamed from: x */
    private int f59348x;

    /* renamed from: y */
    private int f59349y;

    /* renamed from: z */
    private int f59350z;

    static {
        try {
            SSLContext sSLContext = SSLContext.getDefault();
            SSLParameters supportedSSLParameters = sSLContext.getSupportedSSLParameters();
            SSLParameters defaultSSLParameters = sSLContext.getDefaultSSLParameters();
            Logger.m45047d("DidiHttp", "sslParameters.getProtocols = " + Arrays.toString(supportedSSLParameters.getProtocols()));
            Logger.m45047d("DidiHttp", "sslParameters.getProtocols = " + Arrays.toString(defaultSSLParameters.getProtocols()));
            f59322a = Arrays.toString(defaultSSLParameters.getProtocols()) + "/" + Arrays.toString(supportedSSLParameters.getProtocols());
        } catch (Exception unused) {
        }
    }

    StatisticalContext(DidiHttpClient didiHttpClient, Call call) {
        this.f59326b = didiHttpClient;
        this.f59327c = call;
    }

    public void newServerCallData() {
        this.f59328d.add(new ServerCallItem());
    }

    public ServerCallItem currentServerCallData() {
        if (this.f59328d.isEmpty()) {
            this.f59328d.add(new ServerCallItem());
        }
        return this.f59328d.getLast();
    }

    public void setUrlConfigVer(int i) {
        this.f59350z = i;
    }

    public void setIpStack(String str) {
        this.f59323A = str;
    }

    public void addRetryHDnsCount() {
        this.f59329e++;
    }

    public void addRetryCount() {
        this.f59330f++;
    }

    public void addRedirectCount() {
        this.f59331g++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179701a(Throwable th) {
        this.f59332h = th;
    }

    public DidiHttpClient getDidiHttpClient() {
        return this.f59326b;
    }

    public Call getCall() {
        return this.f59327c;
    }

    public int getRetryCount() {
        return this.f59330f;
    }

    public int getRedirectCount() {
        return this.f59331g;
    }

    public Throwable getError() {
        return this.f59332h;
    }

    public Throwable getRootCause() {
        return m44766b(this.f59332h);
    }

    /* renamed from: b */
    private Throwable m44766b(Throwable th) {
        if (th == null) {
            return null;
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public boolean hasError() {
        return this.f59332h != null;
    }

    public void traceTotalStartTime() {
        this.f59333i = SystemClock.uptimeMillis();
    }

    public long getTotalStartTime() {
        return this.f59333i;
    }

    public void traceExecuteTime() {
        this.f59334j = SystemClock.uptimeMillis();
    }

    public void traceTotalEndTime() {
        this.f59335k = SystemClock.uptimeMillis();
    }

    public long getTotalTimeCost() {
        return this.f59335k - this.f59333i;
    }

    public long getWaitTimeCost() {
        long j = this.f59334j;
        long j2 = this.f59333i;
        if (j > j2) {
            return j - j2;
        }
        return 0;
    }

    public Collection<ServerCallItem> getServerCallDatas() {
        return Collections.unmodifiableList(this.f59328d);
    }

    public Dns getCustomDns() {
        return this.f59336l;
    }

    public void setCustomDns(Dns dns) {
        this.f59336l = dns;
    }

    public void addFailIP(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f59337m.add(str);
        }
    }

    public void addFailIP(InetAddress inetAddress) {
        if (inetAddress != null) {
            addFailIP(inetAddress.getHostAddress());
        }
    }

    public void appendRawHttpData(String str) {
        this.f59325C.append(str);
    }

    /* renamed from: a */
    private String m44764a() {
        return Base64.encodeToString(this.f59325C.toString().getBytes(), 2);
    }

    public void addDataToOmega(Map map) {
        currentServerCallData().mo179618a(map);
        map.put("netLib", "v1");
        map.put("redirectNum", Integer.valueOf(this.f59331g));
        map.put("retryHDns", Integer.valueOf(this.f59329e));
        map.put("retry", Integer.valueOf(this.f59330f));
        map.put("llstate", Integer.valueOf(this.f59340p));
        map.put("transDGCode", Integer.valueOf(this.f59324B.getValue()));
        map.put("transAckMs", Long.valueOf(getTransAckCost()));
        if (!TextUtils.isEmpty(this.f59323A)) {
            map.put("ipStack", this.f59323A);
        }
        NetworkStateManager networkStateManager = NetEngine.getInstance().getNetworkStateManager();
        if (networkStateManager != null) {
            if (!networkStateManager.isWifiAvailable()) {
                map.put("dcs", Integer.valueOf(networkStateManager.getDataConnectionState()));
                map.put("oss", Integer.valueOf(networkStateManager.getOperatorServiceState()));
            }
            String httpProxyInfo = networkStateManager.getHttpProxyInfo();
            if (!TextUtils.isEmpty(httpProxyInfo)) {
                map.put("proxy", httpProxyInfo);
            }
            String vpnInfo = networkStateManager.getVpnInfo();
            if (!TextUtils.isEmpty(vpnInfo)) {
                map.put("vpn", vpnInfo);
            }
        }
        map.put("time", Long.valueOf(getTotalTimeCost()));
        map.put(ParamKeys.PARAM_WAIT_TIME, Long.valueOf(getWaitTimeCost()));
        if (!"".equals(this.f59325C.toString())) {
            map.put(Constants.MessagePayloadKeys.RAW_DATA, m44764a());
        }
        int i = this.f59350z;
        if (i != 0) {
            map.put("urlConfVer", Integer.valueOf(i));
        }
        try {
            if (!this.f59337m.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String put : this.f59337m) {
                    jSONArray.put(put);
                }
                map.put("failIPs", "" + jSONArray);
            }
        } catch (Exception unused) {
        }
        if (hasError()) {
            map.put(com.didichuxing.mas.sdk.quality.report.utils.Constants.ERROR_CODE, -1);
            map.put("e", getRootCause());
        } else {
            map.put(com.didichuxing.mas.sdk.quality.report.utils.Constants.ERROR_CODE, 0);
        }
        map.put("pushStat", Integer.valueOf(this.f59349y));
        if (!TextUtils.isEmpty(this.f59343s)) {
            map.put("transAddr", this.f59343s);
            if (!TextUtils.isEmpty(this.f59344t)) {
                map.put("pushVer", this.f59344t);
            }
            map.put("pushTLS", Integer.valueOf(this.f59345u ? 2 : 1));
            map.put("is_multi", Integer.valueOf(this.f59347w));
            map.put("conf_ver", Integer.valueOf(this.f59348x));
        }
        Tree tree = this.f59339o;
        if (tree != null) {
            String icpCost = tree.getIcpCost();
            if (!TextUtils.isEmpty(icpCost)) {
                map.put("icpCost", icpCost);
            }
        }
        if (Build.VERSION.SDK_INT > 19) {
            map.put("ssl_proto", m44765b());
        }
    }

    public void addDataToLocalStorage(Map map) {
        if (hasError()) {
            currentServerCallData().mo179619b(map);
            map.put("e", Log.getStackTraceString(this.f59332h));
            map.put("llstate", Integer.valueOf(this.f59340p));
            return;
        }
        ServerCallItem currentServerCallData = currentServerCallData();
        map.put("HttpDNS", Boolean.valueOf(currentServerCallData.isUseHttpDns()));
        map.put("responseCode", Integer.valueOf(currentServerCallData.getResponseCode()));
        map.put("llstate", Integer.valueOf(this.f59340p));
    }

    /* renamed from: b */
    private String m44765b() {
        String str = f59322a;
        return str == null ? "[TLSv1.3, TLSv1.2, TLSv1.1, TLSv1]" : str;
    }

    public int getLonglinkState() {
        return this.f59340p;
    }

    public void setLonglinkState(int i) {
        this.f59340p = i;
    }

    public void traceTransAckStart() {
        this.f59341q = SystemClock.uptimeMillis();
    }

    public void traceTransAckEnd() {
        this.f59342r = SystemClock.uptimeMillis();
    }

    public long getTransAckCost() {
        long j = this.f59342r - this.f59341q;
        if (j > 0) {
            return j;
        }
        return 0;
    }

    public Request getRequest() {
        Request request = this.f59338n;
        return request == null ? this.f59327c.request() : request;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179700a(Request request) {
        this.f59338n = request;
    }

    public void setTransDGCode(TransDGCode transDGCode) {
        this.f59324B = transDGCode;
    }

    public TransDGCode getTransDGCode() {
        return this.f59324B;
    }

    public void setPushTLS(boolean z) {
        this.f59345u = z;
    }

    public boolean isHaveUsedTrans() {
        return this.f59346v;
    }

    public void setHaveUsedTrans(boolean z) {
        this.f59346v = z;
    }

    public void setIsPushMulti(int i) {
        this.f59347w = i;
    }

    public void setPushConfVer(int i) {
        this.f59348x = i;
    }

    public void setPushState(int i) {
        this.f59349y = i;
    }

    public enum TransDGCode {
        NONE(-1),
        TransReqDGRCodeOK(0),
        TransReqDGRCodePushNotConnected(1),
        TransReqDGRCodeApolloNotAllow(2),
        TransReqDGRCodeTransError(3),
        TransReqDGRCodeServerNotSupport(4),
        TransReqDGRCodeSetDisable(5),
        TransReqDGRCodeDecodeError(6),
        TransReqDGRCodeServerError(7),
        TransReqDGRCodeWaitTimeout(8),
        TransReqDGRCodeDataTooLarge(9),
        TransReqDGRCodePushNotInited(10),
        TransReqDGRCodeServerLimit(11);
        
        private int value;

        private TransDGCode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public void setTransAddr(String str) {
        this.f59343s = str;
    }

    public void setPushVer(String str) {
        this.f59344t = str;
    }

    public void setInterceptorCallTree(Tree tree) {
        this.f59339o = tree;
    }
}
