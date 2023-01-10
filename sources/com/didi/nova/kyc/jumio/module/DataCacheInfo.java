package com.didi.nova.kyc.jumio.module;

import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.enums.JumioScanSide;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, mo148868d2 = {"Lcom/didi/nova/kyc/jumio/module/DataCacheInfo;", "", "()V", "credentialInfoCard", "Lcom/jumio/sdk/credentials/JumioCredentialInfo;", "getCredentialInfoCard", "()Lcom/jumio/sdk/credentials/JumioCredentialInfo;", "setCredentialInfoCard", "(Lcom/jumio/sdk/credentials/JumioCredentialInfo;)V", "credentialInfoFace", "getCredentialInfoFace", "setCredentialInfoFace", "credentialPartBack", "Lcom/jumio/sdk/enums/JumioScanSide;", "getCredentialPartBack", "()Lcom/jumio/sdk/enums/JumioScanSide;", "setCredentialPartBack", "(Lcom/jumio/sdk/enums/JumioScanSide;)V", "credentialPartFace", "getCredentialPartFace", "setCredentialPartFace", "credentialPartFront", "getCredentialPartFront", "setCredentialPartFront", "currentPartName", "", "getCurrentPartName", "()Ljava/lang/String;", "setCurrentPartName", "(Ljava/lang/String;)V", "Companion", "kyc-jumios_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DataCacheInfo.kt */
public final class DataCacheInfo {
    public static final String BACK = "BACK";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FACE = "FACE";
    public static final String FRONT = "FRONT";

    /* renamed from: a */
    private String f31798a = "";

    /* renamed from: b */
    private JumioScanSide f31799b;

    /* renamed from: c */
    private JumioScanSide f31800c;

    /* renamed from: d */
    private JumioScanSide f31801d;

    /* renamed from: e */
    private JumioCredentialInfo f31802e;

    /* renamed from: f */
    private JumioCredentialInfo f31803f;

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/nova/kyc/jumio/module/DataCacheInfo$Companion;", "", "()V", "BACK", "", "FACE", "FRONT", "kyc-jumios_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: DataCacheInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String getCurrentPartName() {
        return this.f31798a;
    }

    public final void setCurrentPartName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f31798a = str;
    }

    public final JumioScanSide getCredentialPartFront() {
        return this.f31799b;
    }

    public final void setCredentialPartFront(JumioScanSide jumioScanSide) {
        this.f31799b = jumioScanSide;
    }

    public final JumioScanSide getCredentialPartBack() {
        return this.f31800c;
    }

    public final void setCredentialPartBack(JumioScanSide jumioScanSide) {
        this.f31800c = jumioScanSide;
    }

    public final JumioScanSide getCredentialPartFace() {
        return this.f31801d;
    }

    public final void setCredentialPartFace(JumioScanSide jumioScanSide) {
        this.f31801d = jumioScanSide;
    }

    public final JumioCredentialInfo getCredentialInfoFace() {
        return this.f31802e;
    }

    public final void setCredentialInfoFace(JumioCredentialInfo jumioCredentialInfo) {
        this.f31802e = jumioCredentialInfo;
    }

    public final JumioCredentialInfo getCredentialInfoCard() {
        return this.f31803f;
    }

    public final void setCredentialInfoCard(JumioCredentialInfo jumioCredentialInfo) {
        this.f31803f = jumioCredentialInfo;
    }
}
