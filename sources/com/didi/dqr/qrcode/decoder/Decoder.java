package com.didi.dqr.qrcode.decoder;

import com.didi.dqr.ChecksumException;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.FormatException;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.common.DecoderResult;
import com.didi.dqr.common.reedsolomon.GenericGF;
import com.didi.dqr.common.reedsolomon.ReedSolomonDecoder;
import com.didi.dqr.common.reedsolomon.ReedSolomonException;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.dqrutil.analysis.EventId;
import java.util.Map;

public final class Decoder {

    /* renamed from: a */
    private final ReedSolomonDecoder f20889a = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);

    public DecoderResult decode(boolean[][] zArr) throws ChecksumException, FormatException {
        return decode(zArr, (Map<DecodeHintType, ?>) null);
    }

    public DecoderResult decode(boolean[][] zArr, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        return decode(BitMatrix.parse(zArr), map);
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        return decode(bitMatrix, (Map<DecodeHintType, ?>) null);
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        ChecksumException e;
        C8485a aVar = new C8485a(bitMatrix);
        FormatException formatException = null;
        try {
            return m17641a(aVar, map);
        } catch (FormatException e2) {
            FormatException formatException2 = e2;
            e = null;
            formatException = formatException2;
            try {
                aVar.mo63549d();
                aVar.mo63546a(true);
                aVar.mo63547b();
                aVar.mo63545a();
                aVar.mo63550e();
                DecoderResult a = m17641a(aVar, map);
                a.setOther(new QRCodeDecoderMetaData(true));
                return a;
            } catch (ChecksumException | FormatException e3) {
                if (formatException != null) {
                    throw formatException;
                } else if (e != null) {
                    throw e;
                } else {
                    throw e3;
                }
            }
        } catch (ChecksumException e4) {
            e = e4;
            aVar.mo63549d();
            aVar.mo63546a(true);
            aVar.mo63547b();
            aVar.mo63545a();
            aVar.mo63550e();
            DecoderResult a2 = m17641a(aVar, map);
            a2.setOther(new QRCodeDecoderMetaData(true));
            return a2;
        }
    }

    /* renamed from: a */
    private DecoderResult m17641a(C8485a aVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        Version b = aVar.mo63547b();
        ErrorCorrectionLevel a = aVar.mo63545a().mo63553a();
        C8486b[] a2 = C8486b.m17653a(aVar.mo63548c(), b, a);
        int i = 0;
        for (C8486b a3 : a2) {
            i += a3.mo63551a();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (C8486b bVar : a2) {
            byte[] b2 = bVar.mo63552b();
            int a4 = bVar.mo63551a();
            m17642a(b2, a4);
            int i3 = 0;
            while (i3 < a4) {
                bArr[i2] = b2[i3];
                i3++;
                i2++;
            }
        }
        return DecodedBitStreamParser.decode(bArr, b, a, map);
    }

    /* renamed from: a */
    private void m17642a(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f20889a.decode(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            AnalysisManager.report(EventId.QRCODE_CORRECT_ERROR_CHECK_ERROR);
            throw ChecksumException.getChecksumInstance();
        }
    }
}
