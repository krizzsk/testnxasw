package com.didi.entrega.customer.component.login;

import android.app.Activity;
import com.didi.entrega.customer.component.login.Contract;
import com.didi.entrega.customer.debug.CustomerToolBoxUtil;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.entity.LoginModel;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.entrega.customer.repo.LoginRepo;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import com.didi.foundation.sdk.login.LoginCallbacks;

public class LoginLogicPresenter extends Contract.AbsLoginLogicPresenter {

    /* renamed from: a */
    private static final String f21714a = "LoginLogicPresenter";

    /* renamed from: b */
    private static final int f21715b = 800;

    /* renamed from: c */
    private LoginCallbacks.LoginOutListener f21716c;

    /* renamed from: d */
    private LoginCallbacks.LoginListener f21717d;

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
        m18131a();
        m18132b();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LoginUtil.unRegisterLoginOutListener(this.f21716c);
        LoginUtil.unRegisterLoginListener(this.f21717d);
        this.f21717d = null;
        this.f21716c = null;
    }

    /* renamed from: a */
    private void m18131a() {
        if (this.f21716c == null) {
            this.f21716c = new LoginCallbacks.LoginOutListener() {
                public void onSuccess() {
                    UiHandlerUtil.postDelayed(new Runnable() {
                        public void run() {
                            LoginLogicPresenter.this.setLogin(false);
                            LoginLogicPresenter.this.getScopeContext().getNavigator().popToRoot();
                        }
                    }, 800);
                }
            };
        }
        LoginUtil.registerLoginOutListener(this.f21716c);
    }

    /* renamed from: b */
    private void m18132b() {
        if (this.f21717d == null) {
            this.f21717d = new LoginCallbacks.LoginListener() {
                public void onCancel() {
                    LoginUtil.updateLoginPopToRootStatus(true);
                }

                public void onSuccess(Activity activity, String str) {
                    LogUtil.m18185i(LoginLogicPresenter.f21714a, "LoginListener callback");
                    LoginUtil.isNewUser();
                    CustomerToolBoxUtil.setUserToken(LoginUtil.getToken());
                    CustomerRpcManagerProxy.get().changeLanguage(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag(), ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag(), new CustomerRpcCallback<Object>() {
                        public void onRpcSuccess(Object obj, long j) {
                        }
                    });
                    UiHandlerUtil.postDelayed(new Runnable() {
                        public void run() {
                            LoginLogicPresenter.this.setLogin(true);
                            if (LoginUtil.isNeedPopToRootStatus()) {
                                LoginLogicPresenter.this.getScopeContext().getNavigator().popToRoot();
                            }
                            LoginUtil.updateLoginPopToRootStatus(true);
                        }
                    }, 800);
                }
            };
        }
        LoginUtil.registerLoginListener(this.f21717d);
    }
}
