package com.didichuxing.mas.sdk.quality.collect.fps;

import android.view.Choreographer;
import com.didichuxing.mas.sdk.quality.collect.lag.OmegaLag;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.backend.AppStateMonitor;
import com.didichuxing.mas.sdk.quality.report.backend.ScreenChangeReceiver;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;

public class FPSFrameCallback implements Choreographer.FrameCallback {

    /* renamed from: a */
    private static long f50650a = 0;

    /* renamed from: b */
    private static long f50651b = 0;

    /* renamed from: c */
    private static final long f50652c = 16600000;

    public void doFrame(long j) {
        if (!OmegaFPS.getInstance().isPause()) {
            if (f50650a == 0) {
                f50650a = j;
                Choreographer.getInstance().postFrameCallback(this);
                return;
            }
            OmegaFPS.getInstance().addFrame();
            f50651b = j;
            final long a = m37734a(f50650a, j);
            if (a > 30 && a > (MASConfig.LAG_TIME / 1000) * 60 && OmegaLag.getInstance().isLagChecking() && AppStateMonitor.getInstance().isInForeground() && ScreenChangeReceiver.SCREEN_STATE == ScreenChangeReceiver.ScreenState.ON) {
                OmegaSDKAdapter.trackMasEvent("omg_fps_df", (String) null, new HashMap<String, Object>() {
                    {
                        put("num", Long.valueOf(a));
                    }
                });
            }
            f50650a = f50651b;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* renamed from: a */
    private long m37734a(long j, long j2) {
        long j3 = j2 - j;
        if (j3 > f50652c) {
            return (j3 / f50652c) - 1;
        }
        return 0;
    }
}
