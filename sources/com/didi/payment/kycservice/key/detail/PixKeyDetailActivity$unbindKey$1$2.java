package com.didi.payment.kycservice.key.detail;

import android.view.View;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/kycservice/key/detail/PixKeyDetailActivity$unbindKey$1$2", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixKeyDetailActivity.kt */
public final class PixKeyDetailActivity$unbindKey$1$2 extends DoubleCheckOnClickListener {
    final /* synthetic */ PixKeyDetailActivity this$0;

    PixKeyDetailActivity$unbindKey$1$2(PixKeyDetailActivity pixKeyDetailActivity) {
        this.this$0 = pixKeyDetailActivity;
    }

    public void doClick(View view) {
        WalletDialog access$getMGuideDialogDrawer$p;
        if (this.this$0.f33148m != null) {
            WalletDialog access$getMGuideDialogDrawer$p2 = this.this$0.f33148m;
            Intrinsics.checkNotNull(access$getMGuideDialogDrawer$p2);
            if (access$getMGuideDialogDrawer$p2.isShowing() && (access$getMGuideDialogDrawer$p = this.this$0.f33148m) != null) {
                access$getMGuideDialogDrawer$p.dismiss();
            }
        }
    }
}
