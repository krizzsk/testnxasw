package com.didi.sdk.logging;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.logging.model.AbstractLog;
import com.didi.sdk.logging.model.BinaryLog;
import com.didi.sdk.logging.model.LongLog;
import com.didi.sdk.logging.util.Objects;
import com.didi.sdk.logging.util.StringUtils;
import java.util.Date;
import java.util.Map;

/* renamed from: com.didi.sdk.logging.c */
/* compiled from: InternalLogger */
class C13222c extends AbstractLogger {

    /* renamed from: a */
    private final String f39297a;

    /* renamed from: b */
    private final LoggerConfig f39298b;

    /* renamed from: c */
    private boolean f39299c = m29617a();

    C13222c(String str, String str2, LoggerConfig loggerConfig) {
        super(str);
        this.f39298b = loggerConfig;
        this.f39297a = str2;
    }

    public boolean isTraceEnabled() {
        return Level.TRACE.level >= this.f39298b.getFileLogLevel().level || Level.TRACE.level >= this.f39298b.getLogcatLogLevel().level || Level.TRACE.level >= LoggerFactory.getFilterLevel();
    }

    public boolean isDebugEnabled() {
        return Level.DEBUG.level >= this.f39298b.getFileLogLevel().level || Level.TRACE.level >= this.f39298b.getLogcatLogLevel().level || Level.TRACE.level >= LoggerFactory.getFilterLevel();
    }

    public boolean isInfoEnabled() {
        return Level.INFO.level >= this.f39298b.getFileLogLevel().level || Level.TRACE.level >= this.f39298b.getLogcatLogLevel().level || Level.TRACE.level >= LoggerFactory.getFilterLevel();
    }

    public boolean isWarnEnabled() {
        return Level.WARN.level >= this.f39298b.getFileLogLevel().level || Level.TRACE.level >= this.f39298b.getLogcatLogLevel().level || Level.TRACE.level >= LoggerFactory.getFilterLevel();
    }

    public boolean isErrorEnabled() {
        return Level.ERROR.level >= this.f39298b.getFileLogLevel().level || Level.TRACE.level >= this.f39298b.getLogcatLogLevel().level || Level.TRACE.level >= LoggerFactory.getFilterLevel();
    }

    public void write(byte[] bArr) {
        Objects.requireNonNull(bArr);
        if (bArr.length != 0) {
            BinaryExecutor.m29577a(this.f39297a).mo98928a((AbstractLog) new BinaryLog((byte[]) bArr.clone()));
        }
    }

    public void trace(String str, Throwable th) {
        m29615a(Level.TRACE, str, th);
    }

    public void trace(String str, Object... objArr) {
        m29616a(Level.TRACE, str, (Map<?, ?>) null, objArr);
    }

    public void trace(String str, Map<?, ?> map) {
        m29616a(Level.TRACE, str, map, new Object[0]);
    }

    public void debug(String str, Throwable th) {
        m29615a(Level.DEBUG, str, th);
    }

    public void debug(String str, Object... objArr) {
        m29616a(Level.DEBUG, str, (Map<?, ?>) null, objArr);
    }

    public void debug(String str, Map<?, ?> map) {
        m29616a(Level.DEBUG, str, map, new Object[0]);
    }

    public void info(String str, Throwable th) {
        m29615a(Level.INFO, str, th);
    }

    public void info(String str, Object... objArr) {
        m29616a(Level.INFO, str, (Map<?, ?>) null, objArr);
    }

    public void info(String str, Map<?, ?> map) {
        m29616a(Level.INFO, str, map, new Object[0]);
    }

    public void warn(String str, Throwable th) {
        m29615a(Level.WARN, str, th);
    }

    public void warn(String str, Object... objArr) {
        m29616a(Level.WARN, str, (Map<?, ?>) null, objArr);
    }

    public void warn(String str, Map<?, ?> map) {
        m29616a(Level.WARN, str, map, new Object[0]);
    }

    public void error(String str, Throwable th) {
        m29615a(Level.WARN, str, th);
    }

    public void error(String str, Object... objArr) {
        m29616a(Level.ERROR, str, (Map<?, ?>) null, objArr);
    }

    public void error(String str, Map<?, ?> map) {
        m29616a(Level.ERROR, str, map, new Object[0]);
    }

    public void traceEvent(String str, Map<?, ?> map) {
        m29616a(Level.TRACE, str, mapCopy(map), new Object[0]);
    }

