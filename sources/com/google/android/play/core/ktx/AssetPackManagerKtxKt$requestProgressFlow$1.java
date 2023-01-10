package com.google.android.play.core.ktx;

import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStateUpdateListener;
import com.google.android.play.core.assetpacks.AssetPackStates;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
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
import kotlinx.coroutines.channels.SendChannel;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo148868d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/google/android/play/core/assetpacks/AssetPackState;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo148869k = 3, mo148870mv = {1, 1, 16})
@DebugMetadata(mo23688c = "com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestProgressFlow$1", mo23689f = "AssetPackManagerKtx.kt", mo23690i = {0, 0, 0}, mo23691l = {67}, mo23692m = "invokeSuspend", mo23693n = {"$this$callbackFlow", "packStatesAlreadyOffered", "globalSessionListener"}, mo23694s = {"L$0", "L$1", "L$2"})
/* compiled from: AssetPackManagerKtx.kt */
final class AssetPackManagerKtxKt$requestProgressFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super AssetPackState>, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $packs;
    final /* synthetic */ AssetPackManager $this_requestProgressFlow;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* renamed from: p$ */
    private ProducerScope f56126p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AssetPackManagerKtxKt$requestProgressFlow$1(AssetPackManager assetPackManager, List list, Continuation continuation) {
        super(2, continuation);
        this.$this_requestProgressFlow = assetPackManager;
        this.$packs = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        AssetPackManagerKtxKt$requestProgressFlow$1 assetPackManagerKtxKt$requestProgressFlow$1 = new AssetPackManagerKtxKt$requestProgressFlow$1(this.$this_requestProgressFlow, this.$packs, continuation);
        assetPackManagerKtxKt$requestProgressFlow$1.f56126p$ = (ProducerScope) obj;
        return assetPackManagerKtxKt$requestProgressFlow$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AssetPackManagerKtxKt$requestProgressFlow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = this.f56126p$;
            final Set linkedHashSet = new LinkedHashSet();
            final AssetPackStateUpdateListener assetPackManagerKtxKt$requestProgressFlow$1$globalSessionListener$1 = new C20123x2beb98f7(producerScope, linkedHashSet);
            this.$this_requestProgressFlow.registerListener(assetPackManagerKtxKt$requestProgressFlow$1$globalSessionListener$1);
            this.$this_requestProgressFlow.getPackStates(this.$packs).addOnSuccessListener(new OnSuccessListener<AssetPackStates>(this) {
                final /* synthetic */ AssetPackManagerKtxKt$requestProgressFlow$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onSuccess(AssetPackStates assetPackStates) {
                    Intrinsics.checkParameterIsNotNull(assetPackStates, "states");
                    Collection arrayList = new ArrayList();
                    for (Object next : this.this$0.$packs) {
                        if (!linkedHashSet.contains((String) next)) {
                            arrayList.add(next);
                        }
                    }
                    for (String str : (List) arrayList) {
                        SendChannel sendChannel = producerScope;
                        Map<String, AssetPackState> packStates = assetPackStates.packStates();
                        Intrinsics.checkExpressionValueIsNotNull(packStates, "packStates()");
                        AssetPackState assetPackState = packStates.get(str);
                        if (assetPackState == null) {
                            Intrinsics.throwNpe();
                        }
                        TaskUtilsKt.tryOffer(sendChannel, assetPackState);
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                public final void onFailure(Exception exc) {
                    producerScope.close(exc);
                }
            });
            this.L$0 = producerScope;
            this.L$1 = linkedHashSet;
            this.L$2 = assetPackManagerKtxKt$requestProgressFlow$1$globalSessionListener$1;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>(this) {
                final /* synthetic */ AssetPackManagerKtxKt$requestProgressFlow$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.$this_requestProgressFlow.unregisterListener(assetPackManagerKtxKt$requestProgressFlow$1$globalSessionListener$1);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            AssetPackStateUpdateListener assetPackStateUpdateListener = (AssetPackStateUpdateListener) this.L$2;
            Set set = (Set) this.L$1;
            ProducerScope producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
