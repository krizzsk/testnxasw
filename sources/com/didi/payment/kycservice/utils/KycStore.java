package com.didi.payment.kycservice.utils;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/payment/kycservice/utils/KycStore;", "", "()V", "faceStatus", "", "getFaceStatus", "()I", "setFaceStatus", "(I)V", "fullKycStatus", "getFullKycStatus", "setFullKycStatus", "latourKycStatus", "getLatourKycStatus", "setLatourKycStatus", "pixStatus", "", "getPixStatus", "()Ljava/lang/Boolean;", "setPixStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "primaryKycStatus", "getPrimaryKycStatus", "setPrimaryKycStatus", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: KycStore.kt */
public final class KycStore {
    public static final KycStore INSTANCE = new KycStore();

    /* renamed from: a */
    private static int f33468a;

    /* renamed from: b */
    private static int f33469b;

    /* renamed from: c */
    private static int f33470c;

    /* renamed from: d */
    private static int f33471d;

    /* renamed from: e */
    private static Boolean f33472e;

    private KycStore() {
    }

    public final int getPrimaryKycStatus() {
        return f33468a;
    }

    public final void setPrimaryKycStatus(int i) {
        f33468a = i;
    }

    public final int getFullKycStatus() {
        return f33469b;
    }

    public final void setFullKycStatus(int i) {
        f33469b = i;
    }

    public final int getFaceStatus() {
        return f33470c;
    }

    public final void setFaceStatus(int i) {
        f33470c = i;
    }

    public final int getLatourKycStatus() {
        return f33471d;
    }

    public final void setLatourKycStatus(int i) {
        f33471d = i;
    }

    public final Boolean getPixStatus() {
        return f33472e;
    }

    public final void setPixStatus(Boolean bool) {
        f33472e = bool;
    }
}
