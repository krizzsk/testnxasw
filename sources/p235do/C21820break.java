package p235do;

/* renamed from: do.break */
/* compiled from: Size */
public final class C21820break {

    /* renamed from: a */
    private final int f59964a;

    /* renamed from: b */
    private final int f59965b;

    public C21820break(int i, int i2) {
        this.f59964a = i;
        this.f59965b = i2;
    }

    /* renamed from: do */
    public int mo180432do() {
        return this.f59965b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21820break)) {
            return false;
        }
        C21820break breakR = (C21820break) obj;
        if (this.f59964a == breakR.f59964a && this.f59965b == breakR.f59965b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f59965b;
        int i2 = this.f59964a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    /* renamed from: if */
    public int mo180435if() {
        return this.f59964a;
    }

    public String toString() {
        return this.f59964a + "x" + this.f59965b;
    }
}
