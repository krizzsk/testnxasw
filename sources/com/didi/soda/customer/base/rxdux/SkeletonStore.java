package com.didi.soda.customer.base.rxdux;

import com.appsflyer.internal.referrer.Payload;
import com.didi.app.nova.skeleton.Component;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.RouterTransaction;
import com.didi.app.nova.skeleton.internal.page.ControllerProxy;
import com.didi.app.nova.skeleton.internal.page.PageInstrumentImpl;
import com.didi.app.nova.skeleton.internal.page.PageWrapper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.jadux.AbsAction;
import com.didi.soda.jadux.Action;
import com.didi.soda.jadux.ActionFunction;
import com.didi.soda.jadux.Store;
import com.didi.soda.jadux.collection.JxArrayList;
import com.didi.soda.jadux.collection.JxList;
import com.didi.soda.jadux.function.MiddwareFunction;
import com.didi.soda.jadux.middleware.LogMiddleWare;
import com.didi.soda.jadux.middleware.ThunkMiddleware;
import com.didi.soda.jadux.utils.ActionTypes;
import p218io.reactivex.Single;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.functions.Consumer;
import p218io.reactivex.functions.Function;
import p218io.reactivex.subjects.PublishSubject;
import p218io.reactivex.subjects.SingleSubject;

public final class SkeletonStore {
    public static final String TAG = "SkeletonStore";

    /* renamed from: a */
    private static SkeletonStore f42970a;

    /* renamed from: b */
    private static SkeletonStore f42971b = new SkeletonStore();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PublishSubject<Boolean> f42972c = PublishSubject.create();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f42973d = false;

    /* renamed from: e */
    private PageInstrument f42974e;

    private SkeletonStore() {
    }

    public static SkeletonStore getStore() {
        SkeletonStore skeletonStore = f42970a;
        return skeletonStore == null ? f42971b : skeletonStore;
    }

    public static void createStore(PageInstrument pageInstrument) {
        if (f42970a == null) {
            f42970a = new SkeletonStore();
            JxArrayList jxArrayList = new JxArrayList();
            jxArrayList.add(ThunkMiddleware.createThunkMiddleware());
            jxArrayList.add(LogMiddleWare.createLogMiddleware());
            m32121a(pageInstrument, (JxList<MiddwareFunction>) jxArrayList);
        }
    }

    public static void destory() {
        f42970a = null;
    }

    /* renamed from: a */
    private static void m32121a(PageInstrument pageInstrument, JxList<MiddwareFunction> jxList) {
        if (pageInstrument != null) {
            f42970a.f42974e = pageInstrument;
            return;
        }
        throw new IllegalArgumentException("Root scope must not be null!");
    }

    public Single<AbsAction> dispatch(AbsAction absAction) {
        if (absAction instanceof Action) {
            Action action = (Action) absAction;
            try {
                LogUtil.m32588i(TAG, Thread.currentThread().getName());
                LogUtil.m32584d(TAG, "Dispatch Action: " + action.getType() + "\nPayload:\n" + action.getPayload().toString());
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            if (ActionTypes.UNKNOW.equals(action.getType())) {
                throw new IllegalArgumentException("Unknow action mType!");
            } else if (this.f42973d) {
                String str = " action = " + action.getType();
                LogUtil.m32588i(TAG, str);
                throw new IllegalStateException("Reducers may not dispatch actions. " + str);
            } else if (this.f42974e == null) {
                return Single.just(absAction);
            } else {
                SingleSubject create = SingleSubject.create();
                Single.just(action).flatMap(new Function<Action, SingleSource<?>>() {
                    public SingleSource<?> apply(Action action) throws Exception {
                        return SkeletonStore.this.m32120a(action);
                    }
                }).doOnSubscribe(new Consumer<Disposable>() {
                    public void accept(Disposable disposable) {
                        boolean unused = SkeletonStore.this.f42973d = true;
                        SkeletonStore.this.f42972c.onNext(Boolean.valueOf(SkeletonStore.this.f42973d));
                    }
                }).doFinally(new p218io.reactivex.functions.Action() {
                    public void run() throws Exception {
                        boolean unused = SkeletonStore.this.f42973d = false;
                        SkeletonStore.this.f42972c.onNext(Boolean.valueOf(SkeletonStore.this.f42973d));
                    }
                }).doOnSuccess(new Consumer<Object>() {
                    public void accept(Object obj) throws Exception {
                        boolean unused = SkeletonStore.this.f42973d = false;
                    }
                }).doOnError(new Consumer<Throwable>() {
                    public void accept(Throwable th) {
                        boolean unused = SkeletonStore.this.f42973d = false;
                        th.printStackTrace();
                    }
                }).subscribe(create);
                return create;
            }
        } else if (absAction instanceof ActionFunction) {
            throw new IllegalArgumentException("Please include ThunkMiddleware to deal with ActionFunction!");
        } else {
            throw new IllegalArgumentException("Action should be Action or ActionFunction!");
        }
    }

    public <T> Store<T> getScopeStore(Class<T> cls) {
        PageInstrumentImpl pageInstrumentImpl = (PageInstrumentImpl) this.f42974e;
        if (pageInstrumentImpl == null) {
            return null;
        }
        for (RouterTransaction controller : pageInstrumentImpl.f62465router.getBackstack()) {
            Controller controller2 = controller.controller();
            if (controller2 instanceof ControllerProxy) {
                PageWrapper page = ((ControllerProxy) controller2).getPage();
                Store<T> a = m32118a(page.getScopeContext(), cls);
                if (a != null) {
                    return a;
                }
                if (page instanceof RxduxPage) {
                    for (Component scopeContext : ((RxduxPage) page).f42969a) {
                        Store<T> a2 = m32118a(scopeContext.getScopeContext(), cls);
                        if (a2 != null) {
                            return a2;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private <T> Store<T> m32118a(ScopeContext scopeContext, Class<T> cls) {
        Store<T> store = (Store) scopeContext.getObject(scopeContext.alias() + Payload.TYPE_STORE);
        if (store != null && store.getStateClass().equals(cls)) {
            return store;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Single<Action> m32120a(Action action) {
        for (RouterTransaction controller : ((PageInstrumentImpl) this.f42974e).f62465router.getBackstack()) {
            Controller controller2 = controller.controller();
            if (controller2 instanceof ControllerProxy) {
                PageWrapper page = ((ControllerProxy) controller2).getPage();
                m32122a(page.getScopeContext(), action);
                if (page instanceof RxduxPage) {
                    for (Component scopeContext : ((RxduxPage) page).f42969a) {
                        m32122a(scopeContext.getScopeContext(), action);
                    }
                }
            }
        }
        return Single.just(action);
    }

    /* renamed from: a */
    private void m32122a(ScopeContext scopeContext, Action action) {
        Store store = (Store) scopeContext.getObject(scopeContext.alias() + Payload.TYPE_STORE);
        if (store != null) {
            store.dispatch(action);
        }
    }
}
