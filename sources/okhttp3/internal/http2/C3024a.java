package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.C3000Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

/* renamed from: okhttp3.internal.http2.a */
/* compiled from: Http2Writer */
final class C3024a implements Closeable {

    /* renamed from: b */
    private static final Logger f7349b = Logger.getLogger(Http2.class.getName());

    /* renamed from: a */
    final Hpack.Writer f7350a;

    /* renamed from: c */
    private final BufferedSink f7351c;

    /* renamed from: d */
    private final boolean f7352d;

    /* renamed from: e */
    private final Buffer f7353e;

    /* renamed from: f */
    private int f7354f = 16384;

    /* renamed from: g */
    private boolean f7355g;

    C3024a(BufferedSink bufferedSink, boolean z) {
        this.f7351c = bufferedSink;
        this.f7352d = z;
        Buffer buffer = new Buffer();
        this.f7353e = buffer;
        this.f7350a = new Hpack.Writer(buffer);
    }

    /* renamed from: a */
    public synchronized void mo30590a() throws IOException {
        if (this.f7355g) {
            throw new IOException("closed");
        } else if (this.f7352d) {
            if (f7349b.isLoggable(Level.FINE)) {
                f7349b.fine(C3000Util.format(">> CONNECTION %s", Http2.f7256a.hex()));
            }
            this.f7351c.write(Http2.f7256a.toByteArray());
            this.f7351c.flush();
        }
    }

    /* renamed from: a */
    public synchronized void mo30598a(Settings settings) throws IOException {
        if (!this.f7355g) {
            this.f7354f = settings.mo30588d(this.f7354f);
            if (settings.mo30585c() != -1) {
                this.f7350a.setHeaderTableSizeSetting(settings.mo30585c());
            }
            mo30592a(0, 0, (byte) 4, (byte) 1);
            this.f7351c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo30593a(int i, int i2, List<Header> list) throws IOException {
        if (!this.f7355g) {
            this.f7350a.writeHeaders(list);
            long size = this.f7353e.size();
            int min = (int) Math.min((long) (this.f7354f - 4), size);
            long j = (long) min;
            int i3 = (size > j ? 1 : (size == j ? 0 : -1));
            mo30592a(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : 0);
            this.f7351c.writeInt(i2 & Integer.MAX_VALUE);
            this.f7351c.write(this.f7353e, j);
            if (i3 > 0) {
                m6916b(i, size - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public synchronized void mo30603b() throws IOException {
        if (!this.f7355g) {
            this.f7351c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo30600a(boolean z, int i, int i2, List<Header> list) throws IOException {
        if (!this.f7355g) {
            mo30605b(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo30601a(boolean z, int i, List<Header> list) throws IOException {
        if (!this.f7355g) {
            mo30605b(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo30595a(int i, List<Header> list) throws IOException {
        if (!this.f7355g) {
            mo30605b(false, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo30596a(int i, ErrorCode errorCode) throws IOException {
        if (this.f7355g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            mo30592a(i, 4, (byte) 3, (byte) 0);
            this.f7351c.writeInt(errorCode.httpCode);
            this.f7351c.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: c */
    public int mo30606c() {
        return this.f7354f;
    }

    /* renamed from: a */
    public synchronized void mo30602a(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (!this.f7355g) {
            byte b = 0;
            if (z) {
                b = (byte) 1;
            }
            mo30591a(i, b, buffer, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo30591a(int i, byte b, Buffer buffer, int i2) throws IOException {
        mo30592a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f7351c.write(buffer, (long) i2);
        }
    }

    /* renamed from: b */
    public synchronized void mo30604b(Settings settings) throws IOException {
        if (!this.f7355g) {
            int i = 0;
            mo30592a(0, settings.mo30583b() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (settings.mo30581a(i)) {
                    this.f7351c.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f7351c.writeInt(settings.mo30584b(i));
                }
                i++;
            }
            this.f7351c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo30599a(boolean z, int i, int i2) throws IOException {
        if (!this.f7355g) {
            mo30592a(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.f7351c.writeInt(i);
            this.f7351c.writeInt(i2);
            this.f7351c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo30597a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.f7355g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            mo30592a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f7351c.writeInt(i);
            this.f7351c.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.f7351c.write(bArr);
            }
            this.f7351c.flush();
        } else {
            throw Http2.m6843a("errorCode.httpCode == -1", new Object[0]);
        }
    }

    /* renamed from: a */
    public synchronized void mo30594a(int i, long j) throws IOException {
        if (this.f7355g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw Http2.m6843a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            mo30592a(i, 4, (byte) 8, (byte) 0);
            this.f7351c.writeInt((int) j);
            this.f7351c.flush();
        }
    }

    /* renamed from: a */
    public void mo30592a(int i, int i2, byte b, byte b2) throws IOException {
        if (f7349b.isLoggable(Level.FINE)) {
            f7349b.fine(Http2.m6845a(false, i, i2, b, b2));
        }
        int i3 = this.f7354f;
        if (i2 > i3) {
            throw Http2.m6843a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) == 0) {
            m6915a(this.f7351c, i2);
            this.f7351c.writeByte(b & 255);
            this.f7351c.writeByte(b2 & 255);
            this.f7351c.writeInt(i & Integer.MAX_VALUE);
        } else {
            throw Http2.m6843a("reserved bit set: %s", Integer.valueOf(i));
        }
    }

    public synchronized void close() throws IOException {
        this.f7355g = true;
        this.f7351c.close();
    }

    /* renamed from: a */
    private static void m6915a(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    /* renamed from: b */
    private void m6916b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f7354f, j);
            long j2 = (long) min;
            j -= j2;
            mo30592a(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.f7351c.write(this.f7353e, j2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo30605b(boolean z, int i, List<Header> list) throws IOException {
        if (!this.f7355g) {
            this.f7350a.writeHeaders(list);
            long size = this.f7353e.size();
            int min = (int) Math.min((long) this.f7354f, size);
            long j = (long) min;
            int i2 = (size > j ? 1 : (size == j ? 0 : -1));
            byte b = i2 == 0 ? (byte) 4 : 0;
            if (z) {
                b = (byte) (b | 1);
            }
            mo30592a(i, min, (byte) 1, b);
            this.f7351c.write(this.f7353e, j);
            if (i2 > 0) {
                m6916b(i, size - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
