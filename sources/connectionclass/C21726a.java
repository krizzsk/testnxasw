package connectionclass;

/* renamed from: connectionclass.a */
/* compiled from: ExponentialGeometricAverage */
class C21726a {

    /* renamed from: a */
    private final double f59060a;

    /* renamed from: b */
    private final int f59061b;

    /* renamed from: c */
    private double f59062c = -1.0d;

    /* renamed from: d */
    private int f59063d;

    public C21726a(double d) {
        int i;
        this.f59060a = d;
        if (d == 0.0d) {
            i = Integer.MAX_VALUE;
        } else {
            i = (int) Math.ceil(1.0d / d);
        }
        this.f59061b = i;
    }

    /* renamed from: a */
    public void mo178967a(double d) {
        double d2 = 1.0d - this.f59060a;
        int i = this.f59063d;
        if (i > this.f59061b) {
            this.f59062c = Math.exp((d2 * Math.log(this.f59062c)) + (this.f59060a * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * ((double) i)) / (((double) i) + 1.0d);
            this.f59062c = Math.exp((d3 * Math.log(this.f59062c)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.f59062c = d;
        }
        this.f59063d++;
    }

    /* renamed from: a */
    public double mo178966a() {
        return this.f59062c;
    }

    /* renamed from: b */
    public void mo178968b() {
        this.f59062c = -1.0d;
        this.f59063d = 0;
    }
}
