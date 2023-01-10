package com.github.mikephil.charting.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

public class MPPointF extends ObjectPool.Poolable {
    public static final Parcelable.Creator<MPPointF> CREATOR = new Parcelable.Creator<MPPointF>() {
        public MPPointF createFromParcel(Parcel parcel) {
            MPPointF mPPointF = new MPPointF(0.0f, 0.0f);
            mPPointF.my_readFromParcel(parcel);
            return mPPointF;
        }

        public MPPointF[] newArray(int i) {
            return new MPPointF[i];
        }
    };

    /* renamed from: a */
    private static ObjectPool<MPPointF> f55041a;

    /* renamed from: x */
    public float f55042x;

    /* renamed from: y */
    public float f55043y;

    static {
        ObjectPool<MPPointF> create = ObjectPool.create(32, new MPPointF(0.0f, 0.0f));
        f55041a = create;
        create.setReplenishPercentage(0.5f);
    }

    public MPPointF() {
    }

    public MPPointF(float f, float f2) {
        this.f55042x = f;
        this.f55043y = f2;
    }

    public static MPPointF getInstance(float f, float f2) {
        MPPointF mPPointF = f55041a.get();
        mPPointF.f55042x = f;
        mPPointF.f55043y = f2;
        return mPPointF;
    }

    public static MPPointF getInstance() {
        return f55041a.get();
    }

    public static MPPointF getInstance(MPPointF mPPointF) {
        MPPointF mPPointF2 = f55041a.get();
        mPPointF2.f55042x = mPPointF.f55042x;
        mPPointF2.f55043y = mPPointF.f55043y;
        return mPPointF2;
    }

    public static void recycleInstance(MPPointF mPPointF) {
        f55041a.recycle(mPPointF);
    }

    public static void recycleInstances(List<MPPointF> list) {
        f55041a.recycle(list);
    }

    public void my_readFromParcel(Parcel parcel) {
        this.f55042x = parcel.readFloat();
        this.f55043y = parcel.readFloat();
    }

    public float getX() {
        return this.f55042x;
    }

    public float getY() {
        return this.f55043y;
    }

    /* access modifiers changed from: protected */
    public ObjectPool.Poolable instantiate() {
        return new MPPointF(0.0f, 0.0f);
    }
}
