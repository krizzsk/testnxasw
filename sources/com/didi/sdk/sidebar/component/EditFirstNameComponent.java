package com.didi.sdk.sidebar.component;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.event.DefaultEvent;
import com.didi.sdk.event.EventReceiver;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.http.BaseObject;
import com.didi.sdk.sidebar.account.model.UserSettingInfo;
import com.didi.sdk.sidebar.account.store.AccountStore;
import com.didi.sdk.sidebar.compatible.MsgAndEventUtil;
import com.didi.sdk.sidebar.compatible.SideBarAdapterReceiver;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.view.EditNameComponetView;
import com.didi.sdk.util.ToastHelper;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

@ComponentType(name = "account_edit_firt_name")
public class EditFirstNameComponent extends AbsComponent<EditNameComponetView> {

    /* renamed from: a */
    private Context f39913a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditNameComponetView f39914b;

    /* renamed from: c */
    private boolean f39915c;

    public EditFirstNameComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
        this.f39913a = baseBusinessContext.getContext();
        AccountStore.getInstance().registerReceiver(this);
    }

    /* access modifiers changed from: protected */
    public EditNameComponetView createComponentView() {
        if (this.f39914b == null) {
            this.f39914b = new EditNameComponetView(this.businessContext.getContext());
        }
        return this.f39914b;
    }

    /* access modifiers changed from: protected */
    public void initData(EditNameComponetView editNameComponetView) {
        editNameComponetView.setMaxLength(50);
        editNameComponetView.setNameDes(this.sidebarItem.getDes());
        editNameComponetView.setHint(TextUtils.isEmpty(this.sidebarItem.getName()) ? this.businessContext.getContext().getString(R.string.enter_name_hint) : this.sidebarItem.getName());
        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(this.businessContext.getContext());
        if (userInfo != null) {
            editNameComponetView.setName(userInfo.getFirst_name());
            Logger logger = LoggerFactory.getLogger("user_info_log");
            logger.info("first name = " + userInfo.getFirst_name(), new Object[0]);
        }
        editNameComponetView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    if (TextUtils.isEmpty(EditFirstNameComponent.this.f39914b.getName())) {
                        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(EditFirstNameComponent.this.businessContext.getContext());
                        if (userInfo != null && !TextUtils.isEmpty(userInfo.getFirst_name())) {
                            EditFirstNameComponent.this.f39914b.setName(userInfo.getFirst_name());
                            return;
                        }
                        return;
                    }
                    EditFirstNameComponent.this.m30044a();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30044a() {
        String str;
        if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
            UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(this.businessContext.getContext());
            UserSettingInfo userSettingInfo = new UserSettingInfo();
            userSettingInfo.firstName = this.f39914b.getName();
            if (!TextUtils.isEmpty(userSettingInfo.firstName)) {
                if (userInfo == null) {
                    str = "";
                } else {
                    str = userInfo.getLast_name();
                }
                userSettingInfo.lastName = str;
                Logger logger = LoggerFactory.getLogger("user_info_log");
                logger.info("EditFirstNameComponent first name  = " + userSettingInfo.firstName + " update last name = " + userSettingInfo.lastName, new Object[0]);
                AccountStore.getInstance().modifyAll((FragmentActivity) this.f39913a, userSettingInfo, false);
            }
        }
    }

    public String getName() {
        return this.f39914b.getName();
    }

    @EventReceiver
    public void onReceive(DefaultEvent defaultEvent) {
        if (!this.f39915c && defaultEvent != null) {
            String type = defaultEvent.getType();
            char c = 65535;
            if (type.hashCode() == 2110813523 && type.equals(AccountStore.ACTION_MODIFY_ALL_INFO)) {
                c = 0;
            }
            ModifyAllReceiver modifyAllReceiver = null;
            if (c == 0) {
                modifyAllReceiver = new ModifyAllReceiver();
            }
            if (modifyAllReceiver != null) {
                modifyAllReceiver.onReceive(MsgAndEventUtil.EventToMsg(defaultEvent));
            }
        }
    }

    private class ModifyAllReceiver implements SideBarAdapterReceiver {
        private ModifyAllReceiver() {
        }

        public void onReceive(Message message) {
            UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(EditFirstNameComponent.this.businessContext.getContext());
            if (userInfo != null) {
                int i = message.what;
                String str = "";
                if (i == 2 || i == 3) {
                    ToastHelper.showShortCompleted(EditFirstNameComponent.this.businessContext.getContext(), (int) R.string.send_faild);
                    EditNameComponetView a = EditFirstNameComponent.this.f39914b;
                    if (userInfo != null) {
                        str = userInfo.getFirst_name();
                    }
                    a.setName(str);
                } else if (i == 1102) {
                    if (message.obj == null || !(message.obj instanceof BaseObject)) {
                        ToastHelper.showShortCompleted(EditFirstNameComponent.this.businessContext.getContext(), (int) R.string.send_faild);
                    } else {
                        ToastHelper.showShortCompleted(EditFirstNameComponent.this.businessContext.getContext(), ((BaseObject) message.obj).errmsg);
                        OmegaSDKAdapter.trackEvent("tone_p_x_login_confm_firstname_toast");
                    }
                    EditNameComponetView a2 = EditFirstNameComponent.this.f39914b;
                    if (userInfo != null) {
                        str = userInfo.getFirst_name();
                    }
                    a2.setName(str);
                }
            }
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        super.onClick(view);
        HashMap hashMap = new HashMap();
        hashMap.put("city_id", NationTypeUtil.getNationComponentData().getCityId());
        hashMap.put("country_code", NationTypeUtil.getNationComponentData().getLocCountry());
        OmegaSDKAdapter.trackEvent("pas_profile_firstname_ck", (Map<String, Object>) hashMap);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f39915c = true;
    }
}
