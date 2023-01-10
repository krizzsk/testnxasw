package com.didi.map.sdk.departure;

import com.didi.map.sdk.departure.internal.special.SpecialPois;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.poi.SpecialPoiGuidance;
import java.util.ArrayList;

public class DepartureAddress {

    /* renamed from: a */
    private RpcPoi f30549a;

    /* renamed from: b */
    private boolean f30550b;

    /* renamed from: c */
    private String f30551c;

    /* renamed from: d */
    private SpecialPoiGuidance f30552d;

    /* renamed from: e */
    private int f30553e;

    /* renamed from: f */
    private FenceInfo f30554f;

    /* renamed from: g */
    private ArrayList<RpcPoi> f30555g;

    /* renamed from: h */
    private SpecialPois f30556h;

    /* renamed from: i */
    private String f30557i;

    /* renamed from: j */
    private ArrayList<String> f30558j;

    /* renamed from: k */
    private int f30559k;

    /* renamed from: l */
    private RpcPoi f30560l;

    /* renamed from: m */
    private int f30561m;

    public int getOperationType() {
        return this.f30561m;
    }

    public void setOperationType(int i) {
        this.f30561m = i;
    }

    public RpcPoi getAddress() {
        return this.f30549a;
    }

    public void setAddress(RpcPoi rpcPoi) {
        this.f30549a = rpcPoi;
    }

    public boolean isRecommendPoi() {
        return this.f30550b;
    }

    public String getDepartureDisplayName() {
        return this.f30551c;
    }

    public void setDepartureDisplayName(String str) {
        this.f30551c = str;
    }

    public SpecialPoiGuidance getSpecialPoiGuidance() {
        return this.f30552d;
    }

    public void setSpecialPoiGuidance(SpecialPoiGuidance specialPoiGuidance) {
        this.f30552d = specialPoiGuidance;
    }

    public void setRecommendPoi(boolean z) {
        this.f30550b = z;
    }

    public int getZoneStatus() {
        return this.f30553e;
    }

    public void setZoneStatus(int i) {
        this.f30553e = i;
    }

    public FenceInfo getFenceInfo() {
        return this.f30554f;
    }

    public void setFenceInfo(FenceInfo fenceInfo) {
        this.f30554f = fenceInfo;
    }

    public ArrayList<RpcPoi> getRecommendDestinations() {
        return this.f30555g;
    }

    public void setRecommendDestinations(ArrayList<RpcPoi> arrayList) {
        this.f30555g = arrayList;
    }

    public SpecialPois getSpecialPois() {
        return this.f30556h;
    }

    public void setSpecialPois(SpecialPois specialPois) {
        this.f30556h = specialPois;
    }

    public boolean hasSpecialPois() {
        SpecialPois specialPois = this.f30556h;
        return (specialPois == null || specialPois.pois == null || this.f30556h.pois.isEmpty()) ? false : true;
    }

    public String getLanguage() {
        return this.f30557i;
    }

    public void setLanguage(String str) {
        this.f30557i = str;
    }

    public ArrayList<String> getGeofenceTags() {
        return this.f30558j;
    }

    public void setGeofenceTags(ArrayList<String> arrayList) {
        this.f30558j = arrayList;
    }

    public int getPickUpPointSize() {
        return this.f30559k;
    }

    public void setPickUpPointSize(int i) {
        this.f30559k = i;
    }

    public RpcPoi getRgeoResult() {
        return this.f30560l;
    }

    public void setRgeoResult(RpcPoi rpcPoi) {
        this.f30560l = rpcPoi;
    }
}
