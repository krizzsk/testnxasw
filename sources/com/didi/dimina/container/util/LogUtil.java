package com.didi.dimina.container.util;

import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.service.LogService;

public class LogUtil {

    /* renamed from: a */
    private static final LogService f19816a = new LogService.NoneLogService();

    /* renamed from: i */
    public static void m16841i(String str) {
        if (m16836b()) {
            m16835a().mo60792i(str);
        }
    }

    /* renamed from: i */
    public static void m16842i(String str, String str2) {
        if (m16836b()) {
            m16835a().mo60793i(str, str2);
        }
    }

    /* renamed from: d */
    public static void m16837d(String str) {
        if (m16836b()) {
            m16835a().mo60786d(str);
        }
    }

    /* renamed from: d */
    public static void m16838d(String str, String str2) {
        if (m16836b()) {
            m16835a().mo60787d(str, str2);
        }
    }

    /* renamed from: e */
    public static void m16839e(String str) {
        if (m16836b()) {
            m16835a().mo60789e(str);
        }
    }

    /* renamed from: e */
    public static void m16840e(String str, String str2) {
        if (m16836b()) {
            m16835a().mo60790e(str, str2);
        }
    }

    /* renamed from: w */
    public static void m16843w(String str) {
        if (m16836b()) {
            m16835a().mo60795w(str);
        }
    }

    /* renamed from: w */
    public static void m16844w(String str, String str2) {
        if (m16836b()) {
            m16835a().mo60796w(str, str2);
        }
    }

    public static void iRelease(String str, String str2) {
        m16835a().iRelease(str, str2);
    }

    public static void dRelease(String str, String str2) {
        m16835a().dRelease(str, str2);
    }

    public static void eRelease(String str, String str2) {
        m16835a().eRelease(str, str2);
    }

    public static void wRelease(String str, String str2) {
        m16835a().wRelease(str, str2);
    }

    /* renamed from: a */
    private static LogService m16835a() {
        if (Dimina.getConfig() == null || Dimina.getConfig().getAdapterConfig() == null || Dimina.getConfig().getAdapterConfig().getLogService() == null) {
            return f19816a;
        }
        return Dimina.getConfig().getAdapterConfig().getLogService();
    }

    /* renamed from: b */
    private static boolean m16836b() {
        return Dimina.getConfig() == null || Dimina.getConfig().isDebug();
    }
}
