package com.didichuxing.mas.sdk.quality.collect.fps;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.WindowManager;
import com.didichuxing.mas.sdk.quality.collect.lag.OmegaLag;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.backend.AppStateMonitor;
import com.didichuxing.mas.sdk.quality.report.backend.ScreenChangeListener;
import com.didichuxing.mas.sdk.quality.report.backend.ScreenChangeReceiver;
import com.didichuxing.mas.sdk.quality.report.utils.JsonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class OmegaFPS {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static Map<Long, Integer> f50653f = null;

    /* renamed from: g */
    private static boolean f50654g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static float f50655h = 60.0f;

    /* renamed from: j */
    private static OmegaFPS f50656j;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long f50657a = 0;

    /* renamed from: b */
    private Timer f50658b = new Timer(true);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f50659c = 0;

    /* renamed from: d */
    private Timer f50660d = new Timer(true);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f50661e = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f50662i = false;

    /* renamed from: k */
    private AppStateMonitor.AppStateListener f50663k;

    /* renamed from: l */
    private ScreenChangeListener f50664l;

    private OmegaFPS() {
        f50653f = new LinkedHashMap<Long, Integer>() {
            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<Long, Integer> entry) {
                return size() > MASConfig.FPS_LATEST_CACHE_NUM;
            }
        };
    }

    /* renamed from: c */
    private void m37744c() {
        this.f50663k = new AppStateMonitor.AppStateListener() {
            public void onInForeground() {
                OmegaFPS.this.resume();
            }

            public void onInBackground() {
                OmegaFPS.this.pause();
                boolean unused = OmegaFPS.this.f50662i = true;
            }
        };
        this.f50664l = new ScreenChangeListener() {
            public void screenOn() {
            }

            public void screenOff() {
                OmegaFPS.this.pause();
                boolean unused = OmegaFPS.this.f50662i = true;
            }
        };
        AppStateMonitor.getInstance().registerAppStateListener(this.f50663k);
        ScreenChangeReceiver.addScreenChangeListener(this.f50664l);
    }

    /* renamed from: d */
    private void m37746d() {
        if (this.f50663k != null) {
            AppStateMonitor.getInstance().unregisterAppStateListener(this.f50663k);
            this.f50663k = null;
        }
        ScreenChangeListener screenChangeListener = this.f50664l;
        if (screenChangeListener != null) {
            ScreenChangeReceiver.removeScreenChangeListener(screenChangeListener);
            this.f50664l = null;
        }
    }

    public static synchronized OmegaFPS getInstance() {
        OmegaFPS omegaFPS;
        synchronized (OmegaFPS.class) {
            if (f50656j == null) {
                f50656j = new OmegaFPS();
            }
            omegaFPS = f50656j;
        }
        return omegaFPS;
    }

    public void start(Context context, final long j, long j2) {
        if (!f50654g) {
            f50654g = true;
            m37744c();
            try {
                f50655h = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate();
            } catch (Exception e) {
                OLog.m37861e("system refresh rate err:" + e.toString());
                OmegaSDKAdapter.trackMasEvent("omg_system_rr", (String) null, new HashMap<String, Object>() {
                    {
                        put("rate", Float.valueOf(OmegaFPS.f50655h));
                    }
                });
            }
            m37747e();
            this.f50658b.schedule(new TimerTask() {
                public void run() {
                    if (!OmegaFPS.this.f50661e) {
                        if (!OmegaFPS.this.f50662i) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("fps", Float.valueOf((((float) (OmegaFPS.this.f50657a / (j / 1000))) / OmegaFPS.f50655h) * 60.0f));
                            hashMap.put("lag", Integer.valueOf(OmegaLag.getInstance().isLagChecking() ? 1 : 0));
                            hashMap.put("interval", Long.valueOf(j));
                            hashMap.put("refreshRate", Float.valueOf(OmegaFPS.f50655h));
                            OmegaSDKAdapter.trackMasEvent("omg_fps", (String) null, hashMap);
                        } else {
                            boolean unused = OmegaFPS.this.f50662i = false;
                        }
                    }
                    long unused2 = OmegaFPS.this.f50657a = 0;
                }
            }, j, j);
            this.f50660d.schedule(new TimerTask() {
                public void run() {
                    if (!OmegaFPS.this.f50661e) {
                        synchronized (OmegaFPS.f50653f) {
                            OmegaFPS.f50653f.put(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(OmegaFPS.this.f50659c));
                        }
                    }
                    int unused = OmegaFPS.this.f50659c = 0;
                }
            }, j2, j2);
        }
    }

    /* renamed from: e */
    private void m37747e() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (Build.VERSION.SDK_INT >= 16) {
                    try {
                        Choreographer.getInstance().postFrameCallback(new FPSFrameCallback());
                        boolean unused = OmegaFPS.this.f50661e = false;
                    } catch (Throwable th) {
                        OLog.m37861e("init fps fail! " + th.toString());
                    }
                }
            }
        });
    }

    public void stop() {
        Timer timer = this.f50658b;
        if (timer != null) {
            timer.cancel();
            this.f50658b = null;
            this.f50661e = true;
            m37746d();
        }
    }

    public void pause() {
        if (this.f50658b != null) {
            this.f50661e = true;
        }
    }

    public void resume() {
        if (this.f50658b != null) {
            this.f50661e = false;
            m37747e();
        }
    }

    public boolean isPause() {
        return this.f50661e;
    }

    public void addFrame() {
        this.f50657a++;
        this.f50659c++;
    }

    public String getLatestFPS() {
        if (!f50654g) {
            return "";
        }
        HashMap hashMap = new HashMap();
        synchronized (f50653f) {
            for (Long next : f50653f.keySet()) {
                hashMap.put(String.valueOf(next), f50653f.get(next));
            }
        }
        return JsonUtil.map2Json(hashMap);
    }

    public float getSystemRefreshRate() {
        return f50655h;
    }

    public void setBacked(boolean z) {
        this.f50662i = z;
    }
}
