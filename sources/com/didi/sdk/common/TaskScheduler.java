package com.didi.sdk.common;

public abstract class TaskScheduler {
    public static final int RIGHT_NOW = 1;
    public static final int WHEN_MAIN_ACTIVITY_CREATED = 2;

    /* renamed from: a */
    private static volatile TaskScheduler f38393a;
    protected int mWhenFlag = 1;

    public abstract void clear();

    public abstract void notify(int i);

    public abstract void scheduleBkgTask(Runnable runnable, int i);

    public abstract void scheduleUiTask(Runnable runnable, int i);

    public static TaskScheduler getDefault() {
        if (f38393a == null) {
            synchronized (TaskScheduler.class) {
                if (f38393a == null) {
                    f38393a = new TaskSchedulerImpl();
                }
            }
        }
        return f38393a;
    }

    /* access modifiers changed from: protected */
    public void resetWhenFlag() {
        this.mWhenFlag = 1;
    }
}
