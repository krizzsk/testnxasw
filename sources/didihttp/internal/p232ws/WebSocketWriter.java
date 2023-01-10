package didihttp.internal.p232ws;

import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* renamed from: didihttp.internal.ws.WebSocketWriter */
final class WebSocketWriter {

    /* renamed from: j */
    static final /* synthetic */ boolean f59740j = (!WebSocketWriter.class.desiredAssertionStatus());

    /* renamed from: a */
    final boolean f59741a;

    /* renamed from: b */
    final Random f59742b;

    /* renamed from: c */
    final BufferedSink f59743c;

    /* renamed from: d */
    boolean f59744d;

    /* renamed from: e */
    final Buffer f59745e = new Buffer();

    /* renamed from: f */
    final FrameSink f59746f = new FrameSink();

    /* renamed from: g */
    boolean f59747g;

    /* renamed from: h */
    final byte[] f59748h;

    /* renamed from: i */
    final byte[] f59749i;

    WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random != null) {
            this.f59741a = z;
            this.f59743c = bufferedSink;
            this.f59742b = random;
            byte[] bArr = null;
            this.f59748h = z ? new byte[4] : null;
            this.f59749i = z ? new byte[8192] : bArr;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo180200a(ByteString byteString) throws IOException {
        synchronized (this) {
            m45005b(9, byteString);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo180201b(ByteString byteString) throws IOException {
        synchronized (this) {
            m45005b(10, byteString);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo180199a(int i, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (!(i == 0 && byteString == null)) {
            if (i != 0) {
                WebSocketProtocol.m44998b(i);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        synchronized (this) {
            try {
                m45005b(8, byteString2);
                this.f59744d = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: b */
    private void m45005b(int i, ByteString byteString) throws IOException {
        if (!f59740j && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (!this.f59744d) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                this.f59743c.writeByte(i | 128);
                if (this.f59741a) {
                    this.f59743c.writeByte(size | 128);
                    this.f59742b.nextBytes(this.f59748h);
                    this.f59743c.write(this.f59748h);
                    byte[] byteArray = byteString.toByteArray();
                    WebSocketProtocol.m44997a(byteArray, (long) byteArray.length, this.f59748h, 0);
                    this.f59743c.write(byteArray);
                } else {
                    this.f59743c.writeByte(size);
                    this.f59743c.write(byteString);
                }
                this.f59743c.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Sink mo180197a(int i, long j) {
        if (!this.f59747g) {
            this.f59747g = true;
            this.f59746f.formatOpcode = i;
            this.f59746f.contentLength = j;
            this.f59746f.isFirstFrame = true;
            this.f59746f.closed = false;
            return this.f59746f;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo180198a(int i, long j, boolean z, boolean z2) throws IOException {
        if (!f59740j && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (!this.f59744d) {
            if (!z) {
                i = 0;
            }
            if (z2) {
                i |= 128;
            }
            this.f59743c.writeByte(i);
            int i2 = this.f59741a ? 128 : 0;
            if (j <= 125) {
                this.f59743c.writeByte(i2 | ((int) j));
            } else if (j <= 65535) {
                this.f59743c.writeByte(i2 | 126);
                this.f59743c.writeShort((int) j);
            } else {
                this.f59743c.writeByte(i2 | 127);
                this.f59743c.writeLong(j);
            }
            if (this.f59741a) {
                this.f59742b.nextBytes(this.f59748h);
                this.f59743c.write(this.f59748h);
                long j2 = 0;
                while (j2 < j) {
                    int read = this.f59745e.read(this.f59749i, 0, (int) Math.min(j, (long) this.f59749i.length));
                    if (read != -1) {
                        long j3 = (long) read;
                        WebSocketProtocol.m44997a(this.f59749i, j3, this.f59748h, j2);
                        this.f59743c.write(this.f59749i, 0, read);
                        j2 += j3;
                    } else {
                        throw new AssertionError();
                    }
                }
            } else {
                this.f59743c.write(this.f59745e, j);
            }
            this.f59743c.emit();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: didihttp.internal.ws.WebSocketWriter$FrameSink */
    final class FrameSink implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (!this.closed) {
                WebSocketWriter.this.f59745e.write(buffer, j);
                boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.f59745e.size() > this.contentLength - 8192;
                long completeSegmentByteCount = WebSocketWriter.this.f59745e.completeSegmentByteCount();
                if (completeSegmentByteCount > 0 && !z) {
                    synchronized (WebSocketWriter.this) {
                        WebSocketWriter.this.mo180198a(this.formatOpcode, completeSegmentByteCount, this.isFirstFrame, false);
                    }
                    this.isFirstFrame = false;
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        public void flush() throws IOException {
            if (!this.closed) {
                synchronized (WebSocketWriter.this) {
                    WebSocketWriter.this.mo180198a(this.formatOpcode, WebSocketWriter.this.f59745e.size(), this.isFirstFrame, false);
                }
                this.isFirstFrame = false;
                return;
            }
            throw new IOException("closed");
        }

        public Timeout timeout() {
            return WebSocketWriter.this.f59743c.timeout();
        }

        public void close() throws IOException {
            if (!this.closed) {
                synchronized (WebSocketWriter.this) {
                    WebSocketWriter.this.mo180198a(this.formatOpcode, WebSocketWriter.this.f59745e.size(), this.isFirstFrame, true);
                }
                this.closed = true;
                WebSocketWriter.this.f59747g = false;
                return;
            }
            throw new IOException("closed");
        }
    }
}
