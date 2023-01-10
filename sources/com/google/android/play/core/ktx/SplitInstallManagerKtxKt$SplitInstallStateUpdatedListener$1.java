package com.google.android.play.core.ktx;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "", "it", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: SplitInstallManagerKtx.kt */
final class SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$1 extends Lambda implements Function1<SplitInstallSessionState, Unit> {
    public static final SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$1 INSTANCE = new SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$1();

    SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SplitInstallSessionState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "it");
    }
}
