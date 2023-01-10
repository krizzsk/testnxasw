package com.didi.soda.customer.p165h5.invokejs;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/soda/customer/h5/invokejs/JSMethodInfo;", "", "moduleName", "", "jsMethodName", "(Ljava/lang/String;Ljava/lang/String;)V", "getJsMethodName", "()Ljava/lang/String;", "setJsMethodName", "(Ljava/lang/String;)V", "getModuleName", "setModuleName", "checkInvalid", "", "toString", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.customer.h5.invokejs.a */
/* compiled from: TriggerManager.kt */
final class C14587a {

    /* renamed from: a */
    private String f43939a;

    /* renamed from: b */
    private String f43940b;

    public C14587a() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public C14587a(String str, String str2) {
        this.f43939a = str;
        this.f43940b = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C14587a(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    /* renamed from: a */
    public final String mo111628a() {
        return this.f43939a;
    }

    /* renamed from: a */
    public final void mo111629a(String str) {
        this.f43939a = str;
    }

    /* renamed from: b */
    public final String mo111630b() {
        return this.f43940b;
    }

    /* renamed from: b */
    public final void mo111631b(String str) {
        this.f43940b = str;
    }

    /* renamed from: c */
    public final boolean mo111632c() {
        CharSequence charSequence = this.f43939a;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        CharSequence charSequence2 = this.f43940b;
        return !(charSequence2 == null || charSequence2.length() == 0);
    }

    public String toString() {
        return "JSMethodInfo(moduleName=" + this.f43939a + ", jsMethodName=" + this.f43940b + VersionRange.RIGHT_OPEN;
    }
}
