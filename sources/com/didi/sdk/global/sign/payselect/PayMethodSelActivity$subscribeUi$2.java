package com.didi.sdk.global.sign.payselect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "", "it"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PayMethodSelActivity.kt */
final class PayMethodSelActivity$subscribeUi$2 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ PayMethodSelActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PayMethodSelActivity$subscribeUi$2(PayMethodSelActivity payMethodSelActivity) {
        super(1);
        this.this$0 = payMethodSelActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Unit) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        this.this$0.f38987g.updateUI();
    }
}
