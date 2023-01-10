package com.didi.app.nova.skeleton.image.glide.internal;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.didi.sdk.apm.SystemUtils;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class SodaUrlFetcher implements DataFetcher<InputStream> {

    /* renamed from: a */
    private static final String f10307a = "SodaUrlFetcher";

    /* renamed from: b */
    private static final int f10308b = 5;

    /* renamed from: c */
    private static final HttpUrlConnectionFactory f10309c = new DefaultHttpUrlConnectionFactory();

    /* renamed from: d */
    private final SodaUrl f10310d;

    /* renamed from: e */
    private final HttpUrlConnectionFactory f10311e;

    /* renamed from: f */
    private HttpURLConnection f10312f;

    /* renamed from: g */
    private InputStream f10313g;

    /* renamed from: h */
    private volatile boolean f10314h;

    interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL url) throws IOException;
    }

    public SodaUrlFetcher(SodaUrl sodaUrl) {
        this(sodaUrl, f10309c);
    }

    SodaUrlFetcher(SodaUrl sodaUrl, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.f10310d = sodaUrl;
        this.f10311e = httpUrlConnectionFactory;
    }

    /* renamed from: a */
    static URL m9064a(SodaUrl sodaUrl, boolean z) throws MalformedURLException {
        StringBuilder sb = new StringBuilder(sodaUrl.getSourceUrl().toStringUrl());
        sb.append(".webp");
        if (z && sodaUrl.getFitSize() != null) {
            sb.append("!");
            sb.append(sodaUrl.getFitSize().width());
            sb.append("x");
            sb.append(sodaUrl.getFitSize().height());
            sb.append("_m");
        }
        return new URL(sb.toString());
    }

    /* renamed from: a */
    private InputStream m9063a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        PrintStream printStream = System.out;
        printStream.println("loadDataWithRedirects " + url);
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new IOException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f10312f = this.f10311e.build(url);
            for (Map.Entry next : map.entrySet()) {
                this.f10312f.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            this.f10312f.setConnectTimeout(2500);
            this.f10312f.setReadTimeout(2500);
            int i2 = 0;
            this.f10312f.setUseCaches(false);
            this.f10312f.setDoInput(true);
            this.f10312f.connect();
            if (this.f10314h) {
                return null;
            }
            int responseCode = this.f10312f.getResponseCode();
            int i3 = responseCode / 100;
            if (i3 == 2) {
                try {
                    i2 = Integer.parseInt(this.f10312f.getHeaderField(HttpHeaders.CONTENT_LENGTH));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                if (i2 != 0) {
                    return m9062a(this.f10312f);
                }
                throw new IOException("Content-Length is zero.");
            } else if (i3 == 3) {
                String headerField = this.f10312f.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    return m9063a(new URL(url, headerField), i + 1, url, map);
                }
                throw new IOException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
            } else {
                throw new IOException("Request failed " + responseCode + ": " + this.f10312f.getResponseMessage());
            }
        } else {
            throw new IOException("Too many (> 5) redirects!");
        }
    }

    /* renamed from: a */
    private InputStream m9062a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f10313g = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(f10307a, 3)) {
                SystemUtils.log(3, f10307a, "Got non empty content encoding: " + httpURLConnection.getContentEncoding(), (Throwable) null, "com.didi.app.nova.skeleton.image.glide.internal.SodaUrlFetcher", 127);
            }
            this.f10313g = httpURLConnection.getInputStream();
        }
        return this.f10313g;
    }

    public void loadData(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        InputStream inputStream;
        try {
            inputStream = m9063a(m9064a(this.f10310d, true), 0, (URL) null, this.f10310d.getResizeUrl().getHeaders());
        } catch (IOException e) {
            e.printStackTrace();
            inputStream = null;
        }
        if (inputStream == null && !this.f10314h) {
            try {
                inputStream = m9063a(this.f10310d.getResizeUrl().toURL(), 0, (URL) null, this.f10310d.getResizeUrl().getHeaders());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        if (inputStream == null && !this.f10314h) {
            try {
                inputStream = m9063a(m9064a(this.f10310d, false), 0, (URL) null, this.f10310d.getSourceUrl().getHeaders());
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        if (inputStream == null && !this.f10314h) {
            try {
                inputStream = m9063a(this.f10310d.getSourceUrl().toURL(), 0, (URL) null, this.f10310d.getSourceUrl().getHeaders());
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        dataCallback.onDataReady(inputStream);
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public void cleanup() {
        InputStream inputStream = this.f10313g;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f10312f;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public void cancel() {
        this.f10314h = true;
    }

    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        private DefaultHttpUrlConnectionFactory() {
        }

        public HttpURLConnection build(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }
}
