package com.google.android.gms.internal.ads;

import com.didi.soda.blocks.constant.Const;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzclc implements zzbpu {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            zze.zzj("Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str)));
            return null;
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzclb zzclb;
        zzckt zzckt;
        Map map2 = map;
        zzciy zzciy = (zzciy) obj;
        if (zze.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map2);
            jSONObject.remove("google.afma.Notify_dt");
            zze.zze("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzcku zzy = zzt.zzy();
        if (!map2.containsKey("abort")) {
            String str = (String) map2.get(Const.BlockParamConst.SRC);
            Integer zzb = zzb(map2, "periodicReportIntervalMs");
            Integer zzb2 = zzb(map2, "exoPlayerRenderingIntervalMs");
            Integer zzb3 = zzb(map2, "exoPlayerIdleIntervalMs");
            zzcix zzcix = new zzcix((String) map2.get("flags"));
            boolean z = zzcix.zzn;
            if (str != null) {
                String[] strArr = {str};
                String str2 = (String) map2.get("demuxed");
                if (str2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            strArr2[i] = jSONArray.getString(i);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused) {
                        zze.zzj("Malformed demuxed URL list for precache: ".concat(str2));
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str};
                }
                if (z) {
                    Iterator it = zzy.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzckt = null;
                            break;
                        }
                        zzckt zzckt2 = (zzckt) it.next();
                        if (zzckt2.zza == zzciy && str.equals(zzckt2.zze())) {
                            zzckt = zzckt2;
                            break;
                        }
                    }
                } else {
                    zzckt = zzy.zza(zzciy);
                }
                if (zzckt != null) {
                    zze.zzj("Precache task is already running.");
                    return;
                } else if (zzciy.zzm() == null) {
                    zze.zzj("Precache requires a dependency provider.");
                    return;
                } else {
                    Integer zzb4 = zzb(map2, "player");
                    if (zzb4 == null) {
                        zzb4 = 0;
                    }
                    if (zzb != null) {
                        zzciy.zzC(zzb.intValue());
                    }
                    if (zzb2 != null) {
                        zzciy.zzA(zzb2.intValue());
                    }
                    if (zzb3 != null) {
                        zzciy.zzz(zzb3.intValue());
                    }
                    int intValue = zzb4.intValue();
                    zzckn zzckn = zzciy.zzm().zzb;
                    if (intValue > 0) {
                        int zzu = zzcip.zzu();
                        if (zzu < zzcix.zzh) {
                            zzclb = new zzclk(zzciy, zzcix);
                        } else if (zzu < zzcix.zzb) {
                            zzclb = new zzclh(zzciy, zzcix);
                        } else {
                            zzclb = new zzclf(zzciy);
                        }
                    } else {
                        zzclb = new zzcle(zzciy);
                    }
                    new zzckt(zzciy, zzclb, str, strArr).zzb();
                }
            } else {
                zzckt zza = zzy.zza(zzciy);
                if (zza != null) {
                    zzclb = zza.zzb;
                } else {
                    zze.zzj("Precache must specify a source.");
                    return;
                }
            }
            Integer zzb5 = zzb(map2, "minBufferMs");
            if (zzb5 != null) {
                zzclb.zzp(zzb5.intValue());
            }
            Integer zzb6 = zzb(map2, "maxBufferMs");
            if (zzb6 != null) {
                zzclb.zzo(zzb6.intValue());
            }
            Integer zzb7 = zzb(map2, "bufferForPlaybackMs");
            if (zzb7 != null) {
                zzclb.zzh(zzb7.intValue());
            }
            Integer zzb8 = zzb(map2, "bufferForPlaybackAfterRebufferMs");
            if (zzb8 != null) {
                zzclb.zzn(zzb8.intValue());
            }
        } else if (!zzy.zzd(zzciy)) {
            zze.zzj("Precache abort but no precache task running.");
        }
    }
}
