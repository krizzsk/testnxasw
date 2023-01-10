package com.didi.payment.base.net;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Deferred;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.didi.payment.base.net.WalletNetKt", mo23689f = "WalletNet.kt", mo23690i = {0, 0}, mo23691l = {50}, mo23692m = "await", mo23693n = {"onFailure", "onComplete"}, mo23694s = {"L$0", "L$1"})
/* compiled from: WalletNet.kt */
final class WalletNetKt$await$2<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    WalletNetKt$await$2(Continuation<? super WalletNetKt$await$2> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WalletNetKt.await((Deferred) null, (Function1<? super Exception, Unit>) null, (Function0<Unit>) null, this);
    }
}
