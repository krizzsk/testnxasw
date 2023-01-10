package com.jumio.core.extraction.liveness.extraction;

import com.jumio.commons.PersistWith;
import com.jumio.commons.camera.ImageData;
import com.jumio.core.data.ScanMode;
import com.jumio.core.model.StaticModel;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, mo148868d2 = {"Lcom/jumio/core/extraction/liveness/extraction/LivenessDataModel;", "Lcom/jumio/core/model/StaticModel;", "Lcom/jumio/core/data/ScanMode;", "a", "Lcom/jumio/core/data/ScanMode;", "getType", "()Lcom/jumio/core/data/ScanMode;", "setType", "(Lcom/jumio/core/data/ScanMode;)V", "type", "", "Lcom/jumio/commons/camera/ImageData;", "b", "[Lcom/jumio/commons/camera/ImageData;", "getFrames", "()[Lcom/jumio/commons/camera/ImageData;", "setFrames", "([Lcom/jumio/commons/camera/ImageData;)V", "frames", "", "c", "Ljava/lang/Boolean;", "isPassed", "()Ljava/lang/Boolean;", "setPassed", "(Ljava/lang/Boolean;)V", "<init>", "()V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
@PersistWith("LivenessDataModel")
/* compiled from: LivenessDataModel.kt */
public final class LivenessDataModel implements StaticModel {

    /* renamed from: a */
    public ScanMode f57609a;

    /* renamed from: b */
    public ImageData[] f57610b;

    /* renamed from: c */
    public Boolean f57611c;

    public final ImageData[] getFrames() {
        return this.f57610b;
    }

    public final ScanMode getType() {
        return this.f57609a;
    }

    public final Boolean isPassed() {
        return this.f57611c;
    }

    public final void setFrames(ImageData[] imageDataArr) {
        this.f57610b = imageDataArr;
    }

    public final void setPassed(Boolean bool) {
        this.f57611c = bool;
    }

    public final void setType(ScanMode scanMode) {
        this.f57609a = scanMode;
    }
}
