package com.didi.nova.assembly.serial;

import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.nova.assembly.ALog;
import com.didi.nova.assembly.serial.Dispatcher;
import java.util.ArrayDeque;
import java.util.Iterator;

public class SerialTaskQueue {

    /* renamed from: a */
    private final ArrayDeque<Work> f31656a = new ArrayDeque<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Work f31657b;

    public enum AppendMode {
        Normal,
        Replace,
        Discard,
        ReplaceStrict,
        DiscardStrict
    }

    static abstract class Work implements Dispatcher.DispatchRunnable {
        volatile boolean cancel;
        volatile boolean finished;

        /* access modifiers changed from: package-private */
        public abstract String getCategory();

        /* access modifiers changed from: package-private */
        public abstract void onCancel();

        Work() {
        }
    }

    public Cancelable append(Task task, AppendMode appendMode) {
        ArrayDeque arrayDeque;
        Work work;
        if (appendMode != AppendMode.Normal) {
            if (appendMode == AppendMode.ReplaceStrict) {
                Work work2 = this.f31657b;
                if (work2 != null && work2.getCategory().equals(task.getCategory())) {
                    this.f31657b.cancel = true;
                    if (!this.f31657b.finished) {
                        this.f31657b.onCancel();
                    }
                }
            } else if (appendMode == AppendMode.DiscardStrict && (work = this.f31657b) != null && work.getCategory().equals(task.getCategory())) {
                m24197a("Cancel " + task + " category: " + task.getCategory() + " mode: " + appendMode);
                task.onCancel();
                return new EmptyCancelable();
            }
            synchronized (this.f31656a) {
                arrayDeque = new ArrayDeque(this.f31656a);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                Work work3 = (Work) it.next();
                if (work3.getCategory().equals(task.getCategory())) {
                    if (appendMode == AppendMode.Replace || appendMode == AppendMode.ReplaceStrict) {
                        m24197a("Cancel " + work3 + " mode: " + appendMode);
                        work3.cancel = true;
                        if (!work3.finished) {
                            work3.onCancel();
                        }
                        m24197a(work3.toString() + " is Replaced.");
                    } else if (appendMode == AppendMode.Discard || appendMode == AppendMode.DiscardStrict) {
                        m24197a("Cancel " + task + " category: " + task.getCategory() + " mode: " + appendMode);
                        task.onCancel();
                        return new EmptyCancelable();
                    }
                }
            }
        }
        final Work a = m24194a(task);
        m24197a("Execute " + a + " mode: " + appendMode + "\n\tmActive: " + this.f31657b);
        return new Cancelable() {
            public void cancel() {
                if (!a.cancel && !a.finished) {
                    a.onCancel();
                }
            }
        };
    }

    public void clear() {
        Iterator<Work> it = this.f31656a.iterator();
        while (it.hasNext()) {
            Work next = it.next();
            if (!next.finished) {
                next.onCancel();
            }
        }
        synchronized (this.f31656a) {
            this.f31656a.clear();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24197a(String str) {
        try {
            ALog.m24113i(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private synchronized Work m24194a(final Task task) {
        C110922 r0;
        r0 = new Work() {
            public void onWorkThread() {
                SerialTaskQueue serialTaskQueue = SerialTaskQueue.this;
                serialTaskQueue.m24197a("onWorkThread " + this);
                if (!this.finished) {
                    if (this.cancel) {
                        onCancel();
                    } else {
                        task.onWorkThread();
                    }
                }
            }

            public void onMainThread() {
                SerialTaskQueue serialTaskQueue = SerialTaskQueue.this;
                serialTaskQueue.m24197a("onMainThread " + this + "\n\tmActive: " + SerialTaskQueue.this.f31657b);
                if (this.finished) {
                    if (SerialTaskQueue.this.f31657b == this) {
                        SerialTaskQueue.this.m24195a();
                    }
                } else if (this.cancel) {
                    onCancel();
                } else {
                    task.onMainThread();
                    this.finished = true;
                    SerialTaskQueue.this.m24195a();
                }
            }

            public void onCancel() {
                SerialTaskQueue serialTaskQueue = SerialTaskQueue.this;
                serialTaskQueue.m24197a("onCancel " + this + "\n\tmActive: " + SerialTaskQueue.this.f31657b);
                task.onCancel();
                this.finished = true;
                if (SerialTaskQueue.this.f31657b == this) {
                    SerialTaskQueue.this.m24195a();
                }
            }

            /* access modifiers changed from: package-private */
            public String getCategory() {
                return task.getCategory();
            }

            public String toString() {
                return task.toString() + " category: " + getCategory() + " cancel: " + this.cancel + " finished: " + this.finished;
            }
        };
        synchronized (this.f31656a) {
            this.f31656a.offer(r0);
        }
        if (this.f31657b == null) {
            m24195a();
        }
        return r0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24195a() {
        Work poll;
        synchronized (this.f31656a) {
            poll = this.f31656a.poll();
            this.f31657b = poll;
        }
        if (poll == null) {
            return;
        }
        if (poll.cancel) {
            if (!this.f31657b.finished) {
                this.f31657b.onCancel();
            }
            m24195a();
            return;
        }
        Dispatcher.async((Dispatcher.DispatchRunnable) this.f31657b);
    }

    static class EmptyCancelable implements Cancelable {
        public void cancel() {
        }

        EmptyCancelable() {
        }
    }
}
