package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.google.android.gms.ads.internal.util.zze;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzckk implements zzazv {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzazu zzf = new zzazu();
    private final zzbab zzg;
    private zzazo zzh;
    private HttpURLConnection zzi;
    private final Queue zzj;
    private InputStream zzk;
    private boolean zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private final long zzr;
    private final long zzs;

    zzckk(String str, zzbab zzbab, int i, int i2, long j, long j2) {
        zzbac.zzb(str);
        this.zze = str;
        this.zzg = zzbab;
        this.zzc = i;
        this.zzd = i2;
        this.zzj = new ArrayDeque();
        this.zzr = j;
        this.zzs = j2;
    }

    private final void zzg() {
        while (!this.zzj.isEmpty()) {
            try {
                ((HttpURLConnection) this.zzj.remove()).disconnect();
            } catch (Exception e) {
                zze.zzh("Unexpected error while disconnecting", e);
            }
        }
        this.zzi = null;
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzazs {
        int i3 = i2;
        if (i3 == 0) {
            return 0;
        }
        try {
            long j = this.zzm;
            long j2 = this.zzn;
            if (j - j2 == 0) {
                return -1;
            }
            long j3 = (long) i3;
            long j4 = this.zzs;
            long j5 = this.zzq;
            long j6 = j5 + 1;
            if (this.zzo + j2 + j3 + j4 > j6) {
                long j7 = this.zzp;
                if (j5 < j7) {
                    long min = Math.min(j7, Math.max(((this.zzr + j6) - j4) - 1, -1 + j6 + j3));
                    long j8 = j6;
                    long j9 = min;
                    zzf(j8, min, 2);
                    this.zzq = j9;
                    j5 = j9;
                }
            }
            int read = this.zzk.read(bArr, i, (int) Math.min(j3, ((j5 + 1) - this.zzo) - this.zzn));
            if (read != -1) {
                this.zzn += (long) read;
                zzbab zzbab = this.zzg;
                if (zzbab != null) {
                    ((zzckg) zzbab).zzW(this, read);
                }
                return read;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new zzazs(e, this.zzh, 2);
        }
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void zzd() throws zzazs {
        try {
            InputStream inputStream = this.zzk;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzk = null;
            zzg();
            if (this.zzl) {
                this.zzl = false;
            }
        } catch (IOException e) {
            throw new zzazs(e, this.zzh, 3);
        } catch (Throwable th) {
            this.zzk = null;
            zzg();
            if (this.zzl) {
                this.zzl = false;
            }
            throw th;
        }
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* access modifiers changed from: package-private */
    public final HttpURLConnection zzf(long j, long j2, int i) throws zzazs {
        String uri = this.zzh.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            httpURLConnection.setConnectTimeout(this.zzc);
            httpURLConnection.setReadTimeout(this.zzd);
            for (Map.Entry entry : this.zzf.zza().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + j + "-" + j2);
            httpURLConnection.setRequestProperty("User-Agent", this.zze);
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            this.zzj.add(httpURLConnection);
            String uri2 = this.zzh.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map headerFields = httpURLConnection.getHeaderFields();
                    zzg();
                    throw new zzckj(responseCode, headerFields, this.zzh, i);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzk != null) {
                        inputStream = new SequenceInputStream(this.zzk, inputStream);
                    }
                    this.zzk = inputStream;
                    return httpURLConnection;
                } catch (IOException e) {
                    zzg();
                    throw new zzazs(e, this.zzh, i);
                }
            } catch (IOException e2) {
                zzg();
                throw new zzazs("Unable to connect to ".concat(String.valueOf(uri2)), e2, this.zzh, i);
            }
        } catch (IOException e3) {
            throw new zzazs("Unable to connect to ".concat(String.valueOf(uri)), e3, this.zzh, i);
        }
    }

    public final long zzb(zzazo zzazo) throws zzazs {
        long j;
        this.zzh = zzazo;
        this.zzn = 0;
        long j2 = zzazo.zzc;
        long j3 = zzazo.zzd;
        if (j3 == -1) {
            j = this.zzr;
        } else {
            j = Math.min(this.zzr, j3);
        }
        this.zzo = j2;
        HttpURLConnection zzf2 = zzf(j2, (j + j2) - 1, 1);
        this.zzi = zzf2;
        String headerField = zzf2.getHeaderField(HttpHeaders.CONTENT_RANGE);
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zzb.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long parseLong = Long.parseLong(matcher.group(2));
                    long parseLong2 = Long.parseLong(matcher.group(3));
                    long j4 = zzazo.zzd;
                    if (j4 != -1) {
                        this.zzm = j4;
                        this.zzp = Math.max(parseLong, (this.zzo + j4) - 1);
                    } else {
                        this.zzm = parseLong2 - this.zzo;
                        this.zzp = parseLong2 - 1;
                    }
                    this.zzq = parseLong;
                    this.zzl = true;
                    zzbab zzbab = this.zzg;
                    if (zzbab != null) {
                        ((zzckg) zzbab).zzk(this, zzazo);
                    }
                    return this.zzm;
                } catch (NumberFormatException unused) {
                    zze.zzg("Unexpected Content-Range [" + headerField + Const.jaRight);
                }
            }
        }
        throw new zzcki(headerField, zzazo);
    }
}
