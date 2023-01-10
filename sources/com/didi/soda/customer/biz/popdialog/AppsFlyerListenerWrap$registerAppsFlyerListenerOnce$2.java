package com.didi.soda.customer.biz.popdialog;

import com.appsflyer.AppsFlyerConversionListener;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\n\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005H\u0016¨\u0006\f"}, mo148868d2 = {"com/didi/soda/customer/biz/popdialog/AppsFlyerListenerWrap$registerAppsFlyerListenerOnce$2", "Lcom/appsflyer/AppsFlyerConversionListener;", "onAppOpenAttribution", "", "map", "", "", "onAttributionFailure", "e", "onConversionDataFail", "onConversionDataSuccess", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AppsFlyerHelper.kt */
public final class AppsFlyerListenerWrap$registerAppsFlyerListenerOnce$2 implements AppsFlyerConversionListener {
    final /* synthetic */ AppsFlyerListenerWrap this$0;

    public void onAttributionFailure(String str) {
    }

    AppsFlyerListenerWrap$registerAppsFlyerListenerOnce$2(AppsFlyerListenerWrap appsFlyerListenerWrap) {
        this.this$0 = appsFlyerListenerWrap;
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        UiHandlerUtil.post(new Runnable(map) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                AppsFlyerListenerWrap$registerAppsFlyerListenerOnce$2.m47342onAppOpenAttribution$lambda1(AppsFlyerListenerWrap.this, this.f$1);
            }
        });
        C14432a access$getMethodCount$p = this.this$0.f43053b;
        if (access$getMethodCount$p != null) {
            C14432a.m32198a(access$getMethodCount$p, false, 1, (Object) null);
        }
        LogUtil.m32588i("AppsFlyerListener", "onAppOpenAttribution");
    }

    /* access modifiers changed from: private */
    /* renamed from: onAppOpenAttribution$lambda-1  reason: not valid java name */
    public static final void m47342onAppOpenAttribution$lambda1(AppsFlyerListenerWrap appsFlyerListenerWrap, Map map) {
        Intrinsics.checkNotNullParameter(appsFlyerListenerWrap, "this$0");
        appsFlyerListenerWrap.m32167a((Map<String, String>) map);
        for (AppsFlyerConversionListener onAppOpenAttribution : appsFlyerListenerWrap.f43052a) {
            try {
                onAppOpenAttribution.onAppOpenAttribution(map);
            } catch (Exception e) {
                e.printStackTrace();
                ErrorTracker.Builder addErrorType = ErrorTracker.create(ErrorConst.ErrorName.SALING_C_HOME_AF_ERROR).addModuleName("home").addErrorType("onAppOpenAttribution err");
                String message = e.getMessage();
                if (message == null) {
                    message = "no msg";
                }
                addErrorType.addErrorMsg(message).build().trackError();
            }
        }
    }

    public void onConversionDataSuccess(Map<String, Object> map) {
        UiHandlerUtil.post(new Runnable(map) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                AppsFlyerListenerWrap$registerAppsFlyerListenerOnce$2.m47343onConversionDataSuccess$lambda3(AppsFlyerListenerWrap.this, this.f$1);
            }
        });
        if (this.this$0.f43053b == null) {
            this.this$0.m32166a();
        } else {
            C14432a access$getMethodCount$p = this.this$0.f43053b;
            if (access$getMethodCount$p != null) {
                access$getMethodCount$p.mo108492a(true);
            }
        }
        LogUtil.m32588i("AppsFlyerListener", "onConversionDataSuccess");
    }

    /* access modifiers changed from: private */
    /* renamed from: onConversionDataSuccess$lambda-3  reason: not valid java name */
    public static final void m47343onConversionDataSuccess$lambda3(AppsFlyerListenerWrap appsFlyerListenerWrap, Map map) {
        Intrinsics.checkNotNullParameter(appsFlyerListenerWrap, "this$0");
        for (AppsFlyerConversionListener onConversionDataSuccess : appsFlyerListenerWrap.f43052a) {
            try {
                onConversionDataSuccess.onConversionDataSuccess(map);
            } catch (Exception e) {
                e.printStackTrace();
                ErrorTracker.Builder addErrorType = ErrorTracker.create(ErrorConst.ErrorName.SALING_C_HOME_AF_ERROR).addModuleName("home").addErrorType("onConversionDataSuccess err");
                String message = e.getMessage();
                if (message == null) {
                    message = "no msg";
                }
                addErrorType.addErrorMsg(message).build().trackError();
            }
        }
    }

    public void onConversionDataFail(String str) {
        LogUtil.m32588i("AppsFlyerListener", "onConversionDataFail");
        this.this$0.m32166a();
    }
}
