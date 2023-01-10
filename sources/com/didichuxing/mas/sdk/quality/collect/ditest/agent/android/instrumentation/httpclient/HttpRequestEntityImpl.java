package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.httpclient;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.TaskQueue;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.TransactionState;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.TransactionStateUtil;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingInputStream;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingOutputStream;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteEvent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteListener;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteListenerSource;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public final class HttpRequestEntityImpl implements StreamCompleteListener, HttpEntity {

    /* renamed from: a */
    private final HttpEntity f50543a;

    /* renamed from: b */
    private final TransactionState f50544b;

    public HttpRequestEntityImpl(HttpEntity httpEntity, TransactionState transactionState) {
        this.f50543a = httpEntity;
        this.f50544b = transactionState;
    }

    public void consumeContent() throws IOException {
        try {
            this.f50543a.consumeContent();
        } catch (IOException e) {
            m37688a(e);
            throw e;
        }
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        try {
            if (this.f50544b.isSent()) {
                return this.f50543a.getContent();
            }
            CountingInputStream countingInputStream = new CountingInputStream(this.f50543a.getContent());
            countingInputStream.addStreamCompleteListener(this);
            return countingInputStream;
        } catch (IOException e) {
            m37688a(e);
            throw e;
        } catch (IllegalStateException e2) {
            m37688a(e2);
            throw e2;
        }
    }

    public Header getContentEncoding() {
        return this.f50543a.getContentEncoding();
    }

    public long getContentLength() {
        return this.f50543a.getContentLength();
    }

    public Header getContentType() {
        return this.f50543a.getContentType();
    }

    public boolean isChunked() {
        return this.f50543a.isChunked();
    }

    public boolean isRepeatable() {
        return this.f50543a.isRepeatable();
    }

    public boolean isStreaming() {
        return this.f50543a.isStreaming();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            if (!this.f50544b.isSent()) {
                CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
                this.f50543a.writeTo(countingOutputStream);
                this.f50544b.setBytesSent(countingOutputStream.getCount());
                return;
            }
            this.f50543a.writeTo(outputStream);
        } catch (IOException e) {
            m37688a(e);
            throw e;
        }
    }

    public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        this.f50544b.setBytesSent(streamCompleteEvent.getBytes());
    }

    public void streamError(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        m37689a(streamCompleteEvent.getException(), Long.valueOf(streamCompleteEvent.getBytes()));
    }

    /* renamed from: a */
    private void m37688a(Exception exc) {
        m37689a(exc, (Long) null);
    }

    /* renamed from: a */
    private void m37689a(Exception exc, Long l) {
        TransactionStateUtil.setErrorCodeFromException(this.f50544b, exc);
        if (!this.f50544b.isComplete()) {
            if (l != null) {
                this.f50544b.setBytesSent(l.longValue());
            }
            TransactionData end = this.f50544b.end();
            if (end != null) {
                TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            }
        }
    }
}
