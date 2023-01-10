package com.didi.payment.commonsdk.p130ui.helper;

import android.view.View;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/commonsdk/ui/helper/NLEGODialogBuilder$build$2", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener;", "onAntiShakeClick", "", "view", "Landroid/view/View;", "wallet-service-commonsdk_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.commonsdk.ui.helper.NLEGODialogBuilder$build$2 */
/* compiled from: NLEGODialogBuilder.kt */
public final class NLEGODialogBuilder$build$2 extends LEGOOnAntiShakeClickListener {
    final /* synthetic */ NLEGODialogBuilder this$0;

    NLEGODialogBuilder$build$2(NLEGODialogBuilder nLEGODialogBuilder) {
        this.this$0 = nLEGODialogBuilder;
    }

    public void onAntiShakeClick(View view) {
        DoubleCheckOnClickListener confirmBtnClickListener;
        Intrinsics.checkNotNullParameter(view, "view");
        LEGODrawer legoDrawer = this.this$0.getLegoDrawer();
        if (legoDrawer != null && legoDrawer.isShowing()) {
            legoDrawer.dismiss();
        }
        if (this.this$0.getConfirmBtnClickListener() != null && (confirmBtnClickListener = this.this$0.getConfirmBtnClickListener()) != null) {
            confirmBtnClickListener.doClick(view);
        }
    }
}