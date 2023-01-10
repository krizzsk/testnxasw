package com.didi.dimina.container.p065ui.statusbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

/* renamed from: com.didi.dimina.container.ui.statusbar.e */
/* compiled from: ImmersionDelegate */
class C8273e implements Runnable {

    /* renamed from: a */
    private ImmersionBar f19658a;

    /* renamed from: b */
    private BarProperties f19659b;

    /* renamed from: c */
    private OnBarListener f19660c;

    /* renamed from: d */
    private int f19661d;

    C8273e(Object obj) {
        if (obj instanceof Activity) {
            if (this.f19658a == null) {
                this.f19658a = new ImmersionBar((Activity) obj);
            }
        } else if (obj instanceof Fragment) {
            if (this.f19658a != null) {
                return;
            }
            if (obj instanceof DialogFragment) {
                this.f19658a = new ImmersionBar((DialogFragment) obj);
            } else {
                this.f19658a = new ImmersionBar((Fragment) obj);
            }
        } else if ((obj instanceof android.app.Fragment) && this.f19658a == null) {
            if (obj instanceof android.app.DialogFragment) {
                this.f19658a = new ImmersionBar((android.app.DialogFragment) obj);
            } else {
                this.f19658a = new ImmersionBar((android.app.Fragment) obj);
            }
        }
    }

    C8273e(Activity activity, Dialog dialog) {
        if (this.f19658a == null) {
            this.f19658a = new ImmersionBar(activity, dialog);
        }
    }

    /* renamed from: a */
    public ImmersionBar mo61645a() {
        return this.f19658a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61646a(Configuration configuration) {
        m16704c(configuration);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo61647b() {
        ImmersionBar immersionBar = this.f19658a;
        if (immersionBar != null) {
            immersionBar.mo61509b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo61649c() {
        this.f19659b = null;
        ImmersionBar immersionBar = this.f19658a;
        if (immersionBar != null) {
            immersionBar.mo61492a();
            this.f19658a = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo61648b(Configuration configuration) {
        ImmersionBar immersionBar = this.f19658a;
        if (immersionBar != null) {
            immersionBar.mo61493a(configuration);
            m16704c(configuration);
        }
    }

    /* renamed from: c */
    private void m16704c(Configuration configuration) {
        ImmersionBar immersionBar = this.f19658a;
        if (immersionBar != null && immersionBar.mo61552n() && Build.VERSION.SDK_INT >= 19) {
            OnBarListener onBarListener = this.f19658a.getBarParams().f19563d;
            this.f19660c = onBarListener;
            if (onBarListener != null) {
                Activity h = this.f19658a.mo61541h();
                if (this.f19659b == null) {
                    this.f19659b = new BarProperties();
                }
                this.f19659b.mo61469a(configuration.orientation == 1);
                int rotation = h.getWindowManager().getDefaultDisplay().getRotation();
                if (rotation == 1) {
                    this.f19659b.mo61471b(true);
                    this.f19659b.mo61473c(false);
                } else if (rotation == 3) {
                    this.f19659b.mo61471b(false);
                    this.f19659b.mo61473c(true);
                } else {
                    this.f19659b.mo61471b(false);
                    this.f19659b.mo61473c(false);
                }
                h.getWindow().getDecorView().post(this);
            }
        }
    }

    public void run() {
        ImmersionBar immersionBar = this.f19658a;
        if (immersionBar != null && immersionBar.mo61541h() != null) {
            Activity h = this.f19658a.mo61541h();
            C8269a aVar = new C8269a(h);
            this.f19659b.mo61468a(aVar.mo61636b());
            this.f19659b.mo61477e(aVar.mo61638d());
            this.f19659b.mo61470b(aVar.mo61639e());
            this.f19659b.mo61472c(aVar.mo61640f());
            this.f19659b.mo61476e(aVar.mo61637c());
            boolean hasNotchScreen = NotchUtils.hasNotchScreen(h);
            this.f19659b.mo61475d(hasNotchScreen);
            if (hasNotchScreen && this.f19661d == 0) {
                int notchHeight = NotchUtils.getNotchHeight(h);
                this.f19661d = notchHeight;
                this.f19659b.mo61474d(notchHeight);
            }
            this.f19660c.onBarChange(this.f19659b);
        }
    }
}
