package didihttp.internal.p232ws;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: didihttp.internal.ws.WebSocketReader */
final class WebSocketReader {

    /* renamed from: a */
    final boolean f59728a;

    /* renamed from: b */
    final BufferedSource f59729b;

    /* renamed from: c */
    final FrameCallback f59730c;

    /* renamed from: d */
    boolean f59731d;

    /* renamed from: e */
    int f59732e;

    /* renamed from: f */
    long f59733f;

    /* renamed from: g */
    long f59734g;

    /* renamed from: h */
    boolean f59735h;

    /* renamed from: i */
    boolean f59736i;

    /* renamed from: j */
    boolean f59737j;

    /* renamed from: k */
    final byte[] f59738k = new byte[4];

    /* renamed from: l */
    final byte[] f59739l = new byte[8192];

    /* renamed from: didihttp.internal.ws.WebSocketReader$FrameCallback */
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
            this.f59728a = z;
            this.f59729b = bufferedSource;
            this.f59730c = frameCallback;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo180195a() throws IOException {
        m45000c();
        if (this.f59736i) {
            m45001d();
        } else {
            m45002e();
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: c */
    private void m45000c() throws IOException {
        if (!this.f59731d) {
            long timeoutNanos = this.f59729b.timeout().timeoutNanos();
            this.f59729b.timeout().clearTimeout();
            try {
                byte readByte = this.f59729b.readByte() & 255;
                this.f59729b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.f59732e = readByte & Ascii.f55148SI;
                boolean z = true;
                this.f59735h = (readByte & 128) != 0;
                boolean z2 = (readByte & 8) != 0;
                this.f59736i = z2;
                if (!z2 || this.f59735h) {
                    boolean z3 = (readByte & SignedBytes.MAX_POWER_OF_TWO) != 0;
                    boolean z4 = (readByte & 32) != 0;
                    boolean z5 = (readByte & 16) != 0;
                    if (z3 || z4 || z5) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte readByte2 = this.f59729b.readByte() & 255;
                    if ((readByte2 & 128) == 0) {
                        z = false;
                    }
                    this.f59737j = z;
                    if (z == this.f59728a) {
                        throw new ProtocolException(this.f59728a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    long j = (long) (readByte2 & Byte.MAX_VALUE);
                    this.f59733f = j;
                    if (j == 126) {
                        this.f59733f = ((long) this.f59729b.readShort()) & 65535;
                    } else if (j == 127) {
                        long readLong = this.f59729b.readLong();
                        this.f59733f = readLong;
                        if (readLong < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f59733f) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    this.f59734g = 0;
                    if (this.f59736i && this.f59733f > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (this.f59737j) {
                        this.f59729b.readFully(this.f59738k);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.f59729b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: d */
    private void m45001d() throws IOException {
        String str;
        Buffer buffer = new Buffer();
        long j = this.f59734g;
        long j2 = this.f59733f;
        if (j < j2) {
            if (!this.f59728a) {
                while (true) {
                    long j3 = this.f59734g;
                    long j4 = this.f59733f;
                    if (j3 >= j4) {
                        break;
                    }
                    int read = this.f59729b.read(this.f59739l, 0, (int) Math.min(j4 - j3, (long) this.f59739l.length));
                    if (read != -1) {
                        long j5 = (long) read;
                        WebSocketProtocol.m44997a(this.f59739l, j5, this.f59738k, this.f59734g);
                        buffer.write(this.f59739l, 0, read);
                        this.f59734g += j5;
                    } else {
                        throw new EOFException();
                    }
                }
            } else {
                this.f59729b.readFully(buffer, j2);
            }
        }
        switch (this.f59732e) {
            case 8:
                short s = 1005;
                long size = buffer.size();
                if (size != 1) {
                    if (size != 0) {
                        s = buffer.readShort();
                        str = buffer.readUtf8();
                        String a = WebSocketProtocol.m44996a(s);
                        if (a != null) {
                            throw new ProtocolException(a);
                        }
                    } else {
                        str = "";
                    }
                    this.f59730c.onReadClose(s, str);
                    this.f59731d = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.f59730c.onReadPing(buffer.readByteString());
                return;
            case 10:
                this.f59730c.onReadPong(buffer.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f59732e));
        }
    }

    /* renamed from: e */
    private void m45002e() throws IOException {
        int i = this.f59732e;
        if (i == 1 || i == 2) {
            Buffer buffer = new Buffer();
            m44999a(buffer);
            if (i == 1) {
                this.f59730c.onReadMessage(buffer.readUtf8());
            } else {
                this.f59730c.onReadMessage(buffer.readByteString());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo180196b() throws IOException {
        while (!this.f59731d) {
            m45000c();
            if (this.f59736i) {
                m45001d();
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m44999a(Buffer buffer) throws IOException {
        long j;
        while (!this.f59731d) {
            if (this.f59734g == this.f59733f) {
                if (!this.f59735h) {
                    mo180196b();
                    if (this.f59732e != 0) {
                        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f59732e));
                    } else if (this.f59735h && this.f59733f == 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
            long j2 = this.f59733f - this.f59734g;
            if (this.f59737j) {
                j = (long) this.f59729b.read(this.f59739l, 0, (int) Math.min(j2, (long) this.f59739l.length));
                if (j != -1) {
                    WebSocketProtocol.m44997a(this.f59739l, j, this.f59738k, this.f59734g);
                    buffer.write(this.f59739l, 0, (int) j);
                } else {
                    throw new EOFException();
                }
            } else {
                j = this.f59729b.read(buffer, j2);
                if (j == -1) {
                    throw new EOFException();
                }
            }
            this.f59734g += j;
        }
        throw new IOException("closed");
    }
}
