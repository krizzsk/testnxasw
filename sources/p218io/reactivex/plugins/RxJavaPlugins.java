package p218io.reactivex.plugins;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import org.reactivestreams.Subscriber;
import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.Flowable;
import p218io.reactivex.Maybe;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.Scheduler;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.exceptions.CompositeException;
import p218io.reactivex.exceptions.MissingBackpressureException;
import p218io.reactivex.exceptions.OnErrorNotImplementedException;
import p218io.reactivex.exceptions.UndeliverableException;
import p218io.reactivex.flowables.ConnectableFlowable;
import p218io.reactivex.functions.BiFunction;
import p218io.reactivex.functions.BooleanSupplier;
import p218io.reactivex.functions.Consumer;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.schedulers.ComputationScheduler;
import p218io.reactivex.internal.schedulers.IoScheduler;
import p218io.reactivex.internal.schedulers.NewThreadScheduler;
import p218io.reactivex.internal.schedulers.SingleScheduler;
import p218io.reactivex.internal.util.ExceptionHelper;
import p218io.reactivex.observables.ConnectableObservable;
import p218io.reactivex.parallel.ParallelFlowable;

/* renamed from: io.reactivex.plugins.RxJavaPlugins */
public final class RxJavaPlugins {

    /* renamed from: a */
    static volatile Consumer<? super Throwable> f62094a;

    /* renamed from: b */
    static volatile Function<? super Runnable, ? extends Runnable> f62095b;

    /* renamed from: c */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f62096c;

    /* renamed from: d */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f62097d;

    /* renamed from: e */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f62098e;

    /* renamed from: f */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f62099f;

    /* renamed from: g */
    static volatile Function<? super Scheduler, ? extends Scheduler> f62100g;

    /* renamed from: h */
    static volatile Function<? super Scheduler, ? extends Scheduler> f62101h;

    /* renamed from: i */
    static volatile Function<? super Scheduler, ? extends Scheduler> f62102i;

    /* renamed from: j */
    static volatile Function<? super Scheduler, ? extends Scheduler> f62103j;

    /* renamed from: k */
    static volatile Function<? super Flowable, ? extends Flowable> f62104k;

    /* renamed from: l */
    static volatile Function<? super ConnectableFlowable, ? extends ConnectableFlowable> f62105l;

    /* renamed from: m */
    static volatile Function<? super Observable, ? extends Observable> f62106m;

    /* renamed from: n */
    static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> f62107n;

    /* renamed from: o */
    static volatile Function<? super Maybe, ? extends Maybe> f62108o;

    /* renamed from: p */
    static volatile Function<? super Single, ? extends Single> f62109p;

    /* renamed from: q */
    static volatile Function<? super Completable, ? extends Completable> f62110q;

    /* renamed from: r */
    static volatile Function<? super ParallelFlowable, ? extends ParallelFlowable> f62111r;

    /* renamed from: s */
    static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> f62112s;

    /* renamed from: t */
    static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> f62113t;

    /* renamed from: u */
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> f62114u;

    /* renamed from: v */
    static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> f62115v;

    /* renamed from: w */
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> f62116w;

    /* renamed from: x */
    static volatile BooleanSupplier f62117x;

    /* renamed from: y */
    static volatile boolean f62118y;

    /* renamed from: z */
    static volatile boolean f62119z;

    public static void lockdown() {
        f62118y = true;
    }

    public static boolean isLockdown() {
        return f62118y;
    }

