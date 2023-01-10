package didihttp.internal.http1;

import com.didi.dynamic.manager.DownloadManager;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.google.common.net.HttpHeaders;
import didihttp.DidiHttpClient;
import didihttp.Headers;
import didihttp.HttpUrl;
import didihttp.Request;
import didihttp.Response;
import didihttp.ResponseBody;
import didihttp.internal.C21750Util;
import didihttp.internal.Internal;
import didihttp.internal.connection.RealConnection;
import didihttp.internal.connection.StreamAllocation;
import didihttp.internal.http.HttpCodec;
import didihttp.internal.http.RealResponseBody;
import didihttp.internal.http.RequestLine;
import didihttp.internal.http.StatusLine;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1Codec implements HttpCodec {

    /* renamed from: f */
    static AtomicInteger f59491f = new AtomicInteger();

    /* renamed from: g */
    private static final int f59492g = 0;

    /* renamed from: h */
    private static final int f59493h = 1;

    /* renamed from: i */
    private static final int f59494i = 2;

    /* renamed from: j */
    private static final int f59495j = 3;

    /* renamed from: k */
    private static final int f59496k = 4;

    /* renamed from: l */
    private static final int f59497l = 5;

    /* renamed from: m */
    private static final int f59498m = 6;

    /* renamed from: a */
    final DidiHttpClient f59499a;

    /* renamed from: b */
    final StreamAllocation f59500b;

    /* renamed from: c */
    final BufferedSource f59501c;

    /* renamed from: d */
    final BufferedSink f59502d;

    /* renamed from: e */
    int f59503e = 0;

    public Http1Codec(DidiHttpClient didiHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f59499a = didiHttpClient;
        this.f59500b = streamAllocation;
        this.f59501c = bufferedSource;
        this.f59502d = bufferedSink;
    }

    public Sink createRequestBody(Request request, long j) {
        if ("chunked".equalsIgnoreCase(request.header(HttpHeaders.TRANSFER_ENCODING))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void cancel() {
        RealConnection connection = this.f59500b.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public void writeRequestHeaders(Request request) throws IOException {
        writeRequest(request.headers(), RequestLine.get(request, this.f59500b.connection().route().proxy().type()));
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        BufferedSource buffer = Okio.buffer(m44837a(response));
        if (buffer.request(1048576)) {
            File createTempFile = File.createTempFile(DownloadManager.MODULE_DIR_TEMP + f59491f.getAndIncrement(), ".dat");
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = buffer.read(bArr);
                    if (-1 != read) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        return new RealResponseBody(response.headers(), Okio.buffer(Okio.source((InputStream) new FileInputStream(createTempFile))));
                    }
                } finally {
                    fileOutputStream.close();
                }
            }
        } else {
            return new RealResponseBody(response.headers(), Okio.buffer(Okio.source((InputStream) new ByteArrayInputStream(buffer.readByteArray()))));
        }
    }

    /* renamed from: a */
    private Source m44837a(Response response) throws IOException {
        if (!didihttp.internal.http.HttpHeaders.hasBody(response)) {
            return newFixedLengthSource(0);
        }
        if ("chunked".equalsIgnoreCase(response.header(HttpHeaders.TRANSFER_ENCODING))) {
            return newChunkedSource(response.request().url());
        }
        long contentLength = didihttp.internal.http.HttpHeaders.contentLength(response);
        if (contentLength != -1) {
            return newFixedLengthSource(contentLength);
        }
        return newUnknownLengthSource();
    }

    public boolean isClosed() {
        return this.f59503e == 6;
    }

    public void flushRequest() throws IOException {
        this.f59502d.flush();
    }

    public void finishRequest() throws IOException {
        this.f59502d.flush();
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        if (this.f59503e == 0) {
            this.f59502d.writeUtf8(str).writeUtf8("\r\n");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                this.f59502d.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
            }
            this.f59502d.writeUtf8("\r\n");
            this.f59503e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f59503e);
    }

    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        int i = this.f59503e;
        if (i == 1 || i == 3) {
            try {
                StatusLine parse = StatusLine.parse(this.f59501c.readUtf8LineStrict());
                Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
                if (z && parse.code == 100) {
                    return null;
                }
                this.f59503e = 4;
                return headers;
            } catch (EOFException e) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f59500b);
                iOException.initCause(e);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.f59503e);
        }
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readUtf8LineStrict = this.f59501c.readUtf8LineStrict();
            if (readUtf8LineStrict.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, readUtf8LineStrict);
        }
    }

    public Sink newChunkedSink() {
        if (this.f59503e == 1) {
            this.f59503e = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.f59503e);
    }

    public Sink newFixedLengthSink(long j) {
        if (this.f59503e == 1) {
            this.f59503e = 2;
            return new FixedLengthSink(j);
        }
        throw new IllegalStateException("state: " + this.f59503e);
    }

    public Source newFixedLengthSource(long j) throws IOException {
        if (this.f59503e == 4) {
            this.f59503e = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException("state: " + this.f59503e);
    }

    public Source newChunkedSource(HttpUrl httpUrl) throws IOException {
        if (this.f59503e == 4) {
            this.f59503e = 5;
            return new ChunkedSource(httpUrl);
        }
        throw new IllegalStateException("state: " + this.f59503e);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.f59503e == 4) {
            StreamAllocation streamAllocation = this.f59500b;
            if (streamAllocation != null) {
                this.f59503e = 5;
                streamAllocation.noNewStreams();
                return new UnknownLengthSource();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f59503e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179877a(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    private final class FixedLengthSink implements Sink {
        private long bytesRemaining;
        private boolean closed;
        private final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.f59502d.timeout());

        FixedLengthSink(long j) {
            this.bytesRemaining = j;
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (!this.closed) {
                C21750Util.checkOffsetAndCount(buffer.size(), 0, j);
                if (j <= this.bytesRemaining) {
                    Http1Codec.this.f59502d.write(buffer, j);
                    this.bytesRemaining -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        public void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.f59502d.flush();
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining <= 0) {
                    Http1Codec.this.mo179877a(this.timeout);
                    Http1Codec.this.f59503e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    private final class ChunkedSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.f59502d.timeout());

        ChunkedSink() {
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                Http1Codec.this.f59502d.writeHexadecimalUnsignedLong(j);
                Http1Codec.this.f59502d.writeUtf8("\r\n");
                Http1Codec.this.f59502d.write(buffer, j);
                Http1Codec.this.f59502d.writeUtf8("\r\n");
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.f59502d.flush();
            }
        }

        public synchronized void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                Http1Codec.this.f59502d.writeUtf8("0\r\n\r\n");
                Http1Codec.this.mo179877a(this.timeout);
                Http1Codec.this.f59503e = 3;
            }
        }
    }

    private abstract class AbstractSource implements Source {
        protected boolean closed;
        protected final ForwardingTimeout timeout;

        private AbstractSource() {
            this.timeout = new ForwardingTimeout(Http1Codec.this.f59501c.timeout());
        }

        public Timeout timeout() {
            return this.timeout;
        }

        /* access modifiers changed from: protected */
        public final void endOfInput(boolean z) throws IOException {
            if (Http1Codec.this.f59503e != 6) {
                if (Http1Codec.this.f59503e == 5) {
                    Http1Codec.this.mo179877a(this.timeout);
                    Http1Codec.this.f59503e = 6;
                    if (Http1Codec.this.f59500b != null) {
                        Http1Codec.this.f59500b.streamFinished(!z, Http1Codec.this);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + Http1Codec.this.f59503e);
            }
        }
    }

    private class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j) throws IOException {
            super();
            this.bytesRemaining = j;
            if (j == 0) {
                endOfInput(true);
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.bytesRemaining == 0) {
                return -1;
            } else {
                long read = Http1Codec.this.f59501c.read(buffer, Math.min(this.bytesRemaining, j));
                if (read != -1) {
                    long j2 = this.bytesRemaining - read;
                    this.bytesRemaining = j2;
                    if (j2 == 0) {
                        endOfInput(true);
                    }
                    return read;
                }
                endOfInput(false);
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.bytesRemaining != 0 && !C21750Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false);
                }
                this.closed = true;
            }
        }
    }

    private class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk = -1;
        private boolean hasMoreChunks = true;
        private final HttpUrl url;

        ChunkedSource(HttpUrl httpUrl) {
            super();
            this.url = httpUrl;
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (!this.hasMoreChunks) {
                return -1;
            } else {
                long j2 = this.bytesRemainingInChunk;
                if (j2 == 0 || j2 == -1) {
                    readChunkSize();
                    if (!this.hasMoreChunks) {
                        return -1;
                    }
                }
                long read = Http1Codec.this.f59501c.read(buffer, Math.min(j, this.bytesRemainingInChunk));
                if (read != -1) {
                    this.bytesRemainingInChunk -= read;
                    return read;
                }
                endOfInput(false);
                throw new ProtocolException("unexpected end of stream");
            }
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Http1Codec.this.f59501c.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = Http1Codec.this.f59501c.readHexadecimalUnsignedLong();
                String trim = Http1Codec.this.f59501c.readUtf8LineStrict().trim();
                if (this.bytesRemainingInChunk < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + trim + Const.jsQuote);
                } else if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    didihttp.internal.http.HttpHeaders.receiveHeaders(Http1Codec.this.f59499a.cookieJar(), this.url, Http1Codec.this.readHeaders());
                    endOfInput(true);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.hasMoreChunks && !C21750Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false);
                }
                this.closed = true;
            }
        }
    }

    private class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        UnknownLengthSource() {
            super();
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.inputExhausted) {
                return -1;
            } else {
                long read = Http1Codec.this.f59501c.read(buffer, j);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                endOfInput(true);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!this.inputExhausted) {
                    endOfInput(false);
                }
                this.closed = true;
            }
        }
    }
}
