package p218io.reactivex.subjects;

import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p218io.reactivex.Observer;
import p218io.reactivex.annotations.CheckReturnValue;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import p218io.reactivex.internal.util.ExceptionHelper;
import p218io.reactivex.internal.util.NotificationLite;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.subjects.BehaviorSubject */
public final class BehaviorSubject<T> extends Subject<T> {

    /* renamed from: c */
    static final BehaviorDisposable[] f62190c = new BehaviorDisposable[0];

    /* renamed from: d */
    static final BehaviorDisposable[] f62191d = new BehaviorDisposable[0];

    /* renamed from: j */
    private static final Object[] f62192j = new Object[0];

    /* renamed from: a */
    final AtomicReference<Object> f62193a;

    /* renamed from: b */
    final AtomicReference<BehaviorDisposable<T>[]> f62194b;

    /* renamed from: e */
    final ReadWriteLock f62195e;

    /* renamed from: f */
    final Lock f62196f;

    /* renamed from: g */
    final Lock f62197g;

    /* renamed from: h */
    final AtomicReference<Throwable> f62198h;

    /* renamed from: i */
    long f62199i;

    @CheckReturnValue
    public static <T> BehaviorSubject<T> create() {
        return new BehaviorSubject<>();
    }

    @CheckReturnValue
    public static <T> BehaviorSubject<T> createDefault(T t) {
        return new BehaviorSubject<>(t);
    }

