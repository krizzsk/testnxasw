package com.didi.map.outer.model;

public class HeatDataNode {

    /* renamed from: a */
    private LatLng f30379a;

    /* renamed from: b */
    private double f30380b;

    public HeatDataNode(LatLng latLng, double d) {
        this.f30379a = latLng;
        this.f30380b = d;
    }

    public double getValue() {
        return this.f30380b;
    }

    public void setValue(double d) {
        this.f30380b = d;
    }

    public LatLng getPoint() {
        return this.f30379a;
    }

    public void setPoint(LatLng latLng) {
        this.f30379a = latLng;
    }
}
