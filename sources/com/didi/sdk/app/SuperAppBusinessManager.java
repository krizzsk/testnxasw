package com.didi.sdk.app;

import android.text.TextUtils;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u001f\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u000eJ\u0006\u0010$\u001a\u00020\u001dJ\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u000eJ\b\u0010'\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, mo148868d2 = {"Lcom/didi/sdk/app/SuperAppBusinessManager;", "", "()V", "COMMON_H5_SCHEME", "", "getCOMMON_H5_SCHEME", "()Ljava/lang/String;", "setCOMMON_H5_SCHEME", "(Ljava/lang/String;)V", "KEY_SA_SELECT_TYPE", "SA_GROUP_ID", "", "SA_GROUP_TYPE", "activityResume", "", "commonBusinessContext", "Lcom/didi/sdk/app/BusinessContext;", "currentBusiness", "lastBusiness", "saRealShow", "saTabShow", "getCommonBusinessContext", "getCurrentBusiness", "getLastBusiness", "getSaTabShow", "isActivityResume", "isCurrentSa", "isSaRealShow", "setBusinessContext", "", "businessContext", "setCommonBusinessContext", "setCurrentBusiness", "businessType", "setSaTabShow", "show", "update", "updateActivityResume", "resume", "updateBusinessContext", "updateOther", "updateSaShow", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SuperAppBusinessManager.kt */
public final class SuperAppBusinessManager {
    public static final SuperAppBusinessManager INSTANCE = new SuperAppBusinessManager();
    public static final String KEY_SA_SELECT_TYPE = "sa_select_group_type";
    public static final int SA_GROUP_ID = 30008;
    public static final String SA_GROUP_TYPE = "sa_home";

    /* renamed from: a */
    private static BusinessContext f37979a;

    /* renamed from: b */
    private static String f37980b = Intrinsics.stringPlus(NationTypeUtil.getNationComponentData().getProductPreFix(), "OneTravel://one/sa_web");

    /* renamed from: c */
    private static String f37981c = "sa_home";

    /* renamed from: d */
    private static String f37982d = "sa_home";

    /* renamed from: e */
    private static boolean f37983e;

    /* renamed from: f */
    private static boolean f37984f;

    /* renamed from: g */
    private static boolean f37985g;

    private SuperAppBusinessManager() {
    }

    public final String getCOMMON_H5_SCHEME() {
        return f37980b;
    }

    public final void setCOMMON_H5_SCHEME(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f37980b = str;
    }

    public final void setBusinessContext(BusinessContext businessContext) {
        BusinessContextManager.getInstance().mo97016a((BaseBusinessContext) businessContext);
    }

    public final BusinessContext getCommonBusinessContext() {
        return f37979a;
    }

    public final void setCommonBusinessContext(BusinessContext businessContext) {
        f37979a = businessContext;
    }

    public final void setCurrentBusiness(String str) {
        Intrinsics.checkNotNullParameter(str, ParamKeys.PARAM_FLIER_BUSINESSTYPE);
        f37982d = f37981c;
        f37981c = str;
        ConfProxy.getInstance().setSelectedType(str);
    }

    /* renamed from: a */
    private final void m28655a() {
        BusinessContext businessContext = f37979a;
        if (businessContext != null) {
            businessContext.setCountryInfo(ConfProxy.getInstance().getCountryInfo());
        }
        BaseBusinessContext curBusinessContext = BusinessContextManager.getInstance().getCurBusinessContext();
        if (curBusinessContext instanceof BusinessContext) {
            ((BusinessContext) curBusinessContext).setCountryInfo(ConfProxy.getInstance().getCountryInfo());
        }
    }

    /* renamed from: b */
    private final void m28656b() {
        SafeToolKit.getIns().setProductId(ConfProxy.getInstance().getSelectedGroupId());
        SafeToolKit.getIns().setBusinessType(ConfProxy.getInstance().getSelectedType());
        if (Intrinsics.areEqual((Object) "bus", (Object) getCurrentBusiness())) {
            SafeToolKit.getIns().setBusinessType("ride");
        }
    }

    public final void update() {
        m28655a();
        m28656b();
    }

    public final void updateActivityResume(boolean z) {
        f37983e = z;
    }

    public final void updateSaShow(boolean z) {
        f37984f = z;
    }

    public final boolean isCurrentSa() {
        return TextUtils.equals("sa_home", f37981c) && SaApolloUtil.INSTANCE.getSaState();
    }

    public final boolean isSaRealShow() {
        return isCurrentSa() && f37984f;
    }

    public final boolean isActivityResume() {
        return f37983e;
    }

    public final String getCurrentBusiness() {
        return f37981c;
    }

    public final String getLastBusiness() {
        return f37982d;
    }

    public final void setSaTabShow(boolean z) {
        f37985g = z;
    }

    public final boolean getSaTabShow() {
        return f37985g;
    }
}
