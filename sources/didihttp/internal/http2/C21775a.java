package didihttp.internal.http2;

import didihttp.internal.C21750Util;
import didihttp.internal.http2.Hpack;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;

/* renamed from: didihttp.internal.http2.a */
/* compiled from: Http2Writer */
final class C21775a implements Closeable {

    /* renamed from: b */
    private static final Logger f59605b = Logger.getLogger(Http2.class.getName());

    /* renamed from: a */
    final Hpack.Writer f59606a;

    /* renamed from: c */
    private final BufferedSink f59607c;

    /* renamed from: d */
    private final boolean f59608d;

    /* renamed from: e */
    private final Buffer f59609e;

    /* renamed from: f */
    private int f59610f = 16384;

    /* renamed from: g */
    private boolean f59611g;

    public C21775a(BufferedSink bufferedSink, boolean z) {
        this.f59607c = bufferedSink;
        this.f59608d = z;
        Buffer buffer = new Buffer();
        this.f59609e = buffer;
        this.f59606a = new Hpack.Writer(buffer);
    }

    /* renamed from: a */
    public synchronized void mo179991a() throws IOException {
        if (this.f59611g) {
            throw new IOException("closed");
        } else if (this.f59608d) {
            if (f59605b.isLoggable(Level.FINE)) {
                f59605b.fine(C21750Util.format(">> CONNECTION %s", Http2.f59511a.hex()));
            }
            this.f59607c.write(Http2.f59511a.toByteArray());
            this.f59607c.flush();
        }
    }

    /* renamed from: a */
    public synchronized void mo179999a(Settings settings) throws IOException {
        if (!this.f59611g) {
            this.f59610f = settings.mo179989d(this.f59610f);
            if (settings.mo179986c() != -1) {
                this.f59606a.setHeaderTableSizeSetting(settings.mo179986c());
            }
            mo179993a(0, 0, (byte) 4, (byte) 1);
            this.f59607c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo179994a(int i, int i2, List<Header> list) throws IOException {
        if (!this.f59611g) {
            this.f59606a.writeHeaders(list);
            long size = this.f59609e.size();
            int min = (int) Math.min((long) (this.f59610f - 4), size);
            long j = (long) min;
            int i3 = (size > j ? 1 : (size == j ? 0 : -1));
            mo179993a(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : 0);
            this.f59607c.writeInt(i2 & Integer.MAX_VALUE);
            this.f59607c.write(this.f59609e, j);
            if (i3 > 0) {
                m44906b(i, size - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public synchronized void mo180004b() throws IOException {
        if (!this.f59611g) {
            this.f59607c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo180001a(boolean z, int i, int i2, List<Header> list) throws IOException {
        if (!this.f59611g) {
            mo180006b(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo180002a(boolean z, int i, List<Header> list) throws IOException {
        if (!this.f59611g) {
            mo180006b(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo179998a(int i, List<Header> list) throws IOException {
        if (!this.f59611g) {
            mo180006b(false, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo179996a(int i, ErrorCode errorCode) throws IOException {
        if (this.f59611g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            mo179993a(i, 4, (byte) 3, (byte) 0);
            this.f59607c.writeInt(errorCode.httpCode);
            this.f59607c.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: c */
    public int mo180007c() {
        return this.f59610f;
    }

    /* renamed from: a */
    public synchronized void mo180003a(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (!this.f59611g) {
            byte b = 0;
            if (z) {
                b = (byte) 1;
            }
            mo179992a(i, b, buffer, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179992a(int i, byte b, Buffer buffer, int i2) throws IOException {
        mo179993a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f59607c.write(buffer, (long) i2);
        }
    }

    /* renamed from: b */
    public synchronized void mo180005b(Settings settings) throws IOException {
        if (!this.f59611g) {
            int i = 0;
            mo179993a(0, settings.mo179984b() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (settings.mo179982a(i)) {
                    this.f59607c.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f59607c.writeInt(settings.mo179985b(i));
                }
                i++;
            }
            this.f59607c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo180000a(boolean z, int i, int i2) throws IOException {
        if (!this.f59611g) {
            mo179993a(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.f59607c.writeInt(i);
            this.f59607c.writeInt(i2);
            this.f59607c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo179997a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.f59611g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            mo179993a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f59607c.writeInt(i);
            this.f59607c.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.f59607c.write(bArr);
            }
            this.f59607c.flush();
        } else {
            throw Http2.m44841a("errorCode.httpCode == -1", new Object[0]);
        }
    }

    /* renamed from: a */
    public synchronized void mo179995a(int i, long j) throws IOException {
        if (this.f59611g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw Http2.m44841a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            mo179993a(i, 4, (byte) 8, (byte) 0);
            this.f59607c.writeInt((int) j);
            this.f59607c.flush();
        }
    }

    /* renamed from: a */
    public void mo179993a(int i, int i2, byte b, byte b2) throws IOException {
        if (f59605b.isLoggable(Level.FINE)) {
            f59605b.fine(Http2.m44843a(false, i, i2, b, b2));
        }
        int i3 = this.f59610f;
        if (i2 > i3) {
            throw Http2.m44841a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) == 0) {
            m44905a(this.f59607c, i2);
            this.f59607c.writeByte(b & 255);
            this.f59607c.writeByte(b2 & 255);
            this.f59607c.writeInt(i & Integer.MAX_VALUE);
        } else {
            throw Http2.m44841a("reserved bit set: %s", Integer.valueOf(i));
        }
    }

    public synchronized void close() throws IOException {
        this.f59611g = true;
        this.f59607c.close();
    }

    /* renamed from: a */
    private static void m44905a(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    /* renamed from: b */
    private void m44906b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f59610f, j);
            long j2 = (long) min;
            j -= j2;
            mo179993a(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.f59607c.write(this.f59609e, j2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo180006b(boolean z, int i, List<Header> list) throws IOException {
        if (!this.f59611g) {
            this.f59606a.writeHeaders(list);
            long size = this.f59609e.size();
            int min = (int) Math.min((long) this.f59610f, size);
            long j = (long) min;
            int i2 = (size > j ? 1 : (size == j ? 0 : -1));
            byte b = i2 == 0 ? (byte) 4 : 0;
            if (z) {
                b = (byte) (b | 1);
            }
            mo179993a(i, min, (byte) 1, b);
            this.f59607c.write(this.f59609e, j);
            if (i2 > 0) {
                m44906b(i, size - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
