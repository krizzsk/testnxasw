package com.didi.sdk.sidebar.component;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.event.DefaultEvent;
import com.didi.sdk.event.EventReceiver;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.sidebar.account.store.AccountStore;
import com.didi.sdk.sidebar.compatible.MsgAndEventUtil;
import com.didi.sdk.sidebar.configer.DidiPassSp;
import com.didi.sdk.sidebar.configer.SideBarConfiger;
import com.didi.sdk.sidebar.model.RedPoints;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.model.SidebarResponse;
import com.didi.sdk.sidebar.view.Nav2UserInfoComponentNewView;
import com.didi.sdk.util.EventKeys;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didi.usercenter.listener.UserInfoListener;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

public abstract class AbsNav2UserInfoComponent extends AbsComponent<Nav2UserInfoComponentNewView> {

    /* renamed from: a */
    private boolean f39900a;

    /* renamed from: b */
    private LoginListeners.LoginListener f39901b = new LoginListeners.LoginListener() {
        public void onCancel() {
        }

        public void onSuccess(Activity activity, String str) {
            LoggerFactory.getLogger("user_info_log").info("on login success", new Object[0]);
            AbsNav2UserInfoComponent.this.m30028a();
        }
    };

    /* renamed from: c */
    private UserInfoListener.InfoListener f39902c = new UserInfoListener.InfoListener() {
        public void onFailure() {
        }

        public void onGetInfo(UserInfo userInfo) {
            LoggerFactory.getLogger("user_info_log").info("onGetInfo...", new Object[0]);
            AbsNav2UserInfoComponent.this.m30028a();
        }
    };

    /* access modifiers changed from: protected */
    public abstract void setName(UserInfo userInfo);

    public AbsNav2UserInfoComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
        AccountStore.getInstance().registerReceiver(this);
        OneLoginFacade.getFunction().addLoginListener(this.f39901b);
        UserCenterFacade.getIns().addInfoListener(this.f39902c);
    }

    /* access modifiers changed from: protected */
    public void initData(Nav2UserInfoComponentNewView nav2UserInfoComponentNewView) {
        m30028a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30028a() {
        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(getView().getContext());
        String string = DidiPassSp.getIns(this.businessContext.getContext()).getString(SideBarConfiger.DIDI_PASS_DATA);
        SidebarResponse.GetProfile getProfile = !TextUtils.isEmpty(string) ? (SidebarResponse.GetProfile) new Gson().fromJson(string, SidebarResponse.GetProfile.class) : null;
        if (userInfo == null) {
            ((Nav2UserInfoComponentNewView) this.componentView).loadImage("", R.drawable.global_default_head);
            return;
        }
        m30030a(userInfo);
        setName(userInfo);
        if ((userInfo.getGradeInfo() != null || getProfile != null) && getProfile != null) {
            ((Nav2UserInfoComponentNewView) this.componentView).showDidiPass(getProfile);
        }
    }

    /* renamed from: a */
    private void m30030a(UserInfo userInfo) {
        if (!TextUtils.isEmpty(userInfo.getAvatar())) {
            ((Nav2UserInfoComponentNewView) this.componentView).loadImage(userInfo.getAvatar(), R.drawable.global_default_head);
        } else if (!TextUtils.isEmpty(userInfo.getHead_url())) {
            ((Nav2UserInfoComponentNewView) this.componentView).loadImage(userInfo.getHead_url(), R.drawable.global_default_head);
        } else {
            ((Nav2UserInfoComponentNewView) this.componentView).loadImage("", R.drawable.global_default_head);
        }
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public Nav2UserInfoComponentNewView createComponentView() {
        return new Nav2UserInfoComponentNewView(this.businessContext.getContext());
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.CLOSE_SIDEBAR));
        if (this.sidebarItem != null) {
            RedPoints redPoints = this.sidebarItem.getRedPoints();
            String traceEvent = this.sidebarItem.getTraceEvent();
            if (!TextUtils.isEmpty(traceEvent)) {
                HashMap hashMap = new HashMap();
                hashMap.put("redpoint", Integer.valueOf((redPoints == null || redPoints.getIsCLicked() != 0) ? 0 : 1));
                hashMap.put("city_id", NationTypeUtil.getNationComponentData().getCityId());
                hashMap.put("country_code", NationTypeUtil.getNationComponentData().getLocCountry());
                hashMap.put("is_login", 1);
                OmegaSDKAdapter.trackEvent(traceEvent, (Map<String, Object>) hashMap);
            }
        }
        super.onClick(view);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f39900a = true;
        AccountStore.getInstance().unregister(this);
        OneLoginFacade.getFunction().removeLoginListener(this.f39901b);
        UserCenterFacade.getIns().removeListener(this.f39902c);
    }

    @EventReceiver
    public void onReceive(DefaultEvent defaultEvent) {
        UserInfo userInfo;
        if (!this.f39900a && defaultEvent != null && (userInfo = UserCenterFacade.getIns().getUserInfo(this.businessContext.getContext())) != null) {
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
            if (c != 0) {
                if (c == 1 && i == 1) {
                    m30030a(userInfo);
                }
            } else if (i == 1) {
                setName(userInfo);
            }
        }
    }
}
