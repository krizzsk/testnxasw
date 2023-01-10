package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzecp {
    private final zzcom zza;
    private final Context zzb;
    private final zzcgv zzc;
    private final zzfef zzd;
    private final Executor zze;
    private final String zzf;
    private final zzfju zzg;
    private final zzfer zzh;
    private final zzdxl zzi;

    public zzecp(zzcom zzcom, Context context, zzcgv zzcgv, zzfef zzfef, Executor executor, String str, zzfju zzfju, zzdxl zzdxl) {
        this.zza = zzcom;
        this.zzb = context;
        this.zzc = zzcgv;
        this.zzd = zzfef;
        this.zze = executor;
        this.zzf = str;
        this.zzg = zzfju;
        this.zzh = zzcom.zzv();
        this.zzi = zzdxl;
    }

    private final zzfzp zzc(String str, String str2) {
        zzfjj zza2 = zzfji.zza(this.zzb, 11);
        zza2.zzf();
        zzfzp zzn = zzfzg.zzn(zzfzg.zzn(zzfzg.zzn(zzfzg.zzi(""), new zzecm(this, str, str2), this.zze), new zzecn(zzt.zzf().zza(this.zzb, this.zzc, this.zza.zzy()).zza("google.afma.response.normalize", zzbuh.zza, zzbuh.zza)), this.zze), new zzeco(this), this.zze);
        zzfjt.zza(zzn, this.zzg, zza2);
        return zzn;
    }

    private final String zzd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && "unknown".equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzf));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            zze.zzj("Failed to update the ad types for rendering. ".concat(e.toString()));
            return str;
        }
    }

    private static final String zze(String str) {
        try {
            return new JSONObject(str).optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, "");
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzfzp zza() {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzfef r0 = r10.zzd
            com.google.android.gms.ads.internal.client.zzl r0 = r0.zzd
            java.lang.String r0 = r0.zzx
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "true"
            if (r1 != 0) goto L_0x011d
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzga
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r3.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x011d
            java.lang.String r1 = zze(r0)
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzgn
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = -1
            if (r3 == 0) goto L_0x004f
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L_0x004f
            java.lang.String r1 = "&request_id="
            int r1 = r0.lastIndexOf(r1)
            if (r1 == r4) goto L_0x004d
            int r1 = r1 + 12
            java.lang.String r1 = r0.substring(r1)
            goto L_0x004f
        L_0x004d:
            java.lang.String r1 = ""
        L_0x004f:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L_0x0063
            com.google.android.gms.internal.ads.zzekr r0 = new com.google.android.gms.internal.ads.zzekr
            r1 = 15
            java.lang.String r2 = "Invalid ad string."
            r0.<init>(r1, r2)
            com.google.android.gms.internal.ads.zzfzp r0 = com.google.android.gms.internal.ads.zzfzg.zzh(r0)
            return r0
        L_0x0063:
            com.google.android.gms.internal.ads.zzcom r3 = r10.zza
            com.google.android.gms.ads.nonagon.signalgeneration.zzc r3 = r3.zzm()
            com.google.android.gms.internal.ads.zzdxl r5 = r10.zzi
            java.lang.String r3 = r3.zzb(r1, r5)
            com.google.android.gms.internal.ads.zzbiu r5 = com.google.android.gms.internal.ads.zzbjc.zzgn
            com.google.android.gms.internal.ads.zzbja r6 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r5 = r6.zzb(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x010d
            com.google.android.gms.internal.ads.zzdxl r5 = r10.zzi
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            if (r6 != 0) goto L_0x010d
            r6 = 0
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00a1 }
            r7.<init>(r3)     // Catch:{ JSONException -> 0x00a1 }
            java.lang.String r8 = "is_gbid"
            java.lang.String r7 = r7.optString(r8)     // Catch:{ JSONException -> 0x00a1 }
            boolean r7 = r7.equals(r2)     // Catch:{ JSONException -> 0x00a1 }
            if (r7 == 0) goto L_0x00a1
            r7 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ JSONException -> 0x00a1 }
            goto L_0x00a5
        L_0x00a1:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
        L_0x00a5:
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x00ac
            goto L_0x010d
        L_0x00ac:
            java.lang.String r7 = "&"
            int r7 = r0.lastIndexOf(r7)
            r8 = 0
            if (r7 == r4) goto L_0x00ba
            java.lang.String r4 = r0.substring(r6, r7)
            goto L_0x00bb
        L_0x00ba:
            r4 = r8
        L_0x00bb:
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L_0x00c2
            goto L_0x010d
        L_0x00c2:
            r6 = 11
            byte[] r4 = android.util.Base64.decode(r4, r6)     // Catch:{ UnsupportedEncodingException -> 0x00f6 }
            java.lang.String r6 = "UTF-8"
            byte[] r1 = r1.getBytes(r6)     // Catch:{ UnsupportedEncodingException -> 0x00f6 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00da }
            r6.<init>(r3)     // Catch:{ JSONException -> 0x00da }
            java.lang.String r7 = "arek"
            java.lang.String r8 = r6.getString(r7)     // Catch:{ JSONException -> 0x00da }
            goto L_0x00f1
        L_0x00da:
            r6 = move-exception
            java.lang.String r7 = "Failed to get key from QueryJSONMap"
            java.lang.String r9 = r6.toString()     // Catch:{ UnsupportedEncodingException -> 0x00f6 }
            java.lang.String r7 = r7.concat(r9)     // Catch:{ UnsupportedEncodingException -> 0x00f6 }
            com.google.android.gms.ads.internal.util.zze.zza(r7)     // Catch:{ UnsupportedEncodingException -> 0x00f6 }
            com.google.android.gms.internal.ads.zzcfy r7 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ UnsupportedEncodingException -> 0x00f6 }
            java.lang.String r9 = "CryptoUtils.getKeyFromQueryJsonMap"
            r7.zzt(r6, r9)     // Catch:{ UnsupportedEncodingException -> 0x00f6 }
        L_0x00f1:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfer.zzb(r4, r1, r8, r5)     // Catch:{ UnsupportedEncodingException -> 0x00f6 }
            goto L_0x010d
        L_0x00f6:
            r1 = move-exception
            java.lang.String r4 = r1.toString()
            java.lang.String r5 = "Failed to decode the adResponse. "
            java.lang.String r4 = r5.concat(r4)
            com.google.android.gms.ads.internal.util.zze.zza(r4)
            com.google.android.gms.internal.ads.zzcfy r4 = com.google.android.gms.ads.internal.zzt.zzo()
            java.lang.String r5 = "PreloadedLoader.decryptAdResponseIfNecessary"
            r4.zzt(r1, r5)
        L_0x010d:
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L_0x0114
            goto L_0x011d
        L_0x0114:
            java.lang.String r1 = r10.zzd(r3)
            com.google.android.gms.internal.ads.zzfzp r0 = r10.zzc(r0, r1)
            return r0
        L_0x011d:
            com.google.android.gms.internal.ads.zzfef r0 = r10.zzd
            com.google.android.gms.ads.internal.client.zzl r0 = r0.zzd
            com.google.android.gms.ads.internal.client.zzc r0 = r0.zzs
            if (r0 == 0) goto L_0x017e
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzfY
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r3.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0138
            goto L_0x0165
        L_0x0138:
            java.lang.String r1 = r0.zza
            java.lang.String r1 = zze(r1)
            java.lang.String r3 = r0.zzb
            java.lang.String r3 = zze(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0172
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0172
            com.google.android.gms.internal.ads.zzcom r2 = r10.zza
            com.google.android.gms.ads.nonagon.signalgeneration.zzc r2 = r2.zzm()
            r2.zzf(r1)
            com.google.android.gms.internal.ads.zzdxl r2 = r10.zzi
            java.util.Map r2 = r2.zza()
            java.lang.String r3 = "rid"
            r2.put(r3, r1)
        L_0x0165:
            java.lang.String r1 = r0.zza
            java.lang.String r0 = r0.zzb
            java.lang.String r0 = r10.zzd(r0)
            com.google.android.gms.internal.ads.zzfzp r0 = r10.zzc(r1, r0)
            return r0
        L_0x0172:
            com.google.android.gms.internal.ads.zzdxl r0 = r10.zzi
            java.util.Map r0 = r0.zza()
            java.lang.String r1 = "ridmm"
            r0.put(r1, r2)
        L_0x017e:
            com.google.android.gms.internal.ads.zzekr r0 = new com.google.android.gms.internal.ads.zzekr
            r1 = 14
            java.lang.String r2 = "Mismatch request IDs."
            r0.<init>(r1, r2)
            com.google.android.gms.internal.ads.zzfzp r0 = com.google.android.gms.internal.ads.zzfzg.zzh(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzecp.zza():com.google.android.gms.internal.ads.zzfzp");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzb(JSONObject jSONObject) throws Exception {
        return zzfzg.zzi(new zzfdw(new zzfdt(this.zzd), zzfdv.zza(new StringReader(jSONObject.toString()))));
    }
}
