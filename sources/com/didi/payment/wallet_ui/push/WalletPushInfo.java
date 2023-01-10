package com.didi.payment.wallet_ui.push;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0017"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/push/WalletPushInfo;", "", "title", "", "subTitle", "router", "", "cancelOnBack", "", "cancelOnTouchOutside", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/String;ZZ)V", "getCancelOnBack", "()Z", "getCancelOnTouchOutside", "getRouter", "()Ljava/lang/String;", "getSubTitle", "()Ljava/lang/CharSequence;", "getTitle", "equals", "other", "hashCode", "", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletPushInfo.kt */
public final class WalletPushInfo {

    /* renamed from: a */
    private final CharSequence f35676a;

    /* renamed from: b */
    private final CharSequence f35677b;

    /* renamed from: c */
    private final String f35678c;

    /* renamed from: d */
    private final boolean f35679d;

    /* renamed from: e */
    private final boolean f35680e;

    public WalletPushInfo(CharSequence charSequence, CharSequence charSequence2, String str, boolean z, boolean z2) {
        this.f35676a = charSequence;
        this.f35677b = charSequence2;
        this.f35678c = str;
        this.f35679d = z;
        this.f35680e = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletPushInfo(CharSequence charSequence, CharSequence charSequence2, String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, charSequence2, str, (i & 8) != 0 ? true : z, (i & 16) != 0 ? true : z2);
    }

    public final CharSequence getTitle() {
        return this.f35676a;
    }

    public final CharSequence getSubTitle() {
        return this.f35677b;
    }

    public final String getRouter() {
        return this.f35678c;
    }

    public final boolean getCancelOnBack() {
        return this.f35679d;
    }

    public final boolean getCancelOnTouchOutside() {
        return this.f35680e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            return false;
        }
        WalletPushInfo walletPushInfo = (WalletPushInfo) obj;
        if (!Intrinsics.areEqual((Object) this.f35676a, (Object) walletPushInfo.f35676a) || !Intrinsics.areEqual((Object) this.f35677b, (Object) walletPushInfo.f35677b) || !Intrinsics.areEqual((Object) this.f35678c, (Object) walletPushInfo.f35678c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f35676a, this.f35677b, this.f35678c});
    }
}