    public static void setFailOnNonBlockingScheduler(boolean z) {
        if (!f62118y) {
            f62119z = z;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static boolean isFailOnNonBlockingScheduler() {
        return f62119z;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getComputationSchedulerHandler() {
        return f62100g;
    }

    public static Consumer<? super Throwable> getErrorHandler() {
        return f62094a;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitComputationSchedulerHandler() {
        return f62096c;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitIoSchedulerHandler() {
        return f62098e;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitNewThreadSchedulerHandler() {
        return f62099f;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitSingleSchedulerHandler() {
        return f62097d;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getIoSchedulerHandler() {
        return f62102i;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getNewThreadSchedulerHandler() {
        return f62103j;
    }

    public static Function<? super Runnable, ? extends Runnable> getScheduleHandler() {
        return f62095b;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getSingleSchedulerHandler() {
        return f62101h;
    }

    public static Scheduler initComputationScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f62096c;
        if (function == null) {
            return m46001a(callable);
        }
        return m46000a(function, callable);
    }

    public static Scheduler initIoScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f62098e;
        if (function == null) {
            return m46001a(callable);
        }
        return m46000a(function, callable);
    }

    public static Scheduler initNewThreadScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f62099f;
        if (function == null) {
            return m46001a(callable);
        }
        return m46000a(function, callable);
    }

    public static Scheduler initSingleScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f62097d;
        if (function == null) {
            return m46001a(callable);
        }
        return m46000a(function, callable);
    }

    public static Scheduler onComputationScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f62100g;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m46003a(function, scheduler);
    }

    public static void onError(Throwable th) {
        Consumer<? super Throwable> consumer = f62094a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!m46005a(th)) {
            th = new UndeliverableException(th);
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                m46006b(th2);
            }
        }
        th.printStackTrace();
        m46006b(th);
    }

    /* renamed from: a */
    static boolean m46005a(Throwable th) {
        if (!(th instanceof OnErrorNotImplementedException) && !(th instanceof MissingBackpressureException) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof CompositeException)) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    static void m46006b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static Scheduler onIoScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f62102i;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m46003a(function, scheduler);
    }

    public static Scheduler onNewThreadScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f62103j;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m46003a(function, scheduler);
    }

    public static Runnable onSchedule(Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "run is null");
        Function<? super Runnable, ? extends Runnable> function = f62095b;
        if (function == null) {
            return runnable;
        }
        return (Runnable) m46003a(function, runnable);
    }

