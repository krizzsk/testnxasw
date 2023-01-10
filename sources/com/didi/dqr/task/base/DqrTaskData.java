package com.didi.dqr.task.base;

import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.LuminanceSource;
import com.didi.dqr.common.DecoderResult;
import com.didi.dqr.common.MultiDetectorResult;
import com.didi.dqr.common.StringUtils;

public class DqrTaskData {

    /* renamed from: a */
    private boolean f20974a;

    /* renamed from: b */
    private BinaryBitmap f20975b;

    /* renamed from: c */
    private MultiDetectorResult f20976c;

    /* renamed from: d */
    private DecoderResult f20977d;

    /* renamed from: e */
    private LuminanceSource f20978e;

    /* renamed from: f */
    private DecodeOptions f20979f;
    protected DqrTaskType fromTask;

    public BinaryBitmap getBinaryBitmap() {
        return this.f20975b;
    }

    public void setBinaryBitmap(BinaryBitmap binaryBitmap) {
        this.f20975b = binaryBitmap;
    }

    public MultiDetectorResult getDetectorResult() {
        return this.f20976c;
    }

    public void setDetectorResult(MultiDetectorResult multiDetectorResult) {
        this.f20976c = multiDetectorResult;
    }

    public DecoderResult getDecoderResult() {
        return this.f20977d;
    }

    public void setDecoderResult(DecoderResult decoderResult) {
        this.f20977d = decoderResult;
    }

    public LuminanceSource getSource() {
        return this.f20978e;
    }

    public void setSource(LuminanceSource luminanceSource) {
        this.f20978e = luminanceSource;
    }

    public DecodeOptions getDecodeOptions() {
        return this.f20979f;
    }

    public void setDecodeOptions(DecodeOptions decodeOptions) {
        this.f20979f = decodeOptions;
    }

    public boolean isFinished() {
        DecoderResult decoderResult = this.f20977d;
        return decoderResult != null && !StringUtils.isEmpty(decoderResult.getText());
    }

    public void setFinished(boolean z) {
        this.f20974a = z;
    }
}
