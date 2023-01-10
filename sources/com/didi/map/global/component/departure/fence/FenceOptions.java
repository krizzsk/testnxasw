package com.didi.map.global.component.departure.fence;

import java.util.List;

public class FenceOptions {

    /* renamed from: a */
    private List<FencePolygon> f27413a;

    /* renamed from: b */
    private IFenceListener f27414b;

    /* renamed from: c */
    private int f27415c;

    /* renamed from: d */
    private int f27416d;

    /* renamed from: e */
    private float f27417e;

    /* renamed from: f */
    private double f27418f = -1.0d;

    /* renamed from: g */
    private int f27419g = 0;

    /* renamed from: h */
    private int f27420h = 0;

    public List<FencePolygon> getFences() {
        return this.f27413a;
    }

    public void setFences(List<FencePolygon> list) {
        this.f27413a = list;
    }

    public IFenceListener getFenceListener() {
        return this.f27414b;
    }

    public void setFenceListener(IFenceListener iFenceListener) {
        this.f27414b = iFenceListener;
    }

    public int getFillColor() {
        return this.f27415c;
    }

    public void setFillColor(int i) {
        this.f27415c = i;
    }

    public int getStrokeColor() {
        return this.f27416d;
    }

    public void setStrokeColor(int i) {
        this.f27416d = i;
    }

    public float getStrokeWidth() {
        return this.f27417e;
    }

    public void setStrokeWidth(float f) {
        this.f27417e = f;
    }

    public double getLimitZoom() {
        return this.f27418f;
    }

    public void setLimitZoom(double d) {
        this.f27418f = d;
    }

    public int getPolygonZIndex() {
        return this.f27419g;
    }

    public void setPolygonZIndex(int i) {
        this.f27419g = i;
    }

    public int getMarkerZIndex() {
        return this.f27420h;
    }

    public void setMarkerZIndex(int i) {
        this.f27420h = i;
    }
}
