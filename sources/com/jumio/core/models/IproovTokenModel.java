package com.jumio.core.models;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.osgi.framework.VersionRange;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B%\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J'\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\"\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006#"}, mo148868d2 = {"Lcom/jumio/core/models/IproovTokenModel;", "Lcom/jumio/core/model/StaticModel;", "", "component1", "component2", "component3", "token", "url", "productType", "copy", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "b", "getUrl", "c", "getProductType", "d", "Z", "getUsed", "()Z", "setUsed", "(Z)V", "used", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
@PersistWith("IproovTokenModel")
/* compiled from: IproovTokenModel.kt */
public final class IproovTokenModel implements StaticModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    public final String f57684a;

    /* renamed from: b */
    public final String f57685b;

    /* renamed from: c */
    public final String f57686c;

    /* renamed from: d */
    public boolean f57687d;

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, mo148868d2 = {"Lcom/jumio/core/models/IproovTokenModel$Companion;", "", "", "string", "Lcom/jumio/core/models/IproovTokenModel;", "fromString", "<init>", "()V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: IproovTokenModel.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IproovTokenModel fromString(String str) {
            Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("token");
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"token\")");
            String string2 = jSONObject.getString("url");
            Intrinsics.checkNotNullExpressionValue(string2, "json.getString(\"url\")");
            String string3 = jSONObject.getString("productType");
            Intrinsics.checkNotNullExpressionValue(string3, "json.getString(\"productType\")");
            return new IproovTokenModel(string, string2, string3);
        }
    }

    public IproovTokenModel() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public IproovTokenModel(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "productType");
        this.f57684a = str;
        this.f57685b = str2;
        this.f57686c = str3;
    }

    public static /* synthetic */ IproovTokenModel copy$default(IproovTokenModel iproovTokenModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iproovTokenModel.f57684a;
        }
        if ((i & 2) != 0) {
            str2 = iproovTokenModel.f57685b;
        }
        if ((i & 4) != 0) {
            str3 = iproovTokenModel.f57686c;
        }
        return iproovTokenModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.f57684a;
    }

    public final String component2() {
        return this.f57685b;
    }

    public final String component3() {
        return this.f57686c;
    }

    public final IproovTokenModel copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "productType");
        return new IproovTokenModel(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IproovTokenModel)) {
            return false;
        }
        IproovTokenModel iproovTokenModel = (IproovTokenModel) obj;
        return Intrinsics.areEqual((Object) this.f57684a, (Object) iproovTokenModel.f57684a) && Intrinsics.areEqual((Object) this.f57685b, (Object) iproovTokenModel.f57685b) && Intrinsics.areEqual((Object) this.f57686c, (Object) iproovTokenModel.f57686c);
    }

    public final String getProductType() {
        return this.f57686c;
    }

    public final String getToken() {
        return this.f57684a;
    }

    public final String getUrl() {
        return this.f57685b;
    }

    public final boolean getUsed() {
        return this.f57687d;
    }

    public int hashCode() {
        return (((this.f57684a.hashCode() * 31) + this.f57685b.hashCode()) * 31) + this.f57686c.hashCode();
    }

    public final void setUsed(boolean z) {
        this.f57687d = z;
    }

    public String toString() {
        return "IproovTokenModel(token=" + this.f57684a + ", url=" + this.f57685b + ", productType=" + this.f57686c + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IproovTokenModel(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "iproov_standard" : str3);
    }
}
