package com.didi.map.global.component.myLocation.view;

import com.didi.common.map.Map;

public class MyLocationMarkerOptions {

    /* renamed from: a */
    private Map f28362a;

    /* renamed from: b */
    private int f28363b;

    /* renamed from: c */
    private int f28364c;

    /* renamed from: d */
    private int f28365d;

    /* renamed from: e */
    private LocationAccuracyCircleOptions f28366e;

    public Map getMap() {
        return this.f28362a;
    }

    public int getzIndex() {
        return this.f28363b;
    }

    public int getArrowIcon() {
        return this.f28364c;
    }

    public int getPositionIcon() {
        return this.f28365d;
    }

    public LocationAccuracyCircleOptions getAccuracyCircleOptions() {
        return this.f28366e;
    }

    private MyLocationMarkerOptions(Builder builder) {
        this.f28362a = builder.map;
        this.f28363b = builder.zIndex;
        this.f28366e = builder.accuracyCircleOptions;
        this.f28364c = builder.arrowIcon;
        this.f28365d = builder.positionIcon;
    }

    public static class Builder {
        LocationAccuracyCircleOptions accuracyCircleOptions;
        int arrowIcon;
        Map map;
        int positionIcon;
        int zIndex;

        public MyLocationMarkerOptions build() {
            return new MyLocationMarkerOptions(this);
        }

        public Builder map(Map map2) {
            this.map = map2;
            return this;
        }

        public Builder zIndex(int i) {
            this.zIndex = i;
            return this;
        }

        public Builder accuracyCircleOptions(LocationAccuracyCircleOptions locationAccuracyCircleOptions) {
            this.accuracyCircleOptions = locationAccuracyCircleOptions;
            return this;
        }

        public Builder arrowIcon(int i) {
            this.arrowIcon = i;
            return this;
        }

        public Builder positionIcon(int i) {
            this.positionIcon = i;
            return this;
        }
    }
}
