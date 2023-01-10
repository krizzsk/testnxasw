package com.google.android.play.core.ktx;

import com.google.android.play.core.splitinstall.SplitInstallManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H@"}, mo148868d2 = {"requestSessionStates", "", "Lcom/google/android/play/core/splitinstall/SplitInstallManager;", "continuation", "Lkotlin/coroutines/Continuation;", "", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;"}, mo148869k = 3, mo148870mv = {1, 1, 16})
@DebugMetadata(mo23688c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", mo23689f = "SplitInstallManagerKtx.kt", mo23690i = {0}, mo23691l = {89}, mo23692m = "requestSessionStates", mo23693n = {"$this$requestSessionStates"}, mo23694s = {"L$0"})
/* compiled from: SplitInstallManagerKtx.kt */
final class SplitInstallManagerKtxKt$requestSessionStates$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    SplitInstallManagerKtxKt$requestSessionStates$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SplitInstallManagerKtxKt.requestSessionStates((SplitInstallManager) null, this);
    }
}
