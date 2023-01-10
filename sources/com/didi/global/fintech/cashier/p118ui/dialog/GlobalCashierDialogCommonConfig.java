package com.didi.global.fintech.cashier.p118ui.dialog;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\n\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(J\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(J\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019¨\u0006*"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCommonConfig;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogBaseConfig;", "title", "", "titleRes", "", "subTitle", "subTitleRes", "positiveText", "positiveTextRes", "negativeText", "negativeTextRes", "isHorizontal", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Z)V", "()Z", "setHorizontal", "(Z)V", "getNegativeText", "()Ljava/lang/String;", "setNegativeText", "(Ljava/lang/String;)V", "getNegativeTextRes", "()Ljava/lang/Integer;", "setNegativeTextRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPositiveText", "setPositiveText", "getPositiveTextRes", "setPositiveTextRes", "getSubTitle", "setSubTitle", "getSubTitleRes", "setSubTitleRes", "getTitle", "setTitle", "getTitleRes", "setTitleRes", "context", "Landroid/content/Context;", "Companion", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCommonConfig */
/* compiled from: GlobalCashierDialogConfig.kt */
public final class GlobalCashierDialogCommonConfig extends GlobalCashierDialogBaseConfig {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Lazy<GlobalCashierDialogCommonConfig> f23611j = LazyKt.lazy(GlobalCashierDialogCommonConfig$Companion$EXIT_CONFORM$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final Lazy<GlobalCashierDialogCommonConfig> f23612k = LazyKt.lazy(GlobalCashierDialogCommonConfig$Companion$APP_UPGRADE$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final Lazy<GlobalCashierDialogCommonConfig> f23613l = LazyKt.lazy(GlobalCashierDialogCommonConfig$Companion$NET_ERROR$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static final Lazy<GlobalCashierDialogCommonConfig> f23614m = LazyKt.lazy(GlobalCashierDialogCommonConfig$Companion$PAYMENT_FAILED$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public static final Lazy<GlobalCashierDialogCommonConfig> f23615n = LazyKt.lazy(GlobalCashierDialogCommonConfig$Companion$CUSTOM_ERROR$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: o */
    public static final Lazy<GlobalCashierDialogCommonConfig> f23616o = LazyKt.lazy(GlobalCashierDialogCommonConfig$Companion$PASSWORD_GUIDE$2.INSTANCE);

    /* renamed from: a */
    private String f23617a;

    /* renamed from: b */
    private Integer f23618b;

    /* renamed from: c */
    private String f23619c;

    /* renamed from: d */
    private Integer f23620d;

    /* renamed from: e */
    private String f23621e;

    /* renamed from: f */
    private Integer f23622f;

    /* renamed from: g */
    private String f23623g;

    /* renamed from: h */
    private Integer f23624h;

    /* renamed from: i */
    private boolean f23625i;

    public GlobalCashierDialogCommonConfig() {
        this((String) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, false, 511, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final GlobalCashierDialogCommonConfig newIns(GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig) {
        return Companion.newIns(globalCashierDialogCommonConfig);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GlobalCashierDialogCommonConfig(java.lang.String r11, java.lang.Integer r12, java.lang.String r13, java.lang.Integer r14, java.lang.String r15, java.lang.Integer r16, java.lang.String r17, java.lang.Integer r18, boolean r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r2 = r18
        L_0x003d:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0043
            r0 = 0
            goto L_0x0045
        L_0x0043:
            r0 = r19
        L_0x0045:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r2
            r20 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCommonConfig.<init>(java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTitle() {
        return this.f23617a;
    }

    public final void setTitle(String str) {
        this.f23617a = str;
    }

    public final Integer getTitleRes() {
        return this.f23618b;
    }

    public final void setTitleRes(Integer num) {
        this.f23618b = num;
    }

    public final String getSubTitle() {
        return this.f23619c;
    }

    public final void setSubTitle(String str) {
        this.f23619c = str;
    }

    public final Integer getSubTitleRes() {
        return this.f23620d;
    }

    public final void setSubTitleRes(Integer num) {
        this.f23620d = num;
    }

    public final String getPositiveText() {
        return this.f23621e;
    }

    public final void setPositiveText(String str) {
        this.f23621e = str;
    }

    public final Integer getPositiveTextRes() {
        return this.f23622f;
    }

    public final void setPositiveTextRes(Integer num) {
        this.f23622f = num;
    }

    public final String getNegativeText() {
        return this.f23623g;
    }

    public final void setNegativeText(String str) {
        this.f23623g = str;
    }

    public final Integer getNegativeTextRes() {
        return this.f23624h;
    }

    public final void setNegativeTextRes(Integer num) {
        this.f23624h = num;
    }

    public final boolean isHorizontal() {
        return this.f23625i;
    }

    public final void setHorizontal(boolean z) {
        this.f23625i = z;
    }

    public GlobalCashierDialogCommonConfig(String str, Integer num, String str2, Integer num2, String str3, Integer num3, String str4, Integer num4, boolean z) {
        this.f23617a = str;
        this.f23618b = num;
        this.f23619c = str2;
        this.f23620d = num2;
        this.f23621e = str3;
        this.f23622f = num3;
        this.f23623g = str4;
        this.f23624h = num4;
        this.f23625i = z;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0018\u001a\u00020\u0004*\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0013\u0010\u0006R\u001b\u0010\u0015\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCommonConfig$Companion;", "", "()V", "APP_UPGRADE", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCommonConfig;", "getAPP_UPGRADE", "()Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCommonConfig;", "APP_UPGRADE$delegate", "Lkotlin/Lazy;", "CUSTOM_ERROR", "getCUSTOM_ERROR", "CUSTOM_ERROR$delegate", "EXIT_CONFORM", "getEXIT_CONFORM", "EXIT_CONFORM$delegate", "NET_ERROR", "getNET_ERROR", "NET_ERROR$delegate", "PASSWORD_GUIDE", "getPASSWORD_GUIDE", "PASSWORD_GUIDE$delegate", "PAYMENT_FAILED", "getPAYMENT_FAILED", "PAYMENT_FAILED$delegate", "newIns", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCommonConfig$Companion */
    /* compiled from: GlobalCashierDialogConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierDialogCommonConfig getEXIT_CONFORM() {
            return (GlobalCashierDialogCommonConfig) GlobalCashierDialogCommonConfig.f23611j.getValue();
        }

        public final GlobalCashierDialogCommonConfig getAPP_UPGRADE() {
            return (GlobalCashierDialogCommonConfig) GlobalCashierDialogCommonConfig.f23612k.getValue();
        }

        public final GlobalCashierDialogCommonConfig getNET_ERROR() {
            return (GlobalCashierDialogCommonConfig) GlobalCashierDialogCommonConfig.f23613l.getValue();
        }

        public final GlobalCashierDialogCommonConfig getPAYMENT_FAILED() {
            return (GlobalCashierDialogCommonConfig) GlobalCashierDialogCommonConfig.f23614m.getValue();
        }

        public final GlobalCashierDialogCommonConfig getCUSTOM_ERROR() {
            return (GlobalCashierDialogCommonConfig) GlobalCashierDialogCommonConfig.f23615n.getValue();
        }

        public final GlobalCashierDialogCommonConfig getPASSWORD_GUIDE() {
            return (GlobalCashierDialogCommonConfig) GlobalCashierDialogCommonConfig.f23616o.getValue();
        }

        @JvmStatic
        public final GlobalCashierDialogCommonConfig newIns(GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig) {
            Intrinsics.checkNotNullParameter(globalCashierDialogCommonConfig, "<this>");
            return new GlobalCashierDialogCommonConfig(globalCashierDialogCommonConfig.getTitle(), globalCashierDialogCommonConfig.getTitleRes(), globalCashierDialogCommonConfig.getSubTitle(), globalCashierDialogCommonConfig.getSubTitleRes(), globalCashierDialogCommonConfig.getPositiveText(), globalCashierDialogCommonConfig.getPositiveTextRes(), globalCashierDialogCommonConfig.getNegativeText(), globalCashierDialogCommonConfig.getNegativeTextRes(), globalCashierDialogCommonConfig.isHorizontal());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if ((r0.length() > 0) == true) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String title(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r3.f23617a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            r1 = 0
            goto L_0x001a
        L_0x000d:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 != r1) goto L_0x000b
        L_0x001a:
            if (r1 == 0) goto L_0x0022
            java.lang.String r4 = r3.f23617a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            goto L_0x003f
        L_0x0022:
            java.lang.Integer r0 = r3.f23618b
            if (r0 == 0) goto L_0x003d
            android.content.res.Resources r4 = r4.getResources()
            java.lang.Integer r0 = r3.f23618b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.intValue()
            java.lang.String r4 = r4.getString(r0)
            java.lang.String r0 = "context.resources.getString(titleRes!!)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            goto L_0x003f
        L_0x003d:
            java.lang.String r4 = ""
        L_0x003f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCommonConfig.title(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if ((r0.length() > 0) == true) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String subTitle(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r3.f23619c
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            r1 = 0
            goto L_0x001a
        L_0x000d:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 != r1) goto L_0x000b
        L_0x001a:
            if (r1 == 0) goto L_0x0022
            java.lang.String r4 = r3.f23619c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            goto L_0x003f
        L_0x0022:
            java.lang.Integer r0 = r3.f23620d
            if (r0 == 0) goto L_0x003d
            android.content.res.Resources r4 = r4.getResources()
            java.lang.Integer r0 = r3.f23620d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.intValue()
            java.lang.String r4 = r4.getString(r0)
            java.lang.String r0 = "context.resources.getString(subTitleRes!!)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            goto L_0x003f
        L_0x003d:
            java.lang.String r4 = ""
        L_0x003f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCommonConfig.subTitle(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if ((r0.length() > 0) == true) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String positiveText(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r3.f23621e
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            r1 = 0
            goto L_0x001a
        L_0x000d:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 != r1) goto L_0x000b
        L_0x001a:
            if (r1 == 0) goto L_0x0022
            java.lang.String r4 = r3.f23621e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            goto L_0x003f
        L_0x0022:
            java.lang.Integer r0 = r3.f23622f
            if (r0 == 0) goto L_0x003d
            android.content.res.Resources r4 = r4.getResources()
            java.lang.Integer r0 = r3.f23622f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.intValue()
            java.lang.String r4 = r4.getString(r0)
            java.lang.String r0 = "context.resources.getString(positiveTextRes!!)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            goto L_0x003f
        L_0x003d:
            java.lang.String r4 = ""
        L_0x003f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCommonConfig.positiveText(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if ((r0.length() > 0) == true) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String negativeText(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r3.f23623g
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            r1 = 0
            goto L_0x001a
        L_0x000d:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 != r1) goto L_0x000b
        L_0x001a:
            if (r1 == 0) goto L_0x0022
            java.lang.String r4 = r3.f23623g
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            goto L_0x003f
        L_0x0022:
            java.lang.Integer r0 = r3.f23624h
            if (r0 == 0) goto L_0x003d
            android.content.res.Resources r4 = r4.getResources()
            java.lang.Integer r0 = r3.f23624h
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.intValue()
            java.lang.String r4 = r4.getString(r0)
            java.lang.String r0 = "context.resources.getString(negativeTextRes!!)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            goto L_0x003f
        L_0x003d:
            java.lang.String r4 = ""
        L_0x003f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCommonConfig.negativeText(android.content.Context):java.lang.String");
    }
}
