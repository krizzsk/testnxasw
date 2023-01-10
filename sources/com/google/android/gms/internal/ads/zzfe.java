package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfe implements zzex {
    private final Context zza;
    private final List zzb = new ArrayList();
    private final zzex zzc;
    private zzex zzd;
    private zzex zze;
    private zzex zzf;
    private zzex zzg;
    private zzex zzh;
    private zzex zzi;
    private zzex zzj;
    private zzex zzk;

    public zzfe(Context context, zzex zzex) {
        this.zza = context.getApplicationContext();
        this.zzc = zzex;
    }

    private final zzex zzg() {
        if (this.zze == null) {
            zzeq zzeq = new zzeq(this.zza);
            this.zze = zzeq;
            zzh(zzeq);
        }
        return this.zze;
    }

    private final void zzh(zzex zzex) {
        for (int i = 0; i < this.zzb.size(); i++) {
            zzex.zzf((zzfz) this.zzb.get(i));
        }
    }

    private static final void zzi(zzex zzex, zzfz zzfz) {
        if (zzex != null) {
            zzex.zzf(zzfz);
        }
    }

    public final long zzb(zzfc zzfc) throws IOException {
        zzex zzex;
        zzdd.zzf(this.zzk == null);
        String scheme = zzfc.zza.getScheme();
        if (zzen.zzW(zzfc.zza)) {
            String path = zzfc.zza.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    zzfn zzfn = new zzfn();
                    this.zzd = zzfn;
                    zzh(zzfn);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzg();
            }
        } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
            this.zzk = zzg();
        } else if ("content".equals(scheme)) {
            if (this.zzf == null) {
                zzeu zzeu = new zzeu(this.zza);
                this.zzf = zzeu;
                zzh(zzeu);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    zzex zzex2 = (zzex) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.zzg = zzex2;
                    zzh(zzex2);
                } catch (ClassNotFoundException unused) {
                    zzdw.zze("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                zzgb zzgb = new zzgb(2000);
                this.zzh = zzgb;
                zzh(zzgb);
            }
            this.zzk = this.zzh;
        } else if ("data".equals(scheme)) {
            if (this.zzi == null) {
                zzev zzev = new zzev();
                this.zzi = zzev;
                zzh(zzev);
            }
            this.zzk = this.zzi;
        } else {
            if ("rawresource".equals(scheme) || UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
                if (this.zzj == null) {
                    zzfx zzfx = new zzfx(this.zza);
                    this.zzj = zzfx;
                    zzh(zzfx);
                }
                zzex = this.zzj;
            } else {
                zzex = this.zzc;
            }
            this.zzk = zzex;
        }
        return this.zzk.zzb(zzfc);
    }

    public final Uri zzc() {
        zzex zzex = this.zzk;
        if (zzex == null) {
            return null;
        }
        return zzex.zzc();
    }

    public final void zzd() throws IOException {
        zzex zzex = this.zzk;
        if (zzex != null) {
            try {
                zzex.zzd();
            } finally {
                this.zzk = null;
            }
        }
    }

    public final Map zze() {
        zzex zzex = this.zzk;
        return zzex == null ? Collections.emptyMap() : zzex.zze();
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        zzex zzex = this.zzk;
        if (zzex != null) {
            return zzex.zza(bArr, i, i2);
        }
        throw null;
    }

    public final void zzf(zzfz zzfz) {
        if (zzfz != null) {
            this.zzc.zzf(zzfz);
            this.zzb.add(zzfz);
            zzi(this.zzd, zzfz);
            zzi(this.zze, zzfz);
            zzi(this.zzf, zzfz);
            zzi(this.zzg, zzfz);
            zzi(this.zzh, zzfz);
            zzi(this.zzi, zzfz);
            zzi(this.zzj, zzfz);
            return;
        }
        throw null;
    }
}
