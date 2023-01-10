package com.didi.rfusion.widget.floating;

/* renamed from: com.didi.rfusion.widget.floating.c */
/* compiled from: RFFloatingNavBarModel */
class C12383c implements Cloneable {

    /* renamed from: a */
    RFFloatingTextAttr f36342a;

    /* renamed from: b */
    RFFloatingIconAttr f36343b;

    /* renamed from: c */
    RFFloatingTextAttr f36344c;

    /* renamed from: d */
    boolean f36345d;

    /* renamed from: e */
    boolean f36346e;

    /* renamed from: f */
    int f36347f;

    C12383c() {
    }

    C12383c(RFFloatingTextAttr rFFloatingTextAttr, RFFloatingIconAttr rFFloatingIconAttr, RFFloatingTextAttr rFFloatingTextAttr2, boolean z, boolean z2, int i) {
        this.f36342a = rFFloatingTextAttr;
        this.f36343b = rFFloatingIconAttr;
        this.f36344c = rFFloatingTextAttr2;
        this.f36345d = z;
        this.f36346e = z2;
        this.f36347f = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C12383c clone() {
        try {
            return (C12383c) super.clone();
        } catch (Exception e) {
            C12383c cVar = new C12383c();
            e.printStackTrace();
            return cVar;
        }
    }
}
