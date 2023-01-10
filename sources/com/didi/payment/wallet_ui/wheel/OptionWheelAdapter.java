package com.didi.payment.wallet_ui.wheel;

import com.contrarywind.adapter.WheelAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/wheel/OptionWheelAdapter;", "T", "Lcom/contrarywind/adapter/WheelAdapter;", "key", "", "initSelectedIndex", "", "(Ljava/lang/String;I)V", "getInitSelectedIndex", "()I", "getKey", "()Ljava/lang/String;", "indexOf", "o", "(Ljava/lang/Object;)I", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OptionWheelBuilder.kt */
public abstract class OptionWheelAdapter<T> implements WheelAdapter<T> {
    private final int initSelectedIndex;
    private final String key;

    public int indexOf(T t) {
        return -1;
    }

    public OptionWheelAdapter(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.key = str;
        this.initSelectedIndex = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OptionWheelAdapter(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i);
    }

    public final String getKey() {
        return this.key;
    }

    public final int getInitSelectedIndex() {
        return this.initSelectedIndex;
    }
}
