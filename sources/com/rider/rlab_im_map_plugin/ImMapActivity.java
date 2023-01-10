package com.rider.rlab_im_map_plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.PageInstrumentFactory;
import com.didi.app.nova.skeleton.SkeletonActivity;
import com.didi.app.nova.skeleton.conductor.ChangeHandlerFrameLayout;
import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.rider.rlab_im_map_plugin.bean.ImBusinessBean;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.gps.AppGpsDialog;
import com.rider.rlab_im_map_plugin.page.ImFlutterNachoPage;
import com.rider.rlab_im_map_plugin.page.ImMapPage;
import com.rider.rlab_im_map_plugin.page.ImNavPage;
import com.rider.rlab_im_map_plugin.tool.ImCallFrom;
import com.rider.rlab_im_map_plugin.tool.ImCommons;
import com.rider.rlab_im_map_plugin.tool.ImFavorFrom;
import com.rider.rlab_im_map_plugin.tool.ImMapUtils;
import com.rider.rlab_im_map_plugin.tool.ImScopeLifecycle;
import com.rider.rlab_im_map_plugin.tool.LocaleUtils;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.Locale;

public class ImMapActivity extends SkeletonActivity {

    /* renamed from: j */
    private static final String[] f58580j = {Permission.ACCESS_FINE_LOCATION};

    /* renamed from: a */
    private final Logger f58581a = LoggerFactory.getLogger("ImMapActivity");

    /* renamed from: b */
    private RelativeLayout f58582b;

    /* renamed from: c */
    private ChangeHandlerFrameLayout f58583c;

    /* renamed from: d */
    private ChangeHandlerFrameLayout f58584d;

    /* renamed from: e */
    private DialogFrameLayout f58585e;

    /* renamed from: f */
    private PageInstrument f58586f;

    /* renamed from: g */
    private PageInstrument f58587g;

    /* renamed from: h */
    private ImNavPage f58588h;

    /* renamed from: i */
    private ImBusinessBean f58589i;

    /* renamed from: k */
    private AppGpsDialog f58590k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ImMapPage f58591l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ImFlutterNachoPage f58592m;
    protected boolean mStateSaved;

    public static void show(Context context, ImBusinessBean imBusinessBean) {
        Intent intent = new Intent();
        intent.setClass(context, ImMapActivity.class);
        if (imBusinessBean != null) {
            intent.putExtra(ImCommons.BUNDLE_IM_DATA, imBusinessBean);
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        try {
            context = LocaleUtils.attachBaseContext(context, ImMapConfig.getInstance().getLocale());
        } catch (Exception e) {
            Logger logger = this.f58581a;
            logger.error("attachBaseContext set locale : " + e, new Object[0]);
        }
        super.attachBaseContext(context);
    }

    /* access modifiers changed from: protected */
    public void onAfterCreate(Bundle bundle) {
        Logger logger = this.f58581a;
        logger.debug("onAfterCreate " + this + " savedInstanceState: " + bundle, new Object[0]);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, 0);
        setContentView((int) R.layout.rider_im_map_page);
        m44354c();
        m44352b();
        m44350a(bundle);
        m44355d();
        mo175603a();
    }

    /* renamed from: b */
    private void m44352b() {
        Bundle extras = getIntent() == null ? null : getIntent().getExtras();
        if (extras != null) {
            this.f58589i = (ImBusinessBean) extras.getParcelable(ImCommons.BUNDLE_IM_DATA);
        }
    }

    public PageInstrument getPageInstrument() {
        return this.f58586f;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f58581a.info("onNewIntent", new Object[0]);
    }

    /* renamed from: c */
    private void m44354c() {
        this.f58582b = (RelativeLayout) findViewById(R.id.rider_root_layout);
        this.f58583c = (ChangeHandlerFrameLayout) findViewById(R.id.rider_map_container);
        this.f58584d = (ChangeHandlerFrameLayout) findViewById(R.id.rider_business_container);
        this.f58585e = (DialogFrameLayout) findViewById(R.id.rider_popup_container);
    }

