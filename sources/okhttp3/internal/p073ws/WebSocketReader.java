package okhttp3.internal.p073ws;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: okhttp3.internal.ws.WebSocketReader */
final class WebSocketReader {

    /* renamed from: a */
    final boolean f7445a;

    /* renamed from: b */
    final BufferedSource f7446b;

    /* renamed from: c */
    final FrameCallback f7447c;

    /* renamed from: d */
    boolean f7448d;

    /* renamed from: e */
    int f7449e;

    /* renamed from: f */
    long f7450f;

    /* renamed from: g */
    boolean f7451g;

    /* renamed from: h */
    boolean f7452h;

    /* renamed from: i */
    private final Buffer f7453i = new Buffer();

    /* renamed from: j */
    private final Buffer f7454j = new Buffer();

    /* renamed from: k */
    private final byte[] f7455k;

    /* renamed from: l */
    private final Buffer.UnsafeCursor f7456l;

    /* renamed from: okhttp3.internal.ws.WebSocketReader$FrameCallback */
    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback != null) {
            this.f7445a = z;
            this.f7446b = bufferedSource;
            this.f7447c = frameCallback;
            Buffer.UnsafeCursor unsafeCursor = null;
            this.f7455k = z ? null : new byte[4];
            this.f7456l = !z ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo30681a() throws IOException {
        m6984b();
        if (this.f7452h) {
            m6985c();
        } else {
            m6986d();
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    private void m6984b() throws IOException {
        if (!this.f7448d) {
            long timeoutNanos = this.f7446b.timeout().timeoutNanos();
            this.f7446b.timeout().clearTimeout();
            try {
                byte readByte = this.f7446b.readByte() & 255;
                this.f7446b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.f7449e = readByte & Ascii.f55148SI;
                boolean z = true;
                this.f7451g = (readByte & 128) != 0;
                boolean z2 = (readByte & 8) != 0;
                this.f7452h = z2;
                if (!z2 || this.f7451g) {
                    boolean z3 = (readByte & SignedBytes.MAX_POWER_OF_TWO) != 0;
                    boolean z4 = (readByte & 32) != 0;
                    boolean z5 = (readByte & 16) != 0;
                    if (z3 || z4 || z5) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte readByte2 = this.f7446b.readByte() & 255;
                    if ((readByte2 & 128) == 0) {
                        z = false;
                    }
                    if (z == this.f7445a) {
                        throw new ProtocolException(this.f7445a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    long j = (long) (readByte2 & Byte.MAX_VALUE);
                    this.f7450f = j;
                    if (j == 126) {
                        this.f7450f = ((long) this.f7446b.readShort()) & 65535;
                    } else if (j == 127) {
                        long readLong = this.f7446b.readLong();
                        this.f7450f = readLong;
                        if (readLong < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f7450f) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    if (this.f7452h && this.f7450f > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (z) {
                        this.f7446b.readFully(this.f7455k);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.f7446b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: c */
    private void m6985c() throws IOException {
        String str;
        long j = this.f7450f;
        if (j > 0) {
            this.f7446b.readFully(this.f7453i, j);
            if (!this.f7445a) {
                this.f7453i.readAndWriteUnsafe(this.f7456l);
                this.f7456l.seek(0);
                WebSocketProtocol.m6982a(this.f7456l, this.f7455k);
                this.f7456l.close();
            }
        }
        switch (this.f7449e) {
            case 8:
                short s = 1005;
                long size = this.f7453i.size();
                if (size != 1) {
                    if (size != 0) {
                        s = this.f7453i.readShort();
                        str = this.f7453i.readUtf8();
                        String a = WebSocketProtocol.m6981a(s);
                        if (a != null) {
                            throw new ProtocolException(a);
                        }
                    } else {
                        str = "";
                    }
                    this.f7447c.onReadClose(s, str);
                    this.f7448d = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.f7447c.onReadPing(this.f7453i.readByteString());
                return;
            case 10:
                this.f7447c.onReadPong(this.f7453i.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f7449e));
        }
    }

    /* renamed from: d */
    private void m6986d() throws IOException {
        int i = this.f7449e;
        if (i == 1 || i == 2) {
            m6988f();
            if (i == 1) {
                this.f7447c.onReadMessage(this.f7454j.readUtf8());
            } else {
                this.f7447c.onReadMessage(this.f7454j.readByteString());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
    }

    /* renamed from: e */
    private void m6987e() throws IOException {
        while (!this.f7448d) {
            m6984b();
            if (this.f7452h) {
                m6985c();
            } else {
                return;
            }
        }
    }

    /* renamed from: f */
    private void m6988f() throws IOException {
        while (!this.f7448d) {
            long j = this.f7450f;
            if (j > 0) {
                this.f7446b.readFully(this.f7454j, j);
                if (!this.f7445a) {
                    this.f7454j.readAndWriteUnsafe(this.f7456l);
                    this.f7456l.seek(this.f7454j.size() - this.f7450f);
                    WebSocketProtocol.m6982a(this.f7456l, this.f7455k);
                    this.f7456l.close();
                }
            }
            if (!this.f7451g) {
                m6987e();
                if (this.f7449e != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f7449e));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }
}
