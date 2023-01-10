package com.didi.app.nova.skeleton.conductor;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.SimpleSwapChangeHandler;
import com.didi.app.nova.skeleton.conductor.internal.NoOpControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.internal.ThreadUtils;
import com.didi.app.nova.skeleton.conductor.internal.TransactionIndexer;
import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.app.nova.skeleton.title.TitleBar;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Router {

    /* renamed from: g */
    private static final String f10164g = "Router.backstack";

    /* renamed from: h */
    private static final String f10165h = "Router.popsLastView";

    /* renamed from: a */
    final Backstack f10166a = new Backstack();

    /* renamed from: b */
    final List<Controller> f10167b = new ArrayList();

    /* renamed from: c */
    boolean f10168c = false;

    /* renamed from: d */
    ViewGroup f10169d;

    /* renamed from: e */
    TitleBar f10170e;

    /* renamed from: f */
    DialogInstrument f10171f;

    /* renamed from: i */
    private final List<ControllerChangeHandler.ControllerChangeListener> f10172i = new ArrayList();

    /* renamed from: j */
    private final List<ControllerChangeHandler.ChangeTransaction> f10173j = new ArrayList();

    /* renamed from: k */
    private boolean f10174k = false;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo45426a(Intent intent);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo45427a(String str);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo45428a(String str, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo45429a(String str, Intent intent, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo45430a(String str, Intent intent, int i, Bundle bundle);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo45431a(String str, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo45432a(String str, String[] strArr);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo45433a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract List<Router> mo45434b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract Router mo45435c();

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract TransactionIndexer mo45436d();

    public abstract Activity getActivity();

    public abstract Fragment getFragment();

    /* access modifiers changed from: package-private */
    public abstract void invalidateOptionsMenu();

    public abstract void onActivityResult(int i, int i2, Intent intent);

    public TitleBar getTitleBar() {
        if (this == mo45435c()) {
            return this.f10170e;
        }
        return mo45435c().getTitleBar();
    }

    public void attachTitleBar(TitleBar titleBar) {
        if (this == mo45435c()) {
            this.f10170e = titleBar;
            return;
        }
        throw new UnsupportedOperationException("Un support attach title bar into sub router.");
    }

    public DialogInstrument getDialogInstrument() {
        if (mo45435c() == this) {
            return this.f10171f;
        }
        return mo45435c().getDialogInstrument();
    }

    public void attachDialogFrame(DialogFrameLayout dialogFrameLayout) {
        if (this == mo45435c()) {
            dialogFrameLayout.removeAllViews();
            this.f10171f = new DialogInstrument(dialogFrameLayout);
            return;
        }
        throw new UnsupportedOperationException("Un support attach Dialog frame into sub router.");
    }

    public void onRequestPermissionsResult(String str, int i, String[] strArr, int[] iArr) {
        Controller controllerWithInstanceId = getControllerWithInstanceId(str);
        if (controllerWithInstanceId != null) {
            controllerWithInstanceId.mo45467a(i, strArr, iArr);
        }
    }

    public boolean handleBack() {
        ThreadUtils.ensureMainThread();
        if (this.f10166a.mo45449a()) {
            return false;
        }
        if (!this.f10166a.mo45458f().f10182a.handleBack() && !popCurrentController()) {
            return false;
        }
        return true;
    }

    public boolean popCurrentController() {
        ThreadUtils.ensureMainThread();
        RouterTransaction f = this.f10166a.mo45458f();
        if (f != null) {
            return popController(f.f10182a);
        }
        TraceUtil.trace("Conductor#Router", "Trying to pop the current controller when there are none on the backstack.");
        return false;
    }

    public boolean popController(Controller controller) {
        ThreadUtils.ensureMainThread();
        RouterTransaction f = this.f10166a.mo45458f();
        if (!(f != null && f.f10182a == controller)) {
            Iterator<RouterTransaction> it = this.f10166a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RouterTransaction next = it.next();
                if (next.f10182a == controller) {
                    next.f10182a.mo45486d();
                    it.remove();
                    break;
                }
            }
        } else {
            m8898a(this.f10166a.mo45457e());
            m8900a(this.f10166a.mo45458f(), f, false);
        }
        if (!this.f10174k) {
            return !this.f10166a.mo45449a();
        }
        if (f != null) {
            return true;
        }
        return false;
    }

    public void pushController(RouterTransaction routerTransaction) {
        ThreadUtils.ensureMainThread();
        if (this.f10169d != null) {
            RouterTransaction f = this.f10166a.mo45458f();
            pushToBackstack(routerTransaction);
            m8900a(routerTransaction, f, true);
        }
    }

    public void replaceTopController(RouterTransaction routerTransaction) {
        ThreadUtils.ensureMainThread();
        RouterTransaction f = this.f10166a.mo45458f();
        if (!this.f10166a.mo45449a()) {
            m8898a(this.f10166a.mo45457e());
        }
        ControllerChangeHandler pushChangeHandler = routerTransaction.pushChangeHandler();
        if (f != null) {
            boolean z = false;
            boolean z2 = f.pushChangeHandler() == null || f.pushChangeHandler().removesFromViewOnPush();
            if (pushChangeHandler == null || pushChangeHandler.removesFromViewOnPush()) {
                z = true;
            }
            if (!z2 && z) {
                for (RouterTransaction a : m8894a(this.f10166a.iterator())) {
                    m8901a((RouterTransaction) null, a, true, pushChangeHandler);
                }
            }
        }
        pushToBackstack(routerTransaction);
        if (pushChangeHandler != null) {
            pushChangeHandler.setForceRemoveViewOnPush(true);
        }
        m8900a(routerTransaction.pushChangeHandler(pushChangeHandler), f, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo45593b(boolean z) {
        this.f10174k = true;
        final List<RouterTransaction> g = this.f10166a.mo45459g();
        m8902a(g);
        if (z && g.size() > 0) {
            RouterTransaction routerTransaction = g.get(0);
            routerTransaction.controller().addLifecycleListener(new Controller.LifecycleListener() {
                public void onChangeEnd(Controller controller, ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
                    if (controllerChangeType == ControllerChangeType.POP_EXIT) {
                        for (int size = g.size() - 1; size > 0; size--) {
                            Router.this.m8901a((RouterTransaction) null, (RouterTransaction) g.get(size), true, (ControllerChangeHandler) new SimpleSwapChangeHandler());
                        }
                    }
                }
            });
            m8901a((RouterTransaction) null, routerTransaction, false, routerTransaction.popChangeHandler());
        }
    }

    public int getContainerId() {
        ViewGroup viewGroup = this.f10169d;
        if (viewGroup != null) {
            return viewGroup.getId();
        }
        return 0;
    }

    public Router setPopsLastView(boolean z) {
        this.f10174k = z;
        return this;
    }

    public boolean popToRoot() {
        ThreadUtils.ensureMainThread();
        return popToRoot((ControllerChangeHandler) null);
    }

    public boolean popToRoot(ControllerChangeHandler controllerChangeHandler) {
        ThreadUtils.ensureMainThread();
        if (this.f10166a.mo45450b() <= 1) {
            return false;
        }
        m8899a(this.f10166a.mo45453c(), controllerChangeHandler);
        return true;
    }

    public boolean popToTag(String str) {
        ThreadUtils.ensureMainThread();
        return popToTag(str, (ControllerChangeHandler) null);
    }

    public boolean popToTag(String str, ControllerChangeHandler controllerChangeHandler) {
        ThreadUtils.ensureMainThread();
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (str.equals(next.tag())) {
                m8899a(next, controllerChangeHandler);
                return true;
            }
        }
        return false;
    }

    public boolean popToPageName(String str) {
        ThreadUtils.ensureMainThread();
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (str.equals(next.pageName())) {
                m8899a(next, (ControllerChangeHandler) null);
                return true;
            }
        }
        return false;
    }

    public void setRoot(RouterTransaction routerTransaction) {
        ThreadUtils.ensureMainThread();
        if (this.f10169d != null) {
            setBackstack(Collections.singletonList(routerTransaction), routerTransaction.pushChangeHandler());
        }
    }

    public Controller getControllerWithInstanceId(String str) {
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            Controller a = it.next().f10182a.mo45465a(str);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    public Controller getControllerWithTag(String str) {
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (str.equals(next.tag())) {
                return next.f10182a;
            }
        }
        return null;
    }

    public Controller getControllerWithPageName(String str) {
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (str.equals(next.pageName())) {
                return next.f10182a;
            }
        }
        return null;
    }

    public int getBackstackSize() {
        return this.f10166a.mo45450b();
    }

    public List<RouterTransaction> getBackstack() {
        ArrayList arrayList = new ArrayList();
        Iterator<RouterTransaction> d = this.f10166a.mo45455d();
        while (d.hasNext()) {
            arrayList.add(d.next());
        }
        return arrayList;
    }

    public void setBackstack(List<RouterTransaction> list, ControllerChangeHandler controllerChangeHandler) {
        ThreadUtils.ensureMainThread();
        List<RouterTransaction> backstack = getBackstack();
        List<RouterTransaction> a = m8894a(this.f10166a.iterator());
        mo45650e();
        m8904b(list);
        this.f10166a.mo45448a(list);
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.mo45636a();
            mo45589a(next.f10182a);
        }
        if (list.size() > 0) {
            ArrayList arrayList = new ArrayList(list);
            Collections.reverse(arrayList);
            List<RouterTransaction> a2 = m8894a((Iterator<RouterTransaction>) arrayList.iterator());
            boolean z = a2.size() <= 0 || !backstack.contains(a2.get(0));
            if (!m8903a(a2, a)) {
                RouterTransaction routerTransaction = a.size() > 0 ? a.get(0) : null;
                RouterTransaction routerTransaction2 = a2.get(0);
                if (routerTransaction == null || routerTransaction.f10182a != routerTransaction2.f10182a) {
                    if (routerTransaction != null) {
                        ControllerChangeHandler.m8890a(routerTransaction.f10182a.getInstanceId());
                    }
                    m8901a(routerTransaction2, routerTransaction, z, controllerChangeHandler);
                }
                for (int size = a.size() - 1; size > 0; size--) {
                    RouterTransaction routerTransaction3 = a.get(size);
                    if (!a2.contains(routerTransaction3)) {
                        ControllerChangeHandler copy = controllerChangeHandler != null ? controllerChangeHandler.copy() : new SimpleSwapChangeHandler();
                        copy.setForceRemoveViewOnPush(true);
                        ControllerChangeHandler.m8890a(routerTransaction3.f10182a.getInstanceId());
                        m8901a((RouterTransaction) null, routerTransaction3, z, copy);
                    }
                }
                for (int i = 1; i < a2.size(); i++) {
                    RouterTransaction routerTransaction4 = a2.get(i);
                    if (!a.contains(routerTransaction4)) {
                        m8901a(routerTransaction4, a2.get(i - 1), true, routerTransaction4.pushChangeHandler());
                    }
                }
            }
        }
    }

    public boolean hasRootController() {
        return getBackstackSize() > 0;
    }

    public void addChangeListener(ControllerChangeHandler.ControllerChangeListener controllerChangeListener) {
        if (!this.f10172i.contains(controllerChangeListener)) {
            this.f10172i.add(controllerChangeListener);
        }
    }

    public void removeChangeListener(ControllerChangeHandler.ControllerChangeListener controllerChangeListener) {
        this.f10172i.remove(controllerChangeListener);
    }

    public void rebindIfNeeded() {
        ThreadUtils.ensureMainThread();
        Iterator<RouterTransaction> d = this.f10166a.mo45455d();
        while (d.hasNext()) {
            RouterTransaction next = d.next();
            if (next.f10182a.mo45482b()) {
                m8901a(next, (RouterTransaction) null, true, (ControllerChangeHandler) new SimpleSwapChangeHandler(false));
            }
        }
    }

    public final void onActivityResult(String str, int i, int i2, Intent intent) {
        Controller controllerWithInstanceId = getControllerWithInstanceId(str);
        if (controllerWithInstanceId != null) {
            controllerWithInstanceId.onActivityResult(i, i2, intent);
        }
    }

    public final void onActivityStarted(Activity activity) {
        DialogInstrument dialogInstrument = this.f10171f;
        if (dialogInstrument != null) {
            dialogInstrument.onActivityStart();
        }
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f10182a.mo45468a(activity);
            for (Router onActivityStarted : next.f10182a.getChildRouters()) {
                onActivityStarted.onActivityStarted(activity);
            }
        }
    }

    public final void onActivityResumed(Activity activity) {
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f10182a.mo45479b(activity);
            for (Router onActivityResumed : next.f10182a.getChildRouters()) {
                onActivityResumed.onActivityResumed(activity);
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f10182a.mo45485c(activity);
            for (Router onActivityPaused : next.f10182a.getChildRouters()) {
                onActivityPaused.onActivityPaused(activity);
            }
        }
    }

    public final void onActivityStopped(Activity activity) {
        DialogInstrument dialogInstrument = this.f10171f;
        if (dialogInstrument != null) {
            dialogInstrument.onActivityStop();
        }
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f10182a.mo45487d(activity);
            for (Router onActivityStopped : next.f10182a.getChildRouters()) {
                onActivityStopped.onActivityStopped(activity);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        DialogInstrument dialogInstrument = this.f10171f;
        if (dialogInstrument != null) {
            dialogInstrument.onActivityDestroy();
        }
        mo45607j();
        this.f10172i.clear();
        this.f10173j.clear();
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f10182a.mo45489e(activity);
            for (Router onActivityDestroyed : next.f10182a.getChildRouters()) {
                onActivityDestroyed.onActivityDestroyed(activity);
            }
        }
        for (int size = this.f10167b.size() - 1; size >= 0; size--) {
            Controller controller = this.f10167b.get(size);
            controller.mo45489e(activity);
            for (Router onActivityDestroyed2 : controller.getChildRouters()) {
                onActivityDestroyed2.onActivityDestroyed(activity);
            }
        }
        this.f10166a.mo45459g();
        this.f10169d = null;
        this.f10170e = null;
        this.f10171f = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo45602h() {
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (ControllerChangeHandler.m8890a(next.f10182a.getInstanceId())) {
                next.f10182a.mo45476a(true);
            }
            next.f10182a.mo45466a();
        }
    }

    public void saveInstanceState(Bundle bundle) {
        mo45602h();
        Bundle bundle2 = new Bundle();
        this.f10166a.mo45447a(bundle2);
        bundle.putParcelable(f10164g, bundle2);
        bundle.putBoolean(f10165h, this.f10174k);
    }

    public void restoreInstanceState(Bundle bundle) {
        this.f10166a.mo45451b((Bundle) bundle.getParcelable(f10164g));
        this.f10174k = bundle.getBoolean(f10165h);
        Iterator<RouterTransaction> d = this.f10166a.mo45455d();
        while (d.hasNext()) {
            mo45589a(d.next().f10182a);
        }
    }

    public final void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f10182a.mo45470a(menu, menuInflater);
            for (Router onCreateOptionsMenu : next.f10182a.getChildRouters()) {
                onCreateOptionsMenu.onCreateOptionsMenu(menu, menuInflater);
            }
        }
    }

    public final void onPrepareOptionsMenu(Menu menu) {
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f10182a.mo45469a(menu);
            for (Router onPrepareOptionsMenu : next.f10182a.getChildRouters()) {
                onPrepareOptionsMenu.onPrepareOptionsMenu(menu);
            }
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (next.f10182a.mo45477a(menuItem)) {
                return true;
            }
            Iterator<Router> it2 = next.f10182a.getChildRouters().iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().onOptionsItemSelected(menuItem)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m8899a(RouterTransaction routerTransaction, ControllerChangeHandler controllerChangeHandler) {
        StringBuilder sb = new StringBuilder("Router#popToTransaction");
        sb.append("[controller=");
        sb.append(routerTransaction.f10182a);
        if (this.f10166a.mo45450b() > 0) {
            sb.append(", backstack=[");
            RouterTransaction f = this.f10166a.mo45458f();
            ArrayList arrayList = new ArrayList();
            Iterator<RouterTransaction> d = this.f10166a.mo45455d();
            while (d.hasNext()) {
                RouterTransaction next = d.next();
                arrayList.add(next);
                sb.append(next.f10182a);
                sb.append(", ");
                if (next == routerTransaction) {
                    break;
                }
            }
            if (controllerChangeHandler == null) {
                controllerChangeHandler = f.popChangeHandler();
            }
            sb.append(f);
            sb.append(Const.jaRight);
            setBackstack(arrayList, controllerChangeHandler);
        }
        sb.append(Const.jaRight);
        TraceUtil.trace("[Conductor]", sb.toString());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo45606i() {
        this.f10169d.post(new Runnable() {
            public void run() {
                Router.this.f10168c = true;
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo45607j() {
        this.f10168c = false;
        ViewGroup viewGroup = this.f10169d;
        if (viewGroup != null) {
            viewGroup.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void onContextAvailable() {
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            it.next().f10182a.mo45484c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final List<Controller> mo45608k() {
        ArrayList arrayList = new ArrayList();
        Iterator<RouterTransaction> d = this.f10166a.mo45455d();
        while (d.hasNext()) {
            arrayList.add(d.next().f10182a);
        }
        return arrayList;
    }

    public final Boolean handleRequestedPermission(String str) {
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (next.f10182a.mo45483b(str)) {
                return Boolean.valueOf(next.f10182a.shouldShowRequestPermissionRationale(str));
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m8900a(RouterTransaction routerTransaction, RouterTransaction routerTransaction2, boolean z) {
        ControllerChangeHandler controllerChangeHandler;
        if (z && routerTransaction != null) {
            routerTransaction.mo45636a();
        }
        if (z) {
            controllerChangeHandler = routerTransaction.pushChangeHandler();
        } else {
            controllerChangeHandler = routerTransaction2 != null ? routerTransaction2.popChangeHandler() : null;
        }
        m8901a(routerTransaction, routerTransaction2, z, controllerChangeHandler);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8901a(RouterTransaction routerTransaction, RouterTransaction routerTransaction2, boolean z, ControllerChangeHandler controllerChangeHandler) {
        boolean z2;
        Controller controller = null;
        Controller controller2 = routerTransaction != null ? routerTransaction.f10182a : null;
        if (routerTransaction2 != null) {
            controller = routerTransaction2.f10182a;
        }
        if (routerTransaction != null) {
            routerTransaction.mo45637a(mo45436d());
            mo45589a(controller2);
        } else if (this.f10166a.mo45450b() == 0 && !this.f10174k) {
            controllerChangeHandler = new NoOpControllerChangeHandler();
            z2 = true;
            m8895a(controller2, controller, z, controllerChangeHandler);
            if (z2 && controller != null && controller.getView() != null) {
                controller.mo45471a(controller.getView(), true, false);
                return;
            }
            return;
        }
        z2 = false;
        m8895a(controller2, controller, z, controllerChangeHandler);
        if (z2) {
        }
    }

    /* renamed from: a */
    private void m8895a(Controller controller, Controller controller2, boolean z, ControllerChangeHandler controllerChangeHandler) {
        if (!z || controller == null || !controller.isDestroyed()) {
            ControllerChangeHandler.ChangeTransaction changeTransaction = new ControllerChangeHandler.ChangeTransaction(controller, controller2, z, this.f10169d, controllerChangeHandler, new ArrayList(this.f10172i));
            if (this.f10173j.size() > 0) {
                this.f10173j.add(changeTransaction);
            } else if (controller2 == null || ((controllerChangeHandler != null && !controllerChangeHandler.removesFromViewOnPush()) || this.f10168c)) {
                ControllerChangeHandler.m8888a(changeTransaction);
            } else {
                this.f10173j.add(changeTransaction);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        Router.this.mo45609l();
                    }
                });
            }
        } else {
            throw new IllegalStateException("Trying to push a controller that has already been destroyed. (" + controller.getClass().getSimpleName() + ")");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo45609l() {
        for (int i = 0; i < this.f10173j.size(); i++) {
            ControllerChangeHandler.ChangeTransaction changeTransaction = this.f10173j.get(i);
            if (changeTransaction.f10163to == null || (!changeTransaction.f10163to.isBeingDestroyed() && !changeTransaction.f10163to.isDestroyed())) {
                ControllerChangeHandler.m8888a(changeTransaction);
            }
        }
        this.f10173j.clear();
    }

    /* access modifiers changed from: protected */
    public void pushToBackstack(RouterTransaction routerTransaction) {
        this.f10166a.mo45454c(routerTransaction);
    }

    /* renamed from: a */
    private void m8898a(RouterTransaction routerTransaction) {
        if (!routerTransaction.f10182a.isDestroyed()) {
            this.f10167b.add(routerTransaction.f10182a);
            routerTransaction.f10182a.addLifecycleListener(new Controller.LifecycleListener() {
                public void postDestroy(Controller controller) {
                    Router.this.f10167b.remove(controller);
                }
            });
        }
    }

    /* renamed from: a */
    private void m8902a(List<RouterTransaction> list) {
        for (RouterTransaction a : list) {
            m8898a(a);
        }
    }

    /* renamed from: e */
    private void mo45650e() {
        ArrayList arrayList = new ArrayList();
        for (RouterTransaction next : m8894a(this.f10166a.iterator())) {
            if (next.f10182a.getView() != null) {
                arrayList.add(next.f10182a.getView());
            }
        }
        for (Router next2 : mo45434b()) {
            if (next2.f10169d == this.f10169d) {
                m8897a(next2, (List<View>) arrayList);
            }
        }
        ViewGroup viewGroup = this.f10169d;
        for (int childCount = (viewGroup == null ? 0 : viewGroup.getChildCount()) - 1; childCount >= 0; childCount--) {
            View childAt = this.f10169d.getChildAt(childCount);
            if (!arrayList.contains(childAt)) {
                this.f10169d.removeView(childAt);
            }
        }
    }

    /* renamed from: b */
    private void m8904b(List<RouterTransaction> list) {
        ArrayList arrayList = new ArrayList();
        for (RouterTransaction next : list) {
            next.mo45637a(mo45436d());
            arrayList.add(Integer.valueOf(next.f10183b));
        }
        Collections.sort(arrayList);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).f10183b = ((Integer) arrayList.get(i)).intValue();
        }
    }

    /* renamed from: a */
    private void m8897a(Router router2, List<View> list) {
        for (Controller next : router2.mo45608k()) {
            if (next.getView() != null) {
                list.add(next.getView());
            }
            for (Router a : next.getChildRouters()) {
                m8897a(a, list);
            }
        }
    }

    /* renamed from: a */
    private List<RouterTransaction> m8894a(Iterator<RouterTransaction> it) {
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            arrayList.add(next);
            if (next.pushChangeHandler() != null) {
                if (next.pushChangeHandler().removesFromViewOnPush()) {
                    break;
                }
            } else {
                break;
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private boolean m8903a(List<RouterTransaction> list, List<RouterTransaction> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).controller() != list.get(i).controller()) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45589a(Controller controller) {
        controller.mo45474a(this);
        controller.mo45484c();
    }
}
