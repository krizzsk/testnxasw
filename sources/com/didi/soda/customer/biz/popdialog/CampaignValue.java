package com.didi.soda.customer.biz.popdialog;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR:\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, mo148868d2 = {"Lcom/didi/soda/customer/biz/popdialog/CampaignValue;", "", "()V", "business", "", "getBusiness", "()Ljava/lang/String;", "setBusiness", "(Ljava/lang/String;)V", "landPage", "getLandPage", "setLandPage", "originCampaign", "getOriginCampaign", "setOriginCampaign", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "addParams", "", "key", "value", "buildH5Url", "buildSchemeForTrack", "checkValid", "", "isH5Page", "isNativePage", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AppsFlyersLauncher.kt */
final class CampaignValue {

    /* renamed from: a */
    public static final Companion f43059a = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    public static final String f43060b = "n";

    /* renamed from: c */
    public static final String f43061c = "ha";

    /* renamed from: d */
    public static final String f43062d = "hc";

    /* renamed from: e */
    private String f43063e = "";

    /* renamed from: f */
    private String f43064f = "";

    /* renamed from: g */
    private HashMap<String, String> f43065g;

    /* renamed from: h */
    private String f43066h = "";

    /* renamed from: a */
    public final String mo108470a() {
        return this.f43063e;
    }

    /* renamed from: a */
    public final void mo108471a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f43063e = str;
    }

    /* renamed from: b */
    public final String mo108474b() {
        return this.f43064f;
    }

    /* renamed from: b */
    public final void mo108475b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f43064f = str;
    }

    /* renamed from: a */
    public final void mo108473a(HashMap<String, String> hashMap) {
        this.f43065g = hashMap;
    }

    /* renamed from: c */
    public final HashMap<String, String> mo108476c() {
        return this.f43065g;
    }

    /* renamed from: c */
    public final void mo108477c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f43066h = str;
    }

    /* renamed from: d */
    public final String mo108478d() {
        return this.f43066h;
    }

    /* renamed from: e */
    public final boolean mo108479e() {
        return TextUtils.equals(this.f43063e, f43060b);
    }

    /* renamed from: f */
    public final boolean mo108480f() {
        return TextUtils.equals(this.f43063e, f43061c) || TextUtils.equals(this.f43063e, f43062d);
    }

    /* renamed from: g */
    public final String mo108481g() {
        String stringPlus = Intrinsics.stringPlus("bsodacustomer://soda/", this.f43064f);
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> hashMap = this.f43065g;
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                sb.append(Typography.amp);
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append((String) entry.getValue());
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "querySb.toString()");
        if (!(sb2.length() > 0)) {
            return stringPlus;
        }
        String replaceFirst$default = StringsKt.replaceFirst$default(sb2, ParamKeys.SIGN_AND, "", false, 4, (Object) null);
        return stringPlus + '?' + replaceFirst$default;
    }

    /* renamed from: h */
    public final String mo108482h() {
        String str;
        String str2 = this.f43063e;
        if (Intrinsics.areEqual((Object) str2, (Object) f43061c)) {
            str = "https://food-act.99app.com/${locale}/";
        } else if (Intrinsics.areEqual((Object) str2, (Object) f43062d)) {
            str = "https://food-c-h5.99app.com/${locale}/";
        } else {
            str = null;
        }
        String str3 = (String) AppsFlyersLauncherKt.f43058e.get(this.f43064f);
        if (str3 == null) {
            str3 = this.f43064f;
        }
        if (str != null) {
            return Intrinsics.stringPlus(str, str3);
        }
        return null;
    }

    /* renamed from: a */
    public final void mo108472a(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        if (this.f43065g == null) {
            this.f43065g = new HashMap<>();
        }
        HashMap<String, String> hashMap = this.f43065g;
        if (hashMap != null) {
            String put = hashMap.put(str, str2);
        }
    }

    /* renamed from: i */
    public final boolean mo108483i() {
        if (this.f43063e.length() > 0) {
            if (this.f43064f.length() > 0) {
                return true;
            }
        }
        return false;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/customer/biz/popdialog/CampaignValue$Companion;", "", "()V", "haPageFlag", "", "hcPageFlag", "nativePageFlag", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: AppsFlyersLauncher.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
