package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.internal.KeyedWeakReferenceMirror;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "", "it", "Lkshark/internal/KeyedWeakReferenceMirror;", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* renamed from: kshark.KeyedWeakReferenceFinder$findKeyedWeakReferences$1$addedToContext$3 */
/* compiled from: KeyedWeakReferenceFinder.kt */
final class C2925xf4ad033e extends Lambda implements Function1<KeyedWeakReferenceMirror, Boolean> {
    public static final C2925xf4ad033e INSTANCE = new C2925xf4ad033e();

    C2925xf4ad033e() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((KeyedWeakReferenceMirror) obj));
    }

    public final boolean invoke(KeyedWeakReferenceMirror keyedWeakReferenceMirror) {
        Intrinsics.checkParameterIsNotNull(keyedWeakReferenceMirror, "it");
        return keyedWeakReferenceMirror.getHasReferent();
    }
}
