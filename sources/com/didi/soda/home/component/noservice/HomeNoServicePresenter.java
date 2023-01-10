package com.didi.soda.home.component.noservice;

import android.os.Bundle;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.NativePageInfoEntity;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.home.component.noservice.HomeNoServiceView;
import com.didi.soda.home.manager.PolicyNotifyHelper;
import com.didi.soda.home.page.SubscribePhonePage;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class HomeNoServicePresenter extends ICustomerPresenter<HomeNoServiceView> {

    /* renamed from: a */
    private boolean f45075a = false;

    /* renamed from: b */
    private int f45076b;

    public void onPageResult(Bundle bundle) {
        if (bundle != null && bundle.containsKey(Const.PageParams.SUB_BACK_FROM_PHONE)) {
            this.f45075a = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).subscribeHomeData(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                HomeNoServicePresenter.this.m33430a((CustomerResource) obj);
            }
        });
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).subscribeHomeRefreshMessage(getScopeContext(), new Action2() {
            public final void call(Object obj, Subscription subscription) {
                HomeNoServicePresenter.this.m33432a((Integer) obj, subscription);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33430a(CustomerResource customerResource) {
        if (customerResource.status != Resource.Status.ERROR || customerResource.code <= 0) {
            ((HomeNoServiceView) getLogicView()).showOrHide(false);
        } else if (customerResource.data != null && ((HomeEntity) customerResource.data).getMNativePageInfo() != null) {
            this.f45076b = customerResource.code;
            ((HomeNoServiceView) getLogicView()).showOrHide(true);
            NativePageInfoEntity mNativePageInfo = ((HomeEntity) customerResource.data).getMNativePageInfo();
            ((HomeNoServiceView) getLogicView()).updateData(mNativePageInfo, m33429a(mNativePageInfo));
            HomeOmegaHelper.getInstance().trackHomeNoServiceSW(customerResource.code);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33432a(Integer num, Subscription subscription) {
        ((HomeNoServiceView) getLogicView()).showOrHide(false);
        ((HomeNoServiceView) getLogicView()).scrollToTop();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f45075a) {
            this.f45075a = false;
            ((HomeNoServiceView) getLogicView()).playSubscribeAnimation();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33431a(HomeNoServiceView.ButtonInfo buttonInfo) {
        HomeOmegaHelper.getInstance().trackHomeNoServiceNotice(this.f45076b);
        if (buttonInfo.isSubscribed) {
            return;
        }
        if (LoginUtil.isLogin()) {
            ((HomeNoServiceView) getLogicView()).showOrHideSubscribeLoading(true);
            PolicyNotifyHelper.submit(getScopeContext(), LoginUtil.getCallingCode(), LoginUtil.getPhone(), false, new PolicyNotifyHelper.VoidCallback() {
                public final void invoke(boolean z) {
                    HomeNoServicePresenter.this.m33433a(z);
                }
            });
            return;
        }
        SubscribePhonePage.toPhonePage(getScopeContext(), buttonInfo.callingCode, buttonInfo.countryId, this.f45076b);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33433a(boolean z) {
        ((HomeNoServiceView) getLogicView()).showOrHideSubscribeLoading(false);
        if (z) {
            ((HomeNoServiceView) getLogicView()).playSubscribeAnimation();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33434b(HomeNoServiceView.ButtonInfo buttonInfo) {
        HomeOmegaHelper.getInstance().trackHomeNoServiceCK(this.f45076b, EventConst.Home.HOME_CHECK_AVAILABLE_COUNTRY_CK);
        DiRouter.request().path("citySelectPage").putInt("param_error_code", this.f45076b).putString("param_title", buttonInfo.buttonText).open();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m33435c(HomeNoServiceView.ButtonInfo buttonInfo) {
        HomeOmegaHelper.getInstance().trackHomeNoServiceCK(this.f45076b, EventConst.Home.HOME_CHECK_AVAILABLE_CITY_CK);
        DiRouter.request().path("citySelectPage").putInt("param_error_code", this.f45076b).putString("param_title", buttonInfo.buttonText).open();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m33436d(HomeNoServiceView.ButtonInfo buttonInfo) {
        HomeOmegaHelper.getInstance().trackHomeNoServiceCK(this.f45076b, EventConst.Home.HOME_HOT_AREA_CK);
        if (buttonInfo != null && buttonInfo.poiInfo != null && buttonInfo.poiInfo.hotPoi != null) {
            ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByCityInfo(buttonInfo.poiInfo.hotPoi.lat, buttonInfo.poiInfo.hotPoi.lng, buttonInfo.poiInfo.cityId);
            getScopeContext().getNavigator().popToRoot();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m33437e(HomeNoServiceView.ButtonInfo buttonInfo) {
        HomeOmegaHelper.getInstance().trackHomeNoServiceCK(this.f45076b, EventConst.Home.HOME_CHANGE_LOCATION_CK);
        DiRouter.request().path(RoutePath.ADDRESS_HOME).putInt("from", 7).open();
    }

    /* renamed from: a */
    private List<HomeNoServiceView.ButtonInfo> m33429a(NativePageInfoEntity nativePageInfoEntity) {
        ArrayList arrayList = new ArrayList();
        if (nativePageInfoEntity.subscribeNotification != null && nativePageInfoEntity.subscribeNotification.display == 1) {
            HomeNoServiceView.ButtonInfo create = HomeNoServiceView.ButtonInfo.create(nativePageInfoEntity.subscribeNotification, new HomeNoServiceView.BtnCallback() {
                public final void invoke(HomeNoServiceView.ButtonInfo buttonInfo) {
                    HomeNoServicePresenter.this.m33431a(buttonInfo);
                }
            });
            create.buttonText = ResourceHelper.getString(R.string.customer_hone_non_keep_me_update);
            create.subscribedText = ResourceHelper.getString(R.string.customer_hone_non_submitted);
            arrayList.add(create);
        }
        if (nativePageInfoEntity.otherLocation != null && nativePageInfoEntity.otherLocation.display == 1) {
            HomeNoServiceView.ButtonInfo create2 = HomeNoServiceView.ButtonInfo.create(nativePageInfoEntity.otherLocation, new HomeNoServiceView.BtnCallback() {
                public final void invoke(HomeNoServiceView.ButtonInfo buttonInfo) {
                    HomeNoServicePresenter.this.m33437e(buttonInfo);
                }
            });
            create2.buttonText = ResourceHelper.getString(R.string.customer_hone_non_other_locations);
            arrayList.add(create2);
        }
        if (nativePageInfoEntity.availableCity != null && nativePageInfoEntity.availableCity.display == 1) {
            HomeNoServiceView.ButtonInfo create3 = HomeNoServiceView.ButtonInfo.create(nativePageInfoEntity.availableCity, new HomeNoServiceView.BtnCallback() {
                public final void invoke(HomeNoServiceView.ButtonInfo buttonInfo) {
                    HomeNoServicePresenter.this.m33435c(buttonInfo);
                }
            });
            create3.buttonText = ResourceHelper.getString(R.string.customer_hone_non_view_available_cities);
            arrayList.add(create3);
        }
        if (nativePageInfoEntity.availableCountry != null && nativePageInfoEntity.availableCountry.display == 1) {
            HomeNoServiceView.ButtonInfo create4 = HomeNoServiceView.ButtonInfo.create(nativePageInfoEntity.availableCountry, new HomeNoServiceView.BtnCallback() {
                public final void invoke(HomeNoServiceView.ButtonInfo buttonInfo) {
                    HomeNoServicePresenter.this.m33434b(buttonInfo);
                }
            });
            create4.buttonText = ResourceHelper.getString(R.string.customer_hone_non_view_available_countries);
            arrayList.add(create4);
        }
        if (nativePageInfoEntity.centralDistrict != null && nativePageInfoEntity.centralDistrict.display == 1) {
            HomeNoServiceView.ButtonInfo create5 = HomeNoServiceView.ButtonInfo.create(nativePageInfoEntity.centralDistrict, new HomeNoServiceView.BtnCallback() {
                public final void invoke(HomeNoServiceView.ButtonInfo buttonInfo) {
                    HomeNoServicePresenter.this.m33436d(buttonInfo);
                }
            });
            create5.buttonText = ResourceHelper.getString(R.string.customer_hone_non_popular_business);
            arrayList.add(create5);
        }
        return arrayList;
    }
}
