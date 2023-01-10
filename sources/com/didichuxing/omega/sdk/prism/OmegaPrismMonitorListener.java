package com.didichuxing.omega.sdk.prism;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.didi.sdk.payment.util.PaymentConstant;
import com.didichuxing.omega.sdk.UIAutoMarker;
import com.didichuxing.omega.sdk.UIAutoTracker;
import com.didichuxing.omega.sdk.analysis.AnalysisActivityListener;
import com.didichuxing.omega.sdk.analysis.AnalysisFragmentListener;
import com.didichuxing.omega.sdk.analysis.AnalysisPageListener;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.iproov.sdk.bridge.OptionsBridge;
import com.xiaojuchefu.prism.monitor.PrismMonitor;
import com.xiaojuchefu.prism.monitor.model.EventData;
import java.util.WeakHashMap;

public class OmegaPrismMonitorListener implements PrismMonitor.OnPrismMonitorListener {
    public void onEvent(EventData eventData) {
        if (eventData == null || !OmegaConfig.SWITCH_OMEGA_ENENT_TRACK_PRISM) {
            return;
        }
        if (eventData.eventType == 3) {
            AnalysisActivityListener.reportOmgAppIn(eventData.activity, (EventData) null);
        } else if (eventData.eventType == 2) {
            AnalysisActivityListener.reportOmgAppOut(eventData.activity, (EventData) null);
        } else if (eventData.eventType == 6) {
            AnalysisActivityListener.reportOmgAppJump(eventData.activity);
        } else if (eventData.eventType == 10) {
            AnalysisActivityListener.reportOmgPageResume(eventData.activity, (EventData) null);
        } else if (eventData.eventType == 11) {
            AnalysisActivityListener.reportOmgPagePause(eventData.activity, (EventData) null);
        } else if (eventData.eventType == 0) {
            reportOmgUi(eventData);
        } else if (eventData.eventType == 14) {
            reportH5OmgUi(eventData);
        }
    }

    public static void reportOmgUi(EventData eventData) {
        Activity activity;
        Event event = new Event("OMGUI");
        event.setFrom(OptionsBridge.UI_KEY);
        if (eventData.view != null) {
            activity = UIAutoTracker.scanForActivity(eventData.view.getContext());
        } else {
            activity = AnalysisActivityListener.getCurActivity();
        }
        if (activity != null) {
            event.putAllAttrs(UIAutoMarker.getPageAttrMap(activity));
            if (eventData.view != null) {
                event.putAllAttrs(UIAutoMarker.getViewAttrMap(eventData.view));
            }
            String str = "UNKNOWN";
            String simplifyClassName = activity != null ? CommonUtil.simplifyClassName(activity.getClass().getName()) : str;
            String currentFramentName = AnalysisFragmentListener.getCurrentFramentName();
            String currentPageName = AnalysisPageListener.getCurrentPageName();
            if (!TextUtils.isEmpty(currentPageName)) {
                event.putAttr("spn", currentPageName);
            }
            if (currentFramentName == null) {
                currentFramentName = simplifyClassName;
            }
            event.putAttr("rpn", simplifyClassName);
            event.putAttr("pn", currentFramentName);
            event.putAttr("at", 1);
            if (eventData.view != null) {
                event.putAttr("rt", CommonUtil.simplifyClassName(eventData.view.getClass().getName()));
            }
            if (eventData.view != null) {
                WeakHashMap<View, String> viewNameMap = UIAutoMarker.getViewNameMap(activity);
                String str2 = null;
                if (viewNameMap != null) {
                    str2 = viewNameMap.get(eventData.view);
                }
                if (str2 == null) {
                    String resourceName = UIAutoTracker.getResourceName(eventData.view);
                    if (resourceName != null) {
                        str = resourceName;
                    }
                } else {
                    str = str2;
                }
                event.putAttr("rn", str);
            }
            OmegaPrismCheck.prismCheck(eventData);
            String str3 = eventData.f58882vr;
            if (!TextUtils.isEmpty(str3) && eventData.view != null) {
                Object tag = eventData.view.getTag();
                String name = eventData.view.getClass().getName();
                if ((tag != null && tag.toString().equals(PaymentConstant.TAG_SENSITIVE)) || ((name != null && name.contains("EditText") && !OmegaConfig.SWITCH_ATUO_EVENT_INPUT) || (eventData.view instanceof EditText))) {
                    str3 = CommonUtil.copyJoinStr("*", str3.length());
                    eventData.f58882vr = str3;
                }
                event.putAttr("text", str3);
            }
            event.setSessionId();
            setPrismAttr(event, eventData);
            String screenShot = ScreenShotUtil.getScreenShot(eventData.view, eventData.mDownX, eventData.mDownY);
            if (!TextUtils.isEmpty(screenShot)) {
                event.putAttr("prism-ck-img", screenShot);
            }
            Tracker.trackEvent(event);
            OmegaPrismKeyMonitorListener.reportOmgUiSw();
            OmegaPrismKeyMonitorListener.setOMGUIEvent(event);
        }
    }

    public static void setPrismAttr(Event event, EventData eventData) {
        if (event != null && eventData != null) {
            if (!TextUtils.isEmpty(eventData.f58883w)) {
                event.putAttr("prism-w", eventData.f58883w);
            }
            if (!TextUtils.isEmpty(eventData.f58878vi)) {
                event.putAttr("prism-vi", eventData.f58878vi);
            }
            if (!TextUtils.isEmpty(eventData.f58882vr)) {
                event.putAttr("prism-vr", eventData.f58882vr);
            }
            if (!TextUtils.isEmpty(eventData.f58881vq)) {
                event.putAttr("prism-vq", eventData.f58881vq);
            }
            if (!TextUtils.isEmpty(eventData.f58879vl)) {
                event.putAttr("prism-vl", eventData.f58879vl);
            }
            if (!TextUtils.isEmpty(eventData.f58880vp)) {
                event.putAttr("prism-vp", eventData.f58880vp);
            }
            if (!TextUtils.isEmpty(eventData.f58877vf)) {
                event.putAttr("prism-vf", eventData.f58877vf);
            }
            if (!TextUtils.isEmpty(eventData.f58876h5)) {
                event.putAttr("prism-h5", eventData.f58876h5);
            }
            event.putAttr("fvd", Long.valueOf(eventData.fvd));
            event.putAttr("avd", Long.valueOf(eventData.avd));
        }
    }

    public static void reportH5OmgUi(EventData eventData) {
        if (OmegaConfig.isDebugModel()) {
            Event event = new Event("OMGUI");
            event.setFrom(OptionsBridge.UI_KEY);
            if (!TextUtils.isEmpty(eventData.f58882vr)) {
                event.putAttr("prism-vr", eventData.f58882vr);
            }
            if (!TextUtils.isEmpty(eventData.f58876h5)) {
                event.putAttr("prism-h5", eventData.f58876h5);
            }
            event.setSessionId();
            String screenShot = ScreenShotUtil.getScreenShot(eventData.view, eventData.mDownX, eventData.mDownY);
            if (!TextUtils.isEmpty(screenShot)) {
                event.putAttr("prism-ck-img", screenShot);
            }
            Tracker.trackEvent(event);
        }
    }
}
