package com.didi.dimina.container.secondparty.http;

import didihttp.MediaType;
import didihttp.RequestBody;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

class ProgressRequestBody extends RequestBody {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ProgressListener f19001a;

    /* renamed from: b */
    private final RequestBody f19002b;

    public interface ProgressListener {
        void onProgressUpdate(long j, long j2);
    }

    ProgressRequestBody(RequestBody requestBody, ProgressListener progressListener) {
        this.f19002b = requestBody;
        this.f19001a = progressListener;
    }

    public MediaType contentType() {
        return this.f19002b.contentType();
    }

    public long contentLength() throws IOException {
        return this.f19002b.contentLength();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        final long contentLength = contentLength();
        BufferedSink buffer = Okio.buffer((Sink) new ForwardingSink(bufferedSink) {
            private long mCurrentLength;

            public void write(Buffer buffer, long j) throws IOException {
                this.mCurrentLength += j;
                if (ProgressRequestBody.this.f19001a != null) {
                    ProgressRequestBody.this.f19001a.onProgressUpdate(this.mCurrentLength, contentLength);
                }
                super.write(buffer, j);
            }
        });
        this.f19002b.writeTo(buffer);
        buffer.flush();
    }
}
