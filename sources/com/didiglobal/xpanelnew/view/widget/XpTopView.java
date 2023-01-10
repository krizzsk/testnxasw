package com.didiglobal.xpanelnew.view.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class XpTopView extends FrameLayout {

    /* renamed from: a */
    private int f54269a = 0;

    /* renamed from: b */
    private IXpSpaceViewHeightCalculate f54270b;

    public interface IXpSpaceViewHeightCalculate {
        int measureHeight(int i);
    }

    public XpTopView(Context context) {
        super(context);
        setBackgroundColor(0);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IXpSpaceViewHeightCalculate iXpSpaceViewHeightCalculate = this.f54270b;
        int measureHeight = iXpSpaceViewHeightCalculate == null ? 0 : iXpSpaceViewHeightCalculate.measureHeight(i);
        this.f54269a = measureHeight;
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(measureHeight, 1073741824));
    }

    public void setSpaceViewHeightCalculate(IXpSpaceViewHeightCalculate iXpSpaceViewHeightCalculate) {
        this.f54270b = iXpSpaceViewHeightCalculate;
    }
}
