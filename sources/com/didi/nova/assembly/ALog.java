package com.didi.nova.assembly;

public class ALog {

    /* renamed from: a */
    static boolean f31545a;

    /* renamed from: b */
    static ILog f31546b;

    public interface ILog {
        /* renamed from: d */
        void mo85945d(String str);

        /* renamed from: e */
        void mo85946e(String str);

        /* renamed from: i */
        void mo85947i(String str);
    }

    /* renamed from: d */
    public static void m24111d(String str) {
        if (f31545a) {
            f31546b.mo85945d(str);
        }
    }

    /* renamed from: i */
    public static void m24113i(String str) {
        if (f31545a) {
            f31546b.mo85947i(str);
        }
    }

    /* renamed from: e */
    public static void m24112e(String str) {
        if (f31545a) {
            f31546b.mo85946e(str);
        }
    }
}
