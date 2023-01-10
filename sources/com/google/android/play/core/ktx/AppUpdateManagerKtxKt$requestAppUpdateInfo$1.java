package com.google.android.play.core.ktx;

import com.google.android.play.core.appupdate.AppUpdateManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H@"}, mo148868d2 = {"requestAppUpdateInfo", "", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;"}, mo148869k = 3, mo148870mv = {1, 1, 16})
@DebugMetadata(mo23688c = "com.google.android.play.core.ktx.AppUpdateManagerKtxKt", mo23689f = "AppUpdateManagerKtx.kt", mo23690i = {0}, mo23691l = {199}, mo23692m = "requestAppUpdateInfo", mo23693n = {"$this$requestAppUpdateInfo"}, mo23694s = {"L$0"})
/* compiled from: AppUpdateManagerKtx.kt */
final class AppUpdateManagerKtxKt$requestAppUpdateInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    AppUpdateManagerKtxKt$requestAppUpdateInfo$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AppUpdateManagerKtxKt.requestAppUpdateInfo((AppUpdateManager) null, this);
    }
}
