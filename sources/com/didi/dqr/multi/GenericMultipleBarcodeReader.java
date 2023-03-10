package com.didi.dqr.multi;

import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.Reader;
import com.didi.dqr.ReaderException;
import com.didi.dqr.Result;
import com.didi.dqr.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {

    /* renamed from: a */
    private static final int f20529a = 100;

    /* renamed from: b */
    private static final int f20530b = 4;

    /* renamed from: c */
    private final Reader f20531c;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.f20531c = reader;
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, (DecodeOptions) null);
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, DecodeOptions decodeOptions) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        m17303a(binaryBitmap, decodeOptions, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    private void m17303a(BinaryBitmap binaryBitmap, DecodeOptions decodeOptions, List<Result> list, int i, int i2, int i3) {
        boolean z;
        float f;
        float f2;
        int i4;
        int i5;
        BinaryBitmap binaryBitmap2 = binaryBitmap;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        if (i8 <= 4) {
            try {
                Result decode = this.f20531c.decode(binaryBitmap2, decodeOptions);
                Iterator<Result> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getText().equals(decode.getText())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    list.add(m17302a(decode, i6, i7));
                } else {
                    List<Result> list2 = list;
                }
                ResultPoint[] resultPoints = decode.getResultPoints();
                if (resultPoints != null && resultPoints.length != 0) {
                    int width = binaryBitmap.getWidth();
                    int height = binaryBitmap.getHeight();
                    float f3 = (float) width;
                    float f4 = (float) height;
                    float f5 = 0.0f;
                    float f6 = 0.0f;
                    for (ResultPoint resultPoint : resultPoints) {
                        if (resultPoint != null) {
                            float x = resultPoint.getX();
                            float y = resultPoint.getY();
                            if (x < f3) {
                                f3 = x;
                            }
                            if (y < f4) {
                                f4 = y;
                            }
                            if (x > f5) {
                                f5 = x;
                            }
                            if (y > f6) {
                                f6 = y;
                            }
                        }
                    }
                    if (f3 > 100.0f) {
                        f = f5;
                        f2 = f4;
                        i5 = height;
                        i4 = width;
                        m17303a(binaryBitmap2.crop(0, 0, (int) f3, height), decodeOptions, list, i, i2, i8 + 1);
                    } else {
                        f = f5;
                        f2 = f4;
                        i5 = height;
                        i4 = width;
                    }
                    if (f2 > 100.0f) {
                        m17303a(binaryBitmap2.crop(0, 0, i4, (int) f2), decodeOptions, list, i, i2, i8 + 1);
                    }
                    float f7 = f;
                    if (f7 < ((float) (i4 - 100))) {
                        int i9 = (int) f7;
                        m17303a(binaryBitmap2.crop(i9, 0, i4 - i9, i5), decodeOptions, list, i6 + i9, i2, i8 + 1);
                    }
                    if (f6 < ((float) (i5 - 100))) {
                        int i10 = (int) f6;
                        m17303a(binaryBitmap2.crop(0, i10, i4, i5 - i10), decodeOptions, list, i, i7 + i10, i8 + 1);
                    }
                }
            } catch (ReaderException unused) {
            }
        }
    }

    /* renamed from: a */
    private static Result m17302a(Result result, int i, int i2) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i3 = 0; i3 < resultPoints.length; i3++) {
            ResultPoint resultPoint = resultPoints[i3];
            if (resultPoint != null) {
                resultPointArr[i3] = new ResultPoint(resultPoint.getX() + ((float) i), resultPoint.getY() + ((float) i2));
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }
}
