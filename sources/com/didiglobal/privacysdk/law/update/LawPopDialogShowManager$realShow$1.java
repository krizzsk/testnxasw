package com.didiglobal.privacysdk.law.update;

import com.didi.global.globaluikit.drawer.LEGODrawerDismissListener;
import com.didiglobal.privacysdk.law.update.LawPopDialogShowManager;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "onDismiss"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: LawPopDialogShowManager.kt */
final class LawPopDialogShowManager$realShow$1 implements LEGODrawerDismissListener {
    public static final LawPopDialogShowManager$realShow$1 INSTANCE = new LawPopDialogShowManager$realShow$1();

    LawPopDialogShowManager$realShow$1() {
    }

    public final void onDismiss() {
        LawPopDialogShowManager.f53194b = false;
        LawPopDialogShowManager.OnDismissListener access$getDissmissListener$p = LawPopDialogShowManager.f53197e;
        if (access$getDissmissListener$p != null) {
            access$getDissmissListener$p.onDismiss();
        }
    }
}
