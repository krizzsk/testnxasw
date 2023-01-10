package net.lingala.zip4j.p070io.outputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.RawIO;

/* renamed from: net.lingala.zip4j.io.outputstream.SplitOutputStream */
public class SplitOutputStream extends OutputStream implements OutputStreamWithSplitZipSupport {

    /* renamed from: a */
    private RandomAccessFile f6735a;

    /* renamed from: b */
    private long f6736b;

    /* renamed from: c */
    private File f6737c;

    /* renamed from: d */
    private int f6738d;

    /* renamed from: e */
    private long f6739e;

    /* renamed from: f */
    private RawIO f6740f;

    public SplitOutputStream(File file) throws FileNotFoundException, ZipException {
        this(file, -1);
    }

    public SplitOutputStream(File file, long j) throws FileNotFoundException, ZipException {
        this.f6740f = new RawIO();
        if (j < 0 || j >= 65536) {
            this.f6735a = new RandomAccessFile(file, RandomAccessFileMode.WRITE.getValue());
            this.f6736b = j;
            this.f6737c = file;
            this.f6738d = 0;
            this.f6739e = 0;
            return;
        }
        throw new ZipException("split length less than minimum allowed split length of 65536 Bytes");
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0) {
            long j = this.f6736b;
            if (j == -1) {
                this.f6735a.write(bArr, i, i2);
                this.f6739e += (long) i2;
                return;
            }
            long j2 = this.f6739e;
            if (j2 >= j) {
                m6554a();
                this.f6735a.write(bArr, i, i2);
                this.f6739e = (long) i2;
                return;
            }
            long j3 = (long) i2;
            if (j2 + j3 <= j) {
                this.f6735a.write(bArr, i, i2);
                this.f6739e += j3;
            } else if (m6556a(bArr)) {
                m6554a();
                this.f6735a.write(bArr, i, i2);
                this.f6739e = j3;
            } else {
                this.f6735a.write(bArr, i, (int) (this.f6736b - this.f6739e));
                m6554a();
                RandomAccessFile randomAccessFile = this.f6735a;
                long j4 = this.f6736b;
                long j5 = this.f6739e;
                randomAccessFile.write(bArr, i + ((int) (j4 - j5)), (int) (j3 - (j4 - j5)));
                this.f6739e = j3 - (this.f6736b - this.f6739e);
            }
        }
    }

    /* renamed from: a */
    private void m6554a() throws IOException {
        String str;
        String zipFileNameWithoutExtension = FileUtils.getZipFileNameWithoutExtension(this.f6737c.getName());
        String absolutePath = this.f6737c.getAbsolutePath();
        if (this.f6737c.getParent() == null) {
            str = "";
        } else {
            str = this.f6737c.getParent() + System.getProperty("file.separator");
        }
        String str2 = ".z0" + (this.f6738d + 1);
        if (this.f6738d >= 9) {
            str2 = ".z" + (this.f6738d + 1);
        }
        File file = new File(str + zipFileNameWithoutExtension + str2);
        this.f6735a.close();
        if (file.exists()) {
            throw new IOException("split file: " + file.getName() + " already exists in the current directory, cannot rename this file");
        } else if (this.f6737c.renameTo(file)) {
            this.f6737c = new File(absolutePath);
            this.f6735a = new RandomAccessFile(this.f6737c, RandomAccessFileMode.WRITE.getValue());
            this.f6738d++;
        } else {
            throw new IOException("cannot rename newly created split file");
        }
    }

    /* renamed from: a */
    private boolean m6556a(byte[] bArr) {
        int readIntLittleEndian = this.f6740f.readIntLittleEndian(bArr);
        for (HeaderSignature headerSignature : HeaderSignature.values()) {
            if (headerSignature != HeaderSignature.SPLIT_ZIP && headerSignature.getValue() == ((long) readIntLittleEndian)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBufferSizeAndStartNextSplitFile(int i) throws ZipException {
        if (i < 0) {
            throw new ZipException("negative buffersize for checkBufferSizeAndStartNextSplitFile");
        } else if (m6555a(i)) {
            return false;
        } else {
            try {
                m6554a();
                this.f6739e = 0;
                return true;
            } catch (IOException e) {
                throw new ZipException((Exception) e);
            }
        }
    }

    /* renamed from: a */
    private boolean m6555a(int i) {
        long j = this.f6736b;
        if (j < 65536 || this.f6739e + ((long) i) <= j) {
            return true;
        }
        return false;
    }

    public void seek(long j) throws IOException {
        this.f6735a.seek(j);
    }

    public int skipBytes(int i) throws IOException {
        return this.f6735a.skipBytes(i);
    }

    public void close() throws IOException {
        this.f6735a.close();
    }

    public long getFilePointer() throws IOException {
        return this.f6735a.getFilePointer();
    }

    public boolean isSplitZipFile() {
        return this.f6736b != -1;
    }

    public long getSplitLength() {
        return this.f6736b;
    }

    public int getCurrentSplitFileCounter() {
        return this.f6738d;
    }
}
