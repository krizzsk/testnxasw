package com.didi.aoe.features.bankcard.global.domain;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, mo148868d2 = {"Lcom/didi/aoe/features/bankcard/global/domain/RecognizeInfo;", "", "prediction", "", "prob", "", "count", "", "([IFI)V", "getCount", "()I", "setCount", "(I)V", "getPrediction", "()[I", "setPrediction", "([I)V", "getProb", "()F", "setProb", "(F)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "global-ocr_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: RecognizeInfo.kt */
public final class RecognizeInfo {

    /* renamed from: a */
    private int[] f9997a;

    /* renamed from: b */
    private float f9998b;

    /* renamed from: c */
    private int f9999c;

    public RecognizeInfo() {
        this((int[]) null, 0.0f, 0, 7, (DefaultConstructorMarker) null);
    }

    public RecognizeInfo(int[] iArr) {
        this(iArr, 0.0f, 0, 6, (DefaultConstructorMarker) null);
    }

    public RecognizeInfo(int[] iArr, float f) {
        this(iArr, f, 0, 4, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecognizeInfo copy$default(RecognizeInfo recognizeInfo, int[] iArr, float f, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iArr = recognizeInfo.f9997a;
        }
        if ((i2 & 2) != 0) {
            f = recognizeInfo.f9998b;
        }
        if ((i2 & 4) != 0) {
            i = recognizeInfo.f9999c;
        }
        return recognizeInfo.copy(iArr, f, i);
    }

    public final int[] component1() {
        return this.f9997a;
    }

    public final float component2() {
        return this.f9998b;
    }

    public final int component3() {
        return this.f9999c;
    }

    public final RecognizeInfo copy(int[] iArr, float f, int i) {
        Intrinsics.checkParameterIsNotNull(iArr, "prediction");
        return new RecognizeInfo(iArr, f, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecognizeInfo)) {
            return false;
        }
        RecognizeInfo recognizeInfo = (RecognizeInfo) obj;
        return Intrinsics.areEqual((Object) this.f9997a, (Object) recognizeInfo.f9997a) && Float.compare(this.f9998b, recognizeInfo.f9998b) == 0 && this.f9999c == recognizeInfo.f9999c;
    }

    public int hashCode() {
        int[] iArr = this.f9997a;
        return ((((iArr != null ? Arrays.hashCode(iArr) : 0) * 31) + Float.floatToIntBits(this.f9998b)) * 31) + this.f9999c;
    }

    public RecognizeInfo(int[] iArr, float f, int i) {
        Intrinsics.checkParameterIsNotNull(iArr, "prediction");
        this.f9997a = iArr;
        this.f9998b = f;
        this.f9999c = i;
    }

    public final int[] getPrediction() {
        return this.f9997a;
    }

    public final void setPrediction(int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "<set-?>");
        this.f9997a = iArr;
    }

    public final float getProb() {
        return this.f9998b;
    }

    public final void setProb(float f) {
        this.f9998b = f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecognizeInfo(int[] iArr, float f, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new int[0] : iArr, (i2 & 2) != 0 ? 0.0f : f, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getCount() {
        return this.f9999c;
    }

    public final void setCount(int i) {
        this.f9999c = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RecognizeInfo ");
        sb.append(this.f9998b);
        sb.append(' ');
        String arrays = Arrays.toString(this.f9997a);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        return sb.toString();
    }
}
