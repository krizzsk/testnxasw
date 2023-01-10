package com.didi.component.savingcenter;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SavingCenterView.kt */
final class SavingCenterView$setScanVisible$1 implements View.OnClickListener {
    final /* synthetic */ String $deepLink;

    SavingCenterView$setScanVisible$1(String str) {
        this.$deepLink = str;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        DRouter.build(this.$deepLink).start();
    }
}
