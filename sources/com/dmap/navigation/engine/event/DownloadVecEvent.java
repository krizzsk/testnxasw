package com.dmap.navigation.engine.event;

import java.util.Arrays;

public class DownloadVecEvent extends NaviEvent {

    /* renamed from: a */
    private final String f54419a;

    /* renamed from: b */
    private final String f54420b;

    /* renamed from: c */
    private final byte[] f54421c;

    public DownloadVecEvent(String str, String str2, byte[] bArr) {
        this.f54419a = str;
        this.f54420b = str2;
        this.f54421c = bArr;
    }

    public String toString() {
        return "DownloadVecEvent{url='" + this.f54419a + '\'' + ", key='" + this.f54420b + '\'' + ", data=" + Arrays.toString(this.f54421c) + '}';
    }

    public String getUrl() {
        return this.f54419a;
    }

    public String getKey() {
        return this.f54420b;
    }

    public byte[] getData() {
        return this.f54421c;
    }
}
