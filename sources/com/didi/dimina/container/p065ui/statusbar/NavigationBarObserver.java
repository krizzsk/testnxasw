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

/* renamed from: com.didi.dimina.container.ui.statusbar.NavigationBarObserver */
final class NavigationBarObserver extends ContentObserver {

    /* renamed from: a */
    private ArrayList<OnNavigationBarListener> f19604a;

    /* renamed from: b */
    private Application f19605b;

    /* renamed from: c */
    private Boolean f19606c;

    /* renamed from: a */
    static NavigationBarObserver m16661a() {
        return NavigationBarObserverInstance.INSTANCE;
    }

    private NavigationBarObserver() {
        super(new Handler(Looper.getMainLooper()));
        this.f19606c = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61615a(Application application) {
        Application application2;
        this.f19605b = application;
        if (Build.VERSION.SDK_INT >= 17 && (application2 = this.f19605b) != null && application2.getContentResolver() != null && !this.f19606c.booleanValue()) {
            Uri uri = null;
            if (OSUtils.isMIUI()) {
                uri = Settings.Global.getUriFor("force_fsg_nav_bar");
            } else if (OSUtils.isEMUI()) {
                if (OSUtils.isEMUI3_x() || Build.VERSION.SDK_INT < 21) {
                    uri = Settings.System.getUriFor("navigationbar_is_min");
                } else {
                    uri = Settings.Global.getUriFor("navigationbar_is_min");
                }
            }
            if (uri != null) {
                this.f19605b.getContentResolver().registerContentObserver(uri, true, this);
                this.f19606c = true;
            }
        }
    }

    public void onChange(boolean z) {
        Application application;
        ArrayList<OnNavigationBarListener> arrayList;
        int i;
        super.onChange(z);
        if (Build.VERSION.SDK_INT >= 17 && (application = this.f19605b) != null && application.getContentResolver() != null && (arrayList = this.f19604a) != null && !arrayList.isEmpty()) {
            if (OSUtils.isMIUI()) {
                i = Settings.Global.getInt(this.f19605b.getContentResolver(), "force_fsg_nav_bar", 0);
            } else {
                i = OSUtils.isEMUI() ? (OSUtils.isEMUI3_x() || Build.VERSION.SDK_INT < 21) ? Settings.System.getInt(this.f19605b.getContentResolver(), "navigationbar_is_min", 0) : Settings.Global.getInt(this.f19605b.getContentResolver(), "navigationbar_is_min", 0) : 0;
            }
            Iterator<OnNavigationBarListener> it = this.f19604a.iterator();
            while (it.hasNext()) {
                OnNavigationBarListener next = it.next();
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
    public void mo61616a(OnNavigationBarListener onNavigationBarListener) {
        if (onNavigationBarListener != null) {
            if (this.f19604a == null) {
                this.f19604a = new ArrayList<>();
            }
            if (!this.f19604a.contains(onNavigationBarListener)) {
                this.f19604a.add(onNavigationBarListener);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo61617b(OnNavigationBarListener onNavigationBarListener) {
        ArrayList<OnNavigationBarListener> arrayList;
        if (onNavigationBarListener != null && (arrayList = this.f19604a) != null) {
            arrayList.remove(onNavigationBarListener);
        }
    }

    /* renamed from: com.didi.dimina.container.ui.statusbar.NavigationBarObserver$NavigationBarObserverInstance */
    private static class NavigationBarObserverInstance {
        /* access modifiers changed from: private */
        public static final NavigationBarObserver INSTANCE = new NavigationBarObserver();

        private NavigationBarObserverInstance() {
        }
    }
}
