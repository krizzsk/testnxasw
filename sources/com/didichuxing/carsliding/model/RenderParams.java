package com.didichuxing.carsliding.model;

import com.didichuxing.carsliding.filter.VectorCoordinateFilter;
import java.util.ArrayList;
import java.util.List;

public class RenderParams {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public DriverCollection f48916a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long f48917b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RenderStrategy f48918c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f48919d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f48920e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f48921f;

    /* renamed from: g */
    private int f48922g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<VectorCoordinateFilter> f48923h;

    private RenderParams() {
        this.f48916a = new DriverCollection();
        this.f48918c = RenderStrategy.SLIDE;
        this.f48921f = true;
        this.f48922g = 0;
        this.f48923h = new ArrayList();
    }

    public String toString() {
        return "driverCollection=" + this.f48916a + ",slidingTimeMillis=" + this.f48917b + ",renderStrategy=" + this.f48918c + ",fadeInAnimEnable=" + this.f48919d + ",fadeOutAnimEnable=" + this.f48920e + ",angleSensitive=" + this.f48921f;
    }

    public int getDriverMarkerZindex() {
        return this.f48922g;
    }

    public void setDriverMarkerZindex(int i) {
        this.f48922g = i;
    }

    public DriverCollection getDriverCollection() {
        return this.f48916a;
    }

    public long getSlidingTimeMillis() {
        return this.f48917b;
    }

    public RenderStrategy getRenderStrategy() {
        return this.f48918c;
    }

    public boolean isFadeInAnimEnable() {
        return this.f48919d;
    }

    public boolean isFadeOutAnimEnable() {
        return this.f48920e;
    }

    public boolean isAngleSensitive() {
        return this.f48921f;
    }

    public List<VectorCoordinateFilter> getFilterList() {
        return this.f48923h;
    }

    public static class Builder {

        /* renamed from: P */
        private RenderParams f48924P = new RenderParams();

        public Builder setDriverCollection(DriverCollection driverCollection) {
            if (driverCollection != null) {
                DriverCollection unused = this.f48924P.f48916a = driverCollection;
            }
            return this;
        }

        public Builder setSlidingTimeMillis(long j) {
            long unused = this.f48924P.f48917b = j;
            return this;
        }

        public Builder setRenderStrategy(RenderStrategy renderStrategy) {
            RenderStrategy unused = this.f48924P.f48918c = renderStrategy;
            return this;
        }

        public Builder setFadeAnimEnable(boolean z, boolean z2) {
            boolean unused = this.f48924P.f48919d = z;
            boolean unused2 = this.f48924P.f48920e = z2;
            return this;
        }

        public Builder setAngleSensitive(boolean z) {
            boolean unused = this.f48924P.f48921f = z;
            return this;
        }

        public Builder addVectorCoordinateFilter(VectorCoordinateFilter vectorCoordinateFilter) {
            this.f48924P.f48923h.add(vectorCoordinateFilter);
            return this;
        }

        public RenderParams create() {
            return this.f48924P;
        }
    }
}
