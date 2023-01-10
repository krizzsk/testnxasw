package com.didi.nova.assembly.p128ui.banner;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.nova.assembly.ui.banner.BannerPagerAdapter$1 */
class BannerPagerAdapter$1 implements View.OnClickListener {
    final /* synthetic */ C11096a this$0;
    final /* synthetic */ int val$position;

    BannerPagerAdapter$1(C11096a aVar, int i) {
        this.this$0 = aVar;
        this.val$position = i;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int a = this.this$0.m24239b(this.val$position);
        if (((Banner) this.this$0.f31707d.get()).f31683a != null) {
            ((Banner) this.this$0.f31707d.get()).f31683a.onBannerClick(a);
        }
        SystemUtils.log(3, "Banner", "banner click, pos = " + a, (Throwable) null, "com.didi.nova.assembly.ui.banner.BannerPagerAdapter$1", 71);
    }
}
