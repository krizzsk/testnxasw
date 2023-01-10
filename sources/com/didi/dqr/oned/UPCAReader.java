package com.didi.dqr.oned;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.ChecksumException;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.Result;
import com.didi.dqr.common.BitArray;
import java.util.Map;

public final class UPCAReader extends UPCEANReader {

    /* renamed from: a */
    private final UPCEANReader f20621a = new EAN13Reader();

    public Result decodeRow(int i, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return m17345a(this.f20621a.decodeRow(i, bitArray, iArr, map));
    }

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return m17345a(this.f20621a.decodeRow(i, bitArray, map));
    }

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return m17345a(this.f20621a.decode(binaryBitmap));
    }

    public Result decode(BinaryBitmap binaryBitmap, DecodeOptions decodeOptions) throws NotFoundException, FormatException {
        return m17345a(this.f20621a.decode(binaryBitmap, decodeOptions));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public BarcodeFormat mo63321a() {
        return BarcodeFormat.UPC_A;
    }

    /* access modifiers changed from: protected */
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.f20621a.decodeMiddle(bitArray, iArr, sb);
    }

    /* renamed from: a */
    private static Result m17345a(Result result) throws FormatException {
        String text = result.getText();
        if (text.charAt(0) == '0') {
            return new Result(text.substring(1), (byte[]) null, result.getResultPoints(), BarcodeFormat.UPC_A);
        }
        throw FormatException.getFormatInstance();
    }
}
