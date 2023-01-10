package com.didi.dqr.oned;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.EncodeHintType;
import com.didi.dqr.FormatException;
import com.didi.dqr.WriterException;
import com.didi.dqr.common.BitMatrix;
import java.util.Map;

public final class EAN8Writer extends UPCEANWriter {

    /* renamed from: a */
    private static final int f20603a = 67;

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + barcodeFormat);
    }

    public boolean[] encode(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + UPCEANReader.m17352b(str);
            } catch (FormatException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length == 8) {
            try {
                if (!UPCEANReader.m17348a((CharSequence) str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + length);
        }
        boolean[] zArr = new boolean[67];
        int appendPattern = appendPattern(zArr, 0, UPCEANReader.f20624b, true) + 0;
        for (int i = 0; i <= 3; i++) {
            appendPattern += appendPattern(zArr, appendPattern, UPCEANReader.f20627e[Character.digit(str.charAt(i), 10)], false);
        }
        int appendPattern2 = appendPattern + appendPattern(zArr, appendPattern, UPCEANReader.f20625c, false);
        for (int i2 = 4; i2 <= 7; i2++) {
            appendPattern2 += appendPattern(zArr, appendPattern2, UPCEANReader.f20627e[Character.digit(str.charAt(i2), 10)], true);
        }
        appendPattern(zArr, appendPattern2, UPCEANReader.f20624b, true);
        return zArr;
    }
}
