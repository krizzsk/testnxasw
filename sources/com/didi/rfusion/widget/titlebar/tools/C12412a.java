package com.didi.rfusion.widget.titlebar.tools;

import android.view.View;
import androidx.core.view.ViewCompat;

/* renamed from: com.didi.rfusion.widget.titlebar.tools.a */
/* compiled from: RFViewOffsetHelper */
class C12412a {

    /* renamed from: a */
    private final View f36754a;

    /* renamed from: b */
    private int f36755b;

    /* renamed from: c */
    private int f36756c;

    /* renamed from: d */
    private int f36757d;

    /* renamed from: e */
    private int f36758e;

    /* renamed from: f */
    private boolean f36759f = true;

    /* renamed from: g */
    private boolean f36760g = true;

    public C12412a(View view) {
        this.f36754a = view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo95002a() {
        this.f36755b = this.f36754a.getTop();
        this.f36756c = this.f36754a.getLeft();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo95005b() {
        View view = this.f36754a;
        ViewCompat.offsetTopAndBottom(view, this.f36757d - (view.getTop() - this.f36755b));
        View view2 = this.f36754a;
        ViewCompat.offsetLeftAndRight(view2, this.f36758e - (view2.getLeft() - this.f36756c));
    }

    /* renamed from: a */
    public boolean mo95004a(int i) {
        if (!this.f36759f || this.f36757d == i) {
            return false;
        }
        this.f36757d = i;
        mo95005b();
        return true;
    }

    /* renamed from: b */
    public boolean mo95007b(int i) {
        if (!this.f36760g || this.f36758e == i) {
            return false;
        }
        this.f36758e = i;
        mo95005b();
        return true;
    }

    /* renamed from: c */
    public int mo95008c() {
        return this.f36757d;
    }

    /* renamed from: d */
    public int mo95009d() {
        return this.f36758e;
    }

    /* renamed from: e */
    public int mo95010e() {
        return this.f36755b;
    }

    /* renamed from: f */
    public int mo95011f() {
        return this.f36756c;
    }

    /* renamed from: a */
    public void mo95003a(boolean z) {
        this.f36759f = z;
    }

    /* renamed from: g */
    public boolean mo95012g() {
        return this.f36759f;
    }

    /* renamed from: b */
    public void mo95006b(boolean z) {
        this.f36760g = z;
    }

    /* renamed from: h */
    public boolean mo95013h() {
        return this.f36760g;
    }
}
