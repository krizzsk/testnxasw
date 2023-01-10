package com.xiaojuchefu.prism.monitor.event;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.xiaojuchefu.prism.monitor.PrismMonitor;
import com.xiaojuchefu.prism.monitor.core.WindowCallbacks;
import com.xiaojuchefu.prism.monitor.model.EventData;
import com.xiaojuchefu.prism.monitor.touch.TouchEventHelper;
import com.xiaojuchefu.prism.monitor.touch.TouchRecord;
import com.xiaojuchefu.prism.monitor.touch.TouchRecordManager;
import com.xiaojuchefu.prism.monitor.touch.TouchTracker;
import com.xiaojuchefu.prism.monitor.touch.WebviewEventHelper;

public class PrismMonitorWindowCallbacks extends WindowCallbacks {

    /* renamed from: f */
    private static final String f58869f = "blackphonelist";

    /* renamed from: a */
    PrismMonitor f58870a;

    /* renamed from: b */
    private Window f58871b;

    /* renamed from: c */
    private BlackPhoneListParser f58872c = new BlackPhoneListParser();

    /* renamed from: d */
    private boolean f58873d = false;

    /* renamed from: e */
    private boolean f58874e = false;

    public PrismMonitorWindowCallbacks(Window window) {
        super(window.getCallback());
        this.f58871b = window;
        this.f58870a = PrismMonitor.getInstance();
    }

    public boolean touchEvent(MotionEvent motionEvent) {
        if (this.f58870a.isMonitoring()) {
            TouchRecordManager.getInstance().touchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 1) {
                TouchRecord touchRecord = TouchRecordManager.getInstance().getTouchRecord();
                if (touchRecord != null && (touchRecord.isClick || this.f58870a.isTest())) {
                    if (!this.f58874e) {
                        this.f58873d = m44507a();
                        this.f58874e = true;
                    }
                    if (this.f58873d) {
                        this.f58870a.post(new EventData(0));
                    } else {
                        int[] iArr = {(int) touchRecord.mDownX, (int) touchRecord.mDownY};
                        long currentTimeMillis = System.currentTimeMillis();
                        ViewGroup viewGroup = (ViewGroup) this.f58871b.getDecorView();
                        if (!touchRecord.isClick) {
                            iArr = null;
                        }
                        View findTargetView = TouchTracker.findTargetView(viewGroup, iArr);
                        WebviewEventHelper.collectWebView(findTargetView);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (findTargetView != null) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            EventData createEventData = TouchEventHelper.createEventData(this.f58871b, findTargetView, touchRecord);
                            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                            if (createEventData != null) {
                                createEventData.mDownX = touchRecord.mDownX;
                                createEventData.mDownY = touchRecord.mDownY;
                                createEventData.fvd = currentTimeMillis2;
                                createEventData.avd = currentTimeMillis4;
                                this.f58870a.post(createEventData);
                            }
                        }
                    }
                }
            } else {
                this.f58870a.postKeyMonitor(actionMasked);
            }
        }
        return false;
    }

    public boolean dispatchBackKeyEvent() {
        if (!this.f58870a.isMonitoring()) {
            return false;
        }
        this.f58870a.post(1);
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f58870a.isMonitoring() && this.f58871b.getAttributes().type == 2) {
            this.f58870a.post(4);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f58870a.isMonitoring() && this.f58871b.getAttributes().type == 2) {
            this.f58870a.post(5);
        }
    }

    /* renamed from: a */
    private boolean m44507a() {
        String blackPhoneToggle = PrismMonitor.getInstance().getBlackPhoneToggle();
        if (TextUtils.isEmpty(blackPhoneToggle)) {
            return false;
        }
        return this.f58872c.check((String) PrismMonitor.getInstance().getParams(blackPhoneToggle, f58869f, ""));
    }

    private static class BlackPhoneListParser {
        private static final String INNER_SPLIT = "&";
        private static final String SPLIT = ",";

        private BlackPhoneListParser() {
        }

        /* access modifiers changed from: private */
        public boolean check(String str) {
            String[] split;
            String[] split2;
            float f;
            if (!(TextUtils.isEmpty(str) || (split = str.trim().split(",")) == null || split.length == 0)) {
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2) && (split2 = str2.split("&")) != null) {
                        if (split2.length == 2) {
                            if (checkPhoneBrand(split2[0]) && checkPhoneModel(split2[1])) {
                                return true;
                            }
                        } else if (split2.length == 3 && PrismMonitor.getInstance().getTotalMem() > 0) {
                            try {
                                f = Float.parseFloat(split2[2]);
                            } catch (Throwable unused) {
                                f = -1.0f;
                            }
                            if (-1.0f == f) {
                                continue;
                            } else {
                                long j = (long) (f * 1024.0f * 1024.0f * 1024.0f);
                                if (checkPhoneBrand(split2[0]) && checkPhoneModel(split2[1]) && j >= PrismMonitor.getInstance().getTotalMem()) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        private boolean checkPhoneBrand(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (PrismMonitor.getInstance().getPhoneBrand() != null) {
                return PrismMonitor.getInstance().getPhoneBrand().equals(str);
            }
            return false;
        }

        private boolean checkPhoneModel(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (PrismMonitor.getInstance().getPhoneModel() != null) {
                return PrismMonitor.getInstance().getPhoneModel().equals(str);
            }
            return false;
        }
    }
}
