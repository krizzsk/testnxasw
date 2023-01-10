package com.didi.map.google.model;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.map.google.util.ApolloUtils;
import com.didi.map.sdk.nav.inertia.ApolloParamsSctxPrediction;
import com.didi.map.sdk.nav.inertia.MatchPointType;

public class PageCachedApolloValue {

    /* renamed from: a */
    private int f30246a;

    /* renamed from: b */
    private int f30247b;

    /* renamed from: c */
    private long f30248c;

    /* renamed from: d */
    private long f30249d;

    /* renamed from: e */
    private boolean f30250e;

    /* renamed from: f */
    private boolean f30251f;

    /* renamed from: g */
    private int f30252g;

    /* renamed from: h */
    private long f30253h;

    /* renamed from: i */
    private String f30254i;

    /* renamed from: j */
    private ApolloParamsSctxPrediction f30255j;

    /* renamed from: k */
    private String f30256k;

    /* renamed from: l */
    private String f30257l;

    public int getMaxMockDistance(MatchPointType matchPointType) {
        if (matchPointType == MatchPointType.WIFI || matchPointType == MatchPointType.MOBILE_STATION) {
            if (this.f30247b < 1) {
                this.f30247b = ApolloUtils.getMaxMockDistance(matchPointType);
            }
            return this.f30247b;
        }
        if (this.f30246a < 1) {
            this.f30246a = ApolloUtils.getMaxMockDistance(matchPointType);
        }
        return this.f30246a;
    }

    public long getMaxMockTime(MatchPointType matchPointType) {
        if (matchPointType == MatchPointType.WIFI || matchPointType == MatchPointType.MOBILE_STATION) {
            if (this.f30249d < 1) {
                this.f30249d = ApolloUtils.getMaxMockTime(matchPointType);
            }
            return this.f30249d;
        }
        if (this.f30248c < 1) {
            this.f30248c = ApolloUtils.getMaxMockTime(matchPointType);
        }
        return this.f30248c;
    }

    public boolean getSimulateMotionEnable() {
        if (this.f30251f) {
            return this.f30250e;
        }
        this.f30250e = ApolloUtils.isSimulateMotionOpened();
        DLog.m10773d("SimulateApollo", "is Simulate Motion Enable:" + this.f30250e, new Object[0]);
        this.f30251f = true;
        return this.f30250e;
    }

    public long getAllowETA() {
        if (this.f30253h < 1) {
            this.f30253h = ApolloUtils.getAllowETA();
        }
        return this.f30253h;
    }

    public int getAllowEDA() {
        if (this.f30252g < 1) {
            this.f30252g = ApolloUtils.getAllowEDA();
        }
        return this.f30252g;
    }

    public String getOraRequestUrl(Context context) {
        if (TextUtils.isEmpty(this.f30254i)) {
            this.f30254i = ApolloUtils.getOraRequestUrl(context);
        }
        return this.f30254i;
    }

    public String getTrafficEventsRequestUrl(Context context) {
        if (TextUtils.isEmpty(this.f30256k)) {
            this.f30256k = ApolloUtils.getTrafficEventShowUrl(context);
        }
        return this.f30256k;
    }

    public String getTrafficEventVerifyUrl(Context context) {
        if (TextUtils.isEmpty(this.f30257l)) {
            this.f30257l = ApolloUtils.getTrafficEventVerifyUrl(context);
        }
        return this.f30257l;
    }

    public ApolloParamsSctxPrediction getSctxPredictionParams() {
        if (this.f30255j == null) {
            this.f30255j = ApolloUtils.getSctxPredictionParams();
        }
        return this.f30255j;
    }

    public boolean getSctxPredictionEnable() {
        if (this.f30255j == null) {
            ApolloParamsSctxPrediction sctxPredictionParams = ApolloUtils.getSctxPredictionParams();
            this.f30255j = sctxPredictionParams;
            if (sctxPredictionParams == null) {
                return false;
            }
        }
        return this.f30255j.isPredictionEnabled();
    }
}
