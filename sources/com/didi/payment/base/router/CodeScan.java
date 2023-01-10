package com.didi.payment.base.router;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/payment/base/router/CodeScan;", "", "code", "", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "base_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CodeScan.kt */
public final class CodeScan {
    @SerializedName("code")
    private final String code;

    public static /* synthetic */ CodeScan copy$default(CodeScan codeScan, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = codeScan.code;
        }
        return codeScan.copy(str);
    }

    public final String component1() {
        return this.code;
    }

    public final CodeScan copy(String str) {
        Intrinsics.checkNotNullParameter(str, "code");
        return new CodeScan(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CodeScan) && Intrinsics.areEqual((Object) this.code, (Object) ((CodeScan) obj).code);
    }

    public int hashCode() {
        return this.code.hashCode();
    }

    public String toString() {
        return "CodeScan(code=" + this.code + VersionRange.RIGHT_OPEN;
    }

    public CodeScan(String str) {
        Intrinsics.checkNotNullParameter(str, "code");
        this.code = str;
    }

    public final String getCode() {
        return this.code;
    }
}
