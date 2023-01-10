package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.filter;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.filter.AccTimeFilterHelper */
public class AccTimeFilterHelper {

    /* renamed from: j */
    private static final String f48621j = "AccTimeFilterHelper ";

    /* renamed from: a */
    float f48622a;

    /* renamed from: b */
    float f48623b;

    /* renamed from: c */
    float f48624c;

    /* renamed from: d */
    float f48625d;

    /* renamed from: e */
    float f48626e;

    /* renamed from: f */
    float f48627f;

    /* renamed from: g */
    float f48628g;

    /* renamed from: h */
    int f48629h;

    /* renamed from: i */
    int f48630i;

    /* renamed from: k */
    private int f48631k;
    public boolean shouldUseAccTimeFilter;
    public boolean shouldUseAccTimeFilterAB;

    public void setCurrentSatelliteNum(int i) {
        DLog.m36225d("AccTimeFilterHelper update satelliteNum: " + i);
        this.f48631k = i;
    }

    public boolean isFewSatellite() {
        return this.f48631k < this.f48629h;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.filter.AccTimeFilterHelper$Holder */
    private static class Holder {
        static AccTimeFilterHelper instance = new AccTimeFilterHelper();

        private Holder() {
        }
    }

    public static AccTimeFilterHelper getInstance() {
        return Holder.instance;
    }

    private AccTimeFilterHelper() {
        this.f48631k = 100;
        boolean z = false;
        this.shouldUseAccTimeFilter = false;
        this.shouldUseAccTimeFilterAB = false;
        Float valueOf = Float.valueOf(1.0f);
        this.f48622a = 1.0f;
        this.f48623b = 1.0f;
        Float valueOf2 = Float.valueOf(0.5f);
        this.f48624c = 0.5f;
        this.f48625d = 0.3f;
        this.f48626e = 0.5f;
        this.f48627f = 0.5f;
        this.f48628g = 0.3f;
        this.f48629h = 2;
        this.f48630i = 0;
        IToggle toggle = Apollo.getToggle("map_loc_acc_time_strategy_toggle");
        if (toggle == null || !toggle.allow()) {
            this.shouldUseAccTimeFilter = false;
            DLog.m36225d("AccTimeFilterHelper map_loc_acc_time_strategy_toggle not allow");
        } else if (toggle.getExperiment() != null) {
            this.shouldUseAccTimeFilter = true;
            this.f48622a = ((Float) toggle.getExperiment().getParam("score_init_flp", valueOf)).floatValue();
            this.f48623b = ((Float) toggle.getExperiment().getParam("score_init_gps", valueOf)).floatValue();
            this.f48624c = ((Float) toggle.getExperiment().getParam("score_init_nlp", valueOf2)).floatValue();
            this.f48625d = ((Float) toggle.getExperiment().getParam("score_init_last_gps", Float.valueOf(0.3f))).floatValue();
            this.f48626e = ((Float) toggle.getExperiment().getParam("weight_acc", valueOf2)).floatValue();
            this.f48627f = ((Float) toggle.getExperiment().getParam("weight_time", valueOf2)).floatValue();
            this.f48628g = ((Float) toggle.getExperiment().getParam("score_delta_gps", Float.valueOf(0.2f))).floatValue();
            this.f48629h = ((Integer) toggle.getExperiment().getParam("adjust_satellite_num", 2)).intValue();
            this.f48630i = ((Integer) toggle.getExperiment().getParam("should_track", 1)).intValue();
            DLog.m36225d("AccTimeFilterHelper map_loc_acc_time_strategy_toggle allow and param: " + getInfo());
        } else {
            DLog.m36225d("AccTimeFilterHelper map_loc_acc_time_strategy_toggle allow but with error");
        }
        IToggle toggle2 = Apollo.getToggle("global_map_loc_benefit_AB");
        if (toggle2 == null || !toggle2.allow()) {
            this.shouldUseAccTimeFilterAB = false;
            DLog.m36225d("AccTimeFilterHelper global_map_loc_benefit_AB not allow");
        } else if (toggle2.getExperiment() != null) {
            z = ((Integer) toggle2.getExperiment().getParam("enable", 0)).intValue() == 1 ? true : z;
            this.shouldUseAccTimeFilterAB = z;
            if (z) {
                DLog.m36225d("AccTimeFilterHelper global_map_loc_benefit_AB exp allow");
            } else {
                DLog.m36225d("AccTimeFilterHelper global_map_loc_benefit_AB exp not allow");
            }
        } else {
            DLog.m36225d("AccTimeFilterHelper global_map_loc_benefit_AB allow but null exp");
        }
    }

    public boolean shouldUseThisFilter() {
        return this.shouldUseAccTimeFilter && this.shouldUseAccTimeFilterAB;
    }

    public boolean shouldTrack() {
        return this.f48630i == 1;
    }

    public String getInfo() {
        return "AccTimeFilterHelper{score_init_flp=" + this.f48622a + ", score_init_gps=" + this.f48623b + ", score_init_nlp=" + this.f48624c + ", score_init_last_gps=" + this.f48625d + ", weight_acc=" + this.f48626e + ", weight_time=" + this.f48627f + ", score_delta_gps=" + this.f48628g + ", adjust_satellite_num=" + this.f48629h + ", should_track=" + this.f48630i + '}';
    }
}
