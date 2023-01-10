package com.didi.component.business.accessibility;

import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: com.didi.component.business.accessibility.a */
/* compiled from: FocusedAccessibilityTask */
class C5163a implements Runnable {

    /* renamed from: a */
    private WeakReference<View> f13003a;

    public C5163a(View view) {
        this.f13003a = new WeakReference<>(view);
    }

    public void run() {
        View view = (View) this.f13003a.get();
        if (view != null) {
            view.setFocusable(true);
            view.sendAccessibilityEvent(128);
        }
    }
}
