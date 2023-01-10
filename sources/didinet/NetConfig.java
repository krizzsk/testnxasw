package didinet;

import android.text.TextUtils;
import didihttp.HttpUrl;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetConfig {
    public static final int DEFAULT_CONNECT_TIMEOUT = 10000;
    public static final int DEFAULT_READ_TIMEOUT = 10000;
    public static final int DEFAULT_WRITE_TIMEOUT = 10000;

    /* renamed from: a */
    static final NetConfig f59849a = new NetConfig();

    /* renamed from: b */
    private static final int f59850b = 4000;

    /* renamed from: c */
    private static final int f59851c = -1;

    /* renamed from: d */
    private static final int f59852d = 0;

    /* renamed from: e */
    private static final String f59853e = "default";

    /* renamed from: f */
    private static final double f59854f = 2.0d;

    /* renamed from: g */
    private static final double f59855g = 1.2d;

    /* renamed from: h */
    private static final double f59856h = 1.0d;

    /* renamed from: i */
    private static final double f59857i = 1.0d;

    /* renamed from: j */
    private static final double f59858j = 1.2d;

    /* renamed from: k */
    private static final boolean f59859k = false;

    /* renamed from: l */
    private String f59860l;

    /* renamed from: m */
    private int f59861m;

    /* renamed from: n */
    private int f59862n;

    /* renamed from: o */
    private int f59863o;

    /* renamed from: p */
    private int f59864p;

    /* renamed from: q */
    private int f59865q;

    /* renamed from: r */
    private int f59866r;

    /* renamed from: s */
    private double f59867s;

    /* renamed from: t */
    private double f59868t;

    /* renamed from: u */
    private double f59869u;

    /* renamed from: v */
    private double f59870v;

    /* renamed from: w */
    private double f59871w;

    /* renamed from: x */
    private boolean f59872x;

    /* renamed from: y */
    private List<UrlConfig> f59873y;

    private NetConfig() {
        m45059a();
    }

    /* renamed from: a */
    private void m45059a() {
        this.f59860l = "default";
        this.f59861m = 10000;
        this.f59862n = 10000;
        this.f59863o = 10000;
        this.f59864p = 4000;
        this.f59865q = 0;
        this.f59867s = 2.0d;
        this.f59868t = 1.2d;
        this.f59869u = 1.0d;
        this.f59870v = 1.0d;
        this.f59871w = 1.2d;
        this.f59872x = false;
    }

    NetConfig(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f59860l = jSONObject.optString("ver", "default");
            this.f59861m = jSONObject.optInt("conn_tmo", 10000);
            this.f59862n = jSONObject.optInt("read_tmo", 10000);
            this.f59863o = jSONObject.optInt("wrt_tmo", 10000);
            this.f59864p = jSONObject.optInt("rtry_tmo", 4000);
            this.f59865q = jSONObject.optInt("rtry_total_tmo", 0);
            this.f59866r = jSONObject.optInt("raw_data", 0);
            this.f59867s = jSONObject.optDouble("rat_2", 2.0d);
            this.f59868t = jSONObject.optDouble("rat_3", 1.2d);
            this.f59869u = jSONObject.optDouble("rat_4", 1.0d);
            this.f59870v = jSONObject.optDouble("rat_wifi", 1.0d);
            this.f59871w = jSONObject.optDouble("rat_https", 1.2d);
            this.f59872x = jSONObject.optBoolean("pst_conn", false);
            this.f59873y = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    UrlConfig parse = UrlConfig.parse(optJSONArray.getJSONObject(i));
                    if (parse != null) {
                        this.f59873y.add(parse);
                    }
                }
            }
            String simpleName = getClass().getSimpleName();
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (this.f59873y == null) {
                str2 = "null";
            } else {
                str2 = Arrays.toString(this.f59873y.toArray());
            }
            objArr[1] = str2;
            Logger.m45047d(simpleName, String.format("NetConfig => data : %s \n urlConfigs : %s", objArr));
        } catch (JSONException unused) {
            m45059a();
        }
    }

    public String getVersion() {
        return this.f59860l;
    }

    /* renamed from: a */
    private int m45058a(long j, NetworkStateManager networkStateManager, boolean z) {
        double d;
        double d2 = 1.0d;
        if (networkStateManager != null) {
            if (networkStateManager.isWifiAvailable()) {
                d = this.f59870v;
            } else if (networkStateManager.isMobileAvailable()) {
                int networkClass = networkStateManager.getNetworkClass();
                if (networkClass == 200) {
                    d = this.f59867s;
                } else if (networkClass == 300) {
                    d = this.f59868t;
                } else if (networkClass == 400) {
                    d = this.f59869u;
                }
            }
            d2 = 1.0d * d;
        }
        if (z) {
            d2 *= this.f59871w;
        }
        return (int) ((((double) j) * d2) + 0.5d);
    }

    public int getConnectTimeout(NetworkStateManager networkStateManager, boolean z) {
        return m45058a((long) this.f59861m, networkStateManager, z);
    }

    public int getReadTimeout(NetworkStateManager networkStateManager, boolean z) {
        return m45058a((long) this.f59862n, networkStateManager, z);
    }

    public int getWriteTimeout(NetworkStateManager networkStateManager, boolean z) {
        return m45058a((long) this.f59863o, networkStateManager, z);
    }

    public boolean usePositiveConnection() {
        return this.f59872x;
    }

    public boolean useTotalTimeout() {
        return this.f59865q > 0;
    }

    public int getRetryTimeout() {
        return this.f59864p;
    }

    public boolean isReportRawData() {
        return this.f59866r > 0;
    }

    public UrlConfig getUrlConfig(HttpUrl httpUrl) {
        List<UrlConfig> list;
        if (!(httpUrl == null || (list = this.f59873y) == null)) {
            for (UrlConfig next : list) {
                if (next.isWhiteList()) {
                    for (UrlItem urlItem : next.urlItemList) {
                        if (urlItem.url.equals(getHostApi(httpUrl.toString())) && m45060a(urlItem.rate)) {
                            return next;
                        }
                    }
                    continue;
                } else {
                    boolean z = false;
                    for (UrlItem urlItem2 : next.urlItemList) {
                        if (urlItem2.url.equals(getHostApi(httpUrl.toString()))) {
                            z = true;
                        }
                    }
                    if (!z) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m45060a(float f) {
        return new Random().nextFloat() < f;
    }

    public String getHostApi(String str) {
        try {
            URL url = new URL(str);
            return url.getHost() + url.getPath();
        } catch (Exception e) {
            Logger.m45050e(getClass().getSimpleName(), "", e);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f59860l;
        String str2 = ((NetConfig) obj).f59860l;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f59860l;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public static class UrlConfig {
        static final int TYPE_BLACK_LIST = -1;
        static final int TYPE_WHITE_LIST = 0;
        private int listType;
        private int reportRawData;
        private int retryMaxCount;
        private int retryTotalTimeout;
        private int retryWaitBase;
        private int retryWaitRandom;
        /* access modifiers changed from: private */
        public List<UrlItem> urlItemList;

        /* access modifiers changed from: package-private */
        public boolean isWhiteList() {
            return this.listType >= 0;
        }

        public boolean isReportRawData() {
            return this.reportRawData > 0;
        }

        public int getListType() {
            return this.listType;
        }

        public int getRetryMaxCount() {
            return this.retryMaxCount;
        }

        public int getRetryTotalTimeout() {
            return this.retryTotalTimeout;
        }

        public void sleepRetryInterval() {
            if (!NetEngine.getInstance().getNetworkStateManager().isNetAvailable()) {
                try {
                    Thread.sleep(this.retryWaitBase + this.retryWaitRandom > 0 ? (long) new Random().nextInt(this.retryWaitRandom) : 0);
                } catch (InterruptedException e) {
                    String simpleName = getClass().getSimpleName();
                    Logger.m45049e(simpleName, "sleepRetryInterval occur error:" + e.getMessage());
                }
            }
        }

        public String toString() {
            return "UrlConfig { listType = " + this.listType + ",\n\t retryMaxCount = " + this.retryMaxCount + ",\n\t retryTotalTimeout = " + this.retryTotalTimeout + ",\n\t retryWaitBase = " + this.retryWaitBase + ",\n\t retryWaitRandom = " + this.retryWaitRandom + ",\n\t reportRawData = " + this.reportRawData + ",\n\t urlItemList = " + Arrays.toString(this.urlItemList.toArray()) + "\n}";
        }

        static UrlConfig parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    UrlConfig urlConfig = new UrlConfig();
                    urlConfig.urlItemList = new ArrayList();
                    urlConfig.listType = jSONObject.optInt("type", 0);
                    urlConfig.retryMaxCount = jSONObject.optInt("rtry_max_cnt", -1);
                    urlConfig.retryTotalTimeout = jSONObject.optInt("rtry_total_tmo", 0);
                    urlConfig.reportRawData = jSONObject.optInt("raw_data", 0);
                    urlConfig.retryWaitBase = jSONObject.optInt("wait_base");
                    urlConfig.retryWaitRandom = jSONObject.optInt("wait_random");
                    JSONArray jSONArray = jSONObject.getJSONArray("urls");
                    int i = 0;
                    while (jSONArray != null && i < jSONArray.length()) {
                        String optString = jSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            String[] split = optString.split(",");
                            UrlItem urlItem = new UrlItem();
                            urlItem.url = split[0];
                            urlItem.rate = split.length > 1 ? Float.valueOf(split[1]).floatValue() : 1.0f;
                            urlConfig.urlItemList.add(urlItem);
                        }
                        i++;
                    }
                    return urlConfig;
                } catch (Throwable th) {
                    Logger.m45049e("NetConfig", "UrlConfig => parse Error : " + jSONObject);
                    th.printStackTrace();
                }
            }
            return null;
        }
    }

    private static class UrlItem {
        float rate;
        String url;

        private UrlItem() {
        }

        public String toString() {
            return this.url + ", " + this.rate;
        }
    }
}
