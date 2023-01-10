package com.didi.map.utils.logger;

import android.os.HandlerThread;
import com.didi.map.utils.logger.DiskLogStrategy;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CsvFormatStrategy implements FormatStrategy {

    /* renamed from: a */
    private static final String f31491a = System.getProperty("line.separator");

    /* renamed from: b */
    private static final String f31492b = " <br> ";

    /* renamed from: c */
    private static final String f31493c = ",";

    /* renamed from: d */
    private final Date f31494d;

    /* renamed from: e */
    private final SimpleDateFormat f31495e;

    /* renamed from: f */
    private final LogStrategy f31496f;

    /* renamed from: g */
    private final String f31497g;

    private CsvFormatStrategy(Builder builder) {
        C11057b.m24081b(builder);
        this.f31494d = builder.date;
        this.f31495e = builder.dateFormat;
        this.f31496f = builder.logStrategy;
        this.f31497g = builder.tag;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void log(int i, String str, String str2) {
        C11057b.m24081b(str2);
        String a = m24039a(str);
        this.f31494d.setTime(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(this.f31494d.getTime()));
        sb.append(",");
        sb.append(this.f31495e.format(this.f31494d));
        sb.append(",");
        sb.append(C11057b.m24076a(i));
        sb.append(",");
        sb.append(a);
        if (str2.contains(f31491a)) {
            str2 = str2.replaceAll(f31491a, f31492b);
        }
        sb.append(",");
        sb.append(str2);
        sb.append(f31491a);
        this.f31496f.log(i, a, sb.toString());
    }

    /* renamed from: a */
    private String m24039a(String str) {
        if (C11057b.m24079a((CharSequence) str) || C11057b.m24080a(this.f31497g, str)) {
            return this.f31497g;
        }
        return this.f31497g + "-" + str;
    }

    public static final class Builder {
        private static final int MAX_BYTES = 512000;
        Date date;
        SimpleDateFormat dateFormat;
        LogStrategy logStrategy;
        String tag;

        private Builder() {
            this.tag = "PRETTY_LOGGER";
        }

        public Builder date(Date date2) {
            this.date = date2;
            return this;
        }

        public Builder dateFormat(SimpleDateFormat simpleDateFormat) {
            this.dateFormat = simpleDateFormat;
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

        public CsvFormatStrategy build() {
            if (this.date == null) {
                this.date = new Date();
            }
            if (this.dateFormat == null) {
                this.dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS", Locale.UK);
            }
            if (this.logStrategy == null) {
                String str = SystemUtils.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "logger";
                HandlerThread handlerThread = new HandlerThread("AndroidFileLogger." + str);
                handlerThread.start();
                this.logStrategy = new DiskLogStrategy(new DiskLogStrategy.WriteHandler(handlerThread.getLooper(), str, 512000));
            }
            return new CsvFormatStrategy(this);
        }
    }
}
