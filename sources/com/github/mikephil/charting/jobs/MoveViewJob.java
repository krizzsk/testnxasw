package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class MoveViewJob extends ViewPortJob {

    /* renamed from: a */
    private static ObjectPool<MoveViewJob> f54975a;

    static {
        ObjectPool<MoveViewJob> create = ObjectPool.create(2, new MoveViewJob((ViewPortHandler) null, 0.0f, 0.0f, (Transformer) null, (View) null));
        f54975a = create;
        create.setReplenishPercentage(0.5f);
    }

    public static MoveViewJob getInstance(ViewPortHandler viewPortHandler, float f, float f2, Transformer transformer, View view) {
        MoveViewJob moveViewJob = f54975a.get();
        moveViewJob.mViewPortHandler = viewPortHandler;
        moveViewJob.xValue = f;
        moveViewJob.yValue = f2;
        moveViewJob.mTrans = transformer;
        moveViewJob.view = view;
        return moveViewJob;
    }

    public static void recycleInstance(MoveViewJob moveViewJob) {
        f54975a.recycle(moveViewJob);
    }

    public MoveViewJob(ViewPortHandler viewPortHandler, float f, float f2, Transformer transformer, View view) {
        super(viewPortHandler, f, f2, transformer, view);
    }

    public void run() {
        this.pts[0] = this.xValue;
        this.pts[1] = this.yValue;
        this.mTrans.pointValuesToPixel(this.pts);
        this.mViewPortHandler.centerViewPort(this.pts, this.view);
        recycleInstance(this);
    }

    /* access modifiers changed from: protected */
    public ObjectPool.Poolable instantiate() {
        return new MoveViewJob(this.mViewPortHandler, this.xValue, this.yValue, this.mTrans, this.view);
    }
}
