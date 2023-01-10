package com.didiglobal.travel.infra.rxjava2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, mo148868d2 = {"Lcom/didiglobal/travel/infra/rxjava2/CompletableSubscribe;", "Lcom/didiglobal/travel/infra/rxjava2/Subscriber;", "()V", "onCompleteAction", "Lkotlin/Function0;", "", "getOnCompleteAction$lib_rxjava2_release", "()Lkotlin/jvm/functions/Function0;", "setOnCompleteAction$lib_rxjava2_release", "(Lkotlin/jvm/functions/Function0;)V", "onComplete", "action", "lib-rxjava2_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: Subscriber.kt */
public final class CompletableSubscribe extends Subscriber {

    /* renamed from: a */
    private Function0<Unit> f53966a;

    public CompletableSubscribe() {
        super((DefaultConstructorMarker) null);
    }

    public final Function0<Unit> getOnCompleteAction$lib_rxjava2_release() {
        return this.f53966a;
    }

    public final void setOnCompleteAction$lib_rxjava2_release(Function0<Unit> function0) {
        this.f53966a = function0;
    }

    public final void onComplete(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "action");
        this.f53966a = function0;
    }
}
