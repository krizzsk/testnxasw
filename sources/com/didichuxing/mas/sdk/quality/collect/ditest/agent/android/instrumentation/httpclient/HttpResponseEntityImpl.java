package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.httpclient;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.Measurements;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.TaskQueue;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.TransactionState;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.TransactionStateUtil;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingInputStream;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingOutputStream;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteEvent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteListener;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteListenerSource;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.message.AbstractHttpMessage;

public final class HttpResponseEntityImpl implements StreamCompleteListener, HttpEntity {

    /* renamed from: a */
    private static final String f50545a = "Transfer-Encoding";

    /* renamed from: b */
    private static final String f50546b = "chunked";

    /* renamed from: g */
    private static final AgentLog f50547g = AgentLogManager.getAgentLog();

    /* renamed from: c */
    private final HttpEntity f50548c;

    /* renamed from: d */
    private final TransactionState f50549d;

    /* renamed from: e */
    private final long f50550e;

    /* renamed from: f */
    private CountingInputStream f50551f;

    public HttpResponseEntityImpl(HttpEntity httpEntity, TransactionState transactionState, long j) {
        this.f50548c = httpEntity;
        this.f50549d = transactionState;
        this.f50550e = j;
    }

    public void consumeContent() throws IOException {
        try {
            this.f50548c.consumeContent();
        } catch (IOException e) {
            m37691a((Exception) e);
            throw e;
        }
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        CountingInputStream countingInputStream = this.f50551f;
        if (countingInputStream != null) {
            return countingInputStream;
        }
        try {
            boolean z = true;
            if (this.f50548c instanceof AbstractHttpMessage) {
                Header lastHeader = this.f50548c.getLastHeader("Transfer-Encoding");
                if (lastHeader != null && f50546b.equalsIgnoreCase(lastHeader.getValue())) {
                    z = false;
                }
            } else if (this.f50548c instanceof HttpEntityWrapper) {
                z = true ^ this.f50548c.isChunked();
            }
            CountingInputStream countingInputStream2 = new CountingInputStream(this.f50548c.getContent(), z);
            this.f50551f = countingInputStream2;
            countingInputStream2.addStreamCompleteListener(this);
            return this.f50551f;
        } catch (IOException e) {
            m37691a((Exception) e);
            throw e;
        }
    }

    public Header getContentEncoding() {
        return this.f50548c.getContentEncoding();
    }

    public long getContentLength() {
        return this.f50548c.getContentLength();
    }

    public Header getContentType() {
        return this.f50548c.getContentType();
    }

    public boolean isChunked() {
        return this.f50548c.isChunked();
    }

    public boolean isRepeatable() {
        return this.f50548c.isRepeatable();
    }

    public boolean isStreaming() {
        return this.f50548c.isStreaming();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (!this.f50549d.isComplete()) {
            CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
            try {
                this.f50548c.writeTo(countingOutputStream);
                if (!this.f50549d.isComplete()) {
                    long j = this.f50550e;
                    if (j >= 0) {
                        this.f50549d.setBytesReceived(j);
                    } else {
                        this.f50549d.setBytesReceived(countingOutputStream.getCount());
                    }
                    m37690a(this.f50549d);
                }
            } catch (IOException e) {
                m37692a(e, Long.valueOf(countingOutputStream.getCount()));
                e.printStackTrace();
                throw e;
            }
        } else {
            this.f50548c.writeTo(outputStream);
        }
    }

    public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        if (!this.f50549d.isComplete()) {
            long j = this.f50550e;
            if (j >= 0) {
                this.f50549d.setBytesReceived(j);
            } else {
                this.f50549d.setBytesReceived(streamCompleteEvent.getBytes());
            }
            m37690a(this.f50549d);
        }
    }

    public void streamError(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        TransactionStateUtil.setErrorCodeFromException(this.f50549d, streamCompleteEvent.getException());
        if (!this.f50549d.isComplete()) {
            this.f50549d.setBytesReceived(streamCompleteEvent.getBytes());
        }
    }

    /* renamed from: a */
    private void m37690a(TransactionState transactionState) {
        TransactionData end = transactionState.end();
        if (end != null) {
            TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            if (transactionState.getStatusCode() >= 400) {
                StringBuilder sb = new StringBuilder();
                try {
                    InputStream content = getContent();
                    if (content instanceof CountingInputStream) {
                        sb.append(((CountingInputStream) content).getBufferAsString());
                    }
                } catch (Exception e) {
                    f50547g.error(e.toString());
                }
                Header contentType = this.f50548c.getContentType();
                TreeMap treeMap = new TreeMap();
                if (!(contentType == null || contentType.getValue() == null || "".equals(contentType.getValue()))) {
                    treeMap.put("content_type", contentType.getValue());
                }
                treeMap.put("content_length", transactionState.getBytesReceived() + "");
                Measurements.addHttpError(end, sb.toString(), treeMap);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m37691a(Exception exc) {
        m37692a(exc, (Long) null);
    }

    /* renamed from: a */
    private void m37692a(Exception exc, Long l) {
        TransactionStateUtil.setErrorCodeFromException(this.f50549d, exc);
        if (!this.f50549d.isComplete()) {
            if (l != null) {
                this.f50549d.setBytesReceived(l.longValue());
            }
            TransactionData end = this.f50549d.end();
            if (end != null) {
                TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            }
        }
    }
}
