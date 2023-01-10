package com.firebase.jobdispatcher;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RetryStrategy {
    public static final RetryStrategy DEFAULT_EXPONENTIAL = new RetryStrategy(1, 30, 3600);
    public static final RetryStrategy DEFAULT_LINEAR = new RetryStrategy(2, 30, 3600);
    public static final int RETRY_POLICY_EXPONENTIAL = 1;
    public static final int RETRY_POLICY_LINEAR = 2;

    /* renamed from: a */
    private final int f54684a;

    /* renamed from: b */
    private final int f54685b;

    /* renamed from: c */
    private final int f54686c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RetryPolicy {
    }

    RetryStrategy(int i, int i2, int i3) {
        this.f54684a = i;
        this.f54685b = i2;
        this.f54686c = i3;
    }

    public int getPolicy() {
        return this.f54684a;
    }

    public int getInitialBackoff() {
        return this.f54685b;
    }

    public int getMaximumBackoff() {
        return this.f54686c;
    }

    static final class Builder {
        private final ValidationEnforcer validator;

        Builder(ValidationEnforcer validationEnforcer) {
            this.validator = validationEnforcer;
        }

        public RetryStrategy build(int i, int i2, int i3) {
            RetryStrategy retryStrategy = new RetryStrategy(i, i2, i3);
            this.validator.ensureValid(retryStrategy);
            return retryStrategy;
        }
    }
}
