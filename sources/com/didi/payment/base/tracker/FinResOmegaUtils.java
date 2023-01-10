package com.didi.payment.base.tracker;

import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001J\u001c\u0010\n\u001a\u00020\u00002\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006J\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\r2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/payment/base/tracker/FinResOmegaUtils;", "", "eventId", "", "(Ljava/lang/String;)V", "params", "", "addParam", "key", "value", "addParamAll", "map", "send", "", "setCommonAttr", "Companion", "base_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FinResOmegaUtils.kt */
public final class FinResOmegaUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static String f32432c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static String f32433d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static String f32434e;

    /* renamed from: a */
    private final String f32435a;

    /* renamed from: b */
    private final Map<String, Object> f32436b;

    public FinResOmegaUtils(String str) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        this.f32435a = str;
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        this.f32436b = linkedHashMap;
        m24607a(linkedHashMap);
    }

    /* renamed from: a */
    private final void m24607a(Map<String, Object> map) {
        map.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        map.put(LogBase.KEY_UID, f32432c);
        map.put("pub_from_page", f32434e);
    }

    public final void send() {
        FinOmegaSDK.trackEvent(this.f32435a, this.f32436b);
    }

    public final FinResOmegaUtils addParam(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.f32436b.put(str, obj);
        return this;
    }

    public final FinResOmegaUtils addParamAll(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.f32436b.putAll(map);
        return this;
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/payment/base/tracker/FinResOmegaUtils$Companion;", "", "()V", "pubFromPage", "", "getPubFromPage", "()Ljava/lang/String;", "setPubFromPage", "(Ljava/lang/String;)V", "pubPage", "getPubPage", "setPubPage", "uid", "getUid", "setUid", "trackEvent", "", "eventId", "base_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: FinResOmegaUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getUid() {
            return FinResOmegaUtils.f32432c;
        }

        public final void setUid(String str) {
            FinResOmegaUtils.f32432c = str;
        }

        public final String getPubPage() {
            return FinResOmegaUtils.f32433d;
        }

        public final void setPubPage(String str) {
            FinResOmegaUtils.f32433d = str;
        }

        public final String getPubFromPage() {
            return FinResOmegaUtils.f32434e;
        }

        public final void setPubFromPage(String str) {
            FinResOmegaUtils.f32434e = str;
        }

        public final void trackEvent(String str) {
            Intrinsics.checkNotNullParameter(str, "eventId");
            new FinResOmegaUtils(str).send();
        }
    }
}
