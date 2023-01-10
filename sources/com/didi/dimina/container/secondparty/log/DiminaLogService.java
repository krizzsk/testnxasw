package com.didi.dimina.container.secondparty.log;

import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.service.LogService;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p174dp.locsdk.Const;

public class DiminaLogService implements LogService {

    /* renamed from: a */
    private static final String f19193a = "Dimina";

    /* renamed from: b */
    private static final Logger f19194b = LoggerFactory.getLogger(f19193a, f19193a);

    /* renamed from: a */
    private static boolean m16289a() {
        return Dimina.getConfig() == null || Dimina.getConfig().isDebug();
    }

    /* renamed from: i */
    public void mo60792i(String str) {
        if (m16289a()) {
            SystemUtils.log(4, f19193a, str, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 24);
        }
    }

    /* renamed from: i */
    public void mo60793i(String str, String str2) {
        if (m16289a()) {
            SystemUtils.log(4, "Dimina [" + str + Const.jaRight, str2, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 30);
        }
    }

    /* renamed from: d */
    public void mo60786d(String str) {
        if (m16289a()) {
            SystemUtils.log(3, f19193a, str, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 36);
        }
    }

    /* renamed from: d */
    public void mo60787d(String str, String str2) {
        if (m16289a()) {
            SystemUtils.log(3, "Dimina [" + str + Const.jaRight, str2, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 42);
        }
    }

    /* renamed from: e */
    public void mo60789e(String str) {
        if (m16289a()) {
            SystemUtils.log(6, f19193a, str, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 48);
        }
    }

    /* renamed from: e */
    public void mo60790e(String str, String str2) {
        if (m16289a()) {
            SystemUtils.log(6, "Dimina [" + str + Const.jaRight, str2, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 54);
        }
    }

    /* renamed from: w */
    public void mo60795w(String str) {
        if (m16289a()) {
            SystemUtils.log(5, f19193a, str, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 60);
        }
    }

    /* renamed from: w */
    public void mo60796w(String str, String str2) {
        if (m16289a()) {
            SystemUtils.log(5, "Dimina [" + str + Const.jaRight, str2, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 66);
        }
    }

    public void iRelease(String str, String str2) {
        f19194b.info("[%s] %s", str, str2);
    }

    public void dRelease(String str, String str2) {
        f19194b.debug("[%s] %s", str, str2);
    }

    public void eRelease(String str, String str2) {
        f19194b.error("[%s] %s", str, str2);
    }

    public void wRelease(String str, String str2) {
        f19194b.warn("[%s] %s", str, str2);
    }
}
