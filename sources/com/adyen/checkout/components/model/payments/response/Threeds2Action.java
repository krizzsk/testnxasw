package com.adyen.checkout.components.model.payments.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, mo148868d2 = {"Lcom/adyen/checkout/components/model/payments/response/Threeds2Action;", "Lcom/adyen/checkout/components/model/payments/response/Action;", "token", "", "subtype", "authorisationToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthorisationToken", "()Ljava/lang/String;", "getSubtype", "getToken", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "Companion", "SubType", "components-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Threeds2Action.kt */
public final class Threeds2Action extends Action {
    public static final String ACTION_TYPE = "threeDS2";
    public static final Parcelable.Creator<Threeds2Action> CREATOR = new ModelObject.Creator(Threeds2Action.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final ModelObject.Serializer<Threeds2Action> SERIALIZER = new Threeds2Action$Companion$SERIALIZER$1();

    /* renamed from: d */
    private static final String f822d = "token";

    /* renamed from: e */
    private static final String f823e = "subtype";

    /* renamed from: f */
    private static final String f824f = "authorisationToken";

    /* renamed from: a */
    private final String f825a;

    /* renamed from: b */
    private final String f826b;

    /* renamed from: c */
    private final String f827c;

    public Threeds2Action() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Threeds2Action(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getToken() {
        return this.f825a;
    }

    public final String getSubtype() {
        return this.f826b;
    }

    public final String getAuthorisationToken() {
        return this.f827c;
    }

    public Threeds2Action(String str, String str2, String str3) {
        this.f825a = str;
        this.f826b = str2;
        this.f827c = str3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo148868d2 = {"Lcom/adyen/checkout/components/model/payments/response/Threeds2Action$Companion;", "", "()V", "ACTION_TYPE", "", "AUTHORISATION_TOKEN", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/components/model/payments/response/Threeds2Action;", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "SUBTYPE", "TOKEN", "components-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: Threeds2Action.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, mo148868d2 = {"Lcom/adyen/checkout/components/model/payments/response/Threeds2Action$SubType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FINGERPRINT", "CHALLENGE", "Companion", "components-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: Threeds2Action.kt */
    public enum SubType {
        FINGERPRINT("fingerprint"),
        CHALLENGE("challenge");
        
        public static final Companion Companion = null;
        private final String value;

        @JvmStatic
        public static final SubType parse(String str) {
            return Companion.parse(str);
        }

        private SubType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo148868d2 = {"Lcom/adyen/checkout/components/model/payments/response/Threeds2Action$SubType$Companion;", "", "()V", "parse", "Lcom/adyen/checkout/components/model/payments/response/Threeds2Action$SubType;", "value", "", "components-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* compiled from: Threeds2Action.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final SubType parse(String str) {
                Intrinsics.checkNotNullParameter(str, "value");
                if (Intrinsics.areEqual((Object) str, (Object) SubType.FINGERPRINT.getValue())) {
                    return SubType.FINGERPRINT;
                }
                if (Intrinsics.areEqual((Object) str, (Object) SubType.CHALLENGE.getValue())) {
                    return SubType.CHALLENGE;
                }
                throw new IllegalArgumentException(Intrinsics.stringPlus("No Subtype matches the value of: ", str));
            }
        }
    }
}
