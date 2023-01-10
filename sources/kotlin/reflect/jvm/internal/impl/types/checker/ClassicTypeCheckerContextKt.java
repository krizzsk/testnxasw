package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.C2404Reflection;

/* compiled from: ClassicTypeCheckerContext.kt */
public final class ClassicTypeCheckerContextKt {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final String m5253a(Object obj) {
        return "ClassicTypeCheckerContext couldn't handle " + C2404Reflection.getOrCreateKotlinClass(obj.getClass()) + ' ' + obj;
    }
}
