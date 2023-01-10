package com.didi.soda.jadux;

import com.didi.soda.jadux.collection.JxArrayList;
import com.didi.soda.jadux.collection.JxList;
import com.didi.soda.jadux.function.DispatchFunction;
import com.didi.soda.jadux.function.MiddwareFunction;
import com.didi.soda.jadux.middleware.LogMiddleWare;
import com.didi.soda.jadux.middleware.ThunkMiddleware;
import com.didi.soda.jadux.utils.ActionTypes;
import com.google.gson.Gson;
import p218io.reactivex.Single;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.functions.Action;
import p218io.reactivex.functions.Consumer;
import p218io.reactivex.functions.Function;
import p218io.reactivex.subjects.BehaviorSubject;
import p218io.reactivex.subjects.PublishSubject;
import p218io.reactivex.subjects.SingleSubject;

public class Store<State> {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Gson f45902d = new Gson();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f45903a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Reducer<State> f45904b;

    /* renamed from: c */
    private String f45905c = null;
    public DispatchFunction dispatchFunction = new DispatchFunction() {
        public Single<AbsAction> apply(AbsAction absAction) {
            return Store.this.dispatch(absAction);
        }
    };
    protected PublishSubject<Boolean> dispatchingSubject = PublishSubject.create();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Class<State> f45906e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f45907f = false;
    protected BehaviorSubject<State> publishSubject;

    /* renamed from: a */
    private void m34039a(JxList<MiddwareFunction> jxList) {
    }

    public void destroyStore() {
    }

    public Store createStore(Reducer<State> reducer, State state) {
        JxArrayList jxArrayList = new JxArrayList();
        jxArrayList.add(ThunkMiddleware.createThunkMiddleware());
        jxArrayList.add(LogMiddleWare.createLogMiddleware());
        m34037a(reducer, state, jxArrayList);
        return this;
    }

    /* renamed from: a */
    private Store m34037a(Reducer<State> reducer, State state, JxList<MiddwareFunction> jxList) {
        if (reducer != null) {
            this.f45904b = reducer;
            if (state != null) {
                this.f45906e = state.getClass();
            }
            String json = f45902d.toJson((Object) state);
            this.f45903a = json;
            this.f45905c = json;
            this.publishSubject = BehaviorSubject.createDefault(state);
            m34039a(jxList);
            return this;
        }
        throw new IllegalArgumentException("reducer must not be null!");
    }

    public Single<AbsAction> dispatch(final AbsAction absAction) {
        if (absAction instanceof Action) {
            Action action = (Action) absAction;
            if (ActionTypes.UNKNOW.equals(action.getType())) {
                throw new IllegalArgumentException("Unknow action type!");
            } else if (this.f45907f) {
                throw new IllegalStateException("Reducers may not dispatch actions.");
            } else if (this.f45904b != null) {
                SingleSubject create = SingleSubject.create();
                Single.just(action).map(new Function<Action, State>() {
                    public State apply(Action action) throws Exception {
                        return Store.this.f45904b.reduce(Store.f45902d.fromJson(Store.this.f45903a, Store.this.f45906e), action);
                    }
                }).doOnSubscribe(new Consumer<Disposable>() {
                    public void accept(Disposable disposable) {
                        boolean unused = Store.this.f45907f = true;
                        Store.this.dispatchingSubject.onNext(Boolean.valueOf(Store.this.f45907f));
                    }
                }).doFinally(new Action() {
                    public void run() throws Exception {
                        boolean unused = Store.this.f45907f = false;
                        Store.this.dispatchingSubject.onNext(Boolean.valueOf(Store.this.f45907f));
                    }
                }).doOnSuccess(new Consumer<State>() {
                    public void accept(State state) {
                        boolean unused = Store.this.f45907f = false;
                        Store.this.update(state);
                    }
                }).doOnError(new Consumer<Throwable>() {
                    public void accept(Throwable th) {
                        boolean unused = Store.this.f45907f = false;
                        th.printStackTrace();
                    }
                }).map(new Function<State, AbsAction>() {
                    public AbsAction apply(State state) {
                        return absAction;
                    }
                }).subscribe(create);
                return create;
            } else {
                throw new IllegalStateException("Call createStore first to init the store!");
            }
        } else if (absAction instanceof ActionFunction) {
            throw new IllegalArgumentException("Please include ThunkMiddleware to deal with ActionFunction!");
        } else {
            throw new IllegalArgumentException("Action should be Action or ActionFunction!");
        }
    }

    /* access modifiers changed from: protected */
    public void update(State state) {
        String json = f45902d.toJson((Object) state);
        if (!this.f45903a.equals(json)) {
            this.f45903a = json;
            this.publishSubject.onNext(state);
        }
    }

    public Disposable subscribe(Consumer<State> consumer, Consumer<Throwable> consumer2) {
        return this.publishSubject.subscribe(consumer, consumer2);
    }

    public Disposable subscribe(Consumer<State> consumer) {
        return this.publishSubject.subscribe(consumer);
    }

    public State getState() {
        return f45902d.fromJson(this.f45903a, this.f45906e);
    }

    public Class<State> getStateClass() {
        return this.f45906e;
    }
}
