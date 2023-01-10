package com.didi.unifylogin.externalfunction;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.SignOffParam;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import java.io.IOException;
import java.util.Iterator;

public class LogoutManager {

    /* renamed from: a */
    private final Context f47427a;

    /* renamed from: b */
    private final String f47428b;

    /* renamed from: c */
    private String f47429c;

    /* renamed from: d */
    private String f47430d;

    public LogoutManager(Context context, String str) {
        this.f47427a = context;
        this.f47428b = str;
    }

    public void activeLogout() {
        m35281a(false, true);
    }

    public void passiveLogout(String str, String str2) {
        this.f47429c = str;
        this.f47430d = str2;
        m35281a(false, false);
    }

    public void silenceLogout() {
        m35281a(true, true);
    }

    /* renamed from: a */
    private void m35281a(boolean z, final boolean z2) {
        if (OneLoginFacade.getStore().isLoginNow()) {
            SignOffParam ticket = new SignOffParam(this.f47427a, LoginScene.SCENE_LOGINOUT.getSceneNum()).setTicket(LoginStore.getInstance().getToken());
            if (!TextUtils.isEmpty(this.f47428b)) {
                ticket.setSignReason(this.f47428b);
            }
            LoginModel.getNet(this.f47427a).signOff(ticket, new LoginRpcCallbackV2<BaseResponse>() {
                public void onSuccess(RpcResponseProxy<BaseResponse> rpcResponseProxy) {
                    super.onSuccess(rpcResponseProxy);
                    LogoutManager.this.m35279a(rpcResponseProxy.getContent().errno, z2);
                }

                public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                    super.onFailure(rpcRequest, iOException);
                    LogoutManager.this.m35279a(-1, z2);
                }
            });
            LoginStore.getInstance().loginOutClean();
            if (!z) {
                Iterator<LoginListeners.LoginOutListener> it = ListenerManager.getLoginOutListeners().iterator();
                while (it.hasNext()) {
                    it.next().onSuccess();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35279a(int i, boolean z) {
        LoginOmegaUtil loginOmegaUtil;
        if (z) {
            loginOmegaUtil = new LoginOmegaUtil(LoginOmegaUtil.TECH_PASSPORT_LOGOUT_POSITIVE);
        } else {
            loginOmegaUtil = new LoginOmegaUtil(LoginOmegaUtil.TECH_PASSPORT_LOGOUT_KICK);
            loginOmegaUtil.add("url", this.f47429c);
            loginOmegaUtil.add("trace", this.f47430d);
        }
        loginOmegaUtil.add("errno", Integer.valueOf(i));
        loginOmegaUtil.add("reason", this.f47428b);
        loginOmegaUtil.send();
    }
}
