package com.didi.entrega.customer.app;

import android.content.Context;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.entrega.customer.CustomerFragment;
import com.didi.entrega.customer.map.OnMapInitCallback;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.NewUISwitchUtils;

public class GlobalContext {

    /* renamed from: a */
    private static final String f21637a = "GlobalContext";

    /* renamed from: b */
    private static TitleAndBizBarManager f21638b = new TitleAndBizBarManager();

    /* renamed from: c */
    private static BusinessContext f21639c;

    /* renamed from: d */
    private static Context f21640d;

    /* renamed from: e */
    private static PageInstrument f21641e;

    /* renamed from: f */
    private static CustomerFragment f21642f;

    /* renamed from: g */
    private static boolean f21643g = true;

    /* renamed from: h */
    private static boolean f21644h = false;

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
        return f21639c;
    }

    public static void setBusinessContext(BusinessContext businessContext) {
        f21639c = businessContext;
        f21638b.attachBusinessContext(businessContext);
    }

    public static void fromSuperApp() {
        f21644h = true;
    }

    public static boolean isSuperApp() {
        return f21644h;
    }

    public static Context getContext() {
        return f21640d;
    }

    public static void setContext(Context context) {
        f21640d = context;
    }

    public static CustomerFragment getFragment() {
        return f21642f;
    }

    public static void setFragment(CustomerFragment customerFragment) {
        f21642f = customerFragment;
    }

    public static boolean isFragmentInited() {
        return getFragment().isFragmentInited();
    }

    public static void popBackStack() {
        BusinessContext businessContext = f21639c;
        if (businessContext != null) {
            businessContext.getNavigation().popBackStack();
        }
    }

    public static void clear() {
        f21639c = null;
        f21640d = null;
        f21641e = null;
        f21642f = null;
    }

    public static void setInHome(boolean z) {
        f21643g = z;
    }

    public static boolean isInHome() {
        return f21643g;
    }

    public static void initMapView(OnMapInitCallback onMapInitCallback) {
        onMapInitCallback.onMapInitFinish(getBusinessContext().getMapFlowView().getMapView().getMap());
    }

    public static TitleAndBizBarManager getTitleAndBizBarManager() {
        return f21638b;
    }

    public static boolean isEmbedHomeNewUi() {
        return NewUISwitchUtils.isHomeNewUI();
    }

    public static int getBrand() {
        String lowerCase = "brazilEmbed".toLowerCase();
        return (TextUtils.isEmpty(lowerCase) || !lowerCase.contains("brazil")) ? 1 : 2;
    }

    public static void setPageInstrument(PageInstrument pageInstrument) {
        f21641e = pageInstrument;
    }

    public static PageInstrument getPageInstrument() {
        return f21641e;
    }

    public static boolean containsPage(Class cls) {
        PageInstrument pageInstrument = f21641e;
        if (pageInstrument == null) {
            return false;
        }
        return pageInstrument.containsPageInBackStack(cls);
    }

    public static boolean isBrazil() {
        return "brazilEmbed".toLowerCase().contains("brazil");
    }

    public static boolean isInRoot() {
        PageInstrument pageInstrument = f21641e;
        if (pageInstrument != null && pageInstrument.getBackstackSize() == 1) {
            return true;
        }
        return false;
    }
}
