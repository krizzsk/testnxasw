package com.didi.soda.customer.biz.popdialog;

import android.content.Context;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\b\u0010\u000b\u001a\u00020\tH\u0002J!\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\t2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/soda/customer/biz/popdialog/AppsFlyerListenerWrap;", "", "()V", "listeners", "", "Lcom/appsflyer/AppsFlyerConversionListener;", "methodCount", "Lcom/didi/soda/customer/biz/popdialog/AFMethodInvokeCount;", "addListener", "", "listener", "destroyAppsFlyer", "getLogTracker", "Lcom/didi/soda/customer/foundation/log/RecordTracker$Builder;", "message", "", "", "([Ljava/lang/String;)Lcom/didi/soda/customer/foundation/log/RecordTracker$Builder;", "registerAppsFlyerListenerOnce", "ctx", "Landroid/content/Context;", "trackAppOpen", "map", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AppsFlyerHelper.kt */
public final class AppsFlyerListenerWrap {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<AppsFlyerConversionListener> f43052a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C14432a f43053b;

    public final void addListener(AppsFlyerConversionListener appsFlyerConversionListener) {
        if (appsFlyerConversionListener != null) {
            this.f43052a.add(appsFlyerConversionListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32167a(Map<String, String> map) {
        String json;
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Conversion.ENTER_APP_ON_APP_OPEN);
        String str = "";
        if (!(map == null || (json = GsonUtil.toJson(map)) == null)) {
            str = json;
        }
        create.addEventParam("conversioninfo", str).build().track();
    }

    public final void registerAppsFlyerListenerOnce(Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        ApolloModel aFDestroySwitch = CustomerApolloUtil.getAFDestroySwitch();
        if (aFDestroySwitch.isOpen()) {
            LogUtil.m32588i("AppsFlyerListener", "registerAppsFlyerListenerOnce open");
            this.f43053b = new C14432a((long) aFDestroySwitch.getTimeout());
        }
        C14432a aVar = this.f43053b;
        if (aVar != null) {
            aVar.mo108491a((Function0<Unit>) new AppsFlyerListenerWrap$registerAppsFlyerListenerOnce$1(this));
        }
        m32165a("initAppsFlyer").build().info();
        AppsFlyerLib.getInstance().registerConversionListener(context, new AppsFlyerListenerWrap$registerAppsFlyerListenerOnce$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32166a() {
        m32165a("destroyAppsFlyer").build().info();
        AppsFlyerLib.getInstance().unregisterConversionListener();
    }

    /* renamed from: a */
    private final RecordTracker.Builder m32165a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        String arrays = Arrays.toString(strArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        RecordTracker.Builder logCategory = RecordTracker.Builder.create().setTag("AppsFlyerListener").setLogModule("m-home|").setMessage(sb.toString()).setLogCategory("c-data|");
        Intrinsics.checkNotNullExpressionValue(logCategory, "create()\n               …t.Category.CATEGORY_DATA)");
        return logCategory;
    }
}
