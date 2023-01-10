package com.google.android.play.core.ktx;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo148868d2 = {"<anonymous>", "", "Lcom/google/android/play/core/ktx/AppUpdatePassthroughListener;", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: AppUpdateManagerKtx.kt */
final class AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$2 extends Lambda implements Function1<AppUpdatePassthroughListener, Unit> {
    final /* synthetic */ ProducerScope $this_callbackFlow;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$2(ProducerScope producerScope) {
        super(1);
        this.$this_callbackFlow = producerScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppUpdatePassthroughListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AppUpdatePassthroughListener appUpdatePassthroughListener) {
        Intrinsics.checkParameterIsNotNull(appUpdatePassthroughListener, "$receiver");
        SendChannel.DefaultImpls.close$default(this.$this_callbackFlow, (Throwable) null, 1, (Object) null);
    }
}
