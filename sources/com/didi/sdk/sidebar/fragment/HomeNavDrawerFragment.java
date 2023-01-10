package com.didi.sdk.sidebar.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.legacy.app.ActionBarDrawerToggle;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.events.IMRefreshEvent;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.PageDecorator;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.sidebar.ViewAssembler;
import com.didi.sdk.sidebar.component.AbsComponent;
import com.didi.sdk.sidebar.component.ComponentFactory;
import com.didi.sdk.sidebar.data.DataContainer;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.model.SidebarPage;
import com.didi.sdk.util.EventKeys;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.travel.util.CollectionUtils;
import com.didiglobal.travel.util.view.ViewEx;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class HomeNavDrawerFragment extends Fragment {

    /* renamed from: b */
    private static final String f39975b = "HomeNavDrawerFragment";

    /* renamed from: c */
    private static final Object f39976c = new Object();

    /* renamed from: a */
    private Logger f39977a = LoggerFactory.getLogger("DataContainer");

    /* renamed from: d */
    private BaseBusinessContext f39978d;

    /* renamed from: e */
    private SidebarPage f39979e;

    /* renamed from: f */
    private boolean f39980f;

    /* renamed from: g */
    private DrawerLayout f39981g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ActionBarDrawerToggle f39982h;

    /* renamed from: i */
    private View f39983i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ViewAssembler f39984j;

    /* renamed from: k */
    private LinearLayout f39985k;

    /* renamed from: l */
    private ViewStub f39986l;

    /* access modifiers changed from: protected */
    public void fixBarrierFree(View view) {
    }

    /* access modifiers changed from: protected */
    public int getRootLayoutId() {
        return R.layout.slide_bar_view;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f39977a.info("onCreate register ", new Object[0]);
        EventBus.getDefault().register(this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f39977a.info("onDestroy unregister ", new Object[0]);
        EventBus.getDefault().unregister(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflateViewAsync = ViewEx.inflateViewAsync(layoutInflater, getRootLayoutId(), (ViewGroup) null, false);
        this.f39983i = inflateViewAsync;
        this.f39986l = (ViewStub) inflateViewAsync.findViewById(R.id.new_slide_bar_view_stub);
        return this.f39983i;
    }

    public void setDrawerLayout(DrawerLayout drawerLayout) {
        this.f39981g = drawerLayout;
    }

    public void setBusinessContext(BusinessContext businessContext) {
        this.f39978d = businessContext;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void openSidebar(SidebarEvent sidebarEvent) {
        if (EventKeys.Sidebar.OPEN_SIDEBAR.equalsIgnoreCase(sidebarEvent.type)) {
            Logger logger = this.f39977a;
            logger.info("openSidebar hasInit = " + this.f39980f + ", pageData = " + this.f39979e, new Object[0]);
            if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
                UserCenterFacade.getIns().fetchUserInfo(getContext(), NationTypeUtil.getNationComponentData().getLoginInfo().getToken(), NationTypeUtil.getNationComponentData().getGLang(), (RpcService.Callback<UserInfo>) null);
                this.f39979e = DataContainer.getInstance().getPageData("level0", "root");
                if (!this.f39980f) {
                    this.f39980f = true;
                    View findViewById = this.f39983i.findViewById(R.id.container);
                    if (findViewById == null) {
                        this.f39986l.inflate();
                        findViewById = this.f39983i.findViewById(R.id.container);
                    }
                    m30132a((ViewGroup) findViewById);
                    m30135b();
                }
                DataContainer.getInstance().refreshData();
                this.f39981g.openDrawer(this.f39983i);
                m30131a();
            }
        }
    }

    /* renamed from: a */
    private void m30131a() {
        String str;
        SidebarPage sidebarPage = this.f39979e;
        if (sidebarPage != null && !CollectionUtils.isEmpty((Collection<?>) sidebarPage.getGroupList())) {
            int i = 0;
            List list = this.f39979e.getGroupList().get(0);
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                str = ((SidebarItem) list.get(i)).getDiscountMsg();
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
                i++;
            }
        }
        str = "";
        HashMap hashMap = new HashMap();
        hashMap.put("tag", str);
        OmegaSDKAdapter.trackEvent("pas_sidebar_sw", (Map<String, Object>) hashMap);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void closeSidebar(SidebarEvent sidebarEvent) {
        if (EventKeys.Sidebar.CLOSE_SIDEBAR.equalsIgnoreCase(sidebarEvent.type)) {
            this.f39981g.closeDrawer(this.f39983i);
            lockDrawerToClose();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshSidebar(SidebarPage sidebarPage) {
        SystemUtils.log(3, f39975b, "refrsh Sidebar", (Throwable) null, "com.didi.sdk.sidebar.fragment.HomeNavDrawerFragment", 171);
        this.f39979e = sidebarPage;
        View view = this.f39983i;
        if (view != null && this.f39980f) {
            m30132a((ViewGroup) view.findViewById(R.id.container));
        }
    }

    /* renamed from: a */
    private void m30132a(ViewGroup viewGroup) {
        List list;
        synchronized (f39976c) {
            this.f39977a.info("assemble begin....", new Object[0]);
            viewGroup.removeAllViews();
            this.f39984j = new ViewAssembler();
            if (!(this.f39979e == null || this.f39979e.getGroupList() == null || this.f39979e.getGroupList().size() <= 0 || (list = this.f39979e.getGroupList().get(0)) == null || list.size() <= 0)) {
                m30133a((SidebarItem) list.get(0));
            }
            this.f39984j.assemble(this.f39979e, new PageDecorator.PageDecoratorBuilder(viewGroup).setDividerColor(R.color.white).build(), this.f39978d);
            this.f39977a.info("assemble end....", new Object[0]);
        }
    }

    /* renamed from: a */
    private void m30133a(SidebarItem sidebarItem) {
        View view;
        if (this.f39985k == null) {
            this.f39985k = (LinearLayout) this.f39983i.findViewById(R.id.sidebar_head_container);
        }
        this.f39985k.setVisibility(0);
        this.f39985k.removeAllViews();
        AbsComponent createComponent = new ComponentFactory().createComponent(sidebarItem.getComponentType(), this.f39978d, sidebarItem, this.f39979e.getSubLevel());
        if (createComponent != null && createComponent.getView() != null && (view = createComponent.getView()) != null) {
            this.f39985k.addView(view);
        }
    }

    /* renamed from: b */
    private void m30135b() {
        fixBarrierFree(this.f39983i);
        this.f39981g.setDrawerShadow((int) R.drawable.drawer_shadow, (int) GravityCompat.START);
        this.f39982h = new ActionBarDrawerToggle(getActivity(), this.f39981g, R.drawable.ic_drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            private void notifyDelegate() {
            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.CLOSE_SIDEBAR));
                if (!HomeNavDrawerFragment.this.isAdded()) {
                }
            }

            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
                EventBus.getDefault().post(new IMRefreshEvent());
                HomeNavDrawerFragment.this.unlockDrawer();
                if (HomeNavDrawerFragment.this.f39984j != null) {
                    HomeNavDrawerFragment.this.f39984j.notifyOnResume();
                }
            }
        };
        this.f39981g.post(new Runnable() {
            public void run() {
                HomeNavDrawerFragment.this.f39982h.syncState();
            }
        });
        this.f39981g.setDrawerListener(this.f39982h);
    }

    public boolean isDrawerOpen() {
        DrawerLayout drawerLayout = this.f39981g;
        return drawerLayout != null && drawerLayout.isDrawerOpen(this.f39983i);
    }

    public void lockDrawerToClose() {
        DrawerLayout drawerLayout = this.f39981g;
        if (drawerLayout != null) {
            drawerLayout.setDrawerLockMode(1);
        }
    }

    public void unlockDrawer() {
        DrawerLayout drawerLayout = this.f39981g;
        if (drawerLayout != null) {
            drawerLayout.setDrawerLockMode(0);
        }
    }

    public void show() {
        this.f39981g.openDrawer(this.f39983i);
    }

    public void close() {
        this.f39981g.closeDrawer(this.f39983i);
    }

    public void onResume() {
        super.onResume();
        EventBus.getDefault().post(EventKeys.Sidebar.OPEN_SIDEBAR);
        EventBus.getDefault().post(new IMRefreshEvent());
    }
}
