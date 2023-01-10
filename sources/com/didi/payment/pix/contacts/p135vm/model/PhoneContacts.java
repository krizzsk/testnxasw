package com.didi.payment.pix.contacts.p135vm.model;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0000H\u0002J\u0006\u0010\u001c\u001a\u00020\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, mo148868d2 = {"Lcom/didi/payment/pix/contacts/vm/model/PhoneContacts;", "", "name", "", "phoneNum", "(Ljava/lang/String;Ljava/lang/String;)V", "iconUrl", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "isFirstInGroup", "", "()Z", "setFirstInGroup", "(Z)V", "getName", "setName", "getPhoneNum", "setPhoneNum", "visibility", "", "getVisibility", "()I", "setVisibility", "(I)V", "compareTo", "other", "isValid", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.pix.contacts.vm.model.PhoneContacts */
/* compiled from: PhoneContacts.kt */
public final class PhoneContacts implements Comparable<PhoneContacts> {

    /* renamed from: a */
    private String f33591a;

    /* renamed from: b */
    private String f33592b;

    /* renamed from: c */
    private String f33593c = "";

    /* renamed from: d */
    private boolean f33594d;

    /* renamed from: e */
    private int f33595e;

    public PhoneContacts(String str, String str2) {
        this.f33591a = str;
        this.f33592b = str2;
    }

    public final String getName() {
        return this.f33591a;
    }

    public final String getPhoneNum() {
        return this.f33592b;
    }

    public final void setName(String str) {
        this.f33591a = str;
    }

    public final void setPhoneNum(String str) {
        this.f33592b = str;
    }

    public final String getIconUrl() {
        return this.f33593c;
    }

    public final void setIconUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f33593c = str;
    }

    public final boolean isFirstInGroup() {
        return this.f33594d;
    }

    public final void setFirstInGroup(boolean z) {
        this.f33594d = z;
    }

    public final int getVisibility() {
        return this.f33595e;
    }

    public final void setVisibility(int i) {
        this.f33595e = i;
    }

    public int compareTo(PhoneContacts phoneContacts) {
        Intrinsics.checkNotNullParameter(phoneContacts, "other");
        if (TextUtils.isEmpty(this.f33591a)) {
            return -1;
        }
        if (TextUtils.isEmpty(phoneContacts.f33591a)) {
            return 1;
        }
        String str = this.f33591a;
        if (str == null) {
            return -1;
        }
        String str2 = phoneContacts.f33591a;
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }

    public final boolean isValid() {
        return !TextUtils.isEmpty(this.f33591a) && !TextUtils.isEmpty(this.f33592b);
    }
}
