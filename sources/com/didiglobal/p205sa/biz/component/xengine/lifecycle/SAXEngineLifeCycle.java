package com.didiglobal.p205sa.biz.component.xengine.lifecycle;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/component/xengine/lifecycle/SAXEngineLifeCycle;", "", "()V", "isServiceEngineActive", "", "setServiceEngineActive", "", "serviceEngineActive", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.xengine.lifecycle.SAXEngineLifeCycle */
/* compiled from: SAXEngineLifeCycle.kt */
public final class SAXEngineLifeCycle {
    public static final SAXEngineLifeCycle INSTANCE = new SAXEngineLifeCycle();

    /* renamed from: a */
    private static boolean f53745a;

    private SAXEngineLifeCycle() {
    }

    public final boolean isServiceEngineActive() {
        return f53745a;
    }

    public final void setServiceEngineActive(boolean z) {
        f53745a = z;
    }
}
