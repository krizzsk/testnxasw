package com.didichuxing.gbankcard.ocr.utils;

import android.graphics.RectF;
import com.didichuxing.dfbasesdk.utils.LogUtils;

public class YuvCroper {
    public static int YUV_420P = 1;
    public static int YUV_420SP;

    /* renamed from: a */
    private final int f50291a;

    /* renamed from: b */
    private byte[] f50292b;

    /* renamed from: c */
    private final int f50293c;

    /* renamed from: d */
    private final int f50294d;

    /* renamed from: e */
    private final int f50295e;

    /* renamed from: f */
    private final int f50296f;

    /* renamed from: g */
    private final int f50297g;

    /* renamed from: h */
    private int f50298h;

    /* renamed from: i */
    private int f50299i;

    /* renamed from: a */
    private int m37618a(int i, int i2) {
        if (i >= i2) {
            return i2;
        }
        float f = ((float) i) / 16.0f;
        int i3 = (int) f;
        int i4 = f - ((float) i3) > 0.5f ? ((int) (((double) f) + 0.5d)) * 16 : i3 * 16;
        if (i4 < 16) {
            return 16;
        }
        return i4;
    }

    public YuvCroper(int i, int i2, int i3, RectF rectF) {
        if (i2 <= 0 || i3 <= 0 || rectF == null || rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
            throw new IllegalArgumentException("YuvCroper: Wrong param! size:" + i2 + "*" + i3 + ". Crop:" + rectF);
        }
        this.f50291a = i;
        this.f50293c = i2;
        this.f50294d = i3;
        this.f50295e = i2 * i3;
        this.f50299i = (int) (rectF.height() * ((float) this.f50294d));
        this.f50298h = (int) (rectF.width() * ((float) this.f50293c));
        this.f50299i = m37618a(this.f50299i, this.f50294d);
        this.f50298h = m37618a(this.f50298h, this.f50293c);
        this.f50296f = (((int) (rectF.left * ((float) this.f50293c))) / 16) * 16;
        this.f50297g = (((int) (rectF.top * ((float) this.f50294d))) / 16) * 16;
        this.f50292b = new byte[(((this.f50299i * this.f50298h) * 3) / 2)];
        LogUtils.m37051d("crop  point:" + this.f50296f + "*" + this.f50297g + "     size:" + this.f50298h + "*" + this.f50299i);
    }

    public int getCropWidth() {
        return this.f50298h;
    }

    public int getCropHeight() {
        return this.f50299i;
    }

    public byte[] crop(byte[] bArr) {
        if (bArr == null || bArr.length != (this.f50295e * 3) / 2) {
            LogUtils.m37051d("crop:wrong oriData!!!");
            return this.f50292b;
        }
        int i = this.f50291a;
        if (i == YUV_420SP) {
            m37620a(bArr);
        } else if (i == YUV_420P) {
            m37621b(bArr);
        }
        return this.f50292b;
    }

    /* renamed from: a */
    private void m37620a(byte[] bArr) {
        int i = this.f50296f;
        int i2 = this.f50293c;
        int i3 = this.f50297g;
        int a = m37619a(bArr, (i2 * i3) + i, i2 * (i3 + this.f50299i), i2, this.f50298h, 0);
        int i4 = this.f50295e;
        int i5 = this.f50293c;
        int i6 = this.f50297g;
        m37619a(bArr, ((i5 * i6) / 2) + i4 + this.f50296f, i4 + (((i6 + this.f50299i) * i5) / 2), i5, this.f50298h, a);
    }

    /* renamed from: b */
    private void m37621b(byte[] bArr) {
        int i = this.f50296f;
        int i2 = this.f50297g;
        int i3 = this.f50293c;
        int a = m37619a(bArr, (i2 * i3) + i, i3 * (i2 + this.f50299i), i3, this.f50298h, 0);
        int i4 = this.f50295e;
        int i5 = this.f50293c;
        int i6 = this.f50297g;
        int i7 = ((i5 * i6) / 4) + (this.f50296f / 2) + i4;
        int i8 = i4 + (((i6 + this.f50299i) * i5) / 4);
        int i9 = i5 / 2;
        int i10 = this.f50298h / 2;
        int a2 = m37619a(bArr, i7, i8, i9, i10, a);
        int i11 = this.f50295e;
        int i12 = this.f50293c;
        int i13 = this.f50297g;
        m37619a(bArr, (this.f50296f / 2) + ((i11 / 4) * 5) + ((i12 * i13) / 4), ((i11 / 4) * 5) + ((i12 * (i13 + this.f50299i)) / 4), i9, i10, a2);
    }

    /* renamed from: a */
    private int m37619a(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        while (i < i2) {
            System.arraycopy(bArr, i, this.f50292b, i5, i4);
            i5 += i4;
            i += i3;
        }
        return i5;
    }
}
