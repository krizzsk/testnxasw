package com.didichuxing.mas.sdk.quality.collect.duration;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DurationEvent {

    /* renamed from: a */
    private static final String f50639a = "OMGDE";

    /* renamed from: b */
    private String f50640b;

    /* renamed from: c */
    private long f50641c = System.currentTimeMillis();

    /* renamed from: d */
    private long f50642d;

    /* renamed from: e */
    private Map<String, SubDurationEvent> f50643e = new HashMap();

    public DurationEvent(String str) {
        this.f50640b = str;
    }

    public void endMain() {
        this.f50642d = System.currentTimeMillis() - this.f50641c;
    }

    public void startSub(String str) {
        if (!this.f50643e.containsKey(str)) {
            this.f50643e.put(str, new SubDurationEvent(str));
        } else if (MASConfig.LOG_PAGE_DURATION) {
            SystemUtils.log(3, f50639a, str + "  has already start!", (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.duration.DurationEvent", 39);
        }
    }

    public void endSub(String str) {
        if (this.f50643e.containsKey(str)) {
            this.f50643e.get(str).end();
        } else if (MASConfig.LOG_PAGE_DURATION) {
            SystemUtils.log(3, f50639a, this.f50640b + " doesn't contains " + str + ", you should start first!", (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.duration.DurationEvent", 49);
        }
    }

    public String getMainName() {
        return this.f50640b;
    }

    public long getMainTime() {
        return this.f50642d;
    }

    public String getSubInfoInJson() {
        if (this.f50643e.size() < 1) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : this.f50643e.entrySet()) {
                String str = (String) next.getKey();
                long subEventTime = ((SubDurationEvent) next.getValue()).getSubEventTime();
                if (0 < subEventTime && subEventTime < 86400000) {
                    jSONObject.put(str, String.valueOf(subEventTime));
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public String getSubInfoInJsonForLog() {
        if (this.f50643e.size() < 1) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : this.f50643e.entrySet()) {
                jSONObject.put((String) next.getKey(), String.valueOf(((SubDurationEvent) next.getValue()).getSubEventTime()));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public String toString() {
        return "\n{\nmainName: " + this.f50640b + "\nmainTime: " + this.f50642d + "\nsubInfo: " + getSubInfoInJsonForLog() + "\n}";
    }
}
