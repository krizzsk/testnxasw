package com.didi.dimina.webview.resource;

import android.os.Looper;
import android.text.TextUtils;
import com.didi.dimina.webview.FusionEngine;
import com.didi.dimina.webview.util.FileUtil;
import com.didi.dimina.webview.util.HttpUtil;
import com.didi.soda.web.config.WebConstant;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class FusionHttpClient {
    public static final int CONNECT_CODE_ERROR_IOE = -102;
    public static final int CONNECT_CODE_ERROR_MUE = -101;
    public static final int CONNECT_CODE_ERROR_STE = -103;
    public static final int CONNECT_CODE_ERROR_UNKNOW = -100;
    public static final int CONNECT_CODE_SUCCESS = 0;

    /* renamed from: a */
    private static final int f20205a = 5000;

    /* renamed from: b */
    private static final int f20206b = 10000;

    /* renamed from: c */
    private final String f20207c;

    /* renamed from: d */
    private Map<String, String> f20208d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public HttpURLConnection f20209e;

    /* renamed from: f */
    private BufferedInputStream f20210f;

    public FusionHttpClient(String str) {
        this.f20207c = str;
        this.f20208d = new HashMap(1);
    }

    public FusionHttpClient(String str, Map<String, String> map) {
        this.f20207c = str;
        this.f20208d = map;
        if (map == null) {
            this.f20208d = new HashMap(1);
        }
    }

    public String getRequestUrl() {
        return this.f20207c;
    }

    public Map<String, String> getRequestHeader() {
        return this.f20208d;
    }

    public String executeGetRequest() {
        String str = "";
        if (m17060a(false) == 0) {
            BufferedInputStream bufferedInputStream = null;
            try {
                if (getResponseCode() == 200 && (bufferedInputStream = getResponseStream()) != null) {
                    str = HttpUtil.streamToString(bufferedInputStream);
                }
            } finally {
                FileUtil.closeQuietly(bufferedInputStream);
                disconnect();
            }
        }
        return str;
    }

    public boolean executeDownload(File file) {
        BufferedInputStream responseStream;
        boolean z = false;
        if (file == null) {
            return false;
        }
        try {
            if (m17060a(false) == 0 && getResponseCode() == 200 && (responseStream = getResponseStream()) != null) {
                if (!file.exists()) {
                    file.createNewFile();
                }
                file.createNewFile();
                z = FileUtil.writeInputStreamToOutputStream(responseStream, new FileOutputStream(file));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            disconnect();
            throw th;
        }
        disconnect();
        return z;
    }

    public int connect() {
        return m17060a(true);
    }

    /* renamed from: a */
    private int m17060a(boolean z) {
        try {
            URLConnection openConnection = new URL(this.f20207c).openConnection();
            if (!(openConnection instanceof HttpURLConnection)) {
                return -100;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            this.f20209e = httpURLConnection;
            httpURLConnection.setConnectTimeout(5000);
            int i = 10000;
            Object attr = FusionEngine.getAttr(WebConstant.READ_TIMEOUT);
            if (attr != null && (attr instanceof Integer)) {
                i = ((Integer) attr).intValue();
            }
            this.f20209e.setReadTimeout(i);
            this.f20209e.setInstanceFollowRedirects(true);
            if (this.f20208d != null && !this.f20208d.isEmpty()) {
                for (Map.Entry next : this.f20208d.entrySet()) {
                    this.f20209e.setRequestProperty((String) next.getKey(), (String) next.getValue());
                }
            }
            if (z) {
                String cookie = FusionCacheClient.sInstance.getCookie(this.f20207c);
                if (!TextUtils.isEmpty(cookie)) {
                    this.f20209e.setRequestProperty(HttpHeaders.COOKIE, cookie);
                }
            }
            this.f20209e.connect();
            return 0;
        } catch (MalformedURLException unused) {
            return -101;
        } catch (IOException e) {
            if (e instanceof SocketTimeoutException) {
                return -103;
            }
            e.printStackTrace();
            return -102;
        }
    }

    public int getResponseCode() {
        try {
            return this.f20209e.getResponseCode();
        } catch (IOException e) {
            return e instanceof SocketTimeoutException ? -103 : -102;
        }
    }

    public boolean isNotModified(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return false;
        }
        int responseCode = getResponseCode();
        if (responseCode == 304) {
            return true;
        }
        if (responseCode != 200) {
            return false;
        }
        String headerValue = getHeaderValue(HttpHeaders.ETAG);
        if (!TextUtils.isEmpty(headerValue) && headerValue.equals(map.get("if-none-match"))) {
            return true;
        }
        String headerValue2 = getHeaderValue(HttpHeaders.LAST_MODIFIED);
        if (TextUtils.isEmpty(headerValue2) || !headerValue2.equals(map.get("if-modified-since"))) {
            return false;
        }
        return true;
    }

    public String getHeaderValue(String str) {
        return this.f20209e.getHeaderField(str);
    }

    public Map<String, List<String>> getResponseHeader() {
        return this.f20209e.getHeaderFields();
    }

    public BufferedInputStream getResponseStream() {
        HttpURLConnection httpURLConnection = this.f20209e;
        if (httpURLConnection != null && this.f20210f == null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if ("gzip".equalsIgnoreCase(this.f20209e.getContentEncoding())) {
                    this.f20210f = new BufferedInputStream(new GZIPInputStream(inputStream));
                } else {
                    this.f20210f = new BufferedInputStream(inputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.f20210f;
    }

    public void disconnect() {
        if (this.f20209e == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                public void run() {
                    FusionHttpClient.this.f20209e.disconnect();
                }
            });
        } else {
            this.f20209e.disconnect();
        }
    }
}
