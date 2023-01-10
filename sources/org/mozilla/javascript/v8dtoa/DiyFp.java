package org.mozilla.javascript.v8dtoa;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.threatmetrix.TrustDefender.qqqqqy;
import net.lingala.zip4j.util.InternalZipConstants;

class DiyFp {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int kSignificandSize = 64;
    static final long kUint64MSB = Long.MIN_VALUE;

    /* renamed from: e */
    private int f8517e;

    /* renamed from: f */
    private long f8518f;

    private static boolean uint64_gte(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i != 0) {
            return (((j > 0 ? 1 : (j == 0 ? 0 : -1)) < 0) ^ (i > 0)) ^ ((j2 > 0 ? 1 : (j2 == 0 ? 0 : -1)) < 0);
        }
    }

    DiyFp() {
        this.f8518f = 0;
        this.f8517e = 0;
    }

    DiyFp(long j, int i) {
        this.f8518f = j;
        this.f8517e = i;
    }

    /* access modifiers changed from: package-private */
    public void subtract(DiyFp diyFp) {
        this.f8518f -= diyFp.f8518f;
    }

    static DiyFp minus(DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFp3 = new DiyFp(diyFp.f8518f, diyFp.f8517e);
        diyFp3.subtract(diyFp2);
        return diyFp3;
    }

    /* access modifiers changed from: package-private */
    public void multiply(DiyFp diyFp) {
        long j = this.f8518f;
        long j2 = j >>> 32;
        long j3 = j & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = diyFp.f8518f;
        long j5 = j4 >>> 32;
        long j6 = j4 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = j2 * j5;
        long j8 = j5 * j3;
        long j9 = j2 * j6;
        long j10 = j7 + (j9 >>> 32) + (j8 >>> 32) + ((((((j3 * j6) >>> 32) + (j9 & InternalZipConstants.ZIP_64_SIZE_LIMIT)) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & j8)) + qqqqqy.b0065ee006500650065) >>> 32);
        this.f8517e += diyFp.f8517e + 64;
        this.f8518f = j10;
    }

    static DiyFp times(DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFp3 = new DiyFp(diyFp.f8518f, diyFp.f8517e);
        diyFp3.multiply(diyFp2);
        return diyFp3;
    }

    /* access modifiers changed from: package-private */
    public void normalize() {
        long j = this.f8518f;
        int i = this.f8517e;
        while ((-18014398509481984L & j) == 0) {
            j <<= 10;
            i -= 10;
        }
        while ((Long.MIN_VALUE & j) == 0) {
            j <<= 1;
            i--;
        }
        this.f8518f = j;
        this.f8517e = i;
    }

    static DiyFp normalize(DiyFp diyFp) {
        DiyFp diyFp2 = new DiyFp(diyFp.f8518f, diyFp.f8517e);
        diyFp2.normalize();
        return diyFp2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public long mo41160f() {
        return this.f8518f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo41159e() {
        return this.f8517e;
    }

    /* access modifiers changed from: package-private */
    public void setF(long j) {
        this.f8518f = j;
    }

    /* access modifiers changed from: package-private */
    public void setE(int i) {
        this.f8517e = i;
    }

    public String toString() {
        return "[DiyFp f:" + this.f8518f + ", e:" + this.f8517e + Const.jaRight;
    }
}
