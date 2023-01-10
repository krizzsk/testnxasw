package net.lingala.zip4j.p070io.inputstream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.util.FileUtils;

/* renamed from: net.lingala.zip4j.io.inputstream.NumberedSplitRandomAccessFile */
public class NumberedSplitRandomAccessFile extends RandomAccessFile {

    /* renamed from: a */
    private long f6694a;

    /* renamed from: b */
    private File[] f6695b;

    /* renamed from: c */
    private RandomAccessFile f6696c;

    /* renamed from: d */
    private byte[] f6697d;

    /* renamed from: e */
    private int f6698e;

    /* renamed from: f */
    private String f6699f;

    public NumberedSplitRandomAccessFile(String str, String str2) throws IOException {
        this(new File(str), str2);
    }

    public NumberedSplitRandomAccessFile(File file, String str) throws IOException {
        this(file, str, FileUtils.getAllSortedNumberedSplitFiles(file));
    }

    public NumberedSplitRandomAccessFile(File file, String str, File[] fileArr) throws IOException {
        super(file, str);
        this.f6697d = new byte[1];
        this.f6698e = 0;
        super.close();
        if (!RandomAccessFileMode.WRITE.getValue().equals(str)) {
            m6513a(fileArr);
            this.f6696c = new RandomAccessFile(file, str);
            this.f6695b = fileArr;
            this.f6694a = file.length();
            this.f6699f = str;
            return;
        }
        throw new IllegalArgumentException("write mode is not allowed for NumberedSplitRandomAccessFile");
    }

    public int read() throws IOException {
        if (read(this.f6697d) == -1) {
            return -1;
        }
        return this.f6697d[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f6696c.read(bArr, i, i2);
        if (read != -1) {
            return read;
        }
        int i3 = this.f6698e;
        if (i3 == this.f6695b.length - 1) {
            return -1;
        }
        m6512a(i3 + 1);
        return read(bArr, i, i2);
    }

    public void write(int i) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void seek(long j) throws IOException {
        int i = (int) (j / this.f6694a);
        if (i != this.f6698e) {
            m6512a(i);
        }
        this.f6696c.seek(j - (((long) i) * this.f6694a));
    }

    public long getFilePointer() throws IOException {
        return this.f6696c.getFilePointer();
    }

    public long length() throws IOException {
        return this.f6696c.length();
    }

    public void seekInCurrentPart(long j) throws IOException {
        this.f6696c.seek(j);
    }

    public void openLastSplitFileForReading() throws IOException {
        m6512a(this.f6695b.length - 1);
    }

    /* renamed from: a */
    private void m6512a(int i) throws IOException {
        if (this.f6698e != i) {
            if (i <= this.f6695b.length - 1) {
                RandomAccessFile randomAccessFile = this.f6696c;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.f6696c = new RandomAccessFile(this.f6695b[i], this.f6699f);
                this.f6698e = i;
                return;
            }
            throw new IOException("split counter greater than number of split files");
        }
    }

    /* renamed from: a */
    private void m6513a(File[] fileArr) throws IOException {
        int length = fileArr.length;
        int i = 1;
        int i2 = 0;
        while (i2 < length) {
            String fileExtension = FileUtils.getFileExtension(fileArr[i2]);
            try {
                if (i == Integer.parseInt(fileExtension)) {
                    i++;
                    i2++;
                } else {
                    throw new IOException("Split file number " + i + " does not exist");
                }
            } catch (NumberFormatException unused) {
                throw new IOException("Split file extension not in expected format. Found: " + fileExtension + " expected of format: .001, .002, etc");
            }
        }
    }
}
