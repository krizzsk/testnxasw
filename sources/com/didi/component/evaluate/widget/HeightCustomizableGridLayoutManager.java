package com.didi.component.evaluate.widget;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.util.GLog;

public class HeightCustomizableGridLayoutManager extends GridLayoutManager {

    /* renamed from: a */
    private static final String f15295a = "MaxHeightLM";

    /* renamed from: b */
    private OnHeightMeasureListener f15296b;

    /* renamed from: c */
    private RecyclerView f15297c;

    public interface OnHeightMeasureListener {
        int onHeightMeasured(int i);
    }

    public HeightCustomizableGridLayoutManager(RecyclerView recyclerView, Context context, int i) {
        super(context, i);
        this.f15297c = recyclerView;
    }

    public void setMeasuredDimension(int i, int i2) {
        GLog.m11354d(f15295a, "height : " + i2);
        OnHeightMeasureListener onHeightMeasureListener = this.f15296b;
        if (onHeightMeasureListener != null) {
            i2 = onHeightMeasureListener.onHeightMeasured(i2);
        }
        GLog.m11354d(f15295a, "final height : " + i2);
        super.setMeasuredDimension(i, i2);
    }

    public void setOnHeightMeasureListener(OnHeightMeasureListener onHeightMeasureListener) {
        this.f15296b = onHeightMeasureListener;
    }
}
