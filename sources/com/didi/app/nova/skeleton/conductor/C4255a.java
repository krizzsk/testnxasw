package com.didi.app.nova.skeleton.conductor;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.internal.TransactionIndexer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.app.nova.skeleton.conductor.a */
/* compiled from: ControllerHostedRouter */
class C4255a extends Router {

    /* renamed from: g */
    private final String f10189g = "ControllerHostedRouter.hostId";

    /* renamed from: h */
    private final String f10190h = "ControllerHostedRouter.tag";

    /* renamed from: i */
    private Controller f10191i;

    /* renamed from: j */
    private int f10192j;

    /* renamed from: k */
    private String f10193k;

    /* renamed from: l */
    private boolean f10194l;

    C4255a() {
    }

    C4255a(int i, String str) {
        this.f10192j = i;
        this.f10193k = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45648a(Controller controller, ViewGroup viewGroup) {
        if (this.f10191i != controller || this.f10169d != viewGroup) {
            mo45650e();
            if (viewGroup instanceof ControllerChangeHandler.ControllerChangeListener) {
                addChangeListener((ControllerChangeHandler.ControllerChangeListener) viewGroup);
            }
            this.f10191i = controller;
            this.f10169d = viewGroup;
            Iterator<RouterTransaction> it = this.f10166a.iterator();
            while (it.hasNext()) {
                it.next().f10182a.mo45472a(controller);
            }
            mo45606i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo45650e() {
        if (this.f10169d != null && (this.f10169d instanceof ControllerChangeHandler.ControllerChangeListener)) {
            removeChangeListener((ControllerChangeHandler.ControllerChangeListener) this.f10169d);
        }
        for (Controller controller : new ArrayList(this.f10167b)) {
            if (controller.getView() != null) {
                controller.mo45471a(controller.getView(), true, false);
            }
        }
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (next.f10182a.getView() != null) {
                next.f10182a.mo45471a(next.f10182a.getView(), true, false);
            }
        }
        mo45607j();
        this.f10191i = null;
        this.f10169d = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45649a(boolean z) {
        this.f10194l = z;
        Iterator<RouterTransaction> it = this.f10166a.iterator();
        while (it.hasNext()) {
            it.next().f10182a.mo45481b(z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo45593b(boolean z) {
        mo45649a(false);
        super.mo45593b(z);
    }

    /* access modifiers changed from: protected */
    public void pushToBackstack(RouterTransaction routerTransaction) {
        if (this.f10194l) {
            routerTransaction.f10182a.mo45481b(true);
        }
        super.pushToBackstack(routerTransaction);
    }

    public void setBackstack(List<RouterTransaction> list, ControllerChangeHandler controllerChangeHandler) {
        if (this.f10194l) {
            for (RouterTransaction routerTransaction : list) {
                routerTransaction.f10182a.mo45481b(true);
            }
        }
        super.setBackstack(list, controllerChangeHandler);
    }

    public Activity getActivity() {
        Controller controller = this.f10191i;
        if (controller != null) {
            return controller.getActivity();
        }
        return null;
    }

    public Fragment getFragment() {
        Controller controller = this.f10191i;
        if (controller == null || controller.getRouter() == null) {
            return null;
        }
        this.f10191i.getRouter().getFragment();
        return null;
    }

    public void onActivityDestroyed(Activity activity) {
        super.onActivityDestroyed(activity);
        mo45650e();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Controller controller = this.f10191i;
        if (controller != null && controller.getRouter() != null) {
            this.f10191i.getRouter().onActivityResult(i, i2, intent);
        }
    }

    public void invalidateOptionsMenu() {
        Controller controller = this.f10191i;
        if (controller != null && controller.getRouter() != null) {
            this.f10191i.getRouter().invalidateOptionsMenu();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45426a(Intent intent) {
        Controller controller = this.f10191i;
        if (controller != null && controller.getRouter() != null) {
            this.f10191i.getRouter().mo45426a(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45429a(String str, Intent intent, int i) {
        Controller controller = this.f10191i;
        if (controller != null && controller.getRouter() != null) {
            this.f10191i.getRouter().mo45429a(str, intent, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45430a(String str, Intent intent, int i, Bundle bundle) {
        Controller controller = this.f10191i;
        if (controller != null && controller.getRouter() != null) {
            this.f10191i.getRouter().mo45430a(str, intent, i, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45431a(String str, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        Controller controller = this.f10191i;
        if (controller != null && controller.getRouter() != null) {
            this.f10191i.getRouter().mo45431a(str, intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45428a(String str, int i) {
        Controller controller = this.f10191i;
        if (controller != null && controller.getRouter() != null) {
            this.f10191i.getRouter().mo45428a(str, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45427a(String str) {
        Controller controller = this.f10191i;
        if (controller != null && controller.getRouter() != null) {
            this.f10191i.getRouter().mo45427a(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45432a(String str, String[] strArr) {
        Controller controller = this.f10191i;
        if (controller != null && controller.getRouter() != null) {
            this.f10191i.getRouter().mo45432a(str, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo45433a() {
        return this.f10191i != null;
    }

    public void saveInstanceState(Bundle bundle) {
        super.saveInstanceState(bundle);
        bundle.putInt("ControllerHostedRouter.hostId", this.f10192j);
        bundle.putString("ControllerHostedRouter.tag", this.f10193k);
    }

    public void restoreInstanceState(Bundle bundle) {
        super.restoreInstanceState(bundle);
        this.f10192j = bundle.getInt("ControllerHostedRouter.hostId");
        this.f10193k = bundle.getString("ControllerHostedRouter.tag");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45589a(Controller controller) {
        super.mo45589a(controller);
        controller.mo45472a(this.f10191i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo45651f() {
        return this.f10192j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public String mo45652g() {
        return this.f10193k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public List<Router> mo45434b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f10191i.getChildRouters());
        arrayList.addAll(this.f10191i.getRouter().mo45434b());
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Router mo45435c() {
        Controller controller = this.f10191i;
        return (controller == null || controller.getRouter() == null) ? this : this.f10191i.getRouter().mo45435c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public TransactionIndexer mo45436d() {
        return mo45435c().mo45436d();
    }
}
