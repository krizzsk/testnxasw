package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector;

import com.didichuxing.mas.sdk.quality.collect.cdnmonitor.ping.PingExecutor;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class CdnDetector {

    /* renamed from: a */
    private static SSLSocketFactory f50330a;

    /* renamed from: b */
    private String f50331b;

    /* renamed from: c */
    private String f50332c;

    public CdnDetector(String str, String str2) {
        this.f50331b = str;
        this.f50332c = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (r1 == null) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003a, code lost:
        if (r1 != null) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.CdnDetectionResult detect() {
        /*
            r7 = this;
            com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.CdnDetectionResult r0 = new com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.CdnDetectionResult
            java.lang.String r1 = r7.f50331b
            r0.<init>(r1)
            r0.fetchEnvironmentParameters()
            r1 = 0
            java.lang.String r2 = r7.f50331b     // Catch:{ all -> 0x003d }
            java.net.HttpURLConnection r1 = r7.m37638b(r2)     // Catch:{ all -> 0x003d }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003d }
            int r4 = r1.getResponseCode()     // Catch:{ all -> 0x003d }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003d }
            long r5 = r5 - r2
            int r2 = (int) r5     // Catch:{ all -> 0x003d }
            int r3 = r1.getContentLength()     // Catch:{ all -> 0x003d }
            int r4 = r4 + 2000
            if (r2 <= 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r2 = 0
        L_0x0029:
            java.util.Map r5 = r1.getHeaderFields()     // Catch:{ all -> 0x003d }
            r0.addDetectionResult(r4, r2, r5, r3)     // Catch:{ all -> 0x003d }
            byte[] r2 = r7.m37637a((java.net.HttpURLConnection) r1)     // Catch:{ all -> 0x003d }
            r7.mo124347a(r0, r2)     // Catch:{ all -> 0x003d }
            r7.m37636a((com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.CdnDetectionResult) r0)
            if (r1 == 0) goto L_0x004d
            goto L_0x004a
        L_0x003d:
            r2 = move-exception
            int r2 = com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.HttpDetectErrCode.praseException(r2)     // Catch:{ all -> 0x004e }
            r0.setDetectErrCode(r2)     // Catch:{ all -> 0x004e }
            r7.m37636a((com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.CdnDetectionResult) r0)
            if (r1 == 0) goto L_0x004d
        L_0x004a:
            r1.disconnect()
        L_0x004d:
            return r0
        L_0x004e:
            r2 = move-exception
            r7.m37636a((com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.CdnDetectionResult) r0)
            if (r1 == 0) goto L_0x0057
            r1.disconnect()
        L_0x0057:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.CdnDetector.detect():com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.CdnDetectionResult");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo124347a(CdnDetectionResult cdnDetectionResult, byte[] bArr) {
        String a = mo124346a(bArr);
        cdnDetectionResult.setDownFileMd5(a);
        if (a != null && !a.equals(this.f50332c)) {
            cdnDetectionResult.setDetectErrCode(1008);
        }
    }

    /* renamed from: b */
    private HttpURLConnection m37638b(String str) throws Throwable {
        HttpURLConnection httpURLConnection;
        Exception e;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                if (httpURLConnection instanceof HttpsURLConnection) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                    if (f50330a != null) {
                        httpsURLConnection.setSSLSocketFactory(f50330a);
                    }
                }
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
            } catch (Exception e2) {
                e = e2;
                OLog.m37867w("setupConnection fail " + e.getCause());
                return httpURLConnection;
            }
        } catch (Exception e3) {
            Exception exc = e3;
            httpURLConnection = null;
            e = exc;
            OLog.m37867w("setupConnection fail " + e.getCause());
            return httpURLConnection;
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private void m37636a(CdnDetectionResult cdnDetectionResult) {
        cdnDetectionResult.setPingInfo(new PingExecutor(mo124345a(this.f50331b)).execute());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo124345a(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception unused) {
            OLog.m37861e("getUrlHost Error");
            return "";
        }
    }

    /* renamed from: a */
    private byte[] m37637a(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo124346a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            String str = "";
            for (byte b : instance.digest()) {
                str = str + Integer.toString((b & 255) + 256, 16).substring(1);
            }
            return str;
        } catch (Exception | NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
