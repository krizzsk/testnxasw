package com.koushikdutta.async.http;

import android.net.Uri;
import com.datadog.android.core.internal.net.DataOkHttpUploader;
import com.didi.sdk.apm.SystemUtils;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncSSLException;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.util.Locale;

public class AsyncHttpRequest {
    public static final int DEFAULT_TIMEOUT = 30000;
    public static final String HEADER_ACCEPT_ALL = "*/*";

    /* renamed from: h */
    static final /* synthetic */ boolean f58114h = (!AsyncHttpRequest.class.desiredAssertionStatus());

    /* renamed from: a */
    Uri f58115a;

    /* renamed from: b */
    int f58116b;

    /* renamed from: c */
    String f58117c;

    /* renamed from: d */
    int f58118d;

    /* renamed from: e */
    String f58119e;

    /* renamed from: f */
    int f58120f;

    /* renamed from: g */
    long f58121g;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f58122i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f58123j;

    /* renamed from: k */
    private Headers f58124k;

    /* renamed from: l */
    private boolean f58125l;

    /* renamed from: m */
    private AsyncHttpRequestBody f58126m;

    public boolean hasBody() {
        return true;
    }

    public void onHandshakeException(AsyncSSLException asyncSSLException) {
    }

    public RequestLine getRequestLine() {
        return new RequestLine() {
            public String getUri() {
                return AsyncHttpRequest.this.getUri().toString();
            }

            public ProtocolVersion getProtocolVersion() {
                return new ProtocolVersion("HTTP", 1, 1);
            }

            public String getMethod() {
                return AsyncHttpRequest.this.f58123j;
            }

            public String toString() {
                if (AsyncHttpRequest.this.f58117c != null) {
                    return String.format(Locale.ENGLISH, "%s %s %s", new Object[]{AsyncHttpRequest.this.f58123j, AsyncHttpRequest.this.getUri(), AsyncHttpRequest.this.f58122i});
                }
                String path = AsyncHttpRequest.this.getPath();
                if (path == null || path.length() == 0) {
                    path = "/";
                }
                String encodedQuery = AsyncHttpRequest.this.getUri().getEncodedQuery();
                if (!(encodedQuery == null || encodedQuery.length() == 0)) {
                    path = path + "?" + encodedQuery;
                }
                return String.format(Locale.ENGLISH, "%s %s %s", new Object[]{AsyncHttpRequest.this.f58123j, path, AsyncHttpRequest.this.f58122i});
            }
        };
    }

    public String getPath() {
        return getUri().getEncodedPath();
    }

    protected static String getDefaultUserAgent() {
        String property = System.getProperty(DataOkHttpUploader.SYSTEM_UA);
        if (property != null) {
            return property;
        }
        return "Java" + System.getProperty("java.version");
    }

    public String getMethod() {
        return this.f58123j;
    }

    public void setRequestLineProtocol(String str) {
        this.f58122i = str;
    }

    public String getRequestLineProtocol() {
        return this.f58122i;
    }

    public AsyncHttpRequest setMethod(String str) {
        if (getClass() == AsyncHttpRequest.class) {
            this.f58123j = str;
            return this;
        }
        throw new UnsupportedOperationException("can't change method on a subclass of AsyncHttpRequest");
    }

    public AsyncHttpRequest(Uri uri, String str) {
        this(uri, str, (Headers) null);
    }

    public static void setDefaultHeaders(Headers headers, Uri uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (uri.getPort() != -1) {
                host = host + ":" + uri.getPort();
            }
            if (host != null) {
                headers.set(HttpHeaders.HOST, host);
            }
        }
        headers.set("User-Agent", getDefaultUserAgent());
        headers.set(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
        headers.set(HttpHeaders.CONNECTION, "keep-alive");
        headers.set(HttpHeaders.ACCEPT, HEADER_ACCEPT_ALL);
    }

