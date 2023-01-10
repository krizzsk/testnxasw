package com.didi.map.global.component.myLocation;

public class MyLocationCompParam {

    /* renamed from: a */
    private int f28316a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f28317b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f28318c;

    private MyLocationCompParam(int i) {
        this.f28316a = i;
    }

    public int getzIndex() {
        return this.f28316a;
    }

    public int getArrowIcon() {
        return this.f28317b;
    }

    public int getPositionIcon() {
        return this.f28318c;
    }

    public static class Builder {
        private MyLocationCompParam locationCompParam;

        public Builder(int i) {
            this.locationCompParam = new MyLocationCompParam(i);
        }

        public Builder arrowIcon(int i) {
            int unused = this.locationCompParam.f28317b = i;
            return this;
        }

        public Builder positionIcon(int i) {
            int unused = this.locationCompParam.f28318c = i;
            return this;
        }

        public MyLocationCompParam build() {
            return this.locationCompParam;
        }
    }
}
