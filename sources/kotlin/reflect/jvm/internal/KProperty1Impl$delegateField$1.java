package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "Ljava/lang/reflect/Field;", "T", "V", "invoke"}, mo148869k = 3, mo148870mv = {1, 5, 1})
/* compiled from: KProperty1Impl.kt */
final class KProperty1Impl$delegateField$1 extends Lambda implements Function0<Field> {
    final /* synthetic */ KProperty1Impl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KProperty1Impl$delegateField$1(KProperty1Impl kProperty1Impl) {
        super(0);
        this.this$0 = kProperty1Impl;
    }

    public final Field invoke() {
        return this.this$0.computeDelegateField();
    }
}
