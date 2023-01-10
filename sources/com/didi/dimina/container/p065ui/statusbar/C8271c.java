package com.didi.dimina.container.p065ui.statusbar;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.dimina.container.ui.statusbar.c */
/* compiled from: FitsKeyboard */
class C8271c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    private final ImmersionBar f19646a;

    /* renamed from: b */
    private final Window f19647b;

    /* renamed from: c */
    private final View f19648c;

    /* renamed from: d */
    private final View f19649d;

    /* renamed from: e */
    private View f19650e;

    /* renamed from: f */
    private int f19651f = 0;

    /* renamed from: g */
    private int f19652g = 0;

    /* renamed from: h */
    private int f19653h = 0;

    /* renamed from: i */
    private int f19654i = 0;

    /* renamed from: j */
    private int f19655j;

    /* renamed from: k */
    private boolean f19656k;

    /* renamed from: l */
    private View f19657l;

    /* JADX WARNING: type inference failed for: r4v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    C8271c(com.didi.dimina.container.p065ui.statusbar.ImmersionBar r4) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.f19651f = r0
            r3.f19652g = r0
            r3.f19653h = r0
            r3.f19654i = r0
            r3.f19646a = r4
            android.view.Window r1 = r4.mo61543i()
            r3.f19647b = r1
            android.view.View r1 = r1.getDecorView()
            r3.f19648c = r1
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            boolean r2 = r4.mo61551m()
            if (r2 == 0) goto L_0x0043
            androidx.fragment.app.Fragment r0 = r4.mo61545j()
            if (r0 == 0) goto L_0x0036
            android.view.View r4 = r0.getView()
            r3.f19650e = r4
            goto L_0x0057
        L_0x0036:
            android.app.Fragment r4 = r4.mo61546k()
            if (r4 == 0) goto L_0x0057
            android.view.View r4 = r4.getView()
            r3.f19650e = r4
            goto L_0x0057
        L_0x0043:
            android.view.View r4 = r1.getChildAt(r0)
            r3.f19650e = r4
            if (r4 == 0) goto L_0x0057
            boolean r2 = r4 instanceof androidx.drawerlayout.widget.DrawerLayout
            if (r2 == 0) goto L_0x0057
            androidx.drawerlayout.widget.DrawerLayout r4 = (androidx.drawerlayout.widget.DrawerLayout) r4
            android.view.View r4 = r4.getChildAt(r0)
            r3.f19650e = r4
        L_0x0057:
            android.view.View r4 = r3.f19650e
            if (r4 == 0) goto L_0x0079
            int r4 = r4.getPaddingLeft()
            r3.f19651f = r4
            android.view.View r4 = r3.f19650e
            int r4 = r4.getPaddingTop()
            r3.f19652g = r4
            android.view.View r4 = r3.f19650e
            int r4 = r4.getPaddingRight()
            r3.f19653h = r4
            android.view.View r4 = r3.f19650e
            int r4 = r4.getPaddingBottom()
            r3.f19654i = r4
        L_0x0079:
            android.view.View r4 = r3.f19650e
            if (r4 == 0) goto L_0x007e
            r1 = r4
        L_0x007e:
            r3.f19649d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p065ui.statusbar.C8271c.<init>(com.didi.dimina.container.ui.statusbar.ImmersionBar):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61642a(int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f19647b.setSoftInputMode(i);
            if (!this.f19656k) {
                if (!(this.f19646a.mo61541h() == null || this.f19646a.mo61541h().isFinishing() || this.f19649d == null)) {
                    if (this.f19657l == null) {
                        this.f19657l = new LinearLayout(this.f19646a.mo61541h());
                    }
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
                    layoutParams.width = 0;
                    layoutParams.height = -1;
                    layoutParams.softInputMode = 16;
                    try {
                        this.f19646a.mo61541h().getWindowManager().addView(this.f19657l, layoutParams);
                        this.f19657l.getViewTreeObserver().addOnGlobalLayoutListener(this);
                    } catch (Exception e) {
                        SystemUtils.log(6, "FitsKeyboard", e.getMessage(), (Throwable) null, "com.didi.dimina.container.ui.statusbar.FitsKeyboard", 82);
                    }
                }
                this.f19656k = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61641a() {
        if (Build.VERSION.SDK_INT >= 19 && this.f19656k) {
            if (this.f19650e != null) {
                this.f19649d.setPadding(this.f19651f, this.f19652g, this.f19653h, this.f19654i);
            } else {
                this.f19649d.setPadding(this.f19646a.mo61525d(), this.f19646a.mo61526e(), this.f19646a.mo61527f(), this.f19646a.mo61538g());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo61643b() {
        if (Build.VERSION.SDK_INT >= 19 && this.f19656k) {
            View view = this.f19657l;
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            this.f19656k = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        if (r3 > r1) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        if (r3 > r1) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008c, code lost:
        if (r3 > r1) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onGlobalLayout() {
        /*
            r7 = this;
            com.didi.dimina.container.ui.statusbar.ImmersionBar r0 = r7.f19646a
            if (r0 == 0) goto L_0x00ce
            com.didi.dimina.container.ui.statusbar.BarParams r0 = r0.getBarParams()
            if (r0 == 0) goto L_0x00ce
            com.didi.dimina.container.ui.statusbar.ImmersionBar r0 = r7.f19646a
            com.didi.dimina.container.ui.statusbar.BarParams r0 = r0.getBarParams()
            boolean r0 = r0.keyboardEnable
            if (r0 == 0) goto L_0x00ce
            android.view.View r0 = r7.f19657l
            if (r0 == 0) goto L_0x00ce
            com.didi.dimina.container.ui.statusbar.ImmersionBar r0 = r7.f19646a
            com.didi.dimina.container.ui.statusbar.a r0 = r0.mo61571o()
            boolean r1 = r0.mo61635a()
            if (r1 == 0) goto L_0x0029
            int r1 = r0.mo61639e()
            goto L_0x002d
        L_0x0029:
            int r1 = r0.mo61640f()
        L_0x002d:
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            android.view.View r3 = r7.f19657l
            r3.getWindowVisibleDisplayFrame(r2)
            android.view.View r3 = r7.f19649d
            int r3 = r3.getHeight()
            int r2 = r2.bottom
            int r3 = r3 - r2
            int r2 = r7.f19655j
            if (r3 == r2) goto L_0x00ce
            r7.f19655j = r3
            android.view.Window r2 = r7.f19647b
            android.view.View r2 = r2.getDecorView()
            r4 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r2 = r2.findViewById(r4)
            boolean r2 = com.didi.dimina.container.p065ui.statusbar.ImmersionBar.checkFitsSystemWindows(r2)
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L_0x008b
            android.view.View r2 = r7.f19650e
            if (r2 == 0) goto L_0x0087
            com.didi.dimina.container.ui.statusbar.ImmersionBar r2 = r7.f19646a
            com.didi.dimina.container.ui.statusbar.BarParams r2 = r2.getBarParams()
            boolean r2 = r2.isSupportActionBar
            if (r2 == 0) goto L_0x0075
            com.didi.dimina.container.ui.statusbar.ImmersionBar r2 = r7.f19646a
            int r2 = r2.mo61573p()
            int r6 = r0.mo61636b()
            int r2 = r2 + r6
            int r3 = r3 + r2
        L_0x0075:
            com.didi.dimina.container.ui.statusbar.ImmersionBar r2 = r7.f19646a
            com.didi.dimina.container.ui.statusbar.BarParams r2 = r2.getBarParams()
            boolean r2 = r2.fits
            if (r2 == 0) goto L_0x0084
            int r2 = r0.mo61636b()
            int r3 = r3 + r2
        L_0x0084:
            if (r3 <= r1) goto L_0x008f
            goto L_0x0090
        L_0x0087:
            int r3 = r3 - r1
            if (r3 <= r1) goto L_0x008f
            goto L_0x0090
        L_0x008b:
            int r3 = r3 - r1
            if (r3 <= r1) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r5 = 0
        L_0x0090:
            if (r3 >= 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r4 = r3
        L_0x0094:
            com.didi.dimina.container.ui.statusbar.ImmersionBar r1 = r7.f19646a
            com.didi.dimina.container.ui.statusbar.BarParams r1 = r1.getBarParams()
            com.didi.dimina.container.ui.statusbar.OnKeyboardListener r1 = r1.f19561b
            if (r1 == 0) goto L_0x00bb
            com.didi.dimina.container.ui.statusbar.ImmersionBar r1 = r7.f19646a
            com.didi.dimina.container.ui.statusbar.BarParams r1 = r1.getBarParams()
            com.didi.dimina.container.ui.statusbar.OnKeyboardListener r1 = r1.f19561b
            android.view.View r2 = r7.f19649d
            int r2 = r2.getHeight()
            com.didi.dimina.container.ui.statusbar.ImmersionBar r3 = r7.f19646a
            int r3 = r3.mo61573p()
            int r2 = r2 - r3
            int r0 = r0.mo61636b()
            int r2 = r2 - r0
            r1.onKeyboardChange(r5, r4, r2)
        L_0x00bb:
            if (r5 != 0) goto L_0x00ce
            com.didi.dimina.container.ui.statusbar.ImmersionBar r0 = r7.f19646a
            com.didi.dimina.container.ui.statusbar.BarParams r0 = r0.getBarParams()
            com.didi.dimina.container.ui.statusbar.BarHide r0 = r0.barHide
            com.didi.dimina.container.ui.statusbar.BarHide r1 = com.didi.dimina.container.p065ui.statusbar.BarHide.FLAG_SHOW_BAR
            if (r0 == r1) goto L_0x00ce
            com.didi.dimina.container.ui.statusbar.ImmersionBar r0 = r7.f19646a
            r0.mo61524c()
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p065ui.statusbar.C8271c.onGlobalLayout():void");
    }
}
