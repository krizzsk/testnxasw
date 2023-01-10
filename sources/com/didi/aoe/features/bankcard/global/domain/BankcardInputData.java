package com.didi.aoe.features.bankcard.global.domain;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, mo148868d2 = {"Lcom/didi/aoe/features/bankcard/global/domain/BankcardInputData;", "", "imageData", "", "imageType", "", "imageWidth", "imageHeight", "degree", "result", "Lcom/didi/aoe/features/bankcard/global/domain/DetectCardInfo;", "([BIIIILcom/didi/aoe/features/bankcard/global/domain/DetectCardInfo;)V", "getDegree", "()I", "getImageData", "()[B", "getImageHeight", "getImageType", "getImageWidth", "getResult", "()Lcom/didi/aoe/features/bankcard/global/domain/DetectCardInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "global-ocr_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: BankcardInputData.kt */
public final class BankcardInputData {

    /* renamed from: a */
    private final byte[] f9991a;

    /* renamed from: b */
    private final int f9992b;

    /* renamed from: c */
    private final int f9993c;

    /* renamed from: d */
    private final int f9994d;

    /* renamed from: e */
    private final int f9995e;

    /* renamed from: f */
    private final DetectCardInfo f9996f;

    public static /* synthetic */ BankcardInputData copy$default(BankcardInputData bankcardInputData, byte[] bArr, int i, int i2, int i3, int i4, DetectCardInfo detectCardInfo, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            bArr = bankcardInputData.f9991a;
        }
        if ((i5 & 2) != 0) {
            i = bankcardInputData.f9992b;
        }
        int i6 = i;
        if ((i5 & 4) != 0) {
            i2 = bankcardInputData.f9993c;
        }
        int i7 = i2;
        if ((i5 & 8) != 0) {
            i3 = bankcardInputData.f9994d;
        }
        int i8 = i3;
        if ((i5 & 16) != 0) {
            i4 = bankcardInputData.f9995e;
        }
        int i9 = i4;
        if ((i5 & 32) != 0) {
            detectCardInfo = bankcardInputData.f9996f;
        }
        return bankcardInputData.copy(bArr, i6, i7, i8, i9, detectCardInfo);
    }

    public final byte[] component1() {
        return this.f9991a;
    }

    public final int component2() {
        return this.f9992b;
    }

    public final int component3() {
        return this.f9993c;
    }

    public final int component4() {
        return this.f9994d;
    }

    public final int component5() {
        return this.f9995e;
    }

    public final DetectCardInfo component6() {
        return this.f9996f;
    }

    public final BankcardInputData copy(byte[] bArr, int i, int i2, int i3, int i4, DetectCardInfo detectCardInfo) {
        Intrinsics.checkParameterIsNotNull(bArr, "imageData");
        Intrinsics.checkParameterIsNotNull(detectCardInfo, "result");
        return new BankcardInputData(bArr, i, i2, i3, i4, detectCardInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankcardInputData)) {
            return false;
        }
        BankcardInputData bankcardInputData = (BankcardInputData) obj;
        return Intrinsics.areEqual((Object) this.f9991a, (Object) bankcardInputData.f9991a) && this.f9992b == bankcardInputData.f9992b && this.f9993c == bankcardInputData.f9993c && this.f9994d == bankcardInputData.f9994d && this.f9995e == bankcardInputData.f9995e && Intrinsics.areEqual((Object) this.f9996f, (Object) bankcardInputData.f9996f);
    }

    public int hashCode() {
        byte[] bArr = this.f9991a;
        int i = 0;
        int hashCode = (((((((((bArr != null ? Arrays.hashCode(bArr) : 0) * 31) + this.f9992b) * 31) + this.f9993c) * 31) + this.f9994d) * 31) + this.f9995e) * 31;
        DetectCardInfo detectCardInfo = this.f9996f;
        if (detectCardInfo != null) {
            i = detectCardInfo.hashCode();
        }
        return hashCode + i;
    }

    public BankcardInputData(byte[] bArr, int i, int i2, int i3, int i4, DetectCardInfo detectCardInfo) {
        Intrinsics.checkParameterIsNotNull(bArr, "imageData");
        Intrinsics.checkParameterIsNotNull(detectCardInfo, "result");
        this.f9991a = bArr;
        this.f9992b = i;
        this.f9993c = i2;
        this.f9994d = i3;
        this.f9995e = i4;
        this.f9996f = detectCardInfo;
    }

    public final byte[] getImageData() {
        return this.f9991a;
    }

    public final int getImageType() {
        return this.f9992b;
    }

    public final int getImageWidth() {
        return this.f9993c;
    }

    public final int getImageHeight() {
        return this.f9994d;
    }

    public final int getDegree() {
        return this.f9995e;
    }

    public final DetectCardInfo getResult() {
        return this.f9996f;
    }

    public String toString() {
        return "BankcardInputData[" + this.f9992b + ", " + this.f9993c + " * " + this.f9994d + ", degree: " + this.f9995e + VersionRange.RIGHT_CLOSED;
    }
}
