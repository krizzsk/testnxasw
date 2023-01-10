package p095switch;

import org.osgi.framework.VersionRange;

/* renamed from: switch.while */
/* compiled from: VectorMatrix */
public class C3682while {

    /* renamed from: a */
    private final int f8799a;

    /* renamed from: b */
    private double[] f8800b;

    public C3682while(int i) {
        this.f8799a = i;
        this.f8800b = new double[i];
    }

    /* renamed from: do */
    public int mo43508do() {
        return this.f8799a;
    }

    /* renamed from: for  reason: not valid java name */
    public C3682while m46670for(C3682while whileR) {
        if (mo43508do() == whileR.mo43508do()) {
            C3682while whileR2 = new C3682while(this.f8799a);
            for (int i = 0; i < this.f8799a; i++) {
                whileR2.f8800b[i] = Math.min(whileR.f8800b[i], this.f8800b[i]);
            }
            return whileR2;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    /* renamed from: if */
    public double mo43512if() {
        double d = 0.0d;
        for (int i = 0; i < this.f8799a; i++) {
            double[] dArr = this.f8800b;
            d += dArr[i] * dArr[i];
        }
        return Math.sqrt(d);
    }

    /* renamed from: new  reason: not valid java name */
    public C3682while m46671new(C3682while whileR) {
        if (mo43508do() == whileR.mo43508do()) {
            C3682while whileR2 = new C3682while(this.f8799a);
            for (int i = 0; i < this.f8799a; i++) {
                whileR2.f8800b[i] = this.f8800b[i] - whileR.f8800b[i];
            }
            return whileR2;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VersionRange.LEFT_OPEN);
        for (int i = 0; i < this.f8799a; i++) {
            sb.append(this.f8800b[i]);
            if (i < this.f8799a - 1) {
                sb.append(", ");
            }
        }
        sb.append(VersionRange.RIGHT_OPEN);
        return sb.toString();
    }

    /* renamed from: try  reason: not valid java name */
    public C3682while m46672try(C3682while whileR) {
        if (mo43508do() == whileR.mo43508do()) {
            C3682while whileR2 = new C3682while(this.f8799a);
            for (int i = 0; i < this.f8799a; i++) {
                whileR2.f8800b[i] = whileR.f8800b[i] * this.f8800b[i];
            }
            return whileR2;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    /* renamed from: do */
    public double mo43507do(C3682while whileR) {
        if (mo43508do() == whileR.mo43508do()) {
            double d = 0.0d;
            for (int i = 0; i < this.f8799a; i++) {
                d += this.f8800b[i] * whileR.f8800b[i];
            }
            return d;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    public C3682while(double... dArr) {
        int length = dArr.length;
        this.f8799a = length;
        this.f8800b = new double[length];
        for (int i = 0; i < this.f8799a; i++) {
            this.f8800b[i] = dArr[i];
        }
    }

    /* renamed from: if */
    public C3682while mo43513if(C3682while whileR) {
        if (mo43508do() == whileR.mo43508do()) {
            C3682while whileR2 = new C3682while(this.f8799a);
            for (int i = 0; i < this.f8799a; i++) {
                whileR2.f8800b[i] = Math.max(whileR.f8800b[i], this.f8800b[i]);
            }
            return whileR2;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    /* renamed from: do */
    public C3682while mo43509do(double d) {
        C3682while whileR = new C3682while(this.f8799a);
        for (int i = 0; i < this.f8799a; i++) {
            whileR.f8800b[i] = this.f8800b[i] * d;
        }
        return whileR;
    }

    /* renamed from: do */
    public C3682while mo43510do(C3682while whileR, C3682while whileR2) {
        if (mo43508do() == whileR.mo43508do() && mo43508do() == whileR2.mo43508do()) {
            C3682while whileR3 = new C3682while(this.f8799a);
            for (int i = 0; i < this.f8799a; i++) {
                whileR3.f8800b[i] = C3679throw.m7436do(this.f8800b[i], whileR.f8800b[i], whileR2.f8800b[i]);
            }
            return whileR3;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }
}
