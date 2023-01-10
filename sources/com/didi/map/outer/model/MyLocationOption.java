package com.didi.map.outer.model;

public final class MyLocationOption {
    public static final int DEFAULT_MAX_RADIUS = 1000;
    public static final int DEFAULT_MIN_RADIUS = 15;
    public static final int LOCATION_TYPE_FOLLOW_CENTER = 2;
    public static final int LOCATION_TYPE_NORMAL = 1;

    /* renamed from: a */
    private final BitmapDescriptor f30447a;

    /* renamed from: b */
    private final BitmapDescriptor f30448b;

    /* renamed from: c */
    private final Float[] f30449c;

    /* renamed from: d */
    private final Integer f30450d;

    /* renamed from: e */
    private final LatLng f30451e;

    /* renamed from: f */
    private final Integer f30452f;

    /* renamed from: g */
    private final Integer f30453g;

    /* renamed from: h */
    private final Boolean f30454h;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MyLocationOption(com.didi.map.outer.model.MyLocationOption r11) {
        /*
            r10 = this;
            com.didi.map.outer.model.BitmapDescriptor r1 = r11.f30447a
            com.didi.map.outer.model.BitmapDescriptor r2 = r11.f30448b
            java.lang.Float[] r0 = r11.f30449c
            r3 = 0
            r3 = r0[r3]
            r4 = 1
            r4 = r0[r4]
            java.lang.Integer r5 = r11.f30450d
            com.didi.map.outer.model.LatLng r6 = r11.f30451e
            java.lang.Integer r7 = r11.f30452f
            java.lang.Integer r8 = r11.f30453g
            java.lang.Boolean r9 = r11.f30454h
            r0 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.outer.model.MyLocationOption.<init>(com.didi.map.outer.model.MyLocationOption):void");
    }

    public MyLocationOption(BitmapDescriptor bitmapDescriptor, float f, float f2, int i, LatLng latLng) {
        this(bitmapDescriptor, (BitmapDescriptor) null, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), latLng, 15, 1000, true);
    }

    public MyLocationOption(BitmapDescriptor bitmapDescriptor, float f, float f2, int i, LatLng latLng, int i2, int i3) {
        this(bitmapDescriptor, (BitmapDescriptor) null, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), latLng, Integer.valueOf(i2), Integer.valueOf(i3), true);
    }

    public MyLocationOption(BitmapDescriptor bitmapDescriptor, BitmapDescriptor bitmapDescriptor2, Float f, Float f2, Integer num, LatLng latLng, Integer num2, Integer num3) {
        this(bitmapDescriptor, bitmapDescriptor2, f, f2, num, latLng, num2, num3, true);
    }

    public MyLocationOption(BitmapDescriptor bitmapDescriptor, BitmapDescriptor bitmapDescriptor2, Float f, Float f2, Integer num, LatLng latLng, Integer num2, Integer num3, Boolean bool) {
        Float valueOf = Float.valueOf(0.5f);
        Float[] fArr = {valueOf, valueOf};
        this.f30449c = fArr;
        this.f30447a = bitmapDescriptor;
        this.f30448b = bitmapDescriptor2;
        this.f30450d = num;
        fArr[0] = f;
        fArr[1] = f2;
        this.f30451e = latLng;
        this.f30452f = num2;
        this.f30453g = num3;
        this.f30454h = bool;
    }

    public BitmapDescriptor getIcon() {
        return this.f30447a;
    }

    public Float getAnchorX() {
        return this.f30449c[0];
    }

    public Float getAnchorY() {
        return this.f30449c[1];
    }

    public Integer getLocationType() {
        return this.f30450d;
    }

    public LatLng getPosition() {
        return this.f30451e;
    }

    public Integer getMinRadius() {
        return this.f30452f;
    }

    public Integer getMaxRadius() {
        return this.f30453g;
    }

    public BitmapDescriptor getFailedIcon() {
        return this.f30448b;
    }

    public Boolean isShowRing() {
        return this.f30454h;
    }

    public String toString() {
        return "MyLocationOption{locationType=" + this.f30450d + ", position=" + this.f30451e + ", minRadius=" + this.f30452f + ", maxRadius=" + this.f30453g + ", showRing=" + this.f30454h + '}';
    }

    public static class Builder {
        private Float anchorX;
        private Float anchorY;
        private BitmapDescriptor failedIcon;
        private BitmapDescriptor icon;
        private Integer locationType;
        private Integer maxRadius;
        private Integer minRadius;
        private LatLng position;
        private Boolean showRing;

        public Builder setAnchorX(float f) {
            this.anchorX = Float.valueOf(f);
            return this;
        }

        public Builder setAnchorY(float f) {
            this.anchorY = Float.valueOf(f);
            return this;
        }

        public Builder setIcon(BitmapDescriptor bitmapDescriptor) {
            this.icon = bitmapDescriptor;
            return this;
        }

        public Builder setFailedIcon(BitmapDescriptor bitmapDescriptor) {
            this.failedIcon = bitmapDescriptor;
            return this;
        }

        public Builder setLocationType(int i) {
            this.locationType = Integer.valueOf(i);
            return this;
        }

        public Builder setPosition(LatLng latLng) {
            this.position = latLng;
            return this;
        }

        public Builder setMinRadius(int i) {
            this.minRadius = Integer.valueOf(i);
            return this;
        }

        public Builder setMaxRadius(int i) {
            this.maxRadius = Integer.valueOf(i);
            return this;
        }

        public Builder setShowRing(boolean z) {
            this.showRing = Boolean.valueOf(z);
            return this;
        }

        public MyLocationOption build() {
            return new MyLocationOption(this.icon, this.failedIcon, this.anchorX, this.anchorY, this.locationType, this.position, this.minRadius, this.maxRadius, this.showRing);
        }
    }
}