    public static Scheduler onSingleScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f62101h;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m46003a(function, scheduler);
    }

    public static void reset() {
        setErrorHandler((Consumer<? super Throwable>) null);
        setScheduleHandler((Function<? super Runnable, ? extends Runnable>) null);
        setComputationSchedulerHandler((Function<? super Scheduler, ? extends Scheduler>) null);
        setInitComputationSchedulerHandler((Function<? super Callable<Scheduler>, ? extends Scheduler>) null);
        setIoSchedulerHandler((Function<? super Scheduler, ? extends Scheduler>) null);
        setInitIoSchedulerHandler((Function<? super Callable<Scheduler>, ? extends Scheduler>) null);
        setSingleSchedulerHandler((Function<? super Scheduler, ? extends Scheduler>) null);
        setInitSingleSchedulerHandler((Function<? super Callable<Scheduler>, ? extends Scheduler>) null);
        setNewThreadSchedulerHandler((Function<? super Scheduler, ? extends Scheduler>) null);
        setInitNewThreadSchedulerHandler((Function<? super Callable<Scheduler>, ? extends Scheduler>) null);
        setOnFlowableAssembly((Function<? super Flowable, ? extends Flowable>) null);
        setOnFlowableSubscribe((BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber>) null);
        setOnObservableAssembly((Function<? super Observable, ? extends Observable>) null);
        setOnObservableSubscribe((BiFunction<? super Observable, ? super Observer, ? extends Observer>) null);
        setOnSingleAssembly((Function<? super Single, ? extends Single>) null);
        setOnSingleSubscribe((BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver>) null);
        setOnCompletableAssembly((Function<? super Completable, ? extends Completable>) null);
        setOnCompletableSubscribe((BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver>) null);
        setOnConnectableFlowableAssembly((Function<? super ConnectableFlowable, ? extends ConnectableFlowable>) null);
        setOnConnectableObservableAssembly((Function<? super ConnectableObservable, ? extends ConnectableObservable>) null);
        setOnMaybeAssembly((Function<? super Maybe, ? extends Maybe>) null);
        setOnMaybeSubscribe((BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver>) null);
        setOnParallelAssembly((Function<? super ParallelFlowable, ? extends ParallelFlowable>) null);
        setFailOnNonBlockingScheduler(false);
        setOnBeforeBlocking((BooleanSupplier) null);
    }

    public static void setComputationSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f62118y) {
            f62100g = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setErrorHandler(Consumer<? super Throwable> consumer) {
        if (!f62118y) {
            f62094a = consumer;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitComputationSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        if (!f62118y) {
            f62096c = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitIoSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        if (!f62118y) {
            f62098e = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitNewThreadSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        if (!f62118y) {
            f62099f = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitSingleSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        if (!f62118y) {
            f62097d = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setIoSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f62118y) {
            f62102i = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setNewThreadSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f62118y) {
            f62103j = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setScheduleHandler(Function<? super Runnable, ? extends Runnable> function) {
        if (!f62118y) {
            f62095b = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setSingleSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f62118y) {
            f62101h = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    /* renamed from: a */
    static void m46004a() {
        f62118y = false;
    }

    public static Function<? super Completable, ? extends Completable> getOnCompletableAssembly() {
        return f62110q;
    }

    public static BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> getOnCompletableSubscribe() {
        return f62116w;
    }

    public static Function<? super Flowable, ? extends Flowable> getOnFlowableAssembly() {
        return f62104k;
    }

    public static Function<? super ConnectableFlowable, ? extends ConnectableFlowable> getOnConnectableFlowableAssembly() {
        return f62105l;
    }

    public static BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> getOnFlowableSubscribe() {
        return f62112s;
    }

    public static BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> getOnMaybeSubscribe() {
        return f62113t;
    }

    public static Function<? super Maybe, ? extends Maybe> getOnMaybeAssembly() {
        return f62108o;
    }

    public static Function<? super Single, ? extends Single> getOnSingleAssembly() {
        return f62109p;
    }

    public static BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> getOnSingleSubscribe() {
        return f62115v;
    }

    public static Function<? super Observable, ? extends Observable> getOnObservableAssembly() {
        return f62106m;
    }

    public static Function<? super ConnectableObservable, ? extends ConnectableObservable> getOnConnectableObservableAssembly() {
        return f62107n;
    }

    public static BiFunction<? super Observable, ? super Observer, ? extends Observer> getOnObservableSubscribe() {
        return f62114u;
    }

    public static void setOnCompletableAssembly(Function<? super Completable, ? extends Completable> function) {
        if (!f62118y) {
            f62110q = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnCompletableSubscribe(BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction) {
        if (!f62118y) {
            f62116w = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableAssembly(Function<? super Flowable, ? extends Flowable> function) {
        if (!f62118y) {
            f62104k = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeAssembly(Function<? super Maybe, ? extends Maybe> function) {
        if (!f62118y) {
            f62108o = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableFlowableAssembly(Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function) {
        if (!f62118y) {
            f62105l = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableSubscribe(BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction) {
        if (!f62118y) {
            f62112s = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeSubscribe(BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver> biFunction) {
        if (!f62118y) {
            f62113t = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableAssembly(Function<? super Observable, ? extends Observable> function) {
        if (!f62118y) {
            f62106m = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableObservableAssembly(Function<? super ConnectableObservable, ? extends ConnectableObservable> function) {
        if (!f62118y) {
            f62107n = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableSubscribe(BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction) {
        if (!f62118y) {
            f62114u = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleAssembly(Function<? super Single, ? extends Single> function) {
        if (!f62118y) {
            f62109p = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleSubscribe(BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction) {
        if (!f62118y) {
            f62115v = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static <T> Subscriber<? super T> onSubscribe(Flowable<T> flowable, Subscriber<? super T> subscriber) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction = f62112s;
        return biFunction != null ? (Subscriber) m46002a(biFunction, flowable, subscriber) : subscriber;
    }

    public static <T> Observer<? super T> onSubscribe(Observable<T> observable, Observer<? super T> observer) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction = f62114u;
        return biFunction != null ? (Observer) m46002a(biFunction, observable, observer) : observer;
    }

    public static <T> SingleObserver<? super T> onSubscribe(Single<T> single, SingleObserver<? super T> singleObserver) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction = f62115v;
        return biFunction != null ? (SingleObserver) m46002a(biFunction, single, singleObserver) : singleObserver;
    }

    public static CompletableObserver onSubscribe(Completable completable, CompletableObserver completableObserver) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = f62116w;
        return biFunction != null ? (CompletableObserver) m46002a(biFunction, completable, completableObserver) : completableObserver;
    }

    public static <T> MaybeObserver<? super T> onSubscribe(Maybe<T> maybe, MaybeObserver<? super T> maybeObserver) {
        BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> biFunction = f62113t;
        return biFunction != null ? (MaybeObserver) m46002a(biFunction, maybe, maybeObserver) : maybeObserver;
    }

    public static <T> Maybe<T> onAssembly(Maybe<T> maybe) {
        Function<? super Maybe, ? extends Maybe> function = f62108o;
        return function != null ? (Maybe) m46003a(function, maybe) : maybe;
    }

    public static <T> Flowable<T> onAssembly(Flowable<T> flowable) {
        Function<? super Flowable, ? extends Flowable> function = f62104k;
        return function != null ? (Flowable) m46003a(function, flowable) : flowable;
    }

    public static <T> ConnectableFlowable<T> onAssembly(ConnectableFlowable<T> connectableFlowable) {
        Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function = f62105l;
        return function != null ? (ConnectableFlowable) m46003a(function, connectableFlowable) : connectableFlowable;
    }

    public static <T> Observable<T> onAssembly(Observable<T> observable) {
        Function<? super Observable, ? extends Observable> function = f62106m;
        return function != null ? (Observable) m46003a(function, observable) : observable;
    }

    public static <T> ConnectableObservable<T> onAssembly(ConnectableObservable<T> connectableObservable) {
        Function<? super ConnectableObservable, ? extends ConnectableObservable> function = f62107n;
        return function != null ? (ConnectableObservable) m46003a(function, connectableObservable) : connectableObservable;
    }

    public static <T> Single<T> onAssembly(Single<T> single) {
        Function<? super Single, ? extends Single> function = f62109p;
        return function != null ? (Single) m46003a(function, single) : single;
    }

    public static Completable onAssembly(Completable completable) {
        Function<? super Completable, ? extends Completable> function = f62110q;
        return function != null ? (Completable) m46003a(function, completable) : completable;
    }

    public static void setOnParallelAssembly(Function<? super ParallelFlowable, ? extends ParallelFlowable> function) {
        if (!f62118y) {
            f62111r = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static Function<? super ParallelFlowable, ? extends ParallelFlowable> getOnParallelAssembly() {
        return f62111r;
    }

    public static <T> ParallelFlowable<T> onAssembly(ParallelFlowable<T> parallelFlowable) {
        Function<? super ParallelFlowable, ? extends ParallelFlowable> function = f62111r;
        return function != null ? (ParallelFlowable) m46003a(function, parallelFlowable) : parallelFlowable;
    }

    public static boolean onBeforeBlocking() {
        BooleanSupplier booleanSupplier = f62117x;
        if (booleanSupplier == null) {
            return false;
        }
        try {
            return booleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static void setOnBeforeBlocking(BooleanSupplier booleanSupplier) {
        if (!f62118y) {
            f62117x = booleanSupplier;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static BooleanSupplier getOnBeforeBlocking() {
        return f62117x;
    }

    public static Scheduler createComputationScheduler(ThreadFactory threadFactory) {
        return new ComputationScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
    }

    public static Scheduler createIoScheduler(ThreadFactory threadFactory) {
        return new IoScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
    }

    public static Scheduler createNewThreadScheduler(ThreadFactory threadFactory) {
        return new NewThreadScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
    }

    public static Scheduler createSingleScheduler(ThreadFactory threadFactory) {
        return new SingleScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
    }

    /* renamed from: a */
    static <T, R> R m46003a(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    /* renamed from: a */
    static <T, U, R> R m46002a(BiFunction<T, U, R> biFunction, T t, U u) {
        try {
            return biFunction.apply(t, u);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    /* renamed from: a */
    static Scheduler m46001a(Callable<Scheduler> callable) {
        try {
            return (Scheduler) ObjectHelper.requireNonNull(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    /* renamed from: a */
    static Scheduler m46000a(Function<? super Callable<Scheduler>, ? extends Scheduler> function, Callable<Scheduler> callable) {
        return (Scheduler) ObjectHelper.requireNonNull(m46003a(function, callable), "Scheduler Callable result can't be null");
    }

    private RxJavaPlugins() {
        throw new IllegalStateException("No instances!");
    }
}
