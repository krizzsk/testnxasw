package didihttp.internal.cache2;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import okio.Buffer;

/* renamed from: didihttp.internal.cache2.a */
/* compiled from: FileOperator */
final class C21759a {

    /* renamed from: a */
    private static final int f59410a = 8192;

    /* renamed from: b */
    private final byte[] f59411b;

    /* renamed from: c */
    private final ByteBuffer f59412c;

    /* renamed from: d */
    private final FileChannel f59413d;

    public C21759a(FileChannel fileChannel) {
        byte[] bArr = new byte[8192];
        this.f59411b = bArr;
        this.f59412c = ByteBuffer.wrap(bArr);
        this.f59413d = fileChannel;
    }

    /* renamed from: a */
    public void mo179805a(long j, Buffer buffer, long j2) throws IOException {
        if (j2 < 0 || j2 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            try {
                int min = (int) Math.min(8192, j2);
                buffer.read(this.f59411b, 0, min);
                this.f59412c.limit(min);
                do {
                    j += (long) this.f59413d.write(this.f59412c, j);
                } while (this.f59412c.hasRemaining());
                j2 -= (long) min;
            } finally {
                this.f59412c.clear();
            }
        }
    }

    /* renamed from: b */
    public void mo179806b(long j, Buffer buffer, long j2) throws IOException {
        if (j2 >= 0) {
            while (j2 > 0) {
                try {
                    this.f59412c.limit((int) Math.min(8192, j2));
                    if (this.f59413d.read(this.f59412c, j) != -1) {
                        int position = this.f59412c.position();
                        buffer.write(this.f59411b, 0, position);
                        long j3 = (long) position;
                        j += j3;
                        j2 -= j3;
                    } else {
                        throw new EOFException();
                    }
                } finally {
                    this.f59412c.clear();
                }
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
