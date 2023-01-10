package com.didi.unifylogin.third;

import android.content.Context;
import android.text.TextUtils;
import com.didi.thirdpartylogin.base.ThirdPartyLoginListener;
import com.didi.unifylogin.api.LoginActionApi;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.AuthParam;
import com.didi.unifylogin.base.net.pojo.response.AuthResponse;
import com.didi.unifylogin.flutter.LoginLogicManager;
import com.didi.unifylogin.flutter.Result;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.NetworkUtil;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import p218io.flutter.plugin.common.MethodChannel;

public class ThirdPartyLoginHandler implements ThirdPartyLoginListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f47557a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final MethodChannel.Result f47558b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f47559c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FragmentMessenger f47560d = LoginLogicManager.getMessenger();

    public ThirdPartyLoginHandler(Context context, String str, MethodChannel.Result result) {
        this.f47557a = context;
        this.f47558b = result;
        this.f47559c = str;
    }

    public void onSucess(final String str, String str2) {
        String reasonOfFirstInstall = ListenerManager.getFirstInstallListener() != null ? ListenerManager.getFirstInstallListener().reasonOfFirstInstall() : null;
        FragmentMessenger messenger = LoginLogicManager.getMessenger();
        this.f47560d = messenger;
        AuthParam idToken = new AuthParam(this.f47557a, messenger.getSceneNum()).setAuthChannel(this.f47559c).setIdToken(str);
        if (TextUtils.isEmpty(reasonOfFirstInstall)) {
            reasonOfFirstInstall = LoginActionApi.loginReason;
        }
        LoginModel.getFlutterNet(this.f47557a).signByAuth(idToken.setSignReason(reasonOfFirstInstall), new LoginRpcCallbackV2<AuthResponse>() {
            public void onSuccess(RpcResponseProxy<AuthResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                if (rpcResponseProxy == null || rpcResponseProxy.getContent() == null) {
                    ThirdPartyLoginHandler.this.m35689a((Object) Result.error());
                    return;
                }
                AuthResponse content = rpcResponseProxy.getContent();
                ThirdPartyLoginHandler.this.f47560d.setChannel(ThirdPartyLoginHandler.this.f47559c);
                ThirdPartyLoginHandler.this.f47560d.setLoginMethod(ThirdPartyLoginHandler.this.f47559c);
                ThirdPartyLoginHandler.this.f47560d.setScene(LoginScene.SCENE_THIRD_LOGIN);
                int i = content.errno;
                if (i == 0) {
                    ThirdPartyLoginHandler.this.f47560d.updateOmegaScene(LoginScene.SCENE_THIRD_LOGIN);
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_USERENTER).send();
                    if (!TextUtils.isEmpty(content.email)) {
                        ThirdPartyLoginHandler.this.f47560d.setHideEmail(content.email);
                    }
                    if (!TextUtils.isEmpty(content.credential)) {
                        ThirdPartyLoginHandler.this.f47560d.setCredential(content.credential);
                    }
                    ThirdPartyLoginHandler.this.f47560d.setCell(content.cell);
                    new LoginLogicManager(ThirdPartyLoginHandler.this.f47557a).handToken(content, ThirdPartyLoginHandler.this.f47558b);
                } else if (i != 41011) {
                    if (TextUtils.isEmpty(content.error)) {
                        content.error = ThirdPartyLoginHandler.this.f47557a.getString(R.string.login_unify_net_error);
                    }
                    LoginOmegaUtil.trackLoginErrorEvent(2, content.error, content.errno == -1 ? rpcResponseProxy.getStatus() : content.errno, NetworkUtil.getHeader(rpcResponseProxy.getHeaders(), "didi-header-rid"), "signByAuth", (String) null);
                    ThirdPartyLoginHandler.this.m35689a((Object) Result.from(content));
                } else {
                    ThirdPartyLoginHandler.this.f47560d.setAuthInfo(content.data);
                    ThirdPartyLoginHandler.this.f47560d.setIdtoken(str);
                    ThirdPartyLoginHandler.this.f47560d.updateOmegaScene(LoginScene.SCENE_THIRD_LOGIN);
                    new LoginLogicManager(ThirdPartyLoginHandler.this.f47557a).transform(LoginState.STATE_BIND_THIRD_PHONE);
                    ThirdPartyLoginHandler.this.m35689a((Object) Result.m35294ok());
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                LoginOmegaUtil.trackLoginErrorEvent(0, (String) null, -1, "", "signByAuth", (String) null);
                ThirdPartyLoginHandler thirdPartyLoginHandler = ThirdPartyLoginHandler.this;
                thirdPartyLoginHandler.m35689a((Object) Result.error(thirdPartyLoginHandler.f47557a.getString(R.string.login_unify_third_party_get_token_error)));
            }
        });
    }

    public void onFailure(Exception exc) {
        m35689a((Object) Result.error(this.f47557a.getString(R.string.login_unify_third_party_get_token_error)));
        new LoginOmegaUtil(LoginOmegaUtil.TECH_PAX_EVENT_THIRD_PARTY_TOKEN_ERROR).add("module", this.f47559c).add("err_type", 6).add("err_msg", exc.getMessage()).send();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35689a(Object obj) {
        try {
            this.f47558b.success(obj);
        } catch (Exception unused) {
        }
    }
}
