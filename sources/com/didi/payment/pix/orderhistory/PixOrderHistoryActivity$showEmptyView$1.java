package com.didi.payment.pix.orderhistory;

import android.view.View;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.raven.config.RavenKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/pix/orderhistory/PixOrderHistoryActivity$showEmptyView$1", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixOrderHistoryActivity.kt */
public final class PixOrderHistoryActivity$showEmptyView$1 extends DoubleCheckOnClickListener {
    final /* synthetic */ PixOrderHistoryActivity this$0;

    PixOrderHistoryActivity$showEmptyView$1(PixOrderHistoryActivity pixOrderHistoryActivity) {
        this.this$0 = pixOrderHistoryActivity;
    }

    public void doClick(View view) {
        Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
        PixOrderHistoryActivity.access$getVm(this.this$0).loadHistoryData(true);
    }
}
