package com.didi.soda.uiwidget.cardview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;

/* renamed from: com.didi.soda.uiwidget.cardview.c */
/* compiled from: SodaCardViewBaseImpl */
class C15002c implements C15004e {

    /* renamed from: a */
    final RectF f46407a = new RectF();

    /* renamed from: f */
    public void mo115607f(C15003d dVar) {
    }

    C15002c() {
    }

    /* renamed from: a */
    public float mo115594a(C15003d dVar) {
        return m34544m(dVar).mo115583f();
    }

    /* renamed from: b */
    public float mo115598b(C15003d dVar) {
        return m34544m(dVar).mo115584g();
    }

    /* renamed from: c */
    public float mo115601c(C15003d dVar) {
        return m34544m(dVar).mo115589i();
    }

    /* renamed from: d */
    public float mo115604d(C15003d dVar) {
        return m34544m(dVar).mo115588h();
    }

    /* renamed from: e */
    public float mo115606e(C15003d dVar) {
        return m34544m(dVar).mo115582e();
    }

    /* renamed from: a */
    public void mo115593a() {
        SodaRoundRectDrawableWithShadow.f46387a = new SodaCardViewBaseImpl$1(this);
    }

    /* renamed from: a */
    public void mo115597a(C15003d dVar, Context context, int i, float f, float f2, float f3, float f4, int i2, int i3) {
        SodaRoundRectDrawableWithShadow a = m34543a(context, i, f, f2, f3, f4, i2, i3);
        a.mo115571a(dVar.getPreventCornerOverlap());
        C15003d dVar2 = dVar;
        dVar.setCardBackground(a);
        mo115613l(dVar);
    }

    /* renamed from: g */
    public void mo115608g(C15003d dVar) {
        m34544m(dVar).mo115571a(dVar.getPreventCornerOverlap());
        mo115613l(dVar);
    }

    /* renamed from: a */
    public void mo115596a(C15003d dVar, int i) {
        m34544m(dVar).mo115569a(i);
    }

    /* renamed from: h */
    public int mo115609h(C15003d dVar) {
        return m34544m(dVar).mo115566a();
    }

    /* renamed from: b */
    public void mo115600b(C15003d dVar, int i) {
        m34544m(dVar).mo115575b(i);
    }

    /* renamed from: c */
    public void mo115603c(C15003d dVar, int i) {
        m34544m(dVar).mo115578c(i);
    }

    /* renamed from: a */
    public void mo115595a(C15003d dVar, float f) {
        m34544m(dVar).mo115574b(f);
    }

    /* renamed from: i */
    public float mo115610i(C15003d dVar) {
        return m34544m(dVar).mo115572b();
    }

    /* renamed from: j */
    public int mo115611j(C15003d dVar) {
        return m34544m(dVar).mo115576c();
    }

    /* renamed from: k */
    public int mo115612k(C15003d dVar) {
        return m34544m(dVar).mo115579d();
    }

    /* renamed from: b */
    public void mo115599b(C15003d dVar, float f) {
        m34544m(dVar).mo115577c(f);
    }

    /* renamed from: c */
    public void mo115602c(C15003d dVar, float f) {
        m34544m(dVar).mo115580d(f);
        mo115613l(dVar);
    }

    /* renamed from: d */
    public void mo115605d(C15003d dVar, float f) {
        m34544m(dVar).mo115567a(f);
        mo115613l(dVar);
    }

    /* renamed from: l */
    public void mo115613l(C15003d dVar) {
        Rect rect = new Rect();
        m34544m(dVar).mo115570a(rect);
        dVar.setMinWidthHeightInternal((int) Math.ceil((double) mo115604d(dVar)), (int) Math.ceil((double) mo115601c(dVar)));
        dVar.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: a */
    private SodaRoundRectDrawableWithShadow m34543a(Context context, int i, float f, float f2, float f3, float f4, int i2, int i3) {
        return new SodaRoundRectDrawableWithShadow(context.getResources(), i, f, f2, f3, f4, i2, i3);
    }

    /* renamed from: m */
    private SodaRoundRectDrawableWithShadow m34544m(C15003d dVar) {
        return (SodaRoundRectDrawableWithShadow) dVar.getCardBackground();
    }
}
