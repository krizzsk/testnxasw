package com.google.android.play.core.ktx;

import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.ktx.AppUpdateResult;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo148868d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo148869k = 3, mo148870mv = {1, 1, 16})
@DebugMetadata(mo23688c = "com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1", mo23689f = "AppUpdateManagerKtx.kt", mo23690i = {0, 0}, mo23691l = {75}, mo23692m = "invokeSuspend", mo23693n = {"$this$callbackFlow", "globalUpdateListener"}, mo23694s = {"L$0", "L$1"})
/* compiled from: AppUpdateManagerKtx.kt */
final class AppUpdateManagerKtxKt$requestUpdateFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super AppUpdateResult>, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppUpdateManager $this_requestUpdateFlow;
    Object L$0;
    Object L$1;
    int label;

    /* renamed from: p$ */
    private ProducerScope f56125p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppUpdateManagerKtxKt$requestUpdateFlow$1(AppUpdateManager appUpdateManager, Continuation continuation) {
        super(2, continuation);
        this.$this_requestUpdateFlow = appUpdateManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        AppUpdateManagerKtxKt$requestUpdateFlow$1 appUpdateManagerKtxKt$requestUpdateFlow$1 = new AppUpdateManagerKtxKt$requestUpdateFlow$1(this.$this_requestUpdateFlow, continuation);
        appUpdateManagerKtxKt$requestUpdateFlow$1.f56125p$ = (ProducerScope) obj;
        return appUpdateManagerKtxKt$requestUpdateFlow$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AppUpdateManagerKtxKt$requestUpdateFlow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = this.f56125p$;
            final AppUpdatePassthroughListener appUpdatePassthroughListener = new AppUpdatePassthroughListener(new AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$1(this, producerScope), new AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$2(producerScope));
            this.$this_requestUpdateFlow.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>(this) {
                final /* synthetic */ AppUpdateManagerKtxKt$requestUpdateFlow$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onSuccess(AppUpdateInfo appUpdateInfo) {
                    int updateAvailability = appUpdateInfo.updateAvailability();
                    if (updateAvailability == 0) {
                        producerScope.close(new InstallException(-2));
                    } else if (updateAvailability == 1) {
                        TaskUtilsKt.tryOffer(producerScope, AppUpdateResult.NotAvailable.INSTANCE);
                        SendChannel.DefaultImpls.close$default(producerScope, (Throwable) null, 1, (Object) null);
                    } else if (updateAvailability == 2 || updateAvailability == 3) {
                        Intrinsics.checkExpressionValueIsNotNull(appUpdateInfo, "updateInfo");
                        if (appUpdateInfo.installStatus() == 11) {
                            TaskUtilsKt.tryOffer(producerScope, new AppUpdateResult.Downloaded(this.this$0.$this_requestUpdateFlow));
                            SendChannel.DefaultImpls.close$default(producerScope, (Throwable) null, 1, (Object) null);
                            return;
                        }
                        this.this$0.$this_requestUpdateFlow.registerListener(appUpdatePassthroughListener);
                        TaskUtilsKt.tryOffer(producerScope, new AppUpdateResult.Available(this.this$0.$this_requestUpdateFlow, appUpdateInfo));
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                public final void onFailure(Exception exc) {
                    producerScope.close(exc);
                }
            });
            this.L$0 = producerScope;
            this.L$1 = appUpdatePassthroughListener;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>(this) {
                final /* synthetic */ AppUpdateManagerKtxKt$requestUpdateFlow$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.$this_requestUpdateFlow.unregisterListener(appUpdatePassthroughListener);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            AppUpdatePassthroughListener appUpdatePassthroughListener2 = (AppUpdatePassthroughListener) this.L$1;
            ProducerScope producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
