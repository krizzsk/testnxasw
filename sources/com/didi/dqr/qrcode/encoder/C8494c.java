package com.didi.dqr.qrcode.encoder;

import com.didi.dqr.WriterException;
import com.didi.dqr.common.BitArray;
import com.didi.dqr.qrcode.decoder.ErrorCorrectionLevel;
import com.didi.dqr.qrcode.decoder.Version;
import org.apache.commons.p074io.IOUtils;

/* renamed from: com.didi.dqr.qrcode.encoder.c */
/* compiled from: MatrixUtil */
final class C8494c {

    /* renamed from: a */
    private static final int[][] f20967a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b */
    private static final int[][] f20968b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c */
    private static final int[][] f20969c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d */
    private static final int[][] f20970d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* renamed from: e */
    private static final int f20971e = 7973;

    /* renamed from: f */
    private static final int f20972f = 1335;

    /* renamed from: g */
    private static final int f20973g = 21522;

    /* renamed from: b */
    private static boolean m17744b(int i) {
        return i == -1;
    }

    private C8494c() {
    }

    /* renamed from: a */
    static void m17740a(ByteMatrix byteMatrix) {
        byteMatrix.clear((byte) -1);
    }

    /* renamed from: a */
    static void m17735a(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i, ByteMatrix byteMatrix) throws WriterException {
        m17740a(byteMatrix);
        m17739a(version, byteMatrix);
        m17737a(errorCorrectionLevel, i, byteMatrix);
        m17742b(version, byteMatrix);
        m17734a(bitArray, i, byteMatrix);
    }

    /* renamed from: a */
    static void m17739a(Version version, ByteMatrix byteMatrix) throws WriterException {
        m17749d(byteMatrix);
        m17747c(byteMatrix);
        m17746c(version, byteMatrix);
        m17743b(byteMatrix);
    }

    /* renamed from: a */
    static void m17737a(ErrorCorrectionLevel errorCorrectionLevel, int i, ByteMatrix byteMatrix) throws WriterException {
        BitArray bitArray = new BitArray();
        m17736a(errorCorrectionLevel, i, bitArray);
        for (int i2 = 0; i2 < bitArray.getSize(); i2++) {
            boolean z = bitArray.get((bitArray.getSize() - 1) - i2);
            int[] iArr = f20970d[i2];
            byteMatrix.set(iArr[0], iArr[1], z);
            if (i2 < 8) {
                byteMatrix.set((byteMatrix.getWidth() - i2) - 1, 8, z);
            } else {
                byteMatrix.set(8, (byteMatrix.getHeight() - 7) + (i2 - 8), z);
            }
        }
    }

    /* renamed from: b */
    static void m17742b(Version version, ByteMatrix byteMatrix) throws WriterException {
        if (version.getVersionNumber() >= 7) {
            BitArray bitArray = new BitArray();
            m17738a(version, bitArray);
            int i = 17;
            for (int i2 = 0; i2 < 6; i2++) {
                for (int i3 = 0; i3 < 3; i3++) {
                    boolean z = bitArray.get(i);
                    i--;
                    byteMatrix.set(i2, (byteMatrix.getHeight() - 11) + i3, z);
                    byteMatrix.set((byteMatrix.getHeight() - 11) + i3, i2, z);
                }
            }
        }
    }

    /* renamed from: a */
    static void m17734a(BitArray bitArray, int i, ByteMatrix byteMatrix) throws WriterException {
        boolean z;
        int width = byteMatrix.getWidth() - 1;
        int height = byteMatrix.getHeight() - 1;
        int i2 = 0;
        int i3 = -1;
        while (width > 0) {
            if (width == 6) {
                width--;
            }
            while (height >= 0 && height < byteMatrix.getHeight()) {
                for (int i4 = 0; i4 < 2; i4++) {
                    int i5 = width - i4;
                    if (m17744b((int) byteMatrix.get(i5, height))) {
                        if (i2 < bitArray.getSize()) {
                            z = bitArray.get(i2);
                            i2++;
                        } else {
                            z = false;
                        }
                        if (i != -1 && C8493b.m17725a(i, i5, height)) {
                            z = !z;
                        }
                        byteMatrix.set(i5, height, z);
                    }
                }
                height += i3;
            }
            i3 = -i3;
            height += i3;
            width -= 2;
        }
        if (i2 != bitArray.getSize()) {
            throw new WriterException("Not all bits consumed: " + i2 + IOUtils.DIR_SEPARATOR_UNIX + bitArray.getSize());
        }
    }

