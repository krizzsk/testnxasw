package com.didi.dimina.container.mina;

import android.app.ActivityManager;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.TraceUtil;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class DMMinaPerformance {

    /* renamed from: a */
    private static final long f18784a = -1;

    /* renamed from: b */
    private static final long f18785b = 0;

    /* renamed from: A */
    private long f18786A = -1;

    /* renamed from: B */
    private long f18787B = -1;

    /* renamed from: C */
    private long f18788C = -1;

    /* renamed from: D */
    private long f18789D = -1;

    /* renamed from: E */
    private long f18790E;

    /* renamed from: F */
    private long f18791F;

    /* renamed from: G */
    private boolean f18792G = false;

    /* renamed from: H */
    private long f18793H = -1;

    /* renamed from: I */
    private long f18794I = -1;

    /* renamed from: J */
    private volatile DMMinaPerfStorage f18795J;

    /* renamed from: K */
    private DMMinaPerfRender f18796K;

    /* renamed from: c */
    private final DMMina f18797c;

    /* renamed from: d */
    private long f18798d = -1;

    /* renamed from: e */
    private long f18799e = -1;

    /* renamed from: f */
    private long f18800f = -1;

    /* renamed from: g */
    private long f18801g = -1;

    /* renamed from: h */
    private long f18802h = -1;

    /* renamed from: i */
    private long f18803i = -1;

    /* renamed from: j */
    private long f18804j = -1;

    /* renamed from: k */
    private long f18805k = -1;

    /* renamed from: l */
    private long f18806l = -1;

    /* renamed from: m */
    private long f18807m = -1;

    /* renamed from: n */
    private long f18808n = -1;

    /* renamed from: o */
    private long f18809o = -1;

    /* renamed from: p */
    private long f18810p = -1;

    /* renamed from: q */
    private long f18811q = -1;

    /* renamed from: r */
    private long f18812r = -1;

    /* renamed from: s */
    private long f18813s = -1;

    /* renamed from: t */
    private long f18814t = -1;

    /* renamed from: u */
    private long f18815u = 0;

    /* renamed from: v */
    private int f18816v = 0;

    /* renamed from: w */
    private long f18817w = 0;

    /* renamed from: x */
    private long f18818x = 0;

    /* renamed from: y */
    private long f18819y = 0;

    /* renamed from: z */
    private long f18820z = -1;

    public DMMinaPerformance(DMMina dMMina) {
        this.f18797c = dMMina;
    }

    /* renamed from: a */
    private long m15949a() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
    }

    public void markJSEnginePreload() {
        this.f18798d = m15949a();
    }

    public void appendStartSubPackageLoadTime(long j) {
        if (!this.f18792G) {
            this.f18818x += j;
        }
    }

    public void appendStartSubPackageLoadExec(long j) {
        if (!this.f18792G) {
            this.f18819y += j;
        }
    }

    public long getSubStartPackageLoadTime() {
        return this.f18818x;
    }

    public long getSubStartPackageLoadExec() {
        return this.f18819y;
    }

    public void markJSEngineReady() {
        this.f18799e = m15949a();
    }

    public void markWebViewOpenFirst() {
        this.f18800f = m15949a();
    }

    public void markWebViewOpen() {
        this.f18801g = m15949a();
        this.f18815u++;
    }

    public void markJSDefinedAppStart() {
        this.f18804j = m15949a();
    }

    public void markJSDefinedAppEnd() {
        this.f18805k = m15949a();
    }

    public void markJSDefinedDmStart() {
        this.f18806l = m15949a();
    }

    public void markJSDefinedDmEnd() {
        this.f18807m = m15949a();
    }

    public void markJSRequireStart() {
        this.f18808n = m15949a();
    }

    public void markLaunchEntryBackground() {
        this.f18816v = 1;
    }

    public void markForceUpdate() {
        this.f18820z = 1;
    }

    public void markNotForceUpdate() {
        this.f18820z = -1;
    }

    public void markJSRequireEnd() {
        this.f18809o = m15949a();
    }

    public void markJSPackageStart() {
        this.f18810p = m15949a();
    }

    public long getMarkJSPackageStart() {
        return this.f18810p;
    }

    public void markJSPackageEnd() {
        this.f18811q = m15949a();
    }

    public void markWinDone() {
        if (!this.f18792G) {
            TraceUtil.trackEventCoreDotting(this.f18797c.getMinaIndex(), Constant.CORE_DOTTING.PAGE_FIRST_INVOKE_PARAMS_TO_WIN_DONE, "");
        }
        this.f18813s = m15949a();
    }

    public void markAppLaunch() {
        this.f18802h = m15949a();
        this.f18792G = false;
        this.f18812r = m15951b();
        TraceUtil.trackAppOpenRateStart(this.f18797c.getMinaIndex());
    }

    public void markNativeJsReady() {
        this.f18803i = m15949a();
        this.f18817w = System.currentTimeMillis();
    }

    public void markDmServiceExecuteStart() {
        this.f18786A = m15949a();
    }

    public void markDmServiceExecuteEnd() {
        this.f18787B = m15949a();
    }

    public void markAppServiceExecuteStart() {
        this.f18788C = m15949a();
        m15953c();
    }

    public void markAppServiceExecuteEnd() {
        this.f18789D = m15949a();
        m15953c();
    }

    public void setRemoteInstallStartTime() {
        this.f18793H = m15949a();
    }

    public void setRemoteInstallEndTime() {
        this.f18794I = m15949a();
    }

    public void markNativeJSBusinessReady() {
        this.f18814t = m15949a();
    }

    public void markDOMReady(DMPage dMPage) {
        if (!this.f18792G) {
            this.f18792G = true;
            m15952b(dMPage);
            TraceUtil.trackEventCoreDotting(this.f18797c.getMinaIndex(), Constant.CORE_DOTTING.DIMINA_PAGE_FIRST_DOM_READY, "onlaunch");
            m15954c(dMPage);
            return;
        }
        m15950a(dMPage);
        DMLaunchLifecycleManager.getInstance().hookPageDomReady(this.f18797c, dMPage);
    }

    public boolean isFirstDomReady() {
        return this.f18792G;
    }

    /* renamed from: a */
    private void m15950a(DMPage dMPage) {
        if (this.f18801g != -1) {
            try {
                this.f18790E = m15952b(dMPage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f18801g = -1;
        }
    }

    public void traceInteractionTime(String str) {
        TraceUtil.traceInteractionTime(this.f18797c.getMinaIndex(), m15949a() - this.f18801g, str);
    }

    /* renamed from: b */
    private long m15952b(DMPage dMPage) {
        long a = m15949a();
        long j = a - this.f18801g;
        if (this.f18802h != -1) {
            TimeUnit.MILLISECONDS.toSeconds(a - this.f18802h);
        }
        if (dMPage != null) {
            String url = dMPage.getUrl();
            HttpUtil.splitPath(url);
            JSONUtil.combineJson(JSONUtil.toJSONObject(dMPage.getNavigateConfig().query), HttpUtil.parseUrlQueryJSONObject(this.f18797c.getConfig().getLaunchConfig().getAppId(), url));
        }
        return j;
    }

    /* renamed from: c */
    private void m15954c(DMPage dMPage) {
        long j;
        long j2;
        DMPage dMPage2 = dMPage;
        long a = m15949a();
        String str = "";
        if (dMPage2 != null) {
            try {
                str = HttpUtil.splitPath(dMPage.getUrl());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JSONObject combineJson = JSONUtil.combineJson(HttpUtil.parseUrlQueryJSONObject(this.f18797c.getConfig().getLaunchConfig().getAppId(), str), this.f18797c.getConfig().getLaunchConfig().getExtraOptions());
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "openType", (Object) "appLaunch");
        JSONUtil.put(jSONObject, "url", (Object) str);
        JSONUtil.put(jSONObject, "query", (Object) combineJson.toString());
        long j3 = this.f18802h != -1 ? a - this.f18802h : 0;
        if (this.f18799e != -1) {
            int i = (this.f18798d > -1 ? 1 : (this.f18798d == -1 ? 0 : -1));
        }
        long j4 = this.f18800f != -1 ? a - this.f18800f : 0;
        long j5 = (this.f18805k == -1 || this.f18804j == -1) ? 0 : this.f18805k - this.f18804j;
        long j6 = (this.f18807m == -1 || this.f18806l == -1) ? 0 : this.f18807m - this.f18806l;
        if (this.f18809o == -1 || this.f18808n == -1) {
            j2 = j6;
            j = 0;
        } else {
            j2 = j6;
            j = this.f18809o - this.f18808n;
        }
        long j7 = (this.f18811q == -1 || this.f18810p == -1) ? 0 : this.f18811q - this.f18810p;
        long j8 = this.f18813s != -1 ? a - this.f18813s : 0;
        this.f18790E = j4;
        this.f18791F = j3;
        TraceUtil.trackEventLaunchPerformance2(this.f18797c.getMinaIndex(), j2 + j5, j, j7, j8, this.f18816v);
        m15951b();
        TraceUtil.trackAppOpenRateEnd(this.f18797c.getMinaIndex(), 1, this.f18794I - this.f18793H, m15955d(), j4, m15949a() - this.f18802h, DMMinaHelper.getCurPath(this.f18797c), "0", "");
        DMLaunchLifecycleManager.getInstance().hookFirstPageDomReady(this.f18797c, dMPage2);
        this.f18798d = -1;
        this.f18799e = -1;
        this.f18800f = -1;
        this.f18803i = -1;
        this.f18814t = -1;
        this.f18816v = 0;
        this.f18786A = -1;
        this.f18787B = -1;
        this.f18788C = -1;
        this.f18789D = -1;
        this.f18793H = -1;
        this.f18794I = -1;
    }

    public void markLaunchFail(int i, String str) {
        int minaIndex = this.f18797c.getMinaIndex();
        String curPath = DMMinaHelper.getCurPath(this.f18797c);
        TraceUtil.trackAppOpenRateEnd(minaIndex, -1, 0, 0, 0, 0, curPath, "" + i, str);
    }

    /* renamed from: b */
    private long m15951b() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) Dimina.getConfig().getApp().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1048576;
    }

    public long getLaunchTime() {
        return this.f18817w;
    }

    public long getForceUpdate() {
        return this.f18820z;
    }

    public long getDidOpenCount() {
        return this.f18815u;
    }

    public long getLaunchDuration() {
        return this.f18791F;
    }

    public long getCurPageChangeTime() {
        return this.f18790E;
    }

    public long getMarkAppLaunchTime() {
        return this.f18802h;
    }

    public long getMarkJSEnginePreloadTime() {
        return this.f18798d;
    }

    public long getMarkJSEngineReadyTime() {
        return this.f18799e;
    }

    public long getMarkJSDefinedDmStart() {
        return this.f18806l;
    }

    public long getMarkJSDefinedDmEnd() {
        return this.f18807m;
    }

    public DMMinaPerfStorage getMinaPerfStorage() {
        if (!Dimina.getConfig().isDebug()) {
            return null;
        }
        if (this.f18795J == null) {
            synchronized (this) {
                if (this.f18795J == null) {
                    this.f18795J = new DMMinaPerfStorage(this.f18797c.getActivity().getApplication(), this.f18797c.getConfig().getLaunchConfig().getAppId());
                }
            }
        }
        return this.f18795J;
    }

    public DMMinaPerfRender getPerfRender() {
        if (!Dimina.getConfig().isDebug()) {
            return null;
        }
        if (this.f18796K == null) {
            synchronized (this) {
                if (this.f18796K == null) {
                    this.f18796K = new DMMinaPerfRender();
                }
            }
        }
        return this.f18796K;
    }

    /* renamed from: c */
    private void m15953c() {
        if (this.f18787B != -1 && this.f18789D != -1) {
            TraceUtil.trackJscoreExecute(this.f18797c.getMinaIndex(), this.f18787B - this.f18786A, this.f18789D - this.f18788C, m15955d());
        }
    }

    /* renamed from: d */
    private long m15955d() {
        long j = this.f18787B;
        if (j != -1) {
            long j2 = this.f18789D;
            if (j2 != -1) {
                if (j <= j2) {
                    j = j2;
                }
                long j3 = this.f18786A;
                long j4 = this.f18788C;
                if (j3 > j4) {
                    j3 = j4;
                }
                return j - j3;
            }
        }
        return -1;
    }
}
