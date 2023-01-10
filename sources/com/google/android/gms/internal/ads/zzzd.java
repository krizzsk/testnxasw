package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzzd implements zzzp {
    private static final int[] zza = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};
    private static final zzzc zzc = new zzzc(zzyz.zza);
    private static final zzzc zzd = new zzzc(zzza.zza);

    private static final void zzc(int i, List list) {
        switch (i) {
            case 0:
                list.add(new zzagr());
                return;
            case 1:
                list.add(new zzagu());
                return;
            case 2:
                list.add(new zzagx(0));
                return;
            case 3:
                list.add(new zzaax(0));
                return;
            case 4:
                zzzi zza2 = zzc.zza(0);
                if (zza2 != null) {
                    list.add(zza2);
                    return;
                } else {
                    list.add(new zzabo(0));
                    return;
                }
            case 5:
                list.add(new zzabr());
                return;
            case 6:
                list.add(new zzaei(0));
                return;
            case 7:
                list.add(new zzaeq(0));
                return;
            case 8:
                list.add(new zzafl(0, (zzel) null));
                list.add(new zzafq(0));
                return;
            case 9:
                list.add(new zzagf());
                return;
            case 10:
                list.add(new zzaia());
                return;
            case 11:
                list.add(new zzaik(1, 0, 112800));
                return;
            case 12:
                list.add(new zzaiw());
                return;
            case 14:
                list.add(new zzabw());
                return;
            case 15:
                zzzi zza3 = zzd.zza(new Object[0]);
                if (zza3 != null) {
                    list.add(zza3);
                    return;
                }
                return;
            case 16:
                list.add(new zzabc());
                return;
            default:
                return;
        }
    }

    public final synchronized zzzi[] zza() {
        return zzb(Uri.EMPTY, new HashMap());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v76, resolved type: java.lang.String} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0188, code lost:
        r3 = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x018b, code lost:
        r3 = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x018e, code lost:
        r3 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0191, code lost:
        r3 = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0193, code lost:
        r3 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0195, code lost:
        r3 = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0198, code lost:
        r3 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x019a, code lost:
        r3 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x019c, code lost:
        r3 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x019e, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01a0, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0173, code lost:
        r3 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0174, code lost:
        switch(r3) {
            case 0: goto L_0x01a0;
            case 1: goto L_0x01a0;
            case 2: goto L_0x01a0;
            case 3: goto L_0x019e;
            case 4: goto L_0x019c;
            case 5: goto L_0x019c;
            case 6: goto L_0x019c;
            case 7: goto L_0x019a;
            case 8: goto L_0x0198;
            case 9: goto L_0x0195;
            case 10: goto L_0x0193;
            case 11: goto L_0x0193;
            case 12: goto L_0x0193;
            case 13: goto L_0x0193;
            case 14: goto L_0x0193;
            case 15: goto L_0x0191;
            case 16: goto L_0x018e;
            case 17: goto L_0x018e;
            case 18: goto L_0x018e;
            case 19: goto L_0x018b;
            case 20: goto L_0x0188;
            case 21: goto L_0x0185;
            case 22: goto L_0x0182;
            case 23: goto L_0x017f;
            case 24: goto L_0x017c;
            case 25: goto L_0x0179;
            default: goto L_0x0177;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0179, code lost:
        r3 = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x017c, code lost:
        r3 = 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x017f, code lost:
        r3 = 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0182, code lost:
        r3 = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0185, code lost:
        r3 = 11;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0324  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzzi[] zzb(android.net.Uri r21, java.util.Map r22) {
        /*
            r20 = this;
            monitor-enter(r20)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x033e }
            r1 = 16
            r0.<init>(r1)     // Catch:{ all -> 0x033e }
            java.lang.String r2 = "Content-Type"
            r3 = r22
            java.lang.Object r2 = r3.get(r2)     // Catch:{ all -> 0x033e }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x033e }
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x0024
            boolean r5 = r2.isEmpty()     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x001d
            goto L_0x0024
        L_0x001d:
            java.lang.Object r2 = r2.get(r4)     // Catch:{ all -> 0x033e }
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x033e }
        L_0x0024:
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 14
            r10 = 13
            r11 = 12
            r12 = 11
            r13 = 9
            r14 = 6
            r15 = 1
            r16 = 15
            r17 = 10
            r18 = 8
            r2 = -1
            if (r3 != 0) goto L_0x003f
        L_0x003c:
            r3 = -1
            goto L_0x01a1
        L_0x003f:
            java.lang.String r3 = com.google.android.gms.internal.ads.zzbt.zze(r3)     // Catch:{ all -> 0x033e }
            int r19 = r3.hashCode()     // Catch:{ all -> 0x033e }
            switch(r19) {
                case -2123537834: goto L_0x0169;
                case -1662384011: goto L_0x015e;
                case -1662384007: goto L_0x0153;
                case -1662095187: goto L_0x0148;
                case -1606874997: goto L_0x013e;
                case -1487394660: goto L_0x0133;
                case -1248337486: goto L_0x0128;
                case -1079884372: goto L_0x011d;
                case -1004728940: goto L_0x0112;
                case -387023398: goto L_0x0106;
                case -43467528: goto L_0x00fa;
                case 13915911: goto L_0x00ee;
                case 187078296: goto L_0x00e3;
                case 187078297: goto L_0x00d8;
                case 187078669: goto L_0x00cd;
                case 187090232: goto L_0x00c1;
                case 187091926: goto L_0x00b5;
                case 187099443: goto L_0x00a9;
                case 1331848029: goto L_0x009d;
                case 1503095341: goto L_0x0092;
                case 1504578661: goto L_0x0087;
                case 1504619009: goto L_0x007c;
                case 1504824762: goto L_0x0070;
                case 1504831518: goto L_0x0064;
                case 1505118770: goto L_0x0058;
                case 2039520277: goto L_0x004c;
                default: goto L_0x004a;
            }     // Catch:{ all -> 0x033e }
        L_0x004a:
            goto L_0x0173
        L_0x004c:
            java.lang.String r4 = "video/x-matroska"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 10
            goto L_0x0174
        L_0x0058:
            java.lang.String r4 = "audio/webm"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 13
            goto L_0x0174
        L_0x0064:
            java.lang.String r4 = "audio/mpeg"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 15
            goto L_0x0174
        L_0x0070:
            java.lang.String r4 = "audio/midi"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 9
            goto L_0x0174
        L_0x007c:
            java.lang.String r4 = "audio/flac"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 7
            goto L_0x0174
        L_0x0087:
            java.lang.String r4 = "audio/eac3"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 1
            goto L_0x0174
        L_0x0092:
            java.lang.String r4 = "audio/3gpp"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 5
            goto L_0x0174
        L_0x009d:
            java.lang.String r4 = "video/mp4"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 16
            goto L_0x0174
        L_0x00a9:
            java.lang.String r4 = "audio/wav"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 22
            goto L_0x0174
        L_0x00b5:
            java.lang.String r4 = "audio/ogg"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 19
            goto L_0x0174
        L_0x00c1:
            java.lang.String r4 = "audio/mp4"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 17
            goto L_0x0174
        L_0x00cd:
            java.lang.String r4 = "audio/amr"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 4
            goto L_0x0174
        L_0x00d8:
            java.lang.String r4 = "audio/ac4"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 3
            goto L_0x0174
        L_0x00e3:
            java.lang.String r4 = "audio/ac3"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 0
            goto L_0x0174
        L_0x00ee:
            java.lang.String r4 = "video/x-flv"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 8
            goto L_0x0174
        L_0x00fa:
            java.lang.String r4 = "application/webm"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 14
            goto L_0x0174
        L_0x0106:
            java.lang.String r4 = "audio/x-matroska"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 11
            goto L_0x0174
        L_0x0112:
            java.lang.String r4 = "text/vtt"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 23
            goto L_0x0174
        L_0x011d:
            java.lang.String r4 = "video/x-msvideo"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 25
            goto L_0x0174
        L_0x0128:
            java.lang.String r4 = "application/mp4"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 18
            goto L_0x0174
        L_0x0133:
            java.lang.String r4 = "image/jpeg"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 24
            goto L_0x0174
        L_0x013e:
            java.lang.String r4 = "audio/amr-wb"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 6
            goto L_0x0174
        L_0x0148:
            java.lang.String r4 = "video/webm"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 12
            goto L_0x0174
        L_0x0153:
            java.lang.String r4 = "video/mp2t"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 21
            goto L_0x0174
        L_0x015e:
            java.lang.String r4 = "video/mp2p"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 20
            goto L_0x0174
        L_0x0169:
            java.lang.String r4 = "audio/eac3-joc"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x033e }
            if (r3 == 0) goto L_0x0173
            r3 = 2
            goto L_0x0174
        L_0x0173:
            r3 = -1
        L_0x0174:
            switch(r3) {
                case 0: goto L_0x01a0;
                case 1: goto L_0x01a0;
                case 2: goto L_0x01a0;
                case 3: goto L_0x019e;
                case 4: goto L_0x019c;
                case 5: goto L_0x019c;
                case 6: goto L_0x019c;
                case 7: goto L_0x019a;
                case 8: goto L_0x0198;
                case 9: goto L_0x0195;
                case 10: goto L_0x0193;
                case 11: goto L_0x0193;
                case 12: goto L_0x0193;
                case 13: goto L_0x0193;
                case 14: goto L_0x0193;
                case 15: goto L_0x0191;
                case 16: goto L_0x018e;
                case 17: goto L_0x018e;
                case 18: goto L_0x018e;
                case 19: goto L_0x018b;
                case 20: goto L_0x0188;
                case 21: goto L_0x0185;
                case 22: goto L_0x0182;
                case 23: goto L_0x017f;
                case 24: goto L_0x017c;
                case 25: goto L_0x0179;
                default: goto L_0x0177;
            }     // Catch:{ all -> 0x033e }
        L_0x0177:
            goto L_0x003c
        L_0x0179:
            r3 = 16
            goto L_0x01a1
        L_0x017c:
            r3 = 14
            goto L_0x01a1
        L_0x017f:
            r3 = 13
            goto L_0x01a1
        L_0x0182:
            r3 = 12
            goto L_0x01a1
        L_0x0185:
            r3 = 11
            goto L_0x01a1
        L_0x0188:
            r3 = 10
            goto L_0x01a1
        L_0x018b:
            r3 = 9
            goto L_0x01a1
        L_0x018e:
            r3 = 8
            goto L_0x01a1
        L_0x0191:
            r3 = 7
            goto L_0x01a1
        L_0x0193:
            r3 = 6
            goto L_0x01a1
        L_0x0195:
            r3 = 15
            goto L_0x01a1
        L_0x0198:
            r3 = 5
            goto L_0x01a1
        L_0x019a:
            r3 = 4
            goto L_0x01a1
        L_0x019c:
            r3 = 3
            goto L_0x01a1
        L_0x019e:
            r3 = 1
            goto L_0x01a1
        L_0x01a0:
            r3 = 0
        L_0x01a1:
            if (r3 == r2) goto L_0x01a6
            zzc(r3, r0)     // Catch:{ all -> 0x033e }
        L_0x01a6:
            java.lang.String r4 = r21.getLastPathSegment()     // Catch:{ all -> 0x033e }
            if (r4 != 0) goto L_0x01af
        L_0x01ac:
            r9 = -1
            goto L_0x0318
        L_0x01af:
            java.lang.String r5 = ".ac3"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x0317
            java.lang.String r5 = ".ec3"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x01c1
            goto L_0x0317
        L_0x01c1:
            java.lang.String r5 = ".ac4"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x01cc
            r9 = 1
            goto L_0x0318
        L_0x01cc:
            java.lang.String r5 = ".adts"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x0315
            java.lang.String r5 = ".aac"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x01de
            goto L_0x0315
        L_0x01de:
            java.lang.String r5 = ".amr"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x01e9
            r9 = 3
            goto L_0x0318
        L_0x01e9:
            java.lang.String r5 = ".flac"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x01f4
            r9 = 4
            goto L_0x0318
        L_0x01f4:
            java.lang.String r5 = ".flv"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x01ff
            r9 = 5
            goto L_0x0318
        L_0x01ff:
            java.lang.String r5 = ".mid"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x0312
            java.lang.String r5 = ".midi"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x0312
            java.lang.String r5 = ".smf"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x0219
            goto L_0x0312
        L_0x0219:
            java.lang.String r5 = ".mk"
            int r6 = r4.length()     // Catch:{ all -> 0x033e }
            int r6 = r6 + -4
            boolean r5 = r4.startsWith(r5, r6)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x0310
            java.lang.String r5 = ".webm"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x0231
            goto L_0x0310
        L_0x0231:
            java.lang.String r5 = ".mp3"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x023c
            r9 = 7
            goto L_0x0318
        L_0x023c:
            java.lang.String r5 = ".mp4"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x030d
            java.lang.String r5 = ".m4"
            int r6 = r4.length()     // Catch:{ all -> 0x033e }
            int r6 = r6 + -4
            boolean r5 = r4.startsWith(r5, r6)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x030d
            java.lang.String r5 = ".mp4"
            int r6 = r4.length()     // Catch:{ all -> 0x033e }
            int r6 = r6 + -5
            boolean r5 = r4.startsWith(r5, r6)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x030d
            java.lang.String r5 = ".cmf"
            int r6 = r4.length()     // Catch:{ all -> 0x033e }
            int r6 = r6 + -5
            boolean r5 = r4.startsWith(r5, r6)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x0270
            goto L_0x030d
        L_0x0270:
            java.lang.String r5 = ".og"
            int r6 = r4.length()     // Catch:{ all -> 0x033e }
            int r6 = r6 + -4
            boolean r5 = r4.startsWith(r5, r6)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x030a
            java.lang.String r5 = ".opus"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x0288
            goto L_0x030a
        L_0x0288:
            java.lang.String r5 = ".ps"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x0307
            java.lang.String r5 = ".mpeg"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x0307
            java.lang.String r5 = ".mpg"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x0307
            java.lang.String r5 = ".m2p"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x02a9
            goto L_0x0307
        L_0x02a9:
            java.lang.String r5 = ".ts"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x0304
            java.lang.String r5 = ".ts"
            int r6 = r4.length()     // Catch:{ all -> 0x033e }
            int r6 = r6 + -4
            boolean r5 = r4.startsWith(r5, r6)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x02c0
            goto L_0x0304
        L_0x02c0:
            java.lang.String r5 = ".wav"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x0301
            java.lang.String r5 = ".wave"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x02d1
            goto L_0x0301
        L_0x02d1:
            java.lang.String r5 = ".vtt"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x02fe
            java.lang.String r5 = ".webvtt"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x02e2
            goto L_0x02fe
        L_0x02e2:
            java.lang.String r5 = ".jpg"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 != 0) goto L_0x0318
            java.lang.String r5 = ".jpeg"
            boolean r5 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r5 == 0) goto L_0x02f3
            goto L_0x0318
        L_0x02f3:
            java.lang.String r5 = ".avi"
            boolean r4 = r4.endsWith(r5)     // Catch:{ all -> 0x033e }
            if (r4 == 0) goto L_0x01ac
            r9 = 16
            goto L_0x0318
        L_0x02fe:
            r9 = 13
            goto L_0x0318
        L_0x0301:
            r9 = 12
            goto L_0x0318
        L_0x0304:
            r9 = 11
            goto L_0x0318
        L_0x0307:
            r9 = 10
            goto L_0x0318
        L_0x030a:
            r9 = 9
            goto L_0x0318
        L_0x030d:
            r9 = 8
            goto L_0x0318
        L_0x0310:
            r9 = 6
            goto L_0x0318
        L_0x0312:
            r9 = 15
            goto L_0x0318
        L_0x0315:
            r9 = 2
            goto L_0x0318
        L_0x0317:
            r9 = 0
        L_0x0318:
            if (r9 == r2) goto L_0x031f
            if (r9 == r3) goto L_0x031f
            zzc(r9, r0)     // Catch:{ all -> 0x033e }
        L_0x031f:
            int[] r2 = zza     // Catch:{ all -> 0x033e }
            r4 = 0
        L_0x0322:
            if (r4 >= r1) goto L_0x0330
            r5 = r2[r4]     // Catch:{ all -> 0x033e }
            if (r5 == r3) goto L_0x032d
            if (r5 == r9) goto L_0x032d
            zzc(r5, r0)     // Catch:{ all -> 0x033e }
        L_0x032d:
            int r4 = r4 + 1
            goto L_0x0322
        L_0x0330:
            int r1 = r0.size()     // Catch:{ all -> 0x033e }
            com.google.android.gms.internal.ads.zzzi[] r1 = new com.google.android.gms.internal.ads.zzzi[r1]     // Catch:{ all -> 0x033e }
            java.lang.Object[] r0 = r0.toArray(r1)     // Catch:{ all -> 0x033e }
            com.google.android.gms.internal.ads.zzzi[] r0 = (com.google.android.gms.internal.ads.zzzi[]) r0     // Catch:{ all -> 0x033e }
            monitor-exit(r20)
            return r0
        L_0x033e:
            r0 = move-exception
            monitor-exit(r20)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzd.zzb(android.net.Uri, java.util.Map):com.google.android.gms.internal.ads.zzzi[]");
    }
}
