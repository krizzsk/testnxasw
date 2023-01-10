package p095switch;

import java.util.Date;

/* renamed from: switch.this */
/* compiled from: Smoother */
public class C3678this {

    /* renamed from: a */
    private final double f8791a;

    /* renamed from: b */
    private Double f8792b;

    /* renamed from: c */
    private Double f8793c;

    /* renamed from: d */
    private Date f8794d;

    public C3678this(double d) {
        this.f8791a = d;
    }

    /* renamed from: do */
    public Double mo43505do(Double d) {
        if (this.f8794d == null) {
            m7432a(d.doubleValue(), d.doubleValue());
        } else {
            double time = (((double) (new Date().getTime() - this.f8794d.getTime())) / 1000.0d) / this.f8791a;
            double exp = Math.exp(-time);
            double d2 = (1.0d - exp) / time;
            m7432a((this.f8792b.doubleValue() * exp) + ((d2 - exp) * this.f8793c.doubleValue()) + ((1.0d - d2) * d.doubleValue()), d.doubleValue());
        }
        return this.f8792b;
    }

    /* renamed from: if */
    public void mo43506if() {
        this.f8792b = null;
        this.f8793c = null;
        this.f8794d = null;
    }

    /* renamed from: a */
    private void m7432a(double d, double d2) {
        this.f8792b = Double.valueOf(d);
        this.f8793c = Double.valueOf(d2);
        this.f8794d = new Date();
    }

    /* renamed from: do */
    public Double mo43504do() {
        return this.f8792b;
    }
}
