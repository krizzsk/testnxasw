package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.cname;

import java.util.Random;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.cname.a */
/* compiled from: Header */
class C16553a {

    /* renamed from: d */
    private static Random f50343d = new Random();

    /* renamed from: a */
    private short f50344a;

    /* renamed from: b */
    private short f50345b;

    /* renamed from: c */
    private short[] f50346c;

    /* renamed from: a */
    static short m37647a(short s, int i, boolean z) {
        return (short) (z ? s | (1 << (15 - i)) : s & (~(1 << (15 - i))));
    }

    /* renamed from: b */
    private void m37648b() {
        this.f50346c = new short[4];
        this.f50345b = 0;
        this.f50344a = (short) f50343d.nextInt(32767);
    }

    public C16553a() {
        m37648b();
    }

    /* renamed from: a */
    public void mo124356a(int i) {
        this.f50345b = m37647a(this.f50345b, i, true);
    }

    /* renamed from: a */
    public void mo124357a(short s, short s2) {
        this.f50346c[s] = s2;
    }

    /* renamed from: a */
    public byte[] mo124358a() {
        byte[] bArr = new byte[12];
        short s = this.f50344a;
        bArr[0] = (byte) (s >> 8);
        bArr[1] = (byte) s;
        short s2 = this.f50345b;
        bArr[2] = (byte) (s2 >> 8);
        bArr[3] = (byte) s2;
        int i = 4;
        for (int i2 = 0; i2 < 4; i2++) {
            short[] sArr = this.f50346c;
            bArr[i] = (byte) (sArr[i2] >> 8);
            bArr[i + 1] = (byte) sArr[i2];
            i += 2;
        }
        return bArr;
    }
}
