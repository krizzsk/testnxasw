package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

@Metadata(mo148867d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo148868d2 = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "clearModuleByClassLoaderCache", "", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflection"}, mo148869k = 2, mo148870mv = {1, 5, 1})
/* compiled from: moduleByClassLoader.kt */
public final class ModuleByClassLoaderKt {

    /* renamed from: a */
    private static final ConcurrentMap<C2439b, WeakReference<RuntimeModuleData>> f4777a = new ConcurrentHashMap();

    public static final RuntimeModuleData getOrCreateModule(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "$this$getOrCreateModule");
        ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(cls);
        C2439b bVar = new C2439b(safeClassLoader);
        WeakReference weakReference = (WeakReference) f4777a.get(bVar);
        if (weakReference != null) {
            RuntimeModuleData runtimeModuleData = (RuntimeModuleData) weakReference.get();
            if (runtimeModuleData != null) {
                Intrinsics.checkNotNullExpressionValue(runtimeModuleData, "it");
                return runtimeModuleData;
            }
            f4777a.remove(bVar, weakReference);
        }
        RuntimeModuleData create = RuntimeModuleData.Companion.create(safeClassLoader);
        while (true) {
            try {
                WeakReference putIfAbsent = f4777a.putIfAbsent(bVar, new WeakReference(create));
                if (putIfAbsent != null) {
                    RuntimeModuleData runtimeModuleData2 = (RuntimeModuleData) putIfAbsent.get();
                    if (runtimeModuleData2 != null) {
                        return runtimeModuleData2;
                    }
                    f4777a.remove(bVar, putIfAbsent);
                } else {
                    bVar.mo24253a((ClassLoader) null);
                    return create;
                }
            } finally {
                bVar.mo24253a((ClassLoader) null);
            }
        }
    }

    public static final void clearModuleByClassLoaderCache() {
        f4777a.clear();
    }
}
