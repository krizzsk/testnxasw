package com.didi.nova.kyc.jumio.module;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010'\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 ¨\u0006*"}, mo148868d2 = {"Lcom/didi/nova/kyc/jumio/module/JumioParams;", "", "()V", "AUTO_TYPE", "", "getAUTO_TYPE", "()I", "setAUTO_TYPE", "(I)V", "BUTTON_AUTO", "getBUTTON_AUTO", "setBUTTON_AUTO", "BUTTON_BACK", "getBUTTON_BACK", "setBUTTON_BACK", "BUTTON_FLASH", "getBUTTON_FLASH", "setBUTTON_FLASH", "BUTTON_TACK_PIC", "getBUTTON_TACK_PIC", "setBUTTON_TACK_PIC", "BUTTON_TIPS", "getBUTTON_TIPS", "setBUTTON_TIPS", "DOCUMENT_SIDE", "getDOCUMENT_SIDE", "setDOCUMENT_SIDE", "ERROR_CODE", "", "getERROR_CODE", "()Ljava/lang/String;", "setERROR_CODE", "(Ljava/lang/String;)V", "FLASH_STATUS", "getFLASH_STATUS", "setFLASH_STATUS", "REJECT_REASON", "getREJECT_REASON", "setREJECT_REASON", "RETRY_REASON", "getRETRY_REASON", "setRETRY_REASON", "kyc-jumios_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: JumioParams.kt */
public final class JumioParams {
    public static final JumioParams INSTANCE = new JumioParams();

    /* renamed from: a */
    private static int f31804a = 1;

    /* renamed from: b */
    private static int f31805b = 1;

    /* renamed from: c */
    private static int f31806c = 2;

    /* renamed from: d */
    private static String f31807d = "";

    /* renamed from: e */
    private static String f31808e = "";

    /* renamed from: f */
    private static String f31809f = "";

    /* renamed from: g */
    private static int f31810g = 1;

    /* renamed from: h */
    private static int f31811h = 2;

    /* renamed from: i */
    private static int f31812i = 3;

    /* renamed from: j */
    private static int f31813j = 4;

    /* renamed from: k */
    private static int f31814k = 5;

    private JumioParams() {
    }

    public final int getAUTO_TYPE() {
        return f31804a;
    }

    public final void setAUTO_TYPE(int i) {
        f31804a = i;
    }

    public final int getDOCUMENT_SIDE() {
        return f31805b;
    }

    public final void setDOCUMENT_SIDE(int i) {
        f31805b = i;
    }

    public final int getFLASH_STATUS() {
        return f31806c;
    }

    public final void setFLASH_STATUS(int i) {
        f31806c = i;
    }

    public final String getREJECT_REASON() {
        return f31807d;
    }

    public final void setREJECT_REASON(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f31807d = str;
    }

    public final String getRETRY_REASON() {
        return f31808e;
    }

    public final void setRETRY_REASON(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f31808e = str;
    }

    public final String getERROR_CODE() {
        return f31809f;
    }

    public final void setERROR_CODE(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f31809f = str;
    }

    public final int getBUTTON_AUTO() {
        return f31810g;
    }

    public final void setBUTTON_AUTO(int i) {
        f31810g = i;
    }

    public final int getBUTTON_FLASH() {
        return f31811h;
    }

    public final void setBUTTON_FLASH(int i) {
        f31811h = i;
    }

    public final int getBUTTON_TIPS() {
        return f31812i;
    }

    public final void setBUTTON_TIPS(int i) {
        f31812i = i;
    }

    public final int getBUTTON_TACK_PIC() {
        return f31813j;
    }

    public final void setBUTTON_TACK_PIC(int i) {
        f31813j = i;
    }

    public final int getBUTTON_BACK() {
        return f31814k;
    }

    public final void setBUTTON_BACK(int i) {
        f31814k = i;
    }
}
