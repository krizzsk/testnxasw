package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: FakePureImplementationsProvider.kt */
public final class FakePureImplementationsProvider {
    public static final FakePureImplementationsProvider INSTANCE = new FakePureImplementationsProvider();

    /* renamed from: a */
    private static final HashMap<FqName, FqName> f5088a = new HashMap<>();

    private FakePureImplementationsProvider() {
    }

    public final FqName getPurelyImplementedInterface(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "classFqName");
        return f5088a.get(fqName);
    }

    static {
        INSTANCE.m4770a(StandardNames.FqNames.mutableList, INSTANCE.m4769a("java.util.ArrayList", "java.util.LinkedList"));
        INSTANCE.m4770a(StandardNames.FqNames.mutableSet, INSTANCE.m4769a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        INSTANCE.m4770a(StandardNames.FqNames.mutableMap, INSTANCE.m4769a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        INSTANCE.m4770a(new FqName("java.util.function.Function"), INSTANCE.m4769a("java.util.function.UnaryOperator"));
        INSTANCE.m4770a(new FqName("java.util.function.BiFunction"), INSTANCE.m4769a("java.util.function.BinaryOperator"));
    }

    /* renamed from: a */
    private final void m4770a(FqName fqName, List<FqName> list) {
        Map map = f5088a;
        for (Object next : list) {
            FqName fqName2 = (FqName) next;
            map.put(next, fqName);
        }
    }

    /* renamed from: a */
    private final List<FqName> m4769a(String... strArr) {
        Collection arrayList = new ArrayList(strArr.length);
        for (String fqName : strArr) {
            arrayList.add(new FqName(fqName));
        }
        return (List) arrayList;
    }
}
