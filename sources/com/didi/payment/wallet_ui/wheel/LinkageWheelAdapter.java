package com.didi.payment.wallet_ui.wheel;

import com.contrarywind.adapter.WheelAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0016J/\u0010\u0017\u001a\u00028\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\bH&¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\bH\u0016J\"\u0010\u001b\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0015\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/wheel/LinkageWheelAdapter;", "T", "Lcom/contrarywind/adapter/WheelAdapter;", "key", "", "rootKey", "linkageKey", "initSelectedIndex", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getInitSelectedIndex", "()I", "getKey", "()Ljava/lang/String;", "getLinkageKey", "getRootKey", "selectedRootIndex", "getSelectedRootIndex$wallet_ui_globalRelease", "setSelectedRootIndex$wallet_ui_globalRelease", "(I)V", "getItem", "index", "(I)Ljava/lang/Object;", "getItemByRoot", "selectedRootKey", "(Ljava/lang/String;ILjava/lang/String;I)Ljava/lang/Object;", "getItemsCount", "getItemsCountByRoot", "indexOf", "o", "(Ljava/lang/Object;)I", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OptionLinkWheelBuilder.kt */
public abstract class LinkageWheelAdapter<T> implements WheelAdapter<T> {
    private final int initSelectedIndex;
    private final String key;
    private final String linkageKey;
    private final String rootKey;
    private int selectedRootIndex;

    public abstract T getItemByRoot(String str, int i, String str2, int i2);

    public abstract int getItemsCountByRoot(String str, int i, String str2);

    public int indexOf(T t) {
        return -1;
    }

    public LinkageWheelAdapter(String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.key = str;
        this.rootKey = str2;
        this.linkageKey = str3;
        this.initSelectedIndex = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LinkageWheelAdapter(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? 0 : i);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getRootKey() {
        return this.rootKey;
    }

    public final String getLinkageKey() {
        return this.linkageKey;
    }

    public final int getInitSelectedIndex() {
        return this.initSelectedIndex;
    }

    public final int getSelectedRootIndex$wallet_ui_globalRelease() {
        return this.selectedRootIndex;
    }

    public final void setSelectedRootIndex$wallet_ui_globalRelease(int i) {
        this.selectedRootIndex = i;
    }

    public int getItemsCount() {
        return getItemsCountByRoot(this.rootKey, this.selectedRootIndex, this.key);
    }

    public T getItem(int i) {
        return getItemByRoot(this.rootKey, this.selectedRootIndex, this.key, i);
    }
}
