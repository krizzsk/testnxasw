package com.didi.dimina.container.secondparty.http;

import didihttp.MediaType;
import didihttp.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import okio.BufferedSource;
import okio.Okio;

class ProgressResponseBody extends ResponseBody {

    /* renamed from: a */
    private final ResponseBody f19003a;

    /* renamed from: b */
    private final ProgressListener f19004b;

    /* renamed from: c */
    private BufferedSource f19005c;

    public interface ProgressListener {
        void onProgressUpdate(long j, long j2);
    }

    ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        this.f19003a = responseBody;
        this.f19004b = progressListener;
    }

    public MediaType contentType() {
        return this.f19003a.contentType();
    }

    public long contentLength() {
        return this.f19003a.contentLength();
    }

    public BufferedSource source() {
        if (this.f19004b == null) {
            return this.f19003a.source();
        }
        BufferedSource buffer = Okio.buffer(Okio.source((InputStream) new ProgressInputStream(this.f19003a.source().inputStream(), this.f19004b, contentLength())));
        this.f19005c = buffer;
        return buffer;
    }

    public void close() {
        BufferedSource bufferedSource = this.f19005c;
        if (bufferedSource != null) {
            try {
                bufferedSource.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class ProgressInputStream extends InputStream {
        private final ProgressListener listener;
        private long now;
        private final InputStream stream;
        private final long total;

        ProgressInputStream(InputStream inputStream, ProgressListener progressListener, long j) {
            this.stream = inputStream;
            this.listener = progressListener;
            this.total = j;
        }

        public int read() throws IOException {
            int read = this.stream.read();
            long j = this.total;
            if (j < 0) {
                this.listener.onProgressUpdate(-1, -1);
                return read;
            }
            if (read >= 0) {
                long j2 = this.now + 1;
                this.now = j2;
                this.listener.onProgressUpdate(j2, j);
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.stream.read(bArr, i, i2);
            long j = this.total;
            if (j < 0) {
                this.listener.onProgressUpdate(-1, -1);
                return read;
            }
            if (read >= 0) {
                long j2 = this.now + ((long) read);
                this.now = j2;
                this.listener.onProgressUpdate(j2, j);
            }
            return read;
        }

        public void close() throws IOException {
            InputStream inputStream = this.stream;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
