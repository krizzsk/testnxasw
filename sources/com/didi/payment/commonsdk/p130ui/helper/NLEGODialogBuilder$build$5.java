package com.didi.payment.commonsdk.p130ui.helper;

import android.view.View;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/commonsdk/ui/helper/NLEGODialogBuilder$build$5", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener;", "onAntiShakeClick", "", "view", "Landroid/view/View;", "wallet-service-commonsdk_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.commonsdk.ui.helper.NLEGODialogBuilder$build$5 */
/* compiled from: NLEGODialogBuilder.kt */
public final class NLEGODialogBuilder$build$5 extends LEGOOnAntiShakeClickListener {
    final /* synthetic */ NLEGODialogBuilder this$0;

    NLEGODialogBuilder$build$5(NLEGODialogBuilder nLEGODialogBuilder) {
        this.this$0 = nLEGODialogBuilder;
    }

    public void onAntiShakeClick(View view) {
        DoubleCheckOnClickListener closeBtnClickListener = this.this$0.getCloseBtnClickListener();
        if (closeBtnClickListener != null) {
            closeBtnClickListener.onClick(view);
        }
    }
}
