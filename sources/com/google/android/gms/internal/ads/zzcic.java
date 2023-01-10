package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.didi.dimina.container.monitor.ErrorCode;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcic extends zzcie implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map zzd;
    private final zzciy zze;
    private final zzciz zzf;
    private final boolean zzg;
    private int zzh = 0;
    private int zzi = 0;
    private MediaPlayer zzj;
    private Uri zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private zzciw zzo;
    private final boolean zzp;
    private int zzq;
    /* access modifiers changed from: private */
    public zzcid zzr;
    /* access modifiers changed from: private */
    public boolean zzs = false;
    private Integer zzt = null;

    static {
        HashMap hashMap = new HashMap();
        zzd = hashMap;
        hashMap.put(Integer.valueOf(ErrorCode.APP_SERVICE_READ_ERROR), "MEDIA_ERROR_IO");
        zzd.put(-1007, "MEDIA_ERROR_MALFORMED");
        zzd.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        zzd.put(-110, "MEDIA_ERROR_TIMED_OUT");
        zzd.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        zzd.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzd.put(1, "MEDIA_ERROR_UNKNOWN");
        zzd.put(1, "MEDIA_INFO_UNKNOWN");
        zzd.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzd.put(701, "MEDIA_INFO_BUFFERING_START");
        zzd.put(702, "MEDIA_INFO_BUFFERING_END");
        zzd.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzd.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzd.put(802, "MEDIA_INFO_METADATA_UPDATE");
        zzd.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        zzd.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzcic(Context context, zzciy zzciy, boolean z, boolean z2, zzcix zzcix, zzciz zzciz, Integer num) {
        super(context, num);
        setSurfaceTextureListener(this);
        this.zze = zzciy;
        this.zzf = zzciz;
        this.zzp = z;
        this.zzg = z2;
        zzciz.zza(this);
    }

    private final void zzC() {
        zze.zza("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzk != null && surfaceTexture != null) {
            zzD(false);
            try {
                zzt.zzk();
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.zzj = mediaPlayer;
                mediaPlayer.setOnBufferingUpdateListener(this);
                this.zzj.setOnCompletionListener(this);
                this.zzj.setOnErrorListener(this);
                this.zzj.setOnInfoListener(this);
                this.zzj.setOnPreparedListener(this);
                this.zzj.setOnVideoSizeChangedListener(this);
                this.zzn = 0;
                if (this.zzp) {
                    zzciw zzciw = new zzciw(getContext());
                    this.zzo = zzciw;
                    zzciw.zzd(surfaceTexture, getWidth(), getHeight());
                    this.zzo.start();
                    SurfaceTexture zzb = this.zzo.zzb();
                    if (zzb != null) {
                        surfaceTexture = zzb;
                    } else {
                        this.zzo.zze();
                        this.zzo = null;
                    }
                }
                this.zzj.setDataSource(getContext(), this.zzk);
                zzt.zzl();
                this.zzj.setSurface(new Surface(surfaceTexture));
                this.zzj.setAudioStreamType(3);
                this.zzj.setScreenOnWhilePlaying(true);
                this.zzj.prepareAsync();
                zzE(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                zze.zzk("Failed to initialize MediaPlayer at ".concat(String.valueOf(String.valueOf(this.zzk))), e);
                onError(this.zzj, 1, 0);
            }
        }
    }

    private final void zzD(boolean z) {
        zze.zza("AdMediaPlayerView release");
        zzciw zzciw = this.zzo;
        if (zzciw != null) {
            zzciw.zze();
            this.zzo = null;
        }
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzj.release();
            this.zzj = null;
            zzE(0);
            if (z) {
                this.zzi = 0;
            }
        }
    }

    private final void zzE(int i) {
        if (i == 3) {
            this.zzf.zzc();
            this.zzb.zzb();
        } else if (this.zzh == 3) {
            this.zzf.zze();
            this.zzb.zzc();
        }
        this.zzh = i;
    }

    private final void zzF(float f) {
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zze.zzj("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.zzh;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzG() {
        /*
            r2 = this;
            android.media.MediaPlayer r0 = r2.zzj
            if (r0 == 0) goto L_0x000f
            int r0 = r2.zzh
            r1 = -1
            if (r0 == r1) goto L_0x000f
            if (r0 == 0) goto L_0x000f
            r1 = 1
            if (r0 == r1) goto L_0x000f
            return r1
        L_0x000f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcic.zzG():boolean");
    }

    static /* synthetic */ void zzl(zzcic zzcic, MediaPlayer mediaPlayer) {
        MediaPlayer.TrackInfo[] trackInfo;
        MediaFormat format;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbD)).booleanValue() && zzcic.zze != null && mediaPlayer != null && (trackInfo = mediaPlayer.getTrackInfo()) != null) {
            HashMap hashMap = new HashMap();
            for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                if (trackInfo2 != null) {
                    int trackType = trackInfo2.getTrackType();
                    if (trackType == 1) {
                        MediaFormat format2 = trackInfo2.getFormat();
                        if (format2 != null) {
                            if (format2.containsKey("frame-rate")) {
                                try {
                                    hashMap.put("frameRate", String.valueOf(format2.getFloat("frame-rate")));
                                } catch (ClassCastException unused) {
                                    hashMap.put("frameRate", String.valueOf(format2.getInteger("frame-rate")));
                                }
                            }
                            if (format2.containsKey(SDKConsts.TAG_KEY_BITRATE)) {
                                Integer valueOf = Integer.valueOf(format2.getInteger(SDKConsts.TAG_KEY_BITRATE));
                                zzcic.zzt = valueOf;
                                hashMap.put("bitRate", String.valueOf(valueOf));
                            }
                            if (format2.containsKey("width") && format2.containsKey("height")) {
                                hashMap.put("resolution", format2.getInteger("width") + "x" + format2.getInteger("height"));
                            }
                            if (format2.containsKey("mime")) {
                                hashMap.put("videoMime", format2.getString("mime"));
                            }
                            if (Build.VERSION.SDK_INT >= 30 && format2.containsKey("codecs-string")) {
                                hashMap.put("videoCodec", format2.getString("codecs-string"));
                            }
                        }
                    } else if (trackType == 2 && (format = trackInfo2.getFormat()) != null) {
                        if (format.containsKey("mime")) {
                            hashMap.put("audioMime", format.getString("mime"));
                        }
                        if (Build.VERSION.SDK_INT >= 30 && format.containsKey("codecs-string")) {
                            hashMap.put("audioCodec", format.getString("codecs-string"));
                        }
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                zzcic.zze.zzd("onMetadataEvent", hashMap);
            }
        }
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzn = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zze.zza("AdMediaPlayerView completion");
        zzE(5);
        this.zzi = 5;
        zzs.zza.post(new zzchv(this));
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) zzd.get(Integer.valueOf(i));
        String str2 = (String) zzd.get(Integer.valueOf(i2));
        zze.zzj("AdMediaPlayerView MediaPlayer error: " + str + ":" + str2);
        zzE(-1);
        this.zzi = -1;
        zzs.zza.post(new zzchw(this, str, str2));
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        zze.zza("AdMediaPlayerView MediaPlayer info: " + ((String) zzd.get(Integer.valueOf(i))) + ":" + ((String) zzd.get(Integer.valueOf(i2))));
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
        if (r1 > r6) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzl
            int r0 = getDefaultSize(r0, r6)
            int r1 = r5.zzm
            int r1 = getDefaultSize(r1, r7)
            int r2 = r5.zzl
            if (r2 <= 0) goto L_0x007e
            int r2 = r5.zzm
            if (r2 <= 0) goto L_0x007e
            com.google.android.gms.internal.ads.zzciw r2 = r5.zzo
            if (r2 != 0) goto L_0x007e
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x0043
            if (r1 != r2) goto L_0x0041
            int r0 = r5.zzl
            int r1 = r0 * r7
            int r2 = r5.zzm
            int r3 = r6 * r2
            if (r1 >= r3) goto L_0x003c
            int r0 = r1 / r2
        L_0x003a:
            r1 = r7
            goto L_0x007e
        L_0x003c:
            if (r1 <= r3) goto L_0x0063
            int r1 = r3 / r0
            goto L_0x0054
        L_0x0041:
            r0 = 1073741824(0x40000000, float:2.0)
        L_0x0043:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L_0x0056
            int r0 = r5.zzm
            int r0 = r0 * r6
            int r2 = r5.zzl
            int r0 = r0 / r2
            if (r1 != r3) goto L_0x0053
            if (r0 <= r7) goto L_0x0053
            goto L_0x0063
        L_0x0053:
            r1 = r0
        L_0x0054:
            r0 = r6
            goto L_0x007e
        L_0x0056:
            if (r1 != r2) goto L_0x0067
            int r1 = r5.zzl
            int r1 = r1 * r7
            int r2 = r5.zzm
            int r1 = r1 / r2
            if (r0 != r3) goto L_0x0065
            if (r1 <= r6) goto L_0x0065
        L_0x0063:
            r0 = r6
            goto L_0x003a
        L_0x0065:
            r0 = r1
            goto L_0x003a
        L_0x0067:
            int r2 = r5.zzl
            int r4 = r5.zzm
            if (r1 != r3) goto L_0x0073
            if (r4 <= r7) goto L_0x0073
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L_0x0075
        L_0x0073:
            r1 = r2
            r7 = r4
        L_0x0075:
            if (r0 != r3) goto L_0x0065
            if (r1 <= r6) goto L_0x0065
            int r4 = r4 * r6
            int r1 = r4 / r2
            goto L_0x0054
        L_0x007e:
            r5.setMeasuredDimension(r0, r1)
            com.google.android.gms.internal.ads.zzciw r6 = r5.zzo
            if (r6 == 0) goto L_0x0088
            r6.zzc(r0, r1)
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcic.onMeasure(int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005f A[LOOP:0: B:12:0x005f->B:17:0x007a, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPrepared(android.media.MediaPlayer r9) {
        /*
            r8 = this;
            java.lang.String r0 = "AdMediaPlayerView prepared"
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            r0 = 2
            r8.zzE(r0)
            com.google.android.gms.internal.ads.zzciz r0 = r8.zzf
            r0.zzb()
            com.google.android.gms.internal.ads.zzfpz r0 = com.google.android.gms.ads.internal.util.zzs.zza
            com.google.android.gms.internal.ads.zzchu r1 = new com.google.android.gms.internal.ads.zzchu
            r1.<init>(r8, r9)
            r0.post(r1)
            int r0 = r9.getVideoWidth()
            r8.zzl = r0
            int r9 = r9.getVideoHeight()
            r8.zzm = r9
            int r9 = r8.zzq
            if (r9 == 0) goto L_0x002b
            r8.zzq(r9)
        L_0x002b:
            boolean r9 = r8.zzg
            r0 = 3
            if (r9 != 0) goto L_0x0031
            goto L_0x0084
        L_0x0031:
            boolean r9 = r8.zzG()
            if (r9 == 0) goto L_0x0084
            android.media.MediaPlayer r9 = r8.zzj
            int r9 = r9.getCurrentPosition()
            if (r9 <= 0) goto L_0x0084
            int r9 = r8.zzi
            if (r9 == r0) goto L_0x0084
            java.lang.String r9 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.ads.internal.util.zze.zza(r9)
            r9 = 0
            r8.zzF(r9)
            android.media.MediaPlayer r9 = r8.zzj
            r9.start()
            android.media.MediaPlayer r9 = r8.zzj
            int r9 = r9.getCurrentPosition()
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzt.zzB()
            long r1 = r1.currentTimeMillis()
        L_0x005f:
            boolean r3 = r8.zzG()
            if (r3 == 0) goto L_0x007c
            android.media.MediaPlayer r3 = r8.zzj
            int r3 = r3.getCurrentPosition()
            if (r3 != r9) goto L_0x007c
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzt.zzB()
            long r3 = r3.currentTimeMillis()
            long r3 = r3 - r1
            r5 = 250(0xfa, double:1.235E-321)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x005f
        L_0x007c:
            android.media.MediaPlayer r9 = r8.zzj
            r9.pause()
            r8.zzn()
        L_0x0084:
            int r9 = r8.zzl
            int r1 = r8.zzm
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "AdMediaPlayerView stream dimensions: "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r9 = " x "
            r2.append(r9)
            r2.append(r1)
            java.lang.String r9 = r2.toString()
            com.google.android.gms.ads.internal.util.zze.zzi(r9)
            int r9 = r8.zzi
            if (r9 != r0) goto L_0x00ab
            r8.zzp()
        L_0x00ab:
            r8.zzn()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcic.onPrepared(android.media.MediaPlayer):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zze.zza("AdMediaPlayerView surface created");
        zzC();
        zzs.zza.post(new zzchx(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zze.zza("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null && this.zzq == 0) {
            this.zzq = mediaPlayer.getCurrentPosition();
        }
        zzciw zzciw = this.zzo;
        if (zzciw != null) {
            zzciw.zze();
        }
        zzs.zza.post(new zzchz(this));
        zzD(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zze.zza("AdMediaPlayerView surface changed");
        int i3 = this.zzi;
        boolean z = false;
        if (this.zzl == i && this.zzm == i2) {
            z = true;
        }
        if (this.zzj != null && i3 == 3 && z) {
            int i4 = this.zzq;
            if (i4 != 0) {
                zzq(i4);
            }
            zzp();
        }
        zzciw zzciw = this.zzo;
        if (zzciw != null) {
            zzciw.zzc(i, i2);
        }
        zzs.zza.post(new zzchy(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzf.zzf(this);
        this.zza.zza(surfaceTexture, this.zzr);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        zze.zza("AdMediaPlayerView size changed: " + i + " x " + i2);
        this.zzl = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.zzm = videoHeight;
        if (this.zzl != 0 && videoHeight != 0) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        zze.zza("AdMediaPlayerView window visibility changed to " + i);
        zzs.zza.post(new zzcht(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        return name + "@" + hexString;
    }

    public final int zza() {
        if (zzG()) {
            return this.zzj.getCurrentPosition();
        }
        return 0;
    }

    public final int zzb() {
        if (Build.VERSION.SDK_INT < 26 || !zzG()) {
            return -1;
        }
        return this.zzj.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    public final int zzc() {
        if (zzG()) {
            return this.zzj.getDuration();
        }
        return -1;
    }

    public final int zzd() {
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    public final int zze() {
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public final long zzf() {
        return 0;
    }

    public final long zzg() {
        if (this.zzt != null) {
            return (zzh() * ((long) this.zzn)) / 100;
        }
        return -1;
    }

    public final long zzh() {
        if (this.zzt != null) {
            return ((long) zzc()) * ((long) this.zzt.intValue());
        }
        return -1;
    }

    public final String zzj() {
        return "MediaPlayer".concat(true != this.zzp ? "" : " spherical");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(int i) {
        zzcid zzcid = this.zzr;
        if (zzcid != null) {
            zzcid.onWindowVisibilityChanged(i);
        }
    }

    public final void zzn() {
        zzF(this.zzb.zza());
    }

    public final void zzo() {
        zze.zza("AdMediaPlayerView pause");
        if (zzG() && this.zzj.isPlaying()) {
            this.zzj.pause();
            zzE(4);
            zzs.zza.post(new zzcib(this));
        }
        this.zzi = 4;
    }

    public final void zzp() {
        zze.zza("AdMediaPlayerView play");
        if (zzG()) {
            this.zzj.start();
            zzE(3);
            this.zza.zzb();
            zzs.zza.post(new zzcia(this));
        }
        this.zzi = 3;
    }

    public final void zzq(int i) {
        zze.zza("AdMediaPlayerView seek " + i);
        if (zzG()) {
            this.zzj.seekTo(i);
            this.zzq = 0;
            return;
        }
        this.zzq = i;
    }

    public final void zzr(zzcid zzcid) {
        this.zzr = zzcid;
    }

    public final void zzs(String str) {
        Uri parse = Uri.parse(str);
        zzbeb zza = zzbeb.zza(parse);
        if (zza == null || zza.zza != null) {
            if (zza != null) {
                parse = Uri.parse(zza.zza);
            }
            this.zzk = parse;
            this.zzq = 0;
            zzC();
            requestLayout();
            invalidate();
        }
    }

    public final void zzt() {
        zze.zza("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzj.release();
            this.zzj = null;
            zzE(0);
            this.zzi = 0;
        }
        this.zzf.zzd();
    }

    public final void zzu(float f, float f2) {
        zzciw zzciw = this.zzo;
        if (zzciw != null) {
            zzciw.zzf(f, f2);
        }
    }
}
