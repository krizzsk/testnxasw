package com.didichuxing.carsliding.anim;

import com.didichuxing.carsliding.filter.VectorCoordinateFilter;
import com.didichuxing.carsliding.model.VectorCoordinate;
import java.util.List;

public class SlidingMeta {

    /* renamed from: a */
    private VectorCoordinate f48899a;

    /* renamed from: b */
    private boolean f48900b;

    /* renamed from: c */
    private float f48901c;

    /* renamed from: d */
    private int f48902d;

    /* renamed from: e */
    private List<VectorCoordinateFilter> f48903e;

    public SlidingMeta(VectorCoordinate vectorCoordinate, boolean z, float f, int i, List<VectorCoordinateFilter> list) {
        this.f48899a = vectorCoordinate;
        this.f48900b = z;
        this.f48901c = f;
        this.f48902d = i;
        this.f48903e = list;
    }

    public VectorCoordinate getVectorCoordinate() {
        return this.f48899a;
    }

    public boolean isAngleSensitive() {
        return this.f48900b;
    }

    public float getAngle() {
        return this.f48901c;
    }

    public int getSlideAnimDuration() {
        return this.f48902d;
    }

    public List<VectorCoordinateFilter> getFilterList() {
        return this.f48903e;
    }
}
