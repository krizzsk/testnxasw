package com.didiglobal.enginecore.cache.concurrent;

import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didiglobal/enginecore/cache/concurrent/TaskRunner$runnable$1", "Ljava/lang/Runnable;", "run", "", "engine-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: TaskRunner.kt */
public final class TaskRunner$runnable$1 implements Runnable {
    final /* synthetic */ TaskRunner this$0;

    TaskRunner$runnable$1(TaskRunner taskRunner) {
        this.this$0 = taskRunner;
    }

    public void run() {
        Task awaitTaskToRun;
        while (true) {
            synchronized (this.this$0) {
                awaitTaskToRun = this.this$0.awaitTaskToRun();
            }
            if (awaitTaskToRun != null) {
                TaskQueue queue$engine_core_release = awaitTaskToRun.getQueue$engine_core_release();
                if (queue$engine_core_release == null) {
                    Intrinsics.throwNpe();
                }
                long j = -1;
                boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
                if (isLoggable) {
                    j = queue$engine_core_release.getTaskRunner$engine_core_release().getBackend().nanoTime();
                    TaskLoggerKt.m32811a(awaitTaskToRun, queue$engine_core_release, "starting");
                }
                try {
                    this.this$0.m32814b(awaitTaskToRun);
                    Unit unit = Unit.INSTANCE;
                    if (isLoggable) {
                        long nanoTime = queue$engine_core_release.getTaskRunner$engine_core_release().getBackend().nanoTime() - j;
                        TaskLoggerKt.m32811a(awaitTaskToRun, queue$engine_core_release, "finished run in " + TaskLoggerKt.formatDuration(nanoTime));
                    }
                } catch (Throwable th) {
                    if (isLoggable) {
                        long nanoTime2 = queue$engine_core_release.getTaskRunner$engine_core_release().getBackend().nanoTime() - j;
                        TaskLoggerKt.m32811a(awaitTaskToRun, queue$engine_core_release, "failed a run in " + TaskLoggerKt.formatDuration(nanoTime2));
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }
}
