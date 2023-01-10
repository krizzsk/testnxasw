package xcrash;

import com.didi.sdk.apm.SystemUtils;

/* renamed from: xcrash.b */
/* compiled from: DefaultLogger */
class C3716b implements ILogger {
    C3716b() {
    }

    /* renamed from: v */
    public void mo43611v(String str, String str2) {
        SystemUtils.log(2, str, str2, (Throwable) null, "xcrash.DefaultLogger", 30);
    }

    /* renamed from: v */
    public void mo43612v(String str, String str2, Throwable th) {
        SystemUtils.log(2, str, str2, th, "xcrash.DefaultLogger", 35);
    }

    /* renamed from: d */
    public void mo43605d(String str, String str2) {
        SystemUtils.log(3, str, str2, (Throwable) null, "xcrash.DefaultLogger", 40);
    }

    /* renamed from: d */
    public void mo43606d(String str, String str2, Throwable th) {
        SystemUtils.log(3, str, str2, th, "xcrash.DefaultLogger", 45);
    }

    /* renamed from: i */
    public void mo43609i(String str, String str2) {
        SystemUtils.log(4, str, str2, (Throwable) null, "xcrash.DefaultLogger", 50);
    }

    /* renamed from: i */
    public void mo43610i(String str, String str2, Throwable th) {
        SystemUtils.log(4, str, str2, th, "xcrash.DefaultLogger", 55);
    }

    /* renamed from: w */
    public void mo43613w(String str, String str2) {
        SystemUtils.log(5, str, str2, (Throwable) null, "xcrash.DefaultLogger", 60);
    }

    /* renamed from: w */
    public void mo43614w(String str, String str2, Throwable th) {
        SystemUtils.log(5, str, str2, th, "xcrash.DefaultLogger", 65);
    }

    /* renamed from: e */
    public void mo43607e(String str, String str2) {
        SystemUtils.log(6, str, str2, (Throwable) null, "xcrash.DefaultLogger", 70);
    }

    /* renamed from: e */
    public void mo43608e(String str, String str2, Throwable th) {
        SystemUtils.log(6, str, str2, th, "xcrash.DefaultLogger", 75);
    }
}
