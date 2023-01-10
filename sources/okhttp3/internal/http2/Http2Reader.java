package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UShort;
import okhttp3.internal.C3000Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Http2Reader implements Closeable {

    /* renamed from: a */
    static final Logger f7317a = Logger.getLogger(Http2.class.getName());

    /* renamed from: b */
    final Hpack.Reader f7318b;

    /* renamed from: c */
    private final BufferedSource f7319c;

    /* renamed from: d */
    private final ContinuationSource f7320d;

    /* renamed from: e */
    private final boolean f7321e;

    interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.f7319c = bufferedSource;
        this.f7321e = z;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.f7320d = continuationSource;
        this.f7318b = new Hpack.Reader(4096, continuationSource);
    }

    /* renamed from: a */
    public void mo30543a(Handler handler) throws IOException {
        if (!this.f7321e) {
            ByteString readByteString = this.f7319c.readByteString((long) Http2.f7256a.size());
            if (f7317a.isLoggable(Level.FINE)) {
                f7317a.fine(C3000Util.format("<< CONNECTION %s", readByteString.hex()));
            }
            if (!Http2.f7256a.equals(readByteString)) {
                throw Http2.m6846b("Expected a connection header but was %s", readByteString.utf8());
            }
        } else if (!mo30544a(true, handler)) {
            throw Http2.m6846b("Required SETTINGS preface not received", new Object[0]);
        }
    }

    /* renamed from: a */
    public boolean mo30544a(boolean z, Handler handler) throws IOException {
        try {
            this.f7319c.require(9);
            int a = m6872a(this.f7319c);
            if (a < 0 || a > 16384) {
                throw Http2.m6846b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
            }
            byte readByte = (byte) (this.f7319c.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.f7319c.readByte() & 255);
                int readInt = this.f7319c.readInt() & Integer.MAX_VALUE;
                if (f7317a.isLoggable(Level.FINE)) {
                    f7317a.fine(Http2.m6845a(true, readInt, a, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        m6876b(handler, a, readByte2, readInt);
                        break;
                    case 1:
                        m6875a(handler, a, readByte2, readInt);
                        break;
                    case 2:
                        m6877c(handler, a, readByte2, readInt);
                        break;
                    case 3:
                        m6878d(handler, a, readByte2, readInt);
                        break;
                    case 4:
                        m6879e(handler, a, readByte2, readInt);
                        break;
                    case 5:
                        m6880f(handler, a, readByte2, readInt);
                        break;
                    case 6:
                        m6881g(handler, a, readByte2, readInt);
                        break;
                    case 7:
                        m6882h(handler, a, readByte2, readInt);
                        break;
                    case 8:
                        m6883i(handler, a, readByte2, readInt);
                        break;
                    default:
                        this.f7319c.skip((long) a);
                        break;
                }
                return true;
            }
            throw Http2.m6846b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m6875a(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.f7319c.readByte() & 255);
            }
            if ((b & 32) != 0) {
                m6874a(handler, i2);
                i -= 5;
            }
            handler.headers(z, i2, -1, m6873a(m6871a(i, b, s), s, b, i2));
            return;
        }
        throw Http2.m6846b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    /* renamed from: a */
    private List<Header> m6873a(int i, short s, byte b, int i2) throws IOException {
        ContinuationSource continuationSource = this.f7320d;
        continuationSource.left = i;
        continuationSource.length = i;
        this.f7320d.padding = s;
        this.f7320d.flags = b;
        this.f7320d.streamId = i2;
        this.f7318b.readHeaders();
        return this.f7318b.getAndResetHeaderList();
    }

    /* renamed from: b */
    private void m6876b(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = (b & 1) != 0;
            if ((b & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b & 8) != 0) {
                    s = (short) (this.f7319c.readByte() & 255);
                }
                handler.data(z2, i2, this.f7319c, m6871a(i, b, s));
                this.f7319c.skip((long) s);
                return;
            }
            throw Http2.m6846b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw Http2.m6846b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    /* renamed from: c */
    private void m6877c(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw Http2.m6846b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        } else if (i2 != 0) {
            m6874a(handler, i2);
        } else {
            throw Http2.m6846b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    /* renamed from: a */
    private void m6874a(Handler handler, int i) throws IOException {
        int readInt = this.f7319c.readInt();
        handler.priority(i, readInt & Integer.MAX_VALUE, (this.f7319c.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    /* renamed from: d */
    private void m6878d(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.m6846b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        } else if (i2 != 0) {
            int readInt = this.f7319c.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 != null) {
                handler.rstStream(i2, fromHttp2);
            } else {
                throw Http2.m6846b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            }
        } else {
            throw Http2.m6846b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    /* renamed from: e */
    private void m6879e(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw Http2.m6846b("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b & 1) != 0) {
            if (i == 0) {
                handler.ackSettings();
                return;
            }
            throw Http2.m6846b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i % 6 == 0) {
            Settings settings = new Settings();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short readShort = this.f7319c.readShort() & UShort.MAX_VALUE;
                int readInt = this.f7319c.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort == 4) {
                        readShort = 7;
                        if (readInt < 0) {
                            throw Http2.m6846b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                        throw Http2.m6846b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    throw Http2.m6846b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                settings.mo30578a(readShort, readInt);
            }
            handler.settings(false, settings);
        } else {
            throw Http2.m6846b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
    }

    /* renamed from: f */
    private void m6880f(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            if ((b & 8) != 0) {
                s = (short) (this.f7319c.readByte() & 255);
            }
            handler.pushPromise(i2, this.f7319c.readInt() & Integer.MAX_VALUE, m6873a(m6871a(i - 4, b, s), s, b, i2));
            return;
        }
        throw Http2.m6846b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    /* renamed from: g */
    private void m6881g(Handler handler, int i, byte b, int i2) throws IOException {
        boolean z = false;
        if (i != 8) {
            throw Http2.m6846b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int readInt = this.f7319c.readInt();
            int readInt2 = this.f7319c.readInt();
            if ((b & 1) != 0) {
                z = true;
            }
            handler.ping(z, readInt, readInt2);
        } else {
            throw Http2.m6846b("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    /* renamed from: h */
    private void m6882h(Handler handler, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw Http2.m6846b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int readInt = this.f7319c.readInt();
            int readInt2 = this.f7319c.readInt();
            int i3 = i - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i3 > 0) {
                    byteString = this.f7319c.readByteString((long) i3);
                }
                handler.goAway(readInt, fromHttp2, byteString);
                return;
            }
            throw Http2.m6846b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        } else {
            throw Http2.m6846b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    /* renamed from: i */
    private void m6883i(Handler handler, int i, byte b, int i2) throws IOException {
        if (i == 4) {
            long readInt = ((long) this.f7319c.readInt()) & 2147483647L;
            if (readInt != 0) {
                handler.windowUpdate(i2, readInt);
            } else {
                throw Http2.m6846b("windowSizeIncrement was 0", Long.valueOf(readInt));
            }
        } else {
            throw Http2.m6846b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
    }

    public void close() throws IOException {
        this.f7319c.close();
    }

    static final class ContinuationSource implements Source {
        byte flags;
        int left;
        int length;
        short padding;
        private final BufferedSource source;
        int streamId;

        public void close() throws IOException {
        }

        ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        public long read(Buffer buffer, long j) throws IOException {
            while (true) {
                int i = this.left;
                if (i == 0) {
                    this.source.skip((long) this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(buffer, Math.min(j, (long) i));
                    if (read == -1) {
                        return -1;
                    }
                    this.left = (int) (((long) this.left) - read);
                    return read;
                }
            }
        }

        public Timeout timeout() {
            return this.source.timeout();
        }

        private void readContinuationHeader() throws IOException {
            int i = this.streamId;
            int a = Http2Reader.m6872a(this.source);
            this.left = a;
            this.length = a;
            byte readByte = (byte) (this.source.readByte() & 255);
            this.flags = (byte) (this.source.readByte() & 255);
            if (Http2Reader.f7317a.isLoggable(Level.FINE)) {
                Http2Reader.f7317a.fine(Http2.m6845a(true, this.streamId, this.length, readByte, this.flags));
            }
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = readInt;
            if (readByte != 9) {
                throw Http2.m6846b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (readInt != i) {
                throw Http2.m6846b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    static int m6872a(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    /* renamed from: a */
    static int m6871a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw Http2.m6846b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
