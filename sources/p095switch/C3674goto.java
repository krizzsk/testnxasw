package p095switch;

/* renamed from: switch.goto */
/* compiled from: RollingAverage */
public class C3674goto {

    /* renamed from: a */
    private final double[] f8788a;

    /* renamed from: b */
    private int f8789b = 0;

    public C3674goto(int i) {
        this.f8788a = new double[i];
    }

    /* renamed from: do */
    public synchronized void mo43502do(double d) {
        int i = this.f8789b;
        this.f8789b = i + 1;
        double[] dArr = this.f8788a;
        dArr[i % dArr.length] = d;
    }

    /* renamed from: do */
    public synchronized float mo43501do() {
        float f;
        f = 0.0f;
        for (double d : this.f8788a) {
            f = (float) (((double) f) + d);
        }
        return f / ((float) Math.min(this.f8789b, this.f8788a.length));
    }
}
