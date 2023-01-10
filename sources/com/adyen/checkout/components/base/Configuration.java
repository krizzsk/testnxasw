package com.adyen.checkout.components.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.core.api.Environment;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0013H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, mo148868d2 = {"Lcom/adyen/checkout/components/base/Configuration;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "shopperLocale", "Ljava/util/Locale;", "environment", "Lcom/adyen/checkout/core/api/Environment;", "clientKey", "", "(Ljava/util/Locale;Lcom/adyen/checkout/core/api/Environment;Ljava/lang/String;)V", "getClientKey", "()Ljava/lang/String;", "getEnvironment", "()Lcom/adyen/checkout/core/api/Environment;", "getShopperLocale", "()Ljava/util/Locale;", "describeContents", "", "writeToParcel", "", "flags", "components-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Configuration.kt */
public abstract class Configuration implements Parcelable {

    /* renamed from: a */
    private final Locale f654a;

    /* renamed from: b */
    private final Environment f655b;

    /* renamed from: c */
    private final String f656c;

    public int describeContents() {
        return 0;
    }

    protected Configuration(Locale locale, Environment environment, String str) {
        Intrinsics.checkNotNullParameter(locale, "shopperLocale");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(str, "clientKey");
        this.f654a = locale;
        this.f655b = environment;
        this.f656c = str;
    }

    public final Locale getShopperLocale() {
        return this.f654a;
    }

    public final Environment getEnvironment() {
        return this.f655b;
    }

    public final String getClientKey() {
        return this.f656c;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Configuration(android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.io.Serializable r0 = r4.readSerializable()
            if (r0 == 0) goto L_0x0031
            java.util.Locale r0 = (java.util.Locale) r0
            java.lang.Class<com.adyen.checkout.core.api.Environment> r1 = com.adyen.checkout.core.api.Environment.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r4.readParcelable(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r2 = "parcel.readParcelable(Environment::class.java.classLoader)!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.adyen.checkout.core.api.Environment r1 = (com.adyen.checkout.core.api.Environment) r1
            java.lang.String r4 = r4.readString()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r2 = "parcel.readString()!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            r3.<init>(r0, r1, r4)
            return
        L_0x0031:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type java.util.Locale"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.components.base.Configuration.<init>(android.os.Parcel):void");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeSerializable(this.f654a);
        parcel.writeParcelable(this.f655b, i);
        parcel.writeString(this.f656c);
    }
}
