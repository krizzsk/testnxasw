package com.didi.dimina.container.p065ui.statusbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.dimina.container.ui.statusbar.RequestManagerRetriever */
class RequestManagerRetriever implements Handler.Callback {

    /* renamed from: c */
    private static final int f19616c = 1;

    /* renamed from: d */
    private static final int f19617d = 2;

    /* renamed from: a */
    private final String f19618a;

    /* renamed from: b */
    private final Handler f19619b;

    /* renamed from: e */
    private final Map<FragmentManager, RequestManagerFragment> f19620e;

    /* renamed from: f */
    private final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f19621f;

    /* renamed from: com.didi.dimina.container.ui.statusbar.RequestManagerRetriever$Holder */
    private static class Holder {
        /* access modifiers changed from: private */
        public static final RequestManagerRetriever INSTANCE = new RequestManagerRetriever();

        private Holder() {
        }
    }

    /* renamed from: a */
    static RequestManagerRetriever m16679a() {
        return Holder.INSTANCE;
    }

    private RequestManagerRetriever() {
        this.f19618a = ImmersionBar.class.getName();
        this.f19620e = new HashMap();
        this.f19621f = new HashMap();
        this.f19619b = new Handler(Looper.getMainLooper(), this);
    }

    /* renamed from: a */
    public ImmersionBar mo61626a(Activity activity) {
        m16682a(activity, "activity is null");
        String str = this.f19618a + System.identityHashCode(activity);
        if (activity instanceof FragmentActivity) {
            return m16680a(((FragmentActivity) activity).getSupportFragmentManager(), str).get(activity);
        }
        return m16677a(activity.getFragmentManager(), str).get(activity);
    }

    /* renamed from: a */
    public ImmersionBar mo61629a(Fragment fragment, boolean z) {
        String str;
        m16682a(fragment, "fragment is null");
        m16682a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            m16682a(((DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str2 = this.f19618a;
        if (z) {
            str = str2 + fragment.getClass().getName();
        } else {
            str = str2 + System.identityHashCode(fragment);
        }
        return m16680a(fragment.getChildFragmentManager(), str).get(fragment);
    }

    /* renamed from: a */
    public ImmersionBar mo61628a(android.app.Fragment fragment, boolean z) {
        String str;
        m16682a(fragment, "fragment is null");
        m16682a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof android.app.DialogFragment) {
            m16682a(((android.app.DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str2 = this.f19618a;
        if (z) {
            str = str2 + fragment.getClass().getName();
        } else {
            str = str2 + System.identityHashCode(fragment);
        }
        return m16677a(fragment.getChildFragmentManager(), str).get(fragment);
    }

    /* renamed from: a */
    public ImmersionBar mo61627a(Activity activity, Dialog dialog) {
        m16682a(activity, "activity is null");
        m16682a(dialog, "dialog is null");
        String str = this.f19618a + System.identityHashCode(dialog);
        if (activity instanceof FragmentActivity) {
            return m16680a(((FragmentActivity) activity).getSupportFragmentManager(), str).get(activity, dialog);
        }
        return m16677a(activity.getFragmentManager(), str).get(activity, dialog);
    }

    /* renamed from: b */
    public void mo61631b(Fragment fragment, boolean z) {
        String str;
        if (fragment != null) {
            String str2 = this.f19618a;
            if (z) {
                str = str2 + fragment.getClass().getName();
            } else {
                str = str2 + System.identityHashCode(fragment);
            }
            m16681a(fragment.getChildFragmentManager(), str, true);
        }
    }

    /* renamed from: b */
    public void mo61630b(Activity activity, Dialog dialog) {
        if (activity != null && dialog != null) {
            String str = this.f19618a + System.identityHashCode(dialog);
            if (activity instanceof FragmentActivity) {
                SupportRequestManagerFragment a = m16681a(((FragmentActivity) activity).getSupportFragmentManager(), str, true);
                if (a != null) {
                    a.get(activity, dialog).mo61492a();
                    return;
                }
                return;
            }
            RequestManagerFragment a2 = m16678a(activity.getFragmentManager(), str, true);
            if (a2 != null) {
                a2.get(activity, dialog).mo61492a();
            }
        }
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.f19620e.remove((FragmentManager) message.obj);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.f19621f.remove((androidx.fragment.app.FragmentManager) message.obj);
            return true;
        }
    }

    /* renamed from: a */
    private RequestManagerFragment m16677a(FragmentManager fragmentManager, String str) {
        return m16678a(fragmentManager, str, false);
    }

    /* renamed from: a */
    private RequestManagerFragment m16678a(FragmentManager fragmentManager, String str, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (requestManagerFragment == null && (requestManagerFragment = this.f19620e.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            requestManagerFragment = new RequestManagerFragment();
            this.f19620e.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, str).commitAllowingStateLoss();
            this.f19619b.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (!z) {
            return requestManagerFragment;
        }
        fragmentManager.beginTransaction().remove(requestManagerFragment).commitAllowingStateLoss();
        return null;
    }

    /* renamed from: a */
    private SupportRequestManagerFragment m16680a(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        return m16681a(fragmentManager, str, false);
    }

    /* renamed from: a */
    private SupportRequestManagerFragment m16681a(androidx.fragment.app.FragmentManager fragmentManager, String str, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f19621f.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            this.f19621f.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add((Fragment) supportRequestManagerFragment, str).commitAllowingStateLoss();
            this.f19619b.obtainMessage(2, fragmentManager).sendToTarget();
        }
        if (!z) {
            return supportRequestManagerFragment;
        }
        fragmentManager.beginTransaction().remove(supportRequestManagerFragment).commitAllowingStateLoss();
        return null;
    }

    /* renamed from: a */
    private static <T> void m16682a(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
    }
}
