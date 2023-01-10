package com.didi.dimina.container.page;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.bean.NavigateConfig;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.dimina.container.bridge.NavigateSubJSBridge;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.p065ui.tabbar.BottomTabBar;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.raven.config.RavenKey;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class DMTabBarPageHostFragment extends Fragment implements ITabBarPageHost {
    public static final String ARG_MINA_INDEX = "mina_index";
    public static final String ARG_WEB_VIEW_FRAGMENT_URL = "arg_web_view_fragment_url";

    /* renamed from: a */
    private int f18914a;

    /* renamed from: b */
    private NavigateConfig f18915b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public NavigateConfig f18916c;

    /* renamed from: d */
    private BottomTabBar f18917d;

    /* renamed from: e */
    private DMMina f18918e;

    /* renamed from: f */
    private DMMinaNavigatorDelegate f18919f;

    /* renamed from: g */
    private int f18920g;

    /* renamed from: h */
    private Fragment f18921h;

    /* renamed from: i */
    private int f18922i;

    /* renamed from: j */
    private long f18923j = -1;

    public /* synthetic */ void disableAlertBeforeUnload() {
        IPageHost.CC.$default$disableAlertBeforeUnload(this);
    }

    public /* synthetic */ void enableAlertBeforeUnload(IPageHost.OnPageHostBackListener onPageHostBackListener) {
        IPageHost.CC.$default$enableAlertBeforeUnload(this, onPageHostBackListener);
    }

    public Fragment getPageHost() {
        return this;
    }

    public /* synthetic */ void onBackPressedInner() {
        IPageHost.CC.$default$onBackPressedInner(this);
    }

    /* renamed from: a */
    static boolean m15999a(int i, int i2, NavigateConfig navigateConfig) {
        DMMina dMMina;
        if (i < 0 || i2 < 0 || (dMMina = DMMinaPool.get(i)) == null) {
            return false;
        }
        return NavigateSubJSBridge.inMainTabs(dMMina, i2, HttpUtil.splitPath(navigateConfig.url));
    }

    /* renamed from: b */
    static ITabBarPageHost m16000b(int i, int i2, NavigateConfig navigateConfig) {
        DMTabBarPageHostFragment dMTabBarPageHostFragment = new DMTabBarPageHostFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("mina_index", i);
        bundle.putInt(DMFragment.ARG_STACK_INDEX, i2);
        bundle.putSerializable("arg_web_view_fragment_url", navigateConfig);
        dMTabBarPageHostFragment.setArguments(bundle);
        return dMTabBarPageHostFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f18914a = arguments.getInt("mina_index", -1);
            this.f18920g = arguments.getInt(DMFragment.ARG_STACK_INDEX, -1);
            this.f18915b = (NavigateConfig) arguments.getSerializable("arg_web_view_fragment_url");
        }
        int i = this.f18914a;
        if (i != -1) {
            DMMina dMMina = DMMinaPool.get(i);
            this.f18918e = dMMina;
            if (dMMina == null) {
                getActivity().finish();
                return;
            }
            this.f18919f = dMMina.getNavigator(this.f18920g);
            this.f18923j = System.currentTimeMillis();
            TraceUtil.trackOpenPageStart(this.f18918e.getMinaIndex(), m15993a());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = 0;
        View inflate = layoutInflater.inflate(R.layout.dimina_main_tab_fragment, viewGroup, false);
        this.f18917d = (BottomTabBar) inflate.findViewById(R.id.tab_bar);
        JSAppConfig jSAppConfig = this.f18918e.getJSAppConfig();
        BottomTabBar bottomTabBar = this.f18917d;
        if (!(jSAppConfig == null || jSAppConfig.tabBar == null || !jSAppConfig.tabBar.custom)) {
            i = 8;
        }
        bottomTabBar.setVisibility(i);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        JSAppConfig.TabBar tabBar;
        DMMina dMMina = this.f18918e;
        if (dMMina != null && dMMina.getJSAppConfig() != null && (tabBar = this.f18918e.getJSAppConfig().tabBar) != null) {
            List<JSAppConfig.TabBar.Item> list = tabBar.list;
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (TextUtils.equals(list.get(i2).pagePath, this.f18915b.url)) {
                    i = i2;
                }
            }
            this.f18917d.setOnTabSelectInterceptor(this.f18918e.getConfig().getCallbackConfig().getBottomBarSelectInterceptor());
            this.f18917d.setOnItemSelectedListener(new BottomTabBar.onItemSelectedListener() {
                public void onSelected(int i, int i2, JSAppConfig.TabBar.Item item, boolean z) {
                    NavigateConfig unused = DMTabBarPageHostFragment.this.f18916c = new NavigateConfig();
                    DMTabBarPageHostFragment.this.f18916c.url = item.pagePath;
                    DMTabBarPageHostFragment.this.f18916c.openType = InternalJSMethod.SWITCH_TAB;
                    DMTabBarPageHostFragment.this.f18916c.packages = "app";
                    DMTabBarPageHostFragment.this.m15994a(i, i2, z);
                }
            });
            this.f18917d.setTabBarData(tabBar.parseTabItemIconPath(this.f18918e), i);
        }
    }

    public void switchTabLoadJSFileToDataThreadFinish(JSONObject jSONObject) {
        NavigateConfig navigateConfig = this.f18915b;
        NavigateConfig navigateConfig2 = this.f18916c;
        if (navigateConfig2 != null) {
            navigateConfig = navigateConfig2;
        }
        if (navigateConfig.isLaunch) {
            this.f18918e.getDmPagePool().requireReadyDMPageCreated(new IDMCommonAction(jSONObject, navigateConfig) {
                public final /* synthetic */ JSONObject f$1;
                public final /* synthetic */ NavigateConfig f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void callback(Object obj) {
                    DMTabBarPageHostFragment.this.m15998a(this.f$1, this.f$2, (Void) obj);
                }
            }, navigateConfig.packages);
            return;
        }
        int optInt = jSONObject.optInt("index", this.f18922i);
        m15995a((Fragment) DMFragment.newPageFragment(this.f18914a, this.f18920g, navigateConfig), "" + optInt);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15998a(JSONObject jSONObject, NavigateConfig navigateConfig, Void voidR) {
        UIHandlerUtil.post(new Runnable(jSONObject, navigateConfig) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ NavigateConfig f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMTabBarPageHostFragment.this.m15997a(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15997a(JSONObject jSONObject, NavigateConfig navigateConfig) {
        int optInt = jSONObject.optInt("index", this.f18922i);
        m15995a((Fragment) DMFragment.newPageFragment(this.f18914a, this.f18920g, navigateConfig), "" + optInt);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15994a(int i, int i2, boolean z) {
        if (getActivity() != null && isAdded()) {
            this.f18922i = i2;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Fragment findFragmentByTag = childFragmentManager.findFragmentByTag("" + i2);
            if (findFragmentByTag == null) {
                this.f18917d.enable(false);
                NavigateConfig navigateConfig = this.f18915b;
                NavigateConfig navigateConfig2 = this.f18916c;
                if (navigateConfig2 != null) {
                    navigateConfig = navigateConfig2;
                }
                String splitPath = HttpUtil.splitPath(navigateConfig.url);
                if (!TextUtils.isEmpty(splitPath) && !splitPath.startsWith("/")) {
                    splitPath = "/" + splitPath;
                }
                JSONObject jSONObject = new JSONObject();
                JSONUtil.put(jSONObject, "route", (Object) splitPath);
                JSONUtil.put(jSONObject, "index", i2);
                JSONUtil.put(jSONObject, RavenKey.FROM_NATIVE, z);
                this.f18918e.getMessageTransfer().sendMessageToServiceFromNative("switchTabLoadJSFileToDataThreadRequire", new MessageWrapperBuilder().stackId(getNavigator().getIndex()).webViewId(-1).data(jSONObject).build());
                this.f18918e.getPerformance().markWebViewOpen();
                TraceUtil.trackEventCoreDotting(this.f18914a, Constant.CORE_DOTTING.LAUNCH_SWITCH_TAB_LOAD_JS_FILE_TO_DATA_THREAD_REQUIRE, "route: " + navigateConfig.url);
                return;
            }
            Fragment findFragmentByTag2 = childFragmentManager.findFragmentByTag("" + i);
            Fragment findFragmentByTag3 = childFragmentManager.findFragmentByTag("" + i2);
            if ((findFragmentByTag2 instanceof DMFragment) && (findFragmentByTag3 instanceof DMFragment)) {
                JSONObject jSONObject2 = new JSONObject();
                JSONUtil.put(jSONObject2, "fromIndex", (Object) "" + i);
                IPageHost iPageHost = (IPageHost) findFragmentByTag2;
                JSONUtil.put(jSONObject2, "fromWebViewId", iPageHost.getPage().getWebViewId());
                JSONUtil.put(jSONObject2, "fromRoute", (Object) "" + iPageHost.getPage().getUrl());
                JSONUtil.put(jSONObject2, "toIndex", (Object) "" + i2);
                IPageHost iPageHost2 = (IPageHost) findFragmentByTag3;
                JSONUtil.put(jSONObject2, "toWebViewId", iPageHost2.getPage().getWebViewId());
                JSONUtil.put(jSONObject2, "toRoute", (Object) "" + iPageHost2.getPage().getUrl());
                JSONUtil.put(jSONObject2, RavenKey.FROM_NATIVE, z);
                this.f18918e.getMessageTransfer().sendMessageToServiceFromNative("switchTabNotification", new MessageWrapperBuilder().stackId(iPageHost2.getPage().getNavigator().getIndex()).webViewId(iPageHost2.getPage().getWebViewId()).data(jSONObject2).build());
                int webViewId = iPageHost2.getPage().getWebViewId();
                WebViewEngine webView = iPageHost2.getPage().getWebViewContainer().getWebView();
                LogUtil.m16837d("webView操作onResume() form：TAB_来自首页 webViewId：" + webViewId);
                webView.dmResume();
            }
            m15995a(findFragmentByTag, "" + i2);
        }
    }

    /* renamed from: a */
    private void m15995a(Fragment fragment, String str) {
        if (getActivity() != null && isAdded()) {
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            Fragment fragment2 = this.f18921h;
            if (fragment2 != null) {
                beginTransaction.hide(fragment2);
            }
            if (!fragment.isAdded()) {
                beginTransaction.add(R.id.container, fragment, str);
            } else {
                beginTransaction.show(fragment);
            }
            beginTransaction.setPrimaryNavigationFragment(fragment);
            this.f18921h = fragment;
            beginTransaction.commitNowAllowingStateLoss();
        }
    }

    public boolean switchTab(NavigateConfig navigateConfig) {
        if (this.f18917d != null) {
            int i = -1;
            for (JSAppConfig.TabBar.Item next : this.f18918e.getJSAppConfig().tabBar.list) {
                i++;
                String splitPath = HttpUtil.splitPath(navigateConfig.url);
                if (!TextUtils.isEmpty(splitPath) && splitPath.startsWith("/")) {
                    splitPath = splitPath.substring(1);
                }
                if (TextUtils.equals(next.pagePath, splitPath)) {
                    break;
                }
            }
            this.f18916c = navigateConfig;
            this.f18917d.setSelectIndex(false, i);
        }
        return true;
    }

    public boolean showTabBar() {
        try {
            this.f18917d.setVisibility(0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean hideTabBar() {
        try {
            this.f18917d.setVisibility(8);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public List<IPageHost> getCurrentPages() {
        ArrayList arrayList = new ArrayList();
        if (getActivity() != null && isAdded()) {
            try {
                for (Fragment next : getChildFragmentManager().getFragments()) {
                    if (next instanceof DMFragment) {
                        arrayList.add((IPageHost) next);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public IPageHost getCurrentPage() {
        Fragment fragment = this.f18921h;
        if (fragment instanceof DMFragment) {
            return (IPageHost) fragment;
        }
        return null;
    }

    public DMPage getPage() {
        Fragment fragment = this.f18921h;
        DMPage page = !(fragment instanceof IPageHost) ? null : ((IPageHost) fragment).getPage();
        StringBuilder sb = new StringBuilder();
        sb.append("getPage: ");
        sb.append(page == null ? "null" : page.getUrl());
        LogUtil.m16841i(sb.toString());
        return page;
    }

    public void invokeDomReady() {
        this.f18917d.enable(true);
        IPageHost currentPage = getCurrentPage();
        if (currentPage != null) {
            currentPage.invokeDomReady();
        }
        TraceUtil.trackOpenPageEnd(this.f18918e.getMinaIndex(), m15993a(), false, Long.valueOf(System.currentTimeMillis() - this.f18923j));
    }

    public boolean setTabBarStyle(JSONObject jSONObject) {
        BottomTabBar bottomTabBar = this.f18917d;
        if (bottomTabBar != null) {
            return bottomTabBar.setTabBarStyle(jSONObject);
        }
        return false;
    }

    public boolean setTabBarItem(JSONObject jSONObject) {
        BottomTabBar bottomTabBar = this.f18917d;
        if (bottomTabBar != null) {
            return bottomTabBar.setTabBarItem(jSONObject);
        }
        return false;
    }

    public boolean showTabBarRedDot(JSONObject jSONObject) {
        BottomTabBar bottomTabBar = this.f18917d;
        if (bottomTabBar != null) {
            return bottomTabBar.showTabBarRedDot(jSONObject);
        }
        return false;
    }

    public boolean hideTabBarRedDot(JSONObject jSONObject) {
        BottomTabBar bottomTabBar = this.f18917d;
        if (bottomTabBar != null) {
            return bottomTabBar.hideTabBarRedDot(jSONObject);
        }
        return false;
    }

    public boolean setTabBarBadge(JSONObject jSONObject) {
        BottomTabBar bottomTabBar = this.f18917d;
        if (bottomTabBar != null) {
            return bottomTabBar.setTabBarBadge(jSONObject);
        }
        return false;
    }

    public boolean removeTabBarBadge(JSONObject jSONObject) {
        BottomTabBar bottomTabBar = this.f18917d;
        if (bottomTabBar != null) {
            return bottomTabBar.removeTabBarBadge(jSONObject);
        }
        return false;
    }

    public DMMinaNavigatorDelegate getNavigator() {
        return this.f18919f;
    }

    /* renamed from: a */
    private String m15993a() {
        NavigateConfig navigateConfig = this.f18916c;
        return navigateConfig != null ? HttpUtil.splitPath(navigateConfig.url) : "";
    }
}
