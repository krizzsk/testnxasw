package com.didi.global.fintech.cashier.soda.processor;

import android.os.CountDownTimer;
import android.text.TextUtils;
import com.didi.global.fintech.cashier.core.utils.CashierLog;
import com.didi.global.fintech.cashier.soda.contract.ISodaSyncUICallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\b\u0010\u0010\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/processor/SodaPayWaitTimeOutProcessor;", "", "maxPayWaitTime", "", "callback", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaSyncUICallback;", "(Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/soda/contract/ISodaSyncUICallback;)V", "Ljava/lang/Integer;", "timer", "Landroid/os/CountDownTimer;", "onActionIntercept", "", "action", "", "onDestroy", "startTimer", "stopTimer", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaPayWaitTimeOutProcessor.kt */
public final class SodaPayWaitTimeOutProcessor {

    /* renamed from: a */
    private final Integer f23545a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ISodaSyncUICallback f23546b;

    /* renamed from: c */
    private CountDownTimer f23547c;

    public SodaPayWaitTimeOutProcessor(Integer num, ISodaSyncUICallback iSodaSyncUICallback) {
        Intrinsics.checkNotNullParameter(iSodaSyncUICallback, "callback");
        this.f23545a = num;
        this.f23546b = iSodaSyncUICallback;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SodaPayWaitTimeOutProcessor(Integer num, ISodaSyncUICallback iSodaSyncUICallback, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, iSodaSyncUICallback);
    }

    public final void startTimer() {
        Integer num = this.f23545a;
        Long valueOf = num == null ? null : Long.valueOf((long) num.intValue());
        if (valueOf != null) {
            long longValue = valueOf.longValue();
            if (this.f23547c == null) {
                CashierLog.INSTANCE.mo68928i("SodaPayWaitTimeOutProcessor startTimer");
                CountDownTimer sodaPayWaitTimeOutProcessor$startTimer$1 = new SodaPayWaitTimeOutProcessor$startTimer$1(this, longValue * ((long) 1000));
                this.f23547c = sodaPayWaitTimeOutProcessor$startTimer$1;
                if (sodaPayWaitTimeOutProcessor$startTimer$1 != null) {
                    sodaPayWaitTimeOutProcessor$startTimer$1.start();
                }
            }
        }
    }

    /* renamed from: a */
    private final void m19224a() {
        CashierLog.INSTANCE.mo68928i("SodaPayWaitTimeOutProcessor stopTimer");
        CountDownTimer countDownTimer = this.f23547c;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f23547c = null;
    }

    public final void onDestroy() {
        m19224a();
    }

    public final void onActionIntercept(String str) {
        CashierLog.INSTANCE.mo68928i(Intrinsics.stringPlus("SodaPayWaitTimeOutProcessor action = ", str));
        if (!TextUtils.isEmpty(str)) {
            m19224a();
        }
    }
}
