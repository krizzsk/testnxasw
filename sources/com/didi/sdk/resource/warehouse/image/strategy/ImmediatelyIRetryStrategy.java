package com.didi.sdk.resource.warehouse.image.strategy;

import com.didi.sdk.resource.warehouse.image.IRetryStrategy;

public class ImmediatelyIRetryStrategy implements IRetryStrategy {

    /* renamed from: a */
    private final int f39833a;

    public int interval(String str, int i, Throwable th) {
        return 0;
    }

    public ImmediatelyIRetryStrategy(int i) {
        this.f39833a = i;
    }

    public boolean isContinue(String str, int i, Throwable th) {
        return this.f39833a >= i;
    }
}
