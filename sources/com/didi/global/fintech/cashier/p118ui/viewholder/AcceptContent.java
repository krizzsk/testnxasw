package com.didi.global.fintech.cashier.p118ui.viewholder;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/AcceptContent;", "", "message", "", "link", "(Ljava/lang/String;Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "getMessage", "setMessage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.AcceptContent */
/* compiled from: GlobalCashierPolicyViewHolder.kt */
public final class AcceptContent {

    /* renamed from: a */
    private String f23670a;

    /* renamed from: b */
    private String f23671b;

    public AcceptContent() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AcceptContent copy$default(AcceptContent acceptContent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = acceptContent.f23670a;
        }
        if ((i & 2) != 0) {
            str2 = acceptContent.f23671b;
        }
        return acceptContent.copy(str, str2);
    }

    public final String component1() {
        return this.f23670a;
    }

    public final String component2() {
        return this.f23671b;
    }

    public final AcceptContent copy(String str, String str2) {
        return new AcceptContent(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AcceptContent)) {
            return false;
        }
        AcceptContent acceptContent = (AcceptContent) obj;
        return Intrinsics.areEqual((Object) this.f23670a, (Object) acceptContent.f23670a) && Intrinsics.areEqual((Object) this.f23671b, (Object) acceptContent.f23671b);
    }

    public int hashCode() {
        String str = this.f23670a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f23671b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AcceptContent(message=" + this.f23670a + ", link=" + this.f23671b + VersionRange.RIGHT_OPEN;
    }

    public AcceptContent(String str, String str2) {
        this.f23670a = str;
        this.f23671b = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AcceptContent(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getMessage() {
        return this.f23670a;
    }

    public final void setMessage(String str) {
        this.f23670a = str;
    }

    public final String getLink() {
        return this.f23671b;
    }

    public final void setLink(String str) {
        this.f23671b = str;
    }
}
