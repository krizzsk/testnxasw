package com.didi.sdk.resource.warehouse.image.strategy;

import com.didi.sdk.resource.warehouse.image.IRetryStrategy;

public class FixedIntervalRetryStrategy implements IRetryStrategy {

    /* renamed from: a */
    private final int f39831a;

    /* renamed from: b */
    private final int f39832b;

    public FixedIntervalRetryStrategy(int i, int i2) {
        this.f39831a = i;
        this.f39832b = i2;
    }

    public int interval(String str, int i, Throwable th) {
        return this.f39831a;
    }

    public boolean isContinue(String str, int i, Throwable th) {
        return this.f39832b >= i;
    }
}
