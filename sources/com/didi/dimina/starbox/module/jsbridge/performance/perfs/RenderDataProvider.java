package com.didi.dimina.starbox.module.jsbridge.performance.perfs;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.DMMinaPerfRender;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IDataProvider;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IPerformance;
import com.didi.dimina.starbox.p108ui.windowpop.GlobalDispatcher;
import com.didi.dimina.starbox.util.ForegroundChecker;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.google.gson.Gson;

public class RenderDataProvider implements IPerformance<Long>, ForegroundChecker.OnForegroundChange, Runnable {

    /* renamed from: a */
    private IDataProvider<Long> f19968a;

    /* renamed from: b */
    private final String f19969b;

    /* renamed from: c */
    private long f19970c;

    public RenderDataProvider(String str) {
        this.f19969b = str;
    }

    public void registerProvider(IDataProvider<Long> iDataProvider) {
        this.f19968a = iDataProvider;
        GlobalDispatcher.post(this);
    }

    public void run() {
        m16941a();
        this.f19968a.onProvide(Long.valueOf(Math.max(0, this.f19970c)));
        GlobalDispatcher.postDelay(this, 1000);
    }

    /* renamed from: a */
    private void m16941a() {
        DMMina findDMMinaByAppId = DMMinaPool.findDMMinaByAppId(this.f19969b);
        if (findDMMinaByAppId != null) {
            try {
                WebViewEngine webView = findDMMinaByAppId.getCurNavigator().getCurrentPage().getPage().getWebViewContainer().getWebView();
                DMMinaPerfRender perfRender = findDMMinaByAppId.getPerformance().getPerfRender();
                if (perfRender != null) {
                    perfRender.evaluateJS4Timing(webView, new DMMinaPerfRender.OnRenderPerfRecorder() {
                        public void record(String str, String str2) {
                            RenderDataProvider.this.record(str, str2);
                        }
                    });
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void record(String str, String str2) {
        if (DMMinaPerfRender.RENDER_TIMING_TAG.equalsIgnoreCase(str)) {
            WebPerformanceTiming webPerformanceTiming = (WebPerformanceTiming) new Gson().fromJson(str2, WebPerformanceTiming.class);
            this.f19970c = webPerformanceTiming.loadEventEnd - (webPerformanceTiming.navigationStart <= 0 ? webPerformanceTiming.startTime : webPerformanceTiming.navigationStart);
            LogUtil.m16838d("WebPerformanceTiming", "   \n重定向时间:" + (webPerformanceTiming.redirectEnd - webPerformanceTiming.redirectStart) + "\nDNS解析时间:" + (webPerformanceTiming.domainLookupEnd - webPerformanceTiming.domainLookupStart) + "\nTCP完成握手时间:" + (webPerformanceTiming.connectEnd - webPerformanceTiming.connectStart) + "\nHTTP请求响应完成时间:" + (webPerformanceTiming.responseEnd - webPerformanceTiming.requestStart) + "\nDOM加载完成时间:" + (webPerformanceTiming.domComplete - webPerformanceTiming.domLoading) + "\ncss、js等内嵌资源加载:" + (webPerformanceTiming.domComplete - webPerformanceTiming.domInteractive) + "\n脚本加载时间:" + (webPerformanceTiming.domContentLoadedEventEnd - webPerformanceTiming.domContentLoadedEventStart) + "\ndomReady时间:" + (webPerformanceTiming.domContentLoadedEventEnd - webPerformanceTiming.fetchStart) + "\nonLoad事件时间:" + (webPerformanceTiming.loadEventEnd - webPerformanceTiming.loadEventStart) + "\n页面完全加载时间:" + this.f19970c);
            StringBuilder sb = new StringBuilder();
            sb.append("record ");
            sb.append(webPerformanceTiming);
            SystemUtils.log(6, SDKConsts.TAG_KEY_RECORD, sb.toString(), (Throwable) null, "com.didi.dimina.starbox.module.jsbridge.performance.perfs.RenderDataProvider", 85);
            return;
        }
        SystemUtils.log(6, SDKConsts.TAG_KEY_RECORD, "record " + str + "    " + str2, (Throwable) null, "com.didi.dimina.starbox.module.jsbridge.performance.perfs.RenderDataProvider", 88);
    }

    public static class WebPerformanceTiming {
        public long connectEnd;
        public long connectStart;
        public long domComplete;
        public long domContentLoadedEventEnd;
        public long domContentLoadedEventStart;
        public long domInteractive;
        public long domLoading;
        public long domainLookupEnd;
        public long domainLookupStart;
        public long fetchStart;
        public long loadEventEnd;
        public long loadEventStart;
        public long navigationStart;
        public long redirectEnd;
        public long redirectStart;
        public long requestStart;
        public long responseEnd;
        public long responseStart;
        public long secureConnectionStart;
        public long startTime;
        public long unloadEventEnd;
        public long unloadEventStart;

        public String toString() {
            return "WebPerformanceTiming{startTime=" + this.startTime + ", navigationStart=" + this.navigationStart + ", unloadEventEnd=" + this.unloadEventEnd + ", redirectStart=" + this.redirectStart + ", redirectEnd=" + this.redirectEnd + ", fetchStart=" + this.fetchStart + ", domainLookupStart=" + this.domainLookupStart + ", domainLookupEnd=" + this.domainLookupEnd + ", connectStart=" + this.connectStart + ", connectEnd=" + this.connectEnd + ", secureConnectionStart=" + this.secureConnectionStart + ", requestStart=" + this.requestStart + ", responseStart=" + this.responseStart + ", responseEnd=" + this.responseEnd + ", domLoading=" + this.domLoading + ", domInteractive=" + this.domInteractive + ", unloadEventStart=" + this.unloadEventStart + ", domContentLoadedEventStart=" + this.domContentLoadedEventStart + ", domContentLoadedEventEnd=" + this.domContentLoadedEventEnd + ", domComplete=" + this.domComplete + ", loadEventStart=" + this.loadEventStart + ", loadEventEnd=" + this.loadEventEnd + '}';
        }
    }

    public void onChange(boolean z) {
        GlobalDispatcher.removeCallbacks(this);
        if (z) {
            GlobalDispatcher.post(this);
        }
    }
}
