package com.google.android.play.core.ktx;

import android.app.Activity;
import com.google.android.play.core.assetpacks.AssetPackManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@"}, mo148868d2 = {"requestCellularDataConfirmation", "", "Lcom/google/android/play/core/assetpacks/AssetPackManager;", "activity", "Landroid/app/Activity;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo148869k = 3, mo148870mv = {1, 1, 16})
@DebugMetadata(mo23688c = "com.google.android.play.core.ktx.AssetPackManagerKtxKt", mo23689f = "AssetPackManagerKtx.kt", mo23690i = {0, 0}, mo23691l = {97}, mo23692m = "requestCellularDataConfirmation", mo23693n = {"$this$requestCellularDataConfirmation", "activity"}, mo23694s = {"L$0", "L$1"})
/* compiled from: AssetPackManagerKtx.kt */
final class AssetPackManagerKtxKt$requestCellularDataConfirmation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    AssetPackManagerKtxKt$requestCellularDataConfirmation$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AssetPackManagerKtxKt.requestCellularDataConfirmation((AssetPackManager) null, (Activity) null, this);
    }
}
