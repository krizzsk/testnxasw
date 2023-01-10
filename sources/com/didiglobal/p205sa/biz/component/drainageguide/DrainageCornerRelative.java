package com.didiglobal.p205sa.biz.component.drainageguide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.didi.global.globaluikit.widget.RoundCornerRelativeLayout;
import com.didiglobal.p205sa.biz.util.UiUtils;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.drainageguide.DrainageCornerRelative */
public class DrainageCornerRelative extends RoundCornerRelativeLayout {

    /* renamed from: b */
    private View f53357b;

    /* renamed from: c */
    private View f53358c;

    public DrainageCornerRelative(Context context) {
        super(context);
    }

    public DrainageCornerRelative(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DrainageCornerRelative(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f53357b == null) {
            this.f53357b = findViewById(R.id.drainage_tips);
        }
        if (this.f53358c == null) {
            this.f53358c = findViewById(R.id.img);
        }
        if (this.f53357b != null && this.f53358c != null) {
            setMeasuredDimension(getMeasuredWidth(), this.f53357b.getMeasuredHeight() + this.f53358c.getMeasuredHeight() + (UiUtils.INSTANCE.dip2px(getContext(), 24.0f) * 2));
        }
    }
}
