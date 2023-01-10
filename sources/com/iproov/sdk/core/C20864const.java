package com.iproov.sdk.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ToneGenerator;
import com.iproov.sdk.face.model.FaceFeature;
import java.util.List;
import p069native.C2947if;
import p091public.C3560do;
import p091public.C3561for;
import p095switch.C3658case;
import p095switch.C3682while;
import p098try.C3688do;
import p235do.C21820break;
import p235do.C21824for;
import p235do.C21827new;

/* renamed from: com.iproov.sdk.core.const */
/* compiled from: LivenessManager */
class C20864const implements C20892try {

    /* renamed from: a */
    private static final C3658case.C3659do f57053a = C3658case.C3659do.FIT;

    /* renamed from: b */
    private static final C3682while f57054b = new C3682while(0.0d, 0.0d, 0.0d);

    /* renamed from: c */
    private final C2947if f57055c;

    /* renamed from: d */
    private final Rect f57056d;

    /* renamed from: e */
    private final Rect f57057e;

    /* renamed from: f */
    private final C20865do f57058f;

    /* renamed from: g */
    private final C20870final f57059g;

    /* renamed from: h */
    private final C20862class f57060h;

    /* renamed from: i */
    private final C3560do f57061i;

    /* renamed from: j */
    private final int f57062j;

    /* renamed from: k */
    private final ToneGenerator f57063k;

    /* renamed from: l */
    private Rect f57064l;

    /* renamed from: m */
    private C3682while f57065m;

    /* renamed from: n */
    private Cdefault f57066n;

    /* renamed from: o */
    private Rect f57067o;

    /* renamed from: p */
    private Rect f57068p;

    /* renamed from: q */
    private C3682while f57069q;

    /* renamed from: r */
    private C3682while f57070r;

    /* renamed from: s */
    private C3682while f57071s;

    /* renamed from: t */
    private C3682while f57072t;

    /* renamed from: u */
    private C3682while f57073u;

    /* renamed from: v */
    private double f57074v;

    /* renamed from: w */
    private int f57075w = 0;

    /* renamed from: x */
    private double f57076x = 0.0d;

    /* renamed from: com.iproov.sdk.core.const$do */
    /* compiled from: LivenessManager */
    interface C20865do {
        /* renamed from: do */
        void mo171467do(Rect rect, Rect rect2, Rect rect3, Rect rect4);

        /* renamed from: do */
        void mo171468do(Rect rect, RectF rectF);

        /* renamed from: do */
        void mo171469do(C21824for forR, boolean z, RectF rectF);

        /* renamed from: do */
        void mo171470do(Exception exc);
    }

    C20864const(Context context, C21827new newR, C21820break breakR, C20870final finalR, C20865do doVar) {
        this.f57055c = new C2947if(context.getApplicationContext());
        boolean z = !newR.m48219new().isPortrait();
        this.f57056d = new Rect(0, 0, z ? newR.mo171312if().mo180432do() : newR.mo171312if().mo180435if(), z ? newR.mo171312if().mo180435if() : newR.mo171312if().mo180432do());
        this.f57057e = new Rect(0, 0, breakR.mo180435if(), breakR.mo180432do());
        this.f57058f = doVar;
        newR.m48218for();
        this.f57059g = finalR;
        this.f57063k = m43269d();
        int max = Math.max(1, finalR.m48119try());
        this.f57062j = max;
        this.f57060h = new C20862class(doVar, finalR.m48117new(), max);
        this.f57061i = new C3560do(finalR.m48116goto(), finalR.m48118this());
    }

    /* renamed from: a */
    private void m43266a(C21824for forR, RectF rectF) {
        this.f57075w++;
        StringBuilder sb = new StringBuilder();
        sb.append("🏁 Completed checkpoint ");
        sb.append(this.f57075w);
        if (this.f57063k == null) {
            return;
        }
        if (this.f57075w == this.f57059g.m48117new()) {
            this.f57063k.startTone(0, 50);
        } else {
            this.f57063k.startTone(10, 50);
        }
    }

    /* renamed from: b */
    private void m43268b(Rect rect) {
        this.f57058f.mo171467do(m43264a(this.f57064l), m43264a(this.f57068p), m43264a(rect), m43264a(this.f57067o));
    }

