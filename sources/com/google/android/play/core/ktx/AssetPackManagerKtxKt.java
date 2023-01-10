package com.google.android.play.core.ktx;

import com.google.android.play.core.assetpacks.AssetLocation;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001d\u0010+\u001a\u00020\u000b*\u00020,2\u0006\u0010-\u001a\u00020.H@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a#\u00100\u001a\u00020\u0017*\u00020,2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000102H@ø\u0001\u0000¢\u0006\u0002\u00103\u001a#\u00104\u001a\u00020\u0017*\u00020,2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000102H@ø\u0001\u0000¢\u0006\u0002\u00103\u001a\u001e\u00105\u001a\b\u0012\u0004\u0012\u00020\u000706*\u00020,2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000102\u001a\u001d\u00107\u001a\u000208*\u00020,2\u0006\u00109\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010:\"\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0016\u0010\n\u001a\u00020\u000b*\u00020\u00078Ç\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0016\u0010\u000e\u001a\u00020\u0001*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\u0006*\u00020\u00128Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0016*\u00020\u00178Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u0016\u0010\u001a\u001a\u00020\u000b*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0016\u0010\u001d\u001a\u00020\u0001*\u00020\u00128Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0004\"\u0016\u0010 \u001a\u00020\u0006*\u00020\u00128Æ\u0002¢\u0006\u0006\u001a\u0004\b!\u0010\u0014\"\u0016\u0010\"\u001a\u00020\u000b*\u00020\u00078Ç\u0002¢\u0006\u0006\u001a\u0004\b#\u0010\r\"\u0016\u0010$\u001a\u00020\u0006*\u00020\u00178Æ\u0002¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u0016\u0010'\u001a\u00020\u0006*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b(\u0010\t\"\u0016\u0010)\u001a\u00020\u000b*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b*\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, mo148868d2 = {"assetsPath", "", "Lcom/google/android/play/core/assetpacks/AssetPackLocation;", "getAssetsPath", "(Lcom/google/android/play/core/assetpacks/AssetPackLocation;)Ljava/lang/String;", "bytesDownloaded", "", "Lcom/google/android/play/core/assetpacks/AssetPackState;", "getBytesDownloaded", "(Lcom/google/android/play/core/assetpacks/AssetPackState;)J", "errorCode", "", "getErrorCode", "(Lcom/google/android/play/core/assetpacks/AssetPackState;)I", "name", "getName", "(Lcom/google/android/play/core/assetpacks/AssetPackState;)Ljava/lang/String;", "offset", "Lcom/google/android/play/core/assetpacks/AssetLocation;", "getOffset", "(Lcom/google/android/play/core/assetpacks/AssetLocation;)J", "packStates", "", "Lcom/google/android/play/core/assetpacks/AssetPackStates;", "getPackStates", "(Lcom/google/android/play/core/assetpacks/AssetPackStates;)Ljava/util/Map;", "packStorageMethod", "getPackStorageMethod", "(Lcom/google/android/play/core/assetpacks/AssetPackLocation;)I", "path", "getPath", "(Lcom/google/android/play/core/assetpacks/AssetLocation;)Ljava/lang/String;", "size", "getSize", "status", "getStatus", "totalBytes", "getTotalBytes", "(Lcom/google/android/play/core/assetpacks/AssetPackStates;)J", "totalBytesToDownload", "getTotalBytesToDownload", "transferProgressPercentage", "getTransferProgressPercentage", "requestCellularDataConfirmation", "Lcom/google/android/play/core/assetpacks/AssetPackManager;", "activity", "Landroid/app/Activity;", "(Lcom/google/android/play/core/assetpacks/AssetPackManager;Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestFetch", "packs", "", "(Lcom/google/android/play/core/assetpacks/AssetPackManager;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestPackStates", "requestProgressFlow", "Lkotlinx/coroutines/flow/Flow;", "requestRemovePack", "", "packName", "(Lcom/google/android/play/core/assetpacks/AssetPackManager;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tmp.wkwm2e3_release"}, mo148869k = 2, mo148870mv = {1, 1, 16})
/* compiled from: AssetPackManagerKtx.kt */
public final class AssetPackManagerKtxKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestFetch(com.google.android.play.core.assetpacks.AssetPackManager r4, java.util.List<java.lang.String> r5, kotlin.coroutines.Continuation<? super com.google.android.play.core.assetpacks.AssetPackStates> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestFetch$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestFetch$1 r0 = (com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestFetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestFetch$1 r0 = new com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestFetch$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r4 = r0.L$0
            com.google.android.play.core.assetpacks.AssetPackManager r4 = (com.google.android.play.core.assetpacks.AssetPackManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0055
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.fetch(r5)
            java.lang.String r2 = "fetch(packs)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            r2 = 2
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            r4 = 0
            java.lang.Object r6 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r6, r4, r0, r2, r4)
            if (r6 != r1) goto L_0x0055
            return r1
        L_0x0055:
            java.lang.String r4 = "runTask(fetch(packs))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.AssetPackManagerKtxKt.requestFetch(com.google.android.play.core.assetpacks.AssetPackManager, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Flow<AssetPackState> requestProgressFlow(AssetPackManager assetPackManager, List<String> list) {
        Intrinsics.checkParameterIsNotNull(assetPackManager, "$this$requestProgressFlow");
        Intrinsics.checkParameterIsNotNull(list, "packs");
        return C2865j.m5969a(FlowKt.callbackFlow(new AssetPackManagerKtxKt$requestProgressFlow$1(assetPackManager, list, (Continuation) null)), Integer.MAX_VALUE, (BufferOverflow) null, 2, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestPackStates(com.google.android.play.core.assetpacks.AssetPackManager r4, java.util.List<java.lang.String> r5, kotlin.coroutines.Continuation<? super com.google.android.play.core.assetpacks.AssetPackStates> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestPackStates$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestPackStates$1 r0 = (com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestPackStates$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestPackStates$1 r0 = new com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestPackStates$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r4 = r0.L$2
            com.google.android.play.core.tasks.Task r4 = (com.google.android.play.core.tasks.Task) r4
            java.lang.Object r4 = r0.L$1
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r4 = r0.L$0
            com.google.android.play.core.assetpacks.AssetPackManager r4 = (com.google.android.play.core.assetpacks.AssetPackManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005b
        L_0x0036:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.getPackStates(r5)
            java.lang.String r2 = "task"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            r2 = 2
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            r4 = 0
            java.lang.Object r6 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r6, r4, r0, r2, r4)
            if (r6 != r1) goto L_0x005b
            return r1
        L_0x005b:
            java.lang.String r4 = "runTask(task)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.AssetPackManagerKtxKt.requestPackStates(com.google.android.play.core.assetpacks.AssetPackManager, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object requestRemovePack(AssetPackManager assetPackManager, String str, Continuation<? super Unit> continuation) {
        Task<Void> removePack = assetPackManager.removePack(str);
        Intrinsics.checkExpressionValueIsNotNull(removePack, "removePack(packName)");
        Object runTask$default = TaskUtilsKt.runTask$default(removePack, (Function0) null, continuation, 2, (Object) null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestCellularDataConfirmation(com.google.android.play.core.assetpacks.AssetPackManager r4, android.app.Activity r5, kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestCellularDataConfirmation$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestCellularDataConfirmation$1 r0 = (com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestCellularDataConfirmation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestCellularDataConfirmation$1 r0 = new com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestCellularDataConfirmation$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            android.app.Activity r4 = (android.app.Activity) r4
            java.lang.Object r4 = r0.L$0
            com.google.android.play.core.assetpacks.AssetPackManager r4 = (com.google.android.play.core.assetpacks.AssetPackManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0055
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.showCellularDataConfirmation(r5)
            java.lang.String r2 = "showCellularDataConfirmation(activity)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            r2 = 2
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            r4 = 0
            java.lang.Object r6 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r6, r4, r0, r2, r4)
            if (r6 != r1) goto L_0x0055
            return r1
        L_0x0055:
            java.lang.String r4 = "runTask(showCellularDataConfirmation(activity))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.AssetPackManagerKtxKt.requestCellularDataConfirmation(com.google.android.play.core.assetpacks.AssetPackManager, android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Map<String, AssetPackState> getPackStates(AssetPackStates assetPackStates) {
        Intrinsics.checkParameterIsNotNull(assetPackStates, "$this$packStates");
        Map<String, AssetPackState> packStates = assetPackStates.packStates();
        Intrinsics.checkExpressionValueIsNotNull(packStates, "packStates()");
        return packStates;
    }

    public static final long getTotalBytes(AssetPackStates assetPackStates) {
        Intrinsics.checkParameterIsNotNull(assetPackStates, "$this$totalBytes");
        return assetPackStates.totalBytes();
    }

    public static final int getStatus(AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$status");
        return assetPackState.status();
    }

    public static final int getErrorCode(AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$errorCode");
        return assetPackState.errorCode();
    }

    public static final long getBytesDownloaded(AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$bytesDownloaded");
        return assetPackState.bytesDownloaded();
    }

    public static final long getTotalBytesToDownload(AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$totalBytesToDownload");
        return assetPackState.totalBytesToDownload();
    }

    public static final String getName(AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$name");
        String name = assetPackState.name();
        Intrinsics.checkExpressionValueIsNotNull(name, "name()");
        return name;
    }

    public static final int getTransferProgressPercentage(AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$transferProgressPercentage");
        return assetPackState.transferProgressPercentage();
    }

    public static final String getAssetsPath(AssetPackLocation assetPackLocation) {
        Intrinsics.checkParameterIsNotNull(assetPackLocation, "$this$assetsPath");
        return assetPackLocation.assetsPath();
    }

    public static final int getPackStorageMethod(AssetPackLocation assetPackLocation) {
        Intrinsics.checkParameterIsNotNull(assetPackLocation, "$this$packStorageMethod");
        return assetPackLocation.packStorageMethod();
    }

    public static final String getPath(AssetPackLocation assetPackLocation) {
        Intrinsics.checkParameterIsNotNull(assetPackLocation, "$this$path");
        return assetPackLocation.path();
    }

    public static final String getPath(AssetLocation assetLocation) {
        Intrinsics.checkParameterIsNotNull(assetLocation, "$this$path");
        String path = assetLocation.path();
        Intrinsics.checkExpressionValueIsNotNull(path, "path()");
        return path;
    }

    public static final long getOffset(AssetLocation assetLocation) {
        Intrinsics.checkParameterIsNotNull(assetLocation, "$this$offset");
        return assetLocation.offset();
    }

    public static final long getSize(AssetLocation assetLocation) {
        Intrinsics.checkParameterIsNotNull(assetLocation, "$this$size");
        return assetLocation.size();
    }
}
