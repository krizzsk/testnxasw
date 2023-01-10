package com.didi.map.global.sctx.work.core;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class WorkRequest {

    /* renamed from: a */
    private UUID f30163a;

    /* renamed from: b */
    private WorkSpec f30164b;

    protected WorkRequest(UUID uuid, WorkSpec workSpec) {
        this.f30163a = uuid;
        this.f30164b = workSpec;
    }

    public UUID getId() {
        return this.f30163a;
    }

    public WorkSpec getWorkSpec() {
        return this.f30164b;
    }

    public static abstract class Builder<B extends Builder<?, ?>, W extends WorkRequest> {
        UUID mId;
        WorkSpec mWorkSpec;
        Worker mWorker;

        /* access modifiers changed from: package-private */
        public abstract W buildInternal();

        /* access modifiers changed from: package-private */
        public abstract B getThis();

        Builder(Worker worker) {
            this.mWorker = worker;
            UUID randomUUID = UUID.randomUUID();
            this.mId = randomUUID;
            WorkSpec workSpec = new WorkSpec(randomUUID.toString(), worker.getClass().getName());
            this.mWorkSpec = workSpec;
            workSpec.setWorker(worker);
        }

        public B setInitialDelay(long j, TimeUnit timeUnit) {
            this.mWorkSpec.setInitialDelay(timeUnit.toMillis(j));
            return getThis();
        }

        public final W build() {
            return buildInternal();
        }
    }
}
