package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p074io.IOUtils;

@Metadata(mo148867d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002\u001a\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\bH\u0001¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\bH\u0001¢\u0006\u0002\b\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo148868d2 = {"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"}, mo148869k = 2, mo148870mv = {1, 5, 1})
/* compiled from: DebugMetadata.kt */
public final class DebugMetadataKt {

    /* renamed from: a */
    private static final int f4578a = 1;

    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl baseContinuationImpl) {
        int i;
        String str;
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "$this$getStackTraceElementImpl");
        DebugMetadata a = m4295a(baseContinuationImpl);
        if (a == null) {
            return null;
        }
        m4296a(1, a.mo23695v());
        int b = m4297b(baseContinuationImpl);
        if (b < 0) {
            i = -1;
        } else {
            i = a.mo23691l()[b];
        }
        String a2 = ModuleNameRetriever.f4579a.mo23696a(baseContinuationImpl);
        if (a2 == null) {
            str = a.mo23688c();
        } else {
            str = a2 + IOUtils.DIR_SEPARATOR_UNIX + a.mo23688c();
        }
        return new StackTraceElement(str, a.mo23692m(), a.mo23689f(), i);
    }

    /* renamed from: a */
    private static final DebugMetadata m4295a(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    /* renamed from: b */
    private static final int m4297b(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            Intrinsics.checkNotNullExpressionValue(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private static final void m4296a(int i, int i2) {
        if (i2 > i) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
        }
    }

    public static final String[] getSpilledVariableFieldMapping(BaseContinuationImpl baseContinuationImpl) {
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "$this$getSpilledVariableFieldMapping");
        DebugMetadata a = m4295a(baseContinuationImpl);
        if (a == null) {
            return null;
        }
        m4296a(1, a.mo23695v());
        ArrayList arrayList = new ArrayList();
        int b = m4297b(baseContinuationImpl);
        int[] i = a.mo23690i();
        int length = i.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i[i2] == b) {
                arrayList.add(a.mo23694s()[i2]);
                arrayList.add(a.mo23693n()[i2]);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
