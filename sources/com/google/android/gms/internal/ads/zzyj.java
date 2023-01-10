package com.google.android.gms.internal.ads;

import com.didi.soda.customer.foundation.rpc.ApiErrorConst;
import java.nio.ByteBuffer;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzyj {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, ApiErrorConst.Code.CREATE_ORDER_BILL_INFO_ERROR, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        int i = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) <= 10) {
            return 1536;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
        }
        return zzb[i] * 256;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            int i = ((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1;
            return i + i;
        }
        byte b = bArr[4];
        return zzf((b & 192) >> 6, b & Utf8.REPLACEMENT_BYTE);
    }

    public static zzaf zzc(zzef zzef, String str, String str2, zzx zzx) {
        int i = zzc[(zzef.zzk() & 192) >> 6];
        int zzk = zzef.zzk();
        int i2 = zze[(zzk & 56) >> 3];
        if ((zzk & 4) != 0) {
            i2++;
        }
        zzad zzad = new zzad();
        zzad.zzH(str);
        zzad.zzS("audio/ac3");
        zzad.zzw(i2);
        zzad.zzT(i);
        zzad.zzB(zzx);
        zzad.zzK(str2);
        return zzad.zzY();
    }

    public static zzaf zzd(zzef zzef, String str, String str2, zzx zzx) {
        zzef.zzG(2);
        int i = zzc[(zzef.zzk() & 192) >> 6];
        int zzk = zzef.zzk();
        int i2 = zze[(zzk & 14) >> 1];
        if ((zzk & 1) != 0) {
            i2++;
        }
        if (((zzef.zzk() & 30) >> 1) > 0 && (2 & zzef.zzk()) != 0) {
            i2 += 2;
        }
        String str3 = (zzef.zza() <= 0 || (zzef.zzk() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc";
        zzad zzad = new zzad();
        zzad.zzH(str);
        zzad.zzS(str3);
        zzad.zzw(i2);
        zzad.zzT(i);
        zzad.zzB(zzx);
        zzad.zzK(str2);
        return zzad.zzY();
    }

    public static zzyi zze(zzee zzee) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        zzee zzee2 = zzee;
        int zzb2 = zzee.zzb();
        zzee2.zzj(40);
        int zzc2 = zzee2.zzc(5);
        zzee2.zzh(zzb2);
        int i12 = -1;
        if (zzc2 > 10) {
            zzee2.zzj(16);
            int zzc3 = zzee2.zzc(2);
            if (zzc3 == 0) {
                i12 = 0;
            } else if (zzc3 == 1) {
                i12 = 1;
            } else if (zzc3 == 2) {
                i12 = 2;
            }
            zzee2.zzj(3);
            int zzc4 = zzee2.zzc(11) + 1;
            int i13 = zzc4 + zzc4;
            int zzc5 = zzee2.zzc(2);
            if (zzc5 == 3) {
                i6 = zzd[zzee2.zzc(2)];
                i8 = 3;
                i7 = 6;
            } else {
                i8 = zzee2.zzc(2);
                i7 = zzb[i8];
                i6 = zzc[zzc5];
            }
            int i14 = i7 * 256;
            int zzc6 = zzee2.zzc(3);
            boolean zzl = zzee.zzl();
            int i15 = zze[zzc6] + (zzl ? 1 : 0);
            zzee2.zzj(10);
            if (zzee.zzl()) {
                zzee2.zzj(8);
            }
            if (zzc6 == 0) {
                zzee2.zzj(5);
                if (zzee.zzl()) {
                    zzee2.zzj(8);
                }
                i9 = 0;
                zzc6 = 0;
            } else {
                i9 = zzc6;
            }
            if (i12 == 1) {
                if (zzee.zzl()) {
                    zzee2.zzj(16);
                }
                i10 = 1;
            } else {
                i10 = i12;
            }
            if (zzee.zzl()) {
                if (i9 > 2) {
                    zzee2.zzj(2);
                }
                if ((i9 & 1) != 0 && i9 > 2) {
                    zzee2.zzj(6);
                }
                if ((i9 & 4) != 0) {
                    zzee2.zzj(6);
                }
                if (zzl && zzee.zzl()) {
                    zzee2.zzj(5);
                }
                if (i10 == 0) {
                    if (zzee.zzl()) {
                        zzee2.zzj(6);
                    }
                    if (i9 == 0 && zzee.zzl()) {
                        zzee2.zzj(6);
                    }
                    if (zzee.zzl()) {
                        zzee2.zzj(6);
                    }
                    int zzc7 = zzee2.zzc(2);
                    if (zzc7 == 1) {
                        zzee2.zzj(5);
                    } else if (zzc7 == 2) {
                        zzee2.zzj(12);
                    } else if (zzc7 == 3) {
                        int zzc8 = zzee2.zzc(5);
                        if (zzee.zzl()) {
                            zzee2.zzj(5);
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                zzee2.zzj(4);
                            }
                            if (zzee.zzl()) {
                                if (zzee.zzl()) {
                                    zzee2.zzj(4);
                                }
                                if (zzee.zzl()) {
                                    zzee2.zzj(4);
                                }
                            }
                        }
                        if (zzee.zzl()) {
                            zzee2.zzj(5);
                            if (zzee.zzl()) {
                                zzee2.zzj(7);
                                if (zzee.zzl()) {
                                    zzee2.zzj(8);
                                    zzee2.zzj((zzc8 + 2) * 8);
                                    zzee.zzd();
                                }
                            }
                        }
                        zzee2.zzj((zzc8 + 2) * 8);
                        zzee.zzd();
                    }
                    if (i9 < 2) {
                        if (zzee.zzl()) {
                            zzee2.zzj(14);
                        }
                        if (zzc6 == 0 && zzee.zzl()) {
                            zzee2.zzj(14);
                        }
                    }
                    if (zzee.zzl()) {
                        if (i8 == 0) {
                            zzee2.zzj(5);
                            i10 = 0;
                            i8 = 0;
                        } else {
                            for (int i16 = 0; i16 < i7; i16++) {
                                if (zzee.zzl()) {
                                    zzee2.zzj(5);
                                }
                            }
                        }
                    }
                    i10 = 0;
                }
            }
            if (zzee.zzl()) {
                zzee2.zzj(5);
                if (i9 == 2) {
                    zzee2.zzj(4);
                    i9 = 2;
                }
                if (i9 >= 6) {
                    zzee2.zzj(2);
                }
                if (zzee.zzl()) {
                    i11 = 8;
                    zzee2.zzj(8);
                } else {
                    i11 = 8;
                }
                if (i9 == 0 && zzee.zzl()) {
                    zzee2.zzj(i11);
                }
                if (zzc5 < 3) {
                    zzee.zzi();
                }
            }
            if (i10 == 0 && i8 != 3) {
                zzee.zzi();
            }
            if (i10 == 2 && (i8 == 3 || zzee.zzl())) {
                zzee2.zzj(6);
            }
            str = (zzee.zzl() && zzee2.zzc(6) == 1 && zzee2.zzc(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i5 = i12;
            i2 = i13;
            i = i14;
            i3 = i6;
            i4 = i15;
        } else {
            zzee2.zzj(32);
            int zzc9 = zzee2.zzc(2);
            String str2 = zzc9 == 3 ? null : "audio/ac3";
            int zzf2 = zzf(zzc9, zzee2.zzc(6));
            zzee2.zzj(8);
            int zzc10 = zzee2.zzc(3);
            if (!((zzc10 & 1) == 0 || zzc10 == 1)) {
                zzee2.zzj(2);
            }
            if ((zzc10 & 4) != 0) {
                zzee2.zzj(2);
            }
            if (zzc10 == 2) {
                zzee2.zzj(2);
            }
            str = str2;
            i2 = zzf2;
            i3 = zzc9 < 3 ? zzc[zzc9] : -1;
            i4 = zze[zzc10] + (zzee.zzl() ? 1 : 0);
            i5 = -1;
            i = 1536;
        }
        return new zzyi(str, i5, i4, i3, i2, i, (zzyh) null);
    }

    private static int zzf(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0 || i >= 3 || i2 < 0 || i3 >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
