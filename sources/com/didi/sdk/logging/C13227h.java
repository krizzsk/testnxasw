package com.didi.sdk.logging;

import com.didi.sdk.logging.util.Debug;
import com.didi.sdk.logging.util.LoggerUtils;
import com.didi.sdk.logging.util.RollingCalendar;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.didi.sdk.logging.h */
/* compiled from: SizeBasedRollingPolicy */
class C13227h extends C13214a {

    /* renamed from: b */
    private final RollingCalendar f39330b;

    /* renamed from: c */
    private C13223d f39331c;

    /* renamed from: d */
    private long f39332d = -1;

    /* renamed from: e */
    private long f39333e = 0;

    /* renamed from: f */
    private int f39334f;

    /* renamed from: g */
    private String f39335g;

    /* renamed from: h */
    private String f39336h;

    /* renamed from: i */
    private String f39337i;

    /* renamed from: j */
    private File f39338j;

    /* renamed from: k */
    private String f39339k;

    C13227h(Type type, String str) {
        this.f39337i = type.name;
        this.f39336h = str;
        this.f39285a.setTime(mo99036d());
        this.f39335g = LoggerUtils.formatForNewFile(this.f39285a);
        this.f39330b = new RollingCalendar();
        m29645e();
    }

    /* renamed from: e */
    private void m29645e() {
        File c = mo99017c();
        this.f39338j = c;
        this.f39334f = m29644a(c, this.f39337i, this.f39336h, this.f39335g);
        this.f39331c = new C13223d(this.f39338j);
    }

    /* renamed from: c */
    public File mo99017c() {
        return LoggerContext.getDefault().getMainLogPathDir();
    }

    /* renamed from: a */
    public boolean mo99015a(File file) {
        if (this.f39333e == 0) {
            m29646f();
            return true;
        } else if (!mo99017c().getPath().equals(this.f39338j.getPath())) {
            m29645e();
            return true;
        } else if (file.length() <= LoggerFactory.getConfig().getMaxFileSize()) {
            return false;
        } else {
            this.f39334f++;
            return true;
        }
    }

    /* renamed from: a */
    public void mo99013a() {
        if (this.f39331c != null && this.f39285a != null) {
            if (Debug.isDebuggable()) {
                Debug.m29707d("SizeBasedRollingPolicy clean: " + this.f39285a);
            }
            this.f39331c.mo99021a(this.f39285a);
            this.f39339k = null;
        }
    }

    /* renamed from: b */
    public String mo99016b() {
        if (this.f39339k == null) {
            File c = mo99017c();
            this.f39339k = new File(c, this.f39337i + "-" + this.f39336h + "-" + this.f39335g + "-" + this.f39334f + ".log").getAbsolutePath();
        }
        return this.f39339k;
    }

    /* renamed from: d */
    public long mo99036d() {
        long j = this.f39332d;
        return j >= 0 ? j : System.currentTimeMillis();
    }

    /* renamed from: f */
    private void m29646f() {
        this.f39333e = this.f39330b.getNextTriggeringMillis(this.f39285a);
    }

    /* renamed from: a */
    public static int m29644a(File file, String str, String str2, String str3) {
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
