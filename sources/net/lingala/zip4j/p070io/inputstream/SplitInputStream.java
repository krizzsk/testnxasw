package net.lingala.zip4j.p070io.inputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;

/* renamed from: net.lingala.zip4j.io.inputstream.SplitInputStream */
public abstract class SplitInputStream extends InputStream {

    /* renamed from: a */
    private boolean f6700a;

    /* renamed from: b */
    private int f6701b = 0;

    /* renamed from: c */
    private byte[] f6702c = new byte[1];
    protected RandomAccessFile randomAccessFile;
    protected File zipFile;

    /* access modifiers changed from: protected */
    public abstract File getNextSplitFile(int i) throws IOException;

    public SplitInputStream(File file, boolean z, int i) throws FileNotFoundException {
        this.randomAccessFile = new RandomAccessFile(file, RandomAccessFileMode.READ.getValue());
        this.zipFile = file;
        this.f6700a = z;
        if (z) {
            this.f6701b = i;
        }
    }

    public int read() throws IOException {
        if (read(this.f6702c) == -1) {
            return -1;
        }
        return this.f6702c[0];
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.randomAccessFile.read(bArr, i, i2);
        if ((read == i2 && read != -1) || !this.f6700a) {
            return read;
        }
        openRandomAccessFileForIndex(this.f6701b + 1);
        this.f6701b++;
        if (read < 0) {
            read = 0;
        }
        int read2 = this.randomAccessFile.read(bArr, read, i2 - read);
        return read2 > 0 ? read + read2 : read;
    }

    public void prepareExtractionForFileHeader(FileHeader fileHeader) throws IOException {
        if (this.f6700a && this.f6701b != fileHeader.getDiskNumberStart()) {
            openRandomAccessFileForIndex(fileHeader.getDiskNumberStart());
            this.f6701b = fileHeader.getDiskNumberStart();
        }
        this.randomAccessFile.seek(fileHeader.getOffsetLocalHeader());
    }

    /* access modifiers changed from: protected */
    public void openRandomAccessFileForIndex(int i) throws IOException {
        File nextSplitFile = getNextSplitFile(i);
        if (nextSplitFile.exists()) {
            this.randomAccessFile.close();
            this.randomAccessFile = new RandomAccessFile(nextSplitFile, RandomAccessFileMode.READ.getValue());
            return;
        }
        throw new FileNotFoundException("zip split file does not exist: " + nextSplitFile);
    }

    public void close() throws IOException {
        RandomAccessFile randomAccessFile2 = this.randomAccessFile;
        if (randomAccessFile2 != null) {
            randomAccessFile2.close();
        }
    }
}
