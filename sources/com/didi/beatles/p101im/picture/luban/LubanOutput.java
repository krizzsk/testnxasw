package com.didi.beatles.p101im.picture.luban;

import java.io.File;

/* renamed from: com.didi.beatles.im.picture.luban.LubanOutput */
public class LubanOutput {

    /* renamed from: a */
    private File f11269a;

    /* renamed from: b */
    private int f11270b;

    /* renamed from: c */
    private int f11271c;

    /* renamed from: d */
    private long f11272d;

    /* renamed from: e */
    private int f11273e;

    /* renamed from: f */
    private int f11274f;

    public LubanOutput(File file) {
        this.f11269a = file;
        this.f11270b = -1;
        this.f11271c = -1;
        this.f11272d = -1;
    }

    public LubanOutput(File file, int i, int i2, long j, int i3, int i4) {
        this.f11269a = file;
        this.f11270b = i;
        this.f11271c = i2;
        this.f11272d = j;
        this.f11273e = i3;
        this.f11274f = i4;
    }

    public File getFile() {
        return this.f11269a;
    }

    public int getWidth() {
        return this.f11270b;
    }

    public int getHeight() {
        return this.f11271c;
    }

    public long getSize() {
        return this.f11272d;
    }

    public int getCompressCount() {
        return this.f11273e;
    }

    public int getCompressQuality() {
        return this.f11274f;
    }
}
