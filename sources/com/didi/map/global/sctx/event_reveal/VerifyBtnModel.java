package com.didi.map.global.sctx.event_reveal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/VerifyBtnModel;", "", "text", "", "code", "", "(Ljava/lang/String;I)V", "getCode", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TriggeredTrafficEventShowModel.kt */
public final class VerifyBtnModel {

    /* renamed from: a */
    private final String f30079a;

    /* renamed from: b */
    private final int f30080b;

    public static /* synthetic */ VerifyBtnModel copy$default(VerifyBtnModel verifyBtnModel, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = verifyBtnModel.f30079a;
        }
        if ((i2 & 2) != 0) {
            i = verifyBtnModel.f30080b;
        }
        return verifyBtnModel.copy(str, i);
    }

    public final String component1() {
        return this.f30079a;
    }

    public final int component2() {
        return this.f30080b;
    }

    public final VerifyBtnModel copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new VerifyBtnModel(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerifyBtnModel)) {
            return false;
        }
        VerifyBtnModel verifyBtnModel = (VerifyBtnModel) obj;
        return Intrinsics.areEqual((Object) this.f30079a, (Object) verifyBtnModel.f30079a) && this.f30080b == verifyBtnModel.f30080b;
    }

    public int hashCode() {
        return (this.f30079a.hashCode() * 31) + this.f30080b;
    }

    public String toString() {
        return "VerifyBtnModel(text=" + this.f30079a + ", code=" + this.f30080b + VersionRange.RIGHT_OPEN;
    }

    public VerifyBtnModel(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.f30079a = str;
        this.f30080b = i;
    }

    public final String getText() {
        return this.f30079a;
    }

    public final int getCode() {
        return this.f30080b;
    }
}
