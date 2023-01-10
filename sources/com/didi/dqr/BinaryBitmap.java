package com.didi.dqr;

import com.didi.dqr.common.BitArray;
import com.didi.dqr.common.BitMatrix;

public final class BinaryBitmap {

    /* renamed from: a */
    private final Binarizer f20348a;

    /* renamed from: b */
    private BitMatrix f20349b;

    public BinaryBitmap(Binarizer binarizer) {
        if (binarizer != null) {
            this.f20348a = binarizer;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public int getWidth() {
        return this.f20348a.getWidth();
    }

    public int getHeight() {
        return this.f20348a.getHeight();
    }

    public BitArray getBlackRow(int i, BitArray bitArray) throws NotFoundException {
        return this.f20348a.getBlackRow(i, bitArray);
    }

    public BitArray getRotatedBlackRow(int i, BitArray bitArray) throws NotFoundException {
        return this.f20348a.getRotatedBlackRow(i, bitArray);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        if (this.f20349b == null) {
            this.f20349b = this.f20348a.getBlackMatrix();
        }
        return this.f20349b;
    }

    public boolean isCropSupported() {
        return this.f20348a.getLuminanceSource().isCropSupported();
    }

    public BinaryBitmap crop(int i, int i2, int i3, int i4) {
        return new BinaryBitmap(this.f20348a.createBinarizer(this.f20348a.getLuminanceSource().crop(i, i2, i3, i4)));
    }

    public boolean isRotateSupported() {
        return this.f20348a.getLuminanceSource().isRotateSupported();
    }

    public BinaryBitmap rotateCounterClockwise() {
        return new BinaryBitmap(this.f20348a.createBinarizer(this.f20348a.getLuminanceSource().rotateCounterClockwise()));
    }

    public BinaryBitmap rotateCounterClockwise45() {
        return new BinaryBitmap(this.f20348a.createBinarizer(this.f20348a.getLuminanceSource().rotateCounterClockwise45()));
    }

    public LuminanceSource getSource() {
        return this.f20348a.getLuminanceSource();
    }

    public String toString() {
        try {
            return getBlackMatrix().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
