package com.didi.dimina.container.bridge.plugin;

import com.didi.dimina.container.bridge.base.DMServiceSubBridgeModule;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.messager.jsmodule.JSModuleWrapper;
import java.util.ArrayList;
import java.util.List;

public class InternalJSMethodsOperator {

    /* renamed from: a */
    private final List<Class<? extends BaseServiceModule>> f18647a = new ArrayList();

    /* renamed from: b */
    private final List<JSModuleWrapper> f18648b = new ArrayList();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59731a(Class<? extends BaseServiceModule> cls) {
        DMServiceSubBridgeModule dMServiceSubBridgeModule = (DMServiceSubBridgeModule) cls.getAnnotation(DMServiceSubBridgeModule.class);
        String str = "DMServiceBridgeModule$Inner" + this.f18647a.size();
        boolean z = false;
        if (dMServiceSubBridgeModule != null) {
            if (dMServiceSubBridgeModule.level() <= 0) {
                z = true;
            }
            m15880a(str, cls, z);
            return;
        }
        m15880a(str, cls, false);
    }

    /* renamed from: a */
    private void m15880a(String str, Class<? extends BaseServiceModule> cls, boolean z) {
        if (z) {
            this.f18647a.add(cls);
            this.f18648b.add(new JSModuleWrapper(str, cls));
            return;
        }
        this.f18647a.add(0, cls);
        this.f18648b.add(0, new JSModuleWrapper(str, cls));
    }

    public List<JSModuleWrapper> getListInternalMethodsWrapper() {
        return this.f18648b;
    }
}
