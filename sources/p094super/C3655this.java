package p094super;

import java.util.HashMap;
import java.util.Map;

/* renamed from: super.this */
/* compiled from: LightingValues */
public class C3655this {

    /* renamed from: a */
    private final Map<String, Double> f8728a;

    public C3655this(Map<String, Double> map) {
        this.f8728a = map;
    }

    /* renamed from: do */
    public void mo43476do(String str, Double d) {
        this.f8728a.put(str, d);
    }

    /* renamed from: do */
    public Map<String, Object> mo43475do() {
        return new HashMap(this.f8728a);
    }
}
