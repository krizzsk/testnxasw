package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.List;
import p055case.C1273goto;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzxg extends zzqq {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private long zzA;
    private int zzB;
    private int zzC = -1;
    private int zzD = -1;
    private int zzE;
    private float zzF = -1.0f;
    private zzda zzG = null;
    private int zzH = 0;
    private zzxk zzI;
    private final Context zze;
    private final zzxr zzf;
    private final zzyc zzg;
    private final boolean zzh = "NVIDIA".equals(zzen.zzc);
    private zzxf zzi;
    private boolean zzj;
    private boolean zzk;
    private Surface zzl;
    private zzxj zzm;
    private boolean zzn;
    private int zzo = 1;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private long zzs;
    private long zzt = -9223372036854775807L;
    private long zzu;
    private int zzv;
    private int zzw;
    private int zzx;
    private long zzy;
    private long zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzxg(Context context, zzqk zzqk, zzqs zzqs, long j, boolean z, Handler handler, zzyd zzyd, int i, float f) {
        super(2, zzqk, zzqs, false, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.zze = applicationContext;
        this.zzf = new zzxr(applicationContext);
        Handler handler2 = handler;
        zzyd zzyd2 = zzyd;
        this.zzg = new zzyc(handler, zzyd);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        if (r3.equals("video/mp4v-es") != false) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        r11 = ((java.lang.Integer) r11.first).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzT(com.google.android.gms.internal.ads.zzqn r10, com.google.android.gms.internal.ads.zzaf r11) {
        /*
            int r0 = r11.zzr
            int r1 = r11.zzs
            r2 = -1
            if (r0 == r2) goto L_0x00cb
            if (r1 != r2) goto L_0x000b
            goto L_0x00cb
        L_0x000b:
            java.lang.String r3 = r11.zzm
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = r4.equals(r3)
            r5 = 1
            java.lang.String r6 = "video/avc"
            java.lang.String r7 = "video/hevc"
            r8 = 2
            if (r4 == 0) goto L_0x0034
            android.util.Pair r11 = com.google.android.gms.internal.ads.zzrf.zzb(r11)
            if (r11 == 0) goto L_0x0033
            java.lang.Object r11 = r11.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r11 == r3) goto L_0x0031
            if (r11 == r5) goto L_0x0031
            if (r11 != r8) goto L_0x0033
        L_0x0031:
            r3 = r6
            goto L_0x0034
        L_0x0033:
            r3 = r7
        L_0x0034:
            int r11 = r3.hashCode()
            r4 = 4
            r9 = 3
            switch(r11) {
                case -1664118616: goto L_0x0075;
                case -1662735862: goto L_0x006b;
                case -1662541442: goto L_0x0063;
                case 1187890754: goto L_0x005a;
                case 1331836730: goto L_0x0052;
                case 1599127256: goto L_0x0048;
                case 1599127257: goto L_0x003e;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x007f
        L_0x003e:
            java.lang.String r11 = "video/x-vnd.on2.vp9"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x007f
            r5 = 6
            goto L_0x0080
        L_0x0048:
            java.lang.String r11 = "video/x-vnd.on2.vp8"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x007f
            r5 = 4
            goto L_0x0080
        L_0x0052:
            boolean r11 = r3.equals(r6)
            if (r11 == 0) goto L_0x007f
            r5 = 2
            goto L_0x0080
        L_0x005a:
            java.lang.String r11 = "video/mp4v-es"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x007f
            goto L_0x0080
        L_0x0063:
            boolean r11 = r3.equals(r7)
            if (r11 == 0) goto L_0x007f
            r5 = 5
            goto L_0x0080
        L_0x006b:
            java.lang.String r11 = "video/av01"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x007f
            r5 = 3
            goto L_0x0080
        L_0x0075:
            java.lang.String r11 = "video/3gpp"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x007f
            r5 = 0
            goto L_0x0080
        L_0x007f:
            r5 = -1
        L_0x0080:
            switch(r5) {
                case 0: goto L_0x00c4;
                case 1: goto L_0x00c4;
                case 2: goto L_0x0088;
                case 3: goto L_0x00c4;
                case 4: goto L_0x00c4;
                case 5: goto L_0x0084;
                case 6: goto L_0x0084;
                default: goto L_0x0083;
            }
        L_0x0083:
            return r2
        L_0x0084:
            int r0 = r0 * r1
            r8 = 4
            goto L_0x00c6
        L_0x0088:
            java.lang.String r11 = com.google.android.gms.internal.ads.zzen.zzd
            java.lang.String r3 = "BRAVIA 4K 2015"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x00c3
            java.lang.String r11 = com.google.android.gms.internal.ads.zzen.zzc
            java.lang.String r3 = "Amazon"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x00b4
            java.lang.String r11 = com.google.android.gms.internal.ads.zzen.zzd
            java.lang.String r3 = "KFSOWI"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x00c3
            java.lang.String r11 = com.google.android.gms.internal.ads.zzen.zzd
            java.lang.String r3 = "AFTS"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x00b4
            boolean r10 = r10.zzf
            if (r10 != 0) goto L_0x00c3
        L_0x00b4:
            r10 = 16
            int r11 = com.google.android.gms.internal.ads.zzen.zze(r0, r10)
            int r10 = com.google.android.gms.internal.ads.zzen.zze(r1, r10)
            int r11 = r11 * r10
            int r0 = r11 * 256
            goto L_0x00c6
        L_0x00c3:
            return r2
        L_0x00c4:
            int r0 = r0 * r1
        L_0x00c6:
            int r0 = r0 * 3
            int r8 = r8 + r8
            int r0 = r0 / r8
            return r0
        L_0x00cb:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxg.zzT(com.google.android.gms.internal.ads.zzqn, com.google.android.gms.internal.ads.zzaf):int");
    }

    protected static int zzU(zzqn zzqn, zzaf zzaf) {
        if (zzaf.zzn == -1) {
            return zzT(zzqn, zzaf);
        }
        int size = zzaf.zzo.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((byte[]) zzaf.zzo.get(i2)).length;
        }
        return zzaf.zzn + i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x04c4, code lost:
        if (r13.equals("deb") != false) goto L_0x078e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:510:0x07a4, code lost:
        if (r10 != 0) goto L_0x07a6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static final boolean zzaB(java.lang.String r17) {
        /*
            java.lang.String r0 = "OMX.google"
            r1 = r17
            boolean r0 = r1.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            java.lang.Class<com.google.android.gms.internal.ads.zzxg> r2 = com.google.android.gms.internal.ads.zzxg.class
            monitor-enter(r2)
            boolean r0 = zzc     // Catch:{ all -> 0x07ae }
            if (r0 != 0) goto L_0x07aa
            int r0 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x07ae }
            r3 = 28
            r4 = 5
            r5 = 6
            r6 = 4
            r7 = 7
            r8 = 2
            r9 = 3
            r10 = -1
            r11 = 1
            if (r0 > r3) goto L_0x0083
            java.lang.String r0 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ all -> 0x07ae }
            int r12 = r0.hashCode()     // Catch:{ all -> 0x07ae }
            switch(r12) {
                case -1339091551: goto L_0x0071;
                case -1220081023: goto L_0x0067;
                case -1220066608: goto L_0x005d;
                case -1012436106: goto L_0x0053;
                case -760312546: goto L_0x0049;
                case -64886864: goto L_0x003f;
                case 3415681: goto L_0x0035;
                case 825323514: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x007b
        L_0x002b:
            java.lang.String r12 = "machuca"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = 5
            goto L_0x007c
        L_0x0035:
            java.lang.String r12 = "once"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = 6
            goto L_0x007c
        L_0x003f:
            java.lang.String r12 = "magnolia"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = 4
            goto L_0x007c
        L_0x0049:
            java.lang.String r12 = "aquaman"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = 0
            goto L_0x007c
        L_0x0053:
            java.lang.String r12 = "oneday"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = 7
            goto L_0x007c
        L_0x005d:
            java.lang.String r12 = "dangalUHD"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = 2
            goto L_0x007c
        L_0x0067:
            java.lang.String r12 = "dangalFHD"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = 3
            goto L_0x007c
        L_0x0071:
            java.lang.String r12 = "dangal"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = 1
            goto L_0x007c
        L_0x007b:
            r0 = -1
        L_0x007c:
            switch(r0) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0080;
                case 2: goto L_0x0080;
                case 3: goto L_0x0080;
                case 4: goto L_0x0080;
                case 5: goto L_0x0080;
                case 6: goto L_0x0080;
                case 7: goto L_0x0080;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x0083
        L_0x0080:
            r1 = 1
            goto L_0x07a6
        L_0x0083:
            int r0 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x07ae }
            r12 = 27
            if (r0 > r12) goto L_0x0094
            java.lang.String r0 = "HWEML"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ all -> 0x07ae }
            boolean r0 = r0.equals(r13)     // Catch:{ all -> 0x07ae }
            if (r0 == 0) goto L_0x0094
            goto L_0x0080
        L_0x0094:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzen.zzd     // Catch:{ all -> 0x07ae }
            int r13 = r0.hashCode()     // Catch:{ all -> 0x07ae }
            r14 = 8
            switch(r13) {
                case -349662828: goto L_0x00f1;
                case -321033677: goto L_0x00e7;
                case 2006354: goto L_0x00dd;
                case 2006367: goto L_0x00d3;
                case 2006371: goto L_0x00c9;
                case 1785421873: goto L_0x00bf;
                case 1785421876: goto L_0x00b5;
                case 1798172390: goto L_0x00aa;
                case 2119412532: goto L_0x00a0;
                default: goto L_0x009f;
            }
        L_0x009f:
            goto L_0x00fb
        L_0x00a0:
            java.lang.String r13 = "AFTEUFF014"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = 5
            goto L_0x00fc
        L_0x00aa:
            java.lang.String r13 = "AFTSO001"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = 8
            goto L_0x00fc
        L_0x00b5:
            java.lang.String r13 = "AFTEU014"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = 4
            goto L_0x00fc
        L_0x00bf:
            java.lang.String r13 = "AFTEU011"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = 3
            goto L_0x00fc
        L_0x00c9:
            java.lang.String r13 = "AFTR"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = 2
            goto L_0x00fc
        L_0x00d3:
            java.lang.String r13 = "AFTN"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = 1
            goto L_0x00fc
        L_0x00dd:
            java.lang.String r13 = "AFTA"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = 0
            goto L_0x00fc
        L_0x00e7:
            java.lang.String r13 = "AFTKMST12"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = 7
            goto L_0x00fc
        L_0x00f1:
            java.lang.String r13 = "AFTJMST12"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = 6
            goto L_0x00fc
        L_0x00fb:
            r13 = -1
        L_0x00fc:
            switch(r13) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0080;
                case 2: goto L_0x0080;
                case 3: goto L_0x0080;
                case 4: goto L_0x0080;
                case 5: goto L_0x0080;
                case 6: goto L_0x0080;
                case 7: goto L_0x0080;
                case 8: goto L_0x0080;
                default: goto L_0x00ff;
            }
        L_0x00ff:
            int r13 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x07ae }
            r15 = 26
            if (r13 > r15) goto L_0x07a6
            java.lang.String r13 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ all -> 0x07ae }
            int r16 = r13.hashCode()     // Catch:{ all -> 0x07ae }
            switch(r16) {
                case -2144781245: goto L_0x0782;
                case -2144781185: goto L_0x0777;
                case -2144781160: goto L_0x076c;
                case -2097309513: goto L_0x0761;
                case -2022874474: goto L_0x0756;
                case -1978993182: goto L_0x074b;
                case -1978990237: goto L_0x0740;
                case -1936688988: goto L_0x0735;
                case -1936688066: goto L_0x072a;
                case -1936688065: goto L_0x071e;
                case -1931988508: goto L_0x0712;
                case -1885099851: goto L_0x0706;
                case -1696512866: goto L_0x06fa;
                case -1680025915: goto L_0x06ee;
                case -1615810839: goto L_0x06e2;
                case -1600724499: goto L_0x06d6;
                case -1554255044: goto L_0x06ca;
                case -1481772737: goto L_0x06be;
                case -1481772730: goto L_0x06b2;
                case -1481772729: goto L_0x06a6;
                case -1320080169: goto L_0x069a;
                case -1217592143: goto L_0x068e;
                case -1180384755: goto L_0x0682;
                case -1139198265: goto L_0x0676;
                case -1052835013: goto L_0x066a;
                case -993250464: goto L_0x065f;
                case -993250458: goto L_0x0654;
                case -965403638: goto L_0x0648;
                case -958336948: goto L_0x063c;
                case -879245230: goto L_0x0630;
                case -842500323: goto L_0x0624;
                case -821392978: goto L_0x0618;
                case -797483286: goto L_0x060c;
                case -794946968: goto L_0x0600;
                case -788334647: goto L_0x05f4;
                case -782144577: goto L_0x05e8;
                case -575125681: goto L_0x05dc;
                case -521118391: goto L_0x05d0;
                case -430914369: goto L_0x05c4;
                case -290434366: goto L_0x05b8;
                case -282781963: goto L_0x05ac;
                case -277133239: goto L_0x05a0;
                case -173639913: goto L_0x0594;
                case -56598463: goto L_0x0588;
                case 2126: goto L_0x057c;
                case 2564: goto L_0x0570;
                case 2715: goto L_0x0564;
                case 2719: goto L_0x0558;
                case 3091: goto L_0x054c;
                case 3483: goto L_0x0540;
                case 73405: goto L_0x0534;
                case 75537: goto L_0x0528;
                case 75739: goto L_0x051c;
                case 76779: goto L_0x0510;
                case 78669: goto L_0x0504;
                case 79305: goto L_0x04f8;
                case 80618: goto L_0x04ec;
                case 88274: goto L_0x04e0;
                case 98846: goto L_0x04d4;
                case 98848: goto L_0x04c8;
                case 99329: goto L_0x04be;
                case 101481: goto L_0x04b2;
                case 1513190: goto L_0x04a7;
                case 1514184: goto L_0x049c;
                case 1514185: goto L_0x0491;
                case 2133089: goto L_0x0485;
                case 2133091: goto L_0x0479;
                case 2133120: goto L_0x046d;
                case 2133151: goto L_0x0461;
                case 2133182: goto L_0x0455;
                case 2133184: goto L_0x0449;
                case 2436959: goto L_0x043d;
                case 2463773: goto L_0x0431;
                case 2464648: goto L_0x0425;
                case 2689555: goto L_0x0419;
                case 3154429: goto L_0x040d;
                case 3284551: goto L_0x0401;
                case 3351335: goto L_0x03f5;
                case 3386211: goto L_0x03e9;
                case 41325051: goto L_0x03dd;
                case 51349633: goto L_0x03d2;
                case 51350594: goto L_0x03c7;
                case 55178625: goto L_0x03bb;
                case 61542055: goto L_0x03b0;
                case 65355429: goto L_0x03a4;
                case 66214468: goto L_0x0398;
                case 66214470: goto L_0x038c;
                case 66214473: goto L_0x0380;
                case 66215429: goto L_0x0374;
                case 66215431: goto L_0x0368;
                case 66215433: goto L_0x035c;
                case 66216390: goto L_0x0350;
                case 76402249: goto L_0x0344;
                case 76404105: goto L_0x0338;
                case 76404911: goto L_0x032c;
                case 80963634: goto L_0x0320;
                case 82882791: goto L_0x0314;
                case 98715550: goto L_0x0308;
                case 101370885: goto L_0x02fc;
                case 102844228: goto L_0x02f0;
                case 165221241: goto L_0x02e4;
                case 182191441: goto L_0x02d8;
                case 245388979: goto L_0x02cc;
                case 287431619: goto L_0x02c0;
                case 307593612: goto L_0x02b4;
                case 308517133: goto L_0x02a8;
                case 316215098: goto L_0x029c;
                case 316215116: goto L_0x0290;
                case 316246811: goto L_0x0284;
                case 316246818: goto L_0x0278;
                case 407160593: goto L_0x026c;
                case 507412548: goto L_0x0260;
                case 793982701: goto L_0x0254;
                case 794038622: goto L_0x0248;
                case 794040393: goto L_0x023c;
                case 835649806: goto L_0x0230;
                case 917340916: goto L_0x0224;
                case 958008161: goto L_0x0218;
                case 1060579533: goto L_0x020c;
                case 1150207623: goto L_0x0200;
                case 1176899427: goto L_0x01f4;
                case 1280332038: goto L_0x01e8;
                case 1306947716: goto L_0x01dc;
                case 1349174697: goto L_0x01d0;
                case 1522194893: goto L_0x01c4;
                case 1691543273: goto L_0x01b8;
                case 1691544261: goto L_0x01ac;
                case 1709443163: goto L_0x01a0;
                case 1865889110: goto L_0x0194;
                case 1906253259: goto L_0x0188;
                case 1977196784: goto L_0x017c;
                case 2006372676: goto L_0x0170;
                case 2019281702: goto L_0x0164;
                case 2029784656: goto L_0x0158;
                case 2030379515: goto L_0x014c;
                case 2033393791: goto L_0x0140;
                case 2047190025: goto L_0x0134;
                case 2047252157: goto L_0x0128;
                case 2048319463: goto L_0x011c;
                case 2048855701: goto L_0x0110;
                default: goto L_0x010e;
            }
        L_0x010e:
            goto L_0x078d
        L_0x0110:
            java.lang.String r3 = "HWWAS-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 66
            goto L_0x078e
        L_0x011c:
            java.lang.String r3 = "HWVNS-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 65
            goto L_0x078e
        L_0x0128:
            java.lang.String r3 = "ELUGA_Prim"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 33
            goto L_0x078e
        L_0x0134:
            java.lang.String r3 = "ELUGA_Note"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 32
            goto L_0x078e
        L_0x0140:
            java.lang.String r3 = "ASUS_X00AD_2"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 14
            goto L_0x078e
        L_0x014c:
            java.lang.String r3 = "HWCAM-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 64
            goto L_0x078e
        L_0x0158:
            java.lang.String r3 = "HWBLN-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 63
            goto L_0x078e
        L_0x0164:
            java.lang.String r3 = "DM-01K"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 29
            goto L_0x078e
        L_0x0170:
            java.lang.String r3 = "BRAVIA_ATV3_4K"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 19
            goto L_0x078e
        L_0x017c:
            java.lang.String r3 = "Infinix-X572"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 69
            goto L_0x078e
        L_0x0188:
            java.lang.String r3 = "PB2-670M"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 100
            goto L_0x078e
        L_0x0194:
            java.lang.String r3 = "santoni"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 117(0x75, float:1.64E-43)
            goto L_0x078e
        L_0x01a0:
            java.lang.String r3 = "iball8735_9806"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 68
            goto L_0x078e
        L_0x01ac:
            java.lang.String r3 = "CPH1715"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 24
            goto L_0x078e
        L_0x01b8:
            java.lang.String r3 = "CPH1609"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 23
            goto L_0x078e
        L_0x01c4:
            java.lang.String r3 = "woods_f"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 133(0x85, float:1.86E-43)
            goto L_0x078e
        L_0x01d0:
            java.lang.String r3 = "htc_e56ml_dtul"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 61
            goto L_0x078e
        L_0x01dc:
            java.lang.String r3 = "EverStar_S"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 35
            goto L_0x078e
        L_0x01e8:
            java.lang.String r3 = "hwALE-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 62
            goto L_0x078e
        L_0x01f4:
            java.lang.String r3 = "itel_S41"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 71
            goto L_0x078e
        L_0x0200:
            java.lang.String r3 = "LS-5017"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 78
            goto L_0x078e
        L_0x020c:
            java.lang.String r3 = "panell_d"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 96
            goto L_0x078e
        L_0x0218:
            java.lang.String r3 = "j2xlteins"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 72
            goto L_0x078e
        L_0x0224:
            java.lang.String r3 = "A7000plus"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 10
            goto L_0x078e
        L_0x0230:
            java.lang.String r3 = "manning"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 81
            goto L_0x078e
        L_0x023c:
            java.lang.String r3 = "GIONEE_WBL7519"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 59
            goto L_0x078e
        L_0x0248:
            java.lang.String r3 = "GIONEE_WBL7365"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 58
            goto L_0x078e
        L_0x0254:
            java.lang.String r3 = "GIONEE_WBL5708"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 57
            goto L_0x078e
        L_0x0260:
            java.lang.String r3 = "QM16XE_U"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 114(0x72, float:1.6E-43)
            goto L_0x078e
        L_0x026c:
            java.lang.String r3 = "Pixi5-10_4G"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 106(0x6a, float:1.49E-43)
            goto L_0x078e
        L_0x0278:
            java.lang.String r3 = "TB3-850M"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 125(0x7d, float:1.75E-43)
            goto L_0x078e
        L_0x0284:
            java.lang.String r3 = "TB3-850F"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 124(0x7c, float:1.74E-43)
            goto L_0x078e
        L_0x0290:
            java.lang.String r3 = "TB3-730X"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 123(0x7b, float:1.72E-43)
            goto L_0x078e
        L_0x029c:
            java.lang.String r3 = "TB3-730F"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 122(0x7a, float:1.71E-43)
            goto L_0x078e
        L_0x02a8:
            java.lang.String r3 = "A7020a48"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 12
            goto L_0x078e
        L_0x02b4:
            java.lang.String r3 = "A7010a48"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 11
            goto L_0x078e
        L_0x02c0:
            java.lang.String r3 = "griffin"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 60
            goto L_0x078e
        L_0x02cc:
            java.lang.String r3 = "marino_f"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 82
            goto L_0x078e
        L_0x02d8:
            java.lang.String r3 = "CPY83_I00"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 25
            goto L_0x078e
        L_0x02e4:
            java.lang.String r3 = "A2016a40"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 8
            goto L_0x078e
        L_0x02f0:
            java.lang.String r3 = "le_x6"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 77
            goto L_0x078e
        L_0x02fc:
            java.lang.String r3 = "l5460"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 76
            goto L_0x078e
        L_0x0308:
            java.lang.String r3 = "i9031"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 67
            goto L_0x078e
        L_0x0314:
            java.lang.String r3 = "X3_HK"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 135(0x87, float:1.89E-43)
            goto L_0x078e
        L_0x0320:
            java.lang.String r3 = "V23GB"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 128(0x80, float:1.794E-43)
            goto L_0x078e
        L_0x032c:
            java.lang.String r3 = "Q4310"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 112(0x70, float:1.57E-43)
            goto L_0x078e
        L_0x0338:
            java.lang.String r3 = "Q4260"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 110(0x6e, float:1.54E-43)
            goto L_0x078e
        L_0x0344:
            java.lang.String r3 = "PRO7S"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 108(0x6c, float:1.51E-43)
            goto L_0x078e
        L_0x0350:
            java.lang.String r3 = "F3311"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 48
            goto L_0x078e
        L_0x035c:
            java.lang.String r3 = "F3215"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 47
            goto L_0x078e
        L_0x0368:
            java.lang.String r3 = "F3213"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 46
            goto L_0x078e
        L_0x0374:
            java.lang.String r3 = "F3211"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 45
            goto L_0x078e
        L_0x0380:
            java.lang.String r3 = "F3116"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 44
            goto L_0x078e
        L_0x038c:
            java.lang.String r3 = "F3113"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 43
            goto L_0x078e
        L_0x0398:
            java.lang.String r3 = "F3111"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 42
            goto L_0x078e
        L_0x03a4:
            java.lang.String r3 = "E5643"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 30
            goto L_0x078e
        L_0x03b0:
            java.lang.String r3 = "A1601"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 7
            goto L_0x078e
        L_0x03bb:
            java.lang.String r3 = "Aura_Note_2"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 15
            goto L_0x078e
        L_0x03c7:
            java.lang.String r3 = "602LV"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 4
            goto L_0x078e
        L_0x03d2:
            java.lang.String r3 = "601LV"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 3
            goto L_0x078e
        L_0x03dd:
            java.lang.String r3 = "MEIZU_M5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 83
            goto L_0x078e
        L_0x03e9:
            java.lang.String r3 = "p212"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 92
            goto L_0x078e
        L_0x03f5:
            java.lang.String r3 = "mido"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 85
            goto L_0x078e
        L_0x0401:
            java.lang.String r3 = "kate"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 75
            goto L_0x078e
        L_0x040d:
            java.lang.String r3 = "fugu"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 50
            goto L_0x078e
        L_0x0419:
            java.lang.String r3 = "XE2X"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 136(0x88, float:1.9E-43)
            goto L_0x078e
        L_0x0425:
            java.lang.String r3 = "Q427"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 111(0x6f, float:1.56E-43)
            goto L_0x078e
        L_0x0431:
            java.lang.String r3 = "Q350"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 109(0x6d, float:1.53E-43)
            goto L_0x078e
        L_0x043d:
            java.lang.String r3 = "P681"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 93
            goto L_0x078e
        L_0x0449:
            java.lang.String r3 = "F04J"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 41
            goto L_0x078e
        L_0x0455:
            java.lang.String r3 = "F04H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 40
            goto L_0x078e
        L_0x0461:
            java.lang.String r3 = "F03H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 39
            goto L_0x078e
        L_0x046d:
            java.lang.String r3 = "F02H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 38
            goto L_0x078e
        L_0x0479:
            java.lang.String r3 = "F01J"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 37
            goto L_0x078e
        L_0x0485:
            java.lang.String r3 = "F01H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 36
            goto L_0x078e
        L_0x0491:
            java.lang.String r3 = "1714"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 2
            goto L_0x078e
        L_0x049c:
            java.lang.String r3 = "1713"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 1
            goto L_0x078e
        L_0x04a7:
            java.lang.String r3 = "1601"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 0
            goto L_0x078e
        L_0x04b2:
            java.lang.String r3 = "flo"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 49
            goto L_0x078e
        L_0x04be:
            java.lang.String r4 = "deb"
            boolean r4 = r13.equals(r4)
            if (r4 == 0) goto L_0x078d
            goto L_0x078e
        L_0x04c8:
            java.lang.String r3 = "cv3"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 27
            goto L_0x078e
        L_0x04d4:
            java.lang.String r3 = "cv1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 26
            goto L_0x078e
        L_0x04e0:
            java.lang.String r3 = "Z80"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 139(0x8b, float:1.95E-43)
            goto L_0x078e
        L_0x04ec:
            java.lang.String r3 = "QX1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 115(0x73, float:1.61E-43)
            goto L_0x078e
        L_0x04f8:
            java.lang.String r3 = "PLE"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 107(0x6b, float:1.5E-43)
            goto L_0x078e
        L_0x0504:
            java.lang.String r3 = "P85"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 94
            goto L_0x078e
        L_0x0510:
            java.lang.String r3 = "MX6"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 86
            goto L_0x078e
        L_0x051c:
            java.lang.String r3 = "M5c"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 80
            goto L_0x078e
        L_0x0528:
            java.lang.String r3 = "M04"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 79
            goto L_0x078e
        L_0x0534:
            java.lang.String r3 = "JGZ"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 73
            goto L_0x078e
        L_0x0540:
            java.lang.String r3 = "mh"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 84
            goto L_0x078e
        L_0x054c:
            java.lang.String r3 = "b5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 16
            goto L_0x078e
        L_0x0558:
            java.lang.String r3 = "V5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 129(0x81, float:1.81E-43)
            goto L_0x078e
        L_0x0564:
            java.lang.String r3 = "V1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 127(0x7f, float:1.78E-43)
            goto L_0x078e
        L_0x0570:
            java.lang.String r3 = "Q5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 113(0x71, float:1.58E-43)
            goto L_0x078e
        L_0x057c:
            java.lang.String r3 = "C1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 20
            goto L_0x078e
        L_0x0588:
            java.lang.String r3 = "woods_fn"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 134(0x86, float:1.88E-43)
            goto L_0x078e
        L_0x0594:
            java.lang.String r3 = "ELUGA_A3_Pro"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 31
            goto L_0x078e
        L_0x05a0:
            java.lang.String r3 = "Z12_PRO"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 138(0x8a, float:1.93E-43)
            goto L_0x078e
        L_0x05ac:
            java.lang.String r3 = "BLACK-1X"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 17
            goto L_0x078e
        L_0x05b8:
            java.lang.String r3 = "taido_row"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 121(0x79, float:1.7E-43)
            goto L_0x078e
        L_0x05c4:
            java.lang.String r3 = "Pixi4-7_3G"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 105(0x69, float:1.47E-43)
            goto L_0x078e
        L_0x05d0:
            java.lang.String r3 = "GIONEE_GBL7360"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 53
            goto L_0x078e
        L_0x05dc:
            java.lang.String r3 = "GiONEE_CBL7513"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 51
            goto L_0x078e
        L_0x05e8:
            java.lang.String r3 = "OnePlus5T"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 91
            goto L_0x078e
        L_0x05f4:
            java.lang.String r3 = "whyred"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 132(0x84, float:1.85E-43)
            goto L_0x078e
        L_0x0600:
            java.lang.String r3 = "watson"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 131(0x83, float:1.84E-43)
            goto L_0x078e
        L_0x060c:
            java.lang.String r3 = "SVP-DTV15"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 119(0x77, float:1.67E-43)
            goto L_0x078e
        L_0x0618:
            java.lang.String r3 = "A7000-a"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 9
            goto L_0x078e
        L_0x0624:
            java.lang.String r3 = "nicklaus_f"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 88
            goto L_0x078e
        L_0x0630:
            java.lang.String r3 = "tcl_eu"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 126(0x7e, float:1.77E-43)
            goto L_0x078e
        L_0x063c:
            java.lang.String r3 = "ELUGA_Ray_X"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 34
            goto L_0x078e
        L_0x0648:
            java.lang.String r3 = "s905x018"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 120(0x78, float:1.68E-43)
            goto L_0x078e
        L_0x0654:
            java.lang.String r3 = "A10-70L"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 6
            goto L_0x078e
        L_0x065f:
            java.lang.String r3 = "A10-70F"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 5
            goto L_0x078e
        L_0x066a:
            java.lang.String r3 = "namath"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 87
            goto L_0x078e
        L_0x0676:
            java.lang.String r3 = "Slate_Pro"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 118(0x76, float:1.65E-43)
            goto L_0x078e
        L_0x0682:
            java.lang.String r3 = "iris60"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 70
            goto L_0x078e
        L_0x068e:
            java.lang.String r3 = "BRAVIA_ATV2"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 18
            goto L_0x078e
        L_0x069a:
            java.lang.String r3 = "GiONEE_GBL7319"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 52
            goto L_0x078e
        L_0x06a6:
            java.lang.String r3 = "panell_dt"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 99
            goto L_0x078e
        L_0x06b2:
            java.lang.String r3 = "panell_ds"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 98
            goto L_0x078e
        L_0x06be:
            java.lang.String r3 = "panell_dl"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 97
            goto L_0x078e
        L_0x06ca:
            java.lang.String r3 = "vernee_M5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 130(0x82, float:1.82E-43)
            goto L_0x078e
        L_0x06d6:
            java.lang.String r3 = "pacificrim"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 95
            goto L_0x078e
        L_0x06e2:
            java.lang.String r3 = "Phantom6"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 104(0x68, float:1.46E-43)
            goto L_0x078e
        L_0x06ee:
            java.lang.String r3 = "ComioS1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 21
            goto L_0x078e
        L_0x06fa:
            java.lang.String r3 = "XT1663"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 137(0x89, float:1.92E-43)
            goto L_0x078e
        L_0x0706:
            java.lang.String r3 = "RAIJIN"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 116(0x74, float:1.63E-43)
            goto L_0x078e
        L_0x0712:
            java.lang.String r3 = "AquaPowerM"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 13
            goto L_0x078e
        L_0x071e:
            java.lang.String r3 = "PGN611"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 103(0x67, float:1.44E-43)
            goto L_0x078e
        L_0x072a:
            java.lang.String r3 = "PGN610"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 102(0x66, float:1.43E-43)
            goto L_0x078e
        L_0x0735:
            java.lang.String r3 = "PGN528"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 101(0x65, float:1.42E-43)
            goto L_0x078e
        L_0x0740:
            java.lang.String r3 = "NX573J"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 90
            goto L_0x078e
        L_0x074b:
            java.lang.String r3 = "NX541J"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 89
            goto L_0x078e
        L_0x0756:
            java.lang.String r3 = "CP8676_I02"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 22
            goto L_0x078e
        L_0x0761:
            java.lang.String r3 = "K50a40"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 74
            goto L_0x078e
        L_0x076c:
            java.lang.String r3 = "GIONEE_SWW1631"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 56
            goto L_0x078e
        L_0x0777:
            java.lang.String r3 = "GIONEE_SWW1627"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 55
            goto L_0x078e
        L_0x0782:
            java.lang.String r3 = "GIONEE_SWW1609"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078d
            r3 = 54
            goto L_0x078e
        L_0x078d:
            r3 = -1
        L_0x078e:
            switch(r3) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0080;
                case 2: goto L_0x0080;
                case 3: goto L_0x0080;
                case 4: goto L_0x0080;
                case 5: goto L_0x0080;
                case 6: goto L_0x0080;
                case 7: goto L_0x0080;
                case 8: goto L_0x0080;
                case 9: goto L_0x0080;
                case 10: goto L_0x0080;
                case 11: goto L_0x0080;
                case 12: goto L_0x0080;
                case 13: goto L_0x0080;
                case 14: goto L_0x0080;
                case 15: goto L_0x0080;
                case 16: goto L_0x0080;
                case 17: goto L_0x0080;
                case 18: goto L_0x0080;
                case 19: goto L_0x0080;
                case 20: goto L_0x0080;
                case 21: goto L_0x0080;
                case 22: goto L_0x0080;
                case 23: goto L_0x0080;
                case 24: goto L_0x0080;
                case 25: goto L_0x0080;
                case 26: goto L_0x0080;
                case 27: goto L_0x0080;
                case 28: goto L_0x0080;
                case 29: goto L_0x0080;
                case 30: goto L_0x0080;
                case 31: goto L_0x0080;
                case 32: goto L_0x0080;
                case 33: goto L_0x0080;
                case 34: goto L_0x0080;
                case 35: goto L_0x0080;
                case 36: goto L_0x0080;
                case 37: goto L_0x0080;
                case 38: goto L_0x0080;
                case 39: goto L_0x0080;
                case 40: goto L_0x0080;
                case 41: goto L_0x0080;
                case 42: goto L_0x0080;
                case 43: goto L_0x0080;
                case 44: goto L_0x0080;
                case 45: goto L_0x0080;
                case 46: goto L_0x0080;
                case 47: goto L_0x0080;
                case 48: goto L_0x0080;
                case 49: goto L_0x0080;
                case 50: goto L_0x0080;
                case 51: goto L_0x0080;
                case 52: goto L_0x0080;
                case 53: goto L_0x0080;
                case 54: goto L_0x0080;
                case 55: goto L_0x0080;
                case 56: goto L_0x0080;
                case 57: goto L_0x0080;
                case 58: goto L_0x0080;
                case 59: goto L_0x0080;
                case 60: goto L_0x0080;
                case 61: goto L_0x0080;
                case 62: goto L_0x0080;
                case 63: goto L_0x0080;
                case 64: goto L_0x0080;
                case 65: goto L_0x0080;
                case 66: goto L_0x0080;
                case 67: goto L_0x0080;
                case 68: goto L_0x0080;
                case 69: goto L_0x0080;
                case 70: goto L_0x0080;
                case 71: goto L_0x0080;
                case 72: goto L_0x0080;
                case 73: goto L_0x0080;
                case 74: goto L_0x0080;
                case 75: goto L_0x0080;
                case 76: goto L_0x0080;
                case 77: goto L_0x0080;
                case 78: goto L_0x0080;
                case 79: goto L_0x0080;
                case 80: goto L_0x0080;
                case 81: goto L_0x0080;
                case 82: goto L_0x0080;
                case 83: goto L_0x0080;
                case 84: goto L_0x0080;
                case 85: goto L_0x0080;
                case 86: goto L_0x0080;
                case 87: goto L_0x0080;
                case 88: goto L_0x0080;
                case 89: goto L_0x0080;
                case 90: goto L_0x0080;
                case 91: goto L_0x0080;
                case 92: goto L_0x0080;
                case 93: goto L_0x0080;
                case 94: goto L_0x0080;
                case 95: goto L_0x0080;
                case 96: goto L_0x0080;
                case 97: goto L_0x0080;
                case 98: goto L_0x0080;
                case 99: goto L_0x0080;
                case 100: goto L_0x0080;
                case 101: goto L_0x0080;
                case 102: goto L_0x0080;
                case 103: goto L_0x0080;
                case 104: goto L_0x0080;
                case 105: goto L_0x0080;
                case 106: goto L_0x0080;
                case 107: goto L_0x0080;
                case 108: goto L_0x0080;
                case 109: goto L_0x0080;
                case 110: goto L_0x0080;
                case 111: goto L_0x0080;
                case 112: goto L_0x0080;
                case 113: goto L_0x0080;
                case 114: goto L_0x0080;
                case 115: goto L_0x0080;
                case 116: goto L_0x0080;
                case 117: goto L_0x0080;
                case 118: goto L_0x0080;
                case 119: goto L_0x0080;
                case 120: goto L_0x0080;
                case 121: goto L_0x0080;
                case 122: goto L_0x0080;
                case 123: goto L_0x0080;
                case 124: goto L_0x0080;
                case 125: goto L_0x0080;
                case 126: goto L_0x0080;
                case 127: goto L_0x0080;
                case 128: goto L_0x0080;
                case 129: goto L_0x0080;
                case 130: goto L_0x0080;
                case 131: goto L_0x0080;
                case 132: goto L_0x0080;
                case 133: goto L_0x0080;
                case 134: goto L_0x0080;
                case 135: goto L_0x0080;
                case 136: goto L_0x0080;
                case 137: goto L_0x0080;
                case 138: goto L_0x0080;
                case 139: goto L_0x0080;
                default: goto L_0x0791;
            }
        L_0x0791:
            int r3 = r0.hashCode()     // Catch:{ all -> 0x07ae }
            r4 = -594534941(0xffffffffdc901de3, float:-3.2452206E17)
            if (r3 == r4) goto L_0x079b
            goto L_0x07a4
        L_0x079b:
            java.lang.String r3 = "JSN-L21"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x07a4
            r10 = 0
        L_0x07a4:
            if (r10 == 0) goto L_0x0080
        L_0x07a6:
            zzd = r1     // Catch:{ all -> 0x07ae }
            zzc = r11     // Catch:{ all -> 0x07ae }
        L_0x07aa:
            monitor-exit(r2)     // Catch:{ all -> 0x07ae }
            boolean r0 = zzd
            return r0
        L_0x07ae:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x07ae }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxg.zzaB(java.lang.String):boolean");
    }

    private static List zzaC(zzqs zzqs, zzaf zzaf, boolean z, boolean z2) throws zzqz {
        String str = zzaf.zzm;
        if (str == null) {
            return zzfvn.zzo();
        }
        List zzf2 = zzrf.zzf(str, z, z2);
        String zze2 = zzrf.zze(zzaf);
        if (zze2 == null) {
            return zzfvn.zzm(zzf2);
        }
        List zzf3 = zzrf.zzf(zze2, z, z2);
        zzfvk zzi2 = zzfvn.zzi();
        zzi2.zzf(zzf2);
        zzi2.zzf(zzf3);
        return zzi2.zzg();
    }

    private final void zzaD() {
        int i = this.zzC;
        if (i == -1) {
            if (this.zzD != -1) {
                i = -1;
            } else {
                return;
            }
        }
        zzda zzda = this.zzG;
        if (zzda == null || zzda.zzc != i || zzda.zzd != this.zzD || zzda.zze != this.zzE || zzda.zzf != this.zzF) {
            zzda zzda2 = new zzda(i, this.zzD, this.zzE, this.zzF);
            this.zzG = zzda2;
            this.zzg.zzt(zzda2);
        }
    }

    private final void zzaE() {
        zzda zzda = this.zzG;
        if (zzda != null) {
            this.zzg.zzt(zzda);
        }
    }

    private final void zzaF() {
        Surface surface = this.zzl;
        zzxj zzxj = this.zzm;
        if (surface == zzxj) {
            this.zzl = null;
        }
        zzxj.release();
        this.zzm = null;
    }

    private static boolean zzaG(long j) {
        return j < -30000;
    }

    private final boolean zzaH(zzqn zzqn) {
        if (zzen.zza < 23 || zzaB(zzqn.zza) || (zzqn.zzf && !zzxj.zzb(this.zze))) {
            return false;
        }
        return true;
    }

    public final void zzD(float f, float f2) throws zzha {
        super.zzD(f, f2);
        this.zzf.zze(f);
    }

    public final String zzK() {
        return "MediaCodecVideoRenderer";
    }

    public final boolean zzN() {
        zzxj zzxj;
        if (super.zzN() && (this.zzp || (((zzxj = this.zzm) != null && this.zzl == zzxj) || zzaj() == null))) {
            this.zzt = -9223372036854775807L;
            return true;
        } else if (this.zzt == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzt) {
                return true;
            }
            this.zzt = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final float zzP(float f, zzaf zzaf, zzaf[] zzafArr) {
        float f2 = -1.0f;
        for (zzaf zzaf2 : zzafArr) {
            float f3 = zzaf2.zzt;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    /* access modifiers changed from: protected */
    public final int zzQ(zzqs zzqs, zzaf zzaf) throws zzqz {
        boolean z;
        int i = 128;
        if (!zzbt.zzh(zzaf.zzm)) {
            return 128;
        }
        int i2 = 0;
        boolean z2 = zzaf.zzp != null;
        List zzaC = zzaC(zzqs, zzaf, z2, false);
        if (z2 && zzaC.isEmpty()) {
            zzaC = zzaC(zzqs, zzaf, false, false);
        }
        if (zzaC.isEmpty()) {
            return 129;
        }
        if (!zzav(zzaf)) {
            return 130;
        }
        zzqn zzqn = (zzqn) zzaC.get(0);
        boolean zzd2 = zzqn.zzd(zzaf);
        if (!zzd2) {
            int i3 = 1;
            while (true) {
                if (i3 >= zzaC.size()) {
                    break;
                }
                zzqn zzqn2 = (zzqn) zzaC.get(i3);
                if (zzqn2.zzd(zzaf)) {
                    zzqn = zzqn2;
                    z = false;
                    zzd2 = true;
                    break;
                }
                i3++;
            }
        }
        z = true;
        int i4 = true != zzd2 ? 3 : 4;
        int i5 = true != zzqn.zze(zzaf) ? 8 : 16;
        int i6 = true != zzqn.zzg ? 0 : 64;
        if (true != z) {
            i = 0;
        }
        if (zzd2) {
            List zzaC2 = zzaC(zzqs, zzaf, z2, true);
            if (!zzaC2.isEmpty()) {
                zzqn zzqn3 = (zzqn) zzrf.zzg(zzaC2, zzaf).get(0);
                if (zzqn3.zzd(zzaf) && zzqn3.zze(zzaf)) {
                    i2 = 32;
                }
            }
        }
        return i4 | i5 | i2 | i6 | i;
    }

    /* access modifiers changed from: protected */
    public final zzgt zzR(zzqn zzqn, zzaf zzaf, zzaf zzaf2) {
        int i;
        int i2;
        zzgt zzb2 = zzqn.zzb(zzaf, zzaf2);
        int i3 = zzb2.zze;
        int i4 = zzaf2.zzr;
        zzxf zzxf = this.zzi;
        if (i4 > zzxf.zza || zzaf2.zzs > zzxf.zzb) {
            i3 |= 256;
        }
        if (zzU(zzqn, zzaf2) > this.zzi.zzc) {
            i3 |= 64;
        }
        String str = zzqn.zza;
        if (i3 != 0) {
            i = i3;
            i2 = 0;
        } else {
            i2 = zzb2.zzd;
            i = 0;
        }
        return new zzgt(str, zzaf, zzaf2, i2, i);
    }

    /* access modifiers changed from: protected */
    public final zzgt zzS(zzjg zzjg) throws zzha {
        zzgt zzS = super.zzS(zzjg);
        this.zzg.zzf(zzjg.zza, zzS);
        return zzS;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012f, code lost:
        r20 = r9;
        r21 = r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0236  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzqj zzV(com.google.android.gms.internal.ads.zzqn r23, com.google.android.gms.internal.ads.zzaf r24, android.media.MediaCrypto r25, float r26) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r26
            com.google.android.gms.internal.ads.zzxj r4 = r0.zzm
            if (r4 == 0) goto L_0x0015
            boolean r4 = r4.zza
            boolean r5 = r1.zzf
            if (r4 == r5) goto L_0x0015
            r22.zzaF()
        L_0x0015:
            java.lang.String r4 = r1.zzc
            com.google.android.gms.internal.ads.zzaf[] r5 = r22.zzJ()
            int r6 = r2.zzr
            int r7 = r2.zzs
            int r8 = zzU(r23, r24)
            int r9 = r5.length
            r10 = -1
            r13 = 1
            if (r9 != r13) goto L_0x0043
            if (r8 == r10) goto L_0x003a
            int r5 = zzT(r23, r24)
            if (r5 == r10) goto L_0x003a
            float r8 = (float) r8
            r9 = 1069547520(0x3fc00000, float:1.5)
            float r8 = r8 * r9
            int r8 = (int) r8
            int r8 = java.lang.Math.min(r8, r5)
        L_0x003a:
            com.google.android.gms.internal.ads.zzxf r5 = new com.google.android.gms.internal.ads.zzxf
            r5.<init>(r6, r7, r8)
            r16 = r4
            goto L_0x017e
        L_0x0043:
            r14 = 0
            r15 = 0
        L_0x0045:
            if (r14 >= r9) goto L_0x0089
            r11 = r5[r14]
            com.google.android.gms.internal.ads.zzq r13 = r2.zzy
            if (r13 == 0) goto L_0x005e
            com.google.android.gms.internal.ads.zzq r13 = r11.zzy
            if (r13 != 0) goto L_0x005e
            com.google.android.gms.internal.ads.zzad r11 = r11.zzb()
            com.google.android.gms.internal.ads.zzq r13 = r2.zzy
            r11.zzy(r13)
            com.google.android.gms.internal.ads.zzaf r11 = r11.zzY()
        L_0x005e:
            com.google.android.gms.internal.ads.zzgt r13 = r1.zzb(r2, r11)
            int r13 = r13.zzd
            if (r13 == 0) goto L_0x0085
            int r13 = r11.zzr
            if (r13 == r10) goto L_0x0071
            int r12 = r11.zzs
            if (r12 != r10) goto L_0x006f
            goto L_0x0071
        L_0x006f:
            r12 = 0
            goto L_0x0072
        L_0x0071:
            r12 = 1
        L_0x0072:
            r15 = r15 | r12
            int r6 = java.lang.Math.max(r6, r13)
            int r12 = r11.zzs
            int r7 = java.lang.Math.max(r7, r12)
            int r11 = zzU(r1, r11)
            int r8 = java.lang.Math.max(r8, r11)
        L_0x0085:
            int r14 = r14 + 1
            r13 = 1
            goto L_0x0045
        L_0x0089:
            if (r15 == 0) goto L_0x0177
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "Resolutions unknown. Codec max resolution: "
            r5.append(r9)
            r5.append(r6)
            java.lang.String r9 = "x"
            r5.append(r9)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.String r10 = "MediaCodecVideoRenderer"
            com.google.android.gms.internal.ads.zzdw.zze(r10, r5)
            int r5 = r2.zzs
            int r11 = r2.zzr
            if (r5 <= r11) goto L_0x00b1
            r12 = r5
            goto L_0x00b2
        L_0x00b1:
            r12 = r11
        L_0x00b2:
            if (r5 > r11) goto L_0x00b6
            r13 = r5
            goto L_0x00b7
        L_0x00b6:
            r13 = r11
        L_0x00b7:
            float r14 = (float) r13
            float r15 = (float) r12
            float r14 = r14 / r15
            int[] r15 = zzb
            r16 = r4
            r3 = 0
        L_0x00bf:
            r4 = 9
            if (r3 >= r4) goto L_0x012f
            r4 = r15[r3]
            r17 = r15
            float r15 = (float) r4
            float r15 = r15 * r14
            int r15 = (int) r15
            if (r4 <= r12) goto L_0x012f
            if (r15 > r13) goto L_0x00d1
            goto L_0x012f
        L_0x00d1:
            r18 = r12
            int r12 = com.google.android.gms.internal.ads.zzen.zza
            r19 = r13
            r13 = 21
            if (r12 < r13) goto L_0x00f9
            if (r5 > r11) goto L_0x00df
            r12 = r4
            goto L_0x00e0
        L_0x00df:
            r12 = r15
        L_0x00e0:
            if (r5 > r11) goto L_0x00e3
            r4 = r15
        L_0x00e3:
            android.graphics.Point r4 = r1.zza(r12, r4)
            float r12 = r2.zzt
            int r13 = r4.x
            int r15 = r4.y
            r20 = r9
            r21 = r10
            double r9 = (double) r12
            boolean r9 = r1.zzf(r13, r15, r9)
            if (r9 == 0) goto L_0x0122
            goto L_0x0134
        L_0x00f9:
            r20 = r9
            r21 = r10
            r9 = 16
            int r4 = com.google.android.gms.internal.ads.zzen.zze(r4, r9)     // Catch:{ zzqz -> 0x0133 }
            int r4 = r4 * 16
            int r10 = com.google.android.gms.internal.ads.zzen.zze(r15, r9)     // Catch:{ zzqz -> 0x0133 }
            int r10 = r10 * 16
            int r9 = r4 * r10
            int r12 = com.google.android.gms.internal.ads.zzrf.zza()     // Catch:{ zzqz -> 0x0133 }
            if (r9 > r12) goto L_0x0122
            android.graphics.Point r3 = new android.graphics.Point     // Catch:{ zzqz -> 0x0133 }
            if (r5 > r11) goto L_0x0119
            r9 = r4
            goto L_0x011a
        L_0x0119:
            r9 = r10
        L_0x011a:
            if (r5 > r11) goto L_0x011d
            r4 = r10
        L_0x011d:
            r3.<init>(r9, r4)     // Catch:{ zzqz -> 0x0133 }
            r4 = r3
            goto L_0x0134
        L_0x0122:
            int r3 = r3 + 1
            r15 = r17
            r12 = r18
            r13 = r19
            r9 = r20
            r10 = r21
            goto L_0x00bf
        L_0x012f:
            r20 = r9
            r21 = r10
        L_0x0133:
            r4 = 0
        L_0x0134:
            if (r4 == 0) goto L_0x0179
            int r3 = r4.x
            int r6 = java.lang.Math.max(r6, r3)
            int r3 = r4.y
            int r7 = java.lang.Math.max(r7, r3)
            com.google.android.gms.internal.ads.zzad r3 = r24.zzb()
            r3.zzX(r6)
            r3.zzF(r7)
            com.google.android.gms.internal.ads.zzaf r3 = r3.zzY()
            int r3 = zzT(r1, r3)
            int r8 = java.lang.Math.max(r8, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Codec max resolution adjusted to: "
            r3.append(r4)
            r3.append(r6)
            r4 = r20
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r4 = r21
            com.google.android.gms.internal.ads.zzdw.zze(r4, r3)
            goto L_0x0179
        L_0x0177:
            r16 = r4
        L_0x0179:
            com.google.android.gms.internal.ads.zzxf r5 = new com.google.android.gms.internal.ads.zzxf
            r5.<init>(r6, r7, r8)
        L_0x017e:
            r0.zzi = r5
            boolean r3 = r0.zzh
            android.media.MediaFormat r4 = new android.media.MediaFormat
            r4.<init>()
            java.lang.String r6 = "mime"
            r7 = r16
            r4.setString(r6, r7)
            int r6 = r2.zzr
            java.lang.String r7 = "width"
            r4.setInteger(r7, r6)
            int r6 = r2.zzs
            java.lang.String r7 = "height"
            r4.setInteger(r7, r6)
            java.util.List r6 = r2.zzo
            com.google.android.gms.internal.ads.zzdy.zzb(r4, r6)
            float r6 = r2.zzt
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r8 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r8 == 0) goto L_0x01ae
            java.lang.String r8 = "frame-rate"
            r4.setFloat(r8, r6)
        L_0x01ae:
            int r6 = r2.zzu
            java.lang.String r8 = "rotation-degrees"
            com.google.android.gms.internal.ads.zzdy.zza(r4, r8, r6)
            com.google.android.gms.internal.ads.zzq r6 = r2.zzy
            if (r6 == 0) goto L_0x01db
            int r8 = r6.zzd
            java.lang.String r9 = "color-transfer"
            com.google.android.gms.internal.ads.zzdy.zza(r4, r9, r8)
            int r8 = r6.zzb
            java.lang.String r9 = "color-standard"
            com.google.android.gms.internal.ads.zzdy.zza(r4, r9, r8)
            int r8 = r6.zzc
            java.lang.String r9 = "color-range"
            com.google.android.gms.internal.ads.zzdy.zza(r4, r9, r8)
            byte[] r6 = r6.zze
            if (r6 == 0) goto L_0x01db
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r6)
            java.lang.String r8 = "hdr-static-info"
            r4.setByteBuffer(r8, r6)
        L_0x01db:
            java.lang.String r6 = r2.zzm
            java.lang.String r8 = "video/dolby-vision"
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x01f8
            android.util.Pair r6 = com.google.android.gms.internal.ads.zzrf.zzb(r24)
            if (r6 == 0) goto L_0x01f8
            java.lang.Object r6 = r6.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.String r8 = "profile"
            com.google.android.gms.internal.ads.zzdy.zza(r4, r8, r6)
        L_0x01f8:
            int r6 = r5.zza
            java.lang.String r8 = "max-width"
            r4.setInteger(r8, r6)
            int r6 = r5.zzb
            java.lang.String r8 = "max-height"
            r4.setInteger(r8, r6)
            int r5 = r5.zzc
            java.lang.String r6 = "max-input-size"
            com.google.android.gms.internal.ads.zzdy.zza(r4, r6, r5)
            int r5 = com.google.android.gms.internal.ads.zzen.zza
            r6 = 23
            if (r5 < r6) goto L_0x0224
            java.lang.String r5 = "priority"
            r6 = 0
            r4.setInteger(r5, r6)
            r5 = r26
            int r6 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0224
            java.lang.String r6 = "operating-rate"
            r4.setFloat(r6, r5)
        L_0x0224:
            if (r3 == 0) goto L_0x0232
            java.lang.String r3 = "no-post-process"
            r5 = 1
            r4.setInteger(r3, r5)
            java.lang.String r3 = "auto-frc"
            r5 = 0
            r4.setInteger(r3, r5)
        L_0x0232:
            android.view.Surface r3 = r0.zzl
            if (r3 != 0) goto L_0x0255
            boolean r3 = r22.zzaH(r23)
            if (r3 == 0) goto L_0x024f
            com.google.android.gms.internal.ads.zzxj r3 = r0.zzm
            if (r3 != 0) goto L_0x024a
            android.content.Context r3 = r0.zze
            boolean r5 = r1.zzf
            com.google.android.gms.internal.ads.zzxj r3 = com.google.android.gms.internal.ads.zzxj.zza(r3, r5)
            r0.zzm = r3
        L_0x024a:
            com.google.android.gms.internal.ads.zzxj r3 = r0.zzm
            r0.zzl = r3
            goto L_0x0255
        L_0x024f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0255:
            android.view.Surface r3 = r0.zzl
            r5 = 0
            com.google.android.gms.internal.ads.zzqj r1 = com.google.android.gms.internal.ads.zzqj.zzb(r1, r4, r2, r3, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxg.zzV(com.google.android.gms.internal.ads.zzqn, com.google.android.gms.internal.ads.zzaf, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzqj");
    }

    /* access modifiers changed from: protected */
    public final List zzW(zzqs zzqs, zzaf zzaf, boolean z) throws zzqz {
        return zzrf.zzg(zzaC(zzqs, zzaf, false, false), zzaf);
    }

    /* access modifiers changed from: protected */
    public final void zzX(Exception exc) {
        zzdw.zzc("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    /* access modifiers changed from: protected */
    public final void zzY(String str, zzqj zzqj, long j, long j2) {
        this.zzg.zza(str, j, j2);
        this.zzj = zzaB(str);
        zzqn zzal = zzal();
        if (zzal != null) {
            boolean z = false;
            if (zzen.zza >= 29 && C1273goto.f62272for.equals(zzal.zzb)) {
                MediaCodecInfo.CodecProfileLevel[] zzg2 = zzal.zzg();
                int length = zzg2.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (zzg2[i].profile == 16384) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            this.zzk = z;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void zzZ(String str) {
        this.zzg.zzb(str);
    }

    /* access modifiers changed from: protected */
    public final void zzaA(long j) {
        zzgs zzgs = this.zza;
        zzgs.zzk += j;
        zzgs.zzl++;
        this.zzA += j;
        this.zzB++;
    }

    /* access modifiers changed from: protected */
    public final void zzaa(zzaf zzaf, MediaFormat mediaFormat) {
        int i;
        int i2;
        zzql zzaj = zzaj();
        if (zzaj != null) {
            zzaj.zzq(this.zzo);
        }
        if (mediaFormat != null) {
            boolean z = false;
            if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
                z = true;
            }
            if (z) {
                i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                i = mediaFormat.getInteger("width");
            }
            this.zzC = i;
            if (z) {
                i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                i2 = mediaFormat.getInteger("height");
            }
            this.zzD = i2;
            this.zzF = zzaf.zzv;
            if (zzen.zza >= 21) {
                int i3 = zzaf.zzu;
                if (i3 == 90 || i3 == 270) {
                    int i4 = this.zzC;
                    this.zzC = this.zzD;
                    this.zzD = i4;
                    this.zzF = 1.0f / this.zzF;
                }
            } else {
                this.zzE = zzaf.zzu;
            }
            this.zzf.zzc(zzaf.zzt);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final void zzab() {
        this.zzr = true;
        if (!this.zzp) {
            this.zzp = true;
            this.zzg.zzq(this.zzl);
            this.zzn = true;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzac() {
        this.zzp = false;
        int i = zzen.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzad(zzgi zzgi) throws zzha {
        this.zzx++;
        int i = zzen.zza;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaf(long j, long j2, zzql zzql, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzaf zzaf) throws zzha {
        boolean z3;
        int zzd2;
        long j4 = j;
        zzql zzql2 = zzql;
        int i4 = i;
        long j5 = j3;
        if (zzql2 != null) {
            if (this.zzs == -9223372036854775807L) {
                this.zzs = j4;
            }
            if (j5 != this.zzy) {
                this.zzf.zzd(j5);
                this.zzy = j5;
            }
            long zzai = zzai();
            long j6 = j5 - zzai;
            if (!z || z2) {
                float zzah = zzah();
                int zzbe = zzbe();
                long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
                long j7 = (long) (((double) (j5 - j4)) / ((double) zzah));
                if (zzbe == 2) {
                    j7 -= elapsedRealtime - j2;
                }
                if (this.zzl != this.zzm) {
                    long j8 = elapsedRealtime - this.zzz;
                    boolean z4 = this.zzr ? !this.zzp : !(zzbe != 2 && !this.zzq);
                    if (this.zzt == -9223372036854775807L && j4 >= zzai && (z4 || (zzbe == 2 && zzaG(j7) && j8 > 100000))) {
                        long nanoTime = System.nanoTime();
                        if (zzen.zza >= 21) {
                            zzax(zzql, i, j6, nanoTime);
                        } else {
                            zzaw(zzql2, i4, j6);
                        }
                        zzaA(j7);
                        return true;
                    } else if (zzbe != 2 || j4 == this.zzs) {
                        return false;
                    } else {
                        long nanoTime2 = System.nanoTime();
                        long zza = this.zzf.zza((j7 * 1000) + nanoTime2);
                        long j9 = (zza - nanoTime2) / 1000;
                        long j10 = this.zzt;
                        if (j9 < -500000 && !z2 && (zzd2 = zzd(j)) != 0) {
                            if (j10 != -9223372036854775807L) {
                                zzgs zzgs = this.zza;
                                zzgs.zzd += zzd2;
                                zzgs.zzf += this.zzx;
                            } else {
                                this.zza.zzj++;
                                zzaz(zzd2, this.zzx);
                            }
                            zzas();
                            return false;
                        } else if (zzaG(j9) && !z2) {
                            if (j10 != -9223372036854775807L) {
                                zzay(zzql2, i4, j6);
                                z3 = true;
                            } else {
                                int i5 = zzen.zza;
                                Trace.beginSection("dropVideoBuffer");
                                zzql2.zzn(i4, false);
                                Trace.endSection();
                                z3 = true;
                                zzaz(0, 1);
                            }
                            zzaA(j9);
                            return z3;
                        } else if (zzen.zza >= 21) {
                            if (j9 >= 50000) {
                                return false;
                            }
                            zzax(zzql, i, j6, zza);
                            zzaA(j9);
                            return true;
                        } else if (j9 >= 30000) {
                            return false;
                        } else {
                            if (j9 > 11000) {
                                try {
                                    Thread.sleep((-10000 + j9) / 1000);
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                    return false;
                                }
                            }
                            zzaw(zzql2, i4, j6);
                            zzaA(j9);
                            return true;
                        }
                    }
                } else if (!zzaG(j7)) {
                    return false;
                } else {
                    zzay(zzql2, i4, j6);
                    zzaA(j7);
                    return true;
                }
            } else {
                zzay(zzql2, i4, j6);
                return true;
            }
        } else {
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public final zzqm zzak(Throwable th, zzqn zzqn) {
        return new zzxe(th, zzqn, this.zzl);
    }

    /* access modifiers changed from: protected */
    public final void zzam(zzgi zzgi) throws zzha {
        if (this.zzk) {
            ByteBuffer byteBuffer = zzgi.zze;
            if (byteBuffer == null) {
                throw null;
            } else if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b != -75 || s != 60 || s2 != 1 || b2 != 4) {
                    return;
                }
                if (b3 == 0 || b3 == 1) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    zzql zzaj = zzaj();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    zzaj.zzp(bundle);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzao(long j) {
        super.zzao(j);
        this.zzx--;
    }

    /* access modifiers changed from: protected */
    public final void zzaq() {
        super.zzaq();
        this.zzx = 0;
    }

    /* access modifiers changed from: protected */
    public final boolean zzau(zzqn zzqn) {
        return this.zzl != null || zzaH(zzqn);
    }

    /* access modifiers changed from: protected */
    public final void zzaw(zzql zzql, int i, long j) {
        zzaD();
        int i2 = zzen.zza;
        Trace.beginSection("releaseOutputBuffer");
        zzql.zzn(i, true);
        Trace.endSection();
        this.zzz = SystemClock.elapsedRealtime() * 1000;
        this.zza.zze++;
        this.zzw = 0;
        zzab();
    }

    /* access modifiers changed from: protected */
    public final void zzax(zzql zzql, int i, long j, long j2) {
        zzaD();
        int i2 = zzen.zza;
        Trace.beginSection("releaseOutputBuffer");
        zzql.zzm(i, j2);
        Trace.endSection();
        this.zzz = SystemClock.elapsedRealtime() * 1000;
        this.zza.zze++;
        this.zzw = 0;
        zzab();
    }

    /* access modifiers changed from: protected */
    public final void zzay(zzql zzql, int i, long j) {
        int i2 = zzen.zza;
        Trace.beginSection("skipVideoBuffer");
        zzql.zzn(i, false);
        Trace.endSection();
        this.zza.zzf++;
    }

    /* access modifiers changed from: protected */
    public final void zzaz(int i, int i2) {
        zzgs zzgs = this.zza;
        zzgs.zzh += i;
        int i3 = i + i2;
        zzgs.zzg += i3;
        this.zzv += i3;
        int i4 = this.zzw + i3;
        this.zzw = i4;
        zzgs.zzi = Math.max(i4, zzgs.zzi);
    }

    /* access modifiers changed from: protected */
    public final void zzs() {
        this.zzG = null;
        this.zzp = false;
        int i = zzen.zza;
        this.zzn = false;
        try {
            super.zzs();
        } finally {
            this.zzg.zzc(this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzt(boolean z, boolean z2) throws zzha {
        super.zzt(z, z2);
        zzk();
        this.zzg.zze(this.zza);
        this.zzq = z2;
        this.zzr = false;
    }

    /* access modifiers changed from: protected */
    public final void zzu(long j, boolean z) throws zzha {
        super.zzu(j, z);
        this.zzp = false;
        int i = zzen.zza;
        this.zzf.zzf();
        this.zzy = -9223372036854775807L;
        this.zzs = -9223372036854775807L;
        this.zzw = 0;
        this.zzt = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public final void zzv() {
        try {
            super.zzv();
            if (this.zzm != null) {
                zzaF();
            }
        } catch (Throwable th) {
            if (this.zzm != null) {
                zzaF();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzw() {
        this.zzv = 0;
        this.zzu = SystemClock.elapsedRealtime();
        this.zzz = SystemClock.elapsedRealtime() * 1000;
        this.zzA = 0;
        this.zzB = 0;
        this.zzf.zzg();
    }

    /* access modifiers changed from: protected */
    public final void zzx() {
        this.zzt = -9223372036854775807L;
        if (this.zzv > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzg.zzd(this.zzv, elapsedRealtime - this.zzu);
            this.zzv = 0;
            this.zzu = elapsedRealtime;
        }
        int i = this.zzB;
        if (i != 0) {
            this.zzg.zzr(this.zzA, i);
            this.zzA = 0;
            this.zzB = 0;
        }
        this.zzf.zzh();
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzp(int r6, java.lang.Object r7) throws com.google.android.gms.internal.ads.zzha {
        /*
            r5 = this;
            r0 = 1
            if (r6 == r0) goto L_0x0042
            r0 = 7
            if (r6 == r0) goto L_0x003d
            r0 = 10
            if (r6 == r0) goto L_0x0030
            r0 = 4
            if (r6 == r0) goto L_0x001e
            r0 = 5
            if (r6 == r0) goto L_0x0012
            goto L_0x00ca
        L_0x0012:
            com.google.android.gms.internal.ads.zzxr r6 = r5.zzf
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r6.zzj(r7)
            return
        L_0x001e:
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r6 = r7.intValue()
            r5.zzo = r6
            com.google.android.gms.internal.ads.zzql r7 = r5.zzaj()
            if (r7 == 0) goto L_0x00ca
            r7.zzq(r6)
            return
        L_0x0030:
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r6 = r7.intValue()
            int r7 = r5.zzH
            if (r7 == r6) goto L_0x00ca
            r5.zzH = r6
            return
        L_0x003d:
            com.google.android.gms.internal.ads.zzxk r7 = (com.google.android.gms.internal.ads.zzxk) r7
            r5.zzI = r7
            return
        L_0x0042:
            boolean r6 = r7 instanceof android.view.Surface
            r0 = 0
            if (r6 == 0) goto L_0x004a
            android.view.Surface r7 = (android.view.Surface) r7
            goto L_0x004b
        L_0x004a:
            r7 = r0
        L_0x004b:
            if (r7 != 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzxj r6 = r5.zzm
            if (r6 == 0) goto L_0x0053
            r7 = r6
            goto L_0x0069
        L_0x0053:
            com.google.android.gms.internal.ads.zzqn r6 = r5.zzal()
            if (r6 == 0) goto L_0x0069
            boolean r1 = r5.zzaH(r6)
            if (r1 == 0) goto L_0x0069
            android.content.Context r7 = r5.zze
            boolean r6 = r6.zzf
            com.google.android.gms.internal.ads.zzxj r7 = com.google.android.gms.internal.ads.zzxj.zza(r7, r6)
            r5.zzm = r7
        L_0x0069:
            android.view.Surface r6 = r5.zzl
            if (r6 == r7) goto L_0x00b6
            r5.zzl = r7
            com.google.android.gms.internal.ads.zzxr r6 = r5.zzf
            r6.zzi(r7)
            r6 = 0
            r5.zzn = r6
            int r1 = r5.zzbe()
            com.google.android.gms.internal.ads.zzql r2 = r5.zzaj()
            if (r2 == 0) goto L_0x0097
            int r3 = com.google.android.gms.internal.ads.zzen.zza
            r4 = 23
            if (r3 < r4) goto L_0x0091
            if (r7 == 0) goto L_0x0091
            boolean r3 = r5.zzj
            if (r3 != 0) goto L_0x0091
            r2.zzo(r7)
            goto L_0x0097
        L_0x0091:
            r5.zzap()
            r5.zzan()
        L_0x0097:
            if (r7 == 0) goto L_0x00af
            com.google.android.gms.internal.ads.zzxj r2 = r5.zzm
            if (r7 == r2) goto L_0x00af
            r5.zzaE()
            r5.zzp = r6
            int r6 = com.google.android.gms.internal.ads.zzen.zza
            r6 = 2
            if (r1 != r6) goto L_0x00ca
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5.zzt = r6
            return
        L_0x00af:
            r5.zzG = r0
            r5.zzp = r6
            int r6 = com.google.android.gms.internal.ads.zzen.zza
            return
        L_0x00b6:
            if (r7 == 0) goto L_0x00ca
            com.google.android.gms.internal.ads.zzxj r6 = r5.zzm
            if (r7 == r6) goto L_0x00ca
            r5.zzaE()
            boolean r6 = r5.zzn
            if (r6 == 0) goto L_0x00ca
            com.google.android.gms.internal.ads.zzyc r6 = r5.zzg
            android.view.Surface r7 = r5.zzl
            r6.zzq(r7)
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxg.zzp(int, java.lang.Object):void");
    }
}
