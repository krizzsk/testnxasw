package com.didi.component.drainage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.didi.global.globaluikit.widget.RoundCornerRelativeLayout;
import com.taxis99.R;

public class DrainageCornerRelative extends RoundCornerRelativeLayout {

    /* renamed from: b */
    private View f14654b;

    /* renamed from: c */
    private View f14655c;

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
        if (this.f14654b == null) {
            this.f14654b = findViewById(R.id.drainage_tips);
        }
        if (this.f14655c == null) {
            this.f14655c = findViewById(R.id.img);
        }
        if (this.f14654b != null && this.f14655c != null) {
            setMeasuredDimension(getMeasuredWidth(), this.f14654b.getMeasuredHeight() + this.f14655c.getMeasuredHeight() + (UiUtils.dip2px(getContext(), 24.0f) * 2));
        }
    }
}