    /* renamed from: a */
    private void m44350a(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("LifecycleHandler.routerState" + this.f58584d.getId());
        }
        Logger logger = this.f58581a;
        logger.info("installHomePage after remove savedInstanceState: " + bundle, new Object[0]);
        PageInstrument install = PageInstrumentFactory.install(this, this.f58584d, bundle);
        this.f58586f = install;
        install.registerPageLifecycleCallback(new ImScopeLifecycle() {
            public void onDestroy(ILive iLive) {
                super.onDestroy(iLive);
                if (ImMapActivity.this.f58592m != null) {
                    ImFlutterNachoPage unused = ImMapActivity.this.f58592m = null;
                }
            }
        });
    }

    /* renamed from: d */
    private void m44355d() {
        PageInstrument install = PageInstrumentFactory.install(this, this.f58583c, (Bundle) null);
        this.f58587g = install;
        install.attachDialogFrame(this.f58585e);
        this.f58587g.registerPageLifecycleCallback(new ImScopeLifecycle() {
            public void onDestroy(ILive iLive) {
                super.onDestroy(iLive);
                if (ImMapActivity.this.f58591l != null) {
                    ImMapPage unused = ImMapActivity.this.f58591l = null;
                }
            }
        });
        this.f58591l = new ImMapPage();
        Bundle bundle = new Bundle();
        ImBusinessBean imBusinessBean = this.f58589i;
        if (imBusinessBean != null) {
            int type = imBusinessBean.getType();
            double lat = this.f58589i.getLat();
            double lng = this.f58589i.getLng();
            bundle.putInt(ImCommons.BUNDLE_TYPE, type);
            bundle.putDouble("lat", lat);
            bundle.putDouble("lng", lng);
        }
        if (ImMapConfig.getInstance().getMockLatLng() != null) {
            bundle.putDouble("lat", this.f58589i.getLat());
            bundle.putDouble("lng", this.f58589i.getLng());
        }
        this.f58591l.setArgs(bundle);
        this.f58587g.setRootPage(this.f58591l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175603a() {
        this.f58592m = new ImFlutterNachoPage(this.f58583c);
        Bundle bundle = new Bundle();
        ImBusinessBean imBusinessBean = this.f58589i;
        if (imBusinessBean != null) {
            bundle.putInt(ImCommons.BUNDLE_TYPE, imBusinessBean.getType());
            bundle.putDouble("lat", this.f58589i.getLat());
            bundle.putDouble("lng", this.f58589i.getLng());
            bundle.putInt(ImCommons.BUNDLE_NAV_TYPE, this.f58589i.getNav());
            bundle.putString("address", this.f58589i.getAddressName());
            bundle.putString("displayname", this.f58589i.getSectionName());
            bundle.putSerializable(ImCommons.BUNDLE_MAP, this.f58589i.getMap());
            bundle.putString("orderId", this.f58589i.getOrderId());
            bundle.putString(ImCommons.BUNDLE_C_ORDER_ID, this.f58589i.getCOrderId());
        }
        if (ImMapConfig.getInstance().getMockLatLng() != null) {
            bundle.putDouble("lat", this.f58589i.getLat());
            bundle.putDouble("lng", this.f58589i.getLng());
        }
        bundle.putString("path", ImCommons.IM_FLUTTER_PATH);
        ImCallFrom callFrom = ImMapConfig.getInstance().getCallFrom();
        if (callFrom == ImCallFrom.IMMAP_RLAB_D) {
            bundle.putInt(ImCommons.BUNDLE_CALL_FROM, 3);
        } else if (callFrom == ImCallFrom.IMMAP_RLAB_C) {
            bundle.putInt(ImCommons.BUNDLE_CALL_FROM, 2);
        }
        if (ImMapConfig.getInstance().getFavorFrom() == ImFavorFrom.IMMAP_BRAZIL) {
            bundle.putString(ImCommons.BUNDLE_FAVOR, "brazil");
        } else {
            bundle.putString(ImCommons.BUNDLE_FAVOR, "global");
        }
        Locale locale = ImMapConfig.getInstance().getLocale();
        if (locale == null) {
            locale = LocaleUtils.getAppLocale(ImMapConfig.getInstance().getContext());
        }
        bundle.putString("lang", locale.getLanguage());
        bundle.putBoolean(ImCommons.BUNDLE_DOWNGRADE_MAP, ImMapConfig.getInstance().isDowngradeMap());
        this.f58592m.setArgs(bundle);
        this.f58586f.setRootPage(this.f58592m);
    }

    public void startMapNavigation(double d, double d2, String str) {
        Bundle bundle = new Bundle();
        bundle.putDouble("lat", d);
        bundle.putDouble("lng", d2);
        bundle.putString("address", str);
        m44353b(bundle);
    }

    /* renamed from: b */
    private void m44353b(Bundle bundle) {
        if (!this.f58587g.containsPageInBackStack(ImNavPage.class) || this.f58588h == null) {
            ImNavPage imNavPage = new ImNavPage();
            this.f58588h = imNavPage;
            imNavPage.setArgs(bundle);
            this.f58587g.pushPage(this.f58588h);
        } else if (bundle != null) {
            Logger logger = this.f58581a;
            logger.debug("showGoogleNavPage() called with: args = [" + bundle + Const.jaRight, new Object[0]);
            this.f58588h.setArgs(bundle);
            this.f58588h.reLoad();
        }
    }

    /* renamed from: e */
    private void m44356e() {
        if (this.f58590k != null) {
            m44357f();
        }
        if (!ImMapUtils.getGpsStatus(this) && getScopeContext() != null) {
            AppGpsDialog appGpsDialog = new AppGpsDialog();
            this.f58590k = appGpsDialog;
            appGpsDialog.setCancelable(false);
            this.f58590k.show(this.f58587g, "bottomSheet");
            this.f58590k.bind(getScopeContext());
            this.f58590k.setOnCancelListener(new AppGpsDialog.OnCancelListener() {
                public void onCancel() {
                    ImMapActivity.this.finish();
                }
            });
        }
    }

    /* renamed from: f */
    private void m44357f() {
        AppGpsDialog appGpsDialog = this.f58590k;
        if (appGpsDialog != null) {
            appGpsDialog.dismiss();
            this.f58590k = null;
        }
    }

    public void closeNewGoogleNaviPage() {
        this.f58581a.info("closeGoogleNaviPage() called", new Object[0]);
        PageInstrument pageInstrument = this.f58587g;
        if (pageInstrument != null && pageInstrument.containsPageInBackStack(ImNavPage.class)) {
            this.f58587g.pop();
            this.f58588h = null;
        }
    }

    public void onBackPressed() {
        if (1 != this.f58586f.getBackstackSize() || !this.f58587g.containsPageInBackStack(ImNavPage.class)) {
            super.onBackPressed();
            return;
        }
        this.f58581a.info("onBackPressed: isNavigation on and return", new Object[0]);
        this.f58587g.handleBack();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Context context = ImMapConfig.getInstance().getContext();
        if (context != null && -1 == context.getPackageManager().checkPermission(Permission.ACCESS_FINE_LOCATION, context.getPackageName()) && Build.VERSION.SDK_INT >= 23) {
            requestPermissions(f58580j, 1);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mStateSaved = false;
        Logger logger = this.f58581a;
        logger.debug("onResume mStateSaved = " + this.mStateSaved, new Object[0]);
        Context context = ImMapConfig.getInstance().getContext();
        if (context != null && context.getPackageManager().checkPermission(Permission.ACCESS_FINE_LOCATION, context.getPackageName()) == 0) {
            m44356e();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            Logger logger = this.f58581a;
            logger.debug("onRequestPermissionsResult = " + i, new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mStateSaved = true;
        Logger logger = this.f58581a;
        logger.debug("onSaveInstanceState mStateSaved = " + this.mStateSaved, new Object[0]);
    }
}
