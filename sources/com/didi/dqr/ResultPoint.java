package com.didi.dqr;

import com.didi.dqr.common.detector.MathUtils;
import org.osgi.framework.VersionRange;

public class ResultPoint {

    /* renamed from: a */
    private final float f20386a;

    /* renamed from: b */
    private final float f20387b;

    public ResultPoint(float f, float f2) {
        this.f20386a = f;
        this.f20387b = f2;
    }

    public final float getX() {
        return this.f20386a;
    }

    public final float getY() {
        return this.f20387b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ResultPoint)) {
            return false;
        }
        ResultPoint resultPoint = (ResultPoint) obj;
        if (this.f20386a == resultPoint.f20386a && this.f20387b == resultPoint.f20387b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f20386a) * 31) + Float.floatToIntBits(this.f20387b);
    }

    public final String toString() {
        return "(" + this.f20386a + ',' + this.f20387b + VersionRange.RIGHT_OPEN;
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float distance = distance(resultPointArr[0], resultPointArr[1]);
        float distance2 = distance(resultPointArr[1], resultPointArr[2]);
        float distance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (distance2 >= distance && distance2 >= distance3) {
            resultPoint3 = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint = resultPointArr[2];
        } else if (distance3 < distance2 || distance3 < distance) {
            resultPoint3 = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint = resultPointArr[1];
        } else {
            resultPoint3 = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint = resultPointArr[2];
        }
        if (m17152a(resultPoint2, resultPoint3, resultPoint) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint;
            resultPoint = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint3;
        resultPointArr[2] = resultPoint;
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f20386a, resultPoint.f20387b, resultPoint2.f20386a, resultPoint2.f20387b);
    }

    /* renamed from: a */
    private static float m17152a(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f = resultPoint2.f20386a;
        float f2 = resultPoint2.f20387b;
        return ((resultPoint3.f20386a - f) * (resultPoint.f20387b - f2)) - ((resultPoint3.f20387b - f2) * (resultPoint.f20386a - f));
    }
}
