package com.google.android.play.core.ktx;

import com.google.android.play.core.assetpacks.AssetPackManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@"}, mo148868d2 = {"requestPackStates", "", "Lcom/google/android/play/core/assetpacks/AssetPackManager;", "packs", "", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/google/android/play/core/assetpacks/AssetPackStates;"}, mo148869k = 3, mo148870mv = {1, 1, 16})
@DebugMetadata(mo23688c = "com.google.android.play.core.ktx.AssetPackManagerKtxKt", mo23689f = "AssetPackManagerKtx.kt", mo23690i = {0, 0, 0}, mo23691l = {79}, mo23692m = "requestPackStates", mo23693n = {"$this$requestPackStates", "packs", "task"}, mo23694s = {"L$0", "L$1", "L$2"})
/* compiled from: AssetPackManagerKtx.kt */
final class AssetPackManagerKtxKt$requestPackStates$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    AssetPackManagerKtxKt$requestPackStates$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AssetPackManagerKtxKt.requestPackStates((AssetPackManager) null, (List<String>) null, this);
    }
}
