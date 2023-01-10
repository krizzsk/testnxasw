package com.google.android.play.core.ktx;

import androidx.core.p006os.LocaleListCompat;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000d\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aô\u0001\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d\u001a$\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002\u001a\u001d\u0010,\u001a\u00020\u001e*\u00020-2\u0006\u0010\u0014\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010.\u001a#\u0010/\u001a\u00020\u001e*\u00020-2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH@ø\u0001\u0000¢\u0006\u0002\u00100\u001a#\u00101\u001a\u00020\u001e*\u00020-2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002020\u000eH@ø\u0001\u0000¢\u0006\u0002\u00100\u001a#\u00103\u001a\u00020\u001e*\u00020-2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002020\u000eH@ø\u0001\u0000¢\u0006\u0002\u00100\u001a#\u00104\u001a\u00020\u001e*\u00020-2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH@ø\u0001\u0000¢\u0006\u0002\u00100\u001a5\u00105\u001a\u00020\u0006*\u00020-2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH@ø\u0001\u0000¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\b\u0012\u0004\u0012\u00020\u000208*\u00020-\u001a\u001d\u00109\u001a\u00020\u0002*\u00020-2\u0006\u0010\u0014\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010.\u001a\u001b\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e*\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010;\u001a\"\u0010<\u001a\u00020\n*\u00020-2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0006\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\"\u0016\u0010\u0014\u001a\u00020\u0006*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\b\"\u0016\u0010\u0016\u001a\u00020\u0006*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\b\"\u0016\u0010\u0018\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006A"}, mo148868d2 = {"bytesDownloaded", "", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "getBytesDownloaded", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)J", "errorCode", "", "getErrorCode", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)I", "hasTerminalStatus", "", "getHasTerminalStatus", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)Z", "languages", "", "", "getLanguages", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)Ljava/util/List;", "moduleNames", "getModuleNames", "sessionId", "getSessionId", "status", "getStatus", "totalBytesToDownload", "getTotalBytesToDownload", "SplitInstallStateUpdatedListener", "Lcom/google/android/play/core/splitinstall/SplitInstallStateUpdatedListener;", "onRequiresConfirmation", "Lkotlin/Function1;", "", "onInstalled", "onFailed", "onPending", "onDownloaded", "onDownloading", "onInstalling", "onCanceling", "onCanceled", "onNonTerminalStatus", "onTerminalStatus", "buildSplitInstallRequest", "Lcom/google/android/play/core/splitinstall/SplitInstallRequest;", "modules", "requestCancelInstall", "Lcom/google/android/play/core/splitinstall/SplitInstallManager;", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestDeferredInstall", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestDeferredLanguageInstall", "Ljava/util/Locale;", "requestDeferredLanguageUninstall", "requestDeferredUninstall", "requestInstall", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestProgressFlow", "Lkotlinx/coroutines/flow/Flow;", "requestSessionState", "requestSessionStates", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConfirmationDialogForResult", "sessionState", "fragment", "Landroidx/fragment/app/Fragment;", "requestCode", "tmp.wkwm2e3_release"}, mo148869k = 2, mo148870mv = {1, 1, 16})
/* compiled from: SplitInstallManagerKtx.kt */
public final class SplitInstallManagerKtxKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestInstall(com.google.android.play.core.splitinstall.SplitInstallManager r4, java.util.List<java.lang.String> r5, java.util.List<java.lang.String> r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            boolean r0 = r7 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestInstall$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestInstall$1 r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestInstall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestInstall$1 r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestInstall$1
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r4 = r0.L$2
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r4 = r0.L$1
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r4 = r0.L$0
            com.google.android.play.core.splitinstall.SplitInstallManager r4 = (com.google.android.play.core.splitinstall.SplitInstallManager) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0060
        L_0x0036:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.google.android.play.core.splitinstall.SplitInstallRequest r7 = buildSplitInstallRequest(r5, r6)
            com.google.android.play.core.tasks.Task r7 = r4.startInstall(r7)
            java.lang.String r2 = "startInstall(buildSplitI…uest(modules, languages))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r2)
            r2 = 2
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            r4 = 0
            java.lang.Object r7 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r7, r4, r0, r2, r4)
            if (r7 != r1) goto L_0x0060
            return r1
        L_0x0060:
            java.lang.String r4 = "runTask(startInstall(bui…est(modules, languages)))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestInstall(com.google.android.play.core.splitinstall.SplitInstallManager, java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object requestInstall$default(SplitInstallManager splitInstallManager, List list, List list2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 2) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        return requestInstall(splitInstallManager, list, list2, continuation);
    }

    public static final Flow<SplitInstallSessionState> requestProgressFlow(SplitInstallManager splitInstallManager) {
        Intrinsics.checkParameterIsNotNull(splitInstallManager, "$this$requestProgressFlow");
        return C2865j.m5969a(FlowKt.callbackFlow(new SplitInstallManagerKtxKt$requestProgressFlow$1(splitInstallManager, (Continuation) null)), Integer.MAX_VALUE, (BufferOverflow) null, 2, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestSessionStates(com.google.android.play.core.splitinstall.SplitInstallManager r4, kotlin.coroutines.Continuation<? super java.util.List<? extends com.google.android.play.core.splitinstall.SplitInstallSessionState>> r5) {
        /*
            boolean r0 = r5 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionStates$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionStates$1 r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionStates$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionStates$1 r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionStates$1
            r0.<init>(r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            com.google.android.play.core.splitinstall.SplitInstallManager r4 = (com.google.android.play.core.splitinstall.SplitInstallManager) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0050
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r5)
            com.google.android.play.core.tasks.Task r5 = r4.getSessionStates()
            java.lang.String r2 = "sessionStates"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r2)
            r2 = 2
            r0.L$0 = r4
            r0.label = r3
            r4 = 0
            java.lang.Object r5 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r5, r4, r0, r2, r4)
            if (r5 != r1) goto L_0x0050
            return r1
        L_0x0050:
            java.lang.String r4 = "runTask(sessionStates)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestSessionStates(com.google.android.play.core.splitinstall.SplitInstallManager, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object requestDeferredInstall(SplitInstallManager splitInstallManager, List<String> list, Continuation<? super Unit> continuation) {
        Task<Void> deferredInstall = splitInstallManager.deferredInstall(list);
        Intrinsics.checkExpressionValueIsNotNull(deferredInstall, "deferredInstall(moduleNames)");
        Object runTask$default = TaskUtilsKt.runTask$default(deferredInstall, (Function0) null, continuation, 2, (Object) null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    public static final Object requestDeferredUninstall(SplitInstallManager splitInstallManager, List<String> list, Continuation<? super Unit> continuation) {
        Task<Void> deferredInstall = splitInstallManager.deferredInstall(list);
        Intrinsics.checkExpressionValueIsNotNull(deferredInstall, "deferredInstall(moduleNames)");
        Object runTask$default = TaskUtilsKt.runTask$default(deferredInstall, (Function0) null, continuation, 2, (Object) null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestSessionState(com.google.android.play.core.splitinstall.SplitInstallManager r4, int r5, kotlin.coroutines.Continuation<? super com.google.android.play.core.splitinstall.SplitInstallSessionState> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionState$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionState$1 r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionState$1 r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionState$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            int r4 = r0.I$0
            java.lang.Object r4 = r0.L$0
            com.google.android.play.core.splitinstall.SplitInstallManager r4 = (com.google.android.play.core.splitinstall.SplitInstallManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0053
        L_0x0030:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.getSessionState(r5)
            java.lang.String r2 = "getSessionState(sessionId)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            r2 = 2
            r0.L$0 = r4
            r0.I$0 = r5
            r0.label = r3
            r4 = 0
            java.lang.Object r6 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r6, r4, r0, r2, r4)
            if (r6 != r1) goto L_0x0053
            return r1
        L_0x0053:
            java.lang.String r4 = "runTask(getSessionState(sessionId))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestSessionState(com.google.android.play.core.splitinstall.SplitInstallManager, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object requestCancelInstall(SplitInstallManager splitInstallManager, int i, Continuation<? super Unit> continuation) {
        Task<Void> cancelInstall = splitInstallManager.cancelInstall(i);
        Intrinsics.checkExpressionValueIsNotNull(cancelInstall, "cancelInstall(sessionId)");
        Object runTask$default = TaskUtilsKt.runTask$default(cancelInstall, (Function0) null, continuation, 2, (Object) null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    public static final Object requestDeferredLanguageInstall(SplitInstallManager splitInstallManager, List<Locale> list, Continuation<? super Unit> continuation) {
        Task<Void> deferredLanguageInstall = splitInstallManager.deferredLanguageInstall(list);
        Intrinsics.checkExpressionValueIsNotNull(deferredLanguageInstall, "deferredLanguageInstall(languages)");
        Object runTask$default = TaskUtilsKt.runTask$default(deferredLanguageInstall, (Function0) null, continuation, 2, (Object) null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    public static final Object requestDeferredLanguageUninstall(SplitInstallManager splitInstallManager, List<Locale> list, Continuation<? super Unit> continuation) {
        Task<Void> deferredLanguageUninstall = splitInstallManager.deferredLanguageUninstall(list);
        Intrinsics.checkExpressionValueIsNotNull(deferredLanguageUninstall, "deferredLanguageUninstall(languages)");
        Object runTask$default = TaskUtilsKt.runTask$default(deferredLanguageUninstall, (Function0) null, continuation, 2, (Object) null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    public static final int getSessionId(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$sessionId");
        return splitInstallSessionState.sessionId();
    }

    public static final int getStatus(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$status");
        return splitInstallSessionState.status();
    }

    public static final int getErrorCode(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$errorCode");
        return splitInstallSessionState.errorCode();
    }

    public static final long getBytesDownloaded(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$bytesDownloaded");
        return splitInstallSessionState.bytesDownloaded();
    }

    public static final long getTotalBytesToDownload(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$totalBytesToDownload");
        return splitInstallSessionState.totalBytesToDownload();
    }

    public static final List<String> getLanguages(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$languages");
        List<String> languages = splitInstallSessionState.languages();
        Intrinsics.checkExpressionValueIsNotNull(languages, "languages()");
        return languages;
    }

    public static final List<String> getModuleNames(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$moduleNames");
        List<String> moduleNames = splitInstallSessionState.moduleNames();
        Intrinsics.checkExpressionValueIsNotNull(moduleNames, "moduleNames()");
        return moduleNames;
    }

    public static final boolean getHasTerminalStatus(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$hasTerminalStatus");
        return splitInstallSessionState.hasTerminalStatus();
    }

    public static /* synthetic */ SplitInstallStateUpdatedListener SplitInstallStateUpdatedListener$default(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function1 function18, Function1 function19, Function1 function110, Function1 function111, int i, Object obj) {
        int i2 = i;
        return SplitInstallStateUpdatedListener(function1, function12, (i2 & 4) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$1.INSTANCE : function13, (i2 & 8) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$2.INSTANCE : function14, (i2 & 16) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$3.INSTANCE : function15, (i2 & 32) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$4.INSTANCE : function16, (i2 & 64) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$5.INSTANCE : function17, (i2 & 128) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$6.INSTANCE : function18, (i2 & 256) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$7.INSTANCE : function19, (i2 & 512) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$8.INSTANCE : function110, (i2 & 1024) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$9.INSTANCE : function111);
    }

    public static final SplitInstallStateUpdatedListener SplitInstallStateUpdatedListener(Function1<? super SplitInstallSessionState, Unit> function1, Function1<? super SplitInstallSessionState, Unit> function12, Function1<? super SplitInstallSessionState, Unit> function13, Function1<? super SplitInstallSessionState, Unit> function14, Function1<? super SplitInstallSessionState, Unit> function15, Function1<? super SplitInstallSessionState, Unit> function16, Function1<? super SplitInstallSessionState, Unit> function17, Function1<? super SplitInstallSessionState, Unit> function18, Function1<? super SplitInstallSessionState, Unit> function19, Function1<? super SplitInstallSessionState, Unit> function110, Function1<? super SplitInstallSessionState, Unit> function111) {
        Intrinsics.checkParameterIsNotNull(function1, "onRequiresConfirmation");
        Intrinsics.checkParameterIsNotNull(function12, "onInstalled");
        Function1<? super SplitInstallSessionState, Unit> function112 = function13;
        Intrinsics.checkParameterIsNotNull(function13, "onFailed");
        Function1<? super SplitInstallSessionState, Unit> function113 = function14;
        Intrinsics.checkParameterIsNotNull(function113, "onPending");
        Function1<? super SplitInstallSessionState, Unit> function114 = function15;
        Intrinsics.checkParameterIsNotNull(function114, "onDownloaded");
        Function1<? super SplitInstallSessionState, Unit> function115 = function16;
        Intrinsics.checkParameterIsNotNull(function115, "onDownloading");
        Function1<? super SplitInstallSessionState, Unit> function116 = function17;
        Intrinsics.checkParameterIsNotNull(function116, "onInstalling");
        Function1<? super SplitInstallSessionState, Unit> function117 = function18;
        Intrinsics.checkParameterIsNotNull(function117, "onCanceling");
        Function1<? super SplitInstallSessionState, Unit> function118 = function19;
        Intrinsics.checkParameterIsNotNull(function118, "onCanceled");
        Function1<? super SplitInstallSessionState, Unit> function119 = function110;
        Intrinsics.checkParameterIsNotNull(function119, "onNonTerminalStatus");
        Function1<? super SplitInstallSessionState, Unit> function120 = function111;
        Intrinsics.checkParameterIsNotNull(function120, "onTerminalStatus");
        return new SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$10(function112, function113, function1, function115, function114, function116, function12, function117, function118, function120, function119);
    }

    public static final boolean startConfirmationDialogForResult(SplitInstallManager splitInstallManager, SplitInstallSessionState splitInstallSessionState, Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(splitInstallManager, "$this$startConfirmationDialogForResult");
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "sessionState");
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        return splitInstallManager.startConfirmationDialogForResult(splitInstallSessionState, (IntentSenderForResultStarter) new C20134xb9d4aeca(new SplitInstallManagerKtxKt$startConfirmationDialogForResult$1(fragment)), i);
    }

    private static final SplitInstallRequest buildSplitInstallRequest(List<String> list, List<String> list2) {
        SplitInstallRequest.Builder newBuilder = SplitInstallRequest.newBuilder();
        for (String addModule : list) {
            newBuilder.addModule(addModule);
        }
        for (String forLanguageTags : list2) {
            newBuilder.addLanguage(LocaleListCompat.forLanguageTags(forLanguageTags).get(0));
        }
        SplitInstallRequest build = newBuilder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "SplitInstallRequest.newB…lang).get(0)) }\n}.build()");
        return build;
    }
}
