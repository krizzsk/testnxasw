package com.adyen.checkout.components.model.payments.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, mo148868d2 = {"Lcom/adyen/checkout/components/model/payments/response/Threeds2ChallengeAction;", "Lcom/adyen/checkout/components/model/payments/response/Action;", "token", "", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "Companion", "components-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Threeds2ChallengeAction.kt */
public final class Threeds2ChallengeAction extends Action {
    public static final String ACTION_TYPE = "threeDS2Challenge";
    public static final Parcelable.Creator<Threeds2ChallengeAction> CREATOR = new ModelObject.Creator(Threeds2ChallengeAction.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final ModelObject.Serializer<Threeds2ChallengeAction> SERIALIZER = new Threeds2ChallengeAction$Companion$SERIALIZER$1();

    /* renamed from: b */
    private static final String f828b = "token";

    /* renamed from: a */
    private final String f829a;

    public Threeds2ChallengeAction() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Threeds2ChallengeAction(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getToken() {
        return this.f829a;
    }

    public Threeds2ChallengeAction(String str) {
        this.f829a = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lcom/adyen/checkout/components/model/payments/response/Threeds2ChallengeAction$Companion;", "", "()V", "ACTION_TYPE", "", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/components/model/payments/response/Threeds2ChallengeAction;", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "TOKEN", "components-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: Threeds2ChallengeAction.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
