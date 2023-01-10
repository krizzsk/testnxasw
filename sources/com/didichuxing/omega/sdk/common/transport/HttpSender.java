package com.didichuxing.omega.sdk.common.transport;

import android.net.TrafficStats;
import android.os.Build;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.utils.OLog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class HttpSender {
    private static String omegaUserAgent = ("Omega/" + OmegaConfig.SDK_VERSION + " (android, " + OmegaConfig.CUSTOM_APP_NAME + ")");

    public static String post(String str, String str2, Map<String, String> map, String str3) throws IOException {
        return post(str, str2.getBytes("UTF-8"), map, str3);
    }

    public static String post(String str, String str2, Map<String, String> map) throws IOException {
        return post(str, str2.getBytes("UTF-8"), map, (String) null);
    }

    public static String post(String str, byte[] bArr, Map<String, String> map, String str2) throws IOException {
        int i = 0;
        while (true) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                String post = post(str, (InputStream) byteArrayInputStream, map, bArr.length > 1048576);
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    OLog.m38207e("HttpSender post", e);
                }
                return post;
            } catch (FileDisableException e2) {
                throw e2;
            } catch (IOException e3) {
                int i2 = i + 1;
                if (i >= OmegaConfig.HTTP_SENDER_RETRY_TIMES) {
                    if (str2 != null && !str2.equals("")) {
                        Tracker.trackCounter(str2);
                    }
                    throw e3;
                }
                try {
                    byteArrayInputStream.close();
                } catch (IOException e4) {
                    OLog.m38207e("HttpSender post", e4);
                }
                i = i2;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e5) {
                    OLog.m38207e("HttpSender post", e5);
                }
                throw th;
            }
        }
    }

    public static String post(String str, InputStream inputStream, Map<String, String> map, boolean z, int i) throws IOException {
        int i2 = 0;
        while (true) {
            try {
                return post(str, inputStream, map, z);
            } catch (FileDisableException e) {
                throw e;
            } catch (Throwable th) {
                int i3 = i2 + 1;
                if (i2 < i) {
                    i2 = i3;
                } else {
                    throw th;
                }
            }
        }
    }

    public static String post(String str, InputStream inputStream, Map<String, String> map) throws IOException {
        return post(str, inputStream, map, false);
    }

    public static String post(String str, InputStream inputStream, Map<String, String> map, boolean z) throws IOException {
        long nanoTime = System.nanoTime();
        String doPost = doPost(str, inputStream, map, z);
        long nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
        return doPost;
    }

    private static String doPost(String str, InputStream inputStream, Map<String, String> map, boolean z) throws IOException {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(1);
        }
        HttpURLConnection openAndSend = openAndSend(str, "POST", inputStream, map, z);
        int responseCode = openAndSend.getResponseCode();
        if (596 == responseCode) {
            FileDisableException fileDisableException = new FileDisableException("596 Exception, drop it!!");
            fileDisableException.setType(2);
            throw fileDisableException;
        } else if (500 <= responseCode) {
            String str2 = "url:" + str + " response code:" + openAndSend.getResponseCode() + ".";
            openAndSend.disconnect();
            throw new IOException(str2);
        } else if (responseCode != 413) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openAndSend.getInputStream(), "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
            openAndSend.disconnect();
            bufferedReader.close();
            if (Build.VERSION.SDK_INT >= 14) {
                TrafficStats.clearThreadStatsTag();
            }
            return sb.toString();
        } else {
            FileDisableException fileDisableException2 = new FileDisableException("File too large, drop it!!");
            fileDisableException2.setType(1);
            throw fileDisableException2;
        }
    }

    public static HttpResponse get(String str, Map<String, String> map) throws IOException {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(1);
        }
        HttpURLConnection openAndSend = openAndSend(str, "GET", (InputStream) null, map, false);
        if (200 == openAndSend.getResponseCode()) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openAndSend.getInputStream(), "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
            openAndSend.disconnect();
            bufferedReader.close();
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.setBody(sb.toString());
            httpResponse.setHeaders(openAndSend.getHeaderFields());
            if (Build.VERSION.SDK_INT >= 14) {
                TrafficStats.clearThreadStatsTag();
            }
            return httpResponse;
        }
        String str2 = "url:" + str + " response code:" + openAndSend.getResponseCode() + ".";
        openAndSend.disconnect();
        throw new IOException(str2);
    }

    private static HttpURLConnection openAndSend(String str, String str2, InputStream inputStream, Map<String, String> map, boolean z) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        if ("POST".equals(str2) || "PUT".equals(str2)) {
            httpURLConnection.setDoOutput(true);
        }
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setRequestProperty("User-Agent", omegaUserAgent);
        httpURLConnection.setRequestProperty("appname", OmegaConfig.CUSTOM_APP_NAME);
        if (z) {
            httpURLConnection.setChunkedStreamingMode(8192);
        }
        if (map != null) {
            for (String next : map.keySet()) {
                String str3 = map.get(next);
                if (str3 != null) {
                    httpURLConnection.setRequestProperty(next, str3);
                }
            }
        }
        if (inputStream != null) {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            outputStream.flush();
            outputStream.close();
        }
        return httpURLConnection;
    }

    public static String httpGet(String str) {
        return httpGet(str, (Map<String, String>) null);
    }

    public static String httpPost(String str, String str2) {
        return httpPost(str, str2, (Map<String, String>) null);
    }

    public static String httpPost(String str, Map<String, Object> map) {
        return httpPost(str, getParams(map), (Map<String, String>) null);
    }

    public static String httpPost(String str, Map<String, Object> map, Map<String, String> map2) {
        StringBuilder sb = new StringBuilder();
        for (String next : map.keySet()) {
            if (sb.length() == 0) {
                sb.append(next);
                sb.append("=");
                sb.append(map.get(next));
            } else {
                sb.append(ParamKeys.SIGN_AND);
                sb.append(next);
                sb.append("=");
                sb.append(map.get(next));
            }
        }
        return httpPost(str, sb.toString(), map2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r6v3, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.OutputStreamWriter] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c0 A[SYNTHETIC, Splitter:B:50:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ca A[SYNTHETIC, Splitter:B:55:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d4 A[DONT_GENERATE] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String httpPost(java.lang.String r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00f3 }
            r1.<init>(r6)     // Catch:{ MalformedURLException -> 0x00f3 }
            int r6 = android.os.Build.VERSION.SDK_INT
            r2 = 1
            r3 = 14
            if (r6 < r3) goto L_0x0010
            android.net.TrafficStats.setThreadStatsTag(r2)
        L_0x0010:
            java.net.URLConnection r6 = r1.openConnection()     // Catch:{ all -> 0x00b3 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ all -> 0x00b3 }
            r6.setDoOutput(r2)     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = "POST"
            r6.setRequestMethod(r1)     // Catch:{ all -> 0x00b0 }
            r1 = 10000(0x2710, float:1.4013E-41)
            r6.setConnectTimeout(r1)     // Catch:{ all -> 0x00b0 }
            r6.setReadTimeout(r1)     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = "User-Agent"
            java.lang.String r2 = omegaUserAgent     // Catch:{ all -> 0x00b0 }
            r6.setRequestProperty(r1, r2)     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = "appname"
            java.lang.String r2 = com.didichuxing.omega.sdk.common.OmegaConfig.CUSTOM_APP_NAME     // Catch:{ all -> 0x00b0 }
            r6.setRequestProperty(r1, r2)     // Catch:{ all -> 0x00b0 }
            if (r8 == 0) goto L_0x0054
            java.util.Set r1 = r8.keySet()     // Catch:{ all -> 0x00b0 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00b0 }
        L_0x003e:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x0054
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00b0 }
            java.lang.Object r4 = r8.get(r2)     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00b0 }
            r6.setRequestProperty(r2, r4)     // Catch:{ all -> 0x00b0 }
            goto L_0x003e
        L_0x0054:
            java.io.OutputStreamWriter r8 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00b0 }
            java.io.OutputStream r1 = r6.getOutputStream()     // Catch:{ all -> 0x00b0 }
            r8.<init>(r1)     // Catch:{ all -> 0x00b0 }
            r8.write(r7)     // Catch:{ all -> 0x00ac }
            r8.flush()     // Catch:{ all -> 0x00ac }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ all -> 0x00ac }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x00ac }
            java.io.InputStream r2 = r6.getInputStream()     // Catch:{ all -> 0x00ac }
            r1.<init>(r2)     // Catch:{ all -> 0x00ac }
            r7.<init>(r1)     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r1.<init>()     // Catch:{ all -> 0x00a6 }
        L_0x0076:
            java.lang.String r2 = r7.readLine()     // Catch:{ all -> 0x00a6 }
            if (r2 == 0) goto L_0x0085
            r1.append(r2)     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = "\n"
            r1.append(r2)     // Catch:{ all -> 0x00a6 }
            goto L_0x0076
        L_0x0085:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00a6 }
            if (r2 < r3) goto L_0x008c
            android.net.TrafficStats.clearThreadStatsTag()     // Catch:{ all -> 0x00a6 }
        L_0x008c:
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00a6 }
            r8.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x0098
        L_0x0094:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0098:
            r7.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00a0:
            if (r6 == 0) goto L_0x00a5
            r6.disconnect()
        L_0x00a5:
            return r0
        L_0x00a6:
            r1 = move-exception
            r5 = r8
            r8 = r7
            r7 = r1
            r1 = r5
            goto L_0x00b7
        L_0x00ac:
            r7 = move-exception
            r1 = r8
            r8 = r0
            goto L_0x00b7
        L_0x00b0:
            r7 = move-exception
            r8 = r0
            goto L_0x00b6
        L_0x00b3:
            r7 = move-exception
            r6 = r0
            r8 = r6
        L_0x00b6:
            r1 = r8
        L_0x00b7:
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00d8 }
            com.didichuxing.omega.sdk.common.utils.OLog.m38206e(r7)     // Catch:{ all -> 0x00d8 }
            if (r1 == 0) goto L_0x00c8
            r1.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00c8
        L_0x00c4:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00c8:
            if (r8 == 0) goto L_0x00d2
            r8.close()     // Catch:{ IOException -> 0x00ce }
            goto L_0x00d2
        L_0x00ce:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00d2:
            if (r6 == 0) goto L_0x00d7
            r6.disconnect()
        L_0x00d7:
            return r0
        L_0x00d8:
            r7 = move-exception
            if (r1 == 0) goto L_0x00e3
            r1.close()     // Catch:{ IOException -> 0x00df }
            goto L_0x00e3
        L_0x00df:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00e3:
            if (r8 == 0) goto L_0x00ed
            r8.close()     // Catch:{ IOException -> 0x00e9 }
            goto L_0x00ed
        L_0x00e9:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00ed:
            if (r6 == 0) goto L_0x00f2
            r6.disconnect()
        L_0x00f2:
            throw r7
        L_0x00f3:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "url err:"
            r8.append(r1)
            java.lang.String r7 = r7.toString()
            r8.append(r7)
            java.lang.String r7 = " url:"
            r8.append(r7)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            com.didichuxing.omega.sdk.common.utils.OLog.m38206e(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.transport.HttpSender.httpPost(java.lang.String, java.lang.String, java.util.Map):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x009e A[SYNTHETIC, Splitter:B:46:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0 A[SYNTHETIC, Splitter:B:56:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String httpGet(java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00be }
            r1.<init>(r6)     // Catch:{ MalformedURLException -> 0x00be }
            int r6 = android.os.Build.VERSION.SDK_INT
            r2 = 1
            r3 = 14
            if (r6 < r3) goto L_0x0010
            android.net.TrafficStats.setThreadStatsTag(r2)
        L_0x0010:
            java.net.URLConnection r6 = r1.openConnection()     // Catch:{ IOException -> 0x0096, all -> 0x0093 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ IOException -> 0x0096, all -> 0x0093 }
            r6.setDoOutput(r2)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.lang.String r1 = "GET"
            r6.setRequestMethod(r1)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            r1 = 10000(0x2710, float:1.4013E-41)
            r6.setConnectTimeout(r1)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            r6.setReadTimeout(r1)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            if (r7 == 0) goto L_0x0046
            java.util.Set r1 = r7.keySet()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
        L_0x0030:
            boolean r2 = r1.hasNext()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            if (r2 == 0) goto L_0x0046
            java.lang.Object r2 = r1.next()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.lang.Object r4 = r7.get(r2)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            r6.setRequestProperty(r2, r4)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            goto L_0x0030
        L_0x0046:
            r6.connect()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.io.InputStream r2 = r6.getInputStream()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            r7.<init>(r1)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
            r1.<init>()     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
        L_0x005c:
            java.lang.String r2 = r7.readLine()     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
            if (r2 == 0) goto L_0x006b
            r1.append(r2)     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
            java.lang.String r2 = "\n"
            r1.append(r2)     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
            goto L_0x005c
        L_0x006b:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
            if (r2 < r3) goto L_0x0072
            android.net.TrafficStats.clearThreadStatsTag()     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
        L_0x0072:
            java.lang.String r0 = r1.toString()     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
            r7.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r7 = move-exception
            r7.printStackTrace()
        L_0x007e:
            if (r6 == 0) goto L_0x0083
            r6.disconnect()
        L_0x0083:
            return r0
        L_0x0084:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
            goto L_0x00ae
        L_0x0089:
            r1 = move-exception
            r5 = r1
            r1 = r7
            r7 = r5
            goto L_0x0099
        L_0x008e:
            r7 = move-exception
            goto L_0x00ae
        L_0x0090:
            r7 = move-exception
            r1 = r0
            goto L_0x0099
        L_0x0093:
            r7 = move-exception
            r6 = r0
            goto L_0x00ae
        L_0x0096:
            r7 = move-exception
            r6 = r0
            r1 = r6
        L_0x0099:
            r7.printStackTrace()     // Catch:{ all -> 0x00ac }
            if (r1 == 0) goto L_0x00a6
            r1.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00a6
        L_0x00a2:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00a6:
            if (r6 == 0) goto L_0x00ab
            r6.disconnect()
        L_0x00ab:
            return r0
        L_0x00ac:
            r7 = move-exception
            r0 = r1
        L_0x00ae:
            if (r0 == 0) goto L_0x00b8
            r0.close()     // Catch:{ IOException -> 0x00b4 }
            goto L_0x00b8
        L_0x00b4:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b8:
            if (r6 == 0) goto L_0x00bd
            r6.disconnect()
        L_0x00bd:
            throw r7
        L_0x00be:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.transport.HttpSender.httpGet(java.lang.String, java.util.Map):java.lang.String");
    }

    private static String getParams(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        synchronized (map) {
            boolean z = true;
            for (String next : map.keySet()) {
                try {
                    String encode = URLEncoder.encode(map.get(next).toString(), "UTF-8");
                    if (z) {
                        sb.append(next);
                        sb.append("=");
                        sb.append(encode);
                        z = false;
                    } else {
                        sb.append(ParamKeys.SIGN_AND);
                        sb.append(next);
                        sb.append("=");
                        sb.append(encode);
                    }
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
        return sb.toString();
    }
}
