package com.google.android.play.core.ktx;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* renamed from: com.google.android.play.core.ktx.SplitInstallManagerKtxKt$sam$com_google_android_play_core_common_IntentSenderForResultStarter$0 */
/* compiled from: SplitInstallManagerKtx.kt */
final class C20134xb9d4aeca implements IntentSenderForResultStarter {
    private final /* synthetic */ Function7 function;

    C20134xb9d4aeca(Function7 function7) {
        this.function = function7;
    }

    public final /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(intentSender, "p0");
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle), "invoke(...)");
    }
}