    /* renamed from: a */
    static int m17731a(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    /* renamed from: a */
    static int m17732a(int i, int i2) {
        if (i2 != 0) {
            int a = m17731a(i2);
            int i3 = i << (a - 1);
            while (m17731a(i3) >= a) {
                i3 ^= i2 << (m17731a(i3) - a);
            }
            return i3;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    /* renamed from: a */
    static void m17736a(ErrorCorrectionLevel errorCorrectionLevel, int i, BitArray bitArray) throws WriterException {
        if (QRCode.isValidMaskPattern(i)) {
            int bits = (errorCorrectionLevel.getBits() << 3) | i;
            bitArray.appendBits(bits, 5);
            bitArray.appendBits(m17732a(bits, 1335), 10);
            BitArray bitArray2 = new BitArray();
            bitArray2.appendBits(21522, 15);
            bitArray.xor(bitArray2);
            if (bitArray.getSize() != 15) {
                throw new WriterException("should not happen but we got: " + bitArray.getSize());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    /* renamed from: a */
    static void m17738a(Version version, BitArray bitArray) throws WriterException {
        bitArray.appendBits(version.getVersionNumber(), 6);
        bitArray.appendBits(m17732a(version.getVersionNumber(), 7973), 12);
        if (bitArray.getSize() != 18) {
            throw new WriterException("should not happen but we got: " + bitArray.getSize());
        }
    }

    /* renamed from: b */
    private static void m17743b(ByteMatrix byteMatrix) {
        int i = 8;
        while (i < byteMatrix.getWidth() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (m17744b((int) byteMatrix.get(i, 6))) {
                byteMatrix.set(i, 6, i3);
            }
            if (m17744b((int) byteMatrix.get(6, i))) {
                byteMatrix.set(6, i, i3);
            }
            i = i2;
        }
    }

    /* renamed from: c */
    private static void m17747c(ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.get(8, byteMatrix.getHeight() - 8) != 0) {
            byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    /* renamed from: a */
    private static void m17733a(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        int i3 = 0;
        while (i3 < 8) {
            int i4 = i + i3;
            if (m17744b((int) byteMatrix.get(i4, i2))) {
                byteMatrix.set(i4, i2, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    /* renamed from: b */
    private static void m17741b(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        int i3 = 0;
        while (i3 < 7) {
            int i4 = i2 + i3;
            if (m17744b((int) byteMatrix.get(i, i4))) {
                byteMatrix.set(i, i4, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    /* renamed from: c */
    private static void m17745c(int i, int i2, ByteMatrix byteMatrix) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = f20968b[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                byteMatrix.set(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    /* renamed from: d */
    private static void m17748d(int i, int i2, ByteMatrix byteMatrix) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = f20967a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                byteMatrix.set(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    /* renamed from: d */
    private static void m17749d(ByteMatrix byteMatrix) throws WriterException {
        int length = f20967a[0].length;
        m17748d(0, 0, byteMatrix);
        m17748d(byteMatrix.getWidth() - length, 0, byteMatrix);
        m17748d(0, byteMatrix.getWidth() - length, byteMatrix);
        m17733a(0, 7, byteMatrix);
        m17733a(byteMatrix.getWidth() - 8, 7, byteMatrix);
        m17733a(0, byteMatrix.getWidth() - 8, byteMatrix);
        m17741b(7, 0, byteMatrix);
        m17741b((byteMatrix.getHeight() - 7) - 1, 0, byteMatrix);
        m17741b(7, byteMatrix.getHeight() - 7, byteMatrix);
    }

    /* renamed from: c */
    private static void m17746c(Version version, ByteMatrix byteMatrix) {
        if (version.getVersionNumber() >= 2) {
            int[] iArr = f20969c[version.getVersionNumber() - 1];
            for (int i : iArr) {
                if (i >= 0) {
                    for (int i2 : iArr) {
                        if (i2 >= 0 && m17744b((int) byteMatrix.get(i2, i))) {
                            m17745c(i2 - 2, i - 2, byteMatrix);
                        }
                    }
                }
            }
        }
    }
}
