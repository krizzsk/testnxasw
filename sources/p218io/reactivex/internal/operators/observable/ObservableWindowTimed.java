package p218io.reactivex.internal.operators.observable;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.Observable;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.Observer;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.observers.QueueDrainObserver;
import p218io.reactivex.internal.queue.MpscLinkedQueue;
import p218io.reactivex.internal.util.NotificationLite;
import p218io.reactivex.observers.SerializedObserver;
import p218io.reactivex.subjects.UnicastSubject;

/* renamed from: io.reactivex.internal.operators.observable.ObservableWindowTimed */
public final class ObservableWindowTimed<T> extends C22215a<T, Observable<T>> {

    /* renamed from: a */
    final long f61774a;

    /* renamed from: b */
    final long f61775b;

    /* renamed from: c */
    final TimeUnit f61776c;

    /* renamed from: d */
    final Scheduler f61777d;

    /* renamed from: e */
    final long f61778e;

    /* renamed from: f */
    final int f61779f;

    /* renamed from: g */
    final boolean f61780g;

    public ObservableWindowTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(observableSource);
        this.f61774a = j;
        this.f61775b = j2;
        this.f61776c = timeUnit;
        this.f61777d = scheduler;
        this.f61778e = j3;
        this.f61779f = i;
        this.f61780g = z;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.f61774a != this.f61775b) {
            this.source.subscribe(new WindowSkipObserver(serializedObserver, this.f61774a, this.f61775b, this.f61776c, this.f61777d.createWorker(), this.f61779f));
        } else if (this.f61778e == Long.MAX_VALUE) {
            this.source.subscribe(new WindowExactUnboundedObserver(serializedObserver, this.f61774a, this.f61776c, this.f61777d, this.f61779f));
        } else {
            this.source.subscribe(new WindowExactBoundedObserver(serializedObserver, this.f61774a, this.f61776c, this.f61777d, this.f61779f, this.f61778e, this.f61780g));
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowExactUnboundedObserver */
    static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Observer<T>, Disposable, Runnable {
        static final Object NEXT = new Object();
        final int bufferSize;
        final Scheduler scheduler;
        volatile boolean terminated;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final long timespan;
        final TimeUnit unit;
        Disposable upstream;
        UnicastSubject<T> window;

        WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler2, int i) {
            super(observer, new MpscLinkedQueue());
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.bufferSize = i;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.window = UnicastSubject.create(this.bufferSize);
                Observer observer = this.downstream;
                observer.onSubscribe(this);
                observer.onNext(this.window);
                if (!this.cancelled) {
                    Scheduler scheduler2 = this.scheduler;
                    long j = this.timespan;
                    DisposableHelper.replace(this.timer, scheduler2.schedulePeriodicallyDirect(this, j, j, this.unit));
                }
            }
        }

        public void onNext(T t) {
            if (!this.terminated) {
                if (fastEnter()) {
                    this.window.onNext(t);
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.queue.offer(NotificationLite.next(t));
                    if (!enter()) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            disposeTimer();
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            disposeTimer();
            this.downstream.onComplete();
        }

        public void dispose() {
            this.cancelled = true;
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void disposeTimer() {
            DisposableHelper.dispose(this.timer);
        }

        public void run() {
            if (this.cancelled) {
                this.terminated = true;
                disposeTimer();
            }
            this.queue.offer(NEXT);
            if (enter()) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        public void drainLoop() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer observer = this.downstream;
            UnicastSubject<T> unicastSubject = this.window;
            int i = 1;
            while (true) {
                boolean z = this.terminated;
                boolean z2 = this.done;
                Object poll = mpscLinkedQueue.poll();
                if (!z2 || !(poll == null || poll == NEXT)) {
                    if (poll == null) {
                        i = leave(-i);
                        if (i == 0) {
                            return;
                        }
                    } else if (poll == NEXT) {
                        unicastSubject.onComplete();
                        if (!z) {
                            unicastSubject = UnicastSubject.create(this.bufferSize);
                            this.window = unicastSubject;
                            observer.onNext(unicastSubject);
                        } else {
                            this.upstream.dispose();
                        }
                    } else {
                        unicastSubject.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
            this.window = null;
            mpscLinkedQueue.clear();
            disposeTimer();
            Throwable th = this.error;
            if (th != null) {
                unicastSubject.onError(th);
            } else {
                unicastSubject.onComplete();
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowExactBoundedObserver */
    static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        final int bufferSize;
        long count;
        final long maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        final Scheduler scheduler;
        volatile boolean terminated;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final long timespan;
        final TimeUnit unit;
        Disposable upstream;
        UnicastSubject<T> window;
        final Scheduler.Worker worker;

        WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler2, int i, long j2, boolean z) {
            super(observer, new MpscLinkedQueue());
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.bufferSize = i;
            this.maxSize = j2;
            this.restartTimerOnMaxSize = z;
            if (z) {
                this.worker = scheduler2.createWorker();
            } else {
                this.worker = null;
            }
        }

        public void onSubscribe(Disposable disposable) {
            Disposable disposable2;
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                Observer observer = this.downstream;
                observer.onSubscribe(this);
                if (!this.cancelled) {
                    UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                    this.window = create;
                    observer.onNext(create);
                    ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                    if (this.restartTimerOnMaxSize) {
                        Scheduler.Worker worker2 = this.worker;
                        long j = this.timespan;
                        disposable2 = worker2.schedulePeriodically(consumerIndexHolder, j, j, this.unit);
                    } else {
                        Scheduler scheduler2 = this.scheduler;
                        long j2 = this.timespan;
                        disposable2 = scheduler2.schedulePeriodicallyDirect(consumerIndexHolder, j2, j2, this.unit);
                    }
                    DisposableHelper.replace(this.timer, disposable2);
                }
            }
        }

        public void onNext(T t) {
            if (!this.terminated) {
                if (fastEnter()) {
                    UnicastSubject<T> unicastSubject = this.window;
                    unicastSubject.onNext(t);
                    long j = this.count + 1;
                    if (j >= this.maxSize) {
                        this.producerIndex++;
                        this.count = 0;
                        unicastSubject.onComplete();
                        UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                        this.window = create;
                        this.downstream.onNext(create);
                        if (this.restartTimerOnMaxSize) {
                            this.timer.get().dispose();
                            Scheduler.Worker worker2 = this.worker;
                            ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                            long j2 = this.timespan;
                            DisposableHelper.replace(this.timer, worker2.schedulePeriodically(consumerIndexHolder, j2, j2, this.unit));
                        }
                    } else {
                        this.count = j;
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.queue.offer(NotificationLite.next(t));
                    if (!enter()) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.downstream.onError(th);
            disposeTimer();
        }

        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.downstream.onComplete();
            disposeTimer();
        }

        public void dispose() {
            this.cancelled = true;
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void disposeTimer() {
            DisposableHelper.dispose(this.timer);
            Scheduler.Worker worker2 = this.worker;
            if (worker2 != null) {
                worker2.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void drainLoop() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer observer = this.downstream;
            UnicastSubject<T> unicastSubject = this.window;
            int i = 1;
            while (!this.terminated) {
                boolean z = this.done;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof ConsumerIndexHolder;
                if (z && (z2 || z3)) {
                    this.window = null;
                    mpscLinkedQueue.clear();
                    disposeTimer();
                    Throwable th = this.error;
                    if (th != null) {
                        unicastSubject.onError(th);
                        return;
                    } else {
                        unicastSubject.onComplete();
                        return;
                    }
                } else if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                    if (this.restartTimerOnMaxSize || this.producerIndex == consumerIndexHolder.index) {
                        unicastSubject.onComplete();
                        this.count = 0;
                        unicastSubject = UnicastSubject.create(this.bufferSize);
                        this.window = unicastSubject;
                        observer.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.getValue(poll));
                    long j = this.count + 1;
                    if (j >= this.maxSize) {
                        this.producerIndex++;
                        this.count = 0;
                        unicastSubject.onComplete();
                        unicastSubject = UnicastSubject.create(this.bufferSize);
                        this.window = unicastSubject;
                        this.downstream.onNext(unicastSubject);
                        if (this.restartTimerOnMaxSize) {
                            Disposable disposable = this.timer.get();
                            disposable.dispose();
                            Scheduler.Worker worker2 = this.worker;
                            ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.producerIndex, this);
                            long j2 = this.timespan;
                            Disposable schedulePeriodically = worker2.schedulePeriodically(consumerIndexHolder2, j2, j2, this.unit);
                            if (!this.timer.compareAndSet(disposable, schedulePeriodically)) {
                                schedulePeriodically.dispose();
                            }
                        }
                    } else {
                        this.count = j;
                    }
                }
            }
            this.upstream.dispose();
            mpscLinkedQueue.clear();
            disposeTimer();
        }

        /* renamed from: io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowExactBoundedObserver$ConsumerIndexHolder */
        static final class ConsumerIndexHolder implements Runnable {
            final long index;
            final WindowExactBoundedObserver<?> parent;

            ConsumerIndexHolder(long j, WindowExactBoundedObserver<?> windowExactBoundedObserver) {
                this.index = j;
                this.parent = windowExactBoundedObserver;
            }

            public void run() {
                WindowExactBoundedObserver<?> windowExactBoundedObserver = this.parent;
                if (!windowExactBoundedObserver.cancelled) {
                    windowExactBoundedObserver.queue.offer(this);
                } else {
                    windowExactBoundedObserver.terminated = true;
                    windowExactBoundedObserver.disposeTimer();
                }
                if (windowExactBoundedObserver.enter()) {
                    windowExactBoundedObserver.drainLoop();
                }
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowSkipObserver */
    static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {
        final int bufferSize;
        volatile boolean terminated;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        Disposable upstream;
        final List<UnicastSubject<T>> windows = new LinkedList();
        final Scheduler.Worker worker;

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker2, int i) {
            super(observer, new MpscLinkedQueue());
            this.timespan = j;
            this.timeskip = j2;
            this.unit = timeUnit;
            this.worker = worker2;
            this.bufferSize = i;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                if (!this.cancelled) {
                    UnicastSubject create = UnicastSubject.create(this.bufferSize);
                    this.windows.add(create);
                    this.downstream.onNext(create);
                    this.worker.schedule(new CompletionTask(create), this.timespan, this.unit);
                    Scheduler.Worker worker2 = this.worker;
                    long j = this.timeskip;
                    worker2.schedulePeriodically(this, j, j, this.unit);
                }
            }
        }

        public void onNext(T t) {
            if (fastEnter()) {
                for (UnicastSubject<T> onNext : this.windows) {
                    onNext.onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t);
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.downstream.onError(th);
            disposeWorker();
        }

        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.downstream.onComplete();
            disposeWorker();
        }

        public void dispose() {
            this.cancelled = true;
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void disposeWorker() {
            this.worker.dispose();
        }

        /* access modifiers changed from: package-private */
        public void complete(UnicastSubject<T> unicastSubject) {
            this.queue.offer(new SubjectWork(unicastSubject, false));
            if (enter()) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        public void drainLoop() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer observer = this.downstream;
            List<UnicastSubject<T>> list = this.windows;
            int i = 1;
            while (!this.terminated) {
                boolean z = this.done;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof SubjectWork;
                if (z && (z2 || z3)) {
                    mpscLinkedQueue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        for (UnicastSubject<T> onError : list) {
                            onError.onError(th);
                        }
                    } else {
                        for (UnicastSubject<T> onComplete : list) {
                            onComplete.onComplete();
                        }
                    }
                    disposeWorker();
                    list.clear();
                    return;
                } else if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    SubjectWork subjectWork = (SubjectWork) poll;
                    if (!subjectWork.open) {
                        list.remove(subjectWork.f61782w);
                        subjectWork.f61782w.onComplete();
                        if (list.isEmpty() && this.cancelled) {
                            this.terminated = true;
                        }
                    } else if (!this.cancelled) {
                        UnicastSubject create = UnicastSubject.create(this.bufferSize);
                        list.add(create);
                        observer.onNext(create);
                        this.worker.schedule(new CompletionTask(create), this.timespan, this.unit);
                    }
                } else {
                    for (UnicastSubject<T> onNext : list) {
                        onNext.onNext(poll);
                    }
                }
            }
            this.upstream.dispose();
            disposeWorker();
            mpscLinkedQueue.clear();
            list.clear();
        }

        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastSubject.create(this.bufferSize), true);
            if (!this.cancelled) {
                this.queue.offer(subjectWork);
            }
            if (enter()) {
                drainLoop();
            }
        }

        /* renamed from: io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowSkipObserver$SubjectWork */
        static final class SubjectWork<T> {
            final boolean open;

            /* renamed from: w */
            final UnicastSubject<T> f61782w;

            SubjectWork(UnicastSubject<T> unicastSubject, boolean z) {
                this.f61782w = unicastSubject;
                this.open = z;
            }
        }

        /* renamed from: io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowSkipObserver$CompletionTask */
        final class CompletionTask implements Runnable {

            /* renamed from: w */
            private final UnicastSubject<T> f61781w;

            CompletionTask(UnicastSubject<T> unicastSubject) {
                this.f61781w = unicastSubject;
            }

            public void run() {
                WindowSkipObserver.this.complete(this.f61781w);
            }
        }
    }
}
