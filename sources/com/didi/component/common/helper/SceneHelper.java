package com.didi.component.common.helper;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.safetoolkit.business.monitor.ISMonitorConfigCallback;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SceneHelper {

    /* renamed from: a */
    private static volatile SceneHelper f13442a;

    /* renamed from: A */
    private Map<String, Object> f13443A;

    /* renamed from: B */
    private List<Integer> f13444B;

    /* renamed from: C */
    private String f13445C = "";

    /* renamed from: D */
    private boolean f13446D = false;

    /* renamed from: b */
    private boolean f13447b = true;

    /* renamed from: c */
    private boolean f13448c = true;

    /* renamed from: d */
    private boolean f13449d = false;

    /* renamed from: e */
    private boolean f13450e = false;

    /* renamed from: f */
    private boolean f13451f = false;
    public HashSet<String> finishSet = new HashSet<>();

    /* renamed from: g */
    private boolean f13452g = false;

    /* renamed from: h */
    private boolean f13453h = false;

    /* renamed from: i */
    private boolean f13454i = false;
    public boolean isClickDispatchFee = false;
    public boolean isDeepLinkFromGoogle = false;
    public boolean isFromBackStackEstimate = false;
    public boolean isRestart = true;

    /* renamed from: j */
    private boolean f13455j = false;

    /* renamed from: k */
    private boolean f13456k = false;

    /* renamed from: l */
    private boolean f13457l = false;

    /* renamed from: m */
    private boolean f13458m = false;
    public ISMonitorConfigCallback monitorConfigCallback;

    /* renamed from: n */
    private boolean f13459n = false;

    /* renamed from: o */
    private boolean f13460o = false;

    /* renamed from: p */
    private boolean f13461p = false;
    public HashSet<String> pickSet = new HashSet<>();
    public String pushId = "";

    /* renamed from: q */
    private boolean f13462q = false;

    /* renamed from: r */
    private boolean f13463r = false;

    /* renamed from: s */
    private boolean f13464s = false;
    public HashMap<String, Object> saMap;

    /* renamed from: t */
    private boolean f13465t = false;

    /* renamed from: u */
    private boolean f13466u = false;

    /* renamed from: v */
    private boolean f13467v = false;

    /* renamed from: w */
    private boolean f13468w = false;

    /* renamed from: x */
    private Map<String, Object> f13469x;

    /* renamed from: y */
    private Map<String, Object> f13470y;

    /* renamed from: z */
    private Map<String, Object> f13471z;

    private SceneHelper() {
    }

    public static SceneHelper getInstance() {
        if (f13442a == null) {
            synchronized (SceneHelper.class) {
                if (f13442a == null) {
                    f13442a = new SceneHelper();
                }
            }
        }
        return f13442a;
    }

    public void setFirstLaunchHome(boolean z) {
        this.f13447b = z;
    }

    public void setFirstLaunchGuess(boolean z) {
        this.f13448c = z;
    }

    public void setFromSA(boolean z, HashMap<String, Object> hashMap) {
        this.f13446D = z;
        this.saMap = hashMap;
    }

    public void setFromSA(boolean z) {
        this.f13446D = z;
    }

    public boolean isFromSA() {
        return this.f13446D;
    }

    public void setFromLoginHome(boolean z) {
        this.f13449d = z;
    }

    public void setFromBackStackHome(boolean z) {
        this.f13451f = z;
    }

    public void setFromBackStackGuess(boolean z) {
        this.f13452g = z;
    }

    public void setFromLoginGuess(boolean z) {
        this.f13450e = z;
    }

    public void setFromBackStackBubble(boolean z) {
        this.f13453h = z;
    }

    public void setFromPickupPoint(boolean z) {
        this.f13454i = z;
    }

    public void setOrderIntercepted(boolean z) {
        this.f13455j = z;
    }

    public void setFromPayMethod(boolean z) {
        this.f13456k = z;
    }

    public void setFromPriceDetail(boolean z) {
        this.f13457l = z;
    }

    public void setParamsAFA(Map<String, Object> map) {
        this.f13469x = map;
    }

    public void setParamsABA(Map<String, Object> map) {
        this.f13470y = map;
    }

    public void setParamsAMA(Map<String, Object> map) {
        this.f13471z = map;
    }

    public void setHomeOnResume(boolean z) {
        this.f13458m = z;
    }

    public boolean isHomeOnResume() {
        return this.f13458m;
    }

    public void setFromImHome(boolean z) {
        this.f13459n = z;
    }

    public void setFromSupageHome(boolean z) {
        this.f13460o = z;
    }

    public void setFromBubbleHome(boolean z) {
        this.f13461p = z;
    }

    public void setFromImGuess(boolean z) {
        this.f13462q = z;
    }

    public void setFromSupageGuess(boolean z) {
        this.f13463r = z;
    }

    public void setFromBubbleGuess(boolean z) {
        this.f13464s = z;
    }

    public void setParamsACMA(Map<String, Object> map) {
        this.f13443A = map;
    }

    public void setAppOnResume(boolean z) {
        this.f13466u = z;
    }

    public void setFromBackStackEta(boolean z) {
        this.f13467v = z;
    }

    public void setCarList(List<Integer> list) {
        this.f13444B = list;
    }

    public void setEtaExecute(boolean z) {
        this.f13468w = z;
    }

    public List<Integer> getCarList() {
        return this.f13444B;
    }

    public void setFromPickupPoARA(boolean z) {
        this.f13465t = z;
    }

    public boolean isFirstLaunchHome() {
        return this.f13447b;
    }

    public boolean isFirstLaunchGuess() {
        return this.f13448c;
    }

    public boolean isFromLoginHome() {
        return this.f13449d;
    }

    public boolean isFromLoginGuess() {
        return this.f13450e;
    }

    public boolean isFromBackStackHome() {
        return this.f13451f;
    }

    public boolean isFromBackStackGuess() {
        return this.f13452g;
    }

    public boolean isFromPickupPoint() {
        return this.f13454i;
    }

    public boolean isOrderIntercepted() {
        return this.f13455j;
    }

    public boolean isFromPayMethod() {
        return this.f13456k;
    }

    public boolean isFromPriceDetail() {
        return this.f13457l;
    }

    public boolean isFromBackStackBubble() {
        return this.f13453h;
    }

    public boolean isFromImHome() {
        return this.f13459n;
    }

    public boolean isFromSupageHome() {
        return this.f13460o;
    }

    public boolean isFromBubbleHome() {
        return this.f13461p;
    }

    public boolean isFromImGuess() {
        return this.f13462q;
    }

    public boolean isFormSupageGuess() {
        return this.f13463r;
    }

    public boolean isFromBubbleGuess() {
        return this.f13464s;
    }

    public boolean isFromBackStackEta() {
        return this.f13467v;
    }

    public boolean isAppOnResume() {
        return this.f13466u;
    }

    public boolean isEtaExecute() {
        return this.f13468w;
    }

    public boolean isFromPickupPoARA() {
        return this.f13465t;
    }

    public void traceAFAEventIfNeed() {
        Map<String, Object> map = this.f13469x;
        if (map != null) {
            map.put("scene", "AFA");
            GlobalOmegaUtils.trackEvent("pas_pickupconfirm_sw", this.f13469x);
        }
    }

    public void traceABAEventIfNeed() {
        Map<String, Object> map = this.f13470y;
        if (map != null) {
            map.put("scene", "ABA");
            GlobalOmegaUtils.trackEvent("pas_pickupconfirm_sw", this.f13470y);
        }
    }

    public void traceAMAEventIfNeed() {
        Map<String, Object> map = this.f13471z;
        if (map != null && this.f13458m) {
            map.put("scene", "AMA");
            GlobalOmegaUtils.trackEvent("pas_home_sw", this.f13471z);
        }
    }

    public void traceACMAEventIfNeed() {
        Map<String, Object> map = this.f13443A;
        if (map != null) {
            map.put("scene", "ACMA");
            GlobalOmegaUtils.trackEvent("gp_eyeballsEta_view_sw", this.f13443A);
        }
    }

    public void traceBubbleEventIfNeed(Context context, Map<String, Object> map) {
        if (GPageIdConstant.G_PAGE_ID_CONF.equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
            map.put("is_login", Integer.valueOf(NationComponentDataUtil.isLoginNow() ? 1 : 0));
            GlobalOmegaUtils.trackEvent("pas_orderconfirm_sw", map);
        }
    }

    public boolean isTargetTopVisible(Context context, Class cls) {
        List<Fragment> fragments;
        int size;
        Fragment fragment = null;
        FragmentManager supportFragmentManager = context instanceof FragmentActivity ? ((FragmentActivity) context).getSupportFragmentManager() : null;
        if (supportFragmentManager == null || (size = fragments.size()) == 0) {
            return false;
        }
        int i = size - 1;
        while (true) {
            if (i < 0) {
                break;
            }
            Fragment fragment2 = (fragments = supportFragmentManager.getFragments()).get(i);
            if (fragment2.isVisible() && fragment2.getUserVisibleHint()) {
                fragment = fragment2;
                break;
            }
            i--;
        }
        if (!cls.isInstance(fragment)) {
            return false;
        }
        return true;
    }

    public void setLatestKey(String str) {
        this.f13445C = str;
    }

    public String getLatestKey() {
        return this.f13445C;
    }
}
