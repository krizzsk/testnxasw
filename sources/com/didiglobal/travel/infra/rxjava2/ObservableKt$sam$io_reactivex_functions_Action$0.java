package com.didiglobal.travel.infra.rxjava2;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p218io.reactivex.functions.Action;

@Metadata(mo148866bv = {1, 0, 3}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: Observable.kt */
final class ObservableKt$sam$io_reactivex_functions_Action$0 implements Action {
    private final /* synthetic */ Function0 function;

    ObservableKt$sam$io_reactivex_functions_Action$0(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ void run() {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(), "invoke(...)");
    }
}
