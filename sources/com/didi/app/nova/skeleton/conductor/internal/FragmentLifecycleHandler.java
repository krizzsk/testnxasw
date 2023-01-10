package com.didi.app.nova.skeleton.conductor.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.didi.app.nova.skeleton.conductor.ActivityHostedRouter;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.Router;
import com.didi.app.nova.skeleton.conductor.embed.FragmentLifecycle;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didichuxing.sofa.permission.PermissionHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FragmentLifecycleHandler implements Application.ActivityLifecycleCallbacks, FragmentLifecycle {

    /* renamed from: a */
    private static final String f10223a = "FragmentLifecycleHandler";

    /* renamed from: b */
    private static final String f10224b = "LifecycleHandler.pendingPermissionRequests";

    /* renamed from: c */
    private static final String f10225c = "LifecycleHandler.permissionRequests";

    /* renamed from: d */
    private static final String f10226d = "LifecycleHandler.activityRequests";

    /* renamed from: e */
    private static final String f10227e = "LifecycleHandler.routerState";

    /* renamed from: j */
    private static final Map<Fragment, FragmentLifecycleHandler> f10228j = new HashMap();

    /* renamed from: f */
    private Activity f10229f;

    /* renamed from: g */
    private boolean f10230g;

    /* renamed from: h */
    private boolean f10231h;

    /* renamed from: i */
    private boolean f10232i;

    /* renamed from: k */
    private SparseArray<String> f10233k = new SparseArray<>();

    /* renamed from: l */
    private SparseArray<String> f10234l = new SparseArray<>();

    /* renamed from: m */
    private ArrayList<PendingPermissionRequest> f10235m = new ArrayList<>();

    /* renamed from: n */
    private final Map<Integer, ActivityHostedRouter> f10236n = new HashMap();

    /* renamed from: o */
    private Fragment f10237o;

    /* renamed from: p */
    private C4274a f10238p;

    public FragmentLifecycleHandler(Fragment fragment) {
        this.f10237o = fragment;
        fragment.setRetainInstance(true);
        this.f10237o.setHasOptionsMenu(true);
    }

    public static FragmentLifecycle install(Fragment fragment) {
        FragmentLifecycleHandler fragmentLifecycleHandler = f10228j.get(fragment);
        if (fragmentLifecycleHandler == null) {
            fragmentLifecycleHandler = new FragmentLifecycleHandler(fragment);
            fragmentLifecycleHandler.f10229f = fragment.getActivity();
            fragmentLifecycleHandler.f10238p = new C4274a(fragmentLifecycleHandler);
            fragment.getFragmentManager().registerFragmentLifecycleCallbacks(fragmentLifecycleHandler.f10238p, false);
            f10228j.put(fragment, fragmentLifecycleHandler);
        }
        TraceUtil.trace(f10223a, "install(" + fragment + ")");
        return fragmentLifecycleHandler;
    }

    public static Router getFragmentRouter(Fragment fragment, ViewGroup viewGroup, Bundle bundle) {
        FragmentLifecycleHandler fragmentLifecycleHandler = f10228j.get(fragment);
        if (fragmentLifecycleHandler == null) {
            return null;
        }
        return fragmentLifecycleHandler.getRouter(viewGroup, bundle);
    }

    public Router getRouter(ViewGroup viewGroup, Bundle bundle) {
        ActivityHostedRouter activityHostedRouter = this.f10236n.get(Integer.valueOf(m8983a(viewGroup)));
        if (activityHostedRouter == null) {
            activityHostedRouter = new ActivityHostedRouter();
            activityHostedRouter.setHost(this, viewGroup);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle(f10227e + activityHostedRouter.getContainerId());
                if (bundle2 != null) {
                    activityHostedRouter.restoreInstanceState(bundle2);
                }
            }
            this.f10236n.put(Integer.valueOf(m8983a(viewGroup)), activityHostedRouter);
        } else {
            activityHostedRouter.setHost(this, viewGroup);
        }
        return activityHostedRouter;
    }

    public List<Router> getRouters() {
        return new ArrayList(this.f10236n.values());
    }

    public Activity getLifecycleActivity() {
        return this.f10229f;
    }

    /* renamed from: a */
    private static int m8983a(ViewGroup viewGroup) {
        return viewGroup.getId();
    }

    public boolean registerActivityListener(Activity activity) {
        this.f10229f = activity;
        if (this.f10230g) {
            return false;
        }
        this.f10230g = true;
        activity.getApplication().registerActivityLifecycleCallbacks(this);
        return true;
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            StringSparseArrayParceler stringSparseArrayParceler = (StringSparseArrayParceler) bundle.getParcelable(f10225c);
            this.f10233k = stringSparseArrayParceler != null ? stringSparseArrayParceler.getStringSparseArray() : new SparseArray<>();
            StringSparseArrayParceler stringSparseArrayParceler2 = (StringSparseArrayParceler) bundle.getParcelable(f10226d);
            this.f10234l = stringSparseArrayParceler2 != null ? stringSparseArrayParceler2.getStringSparseArray() : new SparseArray<>();
            ArrayList<PendingPermissionRequest> parcelableArrayList = bundle.getParcelableArrayList(f10224b);
            if (parcelableArrayList == null) {
                parcelableArrayList = new ArrayList<>();
            }
            this.f10235m = parcelableArrayList;
        }
        TraceUtil.trace(f10223a, NachoLifecycleManager.LIFECYCLE_ON_CREATE);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable(f10225c, new StringSparseArrayParceler(this.f10233k));
        bundle.putParcelable(f10226d, new StringSparseArrayParceler(this.f10234l));
        bundle.putParcelableArrayList(f10224b, this.f10235m);
        TraceUtil.trace(f10223a, "onSaveInstanceState");
    }

    public void onDestroy() {
        Activity activity = this.f10229f;
        if (activity != null) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            m8985b();
            this.f10229f = null;
        }
        TraceUtil.trace(f10223a, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
    }

    public void onAttach(Context context) {
        this.f10231h = false;
        m8984a();
        TraceUtil.trace(f10223a, "onAttach");
    }

    public void onDetach() {
        this.f10232i = false;
        m8985b();
        getFragmentManager().unregisterFragmentLifecycleCallbacks(this.f10238p);
        f10228j.remove(this.f10237o);
        TraceUtil.trace(f10223a, "onDetach");
    }

    /* renamed from: a */
    private void m8984a() {
        if (!this.f10232i) {
            this.f10232i = true;
            for (int size = this.f10235m.size() - 1; size >= 0; size--) {
                PendingPermissionRequest remove = this.f10235m.remove(size);
                requestPermissions(remove.instanceId, remove.permissions);
            }
        }
        for (ActivityHostedRouter onContextAvailable : this.f10236n.values()) {
            onContextAvailable.onContextAvailable();
        }
    }

    /* renamed from: b */
    private void m8985b() {
        if (!this.f10231h) {
            this.f10231h = true;
            if (this.f10229f != null) {
                for (ActivityHostedRouter onActivityDestroyed : this.f10236n.values()) {
                    onActivityDestroyed.onActivityDestroyed(this.f10229f);
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        String str = this.f10234l.get(i);
        if (str != null) {
            for (ActivityHostedRouter onActivityResult : this.f10236n.values()) {
                onActivityResult.onActivityResult(str, i, i2, intent);
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        String str = this.f10233k.get(i);
        if (str != null) {
            for (ActivityHostedRouter controllerWithInstanceId : this.f10236n.values()) {
                Controller controllerWithInstanceId2 = controllerWithInstanceId.getControllerWithInstanceId(str);
                if (controllerWithInstanceId2 != null) {
                    PermissionHelper.onRequestPermissionsResult(this.f10237o, (Object) controllerWithInstanceId2, i, strArr, iArr);
                }
            }
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        for (ActivityHostedRouter handleRequestedPermission : this.f10236n.values()) {
            Boolean handleRequestedPermission2 = handleRequestedPermission.handleRequestedPermission(str);
            if (handleRequestedPermission2 != null) {
                return handleRequestedPermission2.booleanValue();
            }
        }
        return false;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        for (ActivityHostedRouter onCreateOptionsMenu : this.f10236n.values()) {
            onCreateOptionsMenu.onCreateOptionsMenu(menu, menuInflater);
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        for (ActivityHostedRouter onPrepareOptionsMenu : this.f10236n.values()) {
            onPrepareOptionsMenu.onPrepareOptionsMenu(menu);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        for (ActivityHostedRouter onOptionsItemSelected : this.f10236n.values()) {
            if (onOptionsItemSelected.onOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void registerForActivityResult(String str, int i) {
        this.f10234l.put(i, str);
    }

    public void unregisterForActivityResults(String str) {
        for (int size = this.f10234l.size() - 1; size >= 0; size--) {
            SparseArray<String> sparseArray = this.f10234l;
            if (str.equals(sparseArray.get(sparseArray.keyAt(size)))) {
                this.f10234l.removeAt(size);
            }
        }
    }

    public void startActivityForResult(String str, Intent intent, int i) {
        registerForActivityResult(str, i);
        this.f10237o.startActivityForResult(intent, i);
    }

    public void startActivityForResult(String str, Intent intent, int i, Bundle bundle) {
        registerForActivityResult(str, i);
        this.f10237o.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(String str, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        String str2 = str;
        registerForActivityResult(str, i);
        this.f10237o.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void requestPermissions(String str, String[] strArr) {
        int generateRequestCode = PermissionHelper.generateRequestCode(strArr);
        if (this.f10232i) {
            this.f10233k.put(generateRequestCode, str);
            for (ActivityHostedRouter controllerWithInstanceId : this.f10236n.values()) {
                Controller controllerWithInstanceId2 = controllerWithInstanceId.getControllerWithInstanceId(str);
                if (controllerWithInstanceId2 != null) {
                    PermissionHelper.requestPermission(this.f10237o, (Object) controllerWithInstanceId2, strArr);
                }
            }
            return;
        }
        this.f10235m.add(new PendingPermissionRequest(str, strArr, generateRequestCode));
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f10229f == null) {
            this.f10229f = activity;
            for (ActivityHostedRouter onContextAvailable : this.f10236n.values()) {
                onContextAvailable.onContextAvailable();
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        if (this.f10229f == activity) {
            for (ActivityHostedRouter onActivityStarted : this.f10236n.values()) {
                onActivityStarted.onActivityStarted(activity);
            }
        }
    }

    public void onActivityResumed(Activity activity) {
        if (this.f10229f == activity) {
            for (ActivityHostedRouter onActivityResumed : this.f10236n.values()) {
                onActivityResumed.onActivityResumed(activity);
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        if (this.f10229f == activity) {
            for (ActivityHostedRouter onActivityPaused : this.f10236n.values()) {
                onActivityPaused.onActivityPaused(activity);
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        if (this.f10229f == activity) {
            for (ActivityHostedRouter onActivityStopped : this.f10236n.values()) {
                onActivityStopped.onActivityStopped(activity);
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (this.f10229f == activity) {
            for (Router next : this.f10236n.values()) {
                Bundle bundle2 = new Bundle();
                next.saveInstanceState(bundle2);
                bundle.putBundle(f10227e + next.getContainerId(), bundle2);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity == this.f10229f) {
            f10228j.remove(this);
        }
    }

    public void startActivity(Intent intent) {
        this.f10237o.startActivity(intent);
    }

    public FragmentManager getFragmentManager() {
        return this.f10237o.getFragmentManager();
    }

    public Fragment getAttachedFragment() {
        return this.f10237o;
    }

    private static class PendingPermissionRequest implements Parcelable {
        public static final Parcelable.Creator<PendingPermissionRequest> CREATOR = new Parcelable.Creator<PendingPermissionRequest>() {
            public PendingPermissionRequest createFromParcel(Parcel parcel) {
                return new PendingPermissionRequest(parcel);
            }

            public PendingPermissionRequest[] newArray(int i) {
                return new PendingPermissionRequest[i];
            }
        };
        final String instanceId;
        final String[] permissions;
        final int requestCode;

        public int describeContents() {
            return 0;
        }

        PendingPermissionRequest(String str, String[] strArr, int i) {
            this.instanceId = str;
            this.permissions = strArr;
            this.requestCode = i;
        }

        private PendingPermissionRequest(Parcel parcel) {
            this.instanceId = parcel.readString();
            this.permissions = parcel.createStringArray();
            this.requestCode = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.instanceId);
            parcel.writeStringArray(this.permissions);
            parcel.writeInt(this.requestCode);
        }
    }
}
