package com.didi.global.fintech.cashier.model.strategy;

import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.strategy.BaseStrategy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy;", "Lcom/didi/global/fintech/cashier/model/strategy/BaseStrategy;", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "syncTimes", "", "interval", "action", "Lkotlin/Function2;", "Lcom/didi/global/fintech/cashier/model/strategy/BaseStrategy$Result;", "(IILkotlin/jvm/functions/Function2;)V", "getAction", "()Lkotlin/jvm/functions/Function2;", "getInterval", "()I", "getSyncTimes", "setSyncTimes", "(I)V", "handle", "model", "Companion", "cashier_model_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SyncStatusStrategy.kt */
public final class SyncStatusStrategy implements BaseStrategy<PayStatusResponse> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Function2<SyncStatusStrategy, PayStatusResponse, BaseStrategy.Result> f23491d = SyncStatusStrategy$Companion$Normal$1.INSTANCE;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Function2<SyncStatusStrategy, PayStatusResponse, BaseStrategy.Result> f23492e = SyncStatusStrategy$Companion$FastPay$1.INSTANCE;

    /* renamed from: a */
    private int f23493a;

    /* renamed from: b */
    private final int f23494b;

    /* renamed from: c */
    private final Function2<SyncStatusStrategy, PayStatusResponse, BaseStrategy.Result> f23495c;

    public SyncStatusStrategy(int i, int i2, Function2<? super SyncStatusStrategy, ? super PayStatusResponse, ? extends BaseStrategy.Result> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        this.f23493a = i;
        this.f23494b = i2;
        this.f23495c = function2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SyncStatusStrategy(int i, int i2, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 20 : i, (i3 & 2) != 0 ? 3 : i2, function2);
    }

    public final int getSyncTimes() {
        return this.f23493a;
    }

    public final void setSyncTimes(int i) {
        this.f23493a = i;
    }

    public final int getInterval() {
        return this.f23494b;
    }

    public final Function2<SyncStatusStrategy, PayStatusResponse, BaseStrategy.Result> getAction() {
        return this.f23495c;
    }

    @Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy$Companion;", "", "()V", "FastPay", "Lkotlin/Function2;", "Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy;", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "Lcom/didi/global/fintech/cashier/model/strategy/BaseStrategy$Result;", "getFastPay", "()Lkotlin/jvm/functions/Function2;", "Normal", "getNormal", "cashier_model_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SyncStatusStrategy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function2<SyncStatusStrategy, PayStatusResponse, BaseStrategy.Result> getNormal() {
            return SyncStatusStrategy.f23491d;
        }

        public final Function2<SyncStatusStrategy, PayStatusResponse, BaseStrategy.Result> getFastPay() {
            return SyncStatusStrategy.f23492e;
        }
    }

    public BaseStrategy.Result handle(PayStatusResponse payStatusResponse) {
        Intrinsics.checkNotNullParameter(payStatusResponse, "model");
        return this.f23495c.invoke(this, payStatusResponse);
    }
}
