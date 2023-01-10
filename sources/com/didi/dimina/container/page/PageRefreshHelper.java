package com.didi.dimina.container.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.p065ui.refresh.AbsOverView;
import com.didi.dimina.container.p065ui.refresh.IRefresh;
import com.didi.dimina.container.p065ui.refresh.RefreshLayout;
import com.didi.dimina.container.p065ui.refresh.TextOverView;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.taxis99.R;

public class PageRefreshHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RefreshLayout f18924a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f18925b;

    /* renamed from: c */
    private final DMMina f18926c;

    /* renamed from: d */
    private final DMPage f18927d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f18928e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f18929f;

    public PageRefreshHelper(DMMina dMMina, DMPage dMPage) {
        boolean z = false;
        this.f18926c = dMMina;
        this.f18927d = dMPage;
        JSAppConfig jSAppConfig = dMMina.getJSAppConfig();
        JSAppConfig.PageConfig pageConfig = jSAppConfig.getPageConfig(this.f18927d.getUrl());
        if (pageConfig != null) {
            z = pageConfig.enablePullDownRefresh();
        } else if (jSAppConfig.globalConfig != null && jSAppConfig.globalConfig.enablePullDownRefresh()) {
            z = true;
        }
        this.f18925b = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo60282a() {
        if (!this.f18925b) {
            LogUtil.m16841i("the target page can't pull down to refresh");
            return;
        }
        View findViewById = this.f18927d.findViewById(R.id.webview_container);
        if (findViewById == null) {
            LogUtil.m16841i("the target view is empty");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
        if (viewGroup == null) {
            LogUtil.m16841i("the target view's parent is empty");
            return;
        }
        int indexOfChild = viewGroup.indexOfChild(findViewById);
        viewGroup.removeView(findViewById);
        RefreshLayout refreshLayout = new RefreshLayout(this.f18927d.getContext());
        this.f18924a = refreshLayout;
        refreshLayout.addView(findViewById);
        viewGroup.addView(this.f18924a, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
        AbsOverView absOverView = null;
        try {
            Class<? extends AbsOverView> refreshOverViewClass = this.f18926c.getConfig().getUIConfig().getRefreshOverViewClass();
            Class[] clsArr = {Context.class};
            absOverView = (AbsOverView) refreshOverViewClass.getConstructor(clsArr).newInstance(new Object[]{this.f18927d.getContext()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (absOverView != null) {
            this.f18924a.setRefreshOverView(absOverView);
        } else {
            this.f18924a.setRefreshOverView(new TextOverView(this.f18927d.getContext()));
        }
        this.f18924a.setRefreshListener(new IRefresh.RefreshListener() {
            public boolean enableRefresh() {
                return true;
            }

            public void onRefresh() {
                if (!PageRefreshHelper.this.f18928e) {
                    UIHandlerUtil.postDelayed(new Runnable() {
                        public void run() {
                            PageRefreshHelper.this.stopPullDownRefresh();
                        }
                    }, 1000);
                }
            }
        });
        this.f18927d.getWebViewContainer().getWebView().addScrollChangedCallback(new WebViewEngine.OnScrollChangedCallback() {
            public void onScroll(int i, int i2) {
                int unused = PageRefreshHelper.this.f18929f = i2;
                PageRefreshHelper.this.f18924a.setEnablePullDownToRefresh(PageRefreshHelper.this.f18925b && PageRefreshHelper.this.f18929f <= 0);
            }
        });
    }

    public void startPullDownRefresh() {
        RefreshLayout refreshLayout;
        if (this.f18925b && (refreshLayout = this.f18924a) != null) {
            this.f18928e = true;
            refreshLayout.refreshAuto();
        }
    }

    public void stopPullDownRefresh() {
        RefreshLayout refreshLayout;
        if (this.f18925b && (refreshLayout = this.f18924a) != null) {
            refreshLayout.refreshFinished();
        }
    }

    public void setEnablePullRefresh(boolean z) {
        this.f18925b = z;
        if (this.f18924a == null && z) {
            mo60282a();
        }
        RefreshLayout refreshLayout = this.f18924a;
        if (refreshLayout != null) {
            refreshLayout.setEnablePullDownToRefresh(z && this.f18929f <= 0);
        }
    }
}
