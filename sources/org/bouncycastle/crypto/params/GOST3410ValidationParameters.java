package org.bouncycastle.crypto.params;

public class GOST3410ValidationParameters {

    /* renamed from: c */
    private int f8028c;

    /* renamed from: cL */
    private long f8029cL;

    /* renamed from: x0 */
    private int f8030x0;
    private long x0L;

    public GOST3410ValidationParameters(int i, int i2) {
        this.f8030x0 = i;
        this.f8028c = i2;
    }

    public GOST3410ValidationParameters(long j, long j2) {
        this.x0L = j;
        this.f8029cL = j2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410ValidationParameters)) {
            return false;
        }
        GOST3410ValidationParameters gOST3410ValidationParameters = (GOST3410ValidationParameters) obj;
        return gOST3410ValidationParameters.f8028c == this.f8028c && gOST3410ValidationParameters.f8030x0 == this.f8030x0 && gOST3410ValidationParameters.f8029cL == this.f8029cL && gOST3410ValidationParameters.x0L == this.x0L;
    }

    public int getC() {
        return this.f8028c;
    }

    public long getCL() {
        return this.f8029cL;
    }

    public int getX0() {
        return this.f8030x0;
    }

    public long getX0L() {
        return this.x0L;
    }

    public int hashCode() {
        int i = this.f8030x0 ^ this.f8028c;
        long j = this.x0L;
        long j2 = this.f8029cL;
        return (((i ^ ((int) j)) ^ ((int) (j >> 32))) ^ ((int) j2)) ^ ((int) (j2 >> 32));
    }
}