    /* renamed from: d */
    private ToneGenerator m43269d() {
        if (this.f57055c.m46613const()) {
            try {
                return new ToneGenerator(3, 100);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public List<C3561for> mo171462a() {
        return this.f57061i.mo43295do();
    }

    /* renamed from: b */
    public C3560do mo171464b() {
        return this.f57061i;
    }

    /* renamed from: c */
    public void mo171465c() {
        this.f57060h.mo171461a();
    }

    /* renamed from: a */
    private Rect m43264a(Rect rect) {
        return C3658case.m7397do(rect, this.f57056d, this.f57057e, f57053a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3688do mo171463a(C21824for forR, Bitmap bitmap, FaceFeature faceFeature, Rect rect) {
        RectF rectF = faceFeature != null ? new RectF(faceFeature.getFaceBounds().left / ((float) rect.width()), faceFeature.getFaceBounds().top / ((float) rect.height()), faceFeature.getFaceBounds().right / ((float) rect.width()), faceFeature.getFaceBounds().bottom / ((float) rect.height())) : null;
        C3688do a = m43265a(forR, faceFeature, rect, rectF);
        if (rectF == null || a == C3688do.NO_FACE_PATH) {
            return a;
        }
        return this.f57060h.mo171460a(forR, bitmap, faceFeature, rectF, a, this.f57075w, mo171466do());
    }

    /* renamed from: a */
    private C3688do m43265a(C21824for forR, FaceFeature faceFeature, Rect rect, RectF rectF) {
        C21824for forR2 = forR;
        RectF rectF2 = rectF;
        if (faceFeature == null) {
            m43268b((Rect) null);
            if (this.f57075w == this.f57059g.m48117new()) {
                return C3688do.END_FACE_PATH;
            }
            return this.f57064l == null ? C3688do.NO_FACE_PATH : C3688do.FACE_PATH;
        }
        Rect rect2 = C3658case.m7397do(C3658case.m7398do(faceFeature.getFaceBounds()), rect, this.f57056d, f57053a);
        m43268b(rect2);
        if (this.f57064l == null) {
            if (m43267a(rectF)) {
                return C3688do.NO_FACE_PATH;
            }
            this.f57064l = rect2;
            this.f57065m = C3658case.m7400do(rect2);
            Cdefault defaultR = new Cdefault(this.f57064l, this.f57056d, this.f57059g);
            this.f57066n = defaultR;
            Rect a = defaultR.mo171471a(this.f57056d);
            this.f57067o = a;
            RectF rectF3 = C3658case.m7399do(a, this.f57056d);
            StringBuilder sb = new StringBuilder();
            sb.append("CROPRECTpre=");
            sb.append(this.f57067o);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CROPRECTcamera=");
            sb2.append(this.f57056d);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CROPRECTpreF=");
            sb3.append(rectF3);
            this.f57058f.mo171468do(this.f57067o, rectF3);
            m43266a(forR2, rectF2);
            Rect rect3 = C3658case.m7396do(this.f57067o, 0.9f);
            this.f57068p = rect3;
            rect3.offset(0, (int) (((double) this.f57067o.height()) * -0.05d));
            C3682while whileR = C3658case.m7400do(this.f57068p);
            this.f57069q = whileR;
            C3682while whileR2 = whileR.m46671new(this.f57065m).m46672try(this.f57059g.m48113class());
            this.f57070r = whileR2;
            C3682while whileR3 = f57054b;
            this.f57071s = whileR2.m46670for(whileR3);
            this.f57072t = this.f57070r.mo43513if(whileR3);
            double d = this.f57070r.mo43512if();
            this.f57074v = d;
            this.f57073u = this.f57070r.mo43509do(1.0d / d);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("start: ");
            sb4.append(this.f57064l.toShortString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("crop: ");
            sb5.append(this.f57067o.toShortString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("target: ");
            sb6.append(this.f57068p.toShortString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("current: ");
            sb7.append(faceFeature.getFaceBounds().toShortString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append("camera: ");
            sb8.append(this.f57056d.toShortString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append("screen: ");
            sb9.append(this.f57057e.toShortString());
            return C3688do.FACE_PATH;
        } else if (this.f57066n == null) {
            return C3688do.NO_FACE_PATH;
        } else {
            if (this.f57075w >= this.f57059g.m48117new()) {
                return C3688do.END_FACE_PATH;
            }
            this.f57076x = C3658case.m7400do(rect2).m46671new(this.f57065m).m46672try(this.f57059g.m48113class()).mo43510do(this.f57071s, this.f57072t).mo43507do(this.f57073u) / this.f57074v;
            double d2 = (this.f57059g.m48112catch() * ((double) this.f57075w)) / ((double) (this.f57059g.m48117new() - 1));
            double width = (((double) rect2.width()) * 1.0d) / ((double) this.f57068p.width());
            double abs = Math.abs(1.0d - width);
            double d3 = width;
            double max = Math.max((((double) rect2.width()) * 1.0d) / ((double) this.f57064l.width()), (((double) this.f57064l.width()) * 1.0d) / ((double) rect2.width()));
            double d4 = C3658case.m7402if(C3658case.m7403if(rect2), C3658case.m7403if(this.f57068p)) / ((double) this.f57056d.width());
            if (this.f57075w < this.f57059g.m48117new() - 1 && this.f57076x > d2) {
                m43266a(forR2, rectF2);
            } else if (this.f57075w == this.f57059g.m48117new() - 1 && d4 < this.f57059g.mo171478do() && abs < this.f57059g.mo171482if() && max > this.f57059g.m48115for()) {
                m43266a(forR2, rectF2);
            }
            if (this.f57075w == this.f57059g.m48117new()) {
                return C3688do.END_FACE_PATH;
            }
            if (d4 > this.f57059g.mo171478do()) {
                return C3688do.FACE_PATH;
            }
            return d3 < 1.0d ? C3688do.TOO_FAR_FACE_PATH : C3688do.TOO_CLOSE_FACE_PATH;
        }
    }

    /* renamed from: do */
    public int mo171466do() {
        return this.f57059g.m48117new();
    }

    /* renamed from: a */
    private static boolean m43267a(RectF rectF) {
        return rectF.left <= 0.0f || rectF.top <= 0.0f || rectF.right >= 1.0f || rectF.bottom >= 1.0f;
    }
}
