package didihttpdns;

import android.os.SystemClock;
import android.text.TextUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import didihttpdns.p233db.DBCacheType;
import didinet.Logger;
import didinet.NetEngine;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HttpDnsApolloConfig {
    public static final String APOLLO_DEGENERATE_IPV6_DETECTOR = "degenerate_ipv6_detector";
    public static final String TAG = "HttpDnsManager";

    /* renamed from: a */
    private static final int f59754a = 86400;

    /* renamed from: b */
    private static HttpDnsApolloConfig f59755b;

    /* renamed from: c */
    private boolean f59756c = false;

    /* renamed from: d */
    private int f59757d = 86400;

    /* renamed from: e */
    private DBCacheType f59758e = DBCacheType.NO_CACHE;

    /* renamed from: f */
    private boolean f59759f = false;

    /* renamed from: g */
    private int f59760g;

    /* renamed from: h */
    private int f59761h;

    /* renamed from: i */
    private boolean f59762i;

    /* renamed from: j */
    private List<String> f59763j = new ArrayList();

    /* renamed from: k */
    private List<String> f59764k = new ArrayList();

    /* renamed from: l */
    private Map<String, Float> f59765l = new HashMap();

    /* renamed from: m */
    private List<String> f59766m = new ArrayList();

    /* renamed from: n */
    private long f59767n;

    /* renamed from: o */
    private boolean f59768o;

    /* renamed from: p */
    private boolean f59769p = false;

    public static HttpDnsApolloConfig getConfig() {
        if (f59755b == null) {
            synchronized (HttpDnsApolloConfig.class) {
                if (f59755b == null) {
                    f59755b = new HttpDnsApolloConfig();
                }
            }
        }
        return f59755b;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:58|59|60|61) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x0210 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo180205a(java.lang.String r13) {
        /*
            r12 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 == 0) goto L_0x000e
            didinet.ApolloKeySwitcher r13 = didinet.ApolloKeySwitcher.getInstance()
            java.lang.String r13 = r13.getHttpDnsKey()
        L_0x000e:
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r13
            java.lang.String r3 = "HttpDns apollo name is [%s]"
            java.lang.String r1 = java.lang.String.format(r3, r1)
            java.lang.String r3 = "HttpDnsManager"
            didinet.Logger.m45047d(r3, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r13)
            if (r1 != 0) goto L_0x0271
            didinet.NetEngine r1 = didinet.NetEngine.getInstance()
            didinet.ApolloAPI r1 = r1.getApolloAPI()
            didinet.ApolloAPI$Toggle r4 = r1.getToggle(r13)
            boolean r4 = r4.allow()
            r12.f59756c = r4
            if (r4 == 0) goto L_0x0271
            didinet.ApolloAPI$Toggle r13 = r1.getToggle(r13)
            didinet.ApolloAPI$Experiment r13 = r13.getExperiment()
            r1 = 86400(0x15180, float:1.21072E-40)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r4 = "min_ttl"
            java.lang.Object r1 = r13.getParam(r4, r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r12.f59757d = r1
            didihttpdns.db.DBCacheType r1 = didihttpdns.p233db.DBCacheType.NO_CACHE
            int r1 = r1.getValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r4 = "use_cache"
            java.lang.Object r1 = r13.getParam(r4, r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != 0) goto L_0x0071
            java.lang.String r4 = "use_cache not allow"
            goto L_0x0082
        L_0x0071:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "use_cache type = "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
        L_0x0082:
            didinet.Logger.m45047d(r3, r4)
            didihttpdns.db.DBCacheType r1 = didihttpdns.p233db.DBCacheType.valueOf((int) r1)
            r12.f59758e = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r4 = "extend_ttl"
            java.lang.Object r1 = r13.getParam(r4, r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r0) goto L_0x009f
            r1 = 1
            goto L_0x00a0
        L_0x009f:
            r1 = 0
        L_0x00a0:
            r12.f59759f = r1
            java.lang.Object[] r4 = new java.lang.Object[r0]
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r4[r2] = r1
            java.lang.String r1 = "extend ttl => [%s]"
            java.lang.String r1 = java.lang.String.format(r1, r4)
            didinet.Logger.m45047d(r3, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r4 = "buffer_time"
            java.lang.Object r1 = r13.getParam(r4, r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r12.f59760g = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r4 = "buffer_count"
            java.lang.Object r1 = r13.getParam(r4, r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r12.f59761h = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = "downgrade"
            java.lang.Object r1 = r13.getParam(r4, r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r0) goto L_0x00eb
            r1 = 1
            goto L_0x00ec
        L_0x00eb:
            r1 = 0
        L_0x00ec:
            r12.f59762i = r1
            java.lang.Object[] r4 = new java.lang.Object[r0]
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r4[r2] = r1
            java.lang.String r1 = "downgrade => [%s]"
            java.lang.String r1 = java.lang.String.format(r1, r4)
            didinet.Logger.m45047d(r3, r1)
            java.lang.String r1 = "bl"
            java.lang.String r4 = ""
            java.lang.Object r1 = r13.getParam(r1, r4)
            java.lang.String r1 = (java.lang.String) r1
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r6 = "parseConfig: "
            if (r5 != 0) goto L_0x0140
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0129 }
            r5.<init>(r1)     // Catch:{ JSONException -> 0x0129 }
            r1 = 0
        L_0x0117:
            int r7 = r5.length()     // Catch:{ JSONException -> 0x0129 }
            if (r1 >= r7) goto L_0x0140
            java.util.List<java.lang.String> r7 = r12.f59763j     // Catch:{ JSONException -> 0x0129 }
            java.lang.String r8 = r5.optString(r1)     // Catch:{ JSONException -> 0x0129 }
            r7.add(r8)     // Catch:{ JSONException -> 0x0129 }
            int r1 = r1 + 1
            goto L_0x0117
        L_0x0129:
            r1 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r6)
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            didinet.Logger.m45047d(r3, r1)
        L_0x0140:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.util.List<java.lang.String> r5 = r12.f59763j
            java.lang.String r5 = r5.toString()
            r1[r2] = r5
            java.lang.String r5 = "blackHosts from Apollo:[%s]"
            java.lang.String r1 = java.lang.String.format(r5, r1)
            didinet.Logger.m45047d(r3, r1)
            java.lang.String r1 = "bg_bl"
            java.lang.Object r1 = r13.getParam(r1, r4)
            java.lang.String r1 = (java.lang.String) r1
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x0190
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0179 }
            r5.<init>(r1)     // Catch:{ JSONException -> 0x0179 }
            r1 = 0
        L_0x0167:
            int r7 = r5.length()     // Catch:{ JSONException -> 0x0179 }
            if (r1 >= r7) goto L_0x0190
            java.util.List<java.lang.String> r7 = r12.f59764k     // Catch:{ JSONException -> 0x0179 }
            java.lang.String r8 = r5.optString(r1)     // Catch:{ JSONException -> 0x0179 }
            r7.add(r8)     // Catch:{ JSONException -> 0x0179 }
            int r1 = r1 + 1
            goto L_0x0167
        L_0x0179:
            r1 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r6)
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            didinet.Logger.m45047d(r3, r1)
        L_0x0190:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.util.List<java.lang.String> r5 = r12.f59764k
            java.lang.String r5 = r5.toString()
            r1[r2] = r5
            java.lang.String r5 = "backgroundBlackHosts:[%s]"
            java.lang.String r1 = java.lang.String.format(r5, r1)
            didinet.Logger.m45047d(r3, r1)
            java.lang.String r1 = "ipv6"
            java.lang.Object r13 = r13.getParam(r1, r4)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "ipv6: "
            r1.append(r5)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = "push-debug"
            didinet.Logger.m45047d(r5, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r13)
            if (r1 != 0) goto L_0x023d
            java.util.Map<java.lang.String, java.lang.Float> r1 = r12.f59765l     // Catch:{ JSONException -> 0x0226 }
            r1.clear()     // Catch:{ JSONException -> 0x0226 }
            java.util.List<java.lang.String> r1 = r12.f59766m     // Catch:{ JSONException -> 0x0226 }
            r1.clear()     // Catch:{ JSONException -> 0x0226 }
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0226 }
            r1.<init>(r13)     // Catch:{ JSONException -> 0x0226 }
            r13 = 0
        L_0x01d7:
            int r7 = r1.length()     // Catch:{ JSONException -> 0x0226 }
            if (r13 >= r7) goto L_0x023d
            java.lang.String r7 = r1.optString(r13, r4)     // Catch:{ JSONException -> 0x0226 }
            java.lang.String r8 = ","
            java.lang.String[] r7 = r7.split(r8)     // Catch:{ JSONException -> 0x0226 }
            if (r7 == 0) goto L_0x0225
            int r8 = r7.length     // Catch:{ JSONException -> 0x0226 }
            if (r8 < r0) goto L_0x0225
            r8 = r7[r2]     // Catch:{ JSONException -> 0x0226 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x0226 }
            if (r8 == 0) goto L_0x01f5
            goto L_0x0225
        L_0x01f5:
            r8 = r7[r2]     // Catch:{ JSONException -> 0x0226 }
            int r9 = r7.length     // Catch:{ JSONException -> 0x0226 }
            r10 = 1065353216(0x3f800000, float:1.0)
            if (r9 != r0) goto L_0x0206
            java.util.Map<java.lang.String, java.lang.Float> r7 = r12.f59765l     // Catch:{ JSONException -> 0x0226 }
            java.lang.Float r9 = java.lang.Float.valueOf(r10)     // Catch:{ JSONException -> 0x0226 }
            r7.put(r8, r9)     // Catch:{ JSONException -> 0x0226 }
            goto L_0x0219
        L_0x0206:
            int r9 = r7.length     // Catch:{ JSONException -> 0x0226 }
            r11 = 2
            if (r9 < r11) goto L_0x0219
            r7 = r7[r0]     // Catch:{ Exception -> 0x0210 }
            float r10 = java.lang.Float.parseFloat(r7)     // Catch:{ Exception -> 0x0210 }
        L_0x0210:
            java.util.Map<java.lang.String, java.lang.Float> r7 = r12.f59765l     // Catch:{ JSONException -> 0x0226 }
            java.lang.Float r9 = java.lang.Float.valueOf(r10)     // Catch:{ JSONException -> 0x0226 }
            r7.put(r8, r9)     // Catch:{ JSONException -> 0x0226 }
        L_0x0219:
            java.util.List<java.lang.String> r7 = r12.f59766m     // Catch:{ JSONException -> 0x0226 }
            java.lang.String r8 = m45014b(r8)     // Catch:{ JSONException -> 0x0226 }
            r7.add(r8)     // Catch:{ JSONException -> 0x0226 }
            int r13 = r13 + 1
            goto L_0x01d7
        L_0x0225:
            return
        L_0x0226:
            r13 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r13 = android.util.Log.getStackTraceString(r13)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            didinet.Logger.m45047d(r3, r13)
        L_0x023d:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "ipv6UrlMap: "
            r13.append(r0)
            java.util.Map<java.lang.String, java.lang.Float> r0 = r12.f59765l
            java.lang.String r0 = r0.toString()
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            didinet.Logger.m45047d(r5, r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "ipv6Hosts: "
            r13.append(r0)
            java.util.List<java.lang.String> r0 = r12.f59766m
            java.lang.String r0 = r0.toString()
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            didinet.Logger.m45047d(r5, r13)
        L_0x0271:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttpdns.HttpDnsApolloConfig.mo180205a(java.lang.String):void");
    }

    /* renamed from: b */
    private static String m45014b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(47);
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<String> mo180204a() {
        return this.f59763j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public List<String> mo180206b() {
        return this.f59764k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo180207c() {
        return this.f59756c;
    }

    public int getMinTTL() {
        return this.f59757d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public DBCacheType mo180208d() {
        return this.f59758e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo180209e() {
        return this.f59759f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo180210f() {
        return this.f59760g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo180211g() {
        return this.f59761h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo180214h() {
        return this.f59760g > 0 && this.f59761h > 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo180215i() {
        return this.f59762i;
    }

    public List<String> getIpv6Hosts() {
        return this.f59766m;
    }

    public boolean isIpv6Permit(String str) {
        Float f;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String d = m45016d(str);
        if (TextUtils.isEmpty(d)) {
            return false;
        }
        Float f2 = this.f59765l.get(d);
        if (f2 != null) {
            return m45013a(f2.floatValue());
        }
        String c = m45015c(str);
        if (!TextUtils.isEmpty(c) && (f = this.f59765l.get(c)) != null) {
            return m45013a(f.floatValue());
        }
        return false;
    }

    public void setEnableIpv6Apollo(boolean z) {
        Logger.m45047d("HttpDnsManager", "[degenerate] Enable Ipv6 Apollo to [" + z + Const.jaRight);
        this.f59769p = z;
    }

    public boolean isEnableIpv6Apollo() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.f59767n >= 60000) {
            this.f59767n = uptimeMillis;
            this.f59768o = NetEngine.getInstance().getApolloAPI().getToggle(APOLLO_DEGENERATE_IPV6_DETECTOR).allow();
            Logger.m45047d("HttpDnsManager", "[degenerate] Update isDegenerate to [" + this.f59768o + Const.jaRight);
        }
        if (this.f59768o) {
            return this.f59769p;
        }
        return true;
    }

    public boolean isDegenerateIpv6Detect() {
        return this.f59768o;
    }

    /* renamed from: c */
    private String m45015c(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception e) {
            Logger.m45050e("HttpDnsManager", "", e);
            return null;
        }
    }

    /* renamed from: d */
    private String m45016d(String str) {
        try {
            URL url = new URL(str);
            return url.getHost() + url.getPath();
        } catch (Exception e) {
            Logger.m45050e("HttpDnsManager", "", e);
            return null;
        }
    }

    /* renamed from: a */
    private boolean m45013a(float f) {
        return new Random().nextFloat() < f;
    }
}
