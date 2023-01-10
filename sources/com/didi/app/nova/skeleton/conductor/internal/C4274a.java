package com.didi.app.nova.skeleton.conductor.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/* renamed from: com.didi.app.nova.skeleton.conductor.internal.a */
/* compiled from: FragmentLifecycleCallback */
class C4274a extends FragmentManager.FragmentLifecycleCallbacks {

    /* renamed from: a */
    private FragmentLifecycleHandler f10251a;

    C4274a(FragmentLifecycleHandler fragmentLifecycleHandler) {
        this.f10251a = fragmentLifecycleHandler;
    }

    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentAttached(fragmentManager, fragment, context);
        if (fragment == this.f10251a.getAttachedFragment()) {
            this.f10251a.onAttach(context);
        }
    }

    public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentCreated(fragmentManager, fragment, bundle);
        if (fragment == this.f10251a.getAttachedFragment()) {
            this.f10251a.onCreate(bundle);
        }
    }

    public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentSaveInstanceState(fragmentManager, fragment, bundle);
        if (fragment == this.f10251a.getAttachedFragment()) {
            this.f10251a.onSaveInstanceState(bundle);
        }
    }

    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStarted(fragmentManager, fragment);
        if (fragment == this.f10251a.getAttachedFragment()) {
            FragmentLifecycleHandler fragmentLifecycleHandler = this.f10251a;
            fragmentLifecycleHandler.onActivityStarted(fragmentLifecycleHandler.getLifecycleActivity());
        }
    }

    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentResumed(fragmentManager, fragment);
        if (fragment == this.f10251a.getAttachedFragment()) {
            FragmentLifecycleHandler fragmentLifecycleHandler = this.f10251a;
            fragmentLifecycleHandler.onActivityResumed(fragmentLifecycleHandler.getLifecycleActivity());
        }
    }

    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentPaused(fragmentManager, fragment);
        if (fragment == this.f10251a.getAttachedFragment()) {
            FragmentLifecycleHandler fragmentLifecycleHandler = this.f10251a;
            fragmentLifecycleHandler.onActivityPaused(fragmentLifecycleHandler.getLifecycleActivity());
        }
    }

    public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStopped(fragmentManager, fragment);
        if (fragment == this.f10251a.getAttachedFragment()) {
            FragmentLifecycleHandler fragmentLifecycleHandler = this.f10251a;
            fragmentLifecycleHandler.onActivityStopped(fragmentLifecycleHandler.getLifecycleActivity());
        }
    }

    public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDestroyed(fragmentManager, fragment);
        if (fragment == this.f10251a.getAttachedFragment()) {
            this.f10251a.onDestroy();
        }
    }

    public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDetached(fragmentManager, fragment);
        if (fragment == this.f10251a.getAttachedFragment()) {
            this.f10251a.onDetach();
        }
    }
}
