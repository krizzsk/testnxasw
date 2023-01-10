package com.didi.globalsafetoolkit.business.emergency;

import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didichuxing.apollo.sdk.Apollo;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TimeSendLocationMgr {

    /* renamed from: a */
    private static TimeSendLocationMgr f24995a;

    /* renamed from: b */
    private ScheduledExecutorService f24996b = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: c */
    private ScheduledFuture f24997c;

    /* renamed from: d */
    private Runnable f24998d = new Runnable() {
        public void run() {
            GlobalSfBusinessInterface.sendLocation();
        }
    };

    public static TimeSendLocationMgr getInstance() {
        if (f24995a == null) {
            f24995a = new TimeSendLocationMgr();
        }
        return f24995a;
    }

    public void startSendLocation() {
        if (this.f24997c == null) {
            this.f24997c = this.f24996b.scheduleAtFixedRate(this.f24998d, 0, (long) m20039a(), TimeUnit.SECONDS);
        }
    }

    public void stopSendLocation() {
        ScheduledFuture scheduledFuture = this.f24997c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    /* renamed from: a */
    private int m20039a() {
        return ((Integer) m20040a("global_safetytoolkit_location_update_interval", "upload_time_interval", 5)).intValue();
    }

    /* renamed from: a */
    private <T> T m20040a(String str, String str2, T t) {
        try {
            return Apollo.getToggle(str).getExperiment().getParam(str2, t);
        } catch (Exception unused) {
            return t;
        }
    }
}
