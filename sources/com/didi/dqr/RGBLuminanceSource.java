package com.didi.dqr;

public final class RGBLuminanceSource extends LuminanceSource {

    /* renamed from: a */
    private final byte[] f20373a;

    /* renamed from: b */
    private final int f20374b;

    /* renamed from: c */
    private final int f20375c;

    /* renamed from: d */
    private final int f20376d;

    /* renamed from: e */
    private final int f20377e;

    public boolean isCropSupported() {
        return true;
    }

    public RGBLuminanceSource(int i, int i2, int[] iArr) {
        super(i, i2);
        this.f20374b = i;
        this.f20375c = i2;
        this.f20376d = 0;
        this.f20377e = 0;
        int i3 = i * i2;
        this.f20373a = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            this.f20373a[i4] = (byte) (((((i5 >> 16) & 255) + ((i5 >> 7) & 510)) + (i5 & 255)) / 4);
        }
    }

    private RGBLuminanceSource(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i5 + i3 > i || i6 + i4 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f20373a = bArr;
        this.f20374b = i;
        this.f20375c = i2;
        this.f20376d = i3;
        this.f20377e = i4;
    }

    public byte[] getRow(int i, byte[] bArr) {
        if (i < 0 || i >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.f20373a, ((i + this.f20377e) * this.f20374b) + this.f20376d, bArr, 0, width);
        return bArr;
    }

    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        if (width == this.f20374b && height == this.f20375c) {
            return this.f20373a;
        }
        int i = width * height;
        byte[] bArr = new byte[i];
        int i2 = this.f20377e;
        int i3 = this.f20374b;
        int i4 = (i2 * i3) + this.f20376d;
        if (width == i3) {
            System.arraycopy(this.f20373a, i4, bArr, 0, i);
            return bArr;
        }
        for (int i5 = 0; i5 < height; i5++) {
            System.arraycopy(this.f20373a, i4, bArr, i5 * width, width);
            i4 += this.f20374b;
        }
        return bArr;
    }

    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        return new RGBLuminanceSource(this.f20373a, this.f20374b, this.f20375c, this.f20376d + i, this.f20377e + i2, i3, i4);
    }
}
