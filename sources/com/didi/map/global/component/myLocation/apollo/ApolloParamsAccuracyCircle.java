package com.didi.map.global.component.myLocation.apollo;

public class ApolloParamsAccuracyCircle {

    /* renamed from: a */
    private int f28322a = 0;

    /* renamed from: b */
    private int f28323b = 0;

    /* renamed from: c */
    private int f28324c = 0;

    public int getEnable() {
        return this.f28322a;
    }

    public void setEnable(int i) {
        this.f28322a = i;
    }

    public int getMinRadius() {
        return this.f28323b;
    }

    public void setMinRadius(int i) {
        this.f28323b = i;
    }

    public int getMaxRadius() {
        return this.f28324c;
    }

    public void setMaxRadius(int i) {
        this.f28324c = i;
    }

    public ApolloParamsAccuracyCircle(int i, int i2, int i3) {
        this.f28322a = i;
        this.f28323b = i2;
        this.f28324c = i3;
    }

    public String toString() {
        return "ApolloParamsAccuracyCircle{enable=" + this.f28322a + ", minRadius=" + this.f28323b + ", maxRadius=" + this.f28324c + '}';
    }
}
