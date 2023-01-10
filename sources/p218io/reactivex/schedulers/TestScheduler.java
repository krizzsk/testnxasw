package p218io.reactivex.schedulers;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.disposables.Disposables;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.schedulers.TestScheduler */
public final class TestScheduler extends Scheduler {

    /* renamed from: b */
    final Queue<TimedRunnable> f62179b = new PriorityBlockingQueue(11);

    /* renamed from: c */
    long f62180c;

    /* renamed from: d */
    volatile long f62181d;

    public TestScheduler() {
    }

    public TestScheduler(long j, TimeUnit timeUnit) {
        this.f62181d = timeUnit.toNanos(j);
    }

    /* renamed from: io.reactivex.schedulers.TestScheduler$TimedRunnable */
    static final class TimedRunnable implements Comparable<TimedRunnable> {
        final long count;
        final Runnable run;
        final TestWorker scheduler;
        final long time;

        TimedRunnable(TestWorker testWorker, long j, Runnable runnable, long j2) {
            this.time = j;
            this.run = runnable;
            this.scheduler = testWorker;
            this.count = j2;
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", new Object[]{Long.valueOf(this.time), this.run.toString()});
        }

        public int compareTo(TimedRunnable timedRunnable) {
            long j = this.time;
            long j2 = timedRunnable.time;
            if (j == j2) {
                return ObjectHelper.compare(this.count, timedRunnable.count);
            }
            return ObjectHelper.compare(j, j2);
        }
    }

    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(this.f62181d, TimeUnit.NANOSECONDS);
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.f62181d + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j, TimeUnit timeUnit) {
        m46031a(timeUnit.toNanos(j));
    }

    public void triggerActions() {
        m46031a(this.f62181d);
    }

    /* renamed from: a */
    private void m46031a(long j) {
        while (true) {
            TimedRunnable peek = this.f62179b.peek();
            if (peek == null || peek.time > j) {
                this.f62181d = j;
            } else {
                this.f62181d = peek.time == 0 ? this.f62181d : peek.time;
                this.f62179b.remove(peek);
                if (!peek.scheduler.disposed) {
                    peek.run.run();
                }
            }
        }
        this.f62181d = j;
    }

    public Scheduler.Worker createWorker() {
        return new TestWorker();
    }

    /* renamed from: io.reactivex.schedulers.TestScheduler$TestWorker */
    final class TestWorker extends Scheduler.Worker {
        volatile boolean disposed;

        TestWorker() {
        }

        public void dispose() {
            this.disposed = true;
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            long nanos = TestScheduler.this.f62181d + timeUnit.toNanos(j);
            TestScheduler testScheduler = TestScheduler.this;
            long j2 = testScheduler.f62180c;
            testScheduler.f62180c = 1 + j2;
            TimedRunnable timedRunnable = new TimedRunnable(this, nanos, runnable, j2);
            TestScheduler.this.f62179b.add(timedRunnable);
            return Disposables.fromRunnable(new QueueRemove(timedRunnable));
        }

        public Disposable schedule(Runnable runnable) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j = testScheduler.f62180c;
            testScheduler.f62180c = 1 + j;
            TimedRunnable timedRunnable = new TimedRunnable(this, 0, runnable, j);
            TestScheduler.this.f62179b.add(timedRunnable);
            return Disposables.fromRunnable(new QueueRemove(timedRunnable));
        }

        public long now(TimeUnit timeUnit) {
            return TestScheduler.this.now(timeUnit);
        }

        /* renamed from: io.reactivex.schedulers.TestScheduler$TestWorker$QueueRemove */
        final class QueueRemove implements Runnable {
            final TimedRunnable timedAction;

            QueueRemove(TimedRunnable timedRunnable) {
                this.timedAction = timedRunnable;
            }

            public void run() {
                TestScheduler.this.f62179b.remove(this.timedAction);
            }
        }
    }
}
