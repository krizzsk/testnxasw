package com.didiglobal.p205sa.biz.tab.manager;

import android.view.KeyEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.sidebar.fragment.HomeNavDrawerFragment;
import com.didi.sdk.util.SaApolloUtil;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#J\u0010\u0010$\u001a\u00020\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\tR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006%"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/tab/manager/SaSideBarUiManager;", "", "homeNavDrawerFragment", "Lcom/didi/sdk/sidebar/fragment/HomeNavDrawerFragment;", "supportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "businessContext", "Lcom/didi/sdk/app/BusinessContext;", "(Lcom/didi/sdk/sidebar/fragment/HomeNavDrawerFragment;Landroidx/fragment/app/FragmentManager;Landroidx/drawerlayout/widget/DrawerLayout;Lcom/didi/sdk/app/BusinessContext;)V", "getBusinessContext", "()Lcom/didi/sdk/app/BusinessContext;", "setBusinessContext", "(Lcom/didi/sdk/app/BusinessContext;)V", "getDrawerLayout", "()Landroidx/drawerlayout/widget/DrawerLayout;", "setDrawerLayout", "(Landroidx/drawerlayout/widget/DrawerLayout;)V", "getHomeNavDrawerFragment", "()Lcom/didi/sdk/sidebar/fragment/HomeNavDrawerFragment;", "setHomeNavDrawerFragment", "(Lcom/didi/sdk/sidebar/fragment/HomeNavDrawerFragment;)V", "getSupportFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setSupportFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "close", "", "needShowSideBar", "", "onKeyUp", "keyCode", "", "event", "Landroid/view/KeyEvent;", "updateBusinessContext", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.manager.SaSideBarUiManager */
/* compiled from: SaSideBarUiManager.kt */
public final class SaSideBarUiManager {

    /* renamed from: a */
    private HomeNavDrawerFragment f53759a;

    /* renamed from: b */
    private FragmentManager f53760b;

    /* renamed from: c */
    private DrawerLayout f53761c;

    /* renamed from: d */
    private BusinessContext f53762d;

    public SaSideBarUiManager(HomeNavDrawerFragment homeNavDrawerFragment, FragmentManager fragmentManager, DrawerLayout drawerLayout, BusinessContext businessContext) {
        this.f53759a = homeNavDrawerFragment;
        this.f53760b = fragmentManager;
        this.f53761c = drawerLayout;
        this.f53762d = businessContext;
        if (homeNavDrawerFragment != null) {
            homeNavDrawerFragment.setDrawerLayout(drawerLayout);
        }
        DrawerLayout drawerLayout2 = this.f53761c;
        if (drawerLayout2 != null) {
            drawerLayout2.setDrawerLockMode(1);
        }
        HomeNavDrawerFragment homeNavDrawerFragment2 = this.f53759a;
        if (homeNavDrawerFragment2 != null) {
            homeNavDrawerFragment2.setBusinessContext(this.f53762d);
        }
        if (!m40113a()) {
            DrawerLayout drawerLayout3 = this.f53761c;
            if (drawerLayout3 != null) {
                drawerLayout3.setScrimColor(ContextCompat.getColor(DIDIApplication.getAppContext(), R.color.transparent));
            }
            HomeNavDrawerFragment homeNavDrawerFragment3 = this.f53759a;
            View view = homeNavDrawerFragment3 == null ? null : homeNavDrawerFragment3.getView();
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        DrawerLayout drawerLayout4 = this.f53761c;
        if (drawerLayout4 != null) {
            drawerLayout4.setScrimColor(ContextCompat.getColor(DIDIApplication.getAppContext(), R.color.new_ui_sidebar_scim_color));
        }
    }

    public final HomeNavDrawerFragment getHomeNavDrawerFragment() {
        return this.f53759a;
    }

    public final void setHomeNavDrawerFragment(HomeNavDrawerFragment homeNavDrawerFragment) {
        this.f53759a = homeNavDrawerFragment;
    }

    public final FragmentManager getSupportFragmentManager() {
        return this.f53760b;
    }

    public final void setSupportFragmentManager(FragmentManager fragmentManager) {
        this.f53760b = fragmentManager;
    }

    public final DrawerLayout getDrawerLayout() {
        return this.f53761c;
    }

    public final void setDrawerLayout(DrawerLayout drawerLayout) {
        this.f53761c = drawerLayout;
    }

    public final BusinessContext getBusinessContext() {
        return this.f53762d;
    }

    public final void setBusinessContext(BusinessContext businessContext) {
        this.f53762d = businessContext;
    }

    public final void updateBusinessContext(BusinessContext businessContext) {
        HomeNavDrawerFragment homeNavDrawerFragment = this.f53759a;
        if (homeNavDrawerFragment != null) {
            homeNavDrawerFragment.setBusinessContext(businessContext);
        }
    }

    public final void close() {
        HomeNavDrawerFragment homeNavDrawerFragment;
        if (m40113a()) {
            HomeNavDrawerFragment homeNavDrawerFragment2 = this.f53759a;
            boolean z = false;
            if (homeNavDrawerFragment2 != null && homeNavDrawerFragment2.isDrawerOpen()) {
                z = true;
            }
            if (z && (homeNavDrawerFragment = this.f53759a) != null) {
                homeNavDrawerFragment.close();
            }
        }
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!m40113a() || i != 4) {
            return false;
        }
        FragmentManager fragmentManager = this.f53760b;
        Integer valueOf = fragmentManager == null ? null : Integer.valueOf(fragmentManager.getBackStackEntryCount());
        if (valueOf != null && valueOf.intValue() == 0) {
            HomeNavDrawerFragment homeNavDrawerFragment = this.f53759a;
            if (homeNavDrawerFragment != null && homeNavDrawerFragment.isDrawerOpen()) {
                HomeNavDrawerFragment homeNavDrawerFragment2 = this.f53759a;
                if (homeNavDrawerFragment2 != null) {
                    homeNavDrawerFragment2.close();
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private final boolean m40113a() {
        if (SaApolloUtil.INSTANCE.getSaOneState()) {
            return SaTabUserCenterDemoteManager.INSTANCE.hideUserCenter();
        }
        return true;
    }
}
