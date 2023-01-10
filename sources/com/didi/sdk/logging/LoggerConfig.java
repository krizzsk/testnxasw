package com.didi.sdk.logging;

import com.didi.sdk.logging.util.Objects;
import com.didi.sdk.logging.util.Supplier;
import com.didiglobal.enginecore.cache.XECacheConfig;
import java.io.File;

public class LoggerConfig {
    public static final String GLOBAL_SERVER_HOST = "https://catchdata.didiglobal.com/";

    /* renamed from: a */
    private final String f39256a;

    /* renamed from: b */
    private final int f39257b;

    /* renamed from: c */
    private final long f39258c;

    /* renamed from: d */
    private final int f39259d;

    /* renamed from: e */
    private final long f39260e;

    /* renamed from: f */
    private final Boolean f39261f;

    /* renamed from: g */
    private final Boolean f39262g;

    /* renamed from: h */
    private final boolean f39263h;

    /* renamed from: i */
    private final boolean f39264i;

    /* renamed from: j */
    private final Level f39265j;

    /* renamed from: k */
    private final Level f39266k;

    /* renamed from: l */
    private final File f39267l;

    /* renamed from: m */
    private final Supplier<String> f39268m;

    /* renamed from: n */
    private final int f39269n;

    @Deprecated
    public enum LogMode {
        MODE_NORMAL,
        MODE_UPLOAD
    }

    public String getServerHost() {
        return this.f39256a;
    }

    public int getFileMaxHistory() {
        return this.f39257b;
    }

    public long getTotalFileSize() {
        return this.f39258c;
    }

    public int getFileSectionLength() {
        return this.f39259d;
    }

    public long getMaxFileSize() {
        return this.f39260e;
    }

    public boolean isDebuggable() {
        return this.f39264i;
    }

    public Boolean isFileLogEnabled() {
        return this.f39261f;
    }

    public Boolean isLogcatLogEnabled() {
        return this.f39262g;
    }

    public Boolean isEncryptEnabled() {
        return Boolean.valueOf(this.f39263h);
    }

    public Level getFileLogLevel() {
        return this.f39265j;
    }

    public Level getLogcatLogLevel() {
        return this.f39266k;
    }

    public File getLogDir() {
        return this.f39267l;
    }

    public Supplier<String> getUidSupplier() {
        return this.f39268m;
    }

    public int getQueryTimeInterval() {
        return this.f39269n;
    }

    private LoggerConfig(Builder builder) {
        this.f39256a = builder.serverHost;
        this.f39257b = builder.fileMaxHistory;
        this.f39258c = builder.totalFileSize;
        this.f39259d = builder.fileSectionLength;
        this.f39260e = builder.maxFileSize;
        this.f39261f = builder.fileLogEnabled;
        this.f39262g = builder.logcatLogEnabled;
        this.f39263h = builder.encryptEnabled;
        this.f39264i = builder.debuggable;
        this.f39265j = builder.fileLogLevel;
        this.f39266k = builder.logcatLogLevel;
        this.f39267l = builder.logDir;
        this.f39268m = builder.uidSupplier;
        this.f39269n = builder.queryTimeInterval;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean debuggable;
        /* access modifiers changed from: private */
        public boolean encryptEnabled = true;
        /* access modifiers changed from: private */
        public Boolean fileLogEnabled;
        /* access modifiers changed from: private */
        public Level fileLogLevel = Level.INFO;
        /* access modifiers changed from: private */
        public int fileMaxHistory = 7;
        /* access modifiers changed from: private */
        public int fileSectionLength = 2097152;
        /* access modifiers changed from: private */
        public File logDir;
        /* access modifiers changed from: private */
        public Boolean logcatLogEnabled;
        /* access modifiers changed from: private */
        public Level logcatLogLevel = Level.TRACE;
        /* access modifiers changed from: private */
        public long maxFileSize = 5242880;
        /* access modifiers changed from: private */
        public int queryTimeInterval = 30;
        /* access modifiers changed from: private */
        public String serverHost = "";
        /* access modifiers changed from: private */
        public long totalFileSize = XECacheConfig.XE_CACHE_DEF_MAX_SIZE;
        /* access modifiers changed from: private */
        public Supplier<String> uidSupplier;

        @Deprecated
        public Builder phoneNumSupplier(Supplier<String> supplier) {
            return this;
        }

        public Builder serverHost(String str) {
            Objects.requireNonNull(str);
            this.serverHost = str;
            return this;
        }

        public Builder fileMaxHistory(int i) {
            this.fileMaxHistory = i;
            return this;
        }

        public Builder totalFileSize(long j) {
            this.totalFileSize = j;
            return this;
        }

        public Builder fileSectionLength(int i) {
            this.fileSectionLength = i;
            return this;
        }

        public Builder maxFileSize(long j) {
            this.maxFileSize = j;
            return this;
        }

        public Builder fileLogEnabled(boolean z) {
            this.fileLogEnabled = Boolean.valueOf(z);
            return this;
        }

        public Builder logcatLogEnabled(boolean z) {
            this.logcatLogEnabled = Boolean.valueOf(z);
            return this;
        }

        public Builder encryptEnabled(boolean z) {
            this.encryptEnabled = z;
            return this;
        }

        public Builder debuggable(boolean z) {
            this.debuggable = z;
            return this;
        }

        public Builder fileLogLevel(Level level) {
            Objects.requireNonNull(level);
            this.fileLogLevel = level;
            return this;
        }

        public Builder logcatLogLevel(Level level) {
            Objects.requireNonNull(level);
            this.logcatLogLevel = level;
            return this;
        }

        public Builder logDir(File file) {
            this.logDir = file;
            return this;
        }

        public LoggerConfig build() {
            return new LoggerConfig(this);
        }

        public Builder uid(Supplier<String> supplier) {
            this.uidSupplier = supplier;
            return this;
        }

        public Builder queryTimeInterval(int i) {
            this.queryTimeInterval = i;
            return this;
        }
    }
}
