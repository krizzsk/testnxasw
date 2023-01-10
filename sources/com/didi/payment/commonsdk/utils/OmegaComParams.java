package com.didi.payment.commonsdk.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/payment/commonsdk/utils/OmegaComParams;", "", "()V", "Companion", "wallet-service-commonsdk_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OmegaComParams.kt */
public final class OmegaComParams {
    public static final String ADDRESS_VERIFY = "address_verify";
    public static final String BOLETO_DIALOG = "boleto_dialog";
    public static final String BOLETO_EDIT_AMOUNT_PAGE = "boleto_amount_edit";
    public static final String BOLETO_HOME = "boleto_home";
    public static final String BOLETO_MANUAL_PAGE = "boleto_manual";
    public static final String BOLETO_SCAN_PAGE = "boleto_scan";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FACE_GUIDE = "faceguide";
    public static final String FULL_KYC = "fullkycinformation";
    public static final String FULL_KYC_VER = "fullkycverification";
    public static final String JUMIO_CONFIRM = "jumioconfirm";
    public static final String JUMIO_DOCUMENT = "jumiodocument";
    public static final String JUMIO_DOCUMENT_REJECT = "jumiodocumentreject";
    public static final String JUMIO_DOCUMENT_RETRY = "jumiodocumentretry";
    public static final String JUMIO_ERROR = "jumioerror";
    public static final String JUMIO_FACECHECK = "jumiofacecheck";
    public static final String KYC_GUIDE = "kycguide";
    public static final String KYC_RESULET_PEG = "kycresultpage";
    public static final String PIX_KEY_REG = "pixkeyregistration";
    public static final String PRE_PIX_KEY = "prepixkeyregistration";
    public static final String PRIMARY_KYC = "primarykycinformation";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f32667a = "0";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f32668b = "";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static String f32669c = "";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static int f32670d = 1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static String f32671e = "";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static int f32672f = 1;

    @JvmStatic
    public static final void cleanConParams() {
        Companion.cleanConParams();
    }

    @Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010/\u001a\u000200H\u0007J\u000e\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001eR\u001a\u0010&\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001a\u0010)\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\u001a\u0010,\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001e¨\u00063"}, mo148868d2 = {"Lcom/didi/payment/commonsdk/utils/OmegaComParams$Companion;", "", "()V", "ADDRESS_VERIFY", "", "BOLETO_DIALOG", "BOLETO_EDIT_AMOUNT_PAGE", "BOLETO_HOME", "BOLETO_MANUAL_PAGE", "BOLETO_SCAN_PAGE", "FACE_GUIDE", "FULL_KYC", "FULL_KYC_VER", "JUMIO_CONFIRM", "JUMIO_DOCUMENT", "JUMIO_DOCUMENT_REJECT", "JUMIO_DOCUMENT_RETRY", "JUMIO_ERROR", "JUMIO_FACECHECK", "KYC_GUIDE", "KYC_PROCESS_STATE", "", "getKYC_PROCESS_STATE", "()I", "setKYC_PROCESS_STATE", "(I)V", "KYC_RESOURCE_ID", "getKYC_RESOURCE_ID", "()Ljava/lang/String;", "setKYC_RESOURCE_ID", "(Ljava/lang/String;)V", "KYC_RESULET_PEG", "PIX_KEY_REG", "PRE_PIX_KEY", "PRIMARY_KYC", "PUB_FROM_PAGE", "getPUB_FROM_PAGE", "setPUB_FROM_PAGE", "PUB_FROM_PRIMARY", "getPUB_FROM_PRIMARY", "setPUB_FROM_PRIMARY", "PUB_PAGE", "getPUB_PAGE", "setPUB_PAGE", "SOURCE", "getSOURCE", "setSOURCE", "cleanConParams", "", "setPubPage", "page", "wallet-service-commonsdk_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: OmegaComParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getSOURCE() {
            return OmegaComParams.f32667a;
        }

        public final void setSOURCE(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OmegaComParams.f32667a = str;
        }

        public final String getPUB_FROM_PAGE() {
            return OmegaComParams.f32668b;
        }

        public final void setPUB_FROM_PAGE(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OmegaComParams.f32668b = str;
        }

        public final String getPUB_PAGE() {
            return OmegaComParams.f32669c;
        }

        public final void setPUB_PAGE(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OmegaComParams.f32669c = str;
        }

        public final int getPUB_FROM_PRIMARY() {
            return OmegaComParams.f32670d;
        }

        public final void setPUB_FROM_PRIMARY(int i) {
            OmegaComParams.f32670d = i;
        }

        public final String getKYC_RESOURCE_ID() {
            return OmegaComParams.f32671e;
        }

        public final void setKYC_RESOURCE_ID(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OmegaComParams.f32671e = str;
        }

        public final int getKYC_PROCESS_STATE() {
            return OmegaComParams.f32672f;
        }

        public final void setKYC_PROCESS_STATE(int i) {
            OmegaComParams.f32672f = i;
        }

        public final void setPubPage(String str) {
            Intrinsics.checkNotNullParameter(str, "page");
            String pub_page = getPUB_PAGE();
            setPUB_PAGE(str);
            setPUB_FROM_PAGE(pub_page);
        }

        @JvmStatic
        public final void cleanConParams() {
            setSOURCE("0");
            setPUB_PAGE("");
            setPUB_FROM_PAGE("");
            setPUB_FROM_PRIMARY(1);
            setKYC_RESOURCE_ID("");
            setKYC_PROCESS_STATE(1);
        }
    }
}
