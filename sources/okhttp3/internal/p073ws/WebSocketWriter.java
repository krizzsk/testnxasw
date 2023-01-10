package okhttp3.internal.p073ws;

import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* renamed from: okhttp3.internal.ws.WebSocketWriter */
final class WebSocketWriter {

    /* renamed from: a */
    final boolean f7457a;

    /* renamed from: b */
    final Random f7458b;

    /* renamed from: c */
    final BufferedSink f7459c;

    /* renamed from: d */
    final Buffer f7460d;

    /* renamed from: e */
    boolean f7461e;

    /* renamed from: f */
    final Buffer f7462f = new Buffer();

    /* renamed from: g */
    final FrameSink f7463g = new FrameSink();

    /* renamed from: h */
    boolean f7464h;

    /* renamed from: i */
    private final byte[] f7465i;

    /* renamed from: j */
    private final Buffer.UnsafeCursor f7466j;

    WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random != null) {
            this.f7457a = z;
            this.f7459c = bufferedSink;
            this.f7460d = bufferedSink.buffer();
            this.f7458b = random;
            Buffer.UnsafeCursor unsafeCursor = null;
            this.f7465i = z ? new byte[4] : null;
            this.f7466j = z ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo30685a(ByteString byteString) throws IOException {
        m6990b(9, byteString);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo30686b(ByteString byteString) throws IOException {
        m6990b(10, byteString);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo30684a(int i, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (!(i == 0 && byteString == null)) {
            if (i != 0) {
                WebSocketProtocol.m6983b(i);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            m6990b(8, byteString2);
        } finally {
            this.f7461e = true;
        }
    }

    /* renamed from: b */
    private void m6990b(int i, ByteString byteString) throws IOException {
        if (!this.f7461e) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                this.f7460d.writeByte(i | 128);
                if (this.f7457a) {
                    this.f7460d.writeByte(size | 128);
                    this.f7458b.nextBytes(this.f7465i);
                    this.f7460d.write(this.f7465i);
                    if (size > 0) {
                        long size2 = this.f7460d.size();
                        this.f7460d.write(byteString);
                        this.f7460d.readAndWriteUnsafe(this.f7466j);
                        this.f7466j.seek(size2);
                        WebSocketProtocol.m6982a(this.f7466j, this.f7465i);
                        this.f7466j.close();
                    }
                } else {
                    this.f7460d.writeByte(size);
                    this.f7460d.write(byteString);
                }
                this.f7459c.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Sink mo30682a(int i, long j) {
        if (!this.f7464h) {
            this.f7464h = true;
            this.f7463g.formatOpcode = i;
            this.f7463g.contentLength = j;
            this.f7463g.isFirstFrame = true;
            this.f7463g.closed = false;
            return this.f7463g;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo30683a(int i, long j, boolean z, boolean z2) throws IOException {
        if (!this.f7461e) {
            int i2 = 0;
            if (!z) {
                i = 0;
            }
            if (z2) {
                i |= 128;
            }
            this.f7460d.writeByte(i);
            if (this.f7457a) {
                i2 = 128;
            }
            if (j <= 125) {
                this.f7460d.writeByte(((int) j) | i2);
            } else if (j <= 65535) {
                this.f7460d.writeByte(i2 | 126);
                this.f7460d.writeShort((int) j);
            } else {
                this.f7460d.writeByte(i2 | 127);
                this.f7460d.writeLong(j);
            }
            if (this.f7457a) {
                this.f7458b.nextBytes(this.f7465i);
                this.f7460d.write(this.f7465i);
                if (j > 0) {
                    long size = this.f7460d.size();
                    this.f7460d.write(this.f7462f, j);
                    this.f7460d.readAndWriteUnsafe(this.f7466j);
                    this.f7466j.seek(size);
                    WebSocketProtocol.m6982a(this.f7466j, this.f7465i);
                    this.f7466j.close();
                }
            } else {
                this.f7460d.write(this.f7462f, j);
            }
            this.f7459c.emit();
            return;
        }
        throw new IOException("closed");
    }

    /* renamed from: okhttp3.internal.ws.WebSocketWriter$FrameSink */
    final class FrameSink implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (!this.closed) {
                WebSocketWriter.this.f7462f.write(buffer, j);
                boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.f7462f.size() > this.contentLength - 8192;
                long completeSegmentByteCount = WebSocketWriter.this.f7462f.completeSegmentByteCount();
                if (completeSegmentByteCount > 0 && !z) {
                    WebSocketWriter.this.mo30683a(this.formatOpcode, completeSegmentByteCount, this.isFirstFrame, false);
                    this.isFirstFrame = false;
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        public void flush() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.mo30683a(this.formatOpcode, webSocketWriter.f7462f.size(), this.isFirstFrame, false);
                this.isFirstFrame = false;
                return;
            }
            throw new IOException("closed");
        }

        public Timeout timeout() {
            return WebSocketWriter.this.f7459c.timeout();
        }

        public void close() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.mo30683a(this.formatOpcode, webSocketWriter.f7462f.size(), this.isFirstFrame, true);
                this.closed = true;
                WebSocketWriter.this.f7464h = false;
                return;
            }
            throw new IOException("closed");
        }
    }
}
