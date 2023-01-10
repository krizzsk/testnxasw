package com.didi.dimina.container.monitor;

import kotlin.Metadata;
import org.osgi.framework.VersionRange;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u000e"}, mo148868d2 = {"Lcom/didi/dimina/container/monitor/DiminaMonitorSwitchConfig;", "", "()V", "jsCoreLog", "Lcom/didi/dimina/container/monitor/MonitorConfig;", "getJsCoreLog", "()Lcom/didi/dimina/container/monitor/MonitorConfig;", "webViewLog", "getWebViewLog", "openJSCoreLog", "", "openWebViewLog", "toString", "", "container_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: DiminaMonitorSwitchConfig.kt */
public final class DiminaMonitorSwitchConfig {

    /* renamed from: a */
    private final MonitorConfig f18841a = new MonitorConfig("[JsCore]", false);

    /* renamed from: b */
    private final MonitorConfig f18842b = new MonitorConfig("[WebView]", false);

    public final MonitorConfig getJsCoreLog() {
        return this.f18841a;
    }

    public final MonitorConfig getWebViewLog() {
        return this.f18842b;
    }

    public final void openJSCoreLog() {
        this.f18841a.openLog();
    }

    public final void openWebViewLog() {
        this.f18842b.openLog();
    }

    public String toString() {
        return "DiminaMonitorSwitchConfig(jsCoreLog=" + this.f18841a + ", webViewLog=" + this.f18842b + VersionRange.RIGHT_OPEN;
    }
}
