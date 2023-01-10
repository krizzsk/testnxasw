package com.didi.app.nova.skeleton.dialog;

/* renamed from: com.didi.app.nova.skeleton.dialog.a */
/* compiled from: DialogTransaction */
final class C4279a {

    /* renamed from: a */
    private Dialog f10274a;

    /* renamed from: b */
    private String f10275b;

    /* renamed from: a */
    public static C4279a m9019a(Dialog dialog) {
        return new C4279a(dialog);
    }

    private C4279a(Dialog dialog) {
        this.f10274a = dialog;
    }

    /* renamed from: a */
    public C4279a mo45799a(String str) {
        this.f10275b = str;
        return this;
    }

    /* renamed from: a */
    public TransformAnimation mo45798a() {
        return this.f10274a.getEnterAnimation();
    }

    /* renamed from: b */
    public TransformAnimation mo45800b() {
        return this.f10274a.getExitAnimation();
    }

    /* renamed from: c */
    public String mo45801c() {
        return this.f10275b;
    }

    /* renamed from: d */
    public Dialog mo45802d() {
        return this.f10274a;
    }
}
