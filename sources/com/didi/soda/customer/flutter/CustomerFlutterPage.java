package com.didi.soda.customer.flutter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.HorizontalChangeHandler;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.flutter.nacho2.p116v2.NachoAction;
import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.pages.CustomerPageDelegate;
import com.didi.soda.customer.base.pages.PageBackHelper;
import com.didi.soda.customer.base.pages.changehandler.CustomerVerticalChangeHandler;
import com.didi.soda.customer.flutter.performance.FlutterPerformanceTracker;
import com.didi.soda.customer.flutter.plugin.PaymentPlugin;
import com.didi.soda.customer.flutter.plugin.listener.OnCallPluginListener;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.util.CustomerStatusBarHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.soda.router.annotations.Route;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p218io.flutter.embedding.android.BaseNachoSkeletonPage;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.embedding.engine.plugins.PluginRegistry;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u001bH\u0016J\b\u0010-\u001a\u00020\u001bH\u0016J\b\u0010.\u001a\u00020\bH\u0016J\b\u0010/\u001a\u00020\u001bH\u0016J\b\u00100\u001a\u00020\u001bH\u0016J\b\u00101\u001a\u00020\u001bH\u0016J\b\u00102\u001a\u00020\u001bH\u0016J\u0016\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010504H\u0002J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u001bH\u0002J\b\u00109\u001a\u00020\u001bH\u0002J\b\u0010:\u001a\u00020\u001bH\u0002J\b\u0010;\u001a\u00020\u001bH\u0002J\b\u0010<\u001a\u00020\u001bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048CX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, mo148868d2 = {"Lcom/didi/soda/customer/flutter/CustomerFlutterPage;", "Lio/flutter/embedding/android/BaseNachoSkeletonPage;", "()V", "changeHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "getChangeHandler", "()Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "isPageDestroyed", "", "mAppSoftInputMode", "", "mCustomerPageDelegate", "Lcom/didi/soda/customer/base/pages/CustomerPageDelegate;", "mLogger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "mPaymentPlugin", "Lcom/didi/soda/customer/flutter/plugin/PaymentPlugin;", "mPerformanceTracker", "Lcom/didi/soda/customer/flutter/performance/FlutterPerformanceTracker$TrackerInternal;", "mResultRepo", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "paymentPluginListener", "Lcom/didi/soda/customer/flutter/plugin/listener/OnCallPluginListener;", "alias", "", "configureFlutterEngine", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "finish", "data", "Landroid/os/Bundle;", "getContext", "Landroid/content/Context;", "getInitialRoute", "getPopHandler", "getPushHandler", "handlePaymentPlugin", "registry", "Lio/flutter/embedding/engine/plugins/PluginRegistry;", "onCreate", "view", "Landroid/view/View;", "onDestroy", "onFinalize", "onHandleBack", "onInitialize", "onResume", "onStart", "onStop", "parseInitRouteParams", "", "", "provideNachoAction", "Lcom/didi/flutter/nacho2/v2/NachoAction;", "releasePaymentResultRepo", "restoreSoftInputAdjustResize", "saveSoftInputAdjustResize", "setSoftInputAdjustResize", "updateLocale", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@Route({"flutterCommonPage"})
/* compiled from: CustomerFlutterPage.kt */
public class CustomerFlutterPage extends BaseNachoSkeletonPage {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Subscription f43479a;

    /* renamed from: b */
    private final CustomerPageDelegate f43480b;

    /* renamed from: c */
    private final FlutterPerformanceTracker.TrackerInternal f43481c;

    /* renamed from: d */
    private final Logger f43482d = LogService.getLogger("CustomerFlutterPage");

    /* renamed from: e */
    private int f43483e = 48;

    /* renamed from: f */
    private PaymentPlugin f43484f;

    /* renamed from: g */
    private boolean f43485g;

    /* renamed from: h */
    private OnCallPluginListener f43486h = new CustomerFlutterPage$paymentPluginListener$1(this);

    public String getInitialRoute() {
        return "/";
    }

    public CustomerFlutterPage() {
        Logger logger = this.f43482d;
        logger.debug(this + "CustomerFlutterPage()", new Object[0]);
        this.f43480b = new CustomerPageDelegate(this, true);
        FlutterPerformanceTracker.TrackerInternal type = new FlutterPerformanceTracker.TrackerInternal().refreshStart().type("flutter");
        Intrinsics.checkNotNullExpressionValue(type, "TrackerInternal()\n      …anceTracker.TYPE_FLUTTER)");
        this.f43481c = type;
    }

    /* renamed from: a */
    private final ControllerChangeHandler m32534a() {
        AnimatorChangeHandler animatorChangeHandler;
        Bundle args = getArgs();
        if (args == null) {
            return new HorizontalChangeHandler();
        }
        String string = args.getString("changehandler", "");
        Intrinsics.checkNotNullExpressionValue(string, "changeHandler");
        if (string.length() == 0) {
            return new HorizontalChangeHandler();
        }
        if (Intrinsics.areEqual((Object) string, (Object) "CustomerVerticalChangeHandler")) {
            animatorChangeHandler = new CustomerVerticalChangeHandler(args.getBoolean("removesFromViewOnPush", true));
        } else {
            animatorChangeHandler = new HorizontalChangeHandler();
        }
        return animatorChangeHandler;
    }

    public void onInitialize() {
        super.onInitialize();
        this.f43480b.onInitialize(this);
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Bundle args = getArgs();
        ScopeContext scopeContext = getScopeContext();
        if (scopeContext != null) {
            scopeContext.attach("PageName", alias());
        }
        if (args != null) {
            this.f43481c.flutterPageToEvent(args.getString("path"));
            this.f43481c.recordContainerOnCreate();
            this.f43481c.turnIntoFlutter(args);
            args.putString("brand", GlobalContext.isBrazil() ? "99" : "global");
        }
        if (GlobalContext.isEmbed()) {
            m32537c();
            m32538d();
        }
        this.f43480b.onCreate();
        super.onCreate(view);
    }

    public void onStart() {
        super.onStart();
        this.f43480b.onStart((View) null, 0);
    }

    public void onResume() {
        super.onResume();
        this.f43480b.onResume();
        this.mRootView.requestFocus();
    }

    public void onStop() {
        super.onStop();
        this.f43480b.onStop();
    }

    public void finish() {
        if (!PageBackHelper.Companion.popBackStack(this, false)) {
            super.finish();
        }
    }

    public void finish(Bundle bundle) {
        if (!PageBackHelper.Companion.popBackStack(this, false)) {
            super.finish(bundle);
        }
    }

    public void updateLocale() {
        super.updateLocale();
        ArrayList arrayList = new ArrayList(1);
        for (int i = 0; i < 1; i++) {
            Locale lang = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLang();
            if (lang == null) {
                lang = new Locale("en-US");
            }
            arrayList.add(lang);
        }
        provideNachoAction().getEngine().getLocalizationChannel().sendLocales(arrayList);
    }

    public boolean onHandleBack() {
        RecordTracker.Builder.create().setTag(alias()).setMessage("onHandleBack").setOtherParam("PageName:", alias()).build().info();
        OmegaTracker.Builder.create("sailing_c_x_page_return_ck").addEventParam("from", alias()).build().track();
        return super.onHandleBack();
    }

    public void onDestroy() {
        super.onDestroy();
        if (getActivity() != null) {
            CustomerStatusBarHelper.getHelper().resetState();
            CustomerStatusBarHelper.getHelper().setStatusBarBgLightning(getActivity(), false);
        }
        if (GlobalContext.isEmbed()) {
            m32539e();
        }
        PaymentPlugin paymentPlugin = this.f43484f;
        if (paymentPlugin != null) {
            paymentPlugin.removeCallPluginListener(this.f43486h);
        }
        this.f43484f = null;
        m32540f();
        this.f43485g = true;
    }

    public void onFinalize() {
        if (!this.f43485g) {
            onDestroy();
        }
        super.onFinalize();
    }

    public String alias() {
        if (getScopeContext() != null) {
            ScopeContext scopeContext = getScopeContext();
            Intrinsics.checkNotNull(scopeContext);
            if (scopeContext.getBundle().getString("path") != null) {
                ScopeContext scopeContext2 = getScopeContext();
                Intrinsics.checkNotNull(scopeContext2);
                String string = scopeContext2.getBundle().getString("path");
                Intrinsics.checkNotNull(string);
                Intrinsics.checkNotNullExpressionValue(string, "scopeContext!!.bundle.ge…ommons.BUNDLE_KEY_PATH)!!");
                return string;
            }
        }
        String alias = super.alias();
        Intrinsics.checkNotNullExpressionValue(alias, "super.alias()");
        return alias;
    }

    public NachoAction provideNachoAction() {
        NachoAction bizFoodEngineAction = CustomerFlutterEngineManager.getInstance().getBizFoodEngineAction();
        Intrinsics.checkNotNullExpressionValue(bizFoodEngineAction, "getInstance().bizFoodEngineAction");
        return bizFoodEngineAction;
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.configureFlutterEngine(flutterEngine);
        PluginRegistry plugins = flutterEngine.getPlugins();
        Intrinsics.checkNotNullExpressionValue(plugins, "flutterEngine.plugins");
        m32535a(plugins);
    }

    public Context getContext() {
        Context context = this.mRootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        return context;
    }

    public ControllerChangeHandler getPushHandler() {
        return m32534a();
    }

    public ControllerChangeHandler getPopHandler() {
        return m32534a();
    }

    /* renamed from: b */
    private final Map<String, Object> m32536b() {
        Logger logger = this.f43482d;
        logger.debug(this + "parseInitRouteParams()", new Object[0]);
        Bundle args = getArgs();
        Map<String, Object> hashMap = new HashMap<>();
        Bundle bundle = args.getBundle("params");
        if (bundle == null) {
            bundle = new Bundle();
        }
        hashMap.put("path", args.getString("path"));
        hashMap.put("params", transformBundleParameters(bundle));
        return hashMap;
    }

    /* renamed from: c */
    private final void m32537c() {
        try {
            Activity activity = getActivity();
            int i = 48;
            if (activity != null) {
                Window window = activity.getWindow();
                if (window != null) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    if (attributes != null) {
                        i = attributes.softInputMode;
                    }
                }
            }
            this.f43483e = i;
            Logger logger = this.f43482d;
            logger.debug(this + "mAppSoftInputMode = " + this.f43483e, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private final void m32538d() {
        Window window;
        Logger logger = this.f43482d;
        logger.debug(this + "setSoftInputAdjustResize", new Object[0]);
        Activity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(16);
        }
    }

    /* renamed from: e */
    private final void m32539e() {
        Window window;
        Activity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(this.f43483e);
        }
    }

    /* renamed from: a */
    private final void m32535a(PluginRegistry pluginRegistry) {
        FlutterPlugin flutterPlugin = pluginRegistry.get(PaymentPlugin.class);
        if (flutterPlugin instanceof PaymentPlugin) {
            PaymentPlugin paymentPlugin = (PaymentPlugin) flutterPlugin;
            this.f43484f = paymentPlugin;
            if (paymentPlugin != null) {
                paymentPlugin.addCallPluginListener(this.f43486h);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m32540f() {
        Subscription subscription = this.f43479a;
        if (subscription != null) {
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.f43479a = null;
        }
    }
}
