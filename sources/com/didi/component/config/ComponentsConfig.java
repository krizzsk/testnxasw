package com.didi.component.config;

import android.util.Pair;
import com.didi.component.config.BusinessRegistry;
import com.didi.sdk.util.UiThreadHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ComponentsConfig {

    /* renamed from: a */
    private static volatile ComponentsConfig f14433a;

    /* renamed from: b */
    private Map<Object, C5828a> f14434b = new LinkedHashMap();

    /* renamed from: c */
    private final List<ComponentConfigChangedListener> f14435c = new ArrayList();

    public interface ComponentConfigChangedListener {
        void onComponentConfigChanged(List<Pair<String, Integer>> list);
    }

    private ComponentsConfig() {
    }

    public static ComponentsConfig get() {
        if (f14433a == null) {
            synchronized (ComponentsConfig.class) {
                if (f14433a == null) {
                    f14433a = new ComponentsConfig();
                }
            }
        }
        return f14433a;
    }

    public ComponentConfig queryConfig(String str, Object obj, int i) {
        C5828a aVar;
        PageConfig pageConfig;
        synchronized (this) {
            aVar = this.f14434b.get(obj);
        }
        if (aVar == null || (pageConfig = aVar.f14475g.get(i)) == null) {
            return null;
        }
        return pageConfig.f14460c.get(str);
    }

    public void replace(GlobalConfig globalConfig) {
        synchronized (this) {
            if (globalConfig != null) {
                if (!globalConfig.f14443a.isEmpty()) {
                    BusinessRegistry.m11954a();
                    this.f14434b.putAll(globalConfig.f14443a);
                    BusinessRegistry.m11956a(m11963a(this.f14434b.values()));
                }
                m11966a(globalConfig.f14443a);
            }
        }
    }

    /* renamed from: a */
    private void m11966a(Map<Object, C5828a> map) {
        if (!map.isEmpty()) {
            Collection<C5828a> values = map.values();
            if (!values.isEmpty()) {
                final ArrayList arrayList = new ArrayList();
                for (C5828a next : values) {
                    if (next != null) {
                        arrayList.add(new Pair(next.f14470b, Integer.valueOf(next.f14469a)));
                    }
                }
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        ComponentsConfig.this.m11965a((List<Pair<String, Integer>>) arrayList);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private List<BusinessRegistry.Entry> m11963a(Collection<C5828a> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (C5828a a : collection) {
            BusinessRegistry.Entry a2 = m11962a(a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private BusinessRegistry.Entry m11962a(C5828a aVar) {
        if (aVar == null) {
            return null;
        }
        return new BusinessRegistry.Entry(aVar.f14469a, aVar.f14470b, aVar.f14474f);
    }

    public boolean containsBusinessConfig(String str) {
        return this.f14434b.containsKey(str);
    }

    public boolean containsBusinessConfig(int i) {
        return this.f14434b.containsKey(Integer.valueOf(i));
    }

    public void addComponentConfigChangedListener(ComponentConfigChangedListener componentConfigChangedListener) {
        if (componentConfigChangedListener != null) {
            synchronized (this.f14435c) {
                if (!this.f14435c.contains(componentConfigChangedListener)) {
                    this.f14435c.add(componentConfigChangedListener);
                }
            }
        }
    }

    public void removeComponentConfigChangedListener(ComponentConfigChangedListener componentConfigChangedListener) {
        synchronized (this.f14435c) {
            this.f14435c.remove(componentConfigChangedListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11965a(List<Pair<String, Integer>> list) {
        ComponentConfigChangedListener[] componentConfigChangedListenerArr;
        synchronized (this.f14435c) {
            componentConfigChangedListenerArr = (ComponentConfigChangedListener[]) this.f14435c.toArray(new ComponentConfigChangedListener[this.f14435c.size()]);
        }
        for (ComponentConfigChangedListener onComponentConfigChanged : componentConfigChangedListenerArr) {
            onComponentConfigChanged.onComponentConfigChanged(list);
        }
    }

    public void checkOrAddComponent(int i, String str) {
        synchronized (this) {
            if (!this.f14434b.containsKey(Integer.valueOf(i))) {
                C5828a aVar = new C5828a();
                aVar.f14469a = i;
                aVar.f14474f = str;
                this.f14434b.put(Integer.valueOf(i), aVar);
                m11967b(this.f14434b);
            }
        }
    }

    /* renamed from: b */
    private void m11967b(Map<Object, C5828a> map) {
        BusinessRegistry.m11956a(m11963a(map.values()));
        m11966a(map);
    }
}
