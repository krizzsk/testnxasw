package com.google.android.play.core.ktx;

import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStateUpdateListener;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "", "state", "Lcom/google/android/play/core/assetpacks/AssetPackState;", "onStateUpdate"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* renamed from: com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestProgressFlow$1$globalSessionListener$1 */
/* compiled from: AssetPackManagerKtx.kt */
final class C20123x2beb98f7 implements AssetPackStateUpdateListener {
    final /* synthetic */ Set $packStatesAlreadyOffered;
    final /* synthetic */ ProducerScope $this_callbackFlow;

    C20123x2beb98f7(ProducerScope producerScope, Set set) {
        this.$this_callbackFlow = producerScope;
        this.$packStatesAlreadyOffered = set;
    }

    public final void onStateUpdate(AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "state");
        Set set = this.$packStatesAlreadyOffered;
        String name = assetPackState.name();
        Intrinsics.checkExpressionValueIsNotNull(name, "name()");
        set.add(name);
        TaskUtilsKt.tryOffer(this.$this_callbackFlow, assetPackState);
    }
}
