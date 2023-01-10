package com.didi.map.utils.logger;

public class AndroidLogAdapter implements LogAdapter {

    /* renamed from: a */
    private final FormatStrategy f31490a;

    public boolean isLoggable(int i, String str) {
        return true;
    }

    public AndroidLogAdapter() {
        this.f31490a = PrettyFormatStrategy.newBuilder().build();
    }

    public AndroidLogAdapter(FormatStrategy formatStrategy) {
        this.f31490a = (FormatStrategy) C11057b.m24081b(formatStrategy);
    }

    public void log(int i, String str, String str2) {
        this.f31490a.log(i, str, str2);
    }
}
