package com.didi.nova.assembly.p128ui.banner;

import android.content.Context;
import android.widget.Scroller;

/* renamed from: com.didi.nova.assembly.ui.banner.b */
/* compiled from: BannerScroller */
class C11097b extends Scroller {

    /* renamed from: a */
    private int f31709a;

    public C11097b(Context context, int i) {
        super(context);
        this.f31709a = i;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.f31709a);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.f31709a);
    }
}
