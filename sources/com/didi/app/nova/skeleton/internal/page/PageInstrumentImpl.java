package com.didi.app.nova.skeleton.internal.page;

import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.conductor.Router;
import com.didi.app.nova.skeleton.conductor.RouterTransaction;
import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.app.nova.skeleton.title.TitleBar;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PageInstrumentImpl implements PageInstrument {

    /* renamed from: a */
    static final String f10328a = "PageInstrumentImpl.Tag.RootPage";

    /* renamed from: b */
    private List<IScopeLifecycle> f10329b = new ArrayList();

    /* renamed from: c */
    private PageInstrument.IPagePushCallback f10330c;

    /* renamed from: router  reason: collision with root package name */
    public Router f62465router;

    public PageInstrumentImpl(Router router2) {
        this.f62465router = router2;
    }

    public boolean hasRootPage() {
        return this.f62465router.hasRootController();
    }

    public void setRootPage(Page page) {
        if (this.f62465router.getContainerId() == 0) {
            TraceUtil.trace("PageInstrumentImpl", "[WARN] Conductor is destroyed and setRootPage " + page);
            return;
        }
        PageInstrument.IPagePushCallback iPagePushCallback = this.f10330c;
        if (iPagePushCallback != null) {
            iPagePushCallback.pageConfigureOnPush(page);
        }
        ControllerProxy controllerProxy = new ControllerProxy(page.getArgs());
        controllerProxy.f10327c = page;
        if (!this.f10329b.isEmpty()) {
            for (int i = 0; i < this.f10329b.size(); i++) {
                page.addLifecycleCallback(this.f10329b.get(i));
            }
        }
        TraceUtil.trace("PageInstrumentImpl", "setRootPage " + page);
        page.attach(this.f62465router.getActivity(), this, controllerProxy);
        this.f62465router.setRoot(RouterTransaction.with(controllerProxy).pushChangeHandler(getBackstackSize() > 0 ? page.getPushHandler() : null).popChangeHandler(page.getPopHandler()).tag(f10328a).pageName(page.getClass().getName()));
    }

    public Page getRootPage() {
        ControllerProxy controllerProxy;
        if (!this.f62465router.hasRootController() || (controllerProxy = (ControllerProxy) this.f62465router.getControllerWithTag(f10328a)) == null) {
            return null;
        }
        return (Page) controllerProxy.getPage();
    }

    public void pushPage(Page page) {
        if (this.f62465router.getContainerId() == 0) {
            TraceUtil.trace("PageInstrumentImpl", "[WARN] Conductor is destroyed and pushPage " + page);
            return;
        }
        PageInstrument.IPagePushCallback iPagePushCallback = this.f10330c;
        if (iPagePushCallback != null) {
            iPagePushCallback.pageConfigureOnPush(page);
        }
        ControllerProxy controllerProxy = new ControllerProxy(page.getArgs());
        controllerProxy.f10327c = page;
        if (!this.f10329b.isEmpty()) {
            for (int i = 0; i < this.f10329b.size(); i++) {
                page.addLifecycleCallback(this.f10329b.get(i));
            }
        }
        TraceUtil.trace("PageInstrumentImpl", "pushPage " + page);
        page.attach(this.f62465router.getActivity(), this, controllerProxy);
        this.f62465router.pushController(RouterTransaction.with(page.controller).pushChangeHandler(page.getPushHandler()).popChangeHandler(page.getPopHandler()).tag(page.getClass().getName()).pageName(page.getClass().getName()));
    }

    public void pop() {
        if (this.f62465router.getBackstackSize() != 0) {
            this.f62465router.popCurrentController();
            TraceUtil.trace("PageInstrumentImpl", "pop()");
        }
    }

    public void popToPage(Class<?> cls) {
        if (containsPageInBackStack(cls)) {
            this.f62465router.popToPageName(cls.getName());
        }
    }

    public boolean containsPageInBackStack(Class<?> cls) {
        return this.f62465router.getControllerWithPageName(cls.getName()) != null;
    }

    public void popToRoot() {
        this.f62465router.popToRoot();
        TraceUtil.trace("PageInstrumentImpl", "popToRoot()");
    }

    public boolean handleBack() {
        if (getDialogInstrument() != null && getDialogInstrument().handleBack()) {
            return true;
        }
        TraceUtil.trace("PageInstrumentImpl", "handleBack()");
        return this.f62465router.handleBack();
    }

    public void attachTitleBar(TitleBar titleBar) {
        this.f62465router.attachTitleBar(titleBar);
    }

    public void attachDialogFrame(DialogFrameLayout dialogFrameLayout) {
        this.f62465router.attachDialogFrame(dialogFrameLayout);
    }

    public DialogInstrument getDialogInstrument() {
        return this.f62465router.getDialogInstrument();
    }

    public int getBackstackSize() {
        return this.f62465router.getBackstackSize();
    }

    public void registerPageLifecycleCallback(IScopeLifecycle iScopeLifecycle) {
        synchronized (this.f10329b) {
            this.f10329b.add(iScopeLifecycle);
        }
    }

    public void unregisterPageLifecycleCallback(IScopeLifecycle iScopeLifecycle) {
        synchronized (this.f10329b) {
            this.f10329b.remove(iScopeLifecycle);
        }
    }

    public List<IScopeLifecycle> getRegisteredPageLifecycleCallbacks() {
        return Collections.unmodifiableList(this.f10329b);
    }

    public void setPagePushCallback(PageInstrument.IPagePushCallback iPagePushCallback) {
        this.f10330c = iPagePushCallback;
    }
}
