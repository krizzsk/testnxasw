package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

public class MPPointD extends ObjectPool.Poolable {

    /* renamed from: a */
    private static ObjectPool<MPPointD> f55038a;

    /* renamed from: x */
    public double f55039x;

    /* renamed from: y */
    public double f55040y;

    static {
        ObjectPool<MPPointD> create = ObjectPool.create(64, new MPPointD(0.0d, 0.0d));
        f55038a = create;
        create.setReplenishPercentage(0.5f);
    }

    public static MPPointD getInstance(double d, double d2) {
        MPPointD mPPointD = f55038a.get();
        mPPointD.f55039x = d;
        mPPointD.f55040y = d2;
        return mPPointD;
    }

    public static void recycleInstance(MPPointD mPPointD) {
        f55038a.recycle(mPPointD);
    }

    public static void recycleInstances(List<MPPointD> list) {
        f55038a.recycle(list);
    }

    /* access modifiers changed from: protected */
    public ObjectPool.Poolable instantiate() {
        return new MPPointD(0.0d, 0.0d);
    }

    private MPPointD(double d, double d2) {
        this.f55039x = d;
        this.f55040y = d2;
    }

    public String toString() {
        return "MPPointD, x: " + this.f55039x + ", y: " + this.f55040y;
    }
}
