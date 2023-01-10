package com.adyen.checkout.adyen3ds2.repository;

import com.adyen.checkout.adyen3ds2.Adyen3DS2Configuration;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository", mo23689f = "SubmitFingerprintRepository.kt", mo23690i = {}, mo23691l = {66}, mo23692m = "submitFingerprint", mo23693n = {}, mo23694s = {})
/* compiled from: SubmitFingerprintRepository.kt */
final class SubmitFingerprintRepository$submitFingerprint$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SubmitFingerprintRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubmitFingerprintRepository$submitFingerprint$1(SubmitFingerprintRepository submitFingerprintRepository, Continuation<? super SubmitFingerprintRepository$submitFingerprint$1> continuation) {
        super(continuation);
        this.this$0 = submitFingerprintRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.submitFingerprint((String) null, (Adyen3DS2Configuration) null, (String) null, this);
    }
}
