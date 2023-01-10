package net.lingala.zip4j.p070io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* renamed from: net.lingala.zip4j.io.inputstream.c */
/* compiled from: DecompressedInputStream */
abstract class C2953c extends InputStream {

    /* renamed from: a */
    private C2952b f6727a;
    protected byte[] oneByteBuffer = new byte[1];

    public void pushBackInputStreamIfNecessary(PushbackInputStream pushbackInputStream) throws IOException {
    }

    public C2953c(C2952b bVar) {
        this.f6727a = bVar;
    }

    public int read() throws IOException {
        if (read(this.oneByteBuffer) == -1) {
            return -1;
        }
        return this.oneByteBuffer[0];
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f6727a.read(bArr, i, i2);
    }

    public void close() throws IOException {
        this.f6727a.close();
    }

    public void endOfEntryReached(InputStream inputStream) throws IOException {
        this.f6727a.mo29398a(inputStream);
    }

    /* access modifiers changed from: protected */
    public byte[] getLastReadRawDataCache() {
        return this.f6727a.mo29404a();
    }
}
