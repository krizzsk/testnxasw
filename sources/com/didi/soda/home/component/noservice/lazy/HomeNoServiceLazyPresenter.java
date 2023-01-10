package com.didi.soda.home.component.noservice.lazy;

import android.os.Bundle;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.lazycomponent.ILazyPresenter;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.NativePageInfoEntity;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.home.component.noservice.lazy.HomeNoServiceLazyView;
import com.didi.soda.home.manager.PolicyNotifyHelper;
import com.didi.soda.home.page.SubscribePhonePage;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class HomeNoServiceLazyPresenter extends ILazyPresenter<HomeNoServiceLazyView> {

    /* renamed from: a */
    private boolean f45082a = false;

    /* renamed from: b */
    private int f45083b;

    public void onPageResult(Bundle bundle) {
        if (bundle != null && bundle.containsKey(Const.PageParams.SUB_BACK_FROM_PHONE)) {
            this.f45082a = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttach() {
        super.onAttach();
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).subscribeHomeData(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                HomeNoServiceLazyPresenter.this.m33448a((CustomerResource) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33448a(CustomerResource customerResource) {
        if (customerResource.status != Resource.Status.ERROR || customerResource.code <= 0) {
            ((HomeNoServiceLazyView) getLogicView()).showOrHide(false);
        } else if (customerResource.data != null && ((HomeEntity) customerResource.data).getMNativePageInfo() != null) {
            this.f45083b = customerResource.code;
            ((HomeNoServiceLazyView) getLogicView()).showOrHide(true);
            NativePageInfoEntity mNativePageInfo = ((HomeEntity) customerResource.data).getMNativePageInfo();
            ((HomeNoServiceLazyView) getLogicView()).updateData(mNativePageInfo, m33447a(mNativePageInfo));
            HomeOmegaHelper.getInstance().trackHomeNoServiceSW(customerResource.code);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).subscribeHomeRefreshMessage(getScopeContext(), new Action2() {
            public final void call(Object obj, Subscription subscription) {
                HomeNoServiceLazyPresenter.this.m33450a((Integer) obj, subscription);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33450a(Integer num, Subscription subscription) {
        ((HomeNoServiceLazyView) getLogicView()).showOrHide(false);
        ((HomeNoServiceLazyView) getLogicView()).scrollToTop();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f45082a) {
            this.f45082a = false;
            ((HomeNoServiceLazyView) getLogicView()).playSubscribeAnimation();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33449a(HomeNoServiceLazyView.ButtonInfo buttonInfo) {
        HomeOmegaHelper.getInstance().trackHomeNoServiceNotice(this.f45083b);
        if (buttonInfo.isSubscribed) {
            return;
        }
        if (LoginUtil.isLogin()) {
            ((HomeNoServiceLazyView) getLogicView()).showOrHideSubscribeLoading(true);
            PolicyNotifyHelper.submit(getScopeContext(), LoginUtil.getCallingCode(), LoginUtil.getPhone(), false, new PolicyNotifyHelper.VoidCallback() {
                public final void invoke(boolean z) {
                    HomeNoServiceLazyPresenter.this.m33451a(z);
                }
            });
            return;
        }
        SubscribePhonePage.toPhonePage(getScopeContext(), buttonInfo.callingCode, buttonInfo.countryId, this.f45083b);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33451a(boolean z) {
        ((HomeNoServiceLazyView) getLogicView()).showOrHideSubscribeLoading(false);
        if (z) {
            ((HomeNoServiceLazyView) getLogicView()).playSubscribeAnimation();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33452b(HomeNoServiceLazyView.ButtonInfo buttonInfo) {
        HomeOmegaHelper.getInstance().trackHomeNoServiceCK(this.f45083b, EventConst.Home.HOME_CHECK_AVAILABLE_COUNTRY_CK);
        DiRouter.request().path("citySelectPage").putInt("param_error_code", this.f45083b).putString("param_title", buttonInfo.buttonText).open();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m33453c(HomeNoServiceLazyView.ButtonInfo buttonInfo) {
        HomeOmegaHelper.getInstance().trackHomeNoServiceCK(this.f45083b, EventConst.Home.HOME_CHECK_AVAILABLE_CITY_CK);
        DiRouter.request().path("citySelectPage").putInt("param_error_code", this.f45083b).putString("param_title", buttonInfo.buttonText).open();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m33454d(HomeNoServiceLazyView.ButtonInfo buttonInfo) {
        HomeOmegaHelper.getInstance().trackHomeNoServiceCK(this.f45083b, EventConst.Home.HOME_HOT_AREA_CK);
        if (buttonInfo != null && buttonInfo.poiInfo != null && buttonInfo.poiInfo.hotPoi != null) {
            ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByCityInfo(buttonInfo.poiInfo.hotPoi.lat, buttonInfo.poiInfo.hotPoi.lng, buttonInfo.poiInfo.cityId);
            getScopeContext().getNavigator().popToRoot();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m33455e(HomeNoServiceLazyView.ButtonInfo buttonInfo) {
        HomeOmegaHelper.getInstance().trackHomeNoServiceCK(this.f45083b, EventConst.Home.HOME_CHANGE_LOCATION_CK);
        DiRouter.request().path(RoutePath.ADDRESS_HOME).putInt("from", 7).open();
    }

    /* renamed from: a */
    private List<HomeNoServiceLazyView.ButtonInfo> m33447a(NativePageInfoEntity nativePageInfoEntity) {
        ArrayList arrayList = new ArrayList();
        if (nativePageInfoEntity.subscribeNotification != null && nativePageInfoEntity.subscribeNotification.display == 1) {
            HomeNoServiceLazyView.ButtonInfo create = HomeNoServiceLazyView.ButtonInfo.create(nativePageInfoEntity.subscribeNotification, new HomeNoServiceLazyView.BtnCallback() {
                public final void invoke(HomeNoServiceLazyView.ButtonInfo buttonInfo) {
                    HomeNoServiceLazyPresenter.this.m33449a(buttonInfo);
                }
            });
            create.buttonText = ResourceHelper.getString(R.string.customer_hone_non_keep_me_update);
            create.subscribedText = ResourceHelper.getString(R.string.customer_hone_non_submitted);
            arrayList.add(create);
        }
        if (nativePageInfoEntity.otherLocation != null && nativePageInfoEntity.otherLocation.display == 1) {
            HomeNoServiceLazyView.ButtonInfo create2 = HomeNoServiceLazyView.ButtonInfo.create(nativePageInfoEntity.otherLocation, new HomeNoServiceLazyView.BtnCallback() {
                public final void invoke(HomeNoServiceLazyView.ButtonInfo buttonInfo) {
                    HomeNoServiceLazyPresenter.this.m33455e(buttonInfo);
                }
            });
            create2.buttonText = ResourceHelper.getString(R.string.customer_hone_non_other_locations);
            arrayList.add(create2);
        }
        if (nativePageInfoEntity.availableCity != null && nativePageInfoEntity.availableCity.display == 1) {
            HomeNoServiceLazyView.ButtonInfo create3 = HomeNoServiceLazyView.ButtonInfo.create(nativePageInfoEntity.availableCity, new HomeNoServiceLazyView.BtnCallback() {
                public final void invoke(HomeNoServiceLazyView.ButtonInfo buttonInfo) {
                    HomeNoServiceLazyPresenter.this.m33453c(buttonInfo);
                }
            });
            create3.buttonText = ResourceHelper.getString(R.string.customer_hone_non_view_available_cities);
            arrayList.add(create3);
        }
        if (nativePageInfoEntity.availableCountry != null && nativePageInfoEntity.availableCountry.display == 1) {
            HomeNoServiceLazyView.ButtonInfo create4 = HomeNoServiceLazyView.ButtonInfo.create(nativePageInfoEntity.availableCountry, new HomeNoServiceLazyView.BtnCallback() {
                public final void invoke(HomeNoServiceLazyView.ButtonInfo buttonInfo) {
                    HomeNoServiceLazyPresenter.this.m33452b(buttonInfo);
                }
            });
            create4.buttonText = ResourceHelper.getString(R.string.customer_hone_non_view_available_countries);
            arrayList.add(create4);
        }
        if (nativePageInfoEntity.centralDistrict != null && nativePageInfoEntity.centralDistrict.display == 1) {
            HomeNoServiceLazyView.ButtonInfo create5 = HomeNoServiceLazyView.ButtonInfo.create(nativePageInfoEntity.centralDistrict, new HomeNoServiceLazyView.BtnCallback() {
                public final void invoke(HomeNoServiceLazyView.ButtonInfo buttonInfo) {
                    HomeNoServiceLazyPresenter.this.m33454d(buttonInfo);
                }
            });
            create5.buttonText = ResourceHelper.getString(R.string.customer_hone_non_popular_business);
            arrayList.add(create5);
        }
        return arrayList;
    }
}
