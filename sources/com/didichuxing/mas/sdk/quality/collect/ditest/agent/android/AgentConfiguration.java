package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.didichuxing.mas.sdk.quality.report.collector.CustomCollector;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AgentConfiguration {

    /* renamed from: a */
    private boolean f50364a = false;

    /* renamed from: b */
    private int f50365b = 65535;

    /* renamed from: c */
    private boolean f50366c;

    /* renamed from: d */
    private boolean f50367d;

    /* renamed from: e */
    private boolean f50368e = true;

    /* renamed from: f */
    private boolean f50369f = true;

    /* renamed from: g */
    private int f50370g = 2000;

    /* renamed from: h */
    private long f50371h = 500000000;

    /* renamed from: i */
    private long f50372i = 100000000;

    /* renamed from: j */
    private long f50373j = 5000;

    /* renamed from: k */
    private boolean f50374k = false;

    /* renamed from: l */
    private long f50375l = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;

    /* renamed from: m */
    private long f50376m = 10000;

    /* renamed from: n */
    private boolean f50377n = false;

    /* renamed from: o */
    private long f50378o = 10000;

    /* renamed from: p */
    private double f50379p = 0.0d;

    /* renamed from: q */
    private boolean f50380q = false;

    /* renamed from: r */
    private ConcurrentMap<String, Boolean> f50381r;

    public boolean isDisabled() {
        return this.f50364a;
    }

    public void setDisabled(boolean z) {
        this.f50364a = z;
    }

    public int getResponseBodyLimit() {
        return this.f50365b;
    }

    public void setResponseBodyLimit(int i) {
        this.f50365b = i;
    }

    public boolean isApmNetEnable() {
        return !this.f50364a && this.f50366c;
    }

    public void setApmNetEnable(boolean z) {
        this.f50366c = z;
    }

    public boolean isApmUiEnable() {
        return !this.f50364a && this.f50367d;
    }

    public void setApmUiEnable(boolean z) {
        this.f50367d = z;
    }

    public boolean isUploadNetPerf() {
        return this.f50368e;
    }

    public void setUploadNetPerf(boolean z) {
        this.f50368e = z;
    }

    public boolean isUploadErrorDiag() {
        return this.f50369f;
    }

    public void setUploadErrorDiag(boolean z) {
        this.f50369f = z;
    }

    public int getMaxUploadNetErrEventPerDay() {
        return this.f50370g;
    }

    public void setMaxUploadNetErrEventPerDay(int i) {
        this.f50370g = i;
    }

    public long getMaxTrafficPerDay() {
        return this.f50371h;
    }

    public void setMaxTrafficPerDay(long j) {
        this.f50371h = j;
    }

    public long getMaxTrafficFiveMinutes() {
        return this.f50372i;
    }

    public void setMaxTrafficFiveMinutes(long j) {
        this.f50372i = j;
    }

    public long getOverRequestTime() {
        return this.f50373j;
    }

    public void setOverRequestTime(long j) {
        this.f50373j = j;
    }

    public boolean isNetEventLogEnabled() {
        return this.f50374k;
    }

    public void setNetEventLogEnabled(boolean z) {
        this.f50374k = z;
    }

    public long getNetEventLogUploadInterval() {
        return this.f50375l;
    }

    public void setNetEventLogUploadInterval(long j) {
        this.f50375l = j;
    }

    public long getMaxNetEventUploadNum() {
        return this.f50376m;
    }

    public void setMaxNetEventUploadNum(long j) {
        this.f50376m = j;
    }

    public boolean isAllNetUploadEnable() {
        return this.f50377n;
    }

    public void setAllNetUploadEnable(boolean z) {
        this.f50377n = z;
    }

    public long getAllNetUploadLimit() {
        return this.f50378o;
    }

    public void setAllNetUploadLimit(long j) {
        this.f50378o = j;
    }

    public void initWhiteListAllNetCollectMap(String str) {
        if (this.f50381r == null) {
            this.f50381r = new ConcurrentHashMap();
        }
        for (String put : str.split(",")) {
            this.f50381r.put(put, true);
        }
    }

    public void addUploadUrlWhiteList(String str) {
        if (this.f50381r == null) {
            this.f50381r = new ConcurrentHashMap();
        }
        this.f50381r.put(str, true);
    }

    public void addUploadUrlWhiteListAll(Map<String, Boolean> map) {
        if (this.f50381r == null) {
            this.f50381r = new ConcurrentHashMap();
        }
        this.f50381r.putAll(map);
    }

    public boolean isUploadAllUrlEnable() {
        return this.f50380q;
    }

    public void setUploadAllUrlEnable(boolean z) {
        this.f50380q = z;
    }

    public boolean inAllNetUploadWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f50380q) {
            return true;
        }
        ConcurrentMap<String, Boolean> concurrentMap = this.f50381r;
        if (concurrentMap == null) {
            return false;
        }
        for (String str2 : concurrentMap.keySet()) {
            if (str.contains(str2)) {
                Boolean bool = (Boolean) this.f50381r.get(str2);
                if (bool == null || !bool.booleanValue()) {
                    return false;
                }
                return true;
            }
        }
        List<String> uploadURLWhiteList = CustomCollector.getUploadURLWhiteList();
        if (uploadURLWhiteList != null && uploadURLWhiteList.size() > 0) {
            for (String contains : uploadURLWhiteList) {
                if (str.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    public double getExceptionCollectRate() {
        return this.f50379p;
    }

    public void setExceptionCollectRate(double d) {
        this.f50379p = d;
    }

    public void clearUploadUrlPath() {
        ConcurrentMap<String, Boolean> concurrentMap = this.f50381r;
        if (concurrentMap != null && !concurrentMap.isEmpty()) {
            this.f50381r.clear();
        }
    }
}
