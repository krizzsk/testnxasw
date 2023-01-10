package net.lingala.zip4j.p070io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.exception.ZipException;

/* renamed from: net.lingala.zip4j.io.outputstream.CountingOutputStream */
public class CountingOutputStream extends OutputStream implements OutputStreamWithSplitZipSupport {

    /* renamed from: a */
    private OutputStream f6733a;

    /* renamed from: b */
    private long f6734b = 0;

    public CountingOutputStream(OutputStream outputStream) {
        this.f6733a = outputStream;
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f6733a.write(bArr, i, i2);
        this.f6734b += (long) i2;
    }

    public int getCurrentSplitFileCounter() {
        if (isSplitZipFile()) {
            return ((SplitOutputStream) this.f6733a).getCurrentSplitFileCounter();
        }
        return 0;
    }

    public long getOffsetForNextEntry() throws IOException {
        OutputStream outputStream = this.f6733a;
        if (outputStream instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream).getFilePointer();
        }
        return this.f6734b;
    }

    public long getSplitLength() {
        if (isSplitZipFile()) {
            return ((SplitOutputStream) this.f6733a).getSplitLength();
        }
        return 0;
    }

    public boolean isSplitZipFile() {
        OutputStream outputStream = this.f6733a;
        return (outputStream instanceof SplitOutputStream) && ((SplitOutputStream) outputStream).isSplitZipFile();
    }

    public long getNumberOfBytesWritten() throws IOException {
        OutputStream outputStream = this.f6733a;
        if (outputStream instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream).getFilePointer();
        }
        return this.f6734b;
    }

    public boolean checkBuffSizeAndStartNextSplitFile(int i) throws ZipException {
        if (!isSplitZipFile()) {
            return false;
        }
        return ((SplitOutputStream) this.f6733a).checkBufferSizeAndStartNextSplitFile(i);
    }

    public long getFilePointer() throws IOException {
        OutputStream outputStream = this.f6733a;
        if (outputStream instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream).getFilePointer();
        }
        return this.f6734b;
    }

    public void close() throws IOException {
        this.f6733a.close();
    }
}
