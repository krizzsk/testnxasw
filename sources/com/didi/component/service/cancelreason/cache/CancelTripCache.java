package com.didi.component.service.cancelreason.cache;

import com.didi.sdk.util.SingletonHolder;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;

public class CancelTripCache {

    /* renamed from: a */
    private boolean f17637a = false;

    /* renamed from: b */
    private EstimateItem f17638b = null;

    /* renamed from: c */
    private EstimateItemModel f17639c = null;

    /* renamed from: d */
    private String f17640d = "";

    /* renamed from: e */
    private String f17641e = "";

    /* renamed from: f */
    private long f17642f = 0;

    /* renamed from: g */
    private int f17643g = 0;

    /* renamed from: h */
    private boolean f17644h = false;

    private CancelTripCache() {
    }

    public static CancelTripCache getInstance() {
        return (CancelTripCache) SingletonHolder.getInstance(CancelTripCache.class);
    }

    public void setUsingCacheEstimateParams(boolean z) {
        this.f17637a = z;
    }

    public boolean isUsingCachedEstimateParams() {
        return this.f17637a;
    }

    public EstimateItem getEstimateModel() {
        return this.f17638b;
    }

    public void setEstimateModel(EstimateItem estimateItem) {
        this.f17638b = estimateItem;
    }

    public EstimateItemModel getNewEstimateModel() {
        return this.f17639c;
    }

    public void setEstimateModel(EstimateItemModel estimateItemModel) {
        this.f17639c = estimateItemModel;
    }

    public String getEstimateTraceId() {
        return this.f17640d;
    }

    public void setEstimateTraceId(String str) {
        this.f17640d = str;
    }

    public void setPayInfo(String str) {
        this.f17641e = str;
    }

    public String getPayInfo() {
        return this.f17641e;
    }

    public long getEstimateTime() {
        return this.f17642f;
    }

    public void setEstimateTime(long j) {
        this.f17642f = j;
    }

    public boolean isDriverArrived() {
        return this.f17644h;
    }

    public void setDriverArrived(boolean z) {
        this.f17644h = z;
    }

    public int getComboType() {
        return this.f17643g;
    }

    public void setComboType(int i) {
        this.f17643g = i;
    }

    public boolean isCarPool() {
        return this.f17643g == 4;
    }
}
