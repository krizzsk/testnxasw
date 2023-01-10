package com.didi.soda.customer.p165h5.hybird.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006\u001e"}, mo148868d2 = {"Lcom/didi/soda/customer/h5/hybird/request/WebRequestModel;", "", "()V", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "header", "getHeader", "setHeader", "method", "", "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", "timeout", "", "getTimeout", "()J", "setTimeout", "(J)V", "url", "getUrl", "setUrl", "checkSelf", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.customer.h5.hybird.request.WebRequestModel */
/* compiled from: WebRequest.kt */
final class WebRequestModel {

    /* renamed from: a */
    public static final Companion f43921a = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private String f43922b;

    /* renamed from: c */
    private String f43923c;

    /* renamed from: d */
    private JSONObject f43924d;

    /* renamed from: e */
    private JSONObject f43925e;

    /* renamed from: f */
    private long f43926f = 30000;

    /* renamed from: a */
    public final String mo111597a() {
        return this.f43922b;
    }

    /* renamed from: a */
    public final void mo111599a(String str) {
        this.f43922b = str;
    }

    /* renamed from: b */
    public final String mo111601b() {
        return this.f43923c;
    }

    /* renamed from: b */
    public final void mo111602b(String str) {
        this.f43923c = str;
    }

    /* renamed from: a */
    public final void mo111600a(JSONObject jSONObject) {
        this.f43924d = jSONObject;
    }

    /* renamed from: c */
    public final JSONObject mo111604c() {
        return this.f43924d;
    }

    /* renamed from: b */
    public final void mo111603b(JSONObject jSONObject) {
        this.f43925e = jSONObject;
    }

    /* renamed from: d */
    public final JSONObject mo111605d() {
        return this.f43925e;
    }

    /* renamed from: a */
    public final void mo111598a(long j) {
        this.f43926f = j;
    }

    /* renamed from: e */
    public final long mo111606e() {
        return this.f43926f;
    }

    /* renamed from: f */
    public final boolean mo111607f() {
        CharSequence charSequence = this.f43922b;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.f43923c, (Object) "post");
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/customer/h5/hybird/request/WebRequestModel$Companion;", "", "()V", "create", "Lcom/didi/soda/customer/h5/hybird/request/WebRequestModel;", "params", "Lorg/json/JSONObject;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.soda.customer.h5.hybird.request.WebRequestModel$Companion */
    /* compiled from: WebRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WebRequestModel create(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "params");
            WebRequestModel webRequestModel = new WebRequestModel();
            webRequestModel.mo111599a(jSONObject.optString("url"));
            webRequestModel.mo111602b(jSONObject.optString("method"));
            webRequestModel.mo111600a(jSONObject.optJSONObject("data"));
            webRequestModel.mo111603b(jSONObject.optJSONObject("header"));
            webRequestModel.mo111598a(jSONObject.optLong("timeout"));
            if (webRequestModel.mo111606e() == 0) {
                webRequestModel.mo111598a(10000);
            }
            return webRequestModel;
        }
    }
}
