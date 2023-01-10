package p095switch;

import android.graphics.RectF;

/* renamed from: switch.break */
/* compiled from: SmootherRectF */
public class C3657break {

    /* renamed from: a */
    private final C3678this f8765a;

    /* renamed from: b */
    private final C3678this f8766b;

    /* renamed from: c */
    private final C3678this f8767c;

    /* renamed from: case  reason: not valid java name */
    public double f62300case;

    /* renamed from: d */
    private final C3678this f8768d;

    /* renamed from: else  reason: not valid java name */
    public double f62301else;

    /* renamed from: goto  reason: not valid java name */
    public double f62302goto;

    /* renamed from: try  reason: not valid java name */
    public double f62303try;

    public C3657break(double d) {
        this.f8765a = new C3678this(d);
        this.f8766b = new C3678this(d);
        this.f8767c = new C3678this(d);
        this.f8768d = new C3678this(d);
    }

    /* renamed from: do */
    public void mo43491do(RectF rectF) {
        this.f8765a.mo43505do(Double.valueOf(C3658case.m7393do(rectF.left)));
        this.f62303try = this.f8765a.mo43504do().doubleValue();
        this.f8766b.mo43505do(Double.valueOf(C3658case.m7393do(rectF.top)));
        this.f62300case = this.f8766b.mo43504do().doubleValue();
        this.f8767c.mo43505do(Double.valueOf(C3658case.m7393do(rectF.right)));
        this.f62301else = this.f8767c.mo43504do().doubleValue();
        this.f8768d.mo43505do(Double.valueOf(C3658case.m7393do(rectF.bottom)));
        this.f62302goto = this.f8768d.mo43504do().doubleValue();
    }

    /* renamed from: if */
    public RectF mo43492if() {
        return new RectF(C3658case.m7395do(this.f62303try), C3658case.m7395do(this.f62300case), C3658case.m7395do(this.f62301else), C3658case.m7395do(this.f62302goto));
    }

    /* renamed from: do */
    public void mo43490do() {
        this.f8765a.mo43506if();
        this.f8766b.mo43506if();
        this.f8767c.mo43506if();
        this.f8768d.mo43506if();
    }
}
