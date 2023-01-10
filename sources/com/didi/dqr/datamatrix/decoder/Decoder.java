package com.didi.dqr.datamatrix.decoder;

import com.didi.dqr.ChecksumException;
import com.didi.dqr.FormatException;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.common.DecoderResult;
import com.didi.dqr.common.reedsolomon.GenericGF;
import com.didi.dqr.common.reedsolomon.ReedSolomonDecoder;
import com.didi.dqr.common.reedsolomon.ReedSolomonException;

public final class Decoder {

    /* renamed from: a */
    private final ReedSolomonDecoder f20466a = new ReedSolomonDecoder(GenericGF.DATA_MATRIX_FIELD_256);

    public DecoderResult decode(boolean[][] zArr) throws FormatException, ChecksumException {
        return decode(BitMatrix.parse(zArr));
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws FormatException, ChecksumException {
        C8425a aVar = new C8425a(bitMatrix);
        C8426b[] a = C8426b.m17215a(aVar.mo63268b(), aVar.mo63267a());
        int i = 0;
        for (C8426b a2 : a) {
            i += a2.mo63269a();
        }
        byte[] bArr = new byte[i];
        int length = a.length;
        for (int i2 = 0; i2 < length; i2++) {
            C8426b bVar = a[i2];
            byte[] b = bVar.mo63270b();
            int a3 = bVar.mo63269a();
            m17202a(b, a3);
            for (int i3 = 0; i3 < a3; i3++) {
                bArr[(i3 * length) + i2] = b[i3];
            }
        }
        return DecodedBitStreamParser.m17194a(bArr);
    }

    /* renamed from: a */
    private void m17202a(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f20466a.decode(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
