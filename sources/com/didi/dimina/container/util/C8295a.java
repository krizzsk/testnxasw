package com.didi.dimina.container.util;

import com.wallet.flutter.wallet_flutter.function.FlutterShareMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo148868d2 = {"Lcom/didi/dimina/container/util/CpuTemperatureResult;", "", "filePath", "", "temp", "", "(Ljava/lang/String;I)V", "getFilePath", "()Ljava/lang/String;", "getTemp", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "container_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* renamed from: com.didi.dimina.container.util.a */
/* compiled from: PerformanceCanaryUtil.kt */
final class C8295a {

    /* renamed from: a */
    private final String f19845a;

    /* renamed from: b */
    private final int f19846b;

    public C8295a() {
        this((String) null, 0, 3, (DefaultConstructorMarker) null);
    }

    /* renamed from: a */
    public static /* synthetic */ C8295a m16870a(C8295a aVar, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aVar.f19845a;
        }
        if ((i2 & 2) != 0) {
            i = aVar.f19846b;
        }
        return aVar.mo61903a(str, i);
    }

    /* renamed from: a */
    public final C8295a mo61903a(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, FlutterShareMethod.filePathKey);
        return new C8295a(str, i);
    }

    /* renamed from: c */
    public final String mo61906c() {
        return this.f19845a;
    }

    /* renamed from: d */
    public final int mo61907d() {
        return this.f19846b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8295a)) {
            return false;
        }
        C8295a aVar = (C8295a) obj;
        return Intrinsics.areEqual((Object) this.f19845a, (Object) aVar.f19845a) && this.f19846b == aVar.f19846b;
    }

    public int hashCode() {
        String str = this.f19845a;
        return ((str != null ? str.hashCode() : 0) * 31) + this.f19846b;
    }

    public String toString() {
        return "CpuTemperatureResult(filePath=" + this.f19845a + ", temp=" + this.f19846b + ")";
    }

    public C8295a(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, FlutterShareMethod.filePathKey);
        this.f19845a = str;
        this.f19846b = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C8295a(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }

    /* renamed from: a */
    public final String mo61904a() {
        return this.f19845a;
    }

    /* renamed from: b */
    public final int mo61905b() {
        return this.f19846b;
    }
}
