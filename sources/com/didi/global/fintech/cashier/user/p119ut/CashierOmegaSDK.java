package com.didi.global.fintech.cashier.user.p119ut;

import android.app.Activity;
import android.content.ComponentName;
import android.text.TextUtils;
import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0016\u001a\u00020\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ(\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00042\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0019J$\u0010!\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR(\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR(\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR(\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\""}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/user/ut/CashierOmegaSDK;", "", "()V", "value", "", "fromType", "getFromType", "()Ljava/lang/String;", "setFromType", "(Ljava/lang/String;)V", "orderId", "getOrderId", "setOrderId", "outTradeId", "getOutTradeId", "setOutTradeId", "productId", "getProductId", "setProductId", "pubFromPage", "getPubFromPage", "setPubFromPage", "addGlobalAttrs", "", "attrs", "", "initGlobalAttrsFromExternal", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "activity", "Landroid/app/Activity;", "trackEvent", "eventId", "updateGlobalAttrsFromApi", "cashier_user_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.user.ut.CashierOmegaSDK */
/* compiled from: CashierOmegaSDK.kt */
public final class CashierOmegaSDK {
    public static final CashierOmegaSDK INSTANCE = new CashierOmegaSDK();

    /* renamed from: a */
    private static String f23938a;

    /* renamed from: b */
    private static String f23939b;

    /* renamed from: c */
    private static String f23940c;

    /* renamed from: d */
    private static String f23941d;

    /* renamed from: e */
    private static String f23942e;

    private CashierOmegaSDK() {
    }

    public final String getPubFromPage() {
        return f23938a;
    }

    public final void setPubFromPage(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            str = "";
        }
        f23938a = str;
    }

    public final String getFromType() {
        return f23939b;
    }

    public final void setFromType(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            str = "";
        }
        f23939b = str;
    }

    public final String getOutTradeId() {
        return f23940c;
    }

    public final void setOutTradeId(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            str = "";
        }
        f23940c = str;
    }

    public final String getOrderId() {
        return f23941d;
    }

    public final void setOrderId(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            str = "";
        }
        f23941d = str;
    }

    public final String getProductId() {
        return f23942e;
    }

    public final void setProductId(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            str = "";
        }
        f23942e = str;
    }

    public final void initGlobalAttrsFromExternal(CashierParam cashierParam, Activity activity) {
        ComponentName componentName;
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        String str = null;
        if (!(activity == null || (componentName = activity.getComponentName()) == null)) {
            str = componentName.getClassName();
        }
        setPubFromPage(str);
        setOutTradeId(cashierParam.getOutTradeId());
        setFromType((String) cashierParam.getExtraParams().get(CashierParam.PARAM_FROM_TYPE));
    }

    public final void updateGlobalAttrsFromApi(String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        setProductId(str);
        if (str2 == null) {
            str2 = "";
        }
        setOrderId(str2);
        if (!TextUtils.isEmpty(str3)) {
            setOutTradeId(str3);
        }
    }

    public static /* synthetic */ void trackEvent$default(CashierOmegaSDK cashierOmegaSDK, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        cashierOmegaSDK.trackEvent(str, map);
    }

    public final void trackEvent(String str, Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        m19387a(map);
        OmegaSDKAdapter.trackEvent(str, map);
    }

    /* renamed from: a */
    private final void m19387a(Map<String, Object> map) {
        map.put("product_id", f23942e);
        map.put("order_id", f23941d);
        map.put("out_trade_id", f23940c);
        map.put(CashierParam.PARAM_FROM_TYPE, f23939b);
        map.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        map.put("pub_subbiz", "payment");
        String str = f23938a;
        if (str == null) {
            str = "";
        }
        map.put("pub_from_page", str);
        map.put(LogBase.KEY_UID, CashierFacade.Companion.getInstance().getInitConfig().getUid());
    }
}
