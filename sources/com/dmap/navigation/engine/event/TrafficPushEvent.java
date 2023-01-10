package com.dmap.navigation.engine.event;

public class TrafficPushEvent extends NaviEvent {

    /* renamed from: a */
    private final long f54513a;

    /* renamed from: b */
    private final byte[] f54514b;

    public TrafficPushEvent(long j, byte[] bArr) {
        this.f54513a = j;
        this.f54514b = bArr;
    }

    public long getTime() {
        return this.f54513a;
    }

    public byte[] getData() {
        return this.f54514b;
    }
}
