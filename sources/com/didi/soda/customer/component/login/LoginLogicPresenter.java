package com.didi.soda.customer.component.login;

import android.app.Activity;
import com.didi.foundation.sdk.login.LoginCallbacks;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.biz.popdialog.HomePopConfigRepo;
import com.didi.soda.customer.biz.popdialog.natived.PopDialogHelper;
import com.didi.soda.customer.component.login.Contract;
import com.didi.soda.customer.debug.CustomerToolBoxUtil;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.LoginModel;
import com.didi.soda.customer.foundation.rpc.entity.NAPopUpParamsEntity;
import com.didi.soda.customer.foundation.rpc.entity.UserInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.tracker.AppsFlyerTrackHelper;
import com.didi.soda.customer.foundation.tracker.FirebaseAnalyticsHelper;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.p165h5.CustomerTransparentWebPage;
import com.didi.soda.customer.repo.LoginRepo;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.soda.customer.service.IOneSdkService;
import com.didi.soda.globalcart.repo.GlobalCartListRepo;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.search.storage.SearchHistoryStorage;

public class LoginLogicPresenter extends Contract.AbsLoginLogicPresenter {

    /* renamed from: a */
    private static final String f43401a = "LoginLogicPresenter";

    /* renamed from: b */
    private static final int f43402b = 800;

    /* renamed from: c */
    private LoginCallbacks.LoginOutListener f43403c;

    /* renamed from: d */
    private LoginCallbacks.LoginListener f43404d;

    public void setLogin(boolean z) {
        LoginModel value = ((LoginRepo) RepoFactory.getRepo(LoginRepo.class)).getValue();
        value.setLogin(z);
        if (z) {
            value.setToken(LoginUtil.getToken());
        } else {
            value.setToken((String) null);
        }
        ((LoginRepo) RepoFactory.getRepo(LoginRepo.class)).setValue(value);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m32488a();
        m32492b();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LoginUtil.unRegisterLoginOutListener(this.f43403c);
        LoginUtil.unRegisterLoginListener(this.f43404d);
        this.f43404d = null;
        this.f43403c = null;
    }

    /* renamed from: a */
    private void m32488a() {
        if (this.f43403c == null) {
            this.f43403c = new LoginCallbacks.LoginOutListener() {
                public void onSuccess() {
                    UiHandlerUtil.postDelayed(new Runnable() {
                        public void run() {
                            LoginLogicPresenter.this.setLogin(false);
                            new SearchHistoryStorage().setData(null);
                            LoginLogicPresenter.this.m32489a(3);
                            LoginLogicPresenter.this.m32493c();
                            ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).clearAllOrdersInMonitor();
                            if (!GlobalContext.containsPage(CustomerTransparentWebPage.class)) {
                                LoginLogicPresenter.this.getScopeContext().getNavigator().popToRoot();
                            }
                            ((GlobalCartListRepo) RepoFactory.getRepo(GlobalCartListRepo.class)).setValue(null);
                        }
                    }, 800);
                }
            };
        }
        LoginUtil.registerLoginOutListener(this.f43403c);
    }

    /* renamed from: b */
    private void m32492b() {
        if (this.f43404d == null) {
            this.f43404d = new LoginCallbacks.LoginListener() {
                public void onCancel() {
                    LoginUtil.updateLoginPopToRootStatus(true);
                }

                public void onSuccess(Activity activity, String str) {
                    LogUtil.m32588i(LoginLogicPresenter.f43401a, "LoginListener callback");
                    if (LoginUtil.isNewUser()) {
                        AppsFlyerTrackHelper.trackSignup(LoginLogicPresenter.this.getContext());
                        FirebaseAnalyticsHelper.trackSignup(LoginLogicPresenter.this.getContext());
                    } else {
                        AppsFlyerTrackHelper.trackLogin(LoginLogicPresenter.this.getContext());
                        FirebaseAnalyticsHelper.trackLogin(LoginLogicPresenter.this.getContext());
                    }
                    CustomerToolBoxUtil.setUserToken(LoginUtil.getToken());
                    final boolean isLoginFetchHomePop = ((HomePopConfigRepo) RepoFactory.getRepo(HomePopConfigRepo.class)).isLoginFetchHomePop();
                    CustomerRpcManagerProxy.get().changeLanguage(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag(), ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag(), new CustomerRpcCallback<Object>() {
                        public void onRpcSuccess(Object obj, long j) {
                        }
                    });
                    UiHandlerUtil.postDelayed(new Runnable() {
                        public void run() {
                            LoginLogicPresenter.this.setLogin(true);
                            ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshTab();
                            LoginLogicPresenter.this.m32489a(2);
                            LoginLogicPresenter.this.m32493c();
                            if (!GlobalContext.containsPage(CustomerTransparentWebPage.class) && LoginUtil.isNeedPopToRootStatus()) {
                                LoginLogicPresenter.this.getScopeContext().getNavigator().popToRoot();
                            }
                            LoginUtil.updateLoginPopToRootStatus(true);
                            if (isLoginFetchHomePop) {
                                NAPopUpParamsEntity nAPopUpParamsEntity = new NAPopUpParamsEntity();
                                nAPopUpParamsEntity.position = 3;
                                PopDialogHelper.triggerNAPopFetch(nAPopUpParamsEntity);
                            }
                        }
                    }, 800);
                }
            };
        }
        LoginUtil.registerLoginListener(this.f43404d);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32489a(int i) {
        if (i == 3) {
            ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).clearDeliveryAddress();
        }
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).locateThenRefreshHome(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m32493c() {
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.phone = LoginUtil.getPhone();
        contactEntity.callingCode = LoginUtil.getCallingCode();
        contactEntity.countryId = LoginUtil.getCountryId();
        contactEntity.lastModifyFrom = 1;
        UserInfoEntity userInfo = ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).getUserInfo();
        if (userInfo != null) {
            contactEntity.setName(userInfo.firstName, userInfo.lastName);
        }
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).setCurrentContact(contactEntity);
    }
}
