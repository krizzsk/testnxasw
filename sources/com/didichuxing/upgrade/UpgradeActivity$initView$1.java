package com.didichuxing.upgrade;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.util.OmegaUtilsKt;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: UpgradeActivity.kt */
final class UpgradeActivity$initView$1 implements View.OnClickListener {
    final /* synthetic */ UpgradeActivity this$0;

    UpgradeActivity$initView$1(UpgradeActivity upgradeActivity) {
        this.this$0 = upgradeActivity;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        OmegaUtilsKt.OmegaTrack_appupdate_guide_gp_back_ck();
        this.this$0.finish();
    }
}
