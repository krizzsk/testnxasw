package com.didi.map.global.flow.scene.param;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class CommonLineParam {

    /* renamed from: a */
    private MapElementId f29536a;

    /* renamed from: b */
    private int f29537b;

    /* renamed from: c */
    private int f29538c;

    /* renamed from: d */
    private int f29539d;

    /* renamed from: e */
    private LatLng f29540e;

    /* renamed from: f */
    private LatLng f29541f;

    /* renamed from: g */
    private List<LatLng> f29542g;

    /* renamed from: h */
    private int f29543h;

    /* renamed from: i */
    private boolean f29544i;

    public CommonLineParam(MapElementId mapElementId, int i, int i2, int i3, LatLng latLng, LatLng latLng2, List<LatLng> list) {
        this.f29536a = mapElementId;
        this.f29537b = i;
        this.f29538c = i2;
        this.f29539d = i3;
        this.f29540e = latLng;
        this.f29541f = latLng2;
        this.f29542g = list;
    }

    public MapElementId getId() {
        return this.f29536a;
    }

    public LatLng getStartPoint() {
        return this.f29540e;
    }

    public LatLng getEndPoint() {
        return this.f29541f;
    }

    public List<LatLng> getWayPoints() {
        return this.f29542g;
    }

    public int getLineColor() {
        return this.f29537b;
    }

    public void setLineColor(int i) {
        this.f29537b = i;
    }

    public int getLineWidth() {
        return this.f29538c;
    }

    public void setLineWidth(int i) {
        this.f29538c = i;
    }

    public int getLineSpace() {
        return this.f29543h;
    }

    public void setLineSpace(int i) {
        this.f29543h = i;
    }

    public int getLineMode() {
        return this.f29539d;
    }

    public void setLineMode(int i) {
        this.f29539d = i;
    }

    public void setId(MapElementId mapElementId) {
        this.f29536a = mapElementId;
    }

    public void setStartPoint(LatLng latLng) {
        this.f29540e = latLng;
    }

    public void setEndPoint(LatLng latLng) {
        this.f29541f = latLng;
    }

    public void setWayPoints(List<LatLng> list) {
        this.f29542g = list;
    }

    public boolean getAnimate() {
        return this.f29544i;
    }

    public void setAnimate(boolean z) {
        this.f29544i = z;
    }

    public String toString() {
        return "CommonLineParam{id='" + this.f29536a + '\'' + ", lineColor=" + this.f29537b + ", lineWidth=" + this.f29538c + ", lineMode=" + this.f29539d + ", startPoint=" + this.f29540e + ", endPoint=" + this.f29541f + ", wayPoints=" + this.f29542g + '}';
    }
}
