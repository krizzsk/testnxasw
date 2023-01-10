package com.didi.app.nova.skeleton.conductor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.internal.ClassUtils;
import com.didi.app.nova.skeleton.conductor.internal.RouterRequiringFunc;
import com.didi.app.nova.skeleton.conductor.internal.ViewAttachHandler;
import com.didichuxing.sofa.permission.PermissionRequest;
import com.didichuxing.sofa.permission.PermissionResultCallback;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public abstract class Controller implements PermissionResultCallback {

    /* renamed from: a */
    static final String f10114a = "Controller.viewState.bundle";

    /* renamed from: c */
    private static final String f10115c = "Controller.className";

    /* renamed from: d */
    private static final String f10116d = "Controller.viewState";

    /* renamed from: e */
    private static final String f10117e = "Controller.childRouters";

    /* renamed from: f */
    private static final String f10118f = "Controller.savedState";

    /* renamed from: g */
    private static final String f10119g = "Controller.instanceId";

    /* renamed from: h */
    private static final String f10120h = "Controller.target.instanceId";

    /* renamed from: i */
    private static final String f10121i = "Controller.args";

    /* renamed from: j */
    private static final String f10122j = "Controller.needsAttach";

    /* renamed from: k */
    private static final String f10123k = "Controller.requestedPermissions";

    /* renamed from: l */
    private static final String f10124l = "Controller.overriddenPushHandler";

    /* renamed from: m */
    private static final String f10125m = "Controller.overriddenPopHandler";

    /* renamed from: n */
    private static final String f10126n = "Controller.viewState.hierarchy";

    /* renamed from: o */
    private static final String f10127o = "Controller.retainViewMode";

    /* renamed from: A */
    private Controller f10128A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public String f10129B;

    /* renamed from: C */
    private String f10130C;

    /* renamed from: D */
    private boolean f10131D;

    /* renamed from: E */
    private boolean f10132E;

    /* renamed from: F */
    private boolean f10133F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f10134G;

    /* renamed from: H */
    private ControllerChangeHandler f10135H;

    /* renamed from: I */
    private ControllerChangeHandler f10136I;

    /* renamed from: J */
    private RetainViewMode f10137J;

    /* renamed from: K */
    private ViewAttachHandler f10138K;

    /* renamed from: L */
    private final List<C4255a> f10139L;

    /* renamed from: M */
    private final List<LifecycleListener> f10140M;

    /* renamed from: N */
    private final ArrayList<String> f10141N;

    /* renamed from: O */
    private final ArrayList<RouterRequiringFunc> f10142O;

    /* renamed from: P */
    private WeakReference<View> f10143P;

    /* renamed from: Q */
    private boolean f10144Q;

    /* renamed from: R */
    private boolean f10145R;

    /* renamed from: b */
    Bundle f10146b;

    /* renamed from: p */
    private final Bundle f10147p;

    /* renamed from: q */
    private Bundle f10148q;

    /* renamed from: r */
    private boolean f10149r;

    /* renamed from: s */
    private boolean f10150s;

    /* renamed from: t */
    private boolean f10151t;

    /* renamed from: u */
    private boolean f10152u;

    /* renamed from: v */
    private boolean f10153v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f10154w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f10155x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public Router f10156y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public View f10157z;

    public static abstract class LifecycleListener {
        public void onChangeEnd(Controller controller, ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        }

        public void onChangeStart(Controller controller, ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        }

        public void onRestoreInstanceState(Controller controller, Bundle bundle) {
        }

        public void onRestoreViewState(Controller controller, Bundle bundle) {
        }

        public void onSaveInstanceState(Controller controller, Bundle bundle) {
        }

        public void onSaveViewState(Controller controller, Bundle bundle) {
        }

        public void postAttach(Controller controller, View view) {
        }

        public void postContextAvailable(Controller controller, Context context) {
        }

        public void postContextUnavailable(Controller controller) {
        }

        public void postCreateView(Controller controller, View view) {
        }

        public void postDestroy(Controller controller) {
        }

        public void postDestroyView(Controller controller) {
        }

        public void postDetach(Controller controller, View view) {
        }

        public void preAttach(Controller controller, View view) {
        }

        public void preContextAvailable(Controller controller) {
        }

        public void preContextUnavailable(Controller controller, Context context) {
        }

        public void preCreateView(Controller controller) {
        }

        public void preDestroy(Controller controller) {
        }

        public void preDestroyView(Controller controller, View view) {
        }

        public void preDetach(Controller controller, View view) {
        }
    }

    public enum RetainViewMode {
        RELEASE_DETACH,
        RETAIN_DETACH
    }

    /* access modifiers changed from: protected */
    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* access modifiers changed from: protected */
    public void onActivityResumed(Activity activity) {
    }

    /* access modifiers changed from: protected */
    public void onActivityStarted(Activity activity) {
    }

    /* access modifiers changed from: protected */
    public void onActivityStopped(Activity activity) {
    }

    /* access modifiers changed from: protected */
    public void onAttach(View view) {
    }

    /* access modifiers changed from: protected */
    public void onChangeEnded(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
    }

    /* access modifiers changed from: protected */
    public void onChangeStarted(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
    }

    /* access modifiers changed from: protected */
    public void onContextAvailable(Context context) {
    }

    /* access modifiers changed from: protected */
    public void onContextUnavailable() {
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    /* access modifiers changed from: protected */
    public abstract View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* access modifiers changed from: protected */
    public void onDestroyView(View view) {
    }

    /* access modifiers changed from: protected */
    public void onDetach(View view) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onPermissionDenied(String[] strArr) {
    }

    public void onPermissionGranted() {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onRestoreViewState(View view, Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onSaveViewState(View view, Bundle bundle) {
    }

    public boolean onShowPermissionExplanation(PermissionRequest permissionRequest) {
        return false;
    }

    /* renamed from: a */
    static Controller m8841a(Bundle bundle) {
        Controller controller;
        String string = bundle.getString(f10115c);
        Class classForName = ClassUtils.classForName(string, false);
        Constructor[] constructors = classForName.getConstructors();
        Constructor b = m8847b(constructors);
        Bundle bundle2 = bundle.getBundle(f10121i);
        if (bundle2 != null) {
            bundle2.setClassLoader(classForName.getClassLoader());
        }
        if (b != null) {
            try {
                controller = (Controller) b.newInstance(new Object[]{bundle2});
            } catch (Exception e) {
                throw new RuntimeException("An exception occurred while creating a new instance of " + string + ". " + e.getMessage(), e);
            }
        } else {
            controller = (Controller) m8842a(constructors).newInstance(new Object[0]);
            if (bundle2 != null) {
                controller.f10147p.putAll(bundle2);
            }
        }
        controller.m8848b(bundle);
        return controller;
    }

    protected Controller() {
        this((Bundle) null);
    }

    protected Controller(Bundle bundle) {
        this.f10137J = RetainViewMode.RELEASE_DETACH;
        this.f10139L = new ArrayList();
        this.f10140M = new ArrayList();
        this.f10141N = new ArrayList<>();
        this.f10142O = new ArrayList<>();
        this.f10147p = bundle == null ? new Bundle(getClass().getClassLoader()) : bundle;
        this.f10129B = UUID.randomUUID().toString();
        m8860j();
    }

    public final Router getRouter() {
        return this.f10156y;
    }

    public Bundle getArgs() {
        return this.f10147p;
    }

    public final Router getChildRouter(ViewGroup viewGroup) {
        return getChildRouter(viewGroup, (String) null);
    }

    public final Router getChildRouter(ViewGroup viewGroup, String str) {
        return getChildRouter(viewGroup, str, true);
    }

    public final Router getChildRouter(ViewGroup viewGroup, String str, boolean z) {
        C4255a aVar;
        int id = viewGroup.getId();
        Iterator<C4255a> it = this.f10139L.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (aVar.mo45651f() == id && TextUtils.equals(str, aVar.mo45652g())) {
                break;
            }
        }
        if (aVar == null) {
            if (z) {
                aVar = new C4255a(viewGroup.getId(), str);
                aVar.mo45648a(this, viewGroup);
                this.f10139L.add(aVar);
                if (this.f10144Q) {
                    aVar.mo45649a(true);
                }
            }
        } else if (!aVar.mo45433a()) {
            aVar.mo45648a(this, viewGroup);
            aVar.rebindIfNeeded();
        }
        return aVar;
    }

    public final void removeChildRouter(Router router2) {
        if ((router2 instanceof C4255a) && this.f10139L.remove(router2)) {
            router2.mo45593b(true);
        }
    }

    public final boolean isDestroyed() {
        return this.f10150s;
    }

    public final boolean isBeingDestroyed() {
        return this.f10149r;
    }

    public final boolean isAttached() {
        return this.f10151t;
    }

    public final View getView() {
        return this.f10157z;
    }

    public final Activity getActivity() {
        Router router2 = this.f10156y;
        if (router2 != null) {
            return router2.getActivity();
        }
        return null;
    }

    public final Resources getResources() {
        Activity activity = getActivity();
        if (activity != null) {
            return activity.getResources();
        }
        return null;
    }

    public final Context getApplicationContext() {
        Activity activity = getActivity();
        if (activity != null) {
            return activity.getApplicationContext();
        }
        return null;
    }

    public final Controller getParentController() {
        return this.f10128A;
    }

    public final String getInstanceId() {
        return this.f10129B;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Controller mo45465a(String str) {
        if (this.f10129B.equals(str)) {
            return this;
        }
        for (C4255a controllerWithInstanceId : this.f10139L) {
            Controller controllerWithInstanceId2 = controllerWithInstanceId.getControllerWithInstanceId(str);
            if (controllerWithInstanceId2 != null) {
                return controllerWithInstanceId2;
            }
        }
        return null;
    }

    public final List<Router> getChildRouters() {
        ArrayList arrayList = new ArrayList();
        for (C4255a add : this.f10139L) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public void setTargetController(Controller controller) {
        if (this.f10130C == null) {
            this.f10130C = controller != null ? controller.getInstanceId() : null;
            return;
        }
        throw new RuntimeException("Target controller already set. A controller's target may only be set once.");
    }

    public final Controller getTargetController() {
        if (this.f10130C != null) {
            return this.f10156y.mo45435c().getControllerWithInstanceId(this.f10130C);
        }
        return null;
    }

    public final void startActivity(final Intent intent) {
        mo45475a((RouterRequiringFunc) new RouterRequiringFunc() {
            public void execute() {
                Controller.this.f10156y.mo45426a(intent);
            }
        });
    }

    public final void startActivityForResult(final Intent intent, final int i) {
        mo45475a((RouterRequiringFunc) new RouterRequiringFunc() {
            public void execute() {
                Controller.this.f10156y.mo45429a(Controller.this.f10129B, intent, i);
            }
        });
    }

    public final void startActivityForResult(final Intent intent, final int i, final Bundle bundle) {
        mo45475a((RouterRequiringFunc) new RouterRequiringFunc() {
            public void execute() {
                Controller.this.f10156y.mo45430a(Controller.this.f10129B, intent, i, bundle);
            }
        });
    }

    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        this.f10156y.mo45431a(this.f10129B, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public final void registerForActivityResult(final int i) {
        mo45475a((RouterRequiringFunc) new RouterRequiringFunc() {
            public void execute() {
                Controller.this.f10156y.mo45428a(Controller.this.f10129B, i);
            }
        });
    }

    public final void requestPermissions(final String[] strArr) {
        this.f10141N.addAll(Arrays.asList(strArr));
        mo45475a((RouterRequiringFunc) new RouterRequiringFunc() {
            public void execute() {
                Controller.this.f10156y.mo45432a(Controller.this.f10129B, strArr);
            }
        });
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return Build.VERSION.SDK_INT >= 23 && getActivity().shouldShowRequestPermissionRationale(str);
    }

    public boolean handleBack() {
        ArrayList<RouterTransaction> arrayList = new ArrayList<>();
        for (C4255a backstack : this.f10139L) {
            arrayList.addAll(backstack.getBackstack());
        }
        Collections.sort(arrayList, new Comparator<RouterTransaction>() {
            public int compare(RouterTransaction routerTransaction, RouterTransaction routerTransaction2) {
                return routerTransaction2.f10183b - routerTransaction.f10183b;
            }
        });
        for (RouterTransaction routerTransaction : arrayList) {
            Controller controller = routerTransaction.f10182a;
            if (controller.isAttached() && controller.getRouter().handleBack()) {
                return true;
            }
        }
        return false;
    }

    public final void addLifecycleListener(LifecycleListener lifecycleListener) {
        if (!this.f10140M.contains(lifecycleListener)) {
            this.f10140M.add(lifecycleListener);
        }
    }

    public final void removeLifecycleListener(LifecycleListener lifecycleListener) {
        this.f10140M.remove(lifecycleListener);
    }

    public RetainViewMode getRetainViewMode() {
        return this.f10137J;
    }

    public void setRetainViewMode(RetainViewMode retainViewMode) {
        if (retainViewMode == null) {
            retainViewMode = RetainViewMode.RELEASE_DETACH;
        }
        this.f10137J = retainViewMode;
        if (retainViewMode == RetainViewMode.RELEASE_DETACH && !this.f10151t) {
            m8856f();
        }
    }

    public final ControllerChangeHandler getOverriddenPushHandler() {
        return this.f10135H;
    }

    public void overridePushHandler(ControllerChangeHandler controllerChangeHandler) {
        this.f10135H = controllerChangeHandler;
    }

    public ControllerChangeHandler getOverriddenPopHandler() {
        return this.f10136I;
    }

    public void overridePopHandler(ControllerChangeHandler controllerChangeHandler) {
        this.f10136I = controllerChangeHandler;
    }

    public final void setHasOptionsMenu(boolean z) {
        boolean z2 = this.f10151t && !this.f10153v && this.f10152u != z;
        this.f10152u = z;
        if (z2) {
            this.f10156y.invalidateOptionsMenu();
        }
    }

    public final void setOptionsMenuHidden(boolean z) {
        boolean z2 = this.f10151t && this.f10152u && this.f10153v != z;
        this.f10153v = z;
        if (z2) {
            this.f10156y.invalidateOptionsMenu();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45476a(boolean z) {
        this.f10131D = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45466a() {
        this.f10131D = this.f10131D || this.f10151t;
        for (C4255a h : this.f10139L) {
            h.mo45602h();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo45482b() {
        return this.f10131D;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo45483b(String str) {
        return this.f10141N.contains(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45467a(int i, String[] strArr, int[] iArr) {
        this.f10141N.removeAll(Arrays.asList(strArr));
        onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45474a(Router router2) {
        if (this.f10156y != router2) {
            this.f10156y = router2;
            m8859i();
            Iterator<RouterRequiringFunc> it = this.f10142O.iterator();
            while (it.hasNext()) {
                it.next().execute();
            }
            this.f10142O.clear();
            return;
        }
        m8859i();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo45484c() {
        Activity activity = this.f10156y.getActivity();
        if (activity != null && !this.f10145R) {
            for (LifecycleListener preContextAvailable : new ArrayList(this.f10140M)) {
                preContextAvailable.preContextAvailable(this);
            }
            this.f10145R = true;
            onContextAvailable(activity);
            for (LifecycleListener postContextAvailable : new ArrayList(this.f10140M)) {
                postContextAvailable.postContextAvailable(this, activity);
            }
        }
        for (C4255a onContextAvailable : this.f10139L) {
            onContextAvailable.onContextAvailable();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45475a(RouterRequiringFunc routerRequiringFunc) {
        if (this.f10156y != null) {
            routerRequiringFunc.execute();
        } else {
            this.f10142O.add(routerRequiringFunc);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45468a(Activity activity) {
        ViewAttachHandler viewAttachHandler = this.f10138K;
        if (viewAttachHandler != null) {
            viewAttachHandler.onActivityStarted();
        }
        onActivityStarted(activity);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo45479b(Activity activity) {
        View view;
        if (!this.f10151t && (view = this.f10157z) != null && this.f10154w) {
            m8843a(view);
        } else if (this.f10151t) {
            this.f10131D = false;
            this.f10133F = false;
        }
        onActivityResumed(activity);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo45485c(Activity activity) {
        onActivityPaused(activity);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo45487d(Activity activity) {
        ViewAttachHandler viewAttachHandler = this.f10138K;
        if (viewAttachHandler != null) {
            viewAttachHandler.onActivityStopped();
        }
        onActivityStopped(activity);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo45489e(Activity activity) {
        if (activity.isChangingConfigurations()) {
            mo45471a(this.f10157z, true, false);
        } else {
            m8853c(true);
        }
        if (this.f10145R) {
            for (LifecycleListener preContextUnavailable : new ArrayList(this.f10140M)) {
                preContextUnavailable.preContextUnavailable(this, activity);
            }
            this.f10145R = false;
            onContextUnavailable();
            for (LifecycleListener postContextUnavailable : new ArrayList(this.f10140M)) {
                postContextUnavailable.postContextUnavailable(this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8843a(View view) {
        boolean z = this.f10156y == null || view.getParent() != this.f10156y.f10169d;
        this.f10132E = z;
        if (!z) {
            this.f10133F = false;
            for (LifecycleListener preAttach : new ArrayList(this.f10140M)) {
                preAttach.preAttach(this, view);
            }
            this.f10151t = true;
            this.f10131D = false;
            onAttach(view);
            if (this.f10152u && !this.f10153v) {
                this.f10156y.invalidateOptionsMenu();
            }
            for (LifecycleListener postAttach : new ArrayList(this.f10140M)) {
                postAttach.postAttach(this, view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45471a(View view, boolean z, boolean z2) {
        if (!this.f10132E) {
            for (C4255a h : this.f10139L) {
                h.mo45602h();
            }
        }
        boolean z3 = !z2 && (z || this.f10137J == RetainViewMode.RELEASE_DETACH || this.f10149r);
        if (this.f10151t) {
            for (LifecycleListener preDetach : new ArrayList(this.f10140M)) {
                preDetach.preDetach(this, view);
            }
            this.f10151t = false;
            onDetach(view);
            if (this.f10152u && !this.f10153v) {
                this.f10156y.invalidateOptionsMenu();
            }
            for (LifecycleListener postDetach : new ArrayList(this.f10140M)) {
                postDetach.postDetach(this, view);
            }
        }
        if (z3) {
            m8856f();
        }
    }

    /* renamed from: f */
    private void m8856f() {
        View view = this.f10157z;
        if (view != null) {
            if (!this.f10149r && !this.f10133F) {
                m8849b(view);
            }
            for (LifecycleListener preDestroyView : new ArrayList(this.f10140M)) {
                preDestroyView.preDestroyView(this, this.f10157z);
            }
            onDestroyView(this.f10157z);
            ViewAttachHandler viewAttachHandler = this.f10138K;
            if (viewAttachHandler != null) {
                viewAttachHandler.unregisterAttachListener(this.f10157z);
            }
            this.f10138K = null;
            this.f10154w = false;
            if (this.f10149r) {
                this.f10143P = new WeakReference<>(this.f10157z);
            }
            for (LifecycleListener postDestroyView : new ArrayList(this.f10140M)) {
                postDestroyView.postDestroyView(this);
            }
            this.f10157z = null;
            for (C4255a e : this.f10139L) {
                e.mo45650e();
            }
        }
        if (this.f10149r) {
            m8858h();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final View mo45464a(ViewGroup viewGroup) {
        View view = this.f10157z;
        if (!(view == null || view.getParent() == null || this.f10157z.getParent() == viewGroup)) {
            mo45471a(this.f10157z, true, false);
            m8856f();
        }
        if (this.f10157z == null) {
            for (LifecycleListener preCreateView : new ArrayList(this.f10140M)) {
                preCreateView.preCreateView(this);
            }
            View onCreateView = onCreateView(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            this.f10157z = onCreateView;
            if (onCreateView != viewGroup) {
                for (LifecycleListener postCreateView : new ArrayList(this.f10140M)) {
                    postCreateView.postCreateView(this, this.f10157z);
                }
                View view2 = this.f10157z;
                if (view2 == null) {
                    return view2;
                }
                m8852c(view2);
                ViewAttachHandler viewAttachHandler = new ViewAttachHandler(new ViewAttachHandler.ViewAttachListener() {
                    public void onAttached() {
                        boolean unused = Controller.this.f10154w = true;
                        boolean unused2 = Controller.this.f10155x = false;
                        Controller controller = Controller.this;
                        controller.m8843a(controller.f10157z);
                    }

                    public void onDetached(boolean z) {
                        boolean unused = Controller.this.f10154w = false;
                        boolean unused2 = Controller.this.f10155x = true;
                        if (!Controller.this.f10134G) {
                            Controller controller = Controller.this;
                            controller.mo45471a(controller.f10157z, false, z);
                        }
                    }

                    public void onViewDetachAfterStop() {
                        if (!Controller.this.f10134G) {
                            Controller controller = Controller.this;
                            controller.mo45471a(controller.f10157z, false, false);
                        }
                    }
                });
                this.f10138K = viewAttachHandler;
                viewAttachHandler.listenForAttach(this.f10157z);
            } else {
                throw new IllegalStateException("Controller's onCreateView method returned the parent ViewGroup. Perhaps you forgot to pass false for LayoutInflater.inflate's attachToRoot parameter?");
            }
        } else if (this.f10137J == RetainViewMode.RETAIN_DETACH) {
            m8857g();
        }
        return this.f10157z;
    }

    /* renamed from: g */
    private void m8857g() {
        View findViewById;
        for (C4255a next : this.f10139L) {
            if (!next.mo45433a() && (findViewById = this.f10157z.findViewById(next.mo45651f())) != null && (findViewById instanceof ViewGroup)) {
                next.mo45648a(this, (ViewGroup) findViewById);
                next.rebindIfNeeded();
            }
        }
    }

    /* renamed from: h */
    private void m8858h() {
        if (this.f10145R) {
            for (LifecycleListener preContextUnavailable : new ArrayList(this.f10140M)) {
                preContextUnavailable.preContextUnavailable(this, getActivity());
            }
            this.f10145R = false;
            onContextUnavailable();
            for (LifecycleListener postContextUnavailable : new ArrayList(this.f10140M)) {
                postContextUnavailable.postContextUnavailable(this);
            }
        }
        if (!this.f10150s) {
            for (LifecycleListener preDestroy : new ArrayList(this.f10140M)) {
                preDestroy.preDestroy(this);
            }
            this.f10150s = true;
            onDestroy();
            this.f10128A = null;
            for (LifecycleListener postDestroy : new ArrayList(this.f10140M)) {
                postDestroy.postDestroy(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo45486d() {
        m8853c(false);
    }

    /* renamed from: c */
    private void m8853c(boolean z) {
        this.f10149r = true;
        Router router2 = this.f10156y;
        if (router2 != null) {
            router2.mo45427a(this.f10129B);
        }
        for (C4255a b : this.f10139L) {
            b.mo45593b(false);
        }
        if (!this.f10151t) {
            m8856f();
        } else if (z) {
            mo45471a(this.f10157z, true, false);
        }
    }

    /* renamed from: b */
    private void m8849b(View view) {
        this.f10133F = true;
        this.f10146b = new Bundle(getClass().getClassLoader());
        SparseArray sparseArray = new SparseArray();
        view.saveHierarchyState(sparseArray);
        this.f10146b.putSparseParcelableArray(f10126n, sparseArray);
        Bundle bundle = new Bundle(getClass().getClassLoader());
        onSaveViewState(view, bundle);
        this.f10146b.putBundle(f10114a, bundle);
        for (LifecycleListener onSaveViewState : new ArrayList(this.f10140M)) {
            onSaveViewState.onSaveViewState(this, this.f10146b);
        }
    }

    /* renamed from: c */
    private void m8852c(View view) {
        Bundle bundle = this.f10146b;
        if (bundle != null) {
            view.restoreHierarchyState(bundle.getSparseParcelableArray(f10126n));
            Bundle bundle2 = this.f10146b.getBundle(f10114a);
            bundle2.setClassLoader(getClass().getClassLoader());
            onRestoreViewState(view, bundle2);
            m8857g();
            for (LifecycleListener onRestoreViewState : new ArrayList(this.f10140M)) {
                onRestoreViewState.onRestoreViewState(this, this.f10146b);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final Bundle mo45488e() {
        View view;
        if (!this.f10133F && (view = this.f10157z) != null) {
            m8849b(view);
        }
        Bundle bundle = new Bundle();
        bundle.putString(f10115c, getClass().getName());
        bundle.putBundle(f10116d, this.f10146b);
        bundle.putBundle(f10121i, this.f10147p);
        bundle.putString(f10119g, this.f10129B);
        bundle.putString(f10120h, this.f10130C);
        bundle.putStringArrayList(f10123k, this.f10141N);
        bundle.putBoolean(f10122j, this.f10131D || this.f10151t);
        bundle.putInt(f10127o, this.f10137J.ordinal());
        ControllerChangeHandler controllerChangeHandler = this.f10135H;
        if (controllerChangeHandler != null) {
            bundle.putBundle(f10124l, controllerChangeHandler.mo45576a());
        }
        ControllerChangeHandler controllerChangeHandler2 = this.f10136I;
        if (controllerChangeHandler2 != null) {
            bundle.putBundle(f10125m, controllerChangeHandler2.mo45576a());
        }
        ArrayList arrayList = new ArrayList();
        for (C4255a saveInstanceState : this.f10139L) {
            Bundle bundle2 = new Bundle();
            saveInstanceState.saveInstanceState(bundle2);
            arrayList.add(bundle2);
        }
        bundle.putParcelableArrayList(f10117e, arrayList);
        Bundle bundle3 = new Bundle(getClass().getClassLoader());
        onSaveInstanceState(bundle3);
        for (LifecycleListener onSaveInstanceState : new ArrayList(this.f10140M)) {
            onSaveInstanceState.onSaveInstanceState(this, bundle3);
        }
        bundle.putBundle(f10118f, bundle3);
        return bundle;
    }

    /* renamed from: b */
    private void m8848b(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(f10116d);
        this.f10146b = bundle2;
        if (bundle2 != null) {
            bundle2.setClassLoader(getClass().getClassLoader());
        }
        this.f10129B = bundle.getString(f10119g);
        this.f10130C = bundle.getString(f10120h);
        this.f10141N.addAll(bundle.getStringArrayList(f10123k));
        this.f10135H = ControllerChangeHandler.fromBundle(bundle.getBundle(f10124l));
        this.f10136I = ControllerChangeHandler.fromBundle(bundle.getBundle(f10125m));
        this.f10131D = bundle.getBoolean(f10122j);
        this.f10137J = RetainViewMode.values()[bundle.getInt(f10127o, 0)];
        for (Bundle restoreInstanceState : bundle.getParcelableArrayList(f10117e)) {
            C4255a aVar = new C4255a();
            aVar.restoreInstanceState(restoreInstanceState);
            this.f10139L.add(aVar);
        }
        Bundle bundle3 = bundle.getBundle(f10118f);
        this.f10148q = bundle3;
        if (bundle3 != null) {
            bundle3.setClassLoader(getClass().getClassLoader());
        }
        m8859i();
    }

    /* renamed from: i */
    private void m8859i() {
        Bundle bundle = this.f10148q;
        if (bundle != null && this.f10156y != null) {
            onRestoreInstanceState(bundle);
            for (LifecycleListener onRestoreInstanceState : new ArrayList(this.f10140M)) {
                onRestoreInstanceState.onRestoreInstanceState(this, this.f10148q);
            }
            this.f10148q = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45473a(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        if (!controllerChangeType.isEnter) {
            this.f10144Q = true;
            for (C4255a a : this.f10139L) {
                a.mo45649a(true);
            }
        }
        onChangeStarted(controllerChangeHandler, controllerChangeType);
        for (LifecycleListener onChangeStart : new ArrayList(this.f10140M)) {
            onChangeStart.onChangeStart(this, controllerChangeHandler, controllerChangeType);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo45480b(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        WeakReference<View> weakReference;
        if (!controllerChangeType.isEnter) {
            this.f10144Q = false;
            for (C4255a a : this.f10139L) {
                a.mo45649a(false);
            }
        }
        onChangeEnded(controllerChangeHandler, controllerChangeType);
        for (LifecycleListener onChangeEnd : new ArrayList(this.f10140M)) {
            onChangeEnd.onChangeEnd(this, controllerChangeHandler, controllerChangeType);
        }
        if (this.f10149r && !this.f10154w && !this.f10151t && (weakReference = this.f10143P) != null) {
            View view = (View) weakReference.get();
            if (!(this.f10156y.f10169d == null || view == null || view.getParent() != this.f10156y.f10169d)) {
                this.f10156y.f10169d.removeView(view);
            }
            this.f10143P = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo45481b(boolean z) {
        View view;
        if (this.f10134G != z) {
            this.f10134G = z;
            for (C4255a a : this.f10139L) {
                a.mo45649a(z);
            }
            if (!z && (view = this.f10157z) != null && this.f10155x) {
                mo45471a(view, false, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45470a(Menu menu, MenuInflater menuInflater) {
        if (this.f10151t && this.f10152u && !this.f10153v) {
            onCreateOptionsMenu(menu, menuInflater);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45469a(Menu menu) {
        if (this.f10151t && this.f10152u && !this.f10153v) {
            onPrepareOptionsMenu(menu);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo45477a(MenuItem menuItem) {
        return this.f10151t && this.f10152u && !this.f10153v && onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45472a(Controller controller) {
        this.f10128A = controller;
    }

    /* renamed from: j */
    private void m8860j() {
        Constructor[] constructors = getClass().getConstructors();
        if (m8847b(constructors) == null && m8842a(constructors) == null) {
            throw new RuntimeException(getClass() + " does not have a constructor that takes a Bundle argument or a default constructor. Controllers must have one of these in order to restore their states.");
        }
    }

    /* renamed from: a */
    private static Constructor m8842a(Constructor[] constructorArr) {
        for (Constructor constructor : constructorArr) {
            if (constructor.getParameterTypes().length == 0) {
                return constructor;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static Constructor m8847b(Constructor[] constructorArr) {
        for (Constructor constructor : constructorArr) {
            if (constructor.getParameterTypes().length == 1 && constructor.getParameterTypes()[0] == Bundle.class) {
                return constructor;
            }
        }
        return null;
    }
}
