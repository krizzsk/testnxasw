package com.didi.map.global.flow.scene.param;

import android.graphics.Bitmap;
import com.didi.common.map.model.LatLng;

public class CommonMarkerParam {

    /* renamed from: a */
    private LatLng f29545a;

    /* renamed from: b */
    private Bitmap f29546b;

    /* renamed from: c */
    private float f29547c;

    /* renamed from: d */
    private float f29548d;

    /* renamed from: e */
    private String f29549e;

    /* renamed from: f */
    private MapElementId f29550f;

    /* renamed from: g */
    private int f29551g;

    /* renamed from: h */
    private int f29552h;

    /* renamed from: i */
    private int f29553i;

    /* renamed from: j */
    private boolean f29554j;

    /* renamed from: k */
    private int f29555k;
    public String poiId;

    public CommonMarkerParam(LatLng latLng, Bitmap bitmap, float f, float f2, MapElementId mapElementId) {
        this.f29545a = latLng;
        this.f29546b = bitmap;
        this.f29547c = f;
        this.f29548d = f2;
        this.f29550f = mapElementId;
    }

    public CommonMarkerParam(Builder builder) {
        this.f29545a = builder.point;
        this.f29546b = builder.markerIcon;
        this.f29547c = builder.anchorU;
        this.f29548d = builder.anchorV;
        this.f29549e = builder.addressName;
        this.f29550f = builder.f29556id;
        this.f29551g = builder.zIndex;
        this.f29552h = builder.addressNameColorResId;
        this.f29553i = builder.markerIconResId;
        this.f29554j = builder.showSensingCircle;
        this.f29555k = builder.sensingCircleColorRes;
        this.poiId = builder.poiId;
    }

    public MapElementId getId() {
        MapElementId mapElementId = this.f29550f;
        return mapElementId == null ? MapElementId.ID_MARKER_DEFAULT : mapElementId;
    }

    public void setId(MapElementId mapElementId) {
        this.f29550f = mapElementId;
    }

    public LatLng getPoint() {
        return this.f29545a;
    }

    public void setPoint(LatLng latLng) {
        this.f29545a = latLng;
    }

    public Bitmap getMarkerIcon() {
        return this.f29546b;
    }

    public void setMarkerIcon(Bitmap bitmap) {
        this.f29546b = bitmap;
    }

    public int getMarkerIconResId() {
        return this.f29553i;
    }

    public void setMarkerIconResId(int i) {
        this.f29553i = i;
    }

    public float getAnchorU() {
        return this.f29547c;
    }

    public void setAnchorU(float f) {
        this.f29547c = f;
    }

    public float getAnchorV() {
        return this.f29548d;
    }

    public void setAnchorV(float f) {
        this.f29548d = f;
    }

    public String getAddressName() {
        return this.f29549e;
    }

    public void setAddressName(String str) {
        this.f29549e = str;
    }

    public int getZIndex() {
        return this.f29551g;
    }

    public void setZIndex(int i) {
        this.f29551g = i;
    }

    public void setAddressNameColorResId(int i) {
        this.f29552h = i;
    }

    public int getAddressNameColorResId() {
        return this.f29552h;
    }

    public void setSensingCircle(boolean z) {
        this.f29554j = z;
    }

    public boolean showSensingCircle() {
        return this.f29554j;
    }

    public int getSensingCircleColorRes() {
        return this.f29555k;
    }

    public void setSensingCircleColorRes(int i) {
        this.f29555k = i;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public void setPoiId(String str) {
        this.poiId = str;
    }

    public String toString() {
        return "CommonMarkerParam{point=" + this.f29545a + ", markerIcon=" + this.f29546b + ", anchorU=" + this.f29547c + ", anchorV=" + this.f29548d + ", addressName='" + this.f29549e + '\'' + ", id='" + this.f29550f + '\'' + ", zIndex=" + this.f29551g + ", poiId=" + this.poiId + ", addressNameColorResId=" + this.f29552h + ", markerIconResId=" + this.f29553i + ", showSensingCircle=" + this.f29554j + ", sensingCircleColorRes=" + this.f29555k + '}';
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String addressName;
        /* access modifiers changed from: private */
        public int addressNameColorResId;
        /* access modifiers changed from: private */
        public float anchorU;
        /* access modifiers changed from: private */
        public float anchorV;
        /* access modifiers changed from: private */

        /* renamed from: id */
        public MapElementId f29556id;
        /* access modifiers changed from: private */
        public Bitmap markerIcon;
        /* access modifiers changed from: private */
        public int markerIconResId;
        public String poiId;
        /* access modifiers changed from: private */
        public LatLng point;
        /* access modifiers changed from: private */
        public int sensingCircleColorRes;
        /* access modifiers changed from: private */
        public boolean showSensingCircle;
        /* access modifiers changed from: private */
        public int zIndex;

        public Builder point(LatLng latLng) {
            this.point = latLng;
            return this;
        }

        public Builder markerIcon(Bitmap bitmap) {
            this.markerIcon = bitmap;
            return this;
        }

        public Builder anchorU(float f) {
            this.anchorU = f;
            return this;
        }

        public Builder anchorV(float f) {
            this.anchorV = f;
            return this;
        }

        public Builder addressName(String str) {
            this.addressName = str;
            return this;
        }

        /* renamed from: id */
        public Builder mo81429id(MapElementId mapElementId) {
            this.f29556id = mapElementId;
            return this;
        }

        public Builder zIndex(int i) {
            this.zIndex = i;
            return this;
        }

        public Builder addressNameColorResId(int i) {
            this.addressNameColorResId = i;
            return this;
        }

        public Builder markerIconResId(int i) {
            this.markerIconResId = i;
            return this;
        }

        public Builder showSensingCircle(boolean z) {
            this.showSensingCircle = z;
            return this;
        }

        public Builder sensingCircleColorRes(int i) {
            this.sensingCircleColorRes = i;
            return this;
        }

        public Builder poiId(String str) {
            this.poiId = str;
            return this;
        }
    }
}
