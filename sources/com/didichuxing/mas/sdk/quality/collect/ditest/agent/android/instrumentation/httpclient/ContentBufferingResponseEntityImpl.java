package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.httpclient;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class ContentBufferingResponseEntityImpl implements HttpEntity {

    /* renamed from: a */
    final HttpEntity f50541a;

    /* renamed from: b */
    private CountingInputStream f50542b;

    public ContentBufferingResponseEntityImpl(HttpEntity httpEntity) {
        if (httpEntity != null) {
            this.f50541a = httpEntity;
            return;
        }
        throw new IllegalArgumentException("Missing wrapped entity");
    }

    public void consumeContent() throws IOException {
        this.f50541a.consumeContent();
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        CountingInputStream countingInputStream = this.f50542b;
        if (countingInputStream != null) {
            return countingInputStream;
        }
        CountingInputStream countingInputStream2 = new CountingInputStream(this.f50541a.getContent(), true);
        this.f50542b = countingInputStream2;
        return countingInputStream2;
    }

    public Header getContentEncoding() {
        return this.f50541a.getContentEncoding();
    }

    public long getContentLength() {
        return this.f50541a.getContentLength();
    }

    public Header getContentType() {
        return this.f50541a.getContentType();
    }

    public boolean isChunked() {
        return this.f50541a.isChunked();
    }

    public boolean isRepeatable() {
        return this.f50541a.isRepeatable();
    }

    public boolean isStreaming() {
        return this.f50541a.isStreaming();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.f50541a.writeTo(outputStream);
    }
}
