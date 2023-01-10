package com.didichuxing.mas.sdk.quality.collect.duration;

import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.collector.NetworkCollector;
import com.didichuxing.mas.sdk.quality.report.record.Event;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OmegaPageDuration {

    /* renamed from: a */
    private static final String f50644a = "OMGDE";

    /* renamed from: b */
    private List<DurationEvent> f50645b = new ArrayList();

    /* renamed from: c */
    private String f50646c;

    public static void setLoggable(boolean z) {
    }

    public OmegaPageDuration(String str) {
        this.f50646c = str;
    }

    public void startDurationStatistics(String str) {
        boolean z = false;
        for (DurationEvent mainName : this.f50645b) {
            if (mainName.getMainName().equals(str)) {
                z = true;
            }
        }
        if (!z) {
            this.f50645b.add(new DurationEvent(str));
            if (MASConfig.LOG_PAGE_DURATION) {
                SystemUtils.log(3, f50644a, "start main: " + m37733a(this.f50645b), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.duration.OmegaPageDuration", 49);
            }
        } else if (MASConfig.LOG_PAGE_DURATION) {
            SystemUtils.log(3, f50644a, str + " has start already! ", (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.duration.OmegaPageDuration", 53);
        }
    }

    public void startDurationStatistics(String str, String str2) {
        boolean z = false;
        for (DurationEvent next : this.f50645b) {
            if (next.getMainName().equals(str)) {
                next.startSub(str2);
                z = true;
            }
        }
        if (!MASConfig.LOG_PAGE_DURATION) {
            return;
        }
        if (!z) {
            SystemUtils.log(3, f50644a, str + " has NOT start, should start main first. ", (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.duration.OmegaPageDuration", 75);
            return;
        }
        SystemUtils.log(3, f50644a, "start sub: " + m37733a(this.f50645b), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.duration.OmegaPageDuration", 77);
    }

    public void endDurationStatistics(String str) {
        boolean z = false;
        for (DurationEvent next : this.f50645b) {
            if (next.getMainName().equals(str)) {
                z = true;
                next.endMain();
            }
        }
        if (!MASConfig.LOG_PAGE_DURATION) {
            return;
        }
        if (!z) {
            SystemUtils.log(3, f50644a, str + " has NOT start, you should start first! ", (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.duration.OmegaPageDuration", 97);
            return;
        }
        SystemUtils.log(3, f50644a, "end main: " + m37733a(this.f50645b), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.duration.OmegaPageDuration", 99);
    }

    public void endDurationStatistics(String str, String str2) {
        boolean z = false;
        for (DurationEvent next : this.f50645b) {
            if (next.getMainName().equals(str)) {
                z = true;
                next.endSub(str2);
            }
        }
        if (!MASConfig.LOG_PAGE_DURATION) {
            return;
        }
        if (!z) {
            SystemUtils.log(3, f50644a, str + " has NOT start, you should start first! ", (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.duration.OmegaPageDuration", 120);
            return;
        }
        SystemUtils.log(3, f50644a, "end sub: " + m37733a(this.f50645b), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.duration.OmegaPageDuration", 122);
    }

    public void commitDurationStatistics() {
        Iterator<DurationEvent> it = this.f50645b.iterator();
        while (it.hasNext()) {
            DurationEvent next = it.next();
            long mainTime = next.getMainTime();
            if (0 < mainTime && mainTime < 86400000) {
                Event event = new Event(EventConst.Technology.PAGE_LAUNCH_TIME);
                event.putAttr("pn", this.f50646c);
                event.putAttr(ParamConst.PARAM_OMEGA_PAGE_RENDERING_TIME, Long.valueOf(mainTime));
                event.putAttr(ParamConst.PARAM_OMEGA_PAGE_NAME, next.getMainName());
                event.putAttr("sub_events_time", next.getSubInfoInJson());
                event.putAttr("nt", NetworkCollector.getNetworkType());
                OmegaSDKAdapter.trackMasEvent(event);
                if (MASConfig.LOG_PAGE_DURATION) {
                    SystemUtils.log(3, f50644a, "commit : " + event.toString(), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.duration.OmegaPageDuration", 144);
                }
            }
            it.remove();
        }
    }

    /* renamed from: a */
    private String m37733a(List<DurationEvent> list) {
        if (list == null || list.size() < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (DurationEvent durationEvent : list) {
            sb.append(durationEvent.toString());
        }
        return sb.toString();
    }
}
