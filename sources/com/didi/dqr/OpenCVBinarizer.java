package com.didi.dqr;

import com.didi.dqr.common.BitArray;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.common.GlobalHistogramBinarizer;
import com.didi.dqrutil.DqrConfigHelper;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.dqrutil.analysis.EventId;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class OpenCVBinarizer extends GlobalHistogramBinarizer {
    public static int blockSize = 0;

    /* renamed from: d */
    private static int f20361d = 1;

    /* renamed from: f */
    private static boolean f20362f = SoLoader.loadLibraryError;

    /* renamed from: a */
    private BitMatrix f20363a;

    /* renamed from: b */
    private BitMatrix f20364b;

    /* renamed from: c */
    private float f20365c = 1.0f;

    /* renamed from: e */
    private byte[] f20366e;

    static {
        SoLoader.load();
    }

    public OpenCVBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    public void setBlockSizeFact(float f) {
        this.f20365c = f;
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        AnalysisManager.report(EventId.CREATE_OPENCV_BINARIZER);
        BitMatrix bitMatrix = this.f20363a;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        BitMatrix bitMatrix2 = new BitMatrix(width, height);
        this.f20363a = bitMatrix2;
        m17147a(bitMatrix2, luminanceSource.getMatrix(), width, height);
        this.f20363a.setSource(luminanceSource.getMatrix());
        return this.f20363a;
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new OpenCVBinarizer(luminanceSource);
    }

    /* renamed from: a */
    private void m17147a(BitMatrix bitMatrix, byte[] bArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int i5 = i3 % 2 != 0 ? i3 + 1 : i3;
        int i6 = i4 % 2 != 0 ? i4 + 1 : i4;
        Mat mat = new Mat(i6 + (i6 / 2), i5, CvType.CV_8UC1);
        mat.put(0, 0, bArr);
        boolean useFilter = DqrConfigHelper.useFilter();
        if (useFilter) {
            Imgproc.cvtColor(mat, mat, 106);
        }
        int a = m17146a();
        Imgproc.adaptiveThreshold(mat, mat, 255.0d, 0, 0, a < 11 ? 11 : a, 1.0d);
        if (useFilter) {
            Imgproc.erode(mat, mat, new Mat());
            Imgproc.dilate(mat, mat, new Mat());
        }
        byte[] bArr2 = new byte[(mat.channels() * mat.cols() * mat.rows())];
        this.f20366e = bArr2;
        mat.get(0, 0, bArr2);
        m17148b(bitMatrix, this.f20366e, i3, i4);
        mat.release();
    }

    /* renamed from: a */
    private int m17146a() {
        if (!DqrConfigHelper.useDynamicCVBlocksize()) {
            int min = (int) (this.f20365c * ((float) (Math.min(getLuminanceSource().getWidth(), getLuminanceSource().getHeight()) >> 4)));
            return min % 2 == 0 ? min + 1 : min;
        }
        int min2 = (int) (this.f20365c * ((float) (Math.min(getLuminanceSource().getWidth(), getLuminanceSource().getHeight()) >> 5)));
        int min3 = (int) (this.f20365c * ((float) (Math.min(getLuminanceSource().getWidth(), getLuminanceSource().getHeight()) >> 3)));
        int i = (min3 + min2) >> 1;
        if (i % 2 == 0) {
            i++;
        }
        int i2 = f20361d;
        if (i2 > 0) {
            f20361d = i2 * DqrConfigHelper.opencvBlockBulking() * -2;
        } else {
            f20361d = i2 * -1;
        }
        int i3 = f20361d + i;
        if (i3 < min2 || i3 > min3) {
            f20361d = 1;
        } else {
            i = i3;
        }
        if (i % 2 == 0) {
            i++;
        }
        blockSize = i;
        return i;
    }

    /* renamed from: b */
    private static void m17148b(BitMatrix bitMatrix, byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * i;
            for (int i5 = 0; i5 < i; i5++) {
                if (bArr[i4 + i5] == 0) {
                    bitMatrix.set(i5, i3);
                }
            }
        }
    }

    public static boolean isLoadLibraryError() {
        return f20362f;
    }

    public BitArray getBlackRow(int i, BitArray bitArray) throws NotFoundException {
        return getBlackMatrix().getRow(i, bitArray);
    }

    public BitArray getRotatedBlackRow(int i, BitArray bitArray) throws NotFoundException {
        if (this.f20364b == null) {
            int width = getLuminanceSource().getWidth();
            int height = getLuminanceSource().getHeight();
            BitMatrix bitMatrix = new BitMatrix(height, width);
            this.f20364b = bitMatrix;
            m17149c(bitMatrix, this.f20366e, height, width);
        }
        return this.f20364b.getRow(i, bitArray);
    }

    /* renamed from: c */
    private static void m17149c(BitMatrix bitMatrix, byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * i2;
            for (int i5 = 0; i5 < i2; i5++) {
                if (bArr[i4 + i5] == 0) {
                    bitMatrix.set(i3, i5);
                }
            }
        }
    }
}
