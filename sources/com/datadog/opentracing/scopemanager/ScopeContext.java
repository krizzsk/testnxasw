package com.datadog.opentracing.scopemanager;

import p218io.opentracing.ScopeManager;

@Deprecated
public interface ScopeContext extends ScopeManager {
    boolean inContext();
}
