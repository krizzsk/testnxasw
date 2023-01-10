package com.didi.zxing.barcodescanner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.didi.dqr.PlanarYUVLuminanceSource;
import java.io.ByteArrayOutputStream;

public class SourceData {

    /* renamed from: a */
    private byte[] f47975a;

    /* renamed from: b */
    private int f47976b;

    /* renamed from: c */
    private int f47977c;

    /* renamed from: d */
    private int f47978d;

    /* renamed from: e */
    private int f47979e;

    /* renamed from: f */
    private Rect f47980f;

    public SourceData(byte[] bArr, int i, int i2, int i3, int i4) {
        this.f47975a = bArr;
        this.f47976b = i;
        this.f47977c = i2;
        this.f47979e = i4;
        this.f47978d = i3;
        if (i * i2 > bArr.length) {
            throw new IllegalArgumentException("Image data does not match the resolution. " + i + "x" + i2 + " > " + bArr.length);
        }
    }

    public Rect getCropRect() {
        return this.f47980f;
    }

    public void setCropRect(Rect rect) {
        this.f47980f = rect;
    }

    public byte[] getData() {
        return this.f47975a;
    }

    public int getDataWidth() {
        return this.f47976b;
    }

    public int getDataHeight() {
        return this.f47977c;
    }

    public boolean isRotated() {
        return this.f47979e % 180 != 0;
    }

    public int getImageFormat() {
        return this.f47978d;
    }

    public PlanarYUVLuminanceSource createSource() {
        int i;
        int i2;
        byte[] rotateCameraPreview = rotateCameraPreview(this.f47979e, this.f47975a, this.f47976b, this.f47977c);
        if (this.f47980f.width() % 2 != 0) {
            Rect rect = this.f47980f;
            rect.right--;
        }
        if (this.f47980f.height() % 2 != 0) {
            Rect rect2 = this.f47980f;
            rect2.bottom--;
        }
        if (isRotated()) {
            if (this.f47980f.left + this.f47980f.width() > this.f47977c || this.f47980f.top + this.f47980f.height() > (i2 = this.f47976b)) {
                return null;
            }
            return new PlanarYUVLuminanceSource(rotateCameraPreview, this.f47977c, i2, this.f47980f.left, this.f47980f.top, this.f47980f.width(), this.f47980f.height(), false);
        } else if (this.f47980f.left + this.f47980f.width() > this.f47976b || this.f47980f.top + this.f47980f.height() > (i = this.f47977c)) {
            return null;
        } else {
            return new PlanarYUVLuminanceSource(rotateCameraPreview, this.f47976b, i, this.f47980f.left, this.f47980f.top, this.f47980f.width(), this.f47980f.height(), false);
        }
    }

    public Bitmap getBitmap() {
        return getBitmap(1);
    }

    public Bitmap getBitmap(int i) {
        return m36022a(this.f47980f, i);
    }

    /* renamed from: a */
    private Bitmap m36022a(Rect rect, int i) {
        if (isRotated()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(this.f47975a, this.f47978d, this.f47976b, this.f47977c, (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (this.f47979e == 0) {
            return decodeByteArray;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) this.f47979e);
        return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
    }

    public byte[] getJpeg(int i) {
        if (isRotated()) {
            this.f47980f = new Rect(this.f47980f.top, this.f47980f.left, this.f47980f.bottom, this.f47980f.right);
        }
        YuvImage yuvImage = new YuvImage(this.f47975a, this.f47978d, this.f47976b, this.f47977c, (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(this.f47980f, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] rotateCameraPreview(int i, byte[] bArr, int i2, int i3) {
        if (i == 90) {
            return rotateCW(bArr, i2, i3);
        }
        if (i != 180) {
            return i != 270 ? bArr : rotateCCW(bArr, i2, i3);
        }
        return rotate180(bArr, i2, i3);
    }

    public static byte[] rotateCW(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(i * i2)];
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = i2 - 1; i5 >= 0; i5--) {
                bArr2[i3] = bArr[(i5 * i) + i4];
                i3++;
            }
        }
        return bArr2;
    }

    public static byte[] rotate180(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i4] = bArr[i5];
            i4--;
        }
        return bArr2;
    }

    public static byte[] rotateCCW(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = i2 - 1; i6 >= 0; i6--) {
                bArr2[i4] = bArr[(i6 * i) + i5];
                i4--;
            }
        }
        return bArr2;
    }

    public int getAverageLum(int i) {
        int i2 = this.f47977c * this.f47976b;
        long j = 0;
        int i3 = 0;
        while (i3 < this.f47976b) {
            int i4 = 0;
            while (i4 < this.f47977c) {
                j += (long) (this.f47975a[(this.f47976b * i4) + i3] & 255);
                i4 += i;
            }
            i3 += i;
        }
        return (int) (j / ((long) ((i2 / i) / i)));
    }
}
