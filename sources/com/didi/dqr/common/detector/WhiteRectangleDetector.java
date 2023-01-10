package com.didi.dqr.common.detector;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;

public final class WhiteRectangleDetector {

    /* renamed from: a */
    private static final int f20437a = 10;

    /* renamed from: b */
    private static final int f20438b = 1;

    /* renamed from: c */
    private final BitMatrix f20439c;

    /* renamed from: d */
    private final int f20440d;

    /* renamed from: e */
    private final int f20441e;

    /* renamed from: f */
    private final int f20442f;

    /* renamed from: g */
    private final int f20443g;

    /* renamed from: h */
    private final int f20444h;

    /* renamed from: i */
    private final int f20445i;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) throws NotFoundException {
        this.f20439c = bitMatrix;
        this.f20440d = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        this.f20441e = width;
        int i4 = i / 2;
        int i5 = i2 - i4;
        this.f20442f = i5;
        int i6 = i2 + i4;
        this.f20443g = i6;
        int i7 = i3 - i4;
        this.f20445i = i7;
        int i8 = i3 + i4;
        this.f20444h = i8;
        if (i7 < 0 || i5 < 0 || i8 >= this.f20440d || i6 >= width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i = this.f20442f;
        int i2 = this.f20443g;
        int i3 = this.f20445i;
        int i4 = this.f20444h;
        boolean z = false;
        int i5 = 1;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            if (!z2) {
                break;
            }
            boolean z8 = true;
            boolean z9 = false;
            while (true) {
                if ((z8 || !z3) && i2 < this.f20441e) {
                    z8 = m17165a(i3, i4, i2, false);
                    if (z8) {
                        i2++;
                        z3 = true;
                        z9 = true;
                    } else if (!z3) {
                        i2++;
                    }
                }
            }
            if (i2 >= this.f20441e) {
                break;
            }
            boolean z10 = true;
            while (true) {
                if ((z10 || !z4) && i4 < this.f20440d) {
                    z10 = m17165a(i, i2, i4, true);
                    if (z10) {
                        i4++;
                        z4 = true;
                        z9 = true;
                    } else if (!z4) {
                        i4++;
                    }
                }
            }
            if (i4 >= this.f20440d) {
                break;
            }
            boolean z11 = true;
            while (true) {
                if ((z11 || !z5) && i >= 0) {
                    z11 = m17165a(i3, i4, i, false);
                    if (z11) {
                        i--;
                        z5 = true;
                        z9 = true;
                    } else if (!z5) {
                        i--;
                    }
                }
            }
            if (i < 0) {
                break;
            }
            z2 = z9;
            boolean z12 = true;
            while (true) {
                if ((z12 || !z7) && i3 >= 0) {
                    z12 = m17165a(i, i2, i3, true);
                    if (z12) {
                        i3--;
                        z2 = true;
                        z7 = true;
                    } else if (!z7) {
                        i3--;
                    }
                }
            }
            if (i3 < 0) {
                break;
            } else if (z2) {
                z6 = true;
            }
        }
        z = true;
        if (z || !z6) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = i2 - i;
        ResultPoint resultPoint = null;
        ResultPoint resultPoint2 = null;
        int i7 = 1;
        while (resultPoint2 == null && i7 < i6) {
            resultPoint2 = m17164a((float) i, (float) (i4 - i7), (float) (i + i7), (float) i4);
            i7++;
        }
        if (resultPoint2 != null) {
            ResultPoint resultPoint3 = null;
            int i8 = 1;
            while (resultPoint3 == null && i8 < i6) {
                resultPoint3 = m17164a((float) i, (float) (i3 + i8), (float) (i + i8), (float) i3);
                i8++;
            }
            if (resultPoint3 != null) {
                ResultPoint resultPoint4 = null;
                int i9 = 1;
                while (resultPoint4 == null && i9 < i6) {
                    resultPoint4 = m17164a((float) i2, (float) (i3 + i9), (float) (i2 - i9), (float) i3);
                    i9++;
                }
                if (resultPoint4 != null) {
                    while (resultPoint == null && i5 < i6) {
                        resultPoint = m17164a((float) i2, (float) (i4 - i5), (float) (i2 - i5), (float) i4);
                        i5++;
                    }
                    if (resultPoint != null) {
                        return m17166a(resultPoint, resultPoint2, resultPoint4, resultPoint3);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    private ResultPoint m17164a(float f, float f2, float f3, float f4) {
        int round = MathUtils.round(MathUtils.distance(f, f2, f3, f4));
        float f5 = (float) round;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < round; i++) {
            float f8 = (float) i;
            int round2 = MathUtils.round((f8 * f6) + f);
            int round3 = MathUtils.round((f8 * f7) + f2);
            if (this.f20439c.get(round2, round3)) {
                return new ResultPoint((float) round2, (float) round3);
            }
        }
        return null;
    }

    /* renamed from: a */
    private ResultPoint[] m17166a(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        if (x < ((float) this.f20441e) / 2.0f) {
            return new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)};
        }
        return new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
    }

    /* renamed from: a */
    private boolean m17165a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f20439c.get(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.f20439c.get(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
