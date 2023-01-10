package com.google.android.play.core.ktx;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "", "state", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "onStateUpdate"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* renamed from: com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1 */
/* compiled from: SplitInstallManagerKtx.kt */
final class C20133xcb3a9f2f implements SplitInstallStateUpdatedListener {
    final /* synthetic */ Set $sessionsAlreadyOffered;
    final /* synthetic */ ProducerScope $this_callbackFlow;

    C20133xcb3a9f2f(ProducerScope producerScope, Set set) {
        this.$this_callbackFlow = producerScope;
        this.$sessionsAlreadyOffered = set;
    }

    public final void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "state");
        this.$sessionsAlreadyOffered.add(Integer.valueOf(splitInstallSessionState.sessionId()));
        TaskUtilsKt.tryOffer(this.$this_callbackFlow, splitInstallSessionState);
    }
}
