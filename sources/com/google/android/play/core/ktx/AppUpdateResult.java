package com.google.android.play.core.ktx;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo148868d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult;", "", "()V", "Available", "Downloaded", "InProgress", "NotAvailable", "Lcom/google/android/play/core/ktx/AppUpdateResult$NotAvailable;", "Lcom/google/android/play/core/ktx/AppUpdateResult$Available;", "Lcom/google/android/play/core/ktx/AppUpdateResult$InProgress;", "Lcom/google/android/play/core/ktx/AppUpdateResult$Downloaded;", "tmp.wkwm2e3_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: AppUpdateManagerKtx.kt */
public abstract class AppUpdateResult {
    private AppUpdateResult() {
    }

    public /* synthetic */ AppUpdateResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo148868d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$NotAvailable;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "()V", "tmp.wkwm2e3_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: AppUpdateManagerKtx.kt */
    public static final class NotAvailable extends AppUpdateResult {
        public static final NotAvailable INSTANCE = new NotAvailable();

        private NotAvailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, mo148868d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$Available;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "updateInfo", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lcom/google/android/play/core/appupdate/AppUpdateInfo;)V", "getUpdateInfo", "()Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "startFlexibleUpdate", "", "activity", "Landroid/app/Activity;", "requestCode", "", "fragment", "Landroidx/fragment/app/Fragment;", "startImmediateUpdate", "tmp.wkwm2e3_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: AppUpdateManagerKtx.kt */
    public static final class Available extends AppUpdateResult {
        private final AppUpdateManager appUpdateManager;
        private final AppUpdateInfo updateInfo;

        public final AppUpdateInfo getUpdateInfo() {
            return this.updateInfo;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Available(AppUpdateManager appUpdateManager2, AppUpdateInfo appUpdateInfo) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(appUpdateManager2, "appUpdateManager");
            Intrinsics.checkParameterIsNotNull(appUpdateInfo, "updateInfo");
            this.appUpdateManager = appUpdateManager2;
            this.updateInfo = appUpdateInfo;
        }

        public final boolean startFlexibleUpdate(Activity activity, int i) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            return this.appUpdateManager.startUpdateFlowForResult(this.updateInfo, 0, activity, i);
        }

        public final boolean startFlexibleUpdate(Fragment fragment, int i) {
            Intrinsics.checkParameterIsNotNull(fragment, "fragment");
            return AppUpdateManagerKtxKt.startUpdateFlowForResult(this.appUpdateManager, this.updateInfo, 0, fragment, i);
        }

        public final boolean startImmediateUpdate(Activity activity, int i) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            return this.appUpdateManager.startUpdateFlowForResult(this.updateInfo, 1, activity, i);
        }

        public final boolean startImmediateUpdate(Fragment fragment, int i) {
            Intrinsics.checkParameterIsNotNull(fragment, "fragment");
            return AppUpdateManagerKtxKt.startUpdateFlowForResult(this.appUpdateManager, this.updateInfo, 1, fragment, i);
        }
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$InProgress;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "installState", "Lcom/google/android/play/core/install/InstallState;", "(Lcom/google/android/play/core/install/InstallState;)V", "getInstallState", "()Lcom/google/android/play/core/install/InstallState;", "tmp.wkwm2e3_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: AppUpdateManagerKtx.kt */
    public static final class InProgress extends AppUpdateResult {
        private final InstallState installState;

        public final InstallState getInstallState() {
            return this.installState;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InProgress(InstallState installState2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(installState2, "installState");
            this.installState = installState2;
        }
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, mo148868d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$Downloaded;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;)V", "completeUpdate", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tmp.wkwm2e3_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: AppUpdateManagerKtx.kt */
    public static final class Downloaded extends AppUpdateResult {
        private final AppUpdateManager appUpdateManager;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Downloaded(AppUpdateManager appUpdateManager2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(appUpdateManager2, "appUpdateManager");
            this.appUpdateManager = appUpdateManager2;
        }

        public final Object completeUpdate(Continuation<? super Unit> continuation) {
            Object requestCompleteUpdate = AppUpdateManagerKtxKt.requestCompleteUpdate(this.appUpdateManager, continuation);
            return requestCompleteUpdate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? requestCompleteUpdate : Unit.INSTANCE;
        }
    }
}
