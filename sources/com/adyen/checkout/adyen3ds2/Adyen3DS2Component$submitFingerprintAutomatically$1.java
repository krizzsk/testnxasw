package com.adyen.checkout.adyen3ds2;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.adyen.checkout.adyen3ds2.Adyen3DS2Component", mo23689f = "Adyen3DS2Component.kt", mo23690i = {0, 0}, mo23691l = {267}, mo23692m = "submitFingerprintAutomatically", mo23693n = {"this", "activity"}, mo23694s = {"L$0", "L$1"})
/* compiled from: Adyen3DS2Component.kt */
final class Adyen3DS2Component$submitFingerprintAutomatically$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Adyen3DS2Component this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Adyen3DS2Component$submitFingerprintAutomatically$1(Adyen3DS2Component adyen3DS2Component, Continuation<? super Adyen3DS2Component$submitFingerprintAutomatically$1> continuation) {
        super(continuation);
        this.this$0 = adyen3DS2Component;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m1026a((Activity) null, (String) null, (Continuation<? super Unit>) this);
    }
}
