package com.google.android.gms.ads.identifier;

import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.internal.ads_identifier.zzi;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
public final class zzc {
    public static final void zza(String str) {
        HttpURLConnection httpURLConnection;
        try {
            zzi.zzb(263);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
                sb.append("Received non-success response code ");
                sb.append(responseCode);
                sb.append(" from pinging URL: ");
                sb.append(str);
                SystemUtils.log(5, "HttpUrlPinger", sb.toString(), (Throwable) null, "com.google.android.gms.ads.identifier.zzc", 6);
            }
            httpURLConnection.disconnect();
            zzi.zza();
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = e;
            String message = indexOutOfBoundsException.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message).length());
            sb2.append("Error while parsing ping URL: ");
            sb2.append(str);
            sb2.append(". ");
            sb2.append(message);
            SystemUtils.log(5, "HttpUrlPinger", sb2.toString(), indexOutOfBoundsException, "com.google.android.gms.ads.identifier.zzc", 11);
            zzi.zza();
        } catch (IOException | RuntimeException e2) {
            Exception exc = e2;
            try {
                String message2 = exc.getMessage();
                StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message2).length());
                sb3.append("Error while pinging URL: ");
                sb3.append(str);
                sb3.append(". ");
                sb3.append(message2);
                SystemUtils.log(5, "HttpUrlPinger", sb3.toString(), exc, "com.google.android.gms.ads.identifier.zzc", 9);
            } finally {
                zzi.zza();
            }
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
