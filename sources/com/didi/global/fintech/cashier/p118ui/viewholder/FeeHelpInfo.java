package com.didi.global.fintech.cashier.p118ui.viewholder;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/FeeHelpInfo;", "", "type", "", "title", "", "message", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.FeeHelpInfo */
/* compiled from: GlobalCashierFeeViewHolder.kt */
public class FeeHelpInfo {

    /* renamed from: a */
    private Integer f23691a;

    /* renamed from: b */
    private String f23692b;

    /* renamed from: c */
    private String f23693c;

    public FeeHelpInfo() {
        this((Integer) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public FeeHelpInfo(Integer num, String str, String str2) {
        this.f23691a = num;
        this.f23692b = str;
        this.f23693c = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeeHelpInfo(Integer num, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final Integer getType() {
        return this.f23691a;
    }

    public final void setType(Integer num) {
        this.f23691a = num;
    }

    public final String getTitle() {
        return this.f23692b;
    }

    public final void setTitle(String str) {
        this.f23692b = str;
    }

    public final String getMessage() {
        return this.f23693c;
    }

    public final void setMessage(String str) {
        this.f23693c = str;
    }
}
