package com.google.android.gms.internal.ads;

import com.didi.sdk.apm.SystemUtils;
import com.google.common.net.HttpHeaders;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzawj {
    private static final int zzA = zzbar.zzg("sosn");
    private static final int zzB = zzbar.zzg("tvsh");
    private static final int zzC = zzbar.zzg("----");
    private static final String[] zzD = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};
    private static final int zza = zzbar.zzg("nam");
    private static final int zzb = zzbar.zzg("trk");
    private static final int zzc = zzbar.zzg("cmt");
    private static final int zzd = zzbar.zzg("day");
    private static final int zze = zzbar.zzg("ART");
    private static final int zzf = zzbar.zzg("too");
    private static final int zzg = zzbar.zzg("alb");
    private static final int zzh = zzbar.zzg("com");
    private static final int zzi = zzbar.zzg("wrt");
    private static final int zzj = zzbar.zzg("lyr");
    private static final int zzk = zzbar.zzg("gen");
    private static final int zzl = zzbar.zzg("covr");
    private static final int zzm = zzbar.zzg("gnre");
    private static final int zzn = zzbar.zzg("grp");
    private static final int zzo = zzbar.zzg("disk");
    private static final int zzp = zzbar.zzg("trkn");
    private static final int zzq = zzbar.zzg("tmpo");
    private static final int zzr = zzbar.zzg("cpil");
    private static final int zzs = zzbar.zzg("aART");
    private static final int zzt = zzbar.zzg("sonm");
    private static final int zzu = zzbar.zzg("soal");
    private static final int zzv = zzbar.zzg("soar");
    private static final int zzw = zzbar.zzg("soaa");
    private static final int zzx = zzbar.zzg("soco");
    private static final int zzy = zzbar.zzg("rtng");
    private static final int zzz = zzbar.zzg("pgap");

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033 A[Catch:{ all -> 0x01e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a A[Catch:{ all -> 0x01e9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzaxg zza(com.google.android.gms.internal.ads.zzbak r13) {
        /*
            int r0 = r13.zzc()
            int r1 = r13.zze()
            int r0 = r0 + r1
            int r1 = r13.zze()
            int r2 = r1 >> 24
            r2 = r2 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = "und"
            java.lang.String r4 = "TCON"
            r5 = 0
            r6 = 169(0xa9, float:2.37E-43)
            if (r2 == r6) goto L_0x01ec
            int r2 = zzm     // Catch:{ all -> 0x01e9 }
            r6 = -1
            if (r1 != r2) goto L_0x004b
            int r1 = zzb(r13)     // Catch:{ all -> 0x01e9 }
            if (r1 <= 0) goto L_0x0030
            java.lang.String[] r2 = zzD     // Catch:{ all -> 0x01e9 }
            int r3 = r2.length     // Catch:{ all -> 0x01e9 }
            r3 = 148(0x94, float:2.07E-43)
            if (r1 > r3) goto L_0x0030
            int r1 = r1 + r6
            r1 = r2[r1]     // Catch:{ all -> 0x01e9 }
            goto L_0x0031
        L_0x0030:
            r1 = r5
        L_0x0031:
            if (r1 == 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzaxp r2 = new com.google.android.gms.internal.ads.zzaxp     // Catch:{ all -> 0x01e9 }
            r2.<init>(r4, r5, r1)     // Catch:{ all -> 0x01e9 }
            r5 = r2
            goto L_0x0047
        L_0x003a:
            java.lang.String r7 = "MetadataUtil"
            java.lang.String r8 = "Failed to parse standard genre code"
            r6 = 5
            r9 = 0
            java.lang.String r10 = "com.google.android.gms.internal.ads.zzawj"
            r11 = 8
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01e9 }
        L_0x0047:
            r13.zzv(r0)
            return r5
        L_0x004b:
            int r2 = zzo     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x0059
            java.lang.String r2 = "TPOS"
            com.google.android.gms.internal.ads.zzaxp r1 = zzd(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x0059:
            int r2 = zzp     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x0067
            java.lang.String r2 = "TRCK"
            com.google.android.gms.internal.ads.zzaxp r1 = zzd(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x0067:
            int r2 = zzq     // Catch:{ all -> 0x01e9 }
            r4 = 1
            r7 = 0
            if (r1 != r2) goto L_0x0077
            java.lang.String r2 = "TBPM"
            com.google.android.gms.internal.ads.zzaxn r1 = zzc(r1, r2, r13, r4, r7)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x0077:
            int r2 = zzr     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x0085
            java.lang.String r2 = "TCMP"
            com.google.android.gms.internal.ads.zzaxn r1 = zzc(r1, r2, r13, r4, r4)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x0085:
            int r2 = zzl     // Catch:{ all -> 0x01e9 }
            r8 = 4
            if (r1 != r2) goto L_0x00f1
            int r1 = r13.zze()     // Catch:{ all -> 0x01e9 }
            int r2 = r13.zze()     // Catch:{ all -> 0x01e9 }
            int r3 = com.google.android.gms.internal.ads.zzavw.zzaH     // Catch:{ all -> 0x01e9 }
            if (r2 != r3) goto L_0x00e0
            int r2 = r13.zze()     // Catch:{ all -> 0x01e9 }
            int r2 = com.google.android.gms.internal.ads.zzavw.zze(r2)     // Catch:{ all -> 0x01e9 }
            r3 = 13
            r4 = 14
            if (r2 != r3) goto L_0x00a7
            java.lang.String r3 = "image/jpeg"
            goto L_0x00af
        L_0x00a7:
            if (r2 != r4) goto L_0x00ae
            java.lang.String r3 = "image/png"
            r2 = 14
            goto L_0x00af
        L_0x00ae:
            r3 = r5
        L_0x00af:
            if (r3 != 0) goto L_0x00ce
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e9 }
            r1.<init>()     // Catch:{ all -> 0x01e9 }
            java.lang.String r3 = "Unrecognized cover art flags: "
            r1.append(r3)     // Catch:{ all -> 0x01e9 }
            r1.append(r2)     // Catch:{ all -> 0x01e9 }
            java.lang.String r7 = "MetadataUtil"
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x01e9 }
            r6 = 5
            r9 = 0
            java.lang.String r10 = "com.google.android.gms.internal.ads.zzawj"
            r11 = 18
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01e9 }
            goto L_0x00ed
        L_0x00ce:
            r13.zzw(r8)     // Catch:{ all -> 0x01e9 }
            int r1 = r1 + -16
            byte[] r2 = new byte[r1]     // Catch:{ all -> 0x01e9 }
            r13.zzq(r2, r7, r1)     // Catch:{ all -> 0x01e9 }
            com.google.android.gms.internal.ads.zzaxj r1 = new com.google.android.gms.internal.ads.zzaxj     // Catch:{ all -> 0x01e9 }
            r4 = 3
            r1.<init>(r3, r5, r4, r2)     // Catch:{ all -> 0x01e9 }
            r5 = r1
            goto L_0x00ed
        L_0x00e0:
            java.lang.String r7 = "MetadataUtil"
            java.lang.String r8 = "Failed to parse cover art attribute"
            r6 = 5
            r9 = 0
            java.lang.String r10 = "com.google.android.gms.internal.ads.zzawj"
            r11 = 23
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01e9 }
        L_0x00ed:
            r13.zzv(r0)
            return r5
        L_0x00f1:
            int r2 = zzs     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x00ff
            java.lang.String r2 = "TPE2"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x00ff:
            int r2 = zzt     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x010d
            java.lang.String r2 = "TSOT"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x010d:
            int r2 = zzu     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x011b
            java.lang.String r2 = "TSO2"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x011b:
            int r2 = zzv     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x0129
            java.lang.String r2 = "TSOA"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x0129:
            int r2 = zzw     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x0137
            java.lang.String r2 = "TSOP"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x0137:
            int r2 = zzx     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x0145
            java.lang.String r2 = "TSOC"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x0145:
            int r2 = zzy     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x0153
            java.lang.String r2 = "ITUNESADVISORY"
            com.google.android.gms.internal.ads.zzaxn r1 = zzc(r1, r2, r13, r7, r7)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x0153:
            int r2 = zzz     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x0161
            java.lang.String r2 = "ITUNESGAPLESS"
            com.google.android.gms.internal.ads.zzaxn r1 = zzc(r1, r2, r13, r7, r4)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x0161:
            int r2 = zzA     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x016f
            java.lang.String r2 = "TVSHOWSORT"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x016f:
            int r2 = zzB     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x017d
            java.lang.String r2 = "TVSHOW"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x017d:
            int r2 = zzC     // Catch:{ all -> 0x01e9 }
            if (r1 != r2) goto L_0x029e
            r1 = r5
            r2 = r1
            r4 = -1
            r7 = -1
        L_0x0185:
            int r9 = r13.zzc()     // Catch:{ all -> 0x01e9 }
            if (r9 >= r0) goto L_0x01bf
            int r9 = r13.zzc()     // Catch:{ all -> 0x01e9 }
            int r10 = r13.zze()     // Catch:{ all -> 0x01e9 }
            int r11 = r13.zze()     // Catch:{ all -> 0x01e9 }
            r13.zzw(r8)     // Catch:{ all -> 0x01e9 }
            int r12 = com.google.android.gms.internal.ads.zzavw.zzaF     // Catch:{ all -> 0x01e9 }
            if (r11 != r12) goto L_0x01a5
            int r10 = r10 + -12
            java.lang.String r1 = r13.zzo(r10)     // Catch:{ all -> 0x01e9 }
            goto L_0x0185
        L_0x01a5:
            int r12 = com.google.android.gms.internal.ads.zzavw.zzaG     // Catch:{ all -> 0x01e9 }
            if (r11 != r12) goto L_0x01b0
            int r10 = r10 + -12
            java.lang.String r2 = r13.zzo(r10)     // Catch:{ all -> 0x01e9 }
            goto L_0x0185
        L_0x01b0:
            int r12 = com.google.android.gms.internal.ads.zzavw.zzaH     // Catch:{ all -> 0x01e9 }
            if (r11 != r12) goto L_0x01b5
            r7 = r10
        L_0x01b5:
            if (r11 == r12) goto L_0x01b8
            goto L_0x01b9
        L_0x01b8:
            r4 = r9
        L_0x01b9:
            int r10 = r10 + -12
            r13.zzw(r10)     // Catch:{ all -> 0x01e9 }
            goto L_0x0185
        L_0x01bf:
            java.lang.String r8 = "com.apple.iTunes"
            boolean r1 = r8.equals(r1)     // Catch:{ all -> 0x01e9 }
            if (r1 == 0) goto L_0x01e5
            java.lang.String r1 = "iTunSMPB"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x01e9 }
            if (r1 == 0) goto L_0x01e5
            if (r4 != r6) goto L_0x01d2
            goto L_0x01e5
        L_0x01d2:
            r13.zzv(r4)     // Catch:{ all -> 0x01e9 }
            r1 = 16
            r13.zzw(r1)     // Catch:{ all -> 0x01e9 }
            int r7 = r7 + -16
            java.lang.String r1 = r13.zzo(r7)     // Catch:{ all -> 0x01e9 }
            com.google.android.gms.internal.ads.zzaxl r5 = new com.google.android.gms.internal.ads.zzaxl     // Catch:{ all -> 0x01e9 }
            r5.<init>(r3, r2, r1)     // Catch:{ all -> 0x01e9 }
        L_0x01e5:
            r13.zzv(r0)
            return r5
        L_0x01e9:
            r1 = move-exception
            goto L_0x02d6
        L_0x01ec:
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r1
            int r6 = zzc     // Catch:{ all -> 0x01e9 }
            if (r2 != r6) goto L_0x022a
            int r2 = r13.zze()     // Catch:{ all -> 0x01e9 }
            int r4 = r13.zze()     // Catch:{ all -> 0x01e9 }
            int r6 = com.google.android.gms.internal.ads.zzavw.zzaH     // Catch:{ all -> 0x01e9 }
            if (r4 != r6) goto L_0x0211
            r1 = 8
            r13.zzw(r1)     // Catch:{ all -> 0x01e9 }
            int r2 = r2 + -16
            java.lang.String r1 = r13.zzo(r2)     // Catch:{ all -> 0x01e9 }
            com.google.android.gms.internal.ads.zzaxl r5 = new com.google.android.gms.internal.ads.zzaxl     // Catch:{ all -> 0x01e9 }
            r5.<init>(r3, r1, r1)     // Catch:{ all -> 0x01e9 }
            goto L_0x0226
        L_0x0211:
            java.lang.String r7 = "MetadataUtil"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzavw.zzg(r1)     // Catch:{ all -> 0x01e9 }
            java.lang.String r2 = "Failed to parse comment attribute: "
            java.lang.String r8 = r2.concat(r1)     // Catch:{ all -> 0x01e9 }
            r6 = 5
            r9 = 0
            java.lang.String r10 = "com.google.android.gms.internal.ads.zzawj"
            r11 = 54
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01e9 }
        L_0x0226:
            r13.zzv(r0)
            return r5
        L_0x022a:
            int r3 = zza     // Catch:{ all -> 0x01e9 }
            if (r2 == r3) goto L_0x02cc
            int r3 = zzb     // Catch:{ all -> 0x01e9 }
            if (r2 != r3) goto L_0x0234
            goto L_0x02cc
        L_0x0234:
            int r3 = zzh     // Catch:{ all -> 0x01e9 }
            if (r2 == r3) goto L_0x02c2
            int r3 = zzi     // Catch:{ all -> 0x01e9 }
            if (r2 != r3) goto L_0x023e
            goto L_0x02c2
        L_0x023e:
            int r3 = zzd     // Catch:{ all -> 0x01e9 }
            if (r2 != r3) goto L_0x024c
            java.lang.String r2 = "TDRC"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x024c:
            int r3 = zze     // Catch:{ all -> 0x01e9 }
            if (r2 != r3) goto L_0x025a
            java.lang.String r2 = "TPE1"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x025a:
            int r3 = zzf     // Catch:{ all -> 0x01e9 }
            if (r2 != r3) goto L_0x0268
            java.lang.String r2 = "TSSE"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x0268:
            int r3 = zzg     // Catch:{ all -> 0x01e9 }
            if (r2 != r3) goto L_0x0276
            java.lang.String r2 = "TALB"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x0276:
            int r3 = zzj     // Catch:{ all -> 0x01e9 }
            if (r2 != r3) goto L_0x0284
            java.lang.String r2 = "USLT"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x0284:
            int r3 = zzk     // Catch:{ all -> 0x01e9 }
            if (r2 != r3) goto L_0x0290
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r4, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x0290:
            int r3 = zzn     // Catch:{ all -> 0x01e9 }
            if (r2 != r3) goto L_0x029e
            java.lang.String r2 = "TIT1"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x029e:
            java.lang.String r1 = com.google.android.gms.internal.ads.zzavw.zzg(r1)     // Catch:{ all -> 0x01e9 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e9 }
            r2.<init>()     // Catch:{ all -> 0x01e9 }
            java.lang.String r3 = "Skipped unknown metadata entry: "
            r2.append(r3)     // Catch:{ all -> 0x01e9 }
            r2.append(r1)     // Catch:{ all -> 0x01e9 }
            java.lang.String r7 = "MetadataUtil"
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x01e9 }
            r6 = 3
            r9 = 0
            java.lang.String r10 = "com.google.android.gms.internal.ads.zzawj"
            r11 = 63
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r5
        L_0x02c2:
            java.lang.String r2 = "TCOM"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x02cc:
            java.lang.String r2 = "TIT2"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01e9 }
            r13.zzv(r0)
            return r1
        L_0x02d6:
            r13.zzv(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawj.zza(com.google.android.gms.internal.ads.zzbak):com.google.android.gms.internal.ads.zzaxg");
    }

    private static int zzb(zzbak zzbak) {
        zzbak.zzw(4);
        if (zzbak.zze() == zzavw.zzaH) {
            zzbak.zzw(8);
            return zzbak.zzg();
        }
        SystemUtils.log(5, "MetadataUtil", "Failed to parse uint8 attribute value", (Throwable) null, "com.google.android.gms.internal.ads.zzawj", 6);
        return -1;
    }

    private static zzaxn zzc(int i, String str, zzbak zzbak, boolean z, boolean z2) {
        int zzb2 = zzb(zzbak);
        if (z2) {
            zzb2 = Math.min(1, zzb2);
        }
        if (zzb2 < 0) {
            SystemUtils.log(5, "MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzavw.zzg(i)), (Throwable) null, "com.google.android.gms.internal.ads.zzawj", 5);
            return null;
        } else if (z) {
            return new zzaxp(str, (String) null, Integer.toString(zzb2));
        } else {
            return new zzaxl("und", str, Integer.toString(zzb2));
        }
    }

    private static zzaxp zzd(int i, String str, zzbak zzbak) {
        int zze2 = zzbak.zze();
        if (zzbak.zze() == zzavw.zzaH && zze2 >= 22) {
            zzbak.zzw(10);
            int zzj2 = zzbak.zzj();
            if (zzj2 > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(zzj2);
                String sb2 = sb.toString();
                int zzj3 = zzbak.zzj();
                if (zzj3 > 0) {
                    sb2 = sb2 + "/" + zzj3;
                }
                return new zzaxp(str, (String) null, sb2);
            }
        }
        SystemUtils.log(5, "MetadataUtil", "Failed to parse index/count attribute: ".concat(zzavw.zzg(i)), (Throwable) null, "com.google.android.gms.internal.ads.zzawj", 6);
        return null;
    }

    private static zzaxp zze(int i, String str, zzbak zzbak) {
        int zze2 = zzbak.zze();
        if (zzbak.zze() == zzavw.zzaH) {
            zzbak.zzw(8);
            return new zzaxp(str, (String) null, zzbak.zzo(zze2 - 16));
        }
        SystemUtils.log(5, "MetadataUtil", "Failed to parse text attribute: ".concat(zzavw.zzg(i)), (Throwable) null, "com.google.android.gms.internal.ads.zzawj", 7);
        return null;
    }
}
