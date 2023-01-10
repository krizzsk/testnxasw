package com.didi.sdk.apm.aspect;

import org.aspectj.lang.reflect.SourceLocation;

/* renamed from: com.didi.sdk.apm.aspect.a */
/* compiled from: BaseAspect */
class C12709a {
    C12709a() {
    }

    static String getDisplaySourceLocation(SourceLocation sourceLocation) {
        return sourceLocation.getWithinType().getName() + ":" + sourceLocation.getLine();
    }
}
