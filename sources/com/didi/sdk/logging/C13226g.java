package com.didi.sdk.logging;

import com.didi.sdk.logging.util.Debug;
import com.didi.sdk.logging.util.LoggerUtils;
import com.didi.sdk.logging.util.RollingCalendar;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.didi.sdk.logging.g */
/* compiled from: SizeAndTimeBasedRollingPolicy */
class C13226g extends C13214a {

    /* renamed from: b */
    private final RollingCalendar f39320b;

    /* renamed from: c */
    private C13223d f39321c;

    /* renamed from: d */
    private long f39322d = -1;

    /* renamed from: e */
    private long f39323e = 0;

    /* renamed from: f */
    private InvocationGate f39324f = new C13221b();

    /* renamed from: g */
    private int f39325g;

    /* renamed from: h */
    private String f39326h;

    /* renamed from: i */
    private String f39327i;

    /* renamed from: j */
    private String f39328j;

    /* renamed from: k */
    private File f39329k;

    C13226g(Type type, String str) {
        this.f39328j = type.name;
        this.f39327i = str;
        this.f39285a.setTime(mo99035d());
        this.f39326h = LoggerUtils.formatForNewFile(this.f39285a);
        this.f39320b = new RollingCalendar();
        m29637e();
    }

    /* renamed from: e */
    private void m29637e() {
        File c = mo99017c();
        this.f39329k = c;
        this.f39325g = m29636a(c, this.f39328j, this.f39327i, this.f39326h);
        this.f39321c = new C13223d(this.f39329k);
    }

    /* renamed from: c */
    public File mo99017c() {
        return LoggerContext.getDefault().getMainLogPathDir();
    }

    /* renamed from: a */
    public boolean mo99015a(File file) {
        long d = mo99035d();
        long j = this.f39323e;
        if (j == 0) {
            m29638f();
            return true;
        } else if (d > j) {
            this.f39325g = 0;
            mo99014a(d);
            m29638f();
            return true;
        } else if (this.f39324f.isTooSoon(d)) {
            return false;
        } else {
            if (!mo99017c().getPath().equals(this.f39329k.getPath())) {
                m29637e();
                return true;
            } else if (file.length() <= LoggerFactory.getConfig().getMaxFileSize()) {
                return false;
            } else {
                this.f39325g++;
                return true;
            }
        }
    }

    /* renamed from: a */
    public void mo99013a() {
        if (this.f39321c != null) {
            if (Debug.isDebuggable()) {
                Debug.m29707d("SizeAndTimeBasedRollingPolicy clean: " + this.f39285a);
            }
            this.f39321c.mo99021a(this.f39285a);
        }
    }

    /* renamed from: b */
    public String mo99016b() {
        File c = mo99017c();
        return new File(c, this.f39328j + "-" + this.f39327i + "-" + this.f39326h + "-" + this.f39325g + ".log").getAbsolutePath();
    }

    /* renamed from: d */
    public long mo99035d() {
        long j = this.f39322d;
        return j >= 0 ? j : System.currentTimeMillis();
    }

    /* renamed from: f */
    private void m29638f() {
        this.f39323e = this.f39320b.getNextTriggeringMillis(this.f39285a);
    }

    /* renamed from: a */
    public static int m29636a(File file, String str, String str2, String str3) {
        int intValue;
        File[] collectLogFiles = LoggerUtils.collectLogFiles(file, str, str2, str3);
        if (collectLogFiles.length == 0) {
            return 0;
        }
        Pattern logFileRegex = LoggerUtils.getLogFileRegex(str);
        int i = 0;
        for (File name : collectLogFiles) {
            Matcher matcher = logFileRegex.matcher(name.getName());
            if (matcher.matches() && i < (intValue = Integer.valueOf(matcher.group(4)).intValue())) {
                i = intValue;
            }
        }
        return i;
    }
}
