package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClassifier;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"}, mo148869k = 3, mo148870mv = {1, 5, 1})
/* compiled from: KTypeImpl.kt */
final class KTypeImpl$classifier$2 extends Lambda implements Function0<KClassifier> {
    final /* synthetic */ KTypeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KTypeImpl$classifier$2(KTypeImpl kTypeImpl) {
        super(0);
        this.this$0 = kTypeImpl;
    }

    public final KClassifier invoke() {
        KTypeImpl kTypeImpl = this.this$0;
        return kTypeImpl.m4633a(kTypeImpl.getType());
    }
}
