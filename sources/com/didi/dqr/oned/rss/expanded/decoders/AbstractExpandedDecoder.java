package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;
import com.didichuxing.diface.logger.DiFaceLogger;

public abstract class AbstractExpandedDecoder {

    /* renamed from: a */
    private final BitArray f20697a;

    /* renamed from: b */
    private final C8462q f20698b;

    public abstract String parseInformation() throws NotFoundException, FormatException;

    AbstractExpandedDecoder(BitArray bitArray) {
        this.f20697a = bitArray;
        this.f20698b = new C8462q(bitArray);
    }

    /* access modifiers changed from: protected */
    public final BitArray getInformation() {
        return this.f20697a;
    }

    /* access modifiers changed from: protected */
    public final C8462q getGeneralDecoder() {
        return this.f20698b;
    }

    public static AbstractExpandedDecoder createDecoder(BitArray bitArray) {
        if (bitArray.get(1)) {
            return new C8452g(bitArray);
        }
        if (!bitArray.get(2)) {
            return new C8455j(bitArray);
        }
        int a = C8462q.m17450a(bitArray, 1, 4);
        if (a == 4) {
            return new C8446a(bitArray);
        }
        if (a == 5) {
            return new C8447b(bitArray);
        }
        int a2 = C8462q.m17450a(bitArray, 1, 5);
        if (a2 == 12) {
            return new C8448c(bitArray);
        }
        if (a2 == 13) {
            return new C8449d(bitArray);
        }
        switch (C8462q.m17450a(bitArray, 1, 7)) {
            case 56:
                return new C8450e(bitArray, "310", "11");
            case 57:
                return new C8450e(bitArray, "320", "11");
            case 58:
                return new C8450e(bitArray, "310", DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
            case 59:
                return new C8450e(bitArray, "320", DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
            case 60:
                return new C8450e(bitArray, "310", DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
            case 61:
                return new C8450e(bitArray, "320", DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
            case 62:
                return new C8450e(bitArray, "310", DiFaceLogger.EVENT_ID_BIOASSAY_EXIT);
            case 63:
                return new C8450e(bitArray, "320", DiFaceLogger.EVENT_ID_BIOASSAY_EXIT);
            default:
                throw new IllegalStateException("unknown decoder: " + bitArray);
        }
    }
}
