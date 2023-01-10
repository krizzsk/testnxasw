package org.xidea.p089el.impl;

import java.util.Map;

/* renamed from: org.xidea.el.impl.OptimizeStack */
/* compiled from: TokenImpl */
class OptimizeStack extends ValueStackImpl {
    OptimizeStack(Map<String, Object> map) {
        super(map);
    }

    /* access modifiers changed from: protected */
    public Object fallback(Object obj) {
        throw new RuntimeException();
    }
}
