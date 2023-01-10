package com.didi.map.utils.logger;

public class DiskLogAdapter implements LogAdapter {

    /* renamed from: a */
    private final FormatStrategy f31498a;

    public boolean isLoggable(int i, String str) {
        return true;
    }

    public DiskLogAdapter() {
        this.f31498a = CsvFormatStrategy.newBuilder().build();
    }

    public DiskLogAdapter(FormatStrategy formatStrategy) {
        this.f31498a = (FormatStrategy) C11057b.m24081b(formatStrategy);
    }

    public void log(int i, String str, String str2) {
        this.f31498a.log(i, str, str2);
    }
}
