package com.didi.sdk.connectivity;

import android.util.Log;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import didinet.ApolloAPI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class Config {

    /* renamed from: a */
    int f38478a;

    /* renamed from: b */
    int f38479b;

    /* renamed from: c */
    int f38480c;

    /* renamed from: d */
    double f38481d;

    /* renamed from: e */
    int f38482e;

    /* renamed from: f */
    int f38483f = -1;

    /* renamed from: g */
    int f38484g = -1;

    /* renamed from: h */
    int f38485h;

    /* renamed from: i */
    List<Item> f38486i = Collections.emptyList();

    Config() {
    }

    /* renamed from: a */
    static Config m29022a(ApolloAPI.Experiment experiment) {
        try {
            Config config = new Config();
            int intValue = ((Integer) experiment.getParam(RavenKey.VERSION, 0)).intValue();
            config.f38478a = intValue;
            if (intValue != 1) {
                return null;
            }
            config.f38479b = ((Integer) experiment.getParam("conf_ver", 0)).intValue();
            config.f38480c = ((Integer) experiment.getParam("timeout", 5)).intValue();
            config.f38482e = ((Integer) experiment.getParam("min_interval", 10)).intValue();
            config.f38481d = ((Double) experiment.getParam("report_rate", Double.valueOf(0.5d))).doubleValue();
            config.f38483f = ((Integer) experiment.getParam("ping_cnt", -1)).intValue();
            config.f38484g = ((Integer) experiment.getParam("tracert_ttl", -1)).intValue();
            config.f38485h = ((Integer) experiment.getParam("tracert_timeout", -1)).intValue();
            List<Item> parse = Item.parse(new JSONArray((String) experiment.getParam("l", "")));
            if (parse != null) {
                for (Item next : parse) {
                    if (next.timeout <= 0) {
                        next.timeout = config.f38480c;
                    }
                }
                config.f38486i = new ArrayList(parse);
                return config;
            }
            return null;
        } catch (Throwable th) {
            SystemUtils.log(3, "didi-connectivity", Log.getStackTraceString(th), (Throwable) null, "com.didi.sdk.connectivity.Config", 100);
        }
    }

    static class Item {
        String host;

        /* renamed from: ip */
        String f38487ip;
        int pingCnt;
        int port;
        int timeout;
        int trMaxTTL;
        int trTimeout;

        @Deprecated
        Item(String str, int i, int i2) {
            this(str, i, i2, -1, -1, -1);
        }

        Item(String str, int i, int i2, int i3, int i4, int i5) {
            this.host = str;
            this.f38487ip = str;
            this.port = i;
            this.timeout = i2;
            this.pingCnt = i3;
            this.trMaxTTL = i4;
            this.trTimeout = i5;
        }

        static List<Item> parse(JSONArray jSONArray) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(parse(jSONArray.optJSONObject(i)));
                }
                return arrayList;
            } catch (Throwable th) {
                SystemUtils.log(3, "connectivity", Log.getStackTraceString(th), (Throwable) null, "com.didi.sdk.connectivity.Config$Item", 156);
                return null;
            }
        }

        static Item parse(JSONObject jSONObject) {
            try {
                return new Item(jSONObject.getString("host"), jSONObject.getInt("port"), jSONObject.optInt("timeout"), jSONObject.optInt("ping_cnt", -1), jSONObject.optInt("tracert_ttl", -1), jSONObject.optInt("tracert_timeout", -1));
            } catch (Exception e) {
                SystemUtils.log(3, "connectivity", Log.getStackTraceString(e), (Throwable) null, "com.didi.sdk.connectivity.Config$Item", 170);
                return null;
            }
        }

        public String toString() {
            return "Item{host='" + this.host + '\'' + ", ip='" + this.f38487ip + '\'' + ", port=" + this.port + ", timeout=" + this.timeout + ", pingCnt=" + this.pingCnt + ", trMaxTTL=" + this.trMaxTTL + ", trTimeout=" + this.trTimeout + '}';
        }
    }

    public String toString() {
        return "Config{version=" + this.f38478a + ", confVersion=" + this.f38479b + ", timeout=" + this.f38480c + ", reportRate=" + this.f38481d + ", minInterval=" + this.f38482e + ", pingCnt=" + this.f38483f + ", trMaxTTL=" + this.f38484g + ", trTimeout=" + this.f38485h + ", items=" + this.f38486i + '}';
    }
}
