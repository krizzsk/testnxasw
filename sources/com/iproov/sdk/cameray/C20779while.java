package com.iproov.sdk.cameray;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import com.google.common.base.Ascii;
import com.iproov.sdk.cameray.C20772import;
import com.iproov.sdk.core.C20882import;
import com.iproov.sdk.core.C20893while;
import p095switch.C3679throw;
import p235do.C21824for;

/* renamed from: com.iproov.sdk.cameray.while */
/* compiled from: YUV420PackedFrame */
public class C20779while implements C21824for {

    /* renamed from: a */
    private final int f56922a;

    /* renamed from: b */
    private final int f56923b;

    /* renamed from: c */
    private final byte[] f56924c;

    /* renamed from: d */
    private final byte[] f56925d;

    /* renamed from: e */
    private final byte[] f56926e;

    /* renamed from: f */
    private final long f56927f;

    C20779while(Image image) {
        this((C20772import) new C20750a(image));
    }

    /* renamed from: do */
    public Bitmap mo171340do(int i) {
        int i2;
        int[] iArr = new int[(this.f56924c.length / (i * i))];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = this.f56923b;
            if (i3 > i6 - i) {
                return Bitmap.createBitmap(iArr, this.f56922a / i, i6 / i, Bitmap.Config.ARGB_8888);
            }
            int i7 = i4;
            int i8 = 0;
            while (true) {
                i2 = this.f56922a;
                if (i8 > i2 - i) {
                    break;
                }
                int i9 = C3679throw.m7437do((this.f56924c[i7] & 255) - 16, 0, 255);
                iArr[i5] = Color.rgb(i9, i9, i9);
                i7 += i;
                i8 += i;
                i5++;
            }
            i4 += i2 * i;
            i3 += i;
        }
    }

    /* renamed from: for  reason: not valid java name */
    public Bitmap m48076for(int i) {
        int i2;
        float f = ((float) this.f56922a) / 2.0f;
        int[] iArr = new int[(this.f56924c.length / (i * i))];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = this.f56923b;
            if (i3 > i6 - i) {
                return Bitmap.createBitmap(iArr, this.f56922a / i, i6 / i, Bitmap.Config.ARGB_8888);
            }
            int i7 = i4;
            int i8 = 0;
            while (true) {
                i2 = this.f56922a;
                if (i8 > i2 - i) {
                    break;
                }
                int i9 = (int) ((((float) ((int) (((float) i3) / 2.0f))) * f) + (((float) i8) / 2.0f));
                int i10 = C3679throw.m7437do((this.f56924c[i7] & 255) - 16, 0, 255);
                byte b = this.f56925d[i9] & 255;
                byte b2 = this.f56926e[i9] & 255;
                iArr[i5] = Color.rgb(C3679throw.m7437do((((b2 * 1436) / 1024) + i10) - 179, 0, 255), C3679throw.m7437do((((i10 - ((46549 * b) / 131072)) + 44) - ((b2 * 93604) / 131072)) + 91, 0, 255), C3679throw.m7437do((i10 + ((b * Ascii.SYN) / 1024)) - 227, 0, 255));
                i7 += i;
                i8 += i;
                i5++;
            }
            i4 += i2 * i;
            i3 += i;
        }
    }

    /* renamed from: if */
    public byte[] mo171342if(int i) {
        C20893while.m43453do(C20882import.AND1);
        if (i == 19) {
            return m42965b();
        }
        if (i == 21 || i == 2130706688) {
            return m42964a();
        }
        throw new IllegalArgumentException("Unsupported codec format " + i);
    }

    C20779while(C20772import importR) {
        int a = importR.mo171287a();
        this.f56922a = a;
        int b = importR.mo171290b();
        this.f56923b = b;
        int i = b * a;
        this.f56924c = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f56923b; i3++) {
            C20772import.C20773do doVar = C20772import.C20773do.f56913do;
            importR.mo171289a(doVar, i3 * importR.mo171291b(doVar), this.f56924c, i2, this.f56922a);
            i2 += this.f56922a;
        }
        C20772import.C20773do doVar2 = C20772import.C20773do.U;
        int a2 = importR.mo171288a(doVar2);
        int b2 = importR.mo171291b(doVar2);
        int i4 = i / 4;
        this.f56925d = new byte[i4];
        this.f56926e = new byte[i4];
        int i5 = this.f56922a / 2;
        int i6 = this.f56923b / 2;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i6; i9++) {
            for (int i10 = 0; i10 < i5; i10++) {
                this.f56925d[i7] = importR.mo171286a(C20772import.C20773do.U, i8);
                this.f56926e[i7] = importR.mo171286a(C20772import.C20773do.f62357for, i8);
                i7++;
                i8 += a2;
            }
            i8 += b2 - (i5 * a2);
        }
        this.f56927f = System.currentTimeMillis();
    }

    /* renamed from: b */
    private byte[] m42965b() {
        int i = this.f56922a * this.f56923b;
        byte[] bArr = new byte[((int) (((float) i) * 1.5f))];
        byte[] bArr2 = this.f56924c;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        byte[] bArr3 = this.f56925d;
        System.arraycopy(bArr3, 0, bArr, i, bArr3.length);
        byte[] bArr4 = this.f56926e;
        System.arraycopy(bArr4, 0, bArr, i + this.f56925d.length, bArr4.length);
        return bArr;
    }

    /* renamed from: do */
    public long mo171339do() {
        return this.f56927f;
    }

    /* renamed from: a */
    private byte[] m42964a() {
        int i = this.f56922a * this.f56923b;
        byte[] bArr = new byte[((int) (((float) i) * 1.5f))];
        byte[] bArr2 = this.f56924c;
        int i2 = 0;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        while (true) {
            byte[] bArr3 = this.f56925d;
            if (i2 >= bArr3.length) {
                return bArr;
            }
            int i3 = i + 1;
            bArr[i] = bArr3[i2];
            i = i3 + 1;
            bArr[i3] = this.f56926e[i2];
            i2++;
        }
    }
}
