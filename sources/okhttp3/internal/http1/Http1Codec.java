package okhttp3.internal.http1;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.C3000Util;
import okhttp3.internal.Internal;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
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
    private static final int f7235f = 0;

    /* renamed from: g */
    private static final int f7236g = 1;

    /* renamed from: h */
    private static final int f7237h = 2;

    /* renamed from: i */
    private static final int f7238i = 3;

    /* renamed from: j */
    private static final int f7239j = 4;

    /* renamed from: k */
    private static final int f7240k = 5;

    /* renamed from: l */
    private static final int f7241l = 6;

    /* renamed from: m */
    private static final int f7242m = 262144;

    /* renamed from: a */
    final OkHttpClient f7243a;

    /* renamed from: b */
    final StreamAllocation f7244b;

    /* renamed from: c */
    final BufferedSource f7245c;

    /* renamed from: d */
    final BufferedSink f7246d;

    /* renamed from: e */
    int f7247e = 0;

    /* renamed from: n */
    private long f7248n = 262144;

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f7243a = okHttpClient;
        this.f7244b = streamAllocation;
        this.f7245c = bufferedSource;
        this.f7246d = bufferedSink;
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
        RealConnection connection = this.f7244b.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public void writeRequestHeaders(Request request) throws IOException {
        writeRequest(request.headers(), RequestLine.get(request, this.f7244b.connection().route().proxy().type()));
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        this.f7244b.eventListener.responseBodyStart(this.f7244b.call);
        String header = response.header("Content-Type");
        if (!okhttp3.internal.http.HttpHeaders.hasBody(response)) {
            return new RealResponseBody(header, 0, Okio.buffer(newFixedLengthSource(0)));
        }
        if ("chunked".equalsIgnoreCase(response.header(HttpHeaders.TRANSFER_ENCODING))) {
            return new RealResponseBody(header, -1, Okio.buffer(newChunkedSource(response.request().url())));
        }
        long contentLength = okhttp3.internal.http.HttpHeaders.contentLength(response);
        if (contentLength != -1) {
            return new RealResponseBody(header, contentLength, Okio.buffer(newFixedLengthSource(contentLength)));
        }
        return new RealResponseBody(header, -1, Okio.buffer(newUnknownLengthSource()));
    }

    public boolean isClosed() {
        return this.f7247e == 6;
    }

    public void flushRequest() throws IOException {
        this.f7246d.flush();
    }

    public void finishRequest() throws IOException {
        this.f7246d.flush();
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        if (this.f7247e == 0) {
            this.f7246d.writeUtf8(str).writeUtf8("\r\n");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                this.f7246d.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
            }
            this.f7246d.writeUtf8("\r\n");
            this.f7247e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f7247e);
    }

    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        int i = this.f7247e;
        if (i == 1 || i == 3) {
            try {
                StatusLine parse = StatusLine.parse(m6839a());
                Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
                if (z && parse.code == 100) {
                    return null;
                }
                if (parse.code == 100) {
                    this.f7247e = 3;
                    return headers;
                }
                this.f7247e = 4;
                return headers;
            } catch (EOFException e) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f7244b);
                iOException.initCause(e);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.f7247e);
        }
    }

    /* renamed from: a */
    private String m6839a() throws IOException {
        String readUtf8LineStrict = this.f7245c.readUtf8LineStrict(this.f7248n);
        this.f7248n -= (long) readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String a = m6839a();
            if (a.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, a);
        }
    }

    public Sink newChunkedSink() {
        if (this.f7247e == 1) {
            this.f7247e = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.f7247e);
    }

    public Sink newFixedLengthSink(long j) {
        if (this.f7247e == 1) {
            this.f7247e = 2;
            return new FixedLengthSink(j);
        }
        throw new IllegalStateException("state: " + this.f7247e);
    }

    public Source newFixedLengthSource(long j) throws IOException {
        if (this.f7247e == 4) {
            this.f7247e = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException("state: " + this.f7247e);
    }

    public Source newChunkedSource(HttpUrl httpUrl) throws IOException {
        if (this.f7247e == 4) {
            this.f7247e = 5;
            return new ChunkedSource(httpUrl);
        }
        throw new IllegalStateException("state: " + this.f7247e);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.f7247e == 4) {
            StreamAllocation streamAllocation = this.f7244b;
            if (streamAllocation != null) {
                this.f7247e = 5;
                streamAllocation.noNewStreams();
                return new UnknownLengthSource();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f7247e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo30473a(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    private final class FixedLengthSink implements Sink {
        private long bytesRemaining;
        private boolean closed;
        private final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.f7246d.timeout());

        FixedLengthSink(long j) {
            this.bytesRemaining = j;
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (!this.closed) {
                C3000Util.checkOffsetAndCount(buffer.size(), 0, j);
                if (j <= this.bytesRemaining) {
                    Http1Codec.this.f7246d.write(buffer, j);
                    this.bytesRemaining -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        public void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.f7246d.flush();
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining <= 0) {
                    Http1Codec.this.mo30473a(this.timeout);
                    Http1Codec.this.f7247e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    private final class ChunkedSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.f7246d.timeout());

        ChunkedSink() {
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                Http1Codec.this.f7246d.writeHexadecimalUnsignedLong(j);
                Http1Codec.this.f7246d.writeUtf8("\r\n");
                Http1Codec.this.f7246d.write(buffer, j);
                Http1Codec.this.f7246d.writeUtf8("\r\n");
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.f7246d.flush();
            }
        }

        public synchronized void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                Http1Codec.this.f7246d.writeUtf8("0\r\n\r\n");
                Http1Codec.this.mo30473a(this.timeout);
                Http1Codec.this.f7247e = 3;
            }
        }
    }

    private abstract class AbstractSource implements Source {
        protected long bytesRead;
        protected boolean closed;
        protected final ForwardingTimeout timeout;

        private AbstractSource() {
            this.timeout = new ForwardingTimeout(Http1Codec.this.f7245c.timeout());
            this.bytesRead = 0;
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = Http1Codec.this.f7245c.read(buffer, j);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e) {
                endOfInput(false, e);
                throw e;
            }
        }

        /* access modifiers changed from: protected */
        public final void endOfInput(boolean z, IOException iOException) throws IOException {
            if (Http1Codec.this.f7247e != 6) {
                if (Http1Codec.this.f7247e == 5) {
                    Http1Codec.this.mo30473a(this.timeout);
                    Http1Codec.this.f7247e = 6;
                    if (Http1Codec.this.f7244b != null) {
                        Http1Codec.this.f7244b.streamFinished(!z, Http1Codec.this, this.bytesRead, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + Http1Codec.this.f7247e);
            }
        }
    }

    private class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        FixedLengthSource(long j) throws IOException {
            super();
            this.bytesRemaining = j;
            if (j == 0) {
                endOfInput(true, (IOException) null);
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (!this.closed) {
                long j2 = this.bytesRemaining;
                if (j2 == 0) {
                    return -1;
                }
                long read = super.read(buffer, Math.min(j2, j));
                if (read != -1) {
                    long j3 = this.bytesRemaining - read;
                    this.bytesRemaining = j3;
                    if (j3 == 0) {
                        endOfInput(true, (IOException) null);
                    }
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                endOfInput(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.bytesRemaining != 0 && !C3000Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false, (IOException) null);
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
                long read = super.read(buffer, Math.min(j, this.bytesRemainingInChunk));
                if (read != -1) {
                    this.bytesRemainingInChunk -= read;
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                endOfInput(false, protocolException);
                throw protocolException;
            }
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Http1Codec.this.f7245c.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = Http1Codec.this.f7245c.readHexadecimalUnsignedLong();
                String trim = Http1Codec.this.f7245c.readUtf8LineStrict().trim();
                if (this.bytesRemainingInChunk < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + trim + Const.jsQuote);
                } else if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    okhttp3.internal.http.HttpHeaders.receiveHeaders(Http1Codec.this.f7243a.cookieJar(), this.url, Http1Codec.this.readHeaders());
                    endOfInput(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.hasMoreChunks && !C3000Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false, (IOException) null);
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
                long read = super.read(buffer, j);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                endOfInput(true, (IOException) null);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!this.inputExhausted) {
                    endOfInput(false, (IOException) null);
                }
                this.closed = true;
            }
        }
    }
}
