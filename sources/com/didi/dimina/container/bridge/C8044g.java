package com.didi.dimina.container.bridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.page.ITabBarPageHost;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.NavigateUtil;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.g */
/* compiled from: TabBarSubJSBridge */
class C8044g {

    /* renamed from: a */
    private static final int f18618a = -1000;

    /* renamed from: b */
    private static final int f18619b = -1001;

    /* renamed from: c */
    private final DMMina f18620c;

    C8044g(DMMina dMMina) {
        this.f18620c = dMMina;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59681a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ITabBarPageHost c = m15859c(callbackFunction);
        if (c != null) {
            boolean tabBarStyle = c.setTabBarStyle(jSONObject);
            Object[] objArr = new Object[1];
            objArr[0] = tabBarStyle ? m15857a() : m15858a(-1001, "the parameter index is invalid");
            callbackFunction.onCallBack(objArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo59683b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ITabBarPageHost c = m15859c(callbackFunction);
        if (c != null) {
            boolean tabBarItem = c.setTabBarItem(jSONObject);
            Object[] objArr = new Object[1];
            objArr[0] = tabBarItem ? m15857a() : m15858a(-1001, "the parameter index is invalid");
            callbackFunction.onCallBack(objArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo59684c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ITabBarPageHost c = m15859c(callbackFunction);
        if (c != null) {
            boolean showTabBarRedDot = c.showTabBarRedDot(jSONObject);
            Object[] objArr = new Object[1];
            objArr[0] = showTabBarRedDot ? m15857a() : m15858a(-1001, "the parameter index is invalid");
            callbackFunction.onCallBack(objArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo59685d(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ITabBarPageHost c = m15859c(callbackFunction);
        if (c != null) {
            boolean hideTabBarRedDot = c.hideTabBarRedDot(jSONObject);
            Object[] objArr = new Object[1];
            objArr[0] = hideTabBarRedDot ? m15857a() : m15858a(-1001, "the parameter index is invalid");
            callbackFunction.onCallBack(objArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo59686e(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ITabBarPageHost c = m15859c(callbackFunction);
        if (c != null) {
            boolean tabBarBadge = c.setTabBarBadge(jSONObject);
            Object[] objArr = new Object[1];
            objArr[0] = tabBarBadge ? m15857a() : m15858a(-1001, "the parameter index is invalid");
            callbackFunction.onCallBack(objArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo59687f(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ITabBarPageHost c = m15859c(callbackFunction);
        if (c != null) {
            boolean removeTabBarBadge = c.removeTabBarBadge(jSONObject);
            Object[] objArr = new Object[1];
            objArr[0] = removeTabBarBadge ? m15857a() : m15858a(-1001, "the parameter index is invalid");
            callbackFunction.onCallBack(objArr);
        }
    }

    /* renamed from: a */
    public void mo59680a(CallbackFunction callbackFunction) {
        ITabBarPageHost c = m15859c(callbackFunction);
        if (c == null) {
            CallBackUtil.onFail("showTabBar failed", callbackFunction);
        } else if (c.showTabBar()) {
            CallBackUtil.onSuccess(callbackFunction);
        } else {
            CallBackUtil.onFail("showTabBar failed", callbackFunction);
        }
    }

    /* renamed from: b */
    public void mo59682b(CallbackFunction callbackFunction) {
        ITabBarPageHost c = m15859c(callbackFunction);
        if (c == null) {
            CallBackUtil.onFail("hideTabBar failed", callbackFunction);
        } else if (c.hideTabBar()) {
            CallBackUtil.onSuccess(callbackFunction);
        } else {
            CallBackUtil.onFail("hideTabBar failed", callbackFunction);
        }
    }

    /* renamed from: c */
    private ITabBarPageHost m15859c(CallbackFunction callbackFunction) {
        DMMinaNavigatorDelegate curNavigator = NavigateUtil.getCurNavigator(this.f18620c);
        if (curNavigator == null) {
            return null;
        }
        List<IPageHost> currentPages = curNavigator.getCurrentPages();
        if (currentPages == null || currentPages.size() > 1) {
            callbackFunction.onCallBack(m15858a(-1000, "只能在TabBar页面内调用"));
            return null;
        }
        IPageHost currentPage = curNavigator.getCurrentPage();
        if (currentPage == null) {
            callbackFunction.onCallBack(m15858a(-1000, "堆栈内没有任何页面"));
            return null;
        } else if (currentPage instanceof ITabBarPageHost) {
            return (ITabBarPageHost) currentPage;
        } else {
            callbackFunction.onCallBack(m15858a(-1000, "没有配置tabBar"));
            return null;
        }
    }

    /* renamed from: a */
    private static JSONObject m15857a() {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "success", true);
        return jSONObject;
    }

    /* renamed from: a */
    private static JSONObject m15858a(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "success", false);
        JSONUtil.put(jSONObject, "code", i);
        JSONUtil.put(jSONObject, "error", (Object) str);
        return jSONObject;
    }
}
