package com.didichuxing.omega.sdk.prism;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.didichuxing.omega.sdk.UIAutoMarker;
import com.didichuxing.omega.sdk.analysis.AnalysisActivityListener;
import com.didichuxing.omega.sdk.analysis.AnalysisFragmentListener;
import com.didichuxing.omega.sdk.analysis.AnalysisPageListener;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.Constants;
import com.xiaojuchefu.prism.monitor.PrismMonitor;

public class OmegaPrismKeyMonitorListener implements PrismMonitor.OnPrismKeyMonitorListener {
    static boolean mIsMoveCollect;
    static Event mPreOMGUIEvent;
    static String mPrismSwImg;

    public void onEvent(int i) {
        if (ScreenShotUtil.canReportImg() && 2 == i && mPreOMGUIEvent != null && mIsMoveCollect) {
            mIsMoveCollect = false;
            mPrismSwImg = ScreenShotUtil.getScreenShot((View) null, -1.0f, -1.0f);
        }
    }

    static void setOMGUIEvent(Event event) {
        if (ScreenShotUtil.canReportImg()) {
            mPreOMGUIEvent = event;
            mIsMoveCollect = true;
            mPrismSwImg = null;
        }
    }

    public static void reportOmgUiSw() {
        if (ScreenShotUtil.canReportImg() && mPreOMGUIEvent != null) {
            Event event = new Event(Constants.EVENT_OMG_SCREENSHOT);
            event.putAllAttrs(mPreOMGUIEvent.getAllAttrs());
            Activity curActivity = AnalysisActivityListener.getCurActivity();
            if (curActivity != null) {
                event.putAllAttrs(UIAutoMarker.getPageAttrMap(curActivity));
            }
            String simplifyClassName = curActivity != null ? CommonUtil.simplifyClassName(curActivity.getClass().getName()) : "UNKNOWN";
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
            if (mPrismSwImg == null) {
                mPrismSwImg = ScreenShotUtil.getScreenShot((View) null, -1.0f, -1.0f);
            }
            if (!TextUtils.isEmpty(mPrismSwImg)) {
                event.putAttr("prism-img", mPrismSwImg);
            }
            event.removeAttr("prism-ck-img");
            Tracker.trackEvent(event);
            setOMGUIEvent((Event) null);
        }
    }
}
