package com.didiglobal.privacy.domainmonitor.urlconnection;

import com.didiglobal.privacy.domainmonitor.interceptor.NetworkParamsDispatcher;
import com.didiglobal.privacy.domainmonitor.model.NetworkParam;
import com.didiglobal.privacy.domainmonitor.urlconnection.FlowInputStream;
import com.didiglobal.privacy.domainmonitor.urlconnection.FlowOutputStream;
import com.didiglobal.privacy.domainmonitor.utils.UrlUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

public class MonitorHttpURLConnection extends HttpURLConnection {

    /* renamed from: e */
    private static final String f53076e = "MonitorHttpURLCon";

    /* renamed from: a */
    private final HttpURLConnection f53077a;

    /* renamed from: b */
    private NetworkParam f53078b;

    /* renamed from: c */
    private FlowOutputStream f53079c;

    /* renamed from: d */
    private FlowInputStream f53080d;

    protected MonitorHttpURLConnection(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        NetworkParam networkParam = new NetworkParam();
        this.f53078b = networkParam;
        this.f53077a = httpURLConnection;
        networkParam.setUrl(UrlUtil.getAbsoluteUrl((HttpURLConnection) this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo129838a(IOException iOException) {
        this.f53078b.appendErrorMessage(iOException.getLocalizedMessage());
    }

    public void disconnect() {
        this.f53077a.disconnect();
    }

    public boolean usingProxy() {
        return this.f53077a.usingProxy();
    }

    public void connect() throws IOException {
        try {
            this.f53077a.connect();
        } catch (IOException e) {
            mo129838a(e);
            throw e;
        }
    }

    public String getHeaderFieldKey(int i) {
        return this.f53077a.getHeaderFieldKey(i);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.f53077a.setFixedLengthStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(long j) {
        this.f53077a.setFixedLengthStreamingMode(j);
    }

    public void setChunkedStreamingMode(int i) {
        this.f53077a.setChunkedStreamingMode(i);
    }

    public String getHeaderField(int i) {
        return this.f53077a.getHeaderField(i);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f53077a.setInstanceFollowRedirects(z);
    }

    public boolean getInstanceFollowRedirects() {
        return this.f53077a.getInstanceFollowRedirects();
    }

    public void setRequestMethod(String str) throws ProtocolException {
        try {
            this.f53077a.setRequestMethod(str);
        } catch (ProtocolException e) {
            mo129838a((IOException) e);
            throw e;
        }
    }

    public String getRequestMethod() {
        return this.f53077a.getRequestMethod();
    }

    public int getResponseCode() throws IOException {
        try {
            int responseCode = this.f53077a.getResponseCode();
            this.f53078b.setStatusCode(responseCode);
            return responseCode;
        } catch (IOException e) {
            mo129838a(e);
            throw e;
        }
    }

    public String getResponseMessage() throws IOException {
        try {
            return this.f53077a.getResponseMessage();
        } catch (IOException e) {
            mo129838a(e);
            throw e;
        }
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.f53077a.getHeaderFieldDate(str, j);
    }

    public Permission getPermission() throws IOException {
        try {
            return this.f53077a.getPermission();
        } catch (IOException e) {
            mo129838a(e);
            throw e;
        }
    }

    public InputStream getErrorStream() {
        return this.f53077a.getErrorStream();
    }

    public void setConnectTimeout(int i) {
        this.f53077a.setConnectTimeout(i);
    }

    public int getConnectTimeout() {
        return this.f53077a.getConnectTimeout();
    }

    public void setReadTimeout(int i) {
        this.f53077a.setReadTimeout(i);
    }

    public int getReadTimeout() {
        return this.f53077a.getReadTimeout();
    }

    public URL getURL() {
        return this.f53077a.getURL();
    }

    public int getContentLength() {
        return this.f53077a.getContentLength();
    }

    public long getContentLengthLong() {
        return this.f53077a.getContentLengthLong();
    }

    public String getContentType() {
        return this.f53077a.getContentType();
    }

    public String getContentEncoding() {
        return this.f53077a.getContentEncoding();
    }

    public long getExpiration() {
        return this.f53077a.getExpiration();
    }

    public long getDate() {
        return this.f53077a.getDate();
    }

    public long getLastModified() {
        return this.f53077a.getLastModified();
    }

    public String getHeaderField(String str) {
        return this.f53077a.getHeaderField(str);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.f53077a.getHeaderFields();
    }

    public int getHeaderFieldInt(String str, int i) {
        return this.f53077a.getHeaderFieldInt(str, i);
    }

    public long getHeaderFieldLong(String str, long j) {
        return this.f53077a.getHeaderFieldLong(str, j);
    }

    public Object getContent() throws IOException {
        try {
            return this.f53077a.getContent();
        } catch (IOException e) {
            mo129838a(e);
            throw e;
        }
    }

    public Object getContent(Class[] clsArr) throws IOException {
        try {
            return this.f53077a.getContent(clsArr);
        } catch (IOException e) {
            mo129838a(e);
            throw e;
        }
    }

    public OutputStream getOutputStream() throws IOException {
        try {
            if (this.f53079c == null) {
                this.f53079c = new FlowOutputStream(this.f53077a.getOutputStream(), (FlowOutputStream.OutputStreamStatusListener) null);
            }
            return this.f53079c;
        } catch (IOException e) {
            mo129838a(e);
            throw e;
        }
    }

    public InputStream getInputStream() throws IOException {
        try {
            if (this.f53080d == null) {
                this.f53080d = new FlowInputStream(this.f53077a.getInputStream(), new FlowInputStream.InputStreamStatusListener() {
                    public final void onReadFinished(long j) {
                        MonitorHttpURLConnection.this.m39745a(j);
                    }
                });
            }
            return this.f53080d;
        } catch (IOException e) {
            mo129838a(e);
            throw e;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39745a(long j) {
        FlowOutputStream flowOutputStream = this.f53079c;
        if (flowOutputStream != null) {
            this.f53078b.setUploadByteCount(flowOutputStream.getUploadByteCountAndClear());
        }
        this.f53078b.setDownloadByteCount(j);
        NetworkParamsDispatcher.onRequestFinished(this.f53078b);
        this.f53078b = new NetworkParam();
    }

    public String toString() {
        return this.f53077a.toString();
    }

    public void setDoInput(boolean z) {
        this.f53077a.setDoInput(z);
    }

    public boolean getDoInput() {
        return this.f53077a.getDoInput();
    }

    public void setDoOutput(boolean z) {
        this.f53077a.setDoOutput(z);
    }

    public boolean getDoOutput() {
        return this.f53077a.getDoOutput();
    }

    public void setAllowUserInteraction(boolean z) {
        this.f53077a.setAllowUserInteraction(z);
    }

    public boolean getAllowUserInteraction() {
        return this.f53077a.getAllowUserInteraction();
    }

    public void setUseCaches(boolean z) {
        this.f53077a.setUseCaches(z);
    }

    public boolean getUseCaches() {
        return this.f53077a.getUseCaches();
    }

    public void setIfModifiedSince(long j) {
        this.f53077a.setIfModifiedSince(j);
    }

    public long getIfModifiedSince() {
        return this.f53077a.getIfModifiedSince();
    }

    public boolean getDefaultUseCaches() {
        return this.f53077a.getDefaultUseCaches();
    }

    public void setDefaultUseCaches(boolean z) {
        this.f53077a.setDefaultUseCaches(z);
    }

    public void setRequestProperty(String str, String str2) {
        this.f53077a.setRequestProperty(str, str2);
    }

    public void addRequestProperty(String str, String str2) {
        this.f53077a.addRequestProperty(str, str2);
    }

    public String getRequestProperty(String str) {
        return this.f53077a.getRequestProperty(str);
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.f53077a.getRequestProperties();
    }

    public int hashCode() {
        return this.f53077a.hashCode();
    }

    public boolean equals(Object obj) {
        return this.f53077a.equals(obj);
    }
}
