package com.didi.sdk.connectivity;

import com.didi.raven.config.RavenKey;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConnectivityStatistics {

    /* renamed from: n */
    private static final SimpleDateFormat f38499n = new SimpleDateFormat("yyyyMMdd_HH:mm:ss.SSS");

    /* renamed from: a */
    long f38500a;

    /* renamed from: b */
    long f38501b;

    /* renamed from: c */
    int f38502c;

    /* renamed from: d */
    double f38503d;

    /* renamed from: e */
    double f38504e;

    /* renamed from: f */
    int f38505f;

    /* renamed from: g */
    int f38506g;

    /* renamed from: h */
    int f38507h;

    /* renamed from: i */
    String f38508i = "";

    /* renamed from: j */
    String f38509j = "UNKNOWN";

    /* renamed from: k */
    ConnectivityStatus f38510k;

    /* renamed from: l */
    ConnectivityStatusSource f38511l;

    /* renamed from: m */
    List<ConnStat> f38512m = new ArrayList();

    public int getId() {
        return this.f38502c;
    }

    public int getStatus() {
        return this.f38510k.getValue();
    }

    public String getErrsPack() {
        return this.f38508i;
    }

    public int getSource() {
        return this.f38511l.getValue();
    }

    public String getTaskTime() {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.jaLeft);
        String str = "0";
        sb.append(this.f38500a > 0 ? f38499n.format(new Date(this.f38500a)) : str);
        sb.append(", ");
        if (this.f38501b > 0) {
            str = f38499n.format(new Date(this.f38501b));
        }
        sb.append(str);
        sb.append(Const.jaRight);
        return sb.toString();
    }

    /* renamed from: a */
    static ConnectivityStatistics m29030a(Config config, List<ConnStat> list, String str, long j) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ConnectivityStatistics connectivityStatistics = new ConnectivityStatistics();
        connectivityStatistics.f38502c = C12991b.m29059a();
        connectivityStatistics.f38505f = list.size();
        connectivityStatistics.f38500a = j;
        connectivityStatistics.f38501b = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i = list.get(0).errno;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        for (ConnStat next : list) {
            int i5 = next.errno;
            sb.append(i5);
            sb.append(",");
            if (i5 != i2 && !z) {
                z = true;
            }
            if (next.success) {
                i3++;
                i4 += next.cost;
            }
            i2 = i5;
        }
        if (z) {
            connectivityStatistics.f38508i = sb.deleteCharAt(sb.length() - 1).toString();
        } else {
            connectivityStatistics.f38508i = String.valueOf(i2);
        }
        double d = (double) i3;
        connectivityStatistics.f38503d = ((double) Math.round((d * 100.0d) / ((double) list.size()))) / 100.0d;
        connectivityStatistics.f38504e = i3 != 0 ? ((double) Math.round((((double) i4) * 100.0d) / d)) / 100.0d : 0.0d;
        if (connectivityStatistics.f38503d > 0.0d) {
            connectivityStatistics.f38510k = ConnectivityStatus.REACHABLE;
        } else {
            connectivityStatistics.f38510k = ConnectivityStatus.UNREACHABLE;
        }
        connectivityStatistics.f38511l = ConnectivityStatusSource.TCP_CONNECT;
        connectivityStatistics.f38512m.addAll(list);
        connectivityStatistics.f38506g = config.f38478a;
        connectivityStatistics.f38507h = config.f38479b;
        connectivityStatistics.f38509j = str;
        m29033a(config.f38481d, connectivityStatistics);
        return connectivityStatistics;
    }

    /* renamed from: a */
    static ConnectivityStatistics m29031a(String str) {
        ConnectivityStatistics connectivityStatistics = new ConnectivityStatistics();
        connectivityStatistics.f38502c = C12991b.m29059a();
        connectivityStatistics.f38510k = ConnectivityStatus.UNKNOWN;
        connectivityStatistics.f38511l = ConnectivityStatusSource.UNKNOWN;
        connectivityStatistics.f38509j = str;
        connectivityStatistics.f38500a = System.currentTimeMillis();
        connectivityStatistics.f38501b = System.currentTimeMillis();
        return connectivityStatistics;
    }

    /* renamed from: a */
    static ConnectivityStatistics m29029a(Config config) {
        ConnectivityStatistics connectivityStatistics = new ConnectivityStatistics();
        connectivityStatistics.f38502c = C12991b.m29059a();
        connectivityStatistics.f38510k = ConnectivityStatus.REACHABLE;
        connectivityStatistics.f38511l = ConnectivityStatusSource.REQUEST_SUCCESS;
        connectivityStatistics.f38506g = config.f38478a;
        connectivityStatistics.f38507h = config.f38479b;
        connectivityStatistics.f38500a = System.currentTimeMillis();
        connectivityStatistics.f38501b = System.currentTimeMillis();
        m29033a(config.f38481d, connectivityStatistics);
        return connectivityStatistics;
    }

    /* renamed from: a */
    static ConnectivityStatistics m29032a(boolean z, Config config, String str) {
        ConnectivityStatistics connectivityStatistics = new ConnectivityStatistics();
        connectivityStatistics.f38502c = C12991b.m29059a();
        connectivityStatistics.f38510k = z ? ConnectivityStatus.REACHABLE : ConnectivityStatus.UNREACHABLE;
        connectivityStatistics.f38511l = ConnectivityStatusSource.NETWORK_CHANGED;
        connectivityStatistics.f38509j = str;
        connectivityStatistics.f38500a = System.currentTimeMillis();
        connectivityStatistics.f38501b = System.currentTimeMillis();
        connectivityStatistics.f38506g = config.f38478a;
        connectivityStatistics.f38507h = config.f38479b;
        m29033a(config.f38481d, connectivityStatistics);
        return connectivityStatistics;
    }

    public String toString() {
        return "ConnectivityStatistics{id = " + this.f38502c + ", version = " + this.f38506g + ", confVersion = " + this.f38507h + ", time = " + getTaskTime() + ", net = " + this.f38509j + ", taskCount = " + this.f38505f + ", succRate = " + this.f38503d + ", averCost = " + this.f38504e + ", errsPack = " + this.f38508i + ", details = " + this.f38512m.toString() + "}";
    }

    /* renamed from: a */
    private static void m29033a(double d, ConnectivityStatistics connectivityStatistics) {
        if (((double) new Random().nextFloat()) < d) {
            OmegaSDKAdapter.trackEvent("net_connectivity", connectivityStatistics.mo97867a());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, Object> mo97867a() {
        HashMap hashMap = new HashMap();
        hashMap.put(RavenKey.TYPE, getTaskTime());
        hashMap.put("id", Integer.valueOf(this.f38502c));
        hashMap.put("ver", Integer.valueOf(this.f38506g));
        hashMap.put("conf_ver", Integer.valueOf(this.f38507h));
        hashMap.put("net", this.f38509j);
        hashMap.put("status", Integer.valueOf(this.f38510k.getValue()));
        hashMap.put("status_source", Integer.valueOf(this.f38511l.getValue()));
        if (this.f38511l == ConnectivityStatusSource.TCP_CONNECT) {
            hashMap.put("task_count", Integer.valueOf(this.f38505f));
            hashMap.put("succ_rate", Double.valueOf(this.f38503d));
            hashMap.put("avg_delay", Double.valueOf(this.f38504e));
            hashMap.put("errs_pack", this.f38508i);
            JSONArray jSONArray = new JSONArray();
            for (ConnStat json : this.f38512m) {
                JSONObject json2 = json.toJson();
                if (json2 != null) {
                    jSONArray.put(json2);
                }
            }
            hashMap.put("l", jSONArray.toString());
        }
        return hashMap;
    }
}
