package com.didiglobal.enginecore.cache.concurrent;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\fH&J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, mo148868d2 = {"Lcom/didiglobal/enginecore/cache/concurrent/Task;", "", "name", "", "cancelable", "", "(Ljava/lang/String;Z)V", "getCancelable", "()Z", "getName", "()Ljava/lang/String;", "nextExecuteNanoTime", "", "getNextExecuteNanoTime$engine_core_release", "()J", "setNextExecuteNanoTime$engine_core_release", "(J)V", "queue", "Lcom/didiglobal/enginecore/cache/concurrent/TaskQueue;", "getQueue$engine_core_release", "()Lcom/didiglobal/enginecore/cache/concurrent/TaskQueue;", "setQueue$engine_core_release", "(Lcom/didiglobal/enginecore/cache/concurrent/TaskQueue;)V", "initQueue", "", "initQueue$engine_core_release", "runOnce", "toString", "engine-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: Task.kt */
public abstract class Task {
    private final boolean cancelable;
    private final String name;
    private long nextExecuteNanoTime;
    private TaskQueue queue;

    public abstract long runOnce();

    public Task(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        this.name = str;
        this.cancelable = z;
        this.nextExecuteNanoTime = -1;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Task(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z);
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    public final TaskQueue getQueue$engine_core_release() {
        return this.queue;
    }

    public final void setQueue$engine_core_release(TaskQueue taskQueue) {
        this.queue = taskQueue;
    }

    public final long getNextExecuteNanoTime$engine_core_release() {
        return this.nextExecuteNanoTime;
    }

    public final void setNextExecuteNanoTime$engine_core_release(long j) {
        this.nextExecuteNanoTime = j;
    }

    public final void initQueue$engine_core_release(TaskQueue taskQueue) {
        Intrinsics.checkParameterIsNotNull(taskQueue, "queue");
        TaskQueue taskQueue2 = this.queue;
        if (taskQueue2 != taskQueue) {
            if (taskQueue2 == null) {
                this.queue = taskQueue;
                return;
            }
            throw new IllegalStateException("task is in multiple queues".toString());
        }
    }

    public String toString() {
        return this.name;
    }
}
