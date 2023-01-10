package com.didi.map.utils.logger;

public class PrettyFormatStrategy implements FormatStrategy {

    /* renamed from: a */
    private static final int f31502a = 4000;

    /* renamed from: b */
    private static final int f31503b = 5;

    /* renamed from: c */
    private static final char f31504c = '┌';

    /* renamed from: d */
    private static final char f31505d = '└';

    /* renamed from: e */
    private static final char f31506e = '├';

    /* renamed from: f */
    private static final char f31507f = '│';

    /* renamed from: g */
    private static final String f31508g = "────────────────────────────────────────────────────────";

    /* renamed from: h */
    private static final String f31509h = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";

    /* renamed from: i */
    private static final String f31510i = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";

    /* renamed from: j */
    private static final String f31511j = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";

    /* renamed from: k */
    private static final String f31512k = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";

    /* renamed from: l */
    private final int f31513l;

    /* renamed from: m */
    private final int f31514m;

    /* renamed from: n */
    private final boolean f31515n;

    /* renamed from: o */
    private final LogStrategy f31516o;

    /* renamed from: p */
    private final String f31517p;

    private PrettyFormatStrategy(Builder builder) {
        C11057b.m24081b(builder);
        this.f31513l = builder.methodCount;
        this.f31514m = builder.methodOffset;
        this.f31515n = builder.showThreadInfo;
        this.f31516o = builder.logStrategy;
        this.f31517p = builder.tag;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void log(int i, String str, String str2) {
        C11057b.m24081b(str2);
        String b = m24053b(str);
        m24050a(i, b);
        m24051a(i, b, this.f31513l);
        byte[] bytes = str2.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            if (this.f31513l > 0) {
                m24056c(i, b);
            }
            m24052a(i, b, str2);
            m24054b(i, b);
            return;
        }
        if (this.f31513l > 0) {
            m24056c(i, b);
        }
        for (int i2 = 0; i2 < length; i2 += 4000) {
            m24052a(i, b, new String(bytes, i2, Math.min(length - i2, 4000)));
        }
        m24054b(i, b);
    }

    /* renamed from: a */
    private void m24050a(int i, String str) {
        m24055b(i, str, f31510i);
    }

    /* renamed from: a */
    private void m24051a(int i, String str, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.f31515n) {
            m24055b(i, str, "│ Thread: " + Thread.currentThread().getName());
            m24056c(i, str);
        }
        int a = m24048a(stackTrace) + this.f31514m;
        if (i2 + a > stackTrace.length) {
            i2 = (stackTrace.length - a) - 1;
        }
        String str2 = "";
        while (i2 > 0) {
            int i3 = i2 + a;
            if (i3 < stackTrace.length) {
                str2 = str2 + "   ";
                m24055b(i, str, f31507f + ' ' + str2 + m24049a(stackTrace[i3].getClassName()) + "." + stackTrace[i3].getMethodName() + " " + " (" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ")");
            }
            i2--;
        }
    }

    /* renamed from: b */
    private void m24054b(int i, String str) {
        m24055b(i, str, f31511j);
    }

    /* renamed from: c */
    private void m24056c(int i, String str) {
        m24055b(i, str, f31512k);
    }

    /* renamed from: a */
    private void m24052a(int i, String str, String str2) {
        C11057b.m24081b(str2);
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            m24055b(i, str, "│ " + str3);
        }
    }

    /* renamed from: b */
    private void m24055b(int i, String str, String str2) {
        C11057b.m24081b(str2);
        this.f31516o.log(i, str, str2);
    }

    /* renamed from: a */
    private String m24049a(String str) {
        C11057b.m24081b(str);
        return str.substring(str.lastIndexOf(".") + 1);
    }

    /* renamed from: a */
    private int m24048a(StackTraceElement[] stackTraceElementArr) {
        C11057b.m24081b(stackTraceElementArr);
        for (int i = 5; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(C11056a.class.getName()) && !className.equals(Logger.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }

    /* renamed from: b */
    private String m24053b(String str) {
        if (C11057b.m24079a((CharSequence) str) || C11057b.m24080a(this.f31517p, str)) {
            return this.f31517p;
        }
        return this.f31517p + "-" + str;
    }

    public static class Builder {
        LogStrategy logStrategy;
        int methodCount;
        int methodOffset;
        boolean showThreadInfo;
        String tag;

        private Builder() {
            this.methodCount = 2;
            this.methodOffset = 0;
            this.showThreadInfo = true;
            this.tag = "PRETTY_LOGGER";
        }

        public Builder methodCount(int i) {
            this.methodCount = i;
            return this;
        }

        public Builder methodOffset(int i) {
            this.methodOffset = i;
            return this;
        }

        public Builder showThreadInfo(boolean z) {
            this.showThreadInfo = z;
            return this;
        }

        public Builder logStrategy(LogStrategy logStrategy2) {
            this.logStrategy = logStrategy2;
            return this;
        }

        public Builder tag(String str) {
            this.tag = str;
            return this;
        }

        public PrettyFormatStrategy build() {
            if (this.logStrategy == null) {
                this.logStrategy = new LogcatLogStrategy();
            }
            return new PrettyFormatStrategy(this);
        }
    }
}
