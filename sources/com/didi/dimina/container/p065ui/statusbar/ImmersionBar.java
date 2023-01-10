package com.didi.dimina.container.p065ui.statusbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.dimina.container.ui.statusbar.ImmersionBar */
public final class ImmersionBar implements C8272d {

    /* renamed from: A */
    private int f19577A;

    /* renamed from: a */
    private final Activity f19578a;

    /* renamed from: b */
    private Fragment f19579b;

    /* renamed from: c */
    private android.app.Fragment f19580c;

    /* renamed from: d */
    private Dialog f19581d;

    /* renamed from: e */
    private Window f19582e;

    /* renamed from: f */
    private ViewGroup f19583f;

    /* renamed from: g */
    private ViewGroup f19584g;

    /* renamed from: h */
    private ImmersionBar f19585h;

    /* renamed from: i */
    private boolean f19586i;

    /* renamed from: j */
    private boolean f19587j;

    /* renamed from: k */
    private boolean f19588k;

    /* renamed from: l */
    private boolean f19589l;

    /* renamed from: m */
    private BarParams f19590m;

    /* renamed from: n */
    private C8269a f19591n;

    /* renamed from: o */
    private int f19592o;

    /* renamed from: p */
    private int f19593p;

    /* renamed from: q */
    private int f19594q;

    /* renamed from: r */
    private C8271c f19595r;

    /* renamed from: s */
    private final Map<String, BarParams> f19596s;

    /* renamed from: t */
    private int f19597t;

    /* renamed from: u */
    private boolean f19598u;

    /* renamed from: v */
    private boolean f19599v;

    /* renamed from: w */
    private boolean f19600w;

    /* renamed from: x */
    private int f19601x;

    /* renamed from: y */
    private int f19602y;

    /* renamed from: z */
    private int f19603z;

    public static ImmersionBar with(Activity activity) {
        return m16625J().mo61626a(activity);
    }

    public static ImmersionBar with(Fragment fragment) {
        return m16625J().mo61629a(fragment, false);
    }

    public static ImmersionBar with(Fragment fragment, boolean z) {
        return m16625J().mo61629a(fragment, z);
    }

    public static ImmersionBar with(android.app.Fragment fragment) {
        return m16625J().mo61628a(fragment, false);
    }

    public static ImmersionBar with(android.app.Fragment fragment, boolean z) {
        return m16625J().mo61628a(fragment, z);
    }

    public static ImmersionBar with(DialogFragment dialogFragment) {
        return m16625J().mo61629a((Fragment) dialogFragment, false);
    }

    public static ImmersionBar with(android.app.DialogFragment dialogFragment) {
        return m16625J().mo61628a((android.app.Fragment) dialogFragment, false);
    }

    public static ImmersionBar with(Activity activity, Dialog dialog) {
        return m16625J().mo61627a(activity, dialog);
    }

    public static void destroy(Fragment fragment) {
        m16625J().mo61631b(fragment, false);
    }

    public static void destroy(Fragment fragment, boolean z) {
        m16625J().mo61631b(fragment, z);
    }

    public static void destroy(Activity activity, Dialog dialog) {
        m16625J().mo61630b(activity, dialog);
    }