    public AsyncHttpRequest(Uri uri, String str, Headers headers) {
        this.f58122i = "HTTP/1.1";
        this.f58124k = new Headers();
        this.f58125l = true;
        this.f58116b = 30000;
        this.f58118d = -1;
        if (f58114h || uri != null) {
            this.f58123j = str;
            this.f58115a = uri;
            if (headers == null) {
                this.f58124k = new Headers();
            } else {
                this.f58124k = headers;
            }
            if (headers == null) {
                setDefaultHeaders(this.f58124k, uri);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public Uri getUri() {
        return this.f58115a;
    }

    public Headers getHeaders() {
        return this.f58124k;
    }

    public boolean getFollowRedirect() {
        return this.f58125l;
    }

    public AsyncHttpRequest setFollowRedirect(boolean z) {
        this.f58125l = z;
        return this;
    }

    public void setBody(AsyncHttpRequestBody asyncHttpRequestBody) {
        this.f58126m = asyncHttpRequestBody;
    }

    public AsyncHttpRequestBody getBody() {
        return this.f58126m;
    }

    public int getTimeout() {
        return this.f58116b;
    }

    public AsyncHttpRequest setTimeout(int i) {
        this.f58116b = i;
        return this;
    }

    public AsyncHttpRequest setHeader(String str, String str2) {
        getHeaders().set(str, str2);
        return this;
    }

    public AsyncHttpRequest addHeader(String str, String str2) {
        getHeaders().add(str, str2);
        return this;
    }

    public void enableProxy(String str, int i) {
        this.f58117c = str;
        this.f58118d = i;
    }

    public void disableProxy() {
        this.f58117c = null;
        this.f58118d = -1;
    }

    public String getProxyHost() {
        return this.f58117c;
    }

    public int getProxyPort() {
        return this.f58118d;
    }

    public String toString() {
        Headers headers = this.f58124k;
        if (headers == null) {
            return super.toString();
        }
        return headers.toPrefixString(this.f58115a.toString());
    }

    public void setLogging(String str, int i) {
        this.f58119e = str;
        this.f58120f = i;
    }

    public int getLogLevel() {
        return this.f58120f;
    }

    public String getLogTag() {
        return this.f58119e;
    }

    /* renamed from: a */
    private String m44035a(String str) {
        long j = 0;
        if (this.f58121g != 0) {
            j = System.currentTimeMillis() - this.f58121g;
        }
        return String.format(Locale.ENGLISH, "(%d ms) %s: %s", new Object[]{Long.valueOf(j), getUri(), str});
    }

    public void logi(String str) {
        String str2 = this.f58119e;
        if (str2 != null && this.f58120f <= 4) {
            SystemUtils.log(4, str2, m44035a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 218);
        }
    }

    public void logv(String str) {
        String str2 = this.f58119e;
        if (str2 != null && this.f58120f <= 2) {
            SystemUtils.log(2, str2, m44035a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 225);
        }
    }

    public void logw(String str) {
        String str2 = this.f58119e;
        if (str2 != null && this.f58120f <= 5) {
            SystemUtils.log(5, str2, m44035a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 232);
        }
    }

    public void logd(String str) {
        String str2 = this.f58119e;
        if (str2 != null && this.f58120f <= 3) {
            SystemUtils.log(3, str2, m44035a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 239);
        }
    }

    public void logd(String str, Exception exc) {
        String str2 = this.f58119e;
        if (str2 != null && this.f58120f <= 3) {
            SystemUtils.log(3, str2, m44035a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 246);
            SystemUtils.log(3, this.f58119e, exc.getMessage(), exc, "com.koushikdutta.async.http.AsyncHttpRequest", 247);
        }
    }

    public void loge(String str) {
        String str2 = this.f58119e;
        if (str2 != null && this.f58120f <= 6) {
            SystemUtils.log(6, str2, m44035a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 254);
        }
    }

    public void loge(String str, Exception exc) {
        String str2 = this.f58119e;
        if (str2 != null && this.f58120f <= 6) {
            SystemUtils.log(6, str2, m44035a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 261);
            SystemUtils.log(6, this.f58119e, exc.getMessage(), exc, "com.koushikdutta.async.http.AsyncHttpRequest", 262);
        }
    }
}
