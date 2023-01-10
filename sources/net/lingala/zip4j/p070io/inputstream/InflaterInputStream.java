package net.lingala.zip4j.p070io.inputstream;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: net.lingala.zip4j.io.inputstream.InflaterInputStream */
public class InflaterInputStream extends C2953c {

    /* renamed from: a */
    private Inflater f6690a = new Inflater(true);

    /* renamed from: b */
    private byte[] f6691b;

    /* renamed from: c */
    private byte[] f6692c = new byte[1];

    /* renamed from: d */
    private int f6693d;

    public InflaterInputStream(C2952b bVar, int i) {
        super(bVar);
        this.f6691b = new byte[i];
    }

    public int read() throws IOException {
        if (read(this.f6692c) == -1) {
            return -1;
        }
        return this.f6692c[0];
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        while (true) {
            try {
                int inflate = this.f6690a.inflate(bArr, i, i2);
                if (inflate != 0) {
                    return inflate;
                }
                if (this.f6690a.finished()) {
                    return -1;
                }
                if (this.f6690a.needsDictionary()) {
                    return -1;
                }
                if (this.f6690a.needsInput()) {
                    m6510a();
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
    }

    public void endOfEntryReached(InputStream inputStream) throws IOException {
        Inflater inflater = this.f6690a;
        if (inflater != null) {
            inflater.end();
            this.f6690a = null;
        }
        super.endOfEntryReached(inputStream);
    }

    public void pushBackInputStreamIfNecessary(PushbackInputStream pushbackInputStream) throws IOException {
        int remaining = this.f6690a.getRemaining();
        if (remaining > 0) {
            pushbackInputStream.unread(getLastReadRawDataCache(), this.f6693d - remaining, remaining);
        }
    }

    public void close() throws IOException {
        Inflater inflater = this.f6690a;
        if (inflater != null) {
            inflater.end();
        }
        super.close();
    }

    /* renamed from: a */
    private void m6510a() throws IOException {
        byte[] bArr = this.f6691b;
        int read = super.read(bArr, 0, bArr.length);
        this.f6693d = read;
        if (read != -1) {
            this.f6690a.setInput(this.f6691b, 0, read);
            return;
        }
        throw new EOFException("Unexpected end of input stream");
    }
}
