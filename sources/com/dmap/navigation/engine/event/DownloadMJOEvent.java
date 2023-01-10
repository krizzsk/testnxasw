package com.dmap.navigation.engine.event;

public class DownloadMJOEvent extends NaviEvent {

    /* renamed from: a */
    private final long f54415a;

    /* renamed from: b */
    private final String f54416b;

    /* renamed from: c */
    private final String f54417c;

    /* renamed from: d */
    private final String f54418d;

    public DownloadMJOEvent(long j, String str, String str2, String str3) {
        this.f54415a = j;
        this.f54416b = str;
        this.f54417c = str2;
        this.f54418d = str3;
    }

    public String toString() {
        return "DownloadMjoEvent{mjoId=" + this.f54415a + ", url='" + this.f54416b + '\'' + ", configUrl='" + this.f54417c + '\'' + ", commonUrl='" + this.f54418d + '\'' + '}';
    }

    public long getMjoId() {
        return this.f54415a;
    }

    public String getUrl() {
        return this.f54416b;
    }

    public String getConfigUrl() {
        return this.f54417c;
    }

    public String getCommonUrl() {
        return this.f54418d;
    }
}