    BehaviorSubject() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f62195e = reentrantReadWriteLock;
        this.f62196f = reentrantReadWriteLock.readLock();
        this.f62197g = this.f62195e.writeLock();
        this.f62194b = new AtomicReference<>(f62190c);
        this.f62193a = new AtomicReference<>();
        this.f62198h = new AtomicReference<>();
    }

    BehaviorSubject(T t) {
        this();
        this.f62193a.lazySet(ObjectHelper.requireNonNull(t, "defaultValue is null"));
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        BehaviorDisposable behaviorDisposable = new BehaviorDisposable(observer, this);
        observer.onSubscribe(behaviorDisposable);
        if (!mo185325a(behaviorDisposable)) {
            Throwable th = this.f62198h.get();
            if (th == ExceptionHelper.TERMINATED) {
                observer.onComplete();
            } else {
                observer.onError(th);
            }
        } else if (behaviorDisposable.cancelled) {
            mo185327b(behaviorDisposable);
        } else {
            behaviorDisposable.emitFirst();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f62198h.get() != null) {
            disposable.dispose();
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f62198h.get() == null) {
            Object next = NotificationLite.next(t);
            mo185328b(next);
            for (BehaviorDisposable emitNext : (BehaviorDisposable[]) this.f62194b.get()) {
                emitNext.emitNext(next, this.f62199i);
            }
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f62198h.compareAndSet((Object) null, th)) {
            RxJavaPlugins.onError(th);
            return;
        }
        Object error = NotificationLite.error(th);
        for (BehaviorDisposable emitNext : mo185326a(error)) {
            emitNext.emitNext(error, this.f62199i);
        }
    }

    public void onComplete() {
        if (this.f62198h.compareAndSet((Object) null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            for (BehaviorDisposable emitNext : mo185326a(complete)) {
                emitNext.emitNext(complete, this.f62199i);
            }
        }
    }

    public boolean hasObservers() {
        return ((BehaviorDisposable[]) this.f62194b.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo185324a() {
        return ((BehaviorDisposable[]) this.f62194b.get()).length;
    }

    public Throwable getThrowable() {
        Object obj = this.f62193a.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public T getValue() {
        Object obj = this.f62193a.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return NotificationLite.getValue(obj);
    }

    @Deprecated
    public Object[] getValues() {
        Object[] values = getValues(f62192j);
        return values == f62192j ? new Object[0] : values;
    }

    @Deprecated
    public T[] getValues(T[] tArr) {
        Object obj = this.f62193a.get();
        if (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        T value = NotificationLite.getValue(obj);
        if (tArr.length != 0) {
            tArr[0] = value;
            if (tArr.length == 1) {
                return tArr;
            }
            tArr[1] = null;
            return tArr;
        }
        T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1);
        tArr2[0] = value;
        return tArr2;
    }

    public boolean hasComplete() {
        return NotificationLite.isComplete(this.f62193a.get());
    }

    public boolean hasThrowable() {
        return NotificationLite.isError(this.f62193a.get());
    }

    public boolean hasValue() {
        Object obj = this.f62193a.get();
        return obj != null && !NotificationLite.isComplete(obj) && !NotificationLite.isError(obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo185325a(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.f62194b.get();
            if (behaviorDisposableArr == f62191d) {
                return false;
            }
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new BehaviorDisposable[(length + 1)];
            System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!this.f62194b.compareAndSet(behaviorDisposableArr, behaviorDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185327b(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.f62194b.get();
            int length = behaviorDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (behaviorDisposableArr[i2] == behaviorDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        behaviorDisposableArr2 = f62190c;
                    } else {
                        BehaviorDisposable[] behaviorDisposableArr3 = new BehaviorDisposable[(length - 1)];
                        System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i);
                        System.arraycopy(behaviorDisposableArr, i + 1, behaviorDisposableArr3, i, (length - i) - 1);
                        behaviorDisposableArr2 = behaviorDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f62194b.compareAndSet(behaviorDisposableArr, behaviorDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public BehaviorDisposable<T>[] mo185326a(Object obj) {
        BehaviorDisposable<T>[] behaviorDisposableArr = (BehaviorDisposable[]) this.f62194b.getAndSet(f62191d);
        if (behaviorDisposableArr != f62191d) {
            mo185328b(obj);
        }
        return behaviorDisposableArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo185328b(Object obj) {
        this.f62197g.lock();
        this.f62199i++;
        this.f62193a.lazySet(obj);
        this.f62197g.unlock();
    }

    /* renamed from: io.reactivex.subjects.BehaviorSubject$BehaviorDisposable */
    static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        volatile boolean cancelled;
        final Observer<? super T> downstream;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        AppendOnlyLinkedArrayList<Object> queue;
        final BehaviorSubject<T> state;

        BehaviorDisposable(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
            this.downstream = observer;
            this.state = behaviorSubject;
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.mo185327b(this);
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            if (test(r0) == false) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
            emitLoop();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitFirst() {
            /*
                r4 = this;
                boolean r0 = r4.cancelled
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.cancelled     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x000c:
                boolean r0 = r4.next     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x0012:
                io.reactivex.subjects.BehaviorSubject<T> r0 = r4.state     // Catch:{ all -> 0x003e }
                java.util.concurrent.locks.Lock r1 = r0.f62196f     // Catch:{ all -> 0x003e }
                r1.lock()     // Catch:{ all -> 0x003e }
                long r2 = r0.f62199i     // Catch:{ all -> 0x003e }
                r4.index = r2     // Catch:{ all -> 0x003e }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r0.f62193a     // Catch:{ all -> 0x003e }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x003e }
                r1.unlock()     // Catch:{ all -> 0x003e }
                r1 = 1
                if (r0 == 0) goto L_0x002b
                r2 = 1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                r4.emitting = r2     // Catch:{ all -> 0x003e }
                r4.next = r1     // Catch:{ all -> 0x003e }
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x003d
                boolean r0 = r4.test(r0)
                if (r0 == 0) goto L_0x003a
                return
            L_0x003a:
                r4.emitLoop()
            L_0x003d:
                return
            L_0x003e:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p218io.reactivex.subjects.BehaviorSubject.BehaviorDisposable.emitFirst():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r3.fastPath = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitNext(java.lang.Object r4, long r5) {
            /*
                r3 = this;
                boolean r0 = r3.cancelled
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r3.fastPath
                if (r0 != 0) goto L_0x0037
                monitor-enter(r3)
                boolean r0 = r3.cancelled     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0010
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return
            L_0x0010:
                long r0 = r3.index     // Catch:{ all -> 0x0034 }
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 != 0) goto L_0x0018
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return
            L_0x0018:
                boolean r5 = r3.emitting     // Catch:{ all -> 0x0034 }
                if (r5 == 0) goto L_0x002d
                io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r5 = r3.queue     // Catch:{ all -> 0x0034 }
                if (r5 != 0) goto L_0x0028
                io.reactivex.internal.util.AppendOnlyLinkedArrayList r5 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0034 }
                r6 = 4
                r5.<init>(r6)     // Catch:{ all -> 0x0034 }
                r3.queue = r5     // Catch:{ all -> 0x0034 }
            L_0x0028:
                r5.add(r4)     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return
            L_0x002d:
                r5 = 1
                r3.next = r5     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                r3.fastPath = r5
                goto L_0x0037
            L_0x0034:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                throw r4
            L_0x0037:
                r3.test(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p218io.reactivex.subjects.BehaviorSubject.BehaviorDisposable.emitNext(java.lang.Object, long):void");
        }

        public boolean test(Object obj) {
            return this.cancelled || NotificationLite.accept(obj, this.downstream);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r0.forEachWhile(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitLoop() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.cancelled
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.queue     // Catch:{ all -> 0x0017 }
                if (r0 != 0) goto L_0x000f
                r0 = 0
                r2.emitting = r0     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                return
            L_0x000f:
                r1 = 0
                r2.queue = r1     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                r0.forEachWhile(r2)
                goto L_0x0000
            L_0x0017:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p218io.reactivex.subjects.BehaviorSubject.BehaviorDisposable.emitLoop():void");
        }
    }
}