    public void debugEvent(String str, Map<?, ?> map) {
        m29616a(Level.DEBUG, str, mapCopy(map), new Object[0]);
    }

    public void infoEvent(String str, Map<?, ?> map) {
        m29616a(Level.INFO, str, mapCopy(map), new Object[0]);
    }

    public void warnEvent(String str, Map<?, ?> map) {
        m29616a(Level.WARN, str, mapCopy(map), new Object[0]);
    }

    public void errorEvent(String str, Map<?, ?> map) {
        m29616a(Level.ERROR, str, mapCopy(map), new Object[0]);
    }

    public void traceEvent(String str, Object... objArr) {
        m29616a(Level.TRACE, str, toMap(objArr), new Object[0]);
    }

    public void debugEvent(String str, Object... objArr) {
        m29616a(Level.DEBUG, str, toMap(objArr), new Object[0]);
    }

    public void infoEvent(String str, Object... objArr) {
        m29616a(Level.INFO, str, toMap(objArr), new Object[0]);
    }

    public void warnEvent(String str, Object... objArr) {
        m29616a(Level.WARN, str, toMap(objArr), new Object[0]);
    }

    public void errorEvent(String str, Object... objArr) {
        m29616a(Level.ERROR, str, toMap(objArr), new Object[0]);
    }

    public void log(int i, String str, Throwable th, String str2, int i2) {
        Level level = Level.getLevel(i);
        if (!LoggerContext.getDefault().isInitial() || TextUtils.isEmpty(str)) {
            return;
        }
        if (i >= this.f39298b.getFileLogLevel().level || i >= this.f39298b.getLogcatLogLevel().level || i >= LoggerFactory.getFilterLevel() || this.f39299c) {
            if (th != null) {
                str = str + "\n" + Log.getStackTraceString(th);
            }
            LogbackExecutor.m29588a(this.f39297a).mo98937a((AbstractLog) new LongLog.Builder().setLogLevel(level).setDate(new Date()).setTag(this.mName).setMsg(str).setTid(Process.myTid()).setTnm(Thread.currentThread().getName()).setClassName(str2).setLine(i2).build());
        }
    }

    /* renamed from: a */
    private void m29616a(Level level, String str, Map<?, ?> map, Object... objArr) {
        if (!LoggerContext.getDefault().isInitial() || TextUtils.isEmpty(str)) {
            return;
        }
        if (level.level >= this.f39298b.getFileLogLevel().level || level.level >= this.f39298b.getLogcatLogLevel().level || level.level >= LoggerFactory.getFilterLevel() || this.f39299c) {
            LongLog.Builder args = new LongLog.Builder().setLogLevel(level).setDate(new Date()).setTag(this.mName).setMsg(str).setTid(Process.myTid()).setTnm(Thread.currentThread().getName()).setUserInfo(map).setArgs(objArr);
            if (this.mClass != null) {
                args.setClassName(this.mClass.getName());
            }
            LogbackExecutor.m29588a(this.f39297a).mo98937a((AbstractLog) args.build());
        }
    }

    /* renamed from: a */
    private void m29615a(Level level, String str, Throwable th) {
        if (!LoggerContext.getDefault().isInitial() || TextUtils.isEmpty(str)) {
            return;
        }
        if (level.level >= this.f39298b.getFileLogLevel().level || level.level >= this.f39298b.getLogcatLogLevel().level || level.level >= LoggerFactory.getFilterLevel() || this.f39299c) {
            if (th != null) {
                str = str + "\n" + Log.getStackTraceString(th);
            }
            LogbackExecutor.m29588a(this.f39297a).mo98937a((AbstractLog) new LongLog.Builder().setLogLevel(level).setDate(new Date()).setTag(this.mName).setMsg(str).setTid(Process.myTid()).setTnm(StringUtils.ellipsize(Thread.currentThread().getName(), 20, 4)).build());
        }
    }

    public void println(String str) {
        if (LoggerContext.getDefault().isInitial() && !TextUtils.isEmpty(str)) {
            LogbackExecutor.m29588a(this.f39297a).mo98937a((AbstractLog) new LongLog.Builder().setLogLevel(Level.INFO).setTag("logging").setMsg(str).setFormat(false).build());
        }
    }

    /* renamed from: a */
    private boolean m29617a() {
        if (TextUtils.isEmpty(LoggerFactory.getFilterTag()) || TextUtils.isEmpty(this.mName)) {
            return false;
        }
        return LoggerFactory.getFilterTag().equals(this.mName);
    }
}
