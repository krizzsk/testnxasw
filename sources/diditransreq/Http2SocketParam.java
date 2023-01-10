package diditransreq;

import android.text.TextUtils;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import didinet.Logger;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Http2SocketParam {

    /* renamed from: a */
    private static final String f59944a = "Http2Socket";

    /* renamed from: b */
    private static final String f59945b = "translist";

    /* renamed from: c */
    private static final String f59946c = "timeout";

    /* renamed from: d */
    private static final String f59947d = "compress_base";

    /* renamed from: e */
    private static final String f59948e = "updatetid";

    /* renamed from: f */
    private static final int f59949f = 0;

    /* renamed from: g */
    private static final int f59950g = 1;

    /* renamed from: h */
    private static Http2SocketParam f59951h = null;

    /* renamed from: n */
    private static final int f59952n = 30;

    /* renamed from: i */
    private int f59953i;

    /* renamed from: j */
    private int f59954j = 10;

    /* renamed from: k */
    private int f59955k = 0;

    /* renamed from: l */
    private int f59956l = 0;

    /* renamed from: m */
    private AtomicInteger f59957m = new AtomicInteger(1);

    /* renamed from: o */
    private Map<String, UrlItem> f59958o = new HashMap();

    /* renamed from: p */
    private boolean f59959p;

    private static class UrlItem {
        public static final int RATE_FAIL = 1;
        public static final int RATE_INIT = -1;
        public static final int RATE_SUCCESS = 0;
        float rate;
        volatile int rateStatus;
        String url;

        private UrlItem() {
            this.rateStatus = -1;
        }
    }

    private Http2SocketParam() {
        m45109c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c0, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m45109c() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.f59959p     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r7)
            return
        L_0x0007:
            didinet.ApolloKeySwitcher r0 = didinet.ApolloKeySwitcher.getInstance()     // Catch:{ all -> 0x00c1 }
            java.lang.String r0 = r0.getHttpTransReqKey()     // Catch:{ all -> 0x00c1 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c1 }
            r2 = 0
            if (r1 == 0) goto L_0x0021
            java.lang.String r0 = "Http2Socket"
            java.lang.String r1 = "Apollo key is empty!"
            didinet.Logger.m45047d(r0, r1)     // Catch:{ all -> 0x00c1 }
            r7.f59959p = r2     // Catch:{ all -> 0x00c1 }
            monitor-exit(r7)
            return
        L_0x0021:
            didinet.NetEngine r1 = didinet.NetEngine.getInstance()     // Catch:{ all -> 0x00c1 }
            didinet.ApolloAPI r1 = r1.getApolloAPI()     // Catch:{ all -> 0x00c1 }
            didinet.ApolloAPI$Toggle r0 = r1.getToggle(r0)     // Catch:{ all -> 0x00c1 }
            r1 = 1
            if (r0 == 0) goto L_0x00ac
            boolean r3 = r0.allow()     // Catch:{ all -> 0x00c1 }
            if (r3 == 0) goto L_0x00ac
            r7.f59959p = r1     // Catch:{ all -> 0x00c1 }
            java.lang.String r3 = "Http2Socket"
            java.lang.String r4 = "[%s] Apollo allow => true"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c1 }
            java.lang.String r6 = "Http2Socket"
            r5[r2] = r6     // Catch:{ all -> 0x00c1 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ all -> 0x00c1 }
            didinet.Logger.m45047d(r3, r4)     // Catch:{ all -> 0x00c1 }
            didinet.ApolloAPI$Experiment r0 = r0.getExperiment()     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x009a
            java.lang.String r1 = "translist"
            java.lang.String r3 = ""
            java.lang.Object r1 = r0.getParam(r1, r3)     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00c1 }
            r7.m45108b(r1)     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = "timeout"
            r3 = 10
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00c1 }
            java.lang.Object r1 = r0.getParam(r1, r3)     // Catch:{ all -> 0x00c1 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x00c1 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x00c1 }
            r7.f59954j = r1     // Catch:{ all -> 0x00c1 }
            r3 = 3
            if (r1 >= r3) goto L_0x0075
            r7.f59954j = r3     // Catch:{ all -> 0x00c1 }
        L_0x0075:
            java.lang.String r1 = "compress_base"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00c1 }
            java.lang.Object r1 = r0.getParam(r1, r3)     // Catch:{ all -> 0x00c1 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x00c1 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x00c1 }
            r7.f59955k = r1     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = "updatetid"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00c1 }
            java.lang.Object r0 = r0.getParam(r1, r2)     // Catch:{ all -> 0x00c1 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x00c1 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x00c1 }
            r7.f59956l = r0     // Catch:{ all -> 0x00c1 }
            goto L_0x00bf
        L_0x009a:
            java.lang.String r0 = "Http2Socket"
            java.lang.String r3 = "[%s] Apollo Experiment => null"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c1 }
            java.lang.String r4 = "Http2Socket"
            r1[r2] = r4     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = java.lang.String.format(r3, r1)     // Catch:{ all -> 0x00c1 }
            didinet.Logger.m45047d(r0, r1)     // Catch:{ all -> 0x00c1 }
            goto L_0x00bf
        L_0x00ac:
            r7.f59959p = r2     // Catch:{ all -> 0x00c1 }
            java.lang.String r0 = "Http2Socket"
            java.lang.String r3 = "[%s] Apollo allow => false"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c1 }
            java.lang.String r4 = "Http2Socket"
            r1[r2] = r4     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = java.lang.String.format(r3, r1)     // Catch:{ all -> 0x00c1 }
            didinet.Logger.m45047d(r0, r1)     // Catch:{ all -> 0x00c1 }
        L_0x00bf:
            monitor-exit(r7)
            return
        L_0x00c1:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: diditransreq.Http2SocketParam.m45109c():void");
    }

    /* renamed from: b */
    private void m45108b(String str) {
        boolean isEmpty = TextUtils.isEmpty(str);
        Object[] objArr = new Object[2];
        objArr[0] = f59944a;
        objArr[1] = isEmpty ? "empty" : str;
        Logger.m45047d(f59944a, String.format("[%s] Apollo get translist value => %s", objArr));
        if (!isEmpty) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f59953i = jSONObject.optInt("type", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("l");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.f59958o.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String[] split = optJSONArray.optString(i, "").split(",");
                        if (split.length >= 2) {
                            UrlItem urlItem = new UrlItem();
                            urlItem.url = split[0];
                            try {
                                urlItem.rate = Float.parseFloat(split[1]);
                            } catch (NumberFormatException unused) {
                                urlItem.rate = 0.0f;
                            }
                            this.f59958o.put(urlItem.url, urlItem);
                        }
                    }
                }
            } catch (JSONException e) {
                Logger.m45050e(f59944a, "", e);
            }
        }
    }

    public static Http2SocketParam getParam() {
        if (f59951h == null) {
            synchronized (Http2SocketParam.class) {
                if (f59951h == null) {
                    f59951h = new Http2SocketParam();
                }
            }
        }
        return f59951h;
    }

    /* renamed from: a */
    private boolean m45106a(UrlItem urlItem) {
        if (urlItem.rateStatus == -1) {
            urlItem.rateStatus = m45105a(urlItem.rate) ^ true ? 1 : 0;
        }
        if (urlItem.rateStatus == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo180385a(String str) {
        if (this.f59959p) {
            int i = this.f59953i;
            if (i == 0) {
                return m45110c(str);
            }
            if (i == 1) {
                return !m45110c(str);
            }
        } else if (this.f59957m.get() < 30) {
            this.f59957m.incrementAndGet();
            m45109c();
        }
        return false;
    }

    /* renamed from: c */
    private boolean m45110c(String str) {
        UrlItem urlItem = this.f59958o.get(m45112e(str));
        if (urlItem != null) {
            boolean a = m45106a(urlItem);
            Logger.m45047d(f59944a, String.format("[%s] api mode： [%s] in the white list => %b", new Object[]{f59944a, str, Boolean.valueOf(a)}));
            return a;
        }
        UrlItem urlItem2 = this.f59958o.get(m45112e(m45111d(str)));
        boolean a2 = urlItem2 != null ? m45106a(urlItem2) : false;
        Logger.m45047d(f59944a, String.format("[%s] domain mode： [%s] in the white list => %b", new Object[]{f59944a, str, Boolean.valueOf(a2)}));
        return a2;
    }

    /* renamed from: d */
    private String m45111d(String str) {
        try {
            URL url = new URL(str);
            return url.getProtocol() + HWMapConstant.HTTP.SEPARATOR + url.getHost() + "/*";
        } catch (Exception e) {
            Logger.m45050e(f59944a, "", e);
            return null;
        }
    }

    /* renamed from: e */
    private String m45112e(String str) {
        try {
            URL url = new URL(str);
            return url.getHost() + url.getPath();
        } catch (Exception e) {
            Logger.m45050e(f59944a, "", e);
            return null;
        }
    }

    /* renamed from: a */
    private boolean m45105a(float f) {
        return new Random().nextFloat() < f;
    }

    /* renamed from: a */
    private boolean m45107a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!str.equals("https://" + str2)) {
            if (str.equals("http://" + str2)) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo180384a() {
        return this.f59954j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo180386b() {
        return this.f59955k;
    }

    public int getUpdateTid() {
        return this.f59956l;
    }
}
