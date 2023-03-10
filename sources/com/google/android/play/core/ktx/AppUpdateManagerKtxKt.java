package com.google.android.play.core.ktx;

import android.content.IntentSender;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.tasks.Task;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000P\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010 \u001a\u00020\u0002*\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020$*\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u0010\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&*\u00020!\u001a,\u0010(\u001a\u00020\f*\u00020!2\u0006\u0010)\u001a\u00020\u00022\b\b\u0001\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\"\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0016\u0010\u000b\u001a\u00020\f*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0016\u0010\u000f\u001a\u00020\b*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\b*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0016\u0010\u0012\u001a\u00020\b*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\"\u0016\u0010\u0015\u001a\u00020\f*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0016\u0010\u0017\u001a\u00020\f*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016\"\u0016\u0010\u0018\u001a\u00020\u0019*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0016\u0010\u001c\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0004\"\u0016\u0010\u001c\u001a\u00020\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0006\"\u0016\u0010\u001e\u001a\u00020\b*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006."}, mo148868d2 = {"bytesDownloaded", "", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "getBytesDownloaded", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)J", "Lcom/google/android/play/core/install/InstallState;", "(Lcom/google/android/play/core/install/InstallState;)J", "clientVersionStalenessDays", "", "getClientVersionStalenessDays", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)Ljava/lang/Integer;", "hasTerminalStatus", "", "getHasTerminalStatus", "(Lcom/google/android/play/core/install/InstallState;)Z", "installErrorCode", "getInstallErrorCode", "(Lcom/google/android/play/core/install/InstallState;)I", "installStatus", "getInstallStatus", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)I", "isFlexibleUpdateAllowed", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)Z", "isImmediateUpdateAllowed", "packageName", "", "getPackageName", "(Lcom/google/android/play/core/install/InstallState;)Ljava/lang/String;", "totalBytesToDownload", "getTotalBytesToDownload", "updatePriority", "getUpdatePriority", "requestAppUpdateInfo", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCompleteUpdate", "", "requestUpdateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "startUpdateFlowForResult", "appUpdateInfo", "appUpdateType", "fragment", "Landroidx/fragment/app/Fragment;", "requestCode", "tmp.wkwm2e3_release"}, mo148869k = 2, mo148870mv = {1, 1, 16})
/* compiled from: AppUpdateManagerKtx.kt */
public final class AppUpdateManagerKtxKt {
    public static final Flow<AppUpdateResult> requestUpdateFlow(AppUpdateManager appUpdateManager) throws InstallException {
        Intrinsics.checkParameterIsNotNull(appUpdateManager, "$this$requestUpdateFlow");
        return FlowKt.conflate(FlowKt.callbackFlow(new AppUpdateManagerKtxKt$requestUpdateFlow$1(appUpdateManager, (Continuation) null)));
    }

    public static final int getInstallStatus(InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$installStatus");
        return installState.installStatus();
    }

    public static final int getInstallErrorCode(InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$installErrorCode");
        return installState.installErrorCode();
    }

    public static final String getPackageName(InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$packageName");
        String packageName = installState.packageName();
        Intrinsics.checkExpressionValueIsNotNull(packageName, "packageName()");
        return packageName;
    }

    public static final long getBytesDownloaded(InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$bytesDownloaded");
        return installState.bytesDownloaded();
    }

    public static final long getTotalBytesToDownload(InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$totalBytesToDownload");
        return installState.totalBytesToDownload();
    }

    public static final int getInstallStatus(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$installStatus");
        return appUpdateInfo.installStatus();
    }

    public static final Integer getClientVersionStalenessDays(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$clientVersionStalenessDays");
        return appUpdateInfo.clientVersionStalenessDays();
    }

    public static final int getUpdatePriority(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$updatePriority");
        return appUpdateInfo.updatePriority();
    }

    public static final long getBytesDownloaded(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$bytesDownloaded");
        return appUpdateInfo.bytesDownloaded();
    }

    public static final long getTotalBytesToDownload(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$totalBytesToDownload");
        return appUpdateInfo.totalBytesToDownload();
    }

    public static final boolean isFlexibleUpdateAllowed(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$isFlexibleUpdateAllowed");
        return appUpdateInfo.isUpdateTypeAllowed(0);
    }

    public static final boolean isImmediateUpdateAllowed(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$isImmediateUpdateAllowed");
        return appUpdateInfo.isUpdateTypeAllowed(1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestAppUpdateInfo(com.google.android.play.core.appupdate.AppUpdateManager r4, kotlin.coroutines.Continuation<? super com.google.android.play.core.appupdate.AppUpdateInfo> r5) {
        /*
            boolean r0 = r5 instanceof com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1 r0 = (com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1 r0 = new com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1
            r0.<init>(r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            com.google.android.play.core.appupdate.AppUpdateManager r4 = (com.google.android.play.core.appupdate.AppUpdateManager) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004f
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r5)
            com.google.android.play.core.tasks.Task r5 = r4.getAppUpdateInfo()
            java.lang.String r2 = "appUpdateInfo"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r2)
            r2 = 2
            r0.L$0 = r4
            r0.label = r3
            r4 = 0
            java.lang.Object r5 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r5, r4, r0, r2, r4)
            if (r5 != r1) goto L_0x004f
            return r1
        L_0x004f:
            java.lang.String r4 = "runTask(appUpdateInfo)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.AppUpdateManagerKtxKt.requestAppUpdateInfo(com.google.android.play.core.appupdate.AppUpdateManager, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object requestCompleteUpdate(AppUpdateManager appUpdateManager, Continuation<? super Unit> continuation) {
        Task<Void> completeUpdate = appUpdateManager.completeUpdate();
        Intrinsics.checkExpressionValueIsNotNull(completeUpdate, "completeUpdate()");
        Object runTask$default = TaskUtilsKt.runTask$default(completeUpdate, (Function0) null, continuation, 2, (Object) null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    public static final boolean startUpdateFlowForResult(AppUpdateManager appUpdateManager, AppUpdateInfo appUpdateInfo, int i, Fragment fragment, int i2) throws IntentSender.SendIntentException {
        Intrinsics.checkParameterIsNotNull(appUpdateManager, "$this$startUpdateFlowForResult");
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "appUpdateInfo");
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        if (!appUpdateInfo.isUpdateTypeAllowed(i)) {
            return false;
        }
        return appUpdateManager.startUpdateFlowForResult(appUpdateInfo, i, (IntentSenderForResultStarter) new C20119x67d05741(new AppUpdateManagerKtxKt$startUpdateFlowForResult$1(fragment)), i2);
    }

    public static final boolean getHasTerminalStatus(InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$hasTerminalStatus");
        int installStatus = installState.installStatus();
        return installStatus == 0 || installStatus == 11 || installStatus == 5 || installStatus == 6;
    }
}
