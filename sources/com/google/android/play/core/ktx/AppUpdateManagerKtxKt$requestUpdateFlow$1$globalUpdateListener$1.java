package com.google.android.play.core.ktx;

import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.ktx.AppUpdateResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "", "installState", "Lcom/google/android/play/core/install/InstallState;", "onStateUpdate"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: AppUpdateManagerKtx.kt */
final class AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$1 implements InstallStateUpdatedListener {
    final /* synthetic */ ProducerScope $this_callbackFlow;
    final /* synthetic */ AppUpdateManagerKtxKt$requestUpdateFlow$1 this$0;

    AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$1(AppUpdateManagerKtxKt$requestUpdateFlow$1 appUpdateManagerKtxKt$requestUpdateFlow$1, ProducerScope producerScope) {
        this.this$0 = appUpdateManagerKtxKt$requestUpdateFlow$1;
        this.$this_callbackFlow = producerScope;
    }

    public final void onStateUpdate(InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "installState");
        if (installState.installStatus() == 11) {
            TaskUtilsKt.tryOffer(this.$this_callbackFlow, new AppUpdateResult.Downloaded(this.this$0.$this_requestUpdateFlow));
        } else {
            TaskUtilsKt.tryOffer(this.$this_callbackFlow, new AppUpdateResult.InProgress(installState));
        }
    }
}
