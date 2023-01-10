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
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.event.UpdateJarvisEvent;
import com.didi.component.safetoolkit.views.IJarvisViewV2;
import com.didi.component.safetoolkit.views.JarvisBeforeAcceptedFragment;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.business.safeCenter.adapter.SfAdapter;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didi.sdk.misconfig.p154v2.SecondConfProxy;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.taxis99.R;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class AbsJarvisPresenterV2 extends IPresenter<IJarvisViewV2> {
    public static Object sGPageId;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f17233a = "";
    protected BaseEventPublisher.OnEventListener<Boolean> alphaListener = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            ((IJarvisViewV2) AbsJarvisPresenterV2.this.mView).setJarvisDismissedByAlpha(bool.booleanValue());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f17234b;

    /* renamed from: c */
    private int f17235c;

    /* renamed from: d */
    private float f17236d = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CommonTripShareManager f17237e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public JarvisBeforeAcceptedFragment f17238f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f17239g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f17240h;

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener f17241i = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.SafeToolkit.EVENT_REQUEST_JARVIS.equals(str)) {
                AbsJarvisPresenterV2.this.requestJarvisStatus();
            }
        }
    };

    /* renamed from: j */
    private BaseEventPublisher.OnEventListener<UpdateJarvisEvent> f17242j = new BaseEventPublisher.OnEventListener<UpdateJarvisEvent>() {
        public void onEvent(String str, UpdateJarvisEvent updateJarvisEvent) {
            if ("event_update_jarvis".equals(str) && updateJarvisEvent != null) {
                AbsJarvisPresenterV2.this.requestJarvisStatus(updateJarvisEvent.openManualRecord);
            }
        }
    };

    /* renamed from: k */
    private BaseEventPublisher.OnEventListener f17243k = new BaseEventPublisher.OnEventListener<Float>() {
        public void onEvent(String str, Float f) {
            if (BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA.equals(str)) {
                ((IJarvisViewV2) AbsJarvisPresenterV2.this.mView).getView().setAlpha(f.floatValue());
            }
        }
    };

    /* renamed from: l */
    private BaseEventPublisher.OnEventListener<Integer> f17244l = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if ("home".equals(AbsJarvisPresenterV2.this.getPage())) {
                AbsJarvisPresenterV2 absJarvisPresenterV2 = AbsJarvisPresenterV2.this;
                int intValue = num.intValue();
                int intValue2 = num.intValue();
                if (intValue != 0) {
                    intValue2 += AbsJarvisPresenterV2.this.mContext.getResources().getDimensionPixelOffset(R.dimen._10dip);
                }
                int unused = absJarvisPresenterV2.f17239g = intValue2;
                AbsJarvisPresenterV2 absJarvisPresenterV22 = AbsJarvisPresenterV2.this;
                final int newHeightWithUIOffset = absJarvisPresenterV22.getNewHeightWithUIOffset(absJarvisPresenterV22.f17234b);
                if (AbsJarvisPresenterV2.this.mComponentParams.bizCtx == null || SecondConfProxy.getInstance().isCityOpen(AbsJarvisPresenterV2.this.mComponentParams.bizCtx.getBusinessGroupType())) {
                    int bizBarHeight = AbsJarvisPresenterV2.this.mComponentParams.bizCtx.getBizBarHeight();
                    ((IJarvisViewV2) AbsJarvisPresenterV2.this.mView).setTranslationY(((-newHeightWithUIOffset) - bizBarHeight) - AbsJarvisPresenterV2.this.f17239g);
                    GLog.m11356e("lxsJarvis:marginBottom" + newHeightWithUIOffset + ", bizBarHeight" + bizBarHeight + ", mXBannerHeight" + AbsJarvisPresenterV2.this.f17239g);
                    return;
                }
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        if (AbsJarvisPresenterV2.this.mComponentParams != null && AbsJarvisPresenterV2.this.mComponentParams.bizCtx != null) {
                            int bizBarHeight = AbsJarvisPresenterV2.this.mComponentParams.bizCtx.getBizBarHeight();
                            ((IJarvisViewV2) AbsJarvisPresenterV2.this.mView).setTranslationY(((-newHeightWithUIOffset) - bizBarHeight) - AbsJarvisPresenterV2.this.f17239g);
                            GLog.m11356e("lxsJarvis:finalNewHeight" + newHeightWithUIOffset + ", bizBarHeight" + bizBarHeight + ", mXBannerHeight" + AbsJarvisPresenterV2.this.f17239g);
                        }
                    }
                }, 1000);
            }
        }
    };

    /* renamed from: m */
    private BaseEventPublisher.OnEventListener f17245m = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                Activity activity = AbsJarvisPresenterV2.this.mComponentParams.getActivity();
                if (activity instanceof FragmentActivity) {
                    JarvisBeforeAcceptedFragment unused = AbsJarvisPresenterV2.this.f17238f = JarvisBeforeAcceptedFragment.newInstance();
                    AbsJarvisPresenterV2.this.f17238f.show(((FragmentActivity) activity).getSupportFragmentManager(), "jarvis_share_before_accepted");
                    return;
                }
                return;
            }
            if (AbsJarvisPresenterV2.this.f17237e != null) {
                AbsJarvisPresenterV2.this.f17237e.disMissOneKeyShareDialog();
            }
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null) {
                if (AbsJarvisPresenterV2.this.f17237e == null) {
                    CommonTripShareManager unused2 = AbsJarvisPresenterV2.this.f17237e = new CommonTripShareManager();
                }
                if (AbsJarvisPresenterV2.this.mComponentParams != null) {
                    AbsJarvisPresenterV2.this.f17237e.showShareDialog(AbsJarvisPresenterV2.this.mComponentParams.getActivity(), order.oid, order.productid);
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
            AbsJarvisPresenterV2.this.requestJarvisStatus();
        }
    };
    protected BaseEventPublisher.OnEventListener mOnEventListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED)) {
                GLog.m11354d("lxsXpanelCb", "receive:" + num + AbsJarvisPresenterV2.this.toString());
                AbsJarvisPresenterV2.this.onXPanelDefaultHeightChanged(num.intValue());
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mOnScrollEventListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER)) {
                GLog.m11354d("lxsXpanelCb", "biz: " + num);
                AbsJarvisPresenterV2.this.onXPanelScrollChanged(num.intValue());
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
                NotificationUtils.getInstance(AbsJarvisPresenterV2.this.mContext).showNotification("", str3);
                AbsJarvisPresenterV2.this.requestJarvisStatus();
                GLog.m11360i("mRealTimeMonitorListener", "receive warning push:" + str3);
            } catch (Exception e) {
                GLog.m11360i("mRealTimeMonitorListener", e.getMessage());
            }
        }
    };

    /* renamed from: n */
    private LoginListeners.LoginOutListener f17246n = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            ((IJarvisViewV2) AbsJarvisPresenterV2.this.mView).closeSafePanel();
            if (AbsJarvisPresenterV2.this.f17238f != null) {
                AbsJarvisPresenterV2.this.f17238f.dismissAllowingStateLoss();
            }
            ((IJarvisViewV2) AbsJarvisPresenterV2.this.mView).setJarvisData((SfJarvisData) null);
            String unused = AbsJarvisPresenterV2.this.f17233a = "";
        }
    };

    /* renamed from: p */
    private SfAdapter f17247p;

    /* renamed from: q */
    private BroadcastReceiver f17248q = new BroadcastReceiver() {
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
                        ToastHelper.showShortInfo(AbsJarvisPresenterV2.this.mContext, (int) R.string.sf_jarvis_share_suc);
                        AbsJarvisPresenterV2.this.requestJarvisStatus();
                    } else if (c == 1) {
                        ToastHelper.showShortInfo(AbsJarvisPresenterV2.this.mContext, (int) R.string.sf_jarvis_share_fail);
                        AbsJarvisPresenterV2.this.requestJarvisStatus();
                    } else if (c == 2) {
                        AbsJarvisPresenterV2.this.requestJarvisStatus();
                    } else if (c == 3) {
                        GlobalSPUtil.setSFIsReportingPolice(AbsJarvisPresenterV2.this.mContext, true);
                        AbsJarvisPresenterV2.this.requestJarvisStatus();
                    } else if (c != 4) {
                        AbsJarvisPresenterV2.this.requestJarvisStatus();
                    } else {
                        GlobalSPUtil.setSFIsReportingPolice(AbsJarvisPresenterV2.this.mContext, false);
                        AbsJarvisPresenterV2.this.requestJarvisStatus();
                    }
                }
            }
        }
    };

    /* renamed from: r */
    private BaseEventPublisher.OnEventListener<Boolean> f17249r = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                int unused = AbsJarvisPresenterV2.this.f17240h = 1;
            } else {
                int unused2 = AbsJarvisPresenterV2.this.f17240h = 0;
            }
            GlobalSfManager.getInstance().setmIsRecording(AbsJarvisPresenterV2.this.f17240h);
            AbsJarvisPresenterV2.this.requestJarvisStatus();
        }
    };

    /* renamed from: s */
    private BffResponseListener<SfJarvisData> f17250s = new BffResponseListener<SfJarvisData>() {
        public void onFinish(SfJarvisData sfJarvisData) {
            super.onFinish(sfJarvisData);
            if (sfJarvisData == null || sfJarvisData.errno != 0) {
                ((IJarvisViewV2) AbsJarvisPresenterV2.this.mView).setJarvisData((SfJarvisData) null);
                String unused = AbsJarvisPresenterV2.this.f17233a = "";
            } else if (AbsJarvisPresenterV2.this.f17233a != null && AbsJarvisPresenterV2.this.f17233a.equals(sfJarvisData.dataVer)) {
            } else {
                if (sfJarvisData.bubbles != null || sfJarvisData.banner != null || sfJarvisData.menus != null || sfJarvisData.timeline != null) {
                    ((IJarvisViewV2) AbsJarvisPresenterV2.this.mView).setJarvisData(sfJarvisData);
                    String unused2 = AbsJarvisPresenterV2.this.f17233a = sfJarvisData.dataVer;
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public abstract String getPage();

    public AbsJarvisPresenterV2(ComponentParams componentParams) {
        super(componentParams);
        this.mComponentParams = componentParams;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        register();
        this.f17247p = new SfAdapter();
        this.f17236d = TypedValue.applyDimension(1, 4.0f, this.mContext.getResources().getDisplayMetrics());
        doPublish(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT);
        doPublish(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_SCROLL_HEIGHT);
        GlobalSfManager.getInstance().setCurView(getPage(), ((IJarvisViewV2) this.mView).getViewOwner());
        GLog.m11354d("lxsXpanelCb", "onAdd: " + toString());
    }

    /* access modifiers changed from: protected */
    public void register() {
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, this.f17243k);
        subscribe("event_record_status_changed", this.f17249r);
        subscribe(BaseEventKeys.Push.EVENT_ON_SERVICE_MONITOR_TRIGGER, this.mRealTimeMonitorListener);
        subscribe(BaseEventKeys.SafeToolkit.EVENT_MONITOR_STATUS_CHANGED, this.mMonitorStatusChanged);
        subscribe("event_Share_before_accepted", this.f17245m);
        subscribe(BaseEventKeys.SafeToolkit.EVENT_REQUEST_JARVIS, this.f17241i);
        subscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f17244l);
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
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.f17248q, intentFilter);
        OneLoginFacade.getFunction().addLoginOutListener(this.f17246n);
        subscribe("event_update_jarvis", this.f17242j);
    }

    /* access modifiers changed from: protected */
    public void unRegister() {
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, this.f17243k);
        unsubscribe("event_record_status_changed", this.f17249r);
        unsubscribe(BaseEventKeys.Push.EVENT_ON_SERVICE_MONITOR_TRIGGER, this.mRealTimeMonitorListener);
        unsubscribe(BaseEventKeys.SafeToolkit.EVENT_MONITOR_STATUS_CHANGED, this.mMonitorStatusChanged);
        unsubscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f17244l);
        unsubscribe("event_Share_before_accepted", this.f17245m);
        unsubscribe(BaseEventKeys.SafeToolkit.EVENT_REQUEST_JARVIS, this.f17241i);
        unsubscribe(BaseEventKeys.SafeToolkit.EVENT_TRIP_END_DISMISS_WHEN_PAYING, this.alphaListener);
        LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this.f17248q);
        OneLoginFacade.getFunction().removeLoginOutListener(this.f17246n);
        unsubscribe("event_update_jarvis", this.f17242j);
    }

    /* access modifiers changed from: protected */
    public void onXPanelDefaultHeightChanged(int i) {
        if (i >= 0) {
            this.f17235c = i;
            int i2 = this.f17234b;
            if (i2 > i) {
                onXPanelScrollChanged(i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onXPanelScrollChanged(int i) {
        ((IJarvisViewV2) this.mView).getView().animate().cancel();
        this.f17234b = i;
        final int newHeightWithUIOffset = getNewHeightWithUIOffset(i);
        if (!"home".equals(getPage())) {
            ((IJarvisViewV2) this.mView).setTranslationY(-newHeightWithUIOffset);
        } else if (this.mComponentParams.bizCtx == null || SecondConfProxy.getInstance().isCityOpen(this.mComponentParams.bizCtx.getBusinessGroupType())) {
            int bizBarHeight = this.mComponentParams.bizCtx.getBizBarHeight();
            ((IJarvisViewV2) this.mView).setTranslationY(((-newHeightWithUIOffset) - bizBarHeight) - this.f17239g);
            GLog.m11356e("lxsJarvis:newHeight" + newHeightWithUIOffset + ", bizBarHeight" + bizBarHeight + ", mXBannerHeight" + this.f17239g);
        } else {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    if (AbsJarvisPresenterV2.this.mComponentParams != null && AbsJarvisPresenterV2.this.mComponentParams.bizCtx != null) {
                        int bizBarHeight = AbsJarvisPresenterV2.this.mComponentParams.bizCtx.getBizBarHeight();
                        ((IJarvisViewV2) AbsJarvisPresenterV2.this.mView).setTranslationY(((-newHeightWithUIOffset) - bizBarHeight) - AbsJarvisPresenterV2.this.f17239g);
                        GLog.m11356e("lxsJarvis:finalNewHeight" + newHeightWithUIOffset + ", bizBarHeight" + bizBarHeight + ", mXBannerHeight" + AbsJarvisPresenterV2.this.f17239g);
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
        float f2 = this.f17236d;
        return f > f2 ? (int) (f + f2) : i;
    }

    public void requestJarvisStatus() {
        requestJarvisStatus(0);
    }

    public void requestJarvisStatus(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("page", getPage());
        this.f17247p.refreshBubbleData(i, hashMap, (BffResponseListener) null);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unRegister();
        ((IJarvisViewV2) this.mView).closeSafePanel();
        ((IJarvisViewV2) this.mView).onRemove();
        BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, 0);
    }
}
