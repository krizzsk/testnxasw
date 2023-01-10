package com.didiglobal.privacysdk.law.update;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.drawer.LEGOPopupWindow;
import com.didiglobal.privacysdk.law.update.LawPopDialogShowManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: LawPopDialogShowManager.kt */
final class LawPopDialogShowManager$bindData$2 implements View.OnClickListener {
    final /* synthetic */ LawPopDialogShowManager.Data $data;

    LawPopDialogShowManager$bindData$2(LawPopDialogShowManager.Data data) {
        this.$data = data;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        LawPopDialogShowManager.OnClickListener onClickListener = this.$data.getOnClickListener();
        if (onClickListener != null) {
            LEGOPopupWindow access$getPopWidow$p = LawPopDialogShowManager.f53193a;
            if (access$getPopWidow$p == null) {
                Intrinsics.throwNpe();
            }
            onClickListener.onLinkClick(access$getPopWidow$p, this.$data.getLinkUrl());
        }
    }
}
