package com.didi.sdk.app;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

public class BusinessContextHelper implements KeyEvent.Callback {
    public static final String TAG = "BusinessContextHelper";

    /* renamed from: a */
    private static final Logger f37901a = LoggerFactory.getLogger(TAG);
    @Deprecated

    /* renamed from: b */
    private static final String f37902b = "PAGE_URI";

    /* renamed from: c */
    private static Logger f37903c = LoggerFactory.getLogger(TAG);

    /* renamed from: d */
    private ReceiverDelegateManager f37904d;

    /* renamed from: e */
    private FragmentActivity f37905e;

    /* renamed from: f */
    private FragmentManager f37906f;

    /* renamed from: g */
    private NavigationImpl f37907g;

    /* renamed from: h */
    private HashMap<String, BaseBusinessContext> f37908h = new HashMap<>();

    /* renamed from: i */
    private int f37909i;

    /* renamed from: j */
    private Class<? extends BaseBusinessContext> f37910j;

    /* renamed from: k */
    private ITitleBarDelegate f37911k;

    /* renamed from: l */
    private IStatusBarDelegate f37912l;

    /* renamed from: m */
    private IBizNavBarDelegate f37913m;

    /* renamed from: n */
    private INavigationListener f37914n;

    /* renamed from: o */
    private IBusinessContextChangedListener f37915o;

    /* renamed from: p */
    private OnBackResultListener f37916p;

    public Class<? extends BaseBusinessContext> getBusinessContextImpl() {
        return this.f37910j;
    }

    public BusinessContextHelper(FragmentActivity fragmentActivity, ITitleBarDelegate iTitleBarDelegate, IStatusBarDelegate iStatusBarDelegate, IBizNavBarDelegate iBizNavBarDelegate, Class<? extends BaseBusinessContext> cls, int i, Map<Integer, Class<? extends Fragment>> map) {
        this.f37905e = fragmentActivity;
        this.f37906f = fragmentActivity.getSupportFragmentManager();
        this.f37911k = iTitleBarDelegate;
        this.f37912l = iStatusBarDelegate;
        this.f37913m = iBizNavBarDelegate;
        this.f37904d = new ReceiverDelegateManager(this);
        this.f37909i = i;
        this.f37910j = cls;
        this.f37907g = new NavigationImpl(this.f37906f, i, iStatusBarDelegate, map);
    }

    public void addListeners(IBusinessContextChangedListener iBusinessContextChangedListener) {
        BusinessContextManager.getInstance().mo97017a(iBusinessContextChangedListener);
        this.f37915o = iBusinessContextChangedListener;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Fragment currentFragment = this.f37907g.getCurrentFragment(this.f37905e.getSupportFragmentManager());
        if (currentFragment != null) {
            currentFragment.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public <T extends BaseBusinessContext> T getBusinessContext(String str, Class<? extends BaseBusinessContext> cls) {
        T t = (BaseBusinessContext) this.f37908h.get(str);
        if (t != null) {
            return t;
        }
        try {
            t = (BaseBusinessContext) cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        t.assemble(this.f37905e, this.f37907g, this.f37911k, this.f37912l, this.f37913m);
        this.f37908h.put(str, t);
        return t;
    }

    public <T extends BaseBusinessContext> T getBusinessContext(Uri uri) {
        return getBusinessContext(uri.getHost(), this.f37910j);
    }

    public void onResume() {
        NavigationImpl navigationImpl = this.f37907g;
        if (navigationImpl != null) {
            navigationImpl.onResume();
        }
    }

    public void onPause() {
        NavigationImpl navigationImpl = this.f37907g;
        if (navigationImpl != null) {
            navigationImpl.onPause();
        }
    }

    public void setOnBackResultListener(OnBackResultListener onBackResultListener) {
        NavigationImpl navigationImpl = this.f37907g;
        if (navigationImpl != null) {
            navigationImpl.setOnBackResultListener(onBackResultListener);
            this.f37916p = onBackResultListener;
        }
    }

    public void safePost(Runnable runnable) {
        NavigationImpl navigationImpl = this.f37907g;
        if (navigationImpl != null) {
            navigationImpl.safePost(runnable);
        }
    }

    public void setNavigationListener(INavigationListener iNavigationListener) {
        NavigationImpl navigationImpl = this.f37907g;
        if (navigationImpl != null) {
            navigationImpl.setNavigationListener(iNavigationListener);
            this.f37914n = iNavigationListener;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NavigationImpl navigationImpl = this.f37907g;
        if (navigationImpl != null) {
            return navigationImpl.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NavigationImpl navigationImpl = this.f37907g;
        if (navigationImpl != null) {
            return navigationImpl.onKeyUp(i, keyEvent);
        }
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        NavigationImpl navigationImpl = this.f37907g;
        if (navigationImpl != null) {
            return navigationImpl.onKeyLongPress(i, keyEvent);
        }
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        NavigationImpl navigationImpl = this.f37907g;
        if (navigationImpl != null) {
            return navigationImpl.onKeyMultiple(i, i2, keyEvent);
        }
        return false;
    }

    public void transition(BaseBusinessContext baseBusinessContext, Intent intent) {
        NavigationImpl navigationImpl = this.f37907g;
        if (navigationImpl != null) {
            navigationImpl.transition(baseBusinessContext, intent);
        }
    }

    public Fragment matchPage(BaseBusinessContext baseBusinessContext, Intent intent) {
        return this.f37907g.matchPage(baseBusinessContext, intent);
    }

    public void registerStaticReceivers(Class<? extends AbsDidiBroadcastReceiver> cls) {
        this.f37904d.loadDelegates(cls);
    }

    public void removeStaticReceivers() {
        this.f37904d.unloadDelegates();
    }

    public void showDialog(DialogFragment dialogFragment) {
        NavigationImpl navigationImpl = this.f37907g;
        if (navigationImpl != null) {
            navigationImpl.showDialog(dialogFragment);
        }
    }

    public void dismissDialog(DialogFragment dialogFragment) {
        NavigationImpl navigationImpl = this.f37907g;
        if (navigationImpl != null) {
            navigationImpl.dismissDialog(dialogFragment);
        }
    }

    public void popBackStack(int i) {
        this.f37907g.popBackStack(i);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: a */
    public void mo96994a() {
        try {
            Bundle bundle = SystemUtils.getApplicationInfo(this.f37905e.getPackageManager(), this.f37905e.getPackageName(), 128).metaData;
            for (String str : bundle.keySet()) {
                if (str.startsWith(f37902b)) {
                    m28567a(bundle.getString(str));
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            f37903c.error("", (Throwable) e);
        }
    }

    @Deprecated
    /* renamed from: a */
    private void m28567a(String str) {
        String str2;
        IntentFilter intentFilter = new IntentFilter();
        try {
            String[] split = str.split(";");
            int indexOf = split[0].indexOf(58);
            intentFilter.addDataScheme(split[0].substring(0, indexOf));
            int i = indexOf + 3;
            int indexOf2 = split[0].indexOf(47, i);
            if (indexOf2 == -1) {
                str2 = split[0].substring(i);
            } else {
                String substring = split[0].substring(i, indexOf2);
                intentFilter.addDataPath(split[0].substring(indexOf2), 1);
                str2 = substring;
            }
            intentFilter.addDataAuthority(str2, (String) null);
            this.f37907g.registerFilter(intentFilter, Class.forName(split[1]));
        } catch (Exception e) {
            f37903c.error("", (Throwable) e);
        }
    }
}
