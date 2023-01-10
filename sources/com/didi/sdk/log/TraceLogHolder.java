package com.didi.sdk.log;

public class TraceLogHolder {

    /* renamed from: a */
    private TraceLogListener f39212a;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final TraceLogHolder INSTANCE = new TraceLogHolder();

        private SingletonHolder() {
        }
    }

    private TraceLogHolder() {
    }

    public static final TraceLogHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public TraceLogListener getLogListener() {
        return this.f39212a;
    }

    public void setLogListener(TraceLogListener traceLogListener) {
        this.f39212a = traceLogListener;
    }
}
