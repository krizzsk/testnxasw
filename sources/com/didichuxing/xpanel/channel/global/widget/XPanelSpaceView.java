package com.didichuxing.xpanel.channel.global.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didichuxing.xpanel.channel.global.impl.IXPanelMeasureHelper;

public class XPanelSpaceView extends FrameLayout {

    /* renamed from: a */
    private int f52044a = 0;

    /* renamed from: b */
    private Rect f52045b = new Rect();

    /* renamed from: c */
    private IXPanelMeasureHelper f52046c;

    public XPanelSpaceView(Context context) {
        super(context);
        setBackgroundColor(0);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int measureHeight = this.f52046c.measureHeight(i);
        this.f52044a = measureHeight;
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(measureHeight, 1073741824));
    }

    public boolean contain(int i, int i2) {
        IXPanelMeasureHelper iXPanelMeasureHelper = this.f52046c;
        if (iXPanelMeasureHelper == null) {
            return false;
        }
        iXPanelMeasureHelper.getMessageRect(this.f52045b);
        Rect rect = this.f52045b;
        rect.top = this.f52044a - rect.top;
        Rect rect2 = this.f52045b;
        rect2.bottom = this.f52044a - rect2.bottom;
        return this.f52045b.contains(i, i2);
    }

    public void setXPanelMeasureHelper(IXPanelMeasureHelper iXPanelMeasureHelper) {
        this.f52046c = iXPanelMeasureHelper;
    }
}