    public void init() {
        if (Build.VERSION.SDK_INT >= 19 && this.f19590m.barEnable) {
            m16634q();
            mo61524c();
            m16641x();
            m16623H();
            m16621F();
            this.f19598u = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61492a() {
        ImmersionBar immersionBar;
        m16622G();
        if (this.f19589l && (immersionBar = this.f19585h) != null) {
            immersionBar.f19590m.keyboardEnable = immersionBar.f19600w;
            if (this.f19585h.f19590m.barHide != BarHide.FLAG_SHOW_BAR) {
                this.f19585h.mo61524c();
            }
        }
        this.f19598u = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo61509b() {
        if (!this.f19587j && this.f19598u && this.f19590m != null) {
            if (OSUtils.isEMUI3_x() && this.f19590m.navigationBarWithEMUI3Enable) {
                init();
            } else if (this.f19590m.barHide != BarHide.FLAG_SHOW_BAR) {
                mo61524c();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61493a(Configuration configuration) {
        if (!OSUtils.isEMUI3_x() && Build.VERSION.SDK_INT != 19) {
            m16641x();
        } else if (!this.f19598u || this.f19587j || !this.f19590m.navigationBarWithKitkatEnable) {
            m16641x();
        } else {
            init();
        }
    }

    /* renamed from: q */
    private void m16634q() {
        m16640w();
        if (Build.VERSION.SDK_INT >= 19) {
            m16619D();
            ImmersionBar immersionBar = this.f19585h;
            if (immersionBar != null) {
                if (this.f19587j) {
                    immersionBar.f19590m = this.f19590m;
                }
                if (this.f19589l) {
                    ImmersionBar immersionBar2 = this.f19585h;
                    if (immersionBar2.f19600w) {
                        immersionBar2.f19590m.keyboardEnable = false;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo61524c() {
        int i = 256;
        if (Build.VERSION.SDK_INT < 21 || OSUtils.isEMUI3_x()) {
            m16637t();
        } else {
            m16636s();
            i = m16633d(m16632c(m16626a(256)));
        }
        this.f19583f.setSystemUiVisibility(m16631b(i));
        m16635r();
        if (this.f19590m.f19562c != null) {
            NavigationBarObserver.m16661a().mo61615a(this.f19578a.getApplication());
        }
    }

    /* renamed from: r */
    private void m16635r() {
        if (OSUtils.isMIUI6Later()) {
            C8274f.m16716a(this.f19582e, "EXTRA_FLAG_STATUS_BAR_DARK_MODE", this.f19590m.statusBarDarkFont);
            if (this.f19590m.navigationBarEnable) {
                C8274f.m16716a(this.f19582e, "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE", this.f19590m.navigationBarDarkIcon);
            }
        }
        if (!OSUtils.isFlymeOS4Later()) {
            return;
        }
        if (this.f19590m.flymeOSStatusBarFontColor != 0) {
            C8274f.m16711a(this.f19578a, this.f19590m.flymeOSStatusBarFontColor);
        } else {
            C8274f.m16712a(this.f19578a, this.f19590m.statusBarDarkFont);
        }
    }

    /* renamed from: s */
    private void m16636s() {
        if (Build.VERSION.SDK_INT >= 28 && !this.f19598u) {
            WindowManager.LayoutParams attributes = this.f19582e.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            this.f19582e.setAttributes(attributes);
        }
    }

    /* renamed from: a */
    private int m16626a(int i) {
        if (!this.f19598u) {
            this.f19590m.defaultNavigationBarColor = this.f19582e.getNavigationBarColor();
        }
        int i2 = i | 1024;
        if (this.f19590m.fullScreen && this.f19590m.navigationBarEnable) {
            i2 |= 512;
        }
        this.f19582e.clearFlags(View.STATUS_BAR_TRANSIENT);
        if (this.f19591n.mo61638d()) {
            this.f19582e.clearFlags(View.NAVIGATION_BAR_TRANSIENT);
        }
        this.f19582e.addFlags(Integer.MIN_VALUE);
        if (this.f19590m.statusBarColorEnabled) {
            this.f19582e.setStatusBarColor(ColorUtils.blendARGB(this.f19590m.statusBarColor, this.f19590m.statusBarColorTransform, this.f19590m.statusBarAlpha));
        } else {
            this.f19582e.setStatusBarColor(ColorUtils.blendARGB(this.f19590m.statusBarColor, 0, this.f19590m.statusBarAlpha));
        }
        if (this.f19590m.navigationBarEnable) {
            this.f19582e.setNavigationBarColor(ColorUtils.blendARGB(this.f19590m.navigationBarColor, this.f19590m.navigationBarColorTransform, this.f19590m.navigationBarAlpha));
        }
        return i2;
    }

    /* renamed from: t */
    private void m16637t() {
        this.f19582e.addFlags(View.STATUS_BAR_TRANSIENT);
        m16638u();
        if (this.f19591n.mo61638d() || OSUtils.isEMUI3_x()) {
            if (!this.f19590m.navigationBarEnable || !this.f19590m.navigationBarWithKitkatEnable) {
                this.f19582e.clearFlags(View.NAVIGATION_BAR_TRANSIENT);
            } else {
                this.f19582e.addFlags(View.NAVIGATION_BAR_TRANSIENT);
            }
            if (this.f19592o == 0) {
                this.f19592o = this.f19591n.mo61639e();
            }
            if (this.f19593p == 0) {
                this.f19593p = this.f19591n.mo61640f();
            }
            m16639v();
        }
    }

    /* renamed from: u */
    private void m16638u() {
        View findViewById = this.f19583f.findViewById(C8270b.f19630a);
        if (findViewById == null) {
            findViewById = new View(this.f19578a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f19591n.mo61636b());
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(C8270b.f19630a);
            this.f19583f.addView(findViewById);
        }
        if (this.f19590m.statusBarColorEnabled) {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(this.f19590m.statusBarColor, this.f19590m.statusBarColorTransform, this.f19590m.statusBarAlpha));
        } else {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(this.f19590m.statusBarColor, 0, this.f19590m.statusBarAlpha));
        }
    }

    /* renamed from: v */
    private void m16639v() {
        FrameLayout.LayoutParams layoutParams;
        View findViewById = this.f19583f.findViewById(C8270b.f19631b);
        if (findViewById == null) {
            findViewById = new View(this.f19578a);
            findViewById.setId(C8270b.f19631b);
            this.f19583f.addView(findViewById);
        }
        if (this.f19591n.mo61635a()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f19591n.mo61639e());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f19591n.mo61640f(), -1);
            layoutParams.gravity = GravityCompat.END;
        }
        findViewById.setLayoutParams(layoutParams);
        findViewById.setBackgroundColor(ColorUtils.blendARGB(this.f19590m.navigationBarColor, this.f19590m.navigationBarColorTransform, this.f19590m.navigationBarAlpha));
        if (!this.f19590m.navigationBarEnable || !this.f19590m.navigationBarWithKitkatEnable || this.f19590m.hideNavigationBar) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    /* renamed from: w */
    private void m16640w() {
        boolean z = true;
        if (this.f19590m.autoStatusBarDarkModeEnable && this.f19590m.statusBarColor != 0) {
            statusBarDarkFont(this.f19590m.statusBarColor > -4539718, this.f19590m.autoStatusBarDarkModeAlpha);
        }
        if (this.f19590m.autoNavigationBarDarkModeEnable && this.f19590m.navigationBarColor != 0) {
            if (this.f19590m.navigationBarColor <= -4539718) {
                z = false;
            }
            navigationBarDarkIcon(z, this.f19590m.autoNavigationBarDarkModeAlpha);
        }
    }

    /* renamed from: com.didi.dimina.container.ui.statusbar.ImmersionBar$2 */
    static /* synthetic */ class C82662 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$dimina$container$ui$statusbar$BarHide;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.dimina.container.ui.statusbar.BarHide[] r0 = com.didi.dimina.container.p065ui.statusbar.BarHide.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$dimina$container$ui$statusbar$BarHide = r0
                com.didi.dimina.container.ui.statusbar.BarHide r1 = com.didi.dimina.container.p065ui.statusbar.BarHide.FLAG_HIDE_BAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$dimina$container$ui$statusbar$BarHide     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.dimina.container.ui.statusbar.BarHide r1 = com.didi.dimina.container.p065ui.statusbar.BarHide.FLAG_HIDE_STATUS_BAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$dimina$container$ui$statusbar$BarHide     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.dimina.container.ui.statusbar.BarHide r1 = com.didi.dimina.container.p065ui.statusbar.BarHide.FLAG_HIDE_NAVIGATION_BAR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$dimina$container$ui$statusbar$BarHide     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.dimina.container.ui.statusbar.BarHide r1 = com.didi.dimina.container.p065ui.statusbar.BarHide.FLAG_SHOW_BAR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p065ui.statusbar.ImmersionBar.C82662.<clinit>():void");
        }
    }

    /* renamed from: b */
    private int m16631b(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            int i2 = C82662.$SwitchMap$com$didi$dimina$container$ui$statusbar$BarHide[this.f19590m.barHide.ordinal()];
            if (i2 == 1) {
                i |= 518;
            } else if (i2 == 2) {
                i |= 1028;
            } else if (i2 == 3) {
                i |= 514;
            } else if (i2 == 4) {
                i |= 0;
            }
        }
        return i | 4096;
    }

    /* renamed from: x */
    private void m16641x() {
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT < 21 || OSUtils.isEMUI3_x()) {
                m16642y();
            } else {
                m16616A();
            }
            m16620E();
        }
    }

    /* renamed from: y */
    private void m16642y() {
        if (this.f19590m.isSupportActionBar) {
            this.f19599v = true;
            this.f19584g.post(this);
            return;
        }
        this.f19599v = false;
        m16643z();
    }

    public void run() {
        m16643z();
    }

    /* renamed from: z */
    private void m16643z() {
        m16619D();
        m16617B();
        if (!this.f19587j && OSUtils.isEMUI3_x()) {
            m16618C();
        }
    }

    /* renamed from: A */
    private void m16616A() {
        m16619D();
        if (checkFitsSystemWindows(this.f19583f.findViewById(16908290))) {
            m16627a(0, 0, 0, 0);
            return;
        }
        int b = (!this.f19590m.fits || this.f19597t != 4) ? 0 : this.f19591n.mo61636b();
        if (this.f19590m.isSupportActionBar) {
            b = this.f19591n.mo61636b() + this.f19594q;
        }
        m16627a(0, b, 0, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007b  */
    /* renamed from: B */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m16617B() {
        /*
            r5 = this;
            android.view.ViewGroup r0 = r5.f19583f
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r1)
            boolean r0 = checkFitsSystemWindows(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0014
            r5.m16627a(r1, r1, r1, r1)
            return
        L_0x0014:
            com.didi.dimina.container.ui.statusbar.BarParams r0 = r5.f19590m
            boolean r0 = r0.fits
            if (r0 == 0) goto L_0x0026
            int r0 = r5.f19597t
            r2 = 4
            if (r0 != r2) goto L_0x0026
            com.didi.dimina.container.ui.statusbar.a r0 = r5.f19591n
            int r0 = r0.mo61636b()
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            com.didi.dimina.container.ui.statusbar.BarParams r2 = r5.f19590m
            boolean r2 = r2.isSupportActionBar
            if (r2 == 0) goto L_0x0036
            com.didi.dimina.container.ui.statusbar.a r0 = r5.f19591n
            int r0 = r0.mo61636b()
            int r2 = r5.f19594q
            int r0 = r0 + r2
        L_0x0036:
            com.didi.dimina.container.ui.statusbar.a r2 = r5.f19591n
            boolean r2 = r2.mo61638d()
            if (r2 == 0) goto L_0x008a
            com.didi.dimina.container.ui.statusbar.BarParams r2 = r5.f19590m
            boolean r2 = r2.navigationBarEnable
            if (r2 == 0) goto L_0x008a
            com.didi.dimina.container.ui.statusbar.BarParams r2 = r5.f19590m
            boolean r2 = r2.navigationBarWithKitkatEnable
            if (r2 == 0) goto L_0x008a
            com.didi.dimina.container.ui.statusbar.BarParams r2 = r5.f19590m
            boolean r2 = r2.fullScreen
            if (r2 != 0) goto L_0x0068
            com.didi.dimina.container.ui.statusbar.a r2 = r5.f19591n
            boolean r2 = r2.mo61635a()
            if (r2 == 0) goto L_0x0061
            com.didi.dimina.container.ui.statusbar.a r2 = r5.f19591n
            int r2 = r2.mo61639e()
            r3 = r2
            r2 = 0
            goto L_0x006a
        L_0x0061:
            com.didi.dimina.container.ui.statusbar.a r2 = r5.f19591n
            int r2 = r2.mo61640f()
            goto L_0x0069
        L_0x0068:
            r2 = 0
        L_0x0069:
            r3 = 0
        L_0x006a:
            com.didi.dimina.container.ui.statusbar.BarParams r4 = r5.f19590m
            boolean r4 = r4.hideNavigationBar
            if (r4 == 0) goto L_0x007b
            com.didi.dimina.container.ui.statusbar.a r4 = r5.f19591n
            boolean r4 = r4.mo61635a()
            if (r4 == 0) goto L_0x0079
            goto L_0x008b
        L_0x0079:
            r2 = 0
            goto L_0x008c
        L_0x007b:
            com.didi.dimina.container.ui.statusbar.a r4 = r5.f19591n
            boolean r4 = r4.mo61635a()
            if (r4 != 0) goto L_0x008c
            com.didi.dimina.container.ui.statusbar.a r2 = r5.f19591n
            int r2 = r2.mo61640f()
            goto L_0x008c
        L_0x008a:
            r2 = 0
        L_0x008b:
            r3 = 0
        L_0x008c:
            r5.m16627a(r1, r0, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p065ui.statusbar.ImmersionBar.m16617B():void");
    }

    /* renamed from: C */
    private void m16618C() {
        View findViewById = this.f19583f.findViewById(C8270b.f19631b);
        if (!this.f19590m.navigationBarEnable || !this.f19590m.navigationBarWithKitkatEnable) {
            EMUI3NavigationBarObserver.m16612a().mo61490b(this);
            findViewById.setVisibility(8);
        } else if (findViewById != null) {
            EMUI3NavigationBarObserver.m16612a().mo61489a((C8272d) this);
            EMUI3NavigationBarObserver.m16612a().mo61488a(this.f19578a.getApplication());
        }
    }

    /* renamed from: D */
    private void m16619D() {
        this.f19591n = new C8269a(this.f19578a);
        if (!this.f19598u || this.f19599v) {
            this.f19594q = this.f19591n.mo61637c();
        }
    }

    public void onNavigationBarChange(boolean z) {
        View findViewById = this.f19583f.findViewById(C8270b.f19631b);
        if (findViewById != null) {
            this.f19591n = new C8269a(this.f19578a);
            int paddingBottom = this.f19584g.getPaddingBottom();
            int paddingRight = this.f19584g.getPaddingRight();
            if (!z) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
                if (!checkFitsSystemWindows(this.f19583f.findViewById(16908290))) {
                    if (this.f19592o == 0) {
                        this.f19592o = this.f19591n.mo61639e();
                    }
                    if (this.f19593p == 0) {
                        this.f19593p = this.f19591n.mo61640f();
                    }
                    if (!this.f19590m.hideNavigationBar) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                        if (this.f19591n.mo61635a()) {
                            layoutParams.gravity = 80;
                            layoutParams.height = this.f19592o;
                            paddingBottom = !this.f19590m.fullScreen ? this.f19592o : 0;
                            paddingRight = 0;
                        } else {
                            layoutParams.gravity = GravityCompat.END;
                            layoutParams.width = this.f19593p;
                            paddingRight = !this.f19590m.fullScreen ? this.f19593p : 0;
                            paddingBottom = 0;
                        }
                        findViewById.setLayoutParams(layoutParams);
                    }
                    m16627a(0, this.f19584g.getPaddingTop(), paddingRight, paddingBottom);
                }
            }
            paddingBottom = 0;
            paddingRight = 0;
            m16627a(0, this.f19584g.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    /* renamed from: c */
    private int m16632c(int i) {
        return (Build.VERSION.SDK_INT < 23 || !this.f19590m.statusBarDarkFont) ? i : i | 8192;
    }

    /* renamed from: d */
    private int m16633d(int i) {
        return (Build.VERSION.SDK_INT < 26 || !this.f19590m.navigationBarDarkIcon) ? i : i | 16;
    }

    /* renamed from: E */
    private void m16620E() {
        int statusBarHeight = this.f19590m.fitsLayoutOverlapEnable ? getStatusBarHeight(this.f19578a) : 0;
        int i = this.f19597t;
        if (i == 1) {
            setTitleBar(this.f19578a, statusBarHeight, this.f19590m.titleBarView);
        } else if (i == 2) {
            setTitleBarMarginTop(this.f19578a, statusBarHeight, this.f19590m.titleBarView);
        } else if (i == 3) {
            setStatusBarView(this.f19578a, statusBarHeight, this.f19590m.statusBarView);
        }
    }

    /* renamed from: F */
    private void m16621F() {
        if (this.f19590m.f19560a.size() != 0) {
            for (Map.Entry next : this.f19590m.f19560a.entrySet()) {
                View view = (View) next.getKey();
                Integer valueOf = Integer.valueOf(this.f19590m.statusBarColor);
                Integer valueOf2 = Integer.valueOf(this.f19590m.statusBarColorTransform);
                for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                    Integer num = (Integer) entry.getKey();
                    valueOf2 = (Integer) entry.getValue();
                    valueOf = num;
                }
                if (view != null) {
                    if (Math.abs(this.f19590m.viewAlpha - 0.0f) == 0.0f) {
                        view.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.f19590m.statusBarAlpha));
                    } else {
                        view.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.f19590m.viewAlpha));
                    }
                }
            }
        }
    }

    /* renamed from: G */
    private void m16622G() {
        if (this.f19578a != null) {
            C8271c cVar = this.f19595r;
            if (cVar != null) {
                cVar.mo61643b();
                this.f19595r = null;
            }
            EMUI3NavigationBarObserver.m16612a().mo61490b(this);
            NavigationBarObserver.m16661a().mo61617b(this.f19590m.f19562c);
        }
    }

    /* renamed from: H */
    private void m16623H() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (this.f19587j) {
            ImmersionBar immersionBar = this.f19585h;
            if (immersionBar == null) {
                return;
            }
            if (immersionBar.f19590m.keyboardEnable) {
                ImmersionBar immersionBar2 = this.f19585h;
                if (immersionBar2.f19595r == null) {
                    immersionBar2.f19595r = new C8271c(immersionBar2);
                }
                ImmersionBar immersionBar3 = this.f19585h;
                immersionBar3.f19595r.mo61642a(immersionBar3.f19590m.keyboardMode);
                return;
            }
            C8271c cVar = this.f19585h.f19595r;
            if (cVar != null) {
                cVar.mo61641a();
            }
        } else if (this.f19590m.keyboardEnable) {
            if (this.f19595r == null) {
                this.f19595r = new C8271c(this);
            }
            this.f19595r.mo61642a(this.f19590m.keyboardMode);
        } else {
            C8271c cVar2 = this.f19595r;
            if (cVar2 != null) {
                cVar2.mo61641a();
            }
        }
    }

    public BarParams getBarParams() {
        return this.f19590m;
    }

    /* renamed from: a */
    private void m16627a(int i, int i2, int i3, int i4) {
        ViewGroup viewGroup = this.f19584g;
        if (viewGroup != null) {
            viewGroup.setPadding(i, i2, i3, i4);
        }
        this.f19601x = i;
        this.f19602y = i2;
        this.f19603z = i3;
        this.f19577A = i4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo61525d() {
        return this.f19601x;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo61526e() {
        return this.f19602y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo61527f() {
        return this.f19603z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo61538g() {
        return this.f19577A;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public Activity mo61541h() {
        return this.f19578a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public Window mo61543i() {
        return this.f19582e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public Fragment mo61545j() {
        return this.f19579b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public android.app.Fragment mo61546k() {
        return this.f19580c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean mo61550l() {
        return this.f19587j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo61551m() {
        return this.f19588k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo61552n() {
        return this.f19598u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public C8269a mo61571o() {
        if (this.f19591n == null) {
            this.f19591n = new C8269a(this.f19578a);
        }
        return this.f19591n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public int mo61573p() {
        return this.f19594q;
    }

    public static boolean isSupportStatusBarDarkFont() {
        return OSUtils.isMIUI6Later() || OSUtils.isFlymeOS4Later() || Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isSupportNavigationIconDark() {
        return OSUtils.isMIUI6Later() || Build.VERSION.SDK_INT >= 26;
    }

    public static void setTitleBar(Activity activity, final int i, View... viewArr) {
        if (Build.VERSION.SDK_INT >= 19 && activity != null) {
            if (i < 0) {
                i = 0;
            }
            for (final View view : viewArr) {
                if (view != null) {
                    final Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() != i) {
                        view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i));
                        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-1, -2);
                        }
                        if (layoutParams.height == -2 || layoutParams.height == -1) {
                            view.post(new Runnable() {
                                public void run() {
                                    layoutParams.height = (view.getHeight() + i) - num.intValue();
                                    View view = view;
                                    view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                                    view.setLayoutParams(layoutParams);
                                }
                            });
                        } else {
                            layoutParams.height += i - num.intValue();
                            view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                            view.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
        }
    }

    public static void setTitleBar(Activity activity, View... viewArr) {
        setTitleBar(activity, getStatusBarHeight(activity), viewArr);
    }

    public static void setTitleBar(Fragment fragment, int i, View... viewArr) {
        if (fragment != null) {
            setTitleBar((Activity) fragment.getActivity(), i, viewArr);
        }
    }

    public static void setTitleBar(Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setTitleBar((Activity) fragment.getActivity(), viewArr);
        }
    }

    public static void setTitleBar(android.app.Fragment fragment, int i, View... viewArr) {
        if (fragment != null) {
            setTitleBar(fragment.getActivity(), i, viewArr);
        }
    }

    public static void setTitleBar(android.app.Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setTitleBar(fragment.getActivity(), viewArr);
        }
    }

    public static void setTitleBarMarginTop(Activity activity, int i, View... viewArr) {
        if (Build.VERSION.SDK_INT >= 19 && activity != null) {
            if (i < 0) {
                i = 0;
            }
            for (View view : viewArr) {
                if (view != null) {
                    Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() != i) {
                        view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i));
                        Object layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (marginLayoutParams.topMargin + i) - num.intValue(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                        view.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }

    public static void setTitleBarMarginTop(Activity activity, View... viewArr) {
        setTitleBarMarginTop(activity, getStatusBarHeight(activity), viewArr);
    }

    public static void setTitleBarMarginTop(Fragment fragment, int i, View... viewArr) {
        if (fragment != null) {
            setTitleBarMarginTop((Activity) fragment.getActivity(), i, viewArr);
        }
    }

    public static void setTitleBarMarginTop(Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setTitleBarMarginTop((Activity) fragment.getActivity(), viewArr);
        }
    }

    public static void setTitleBarMarginTop(android.app.Fragment fragment, int i, View... viewArr) {
        if (fragment != null) {
            setTitleBarMarginTop(fragment.getActivity(), i, viewArr);
        }
    }

    public static void setTitleBarMarginTop(android.app.Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setTitleBarMarginTop(fragment.getActivity(), viewArr);
        }
    }

    public static void setStatusBarView(Activity activity, int i, View... viewArr) {
        if (Build.VERSION.SDK_INT >= 19 && activity != null) {
            if (i < 0) {
                i = 0;
            }
            for (View view : viewArr) {
                if (view != null) {
                    Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() != i) {
                        view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i));
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-1, 0);
                        }
                        layoutParams.height = i;
                        view.setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    public static void setStatusBarView(Activity activity, View... viewArr) {
        setStatusBarView(activity, getStatusBarHeight(activity), viewArr);
    }

    public static void setStatusBarView(Fragment fragment, int i, View... viewArr) {
        if (fragment != null) {
            setStatusBarView((Activity) fragment.getActivity(), i, viewArr);
        }
    }

    public static void setStatusBarView(Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setStatusBarView((Activity) fragment.getActivity(), viewArr);
        }
    }

    public static void setStatusBarView(android.app.Fragment fragment, int i, View... viewArr) {
        if (fragment != null) {
            setStatusBarView(fragment.getActivity(), i, viewArr);
        }
    }

    public static void setStatusBarView(android.app.Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setStatusBarView(fragment.getActivity(), viewArr);
        }
    }

    public static void setFitsSystemWindows(Activity activity, boolean z) {
        if (activity != null) {
            m16628a(((ViewGroup) activity.findViewById(16908290)).getChildAt(0), z);
        }
    }

    public static void setFitsSystemWindows(Activity activity) {
        setFitsSystemWindows(activity, true);
    }

    public static void setFitsSystemWindows(Fragment fragment, boolean z) {
        if (fragment != null) {
            setFitsSystemWindows((Activity) fragment.getActivity(), z);
        }
    }

    public static void setFitsSystemWindows(Fragment fragment) {
        if (fragment != null) {
            setFitsSystemWindows((Activity) fragment.getActivity());
        }
    }

    public static void setFitsSystemWindows(android.app.Fragment fragment, boolean z) {
        if (fragment != null) {
            setFitsSystemWindows(fragment.getActivity(), z);
        }
    }

    public static void setFitsSystemWindows(android.app.Fragment fragment) {
        if (fragment != null) {
            setFitsSystemWindows(fragment.getActivity());
        }
    }

    /* renamed from: a */
    private static void m16628a(View view, boolean z) {
        if (view != null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup instanceof DrawerLayout) {
                    m16628a(viewGroup.getChildAt(0), z);
                    return;
                }
                viewGroup.setFitsSystemWindows(z);
                viewGroup.setClipToPadding(true);
                return;
            }
            view.setFitsSystemWindows(z);
        }
    }

    public static boolean checkFitsSystemWindows(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (((childAt instanceof DrawerLayout) && checkFitsSystemWindows(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasNavigationBar(Activity activity) {
        return new C8269a(activity).mo61638d();
    }

    public static boolean hasNavigationBar(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNavigationBar((Activity) fragment.getActivity());
    }

    public static boolean hasNavigationBar(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNavigationBar(fragment.getActivity());
    }

    public static int getNavigationBarHeight(Activity activity) {
        return new C8269a(activity).mo61639e();
    }

    public static int getNavigationBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarHeight((Activity) fragment.getActivity());
    }

    public static int getNavigationBarHeight(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarHeight(fragment.getActivity());
    }

    public static int getNavigationBarWidth(Activity activity) {
        return new C8269a(activity).mo61640f();
    }

    public static int getNavigationBarWidth(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarWidth((Activity) fragment.getActivity());
    }

    public static int getNavigationBarWidth(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarWidth(fragment.getActivity());
    }

    public static boolean isNavigationAtBottom(Activity activity) {
        return new C8269a(activity).mo61635a();
    }

    public static boolean isNavigationAtBottom(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return isNavigationAtBottom((Activity) fragment.getActivity());
    }

    public static boolean isNavigationAtBottom(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return isNavigationAtBottom(fragment.getActivity());
    }

    public static int getStatusBarHeight(Activity activity) {
        return new C8269a(activity).mo61636b();
    }

    public static int getStatusBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getStatusBarHeight((Activity) fragment.getActivity());
    }

    public static int getStatusBarHeight(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getStatusBarHeight(fragment.getActivity());
    }

    public static int getActionBarHeight(Activity activity) {
        return new C8269a(activity).mo61637c();
    }

    public static int getActionBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getActionBarHeight((Activity) fragment.getActivity());
    }

    public static int getActionBarHeight(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getActionBarHeight(fragment.getActivity());
    }

    public static boolean hasNotchScreen(Activity activity) {
        return NotchUtils.hasNotchScreen(activity);
    }

    public static boolean hasNotchScreen(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNotchScreen((Activity) fragment.getActivity());
    }

    public static boolean hasNotchScreen(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNotchScreen(fragment.getActivity());
    }

    public static boolean hasNotchScreen(View view) {
        return NotchUtils.hasNotchScreen(view);
    }

    public static int getNotchHeight(Activity activity) {
        if (hasNotchScreen(activity)) {
            return NotchUtils.getNotchHeight(activity);
        }
        return 0;
    }

    public static int getNotchHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNotchHeight((Activity) fragment.getActivity());
    }

    public static int getNotchHeight(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNotchHeight(fragment.getActivity());
    }

    public static void hideStatusBar(Window window) {
        window.setFlags(1024, 1024);
    }

    public static void showStatusBar(Window window) {
        window.clearFlags(1024);
    }

    ImmersionBar(Activity activity) {
        this.f19586i = false;
        this.f19587j = false;
        this.f19588k = false;
        this.f19589l = false;
        this.f19592o = 0;
        this.f19593p = 0;
        this.f19594q = 0;
        this.f19595r = null;
        this.f19596s = new HashMap();
        this.f19597t = 0;
        this.f19598u = false;
        this.f19599v = false;
        this.f19600w = false;
        this.f19601x = 0;
        this.f19602y = 0;
        this.f19603z = 0;
        this.f19577A = 0;
        this.f19586i = true;
        this.f19578a = activity;
        m16629a(activity.getWindow());
    }

    ImmersionBar(Fragment fragment) {
        this.f19586i = false;
        this.f19587j = false;
        this.f19588k = false;
        this.f19589l = false;
        this.f19592o = 0;
        this.f19593p = 0;
        this.f19594q = 0;
        this.f19595r = null;
        this.f19596s = new HashMap();
        this.f19597t = 0;
        this.f19598u = false;
        this.f19599v = false;
        this.f19600w = false;
        this.f19601x = 0;
        this.f19602y = 0;
        this.f19603z = 0;
        this.f19577A = 0;
        this.f19587j = true;
        this.f19578a = fragment.getActivity();
        this.f19579b = fragment;
        m16624I();
        m16629a(this.f19578a.getWindow());
    }

    ImmersionBar(android.app.Fragment fragment) {
        this.f19586i = false;
        this.f19587j = false;
        this.f19588k = false;
        this.f19589l = false;
        this.f19592o = 0;
        this.f19593p = 0;
        this.f19594q = 0;
        this.f19595r = null;
        this.f19596s = new HashMap();
        this.f19597t = 0;
        this.f19598u = false;
        this.f19599v = false;
        this.f19600w = false;
        this.f19601x = 0;
        this.f19602y = 0;
        this.f19603z = 0;
        this.f19577A = 0;
        this.f19587j = true;
        this.f19578a = fragment.getActivity();
        this.f19580c = fragment;
        m16624I();
        m16629a(this.f19578a.getWindow());
    }

    ImmersionBar(DialogFragment dialogFragment) {
        this.f19586i = false;
        this.f19587j = false;
        this.f19588k = false;
        this.f19589l = false;
        this.f19592o = 0;
        this.f19593p = 0;
        this.f19594q = 0;
        this.f19595r = null;
        this.f19596s = new HashMap();
        this.f19597t = 0;
        this.f19598u = false;
        this.f19599v = false;
        this.f19600w = false;
        this.f19601x = 0;
        this.f19602y = 0;
        this.f19603z = 0;
        this.f19577A = 0;
        this.f19589l = true;
        this.f19588k = true;
        this.f19578a = dialogFragment.getActivity();
        this.f19579b = dialogFragment;
        this.f19581d = dialogFragment.getDialog();
        m16624I();
        m16629a(this.f19581d.getWindow());
    }

    ImmersionBar(android.app.DialogFragment dialogFragment) {
        this.f19586i = false;
        this.f19587j = false;
        this.f19588k = false;
        this.f19589l = false;
        this.f19592o = 0;
        this.f19593p = 0;
        this.f19594q = 0;
        this.f19595r = null;
        this.f19596s = new HashMap();
        this.f19597t = 0;
        this.f19598u = false;
        this.f19599v = false;
        this.f19600w = false;
        this.f19601x = 0;
        this.f19602y = 0;
        this.f19603z = 0;
        this.f19577A = 0;
        this.f19589l = true;
        this.f19588k = true;
        this.f19578a = dialogFragment.getActivity();
        this.f19580c = dialogFragment;
        this.f19581d = dialogFragment.getDialog();
        m16624I();
        m16629a(this.f19581d.getWindow());
    }

    ImmersionBar(Activity activity, Dialog dialog) {
        this.f19586i = false;
        this.f19587j = false;
        this.f19588k = false;
        this.f19589l = false;
        this.f19592o = 0;
        this.f19593p = 0;
        this.f19594q = 0;
        this.f19595r = null;
        this.f19596s = new HashMap();
        this.f19597t = 0;
        this.f19598u = false;
        this.f19599v = false;
        this.f19600w = false;
        this.f19601x = 0;
        this.f19602y = 0;
        this.f19603z = 0;
        this.f19577A = 0;
        this.f19589l = true;
        this.f19578a = activity;
        this.f19581d = dialog;
        m16624I();
        m16629a(this.f19581d.getWindow());
    }

    /* renamed from: I */
    private void m16624I() {
        if (this.f19585h == null) {
            this.f19585h = with(this.f19578a);
        }
        ImmersionBar immersionBar = this.f19585h;
        if (immersionBar != null && !immersionBar.f19598u) {
            immersionBar.init();
        }
    }

    /* renamed from: a */
    private void m16629a(Window window) {
        this.f19582e = window;
        this.f19590m = new BarParams();
        ViewGroup viewGroup = (ViewGroup) this.f19582e.getDecorView();
        this.f19583f = viewGroup;
        this.f19584g = (ViewGroup) viewGroup.findViewById(16908290);
    }

    public ImmersionBar transparentStatusBar() {
        this.f19590m.statusBarColor = 0;
        return this;
    }

    public ImmersionBar transparentNavigationBar() {
        this.f19590m.navigationBarColor = 0;
        this.f19590m.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentBar() {
        this.f19590m.statusBarColor = 0;
        this.f19590m.navigationBarColor = 0;
        this.f19590m.fullScreen = true;
        return this;
    }

    public ImmersionBar statusBarColor(int i) {
        return statusBarColorInt(ContextCompat.getColor(this.f19578a, i));
    }

    public ImmersionBar statusBarColor(int i, float f) {
        return statusBarColorInt(ContextCompat.getColor(this.f19578a, i), f);
    }

    public ImmersionBar statusBarColor(int i, int i2, float f) {
        return statusBarColorInt(ContextCompat.getColor(this.f19578a, i), ContextCompat.getColor(this.f19578a, i2), f);
    }

    public ImmersionBar statusBarColor(String str) {
        return statusBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColor(String str, float f) {
        return statusBarColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar statusBarColor(String str, String str2, float f) {
        return statusBarColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar statusBarColorInt(int i) {
        this.f19590m.statusBarColor = i;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i, float f) {
        this.f19590m.statusBarColor = i;
        this.f19590m.statusBarAlpha = f;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i, int i2, float f) {
        this.f19590m.statusBarColor = i;
        this.f19590m.statusBarColorTransform = i2;
        this.f19590m.statusBarAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarColor(int i) {
        return navigationBarColorInt(ContextCompat.getColor(this.f19578a, i));
    }

    public ImmersionBar navigationBarColor(int i, float f) {
        return navigationBarColorInt(ContextCompat.getColor(this.f19578a, i), f);
    }

    public ImmersionBar navigationBarColor(int i, int i2, float f) {
        return navigationBarColorInt(ContextCompat.getColor(this.f19578a, i), ContextCompat.getColor(this.f19578a, i2), f);
    }

    public ImmersionBar navigationBarColor(String str) {
        return navigationBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColor(String str, float f) {
        return navigationBarColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar navigationBarColor(String str, String str2, float f) {
        return navigationBarColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar navigationBarColorInt(int i) {
        this.f19590m.navigationBarColor = i;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int i, float f) {
        this.f19590m.navigationBarColor = i;
        this.f19590m.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int i, int i2, float f) {
        this.f19590m.navigationBarColor = i;
        this.f19590m.navigationBarColorTransform = i2;
        this.f19590m.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar barColor(int i) {
        return barColorInt(ContextCompat.getColor(this.f19578a, i));
    }

    public ImmersionBar barColor(int i, float f) {
        return barColorInt(ContextCompat.getColor(this.f19578a, i), (float) i);
    }

    public ImmersionBar barColor(int i, int i2, float f) {
        return barColorInt(ContextCompat.getColor(this.f19578a, i), ContextCompat.getColor(this.f19578a, i2), f);
    }

    public ImmersionBar barColor(String str) {
        return barColorInt(Color.parseColor(str));
    }

    public ImmersionBar barColor(String str, float f) {
        return barColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar barColor(String str, String str2, float f) {
        return barColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar barColorInt(int i) {
        this.f19590m.statusBarColor = i;
        this.f19590m.navigationBarColor = i;
        return this;
    }

    public ImmersionBar barColorInt(int i, float f) {
        this.f19590m.statusBarColor = i;
        this.f19590m.navigationBarColor = i;
        this.f19590m.statusBarAlpha = f;
        this.f19590m.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar barColorInt(int i, int i2, float f) {
        this.f19590m.statusBarColor = i;
        this.f19590m.navigationBarColor = i;
        this.f19590m.statusBarColorTransform = i2;
        this.f19590m.navigationBarColorTransform = i2;
        this.f19590m.statusBarAlpha = f;
        this.f19590m.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar statusBarColorTransform(int i) {
        return statusBarColorTransformInt(ContextCompat.getColor(this.f19578a, i));
    }

    public ImmersionBar statusBarColorTransform(String str) {
        return statusBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColorTransformInt(int i) {
        this.f19590m.statusBarColorTransform = i;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(int i) {
        return navigationBarColorTransformInt(ContextCompat.getColor(this.f19578a, i));
    }

    public ImmersionBar navigationBarColorTransform(String str) {
        return navigationBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColorTransformInt(int i) {
        this.f19590m.navigationBarColorTransform = i;
        return this;
    }

    public ImmersionBar barColorTransform(int i) {
        return barColorTransformInt(ContextCompat.getColor(this.f19578a, i));
    }

    public ImmersionBar barColorTransform(String str) {
        return barColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar barColorTransformInt(int i) {
        this.f19590m.statusBarColorTransform = i;
        this.f19590m.navigationBarColorTransform = i;
        return this;
    }

    public ImmersionBar addViewSupportTransformColor(View view) {
        return addViewSupportTransformColorInt(view, this.f19590m.statusBarColorTransform);
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.f19578a, i));
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i, int i2) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.f19578a, i), ContextCompat.getColor(this.f19578a, i2));
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str));
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str, String str2) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str), Color.parseColor(str2));
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i) {
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(this.f19590m.statusBarColor), Integer.valueOf(i));
            this.f19590m.f19560a.put(view, hashMap);
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i, int i2) {
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
            this.f19590m.f19560a.put(view, hashMap);
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar viewAlpha(float f) {
        this.f19590m.viewAlpha = f;
        return this;
    }

    public ImmersionBar removeSupportView(View view) {
        if (view != null) {
            Map map = this.f19590m.f19560a.get(view);
            if (!(map == null || map.size() == 0)) {
                this.f19590m.f19560a.remove(view);
            }
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar removeSupportAllView() {
        if (this.f19590m.f19560a.size() != 0) {
            this.f19590m.f19560a.clear();
        }
        return this;
    }

    public ImmersionBar fullScreen(boolean z) {
        this.f19590m.fullScreen = z;
        return this;
    }

    public ImmersionBar statusBarAlpha(float f) {
        this.f19590m.statusBarAlpha = f;
        this.f19590m.statusBarTempAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarAlpha(float f) {
        this.f19590m.navigationBarAlpha = f;
        this.f19590m.navigationBarTempAlpha = f;
        return this;
    }

    public ImmersionBar barAlpha(float f) {
        this.f19590m.statusBarAlpha = f;
        this.f19590m.statusBarTempAlpha = f;
        this.f19590m.navigationBarAlpha = f;
        this.f19590m.navigationBarTempAlpha = f;
        return this;
    }

    public ImmersionBar autoDarkModeEnable(boolean z) {
        return autoDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoDarkModeEnable(boolean z, float f) {
        this.f19590m.autoStatusBarDarkModeEnable = z;
        this.f19590m.autoStatusBarDarkModeAlpha = f;
        this.f19590m.autoNavigationBarDarkModeEnable = z;
        this.f19590m.autoNavigationBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z) {
        return autoStatusBarDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z, float f) {
        this.f19590m.autoStatusBarDarkModeEnable = z;
        this.f19590m.autoStatusBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z) {
        return autoNavigationBarDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z, float f) {
        this.f19590m.autoNavigationBarDarkModeEnable = z;
        this.f19590m.autoNavigationBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean z) {
        return statusBarDarkFont(z, 0.2f);
    }

    public ImmersionBar statusBarDarkFont(boolean z, float f) {
        this.f19590m.statusBarDarkFont = z;
        if (!z || isSupportStatusBarDarkFont()) {
            BarParams barParams = this.f19590m;
            barParams.flymeOSStatusBarFontColor = barParams.flymeOSStatusBarFontTempColor;
            BarParams barParams2 = this.f19590m;
            barParams2.statusBarAlpha = barParams2.statusBarTempAlpha;
        } else {
            this.f19590m.statusBarAlpha = f;
        }
        return this;
    }

    public ImmersionBar navigationBarDarkIcon(boolean z) {
        return navigationBarDarkIcon(z, 0.2f);
    }

    public ImmersionBar navigationBarDarkIcon(boolean z, float f) {
        this.f19590m.navigationBarDarkIcon = z;
        if (!z || isSupportNavigationIconDark()) {
            BarParams barParams = this.f19590m;
            barParams.navigationBarAlpha = barParams.navigationBarTempAlpha;
        } else {
            this.f19590m.navigationBarAlpha = f;
        }
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(int i) {
        this.f19590m.flymeOSStatusBarFontColor = ContextCompat.getColor(this.f19578a, i);
        BarParams barParams = this.f19590m;
        barParams.flymeOSStatusBarFontTempColor = barParams.flymeOSStatusBarFontColor;
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(String str) {
        this.f19590m.flymeOSStatusBarFontColor = Color.parseColor(str);
        BarParams barParams = this.f19590m;
        barParams.flymeOSStatusBarFontTempColor = barParams.flymeOSStatusBarFontColor;
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColorInt(int i) {
        this.f19590m.flymeOSStatusBarFontColor = i;
        BarParams barParams = this.f19590m;
        barParams.flymeOSStatusBarFontTempColor = barParams.flymeOSStatusBarFontColor;
        return this;
    }

    public ImmersionBar hideBar(BarHide barHide) {
        this.f19590m.barHide = barHide;
        if (Build.VERSION.SDK_INT == 19 || OSUtils.isEMUI3_x()) {
            BarParams barParams = this.f19590m;
            barParams.hideNavigationBar = barParams.barHide == BarHide.FLAG_HIDE_NAVIGATION_BAR || this.f19590m.barHide == BarHide.FLAG_HIDE_BAR;
        }
        return this;
    }

    public ImmersionBar applySystemFits(boolean z) {
        this.f19590m.fitsLayoutOverlapEnable = !z;
        setFitsSystemWindows(this.f19578a, z);
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean z) {
        this.f19590m.fits = z;
        if (!this.f19590m.fits) {
            this.f19597t = 0;
        } else if (this.f19597t == 0) {
            this.f19597t = 4;
        }
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.f19578a, i));
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i, int i2, float f) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.f19578a, i), ContextCompat.getColor(this.f19578a, i2), f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i) {
        return fitsSystemWindowsInt(z, i, -16777216, 0.0f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i, int i2, float f) {
        this.f19590m.fits = z;
        this.f19590m.contentColor = i;
        this.f19590m.contentColorTransform = i2;
        this.f19590m.contentAlpha = f;
        if (!this.f19590m.fits) {
            this.f19597t = 0;
        } else if (this.f19597t == 0) {
            this.f19597t = 4;
        }
        this.f19584g.setBackgroundColor(ColorUtils.blendARGB(this.f19590m.contentColor, this.f19590m.contentColorTransform, this.f19590m.contentAlpha));
        return this;
    }

    public ImmersionBar fitsLayoutOverlapEnable(boolean z) {
        this.f19590m.fitsLayoutOverlapEnable = z;
        return this;
    }

    public ImmersionBar statusBarView(View view) {
        if (view == null) {
            return this;
        }
        this.f19590m.statusBarView = view;
        if (this.f19597t == 0) {
            this.f19597t = 3;
        }
        return this;
    }

    public ImmersionBar statusBarView(int i) {
        return statusBarView(this.f19578a.findViewById(i));
    }

    public ImmersionBar statusBarView(int i, View view) {
        return statusBarView(view.findViewById(i));
    }

    public ImmersionBar titleBar(View view) {
        return view == null ? this : titleBar(view, true);
    }

    public ImmersionBar titleBar(View view, boolean z) {
        if (view == null) {
            return this;
        }
        if (this.f19597t == 0) {
            this.f19597t = 1;
        }
        this.f19590m.titleBarView = view;
        this.f19590m.statusBarColorEnabled = z;
        return this;
    }

    public ImmersionBar titleBar(int i) {
        return titleBar(i, true);
    }

    public ImmersionBar titleBar(int i, boolean z) {
        Fragment fragment = this.f19579b;
        if (fragment != null && fragment.getView() != null) {
            return titleBar(this.f19579b.getView().findViewById(i), z);
        }
        android.app.Fragment fragment2 = this.f19580c;
        if (fragment2 == null || fragment2.getView() == null) {
            return titleBar(this.f19578a.findViewById(i), z);
        }
        return titleBar(this.f19580c.getView().findViewById(i), z);
    }

    public ImmersionBar titleBar(int i, View view) {
        return titleBar(view.findViewById(i), true);
    }

    public ImmersionBar titleBar(int i, View view, boolean z) {
        return titleBar(view.findViewById(i), z);
    }

    public ImmersionBar titleBarMarginTop(int i) {
        Fragment fragment = this.f19579b;
        if (fragment != null && fragment.getView() != null) {
            return titleBarMarginTop(this.f19579b.getView().findViewById(i));
        }
        android.app.Fragment fragment2 = this.f19580c;
        if (fragment2 == null || fragment2.getView() == null) {
            return titleBarMarginTop(this.f19578a.findViewById(i));
        }
        return titleBarMarginTop(this.f19580c.getView().findViewById(i));
    }

    public ImmersionBar titleBarMarginTop(int i, View view) {
        return titleBarMarginTop(view.findViewById(i));
    }

    public ImmersionBar titleBarMarginTop(View view) {
        if (view == null) {
            return this;
        }
        if (this.f19597t == 0) {
            this.f19597t = 2;
        }
        this.f19590m.titleBarView = view;
        return this;
    }

    public ImmersionBar supportActionBar(boolean z) {
        this.f19590m.isSupportActionBar = z;
        return this;
    }

    public ImmersionBar statusBarColorTransformEnable(boolean z) {
        this.f19590m.statusBarColorEnabled = z;
        return this;
    }

    public ImmersionBar reset() {
        this.f19590m = new BarParams();
        this.f19597t = 0;
        return this;
    }

    public ImmersionBar addTag(String str) {
        if (!m16630a(str)) {
            this.f19596s.put(str, this.f19590m.clone());
            return this;
        }
        throw new IllegalArgumentException("tag不能为空");
    }

    public ImmersionBar getTag(String str) {
        if (!m16630a(str)) {
            BarParams barParams = this.f19596s.get(str);
            if (barParams != null) {
                this.f19590m = barParams.clone();
            }
            return this;
        }
        throw new IllegalArgumentException("tag不能为空");
    }

    public ImmersionBar keyboardEnable(boolean z) {
        return keyboardEnable(z, this.f19590m.keyboardMode);
    }

    public ImmersionBar keyboardEnable(boolean z, int i) {
        this.f19590m.keyboardEnable = z;
        this.f19590m.keyboardMode = i;
        this.f19600w = z;
        return this;
    }

    public ImmersionBar keyboardMode(int i) {
        this.f19590m.keyboardMode = i;
        return this;
    }

    public ImmersionBar setOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        if (this.f19590m.f19561b == null) {
            this.f19590m.f19561b = onKeyboardListener;
        }
        return this;
    }

    public ImmersionBar setOnNavigationBarListener(OnNavigationBarListener onNavigationBarListener) {
        if (onNavigationBarListener != null) {
            if (this.f19590m.f19562c == null) {
                this.f19590m.f19562c = onNavigationBarListener;
                NavigationBarObserver.m16661a().mo61616a(this.f19590m.f19562c);
            }
        } else if (this.f19590m.f19562c != null) {
            NavigationBarObserver.m16661a().mo61617b(this.f19590m.f19562c);
            this.f19590m.f19562c = null;
        }
        return this;
    }

    public ImmersionBar setOnBarListener(OnBarListener onBarListener) {
        if (onBarListener != null) {
            if (this.f19590m.f19563d == null) {
                this.f19590m.f19563d = onBarListener;
            }
        } else if (this.f19590m.f19563d != null) {
            this.f19590m.f19563d = null;
        }
        return this;
    }

    public ImmersionBar navigationBarEnable(boolean z) {
        this.f19590m.navigationBarEnable = z;
        return this;
    }

    public ImmersionBar navigationBarWithKitkatEnable(boolean z) {
        this.f19590m.navigationBarWithKitkatEnable = z;
        return this;
    }

    public ImmersionBar navigationBarWithEMUI3Enable(boolean z) {
        if (OSUtils.isEMUI3_x()) {
            this.f19590m.navigationBarWithEMUI3Enable = z;
            this.f19590m.navigationBarWithKitkatEnable = z;
        }
        return this;
    }

    public ImmersionBar barEnable(boolean z) {
        this.f19590m.barEnable = z;
        return this;
    }

    /* renamed from: J */
    private static RequestManagerRetriever m16625J() {
        return RequestManagerRetriever.m16679a();
    }

    /* renamed from: a */
    private static boolean m16630a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
