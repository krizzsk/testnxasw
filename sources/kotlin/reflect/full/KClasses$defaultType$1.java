package kotlin.reflect.full;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KClassImpl;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"}, mo148869k = 3, mo148870mv = {1, 5, 1})
/* compiled from: KClasses.kt */
final class KClasses$defaultType$1 extends Lambda implements Function0<Type> {
    final /* synthetic */ KClass $this_defaultType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClasses$defaultType$1(KClass kClass) {
        super(0);
        this.$this_defaultType = kClass;
    }

    public final Type invoke() {
        return ((KClassImpl) this.$this_defaultType).getJClass();
    }
}
