package net.lingala.zip4j.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.exception.ZipException;

public class RawIO {

    /* renamed from: a */
    private byte[] f6905a = new byte[2];

    /* renamed from: b */
    private byte[] f6906b = new byte[4];

    /* renamed from: c */
    private byte[] f6907c = new byte[8];

    public long readLongLittleEndian(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f6907c);
        return readLongLittleEndian(this.f6907c, 0);
    }

    public long readLongLittleEndian(RandomAccessFile randomAccessFile, int i) throws IOException {
        m6656a(this.f6907c);
        randomAccessFile.readFully(this.f6907c, 0, i);
        return readLongLittleEndian(this.f6907c, 0);
    }

    public long readLongLittleEndian(InputStream inputStream) throws IOException {
        byte[] bArr = this.f6907c;
        m6655a(inputStream, bArr, bArr.length);
        return readLongLittleEndian(this.f6907c, 0);
    }

    public long readLongLittleEndian(InputStream inputStream, int i) throws IOException {
        m6656a(this.f6907c);
        m6655a(inputStream, this.f6907c, i);
        return readLongLittleEndian(this.f6907c, 0);
    }

    public long readLongLittleEndian(byte[] bArr, int i) {
        if (bArr.length - i < 8) {
            m6656a(this.f6907c);
        }
        System.arraycopy(bArr, i, this.f6907c, 0, bArr.length < 8 ? bArr.length - i : 8);
        byte[] bArr2 = this.f6907c;
        return ((((((((((((((0 | ((long) (bArr2[7] & 255))) << 8) | ((long) (bArr2[6] & 255))) << 8) | ((long) (bArr2[5] & 255))) << 8) | ((long) (bArr2[4] & 255))) << 8) | ((long) (bArr2[3] & 255))) << 8) | ((long) (bArr2[2] & 255))) << 8) | ((long) (bArr2[1] & 255))) << 8) | ((long) (bArr2[0] & 255));
    }

    public int readIntLittleEndian(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f6906b);
        return readIntLittleEndian(this.f6906b);
    }

    public int readIntLittleEndian(InputStream inputStream) throws IOException {
        m6655a(inputStream, this.f6906b, 4);
        return readIntLittleEndian(this.f6906b);
    }

    public int readIntLittleEndian(byte[] bArr) {
        return readIntLittleEndian(bArr, 0);
    }

    public int readIntLittleEndian(byte[] bArr, int i) {
        return ((((bArr[i + 3] & 255) << 8) | (bArr[i + 2] & 255)) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    public int readShortLittleEndian(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f6905a);
        return readShortLittleEndian(this.f6905a, 0);
    }

    public int readShortLittleEndian(InputStream inputStream) throws IOException {
        byte[] bArr = this.f6905a;
        m6655a(inputStream, bArr, bArr.length);
        return readShortLittleEndian(this.f6905a, 0);
    }

    public int readShortLittleEndian(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    public void writeShortLittleEndian(OutputStream outputStream, int i) throws IOException {
        writeShortLittleEndian(this.f6905a, 0, i);
        outputStream.write(this.f6905a);
    }

    public void writeShortLittleEndian(byte[] bArr, int i, int i2) {
        bArr[i + 1] = (byte) (i2 >>> 8);
        bArr[i] = (byte) (i2 & 255);
    }

    public void writeIntLittleEndian(OutputStream outputStream, int i) throws IOException {
        writeIntLittleEndian(this.f6906b, 0, i);
        outputStream.write(this.f6906b);
    }

    public void writeIntLittleEndian(byte[] bArr, int i, int i2) {
        bArr[i + 3] = (byte) (i2 >>> 24);
        bArr[i + 2] = (byte) (i2 >>> 16);
        bArr[i + 1] = (byte) (i2 >>> 8);
        bArr[i] = (byte) (i2 & 255);
    }

    public void writeLongLittleEndian(OutputStream outputStream, long j) throws IOException {
        writeLongLittleEndian(this.f6907c, 0, j);
        outputStream.write(this.f6907c);
    }

    public void writeLongLittleEndian(byte[] bArr, int i, long j) {
        bArr[i + 7] = (byte) ((int) (j >>> 56));
        bArr[i + 6] = (byte) ((int) (j >>> 48));
        bArr[i + 5] = (byte) ((int) (j >>> 40));
        bArr[i + 4] = (byte) ((int) (j >>> 32));
        bArr[i + 3] = (byte) ((int) (j >>> 24));
        bArr[i + 2] = (byte) ((int) (j >>> 16));
        bArr[i + 1] = (byte) ((int) (j >>> 8));
        bArr[i] = (byte) ((int) (j & 255));
    }

    /* renamed from: a */
    private void m6655a(InputStream inputStream, byte[] bArr, int i) throws IOException {
        if (Zip4jUtil.readFully(inputStream, bArr, 0, i) != i) {
            throw new ZipException("Could not fill buffer");
        }
    }

    /* renamed from: a */
    private void m6656a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = 0;
        }
    }
}
