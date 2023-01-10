package com.didi.dqr.datamatrix;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.Dimension;
import com.didi.dqr.EncodeHintType;
import com.didi.dqr.Writer;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.datamatrix.encoder.DefaultPlacement;
import com.didi.dqr.datamatrix.encoder.ErrorCorrection;
import com.didi.dqr.datamatrix.encoder.HighLevelEncoder;
import com.didi.dqr.datamatrix.encoder.SymbolInfo;
import com.didi.dqr.datamatrix.encoder.SymbolShapeHint;
import com.didi.dqr.qrcode.encoder.ByteMatrix;
import java.util.Map;

public final class DataMatrixWriter implements Writer {
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, (Map<EncodeHintType, ?>) null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Dimension dimension;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i + 'x' + i2);
        } else {
            SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
            Dimension dimension2 = null;
            if (map != null) {
                SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
                if (symbolShapeHint2 != null) {
                    symbolShapeHint = symbolShapeHint2;
                }
                Dimension dimension3 = (Dimension) map.get(EncodeHintType.MIN_SIZE);
                if (dimension3 == null) {
                    dimension3 = null;
                }
                dimension = (Dimension) map.get(EncodeHintType.MAX_SIZE);
                if (dimension == null) {
                    dimension = null;
                }
                dimension2 = dimension3;
            } else {
                dimension = null;
            }
            String encodeHighLevel = HighLevelEncoder.encodeHighLevel(str, symbolShapeHint, dimension2, dimension);
            SymbolInfo lookup = SymbolInfo.lookup(encodeHighLevel.length(), symbolShapeHint, dimension2, dimension, true);
            DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.encodeECC200(encodeHighLevel, lookup), lookup.getSymbolDataWidth(), lookup.getSymbolDataHeight());
            defaultPlacement.place();
            return m17191a(defaultPlacement, lookup, i, i2);
        }
    }

    /* renamed from: a */
    private static BitMatrix m17191a(DefaultPlacement defaultPlacement, SymbolInfo symbolInfo, int i, int i2) {
        int symbolDataWidth = symbolInfo.getSymbolDataWidth();
        int symbolDataHeight = symbolInfo.getSymbolDataHeight();
        ByteMatrix byteMatrix = new ByteMatrix(symbolInfo.getSymbolWidth(), symbolInfo.getSymbolHeight());
        int i3 = 0;
        for (int i4 = 0; i4 < symbolDataHeight; i4++) {
            if (i4 % symbolInfo.matrixHeight == 0) {
                int i5 = 0;
                for (int i6 = 0; i6 < symbolInfo.getSymbolWidth(); i6++) {
                    byteMatrix.set(i5, i3, i6 % 2 == 0);
                    i5++;
                }
                i3++;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < symbolDataWidth; i8++) {
                if (i8 % symbolInfo.matrixWidth == 0) {
                    byteMatrix.set(i7, i3, true);
                    i7++;
                }
                byteMatrix.set(i7, i3, defaultPlacement.getBit(i8, i4));
                i7++;
                if (i8 % symbolInfo.matrixWidth == symbolInfo.matrixWidth - 1) {
                    byteMatrix.set(i7, i3, i4 % 2 == 0);
                    i7++;
                }
            }
            i3++;
            if (i4 % symbolInfo.matrixHeight == symbolInfo.matrixHeight - 1) {
                int i9 = 0;
                for (int i10 = 0; i10 < symbolInfo.getSymbolWidth(); i10++) {
                    byteMatrix.set(i9, i3, true);
                    i9++;
                }
                i3++;
            }
        }
        return m17192a(byteMatrix, i, i2);
    }

    /* renamed from: a */
    private static BitMatrix m17192a(ByteMatrix byteMatrix, int i, int i2) {
        BitMatrix bitMatrix;
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int max = Math.max(i, width);
        int max2 = Math.max(i2, height);
        int min = Math.min(max / width, max2 / height);
        int i3 = (max - (width * min)) / 2;
        int i4 = (max2 - (height * min)) / 2;
        if (i2 < height || i < width) {
            bitMatrix = new BitMatrix(width, height);
            i3 = 0;
            i4 = 0;
        } else {
            bitMatrix = new BitMatrix(i, i2);
        }
        bitMatrix.clear();
        int i5 = 0;
        while (i5 < height) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < width) {
                if (byteMatrix.get(i7, i5) == 1) {
                    bitMatrix.setRegion(i6, i4, min, min);
                }
                i7++;
                i6 += min;
            }
            i5++;
            i4 += min;
        }
        return bitMatrix;
    }
}
