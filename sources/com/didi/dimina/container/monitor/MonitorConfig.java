package com.didi.dimina.container.monitor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/dimina/container/monitor/MonitorConfig;", "", "tagName", "", "isPrintLog", "", "(Ljava/lang/String;Z)V", "()Z", "setPrintLog", "(Z)V", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "changeTag", "", "newTagName", "openLog", "container_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: MonitorConfig.kt */
public final class MonitorConfig {

    /* renamed from: a */
    private String f18843a;

    /* renamed from: b */
    private boolean f18844b;

    public MonitorConfig(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "tagName");
        this.f18843a = str;
        this.f18844b = z;
    }

    public final String getTagName() {
        return this.f18843a;
    }

    public final boolean isPrintLog() {
        return this.f18844b;
    }

    public final void setPrintLog(boolean z) {
        this.f18844b = z;
    }

    public final void setTagName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f18843a = str;
    }

    public final void openLog() {
        this.f18844b = true;
    }

    public final void changeTag(String str) {
        Intrinsics.checkParameterIsNotNull(str, "newTagName");
        this.f18843a = str;
    }
}
