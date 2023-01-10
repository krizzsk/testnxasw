package com.didi.global.fintech.cashier.p118ui.omega;

import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.global.fintech.cashier.user.p119ut.CashierOmegaSDK;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001J\u001c\u0010\n\u001a\u00020\u00002\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/omega/CashierOmegaUtils;", "", "eventId", "", "(Ljava/lang/String;)V", "params", "", "addParam", "key", "value", "addParamAll", "map", "", "send", "", "setCommonAttr", "Companion", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils */
/* compiled from: CashierOmegaUtils.kt */
public final class CashierOmegaUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static String f23660c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static String f23661d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static String f23662e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static String f23663f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static String f23664g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static String f23665h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static String f23666i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static String f23667j;

    /* renamed from: a */
    private final String f23668a;

    /* renamed from: b */
    private final Map<String, Object> f23669b;

    public CashierOmegaUtils(String str) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        this.f23668a = str;
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        this.f23669b = linkedHashMap;
        m19245a(linkedHashMap);
    }

    /* renamed from: a */
    private final void m19245a(Map<String, Object> map) {
        map.put("product_id", f23660c);
        map.put("appid", f23661d);
        map.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        map.put(LogBase.KEY_UID, f23662e);
        map.put("pub_page", f23666i);
        map.put("pub_from_page", CashierOmegaSDK.INSTANCE.getPubFromPage());
        map.put("order_id", f23663f);
        map.put("out_trade_id", f23664g);
        String str = f23665h;
        if (str != null) {
            map.put("sequence_id", str);
        }
        map.put("pub_subbiz", "payment");
    }

    public final void send() {
        OmegaSDKAdapter.trackEvent(this.f23668a, this.f23669b);
    }

    public final CashierOmegaUtils addParam(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.f23669b.put(str, obj);
        return this;
    }

    public final CashierOmegaUtils addParamAll(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.f23669b.putAll(map);
        return this;
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR(\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b¨\u0006\""}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/omega/CashierOmegaUtils$Companion;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "oid", "getOid", "setOid", "outTradeId", "getOutTradeId", "setOutTradeId", "value", "productId", "getProductId", "setProductId", "pubFromPage", "getPubFromPage", "setPubFromPage", "pubPage", "getPubPage", "setPubPage", "sequenceId", "getSequenceId", "setSequenceId", "uid", "getUid", "setUid", "trackEvent", "", "eventId", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils$Companion */
    /* compiled from: CashierOmegaUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getProductId() {
            return CashierOmegaUtils.f23660c;
        }

        public final void setProductId(String str) {
            CharSequence charSequence = str;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                str = "-1";
            }
            CashierOmegaUtils.f23660c = str;
        }

        public final String getAppId() {
            return CashierOmegaUtils.f23661d;
        }

        public final void setAppId(String str) {
            CashierOmegaUtils.f23661d = str;
        }

        public final String getUid() {
            return CashierOmegaUtils.f23662e;
        }

        public final void setUid(String str) {
            CashierOmegaUtils.f23662e = str;
        }

        public final String getOid() {
            return CashierOmegaUtils.f23663f;
        }

        public final void setOid(String str) {
            CashierOmegaUtils.f23663f = str;
        }

        public final String getOutTradeId() {
            return CashierOmegaUtils.f23664g;
        }

        public final void setOutTradeId(String str) {
            CashierOmegaUtils.f23664g = str;
        }

        public final String getSequenceId() {
            return CashierOmegaUtils.f23665h;
        }

        public final void setSequenceId(String str) {
            CashierOmegaUtils.f23665h = str;
        }

        public final String getPubPage() {
            return CashierOmegaUtils.f23666i;
        }

        public final void setPubPage(String str) {
            CharSequence charSequence = str;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                str = PubPageType.CHECKOUT.getType();
            }
            CashierOmegaUtils.f23666i = str;
        }

        public final String getPubFromPage() {
            return CashierOmegaUtils.f23667j;
        }

        public final void setPubFromPage(String str) {
            CashierOmegaUtils.f23667j = str;
        }

        public final void trackEvent(String str) {
            Intrinsics.checkNotNullParameter(str, "eventId");
            new CashierOmegaUtils(str).send();
        }
    }
}
