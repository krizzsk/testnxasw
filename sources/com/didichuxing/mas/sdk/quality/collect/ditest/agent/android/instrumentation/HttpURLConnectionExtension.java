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
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HttpURLConnectionExtension extends HttpURLConnection {

    /* renamed from: c */
    private static final AgentLog f50507c = AgentLogManager.getAgentLog();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public HttpURLConnection f50508a;

    /* renamed from: b */
    private TransactionState f50509b;

    public HttpURLConnectionExtension(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        if (!Agent.isEnvSwitchEnable()) {
            this.f50508a = httpURLConnection;
        } else {
            this.f50508a = EnvSwitchManager.getInstance().replaceHttpURLConnection(httpURLConnection);
        }
    }

    public void addRequestProperty(String str, String str2) {
        if (!(str == null || str2 == null)) {
            m37677b();
            try {
                String requestProperty = this.f50508a.getRequestProperty(str);
                int length = str2.length() + 1;
                if (requestProperty == null) {
                    length += str.length() + 2;
                }
                this.f50509b.setBytesHeaderSent(this.f50509b.getBytesHeaderSent() + ((long) length));
                if (TransactionStateUtil.isTraceIdHeader(str)) {
                    this.f50509b.setTraceId(str2);
                }
            } catch (IllegalStateException e) {
                f50507c.error("http url connection already connected when set Request Property");
                throw e;
            }
        }
        this.f50508a.addRequestProperty(str, str2);
    }

    public void disconnect() {
        TransactionState transactionState = this.f50509b;
        if (transactionState != null && !transactionState.isComplete()) {
            m37675a(this.f50509b);
        }
        this.f50508a.disconnect();
    }

    public boolean usingProxy() {
        return this.f50508a.usingProxy();
    }

    public void connect() throws IOException {
        m37677b();
        try {
            this.f50508a.connect();
        } catch (IOException e) {
            m37676a((Exception) e);
            throw e;
        }
    }

    public boolean getAllowUserInteraction() {
        return this.f50508a.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.f50508a.getConnectTimeout();
    }

    public Object getContent() throws IOException {
        m37677b();
        try {
            Object content = this.f50508a.getContent();
            int contentLength = this.f50508a.getContentLength();
            if (contentLength >= 0) {
                TransactionState b = m37677b();
                if (!b.isComplete()) {
                    b.setBytesReceived((long) contentLength);
                    m37675a(b);
                }
            }
            return content;
        } catch (IOException e) {
            m37676a((Exception) e);
            throw e;
        }
    }

    public Object getContent(Class[] clsArr) throws IOException {
        m37677b();
        try {
            Object content = this.f50508a.getContent(clsArr);
            m37672a();
            return content;
        } catch (IOException e) {
            m37676a((Exception) e);
            throw e;
        }
    }

    public String getContentEncoding() {
        m37677b();
        String contentEncoding = this.f50508a.getContentEncoding();
        m37672a();
        return contentEncoding;
    }

    public int getContentLength() {
        m37677b();
        int contentLength = this.f50508a.getContentLength();
        m37672a();
        return contentLength;
    }

    public String getContentType() {
        m37677b();
        String contentType = this.f50508a.getContentType();
        m37672a();
        return contentType;
    }

    public long getDate() {
        m37677b();
        long date = this.f50508a.getDate();
        m37672a();
        return date;
    }

    public InputStream getErrorStream() {
        m37677b();
        try {
            return new CountingInputStream(this.f50508a.getErrorStream(), true);
        } catch (Exception e) {
            f50507c.error(e.toString());
            return this.f50508a.getErrorStream();
        }
    }

    public long getHeaderFieldDate(String str, long j) {
        m37677b();
        long headerFieldDate = this.f50508a.getHeaderFieldDate(str, j);
        m37672a();
        return headerFieldDate;
    }

    public boolean getInstanceFollowRedirects() {
        return this.f50508a.getInstanceFollowRedirects();
    }

    public Permission getPermission() throws IOException {
        return this.f50508a.getPermission();
    }

    public String getRequestMethod() {
        return this.f50508a.getRequestMethod();
    }

    public int getResponseCode() throws IOException {
        m37677b();
        try {
            int responseCode = this.f50508a.getResponseCode();
            m37672a();
            return responseCode;
        } catch (IOException e) {
            m37676a((Exception) e);
            throw e;
        }
    }

    public String getResponseMessage() throws IOException {
        m37677b();
        try {
            String responseMessage = this.f50508a.getResponseMessage();
            m37672a();
            return responseMessage;
        } catch (IOException e) {
            m37676a((Exception) e);
            throw e;
        }
    }

    public void setChunkedStreamingMode(int i) {
        this.f50508a.setChunkedStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.f50508a.setFixedLengthStreamingMode(i);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f50508a.setInstanceFollowRedirects(z);
    }

    public void setRequestMethod(String str) throws ProtocolException {
        m37677b();
        try {
            this.f50508a.setRequestMethod(str);
        } catch (ProtocolException e) {
            m37676a((Exception) e);
            throw e;
        }
    }

    public boolean getDefaultUseCaches() {
        return this.f50508a.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.f50508a.getDoInput();
    }

    public boolean getDoOutput() {
        return this.f50508a.getDoOutput();
    }

    public long getExpiration() {
        m37677b();
        long expiration = this.f50508a.getExpiration();
        m37672a();
        return expiration;
    }

    public String getHeaderField(int i) {
        m37677b();
        String headerField = this.f50508a.getHeaderField(i);
        m37672a();
        return headerField;
    }

    public String getHeaderField(String str) {
        m37677b();
        String headerField = this.f50508a.getHeaderField(str);
        m37672a();
        return headerField;
    }

    public int getHeaderFieldInt(String str, int i) {
        m37677b();
        int headerFieldInt = this.f50508a.getHeaderFieldInt(str, i);
        m37672a();
        return headerFieldInt;
    }

    public String getHeaderFieldKey(int i) {
        m37677b();
        String headerFieldKey = this.f50508a.getHeaderFieldKey(i);
        m37672a();
        return headerFieldKey;
    }

    public Map<String, List<String>> getHeaderFields() {
        m37677b();
        Map<String, List<String>> headerFields = this.f50508a.getHeaderFields();
        m37672a();
        return headerFields;
    }

    public long getIfModifiedSince() {
        m37677b();
        long ifModifiedSince = this.f50508a.getIfModifiedSince();
        m37672a();
        return ifModifiedSince;
    }

    public InputStream getInputStream() throws IOException {
        final TransactionState b = m37677b();
        try {
            CountingInputStream countingInputStream = new CountingInputStream(this.f50508a.getInputStream());
            TransactionStateUtil.inspectAndInstrumentResponse(b, this.f50508a);
            countingInputStream.addStreamCompleteListener(new StreamCompleteListener() {
                public void streamError(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        b.setBytesReceived(streamCompleteEvent.getBytes());
                    }
                    HttpURLConnectionExtension.this.m37676a(streamCompleteEvent.getException());
                }

                public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        long contentLength = (long) HttpURLConnectionExtension.this.f50508a.getContentLength();
                        long bytes = streamCompleteEvent.getBytes();
                        if (contentLength < 0) {
                            contentLength = bytes;
                        }
                        b.setBytesReceived(contentLength);
                        HttpURLConnectionExtension.this.m37675a(b);
                    }
                }
            });
            return countingInputStream;
        } catch (IOException e) {
            m37676a((Exception) e);
            throw e;
        }
    }

    public long getLastModified() {
        m37677b();
        long lastModified = this.f50508a.getLastModified();
        m37672a();
        return lastModified;
    }

    public OutputStream getOutputStream() throws IOException {
        final TransactionState b = m37677b();
        try {
            CountingOutputStream countingOutputStream = new CountingOutputStream(this.f50508a.getOutputStream());
            countingOutputStream.addStreamCompleteListener(new StreamCompleteListener() {
                public void streamError(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        b.setBytesSent(streamCompleteEvent.getBytes());
                    }
                    HttpURLConnectionExtension.this.m37676a(streamCompleteEvent.getException());
                }

                public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        String requestProperty = HttpURLConnectionExtension.this.f50508a.getRequestProperty("content-length");
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
            m37676a((Exception) e);
            throw e;
        }
    }

    public int getReadTimeout() {
        return this.f50508a.getReadTimeout();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.f50508a.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.f50508a.getRequestProperty(str);
    }

    public URL getURL() {
        return this.f50508a.getURL();
    }

    public boolean getUseCaches() {
        return this.f50508a.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z) {
        this.f50508a.setAllowUserInteraction(z);
    }

    public void setConnectTimeout(int i) {
        this.f50508a.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean z) {
        this.f50508a.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.f50508a.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.f50508a.setDoOutput(z);
    }

    public void setIfModifiedSince(long j) {
        this.f50508a.setIfModifiedSince(j);
    }

    public void setReadTimeout(int i) {
        this.f50508a.setReadTimeout(i);
    }

    public void setRequestProperty(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                if (this.f50508a.getRequestProperty(str) != null) {
                    m37677b();
                    this.f50509b.setBytesHeaderSent(this.f50509b.getBytesHeaderSent() + ((long) str.length()) + 1 + ((long) str2.length()) + 1);
                }
            } catch (IllegalStateException e) {
                f50507c.error("http url connection already connected when set Request Property");
                throw e;
            }
        }
        this.f50508a.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.f50508a.setUseCaches(z);
    }

    public String toString() {
        return this.f50508a.toString();
    }

    /* renamed from: a */
    private void m37672a() {
        if (!m37677b().isComplete()) {
            TransactionStateUtil.inspectAndInstrumentResponse(m37677b(), this.f50508a);
        }
    }

    /* renamed from: b */
    private TransactionState m37677b() {
        if (this.f50509b == null) {
            TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTP_URL_CONNECTION);
            this.f50509b = transactionState;
            TransactionStateUtil.inspectAndInstrumentRequet(transactionState, this.f50508a);
        }
        return this.f50509b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37676a(Exception exc) {
        TransactionState b = m37677b();
        TransactionStateUtil.setErrorCodeFromException(b, exc);
        if (!b.isComplete()) {
            TransactionStateUtil.inspectAndInstrumentResponse(b, this.f50508a);
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
    public void m37675a(TransactionState transactionState) {
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
                    f50507c.error(e.toString());
                }
                TreeMap treeMap = new TreeMap();
                String contentType = this.f50508a.getContentType();
                if (contentType != null && !"".equals(contentType)) {
                    treeMap.put("content_type", contentType);
                }
                treeMap.put("content_length", transactionState.getBytesReceived() + "");
                Measurements.addHttpError(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), sb.toString(), end.getBusinessType(), end.getTraceId(), end.isForground(), end.getWanType(), end.getCarrier(), treeMap);
                return;
            }
        }
    }
}
