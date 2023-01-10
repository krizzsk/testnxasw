package com.didi.global.flutter.usercenter;

import android.app.Activity;
import android.os.Bundle;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.core.IMSessionMessageListener;
import com.didi.beatles.p101im.module.IMSessionUnreadCallback;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.flutter.nacho.NachoFlutterFragment;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.event.DefaultEvent;
import com.didi.sdk.event.EventReceiver;
import com.didi.sdk.events.IMRefreshEvent;
import com.didi.sdk.oneconf.OneConfData;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.sidebar.account.store.AccountStore;
import com.didi.sdk.sidebar.compatible.MsgAndEventUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.usercenter.api.UserCenterFacade;
import com.didiglobal.usercenter.pax_usercenter_module.PaxUsercenterModulePlugin;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import p218io.flutter.plugin.common.MethodChannel;

public class UserCenterNachoFlutterFragment extends NachoFlutterFragment {

    /* renamed from: a */
    MethodChannel f23949a;

    /* renamed from: b */
    LoginListeners.LoginListener f23950b = new LoginListeners.LoginListener() {
        public void onCancel() {
        }

        public void onSuccess(Activity activity, String str) {
            if (UserCenterNachoFlutterFragment.this.f23949a != null) {
                UserCenterNachoFlutterFragment.this.f23949a.invokeMethod("updateProfile", (Object) null);
                UserCenterNachoFlutterFragment.this.f23949a.invokeMethod("updateDefaultData", (Object) null);
            }
        }
    };

    /* renamed from: c */
    LoginListeners.LoginOutListener f23951c = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            UserCenterFacade.getIns().clearUserInfo(UserCenterNachoFlutterFragment.this.getContext());
            if (UserCenterNachoFlutterFragment.this.f23949a != null) {
                UserCenterNachoFlutterFragment.this.f23949a.invokeMethod("updateProfile", (Object) null);
            }
        }
    };

    /* renamed from: e */
    private long f23952e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f23953f = OneConfStore.getInstance().getCityId();

    /* renamed from: g */
    private OneConfStore.OneConfConfigChangeListener f23954g = new OneConfStore.OneConfConfigChangeListener() {
        public void onChanged(OneConfData oneConfData, double d, double d2) {
            if (oneConfData != null && oneConfData.cityId != UserCenterNachoFlutterFragment.this.f23953f) {
                int unused = UserCenterNachoFlutterFragment.this.f23953f = oneConfData.cityId;
                if (UserCenterNachoFlutterFragment.this.f23949a != null) {
                    UserCenterNachoFlutterFragment.this.f23949a.invokeMethod("refreshUserCenterPage", (Object) null);
                }
            }
        }
    };

    /* renamed from: h */
    private IMSessionMessageListener f23955h = new IMSessionMessageListener() {
        public void onSessionMessageArrive(Set<Long> set) {
            UserCenterNachoFlutterFragment.this.m19397c();
        }
    };

    public void onResume() {
        super.onResume();
        GlobalOmegaUtils.trackEvent("ibt_gp_sa_account_page_sw", (Map<String, Object>) new HashMap());
        this.f23952e = System.currentTimeMillis();
        MethodChannel methodChannel = this.f23949a;
        if (methodChannel != null) {
            methodChannel.invokeMethod("refreshUserCenterPage", (Object) null);
            this.f23949a.invokeMethod("onResume", (Object) null);
        }
        m19397c();
    }

    public void onPause() {
        super.onPause();
        m19395a(System.currentTimeMillis() - this.f23952e);
    }

    /* renamed from: a */
    private void m19395a(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "notice");
        hashMap.put(RavenKey.VERSION, "staytime");
        hashMap.put("time", Long.valueOf(j));
        GlobalOmegaUtils.trackEvent("ibt_gp_sa_account_page_time_sw", (Map<String, Object>) hashMap);
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            m19395a(System.currentTimeMillis() - this.f23952e);
            OneConfStore.getInstance().removeOneConfChangeListener(this.f23954g);
            return;
        }
        this.f23952e = System.currentTimeMillis();
        GlobalOmegaUtils.putGlobal("g_PageId", "sa_account");
        OneConfStore.getInstance().addOneConfChangeListener(this.f23954g);
        MethodChannel methodChannel = this.f23949a;
        if (methodChannel != null) {
            methodChannel.invokeMethod("refreshUserCenterPage", (Object) null);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PaxUsercenterModulePlugin paxUsercenterModulePlugin = (PaxUsercenterModulePlugin) getFlutterEngine().getPlugins().get(PaxUsercenterModulePlugin.class);
        if (paxUsercenterModulePlugin != null) {
            this.f23949a = paxUsercenterModulePlugin.channel;
        }
        OneLoginFacade.getFunction().addLoginListener(this.f23950b);
        OneLoginFacade.getFunction().addLoginOutListener(this.f23951c);
        AccountStore.getInstance().register(this);
        EventBus.getDefault().register(this);
        GlobalOmegaUtils.putGlobal("g_PageId", "sa_account");
        IMEngine.getInstance(getContext());
        IMEngine.addSessionMessageListener(this.f23955h);
        OneConfStore.getInstance().addOneConfChangeListener(this.f23954g);
    }

    public void onDestroy() {
        super.onDestroy();
        OneLoginFacade.getFunction().removeLoginListener(this.f23950b);
        OneLoginFacade.getFunction().removeLoginOutListener(this.f23951c);
        AccountStore.getInstance().unregister(this);
        EventBus.getDefault().unregister(this);
        IMEngine.getInstance(getContext());
        IMEngine.removeSessionMessageListener(this.f23955h);
        OneConfStore.getInstance().removeOneConfChangeListener(this.f23954g);
    }

    @EventReceiver
    public void onReceive(DefaultEvent defaultEvent) {
        MethodChannel methodChannel;
        if (defaultEvent != null && UserCenterFacade.getIns().getUserInfo(getContext()) != null) {
            int i = MsgAndEventUtil.EventToMsg(defaultEvent).what;
            String type = defaultEvent.getType();
            char c = 65535;
            int hashCode = type.hashCode();
            if (hashCode != -619521077) {
                if (hashCode == 2110813523 && type.equals(AccountStore.ACTION_MODIFY_ALL_INFO)) {
                    c = 0;
                }
            } else if (type.equals(AccountStore.ACTION_MODIFY_USERAVATAR)) {
                c = 1;
            }
            if ((c == 0 || c == 1) && i == 1 && (methodChannel = this.f23949a) != null) {
                methodChannel.invokeMethod("updateProfile", (Object) null);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(IMRefreshEvent iMRefreshEvent) {
        m19397c();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m19397c() {
        IMEngine.getAllUnreadMessageCount(new IMSessionUnreadCallback() {
            public void unReadCount(int i) {
                if (UserCenterNachoFlutterFragment.this.f23949a != null) {
                    UserCenterNachoFlutterFragment.this.f23949a.invokeMethod("updateIMRedPoint", Integer.valueOf(i));
                }
            }
        });
    }
}
