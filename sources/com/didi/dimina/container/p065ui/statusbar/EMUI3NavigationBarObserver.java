package com.didi.dimina.container.p065ui.statusbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.didi.dimina.container.ui.statusbar.EMUI3NavigationBarObserver */
final class EMUI3NavigationBarObserver extends ContentObserver {

    /* renamed from: a */
    private ArrayList<C8272d> f19574a;

    /* renamed from: b */
    private Application f19575b;

    /* renamed from: c */
    private Boolean f19576c;

    /* renamed from: a */
    static EMUI3NavigationBarObserver m16612a() {
        return NavigationBarObserverInstance.INSTANCE;
    }

    private EMUI3NavigationBarObserver() {
        super(new Handler(Looper.getMainLooper()));
        this.f19576c = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61488a(Application application) {
        Application application2;
        Uri uriFor;
        this.f19575b = application;
        if (Build.VERSION.SDK_INT >= 17 && (application2 = this.f19575b) != null && application2.getContentResolver() != null && !this.f19576c.booleanValue() && (uriFor = Settings.System.getUriFor("navigationbar_is_min")) != null) {
            this.f19575b.getContentResolver().registerContentObserver(uriFor, true, this);
            this.f19576c = true;
        }
    }

    public void onChange(boolean z) {
        Application application;
        ArrayList<C8272d> arrayList;
        super.onChange(z);
        if (Build.VERSION.SDK_INT >= 17 && (application = this.f19575b) != null && application.getContentResolver() != null && (arrayList = this.f19574a) != null && !arrayList.isEmpty()) {
            int i = Settings.System.getInt(this.f19575b.getContentResolver(), "navigationbar_is_min", 0);
            Iterator<C8272d> it = this.f19574a.iterator();
            while (it.hasNext()) {
                C8272d next = it.next();
                boolean z2 = true;
                if (i == 1) {
                    z2 = false;
                }
                next.onNavigationBarChange(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61489a(C8272d dVar) {
        if (dVar != null) {
            if (this.f19574a == null) {
                this.f19574a = new ArrayList<>();
            }
            if (!this.f19574a.contains(dVar)) {
                this.f19574a.add(dVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo61490b(C8272d dVar) {
        ArrayList<C8272d> arrayList;
        if (dVar != null && (arrayList = this.f19574a) != null) {
            arrayList.remove(dVar);
        }
    }

    /* renamed from: com.didi.dimina.container.ui.statusbar.EMUI3NavigationBarObserver$NavigationBarObserverInstance */
    private static class NavigationBarObserverInstance {
        /* access modifiers changed from: private */
        public static final EMUI3NavigationBarObserver INSTANCE = new EMUI3NavigationBarObserver();

        private NavigationBarObserverInstance() {
        }
    }
}
