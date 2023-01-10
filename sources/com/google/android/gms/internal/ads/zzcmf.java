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
final class zzcmf extends zzer implements zzfu {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzft zzf = new zzft();
    private zzfc zzg;
    private HttpURLConnection zzh;
    private final Queue zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private final long zzr;
    private final long zzs;

    zzcmf(String str, zzfz zzfz, int i, int i2, long j, long j2) {
        super(true);
        zzdd.zzc(str);
        this.zze = str;
        this.zzc = i;
        this.zzd = i2;
        this.zzi = new ArrayDeque();
        this.zzr = j;
        this.zzs = j2;
        if (zzfz != null) {
            zzf(zzfz);
        }
    }

    private final void zzl() {
        while (!this.zzi.isEmpty()) {
            try {
                ((HttpURLConnection) this.zzi.remove()).disconnect();
            } catch (Exception e) {
                zze.zzh("Unexpected error while disconnecting", e);
            }
        }
        this.zzh = null;
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzfq {
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
                    zzk(j8, min, 2);
                    this.zzq = j9;
                    j5 = j9;
                }
            }
            int read = this.zzj.read(bArr, i, (int) Math.min(j3, ((j5 + 1) - this.zzo) - this.zzn));
            if (read != -1) {
                this.zzn += (long) read;
                zzg(read);
                return read;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new zzfq(e, this.zzg, 2000, 2);
        }
    }

    public final long zzb(zzfc zzfc) throws zzfq {
        long j;
        this.zzg = zzfc;
        this.zzn = 0;
        long j2 = zzfc.zzf;
        long j3 = zzfc.zzg;
        if (j3 == -1) {
            j = this.zzr;
        } else {
            j = Math.min(this.zzr, j3);
        }
        this.zzo = j2;
        HttpURLConnection zzk2 = zzk(j2, (j + j2) - 1, 1);
        this.zzh = zzk2;
        String headerField = zzk2.getHeaderField(HttpHeaders.CONTENT_RANGE);
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zzb.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long parseLong = Long.parseLong(matcher.group(2));
                    long parseLong2 = Long.parseLong(matcher.group(3));
                    long j4 = zzfc.zzg;
                    if (j4 != -1) {
                        this.zzm = j4;
                        this.zzp = Math.max(parseLong, (this.zzo + j4) - 1);
                    } else {
                        this.zzm = parseLong2 - this.zzo;
                        this.zzp = parseLong2 - 1;
                    }
                    this.zzq = parseLong;
                    this.zzk = true;
                    zzj(zzfc);
                    return this.zzm;
                } catch (NumberFormatException unused) {
                    zze.zzg("Unexpected Content-Range [" + headerField + Const.jaRight);
                }
            }
        }
        throw new zzcmd(headerField, zzfc);
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void zzd() throws zzfq {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzj = null;
            zzl();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
        } catch (IOException e) {
            throw new zzfq(e, this.zzg, 2000, 3);
        } catch (Throwable th) {
            this.zzj = null;
            zzl();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            throw th;
        }
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* access modifiers changed from: package-private */
    public final HttpURLConnection zzk(long j, long j2, int i) throws zzfq {
        String uri = this.zzg.zza.toString();
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
            this.zzi.add(httpURLConnection);
            String uri2 = this.zzg.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzl = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    Map headerFields = httpURLConnection.getHeaderFields();
                    zzl();
                    throw new zzcme(this.zzl, headerFields, this.zzg, i);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzj != null) {
                        inputStream = new SequenceInputStream(this.zzj, inputStream);
                    }
                    this.zzj = inputStream;
                    return httpURLConnection;
                } catch (IOException e) {
                    zzl();
                    throw new zzfq(e, this.zzg, 2000, i);
                }
            } catch (IOException e2) {
                zzl();
                throw new zzfq("Unable to connect to ".concat(String.valueOf(uri2)), e2, this.zzg, 2000, i);
            }
        } catch (IOException e3) {
            throw new zzfq("Unable to connect to ".concat(String.valueOf(uri)), e3, this.zzg, 2000, i);
        }
    }
}
