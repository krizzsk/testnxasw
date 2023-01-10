package com.google.android.play.core.ktx;

import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo148868d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo148869k = 3, mo148870mv = {1, 1, 16})
@DebugMetadata(mo23688c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestProgressFlow$1", mo23689f = "SplitInstallManagerKtx.kt", mo23690i = {0, 0, 0}, mo23691l = {78}, mo23692m = "invokeSuspend", mo23693n = {"$this$callbackFlow", "sessionsAlreadyOffered", "globalSessionListener"}, mo23694s = {"L$0", "L$1", "L$2"})
/* compiled from: SplitInstallManagerKtx.kt */
final class SplitInstallManagerKtxKt$requestProgressFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super SplitInstallSessionState>, Continuation<? super Unit>, Object> {
    final /* synthetic */ SplitInstallManager $this_requestProgressFlow;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* renamed from: p$ */
    private ProducerScope f56127p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SplitInstallManagerKtxKt$requestProgressFlow$1(SplitInstallManager splitInstallManager, Continuation continuation) {
        super(2, continuation);
        this.$this_requestProgressFlow = splitInstallManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SplitInstallManagerKtxKt$requestProgressFlow$1 splitInstallManagerKtxKt$requestProgressFlow$1 = new SplitInstallManagerKtxKt$requestProgressFlow$1(this.$this_requestProgressFlow, continuation);
        splitInstallManagerKtxKt$requestProgressFlow$1.f56127p$ = (ProducerScope) obj;
        return splitInstallManagerKtxKt$requestProgressFlow$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SplitInstallManagerKtxKt$requestProgressFlow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = this.f56127p$;
            final Set linkedHashSet = new LinkedHashSet();
            final SplitInstallStateUpdatedListener splitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1 = new C20133xcb3a9f2f(producerScope, linkedHashSet);
            this.$this_requestProgressFlow.registerListener(splitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1);
            this.$this_requestProgressFlow.getSessionStates().addOnSuccessListener(new OnSuccessListener<List<SplitInstallSessionState>>() {
                public final void onSuccess(List<? extends SplitInstallSessionState> list) {
                    Intrinsics.checkParameterIsNotNull(list, "sessionList");
                    Collection arrayList = new ArrayList();
                    for (Object next : list) {
                        if (!linkedHashSet.contains(Integer.valueOf(((SplitInstallSessionState) next).sessionId()))) {
                            arrayList.add(next);
                        }
                    }
                    for (SplitInstallSessionState tryOffer : (List) arrayList) {
                        TaskUtilsKt.tryOffer(producerScope, tryOffer);
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                public final void onFailure(Exception exc) {
                    producerScope.close(exc);
                }
            });
            this.L$0 = producerScope;
            this.L$1 = linkedHashSet;
            this.L$2 = splitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>(this) {
                final /* synthetic */ SplitInstallManagerKtxKt$requestProgressFlow$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.$this_requestProgressFlow.unregisterListener(splitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            SplitInstallStateUpdatedListener splitInstallStateUpdatedListener = (SplitInstallStateUpdatedListener) this.L$2;
            Set set = (Set) this.L$1;
            ProducerScope producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
