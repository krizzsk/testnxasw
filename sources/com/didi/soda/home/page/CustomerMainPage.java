package com.didi.soda.home.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.Component;
import com.didi.soda.customer.annotation.SupportInnerDialog;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.home.page.CustomerMainPageDelegate;
import com.didi.soda.home.page.deleagteimp.CustomerMainPageA;
import com.didi.soda.home.page.deleagteimp.CustomerMainPageB;
import com.didi.soda.home.page.deleagteimp.HolderMainPage;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.didi.soda.router.annotations.RouteIndex;

@Route({"taxis99OneTravel://soda"})
@SupportInnerDialog
@RouteIndex(host = {"taxis99OneTravel://soda"})
public class CustomerMainPage extends CustomerPage implements CustomerMainPageDelegate.CustomerPageCallback {

    /* renamed from: a */
    private static String f45178a = "CustomerMainPageWrap";

    /* renamed from: b */
    private CustomerMainPageDelegate f45179b;

    public CustomerPage getOwner() {
        return this;
    }

    public CustomerMainPage(boolean z, boolean z2) {
        if (z) {
            LogUtil.m32588i(f45178a, "打开首页 命中B组!!!");
            if (z2) {
                LogUtil.m32588i(f45178a, "打开首页 直达二级页!!!");
                this.f45179b = new HolderMainPage(this);
            } else {
                LogUtil.m32588i(f45178a, "打开首页 显示Feed流");
                this.f45179b = new CustomerMainPageB(this);
            }
        } else {
            LogUtil.m32588i(f45178a, "打开首页 命中A组!!!");
            this.f45179b = new CustomerMainPageA(this);
        }
        DiRouter.registerHub("taxis99OneTravel://soda", this);
        DiRouter.registerIndexHub("taxis99OneTravel://soda", this);
    }

    public boolean isHolderPage() {
        return this.f45179b instanceof HolderMainPage;
    }

    public void onCreate(View view) {
        super.onCreate(view);
        this.f45179b.onCreate(view);
    }

    public void onPageChangeEnded() {
        super.onPageChangeEnded();
        this.f45179b.onPageChangeEnded();
    }

    public void onPageResult(Bundle bundle) {
        super.onPageResult(bundle);
        this.f45179b.onPageResult(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f45179b.onDestroy();
    }

    public boolean onHandleBack() {
        if (this.f45179b.onHandleBack()) {
            return true;
        }
        return super.onHandleBack();
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.f45179b.onInflateView(layoutInflater, viewGroup);
    }

    public void onStart() {
        super.onStart();
        this.f45179b.onStart();
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        this.f45179b.setupComponents(view);
    }

    public boolean removeComponent(Component component) {
        return super.removeComponent(component);
    }

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return this.f45179b.getStatusBarHeight();
    }

    public boolean addComponent(Component component) {
        return super.addComponent(component);
    }
}
