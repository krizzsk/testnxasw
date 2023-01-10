package com.google.android.datatransport.runtime.backends;

public abstract class BackendResponse {

    public enum Status {
        f55136OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public abstract long getNextRequestWaitMillis();

    public abstract Status getStatus();

    public static BackendResponse transientError() {
        return new AutoValue_BackendResponse(Status.TRANSIENT_ERROR, -1);
    }

    public static BackendResponse fatalError() {
        return new AutoValue_BackendResponse(Status.FATAL_ERROR, -1);
    }

    /* renamed from: ok */
    public static BackendResponse m40761ok(long j) {
        return new AutoValue_BackendResponse(Status.f55136OK, j);
    }
}
