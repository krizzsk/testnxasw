package com.didi.app.nova.skeleton.conductor;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.internal.FragmentLifecycleHandler;
import com.didi.app.nova.skeleton.conductor.internal.TransactionIndexer;
import java.util.Collections;
import java.util.List;

public final class ActivityHostedRouter extends Router {

    /* renamed from: g */
    private FragmentLifecycleHandler f10109g;

    /* renamed from: h */
    private final TransactionIndexer f10110h = new TransactionIndexer();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Router mo45435c() {
        return this;
    }

    public final void invalidateOptionsMenu() {
    }

    public final void setHost(FragmentLifecycleHandler fragmentLifecycleHandler, ViewGroup viewGroup) {
        if (this.f10109g != fragmentLifecycleHandler || this.f10169d != viewGroup) {
            if (this.f10169d != null && (this.f10169d instanceof ControllerChangeHandler.ControllerChangeListener)) {
                removeChangeListener((ControllerChangeHandler.ControllerChangeListener) this.f10169d);
            }
            if (viewGroup instanceof ControllerChangeHandler.ControllerChangeListener) {
                addChangeListener((ControllerChangeHandler.ControllerChangeListener) viewGroup);
            }
            this.f10109g = fragmentLifecycleHandler;
            this.f10169d = viewGroup;
            mo45606i();
        }
    }

    public void saveInstanceState(Bundle bundle) {
        super.saveInstanceState(bundle);
        this.f10110h.saveInstanceState(bundle);
    }

    public void restoreInstanceState(Bundle bundle) {
        super.restoreInstanceState(bundle);
        this.f10110h.restoreInstanceState(bundle);
    }

    public Activity getActivity() {
        FragmentLifecycleHandler fragmentLifecycleHandler = this.f10109g;
        if (fragmentLifecycleHandler != null) {
            return fragmentLifecycleHandler.getLifecycleActivity();
        }
        return null;
    }

    public Fragment getFragment() {
        FragmentLifecycleHandler fragmentLifecycleHandler = this.f10109g;
        if (fragmentLifecycleHandler != null) {
            return fragmentLifecycleHandler.getAttachedFragment();
        }
        return null;
    }

    public void onActivityDestroyed(Activity activity) {
        super.onActivityDestroyed(activity);
        this.f10109g = null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (mo45433a()) {
            this.f10109g.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45426a(Intent intent) {
        if (mo45433a()) {
            this.f10109g.startActivity(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45429a(String str, Intent intent, int i) {
        if (mo45433a()) {
            this.f10109g.startActivityForResult(str, intent, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45430a(String str, Intent intent, int i, Bundle bundle) {
        if (mo45433a()) {
            this.f10109g.startActivityForResult(str, intent, i, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45431a(String str, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (mo45433a()) {
            this.f10109g.startIntentSenderForResult(str, intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45428a(String str, int i) {
        if (mo45433a()) {
            this.f10109g.registerForActivityResult(str, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45427a(String str) {
        if (mo45433a()) {
            this.f10109g.unregisterForActivityResults(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45432a(String str, String[] strArr) {
        if (mo45433a()) {
            this.f10109g.requestPermissions(str, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo45433a() {
        return this.f10109g != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public List<Router> mo45434b() {
        return mo45433a() ? this.f10109g.getRouters() : Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public TransactionIndexer mo45436d() {
        return this.f10110h;
    }

    public void onContextAvailable() {
        super.onContextAvailable();
    }
}
