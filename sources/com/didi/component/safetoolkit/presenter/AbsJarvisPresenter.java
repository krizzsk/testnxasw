package com.didi.component.safetoolkit.presenter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.TypedValue;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.sharetrip.CommonTripShareManager;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.event.UpdateJarvisEvent;
import com.didi.component.safetoolkit.views.IJarvisView;
import com.didi.component.safetoolkit.views.JarvisBeforeAcceptedFragment;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didi.sdk.misconfig.p154v2.SecondConfProxy;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.taxis99.R;
import org.json.JSONObject;

public abstract class AbsJarvisPresenter extends IPresenter<IJarvisView> {
    public static Object sGPageId;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f17216a = "";
    protected BaseEventPublisher.OnEventListener<Boolean> alphaListener = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            ((IJarvisView) AbsJarvisPresenter.this.mView).setJarvisDismissedByAlpha(bool.booleanValue());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f17217b;

    /* renamed from: c */
    private int f17218c;

    /* renamed from: d */
    private float f17219d = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CommonTripShareManager f17220e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public JarvisBeforeAcceptedFragment f17221f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f17222g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f17223h;

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener f17224i = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.SafeToolkit.EVENT_REQUEST_JARVIS.equals(str)) {
                AbsJarvisPresenter.this.requestJarvisStatus();
            }
        }
    };

    /* renamed from: j */
    private BaseEventPublisher.OnEventListener<UpdateJarvisEvent> f17225j = new BaseEventPublisher.OnEventListener<UpdateJarvisEvent>() {
        public void onEvent(String str, UpdateJarvisEvent updateJarvisEvent) {
            if ("event_update_jarvis".equals(str) && updateJarvisEvent != null) {
                AbsJarvisPresenter.this.requestJarvisStatus(updateJarvisEvent.openManualRecord);
            }
        }
    };

    /* renamed from: k */
    private BaseEventPublisher.OnEventListener f17226k = new BaseEventPublisher.OnEventListener<Float>() {
        public void onEvent(String str, Float f) {
            if (BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA.equals(str)) {
                ((IJarvisView) AbsJarvisPresenter.this.mView).getView().setAlpha(f.floatValue());
            }
        }
    };

    /* renamed from: l */
    private BaseEventPublisher.OnEventListener<Integer> f17227l = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if ("home".equals(AbsJarvisPresenter.this.getPage())) {
                AbsJarvisPresenter absJarvisPresenter = AbsJarvisPresenter.this;
                int intValue = num.intValue();
                int intValue2 = num.intValue();
                if (intValue != 0) {
                    intValue2 += AbsJarvisPresenter.this.mContext.getResources().getDimensionPixelOffset(R.dimen._10dip);
                }
                int unused = absJarvisPresenter.f17222g = intValue2;
                AbsJarvisPresenter absJarvisPresenter2 = AbsJarvisPresenter.this;
                final int newHeightWithUIOffset = absJarvisPresenter2.getNewHeightWithUIOffset(absJarvisPresenter2.f17217b);
                if (AbsJarvisPresenter.this.mComponentParams.bizCtx == null || SecondConfProxy.getInstance().isCityOpen(AbsJarvisPresenter.this.mComponentParams.bizCtx.getBusinessGroupType())) {
                    int bizBarHeight = AbsJarvisPresenter.this.mComponentParams.bizCtx.getBizBarHeight();
                    ((IJarvisView) AbsJarvisPresenter.this.mView).setTranslationY(((-newHeightWithUIOffset) - bizBarHeight) - AbsJarvisPresenter.this.f17222g);
                    GLog.m11356e("lxsJarvis:marginBottom" + newHeightWithUIOffset + ", bizBarHeight" + bizBarHeight + ", mXBannerHeight" + AbsJarvisPresenter.this.f17222g);
                    return;
                }
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        if (AbsJarvisPresenter.this.mComponentParams != null && AbsJarvisPresenter.this.mComponentParams.bizCtx != null) {
                            int bizBarHeight = AbsJarvisPresenter.this.mComponentParams.bizCtx.getBizBarHeight();
                            ((IJarvisView) AbsJarvisPresenter.this.mView).setTranslationY(((-newHeightWithUIOffset) - bizBarHeight) - AbsJarvisPresenter.this.f17222g);
                            GLog.m11356e("lxsJarvis:finalNewHeight" + newHeightWithUIOffset + ", bizBarHeight" + bizBarHeight + ", mXBannerHeight" + AbsJarvisPresenter.this.f17222g);
                        }
                    }
                }, 1000);
            }
        }
    };

    /* renamed from: m */
    private BaseEventPublisher.OnEventListener f17228m = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                Activity activity = AbsJarvisPresenter.this.mComponentParams.getActivity();
                if (activity instanceof FragmentActivity) {
                    JarvisBeforeAcceptedFragment unused = AbsJarvisPresenter.this.f17221f = JarvisBeforeAcceptedFragment.newInstance();
                    AbsJarvisPresenter.this.f17221f.show(((FragmentActivity) activity).getSupportFragmentManager(), "jarvis_share_before_accepted");
                    return;
                }
                return;
            }
            if (AbsJarvisPresenter.this.f17220e != null) {
                AbsJarvisPresenter.this.f17220e.disMissOneKeyShareDialog();
            }
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null) {
                if (AbsJarvisPresenter.this.f17220e == null) {
                    CommonTripShareManager unused2 = AbsJarvisPresenter.this.f17220e = new CommonTripShareManager();
                }
                if (AbsJarvisPresenter.this.mComponentParams != null) {
                    AbsJarvisPresenter.this.f17220e.showShareDialog(AbsJarvisPresenter.this.mComponentParams.getActivity(), order.oid, order.productid);
                    return;
                }
                GLog.m11357e("global_share", "componentParams is null");
                return;
            }
            GLog.m11357e("global_share", "carOrder is null");
        }
    };
    protected ComponentParams mComponentParams;
    protected BaseEventPublisher.OnEventListener mMonitorStatusChanged = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsJarvisPresenter.this.requestJarvisStatus();
        }
    };
    protected BaseEventPublisher.OnEventListener mOnEventListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED)) {
                GLog.m11354d("lxsXpanelCb", "receive:" + num + AbsJarvisPresenter.this.toString());
                AbsJarvisPresenter.this.onXPanelDefaultHeightChanged(num.intValue());
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mOnScrollEventListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER)) {
                GLog.m11354d("lxsXpanelCb", "biz: " + num);
                AbsJarvisPresenter.this.onXPanelScrollChanged(num.intValue());
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mRealTimeMonitorListener = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            String str3;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                JSONObject optJSONObject = jSONObject.optJSONObject("trip_monitor_push");
                if (optJSONObject != null) {
                    optJSONObject.optInt("level");
                    optJSONObject.optString("push_id");
                    optJSONObject.optString(ParamKeys.PARAM_DISTRICT);
                    str3 = optJSONObject.optString("text");
                } else {
                    str3 = "";
                }
                jSONObject.optString("order_id");
                NotificationUtils.getInstance(AbsJarvisPresenter.this.mContext).showNotification("", str3);
                AbsJarvisPresenter.this.requestJarvisStatus();
                GLog.m11360i("mRealTimeMonitorListener", "receive warning push:" + str3);
            } catch (Exception e) {
                GLog.m11360i("mRealTimeMonitorListener", e.getMessage());
            }
        }
    };

    /* renamed from: n */
    private LoginListeners.LoginOutListener f17229n = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            ((IJarvisView) AbsJarvisPresenter.this.mView).closeSafePanel();
            if (AbsJarvisPresenter.this.f17221f != null) {
                AbsJarvisPresenter.this.f17221f.dismissAllowingStateLoss();
            }
            ((IJarvisView) AbsJarvisPresenter.this.mView).setJarvisData((SfJarvisData) null);
            String unused = AbsJarvisPresenter.this.f17216a = "";
        }
    };

    /* renamed from: p */
    private BroadcastReceiver f17230p = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                GLog.m11360i("mActionChangedReceiver", "action:" + action);
                if (action != null) {
                    char c = 65535;
                    switch (action.hashCode()) {
                        case -1698865573:
                            if (action.equals("sf_emergency_assist_on")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1217465591:
                            if (action.equals("sf_share_failed")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1125225357:
                            if (action.equals("sf_emergency_assist_off")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 132692663:
                            if (action.equals("sf_share_success")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 2062997172:
                            if (action.equals(BaseEventKeys.SafeToolkit.ACTION_UPDATE_SAFETY_SWITCH)) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    if (c == 0) {
                        ToastHelper.showShortInfo(AbsJarvisPresenter.this.mContext, (int) R.string.sf_jarvis_share_suc);
                        AbsJarvisPresenter.this.requestJarvisStatus();
                    } else if (c == 1) {
                        ToastHelper.showShortInfo(AbsJarvisPresenter.this.mContext, (int) R.string.sf_jarvis_share_fail);
                        AbsJarvisPresenter.this.requestJarvisStatus();
                    } else if (c == 2) {
                        AbsJarvisPresenter.this.requestJarvisStatus();
                    } else if (c == 3) {
                        GlobalSPUtil.setSFIsReportingPolice(AbsJarvisPresenter.this.mContext, true);
                        AbsJarvisPresenter.this.requestJarvisStatus();
                    } else if (c != 4) {
                        AbsJarvisPresenter.this.requestJarvisStatus();
                    } else {
                        GlobalSPUtil.setSFIsReportingPolice(AbsJarvisPresenter.this.mContext, false);
                        AbsJarvisPresenter.this.requestJarvisStatus();
                    }
                }
            }
        }
    };

    /* renamed from: q */
    private BaseEventPublisher.OnEventListener<Boolean> f17231q = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                int unused = AbsJarvisPresenter.this.f17223h = 1;
            } else {
                int unused2 = AbsJarvisPresenter.this.f17223h = 0;
            }
            AbsJarvisPresenter.this.requestJarvisStatus();
        }
    };

    /* renamed from: r */
    private BffResponseListener<SfJarvisData> f17232r = new BffResponseListener<SfJarvisData>() {
        public void onFinish(SfJarvisData sfJarvisData) {
            super.onFinish(sfJarvisData);
            if (sfJarvisData == null || sfJarvisData.errno != 0) {
                ((IJarvisView) AbsJarvisPresenter.this.mView).setJarvisData((SfJarvisData) null);
                String unused = AbsJarvisPresenter.this.f17216a = "";
            } else if (AbsJarvisPresenter.this.f17216a != null && AbsJarvisPresenter.this.f17216a.equals(sfJarvisData.dataVer)) {
            } else {
                if (sfJarvisData.bubbles != null || sfJarvisData.banner != null || sfJarvisData.menus != null || sfJarvisData.timeline != null) {
                    ((IJarvisView) AbsJarvisPresenter.this.mView).setJarvisData(sfJarvisData);
                    String unused2 = AbsJarvisPresenter.this.f17216a = sfJarvisData.dataVer;
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public abstract String getPage();

    public AbsJarvisPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mComponentParams = componentParams;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        register();
        this.f17219d = TypedValue.applyDimension(1, 4.0f, this.mContext.getResources().getDisplayMetrics());
        doPublish(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT);
        doPublish(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_SCROLL_HEIGHT);
        GLog.m11354d("lxsXpanelCb", "onAdd: " + toString());
    }

    /* access modifiers changed from: protected */
    public void register() {
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, this.f17226k);
        subscribe("event_record_status_changed", this.f17231q);
        subscribe(BaseEventKeys.Push.EVENT_ON_SERVICE_MONITOR_TRIGGER, this.mRealTimeMonitorListener);
        subscribe(BaseEventKeys.SafeToolkit.EVENT_MONITOR_STATUS_CHANGED, this.mMonitorStatusChanged);
        subscribe("event_Share_before_accepted", this.f17228m);
        subscribe(BaseEventKeys.SafeToolkit.EVENT_REQUEST_JARVIS, this.f17224i);
        subscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f17227l);
        subscribe(BaseEventKeys.SafeToolkit.EVENT_TRIP_END_DISMISS_WHEN_PAYING, this.alphaListener);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("sf_emergency_assist_on");
        intentFilter.addAction("sf_emergency_assist_off");
        intentFilter.addAction("sf_share_success");
        intentFilter.addAction("sf_share_failed");
        intentFilter.addAction("sf_start_share");
        intentFilter.addAction("sf_add_contacts_fail");
        intentFilter.addAction("sf_add_contacts_success");
        intentFilter.addAction("sf_delete_contacts_fail");
        intentFilter.addAction("sf_delete_contacts_success");
        intentFilter.addAction(BaseEventKeys.SafeToolkit.ACTION_UPDATE_SAFETY_SWITCH);
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.f17230p, intentFilter);
        OneLoginFacade.getFunction().addLoginOutListener(this.f17229n);
        subscribe("event_update_jarvis", this.f17225j);
    }

    /* access modifiers changed from: protected */
    public void unRegister() {
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, this.f17226k);
        unsubscribe("event_record_status_changed", this.f17231q);
        unsubscribe(BaseEventKeys.Push.EVENT_ON_SERVICE_MONITOR_TRIGGER, this.mRealTimeMonitorListener);
        unsubscribe(BaseEventKeys.SafeToolkit.EVENT_MONITOR_STATUS_CHANGED, this.mMonitorStatusChanged);
        unsubscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f17227l);
        unsubscribe("event_Share_before_accepted", this.f17228m);
        unsubscribe(BaseEventKeys.SafeToolkit.EVENT_REQUEST_JARVIS, this.f17224i);
        unsubscribe(BaseEventKeys.SafeToolkit.EVENT_TRIP_END_DISMISS_WHEN_PAYING, this.alphaListener);
        LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this.f17230p);
        OneLoginFacade.getFunction().removeLoginOutListener(this.f17229n);
        unsubscribe("event_update_jarvis", this.f17225j);
    }

    /* access modifiers changed from: protected */
    public void onXPanelDefaultHeightChanged(int i) {
        if (i >= 0) {
            this.f17218c = i;
            int i2 = this.f17217b;
            if (i2 > i) {
                onXPanelScrollChanged(i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onXPanelScrollChanged(int i) {
        ((IJarvisView) this.mView).getView().animate().cancel();
        this.f17217b = i;
        final int newHeightWithUIOffset = getNewHeightWithUIOffset(i);
        if (!"home".equals(getPage())) {
            ((IJarvisView) this.mView).setTranslationY(-newHeightWithUIOffset);
        } else if (this.mComponentParams.bizCtx == null || SecondConfProxy.getInstance().isCityOpen(this.mComponentParams.bizCtx.getBusinessGroupType())) {
            int bizBarHeight = this.mComponentParams.bizCtx.getBizBarHeight();
            ((IJarvisView) this.mView).setTranslationY(((-newHeightWithUIOffset) - bizBarHeight) - this.f17222g);
            GLog.m11356e("lxsJarvis:newHeight" + newHeightWithUIOffset + ", bizBarHeight" + bizBarHeight + ", mXBannerHeight" + this.f17222g);
        } else {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    if (AbsJarvisPresenter.this.mComponentParams != null && AbsJarvisPresenter.this.mComponentParams.bizCtx != null) {
                        int bizBarHeight = AbsJarvisPresenter.this.mComponentParams.bizCtx.getBizBarHeight();
                        ((IJarvisView) AbsJarvisPresenter.this.mView).setTranslationY(((-newHeightWithUIOffset) - bizBarHeight) - AbsJarvisPresenter.this.f17222g);
                        GLog.m11356e("lxsJarvis:finalNewHeight" + newHeightWithUIOffset + ", bizBarHeight" + bizBarHeight + ", mXBannerHeight" + AbsJarvisPresenter.this.f17222g);
                    }
                }
            }, 1000);
        }
    }

    /* access modifiers changed from: protected */
    public int getNewHeightWithUIOffset(int i) {
        if (this.mView == null) {
            return i;
        }
        float f = (float) i;
        float f2 = this.f17219d;
        return f > f2 ? (int) (f + f2) : i;
    }

    public void requestJarvisStatus() {
        requestJarvisStatus(0);
    }

    public void requestJarvisStatus(int i) {
        GLog.m11360i("lxs", "requestJarvisStatus" + getPage());
        sGPageId = OmegaSDK.getGlobalAttr("g_PageId");
        String page = getPage();
        if (GPageIdConstant.G_PAGE_ID_ENDS.equals(page)) {
            page = "end";
        }
        CarRequest.getJarvisStatus(this.mContext, CarOrderHelper.getOrder() == null ? "" : CarOrderHelper.getOrder().getOid(), String.valueOf(CarOrderHelper.getOrder() == null ? BusinessDataUtil.getProductId() : Integer.valueOf(CarOrderHelper.getOrder().getProductId())), 0, page, this.f17216a, this.f17223h, i, this.f17232r);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unRegister();
        ((IJarvisView) this.mView).closeSafePanel();
        ((IJarvisView) this.mView).onRemove();
        BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, 0);
    }
}
