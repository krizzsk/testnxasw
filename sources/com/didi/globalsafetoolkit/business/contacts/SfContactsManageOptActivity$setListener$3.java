package com.didi.globalsafetoolkit.business.contacts;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.globalsafetoolkit.business.share.controller.SfGetOptController;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: SfContactsManageOptActivity.kt */
final class SfContactsManageOptActivity$setListener$3 implements View.OnClickListener {
    final /* synthetic */ SfContactsManageOptActivity this$0;

    SfContactsManageOptActivity$setListener$3(SfContactsManageOptActivity sfContactsManageOptActivity) {
        this.this$0 = sfContactsManageOptActivity;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        SfGetOptController access$getSfGetOptController$p = this.this$0.f24986i;
        if (access$getSfGetOptController$p != null) {
            access$getSfGetOptController$p.hideGuide();
        }
        SfGetOptController access$getSfGetOptController$p2 = this.this$0.f24986i;
        if (access$getSfGetOptController$p2 != null) {
            access$getSfGetOptController$p2.goContact();
        }
    }
}
