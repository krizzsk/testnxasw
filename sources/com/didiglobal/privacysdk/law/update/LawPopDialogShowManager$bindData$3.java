package com.didiglobal.privacysdk.law.update;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: LawPopDialogShowManager.kt */
final class LawPopDialogShowManager$bindData$3 implements Runnable {
    public static final LawPopDialogShowManager$bindData$3 INSTANCE = new LawPopDialogShowManager$bindData$3();

    LawPopDialogShowManager$bindData$3() {
    }

    public final void run() {
        TextView access$getContent$p = LawPopDialogShowManager.f53201i;
        int measuredHeight = access$getContent$p != null ? access$getContent$p.getMeasuredHeight() : 0;
        MaxHeightScrollView access$getContentLayout$p = LawPopDialogShowManager.f53198f;
        int measuredHeight2 = access$getContentLayout$p != null ? access$getContentLayout$p.getMeasuredHeight() : 0;
        if (measuredHeight <= 0 || measuredHeight2 <= 0 || measuredHeight <= measuredHeight2) {
            View access$getViewBg$p = LawPopDialogShowManager.f53199g;
            if (access$getViewBg$p != null) {
                access$getViewBg$p.setVisibility(8);
                return;
            }
            return;
        }
        View access$getViewBg$p2 = LawPopDialogShowManager.f53199g;
        if (access$getViewBg$p2 != null) {
            access$getViewBg$p2.setVisibility(0);
        }
    }
}
