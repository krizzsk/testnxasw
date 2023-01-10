package com.didi.soda.customer.app;

import android.content.Context;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.AnalysisAPK;
import com.didi.soda.customer.CustomerFragment;
import com.didi.soda.customer.map.OnMapInitCallback;

public class GlobalContext {

    /* renamed from: a */
    private static final String f42898a = "GlobalContext";

    /* renamed from: b */
    private static BusinessContext f42899b = null;

    /* renamed from: c */
    private static Context f42900c = null;

    /* renamed from: d */
    private static PageInstrument f42901d = null;

    /* renamed from: e */
    private static CustomerFragment f42902e = null;

    /* renamed from: f */
    private static boolean f42903f = true;

    /* renamed from: g */
    private static boolean f42904g = false;

    /* renamed from: h */
    private static TitleAndBizBarManager f42905h = new TitleAndBizBarManager();

    public static boolean isEmbed() {
        return true;
    }

    public static boolean mapViewReady() {
        return true;
    }

    public static void onMapDestroy() {
    }

    public static void onMapResume() {
    }

    public static BusinessContext getBusinessContext() {
        return f42899b;
    }

    public static void setBusinessContext(BusinessContext businessContext) {
        f42899b = businessContext;
        f42905h.attachBusinessContext(businessContext);
    }

    public static boolean isGmsChannel() {
        return !AnalysisAPK.isGlobalHmsApk(getContext());
    }

    public static Context getContext() {
        return f42900c;
    }

    public static void setContext(Context context) {
        f42900c = context;
    }

    public static CustomerFragment getFragment() {
        return f42902e;
    }

    public static void setFragment(CustomerFragment customerFragment) {
        f42902e = customerFragment;
    }

    public static boolean isFragmentInited() {
        return getFragment().isFragmentInited();
    }

    public static void clear() {
        f42899b = null;
        f42900c = null;
        f42901d = null;
        f42902e = null;
    }

    public static void setInHome(boolean z) {
        f42903f = z;
    }

    public static boolean isInHome() {
        return f42903f;
    }

    public static void initMapView(OnMapInitCallback onMapInitCallback) {
        onMapInitCallback.onMapInitFinish(getBusinessContext().getMapFlowView().getMapView().getMap());
    }

    public static TitleAndBizBarManager getTitleAndBizBarManager() {
        return f42905h;
    }

    public static void fromSuperApp() {
        f42904g = true;
    }

    public static boolean isSuperApp() {
        return f42904g;
    }

    public static boolean isBrazil() {
        return "brazilEmbed".toLowerCase().contains("brazil");
    }

    public static void setPageInstrument(PageInstrument pageInstrument) {
        f42901d = pageInstrument;
    }

    public static PageInstrument getPageInstrument() {
        return f42901d;
    }

    public static boolean containsPage(Class cls) {
        PageInstrument pageInstrument = f42901d;
        if (pageInstrument == null) {
            return false;
        }
        return pageInstrument.containsPageInBackStack(cls);
    }

    public static boolean isInRoot() {
        PageInstrument pageInstrument = f42901d;
        if (pageInstrument != null && pageInstrument.getBackstackSize() == 1) {
            return true;
        }
        return false;
    }

    public static void popBackStack() {
        BusinessContext businessContext = f42899b;
        if (businessContext != null) {
            businessContext.getNavigation().popBackStack();
        }
    }
}
