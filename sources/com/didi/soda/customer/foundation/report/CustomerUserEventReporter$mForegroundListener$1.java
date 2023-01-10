package com.didi.soda.customer.foundation.report;

import com.didi.soda.customer.app.ApplicationForegroundListener;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, mo148868d2 = {"com/didi/soda/customer/foundation/report/CustomerUserEventReporter$mForegroundListener$1", "Lcom/didi/soda/customer/app/ApplicationForegroundListener;", "onBecomeBackground", "", "currentBackgroundTime", "", "lastForegroundTime", "onBecomeForeground", "currentForegroundTime", "lastBackgroundTime", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerUserEventReporter.kt */
public final class CustomerUserEventReporter$mForegroundListener$1 implements ApplicationForegroundListener {
    CustomerUserEventReporter$mForegroundListener$1() {
    }

    public void onBecomeBackground(long j, long j2) {
        CustomerUserEventReporter.INSTANCE.reportBackground();
    }

    public void onBecomeForeground(long j, long j2) {
        CustomerUserEventReporter.INSTANCE.reportForeground();
    }
}
