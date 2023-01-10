package com.didi.sdk.log;

public final class Settings {

    /* renamed from: a */
    private int f39208a = 2;

    /* renamed from: b */
    private boolean f39209b = true;

    /* renamed from: c */
    private int f39210c = 0;

    /* renamed from: d */
    private LogLevel f39211d = LogLevel.FULL;

    public Settings hideThreadInfo() {
        this.f39209b = false;
        return this;
    }

    public Settings setMethodCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f39208a = i;
        return this;
    }

    public Settings setLogLevel(LogLevel logLevel) {
        this.f39211d = logLevel;
        return this;
    }

    public Settings setMethodOffset(int i) {
        this.f39210c = i;
        return this;
    }

    public int getMethodCount() {
        return this.f39208a;
    }

    public boolean isShowThreadInfo() {
        return this.f39209b;
    }

    public LogLevel getLogLevel() {
        return this.f39211d;
    }

    public int getMethodOffset() {
        return this.f39210c;
    }
}
