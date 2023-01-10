package com.didi.component.comp_xpanel.presenter;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.constant.BaseConstants;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationUtils;
import com.didi.component.comp_xpanel.AbsGlobalXPanelPresenter;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.component.comp_xpanel.view.GlobalHomeXPanelView;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.misconfig.p154v2.SecondConfProxy;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.taxis99.R;

public class GlobalXPanelHomePresenter extends AbsGlobalXPanelPresenter<GlobalHomeXPanelView> {

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14378a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            GlobalXPanelHomePresenter.this.m11916c();
        }
    };

    /* renamed from: b */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14379b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            GlobalXPanelHomePresenter.this.m11915b();
        }
    };

    /* renamed from: c */
    private boolean f14380c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f14381d;

    /* renamed from: e */
    private boolean f14382e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f14383f = false;

    /* renamed from: g */
    private LoginListeners.LoginOutListener f14384g = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            if (GlobalXPanelHomePresenter.this.f14381d) {
                boolean unused = GlobalXPanelHomePresenter.this.f14383f = false;
                GlobalXPanelHomePresenter.this.loadAgentData();
                return;
            }
            boolean unused2 = GlobalXPanelHomePresenter.this.f14383f = true;
        }
    };

    /* renamed from: h */
    private BaseEventPublisher.OnEventListener<Integer> f14385h = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.Service.EVENT_DESTINATION_HEIGHT) && num != null) {
                int intValue = num.intValue();
                GLog.m11359i("GlobalXPanelHomePresenter, event_destination_height： " + intValue);
                ((GlobalHomeXPanelView) GlobalXPanelHomePresenter.this.mView).getXPanel().checkShowCardHeight(intValue);
            }
        }
    };

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener f14386i = new BaseEventPublisher.OnEventListener<BaseObject>() {
        public void onEvent(String str, BaseObject baseObject) {
            GlobalXPanelHomePresenter.this.refreshAgentData();
        }
    };

    /* renamed from: j */
    private BaseEventPublisher.OnEventListener f14387j = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            GlobalXPanelHomePresenter.this.m11915b();
        }
    };

    public String getDimension() {
        return "home";
    }

    public void loadAgentData() {
    }

    public void loadError(com.didichuxing.xpanel.agent.net.BaseObject baseObject) {
    }

    public void refreshAgentData() {
    }

    public final void refreshAgentDataOnPageResume() {
    }

    public GlobalXPanelHomePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mBizCtx = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f14382e = false;
        this.f14381d = true;
        loadDefaultCards(bundle);
        this.f14380c = true;
        commit();
        subscribe(BaseEventKeys.Order.BIZ_ERROR, this.f14386i);
        subscribe(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET, this.f14387j);
        subscribe(BaseEventKeys.Home.HIDE_HOME_DESTINATION, this.f14378a);
        subscribe(BaseEventKeys.Home.CHECK_HOME_DESTINATION, this.f14379b);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.Service.EVENT_DESTINATION_HEIGHT, this.f14385h);
        OneLoginFacade.getFunction().addLoginOutListener(this.f14384g);
        loadAgentData();
        m11915b();
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        if (this.f14381d) {
            if (!this.f14380c) {
                refreshAgentDataOnPageResume();
            }
            this.f14380c = false;
            ((GlobalHomeXPanelView) this.mView).show();
        }
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        this.f14381d = false;
        SystemUtils.log(4, "Home_XPanel", "onLeaveHome", (Throwable) null, "com.didi.component.comp_xpanel.presenter.GlobalXPanelHomePresenter", 146);
        ((GlobalHomeXPanelView) this.mView).hide();
        unsubscribe(BaseEventKeys.XPanel.EVENT_REQUEST_SHOW, this.mRequestShowEventListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_REQUEST_HIDE, this.mRequestHideEventListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT, this.mRequestDefaultHeight);
        unsubscribe(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_SCROLL_HEIGHT, this.mRequestDefaultScrollHeight);
        unsubscribe(BaseEventKeys.Order.BIZ_ERROR, this.f14386i);
        BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.Service.EVENT_DESTINATION_HEIGHT);
        BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.Service.EndService.EVENT_BACK_TO_HOME_FROM_END_SERVICE);
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        RecyclerView recyclerView;
        super.onBackHome(bundle);
        this.f14381d = true;
        SystemUtils.log(4, "Home_XPanel", "onBackHome", (Throwable) null, "com.didi.component.comp_xpanel.presenter.GlobalXPanelHomePresenter", 161);
        subscribe(BaseEventKeys.XPanel.EVENT_REQUEST_SHOW, this.mRequestShowEventListener);
        subscribe(BaseEventKeys.XPanel.EVENT_REQUEST_HIDE, this.mRequestHideEventListener);
        subscribe(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT, this.mRequestDefaultHeight);
        subscribe(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_SCROLL_HEIGHT, this.mRequestDefaultScrollHeight);
        subscribe(BaseEventKeys.Order.BIZ_ERROR, this.f14386i);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.Service.EVENT_DESTINATION_HEIGHT, this.f14385h);
        this.f14382e = bundle.getBoolean(BaseConstants.NormalFinishTrip.NORMAL_FINISH_THE_TRIP, false);
        bundle.getString(BaseConstants.NormalFinishTrip.LAST_ORDER_PARENT_SID, "-1");
        bundle.remove(BaseConstants.NormalFinishTrip.NORMAL_FINISH_THE_TRIP);
        bundle.remove(BaseConstants.NormalFinishTrip.LAST_ORDER_PARENT_SID);
        BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.Service.EndService.EVENT_BACK_TO_HOME_FROM_END_SERVICE);
        BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.Service.EndService.EVENT_BACK_TO_HOME_FROM_END_SERVICE, new Boolean(this.f14382e));
        if (this.f14383f) {
            this.f14383f = false;
            loadAgentData();
        } else {
            refreshAgentData();
        }
        ((GlobalHomeXPanelView) this.mView).show();
        if (((GlobalHomeXPanelView) this.mView).getView() != null && (((GlobalHomeXPanelView) this.mView).getView().findViewById(R.id.oc_x_panel_list) instanceof RecyclerView) && (recyclerView = (RecyclerView) ((GlobalHomeXPanelView) this.mView).getView().findViewById(R.id.oc_x_panel_list)) != null && recyclerView.getAdapter() != null) {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    public void doXPanelMoveChange(int i) {
        if (this.f14381d) {
            super.doXPanelMoveChange(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.f14381d = false;
        this.f14382e = false;
        unsubscribe(BaseEventKeys.XPanel.EVENT_REQUEST_SHOW, this.mRequestShowEventListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_REQUEST_HIDE, this.mRequestHideEventListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT, this.mRequestDefaultHeight);
        unsubscribe(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_SCROLL_HEIGHT, this.mRequestDefaultScrollHeight);
        unsubscribe(BaseEventKeys.Order.BIZ_ERROR, this.f14386i);
        unsubscribe(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET, this.f14387j);
        unsubscribe(BaseEventKeys.Home.HIDE_HOME_DESTINATION, this.f14378a);
        unsubscribe(BaseEventKeys.Home.CHECK_HOME_DESTINATION, this.f14379b);
        BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.Service.EVENT_DESTINATION_HEIGHT);
        BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.Service.EndService.EVENT_BACK_TO_HOME_FROM_END_SERVICE);
        OneLoginFacade.getFunction().removeLoginOutListener(this.f14384g);
    }

    public final String getRequestTag() {
        return this.f14382e ? XPanelScene.SCENE_END_TO_HOME : "home";
    }

    /* access modifiers changed from: protected */
    public String[] getDefaultCards() {
        if (GlobalApolloUtil.isHomeEngine()) {
            return new String[]{ComponentType.HOME_PANEL};
        }
        return new String[]{ComponentType.UNENABLE_CITY, ComponentType.HOME_DESTINATION};
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11915b() {
        if ((this.mBizCtx == null || (SecondConfProxy.getInstance().isCityOpen(this.mBizCtx.getBusinessGroupType()) && !BusinessUtils.isPreHeat(this.mBizCtx))) && !FormStore.getInstance().isSafetyTrain() && !FormStore.getInstance().isOrderBan() && (this.mContext == null || LocationUtils.parseLocation(this.mContext) == 0)) {
            m11918d();
        } else {
            m11916c();
        }
        commit();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m11916c() {
        setVisibilityByType(ComponentType.HOME_DESTINATION, false);
        commit();
    }

    /* renamed from: d */
    private void m11918d() {
        setVisibilityByType(ComponentType.HOME_DESTINATION, true);
        commit();
    }
}
