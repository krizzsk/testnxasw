package com.google.android.gms.internal.instantapps;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

final class zzcd extends zzcb {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzall;
    private int zzalm;
    private int zzaln;
    private int zzalo;
    private int zzalp;

    private zzcd(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzalp = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzaln = i;
        this.zzall = z;
    }

    public final int zzaa() throws IOException {
        if (zzaq()) {
            this.zzalo = 0;
            return 0;
        }
        int zzau = zzau();
        this.zzalo = zzau;
        if ((zzau >>> 3) != 0) {
            return zzau;
        }
        throw zzdf.zzci();
    }

    public final void zzm(int i) throws zzdf {
        if (this.zzalo != i) {
            throw zzdf.zzcj();
        }
    }

    public final boolean zzn(int i) throws IOException {
        int zzaa;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.limit - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzdf.zzch();
            }
            while (i3 < 10) {
                if (zzaz() < 0) {
                    i3++;
                }
            }
            throw zzdf.zzch();
            return true;
        } else if (i2 == 1) {
            zzv(8);
            return true;
        } else if (i2 == 2) {
            zzv(zzau());
            return true;
        } else if (i2 == 3) {
            do {
                zzaa = zzaa();
                if (zzaa == 0 || !zzn(zzaa)) {
                    zzm(((i >>> 3) << 3) | 4);
                }
                zzaa = zzaa();
                break;
            } while (!zzn(zzaa));
            zzm(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzv(4);
                return true;
            }
            throw zzdf.zzck();
        }
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzax());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzaw());
    }

    public final long zzab() throws IOException {
        return zzav();
    }

    public final long zzac() throws IOException {
        return zzav();
    }

    public final int zzad() throws IOException {
        return zzau();
    }

    public final long zzae() throws IOException {
        return zzax();
    }

    public final int zzaf() throws IOException {
        return zzaw();
    }

    public final boolean zzag() throws IOException {
        return zzav() != 0;
    }

    public final String readString() throws IOException {
        int zzau = zzau();
        if (zzau > 0 && zzau <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzau, zzcy.UTF_8);
            this.pos += zzau;
            return str;
        } else if (zzau == 0) {
            return "";
        } else {
            if (zzau < 0) {
                throw zzdf.zzcg();
            }
            throw zzdf.zzcf();
        }
    }

    public final String zzah() throws IOException {
        int zzau = zzau();
        if (zzau > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzau <= i - i2) {
                String zzg = zzfv.zzg(this.buffer, i2, zzau);
                this.pos += zzau;
                return zzg;
            }
        }
        if (zzau == 0) {
            return "";
        }
        if (zzau <= 0) {
            throw zzdf.zzcg();
        }
        throw zzdf.zzcf();
    }

    public final zzbp zzai() throws IOException {
        byte[] bArr;
        int zzau = zzau();
        if (zzau > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzau <= i - i2) {
                zzbp zzb = zzbp.zzb(this.buffer, i2, zzau);
                this.pos += zzau;
                return zzb;
            }
        }
        if (zzau == 0) {
            return zzbp.zzakv;
        }
        if (zzau > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzau <= i3 - i4) {
                int i5 = zzau + i4;
                this.pos = i5;
                bArr = Arrays.copyOfRange(this.buffer, i4, i5);
                return zzbp.zza(bArr);
            }
        }
        if (zzau > 0) {
            throw zzdf.zzcf();
        } else if (zzau == 0) {
            bArr = zzcy.zzapu;
            return zzbp.zza(bArr);
        } else {
            throw zzdf.zzcg();
        }
    }

    public final int zzaj() throws IOException {
        return zzau();
    }

    public final int zzak() throws IOException {
        return zzau();
    }

    public final int zzal() throws IOException {
        return zzaw();
    }

    public final long zzam() throws IOException {
        return zzax();
    }

    public final int zzan() throws IOException {
        return zzq(zzau());
    }

    public final long zzao() throws IOException {
        return zzc(zzav());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzau() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006b
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0068
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002d:
            r1 = r3
            goto L_0x0068
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0068
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006b
        L_0x0068:
            r5.pos = r1
            return r0
        L_0x006b:
            long r0 = r5.zzap()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzcd.zzau():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzav() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.limit
            if (r1 == r0) goto L_0x00b8
            byte[] r2 = r11.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.pos = r3
            long r0 = (long) r0
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00b8
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0025
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0022:
            long r2 = (long) r0
            goto L_0x00b5
        L_0x0025:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0036
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r2 = r9
            goto L_0x00b5
        L_0x0036:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0044
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0022
        L_0x0044:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005b
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x0057:
            long r2 = r3 ^ r1
            r1 = r0
            goto L_0x00b5
        L_0x005b:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x006d:
            long r2 = r3 ^ r5
            goto L_0x00b5
        L_0x0070:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0083
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x0057
        L_0x0083:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0096
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x006d
        L_0x0096:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b3
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00b8
            goto L_0x00b4
        L_0x00b3:
            r1 = r0
        L_0x00b4:
            r2 = r3
        L_0x00b5:
            r11.pos = r1
            return r2
        L_0x00b8:
            long r0 = r11.zzap()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzcd.zzav():long");
    }

    /* access modifiers changed from: package-private */
    public final long zzap() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzaz = zzaz();
            j |= ((long) (zzaz & Byte.MAX_VALUE)) << i;
            if ((zzaz & 128) == 0) {
                return j;
            }
        }
        throw zzdf.zzch();
    }

    private final int zzaw() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzdf.zzcf();
    }

    private final long zzax() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzdf.zzcf();
    }

    public final int zzo(int i) throws zzdf {
        if (i >= 0) {
            int zzar = i + zzar();
            int i2 = this.zzalp;
            if (zzar <= i2) {
                this.zzalp = zzar;
                zzay();
                return i2;
            }
            throw zzdf.zzcf();
        }
        throw zzdf.zzcg();
    }

    private final void zzay() {
        int i = this.limit + this.zzalm;
        this.limit = i;
        int i2 = i - this.zzaln;
        int i3 = this.zzalp;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzalm = i4;
            this.limit = i - i4;
            return;
        }
        this.zzalm = 0;
    }

    public final void zzp(int i) {
        this.zzalp = i;
        zzay();
    }

    public final boolean zzaq() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzar() {
        return this.pos - this.zzaln;
    }

    private final byte zzaz() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzdf.zzcf();
    }

    private final void zzv(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzdf.zzcg();
        }
        throw zzdf.zzcf();
    }
}
