package jumio.core;

import com.jumio.core.plugins.C20991a;
import com.jumio.core.plugins.ScanPartPlugin;
import java.util.EnumMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.d0 */
/* compiled from: PluginManager.kt */
public final class C19470d0 {

    /* renamed from: a */
    public final Object f55334a = new Object();

    /* renamed from: b */
    public final EnumMap<C20991a.C20994c, C19467c0> f55335b = new EnumMap<>(C20991a.C20994c.class);

    /* renamed from: a */
    public final <T extends C19467c0> T mo148608a(C20991a.C20994c cVar) {
        T t;
        Intrinsics.checkNotNullParameter(cVar, "pluginMode");
        synchronized (this.f55334a) {
            t = this.f55335b.get(cVar);
            if (t == null) {
                t = C20991a.m43783b(cVar);
                if (t != null) {
                    this.f55335b.put(cVar, t);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return (C19467c0) t;
    }

    /* renamed from: a */
    public final void mo148609a() {
        synchronized (this.f55334a) {
            for (Map.Entry next : this.f55335b.entrySet()) {
                C20991a.C20994c cVar = (C20991a.C20994c) next.getKey();
                C19467c0 c0Var = (C19467c0) next.getValue();
                if (c0Var instanceof ScanPartPlugin) {
                    ((ScanPartPlugin) c0Var).unload();
                }
            }
            this.f55335b.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
