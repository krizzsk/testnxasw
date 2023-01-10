package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.Agent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.Measurements;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.TaskQueue;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.TransactionState;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingInputStream;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingOutputStream;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteEvent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteListener;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.mas.sdk.quality.collect.ditest.assistant.EnvSwitchManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public class HttpsURLConnectionExtension extends HttpsURLConnection {

    /* renamed from: c */
    private static final AgentLog f50510c = AgentLogManager.getAgentLog();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public HttpsURLConnection f50511a;

    /* renamed from: b */
    private TransactionState f50512b;

    public HttpsURLConnectionExtension(HttpsURLConnection httpsURLConnection) {
        super(httpsURLConnection.getURL());
        if (!Agent.isEnvSwitchEnable()) {
            this.f50511a = httpsURLConnection;
        } else {
            this.f50511a = EnvSwitchManager.getInstance().replaceHttpsURLConnection(httpsURLConnection);
        }
    }

    public String getCipherSuite() {
        return this.f50511a.getCipherSuite();
    }

    public Certificate[] getLocalCertificates() {
        return this.f50511a.getLocalCertificates();
    }

    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        try {
            return this.f50511a.getServerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            m37683a((Exception) e);
            throw e;
        }
    }

    public void addRequestProperty(String str, String str2) {
        if (!(str == null || str2 == null)) {
            m37684b();
            try {
                String requestProperty = this.f50511a.getRequestProperty(str);
                int length = str2.length() + 1;
                if (requestProperty == null) {
                    length += str.length() + 2;
                }
                this.f50512b.setBytesHeaderSent(this.f50512b.getBytesHeaderSent() + ((long) length));
                if (TransactionStateUtil.isTraceIdHeader(str)) {
                    this.f50512b.setTraceId(str2);
                }
            } catch (IllegalStateException e) {
                f50510c.error("http url connection already connected when set Request Property");
                throw e;
            }
        }
        this.f50511a.addRequestProperty(str, str2);
    }

    public void disconnect() {
        TransactionState transactionState = this.f50512b;
        if (transactionState != null && !transactionState.isComplete()) {
            m37682a(this.f50512b);
        }
        this.f50511a.disconnect();
    }

    public boolean usingProxy() {
        return this.f50511a.usingProxy();
    }

    public void connect() throws IOException {
        m37684b();
        try {
            this.f50511a.connect();
        } catch (IOException e) {
            m37683a((Exception) e);
            throw e;
        }
    }

    public boolean getAllowUserInteraction() {
        return this.f50511a.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.f50511a.getConnectTimeout();
    }

    public Object getContent() throws IOException {
        m37684b();
        try {
            Object content = this.f50511a.getContent();
            int contentLength = this.f50511a.getContentLength();
            if (contentLength >= 0) {
                TransactionState b = m37684b();
                if (!b.isComplete()) {
                    b.setBytesReceived((long) contentLength);
                    m37682a(b);
                }
            }
            return content;
        } catch (IOException e) {
            m37683a((Exception) e);
            throw e;
        }
    }

    public Object getContent(Class[] clsArr) throws IOException {
        m37684b();
        try {
            Object content = this.f50511a.getContent(clsArr);
            m37679a();
            return content;
        } catch (IOException e) {
            m37683a((Exception) e);
            throw e;
        }
    }

    public String getContentEncoding() {
        m37684b();
        String contentEncoding = this.f50511a.getContentEncoding();
        m37679a();
        return contentEncoding;
    }

    public int getContentLength() {
        m37684b();
        int contentLength = this.f50511a.getContentLength();
        m37679a();
        return contentLength;
    }

    public String getContentType() {
        m37684b();
        String contentType = this.f50511a.getContentType();
        m37679a();
        return contentType;
    }

    public long getDate() {
        m37684b();
        long date = this.f50511a.getDate();
        m37679a();
        return date;
    }

    public InputStream getErrorStream() {
        m37684b();
        try {
            return new CountingInputStream(this.f50511a.getErrorStream(), true);
        } catch (Exception e) {
            f50510c.error(e.toString());
            return this.f50511a.getErrorStream();
        }
    }

    public long getHeaderFieldDate(String str, long j) {
        m37684b();
        long headerFieldDate = this.f50511a.getHeaderFieldDate(str, j);
        m37679a();
        return headerFieldDate;
    }

    public boolean getInstanceFollowRedirects() {
        return this.f50511a.getInstanceFollowRedirects();
    }

    public Permission getPermission() throws IOException {
        return this.f50511a.getPermission();
    }

    public String getRequestMethod() {
        return this.f50511a.getRequestMethod();
    }

    public int getResponseCode() throws IOException {
        m37684b();
        try {
            int responseCode = this.f50511a.getResponseCode();
            m37679a();
            return responseCode;
        } catch (IOException e) {
            m37683a((Exception) e);
            throw e;
        }
    }

    public String getResponseMessage() throws IOException {
        m37684b();
        try {
            String responseMessage = this.f50511a.getResponseMessage();
            m37679a();
            return responseMessage;
        } catch (IOException e) {
            m37683a((Exception) e);
            throw e;
        }
    }

    public void setChunkedStreamingMode(int i) {
        this.f50511a.setChunkedStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.f50511a.setFixedLengthStreamingMode(i);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f50511a.setInstanceFollowRedirects(z);
    }

    public void setRequestMethod(String str) throws ProtocolException {
        try {
            this.f50511a.setRequestMethod(str);
        } catch (ProtocolException e) {
            m37683a((Exception) e);
            throw e;
        }
    }

    public boolean getDefaultUseCaches() {
        return this.f50511a.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.f50511a.getDoInput();
    }

    public boolean getDoOutput() {
        return this.f50511a.getDoOutput();
    }

    public long getExpiration() {
        m37684b();
        long expiration = this.f50511a.getExpiration();
        m37679a();
        return expiration;
    }

    public String getHeaderField(int i) {
        m37684b();
        String headerField = this.f50511a.getHeaderField(i);
        m37679a();
        return headerField;
    }

    public String getHeaderField(String str) {
        m37684b();
        String headerField = this.f50511a.getHeaderField(str);
        m37679a();
        return headerField;
    }

    public int getHeaderFieldInt(String str, int i) {
        m37684b();
        int headerFieldInt = this.f50511a.getHeaderFieldInt(str, i);
        m37679a();
        return headerFieldInt;
    }

    public String getHeaderFieldKey(int i) {
        m37684b();
        String headerFieldKey = this.f50511a.getHeaderFieldKey(i);
        m37679a();
        return headerFieldKey;
    }

    public Map<String, List<String>> getHeaderFields() {
        m37684b();
        Map<String, List<String>> headerFields = this.f50511a.getHeaderFields();
        m37679a();
        return headerFields;
    }

    public long getIfModifiedSince() {
        m37684b();
        long ifModifiedSince = this.f50511a.getIfModifiedSince();
        m37679a();
        return ifModifiedSince;
    }

    public InputStream getInputStream() throws IOException {
        final TransactionState b = m37684b();
        try {
            CountingInputStream countingInputStream = new CountingInputStream(this.f50511a.getInputStream());
            TransactionStateUtil.inspectAndInstrumentResponse(b, this.f50511a);
            countingInputStream.addStreamCompleteListener(new StreamCompleteListener() {
                public void streamError(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        b.setBytesReceived(streamCompleteEvent.getBytes());
                    }
                    HttpsURLConnectionExtension.this.m37683a(streamCompleteEvent.getException());
                }

                public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        long contentLength = (long) HttpsURLConnectionExtension.this.f50511a.getContentLength();
                        long bytes = streamCompleteEvent.getBytes();
                        if (contentLength < 0) {
                            contentLength = bytes;
                        }
                        b.setBytesReceived(contentLength);
                        HttpsURLConnectionExtension.this.m37682a(b);
                    }
                }
            });
            return countingInputStream;
        } catch (IOException e) {
            m37683a((Exception) e);
            throw e;
        }
    }

    public long getLastModified() {
        m37684b();
        long lastModified = this.f50511a.getLastModified();
        m37679a();
        return lastModified;
    }

    public OutputStream getOutputStream() throws IOException {
        final TransactionState b = m37684b();
        try {
            CountingOutputStream countingOutputStream = new CountingOutputStream(this.f50511a.getOutputStream());
            countingOutputStream.addStreamCompleteListener(new StreamCompleteListener() {
                public void streamError(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        b.setBytesSent(streamCompleteEvent.getBytes());
                    }
                    HttpsURLConnectionExtension.this.m37683a(streamCompleteEvent.getException());
                }

                public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        String requestProperty = HttpsURLConnectionExtension.this.f50511a.getRequestProperty("content-length");
                        long bytes = streamCompleteEvent.getBytes();
                        if (requestProperty != null) {
                            try {
                                bytes = Long.parseLong(requestProperty);
                            } catch (NumberFormatException unused) {
                            }
                        }
                        b.setBytesSent(bytes);
                    }
                }
            });
            return countingOutputStream;
        } catch (IOException e) {
            m37683a((Exception) e);
            throw e;
        }
    }

    public int getReadTimeout() {
        return this.f50511a.getReadTimeout();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.f50511a.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.f50511a.getRequestProperty(str);
    }

    public URL getURL() {
        return this.f50511a.getURL();
    }

    public boolean getUseCaches() {
        return this.f50511a.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z) {
        this.f50511a.setAllowUserInteraction(z);
    }

    public void setConnectTimeout(int i) {
        this.f50511a.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean z) {
        this.f50511a.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.f50511a.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.f50511a.setDoOutput(z);
    }

    public void setIfModifiedSince(long j) {
        this.f50511a.setIfModifiedSince(j);
    }

    public void setReadTimeout(int i) {
        this.f50511a.setReadTimeout(i);
    }

    public void setRequestProperty(String str, String str2) {
        int i;
        if (!(str == null || str2 == null)) {
            m37684b();
            try {
                String requestProperty = this.f50511a.getRequestProperty(str);
                int length = str2.length();
                if (requestProperty != null) {
                    i = length - requestProperty.length();
                } else {
                    i = length + str.length() + 2;
                }
                this.f50512b.setBytesHeaderSent(this.f50512b.getBytesHeaderSent() + ((long) i));
                if (TransactionStateUtil.isTraceIdHeader(str)) {
                    this.f50512b.setTraceId(str2);
                }
            } catch (IllegalStateException e) {
                f50510c.error("http url connection already connected when set Request Property");
                throw e;
            }
        }
        this.f50511a.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.f50511a.setUseCaches(z);
    }

    public String toString() {
        return this.f50511a.toString();
    }

    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.f50511a.getPeerPrincipal();
    }

    public Principal getLocalPrincipal() {
        return this.f50511a.getLocalPrincipal();
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f50511a.setHostnameVerifier(hostnameVerifier);
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f50511a.getHostnameVerifier();
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f50511a.setSSLSocketFactory(sSLSocketFactory);
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.f50511a.getSSLSocketFactory();
    }

    /* renamed from: a */
    private void m37679a() {
        if (!m37684b().isComplete()) {
            TransactionStateUtil.inspectAndInstrumentResponse(m37684b(), this.f50511a);
        }
    }

    /* renamed from: b */
    private TransactionState m37684b() {
        if (this.f50512b == null) {
            TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTP_URL_CONNECTION);
            this.f50512b = transactionState;
            TransactionStateUtil.inspectAndInstrumentRequet(transactionState, this.f50511a);
        }
        return this.f50512b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37683a(Exception exc) {
        TransactionState b = m37684b();
        TransactionStateUtil.setErrorCodeFromException(b, exc);
        if (!b.isComplete()) {
            TransactionStateUtil.inspectAndInstrumentResponse(b, this.f50511a);
            TransactionData end = b.end();
            if (end != null) {
                TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
                return;
            }
            return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37682a(TransactionState transactionState) {
        TransactionData end = transactionState.end();
        if (end != null) {
            TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            if (transactionState.getStatusCode() >= 400) {
                StringBuilder sb = new StringBuilder();
                try {
                    InputStream errorStream = getErrorStream();
                    if (errorStream instanceof CountingInputStream) {
                        sb.append(((CountingInputStream) errorStream).getBufferAsString());
                    }
                } catch (Exception e) {
                    f50510c.error(e.toString());
                }
                TreeMap treeMap = new TreeMap();
                String contentType = this.f50511a.getContentType();
                if (contentType != null && !"".equals(contentType)) {
                    treeMap.put("content_type", contentType);
                }
                treeMap.put("content_length", transactionState.getBytesReceived() + "");
                Measurements.addHttpError(end, sb.toString(), treeMap);
                return;
            }
        }
    }
}
