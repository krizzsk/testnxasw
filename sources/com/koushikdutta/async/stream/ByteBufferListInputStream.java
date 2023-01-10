package com.koushikdutta.async.stream;

import com.koushikdutta.async.ByteBufferList;
import java.io.IOException;
import java.io.InputStream;

public class ByteBufferListInputStream extends InputStream {

    /* renamed from: a */
    ByteBufferList f58282a;

    public ByteBufferListInputStream(ByteBufferList byteBufferList) {
        this.f58282a = byteBufferList;
    }

    public int read() throws IOException {
        if (this.f58282a.remaining() <= 0) {
            return -1;
        }
        return this.f58282a.get() & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f58282a.remaining() <= 0) {
            return -1;
        }
        int min = Math.min(i2, this.f58282a.remaining());
        this.f58282a.get(bArr, i, min);
        return min;
    }
}
