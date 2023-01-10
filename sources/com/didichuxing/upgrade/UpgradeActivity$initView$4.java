package com.didichuxing.upgrade;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: UpgradeActivity.kt */
final class UpgradeActivity$initView$4 implements View.OnClickListener {
    public static final UpgradeActivity$initView$4 INSTANCE = new UpgradeActivity$initView$4();

    UpgradeActivity$initView$4() {
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        UpgradeConfig.iConfig.openWebView(UpgradeActivityKt.URL_TESTING_LEARN_MORE);
    }
}
