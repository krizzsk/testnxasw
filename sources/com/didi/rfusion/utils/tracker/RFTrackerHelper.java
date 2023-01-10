package com.didi.rfusion.utils.tracker;

import com.didi.rfusion.RFusion;

public class RFTrackerHelper {
    public static void trackFloatingShow() {
        m27157a("tech_rf_floating_sw").track();
    }

    public static void trackDialogShow() {
        m27157a("tech_rf_dialog_sw").track();
    }

    /* renamed from: a */
    private static RFEventTracker m27157a(String str) {
        RFEventTracker event = RFEventTracker.event(str);
        m27158a(event);
        return event;
    }

    /* renamed from: a */
    private static void m27158a(RFEventTracker rFEventTracker) {
        rFEventTracker.param("pkgName", RFusion.getContext().getPackageName());
    }
}
