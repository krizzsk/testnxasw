package com.dmap.navigation.engine.event;

public class SpeedIconEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54503a;

    /* renamed from: b */
    private final int f54504b;

    /* renamed from: c */
    private final int f54505c;

    /* renamed from: d */
    private final int f54506d;

    /* renamed from: e */
    private final int f54507e;

    /* renamed from: f */
    private final float f54508f;

    /* renamed from: g */
    private final int f54509g;

    public SpeedIconEvent(int i, int i2, int i3, int i4, int i5, float f, int i6) {
        this.f54503a = i;
        this.f54504b = i2;
        this.f54505c = i3;
        this.f54506d = i4;
        this.f54507e = i5;
        this.f54508f = f;
        this.f54509g = i6;
    }

    public String toString() {
        return "SpeedIconEvent{updateType=" + this.f54503a + ", gpsSpeed=" + this.f54504b + ", speedIconKind=" + this.f54505c + ", averageSpeed=" + this.f54506d + ", averSpeedIconKind=" + this.f54507e + ", remanenDistance=" + this.f54508f + ", limitSpeed=" + this.f54509g + '}';
    }

    public int getUpdateType() {
        return this.f54503a;
    }

    public int getGpsSpeed() {
        return this.f54504b;
    }

    public int getSpeedIconKind() {
        return this.f54505c;
    }

    public int getAverageSpeed() {
        return this.f54506d;
    }

    public int getAverSpeedIconKind() {
        return this.f54507e;
    }

    public float getRemanenDistance() {
        return this.f54508f;
    }

    public int getLimitSpeed() {
        return this.f54509g;
    }
}
